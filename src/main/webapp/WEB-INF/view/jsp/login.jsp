<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.welcome" /></title>
</head>
<body>
<div>Language : <a href="?lang=en">English</a>|<a href="?lang=fr">French</a></div>
<p>Welcome Login Here  <a href="signup"><spring:message code="label.signup" /></a>  <a href="index"><spring:message code="label.home" /></a></p>

<div>${message}</div>

<p>
<form:form modelAttribute="newSystemUser" action="login" method="POST">
<label><spring:message code="label.username" />: </label> <input type="text" name="username"> <br />
<input type="submit" value="<spring:message code="label.login" />">
</form:form>
</p>


</body>
</html>