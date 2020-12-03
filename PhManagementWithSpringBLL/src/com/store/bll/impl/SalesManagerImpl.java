/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.SalesManager;
import com.store.bll.transformers.BillCodeStoreTransformer;
import com.store.bll.transformers.DeliveryBillsTransformer;
import com.store.bll.transformers.DrugsTransformer;
import com.store.bll.transformers.SalesBillsTransformer;
import com.store.common.beans.BillCodeStoreBean;
import com.store.common.beans.DeliveryBillsBean;
import com.store.common.beans.DrugsBean;
import com.store.common.beans.SalesBillsBean;
import com.store.dal.entities.DeliveryBills;
import com.store.dal.entities.Drugs;
import com.store.dal.entities.SalesBills;
import com.store.dal.repos.BillCodeStoreDAO;
import com.store.dal.repos.DeliveryBillsDAO;
import com.store.dal.repos.DrugsDAO;
import com.store.dal.repos.SalesBillsDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "salesManagerImpl")
public class SalesManagerImpl implements SalesManager {

    @Autowired(required = true)
    private DeliveryBillsDAO deliveryBillsDAO;
    @Autowired(required = true)
    private DeliveryBillsTransformer deliveryBillsTransformer;
    @Autowired(required = true)
    private DrugsDAO drugsDAO;
    @Autowired(required = true)
    private DrugsTransformer drugsTransformer;
    @Autowired(required = true)
    private SalesBillsDAO salesBillsDAO;
    @Autowired(required = true)
    private SalesBillsTransformer salesBillsTransformer;
    @Autowired(required = true)
    private BillCodeStoreTransformer billCosdeStoreTransformer;
    @Autowired(required = true)
    private BillCodeStoreDAO billCodeStoreDAO;

