<%@include file="includes/header.jsp"%>

<div class="content">
	<div class="signup-box container">
		<div class="h2"><spring:message code="label.signup" /> Questions for ${systemUser.username}</div> 
	<form action="signup-qns" method="POST">
		<c:forEach var="randomQn" items="${systemUser.securityQuestions}" varStatus="theCount">
			<label>Question ${theCount.count}: </label>			
				<select name="qn${theCount.count}" id="qn${theCount.count}">
				<c:forEach var="qn" items="${allSecurityQuestions}">
					<option value="${qn.key}" <c:if test="${qn.key eq randomQn.key}">selected="selected"</c:if>>${qn.value}</option>
					</c:forEach>
				</select>
				<input type="text" id="ans${theCount.count}" name="ans${theCount.count}" />
		</c:forEach>
		<input type="submit" value="Save">
	</form>
	</div>
</div>

<%@include file="includes/footer.jsp"%>