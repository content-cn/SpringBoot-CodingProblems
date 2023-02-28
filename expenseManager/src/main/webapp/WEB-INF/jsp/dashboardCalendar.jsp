<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Dashboard Page</title>
</head>
<body>
	<h2>Dashboard</h2>
	<% if (request.getParameter("error") != null) { %>
		<p style="color:red;">Invalid username</p>
	<% } %>
	<form:form method="get" modelAttribute="users" action="${pageContext.request.contextPath}/processDashboardCalendarPage">
        <label>Filter by:</label>
            <input type="text" name="day" placeholder="Income Day"/>
            <input type="text" name="month" placeholder="Income Month"/>
            <input type="text" name="year" placeholder="Income Year"/>
        <button type="submit" name="submit">Apply Filters</button>
        <button type="submit" name="submit" value="dashboardType">Apply Type Filters</button>
        <table border="1">
            <tr>
                <th>Username</th>
                <th>Nickname</th>
                <th>Email</th>
                <th>Address</th>
                <th>IncomeDescription</th>
                <th>IncomeAmount</th>
                <th>IncomeDate</th>
                <th>IncomeTypes</th>
                <th>ExpenseDescription</th>
                <th>ExpenseAmount</th>
                <th>ExpenseDate</th>
                <th>ExpenseTypes</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <c:forEach var="income" items="${user.incomes}">
                   <tr>
                        <td>${user.username}</td>
                            <td>${user.nickname}</td>
                            <td>${user.email}</td>
                            <td>${user.address}</td>
                            <td>${income.description}</td>
                            <td>${income.amount}</td>
                            <td>${income.date}</td>
                            <td>
                                <c:set var="incomeTypes" value=""/>
                                <c:forEach var="incomeType" items="${income.incomeTypes}">
                                    <c:set var="incomeTypes" value="${incomeType.name}, "/>
                                </c:forEach>
                                ${incomeTypes}
                            </td>
                            <td>${income.expense.description}</td>
                            <td>${income.expense.amount}</td>
                            <td>${income.expense.date}</td>
                             <td>
                                <c:set var="expenseTypes" value=""/>
                                <c:forEach var="expenseType" items="${income.expense.expenseTypes}">
                                <c:set var="expenseTypes" value="${expenseType.name}, "/>
                                </c:forEach>
                                ${expenseTypes}
                             </td>
                  </tr>
                </c:forEach>
            </c:forEach>
        </table>
    </form:form>
	<b></b>
</body>
</html>

