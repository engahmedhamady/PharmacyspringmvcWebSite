/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.PurchasesManager;
import com.store.bll.transformers.BillCodeStoreTransformer;
import com.store.bll.transformers.CustomerTransformer;
import com.store.bll.transformers.DrugsTransformer;
import com.store.bll.transformers.LostDrugsTransformer;
import com.store.bll.transformers.PurchasesBillsTransformer;
import com.store.common.beans.BillCodeStoreBean;
import com.store.common.beans.CustomerBean;
import com.store.common.beans.DrugsBean;
import com.store.common.beans.LostDrugsBean;
import com.store.common.beans.PurchasesBillsBean;
import com.store.dal.entities.BillCodeStore;
import com.store.dal.entities.Customer;
import com.store.dal.entities.Drugs;
import com.store.dal.entities.LostDrugs;
import com.store.dal.repos.BillCodeStoreDAO;
import com.store.dal.repos.CustomerDAO;
import com.store.dal.repos.DrugsDAO;
import com.store.dal.repos.LostDrugsDAO;
import com.store.dal.repos.PurchasesBillsDAO;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "purchasesManagerImpl")
public class PurchasesManagerImpl implements PurchasesManager {

    @Autowired(required = true)
    private BillCodeStoreDAO billCodeStoreDAO;
    @Autowired(required = true)
    private BillCodeStoreTransformer billCodeStoreTransformer;
    @Autowired(required = true)
    private PurchasesBillsDAO purchasesBillsDAO;
    @Autowired(required = true)
    private PurchasesBillsTransformer purchasesBillsTransformer;
    @Autowired(required = true)
    private DrugsTransformer drugsTransformer;
    @Autowired(required = true)
    private DrugsDAO drugsDAO;
    @Autowired(required = true)
    private LostDrugsDAO lostDrugsDAO;
    @Autowired(required = true)
    private LostDrugsTransformer lostDrugsTransformer;
    @Autowired(required = true)
    private CustomerDAO customerDAO;
    @Autowired(required = true)
    private CustomerTransformer customerTransformer;

    public BillCodeStoreDAO getBillCodeStoreDAO() {
        return billCodeStoreDAO;
    }

    public void setBillCodeStoreDAO(BillCodeStoreDAO billCodeStoreDAO) {
        this.billCodeStoreDAO = billCodeStoreDAO;
    }

    public BillCodeStoreTransformer getBillCodeStoreTransformer() {
        return billCodeStoreTransformer;
    }

