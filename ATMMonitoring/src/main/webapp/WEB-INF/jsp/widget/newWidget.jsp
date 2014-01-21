<%@taglib tagdir="/WEB-INF/tags/widget/" prefix="widget" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">
<script type="text/javascript">
	$(function() {
		$('.next').click(function() {
			$(this).closest(".content").hide();
			$('.graph_content').show();
		});
		// Cambio de estilo en tipo de grafica nuevo componente
		$(".inputGraph").change(function() { 
	            $(".inputGraph").parent().removeClass("current");
	            $(this).parent().addClass("current");
	    }); 
	});
</script>
<div id="main">
	<div id="primary">
		<article>
			<h1>Nuevo componente</h1>
			<div class="content fixed">
					<label><input type="radio" name="component" checked="checked"> Crear nuevo componente</label>
					<label><input type="radio" name="component"  disabled > Elegir de la biblioteca de componentes</label>
				<div class="botonera">
					<input id="next" type="button" class="btn next" value="Continuar">
					<input type="button" class="btn cancel" value="Cancelar">
				</div>
			</div><!-- /content -->
			
			<div class="content graph_content fixed hide">
				<form id="newWidgetForm" method="post" action="dashboard/save" >
					<widget:widgetFormContent />
				</form>				
			</div><!-- /content -->

		</article>
	</div>
</div>
</t:osoco-wrapperWoMenu>