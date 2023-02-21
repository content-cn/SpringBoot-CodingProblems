<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home Page</title>
</head>
<body>
    <h1> Welcome To Expense Manager Application</h1>
	<form method="get" modelAttribute="choice" action="${pageContext.request.contextPath}/processHomePage">
		<label for="username">Are you an Existing User?</label>
		<input type="submit" name="choice" value="Yes">
		<input type="submit" name="choice" value="No">
	</form>
</body>
</html>
