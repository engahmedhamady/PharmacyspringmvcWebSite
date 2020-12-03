/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.dal.repos;

import com.store.dal.entities.BillCodeStore;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "billCodeStoreDAO")
public class BillCodeStoreDAO extends BaseDAO implements  commonDAO<BillCodeStore>  {
      
      @Override
    
      public BillCodeStore add(BillCodeStore billCodeStore) {
           getCurrentSession().persist(billCodeStore);
            return billCodeStore;

      }
  @Override
      public BillCodeStore update(BillCodeStore billCodeStore) {
            getCurrentSession().update(billCodeStore);
            return billCodeStore;

      }
  @Override
      public void remove( Object num) {
            getCurrentSession().delete(num);

      }
  @Override
      public BillCodeStore findById(Object num) {
            return  getCurrentSession().get(BillCodeStore.class, (int)num);

      }
  @Override
      public List<BillCodeStore> findList() {
            Session session =  getCurrentSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<BillCodeStore> CriteriaQuery = builder.createQuery(BillCodeStore.class);
            Root<BillCodeStore> from0 = CriteriaQuery.from(BillCodeStore.class);
           CriteriaQuery.select(from0);
            Query<BillCodeStore> adminQuery = session.createQuery(CriteriaQuery);
            return adminQuery.getResultList();
      }
      
      
         public void patchRemove(List <BillCodeStore>billCodeStores) {
                if (billCodeStores==null) {
                     
                        return;
                     }
                for (BillCodeStore billCodeStore : billCodeStores) {
                       remove(billCodeStore.getCode());
               }
             

      }
}
