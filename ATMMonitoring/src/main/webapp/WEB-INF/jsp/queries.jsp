<%@include file="includes/JspImports.jsp"%>

						<div id="header_g">
							<%-- <nav id="breadcrumb">
								<ul>
									<li>
										<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
									</li>
									<li>
										<a href="terminals"><spring:message code="breadcrumb.terminals"/></a>
									</li>
									<li><a href="queries/list"><spring:message code="label.queries.mine"/></a></li>
									<li><spring:message code="label.query"/>: ${query.name}</li>
								</ul>
							</nav> --%>
							<c:set var="navigationBackMain" scope="request" >home,terminals,queries</c:set>
							<c:set var="navigationActual" value="label.query" scope="request" />
							<c:set var="navigationActualExtra" value=": ${query.name}" scope="request" />
							<jsp:include page="includes/navigation.jsp" />
						</div>
						<div class="content">
							<h1>
		
								<spring:message code="label.query"/>:  ${query.name}
							</h1>
							<div class="botonera"><a onclick="loadInnerSection('#primary', 'queries') " class="btn back left"><spring:message code="label.query.return"/></a></div>
							<div class="action_box desplegable">
								
							<form:form method="post" action="queries/results" commandName="query">
								   <form:hidden path="id"/>			   
		
								<h2 class="txt content_hide" id="terminalSection" ">
									<spring:message code="label.query.terminalSection"/>
								</h2>
								
								<div class="collapsible hide">
									<table class="query-form">
										<tr>
											<th>
												<spring:message code="label.query.field"/>
											</th>
											<th>
												<spring:message code="label.query.not"/>
											</th>
											<th>
												<spring:message code="label.query.comparison"/>
											</th>
											<th>
												<spring:message code="label.query.value"/>
											</th>
											<th></th>
										</tr>
										<c:forEach var="i" begin="1" end="5" varStatus="status">
											<tr id="terminalRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
											>
											<td>
												<form:select path="terminalCombo${i}1" id="terminalCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('terminal','#'+this.id,'#terminalCombo${i}2','#terminalCB${i}','#terminalField${i}')" 
												onClick="loadQueryOptions('terminal','#'+this.id)">
													<form:option value="" label=""/>
													<%-- <c:forEach items="${values.get('terminal').keySet()}" var="value">
														<form:option value="${value}">
															<spring:message code="label.terminal.${value}"/>
														</form:option>
													</c:forEach>  --%>
												</form:select>
											</td>
											<td>
												<form:checkbox path="terminalCB${i}" id="terminalCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
											</td>
											<td>
												<form:select path="terminalCombo${i}2" id="terminalCombo${i}2" class="query_selectors" size="1" disabled="true" onchange ="onChangeComparisonEnableDisableText('#'+this.id,'#terminalField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
													<form:option value="" label=""/>
													<%-- -><c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
														<form:option value="${value}">
															<spring:message code="label.query.operation.${value}"/>
														</form:option>
													</c:forEach>--%>
												</form:select>
											</td>
											<td>
												<form:input class='form-tf-grey' path="terminalField${i}" id="terminalField${i}" disabled="true" maxlength="150"/>
												<br></td>
											<c:if test="${!status.last}">
												<td class="btn_add">
													<div id="terminalShowButton${i}" onclick="showHiddenRow('terminal', ${i})" class="btn add"><span>Añadir</span></div>
												</td>
											</c:if>
										</tr>
									</c:forEach>
								</table>
							</div>
							<h2 class="txt content_hide" id="hwSection">
								<spring:message code="label.query.hardwareSection"/>
								<span></span>
							</h2>
							<div class="collapsible hide">
								<h3>
									<spring:message code="label.query.hardwareDeviceSection"/>
								</h3>
								<table class="query-form">
									<tr>
										<th>
		
											<spring:message code="label.query.deviceType"/>
		
										</th>
										<th>
		
											<spring:message code="label.query.field"/>
		
										</th>
										<th>
		
											<spring:message code="label.query.not"/>
		
										</th>
										<th>
		
											<spring:message code="label.query.comparison"/>
		
										</th>
										<th>
		
											<spring:message code="label.query.value"/>
		
										</th>
										<th></th>
									</tr>
									<c:forEach var="i" begin="1" end="5" varStatus="status">
										<tr id="hardwareDeviceRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
										>
										<td>
											<form:select path="hardwareDeviceCombo${i}1" id="hardwareDeviceCombo${i}1" class="query_selectors" size="1" onchange="loadQueryHardwareFieldsOptions('#'+this.id, '#hardwareDeviceCombo${i}2','#hardwareDeviceCB${i}','#hardwareDeviceCombo${i}3','#hardwareDeviceField${i}' )"
											onClick="loadQueryOptions('hardwareDevice','#'+this.id)">
												<form:option value="" label=""/>
												<%-- <c:forEach items="${values.get('hardwareDevice').keySet()}" var="value">
													<c:if test="${value != 'allHwDevices'}">
														<form:option value="${value}">
															<spring:message code="label.hardwareDevice.${value}"/>
														</form:option>
													</c:if>
												</c:forEach>  --%>
											</form:select>
										</td>
										<td>
											<form:select path="hardwareDeviceCombo${i}2" id="hardwareDeviceCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="loadQueryComparisonOptions('hardwareDevice','#'+this.id,'#hardwareDeviceCombo${i}3','#hardwareDeviceCB${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
												<form:option value="" label=""/>
												<%--  <c:forEach items="${values.get('hardwareDevice').get('allHwDevices').keySet()}" var="value">
													<form:option value="${value}">
														<spring:message code="label.hardwareDevice.${value}"/>
													</form:option>
												</c:forEach> --%>
											</form:select>
										</td>
										<td>
											<form:checkbox path="hardwareDeviceCB${i}" id="hardwareDeviceCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
										</td>
										<td>
											<form:select path="hardwareDeviceCombo${i}3" id="hardwareDeviceCombo${i}3" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#hardwareDeviceField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
												<form:option value="" label=""/>
												<%--  <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
													<form:option value="${value}">
														<spring:message code="label.query.operation.${value}"/>
													</form:option>
												</c:forEach>  --%>
											</form:select>
										</td>
										<td>
											<form:input class='form-tf-grey' path="hardwareDeviceField${i}" id="hardwareDeviceField${i}" disabled="true" maxlength="150"/>
											<br></td>
										<c:if test="${!status.last}">
											<td class="btn_add">
												<div id="hardwareDeviceShowButton${i}" onclick="showHiddenRow('hardwareDevice', ${i})" class="btn add"><span>Añadir</span></div>
											</td>
										</c:if>
									</tr>
								</c:forEach>
							</table>
							<h3>
								<spring:message code="label.query.financialDeviceSection"/>
							</h3>
							<table class="query-form">
								<tr>
									<th>
										<spring:message code="label.query.field"/>
									</th>
									<th>
										<spring:message code="label.query.not"/>
									</th>
									<th>
										<spring:message code="label.query.comparison"/>
									</th>
									<th>
										<spring:message code="label.query.value"/>
									</th>
									<th></th>
								</tr>
								<c:forEach var="i" begin="1" end="5" varStatus="status">
									<tr id="financialDeviceRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="financialDeviceCombo${i}1" id="financialDeviceCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('financialDevice','#'+this.id,'#financialDeviceCombo${i}2','#financialDeviceCB${i}, '#financialDeviceField${i}')"
										onClick="loadQueryOptions('financialDevice','#'+this.id)">
											<form:option value="" label=""/>
											<%-- <c:forEach items="${values.get('financialDevice').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.financialDevice.${value}"/>
												</form:option>
											</c:forEach> --%>
										</form:select>
									</td>
									<td>
										<form:checkbox path="financialDeviceCB${i}" id="financialDeviceCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
									</td>
									<td>
										<form:select path="financialDeviceCombo${i}2" id="financialDeviceCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#financialDeviceField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
											<form:option value="" label=""/>
											<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.query.operation.${value}"/>
												</form:option>
											</c:forEach> --%>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="financialDeviceField${i}" id="financialDeviceField${i}" disabled="true" maxlength="150"/>
										<br></td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="financialDeviceShowButton${i}" onclick="showHiddenRow('financialDevice', ${i})" class="btn add"><span>Añadir</span></div>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<h3>
							<spring:message code="label.query.xfsComponentSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="xfsComponentRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="xfsComponentCombo${i}1" id="xfsComponentCombo${i}1" class="query_selectors" size="1" 
										onchange="loadQueryComparisonOptions('xfsComponent','#'+this.id,'#xfsComponentCombo${i}2','#xfsComponentCB${i}','#xfsComponentField${i}')"
											onClick="loadQueryOptions('xfsComponent','#'+this.id)">
											<form:option value="" label=""/>
											<%-- <c:forEach items="${values.get('xfsComponent').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.xfsComponent.${value}"/>
												</form:option>
											</c:forEach> --%>
										</form:select>
									</td>
									<td>
										<form:checkbox path="xfsComponentCB${i}" id="xfsComponentCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
									</td>
									<td>
										<form:select path="xfsComponentCombo${i}2" id="xfsComponentCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#xfsComponentField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
											<form:option value="" label=""/>
											<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.query.operation.${value}"/>
												</form:option>
											</c:forEach> --%>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="xfsComponentField${i}" id="xfsComponentField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="xfsComponentShowButton${i}" onclick="showHiddenRow('xfsComponent', ${i})" class="btn add"><span>Añadir</span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
						<h3>
							<spring:message code="label.query.jxfsComponentSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="jxfsComponentRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>>
									<td>
										<form:select path="jxfsComponentCombo${i}1" id="jxfsComponentCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('jxfsComponent','#'+this.id,'#jxfsComponentCombo${i}2','#jxfsComponentCB${i}','#jxfsComponentField${i}')"
											onClick="loadQueryOptions('jxfsComponent','#'+this.id)">
											<form:option value="" label=""/>
											
											<%-- <c:forEach items="${values.get('jxfsComponent').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.jxfsComponent.${value}"/>
												</form:option>
											</c:forEach> --%>
										</form:select>
									</td>
									<td>
										<form:checkbox path="jxfsComponentCB${i}" id="jxfsComponentCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
									</td>
									<td>
										<form:select path="jxfsComponentCombo${i}2" id="jxfsComponentCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#jxfsComponentField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
											<form:option value="" label=""/>
											<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.query.operation.${value}"/>
												</form:option>
											</c:forEach> --%>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="jxfsComponentField${i}" id="jxfsComponentField${i}" disabled="true" maxlength="150"/>
										</td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="jxfsComponentShowButton${i}" onclick="showHiddenRow('jxfsComponent', ${i})" class="btn add"><span>Añadir</span></div>
										</td>
									</c:if>
									<c:if test="${status.last}">
										<td> </td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</div>
					<h2 class="txt content_hide" id="swSection">
						<spring:message code="label.query.softwareGlobalSection"/>
						<span></span>
					</h2>
					<div class="collapsible hide">
						<h3>
							<spring:message code="label.query.operatingSystemSection"/>
						</h3>
						<table class="query-form">
							<tr>
								<th>
									<spring:message code="label.query.field"/>
								</th>
								<th>
									<spring:message code="label.query.not"/>
								</th>
								<th>
									<spring:message code="label.query.comparison"/>
								</th>
								<th>
									<spring:message code="label.query.value"/>
								</th>
								<th></th>
							</tr>
							<c:forEach var="i" begin="1" end="5" varStatus="status">
								<tr id="operatingSystemRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
								>
								<td>
									<form:select path="operatingSystemCombo${i}1" id="operatingSystemCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('operatingSystem','#'+this.id,'#operatingSystemCombo${i}2','#operatingSystemCB${i}','#operatingSystemField${i}')"
										onClick="loadQueryOptions('operatingSystem','#'+this.id)">
										<form:option value="" label=""/>
										
										<%-- <c:forEach items="${values.get('operatingSystem').keySet()}" var="value">
											<form:option value="${value}">
												<spring:message code="label.operatingSystem.${value}"/>
											</form:option>
										</c:forEach> --%>
									</form:select>
								</td>
								<td>
									<form:checkbox path="operatingSystemCB${i}" id="operatingSystemCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
								</td>
								<td>
									<form:select path="operatingSystemCombo${i}2" id="operatingSystemCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#operatingSystemField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
										<form:option value="" label=""/>
										<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
											<form:option value="${value}">
												<spring:message code="label.query.operation.${value}"/>
											</form:option>
										</c:forEach> --%>
									</form:select>
								</td>
								<td>
									<form:input class='form-tf-grey' path="operatingSystemField${i}" id="operatingSystemField${i}" disabled="true" maxlength="150"/>
									<br></td>
								<c:if test="${!status.last}">
									<td class="btn_add">
										<div id="operatingSystemShowButton${i}" onclick="showHiddenRow('operatingSystem', ${i})"  class="btn add"><span>Añadir</span></div>
									</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
					<h3>
						<spring:message code="label.query.internetExplorerSection"/>
					</h3>
					<table class="query-form">
						<tr>
							<th>
								<spring:message code="label.query.field"/>
							</th>
							<th>
								<spring:message code="label.query.not"/>
							</th>
							<th>
								<spring:message code="label.query.comparison"/>
							</th>
							<th>
								<spring:message code="label.query.value"/>
							</th>
							<th></th>
						</tr>
						<c:forEach var="i" begin="1" end="2" varStatus="status">
							<tr id="internetExplorerRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
							>
							<td>
								<form:select path="internetExplorerCombo${i}1" id="internetExplorerCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('internetExplorer','#'+this.id,'#internetExplorerCombo${i}2','#internetExplorerCB${i}','#internetExplorerField${i}')"
									onClick="loadQueryOptions('internetExplorer','#'+this.id)">
									<form:option value="" label=""/>
									<%-- <c:forEach items="${values.get('internetExplorer').keySet()}" var="value">
										<form:option value="${value}">
											<spring:message code="label.internetExplorer.${value}"/>
										</form:option>
									</c:forEach> --%>
								</form:select>
							</td>
							<td>
								<form:checkbox path="internetExplorerCB${i}" id="internetExplorerCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
							</td>
							<td>
								<form:select path="internetExplorerCombo${i}2" id="internetExplorerCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#internetExplorerField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
									<form:option value="" label=""/>
									<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
										<form:option value="${value}">
											<spring:message code="label.query.operation.${value}"/>
										</form:option>
									</c:forEach> --%>
								</form:select>
							</td>
							<td>
								<form:input class='form-tf-grey' path="internetExplorerField${i}" id="internetExplorerField${i}" disabled="true" maxlength="150"/>
								<br></td>
							<c:if test="${!status.last}">
								<td class="btn_add">
									<div id="internetExplorerShowButton${i}" onclick="showHiddenRow('internetExplorer', ${i})" class="btn add"><span>Añadir</span></div>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<h3>
					<spring:message code="label.query.hotfixSection"/>
				</h3>
				<table class="query-form">
					<tr>
						<th>
							<spring:message code="label.query.field"/>
						</th>
						<th>
							<spring:message code="label.query.not"/>
						</th>
						<th>
							<spring:message code="label.query.comparison"/>
						</th>
						<th>
							<spring:message code="label.query.value"/>
						</th>
						<th></th>
					</tr>
					<c:forEach var="i" begin="1" end="5" varStatus="status">
						<tr id="hotfixRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
						>
						<td>
							<form:select path="hotfixCombo${i}1" id="hotfixCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('hotfix','#'+this.id,'#hotfixCombo${i}2','#hotfixCB${i}','#hotfixField${i}')"
								onClick="loadQueryOptions('hotfix','#'+this.id)">
								<form:option value="" label=""/>
								<%-- <c:forEach items="${values.get('hotfix').keySet()}" var="value">
									<form:option value="${value}">
										<spring:message code="label.hotfix.${value}"/>
									</form:option>
								</c:forEach> --%>
							</form:select>
						</td>
						<td>
							<form:checkbox path="hotfixCB${i}" id="hotfixCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
						</td>
						<td>
							<form:select path="hotfixCombo${i}2" id="hotfixCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#hotfixField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
								<form:option value="" label=""/>
								<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
									<form:option value="${value}">
										<spring:message code="label.query.operation.${value}"/>
									</form:option>
								</c:forEach> --%>
							</form:select>
						</td>
						<td>
							<form:input class='form-tf-grey' path="hotfixField${i}" id="hotfixField${i}" disabled="true" maxlength="150"/>
							<br></td>
						<c:if test="${!status.last}">
							<td class="btn_add">
								<div id="hotfixShowButton${i}" onclick="showHiddenRow('hotfix', ${i})" class="btn add"><span>Añadir</span></div>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
			<h3>
				<spring:message code="label.query.softwareSection"/>
			</h3>
			<table class="query-form">
				<tr>
					<th>
						<spring:message code="label.query.field"/>
					</th>
					<th>
						<spring:message code="label.query.not"/>
					</th>
					<th>
						<spring:message code="label.query.comparison"/>
					</th>
					<th>
						<spring:message code="label.query.value"/>
					</th>
					<th></th>
				</tr>
				<c:forEach var="i" begin="1" end="5" varStatus="status">
					<tr id="softwareRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
					>
					<td>
						<form:select path="softwareCombo${i}1" id="softwareCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('software','#'+this.id,'#softwareCombo${i}2','#softwareCB${i}','#softwareField${i}')"
								onClick="loadQueryOptions('software','#'+this.id)">
							<form:option value="" label=""/>
							<%-- <c:forEach items="${values.get('software').keySet()}" var="value">
								<form:option value="${value}">
									<spring:message code="label.software.${value}"/>
								</form:option>
							</c:forEach> --%>
						</form:select>
					</td>
					<td>
						<form:checkbox path="softwareCB${i}" id="softwareCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
					</td>
					<td>
						<form:select path="softwareCombo${i}2" id="softwareCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#softwareField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
							<form:option value="" label=""/>
							<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
								<form:option value="${value}">
									<spring:message code="label.query.operation.${value}"/>
								</form:option>
							</c:forEach> --%>
						</form:select>
					</td>
					<td>
						<form:input class='form-tf-grey' path="softwareField${i}" id="softwareField${i}" disabled="true" maxlength="150"/>
						<br></td>
					<c:if test="${!status.last}">
						<td class="btn_add">
							<div id="softwareShowButton${i}" onclick="showHiddenRow('software', ${i})"  class="btn add"><span>Añadir</span></div>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<h3>
			<spring:message code="label.query.featSwSection"/>
		</h3>
		<table class="query-form">
			<tr>
				<th>
					<spring:message code="label.query.field"/>
				</th>
				<th>
					<spring:message code="label.query.not"/>
		
				</th>
				<th>
					<spring:message code="label.query.comparison"/>
				</th>
				<th>
					<spring:message code="label.query.value"/>
				</th>
				<th></th>
			</tr>
			<c:forEach var="i" begin="1" end="5" varStatus="status">
				<tr id="featSwRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
				>
				<td>
					<form:select path="featSwCombo${i}1" id="featSwCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('featSw','#'+this.id,'#featSwCombo${i}2','#featSwCB${i}','#featSwField${i}')"
							onClick="loadQueryOptions('featSw','#'+this.id)">
						<form:option value="" label=""/>
						<%-- <c:forEach items="${values.get('featSw').keySet()}" var="value">
							<form:option value="${value}">
								<spring:message code="label.featSw.${value}"/>
							</form:option>
						</c:forEach> --%>
					</form:select>
				</td>
				<td>
					<form:checkbox path="featSwCB${i}" id="featSwCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
				</td>
				<td>
					<form:select path="featSwCombo${i}2" id="featSwCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#featSwField${i}')" onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
						<form:option value="" label=""/>
						<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
							<form:option value="${value}">
								<spring:message code="label.query.operation.${value}"/>
							</form:option>
						</c:forEach> --%>
					</form:select>
				</td>
				<td>
					<form:input class='form-tf-grey' path="featSwField${i}" id="featSwField${i}" disabled="true" maxlength="150"/>
					<br></td>
				<c:if test="${!status.last}">
					<td class="btn_add">
						<div id="featSwShowButton${i}" onclick="showHiddenRow('featSw', ${i})" class="btn add"><span>Añadir</span></div>
					</td>
				</c:if>
			</tr>
		</c:forEach>
		</table>
		<h3>
		<spring:message code="label.query.xfsSwSection"/>
		</h3>
		<table class="query-form">
		<tr>
			<th>
				<spring:message code="label.query.field"/>
			</th>
			<th>
				<spring:message code="label.query.not"/>
			</th>
			<th>
				<spring:message code="label.query.comparison"/>
			</th>
			<th>
				<spring:message code="label.query.value"/>
			</th>
			<th></th>
		</tr>
		<c:forEach var="i" begin="1" end="5" varStatus="status">
			<tr id="xfsSwRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
			>
			<td>
				<form:select path="xfsSwCombo${i}1" id="xfsSwCombo${i}1" class="query_selectors" size="1" onchange="loadQueryComparisonOptions('xfsSw','#'+this.id,'#xfsSwCombo${i}2','#xfsSwCB${i}','#xfsSwField${i}')"
					onClick="loadQueryOptions('xfsSw','#'+this.id)">
					<form:option value="" label=""/>
					<%-- <c:forEach items="${values.get('xfsSw').keySet()}" var="value">
						<form:option value="${value}">
							<spring:message code="label.xfsSw.${value}"/>
						</form:option>
					</c:forEach> --%>
				</form:select>
			</td>
			<td>
				<form:checkbox path="xfsSwCB${i}" id="xfsSwCB${i}" disabled="true" onclick="checkboxChangeValue('#'+this.id)"/>
			</td>
			<td>
				<form:select path="xfsSwCombo${i}2" id="xfsSwCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="onChangeComparisonEnableDisableText('#'+this.id,'#xfsSwField${i}')"  onclick="removeDuplicatedValueFromCombobox('#'+this.id)">
					<form:option value="" label=""/>
					<%-- <c:forEach items="${values.get('allOperations').get('allOperations').keySet()}" var="value">
						<form:option value="${value}">
							<spring:message code="label.query.operation.${value}"/>
						</form:option>
					</c:forEach> --%>
				</form:select>
			</td>
			<td>
				<form:input class='form-tf-grey' path="xfsSwField${i}" id="xfsSwField${i}" disabled="true" maxlength="150"/>
				<br></td>
			<c:if test="${!status.last}">
				<td class="btn_add">
					<div id="xfsSwShowButton${i}" onclick="showHiddenRow('xfsSw', ${i})" class="add btn"><span>Añadir</span></div>
				</td>
			</c:if>
		</tr>
		</c:forEach>
		</table>
		</div>
			<div class="botonera">
				<div class="desplegable button">
					<div class="btn txt content_hide"><spring:message code="label.query.save"/></div>
					<div class="hide collapsible">
						<ul>
							<li><label for="namequery"><spring:message code="label.name"/></label> <form:input type="text" path="name"/></li>
							<li><label for="descriptionquery"><spring:message code="label.description"/></label> <form:textarea path="description"/></li>
						</ul>
						<div class="botonera"><button  class="save" id="save" name="save" onclick="changeRequestParam('#query', '#primary', '#queryList','save'); return false;"><spring:message code="label.save"/>" </button></div>
					</div>
				</div><!-- /desplegable -->
				<button  class="form-submit play" name="execute" id="execute" onClick="changeRequestParam('#query', '#queryResults', '#content','execute'); return false;"><spring:message code="label.query.execute"/></button>
				<button  class="delete right" name="delete" id="delete" onClick=" deleteQuery('#query', '#primary', '#queryList','delete','¿Estás seguro que quieres borrar la consulta?'); return false;"
						    <c:if test="${query.id == null}">disabled="disabled"</c:if>><spring:message code="label.query.delete"/></button>
				<input type="reset" class="cancel right" value="<spring:message code="label.cancel"/>" />
				</form:form>
			</div>
		</div>
		<div id="queryResults"></div>
		<script type="text/javascript">
		
		var queryInitValues = ${queryJson};
		
		  function initPageJS() {
			
				<t:queryCbJs query="${query}"/>
					$('#queryName').val('');
					displayOnLoad('terminal', 5);
					displayOnLoad('hardwareDevice', 5);
					displayOnLoad('financialDevice', 5);
					displayOnLoad('xfsComponent', 5);
					displayOnLoad('jxfsComponent', 5);
					displayOnLoad('operatingSystem', 5);
					displayOnLoad('internetExplorer', 2);
					displayOnLoad('hotfix', 5);
					displayOnLoad('software', 5);
					displayOnLoad('featSw', 5);
					displayOnLoad('xfsSw', 5);
					onLoadValueCB2('terminal', 5);
					onLoadValueCB2('financialDevice', 5);
					onLoadValueCB2('xfsComponent', 5);
					onLoadValueCB2('jxfsComponent', 5);
					onLoadValueCB2('operatingSystem', 5);
					onLoadValueCB2('hotfix', 5);
					onLoadValueCB2('software', 5);
					onLoadValueCB2('featSw', 5);
					onLoadValueCB2('xfsSw', 5);
					onLoadValueCB2('internetExplorer', 2);
					onLoadValueCB3('hardwareDevice', 5);
					loadQueryValues(queryInitValues);
				}
		<%--   var valuesTree = {
		        	<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
		        		<c:set var="value" value="${values.get(key)}"/>
		       	 '${key}': {
						<c:forEach items="${value.keySet()}" var="subkey" varStatus="status2">
			        		<c:set var="subvalue" value="${value.get(subkey)}"/>
							'${subkey}': 
								{
									label: <c:if test="${(key != 'allOperations') && (subkey != 'allHwDevices')}">'<spring:message code="label.${key}.${subkey}"/>'</c:if><c:if test="${(key == 'allOperations') || (subkey == 'allHwDevices')}">''</c:if>,
									values: {
										<c:forEach items="${subvalue.keySet()}" var="subsubkey" varStatus="status3">
						        		<c:set var="subsubvalue" value="${subvalue.get(subsubkey)}"/>
										'${subsubkey}': 
											{
												<c:if test="${subsubvalue.getClass().getSimpleName() == 'TreeMap'}">
												label: <c:if test="${key != 'allOperations'}">'<spring:message code="label.${key}.${subsubkey}"/>'</c:if><c:if test="${key == 'allOperations'}">''</c:if>,
												values: {
													<c:forEach items="${subsubvalue.keySet()}" var="subsubsubkey" varStatus="status4">
									        		<c:set var="subsubsubvalue" value="${subsubvalue.get(subsubsubkey)}"/>
													'${subsubsubkey}': 
													{
														label: '<spring:message code="label.query.operation.${subsubsubkey}"/>',
														values: ${subsubsubvalue}
													}${not status4.last ? ',' : ''}
													</c:forEach>
												}
												</c:if>
												<c:if test="${subsubvalue.getClass().getSimpleName() != 'TreeMap'}">
												label: '<spring:message code="label.query.operation.${subsubkey}"/>',
												values: ${subsubvalue}
												</c:if>
											}${not status3.last ? ',' : ''}
										</c:forEach>
									}
								}${not status2.last ? ',' : ''}
						</c:forEach>
		       	 			}${not status1.last ? ',' : ''}
		       		</c:forEach>
		    }; --%>
		    </script>