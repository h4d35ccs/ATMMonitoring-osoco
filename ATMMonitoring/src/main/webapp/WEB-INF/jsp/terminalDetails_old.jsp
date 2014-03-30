<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.terminalsManager" userMsg="${userMsg}">

<div class="box">
<h2><spring:message code="label.terminalDetails"/></h2>

<c:choose>
<c:when test="${canEdit == true}">
	<form:form method="post" action="terminals/update" commandName="terminal">
		<form:hidden path="id"/>

		<div class="margin-box">
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
	        <td class="header"><form:label path="serialNumber"><i><spring:message code="label.terminal.serialNumber"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="serialNumber" maxlength="50"/></td>
	        <td class="error-td"><form:errors path="serialNumber"/>
	        <c:if test="${duplicatedSerialNumber == true}">
	        <spring:message code="label.terminal.duplicatedSerialNumber"/>
	        </c:if></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="terminalType"><i><spring:message code="label.terminal.terminalType"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="terminalType" maxlength="50"/></td><td class="error-td"><form:errors path="terminalType"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="terminalVendor"><i><spring:message code="label.terminal.terminalVendor"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="terminalVendor" maxlength="50"/></td><td class="error-td"><form:errors path="terminalVendor"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="frontReplenish"><i><spring:message code="label.terminal.frontReplenish"/></i></form:label></td>
	        <td><form:checkbox path="frontReplenish"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="bank"><i><spring:message code="label.terminal.bank"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="bank" maxlength="50"/></td><td class="error-td"><form:errors path="bank"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="branch"><i><spring:message code="label.terminal.branch"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="branch" maxlength="50"/></td><td class="error-td"><form:errors path="branch"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="geographicAddress"><i><spring:message code="label.terminal.geographicAddress"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="geographicAddress" maxlength="150"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="address"><i><spring:message code="label.terminal.address"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="address" maxlength="100"/></td><td class="error-td"><form:errors path="address"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="city"><i><spring:message code="label.terminal.city"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="city" maxlength="35"/></td><td class="error-td"><form:errors path="city"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="zipCode"><i><spring:message code="label.terminal.zipCode"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="zipCode" maxlength="15"/></td><td class="error-td"><form:errors path="zipCode"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="area"><i><spring:message code="label.terminal.area"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="area" maxlength="35"/></td><td class="error-td"><form:errors path="area"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="country"><i><spring:message code="label.terminal.country"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="country" maxlength="50"/></td><td class="error-td"><form:errors path="country"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="manufacturingSite"><i><spring:message code="label.terminal.manufacturingSite"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="manufacturingSite" maxlength="20"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="model"><i><spring:message code="label.terminal.model"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="model" maxlength="20"/></td><td class="error-td"><form:errors path="model"/></td>
	    </tr>
	    <tr>
	        <td class="header"><form:label path="productClass"><i><spring:message code="label.terminal.productClass"/></i></form:label></td>
	        <td><form:input class='form-tf-grey' path="productClass" maxlength="20"/></td><td class="error-td"><form:errors path="productClass"/></td>
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
			<input type="submit" class="form-submit" style="float: right;" value="<spring:message code="label.terminal.updateTerminal"/>"/>
			</td>
		</tr>
	</table>
	</div>
	</form:form>
	<button class="form-submit" style="margin: 10px;" onclick="requestSnmpUpdate()"><spring:message code="label.terminal.requestSingleSnmpUpdate"/></button>
