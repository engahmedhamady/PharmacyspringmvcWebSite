<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>


<%@page import="com.store.presn.constansApp.Constants"%>
<%@page import="com.store.common.beans.AdminBean"%>
<%@page import="java.util.HashSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.store.presn.constansApp.*"%>
<!DOCTYPE html>

<html lang="en">

    <head>
        <title> <%=   request.getAttribute(Constants.TITLE_ATTRIBUTE)%> </title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Rubik:400,700|Crimson+Text:400,400i" rel="stylesheet">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/fonts/icomoon/style.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/jquery-ui.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/owl.theme.default.min.css">


        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/aos.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/files/css/style.css">

    </head>

    <body>

        <div class="site-wrap">


            <div class="site-navbar py-2">

                <div class="search-wrap">
                    <div class="container">
                        <a href="#" class="search-close js-search-close"><span class="icon-close2"></span></a>
                        <form action="#" method="post">
                            <input type="text" class="form-control" placeholder="Search keyword and hit enter...">
                        </form>
                    </div>
                </div>

                <div class="container">
                    <div class="d-flex align-items-center justify-content-between">
                        <div class="logo">
                            <div class="site-logo">
                                <a href="${pageContext.request.contextPath}/processRequest?page=home" class="js-logo-clone">Ph  ${log.name} </a>

                            </div>
                        </div>
                        <div class="main-nav d-none d-lg-block">
                            <nav class="site-navigation text-right text-md-center" role="navigation">




                                <ul class="site-menu js-clone-nav d-none d-lg-block">
                                    <li class="active" ><a href="${pageContext.request.contextPath}/processRequest?page=home">Home</a></li>






                                    <li class="has-children" >
                                        <a href="#">Sales</a>
                                        <ul class="dropdown">
                                            <li><a  href="${pageContext.request.contextPath}/processRequest?page=newsales">   New Sales      </a>   </li>
                                            <!--                                            <li><a  href="MenuController?page=deliverylist">  Delivery List </a>  </li>-->
                                        </ul>
                                    </li>




                                    <li class="has-children" >
                                        <a href="#">Purchases</a>
                                        <ul class="dropdown">
                                            <li  ><a href="${pageContext.request.contextPath}/processRequest?page=newpurchase">New Bill</a></li>
                                            <li  class="has-children" >

                                                <a href="#">Founded</a>
                                                <ul class="dropdown">
                                                    <li ><a href="${pageContext.request.contextPath}/processRequest?page=foundedall">ALL</a></li>
                                                    <li  ><a href="${pageContext.request.contextPath}/processRequest?page=foundedname">NAME</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=foundedtype">TYPE</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=foundedquantity">QUANTITY</a></li>
                                                    <!--                                                    <li><a href="MenuController?page=foundedexpiry">EXPIRY</a></li>-->
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=foundedprice">PRICE</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=foundedcompany">COMPANY</a></li>
                                                </ul>
                                            </li >
                                            <li  class="has-children" >
                                                <a href="#">Requested</a>
                                                <ul class="dropdown">
                                                    <li  class="has-children"  >
                                                        <a href="#">SEARCH</a>
                                                        <ul class="dropdown">
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/processRequest?page=requestall">ALL</a>
                                                            </li>
                                                            <li>
                                                                <a href="${pageContext.request.contextPath}/processRequest?page=requestname">NAME</a>
                                                            </li >
                                                        </ul>
                                                    </li>             
                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/processRequest?page=requestadd">ADD</a>
                                                    </li> 
                                                </ul>

                                            </li>
                                        </ul>                                                  
                                    </li>

                                    <li  class="has-children" >
                                        <a href="#">Customer</a>
                                        <ul class="dropdown">


                                            <li  class="has-children">
                                                <a href="#">SEARCH</a>
                                                <ul class="dropdown">
                                                    <li >
                                                        <a href="${pageContext.request.contextPath}/processRequest?page=customerall">ALL</a>
                                                    </li>
                                                    <li>
                                                        <a href="${pageContext.request.contextPath}/processRequest?page=customername">NAME</a>
                                                    </li>
                                                </ul>
                                            </li>   

                                            <li>
                                                <a href="${pageContext.request.contextPath}/processRequest?page=customeradd">ADD</a>
                                            </li> 





                                            %>            
                                        </ul>
                                    </li>   




                                    <li class="has-children"  >
                                        <a href="#">Search</a>
                                        <ul class="dropdown">
                                            <li  ><a href="${pageContext.request.contextPath}/processRequest?page=searchall">ALL</a></li>
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=searchname">NAME</a></li>
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=searchtype">TYPE</a></li>
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=searchprice">PRICE</a></li>
                                            <!--                                            <li ><a href="MenuController?page=searchexpiry">EXPIRY</a></li>-->
                                        </ul>
                                    </li>



                                    <li class="has-children" >
                                        <a href="#">Discount</a>
                                        <ul class="dropdown">
                                            <li  ><a href="${pageContext.request.contextPath}/processRequest?page=discountall">ALL</a></li>
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=discountname">NAME</a></li>
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=discounttype">TYPE</a></li>
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=discountprice">PRICE</a></li>
                                            <li  ><a href="${pageContext.request.contextPath}/processRequest?page=discountdiscount">DISCOUNT</a></li>
                                        </ul>
                                    </li >



                                    <li class="has-children" >
                                        <a href="#">Reports</a>
                                        <ul class="dropdown">
                                            <li class="has-children"  >
                                                <a href="#" >Sale Bills By</a>
                                                <ul class="dropdown">
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=salebillreportsall" >All</a></li>
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=salebillreportsbillcode">Bill Code</a></li>
                                                    <!--                                                    <li><a href="MenuController?page=salebillreportsdate">Date</a></li> -->
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=salebillreportstotal" >Total</a></li> 
                                                    <li><a href="${pageContext.request.contextPath}/processRequest?page=salebillreportsprofit" >Profit</a></li>         
                                                </ul>

                                            </li>
                                            <li class="has-children">
                                                <a href="#" >Purchase Bills By</a>
                                                <ul class="dropdown">

                                                    <li ><a href="${pageContext.request.contextPath}/processRequest?page=purchasebillreportsall">All</a></li>
                                                    <li  ><a href="${pageContext.request.contextPath}/processRequest?page=purchasebillreportsbillcode">Bill Code</a></li>
                                                    <!--                                                    <li  ><a href="MenuController?page=purchasebillreportsdate">Date</a></li> -->
                                                    <li ><a href="${pageContext.request.contextPath}/processRequest?page=purchasebillreportstotal">Total</a></li> 

                                                </ul>

                                            </li>
                                            <li><a href="${pageContext.request.contextPath}/processRequest?page=analysisbillreports">Analysis</a></li>                                                
                                        </ul>
                                    </li>

                                    <li class="has-children"  >
                                        <a href="#">Setting</a>
                                        <ul class="dropdown">
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=addaccount">Add Account</a></li>
                                            <li ><a href="${pageContext.request.contextPath}/processRequest?page=deleteaccount">Delete Account</a></li>
                                            <li><a href="${pageContext.request.contextPath}/processRequest?page=editaccount">Change Password</a></li>
                                            <li><a href="${pageContext.request.contextPath}/processRequest?page=viewaccounts">View Accounts</a></li>
                                            <!--                                            <li><a href="MenuController?page=priviliges"> Priviliges </a></li>-->
                                        </ul>
                                    </li>


                                    <li class="active" ><a href="${pageContext.request.contextPath}/processRequest?page=logout">Log Out</a></li>




                                </ul>
                            </nav>
                        </div>

                    </div>
                </div>
            </div>

