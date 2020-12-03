package com.store.dal.repos;

import com.store.dal.entities.LostDrugs;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "lostDrugsDAO")
public class LostDrugsDAO extends BaseDAO implements commonDAO<LostDrugs> {

    @Override
    public LostDrugs add(LostDrugs lostDrugs) {
        getCurrentSession().save(lostDrugs);
        return lostDrugs;

    }

    @Override
    public LostDrugs update(LostDrugs lostDrugs) {
        getCurrentSession().update(lostDrugs);
        return lostDrugs;

    }

    @Override
    public void remove(Object name) {
        getCurrentSession().delete(name);

    }

    @Override
    public LostDrugs findById(Object name) {
        return getCurrentSession().get(LostDrugs.class, (String) name);

    }

    @Override
    public List<LostDrugs> findList() {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LostDrugs> CriteriaQuery = builder.createQuery(LostDrugs.class);
        Root<LostDrugs> from0 = CriteriaQuery.from(LostDrugs.class);
        CriteriaQuery.select(from0);
        Query<LostDrugs> query = session.createQuery(CriteriaQuery);
        return query.getResultList();
    }

    public void patchRemove(List<LostDrugs> lostDrugses) {
        if (lostDrugses == null) {

            return;
        }
        for (LostDrugs lostDrugs : lostDrugses) {
            remove(lostDrugs.getDrugName());
        }

    }

    public List<LostDrugs> findByName(String name) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LostDrugs> criteriaQuery = builder.createQuery(LostDrugs.class);
        Root<LostDrugs> from0 = criteriaQuery.from(LostDrugs.class);
        criteriaQuery.select(from0);
        criteriaQuery.where(builder.equal(from0.get("drugName"), name));
   
        org.hibernate.query.Query<LostDrugs> adminQuery = session.createQuery(criteriaQuery);
        return adminQuery.getResultList();

    }

    public List<LostDrugs> findByType(String type) {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LostDrugs> CriteriaQuery = builder.createQuery(LostDrugs.class);
        Root<LostDrugs> from0 = CriteriaQuery.from(LostDrugs.class);
        CriteriaQuery.select(from0).where(builder.equal(from0.get("drugType"), type));
        org.hibernate.query.Query<LostDrugs> adminQuery = session.createQuery(CriteriaQuery);
        return adminQuery.getResultList();

    }
}
