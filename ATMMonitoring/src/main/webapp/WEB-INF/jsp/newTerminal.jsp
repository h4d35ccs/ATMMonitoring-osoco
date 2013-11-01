<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>


<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="terminals">
				<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
							</li>
							<li>
								<a href="terminals"><spring:message code="breadcrumb.terminals"/></a>
							</li>
							<li><spring:message code="label.terminal.new"/></li>
						</ul>
					</nav>
				</div>
				<div class="content">
					<h1><spring:message code="label.terminal.new"/></h1>
					<div class=" botonera">
						<div class="desplegable button">
							<div class="btn txt import content_hide"><spring:message code="label.import.file"/></div>
							<div class="hide collapsible" style="display: none;">
								<input type="file">
								<div class="botonera"><input type="button" class="btn" value="<spring:message code="label.upload"/>"></div>
							</div>
						</div>
					</div>
					<div class="action_box data">
						<h2><spring:message code="label.terminalDetails"/></h2>
						<form:form method="post" action="terminals/list" commandName="terminal">
						  <div class="row td">
							<label for="proveedor"><spring:message code="label.manufacturer"/>:</label>
							<select id="ManufacturerCombo" onchange="ChangeManufacturer()"> 
								<option value=""><spring:message code="label.select.default"/></option>
								<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
								  <c:if test="${key != 'allManufacturers'}">
									<option value="${key}">${key}</option>
								  </c:if>
								</c:forEach>
							</select> 
							<label for="modelo"><spring:message code="label.terminal.model"/>:</label> 
							<form:select id="ModelsCombo" path="terminalModel" onchange="ChangeModel()">
							  <option value="" ></option>
                            </form:select>
							
						  </div>
						  <div class="collapsible last">
						  	<div class="model">
							<div class="photo">
								<a href="resources/images/ejemplo/terminal.jpg" class="colorbox">
									<img src="resources/images/ejemplo/terminal.jpg"/>
									<div class="zoom"></div>
								</a>
							</div>
							<div class="desplegable">
									<div class="txt content_hide"><span><spring:message code="label.moreInfo"/></span></div>
									<dl class="collapsible hide">
										<dt><spring:message code="label.name"/>: </dt>
											<dd id="field_model"></dd>
										<dt><spring:message code="label.manufacturer"/> : </dt>
											<dd id="field_manufacturer"></dd>
										<dt>Nickname: </dt>
											<dd id="field_nickname"></dd>
										<dt>Altura (mm): </dt>
											<dd id="field_height"></dd>
										<dt>Ancho (mm): </dt>
											<dd id="field_width"></dd>
										<dt>Profundidad (mm): </dt>
											<dd id="field_depth"></dd>
										<dt>Peso mínimo (kg): </dt>
											<dd id="field_min_weight"></dd>
										<dt>Peso máximo (kg): </dt>
											<dd id="field_max_weight"></dd>
									</dl>
								</div>
							</div>
							
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
							      <form:select class='form-tf-grey' path="bankCompany">
							          <option value="" >Seleccionar</option>
                                				  <c:forEach items="${banksList}" var="bank">
                                    				    <option value="${bank.id}"}>${bank.name}</option>
                                                                 </c:forEach>
                            				      </form:select>
							      <div class="error-td">
								<form:errors path="bankCompany"/>
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
												<!--li>
													<strong>
														<form:label path="model">

															<spring:message code="label.terminal.model"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="model" maxlength="20"/>
													<div class="error-td">
														<form:errors path="model"/>
													</div>
												</li-->
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
														<label><spring:message code="label.installation.create"/></label>
													</strong>
														<input type="checkbox" id="isAgeSelected"/>
												</li>
											</ul>
											<div id="txtAge" style="display:none">
											<h3><spring:message code="label.installation.data"/></h3>
												<div class="ul_data editable">
													<ul>
														<li>
															<strong><label for="date"><spring:message code="label.installation.startDate"/></label></strong>
															<input id="date" name="date" type="text" value="22/10/2013">
															<div class="error-td"></div>
														</li>
														<li class="td">
															<strong><label for="noff"><spring:message code="label.location.office"/></label></strong>
															<div class="row">
																<input id="noff" name="noff" type="text" class="num">
																<button class="btn"><spring:message code="label.validate"/></button>
															</div>
															<div class="message">
																La Caixa
																Oficina Avenida de los Andes, 24, 28042
																Madrid - España - Teléfono: 91 440 38 90
																X 40.454932, Y -3.620907
															</div>
															<div class="error-td"></div>
														</li>
														<li> 
															<strong><label for="ip"><spring:message code="label.location.ip"/></label></strong>
															<input id="ip" name="ip" type="text">
															<div class="error-td">
															</div>
														</li>
														<li>
															<strong><label for="type"><spring:message code="label.installation.type"/></label></strong>
															<input id="type" name="type" type="text">
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="puesto"><spring:message code="label.location.position"/></label></strong>
															<input id="puesto" name="puesto" type="text">
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="date_off"><spring:message code="label.installation.endDate"/></label></strong>
															<input id="date_off" name="date_off" type="text">
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="procesado"><spring:message code="label.location.processed"/></label></strong>
															<input id="procesado" name="procesado" type="text">
															<div class="error-td"></div>
														</li>
														<li>
															<strong><label for="date_off"><spring:message code="label.location.publicAccess"/></label></strong>
															<input type="checkbox">
														</li>
													</ul>
												</div>
											</div>
											
										</div>
										<div class="botonera">
											<input type="submit" class="btn save" value="<spring:message code="label.terminal.save"/>"/>
											<a href="terminals" class="btn cancel"><spring:message code="label.cancel"/></a>
										</div>
									</form:form>
						</div>
						<!-- // collapsible -->
					</div>
					<!-- // /action_box -->
				</div>
				
	</div>
	<script type="text/javascript">
	    var valuesTree = {
	        	<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
	        		<c:set var="value" value="${values.get(key)}"/>
	       	 '${key}': {
					<c:forEach items="${value}" var="model" varStatus="status2">
						'${model.id}': {
							'model' : '${model.model}',
							'manufacturer' : '${model.manufacturer}',
							'nickname' : '${model.nickname}',
							'height' : '${model.height}',
							'width' : '${model.width}',
							'depth' : '${model.depth}',
							'min_weight' : '${model.minWeight}',
							'max_weight' : '${model.maxWeight}'
						}${not status2.last ? ',' : ''}
					</c:forEach>
	       	 			}${not status1.last ? ',' : ''}
	       		</c:forEach>
	    };
	    function ChangeManufacturer(){
			var $cb1 = $('#ModelsCombo');
			var $cb2 = $('#ManufacturerCombo');
			$cb1.empty();
			$cb1.append($('<option selected="selected"></option>'));
			if ($cb2.val() != '') {
				var values = valuesTree[$cb2.val()];
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
					  $cb1.append($('<option/>')
					     .attr("value", key).text(values[key]['model']));
				});
				$cb1.prop('disabled', false);
			} else {
				$cb1.prop('disabled', true);
			};
			$('#field_model').text('');
			$('#field_manufacturer').text('');
			$('#field_nickname').text('');
			$('#field_width').text('');
			$('#field_height').text('');
			$('#field_depth').text('');
			$('#field_min_weight').text('');
			$('#field_max_weight').text('');
			$('.photo a').attr("href", '');
			$('.photo img').attr("src", '');
	    };
	    function ChangeModel(){
			var $cb1 = $('#ModelsCombo');
			var $cb2 = $('#ManufacturerCombo');
			if (($cb1.val() != '') && ($cb2.val() != '')) {
				var values = valuesTree[$cb2.val()][$cb1.val()];
				$('#field_model').text(values.model);
				$('#field_manufacturer').text(values.manufacturer);
				$('#field_nickname').text(values.nickname);
				$('#field_width').text(values.width);
				$('#field_height').text(values.height);
				$('#field_depth').text(values.depth);
				$('#field_min_weight').text(values.min_weight);
				$('#field_max_weight').text(values.max_weight);
				$('.photo a').attr("href", 'terminals/models/image/' + $cb1.val());
				$('.photo img').attr("src", 'terminals/models/image/' + $cb1.val());
			};
	    };
    </script>

</t:osoco-wrapper>
