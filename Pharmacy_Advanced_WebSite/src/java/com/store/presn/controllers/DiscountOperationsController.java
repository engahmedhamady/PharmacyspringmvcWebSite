
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.DrugsBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/DiscountOperationsController/"})

public class DiscountOperationsController {
    
    @Autowired(required = true)
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }
    
    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = "discountall", method = RequestMethod.POST)
    public ModelAndView listAll(@RequestParam("page") String page) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List<DrugsBean> selectAll = getWay.listAllDiscount();
        ModelAndView modelAndView = new ModelAndView();
        if (selectAll.size() > 0) {
            modelAndView.setViewName(page);
            modelAndView.addObject("salebill", selectAll);
        } else {
            modelAndView.setViewName("errorPage");
            
        }
        //page
        return modelAndView;//return page name

    }
    //===================================================================
    
    @RequestMapping(value = "discountname", method = RequestMethod.POST)
    public ModelAndView findByName(@RequestParam("page") String page, @RequestParam("name") String name) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List< DrugsBean> selectAll = getWay.findByNameDiscount(name);
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
    
    @RequestMapping(value = "discountprice", method = RequestMethod.POST)
    public ModelAndView FindByPrice(@RequestParam("page") String page, @RequestParam("from") String from, @RequestParam("to") String to) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        int fromValue = Integer.parseInt(from);
        int toValue = Integer.parseInt(to);
        
        List< DrugsBean> selectAll = getWay.findByPriceDiscount(fromValue, toValue);
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
//===============================================================================    
    @RequestMapping(value = "discounttype", method = RequestMethod.POST)
    public ModelAndView findByType(@RequestParam("page") String page, @RequestParam("type") String type) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List< DrugsBean> selectAll = getWay.findByTypeDiscount(type);
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

    @RequestMapping(value = "discount", method = RequestMethod.POST)
    public ModelAndView findByDiscount(@RequestParam("page") String page, @RequestParam("from") String from, @RequestParam("to") String to) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        int fromValue = Integer.parseInt(from);
        int toValue = Integer.parseInt(to);
        
        List< DrugsBean> selectAll = getWay.findByDiscount(fromValue, toValue);
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
    
}
