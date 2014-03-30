<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.terminalsManager" userMsg="${userMsg}">
<h1><spring:message code="label.terminalsManager"/></h1>

<div class="box">
	<h2><spring:message code="label.terminals"/></h2>
	<div class="box-tableContainer">
		<c:if  test="${empty pagedListHolder.pageList}">
		<div class="empty-list"><spring:message code="label.terminal.noTerminals"/></div>
		</c:if>
		<c:if  test="${!empty pagedListHolder.pageList}">
			<t:terminalsTable terminals="${pagedListHolder.pageList}"/>
			<div class="pagingContainer">
			<t:paging pagedListHolder="${pagedListHolder}" pagedLink="terminals/list?p=~"/>
			</div>
		</c:if>
	</div>
</div>

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

	<form:form method="post" commandName="terminal">

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
	        <td class="header"><form:label path="tracerNumber"><i><spring:message code="label.terminal.tracerNumber"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="tracerNumber" maxlength="20"/></td>
	    </tr>
	    <tr>
	    	<td class="header"><form:label path="bankCompany"><i><spring:message code="label.terminal.bankCompany"/></i></form:label></td>
	    	<td>
	    		<form:select path="bankCompany.id" style="width: 100%;">
					<form:option value="" label=""/>
					<form:options items="${banksList}" itemValue="id" itemLabel="name" />
				</form:select>
			</td>
		</tr>
	    <tr>
	    	<td class="header"><form:label path="terminalModel"><i><spring:message code="label.terminal.terminalModel"/></i></form:label></td>
	    	<td>
	    		<form:select path="terminalModel.id" style="width: 100%;">
					<form:option value="" label=""/>
					<form:options items="${terminalModelsList}" itemValue="id" itemLabel="model" />
				</form:select>
			</td>
		</tr>
	    <tr>
	    	<td class="header last-header"><form:label path="installation"><i><spring:message code="label.terminal.installation"/></i></form:label></td>
	    	<td>
	    		<form:select path="installation.id" style="width: 100%;">
					<form:option value="" label=""/>
					<form:options items="${installationsList}" itemValue="id" itemLabel="luCode" />
				</form:select>
			</td>
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

</t:wrapper>