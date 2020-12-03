<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="com.store.common.beans.DrugsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file="header.jsp" %>  
<form action="${pageContext.request.contextPath}/DiscountOperationsController/discountname?page=discountname" method="POST">

    <table border="1">
        <tbody>
            <tr>

                <td><input type="submit" value="Search" /></td>
                <td><input type="text" name="name"value="" /></td>
            </tr>
        </tbody>
    </table>
    <table border="1" width="90%">
     <c:if test="${not empty salebill}"> 
            <c:choose>
                <c:when test="${fn:length(salebill)eq 0}">  
                    <h1>   <c:out value="${'no results'}"/>  </h1>
                </c:when>    
                <c:when test="${fn:length(salebill)gt 0}">  
                    <thead> 
                        <tr> 
                            <th>Name</th> 
                            <th>Type</th> 
                            <th>Price</th> 
                            <th>Discount</th>
                        </tr>   
                    </thead> 
                    <tbody>
                        <c:forEach items="${salebill}" var="p" >

                            <tr> 
                                <td> ${p.name}  </td>
                                <td>${p.type}  </td> 
                                <td> ${p.sellingPrice} </td> 
                                <td> ${p.discount} </td> 
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
