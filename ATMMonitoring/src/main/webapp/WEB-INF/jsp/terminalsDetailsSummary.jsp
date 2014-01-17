<%@taglib prefix="terminal" tagdir="/WEB-INF/tags/terminal/" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<div class="summaryContent"  style="width:500px">
	<c:if test="${terminals.size() > 1}">
		<h2> ${terminals.size()} <spring:message code="label.terminals"/></h2>
	</c:if> 
	
	<div class="action_box data desplegable">
		<c:forEach items="${terminals}" var="terminal">
			<div class="margin-box">
				<h3 class="txt content_hide"> <spring:message code="label.terminal"/> ${terminal.mac}</h3>
				<div class="margin-box collapsible hide"  class="ul_data ">
					<terminal:terminalSummary/>
					
					<a class="btn" href="terminals/details/${terminal.id}?dateTime=${queryDate.time}">
						<spring:message code="label.terminal.map.summary.show" />
				 	</a>				
				</div>	
			</div>
		</c:forEach>
	</div>
</div>
