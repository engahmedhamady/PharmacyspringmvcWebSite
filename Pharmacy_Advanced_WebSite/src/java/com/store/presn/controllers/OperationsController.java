
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.AdminBean;
import com.store.dal.entities.Screens;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value = {"/OperationsController/"})
public class OperationsController  {
     @Autowired(required = true)
    private ApplicationContext context;
       public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

     @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView logIn(@RequestParam("page") String page, @RequestParam("name") String name, @RequestParam("password") String password) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
       AdminBean adminBean = new AdminBean();
            adminBean.setName(name);
            adminBean.setPassword(password);
            boolean admin = getWay.login(adminBean);  ModelAndView modelAndView = new ModelAndView();
        if (!admin) {
          
            modelAndView.addObject("bean", null);
                adminBean.setIsLegalLogin("0");
                modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName(page);
            modelAndView.addObject("bean", adminBean);
            adminBean.setIsLegalLogin("1");
                //adminBean.setScreenses(getWay.find(adminBean).getScreenses());
               
//                Set screenses = getWay.find(adminBean).getScreenses();
//                Iterator iterator = screenses.iterator();
//                Set set = new HashSet();
//                while (iterator.hasNext()) {
//                   String next = ((Screens) iterator.next()).getPage();
//                    set.add(next);
//                    
//                }
              //  modelAndView.addObject("screens", set);
              modelAndView.setViewName(page);
        }
          
        //page
        return modelAndView;//return page name

    }
}
