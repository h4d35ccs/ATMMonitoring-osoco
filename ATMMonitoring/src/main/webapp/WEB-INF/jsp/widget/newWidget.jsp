<%@include file="../includes/JspImports.jsp"%>
<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
	<div id="mainWidgets" class="mainWidgets">
		<div id="widgetPrimary">
			<article>
				<h1><spring:message code="widget.create.title" /></h1>
				<div class="content fixed">
					<label>
						<input type="radio" name="creationType" value="dashboard/create" checked="checked">
						<spring:message code="widget.create.new" />
					</label>
					
					<label>
						<input type="radio" name="creationType" value="dashboard/createFromLibrary" >
						<spring:message code="widget.create.from.library" />
					</label>
					
					<div class="botonera">
						<input id="next" type="button" class="btn next" value="Continuar">
					</div>
				</div><!-- /content -->
			</article>
		</div>
	</div>
	<script type="text/javascript">
		$("input#next").click(function() {
			var selectedOption = $("input[type=radio]:checked");
			loadInnerSection("#widgetPrimary",selectedOption.val());
		});
	</script>