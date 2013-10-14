<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:wrapper titleCode="label.queryEngine" userMsg="${userMsg}">

<div class="box">
	<h2><spring:message code="label.queryResults"/></h2>
	<div class="box-tableContainer">
		<c:if  test="${empty pagedListHolder.pageList}">
		<div class="empty-list"><spring:message code="label.query.noResults"/></div>
		</c:if>
		<c:if  test="${!empty pagedListHolder.pageList}">
			<t:terminalsTable terminals="${pagedListHolder.pageList}"/>
			<div class="pagingContainer">
			<form:form id="pagingForm" method="post" action="queries/results/export" commandName="query">
				<c:forEach var="i" begin="1" end="5">
					<form:hidden path="terminalCombo${i}1"/>
					<form:hidden path="terminalCB${i}"/>
					<form:hidden path="terminalCombo${i}2"/>
					<form:hidden path="terminalField${i}"/>
					<form:hidden path="hardwareDeviceCombo${i}1"/>
					<form:hidden path="hardwareDeviceCB${i}"/>
					<form:hidden path="hardwareDeviceCombo${i}2"/>
					<form:hidden path="hardwareDeviceCombo${i}3"/>
					<form:hidden path="hardwareDeviceField${i}"/>
					<form:hidden path="financialDeviceCombo${i}1"/>
					<form:hidden path="financialDeviceCB${i}"/>
					<form:hidden path="financialDeviceCombo${i}2"/>
					<form:hidden path="financialDeviceField${i}"/>
					<form:hidden path="operatingSystemCombo${i}1"/>
					<form:hidden path="operatingSystemCB${i}"/>
					<form:hidden path="operatingSystemCombo${i}2"/>
					<form:hidden path="operatingSystemField${i}"/>
					<form:hidden path="hotfixCombo${i}1"/>
					<form:hidden path="hotfixCB${i}"/>
					<form:hidden path="hotfixCombo${i}2"/>
					<form:hidden path="hotfixField${i}"/>
					<form:hidden path="softwareCombo${i}1"/>
					<form:hidden path="softwareCB${i}"/>
					<form:hidden path="softwareCombo${i}2"/>
					<form:hidden path="softwareField${i}"/>
					<form:hidden path="featSwCombo${i}1"/>
					<form:hidden path="featSwCB${i}"/>
					<form:hidden path="featSwCombo${i}2"/>
					<form:hidden path="featSwField${i}"/>
					<form:hidden path="xfsSwCombo${i}1"/>
					<form:hidden path="xfsSwCB${i}"/>
					<form:hidden path="xfsSwCombo${i}2"/>
					<form:hidden path="xfsSwField${i}"/>
				</c:forEach>
				<c:forEach var="i" begin="1" end="2">
					<form:hidden path="internetExplorerCombo${i}1"/>
					<form:hidden path="internetExplorerCB${i}"/>
					<form:hidden path="internetExplorerCombo${i}2"/>
					<form:hidden path="internetExplorerField${i}"/>
				</c:forEach>
			<t:pagingForm pagedListHolder="${pagedListHolder}" pagedLink="queries/results?p=~" formId="pagingForm"/>
			</form:form>
			</div>
			<form:form id="exportForm" method="post" action="queries/results/export" commandName="query" target="_blank">
				<c:forEach var="i" begin="1" end="5">
					<form:hidden path="terminalCombo${i}1"/>
					<form:hidden path="terminalCB${i}"/>
					<form:hidden path="terminalCombo${i}2"/>
					<form:hidden path="terminalField${i}"/>
					<form:hidden path="hardwareDeviceCombo${i}1"/>
					<form:hidden path="hardwareDeviceCB${i}"/>
					<form:hidden path="hardwareDeviceCombo${i}2"/>
					<form:hidden path="hardwareDeviceCombo${i}3"/>
					<form:hidden path="hardwareDeviceField${i}"/>
					<form:hidden path="financialDeviceCombo${i}1"/>
					<form:hidden path="financialDeviceCB${i}"/>
					<form:hidden path="financialDeviceCombo${i}2"/>
					<form:hidden path="financialDeviceField${i}"/>
					<form:hidden path="operatingSystemCombo${i}1"/>
					<form:hidden path="operatingSystemCB${i}"/>
					<form:hidden path="operatingSystemCombo${i}2"/>
					<form:hidden path="operatingSystemField${i}"/>
					<form:hidden path="hotfixCombo${i}1"/>
					<form:hidden path="hotfixCB${i}"/>
					<form:hidden path="hotfixCombo${i}2"/>
					<form:hidden path="hotfixField${i}"/>
					<form:hidden path="softwareCombo${i}1"/>
					<form:hidden path="softwareCB${i}"/>
					<form:hidden path="softwareCombo${i}2"/>
					<form:hidden path="softwareField${i}"/>
					<form:hidden path="featSwCombo${i}1"/>
					<form:hidden path="featSwCB${i}"/>
					<form:hidden path="featSwCombo${i}2"/>
					<form:hidden path="featSwField${i}"/>
					<form:hidden path="xfsSwCombo${i}1"/>
					<form:hidden path="xfsSwCB${i}"/>
					<form:hidden path="xfsSwCombo${i}2"/>
					<form:hidden path="xfsSwField${i}"/>
				</c:forEach>
				<c:forEach var="i" begin="1" end="2">
					<form:hidden path="internetExplorerCombo${i}1"/>
					<form:hidden path="internetExplorerCB${i}"/>
					<form:hidden path="internetExplorerCombo${i}2"/>
					<form:hidden path="internetExplorerField${i}"/>
				</c:forEach>
				<div class="query-csv-export"><a href="#" onclick="$('#exportForm').submit(); return false;" ><spring:message code="label.query.downloadCsv"/></a></div> 
			</form:form>
		</c:if>
	</div>
</div>

</t:wrapper>