</c:when>
<c:otherwise>	
	<div class="margin-box">
    <table class="form-disabled">
	    <tr>
	        <td class="header first-header"><i><label><spring:message code="label.terminal.serialNumber"/></label></i></td>
	        <td class="first-header"><label>${terminal.serialNumber}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.ip"/></label></i></td>
	        <td><label>${terminal.ip}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.mac"/></label></i></td>
	        <td><label>${terminal.mac}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.terminalType"/></label></i></td>
	        <td><label>${terminal.terminalType}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.terminalVendor"/></label></i></td>
	        <td><label>${terminal.terminalVendor}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.frontReplenish"/></label></i></td>
	        <td><label>${terminal.frontReplenish}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.bank"/></label></i></td>
	        <td><label>${terminal.bank}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.branch"/></label></i></td>
	        <td><label>${terminal.branch}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.geographicAddress"/></label></i></td>
	        <td><label>${terminal.geographicAddress}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.address"/></label></i></td>
	        <td><label>${terminal.address}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.city"/></label></i></td>
	        <td><label>${terminal.city}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.zipCode"/></label></i></td>
	        <td><label>${terminal.zipCode}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.area"/></label></i></td>
	        <td><label>${terminal.area}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.country"/></label></i></td>
	        <td><label>${terminal.country}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.manufacturingSite"/></label></i></td>
	        <td><label>${terminal.manufacturingSite}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.model"/></label></i></td>
	        <td><label>${terminal.model}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.productClass"/></label></i></td>
	        <td><label>${terminal.productClass}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.productClassDescription"/></label></i></td>
	        <td><label>${terminal.productClassDescription}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.tracerNumber"/></label></i></td>
	        <td><label>${terminal.tracerNumber}</label></td>
	    </tr>
	    <tr>
	        <td class="header"><i><label><spring:message code="label.terminal.bankCompany"/></label></i></td>
	        <td><label>${terminal.bankCompany.name}</label></td>
	    </tr>
	    <tr>
	    	<td class="header"><i><label><spring:message code="label.terminal.terminalModel"/></label></i></td>
	    	<td><label>${terminal.terminalModel.model}</label></td>
		</tr>
	    <tr>
	    	<td class="header last-header"><i><label><spring:message code="label.terminal.installation"/></label></i></td>
	    	<td class="last-header"><label>${terminal.installation.luCode}</label></td>
		</tr>
	</table>
	</div>
</c:otherwise>
</c:choose>
</div>

<div class="box">
<h2><spring:message code="label.financialDevices"/></h2>
<div class="margin-box">
<c:if  test="${empty terminal.financialDevices}">
<div class="empty-list"><spring:message code="label.terminal.noFinancialDevices"/></div>
</c:if>
<c:if test="${!empty terminal.financialDevices}">

	<c:choose>
	<c:when  test="${terminal.financialDevices.size() > 5}">
	
	<style type="text/css">
	/* define height and width of scrollable area. Add 16px to width for scrollbar          */
	div.financialDevsTableContainer {
		height: 170px;
		width: 1034px;
	}
	
	/* define width of table. IE browsers only                 */
	div.financialDevsTableContainer table {
		width: 1035px
	}
	
	html>body tbody.financialDevsScrollContent {
		height: 137px;
	}
	</style>
	<div id="financialDevsTableContainer" class="tableContainer financialDevsTableContainer">
	<table class="data subform">
	<thead class="fixedHeader">
	</c:when>
	<c:otherwise>
	<table class="data subform">
	</c:otherwise>
	</c:choose>
	<tr>
		<th width="125px"><i><spring:message code="label.financialDevice.name"/></i></th>
		<th width="80px"><i><spring:message code="label.financialDevice.majorVersion"/></i></th>
		<th width="55px"><i><spring:message code="label.financialDevice.serialNumber"/></i></th>
		<th width="40px"><i><spring:message code="label.financialDevice.caption"/></i></th>
		<th width="55px"><i><spring:message code="label.financialDevice.description"/></i></th>
		<th width="60px"><i><spring:message code="label.financialDevice.universalId"/></i></th>
		<th width="40px"><i><spring:message code="label.financialDevice.deviceInstance"/></i></th>
		<th width="40px"><i><spring:message code="label.financialDevice.deviceStatus"/></i></th>
		<th width="40px"><i><spring:message code="label.financialDevice.pmStatus"/></i></th>
		<th width="45px"><i><spring:message code="label.financialDevice.model"/></i></th>
		<th width="40px"><i><spring:message code="label.financialDevice.variant"/></i></th>
		<th width="65px"><i><spring:message code="label.financialDevice.manufacturer"/></i></th>
		<th width="65px"><i><spring:message code="label.financialDevice.firmwareMajorVersion"/></i></th>
		<th width="50px"><i><spring:message code="label.financialDevice.removable"/></i></th>
		<th width="60px"><i><spring:message code="label.financialDevice.replaceable"/></i></th>
		<th width="50px"><i><spring:message code="label.financialDevice.hotSwappable"/></i></th>
			<c:choose>
			<c:when  test="${terminal.financialDevices.size() > 5}">
			<th width="70px">
			</c:when>
			<c:otherwise>
			<th width="55px">
			</c:otherwise>
			</c:choose>
			<i><spring:message code="label.financialDevice.xfsComponents"/></i></th>
	</tr>
	<c:if  test="${terminal.financialDevices.size() > 5}">
	</thead>
	<tbody class="scrollContent financialDevsScrollContent">
	</c:if>
	<c:set var="alt" value="${false}"/>
	<c:forEach items="${terminal.financialDevices}" var="financialDevice">
	    <tr <c:if test="${alt}">class="alt"</c:if>>
		    <td width="125px"><label>${financialDevice.name}</label></td>
		    <td width="80px"><label>${financialDevice.version}</label></td>
		    <td width="55px"><label>${financialDevice.serialNumber}</label></td>
		    <td width="40px"><label>${financialDevice.caption}</label></td>
		    <td width="55px"><label>${financialDevice.description}</label></td>
		    <td width="60px"><label>${financialDevice.universalId}</label></td>
		    <td width="40px"><label>${financialDevice.deviceInstance}</label></td>
		    <td width="40px"><label>${financialDevice.deviceStatus}</label></td>
		    <td width="40px"><label>${financialDevice.pmStatus}</label></td>
		    <td width="45px"><label>${financialDevice.model}</label></td>
		    <td width="40px"><label>${financialDevice.variant}</label></td>
		    <td width="65px"><label>${financialDevice.manufacturer}</label></td>
		    <td width="65px"><label>${financialDevice.firmwareVersion}</label></td>
		    <td width="50px"><label>${financialDevice.removable}</label></td>
		    <td width="60px"><label>${financialDevice.replaceable}</label></td>
			<td width="50px"><label>${financialDevice.hotSwappable}</label></td>
		    <td width="55px">
		    	<c:forEach items="${financialDevice.xfsComponents}" var="xfsComponent">
		    	<a href="terminals/xfsComponents/details/${xfsComponent.id}">${xfsComponent.logicalName}</a><br>
		    	</c:forEach>
		    </td>
		</tr>
		<c:set var="alt" value="${!alt}"/>
	</c:forEach>
	<c:choose>
	<c:when  test="${terminal.financialDevices.size() > 5}">
	</tbody>
	</table>
	</div>
	</c:when>
	<c:otherwise>
	</table>
	</c:otherwise>
	</c:choose>
