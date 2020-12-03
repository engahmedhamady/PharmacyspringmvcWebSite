/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.AdminBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class test3 {

    public static void main(String[] args) {

        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("/com/store/dal/config/bll-spring-context.xml");
            StoreGetWay storeGetWay = context.getBean("getWay", StoreGetWay.class);
            AdminBean adminBean = new AdminBean();
            adminBean.setName("ahmed");
            adminBean.setPassword("ahmed");
            System.out.println( storeGetWay.login(adminBean));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
