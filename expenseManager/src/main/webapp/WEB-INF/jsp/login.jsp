<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
</head>
<body>
	<h2>Login Form</h2>
	<% if (request.getParameter("error") != null) { %>
		<p style="color:red;">Invalid username</p>
	<% } %>
	 <form:form method="get" modelAttribute="user" action="${pageContext.request.contextPath}/processLoginPage">
            <table>
                <tr>
                    <td>Enter your Username:</td>
                    <td><form:input path="username"/></td>
                    <td><form:errors path="username" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                     <td><form:button path="submit" name="submit">Click here to Submit</form:button></td>
                </tr>
                <tr>
                   <td><form:button path="submit" name="submit" value="register">Go to Register Page</form:button></td>
                </tr>
            </table>
        </form:form>
	<b></b>
</body>
</html>
