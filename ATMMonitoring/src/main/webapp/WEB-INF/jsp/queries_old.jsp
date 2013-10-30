<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="terminals">
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
							<li>Mis consultas</li>
						</ul>
					</nav>
				</div>

				<div class="content">
					<h1>
						<spring:message code="label.queryDesigner"/>
					</h1>
					<div class="query-designer">
						<form:form method="post" name="userQueriesForm" action="queries/create" commandName="query">
							<div class="query-submit">
								<label class="plain-label">
									<spring:message code="label.query.userQueries"/>
								</label>
								<form:select path="id" id="id" size="1" onchange="userQuerySelected()">
									<form:option value="" label=""/>
									<c:forEach items="${userQueries}" var="userQuery">
										<form:option value="${userQuery.id}" label="${userQuery.name}"/>
									</c:forEach>
								</form:select>
							</div>
							<div class="query-submit">
								<input type="submit" class="form-submit" name="delete" id="delete" 
	    <c:if test="${query.id == null}">disabled="disabled"</c:if> value="<spring:message code="label.query.delete"/> "/>
						</div>
					</form:form>
					<div class="queries-notes">
						<label>
							<spring:message code="label.query.dateFormatNote"/>
							'${datePattern}'
						</label>
					</div>
					<form:form method="post" target="_blank" action="queries/results" commandName="query">
						<h2 class="collapsible" id="terminalSection">
							<spring:message code="label.query.terminalSection"/>
							<span></span>
						</h2>
						<div class="container">
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
										<form:select path="terminalCombo${i}1" id="terminalCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('terminal',${i})">
											<form:option value="" label=""/>
											<c:forEach items="${values.get('terminal').keySet()}" var="value">
												<form:option value="${value}">
													<spring:message code="label.terminal.${value}"/>
												</form:option>
											</c:forEach>
										</form:select>
									</td>
									<td>
										<form:checkbox path="terminalCB${i}" id="terminalCB${i}" disabled="true"/>
									</td>
									<td>
										<form:select path="terminalCombo${i}2" id="terminalCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('terminal',${i})">
											<form:option value="" label=""/>
										</form:select>
									</td>
									<td>
										<form:input class='form-tf-grey' path="terminalField${i}" id="terminalField${i}" disabled="true" maxlength="150"/>
										<br></td>
									<c:if test="${!status.last}">
										<td class="btn_add">
											<div id="terminalShowButton${i}" onclick="showHiddenRow('terminal', ${i})" class="btn add">Añadir</div>
										</td>
									</c:if>
								</tr>
							</c:forEach>
						</table>
					</div>
					<h2 class="collapsible" id="hwSection">
						<spring:message code="label.query.hardwareSection"/>
						<span></span>
					</h2>
					<div class="container">
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
									<form:select path="hardwareDeviceCombo${i}1" id="hardwareDeviceCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue3CB1('hardwareDevice', ${i})">
										<form:option value="" label=""/>
										<c:forEach items="${values.get('hardwareDevice').keySet()}" var="value">
											<form:option value="${value}">
												<spring:message code="label.hardwareDevice.${value}"/>
											</form:option>
										</c:forEach>
									</form:select>
								</td>
								<td>
									<form:select path="hardwareDeviceCombo${i}2" id="hardwareDeviceCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue3CB2('hardwareDevice', ${i})">
										<form:option value="" label=""/>
									</form:select>
								</td>
								<td>
									<form:checkbox path="hardwareDeviceCB${i}" id="hardwareDeviceCB${i}" disabled="true"/>
								</td>
								<td>
									<form:select path="hardwareDeviceCombo${i}3" id="hardwareDeviceCombo${i}3" class="query_selectors" size="1" disabled="true" onchange="ChangeValue3CB3('hardwareDevice', ${i})">
										<form:option value="" label=""/>
									</form:select>
								</td>
								<td>
									<form:input class='form-tf-grey' path="hardwareDeviceField${i}" id="hardwareDeviceField${i}" disabled="true" maxlength="150"/>
									<br></td>
								<c:if test="${!status.last}">
									<td class="btn_add">
										<div id="hardwareDeviceShowButton${i}" onclick="showHiddenRow('hardwareDevice', ${i})" class="btn add">Añadir</div>
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
							<tr id="financialDeviceRow${i}" <c:if test="${!status.first}">class="hidden"</c:if>
							>
							<td>
								<form:select path="financialDeviceCombo${i}1" id="financialDeviceCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('financialDevice', ${i})">
									<form:option value="" label=""/>
									<c:forEach items="${values.get('financialDevice').keySet()}" var="value">
										<form:option value="${value}">
											<spring:message code="label.financialDevice.${value}"/>
										</form:option>
									</c:forEach>
								</form:select>
							</td>
							<td>
								<form:checkbox path="financialDeviceCB${i}" id="financialDeviceCB${i}" disabled="true"/>
							</td>
							<td>
								<form:select path="financialDeviceCombo${i}2" id="financialDeviceCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('financialDevice', ${i})">
									<form:option value="" label=""/>
								</form:select>
							</td>
							<td>
								<form:input class='form-tf-grey' path="financialDeviceField${i}" id="financialDeviceField${i}" disabled="true" maxlength="150"/>
								<br></td>
							<c:if test="${!status.last}">
								<td class="btn_add">
									<div id="financialDeviceShowButton${i}" onclick="showHiddenRow('financialDevice', ${i})" class="btn add">Añadir</div>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</div>
			<h2 class="collapsible" id="swSection">
				<spring:message code="label.query.softwareGlobalSection"/>
				<span></span>
			</h2>
			<div class="container">
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
							<form:select path="operatingSystemCombo${i}1" id="operatingSystemCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('operatingSystem', ${i})">
								<form:option value="" label=""/>
								<c:forEach items="${values.get('operatingSystem').keySet()}" var="value">
									<form:option value="${value}">
										<spring:message code="label.operatingSystem.${value}"/>
									</form:option>
								</c:forEach>
							</form:select>
						</td>
						<td>
							<form:checkbox path="operatingSystemCB${i}" id="operatingSystemCB${i}" disabled="true"/>
						</td>
						<td>
							<form:select path="operatingSystemCombo${i}2" id="operatingSystemCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('operatingSystem', ${i})">
								<form:option value="" label=""/>
							</form:select>
						</td>
						<td>
							<form:input class='form-tf-grey' path="operatingSystemField${i}" id="operatingSystemField${i}" disabled="true" maxlength="150"/>
							<br></td>
						<c:if test="${!status.last}">
							<td class="btn_add">
								<div id="operatingSystemShowButton${i}" onclick="showHiddenRow('operatingSystem', ${i})"  class="btn add">Añadir</div>
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
						<form:select path="internetExplorerCombo${i}1" id="internetExplorerCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('internetExplorer', ${i})">
							<form:option value="" label=""/>
							<c:forEach items="${values.get('internetExplorer').keySet()}" var="value">
								<form:option value="${value}">
									<spring:message code="label.internetExplorer.${value}"/>
								</form:option>
							</c:forEach>
						</form:select>
					</td>
					<td>
						<form:checkbox path="internetExplorerCB${i}" id="internetExplorerCB${i}" disabled="true"/>
					</td>
					<td>
						<form:select path="internetExplorerCombo${i}2" id="internetExplorerCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('internetExplorer', ${i})">
							<form:option value="" label=""/>
						</form:select>
					</td>
					<td>
						<form:input class='form-tf-grey' path="internetExplorerField${i}" id="internetExplorerField${i}" disabled="true" maxlength="150"/>
						<br></td>
					<c:if test="${!status.last}">
						<td class="btn_add">
							<div id="internetExplorerShowButton${i}" onclick="showHiddenRow('internetExplorer', ${i})" class="btn add">Añadir</div>
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
					<form:select path="hotfixCombo${i}1" id="hotfixCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('hotfix', ${i})">
						<form:option value="" label=""/>
						<c:forEach items="${values.get('hotfix').keySet()}" var="value">
							<form:option value="${value}">
								<spring:message code="label.hotfix.${value}"/>
							</form:option>
						</c:forEach>
					</form:select>
				</td>
				<td>
					<form:checkbox path="hotfixCB${i}" id="hotfixCB${i}" disabled="true"/>
				</td>
				<td>
					<form:select path="hotfixCombo${i}2" id="hotfixCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('hotfix', ${i})">
						<form:option value="" label=""/>
					</form:select>
				</td>
				<td>
					<form:input class='form-tf-grey' path="hotfixField${i}" id="hotfixField${i}" disabled="true" maxlength="150"/>
					<br></td>
				<c:if test="${!status.last}">
					<td class="btn_add">
						<div id="hotfixShowButton${i}" onclick="showHiddenRow('hotfix', ${i})" class="btn add">Añadir</div>
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
				<form:select path="softwareCombo${i}1" id="softwareCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('software', ${i})">
					<form:option value="" label=""/>
					<c:forEach items="${values.get('software').keySet()}" var="value">
						<form:option value="${value}">
							<spring:message code="label.software.${value}"/>
						</form:option>
					</c:forEach>
				</form:select>
			</td>
			<td>
				<form:checkbox path="softwareCB${i}" id="softwareCB${i}" disabled="true"/>
			</td>
			<td>
				<form:select path="softwareCombo${i}2" id="softwareCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('software', ${i})">
					<form:option value="" label=""/>
				</form:select>
			</td>
			<td>
				<form:input class='form-tf-grey' path="softwareField${i}" id="softwareField${i}" disabled="true" maxlength="150"/>
				<br></td>
			<c:if test="${!status.last}">
				<td class="btn_add">
					<div id="softwareShowButton${i}" onclick="showHiddenRow('software', ${i})"  class="btn add">Añadir</div>
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
			<form:select path="featSwCombo${i}1" id="featSwCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('featSw', ${i})">
				<form:option value="" label=""/>
				<c:forEach items="${values.get('featSw').keySet()}" var="value">
					<form:option value="${value}">
						<spring:message code="label.featSw.${value}"/>
					</form:option>
				</c:forEach>
			</form:select>
		</td>
		<td>
			<form:checkbox path="featSwCB${i}" id="featSwCB${i}" disabled="true"/>
		</td>
		<td>
			<form:select path="featSwCombo${i}2" id="featSwCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('featSw', ${i})">
				<form:option value="" label=""/>
			</form:select>
		</td>
		<td>
			<form:input class='form-tf-grey' path="featSwField${i}" id="featSwField${i}" disabled="true" maxlength="150"/>
			<br></td>
		<c:if test="${!status.last}">
			<td class="btn_add">
				<div id="featSwShowButton${i}" onclick="showHiddenRow('featSw', ${i})" class="btn add">Añadir</div>
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
		<form:select path="xfsSwCombo${i}1" id="xfsSwCombo${i}1" class="query_selectors" size="1" onchange="ChangeValue2CB1('xfsSw', ${i})">
			<form:option value="" label=""/>
			<c:forEach items="${values.get('xfsSw').keySet()}" var="value">
				<form:option value="${value}">
					<spring:message code="label.xfsSw.${value}"/>
				</form:option>
			</c:forEach>
		</form:select>
	</td>
	<td>
		<form:checkbox path="xfsSwCB${i}" id="xfsSwCB${i}" disabled="true"/>
	</td>
	<td>
		<form:select path="xfsSwCombo${i}2" id="xfsSwCombo${i}2" class="query_selectors" size="1" disabled="true" onchange="ChangeValue2CB2('xfsSw', ${i})">
			<form:option value="" label=""/>
		</form:select>
	</td>
	<td>
		<form:input class='form-tf-grey' path="xfsSwField${i}" id="xfsSwField${i}" disabled="true" maxlength="150"/>
		<br></td>
	<c:if test="${!status.last}">
		<td class="btn_add">
			<div id="xfsSwShowButton${i}" onclick="showHiddenRow('xfsSw', ${i})" class="add btn">Añadir</div>
		</td>
	</c:if>
