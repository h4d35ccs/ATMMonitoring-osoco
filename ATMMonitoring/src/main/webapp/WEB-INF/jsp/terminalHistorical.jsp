<%@include file="includes/JspImports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="${base}"/>
<%@include file="includes/cssImports.jsp" %>
<%@include file="includes/jqueryImports.jsp" %>
<script type='text/javascript' src="resources/js/application.js"></script>
<script type='text/javascript' src="resources/js/jquery.floatThead.min.js"></script>
<style>
/* removes the green bar in the body*/
	body {
	background-image:none;
	background-color:#FFFFFF;
}
#main{
  padding: 0px 0px; */
  border-top:none; 
  margin-left: 0px; */
  background: white;
  position: relative;
  display: block; */
  border-style:none;
  border-width:0px; */
  border-color:none; */
}

.wrapperFloatThead {
    width:100%;
    height: 400px;
    overflow-x:auto;
    overflow-y:auto;
}

.floatThead {
    width:100%;
}

.myTable thead {
    width:100%;
}

</style>
</head>
<body>
<div id="main" class="btn_close">
<div id="primary">
<div class="content">
<div class="botonera">
	<a  class="timelineZoom on" data-zoom-in="true"  >  </a>
	<a class="timelineZoom off" data-zoom-in="false" >  </a>
</div>
<div class="history_legend">
	<div id="timeline" style="height:120px"> </div>
	<ul class="legend">
		<c:forEach items="${historicalChanges}" var="changesByType">
		    <li class="showVertical"><c:set var="changeName" value="${changesByType.key.simpleName}"> </c:set>
		    <img src="<c:url value="/resources/timeline/api/images/${changeName}.png" />" />
		    <spring:message code="label.historical.${changeName}"/></li>
		</c:forEach>	
		<li class="showVertical">
		    <img src="<c:url value="/resources/timeline/api/images/Current.png" />" />
		    <spring:message code="label.historical.Current"/>
		</li>
		<li class="showVertical">
		    <img src="<c:url value="/resources/timeline/api/images/Cluster.png" />" />
		    <spring:message code="label.historical.Cluster"/>
		</li>
	</ul>
