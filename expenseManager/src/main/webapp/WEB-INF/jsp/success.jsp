<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Success Page</title>
</head>
<body>
    <h1> <b>Congratulations!!</b> You have successfully ${action} our application.</h1>
    <b>Go to <a href="${pageContext.request.contextPath}/processSuccessPage?redirectPage=${redirectPage}">${redirectPageName}</a></b>
</body>
</html>
