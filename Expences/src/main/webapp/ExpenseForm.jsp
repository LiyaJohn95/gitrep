<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My  Expense List Application</title>
</head>
<body>


    <%@include file="header.jsp" %>
   
    <div align="center">
        <c:if test="${expense != null}">
            <form action="updateExpense" method="post">
        </c:if>
        <c:if test="${expense == null}">
            <form action="insertExpense" method="post">
        </c:if>
        <table border="1" cellpadding="4">
            <caption>
                <h2>
                    <c:if test="${expense != null}">
                        Edit Expense
                    </c:if>
                    <c:if test="${expense == null}">
                        Add New Expense
                    </c:if>
                </h2>
            </caption>
                <c:if test="${expense != null}">
                    <input type="hidden" name="sno" value="<c:out value='${expense.sno}' />" />
                </c:if>
            <tr>
                <th>Exp: </th>
                <td>
                    <input type="text" name="exp" size="200"
                            value="<c:out value='${expense.exp}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Purpose: </th>
                <td>
                    <input type="text" name="purpose" size="200"
                            value="<c:out value='${expense.purpose}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Day: </th>
                <td>
                    <input type="text" name="day" size="512"
                            value="<c:out value='${expense.day}' />"
                    />
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="left">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
    
     <%@include file="footer.jsp" %>
     
</body>
</html>