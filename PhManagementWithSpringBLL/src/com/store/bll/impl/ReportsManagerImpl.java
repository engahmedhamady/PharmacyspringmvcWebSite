/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.ReportsManager;
import com.store.bll.transformers.PurchasesBillsTransformer;
import com.store.bll.transformers.SalesBillsTransformer;
import com.store.common.beans.PurchasesBillsBean;
import com.store.common.beans.SalesBillsBean;
import com.store.dal.entities.PurchasesBills;
import com.store.dal.entities.SalesBills;
import com.store.dal.repos.PurchasesBillsDAO;
import com.store.dal.repos.SalesBillsDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component (value = "reportsManagerImpl")
public class ReportsManagerImpl implements ReportsManager {
@Autowired(required = true)
    private SalesBillsDAO salesBillsDAO;
@Autowired(required = true)
    private SalesBillsTransformer salesBillsTransformer;
@Autowired(required = true)
    private PurchasesBillsDAO purchasesBillsDAO;
@Autowired(required = true)
    private PurchasesBillsTransformer purchasesBillsTransformer;

    @Transactional
    @Override
    public List<SalesBillsBean> listAllSales() {
        List<SalesBillsBean> l = null;
        List<SalesBills> list = salesBillsDAO.findList();

        if (list != null) {
            l = new ArrayList<>();
            for (SalesBills d : list) {

                l.add(salesBillsTransformer.transformEntityToBean(d));
            }

        }

        return l;

    }

    @Transactional
    @Override
    public List<SalesBillsBean> findByCodeSales(int billCode) {
        List<SalesBillsBean> l = null;
        SalesBills findById = salesBillsDAO.findById(billCode);
        List<SalesBills> list = new ArrayList<>();
        list.add(findById);

        if (list != null) {
            l = new ArrayList<>();
            for (SalesBills d : list) {

                l.add(salesBillsTransformer.transformEntityToBean(d));
            }

        }
        return l;
    }

    @Transactional
    @Override
    public List<SalesBillsBean> findByDateSales(Date from, Date to) {
        List<SalesBillsBean> l = null;
        List<SalesBills> list = salesBillsDAO.findByDate(from, to);

        if (list != null) {
            l = new ArrayList<>();
            for (SalesBills d : list) {

                SalesBillsBean bean = new SalesBillsBean();
                bean.setBillcode(d.getBillCode());
                bean.setBilldate(d.getBillDate());
                bean.setTotalnet(d.getTotalnet());
                bean.setTotalprofits(d.getTotalProfits());

                l.add(bean);
            }

        }

        return l;
    }

    @Transactional
    @Override
    public List<SalesBillsBean> findByTotalSales(int from, int to) {
        List<SalesBillsBean> l = null;
        List<SalesBills> list = salesBillsDAO.findByTotal(from, to);
        if (list != null) {
            l = new ArrayList<>();
            for (SalesBills d : list) {
                SalesBillsBean bean = new SalesBillsBean();
                bean.setBillcode(d.getBillCode());
                bean.setBilldate(d.getBillDate());
                bean.setTotalnet(d.getTotalnet());
                bean.setTotalprofits(d.getTotalProfits());

                l.add(bean);
            }

        }

        return l;
    }

    @Transactional
    @Override
    public List<SalesBillsBean> findByProfitSales(int from, int to) {
        List<SalesBillsBean> l = null;
        List<SalesBills> list = salesBillsDAO.findByProfit(from, to);
        if (list != null) {
            l = new ArrayList<>();
            for (SalesBills d : list) {

                SalesBillsBean bean = new SalesBillsBean();
                bean.setBillcode(d.getBillCode());
                bean.setBilldate(d.getBillDate());
                bean.setTotalnet(d.getTotalnet());
                bean.setTotalprofits(d.getTotalProfits());

                l.add(bean);
            }

        }

        return l;
    }
//=====================================================================================

    @Transactional
    @Override
    public List<PurchasesBillsBean> listAllPurchases() {
        List<PurchasesBillsBean> l = null;
        
            List<PurchasesBills> list = purchasesBillsDAO.findList();

             if (list != null) {
                l = new ArrayList<>();
                for (PurchasesBills d : list) {

                    l.add(purchasesBillsTransformer.transformEntityToBean(d));
                }

            }
        return l;
    }

