<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>ExpensePage</title>
</head>
<body>
	<h2>Expense Form</h2>
	<% if (request.getParameter("error") != null) { %>
		<p style="color:red;">Invalid username</p>
	<% } %>
	 <form:form method="get" modelAttribute="expense" action="${pageContext.request.contextPath}/processExpensePage">
            <table>
                <tr>
                    <td>Enter your Amount:</td>
                    <td><form:input path="amount"/></td>
                    <td><form:errors path="amount" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                    <td>Enter your Date:</td>
                    <td><form:input path="date"/></td>
                    <td><form:errors path="date" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                    <td>Enter your Description:</td>
                    <td><form:input path="description"/></td>
                    <td><form:errors path="description" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                    <td>Select a Category:&nbsp;</td>
                    <td>
                    <form:checkbox path="expenseTypes" value="Food" label="Food"/>
                    <form:checkbox path="expenseTypes" value="Education" label="Education"/>
                    <form:checkbox path="expenseTypes" value="Bills" label="Bills"/>
                    <form:checkbox path="expenseTypes" value="Travel" label="Travel"/>
                    <td>
                </tr>
                <tr>
                     <td><form:button path="submit" name="submit">Add Expense</form:button></td>
                </tr>
                <tr>
                   <td><form:button path="submit" name="submit" value="home">Go to Home Page</form:button></td>
                </tr>
            </table>
        </form:form>
	<b></b>
</body>
</html>

