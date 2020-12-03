

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

          <%@ include file="header.jsp" %>  
        <div class="site-block-cover-content text-center">
               <form action="${pageContext.request.contextPath}/SettingOperationsController/deleteaccount?page=deleteaccount" method="POST">
            <table border="0" width="40%" cellspacing="5 " >

                <tbody>
                    <tr>
                        <td> user name </td>
                        <td><input type="text" name="name" value=""  /> </td>
                    </tr>
                    <tr>
                        <td>password</td>
                        <td> <input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>

                        <td colspan="2"  align=" center"> <input type="submit" value="Delete" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
             
            </div>
            
            
            
        <c:if test="${not empty deleted}">  

        <c:choose>
            <c:when test="${deleted == 0}">  

                <h1>   <c:out value="${'sorry this username not valid'}"/>  </h1>
            </c:when>    
            <c:when test="${deleted == 1}">  

                <h1>   <c:out value="${'account is deleted'}"/>  </h1>
            </c:when> 

        </c:choose>

        <c:remove var="deleted"/> 
    </c:if>   
    </body>
</html>
