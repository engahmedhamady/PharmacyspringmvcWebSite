<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

          <%@ include file="header.jsp" %>  
        <div class="site-block-cover-content text-center">
               <form action="${pageContext.request.contextPath}/SettingOperationsController/editaccount?page=editaccount" method="POST">
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
                        <td>password</td>
                        <td> <input type="password" name="newPassword" value="" /></td>
                    </tr>
                    <tr>

                        <td colspan="2"  align=" center"> <input type="submit" value="Change" /></td>
                    </tr>
                </tbody>
            </table>

        </form>
             
            </div>
           <c:if test="${not empty edited}">  

        <c:choose>
            <c:when test="${edited == 0}">  

                <h1>   <c:out value="${'sorry this username not valid'}"/>  </h1>
            </c:when>    
            <c:when test="${edited == 1}">  

                <h1>   <c:out value="${'password is updated'}"/>  </h1>
            </c:when> 

        </c:choose>

        <c:remove var="edited"/> 
    </c:if>   
               
               
    </body>
</html>
