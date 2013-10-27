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
		
	});
</script>
<div id="main">
	<div id="primary">
		<article>
			<h1>Nuevo componente</h1>
			<div class="content fixed">
					<label><input type="radio" name="component" checked="checked"> Crear nuevo componente</label>
					<label><input type="radio" name="component"  disabled > Elegir de la bibliotecaq de componentes</label>
				<div class="botonera">
					<input id="next" type="button" class="btn next" value="Continuar">
					<input type="button" class="btn cancel" value="Cancelar">
				</div>
			</div><!-- /content -->
			<div class="content graph_content fixed hide">
				<div class="row">
					<label for="name">Nombre componente</label>
					<input type="text" id="name">
				</div>
				<h2>Modelo gráfica</h2>
				<div class="graph_component">
					<label  class="graph_01"><span>Tabla</span><input type="radio" name="graph"></label>
					<label  class="graph_02"><span>Línea tiempo</span><input type="radio" name="graph"></label>
					<label  class="graph_03"><span>Circular</span><input type="radio" name="graph"></label>
					<label  class="graph_04"><span>Barras</span><input type="radio" name="graph"></label>
					<label  class="graph_05"><span>Geográfico</span><input type="radio" name="graph"></label>
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
</t:osoco-wrapperWoMenu>