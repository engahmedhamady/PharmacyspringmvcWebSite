package com.store.dal.repos;

import com.store.dal.entities.Screens;
import com.store.dal.myGenerics.repos.commonDAO;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository(value = "screensDAO")
public class ScreensDAO extends BaseDAO implements commonDAO<Screens> {

    @Override
    public Screens add(Screens screens) {
        getCurrentSession().persist(screens);
        return screens;

    }

    @Override
    public Screens update(Screens screens) {
        getCurrentSession().update(screens);
        return screens;

    }

    @Override
    public void remove(Object seq) {
        getCurrentSession().delete(seq);

    }

    @Override
    public Screens findById(Object seq) {
        return getCurrentSession().get(Screens.class, (int) seq);

    }

    @Override
    public List<Screens> findList() {
        Session session = getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Screens> CriteriaQuery = builder.createQuery(Screens.class);
        Root<Screens> from0 = CriteriaQuery.from(Screens.class);
        CriteriaQuery.select(from0);
        Query<Screens> query = session.createQuery(CriteriaQuery);
        return query.getResultList();
    }

    public void patchRemove(List<Screens> screenses) {
        if (screenses == null) {

            return;
        }
        for (Screens screens : screenses) {
            remove(screens.getSeq());
        }

    }
}
