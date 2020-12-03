
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.CustomerBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/CustomerOperationsController/"})
public class CustomerOperationsController {

    @Autowired(required = true)
    private ApplicationContext context;
       public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    @RequestMapping(value = "customerall", method = RequestMethod.POST)
    public ModelAndView listAll(@RequestParam("page") String page) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List< CustomerBean> selectAll = getWay.listAllCustomer();
        ModelAndView modelAndView = new ModelAndView();
        if (selectAll.size() > 0) {
          
            modelAndView.addObject("salebill", selectAll);
              modelAndView.setViewName(page);
        } else {
          
            modelAndView.addObject("salebill", "not");
              modelAndView.setViewName(page);
        }
        //page
        return modelAndView;//return page name

    }

    //===============================================================================
    @RequestMapping(value = "customername", method = RequestMethod.POST)
    public ModelAndView findByName(@RequestParam("page") String page, @RequestParam("name") String name) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
       List< CustomerBean> selectAll = getWay.listByNameCustomer(name);
        ModelAndView modelAndView = new ModelAndView();
        if (selectAll.size() > 0) {
            modelAndView.setViewName(page);
            modelAndView.addObject("salebill", selectAll);
        } else {
            modelAndView.setViewName(page);
            modelAndView.addObject("salebill", "not");
        }
        //page
        return modelAndView;//return page name

    }

    //=============================================================================
 @RequestMapping(value = "customeradd", method = RequestMethod.POST)
    public ModelAndView insertCustomer(@RequestParam("page") String page,@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("phone") String phone) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        
      CustomerBean bean = new CustomerBean();
            bean.setEmail(email);
            bean.setName(name);
            bean.setPhone(phone);
            CustomerBean addCustomer = getWay.addCustomer(bean);
        ModelAndView modelAndView = new ModelAndView();
        if (addCustomer == null) {
            modelAndView.setViewName(page);
            modelAndView.addObject("founded", 0);
        } 
        else if (addCustomer != null) {
             modelAndView.setViewName(page);
            modelAndView.addObject("founded", 1);
        }
        else {
            modelAndView.setViewName("errorPage");
           
        }
        //page
        return modelAndView;//return page name

    }



}
