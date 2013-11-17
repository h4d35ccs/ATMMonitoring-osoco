<%@taglib uri="http://www.ncr.com/tags" prefix="ncr"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}" section="terminals">

<jsp:attribute name="header">
    <script type="text/javascript">
        $(function() {
            $("#editTerminalButton").click(function(event) {
                $("#showTerminal").hide();
                $("#editForm").show();
	        });
            $("#cancelEdit").click(function(event) {
                $("#showTerminal").show();
                $("#editForm").hide();
	        });

            initTabs();
            onLoadModelCB();
	    });

        function initTabs() {
	        $('#tabs .content_tab').hide(); // cierro todas las capas
	        $('#tabs .content_tab:first').show(); // muestro la primera
	        $('.sub_nav li').removeClass();
	        $('.sub_nav li:first').addClass('current'); // activo el primer tab
	        $('.sub_nav li').click(function(event) {
		        $('.sub_nav li').removeClass(); // borro estilo current de todos los li
		        $(this).addClass('current');
		        var tab_click =  $('.sub_nav li').index(this);
		        $('#tabs .content_tab').hide();
		        $('#tabs').find( ".content_tab" ).eq( tab_click ).show();
            });
            $('a[href*=#]').click(function() {
                if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
                    && location.hostname == this.hostname) {

                    var $target = $(this.hash);
                    $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');
                    if ($target.length) {
                        var targetOffset = $target.offset().top - 70;
                        $('html,body').animate({scrollTop: targetOffset}, 1000);
                    }
                }
            });
        }
    </script>
</jsp:attribute>

