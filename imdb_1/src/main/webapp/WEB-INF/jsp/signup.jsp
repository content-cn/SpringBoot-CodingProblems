<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<h1>This is the sign-up page</h1>
<form:form action="registerUser" modelAttribute="user">
    User Name:<form:input path="userName" />
    <br />
    <br />

    Email:<form:input path="email" />
    <br />
    <br />

    Password:<form:input path="password" />
    <br />
    <br />
    <input type="submit" />
</form:form>
</html>