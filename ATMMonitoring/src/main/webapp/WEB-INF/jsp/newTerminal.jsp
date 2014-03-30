<%@include file="includes/JspImports.jsp"%>
				<div id="header_g">
					<%-- nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
							</li>
							<li>
								<a href="terminals"><spring:message code="breadcrumb.terminals"/></a>
							</li>
							<li><spring:message code="label.terminal.new"/></li>
						</ul>
					</nav> --%>
					<c:set var="navigationBackMain" scope="request" >home,terminals</c:set>
					<c:set var="navigationActual" value="label.terminal.new" scope="request" />
					<jsp:include page="includes/navigation.jsp" />
				</div>
				<div class="content">
					<h1><spring:message code="label.terminal.new"/></h1>
					<div class=" botonera">
						<div class="desplegable button">
							<form method="post" action="terminals/import" enctype="multipart/form-data" >
								<div class="btn txt import content_hide"><spring:message code="label.import.file"/></div>
								<div class="hide collapsible" style="display: none;">
									<input type="file" name="file">
									<div class="botonera"><input type="submit" class="btn" value="<spring:message code="label.upload"/>"></div>
								</div>
							</form>
						</div>
					</div>
					<div class="action_box data">
						<h2><spring:message code="label.terminalDetails"/></h2>
						<form:form method="post" action="terminals/list" commandName="terminal">
						  <div class="collapsible last">
						  	<div class="model">
							<div class="photo">
					    <a id="clickeablePhoto" href="" class="colorbox"> 
							<img id="atmPicture" src="resources/images/ejemplo/no_photo.png" width="300">
							<img id="imgLoader" src="resources/images/icons/icon_loader.gif" style="display:none"  />
							<div class="zoom"></div>
						</a>
				</div>
							<div class="desplegable">
									<div class="txt content_hide"><span><spring:message code="label.moreInfo"/></span></div>
									<dl class="collapsible hide">
										<dt><spring:message code="label.terminalModel.model"/>: </dt>
											<dd id="field_model">${terminal.terminalModel.model}</dd>
										<dt><spring:message code="label.terminalModel.productClass"/>: </dt>
											<dd id="field_product_class">${terminal.terminalModel.productClass}</dd>
										<dt><spring:message code="label.terminalModel.manufacturer"/> : </dt>
											<dd id="field_manufacturer">${terminal.terminalModel.manufacturer}</dd>
										<dt><spring:message code="label.terminalModel.nickname"/>: </dt>
											<dd id="field_nickname">${terminal.terminalModel.nickname}</dd>
										<dt><spring:message code="label.terminalModel.height"/>: </dt>
											<dd id="field_height">${terminal.terminalModel.height}</dd>
										<dt><spring:message code="label.terminalModel.width"/>: </dt>
											<dd id="field_width">${terminal.terminalModel.width}</dd>
										<dt><spring:message code="label.terminalModel.depth"/>: </dt>
											<dd id="field_depth">${terminal.terminalModel.depth}</dd>
										<dt><spring:message code="label.terminalModel.minWeight"/>: </dt>
											<dd id="field_min_weight">${terminal.terminalModel.minWeight}</dd>
										<dt><spring:message code="label.terminalModel.maxWeight"/>: </dt>
											<dd id="field_max_weight">${terminal.terminalModel.maxWeight}</dd>
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


														<form:errors path="mac" element="div" cssClass="error top"/>
														<c:if test="${duplicatedMac == true}">
														   	<div class="error top">
															<spring:message code="label.terminal.duplicatedMac"/>
															</div>
														</c:if>

												</li>
												<li> <strong><form:label path="ip">
															<spring:message code="label.terminal.ip"/>
															*
														</form:label></strong>
													        <form:input class='form-tf-grey' path="ip" maxlength="23"/>

														<form:errors path="ip"  element="div" cssClass="error top"/>
														<c:if test="${duplicatedIp == true}">
														<div class="error top">
															<spring:message code="label.terminal.duplicatedIp"/>
												                </div>
														</c:if>
												</li>
												<li>
													<strong>
														<form:label path="terminalVendor">

															<spring:message code="label.terminal.terminalVendor"/>

														</form:label>
													</strong>
													<form:select id="ManufacturerCombo" path="terminalVendor" onchange="ChangeManufacturer();
													getManufacturerPic('#atmPicture','#'+this.id,'#imgLoader','#clickeablePhoto','resources/images/logo/','resources/images/ejemplo/')">
														<option value=""><spring:message code="label.select.default"/></option>
														<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
														  <c:if test="${key != 'allManufacturers'}">
														  	<option value="${key}"
															  	<c:if test="${key.equals(terminal.terminalVendor)}">
															  		selected="true"
															  	</c:if>
														  	>${key}</option>
														  </c:if>
														</c:forEach>
													</form:select>
												</li>
												<li>
													<strong>
														<form:label path="terminalModel.productClass">

															<spring:message code="label.terminalModel.productClass"/>

														</form:label>
													</strong>
													<form:select id="ModelsCombo" path="terminalModel.id" 
															onchange="ChangeModel('#atmPicture',
																		'GET','resources/images/logo/','resources/images/ejemplo/',
																		'#imgLoader','#clickeablePhoto')">
													  <option value="" ></option>
													  <c:forEach items="${values.get('allManufacturers')}" var="model">
														  	<option value="${model.id}"
															  	<c:if test="${model.productClass.equals(terminal.terminalModel.productClass)}">
															  		selected="true"
															  	</c:if>
														  	>${model.productClass}</option>
														</c:forEach>
						                            </form:select>
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
														<form:label path="serialNumber">

															<spring:message code="label.terminal.serialNumber"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="serialNumber" maxlength="50"/>
													<form:errors path="serialNumber"  element="div" cssClass="error top"/>
													<c:if test="${duplicatedSerialNumber == true}">
														<div class="error top"><spring:message code="label.terminal.duplicatedSerialNumber"/></div>
													</c:if>
												</li>
												<li>
													<strong>
														<form:label path="terminalType">

															<spring:message code="label.terminal.terminalType"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="terminalType" maxlength="50"/>
													<form:errors path="terminalType"  elnement="div" cssClass="error top"/>
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
													<form:errors path="bank"  element="div" cssClass="error top"/>
												</li>
												<li>
													<strong>
														<form:label path="branch">

															<spring:message code="label.terminal.branch"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="branch" maxlength="50"/>
													<form:errors path="branch"  element="div" cssClass="error top"/>
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
														<form:label path="tracerNumber">

															<spring:message code="label.terminal.tracerNumber"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="tracerNumber" maxlength="20"/>

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
															<strong><label for="type"><spring:message code="label.installation.type"/></label></strong>
															<input id="type" name="type" type="text">
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
											<button class="btn save" onclick="loadInnerSectionFromForm('#terminal','#primary'); return false;"><spring:message code="label.terminal.save"/></button>
											<button onclick="loadInnerSection('#primary', 'terminals')" class="btn cancel"><spring:message code="label.cancel"/></button>
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
							'product_class' : '${model.productClass}',
							'manufacturer' : '${model.manufacturer}',
							'nickname' : '${model.nickname}',
							'height' : '${model.height}',
							'width' : '${model.width}',
							'depth' : '${model.depth}',
							'min_weight' : '${model.minWeight}',
							'max_weight' : '${model.maxWeight}'
						},
						 </c:forEach>
						  'photoUrl': ' <%--<ncr:terminalModelPhotoUrl manufacturer="${key}"/>--%>'
	       	 			}${not status1.last ? ',' : ''}
	       		</c:forEach>
	    };

	   function initPageJS() {
	        onLoadModelCB();
	 	 }
    </script>