</c:if>
</div>
</div>

<div class="box">
<h2><spring:message code="label.hardwareDevices"/></h2>
<c:if  test="${empty terminal.hardwareDevices}">
<div class="empty-list"><spring:message code="label.terminal.noHwDevices"/></div>
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
<h2><spring:message code="label.terminalConfigs"/></h2>
<div class="margin-box">
<c:if  test="${empty terminal.configs}">
<div class="empty-list"><spring:message code="label.terminal.noConfigs"/></div>
</c:if>
<c:if  test="${!empty terminal.configs}">

<div class="box">
<h3><spring:message code="label.currentTerminalConfig"/></h3>
	<div class="margin-box">
	<table class="form-disabled">
	<tr>
	    <td class="header first-header last-header"><i><label><spring:message code="label.terminalConfig.startDate"/></label></i></td>
		<td class="first-header last-header"><a href="terminals/swConfigs/details/${terminal.currentConfig.id}"><fmt:formatDate value="${terminal.currentConfig.startDate}" dateStyle="short" type="both" /></a></td>
	</tr>
	<%--Code with support for Terminal Config AUTHORS --%>
	<%-- <c:choose>
	<c:when test="${terminal.currentConfig.author != null}">
		<tr>
		    <td><label><i><spring:message code="label.terminalconfig.author"/></i></label></td>
		    <td><label>${terminal.currentConfig.author.lastname}, ${terminal.currentConfig.author.firstname}</label></td>
		</tr>
	</c:when>
	<c:otherwise>
		<tr>
		    <td><label><i><spring:message code="label.terminalconfig.author"/></i></label></td>
		    <td><label>----</label></td>
		</tr>
	</c:otherwise>
	</c:choose> --%>
	</table>

	<t:listSoftware config="${terminal.currentConfig}"/>
	</div>
</div>

<div class="box">
<h3><spring:message code="label.terminalConfigsHistory"/></h3>
<div class="margin-box">
<c:choose>
<c:when  test="${terminal.configs.size() > 10}">

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
<thead class="fixedHeader">
</c:when>
<c:otherwise>
<table class="data">
</c:otherwise>
</c:choose>
<tr>
	<c:choose>
	<c:when  test="${terminal.configs.size() > 10}">
	<th width="151px">
	</c:when>
	<c:otherwise>
	<th width="136px">
	</c:otherwise>
	</c:choose>
    <i><spring:message code="label.terminalConfig.startDate"/></i></th>
	<%--Code with support for Terminal Config AUTHORS --%>
    <%-- <th><i><spring:message code="label.terminalconfig.author"/></i></th>--%>