</div>
<div>
</div>
<h2 id="features">Características 
				<c:if test="${date != null}">
                	 <spring:message code="label.terminal.forDate" />    
                     <fmt:formatDate value="${date}" pattern="dd/MM/yyyy HH:mm:ss" />   
                    
                </c:if>
           </h2>
				<div id="tabs">
					<nav class="sub_nav">
						<ul>
							<li class="current">
							  <a class="Installation" href="${currentUrl}#features" onclick="parent.autoResize('historicalDetails',555,jQuery.browser.mobile);"><spring:message code="label.installations"/></a>
							</li>
							<li>
								<a class="FinancialDevice" href="${currentUrl}#features" onclick="parent.autoResize('historicalDetails',1000,jQuery.browser.mobile)"><spring:message code="label.financialDevices"/></a>
							</li>
							<li>
								<a class="HardwareDevice" href="${currentUrl}#features" onclick="parent.autoResize('historicalDetails',8000,jQuery.browser.mobile)"><spring:message code="label.hardwareDevices"/></a>
							</li>
							<li>
								<a class="TerminalConfig" href="${currentUrl}#features" onclick="parent.autoResize('historicalDetails',555,jQuery.browser.mobile)"><spring:message code="label.software"/></a>
							</li>
							<li>
								<a class="SoftwareAggregate" href="${currentUrl}#features" onclick="parent.autoResize('historicalDetails',700,jQuery.browser.mobile)"><spring:message code="label.softwareAggregates"/></a>
							</li>
							<li>
								<a class="Hotfix" href="${currentUrl}#features" onclick="parent.autoResize('historicalDetails',700,jQuery.browser.mobile)"><spring:message code="label.hotfixes"/></a>
							</li>
							<li>
								<a class="AuditableInternetExplorer" href="${currentUrl}#features" onclick="parent.autoResize('historicalDetails',700,jQuery.browser.mobile)"><spring:message code="label.browsers"/></a>
							</li>
						</ul>
					</nav>
					<div class="content_tab">
						<div class="botonera">
							<a href="terminals/installations/new?matricula=${terminal.matricula}" class="btn iframe_m"><spring:message code="label.installation.new"/></a>
						</div>
                        
                        <c:set var="currentInstallationActiveByDate" value="${terminal.getCurrentInstallationByDate(date)}" />
                        <c:if test="${empty currentInstallationActiveByDate}">
                        	<div class="empty-list message">
								<spring:message code="label.terminal.noInstallations"/>
							</div>
                        </c:if>
                        <c:if test="${!empty currentInstallationActiveByDate}">
	                        <h3><spring:message code="label.installation.current"/></h3>
	                			<t:installationTable installations="${currentInstallationActiveByDate}" />
				  		</c:if>
					</div>
					
					
					<div class="content_tab">
						<div class="margin-box">
							<c:set var="activeFinancialDevicesByDate" value="${terminal.getActiveFinancialDevicesByDate(date)}" />
							<c:if  test="${empty activeFinancialDevicesByDate}">
								<div class="empty-list message">
									<spring:message code="label.terminal.noFinancialDevices"/>
								</div>
							</c:if>
							<c:if test="${!empty activeFinancialDevicesByDate}">
							<div class="margin-box">
							<div class="wrapperFloatThead">
								<c:choose>
									<c:when  test="${activeFinancialDevicesByDate.size() > 5}">
										 <table id="TestChromatable" class="data subform link floatThead">
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

														<th><div class="add"><span>Ver más información</span></div></th>
													</tr>
												</thead>
											</c:otherwise>
										</c:choose>
										<tbody>

											<c:forEach items="${activeFinancialDevicesByDate}" var="financialDevice">
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
								</div>
								</div><!-- /margin-box -->
							</c:if>
						</div>
					</div>

					<div class="content_tab">
						<c:if  test="${empty terminal.getActiveHardwareDevicesByDate(date)}">
							<div class="empty-list message">
								<spring:message code="label.terminal.noHwDevices"/>
							</div>
						</c:if>
						<c:if test="${!empty terminal.getActiveHardwareDevicesByDate(date)}">

                          <div class="action_box data desplegable">

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveComputerSystemsByDate(date)}">
									<t:computerSystemTable hardwareDevices="${terminal.getActiveComputerSystemsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveProcessorsByDate(date)}">
									<t:processorTable hardwareDevices="${terminal.getActiveProcessorsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActivePhysicalMemoriesByDate(date)}">
									<t:physicalMemoryTable hardwareDevices="${terminal.getActivePhysicalMemoriesByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveDiskDrivesByDate(date)}">
									<t:diskDriveTable hardwareDevices="${terminal.getActiveDiskDrivesByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveLogicalDisksByDate(date)}">
									<t:logicalDiskTable hardwareDevices="${terminal.getActiveLogicalDisksByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveBaseBoardsByDate(date)}">
									<t:baseBoardTable hardwareDevices="${terminal.getActiveBaseBoardsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveNetworkAdaptersByDate(date)}">
									<t:networkAdapterTable hardwareDevices="${terminal.getActiveNetworkAdaptersByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveFloppyDrivesByDate(date)}">
									<t:floppyDriveTable hardwareDevices="${terminal.getActiveFloppyDrivesByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveCdromDrivesByDate(date)}">
									<t:cdromDriveTable hardwareDevices="${terminal.getActiveCdromDrivesByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveSoundDevicesByDate(date)}">
									<t:soundDeviceTable hardwareDevices="${terminal.getActiveSoundDevicesByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveUsbControllersByDate(date)}">
									<t:usbControllerTable hardwareDevices="${terminal.getActiveUsbControllersByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveSerialPortsByDate(date)}">
									<t:serialPortTable hardwareDevices="${terminal.getActiveSerialPortsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveParallelPortsByDate(date)}">
									<t:parallelPortTable hardwareDevices="${terminal.getActiveParallelPortsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveControllers1394ByDate(date)}">
									<t:1394ControllerTable hardwareDevices="${terminal.getActiveControllers1394ByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveScsiControllersByDate(date)}">
									<t:scsiControllerTable hardwareDevices="${terminal.getActiveScsiControllersByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveDesktopMonitorsByDate(date)}">
									<t:desktopMonitorTable hardwareDevices="${terminal.getActiveDesktopMonitorsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveKeyboardsByDate(date)}">
									<t:keyboardTable hardwareDevices="${terminal.getActiveKeyboardsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActivePointingDevicesByDate(date)}">
									<t:pointingDeviceTable hardwareDevices="${terminal.getActivePointingDevicesByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveSystemSlotsByDate(date)}">
									<t:systemSlotTable hardwareDevices="${terminal.getActiveSystemSlotsByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveBiosByDate(date)}">
									<t:biosTable hardwareDevices="${terminal.getActiveBiosByDate(date)}"/>
								</c:if>
							</div>

							<div class="margin-box">
								<c:if test="${!empty terminal.getActiveVideoControllersByDate(date)}">
									<t:videoControllerTable hardwareDevices="${terminal.getActiveVideoControllersByDate(date)}"/>
								</c:if>
							</div>

						</div>

                        </div>
						</c:if>
					</div>

					<div class="content_tab">
						<c:set var="currentTerminalConfigActiveByDate" value="${terminal.getCurrentTerminalConfigActiveByDate(date)}"/>
						<c:if  test="${empty currentTerminalConfigActiveByDate}">
							<div class="empty-list message">
								<spring:message code="label.terminal.noConfigs"/>
							</div>
						</c:if>
						<c:if  test="${!empty currentTerminalConfigActiveByDate}">
                          <div class="action_box data desplegable">
							<t:listSoftware config="${currentTerminalConfigActiveByDate}"/>
                           </div> 
						</c:if>

					</div>
			<div class="content_tab">
					<c:if  test="${empty terminal.getActiveAuditableSoftwareAggregatesByDate(date)}">
						<div class="empty-list message">
							<spring:message code="label.terminal.noSwAggregates"/>
						</div>
					</c:if>
					<c:if test="${!empty terminal.getActiveAuditableSoftwareAggregatesByDate(date)}">
					<div class="margin-box">
					<div class="wrapperFloatThead">
						<c:choose>
							<c:when  test="${terminal.getActiveAuditableSoftwareAggregatesByDate(date).size() >
								5}">
								<table id="AggregateChromatable" class="data link floatThead">
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
								<c:forEach items="${terminal.getActiveAuditableSoftwareAggregatesByDate(date)}" var="auditableSoftwareAggregate">
									<tr <c:if test="${alt}">class="alt"</c:if>
									>
									<td>${auditableSoftwareAggregate.softwareAggregate.nameVersion}</td>
									<td>${auditableSoftwareAggregate.softwareAggregate.number}</td>
									<td>${auditableSoftwareAggregate.softwareAggregate.description}</td>
									<td>${auditableSoftwareAggregate.softwareAggregate.profile}</td>
								</tr>
								<c:set var="alt" value="${!alt}"/>
							</c:forEach>
						</table>
						</div>
					</div><!-- / margin-box -->
					</c:if>

			</div>

			<div class="content_tab">
				<div class="margin-box">
				<div class="wrapperFloatThead">
					<c:if  test="${empty terminal.getActiveHotfixesByDate(date)}">
						<div class="empty-list message">
							<spring:message code="label.terminal.noHotfixes"/>
						</div>
					</c:if>
					<c:if test="${!empty terminal.getActiveHotfixesByDate(date)}">
						<c:choose>
							<c:when  test="${terminal.getActiveHotfixesByDate(date).size() >
								5}">
								<table id="HotfixChromatable" class="data margin-box link floatThead">
									<thead>
										<tr >
											<th >

												<spring:message code="label.hotfix.hotfixId"/>

											</th>
											<th >

												<spring:message code="label.hotfix.description"/>

											</th >
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
								<c:forEach items="${terminal.getActiveHotfixesByDate(date)}" var="hotfix">
									<tr <c:if test="${alt}">class="alt"</c:if>
									>
									<td>${hotfix.hotfixId}</td>
									<td>${hotfix.description}</td>
									<td>${hotfix.number}</td>
									<td>
										<fmt:formatDate value="${hotfix.startDate}" dateStyle="short" type="date" />
									</td>
									<td>${hotfix.fixComments}</td>
								</tr>
								<c:set var="alt" value="${!alt}"/>
							</c:forEach>
						</table>
					</c:if>
					</div>
				</div>
			</div>
			<div class="content_tab">
				<div class="margin-box">
					<c:if  test="${empty terminal.getActiveAuditableInternetExplorersByDate(date)}">
						<div class="empty-list message">
							<spring:message code="label.terminal.noIEs"/>
						</div>
					</c:if>
					<c:if test="${!empty terminal.getActiveAuditableInternetExplorersByDate(date)}">
						<table class="data link">
							<tr>
								<th>

									<spring:message code="label.internetExplorer.majorVersion"/>

								</th>
							</tr>
							<c:set var="alt" value="${false}"/>
							<c:forEach items="${terminal.getActiveAuditableInternetExplorersByDate(date)}" var="auditableInternetExplorer">
								<tr <c:if test="${alt}">class="alt"</c:if>
								>
								<td>${auditableInternetExplorer.internetExplorer.version}</td>
							</tr>
							<c:set var="alt" value="${!alt}"/>
						</c:forEach>
					</table>
				</c:if>
			</div>
		</div>
		<!-- /tabs -->
	</div>