</tr>
</c:forEach>
</table>
</div>
<div class="query-submit">
<input type="submit" class="form-submit" name="execute" id="execute" value="<spring:message code="label.query.execute"/>
"/>
</div>
<div class="query-submit">
<label class="plain-label">
<spring:message code="label.query.description"/>
</label>
<form:input class='thin-border-grey' path="description" id="queryDescription" maxlength="200"/>
<label class="plain-label">
<spring:message code="label.query.queryName"/>
</label>
<form:input class='thin-border-grey' path="name" id="queryName" maxlength="50" onKeyUp="checkSaveExecute()"/>
<input type="submit" class="form-submit" name="save_execute" disabled="disabled" id="save_execute" value="<spring:message code="label.query.saveExecute"/>
"/>
</div>
</form:form>
<div class="botonera">
<a href="#" class="btn">Guardar Consulta</a>
<a href="#" class="btn">Aplicar Consulta</a>
<a href="#" class="btn cancel">Cancelar</a>
</div>
</div>

<script type="text/javascript">
	    $(document).ready(function(){
			$('.collapsible').collapsible({
	            defaultOpen: 'terminalSection'
	        });
			<t:queryCbJs query="${query}"/>
			$('#queryName').val('');
			displayOnLoad('terminal', 5);
			displayOnLoad('hardwareDevice', 5);
			displayOnLoad('financialDevice', 5);
			displayOnLoad('operatingSystem', 5);
			displayOnLoad('internetExplorer', 2);
			displayOnLoad('hotfix', 5);
			displayOnLoad('software', 5);
			displayOnLoad('featSw', 5);
			displayOnLoad('xfsSw', 5);
		});
	    var valuesTree = {
	        	<c:forEach items="${values.keySet()}" var="key" varStatus="status1">
	        		<c:set var="value" value="${values.get(key)}"/>
	       	 '${key}': {
					<c:forEach items="${value.keySet()}" var="subkey" varStatus="status2">
		        		<c:set var="subvalue" value="${value.get(subkey)}"/>
						'${subkey}': 
							{
								label: '<spring:message code="label.${key}.${subkey}"/>',
								values: {
									<c:forEach items="${subvalue.keySet()}" var="subsubkey" varStatus="status3">
					        		<c:set var="subsubvalue" value="${subvalue.get(subsubkey)}"/>
									'${subsubkey}': 
										{
											<c:if test="${subsubvalue.getClass().getSimpleName() == 'TreeMap'}">
											label: '<spring:message code="label.${key}.${subsubkey}"/>',
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
	    };
	    function displayOnLoad(name, maxValue) {
	    	for (i=maxValue; i>1; i--) {
	    		if ($('#' + name + 'Combo' + i + '1').val() != '') {
	    			for (j=1; j<i; j++) {
		    			showHiddenRow(name, j);
	    			}
	    			break;
	    		}
	    	}
	    };
	    function ChangeValue2CB1(entity, number){
			var $cb = $('#' + entity + 'Combo' + number + '2');
			$cb.empty();
			$cb.append($('<option selected="selected"></option>'));
			if ($('#' + entity + 'Combo' + number + '1').val() != '') {
				var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values;
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
					  $cb.append($('<option/>')
					     .attr("value", key).text(values[key].label));
				});
			    $('#' + entity + 'CB' + number).prop('disabled', false);
				$cb.prop('disabled', false);
			} else {
			    $('#' + entity + 'CB' + number).prop('disabled', true);
				$cb.prop('disabled', true);
			};
		    $('#' + entity + 'Field' + number).prop('disabled', true);
	    };
	    function ChangeValue2CB2(entity, number){
			if ($('#' + entity + 'Combo' + number + '2').val() != '') {
				if (valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$('#' + entity + 'Combo' + number + '2').val()].values) {
				    $('#' + entity + 'Field' + number).prop('disabled', false);
				} else {
					$('#' + entity + 'Field' + number).prop('disabled', true);
				}
			} else {
			    $('#' + entity + 'Field' + number).prop('disabled', true);
			};
	    };
	    function ChangeValue3CB1(entity, number){
			var $cb = $('#' + entity + 'Combo' + number + '2');
			$cb.empty();
			$cb.append($('<option selected="selected"></option>'));
			if ($('#' + entity + 'Combo' + number + '1').val() != '') {
				var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values;
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
					  $cb.append($('<option/>')
					     .attr("value", key).text(values[key].label));
				});
			    $('#' + entity + 'CB' + number).prop('disabled', false);
				$cb.prop('disabled', false);
			} else {
				$cb.prop('disabled', true);
			};
			$('#' + entity + 'Combo' + number + '3').prop('disabled', true);
		    $('#' + entity + 'CB' + number).prop('disabled', true);
		    $('#' + entity + 'Field' + number).prop('disabled', true);
	    };
	    function ChangeValue3CB2(entity, number){
			var $cb = $('#' + entity + 'Combo' + number + '3');
			$cb.empty();
			$cb.append($('<option selected="selected"></option>'));
			if ($('#' + entity + 'Combo' + number + '2').val() != '') {
				var values = valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$('#' + entity + 'Combo' + number + '2').val()].values
				var keys = $.map(values, function(v, i){
					  return i;
					});
				keys.sort(function(a,b){
				    var compA = values[a].label;
				    var compB = values[b].label;
				    return (compA < compB) ? -1 : (compA > compB) ? 1 : 0;
				  });
				$.each(keys, function(index, key) {
					  $cb.append($('<option/>')
					     .attr("value", key).text(values[key].label));
				});
			    $('#' + entity + 'CB' + number).prop('disabled', false);
				$cb.prop('disabled', false);
			} else {
			    $('#' + entity + 'CB' + number).prop('disabled', true);
				$cb.prop('disabled', true);
			};
		    $('#' + entity + 'Field' + number).prop('disabled', true);
	    };
	    function ChangeValue3CB3(entity, number){
			if ($('#' + entity + 'Combo' + number + '3').val() != '') {
				if (valuesTree[entity][$('#' + entity + 'Combo' + number + '1').val()].values[$('#' + entity + 'Combo' + number + '2').val()].values[$('#' + entity + 'Combo' + number + '3').val()].values) {
				    $('#' + entity + 'Field' + number).prop('disabled', false);
				} else {
					$('#' + entity + 'Field' + number).prop('disabled', true);
				}
			} else {
			    $('#' + entity + 'Field' + number).prop('disabled', true);
			};
	    };
	    function checkSaveExecute() {
	    	if ($('#queryName').val().length > 0) {
	    		if ($("#save_execute").button("option", "disabled")) {
	    			$("#save_execute").button("option", "disabled", false);
	    		}
	    	} else {
	    		if (!$("#save_execute").button("option", "disabled")) {
	    			$("#save_execute").button("option", "disabled", true);
	    		}
	    	}
	    }
	    function showHiddenRow(name, rowNumber) {
	    	$('#' + name + 'Row' + (rowNumber + 1)).removeClass('hidden');
	    	$('#' + name + 'ShowButton' + rowNumber).addClass('hidden');
	    }
	    function userQuerySelected()
	    {
	    	document.userQueriesForm.submit();
	    }
    </script>
</div>
</article>
</div>
</div>
</t:osoco-wrapper>