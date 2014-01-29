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
			<c:choose>
				<c:when test="${empty categories}">
					<div class="message">
		            	<p><spring:message code="widget.create.from.library.no.categories"/></p>
		          	</div>
				</c:when>
				<c:otherwise>
					<div class="content graph_content fixed">
						<form method="post" action="dashboard/addFromLibrary" >
							<ul class="category_library">
								<c:forEach var="category" items="${categories}"> 
									<li class="category">
										<label><input type="checkbox" disabled="disabled" name="categoryId" value="${category.id}"> ${category.name} </label>
										
										<ul class="widgets">
											<c:forEach var="widget" items="${category.widgets}"> 
												<li><label>
													<input type="checkbox" name="widgetIds" value="${widget.id}">
													${widget.title}
												</label></li>	
											</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</ul>
							<div class="botonera">
								<input type="submit" class="btn next" value="<spring:message code="widget.create.button.label"/>">
							</div>
						</form>				
					</div><!-- /content -->		
				</c:otherwise>
			</c:choose>
		</article>
	</div>
</div>

<script type="text/javascript">
$(function() {
	var categoryListElement = $("ul.category_library li.category");
	var widgetsByCategory = $("ul.category_library li.category ul");
	
	categoryListElement.click(function(event)  {
		var clickedElement = $(this);
		widgetsByCategory.hide();
		categoryListElement.removeClass('selected');
		
		clickedElement.addClass('selected');
		clickedElement.find("ul.widgets").show();
	});
});	
</script>
</t:osoco-wrapperWoMenu>