    @Transactional
    @Override
    public List<PurchasesBillsBean> findByCodePurchases(int billCode) {
        List<PurchasesBillsBean> l = null;
        PurchasesBills findById = purchasesBillsDAO.findById(billCode);
            List<PurchasesBills> list = null;
            if (findById != null) {
                list = new ArrayList<>();
                list.add(findById);
            }
   if (list != null) {
                l = new ArrayList<>();
                for (PurchasesBills d : list) {

                    l.add(purchasesBillsTransformer.transformEntityToBean(d));
                }

            }

           return l;
    }

    @Transactional
    @Override
    public List<PurchasesBillsBean> findByDatePurchases(Date from, Date to) {
        List<PurchasesBillsBean> l = null;
            List<PurchasesBills> list = purchasesBillsDAO.findByDate(from, to);

              if (list != null) {
                l = new ArrayList<>();
                for (PurchasesBills d : list) {

                    l.add(purchasesBillsTransformer.transformEntityToBean(d));
                }

            }

        
        return l;
    }

    @Transactional
    @Override
    public List<PurchasesBillsBean> findByTotalPurchases(int from, int to) {
        List<PurchasesBillsBean> l = null;
              List<PurchasesBills> list = purchasesBillsDAO.findByTotalPurchases(from, to);

              if (list != null) {
                l = new ArrayList<>();
                for (PurchasesBills d : list) {

                    l.add(purchasesBillsTransformer.transformEntityToBean(d));
                }

            }

        
        return l;
    }
//-------------------------------------------------------------------------------

    @Transactional
    @Override
    public int incom(Date from, Date to) {

        List<SalesBillsBean> findByDateSales = findByDateSales(from, to);
        if (findByDateSales != null && findByDateSales.size() > 0) {
            int total = 0;
            for (SalesBillsBean findByDateSale : findByDateSales) {
                total += findByDateSale.getTotalnet();
            }
            return total;

        } else {
            return 0;
        }
    }

    @Transactional
    @Override
    public int payment(Date from, Date to) {
        List<PurchasesBillsBean> findByDateSales = findByDatePurchases(from, to);
        if (findByDateSales != null && findByDateSales.size() > 0) {
            int total = 0;
            for (PurchasesBillsBean findByDateSale : findByDateSales) {
                total += findByDateSale.getTotal();
            }
            return total;

        } else {
            return 0;
        }

    }

    @Transactional
    @Override
    public int profits(Date from, Date to) {
        List<SalesBillsBean> findByDateSales = findByDateSales(from, to);
        if (findByDateSales != null && findByDateSales.size() > 0) {
            int total = 0;
            for (SalesBillsBean findByDateSale : findByDateSales) {
                total += findByDateSale.getTotalprofits();
            }
            return total;

        } else {
            return 0;
        }
    }

    public SalesBillsDAO getSalesBillsDAO() {
        return salesBillsDAO;
    }

    public void setSalesBillsDAO(SalesBillsDAO salesBillsDAO) {
        this.salesBillsDAO = salesBillsDAO;
    }

    public SalesBillsTransformer getSalesBillsTransformer() {
        return salesBillsTransformer;
    }

    public void setSalesBillsTransformer(SalesBillsTransformer salesBillsTransformer) {
        this.salesBillsTransformer = salesBillsTransformer;
    }

    public PurchasesBillsDAO getPurchasesBillsDAO() {
        return purchasesBillsDAO;
    }

    public void setPurchasesBillsDAO(PurchasesBillsDAO purchasesBillsDAO) {
        this.purchasesBillsDAO = purchasesBillsDAO;
    }

    public PurchasesBillsTransformer getPurchasesBillsTransformer() {
        return purchasesBillsTransformer;
    }

    public void setPurchasesBillsTransformer(PurchasesBillsTransformer purchasesBillsTransformer) {
        this.purchasesBillsTransformer = purchasesBillsTransformer;
    }

}
