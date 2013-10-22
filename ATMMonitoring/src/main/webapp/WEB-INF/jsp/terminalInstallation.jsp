<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapperWoMenu titleCode="label.terminalsManager" section="iframe">
<div id="main">
	<h1>Nueva Instalación</h1>
	<div id="primary" class="w50 left">
		<article>
			<div class="content">
				
				<div class="ul_data edit">
					<ul>
						<li>
							<label for="date">Fecha de alta</label>
							<input id="date" name="date" type="text" value="22/10/2013">
							<div class="error-td"></div>
						</li>
						<li class="td">
							<label for="noff">Numero de oficina</label>
							<input id="noff" name="noff" type="text">
							<button class="btn">Validar</button>
							<div class="">
								La Caixa
								Oficina Avenida de los Andes, 24, 28042
								Madrid - España - Teléfono: 91 440 38 90
								X 40.454932, Y -3.620907
							</div>
							<div class="error-td"></div>
						</li>
						<li> 
							<spring:message code="label.terminal.ip"/>I.P. 
							<input id="ip" name="ip" type="text">
							<div class="error-td">
							</div>
						</li>
						<li>
							<label for="type">Tipo de instalación</label>
							<input id="type" name="type" type="text">
							<div class="error-td"></div>
						</li>
						<li>
							<label for="puesto">Puesto</label>
							<input id="puesto" name="puesto" type="text">
							<div class="error-td"></div>
						</li>
						<li>
							<label for="date_off">Fecha baja</label>
							<input id="date_off" name="date_off" type="text">
							<div class="error-td"></div>
						</li>
						<li>
							<label for="procesado">Procesado</label>
							<input id="procesado" name="procesado" type="text">
							<div class="error-td"></div>
						</li>
						<li>
							<label for="date_off">Acceso al público</label>
							<input type="checkbox"/>
						</li>
					</ul>
				</div>
			</div>
		</article>
	</div>
	<div id="secondary" class="w50 right">
		Secundario
	</div>
</div>
</t:osoco-wrapperWoMenu>