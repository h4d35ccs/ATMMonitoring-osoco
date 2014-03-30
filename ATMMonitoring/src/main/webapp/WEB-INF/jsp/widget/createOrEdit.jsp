<%@include file="../includes/JspImports.jsp"%>
<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
	<div id="addWidgetPrimary">
		<article>
			<h1><spring:message code="widget.${operationType}.title" /></h1>
			<div class="content graph_content fixed">
				<form id="newWidgetForm" method="post" action="dashboard/save" >
					<widget:widgetFormContent />
				</form>				
			</div><!-- /content -->
		</article>
	</div>
<script type="text/javascript">
function initPageJS() {

}
</script>