<jsp:body>
			<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
							</li>
							<li>
								<a href="terminals"><spring:message code="breadcrumb.terminals"/></a>
							</li>
							<li><spring:message code="label.terminal"/> ${terminal.mac}</li>
						</ul>
					</nav>
				</div>
				<div class="content">
					<h1><spring:message code="label.terminal"/> ${terminal.mac}</h1>
					<c:if test="${success != null}">
					      <div class="notification"><p>${success}</p></div>
					</c:if>

					<c:if test="${errors != null}">
					      <div class="alert"><p><spring:message code="label.error.form"/></p></div>
					</c:if>

					<c:if test="${timeout != null}">
					      <div class="message"><p>${timeout}</p></div>
					</c:if>

					<div class="action_box data desplegable">
						<h2 class="txt last"><spring:message code="label.terminalDetails"/></h2>
						<div class="collapsible last">
							<div class="model">
								<div class="photo">
									<a href='<ncr:terminalModelPhotoUrl atm="${terminal}" />' class="colorbox">
										<img src='<ncr:terminalModelPhotoUrl atm="${terminal}" width="300" />' width="300"/>
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
								<c:if test="${canEdit == true}">
							      <div id="editForm" class="${errors != null ? '': 'hide'}">
									<form:form method="post" action="terminals/update" commandName="terminal">
										<form:hidden path="id"/>
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
													<form:select id="ManufacturerCombo" path="terminalVendor" onchange="ChangeManufacturer()">
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
														<form:label path="productClass">

															<spring:message code="label.terminal.productClass"/>

														</form:label>
													</strong>
													<form:select id="ModelsCombo" path="terminalModel.id" onchange="ChangeModel()">
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
										<div class="botonera">

											<input type="submit" class="btn" value="<spring:message code="label.terminal.updateTerminal"/>"/>
											<a class="btn update" href="terminals/request/${terminal.id}"><spring:message code="label.terminal.requestSingleSnmpUpdate"/></a>

		                                    <input id="cancelEdit" type="reset" class="cancel right" value="<spring:message code="label.cancel"/>" />
										</div>

										</div>
									</form:form>
							            </div>
								</c:if>

									<div id="showTerminal"  class="ul_data ${errors  != null ? 'hide': ''}">
										<ul>
											<li>
												<strong>
													<spring:message code="label.terminal.mac"/>
												</strong>
												${terminal.mac}
											</li>

											<li>
												<strong>
													<spring:message code="label.terminal.ip"/>
												</strong>
												${terminal.ip}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.terminalVendor"/>
												</strong>
												${terminal.terminalVendor}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.productClass"/>
												</strong>
												${terminal.terminalModel.productClass}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.productClassDescription"/>
												</strong>
												${terminal.productClassDescription}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.serialNumber"/>
												</strong>
												${terminal.serialNumber}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.terminalType"/>
												</strong>
												${terminal.terminalType}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.frontReplenish"/>
												</strong>
												${terminal.frontReplenish}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.bank"/>
												</strong>
												${terminal.bank}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.branch"/>
												</strong>
												${terminal.branch}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.manufacturingSite"/>
												</strong>
												${terminal.manufacturingSite}
											</li>
											<li>
												<strong>
													<spring:message code="label.terminal.tracerNumber"/>
												</strong>
												${terminal.tracerNumber}
											</li>
										</ul>

									<c:if test="${canEdit == 'true'}">
										<div class="botonera">
											<button id="editTerminalButton" class="btn">Editar Terminal</button>
											<a class="btn update" href="terminals/request/${terminal.id}"><spring:message code="label.terminal.requestSingleSnmpUpdate"/></a>
										</div>
									</c:if>

									</div>
									<!-- //ul-data -->

						</div>
						<!-- // collapsible -->
					</div>
					<!-- // /action_box -->
					<div class="action_box data desplegable">
						<h2 class="txt content_hide last"><spring:message code="label.terminal.history"/></h2>
						<div class="collapsible last hide">
							<img src="resources/images/ejemplo/historico.png" style="width:100%; margin:1em 0" />
						</div>
					</div>
				</div>
				<h2 id="features">Características</h2>
				<div id="tabs">
					<nav class="sub_nav">
						<ul>
							<li class="current">
							  <a href="${currentUrl}#features"><spring:message code="label.installations"/></a>
							</li>
							<li>
								<a href="${currentUrl}#features"><spring:message code="label.financialDevices"/></a>
							</li>
							<li>
								<a href="${currentUrl}#features"><spring:message code="label.hardwareDevices"/></a>
							</li>
							<li>
								<a href="${currentUrl}#features"><spring:message code="label.software"/></a>
							</li>
							<li>
								<a href="${currentUrl}#features"><spring:message code="label.softwareAggregates"/></a>
							</li>
							<li>
								<a href="${currentUrl}#features"><spring:message code="label.hotfixes"/></a>
							</li>
							<li>
								<a href="${currentUrl}#features"><spring:message code="label.browsers"/></a>
							</li>
						</ul>
					</nav>
					<div class="content_tab">
						<div class="botonera">
							<a href="terminals/installations/new?matricula=${terminal.matricula}" class="btn iframe_m"><spring:message code="label.installation.new"/></a>
						</div>
                                                <c:if test="${terminal.installation != null}">
						<h3><spring:message code="label.installation.current"/></h3>
						<div class="margin-box">
							<table>
								<tr>
									<th><spring:message code="label.location.office"/></th>
									<th><spring:message code="label.location.address"/></th>
									<th><spring:message code="label.creationDate"/></th>
									<th><spring:message code="label.terminal.ip"/></th>
									<th><spring:message code="label.installation.type"/></th>
									<th><spring:message code="label.installation.locationClass"/></th>
									<th><spring:message code="label.location.processed"/></th>
									<th><spring:message code="label.location.publicAccess"/></th>
								</tr>
								<tr>
									<td>${terminal.installation.location.office}</td>
									<td>${terminal.installation.location.completeAddress}</td>
									<td>${terminal.installation.startDate}</td>
									<td>${terminal.installation.ip}</td>
									<td>${terminal.installation.type}</td>
									<c:choose>
										<c:when  test="${(terminal.installation.locationClass != null) && (terminal.installation.locationClass.length() > 0)}">
											<td><spring:message code="label.installation.${terminal.installation.locationClass}"/></td>
										</c:when>
										<c:otherwise>
										<td></td>
										</c:otherwise>
									</c:choose>
									<td>${terminal.installation.processed}</td>
									<td>${terminal.installation.location.publicAccess}</td>
									<td></td>
								</tr>
							</table>
						</div>
						</c:if>

					</div>
					<div class="content_tab">
						<div class="margin-box">
							<c:if  test="${empty terminal.financialDevices}">
								<div class="empty-list message">
									<spring:message code="label.terminal.noFinancialDevices"/>
								</div>
							</c:if>
							<c:if test="${!empty terminal.financialDevices}">
							<div class="margin-box">
								<c:choose>
									<c:when  test="${terminal.financialDevices.size() >
										5}">
										<table id="TestChromatable" class="data subform link">
											<thead>
												<tr>
													<th>

														<spring:message code="label.financialDevice.name"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.majorVersion"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.serialNumber"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.caption"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.description"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.universalId"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.deviceInstance"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.deviceStatus"/>

													</th>
