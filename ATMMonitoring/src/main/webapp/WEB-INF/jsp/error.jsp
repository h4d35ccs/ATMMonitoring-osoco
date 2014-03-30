<%@include file="includes/JspImports.jsp" %>
<div>
	<div id="error_box">
		<div class="message_box">
			<h1><spring:message code="label.error.errorPageTitle"/></h1>
			<h2><spring:message code="label.error.errorMessage1"/></h2>
			<div class="error">${exception.getClass().getCanonicalName()}:${exception.message}</div>
			<div class="alert"><spring:message code="label.error.errorMessage2"/></div>
		</div>
	</div>
	<div class="action_box">
      <h2><spring:message code="label.error.completeStackTrace"/></h2>
	  <c:forEach items="${exception.stackTrace}" var="element">
		<c:out value="${element}"/></br>
	  </c:forEach>
	</div>
</div>