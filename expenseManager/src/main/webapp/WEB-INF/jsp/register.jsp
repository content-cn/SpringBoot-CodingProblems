<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Registration Page</title>
</head>
<body>
	<h2>Registration Form</h2>
	<% if (request.getParameter("error") != null) { %>
		<p style="color:red;">Invalid username</p>
	<% } %>
	 <form:form method="get" modelAttribute="user" action="${pageContext.request.contextPath}/processRegisterPage">
            <table>
                <tr>
                    <td>Enter your Username:</td>
                    <td><form:input path="username"/></td>
                    <td><form:errors path="username" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                    <td>Enter your Nickname:</td>
                    <td><form:input path="nickname"/></td>
                    <td><form:errors path="nickname" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                    <td>Enter your Email:</td>
                    <td><form:input path="email"/></td>
                    <td><form:errors path="email" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                    <td>Enter your Address:</td>
                    <td><form:input path="address"/></td>
                    <td><form:errors path="address" cssStyle="color: #ff0000;" /></td>
                </tr>
                <tr>
                     <td><form:button path="submit" name="submit">Click here to Submit</form:button></td>
                </tr>
                <tr>
                   <td><form:button path="submit" name="submit" value="login">Go to Login Page</form:button></td>
                </tr>
            </table>
        </form:form>
	<b></b>
</body>
</html>
