<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}"  section="terminals">
	
	<jsp:attribute name="header">
		<script type="text/javascript">
        $(function() {
        	$("#queryDate").datepicker({ dateFormat: "dd/mm/yy" });
            $("#queryDateButton").click(function(event) {
                event.preventDefault();
                $("#queryDate").datepicker("show");
            });
            $("thead th.order").click(function(event) {
                var headerUrl = $(this).find("a").attr("href");
                document.location.href = headerUrl;
            });
            $("#terminals tbody tr").click(function(event) {
                var terminalUrl = $(this).find("a").attr("href");
                document.location.href = terminalUrl;
            });
        });
    </script>
	</jsp:attribute>

	<jsp:body>
		<fmt:formatDate value="${queryDate}" pattern="dd/MM/yyyy" var="stringQueryDate"/>
		
		<div id="header_g">
			<nav id="breadcrumb">
				<ul>
					<li>
						<a href="dashboard">
							<spring:message code="breadcrumb.home"/>
						</a>
					</li>
					<li>
						<spring:message code="breadcrumb.terminals"/>
					</li>
				</ul>
			</nav>
			<div class="botonera">
				<ul>
					<sec:authorize access="hasAnyRole(${terminalsManagementAllowedRoles})">
						<li>
							<a href="terminals/new" class="btn add">
								<spring:message code="label.terminal.new"/>
							</a>
						</li>
					</sec:authorize>
				</ul>
			</div>
		</div>

		<div class="content">
			<h1>
				<spring:message code="label.terminals"/>
			</h1>
			<sec:authorize access="hasAnyRole(${queriesAccessAllowedRoles})">
				<div class="action_box">
					<h2>
						<spring:message code="label.queries"/>
						<a href="#help_pop" class="info inline">
							<span>
								<spring:message code="label.moreInfo"/>
							</span>
						</a>
					</h2>
	
					<div class="row">
						<a href="queries" class="btn right">
							<spring:message code="label.queries.mine"/>
						</a>
						<c:if test="${userQueries == null}">
							<div class="message no_queries">
								<p>
									<spring:message code="label.queries.tip"/>
								</p>
								<div class="flecha"></div>
							</div>
						</c:if>
						<c:if test="${userQueries != null && !userQueries.isEmpty()}">
							<form method="post" name="userQueriesForm" action="terminals/byQuery">
								<label>
									<spring:message code="label.choose.query"/>:
								</label>
								<select name="queryId" size="1">
									<option value="" ><spring:message code="label.select.default"/></option>
									<c:forEach items="${userQueries}" var="userQuery">
										<option value="${userQuery.id}" ${query.id == userQuery.id? 'selected': ''}>${userQuery.name}</option>
									</c:forEach>
								</select>
	
								<input id="queryDate" type="text" name="queryDate" 
								   value="${stringQueryDate}">
								<a href="" id="queryDateButton" class="btn calendar">
									<span>
										<spring:message code="label.calendar.open"/>
									</span>
								</a>
								<input type="submit" value="<spring:message code="label.apply"/>" class="btn">
							</form>
						</c:if>
					</div>
				</div>
			</sec:authorize>
			<c:if test="${timeout}">
				<div class="message">
					<p>${timeout}</p>
				</div>
			</c:if>
			<c:if test="${success}">
				<div class="notification">
					<p>${success}</p>
				</div>
			</c:if>

			<h2>
				${pagedListHolder.source.size()}
				<spring:message code="label.terminals"/>

				<c:if test="${query != null}">
					<spring:message code="label.forquery"/>
					: ${query.name}
					<a href="queries/show?queryId=${query.id}" class="edit">
						<span>
							<g:message code="label.edit"/>
						</span>
					</a>
				</c:if>
			</h2>

			<c:if  test="${empty pagedListHolder.pageList}">
				<div class="message">
					<p>
						<spring:message code="label.terminal.noTerminals"/>
					</p>
				</div>
			</c:if>
			<c:if  test="${!empty pagedListHolder.pageList}">
				<div class="table_buttons">
					<div class="botonera">
						<!-- Repito botonera antes de la tabla -->
						<c:if test="${query == null}">
							<sec:authorize access="hasAnyRole(${terminalsUpdateRequestAllowedRoles})">
								<a href="terminals/request" class="btn left update">
									<spring:message code="label.update"/>
								</a>
							</sec:authorize>
							<sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
								<a href="terminals/schedules/new" class="btn left clock">
									<spring:message code="label.update.schedule"/>
								</a>
							</sec:authorize>
							<a href="terminals/exportAll" class="btn download" target="_blank" >
								<spring:message code="label.query.downloadCsv"/>
							</a>
						</c:if>
						<c:if test="${query != null}">
							<sec:authorize access="hasAnyRole(${terminalsUpdateRequestAllowedRoles})">
								<a href="terminals/request?queryId=${query.id}" class="btn left update">
									<spring:message code="label.update"/>
								</a>
							</sec:authorize>
							<sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
								<a href="terminals/schedules/new?queryId=${query.id}" class="btn left clock">
									<spring:message code="label.update.schedule"/>
								</a>
							</sec:authorize>
							<a href="terminals/export/${query.id}" class="btn download" target="_blank" >
								<spring:message code="label.query.downloadCsv"/>
							</a>
						</c:if>
					</div>

					<div class="margin-box">
						<t:terminalsTable terminals="${pagedListHolder.pageList}" stringQueryDate="${stringQueryDate}"
                                           baseUrl="${query != null ? 'terminals/byQuery' : 'terminals/list'}"/>
					</div>

					<div class="botonera">
						<!-- Repito botonera después de la tabla -->
						<c:if test="${query == null}">
							<sec:authorize access="hasAnyRole(${terminalsUpdateRequestAllowedRoles})">
								<a href="terminals/request" class="btn left update">
									<spring:message code="label.update"/>
								</a>
							</sec:authorize>
							<sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
								<a href="terminals/schedules/new" class="btn left clock">
									<spring:message code="label.update.schedule"/>
								</a>
							</sec:authorize>
							<a href="terminals/exportAll" class="btn download" target="_blank" >
								<spring:message code="label.query.downloadCsv"/>
							</a>
						</c:if>
						<c:if test="${query != null}">
							<sec:authorize access="hasAnyRole(${terminalsUpdateRequestAllowedRoles})">
								<a href="terminals/request" class="btn left update">
									<spring:message code="label.update"/>
								</a>
							</sec:authorize>
							<sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
								<a href="terminals/schedules/new?queryId=${query.id}" class="btn left clock">
									<spring:message code="label.update.schedule"/>
								</a>
							</sec:authorize>
							<a href="terminals/export/${query.id}" class="btn download" target="_blank" >
								<spring:message code="label.query.downloadCsv"/>
							</a>
						</c:if>
					</div>
				</div>
				<!-- /table_buttons -->

				<div class="pagination">
					<div class="t_number">
						<span class="text">
							${pagedListHolder.source.size()}
							<spring:message code="label.terminals"/>
						</span>

					</div>

					<div class="p_number">
						<c:if test="${pagedListHolder.getPageCount() >
							1 }">
							<span class="text">
								<spring:message code="label.page"/>
							</span>

							<t:paging pagedListHolder="${pagedListHolder}" 
									  pagedLink="terminals/${(query != null)?'byQuery':'list'}?p=~&queryId=${query.id}&sort=${sort}&order=${order}&queryDate=${stringQueryDate}"/>
						</div>
					</c:if>
				</div>

			</div>

		</c:if>

		<div class="hide">
			<div id="help_pop" class="inline">
				<!-- <div class="content">
					<h1>
						<spring:message code="label.terminals"/>
					</h1>
					<h2>
						<spring:message code="label.queries"/>
					</h2>
					<p>
						Scelerisque montes est et! Sit dignissim, sed, aenean ac scelerisque. Pulvinar ac! Elementum natoque penatibus scelerisque sociis tempor, hac ridiculus ac augue non et. Magna dignissim lundium rhoncus turpis! Porttitor eros dis proin pulvinar sagittis ac, facilisis porta mauris tincidunt scelerisque pulvinar. Arcu augue eu. Penatibus sit phasellus lorem in.
					</p>

					<p>
						Ultrices! A, nisi. Parturient amet ac ut et, phasellus odio aenean montes tincidunt eu. Aliquet? Turpis augue? Porta ultrices dignissim enim, sed sit arcu ac porttitor dapibus augue? Turpis nec dignissim augue scelerisque. Dignissim tempor amet sed turpis aliquet, arcu vel in diam? In, in, scelerisque montes eu, velit.
					</p>

					<ol>
						<li>Pulvinar ac!</li>
						<li>Dignissim vel</li>
						<li>Egestas etiam</li>
						<li>Ridiculus elementum</li>
						p
					</ol>

					<p>
						Etiam amet dignissim vel pulvinar, sit in pulvinar habitasse! In scelerisque! Platea hac natoque proin placerat in, elementum, augue etiam dolor amet augue urna nascetur egestas mauris habitasse. Velit? Sed mattis? Magna sed egestas mauris amet et ridiculus sociis! Et velit ut vel, aliquam et pulvinar, et enim turpis.
					</p>

					<p>
						Aliquet. Ridiculus elementum. Egestas etiam? Porttitor porta nisi. Rhoncus. Arcu aenean? Nunc nisi hac, magna montes dis, dolor ridiculus porta purus rhoncus proin augue ut, mauris pulvinar ultricies parturient vut elementum lacus! Enim magna? Sed magnis in dis ultricies dolor pulvinar, parturient porttitor pulvinar, pellentesque auctor lundium, hac ridiculus.
					</p>

					<p>
						Nisi, lorem arcu eu ut cursus, massa! Sit, sit, turpis penatibus elit ut tristique? Placerat! Dolor turpis in integer ac phasellus vut augue, eu ridiculus et sagittis platea hac nunc et, habitasse rhoncus, elementum pulvinar parturient sit facilisis non? Platea dolor egestas diam in dapibus. Urna non eu odio.
					</p>

					<p>
						Tristique? Pulvinar dis, porta! Integer? Nunc sit nisi vel, scelerisque aliquam phasellus dictumst, pid a risus mid platea tincidunt a vel, augue mid? Nunc lorem! Dolor natoque lorem elementum tristique dignissim placerat sed. Natoque, amet elementum sed? Rhoncus turpis a sociis auctor aliquam et cursus dapibus lectus porttitor proin.
					</p>
				</div> -->
				<c:import url="/resources/help/${localeCode}/terminals.html" />
			</div>
		</div>
	</article>