    @Transactional
    @Override
    public List<DeliveryBillsBean> listAllDelivery() {
        List<DeliveryBillsBean> find = null;
        List<DeliveryBills> findList = deliveryBillsDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (DeliveryBills drugs : findList) {

                find.add(deliveryBillsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;

    }

    @Transactional
    @Override
    public List<DeliveryBillsBean> listByCodeDelivery(int code) {
        List<DeliveryBillsBean> find = null;

        DeliveryBills findList = deliveryBillsDAO.findById(code);
        if (findList != null) {
            find = new ArrayList();
            find.add(deliveryBillsTransformer.transformEntityToBean(findList));
        }

        return find;
    }

    @Transactional
    @Override
    public SalesBillsBean AddBillSales(SalesBills salesBills) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional
    @Override
    public List<DrugsBean> findDrug(String name) {
        List<DrugsBean> list = new ArrayList<>();
        Drugs find = drugsDAO.findById(name);
        list.add(drugsTransformer.transformEntityToBean(find));
        if (find == null) {
            return null;
        } else {
            return list;
        }

    }

    @Transactional
    @Override
    public SalesBillsBean saveSaleBill(SalesBillsBean bean) {
        SalesBillsBean add = null;
        add = salesBillsTransformer.transformEntityToBean(salesBillsDAO.add(salesBillsTransformer.transformBeanToEntity(bean)));

        DrugsBean bean1 = new DrugsBean();
        if (add != null) {
            int[] quantity = {add.getQuantity1(), add.getQuantity2(), add.getQuantity3(), add.getQuantity4(), add.getQuantity5()};
            int i = 0;
            String[] names = {add.getDrug1(), add.getDrug2(), add.getDrug3(), add.getDrug4(), add.getDrug5()};

            for (String name : names) {
                if (name != null) {
                    Drugs find = drugsDAO.findById(name);
                    find.setQuantity(find.getQuantity() - quantity[i]);
                    drugsDAO.update(find);

                }
                i++;
            }

        }
        BillCodeStoreBean s = new BillCodeStoreBean();
        s.setCode(bean.getBillcode());

        billCodeStoreDAO.remove(billCosdeStoreTransformer.transformBeanToEntity(s));
        s.setCode(bean.getBillcode() + 1);
        billCodeStoreDAO.add(billCosdeStoreTransformer.transformBeanToEntity(s));

        return add;
    }

    @Transactional
    @Override
    public SalesBillsBean saveDeliveryBill(DeliveryBillsBean bean) {
        DeliveryBillsBean add = null;

        add = deliveryBillsTransformer.transformEntityToBean(deliveryBillsDAO.findById(bean.getBillcode()));

        if (add != null) {

            SalesBillsBean salesBillsBean = new SalesBillsBean();

            salesBillsBean.setBillcode(add.getBillcode());
            salesBillsBean.setBilldate(add.getBilldate());
            salesBillsBean.setDrug1(add.getDrug1());
            salesBillsBean.setDrug2(add.getDrug2());
            salesBillsBean.setDrug3(add.getDrug3());
            salesBillsBean.setDrug4(add.getDrug4());
            salesBillsBean.setDrug5(add.getDrug5());

            salesBillsBean.setDiscount1(add.getDiscount1());
            salesBillsBean.setDiscount2(add.getDiscount2());
            salesBillsBean.setDiscount3(add.getDiscount3());
            salesBillsBean.setDiscount4(add.getDiscount4());
            salesBillsBean.setDiscount5(add.getDiscount5());

            salesBillsBean.setNet1(add.getNet1());
            salesBillsBean.setNet2(add.getNet2());
            salesBillsBean.setNet3(add.getNet3());
            salesBillsBean.setNet4(add.getNet4());
            salesBillsBean.setNet5(add.getNet5());

            salesBillsBean.setProfit1(add.getProfit1());
            salesBillsBean.setProfit2(add.getProfit2());
            salesBillsBean.setProfit3(add.getProfit3());
            salesBillsBean.setProfit4(add.getProfit4());
            salesBillsBean.setProfit5(add.getProfit5());

            salesBillsBean.setQuantity1(add.getQuantity1());
            salesBillsBean.setQuantity2(add.getQuantity2());
            salesBillsBean.setQuantity3(add.getQuantity3());
            salesBillsBean.setQuantity4(add.getQuantity4());
            salesBillsBean.setQuantity5(add.getQuantity5());

            salesBillsBean.setTotal1(add.getTotal1());
            salesBillsBean.setTotal2(add.getTotal2());
            salesBillsBean.setTotal3(add.getTotal3());
            salesBillsBean.setTotal4(add.getTotal4());
            salesBillsBean.setTotal5(add.getTotal5());

            salesBillsBean.setUnitprice1(add.getUnitprice1());
            salesBillsBean.setUnitprice2(add.getUnitprice2());
            salesBillsBean.setUnitprice3(add.getUnitprice3());
            salesBillsBean.setUnitprice4(add.getUnitprice4());
            salesBillsBean.setUnitprice5(add.getUnitprice5());

            salesBillsBean.setTotalnet(add.getTotalnet());
            salesBillsBean.setTotalprofits(add.getTotalprofits());

            SalesBillsBean transformEntityToBean = salesBillsTransformer.transformEntityToBean(salesBillsDAO.add(salesBillsTransformer.transformBeanToEntity(salesBillsBean)));

            DrugsBean bean1 = new DrugsBean();
            if (transformEntityToBean != null) {
                int[] quantity = {add.getQuantity1(), add.getQuantity2(), add.getQuantity3(), add.getQuantity4(), add.getQuantity5()};
                int i = 0;
                String[] names = {add.getDrug1(), add.getDrug2(), add.getDrug3(), add.getDrug4(), add.getDrug5()};
                for (String name : names) {
                    if (name != null) {
                        Drugs find = drugsDAO.findById(name);
                        find.setQuantity(find.getQuantity() - quantity[i]);
                        drugsDAO.update(find);

                    }
                    i++;
                }

                // delete delivery
                DeliveryBillsBean deletedeliveryBill = deletedeliveryBill(bean);
                return transformEntityToBean;

            } 
            else
            {
                return null;
            }

        }
        else
        {
            return null;
        }

    }

    @Transactional
    @Override
    public DeliveryBillsBean deliveryBill(DeliveryBillsBean bean) {
        DeliveryBillsBean add = null;
        add = deliveryBillsTransformer.transformEntityToBean(deliveryBillsDAO.add(deliveryBillsTransformer.transformBeanToEntity(bean)));
        BillCodeStoreBean s = new BillCodeStoreBean();
        s.setCode(bean.getBillcode());

        billCodeStoreDAO.remove(billCosdeStoreTransformer.transformBeanToEntity(s));
        s.setCode(bean.getBillcode() + 1);
        billCodeStoreDAO.add(billCosdeStoreTransformer.transformBeanToEntity(s));

        return add;
    }

    @Transactional
    @Override
    public DeliveryBillsBean deletedeliveryBill(DeliveryBillsBean bean) {
        DeliveryBillsBean add = null;
        DeliveryBills findById = deliveryBillsDAO.findById(bean.getBillcode());
        deliveryBillsDAO.remove(findById);
        DeliveryBills findById1 = deliveryBillsDAO.findById(bean.getBillcode());
        if (findById1 != null) {
            return bean;
        } else {
            return null;
        }
    }

    public DeliveryBillsDAO getDeliveryBillsDAO() {
        return deliveryBillsDAO;
    }

    public void setDeliveryBillsDAO(DeliveryBillsDAO deliveryBillsDAO) {
        this.deliveryBillsDAO = deliveryBillsDAO;
    }

    public DeliveryBillsTransformer getDeliveryBillsTransformer() {
        return deliveryBillsTransformer;
    }

    public void setDeliveryBillsTransformer(DeliveryBillsTransformer deliveryBillsTransformer) {
        this.deliveryBillsTransformer = deliveryBillsTransformer;
    }

    public DrugsDAO getDrugsDAO() {
        return drugsDAO;
    }

    public void setDrugsDAO(DrugsDAO drugsDAO) {
        this.drugsDAO = drugsDAO;
    }

    public DrugsTransformer getDrugsTransformer() {
        return drugsTransformer;
    }

    public void setDrugsTransformer(DrugsTransformer drugsTransformer) {
        this.drugsTransformer = drugsTransformer;
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

    public BillCodeStoreTransformer getBillCosdeStoreTransformer() {
        return billCosdeStoreTransformer;
    }

    public void setBillCosdeStoreTransformer(BillCodeStoreTransformer billCosdeStoreTransformer) {
        this.billCosdeStoreTransformer = billCosdeStoreTransformer;
    }

    public BillCodeStoreDAO getBillCodeStoreDAO() {
        return billCodeStoreDAO;
    }

    public void setBillCodeStoreDAO(BillCodeStoreDAO billCodeStoreDAO) {
        this.billCodeStoreDAO = billCodeStoreDAO;
    }
}