    public void setBillCodeStoreTransformer(BillCodeStoreTransformer billCodeStoreTransformer) {
        this.billCodeStoreTransformer = billCodeStoreTransformer;
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

    public DrugsTransformer getDrugsTransformer() {
        return drugsTransformer;
    }

    public void setDrugsTransformer(DrugsTransformer drugsTransformer) {
        this.drugsTransformer = drugsTransformer;
    }

    public DrugsDAO getDrugsDAO() {
        return drugsDAO;
    }

    public void setDrugsDAO(DrugsDAO drugsDAO) {
        this.drugsDAO = drugsDAO;
    }

    public LostDrugsDAO getLostDrugsDAO() {
        return lostDrugsDAO;
    }

    public void setLostDrugsDAO(LostDrugsDAO lostDrugsDAO) {
        this.lostDrugsDAO = lostDrugsDAO;
    }

    public LostDrugsTransformer getLostDrugsTransformer() {
        return lostDrugsTransformer;
    }

    public void setLostDrugsTransformer(LostDrugsTransformer lostDrugsTransformer) {
        this.lostDrugsTransformer = lostDrugsTransformer;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CustomerTransformer getCustomerTransformer() {
        return customerTransformer;
    }

    public void setCustomerTransformer(CustomerTransformer customerTransformer) {
        this.customerTransformer = customerTransformer;
    }

    @Transactional
    @Override
    public int createBill() {

        List<BillCodeStore> findList = billCodeStoreDAO.findList();
        List<BillCodeStoreBean> list = new ArrayList<>();
        for (BillCodeStore billCodeStore : findList) {
            list.add(billCodeStoreTransformer.transformEntityToBean(billCodeStore));
        }
        if (list.size() > 0) {

            return list.get(0).getCode();
        } else {
            return 0;
        }

    }
//c

    @Transactional
    @Override
    public PurchasesBillsBean saveBill(PurchasesBillsBean bean) {
        PurchasesBillsBean add = null;

        add = purchasesBillsTransformer.transformEntityToBean(purchasesBillsDAO.add(purchasesBillsTransformer.transformBeanToEntity(bean)));
         System.out.println(add.getDrugName());
        DrugsBean bean1 = new DrugsBean();
        if (add != null) {

            int profit = bean.getSellPrice() - bean.getPurchasePrice() - bean.getDiscount();
            bean1.setBarcode(bean.getBarCode());
            bean1.setName(bean.getDrugName());
            bean1.setType(bean.getDrugType());
            bean1.setPurchasingPrice(bean.getPurchasePrice());
            bean1.setDiscount(bean.getDiscount());
            bean1.setQuantity(bean.getQuantityDrug());
            bean1.setProfit(profit);
            bean1.setSellingPrice(bean.getSellPrice());
            bean1.setCompany(bean.getCompany());

            Drugs findById = drugsDAO.findById(bean.getDrugName());

            if (findById == null) {

                drugsDAO.add(drugsTransformer.transformBeanToEntity(bean1));

            } else {
                findById.setQuantity(findById.getQuantity() + bean1.getQuantity());
                drugsDAO.update(findById);
            }
            BillCodeStoreBean s = new BillCodeStoreBean();
            s.setCode(bean.getBillCode());
            billCodeStoreDAO.remove(billCodeStoreTransformer.transformBeanToEntity(s));
            s.setCode(bean.getBillCode() + 1);
            billCodeStoreDAO.add(billCodeStoreTransformer.transformBeanToEntity(s));
        }
        return add;

    }

    @Transactional
    @Override
    public LostDrugsBean addRequested(LostDrugsBean bean) {

        LostDrugs findById = lostDrugsDAO.findById(bean.getDrugname());
        if (findById == null) {
            LostDrugs add = lostDrugsDAO.add(lostDrugsTransformer.transformBeanToEntity(bean));

            return lostDrugsTransformer.transformEntityToBean(add);
        } else {

            findById.setQuantityDrug(bean.getQuantitydrug() + findById.getQuantityDrug());
            LostDrugsBean transformEntityToBean = lostDrugsTransformer.transformEntityToBean(lostDrugsDAO.update(findById));

            return transformEntityToBean;

        }

    }

    @Transactional
    @Override
    public List<LostDrugsBean> listAllRequested() {
        List<LostDrugsBean> find = null;

        List<LostDrugs> findList = lostDrugsDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (LostDrugs drugs : findList) {

                find.add(lostDrugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;

    }

    @Transactional
    @Override
    public List<LostDrugsBean> listByNameRequested(String name) {
        List<LostDrugsBean> find = null;

        List<LostDrugs> findList = lostDrugsDAO.findByName(name);
        if (findList != null) {
            find = new ArrayList();
            for (LostDrugs drugs : findList) {

                find.add(lostDrugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
    }

    @Transactional
    @Override
    public List<LostDrugsBean> listByTypeRequested(String type) {
        List<LostDrugsBean> find = null;

        List<LostDrugs> findList = lostDrugsDAO.findByType(type);
        if (findList != null) {
            find = new ArrayList();
            for (LostDrugs drugs : findList) {

                find.add(lostDrugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
    }

    @Transactional
    @Override
    public CustomerBean addCustomer(CustomerBean bean) {
        Customer find = null;
        find = customerDAO.add(customerTransformer.transformBeanToEntity(bean));

        return customerTransformer.transformEntityToBean(find);

    }

    @Transactional
    @Override
    public List<CustomerBean> listAllCustomer() {
        List<CustomerBean> find = null;
        List<Customer> findList = customerDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (Customer drugs : findList) {

                find.add(customerTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
    }

    @Transactional
    @Override
    public List<CustomerBean> listByNameCustomer(String name) {
        List<CustomerBean> find = null;

        List<Customer> findList = customerDAO.findByName(name);
        if (findList != null) {
            find = new ArrayList();
            for (Customer drugs : findList) {

                find.add(customerTransformer.transformEntityToBean(drugs));
            }
        }
        return find;
    }

    @Transactional
    @Override
    public CustomerBean deleteCustomer(CustomerBean bean) {
        Customer find = null;
        customerDAO.remove(customerTransformer.transformBeanToEntity(bean));
        return customerTransformer.transformEntityToBean(find);
    }

    @Transactional
    @Override
    public CustomerBean updateCustomer(CustomerBean bean) {
        Customer find = null;
        find = customerDAO.update(customerTransformer.transformBeanToEntity(bean));

        return customerTransformer.transformEntityToBean(find);

    }

    @Transactional
    @Override
    public LostDrugsBean updateDrugRequested(LostDrugsBean bean) {
        LostDrugs find = null;
        find = lostDrugsDAO.update(lostDrugsTransformer.transformBeanToEntity(bean));

        return lostDrugsTransformer.transformEntityToBean(find);
    }

    @Transactional
    @Override
    public DrugsBean deleteDrug(DrugsBean bean) {
        drugsDAO.remove(drugsTransformer.transformBeanToEntity(bean));
        Drugs findById = drugsDAO.findById(bean.getName());
        if (findById == null) {
            return null;
        } else {
            return bean;
        }
    }

    @Transactional
    @Override
    public LostDrugsBean deleteLostDrug(LostDrugsBean bean) {
        lostDrugsDAO.remove(lostDrugsTransformer.transformBeanToEntity(bean));
        LostDrugs findById = lostDrugsDAO.findById(bean.getDrugname());
        if (findById == null) {
            return bean;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public List<DrugsBean> listAllFounded() {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findList();
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
    }

    @Transactional
    @Override
    public List<DrugsBean> listByNamefounded(String name) {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findByName(name);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
    }

    @Transactional
    @Override
    public List<DrugsBean> listByTypefounded(String type) {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findByType(type);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
        }
        return find;
    }

    @Transactional
    @Override
    public List<DrugsBean> listByQuantityfounded(int from, int to) {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findByQuantity(from, to);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
    }

    @Transactional
    @Override
    public List<DrugsBean> listByPricefounded(int from, int to) {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findByPrice(from, to);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
        }
        return find;
    }

    @Transactional
    @Override
    public List<DrugsBean> listByCompanyfounded(String name) {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findByCompanye(name);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
    }

    @Transactional
    @Override
    public DrugsBean updateDrug(DrugsBean drugsBean) {
        Drugs find = null;
        Drugs findById = drugsDAO.findById(drugsBean.getName());
       //drugsBean.setPurchasingPrice(findById.getPurchasingPrice());
       findById.setQuantity(drugsBean.getQuantity());
       findById.setSellingPrice(drugsBean.getSellingPrice());
        int profit = findById.getSellingPrice()-findById.getPurchasingPrice()-findById.getDiscount();
       findById.setProfit(profit);
      
        find = drugsDAO.update(findById);

        return drugsTransformer.transformEntityToBean(find);

    }

}
