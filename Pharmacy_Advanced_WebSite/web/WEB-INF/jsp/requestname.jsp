<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="com.store.common.beans.LostDrugsBean"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <%@ include file="header.jsp" %>  
          <form action="${pageContext.request.contextPath}/PurchasesOperationsController/requestname?page=requestname" method="POST">
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
                           <th>Type</th> 
                           <th>Quantity</th> 
                       </tr>  
                    
                    </thead>  
                    <tbody>
                        <c:forEach items="${salebill}" var="p" >

                            <tr> 
                                <td> ${p.drugname}  </td>
                                <td>${p.drugtype}  </td> 
                                <td> ${p.quantitydrug} </td> 
                           
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
