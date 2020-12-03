/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.SearchManager;
import com.store.bll.transformers.DrugsTransformer;
import com.store.common.beans.DrugsBean;
import com.store.dal.entities.Drugs;
import com.store.dal.repos.DrugsDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "searchManagerImpl")
public class SearchManagerImpl implements SearchManager {

    @Autowired(required = true)
    private DrugsDAO drugsDAO;
    @Autowired(required = true)
    private DrugsTransformer drugsTransformer;

    @Transactional
    @Override
    public List<DrugsBean> listAllSearch() {
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
    public List<DrugsBean> findByNameSearch(String name) {
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
    public List<DrugsBean> findByTypeSearch(String type) {
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
    public List<DrugsBean> findByPriceSearch(int from, int to) {
        List<DrugsBean> find = null;
        List<Drugs> findList = drugsDAO.findByPrice(from, to);
        if (findList != null) {
            find = new ArrayList();
            for (Drugs drugs : findList) {
                System.out.println(drugs.getName());
                find.add(drugsTransformer.transformEntityToBean(drugs));
            }
        }

        return find;
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

}
