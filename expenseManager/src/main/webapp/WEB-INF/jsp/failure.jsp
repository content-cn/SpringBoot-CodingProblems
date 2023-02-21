<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<title>Failure Page</title>
</head>
<body>
    <h1> <b>Failed to ${action}!!</b> Please fill your form correctly.</h1>
    <b>Go to <a href="${pageContext.request.contextPath}/processSuccessPage?redirectPage=${redirectPage}">${redirectPageName}</a></b>
</body>
</html>
