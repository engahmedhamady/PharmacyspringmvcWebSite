
package com.store.presn.controllers;

import com.store.common.beans.AdminBean;
import com.store.presn.constansApp.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/*", "/MenuController/"})

public class MenuController {

    @RequestMapping(value = "/")
    public ModelAndView index() {
        //data
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;//return page name
    }

    @RequestMapping(value = "processRequest")
    protected ModelAndView processRequest(@RequestParam("page") String page) {
        ModelAndView modelAndView = new ModelAndView();

        if (page == null || page.equals("") || page.trim().equals("")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "login page");
            modelAndView.setViewName("index");
        }

        if (page.equals("home")) {
            AdminBean adminBean = new AdminBean();

            if (adminBean == null || !adminBean.getIsLegalLogin().equals("1")) {
                modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "");
                modelAndView.setViewName("index");

            } else {
                modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
                modelAndView.setViewName(page);
            }
        } else if (page.equals("newsales")) {

            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("deliverylist")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("newpurchase")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("foundedall")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("foundedname")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("foundedtype")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("foundedquantity")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("foundedexpiry")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("foundedprice")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("foundedcompany")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("requestall")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("requestname")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("requestadd")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("customerall")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("customername")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("customeradd")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("searchall")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("searchname")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("searchtype")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("searchprice")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("searchexpiry")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("discountall")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("discountdiscount")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("discountname")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("discountprice")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("discounttype")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("salebillreportsall")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("salebillreportsdate")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("salebillreportsbillcode")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("salebillreportstotal")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("salebillreportsprofit")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("purchasebillreportsall")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("purchasebillreportsdate")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("purchasebillreportstotal")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("purchasebillreportsbillcode")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("analysisbillreports")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("addaccount")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("deleteaccount")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("editaccount")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("viewaccounts")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("priviliges")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("about")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else if (page.equals("logout")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName("index");
            // ((Admin) session.getAttribute("log")).setIsLegalLogin("0");

            // session.removeAttribute("log");
            // response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            //response.setHeader("Pragma", "no-cache");
            // response.setDateHeader("Expires", 0);
            //  session.invalidate();
           
        } else if (page.equals("errorPage")) {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        } else {
            modelAndView.addObject(Constants.TITLE_ATTRIBUTE, "home page");
            modelAndView.setViewName(page);
        }
        return modelAndView;

    }

}
