<%@include file="includes/header.jsp"%>

<div class="content">
	<div class="signup-box container">
		<div class="h2"><spring:message code="label.signup" />:</div>
		<div>
		<div>${message}</div>
		
		<form:form action="signup" method="POST">
		<div class="error">
		<div>${errorMsg}</div>
		<form:errors path="username" cssClass="error" />
		</div>
			<label><spring:message code="label.username" />: </label> <input type="text" id="username" name="username"> 
			<label><spring:message 	code="label.dob" />: </label> <input type="text" id="dateOfBirth" name="dateOfBirth"> <br /> 
			<input type="submit" value="<spring:message code="label.save" />">
		</form:form>
		
		</div>
	</div>
</div>

<%@include file="includes/footer.jsp"%>