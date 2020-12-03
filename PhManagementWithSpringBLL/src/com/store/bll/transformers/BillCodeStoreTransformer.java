package com.store.bll.transformers;

import com.store.common.beans.BillCodeStoreBean;
import com.store.dal.entities.BillCodeStore;
import org.springframework.stereotype.Component;

@Component(value = "billCodeStoreTransformer")
public class BillCodeStoreTransformer {

    public BillCodeStoreBean transformEntityToBean(BillCodeStore entity) {
        if (entity == null) {
            return null;
        }
        BillCodeStoreBean bean = new BillCodeStoreBean();
        // transform
        bean.setCode(entity.getCode());
        
        return bean;
    }

    public BillCodeStore transformBeanToEntity(BillCodeStoreBean bean) {
        if (bean== null) {
            return null;
        }
       BillCodeStore entity =new BillCodeStore();
        // transform
        entity.setCode(bean.getCode());
     
        return entity;
        
    }
}
