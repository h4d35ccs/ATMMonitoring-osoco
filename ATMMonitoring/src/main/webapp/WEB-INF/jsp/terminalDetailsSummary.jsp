<%@taglib prefix="terminal" tagdir="/WEB-INF/tags/terminal/" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<div class="summaryContent">
	${terminals.size() }
	
	
<%-- 	<h1><spring:message code="label.terminal"/> ${terminal.mac}</h1> --%>
<%-- 	<terminal:terminalSummary/> --%>
	
<%-- 	<a class="btn" href="terminals/details/${terminal.id}?dateTime=${queryDate.time}"> --%>
<%-- 		<spring:message code="label.terminal.map.summary.show" /> --%>
<!--  	</a> -->
</div>
