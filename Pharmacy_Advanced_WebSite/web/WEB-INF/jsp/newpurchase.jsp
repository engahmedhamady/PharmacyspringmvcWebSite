<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>  
<form action="${pageContext.request.contextPath}/PurchasesOperationsController/save?page=newpurchase" method="POST">

    
    <table border="1" width="90%">

    <tbody>
        <tr>
            <td align="center">Bar Code</td>
            <td><input type="text" name="barcode" value="" /></td>
            <td align="center"> Name</td>
            <td><input type="text" name="name" value="" /></td>
            <td align="center">Type</td>
            <td>
                <select name = "type">

                    <option value = "ointment">ointment</option>
                    <option value = "injection">injection</option>
                    <option value = "capsule">capsule</option>
                </select>
            </td>        
        </tr>
        <tr>
            <td align="center">Purchase Price</td>
            <td><INPUT TYPE="NUMBER" name="purchase"MIN="0" MAX="10" STEP="2" VALUE="6" SIZE="6"> </td>
            <td align="center">Sell Price</td>
            <td><INPUT TYPE="NUMBER" name="sell"MIN="0" MAX="10" STEP="2" VALUE="6" SIZE="6"> </td>
            <td align="center">Discount</td>
            <td><INPUT TYPE="NUMBER" name="discount"MIN="0" MAX="10" STEP="2" VALUE="6" SIZE="6"> </td>
        </tr>
        <tr>
            <td align="center">Quantity</td>
            <td><INPUT TYPE="NUMBER"name="quantity" MIN="0" MAX="10" STEP="2" VALUE="6" SIZE="6"> </td>
           
            <td align="center">Company</td>
            <td><input type="text" name="company" value="" /></td>
        </tr>
        <tr>
            <th><input type="submit" value="Save" /></th>
        </tr>
          
    </tbody>
</table>
    
    
</form>

</body>
</html>
