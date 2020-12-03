/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.store.presn.controllers;
import com.store.bll.delegate.StoreGetWay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ahmed
 */
public class SalesOperationController extends HttpServlet {

     


//      protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//              throws ServletException, IOException {
//            response.setContentType("text/html;charset=UTF-8");
//
//            String page = request.getParameter("page");
//            String operation = request.getParameter("operation");
//   StoreGetWay getWay =   new StoreGetWay();
//            RequestDispatcher dispatcher = null;
//            HttpSession session = request.getSession();
//
//            if (page == null || page.equals("") || page.trim().equals("")) {
//                  dispatcher = request.getRequestDispatcher("index.jsp");
//                  dispatcher.forward(request, response);
//            }
//
//            if (operation == null || operation.equals("") || operation.trim().equals("")) {
//                  dispatcher = request.getRequestDispatcher("index.jsp");
//                  dispatcher.forward(request, response);
//            }
//            if (operation.equals("save")) {
//
//                  ArrayList<Integer> num = new ArrayList();
//                  String drug1 = request.getParameter("drug1");
//
//                  String drug2 = request.getParameter("drug2");
//                  String drug3 = request.getParameter("drug3");
//                  String drug4 = request.getParameter("drug4");
//                  String drug5 = request.getParameter("drug5");
//                  String num1 = request.getParameter("num1");
//                  String num2 = request.getParameter("num2");
//                  String num3 = request.getParameter("num3");
//                  String num4 = request.getParameter("num4");
//                  String num5 = request.getParameter("num5");
//                  if (drug1 != null && num1 != null && DrugsRepos.select(drug1) != null) {
//                        if (Integer.parseInt(num1) > 0) {
//                              num.add(Integer.parseInt(num1));
//                              l.add(DrugsRepos.select(drug1));
//                        }
//
//                  }
//                  if (drug2 != null && num2 != null && DrugsRepos.select(drug2) != null) {
//                        if (Integer.parseInt(num2) > 0) {
//                              num.add(Integer.parseInt(num2));
//                              l.add(DrugsRepos.select(drug2));
//                        }
//
//                  }
//                  if (drug3 != null && num3 != null && DrugsRepos.select(drug3) != null) {
//                        if (Integer.parseInt(num3) > 0) {
//                              num.add(Integer.parseInt(num3));
//                              l.add(DrugsRepos.select(drug3));
//                        }
//
//                  }
//                  if (drug4 != null && num4 != null && DrugsRepos.select(drug4) != null) {
//                        if (Integer.parseInt(num4) > 0) {
//                              num.add(Integer.parseInt(num4));
//                              l.add(DrugsRepos.select(drug4));
//                        }
//
//                  }
//                  if (drug5 != null && num5 != null && DrugsRepos.select(drug5) != null) {
//                        if (Integer.parseInt(num5) > 0) {
//                              num.add(Integer.parseInt(num5));
//                              l.add(DrugsRepos.select(drug5));
//                        }
//
//                  }
//                  int billCode = BillCodeStoreRepo.createBill();
//                  if (l.size() == 0) {
//                        response.sendRedirect("MenuController?page=addaccount");
//
//                  } else if (billCode <= 0) {
//
//                        response.sendRedirect("MenuController?page=deleteaccount");
//                  } else {
//
//                        int totalprofits = 0;
//                        int totalnet = 0;
//                        SalesBills salesBills = new SalesBills(billCode, null, null, null, null, null, null, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
//                        salesBills.setBillcode(billCode);
//                        for (int row = 0; row < l.size(); row++) {
//
//                              int profit = l.get(row).getProfit() * num.get(row);
//                              totalprofits += profit;
//                              int net = (l.get(row).getSellingPrice() * num.get(row)) - (num.get(row) * l.get(row).getDiscount());
//                              totalnet += net;
//                              int total = l.get(row).getSellingPrice() * num.get(row);
//                              setSalesBills(salesBills, row, l.get(row).getName(), l.get(row).getDiscount() * num.get(row),
//                                      l.get(row).getExpiry(), net, profit, num.get(row), total, l.get(row).getSellingPrice());
//
//                        }
//                        salesBills.setTotalprofits(totalprofits);
//                        salesBills.setTotalnet(totalnet);
//                        SalesBillsRepo.insert(salesBills);
//                        ArrayList<SalesBills> s = new ArrayList<>();
//                        s.add(salesBills);
//                        DrugsRepos.updateQuantity(s);
//                        BillCodeStoreRepo.updateBillCode(billCode + 1, billCode);
//                        session.setAttribute("ok", 1);
//                        session.setAttribute("code", billCode);
//                        response.sendRedirect("MenuController?page=newsales");
//                  }
//
//            }
//          
//            if (operation.equals("cancel")) {
//                  response.sendRedirect("MenuController?page=newsales");
//            }
//
//      }

      @Override
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
              throws ServletException, IOException {
           // processRequest(request, response);
      }

//      void setSalesBills(SalesBills salesBills, int i, String name, int discount, Date expiry, int net, int profit, int quantity, int total, int unitPrice) {
//
//            if (i == 0) {
//                  salesBills.setDrug1(name);
//                  salesBills.setDiscount1(discount);
//                  salesBills.setExpiry1(expiry);
//                  salesBills.setNet1(net);
//                  salesBills.setProfit1(profit);
//                  salesBills.setQuantity1(quantity);
//                  salesBills.setTotal1(total);
//                  salesBills.setUnitprice1(unitPrice);
//            }
//            if (i == 1) {
//                  salesBills.setDrug2(name);
//                  salesBills.setDiscount2(discount);;
//                  salesBills.setExpiry2(expiry);
//                  salesBills.setNet2(net);
//                  salesBills.setProfit2(profit);
//                  salesBills.setQuantity2(quantity);
//                  salesBills.setTotal2(total);
//                  salesBills.setUnitprice2(unitPrice);
//            }
//            if (i == 2) {
//                  salesBills.setDrug3(name);
//                  salesBills.setDiscount3(discount);;
//                  salesBills.setExpiry3(expiry);
//                  salesBills.setNet3(net);
//                  salesBills.setProfit3(profit);
//                  salesBills.setQuantity3(quantity);
//                  salesBills.setTotal3(total);
//                  salesBills.setUnitprice3(unitPrice);
//            }
//            if (i == 3) {
//                  salesBills.setDrug4(name);
//                  salesBills.setDiscount4(discount);;
//                  salesBills.setExpiry4(expiry);
//                  salesBills.setNet4(net);
//                  salesBills.setProfit4(profit);
//                  salesBills.setQuantity4(quantity);
//                  salesBills.setTotal4(total);
//                  salesBills.setUnitprice4(unitPrice);
//            }
//            if (i == 4) {
//                  salesBills.setDrug5(name);
//                  salesBills.setDiscount5(discount);;
//                  salesBills.setExpiry5(expiry);
//                  salesBills.setNet5(net);
//                  salesBills.setProfit5(profit);
//                  salesBills.setQuantity5(quantity);
//                  salesBills.setTotal5(total);
//                  salesBills.setUnitprice5(unitPrice);
//            }
//
//      }

     

      /**
       * Returns a short description of the servlet.
       *
       * @return a String containing servlet description
       */
      @Override
      public String getServletInfo() {
            return "Short description";
      }// </editor-fold>

}