<%--
													<th>

														<spring:message code="label.financialDevice.pmStatus"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.model"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.variant"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.manufacturer"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.firmwareMajorVersion"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.removable"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.replaceable"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.hotSwappable"/>

													</th>
													<th>

														<spring:message code="label.financialDevice.xfsComponents"/>

													</th>

--%>
													<th><div class="add"><span>Ver más información</span></div></th>
												</tr>
											</thead>
										</c:when>
										<c:otherwise>
											<table class="data subform link">
												<thead>
													<tr class="showDetail open">
														<th width="125px">

															<spring:message code="label.financialDevice.name"/>

														</th>
														<th width="80px">

															<spring:message code="label.financialDevice.majorVersion"/>

														</th>
														<th width="55px">

															<spring:message code="label.financialDevice.serialNumber"/>

														</th>
														<th width="40px">

															<spring:message code="label.financialDevice.caption"/>

														</th>
														<th width="55px">

															<spring:message code="label.financialDevice.description"/>

														</th>
														<th width="60px">

															<spring:message code="label.financialDevice.universalId"/>

														</th>
														<th width="40px">

															<spring:message code="label.financialDevice.deviceInstance"/>

														</th>
														<th width="40px">

															<spring:message code="label.financialDevice.deviceStatus"/>

														</th>
														<th width="40px">

															<spring:message code="label.financialDevice.pmStatus"/>

														</th>
<%--
														<th width="45px">

															<spring:message code="label.financialDevice.model"/>

														</th>
														<th width="40px">

															<spring:message code="label.financialDevice.variant"/>

														</th>
														<th width="65px">

															<spring:message code="label.financialDevice.manufacturer"/>

														</th>
														<th width="65px">

															<spring:message code="label.financialDevice.firmwareMajorVersion"/>

														</th>
														<th width="50px">

															<spring:message code="label.financialDevice.removable"/>

														</th>
														<th width="60px">

															<spring:message code="label.financialDevice.replaceable"/>

														</th>
														<th width="50px">

															<spring:message code="label.financialDevice.hotSwappable"/>

														</th>
														<th width="55px">

															<spring:message code="label.financialDevice.xfsComponents"/>

--%>														</th>

														<th><div class="add"><span>Ver más información</span></div></th>
													</tr>
												</thead>
											</c:otherwise>
										</c:choose>
										<tbody>

											<c:forEach items="${terminal.financialDevices}" var="financialDevice">
												<tr class="showdetail open">
												<td>
													<label>${financialDevice.name}</label>
												</td>
												<td>
													<label>${financialDevice.version}</label>
												</td>
												<td>
													<label>${financialDevice.serialNumber}</label>
												</td>
												<td>
													<label>${financialDevice.caption}</label>
												</td>
												<td>
													<label>${financialDevice.description}</label>
												</td>
												<td>
													<label>${financialDevice.universalId}</label>
												</td>
												<td>
													<label>${financialDevice.deviceInstance}</label>
												</td>
												<td>
													<label>${financialDevice.deviceStatus}</label>
												</td>
