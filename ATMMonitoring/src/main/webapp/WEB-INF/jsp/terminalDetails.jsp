<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>


<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="terminals">
	<div id="main">
		<div id="primary">
			<article>
				<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard">inicio</a>
							</li>
							<li>
								<a href="terminals">Terminales</a>
							</li>
							<li>Nuevo terminal</li>
						</ul>
					</nav>
				</div>
				<div class="content">
					<h1>Nuevo Terminal</h1>
					<div class="desplegable botonera">
						<div class="btn txt import content_hide">Guardar consulta</div>
						<div class="hide collapsible" style="display: none;">
							<ul>
								<li><label for="namequery">Nombre</label> <input type="text"></li>
								<li><label for="descriptionquery">Descripción</label> <textarea></textarea></li>
							</ul>
							<div class="botonera"><input type="submit" value="Guardar" class="save"></div>
						</div>
					</div>
					<div class="action_box data">
						<h2><spring:message code="label.terminalDetails"/></h2>
						<div class="row td">
							<label for="proveedor">Proveedor:</label><select> <option value>Seleccionar</option></select> <label for="modelo">Modelo ATM:</label> <select> <option value>Seleccionar</option></select>
						</div>
						<div class="collapsible last">
							<div class="photo">
								<img src="resources/images/terminal.jpg"/>
								<div class="desplegable">
									<div class="txt content_hide plus"><span>Más información</span></div>
									<dl class="collapsible hide">
										<dt>Nombre: </dt>
											<dd>campo</dd>
										<dt>Nombre de campo: </dt>
											<dd>campo</dd>
										<dt>Campo: </dt>
											<dd>campo</dd>
										<dt>Nombre de campo: </dt>
											<dd>Lorem ipsum dolor sit amet, consectetur adipisicing elit. </dd>
										<dt>Nombre de campo: </dt>
											<dd>campo</dd>
										<dt>Nombre de campo: </dt>
											<dd>campo</dd>
									</dl>
								</div>
							</div>

							
									<form:form method="post" action="terminals/update" commandName="terminal">
										<form:hidden path="id"/>
										<div class="ul_data editable">
											<ul>
												<li> <strong><form:label path="mac">
															<spring:message code="label.terminal.mac"/>
															*
														</form:label></strong> 

													<form:input class='form-tf-grey' path="mac" maxlength="17"/>

													<div class="error-td">
														<form:errors path="mac"/>
														<c:if test="${duplicatedMac == true}">
															<spring:message code="label.terminal.duplicatedMac"/>
														</c:if>
													</div>
												</li>
												<li> <strong><form:label path="ip">
															<spring:message code="label.terminal.ip"/>
															*
														</form:label></strong> 
													<form:input class='form-tf-grey' path="ip" maxlength="23"/>
													<div class="error-td">
														<form:errors path="ip"/>
														<c:if test="${duplicatedIp == true}">
															<spring:message code="label.terminal.duplicatedIp"/>
														</c:if>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="serialNumber">

															<spring:message code="label.terminal.serialNumber"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="serialNumber" maxlength="50"/>

													<div class="error-td">
														<form:errors path="serialNumber"/>
														<c:if test="${duplicatedSerialNumber == true}">
															<spring:message code="label.terminal.duplicatedSerialNumber"/>
														</c:if>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="terminalType">

															<spring:message code="label.terminal.terminalType"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="terminalType" maxlength="50"/>

													<div class="error-td">
														<form:errors path="terminalType"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="terminalVendor">

															<spring:message code="label.terminal.terminalVendor"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="terminalVendor" maxlength="50"/>

													<div class="error-td">
														<form:errors path="terminalVendor"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="frontReplenish">

															<spring:message code="label.terminal.frontReplenish"/>

														</form:label>
													</strong>
													<form:checkbox path="frontReplenish"/>

												</li>
												<li>
													<strong>
														<form:label path="bank">

															<spring:message code="label.terminal.bank"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="bank" maxlength="50"/>

													<div class="error-td">
														<form:errors path="bank"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="branch">

															<spring:message code="label.terminal.branch"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="branch" maxlength="50"/>

													<div class="error-td">
														<form:errors path="branch"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="manufacturingSite">

															<spring:message code="label.terminal.manufacturingSite"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="manufacturingSite" maxlength="20"/>
												</li>
												<li>
													<strong>
														<form:label path="model">

															<spring:message code="label.terminal.model"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="model" maxlength="20"/>
													<div class="error-td">
														<form:errors path="model"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="productClass">

															<spring:message code="label.terminal.productClass"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="productClass" maxlength="20"/>
													<div class="error-td">
														<form:errors path="productClass"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="productClassDescription">

															<spring:message code="label.terminal.productClassDescription"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="productClassDescription" maxlength="120"/>

												</li>
												<li>
													<strong>
														<form:label path="tracerNumber">

															<spring:message code="label.terminal.tracerNumber"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="tracerNumber" maxlength="20"/>

												</li>
												<li>
													<strong>
														<label>Crear instalación</label>
													</strong>
														<input type="checkbox" id="isAgeSelected"/>
														<div id="txtAge" style="display:none">
															<h3>Datos de la instalación</h3>
														</div>
												</li>
											</ul>
											
										</div>
										<div class="botonera">
											<input type="submit" class="btn save" value="Guardar terminal"/>
										</div>
									</form:form>
						</div>
						<!-- // collapsible -->
					</div>
					<!-- // /action_box -->
				</div>
				
	</div>
</article>
</div>
<!-- /main -->
</div>
<!-- /#main -->
</t:osoco-wrapper>