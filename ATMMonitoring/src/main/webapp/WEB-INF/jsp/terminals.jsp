<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.terminalsManager" userMsg="${userMsg}"  section="terminals">

    <div id="main">
        <div id="primary">
            <article>
                <div id="header_g">
                    <nav id="breadcrumb">
                        <ul>
                            <li><a href="#">inicio</a></li>
                            <li>Terminales</li>
                        </ul>
                    </nav>
                    <div class="botonera">
                        <ul>
                            <li><a href="terminales_add_terminal.html" class="btn add">Nuevo terminal</a></li>
                        </ul>
                    </div>
                </div>

                <div class="content">
                    <h1><spring:message code="label.terminals"/></h1>
                    <div class="action_box">
                        <h2>Consultas <div class="info"><span>Más información</span></div></h2>
                        <!-- div class="row">
                            <label>Elige tu consulta:</label>
                            <select>
                                <option value="" >Seleccionar</option>
                                <c:forEach items="${userQueries}" var="userQuery">
                                    <option value="${userQuery.id}">${userQuery.name}</option>
                                </c:forEach>
                            </select>
                            <input type="submit" value="Aplicar" class="btn">
                            <a href="queries" class="btn right">Mis consultas</a>
                        </div -->
                        <div class="row">
                           <div class="message no_queries">
                           	<p>Ahorra tiempo generardo consultas, que las irás aplicando a medida que las vayas necesitando.</p>
							<div class="flecha"></div>
                           </div>
                            <a href="queries" class="btn right">Mis consultas</a>
                        </div>
                    </div>
                    <div class="message">
						<p>Sabías que lorem ipsum dolor sit amet, <strong>consectetur adipisicing</strong> elit. Voluptatum, hic, laboriosam ea eaque necessitatibus alias dolor saepe earum et ullam veritatis animi at dignissimos. Consequatur optio cupiditate distinctio quasi amet?</p>
					</div>
                    <div class="notification">
						<p>Los terminales se han priorizado con éxito y sus datos se están actualizando. Esta operación puede llevar un tiempo dependiendo del número de cajeros</p>
					</div>
					<div class="alert">
						<p><strong>Se ha producido un error</strong>. Inténtelo más tarde.</p>
					</div>

					<h2>${pagedListHolder.source.size()} terminales <a href="#" class="edit"><span>edit</span></a></h2>
					<div class="table_buttons">
                    <div class="botonera"> <!-- Repito botonera antes de la tabla -->
						<label for="all_check"><input type="checkbox" class="all_check" name="all_check"/> Marcar todos</label>
						<a href="#" class="btn left update">Actualizar</a>
						<a href="#" class="btn left clock">Actualización planificada</a>
						<a href="#" class="btn download" onclick="$('#exportForm').submit(); return false;" ><spring:message code="label.query.downloadCsv"/></a>
					</div> 
                    <c:if  test="${empty pagedListHolder.pageList}">
                        <div class="empty-list"><spring:message code="label.terminal.noTerminals"/></div>
                    </c:if>
                    <c:if  test="${!empty pagedListHolder.pageList}">

                        <t:terminalsTable terminals="${pagedListHolder.pageList}"/>


                      

                    </c:if>
                    <div class="botonera"> <!-- Repito botonera antes de la tabla -->
						<label for="all_check"><input type="checkbox" class="all_check" name="all_check"/> Marcar todos</label>
						<a href="#" class="btn left update">Actualizar</a>
						<a href="#" class="btn left clock">Actualización planificada</a>
						<a href="#" class="btn download" onclick="$('#exportForm').submit(); return false;" ><spring:message code="label.query.downloadCsv"/></a>
					</div> 
					</div><!-- /table_buttons -->
                   
                    <div class="pagination"> 
 						<div class="t_number">${pagedListHolder.source.size()} Terminales</div>
                    	<div class="p_number">Página <t:paging pagedListHolder="${pagedListHolder}" pagedLink="terminals/list?p=~"/></div>
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
	<h2><spring:message code="label.requestSnmpUpdateTitle"/></h2>
	<button class="form-submit" style="margin: 10px;" onclick="requestSnmpUpdate()"><spring:message code="label.terminal.requestSnmpUpdate"/></button>

	<c:if test="${canManageScheduled == true}">
	<div style="margin: 10px;">
		<a href="terminals/schedules/list" style="font-weight: italic; font-size: 18;"><spring:message code="label.terminal.manageScheduledUpdates"/></a>
	</div>
	</c:if>
	</div>

	<div class="box">
	<h2><spring:message code="label.newTerminal"/></h2>

	<form:form method="post" action="terminals/list" commandName="terminal">

	    <table class="form">
	    <tr>
	        <td class="header first-header"><form:label path="mac"><i><spring:message code="label.terminal.mac"/> *</i></form:label></td>
	        <td><form:input class='form-tf-grey' path="mac" maxlength="17"/></td>
	        <td class="error-td"><form:errors path="mac"/>
	        <c:if test="${duplicatedMac == true}">
	        <spring:message code="label.terminal.duplicatedMac"/>
	        </c:if></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="ip"><i><spring:message code="label.terminal.ip"/> *</i></form:label></td>
	        <td><form:input class='form-tf-grey' path="ip" maxlength="23"/></td>
	        <td class="error-td"><form:errors path="ip"/>
	        <c:if test="${duplicatedIp == true}">
	        <spring:message code="label.terminal.duplicatedIp"/>
	        </c:if></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="serialNumber"><i><spring:message code="label.terminal.serialNumber"/> *</i></form:label></td>
	        <td><form:input class='form-tf-grey' path="serialNumber" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="serialNumber"/>
	        <c:if test="${duplicatedSerialNumber == true}">
	        <spring:message code="label.terminal.duplicatedSerialNumber"/>
	        </c:if></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="terminalType"><i><spring:message code="label.terminal.terminalType"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="terminalType" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="terminalType"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="terminalVendor"><i><spring:message code="label.terminal.terminalVendor"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="terminalVendor" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="terminalVendor"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="frontReplenish"><i><spring:message code="label.terminal.frontReplenish"/></i></form:label></td>
	        <td><form:checkbox path="frontReplenish"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="bank"><i><spring:message code="label.terminal.bank"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="bank" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="bank"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="branch"><i><spring:message code="label.terminal.branch"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="branch" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="branch"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="geographicAddress"><i><spring:message code="label.terminal.geographicAddress"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="geographicAddress" maxlength="150"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="address"><i><spring:message code="label.terminal.address"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="address" maxlength="100"/></td>
	        <td class="error-td"><form:errors path="address"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="city"><i><spring:message code="label.terminal.city"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="city" maxlength="35"/></td><td><form:errors path="city"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="zipCode"><i><spring:message code="label.terminal.zipCode"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="zipCode" maxlength="15"/></td>
	        <td class="error-td"><form:errors path="zipCode"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="area"><i><spring:message code="label.terminal.area"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="area" maxlength="35"/></td>
	        <td class="error-td"><form:errors path="area"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="country"><i><spring:message code="label.terminal.country"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="country" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="country"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="manufacturingSite"><i><spring:message code="label.terminal.manufacturingSite"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="manufacturingSite" maxlength="20"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="model"><i><spring:message code="label.terminal.model"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="model" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="model"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="productClass"><i><spring:message code="label.terminal.productClass"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="productClass" maxlength="20"/></td>
	        <td class="error-td"><form:errors path="productClass"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="productClassDescription"><i><spring:message code="label.terminal.productClassDescription"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="productClassDescription" maxlength="120"/></td>
	    </tr>
	    <tr>
	        <td class="header last-header"><form:label path="tracerNumber"><i><spring:message code="label.terminal.tracerNumber"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="tracerNumber" maxlength="20"/></td>
	    </tr>
		<tr><td colspan="2">
			<font size="2"><i><spring:message code="label.requiredFields"/></i></font>
			<input type="submit" class="form-submit" value="<spring:message code="label.terminal.addTerminal"/>" style="float: right;"/>
		</td></tr>
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

</t:osoco-wrapper>