<%--
												<td>
													<label>${financialDevice.pmStatus}</label>
												</td>
												<td>
													<label>${financialDevice.model}</label>
												</td>
												<td>
													<label>${financialDevice.variant}</label>
												</td>
												<td>
													<label>${financialDevice.manufacturer}</label>
												</td>
												<td>
													<label>${financialDevice.firmwareVersion}</label>
												</td>
												<td>
													<label>${financialDevice.removable}</label>
												</td>
												<td>
													<label>${financialDevice.replaceable}</label>
												</td>
												<td>
													<label>${financialDevice.hotSwappable}</label>
												</td>
												<td>
													<c:forEach items="${financialDevice.xfsComponents}" var="xfsComponent">
														<a class="iframe" href="terminals/xfsComponents/details/${xfsComponent.id}">${xfsComponent.xfsClass}</a>
														</c:forEach>
												</td>
--%>
												<td><div class="add"><span>Ver más información</span></div></td>
											</tr>
											<tr class="detail">
										          <td colspan="9">
										             <ul>
												<li>
												  <strong><spring:message code="label.financialDevice.name"/>:</strong>${financialDevice.name}											 </li>
												<li>
												  <strong><spring:message code="label.financialDevice.majorVersion"/>:</strong>${financialDevice.version}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.serialNumber"/>:</strong>${financialDevice.serialNumber}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.caption"/>:</strong>${financialDevice.caption}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.description"/>:</strong>${financialDevice.description}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.universalId"/>:</strong>${financialDevice.universalId}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.deviceInstance"/>:</strong>${financialDevice.deviceInstance}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.deviceStatus"/>:</strong>${financialDevice.deviceStatus}
												</li>

												<li>
													<strong><spring:message code="label.financialDevice.pmStatus"/>:</strong>${financialDevice.pmStatus}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.model"/>:</strong>${financialDevice.model}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.variant"/>:</strong>${financialDevice.variant}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.manufacturer"/>:</strong>${financialDevice.manufacturer}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.firmwareMajorVersion"/>:</strong>${financialDevice.firmwareVersion}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.removable"/>:</strong>${financialDevice.removable}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.replaceable"/>:</strong>${financialDevice.replaceable}
												</li>
												<li>
													<strong><spring:message code="label.financialDevice.hotSwappable"/>:</strong>${financialDevice.hotSwappable}
												</li>
												<c:if  test="${!empty financialDevice.xfsComponents}">
													<li>
														<strong><spring:message code="label.financialDevice.xfsComponents"/>:</strong>
														<c:forEach items="${financialDevice.xfsComponents}" var="xfsComponent">
															<a class="iframe" href="terminals/xfsComponents/details/${xfsComponent.id}">${xfsComponent.xfsClass}</a>
														</c:forEach>
													</li>
												</c:if>
												<c:if  test="${!empty financialDevice.jxfsComponents}">
													<li>
														<strong><spring:message code="label.financialDevice.jxfsComponents"/>:</strong>
														<c:forEach items="${financialDevice.jxfsComponents}" var="jxfsComponent">
															<a class="iframe" href="terminals/jxfsComponents/details/${jxfsComponent.id}">${jxfsComponent.jxfsClass}</a>
														</c:forEach>
													</li>
												</c:if>
												</ul>
											</td>
											</tr>


										</c:forEach>
									</tbody>
								</table>
								</div><!-- /margin-box -->
							</c:if>
						</div>
					</div>

					<div class="content_tab">
						<c:if  test="${empty terminal.hardwareDevices}">
							<div class="empty-list message">
								<spring:message code="label.terminal.noHwDevices"/>
							</div>
						</c:if>
						<c:if test="${!empty terminal.hardwareDevices}">

                          <div class="action_box data desplegable">

							<div class="margin-box">
								<c:if test="${!empty terminal.computerSystems}">
									<t:computerSystemTable hardwareDevices="${terminal.computerSystems}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.processors}">
									<t:processorTable hardwareDevices="${terminal.processors}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.physicalMemories}">
									<t:physicalMemoryTable hardwareDevices="${terminal.physicalMemories}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.diskDrives}">
									<t:diskDriveTable hardwareDevices="${terminal.diskDrives}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.logicalDisks}">
									<t:logicalDiskTable hardwareDevices="${terminal.logicalDisks}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.baseBoards}">
									<t:baseBoardTable hardwareDevices="${terminal.baseBoards}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.networkAdapters}">
									<t:networkAdapterTable hardwareDevices="${terminal.networkAdapters}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.floppyDrives}">
									<t:floppyDriveTable hardwareDevices="${terminal.floppyDrives}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.cdromDrives}">
									<t:cdromDriveTable hardwareDevices="${terminal.cdromDrives}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.soundDevices}">
									<t:soundDeviceTable hardwareDevices="${terminal.soundDevices}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.usbControllers}">
									<t:usbControllerTable hardwareDevices="${terminal.usbControllers}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.serialPorts}">
									<t:serialPortTable hardwareDevices="${terminal.serialPorts}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.parallelPorts}">
									<t:parallelPortTable hardwareDevices="${terminal.parallelPorts}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.controllers1394}">
									<t:1394ControllerTable hardwareDevices="${terminal.controllers1394}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.scsiControllers}">
									<t:scsiControllerTable hardwareDevices="${terminal.scsiControllers}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.desktopMonitors}">
									<t:desktopMonitorTable hardwareDevices="${terminal.desktopMonitors}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.keyboards}">
									<t:keyboardTable hardwareDevices="${terminal.keyboards}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.pointingDevices}">
									<t:pointingDeviceTable hardwareDevices="${terminal.pointingDevices}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.systemSlots}">
									<t:systemSlotTable hardwareDevices="${terminal.systemSlots}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.bios}">
									<t:biosTable hardwareDevices="${terminal.bios}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.videoControllers}">
									<t:videoControllerTable hardwareDevices="${terminal.videoControllers}"/>
								</c:if>
							</div>

						</div>

                        </div>
						</c:if>
					</div>

					<div class="content_tab">
						<c:if  test="${empty terminal.configs}">
							<div class="empty-list message">
								<spring:message code="label.terminal.noConfigs"/>
							</div>
						</c:if>
						<c:if  test="${!empty terminal.configs}">
                          <div class="action_box data desplegable">
								<h3 class="txt">
									<spring:message code="label.currentTerminalConfig"/>
								</h3>
								<div class="margin-box collapsible">
									<table class="form-disabled">
										<tr>
											<td class="header first-header last-header">

												<label>
													<spring:message code="label.terminalConfig.startDate"/>
												</label>

											</td>
											<td class="first-header last-header">
												<a href="terminals/swConfigs/details/${terminal.currentConfig.id}">
													<fmt:formatDate value="${terminal.currentConfig.startDate}" dateStyle="short" type="both" />
												</a>
											</td>
										</tr>
										<%--Code with support for Terminal Config AUTHORS --%>
										<%-- <c:choose>
										<c:when test="${terminal.currentConfig.author != null}">
											<tr>
												<td>
													<label>

														<spring:message code="label.terminalconfig.author"/>

													</label>
												</td>
												<td>
													<label>
														${terminal.currentConfig.author.lastname}, ${terminal.currentConfig.author.firstname}
													</label>
												</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td>
													<label>

														<spring:message code="label.terminalconfig.author"/>

													</label>
												</td>
												<td>
													<label>----</label>
												</td>
											</tr>
										</c:otherwise>
									</c:choose>
									--%>
								</table>
							</div>

							<t:listSoftware config="${terminal.currentConfig}"/>

						</c:if>

