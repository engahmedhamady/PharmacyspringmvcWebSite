<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form method="POST" action="${pageContext.request.contextPath}/SettingOperationsController/viewaccounts?page=viewaccounts">
    <input type="submit" value="View" />

    <table border="1" width="90%">



      <c:if test="${not empty accounts}"> 
            <c:choose>
                <c:when test="${fn:length(accounts)eq 0}">  
                    <h1>   <c:out value="${'no results'}"/>  </h1>
                </c:when>    
                <c:when test="${fn:length(accounts)gt 0}">  
                    <thead>
                        <tr> 
                            <th>User Name</th> 
                        </tr>   
                    </thead>  
                    <tbody>
                        <c:forEach items="${accounts}" var="p" >

                            <tr> 
                                <td> ${p.name}  </td>
                               
                            </tr>   
                        </c:forEach>
                    </c:when> 
                </c:choose>
                <c:remove var="accounts"/> 
            </tbody>
        </c:if>    


    </table>
</form>
</body>
</html>
