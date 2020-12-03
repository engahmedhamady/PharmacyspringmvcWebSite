/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.bll.impl;

import com.store.bll.managers.SettingManager;
import com.store.bll.transformers.AdminTransformer;
import com.store.common.beans.AdminBean;
import com.store.dal.entities.Admin;
import com.store.dal.repos.AdminDAO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component(value = "settingManagerImpl")
public class SettingManagerImpl implements SettingManager {

    @Autowired(required = true)
    private AdminTransformer adminTransformer;
    @Autowired(required = true)
    private AdminDAO adminDAO;

    @Transactional
    @Override
    public void addAccount(AdminBean adminBean) {
        adminDAO.add(adminTransformer.transformBeanToEntity(adminBean));
    }

    @Transactional
    @Override
    public void deleteAccount(AdminBean adminBean) {

        adminDAO.remove(adminTransformer.transformBeanToEntity(adminBean));

    }

    @Transactional
    @Override
    public void updatePassword(AdminBean adminBean) {

        adminDAO.update(adminTransformer.transformBeanToEntity(adminBean));

    }

    @Transactional
    @Override
    public List<AdminBean> listAll() {
        List<AdminBean> l = null;
        List<Admin> list = adminDAO.findList();

        if (list != null) {
            l = new ArrayList<>();
            for (Admin admin : list) {

                l.add(adminTransformer.transformEntityToBean(admin));
            }

        }

        return l;
    }

    public AdminTransformer getAdminTransformer() {
        return adminTransformer;
    }

    public void setAdminTransformer(AdminTransformer adminTransformer) {
        this.adminTransformer = adminTransformer;
    }

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

}
