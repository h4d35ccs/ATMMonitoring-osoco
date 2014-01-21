<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">
<div id="main">
	<div id="primary">
		<article>
			<h1><spring:message code="widget.create.from.library.title" /></h1>
			<div class="content graph_content fixed">
				<form method="post" action="dashboard/addFromLibrary" >
					<c:forEach var="widget" items="${widgets}"> 
						<label> <input type="checkbox" name="widgetIds" value="${widget.id}"> ${widget.title} </label> 
					</c:forEach>
					
					<div class="botonera">
						<input type="submit" class="btn next" value="<spring:message code="widget.create.button.label"/>">
					</div>
				</form>				
			</div><!-- /content -->
		</article>
	</div>
</div>
</t:osoco-wrapperWoMenu>