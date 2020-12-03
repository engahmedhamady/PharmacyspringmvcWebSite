

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="header.jsp" %>  
<form action="${pageContext.request.contextPath}/OperationsController?page=analysisbillreports&operation=purchasebillcode" method="POST">


    <table  width="90%">

        <tbody>
            <tr>
                <td align="center">From</td>
                <td> <input type="date" id="birthday" name="fromdate"></td>

            </tr>
            <tr>

                <td align="center"> To</td>
                <td> <input type="date" id="birthday" name="todate"></td>    
            </tr>
            <c:if test="${empty analysis}"> 

                <tr>
                    <td align="center">Payment</td>
                    <td><td> </td>
                </tr>
                <tr>
                    <td align="center">Income</td>
                    <td> </td>
                </tr>
                <tr>
                    <td align="center">Profit</td>
                    <td> </td>          
                </tr>
            </c:if>



            <c:if test="${not empty analysis}">  

                <c:choose>
                    <c:when test="${analysis == 'error'}">  

                        <tr>
                            <td align="center">Payment</td>
                            <td><td> </td>
                        </tr>
                        <tr>
                            <td align="center">Income</td>
                            <td> </td>
                        </tr>
                        <tr>
                            <td align="center">Profit</td>
                            <td> </td>          
                        </tr>
                        <tr>
                    <h4>Enter Right Date</h4>           
                    </tr>
                </c:when>    
                <c:otherwise>  
                    <tr>
                        <td align="center">Payment</td>
                        <td>  <c:out value="${payment}"/></td>
                       
                    </tr>
                    <tr>    
                        <td align="center">Income</td>
                        <td> <c:out value="${income}"/>  </td>
                    </tr>
                    <tr>
                        <td align="center">Profit</td>
                        <td>  <c:out value="${profit}"/> </td>
                        <td salalaaalal</td>
                    </tr>   
                </c:otherwise>  

            </c:choose>

            <c:remove var="analysis"/> 
            <c:remove var="profit"/> 
            <c:remove var="income"/> 
            <c:remove var="payment"/> 

        </c:if>  




        <tr>  
            <td align="center"><input type="submit" name="OK" value="OK" /></td>  
        </tr>
        </tbody>
    </table>

</form>

</body>
</html>