</div>
			</div>
			<div class="content_tab">
					<c:if  test="${empty terminal.softwareAggregates}">
						<div class="empty-list message">
							<spring:message code="label.terminal.noSwAggregates"/>
						</div>
					</c:if>
					<c:if test="${!empty terminal.softwareAggregates}">
					<div class="margin-box">
						<c:choose>
							<c:when  test="${terminal.softwareAggregates.size() >
								5}">
								<table id="AggregateChromatable" class="data link">
									<thead>
										<tr>
											<th>

												<spring:message code="label.softwareAggregate.name"/>
												+
												<spring:message code="label.softwareAggregate.majorVersion"/>

											</th>
											<th>

												<spring:message code="label.softwareAggregate.number"/>

											</th>
											<th>

												<spring:message code="label.softwareAggregate.description"/>

											</th>
											<th>

												<spring:message code="label.softwareAggregate.profile"/>

											</th>
										</tr>
									</thead>
								</c:when>
								<c:otherwise>
									<table class="data link">
										<tr>
											<th>

												<spring:message code="label.softwareAggregate.name"/>
												+
												<spring:message code="label.softwareAggregate.majorVersion"/>

											</th>
											<th>

												<spring:message code="label.softwareAggregate.number"/>

											</th>
											<th>

												<spring:message code="label.softwareAggregate.description"/>

											</th>
											<th>

												<spring:message code="label.softwareAggregate.profile"/>

											</th>
										</tr>
									</c:otherwise>
								</c:choose>
								<c:set var="alt" value="${false}"/>
								<c:forEach items="${terminal.softwareAggregates}" var="softwareAggregate">
									<tr <c:if test="${alt}">class="alt"</c:if>
									>
									<td>${softwareAggregate.nameVersion}</td>
									<td>${softwareAggregate.number}</td>
									<td>${softwareAggregate.description}</td>
									<td>${softwareAggregate.profile}</td>
								</tr>
								<c:set var="alt" value="${!alt}"/>
							</c:forEach>
						</table>
					</div><!-- / margin-box -->
					</c:if>

			</div>

			<div class="content_tab">
				<div class="margin-box">
					<c:if  test="${empty terminal.hotfixes}">
						<div class="empty-list message">
							<spring:message code="label.terminal.noHotfixes"/>
						</div>
					</c:if>
					<c:if test="${!empty terminal.hotfixes}">
						<c:choose>
							<c:when  test="${terminal.hotfixes.size() >
								5}">
								<table id="HotfixChromatable" class="data margin-box link">
									<thead>
										<tr>
											<th>

												<spring:message code="label.hotfix.hotfixId"/>

											</th>
											<th>

												<spring:message code="label.hotfix.description"/>

											</th>
											<th>

												<spring:message code="label.hotfix.number"/>

											</th>
											<th>

												<spring:message code="label.hotfix.installedOn"/>

											</th>
											<th>

												<spring:message code="label.hotfix.fixComments"/>

											</th>
										</tr>
									</thead>
								</c:when>
								<c:otherwise>
									<table class="data link">
										<tr>
											<th>

												<spring:message code="label.hotfix.hotfixId"/>

											</th>
											<th>

												<spring:message code="label.hotfix.description"/>

											</th>
											<th>

												<spring:message code="label.hotfix.number"/>

											</th>
											<th>

												<spring:message code="label.hotfix.installedOn"/>

											</th>
											<th>

												<spring:message code="label.hotfix.fixComments"/>

											</th>
										</tr>
									</c:otherwise>
								</c:choose>
								<c:set var="alt" value="${false}"/>
								<c:forEach items="${terminal.hotfixes}" var="hotfix">
									<tr <c:if test="${alt}">class="alt"</c:if>
									>
									<td>${hotfix.hotfixId}</td>
									<td>${hotfix.description}</td>
									<td>${hotfix.number}</td>
									<td>
										<fmt:formatDate value="${hotfix.installedOn}" dateStyle="short" type="date" />
									</td>
									<td>${hotfix.fixComments}</td>
								</tr>
								<c:set var="alt" value="${!alt}"/>
							</c:forEach>
						</table>
					</c:if>
				</div>
			</div>
			<div class="content_tab">
				<div class="margin-box">
					<c:if  test="${empty terminal.internetExplorers}">
						<div class="empty-list message">
							<spring:message code="label.terminal.noIEs"/>
						</div>
					</c:if>
					<c:if test="${!empty terminal.internetExplorers}">
						<table class="data link">
							<tr>
								<th>

									<spring:message code="label.internetExplorer.majorVersion"/>

								</th>
							</tr>
							<c:set var="alt" value="${false}"/>
							<c:forEach items="${terminal.internetExplorers}" var="internetExplorer">
								<tr <c:if test="${alt}">class="alt"</c:if>
								>
								<td>${internetExplorer.version}</td>
							</tr>
							<c:set var="alt" value="${!alt}"/>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
		<!-- /tabs -->
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
	                'photoUrl': '<ncr:terminalModelPhotoUrl manufacturer="${key}"/>'
	   	 			}${not status1.last ? ',' : ''}
	   		</c:forEach>
	};
	function onLoadModelCB(){
	    	var value = $('#ManufacturerCombo').val();
	    	var $cb = $('#ModelsCombo');
	    	if (value == '') {
	    		$cb.empty();
				$cb.append($('<option selected="selected"></option>'));
	    	} else {
	    		var values = valuesTree[value];
	    		$('#ModelsCombo > option').each(function()
						{
							if (!(($(this).val() in values) || ($(this).val() == ''))) {
								$(this).remove();
							}
						}
	    		);
	    	}
            if (!$cb.val()) {
				var photoUrl = valuesTree[value]['photoUrl'];
				$('.photo a').attr("href", photoUrl);
				$('.photo img').attr("src", photoUrl);
          	}
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
	              if (key != 'photoUrl') {
			          $cb1.append($('<option/>')
				         .attr("value", key).text(values[key]['product_class']));
	              }
			});
			$cb1.prop('disabled', false);
		} else {
			$cb1.prop('disabled', true);
		};
		$('#field_model').text('');
		$('#field_product_class').text('');
		$('#field_manufacturer').text('');
		$('#field_nickname').text('');
		$('#field_width').text('');
		$('#field_height').text('');
		$('#field_depth').text('');
		$('#field_min_weight').text('');
		$('#field_max_weight').text('');
	    var photoUrl;
	    if ($cb2.val()) {
	      photoUrl = valuesTree[$cb2.val()]['photoUrl'];
	    } else {
	      photoUrl = '<ncr:terminalModelPhotoUrl />'
	    }
		$('.photo a').attr("href", photoUrl);
		$('.photo img').attr("src", photoUrl);
	};
	
	function ChangeModel(){
		var $cb1 = $('#ModelsCombo');
		var $cb2 = $('#ManufacturerCombo');
		if (($cb1.val() != '') && ($cb2.val() != '')) {
			var values = valuesTree[$cb2.val()][$cb1.val()];
			$('#field_model').text(values.model);
			$('#field_product_class').text(values.product_class);
			$('#field_manufacturer').text(values.manufacturer);
			$('#field_nickname').text(values.nickname);
			$('#field_width').text(values.width);
			$('#field_height').text(values.height);
			$('#field_depth').text(values.depth);
			$('#field_min_weight').text(values.min_weight);
			$('#field_max_weight').text(values.max_weight);
			$('.photo a').attr("href", 'terminals/models/image/' + $cb1.val());
			$('.photo img').attr("src", 'terminals/models/image/' + $cb1.val() + '?width=200');
		}
	    if (!$cb1.val()) {
	          var photoUrl = valuesTree[$cb2.val()]['photoUrl'];
		      $('.photo a').attr("href", photoUrl);
		      $('.photo img').attr("src", photoUrl);
	    }
	};

	function requestSnmpUpdate() {

			window.location.href = "terminals/request/${terminal.id}";
	}
	
	$(document).ready(function(){
		$("#TestChromatable").chromatable({
				width: "1015px",
				height: "170px",
				scrolling: "yes"
		});

		$("#AggregateChromatable").chromatable({
				width: "800px",
				height: "150px",
				scrolling: "yes"
		});

		$("#HotfixChromatable").chromatable({
				width: "800px",
				height: "150px",
				scrolling: "yes"
		});

	});
    </script>

</jsp:body>

</t:osoco-wrapper>
