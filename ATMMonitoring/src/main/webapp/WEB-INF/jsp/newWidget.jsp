<%@include file="includes/JspImports.jsp"%>
<div id="newWidgetComponent">
	<div id="primaryNewComponent">
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
				<div class="row">
					<label for="name">Nombre</label>
					<input type="text" id="name">
				</div>
				<h2>Modelo gráfica</h2>
				<div id="inputGraph" class="graph_component">
					<label  class="graph graph_01"><span>Tabla</span><input type="radio" name="graph" class="inputGraph"></label>
					<label  class="graph graph_02"><span>Línea tiempo</span><input type="radio" name="graph" class="inputGraph"></label>
					<label  class="graph graph_03"><span>Circular</span><input type="radio" name="graph" class="inputGraph"></label>
					<label  class="graph graph_04"><span>Barras</span><input type="radio" name="graph" class="inputGraph"></label>
					<label  class="graph graph_05"><span>Geográfico</span><input type="radio" name="graph" class="inputGraph"></label>
				</div>
				<div class="row">
					<label for="apquery">Aplicar Consulta</label><select><option>Seleccionar</option></select>
				</div>
				<div class="row">
					<label for="apquery">Aplicar Metrica</label><select><option>Seleccionar</option></select>

				</div>
				<div class="botonera">
					<input type="button" class="btn next" value="crear componente">
					<input type="button" class="btn cancel" value="Cancelar">
				</div>
			</div><!-- /content -->

		</article>
	</div>
</div>
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
