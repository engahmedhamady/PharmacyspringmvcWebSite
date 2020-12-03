<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="${pageContext.request.contextPath}/PurchasesOperationsController/requestadd?page=requestadd" method="POST">

    <table border="0">
        <tbody>

            <tr>
                <td> name </td>
                <td><input type="text" name="name" value=""  /> </td>
            </tr>
            <tr>
                <td>quantity</td>
                <td> <input type="number" name="quantity" value="" /></td>
            </tr>

            <tr>
                <td> type</td>
                 <td>
                     <select name = "selected">

                        <option value = "ointment">ointment</option>
                        <option value = "injection">injection</option>
                        <option value = "capsule">capsule</option>
                    </select>
                 </td>
            </tr>
            <tr>
                <td><input type="submit" value="Add" /></td>

            </tr>
        </tbody>
</form>
 <c:if test="${not empty founded}"> 
            <c:choose>
                 <c:when test="${founded == '1'}">  
                     <h1>   <c:out value="${'drug addded'}"/>  </h1>
                </c:when>
                <c:when test="${founded == '0'}">  
                    <h1> bill added with code =  <c:out value="${'failed operation try again'}"/>  </h1>
                </c:when>
               
                </c:choose>
                <c:remove var="founded"/> 
            </tbody>
        </c:if>  


</body>
</html>
