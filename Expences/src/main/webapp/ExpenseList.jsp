<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>My Daily Expense List </title>
</head>
<body>

<%@include file="header.jsp" %>

    <div align="center">
        <table border="0" cellpadding="5">
            <caption><h2>List of Expense</h2></caption>
            <tr>
                <th>SNO</th>
                <th>EXP</th>
                <th>PURPOSE</th>
                <th>DAY</th>
                <th></th>
            </tr>
            <c:forEach var="expense" items="${listExpense}">
                <tr>
                    <td><c:out value="${expense.sno}" /></td>
                    <td><c:out value="${expense.exp}" /></td>
                    <td><c:out value="${expense.purpose}" /></td>
                    <td><c:out value="${expense.day}" /></td>
                    <td>
                        <a href="editExpense?sno=<c:out value='${expense.sno}' />">Edit</a>                       
                        <a href="deleteExpense?sno=<c:out value='${expense.sno}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    
    <%@include file="footer.jsp" %>
  
</body>
</html>