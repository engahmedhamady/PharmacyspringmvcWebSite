<%-- 
    Document   : customers
    Created on : May 12, 2020, 8:34:00 AM
    Author     : ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp" %>  
<div class="site-block-cover-content text-center">
    <form action="${pageContext.request.contextPath}/CustomerOperationsController/customeradd?page=customeradd" method="POST">
        <table border="0" width="40%" cellspacing="5 " >

            <tbody>
                <tr>
                    <td> NAME </td>
                    <td><input type="text" name="name" value=""  /> </td>
                </tr>
                <tr>
                    <td>EMAIL</td>
                    <td> <input type="text" name="email" value="" /></td>
                </tr>
                <tr>
                    <td>PHONE</td>
                    <td> <input type="text" name="phone" value="" /></td>
                </tr>

                <tr>

                    <td colspan="2"  align=" center"> <input type="submit" value="Add" /></td>
                </tr>
            </tbody>
        </table>

    </form>
     <c:if test="${not empty founded}"> 
        <c:choose>
            <c:when test="${founded == 0}">  
                <h1>   <c:out value="${'sorry this username not invalid try with another name'}"/>  </h1>
            </c:when>    
            <c:when test="${founded == 1}">  
                <h1>   <c:out value="${'username is created'}"/>  </h1>
            </c:when> 
        </c:choose>
        <c:remove var="founded"/> 

    </c:if>





</div>
</body>
</html>
