
package com.store.dal.repos;

import com.store.dal.entities.PurchasesBills;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "purchasesBillsDAO")
public class PurchasesBillsDAO extends BaseDAO implements commonDAO<PurchasesBills> {

    @Override
    public PurchasesBills add(PurchasesBills purchasesBills) {
        getCurrentSession().save(purchasesBills);
        return purchasesBills;

    }

    @Override
    public PurchasesBills update(PurchasesBills purchasesBills) {
        getCurrentSession().update(purchasesBills);
        return purchasesBills;

    }

    @Override
    public void remove(Object billCode) {
        getCurrentSession().delete(billCode);

    }

    @Override
    public PurchasesBills findById(Object billCode) {
        return getCurrentSession().get(PurchasesBills.class, (int) billCode);

    }

    @Override
    public List<PurchasesBills> findList() {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchasesBills> CriteriaQuery = builder.createQuery(PurchasesBills.class);
        Root<PurchasesBills> from0 = CriteriaQuery.from(PurchasesBills.class);
        CriteriaQuery.select(from0);
        Query<PurchasesBills> query = session.createQuery(CriteriaQuery);
        return query.getResultList();
    }

    public void patchRemove(List<PurchasesBills> purchasesBillses) {
        if (purchasesBillses == null) {

            return;
        }
        for (PurchasesBills purchasesBills : purchasesBillses) {
            remove(purchasesBills.getBillcode());
        }

    }

    public List<PurchasesBills> findByTotalPurchases(int from, int to) {
        List<PurchasesBills> purchasesBillses = null;
        Session session = getCurrentSession();
        String querySql = "SELECT * FROM purchases_bills where total between ? and ?";
        Query query = session.createNativeQuery(querySql)
                .addScalar("Billcode")
                .addScalar("total")
                .addScalar("DateBill");
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();

        if (list.size() > 0) {
            purchasesBillses = new ArrayList<>();
            for (Object[] p : list) {
                PurchasesBills d = new PurchasesBills();
                d.setBillcode((int) p[0]);
                d.setTotal((int) p[1]);
                d.setDateBill((Date) p[2]);

                purchasesBillses.add(d);

            }
            return purchasesBillses;
        } else {
            return null;
        }

    }

    

    
public List <PurchasesBills> findByDate(Date from, Date to) 
    {
        List<PurchasesBills> purchasesBillses = null;
        Session session = getCurrentSession();
        String querySql = "SELECT * FROM purchases_bills where DateBill between ? and ?";
        Query query = session.createNativeQuery(querySql)
                .addScalar("Billcode")
                .addScalar("total")
                .addScalar("DateBill");
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();

        if (list.size() > 0) {
            purchasesBillses = new ArrayList<>();
            for (Object[] p : list) {
                PurchasesBills d = new PurchasesBills();
                d.setBillcode((int) p[0]);
                d.setTotal((int) p[1]);
                d.setDateBill((Date) p[2]);

                purchasesBillses.add(d);

            }
            return purchasesBillses;
        } else {
            return null;
        }
    }
}
