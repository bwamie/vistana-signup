<%@include file="includes/header.jsp"%>

<div class="content">
	<div class="signup-box container">
		<div class="h2"><spring:message code="label.login" /> Questions for ${systemUser.username}</div> 
	<form action="login-qns" method="POST">
		<c:forEach var="randomQn" items="${systemUser.securityQuestions}" varStatus="theCount">
			<label>Question ${theCount.count}: ${randomQn.value.question}</label>
				<input type="text" id="ans${randomQn.key}" name="ans${randomQn.key}" />
				<br />
			<br />
		</c:forEach>
		<input type="hidden" name="username" value="${username}" />
		<input type="submit" value="SignOn">
	</form>
	</div>
</div>

<%@include file="includes/footer.jsp"%>