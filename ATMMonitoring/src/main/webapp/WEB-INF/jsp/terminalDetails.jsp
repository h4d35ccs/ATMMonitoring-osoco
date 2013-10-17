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
								<a href="index.html">inicio</a>
							</li>
							<li>
								<a href="terminales.html">Terminales</a>
							</li>
							<li>Terminal 00:1b:21:01:82:8B</li>
						</ul>
					</nav>
				</div>
				<div class="content">
					<h1>
						<spring:message code="label.terminalDetails"/>
					</h1>
					<div class="action_box data desplegable">
						<h2 class="txt">Detalles del terminal</h2>
						<div class="ocultable">
							<div class="photo">
								<a href="resources/images/terminal_original.jpg">
									<img src="resources/images/terminal.jpg"/>
								</a>
							</div>

							<c:choose>
								<c:when test="${canEdit == true}">
									<form:form method="post" action="terminals/update" commandName="terminal">
										<form:hidden path="id"/>
										<div class="ul_data">
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
														<form:label path="geographicAddress">

															<spring:message code="label.terminal.geographicAddress"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="geographicAddress" maxlength="150"/>
												</li>
												<li>
													<strong>
														<form:label path="address">

															<spring:message code="label.terminal.address"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="address" maxlength="100"/>

													<div class="error-td">
														<form:errors path="address"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="city">

															<spring:message code="label.terminal.city"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="city" maxlength="35"/>

													<div class="error-td">
														<form:errors path="city"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="zipCode">

															<spring:message code="label.terminal.zipCode"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="zipCode" maxlength="15"/>

													<div class="error-td">
														<form:errors path="zipCode"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="area">

															<spring:message code="label.terminal.area"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="area" maxlength="35"/>

													<div class="error-td">
														<form:errors path="area"/>
													</div>
												</li>
												<li>
													<strong>
														<form:label path="country">

															<spring:message code="label.terminal.country"/>

														</form:label>
													</strong>
													<form:input class='form-tf-grey' path="country" maxlength="50"/>

													<div class="error-td">
														<form:errors path="country"/>
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
											</ul>
										</div>
										<div class="botonera">
											<input type="submit" class="btn update" value="<spring:message code="label.terminal.updateTerminal"/>"/>
										</div>
									</form:form>
									<div class="botonera">
										<button class="btn request" onclick="requestSnmpUpdate()">
											<spring:message code="label.terminal.requestSingleSnmpUpdate"/>
										</button>
									</div>
								</c:when>
								<c:otherwise>
									<div class="ul_data">
										<ul>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.serialNumber"/>
													</label>

												</strong>
												<label>${terminal.serialNumber}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.ip"/>
													</label>
												</strong>
												<label>${terminal.ip}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.mac"/>
													</label>
												</strong>
												<label>${terminal.mac}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.terminalType"/>
													</label>
												</strong>
												<label>${terminal.terminalType}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.terminalVendor"/>
													</label>
												</strong>
												<label>${terminal.terminalVendor}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.frontReplenish"/>
													</label>
												</strong>
												<label>${terminal.frontReplenish}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.bank"/>
													</label>
												</strong>
												<label>${terminal.bank}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.branch"/>
													</label>
												</strong>
												<label>${terminal.branch}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.geographicAddress"/>
													</label>
												</strong>
												<label>${terminal.geographicAddress}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.address"/>
													</label>
												</strong>
												<label>${terminal.address}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.city"/>
													</label>
												</strong>
												<label>${terminal.city}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.zipCode"/>
													</label>
												</strong>
												<label>${terminal.zipCode}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.area"/>
													</label>
												</strong>
												<label>${terminal.area}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.country"/>
													</label>
												</strong>
												<label>${terminal.country}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.manufacturingSite"/>
													</label>
												</strong>
												<label>${terminal.manufacturingSite}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.model"/>
													</label>
												</strong>
												<label>${terminal.model}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.productClass"/>
													</label>
												</strong>
												<label>${terminal.productClass}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.productClassDescription"/>
													</label>
												</strong>
												<label>${terminal.productClassDescription}</label>
											</li>
											<li>
												<strong>

													<label>
														<spring:message code="label.terminal.tracerNumber"/>
													</label>

												</strong>
												<label>${terminal.tracerNumber}</label>
											</li>
										</ul>
									</div>
									<!-- //ul-data -->
								</c:otherwise>
							</c:choose>
						</div>
						<!-- // ocultable -->
					</div>
					<!-- // /action_box -->
					<div class="action_box data desplegable">
						<h2 class="txt">Histórico</h2>
						<div class="ocultable">
							<img src="resources/images/historico.png" style="width:100%; margin:1em 0" />
						</div>
					</div>
				</div>

				<div class="box">
					<h2>
						<spring:message code="label.financialDevices"/>
					</h2>
					<div class="margin-box">
						<c:if  test="${empty terminal.financialDevices}">
							<div class="empty-list">
								<spring:message code="label.terminal.noFinancialDevices"/>
							</div>
						</c:if>
						<c:if test="${!empty terminal.financialDevices}">
							<c:choose>
								<c:when  test="${terminal.financialDevices.size() >
									5}">
									<table id="TestChromatable" class="data subform">
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
											</tr>
										</thead>
									</c:when>
									<c:otherwise>
										<table class="data subform">
											<thead>
												<tr>
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

													</th>
												</tr>
											</thead>
										</c:otherwise>
									</c:choose>
									<tbody>
										<c:set var="alt" value="${false}"/>
										<c:forEach items="${terminal.financialDevices}" var="financialDevice">
											<tr <c:if test="${alt}">class="alt"</c:if>
											>
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
													<a href="terminals/xfsComponents/details/${xfsComponent.id}">${xfsComponent.serviceProvider}</a>
													<br></c:forEach>
											</td>
										</tr>
										<c:set var="alt" value="${!alt}"/>
									</c:forEach>
								</tbody>
							</table>
						</c:if>
					</div>
				</div>

				<div class="box">
					<h2>
						<spring:message code="label.hardwareDevices"/>
					</h2>
					<c:if  test="${empty terminal.hardwareDevices}">
						<div class="empty-list">
							<spring:message code="label.terminal.noHwDevices"/>
						</div>
					</c:if>
					<c:if test="${!empty terminal.hardwareDevices}">

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

					</c:if>
				</div>

				<div class="box">
					<h2>
						<spring:message code="label.terminalConfigs"/>
					</h2>
					<div class="margin-box">
						<c:if  test="${empty terminal.configs}">
							<div class="empty-list">
								<spring:message code="label.terminal.noConfigs"/>
							</div>
						</c:if>
						<c:if  test="${!empty terminal.configs}">

							<div class="box">
								<h3>
									<spring:message code="label.currentTerminalConfig"/>
								</h3>
								<div class="margin-box">
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

								<t:listSoftware config="${terminal.currentConfig}"/>
							</div>
						</div>

						<div class="box">
							<h3>
								<spring:message code="label.terminalConfigsHistory"/>
							</h3>
							<div class="margin-box">
								<c:choose>
									<c:when  test="${terminal.configs.size() >
										10}">
										<style type="text/css">
