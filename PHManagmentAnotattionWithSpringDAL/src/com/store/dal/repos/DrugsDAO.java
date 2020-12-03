
package com.store.dal.repos;

import com.store.dal.entities.Drugs;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "drugsDAO")
public class DrugsDAO extends BaseDAO implements commonDAO<Drugs> {

    @Override
    public Drugs add(Drugs drugs) {
        getCurrentSession().save(drugs);
        return drugs;

    }

    @Override
    public Drugs update(Drugs drugs) {
        getCurrentSession().update(drugs);
        return drugs;

    }

    @Override
    public void remove(Object billCode) {
        getCurrentSession().delete(billCode);

    }

    @Override
    public List<Drugs> findList() {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0);
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();
    }

    public List<Drugs> findByName(String name) {
        Session session = getCurrentSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("name"), name));
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }

    public List<Drugs> findByType(String type) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("type"), type));
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }

    public List<Drugs> findByCompanye(String type) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Drugs> CriteriaQuery = builder.createQuery(Drugs.class);
        Root<Drugs> from0 = CriteriaQuery.from(Drugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("company"), type));
        Query<Drugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }

    public List<Drugs> findByPrice(int from, int to) {
        List<Drugs> drugses = null;
        Session session = getCurrentSession();
        String querySql = "SELECT * FROM Drugs where 	Selling_price between ? and ?";
        Query query = session.createNativeQuery(querySql);
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();

        if (list.size() > 0) {
            drugses = new ArrayList<>();
            for (Object[] p : list) {
                Drugs d = new Drugs();
                d.setBarcode((String) p[0]);
                d.setName((String) p[1]);
                d.setType((String) p[2]);
                d.setPurchasingPrice((int) p[3]);
                d.setSellingPrice((int) p[4]);
                d.setDiscount((int) p[5]);
                d.setQuantity((int) p[6]);
                d.setProfit((int) p[7]);
                d.setCompany((String) p[8]);
                drugses.add(d);

            }
        }
        return drugses;
    }

    public List<Drugs> findByQuantity(int from, int to) {
        List<Drugs> drugses = null;
        Session session = getCurrentSession();
        String querySql = "SELECT * FROM Drugs where 	quantity between ? and ?";
        Query query = session.createNativeQuery(querySql);
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();

        if (list.size() > 0) {
            drugses = new ArrayList<>();
            for (Object[] p : list) {
                Drugs d = new Drugs();
                d.setBarcode((String) p[0]);
                d.setName((String) p[1]);
                d.setType((String) p[2]);
                d.setPurchasingPrice((int) p[3]);
                d.setSellingPrice((int) p[4]);
                d.setDiscount((int) p[5]);
                d.setQuantity((int) p[6]);
                d.setProfit((int) p[7]);
                d.setCompany((String) p[8]);
                drugses.add(d);

            }
        }
        return drugses;

    }

    @Override
    public Drugs findById(Object id) {
        return getCurrentSession().find(Drugs.class, (String) id);
    }

    public List<Drugs> findByDiscount(int from, int to) {
        List<Drugs> drugses = null;
        Session session = getCurrentSession();
        String querySql = "SELECT * FROM Drugs where 	discount between ? and ?";
        Query query = session.createNativeQuery(querySql);
        query.setParameter(1, from);
        query.setParameter(2, to);
        List<Object[]> list = query.list();

        if (list.size() > 0) {
            drugses = new ArrayList<>();
            for (Object[] p : list) {
                Drugs d = new Drugs();
                d.setBarcode((String) p[0]);
                d.setName((String) p[1]);
                d.setType((String) p[2]);
                d.setPurchasingPrice((int) p[3]);
                d.setSellingPrice((int) p[4]);
                d.setDiscount((int) p[5]);
                d.setQuantity((int) p[6]);
                d.setProfit((int) p[7]);
                d.setCompany((String) p[8]);
                drugses.add(d);

            }
        }
        return drugses;
    }

}
