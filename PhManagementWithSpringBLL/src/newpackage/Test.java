package newpackage;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.AdminBean;
import com.store.common.beans.DrugsBean;
import com.store.common.beans.PurchasesBillsBean;
import com.store.dal.manager.HibernateDBManager;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

public class Test {

    public static void main(String[] args) {
        StoreGetWay getWay = new StoreGetWay();
        try {

            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");

            HibernateDBManager.buildSessionFactory();
            Session session = HibernateDBManager.getSession();
          //  HibernateDBManager.beginTransaction();
            List<DrugsBean> findByPriceSearch = getWay.findByPriceSearch(0, 10);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