/* define height and width of scrollable area. Add 16px to width for scrollbar          */
div.tableContainerTc {
	height: 287px;
	width: 159px;
}

/* define width of table. IE browsers only                 */
div.tableContainerTc table {
	width: 159px
}

/* define width of table. Add 16px to width for scrollbar.           */
/* All other non-IE browsers.                                        */
html>body div.tableContainerTc table {
	width: 159px;
}

html>body tbody.scrollContentTc {
	height: 261px;
}
</style>
										<div id="tableContainer" class="tableContainer tableContainerTc">
											<table class="data">
												<thead class="fixedHeader"></c:when>
												<c:otherwise>
													<table class="data"></c:otherwise>
												</c:choose>
												<tr>
													<c:choose>
														<c:when  test="${terminal.configs.size() >
															10}">
															<th width="151px"></c:when>
															<c:otherwise>
																<th width="136px"></c:otherwise>
															</c:choose>

															<spring:message code="label.terminalConfig.startDate"/>

														</th>
														<%--Code with support for Terminal Config AUTHORS --%>
														<%-- <th>

														<spring:message code="label.terminalconfig.author"/>

													</th>
													--%>
												</tr>
												<c:if  test="${terminal.configs.size() >10}"></thead>
												<tbody class="scrollContent scrollContentTc"></c:if>
												<c:set var="alt" value="${false}"/>
												<c:forEach items="${terminal.configs}" var="config">
													<tr <c:if test="${alt}">class="alt"</c:if>
													>
													<td width="135px">
														<a href="terminals/swConfigs/details/${config.id}">
															<fmt:formatDate value="${config.startDate}" dateStyle="short" type="both" />
														</a>
													</td>
													<%--Code with support for Terminal Config AUTHORS --%>
													<%-- <c:choose>
													<c:when test="${config.author != null}">
														<td>${config.author.lastname}, ${config.author.firstname}</td>
													</c:when>
													<c:otherwise>
														<td>----</td>
													</c:otherwise>
												</c:choose>
												--%>
											</tr>
											<c:set var="alt" value="${!alt}"/>
										</c:forEach>
										<c:choose>
											<c:when  test="${terminal.configs.size() >10}"></tbody>
										</table>
									</div>
								</c:when>
								<c:otherwise></table>
							</c:otherwise>
						</c:choose>
					</c:if>
				</div>
			</div>
		</div>
	</div>
	<%--Code with support for Terminal Config AUTHORS --%>
	<%-- <h3>Add New Config</h3>
