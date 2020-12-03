/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.Admin;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ahmed
 */
@Repository(value = "adminDAO")
public class AdminDAO extends BaseDAO implements commonDAO<Admin> {

// insert 
    @Override
    public Admin add(Admin admin) {
        getCurrentSession().persist(admin);
        return admin;

    }

    @Override
    public Admin update(Admin admin) {
        getCurrentSession().update(admin);
        return admin;

    }
// delete

    @Override
    public void remove(Object name) {
        getCurrentSession().delete(name);

    }
// find by name

    public Admin findById(Object name) {
        return getCurrentSession().get(Admin.class, (String) name);

    }

    public Admin find(Admin admin) {
        return getCurrentSession().find(Admin.class, admin.getName());

    }

    @Override
    public List<Admin> findList() {
        Session session = getCurrentSession().getSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> adminCriteriaQuery = builder.createQuery(Admin.class);
        Root<Admin> from0 = adminCriteriaQuery.from(Admin.class);
        adminCriteriaQuery.select(from0);
        Query<Admin> adminQuery = session.createQuery(adminCriteriaQuery);
        return adminQuery.getResultList();
    }

    public void patchRemove(List<Admin> admins) {
        if (admins == null) {

            return;
        }
        for (Admin admin : admins) {
            remove(admin.getName());
        }

    }

}
