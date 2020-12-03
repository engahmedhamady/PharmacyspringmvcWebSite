package com.store.bll.impl;

import com.store.bll.managers.DiscountManager;
import com.store.bll.transformers.DrugsTransformer;
import com.store.common.beans.DrugsBean;
import com.store.dal.entities.Drugs;
import com.store.dal.repos.DrugsDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "discountManagerImpl")
public class DiscountManagerImpl implements DiscountManager {

    @Autowired(required = true)
    private DrugsDAO drugsDAO;
    @Autowired(required = true)
    private DrugsTransformer drugsTransformer;

    public DrugsDAO getDrugsDAO() {
        return drugsDAO;
    }
public DrugsTransformer getDrugsTransformer() {
        return drugsTransformer;
    }

    public void setDrugsTransformer(DrugsTransformer drugsTransformer) {
        this.drugsTransformer = drugsTransformer;
    }

    public void setDrugsDAO(DrugsDAO drugsDAO) {
        this.drugsDAO = drugsDAO;
    }

    @Transactional
    @Override
    public List<DrugsBean> listAllDiscount() {
        List<DrugsBean> l = null;
        List<Drugs> list = drugsDAO.findList();

        if (list != null) {
            l = new ArrayList<>();
            for (Drugs d : list) {

                l.add(drugsTransformer.transformEntityToBean(d));
            }

            return l;
        } else {
            return null;
        }

    }

    @Transactional
    @Override
    public List<DrugsBean> findByNameDiscount(String name) {
        List<DrugsBean> find = null;

        List<Drugs> findList = drugsDAO.findByName(name);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
            return find;

        } else {
            return null;
        }

    }

    @Transactional
    @Override
    public List<DrugsBean> findByTypeDiscount(String type) {
        List<DrugsBean> find = null;

        List<Drugs> findList = drugsDAO.findByType(type);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {

                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
            return find;
        } else {
            return null;
        }

    }

    @Transactional
    @Override
    public List<DrugsBean> findByDiscount(int from, int to) {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findByDiscount(from, to);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {
                System.out.println(drugs.getName());
                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
            return find;
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public List<DrugsBean> findByPriceDiscount(int from, int to) {
        List<DrugsBean> find = null;

        List<Drugs> findList = drugsDAO.findByPrice(from, to);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {
                System.out.println(drugs.getName());
                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
            return find;
        } else {
            return null;
        }

    }

    @Transactional
    @Override
    public DrugsBean updateDiscount(String name, int value) {
        Drugs find = null;
        Drugs findById = drugsDAO.findById(name);
        findById.setDiscount(value);
        int profit = findById.getSellingPrice()-findById.getPurchasingPrice()-value;
        findById.setProfit(profit);
        find = drugsDAO.update(findById);
        return drugsTransformer.transformEntityToBean(find);
    }

    
}
