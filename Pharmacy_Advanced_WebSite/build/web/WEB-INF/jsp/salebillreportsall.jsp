<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.store.common.beans.SalesBillsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="${pageContext.request.contextPath}/ReportsOperationsController/saleall?page=salebillreportsall" method="POST">
    <table border="1">
        <tbody>
            <tr>
                <td>
                    <input type="submit"  value="Search" />   
                </td>


            </tr>
        </tbody>
    </table>
    <table border="1" width="90%">

       <c:if test="${not empty salebills}"> 
            <c:choose>
                <c:when test="${fn:length(salebills)eq 0}">  
                    <h1>   <c:out value="${'no results'}"/>  </h1>
                </c:when>    
                <c:when test="${fn:length(salebills)gt 0}">  
                    <thead> 
                        <tr>
                            <th>Bill Code</th>
                            <th>Total</th>
                            <th>Profit</th>
                            <th>Date</th>
                        </tr>  
                    </thead>  
                    <tbody>
                        <c:forEach items="${salebills}" var="p" >

                            <tr> 
                                <td> ${p.billcode}  </td>
                                <td>${p.totalnet}  </td> 
                                <td> ${p.totalprofits} </td> 
                                <td> ${p.billdate} </td> 
                            </tr>   
                        </c:forEach>
                    </c:when> 
                </c:choose>
                <c:remove var="salebills"/> 
            </tbody>
        </c:if>    
    </table>


</form>
</body>
</html>
