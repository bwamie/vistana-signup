<%@include file="includes/header.jsp"%>

<div class="content">
	<div>${message}</div>
	<div>
		<h2>
			<spring:message code="label.welcome" />
		</h2>
		<div class="h2">This Demo Application has been developed using Spring MVC
			Framework, JQuery, JavaScript, HTML and CSS.</div>
	</div>

	<button id="login-btn">Login</button>
	<button id="signup-btn">Sign Up</button>
	<div id="login-dialog" title="Login Here">
	   <div class="error" id="invalid-username"></div>
		<form:form modelAttribute="newSystemUser" action="login" method="POST">
			<label><spring:message code="label.username" />: </label>
			<input type="text" name="username" id="username">
			<br />
			<input type="button" id="login-submit-btn" value="<spring:message code="label.login" />">
		</form:form>
	</div>
	
	<script>
		$("#login-dialog").dialog({
			autoOpen : false
		});
		$("#login-btn").click(function() {
			$("#login-dialog").dialog("open");
		});
		$("#signup-btn").click(function() {
			window.location = "signup";
		});
		
		$("#login-submit-btn").click(function() {
			loginSubmit();
		});
	</script>
</div>

<%@include file="includes/footer.jsp"%>