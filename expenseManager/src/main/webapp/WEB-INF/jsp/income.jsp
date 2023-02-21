<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>IncomePage</title>
</head>
<body>
	<h2>Income Form</h2>
	<% if (request.getParameter("error") != null) { %>
		<p style="color:red;">Invalid username</p>
	<% } %>
	 <form:form method="get" modelAttribute="income" action="${pageContext.request.contextPath}/processIncomePage">
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
                    <form:checkbox path="incomeTypes" value="Salary" label="Salary"/>
                    <form:checkbox path="incomeTypes" value="Bonus" label="Bonus"/>
                    <form:checkbox path="incomeTypes" value="Consultancy" label="Consultancy"/>
                    <td>
                </tr>
                <tr>
                     <td><form:button path="submit" name="submit">Add Income</form:button></td>
                </tr>
                <tr>
                   <td><form:button path="submit" name="submit" value="expense">Go to Expense Page</form:button></td>
                </tr>
            </table>
        </form:form>
	<b></b>
</body>
</html>

