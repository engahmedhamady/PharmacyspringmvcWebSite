package com.store.bll.transformers;

import com.store.dal.entities.Admin;
import com.store.common.beans.AdminBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author ahmed
 */
@Component(value = "adminTransformer")
public class AdminTransformer {

    public AdminBean transformEntityToBean(Admin entity) {
        if (entity == null) {
            return null;
        }
        AdminBean bean = new AdminBean();
        // transform
        bean.setName(entity.getName());
        bean.setPassword(entity.getPassword());
        return bean;
    }

    public Admin transformBeanToEntity(AdminBean bean) {
        if (bean == null) {
            return null;
        }
        Admin entity = new Admin();
        // transform
        entity.setName(bean.getName());
        entity.setPassword(bean.getPassword());
        return entity;
    }
}
