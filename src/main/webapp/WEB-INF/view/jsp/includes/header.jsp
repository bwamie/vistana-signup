<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><spring:message code="label.welcome" /></title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="<c:url value="/resources/js/main.js" />"></script>

</head>
<body>
	<div class="main">
		<div class="header">
			<div class="top-heading">
				<div class="left">
					<h1>Vistana: Sign Up Demo</h1>
				</div>
				<div class="right">
					Language : <a href="?lang=en">English</a>|<a href="?lang=fr">French</a>
				</div>
				<div class="clear"></div>
			</div>

			<div class="nav">
				<a href="/vistana-signup"><spring:message code="label.home" /> </a> | 
				<c:if test="${LOGGEDIN eq true}">
				<a	href="logout"><spring:message code="label.logout" /></a> |
				</c:if>
				<c:if test="${LOGGEDIN ne true}">
					<a href="#"><spring:message code="label.login" /> </a>  | 
					<a href="signup"><spring:message code="label.signup" /></a> 
					</c:if>
			</div>

		</div>
		<div class="full">
			<hr />
		</div>