</div>
</div>
</div>
<script>
var Timeline_urlPrefix = 'resources/timeline/api/';
var Timeline_ajax_url= 'resources/timeline/ajax/simile-ajax-api.js'; 
</script>
<script src="resources/timeline/api/timeline-api.js" type="text/javascript"></script>
<script src="resources/js/elementClusterer.js" type="text/javascript"></script> 
<script>

	window.onload = function() { executeOnTimelineLoaded(loadTimeline); initTabs();  };

	var tl;
   
    function loadTimeline() {

    	var elementsSize = 16;
    	var eventSource = new Timeline.DefaultEventSource();

        var zones = [];
        var zones2 = [];
        
        var theme = Timeline.ClassicTheme.create();
        theme.event.bubble.width = 250;
        
        var bandInfos = [
            Timeline.createHotZoneBandInfo({
            	<c:if test="${!(date == null)}">  
	            	date : new Date(${date.time}) ,     
	        	</c:if>  
	        	width:          "66%", 
                intervalUnit:   Timeline.DateTime.MONTH, 
                intervalPixels: 200,
                zones:          zones,
                eventSource:    eventSource,
                zoomIndex:      16,
            zoomSteps:      new Array(
              {pixelsPerInterval: 3000,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2500,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2000,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 1600,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2500,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 2000,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1700,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1500,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1500,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 1200,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 800,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 500,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 300,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 200,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.YEAR}
            )
                
              //  theme:          theme
            }),
            Timeline.createHotZoneBandInfo({
                width:          "34%", 
                intervalUnit:   Timeline.DateTime.YEAR, 
                zones:          zones2, 
                intervalPixels: 400,
                eventSource:    eventSource,
                overview:       true,
                zoomIndex:      1,
                zoomSteps:      new Array(
                    {pixelsPerInterval: 400,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 50,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.DECADE},
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.DECADE}
                 )
               // theme:          theme
            })
        ];
        bandInfos[1].syncWith = 0;
        bandInfos[1].highlight = true;
        
        
        tl = Timeline.create(document.getElementById("timeline"), bandInfos, Timeline.HORIZONTAL);
        addOnEventPaintFinished(elementsSize);

            eventSource.loadJSON(buildEventsJSONData(), '');
       
        
        Timeline.OriginalEventPainter.prototype._showBubble = function(x, y, evt) {
            window.location.assign(document.location.pathname + evt.getDescription());
  		}
  		
  		var resizeTimerID = null;
		function onResize() {
			if (resizeTimerID == null) {
				resizeTimerID = window.setTimeout(function() {
					resizeTimerID = null;
					tl.layout();
				}, 500);
			}
		}
		
		window.onresize = onResize;  
		
		$("div.botonera .timelineZoom").click( function() {
			var target = document.getElementById("timeline-band-0");
			var zoomIn = $(this).data('zoomIn');
			
			tl.zoom(zoomIn, tl.getCenterPixel(0) ,1,target);
		});
	
	}
    function addOnEventPaintFinished(elementsSize) {
		tl._bands[0].addOnEventPaintFinished(function(event,op) { 
			if (op == 'paintEnded') {
				clusterizeTimeline(elementsSize)
			} 
		});
	}	
	function clusterizeTimeline(elementsSize) {
		var elements = $("div#timeline .timeline-event-icon")
		var parent = elements.parent(); 
		var createdClusters = []
			
		var clusterer = new ElementsClusterer(elements.toArray(), elementsSize);
				
		clusterer.addOnElementChangeListener(function(event) {
		    event.HTMLElement.style.left = event.leftPosition+"px";
		});
		clusterer.addOnClusterCreateListener(onClusterCreaterdListener);
		
		clusterer.clusterize()
		initClusterNumberOfElements();
		
		function initClusterNumberOfElements() {
			var index = 0;
			for( index; index < createdClusters.length ;  index++) {
				var cluster = createdClusters[index]
				var clusteredElementsSize = cluster.elements.length;
				var clusterDiv = cluster.clusterDivElement;
				clusterDiv.append(
					'<span class="cluster">' + clusteredElementsSize + '</span>'
				)
			}
		}
		function onClusterCreaterdListener(event) {
		    var clusteredElements = event.clusteredElements,
		   	elementSpace = elementsSize,
		   	leftPosition = event.leftPosition;
		   	
		   	var clusterDivString = '<div class="timeline-event-icon cluster" id="cluster-' + leftPosition+ '"style="left: ' + 
		    leftPosition + 'px; top: 7px;"><img src="resources/timeline/api/images/Cluster.png"></div>'
		    parent.append(clusterDivString);
		    
		    var clusterDivElement = $('div#cluster-'+ leftPosition); 
		    createdClusters.push({leftPosition:leftPosition, elements:clusteredElements, clusterDivElement:clusterDivElement})
		    
		    clusterDivElement.click(function() {
		    	var index = 0,
		    		totalClusteredElements = clusteredElements.length,
		    		totalWidth = elementSpace * totalClusteredElements,
		    		firstLeftPosition = (leftPosition - totalWidth / 2 ) + elementSpace/1.25 ,
		    		currentLeftPosition = firstLeftPosition;
		    		
		    	restoreClusters();
		    	
		    	for(index ; index < totalClusteredElements; index++) {
		    		var htmlElement = clusteredElements[index].HTMLElement 
		    		var element = $(htmlElement);
		    		element.addClass('secondLine');
		    		
		    		element.animate({
						left: currentLeftPosition + "px",
					}, 500 );
		    		currentLeftPosition += elementSpace;
		    	}
		    });
		    
		    function restoreClusters() {
				var index = 0;
				for( index; index < createdClusters.length ;  index++) {
					var cluster = createdClusters[index]
					var elementIndex = 0;
					var clusteredElements = cluster.elements;
					
					for(elementIndex ; elementIndex < clusteredElements.length; elementIndex++) {
		    			var htmlElement = clusteredElements[elementIndex].HTMLElement 
		    			var element = $(htmlElement);
		    			element.removeClass('secondLine');
		    			htmlElement.style.left = cluster.leftPosition + "px";
		    		}
				}
			}
		}
	}
    function buildEventsJSONData() {
    	var eventData = {
    	   events : [
    	   <c:set var="times" value="${0}" />
    	       <c:forEach items="${historicalChanges}" var="changesByType">
    	           <c:forEach items="${changesByType.getValue()}" var="changeDates">
	               <c:set var="changeDate" value="${changeDates.getKey()}" />
	               <c:set var="numberOfChanges" value="${changeDates.getValue()}" />
	               <c:set var="times" value="${times + 1}" />
			{
			 		 start : new Date(${changeDate.time}) ,
    	          	 description : "?dateTime=${changeDate.time}&preselectedTab=${changesByType.key.simpleName}",
    	          	 classname : 'firstLine',
    	          	 icon : '<c:url 
    	          	 	value="/resources/timeline/api/images/${changesByType.key.simpleName}${date.time == changeDate.time ? '_current' : ''}.png" 
    	          	 />',
    	          	 iconTitle : '<fmt:formatDate value="${changeDate}" pattern="dd/MM/yyyy HH:mm:ss" />'
    	      		},
    	      	    </c:forEach>
    	        </c:forEach>	
    	   ] 
        }
        return eventData;
    } 

     $(document).ready(function(){

    	 var $table = $('.floatThead');
    	 $table.floatThead({
    	     //debounceResizeMs: 300,
    	     scrollContainer: function ($table) {
    	         return $table.closest('.wrapperFloatThead');
    	     }
    	 });
	 }); 
	function initTabs() {
		   defaultInitTabs();
		    
	       $('a[href*=#]').click(function(event) {
	           event.preventDefault();
	           if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
	               && location.hostname == this.hostname) {
	
	               var $target = $(this.hash);
	               $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');
	               if ($target.length) {
	                   var targetOffset = $target.offset().top - 220;
	                   $('html,body').animate({scrollTop: targetOffset}, 1000);
	               }
	           }
	       }); 
	       <c:if test="${preselectedTab != null}" >
		  		$('li > a[href*=#].${preselectedTab}').click()	
		   </c:if>
		}
</script>
</body>
</html>