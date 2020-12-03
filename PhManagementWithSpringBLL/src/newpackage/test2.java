/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import com.store.dal.entities.Drugs;
import com.store.dal.entities.LostDrugs;
import com.store.dal.manager.HibernateDBManager;
import com.store.dal.repos.DrugsDAO;
import com.store.dal.repos.LostDrugsDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;

/**
 *
 * @author Sroor For Laptop
 */
public class test2 {

    public static void main(String[] args) {
        try {
            HibernateDBManager.setDbConfigFileName("com/store/dal/config/hibernate.cfg.xml");

            HibernateDBManager.buildSessionFactory();
            Session session = HibernateDBManager.getSession();
            HibernateDBManager.beginTransaction();
            LostDrugsDAO dAO = new LostDrugsDAO();
            LostDrugs drugs = new LostDrugs();
            
           
          
            drugs.setDrugName("alttttttttttttt");
           drugs.setDrugType("ointment");
            dAO.remove(drugs);
            HibernateDBManager.commitTransaction();
            HibernateDBManager.closeSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