<c:if  test="${!empty softwareList}">
	<form:form method="post" action="terminals/swConfigs/add.html" commandName="newConfig">
		<form:hidden path="terminal.id"/>
		<table>
			<tr>
				<td>
					<form:checkboxes items="${softwareList}" path="software" itemValue="id" itemLabel="nameVersion" delimiter="</td></tr>
					<tr>
						<td>"/></td>
					</tr>
					<tr>
						<td>
							<input type="submit" class="form-submit" value="<spring:message code="label.terminalconfig.addterminalconfig"/>
							"/>
						</td>
					</tr>
				</table>
			</form:form>
		</c:if>
		--%>
		<div class="box">
			<h2>
				<spring:message code="label.softwareAggregates"/>
			</h2>
			<div class="margin-box">
				<c:if  test="${empty terminal.softwareAggregates}">
					<div class="empty-list">
						<spring:message code="label.terminal.noSwAggregates"/>
					</div>
				</c:if>
				<c:if test="${!empty terminal.softwareAggregates}">
					<c:choose>
						<c:when  test="${terminal.softwareAggregates.size() >
							5}">
							<table id="AggregateChromatable" class="data">
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
								<table class="data">
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
				</c:if>
			</div>
		</div>

		<div class="box">
			<h2>
				<spring:message code="label.hotfixes"/>
			</h2>
			<div class="margin-box">
				<c:if  test="${empty terminal.hotfixes}">
					<div class="empty-list">
						<spring:message code="label.terminal.noHotfixes"/>
					</div>
				</c:if>
				<c:if test="${!empty terminal.hotfixes}">
					<c:choose>
						<c:when  test="${terminal.hotfixes.size() >
							5}">
							<table id="HotfixChromatable" class="data">
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
								<table class="data">
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

		<div class="box">
			<h2>
				<spring:message code="label.internetExplorers"/>
			</h2>
			<div class="margin-box">
				<c:if  test="${empty terminal.internetExplorers}">
					<div class="empty-list">
						<spring:message code="label.terminal.noIEs"/>
					</div>
				</c:if>
				<c:if test="${!empty terminal.internetExplorers}">
					<table class="data">
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
</article>
</div>
<!-- /primary -->
<div id="secundary"></div>
<!-- /secundary -->
<!-- /main -->
</div>
<!-- /#main -->
<script type="text/javascript">
	function requestSnmpUpdate() {
			$.blockUI({ 
	            theme:     true, 
	            title:    '<spring:message code="label.terminal.requestSnmpUpdateFrameTitle"/>', 
	            message:  '<p><spring:message code="label.terminal.requestSnmpUpdateFrameMessage"/></p><div id="spinner"',
	            themedCSS: { 
	                width: '275px',
	                height: '150px'
	            }
	        });
			$("#spinner").spin("small");
			window.location.href = "terminals/request/${terminal.id}";
	}
</script>

<script type="text/javascript">
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
</t:osoco-wrapper>