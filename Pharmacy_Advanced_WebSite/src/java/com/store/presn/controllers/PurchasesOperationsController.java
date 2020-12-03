
package com.store.presn.controllers;

import com.store.bll.delegate.StoreGetWay;
import com.store.common.beans.DrugsBean;
import com.store.common.beans.LostDrugsBean;
import com.store.common.beans.PurchasesBillsBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping(value = {"/PurchasesOperationsController/"})
public class PurchasesOperationsController  {

   @Autowired(required = true)
    private ApplicationContext context;

    public ApplicationContext getContext() {
        return context;
    }
    
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public ModelAndView insertBill(@RequestParam("page") String page, @RequestParam("name") String name,
            @RequestParam("type") String type,@RequestParam("company") String company,
            @RequestParam("barcode") String barcode,@RequestParam("quantity") String quantity,
            @RequestParam("sell") String sell,@RequestParam("discount") String discount,
            @RequestParam("purchase") String purchase) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
       java.util.Date date = new java.util.Date(new java.util.Date().getTime());
             PurchasesBillsBean bean = new PurchasesBillsBean();
            bean.setBarCode(barcode);
            bean.setBillCode(getWay.createBill());
            bean.setCompany(company);
            bean.setDateBill(date);
            bean.setDiscount(Integer.parseInt(discount));
            bean.setDrugName(name);
            bean.setDrugType(type);
            bean.setPurchasePrice(Integer.parseInt(purchase));
            bean.setQuantityDrug(Integer.parseInt(quantity));
            bean.setSellPrice(Integer.parseInt(sell));
            bean.setTotal(Integer.parseInt(quantity)*Integer.parseInt(purchase));
            PurchasesBillsBean selectAll = getWay.saveBill(bean);
        ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName(page);
        if (selectAll != null) {
          
            modelAndView.addObject("salebill", selectAll);
        } else {
            modelAndView.setViewName("errorPage");
            
        }
        //page
        return modelAndView;//return page name

    }
    
//--------------------------------------------------------------------------------------
    @RequestMapping(value = "foundall", method = RequestMethod.POST)
    public ModelAndView listAll(@RequestParam("page") String page) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List<DrugsBean> selectAll = getWay.listAllFounded();
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
   //----------------------------------------------------------------------------- 
    @RequestMapping(value = "foundname", method = RequestMethod.POST)
    public ModelAndView findByName(@RequestParam("page") String page,  @RequestParam("name") String name) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
         List<DrugsBean> selectAll = getWay.listByNamefounded(name);
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
  //========================================================================= 
    @RequestMapping(value = "foundtype", method = RequestMethod.POST)
    public ModelAndView findByType(@RequestParam("page") String page, @RequestParam("operation") String operation, @RequestParam("selected") String type) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
         List<DrugsBean> selectAll = getWay.listByTypefounded(type);
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
    //=================================================================
    @RequestMapping(value = "foundprice", method = RequestMethod.POST)
    public ModelAndView findByPrice(@RequestParam("page") String page, @RequestParam("from") String from, @RequestParam("to") String to) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        int fromValue = Integer.parseInt(from);
        int toValue = Integer.parseInt(to);
        
        List< DrugsBean> selectAll = getWay.listByPricefounded(fromValue, toValue);
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
    
   // ========================================================================

    @RequestMapping(value = "foundquantity", method = RequestMethod.POST)
    public ModelAndView findByQuantity(@RequestParam("page") String page, @RequestParam("from") String from, @RequestParam("to") String to) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        int fromValue = Integer.parseInt(from);
        int toValue = Integer.parseInt(to);
        
       List<DrugsBean> selectAll = getWay.listByQuantityfounded(fromValue, toValue);
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
     @RequestMapping(value = "foundcompany", method = RequestMethod.POST)
    public ModelAndView findByCompany(@RequestParam("page") String page, @RequestParam("name") String name) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
           List<DrugsBean> selectAll = getWay.listByCompanyfounded(name);
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
    //====================================================================
        @RequestMapping(value = "requestall", method = RequestMethod.POST)
    public ModelAndView listAllRequested(@RequestParam("page") String page) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        List< LostDrugsBean> selectAll = getWay.listAllRequested();
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

    @RequestMapping(value = "requestname", method = RequestMethod.POST)
    public ModelAndView findByRequestName(@RequestParam("page") String page,@RequestParam("name") String name) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
         List< LostDrugsBean> selectAll = getWay.listByNameRequested(name);
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

 @RequestMapping(value = "requestadd", method = RequestMethod.POST)
    public ModelAndView insertRequested(@RequestParam("page") String page, @RequestParam("name") String name,@RequestParam("type") String type,@RequestParam("quantity") String quantity) {
        //data
        StoreGetWay getWay = context.getBean("getWay", StoreGetWay.class);
        
     LostDrugsBean bean = new LostDrugsBean();
            bean.setDrugname(name);
            bean.setDrugtype(type);
            bean.setQuantitydrug(Integer.parseInt(quantity));
            LostDrugsBean addRequested = getWay.addRequested(bean);
           
        ModelAndView modelAndView = new ModelAndView();
        if (addRequested != null) {
            modelAndView.setViewName(page);
            modelAndView.addObject("founded", 1);
        } 
        else if (addRequested == null) {
             modelAndView.setViewName(page);
            modelAndView.addObject("founded", 0);
        }
        else {
            modelAndView.setViewName("errorPage");
           
        }
        //page
        return modelAndView;//return page name

    }


}
