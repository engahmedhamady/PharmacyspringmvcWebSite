package com.store.bll.impl;

import com.store.bll.managers.LogManager;
import com.store.bll.transformers.AdminTransformer;
import com.store.common.beans.AdminBean;
import com.store.dal.entities.Admin;
import com.store.dal.entities.Screens;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.repos.AdminDAO;
import java.util.Set;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ahmed
 */
@Component(value = "logManagerImpl")
public class LogManagerImpl implements LogManager {

    @Autowired(required = true)
    AdminTransformer adminTransformer;
    @Autowired(required = true)
    AdminDAO adminDAO;

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    public AdminTransformer getAdminTransformer() {
        return adminTransformer;
    }

    public void setAdminTransformer(AdminTransformer adminTransformer) {
        this.adminTransformer = adminTransformer;
    }

    @Override
    @Transactional
    public AdminBean find(AdminBean adminBean) {
        AdminBean x = null;
        try {
            Admin find = adminDAO.find(adminTransformer.transformBeanToEntity(adminBean));
         
            Set<Screens> screenses = find.getScreenses();
            for (Screens screense : screenses) {
                System.out.println(screense.getAdmin().getName() + "------" + screense.getPage());

            }
            if (find == null) {
                return null;
            } else {
                return adminTransformer.transformEntityToBean(find);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        //  return x;

    }

    @Override
    @Transactional
    public boolean login(AdminBean adminBean) {
        try {
            Admin find = adminDAO.find(adminTransformer.transformBeanToEntity(adminBean));

            if (find == null) {
                return false;
            } else {
                if (adminBean.getPassword().equals(find.getPassword())) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {

            return false;
        }

    }

    @Override
    public boolean logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
