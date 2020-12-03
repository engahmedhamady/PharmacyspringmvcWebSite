/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.PurchasesBillsBean;
import com.store.common.beans.SalesBillsBean;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/ReportsOperationsControllerr/"})
public class ReportsOperationsController {

    @Autowired(required = true)
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

    @RequestMapping(value = "saleall", method = RequestMethod.POST)
    public ModelAndView listAllSales(@RequestParam("page") String page) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List<SalesBillsBean> selectAll = getWay.listAllSales();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("salebills", selectAll);;

        if (selectAll.size() > 0) {
            modelAndView.setViewName(page);

        } else {
            modelAndView.setViewName("errorPage");

        }
        //page
        return modelAndView;//return page name

    }
//=========================================================================
    @RequestMapping(value = "salebillcode", method = RequestMethod.POST)
    public ModelAndView findByBillcodeSale(@RequestParam("page") String page, @RequestParam("billCode") String billCode) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List<SalesBillsBean> selectAll = getWay.findByCodeSales(Integer.parseInt(billCode));

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
//===========================================================================
    @RequestMapping(value = "saletotal", method = RequestMethod.POST)
    public ModelAndView findBySaleTotal(@RequestParam("page") String page, @RequestParam("fromSearch") String from, @RequestParam("toSearch") String to) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        int fromValue = Integer.parseInt(from);
        int toValue = Integer.parseInt(to);
        ModelAndView modelAndView = new ModelAndView();
        if (Integer.parseInt(from) < Integer.parseInt(to)) {
            List<SalesBillsBean> selectAll = getWay.findByTotalSales(Integer.parseInt(from), Integer.parseInt(to));
            modelAndView.addObject("salebill", selectAll);
            if (selectAll.size() > 0) {
                modelAndView.setViewName(page);
            } else {
                modelAndView.addObject("salebill", "not");

                modelAndView.setViewName(page);
            }
        } else {
            modelAndView.addObject("salebill", "error");

            modelAndView.setViewName(page);
        }
        //page
        return modelAndView;//return page name

    }
//===========================================================================
    @RequestMapping(value = "saleprofit", method = RequestMethod.POST)
    public ModelAndView findBySaleProfit(@RequestParam("page") String page, @RequestParam("fromSearch") String from, @RequestParam("toSearch") String to) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        int fromValue = Integer.parseInt(from);
        int toValue = Integer.parseInt(to);
        ModelAndView modelAndView = new ModelAndView();
        if (Integer.parseInt(from) < Integer.parseInt(to)) {
            List<SalesBillsBean> selectAll = getWay.findByProfitSales(Integer.parseInt(from), Integer.parseInt(to));
                     modelAndView.addObject("salebill", selectAll);
            if (selectAll.size() > 0) {
                modelAndView.setViewName(page);
            } else {
                modelAndView.addObject("salebill", "not");

                modelAndView.setViewName(page);
            }
        } else {
            modelAndView.addObject("salebill", "error");

            modelAndView.setViewName(page);
        }
        //page
        return modelAndView;//return page name

    }
//========================================================================
@RequestMapping(value = "purchaseall", method = RequestMethod.POST)
    public ModelAndView listAllPurchase(@RequestParam("page") String page) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List<PurchasesBillsBean> selectAll = getWay.listAllPurchases();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("salebills", selectAll);;

        if (selectAll.size() > 0) {
            modelAndView.setViewName(page);

        } else {
            modelAndView.setViewName("errorPage");

        }
        //page
        return modelAndView;//return page name

    }

 //=======================================================================   
    @RequestMapping(value = "purchasebillcode", method = RequestMethod.POST)
    public ModelAndView findByPurchaseBillcode(@RequestParam("page") String page,@RequestParam("billCode") String billCode) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List<PurchasesBillsBean> selectAll = getWay.findByCodePurchases(Integer.parseInt(billCode));
               
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
//=======================================================================
    @RequestMapping(value = "purchasetotal", method = RequestMethod.POST)
    public ModelAndView findByPurchaseTotal(@RequestParam("page") String page, @RequestParam("fromSearch") String from, @RequestParam("toSearch") String to) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        int fromValue = Integer.parseInt(from);
        int toValue = Integer.parseInt(to);
        ModelAndView modelAndView = new ModelAndView();
        if (Integer.parseInt(from) < Integer.parseInt(to)) {
            List<PurchasesBillsBean> selectAll = getWay.findByTotalPurchases(fromValue, toValue);
         modelAndView.addObject("salebill", selectAll);
            if (selectAll.size() > 0) {
                modelAndView.setViewName(page);
            } else {
                modelAndView.addObject("salebill", "not");

                modelAndView.setViewName(page);
            }
        } else {
            modelAndView.addObject("salebill", "error");

            modelAndView.setViewName(page);
        }
        //page
        return modelAndView;//return page name

    }
//==================================================================
     @RequestMapping(value = "analysis", method = RequestMethod.POST)
    public ModelAndView analysis(@RequestParam("page") String page, @RequestParam("operation") String operation,@RequestParam("fromdate") String from,@RequestParam("todate") String to) {
         ModelAndView modelAndView = new ModelAndView();
        try {
            //data
            StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = sdf.parse(from);
            Date endDate = sdf.parse(to);
            int totalProfit = 0;
            int totalPayment = 0;
            int totalIncome = 0;
            
          
            if (startDate.compareTo(endDate) < 0) {
                modelAndView.addObject("analysis", "ok");
                totalPayment = getWay.payment(endDate, endDate);
                
                totalProfit = getWay.profits(endDate, endDate);
                totalIncome = getWay.incom(endDate, endDate);
                
                modelAndView.addObject("payment", totalPayment);
                modelAndView.addObject("income", totalIncome);
                modelAndView.addObject("profit", totalProfit);
                modelAndView.setViewName( page);
            } else {
                modelAndView.addObject("analysis", "error");
                modelAndView.setViewName( page);
            }
            //page
           
        } catch (ParseException ex) {
            modelAndView.addObject("analysis", "error");
                modelAndView.setViewName( page); }
 return modelAndView;//return page name
    }
    

}
