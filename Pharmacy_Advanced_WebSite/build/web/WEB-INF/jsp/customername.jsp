<%-- 
    Document   : customers
    Created on : May 12, 2020, 8:34:00 AM
    Author     : ahmed
--%>


<%@page import="com.store.common.beans.CustomerBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp" %>  
<form action="${pageContext.request.contextPath}/CustomerOperationsController/customername?page=customername" method="POST">
    <table border="1">
        <tbody>
            <tr>
        <input type="submit"  value="Search" />   
        <input type="text" name="name" value="" />   
        </tr>
        </tbody>
    </table>
    <table border="1" width="90%">
        
          <c:if test="${not empty salebill}"> 
            <c:choose>
                <c:when test="${salebill == 'error'}">  
                    <h1>   <c:out value="${'Enter Right Name'}"/>  </h1>
                </c:when>
                <c:when test="${salebill == 'not'}">  
                    <h1>   <c:out value="${'Not found'}"/>  </h1>
                </c:when>
                <c:when test="${fn:length(salebill)eq 0}">  
                    <h1>   <c:out value="${'no results'}"/>  </h1>
                </c:when>    
                <c:when test="${fn:length(salebill)gt 0}">  
                    <thead>
                        <tr>
                            <th>Name</th> 
                            <th>Email</th>
                            <th>Phone</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <c:forEach items="${salebill}" var="p" >

                            <tr> 
                                <td> ${p.name}  </td>
                                <td>${p.email}  </td> 
                                <td> ${p.phone} </td> 
                            </tr>   
                        </c:forEach>
                    </c:when> 
                </c:choose>
                <c:remove var="salebill"/> 
            </tbody>
        </c:if>


        
    </table>


</form>
</body>
</html>