</div>
<!-- /primary -->
</div>

<!-- /#main -->
<%--
<c:if test="${canAdd == true}">

<div class="box">
<h2>
	<spring:message code="label.requestSnmpUpdateTitle"/>
</h2>
<button class="form-submit" style="margin: 10px;" onclick="requestSnmpUpdate()">
	<spring:message code="label.terminal.requestSnmpUpdate"/>
</button>

<c:if test="${canManageScheduled == true}">
	<div style="margin: 10px;">
		<a href="terminals/schedules/list" style="font-weight: italic; font-size: 18;">
			<spring:message code="label.terminal.manageScheduledUpdates"/>
		</a>
	</div>
</c:if>
</div>

<div class="box">
<h2>
	<spring:message code="label.newTerminal"/>
</h2>

<form:form method="post" action="terminals/list" commandName="terminal">

	<table class="form">
		<tr>
			<td class="header first-header">
				<form:label path="mac"> <i><spring:message code="label.terminal.mac"/>
						*</i> 
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="mac" maxlength="17"/>
			</td>
			<td class="error-td">
				<form:errors path="mac"/>
				<c:if test="${duplicatedMac == true}">
					<spring:message code="label.terminal.duplicatedMac"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="ip"> <i><spring:message code="label.terminal.ip"/>
						*</i> 
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="ip" maxlength="23"/>
			</td>
			<td class="error-td">
				<form:errors path="ip"/>
				<c:if test="${duplicatedIp == true}">
					<spring:message code="label.terminal.duplicatedIp"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="serialNumber">
					<i>
						<spring:message code="label.terminal.serialNumber"/>
						*
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="serialNumber" maxlength="50"/>
			</td>
			<td class="error-td">
				<form:errors path="serialNumber"/>
				<c:if test="${duplicatedSerialNumber == true}">
					<spring:message code="label.terminal.duplicatedSerialNumber"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="terminalType">
					<i>
						<spring:message code="label.terminal.terminalType"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="terminalType" maxlength="50"/>
			</td>
			<td class="error-td">
				<form:errors path="terminalType"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="terminalVendor">
					<i>
						<spring:message code="label.terminal.terminalVendor"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="terminalVendor" maxlength="50"/>
			</td>
			<td class="error-td">
				<form:errors path="terminalVendor"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="frontReplenish">
					<i>
						<spring:message code="label.terminal.frontReplenish"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:checkbox path="frontReplenish"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="bank">
					<i>
						<spring:message code="label.terminal.bank"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="bank" maxlength="50"/>
			</td>
			<td class="error-td">
				<form:errors path="bank"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="branch">
					<i>
						<spring:message code="label.terminal.branch"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="branch" maxlength="50"/>
			</td>
			<td class="error-td">
				<form:errors path="branch"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="geographicAddress">
					<i>
						<spring:message code="label.terminal.geographicAddress"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="geographicAddress" maxlength="150"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="city">
					<i>
						<spring:message code="label.terminal.city"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="city" maxlength="35"/>
			</td>
			<td>
				<form:errors path="city"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="zipCode">
					<i>
						<spring:message code="label.terminal.zipCode"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="zipCode" maxlength="15"/>
			</td>
			<td class="error-td">
				<form:errors path="zipCode"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="area">
					<i>
						<spring:message code="label.terminal.area"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="area" maxlength="35"/>
			</td>
			<td class="error-td">
				<form:errors path="area"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="country">
					<i>
						<spring:message code="label.terminal.country"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="country" maxlength="50"/>
			</td>
			<td class="error-td">
				<form:errors path="country"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="manufacturingSite">
					<i>
						<spring:message code="label.terminal.manufacturingSite"/>
					</i>
				</form:label>
			</td>
			<td>
				<form:input class='form-tf-grey' path="manufacturingSite" maxlength="20"/>
			</td>
		</tr>
		<tr>
			<td class="header">
				<form:label path="model">
					<i>
						<spring:message code="label.terminal.model"/p></i>
					</form:label>
				</td>
				<td>
					<form:input class='form-tf-grey' path="model" maxlength="20"/>
				</td>
				<td class="error-td">
					<form:errors path="model"/>
				</td>
			</tr>
			<tr>
				<td class="header">
					<form:label path="productClassDescription">
						<i>
							<spring:message code="label.terminal.productClassDescription"/>
						</i>
					</form:label>
				</td>
				<td>
					<form:input class='form-tf-grey' path="productClassDescription" maxlength="120"/>
				</td>
			</tr>
			<tr>
				<td class="header last-header">
					<form:label path="tracerNumber">
						<i>
							<spring:message code="label.terminal.tracerNumber"/>
						</i>
					</form:label>
				</td>
				<td>
					<form:input class='form-tf-grey' path="tracerNumber" maxlength="20"/>
				</td>
			</tr>
			<tr>
				<td colspan="2"> <font size="2"><i>
							<spring:message code="label.requiredFields"/>
						</i></font> 
					<input type="submit" class="form-submit" value="<spring:message code="label.terminal.addTerminal"/>
					" style="float: right;"/>
				</td>
			</tr>
		</table>
	</form:form>
</div>

<script type="text/javascript">
		function requestSnmpUpdate() {
			if (window.confirm('<spring:message code="label.terminal.requestSnmpUpdateConfirm"/>')) {
				$.blockUI({
		            theme:     true,
		            title:    '<spring:message code="label.terminal.requestSnmpUpdateFrameTitle"/>',
		            message:  '<center><p><spring:message code="label.terminal.requestSnmpUpdateFrameMessage"/></p><br><div id="spinner" style="height:20px;"/></center>',
		            themedCSS: {
		                width: '275px',
		                height: '150px'
		            }
		        });
				$("#spinner").spin("small");
				window.location.href = "terminals/request";
			}
		}
	</script>
</c:if>
--%>
</jsp:body>

</t:osoco-wrapper>
