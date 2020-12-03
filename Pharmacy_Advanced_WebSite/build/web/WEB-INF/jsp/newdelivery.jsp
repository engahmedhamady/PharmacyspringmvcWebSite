<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  

<form method="POST" action="${pageContext.request.contextPath}/SalesOperationController?page=newsales&operation=save"  >
    <table border="1">
        <thead>
            <tr>
                <th>Seq</th>
                <th>NAME</th>
                <th>QUANTITY</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>1</td>
                <td><input type="text" name="drug1" value="" /></td>
                <td><input type="number" name="num1" value="" /></td>
            </tr>
            <tr>
                <td>2</td>
                <td><input type="text" name="drug2" value="" /></td>
                <td><input type="number" name="num2" value="" /></td>
            </tr>
            <tr>
                <td>3</td>
                <td><input type="text" name="drug3" value="" /></td>
                <td><input type="number" name="num3" value="" /></td>
            </tr>
            <tr>
                <td>4</td>
                <td><input type="text" name="drug4" value="" /></td>
                <td><input type="number" name="num4" value="" /></td>
            </tr>
            <tr>
                <td>5</td>
                <td><input type="text" name="drug5" value="" /></td>
                <td> <input type="number" name="num5" value="" /></td>
            </tr>
            <tr>
                 <th><a href="SalesOperationController?page=newsales&operation=delivery">Delivery</a></th>
                <th><a href="SalesOperationController?page=newsales&operation=cancel">Cancel</a></th>
             </tr>
            
        </tbody>
    </table>

</form>

 <c:if test="${not empty ok}"> 
            <c:choose>
                 <c:when test="${salebill == '1'}">  
                     <h1>   <c:out value="${sessionScope.code}"/>  </h1>
                </c:when>
                <c:when test="${salebill == '0'}">  
                    <h1> bill added with code =  <c:out value="${'failed added try again'}"/>  </h1>
                </c:when>
               
                </c:choose>
                <c:remove var="ok"/> 
            </tbody>
        </c:if>  






</body>

</html>
