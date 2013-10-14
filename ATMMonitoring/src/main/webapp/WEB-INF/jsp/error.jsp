<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.error">
	<h1><spring:message code="label.error.errorPageTitle"/></h1>
	<h4><spring:message code="label.error.errorMessage1"/></h4>
	<div class="error-message">${exception.getClass().getCanonicalName()}:{${exception.message}</div>
	<h4><spring:message code="label.error.errorMessage2"/></h4>
	<br><br><br>
	<h4><spring:message code="label.error.completeStackTrace"/></h4>
	<c:forEach items="${exception.stackTrace}" var="element">
	    <c:out value="${element}"/>
	</c:forEach>
</t:wrapper>