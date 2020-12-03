package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.AdminBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/SettingOperationsController/"})
public class SettingOperationsController {

    @Autowired(required = true)
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = "viewaccounts", method = RequestMethod.POST)
    public ModelAndView listAll(@RequestParam("page") String page) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List<AdminBean> selectAll = getWay.listAll();
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

    @RequestMapping(value = "addaccount", method = RequestMethod.POST)
    public ModelAndView insert(@RequestParam("page") String page, @RequestParam("name") String name, @RequestParam("password") String password) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);

        AdminBean admin = new AdminBean();
        admin.setName(name);
        admin.setPassword(password);

        boolean login = getWay.login(admin);
        ModelAndView modelAndView = new ModelAndView();
        if (login) {
            modelAndView.setViewName(page);
            modelAndView.addObject("founded", 0);
        } else if (!login) {
            getWay.addAccount(admin);
            modelAndView.setViewName(page);
            modelAndView.addObject("founded", 1);
        } else {
            modelAndView.setViewName("errorPage");
        }
        //page
        return modelAndView;//return page name
    }

    @RequestMapping(value = "editaccount", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam("page") String page, @RequestParam("name") String name, @RequestParam("password") String password, @RequestParam("newPassword") String newPassword) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);

        AdminBean admin = new AdminBean();
        admin.setName(name);
        admin.setPassword(password);

        boolean login = getWay.login(admin);

        ModelAndView modelAndView = new ModelAndView();
        if (login) {
            modelAndView.setViewName(page);
            modelAndView.addObject("edited", 0);
        } else if (!login) {
            admin.setPassword(newPassword);
            getWay.updatePassword(admin);
            modelAndView.setViewName(page);
            modelAndView.addObject("edited", 1);
        } else {
            modelAndView.setViewName("errorPage");

        }
        //page
        return modelAndView;//return page name

    }

    @RequestMapping(value = "deleteaccount", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("page") String page, @RequestParam("name") String name, @RequestParam("password") String password) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);

        AdminBean admin = new AdminBean();
        admin.setName(name);
        admin.setPassword(password);

        boolean login = getWay.login(admin);
        ModelAndView modelAndView = new ModelAndView();
        if (login) {
            getWay.deleteAccount(admin);
            modelAndView.setViewName(page);
            modelAndView.addObject("deleted", 1);
        } else if (!login) {
            getWay.addAccount(admin);
            modelAndView.setViewName(page);
            modelAndView.addObject("deleted", 0);
        } else {
            modelAndView.setViewName("errorPage");

        }
        //page
        return modelAndView;//return page name

    }

}