</tr>
<c:if  test="${terminal.configs.size() > 10}">
</thead>
<tbody class="scrollContent scrollContentTc">
</c:if>
<c:set var="alt" value="${false}"/>
<c:forEach items="${terminal.configs}" var="config">
	<tr <c:if test="${alt}">class="alt"</c:if>>
	    <td width="135px"><a href="terminals/swConfigs/details/${config.id}"><fmt:formatDate value="${config.startDate}" dateStyle="short" type="both" /></a></td>
		<%--Code with support for Terminal Config AUTHORS --%>
	    <%-- <c:choose>
	    <c:when test="${config.author != null}">
	        <td>${config.author.lastname}, ${config.author.firstname}</td>
	    </c:when>
	    <c:otherwise>
	        <td>----</td>
	    </c:otherwise>
	    </c:choose> --%>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
<c:choose>
<c:when  test="${terminal.configs.size() > 10}">
</tbody>
</table>
</div>
</c:when>
<c:otherwise>
</table>
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
	    <tr><td>
	<form:checkboxes items="${softwareList}" path="software" itemValue="id" itemLabel="nameVersion" delimiter="</td></tr><tr><td>"/>
	    </td></tr>
	    <tr><td>
	        <input type="submit" class="form-submit" value="<spring:message code="label.terminalconfig.addterminalconfig"/>"/>
	    </td></tr>
	</table> 
	</form:form>
</c:if> --%>

<div class="box">
<h2><spring:message code="label.softwareAggregates"/></h2>
<div class="margin-box">
<c:if  test="${empty terminal.softwareAggregates}">
<div class="empty-list"><spring:message code="label.terminal.noSwAggregates"/></div>
</c:if>
<c:if test="${!empty terminal.softwareAggregates}">
	<table class="data">
	<tr>
	    <th><i><spring:message code="label.softwareAggregate.name"/> + <spring:message code="label.softwareAggregate.majorVersion"/></i></th>
	    <th><i><spring:message code="label.softwareAggregate.number"/></i></th>
	    <th><i><spring:message code="label.softwareAggregate.description"/></i></th>
	    <th><i><spring:message code="label.softwareAggregate.profile"/></i></th>
	</tr>
	<c:set var="alt" value="${false}"/>
	<c:forEach items="${terminal.softwareAggregates}" var="softwareAggregate">
		<tr <c:if test="${alt}">class="alt"</c:if>>
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
<h2><spring:message code="label.hotfixes"/></h2>
<div class="margin-box">
<c:if  test="${empty terminal.hotfixes}">
<div class="empty-list"><spring:message code="label.terminal.noHotfixes"/></div>
</c:if>
<c:if test="${!empty terminal.hotfixes}">
	<table class="data">
	<tr>
	    <th><i><spring:message code="label.hotfix.hotfixId"/></i></th>
	    <th><i><spring:message code="label.hotfix.description"/></i></th>
	    <th><i><spring:message code="label.hotfix.number"/></i></th>
	    <th><i><spring:message code="label.hotfix.installedOn"/></i></th>
	    <th><i><spring:message code="label.hotfix.fixComments"/></i></th>
	</tr>
	<c:set var="alt" value="${false}"/>
	<c:forEach items="${terminal.hotfixes}" var="hotfix">
		<tr <c:if test="${alt}">class="alt"</c:if>>
	        <td>${hotfix.hotfixId}</td>
	        <td>${hotfix.description}</td>
	        <td>${hotfix.number}</td>
	        <td><fmt:formatDate value="${hotfix.installedOn}" dateStyle="short" type="date" /></td>
	        <td>${hotfix.fixComments}</td>
	    </tr>
		<c:set var="alt" value="${!alt}"/>
	</c:forEach>
	</table>
</c:if>
</div>
</div>

<div class="box">
<h2><spring:message code="label.internetExplorers"/></h2>
<div class="margin-box">
<c:if  test="${empty terminal.internetExplorers}">
<div class="empty-list"><spring:message code="label.terminal.noIEs"/></div>
</c:if>
<c:if test="${!empty terminal.internetExplorers}">
	<table class="data">
	<tr>
	    <th><i><spring:message code="label.internetExplorer.majorVersion"/></i></th>
	</tr>
	<c:set var="alt" value="${false}"/>
	<c:forEach items="${terminal.internetExplorers}" var="internetExplorer">
		<tr <c:if test="${alt}">class="alt"</c:if>>
	        <td>${internetExplorer.version}</td>
	    </tr>
		<c:set var="alt" value="${!alt}"/>
	</c:forEach>
	</table>
</c:if>
</div>
</div>

<script type="text/javascript">
	function requestSnmpUpdate() {
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
			window.location.href = "terminals/request/${terminal.id}";
	}
</script>

</t:wrapper>