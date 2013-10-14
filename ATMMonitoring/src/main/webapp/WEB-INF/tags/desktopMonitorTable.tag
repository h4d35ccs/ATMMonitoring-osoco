<%@tag description="Desktop Monitor Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h5><spring:message code="label.desktopMonitors"/></h5>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.deviceId"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.displayType"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.monitorManufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.monitorType"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.pixelsPerXLogicalInch"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.pixelsPerYLogicalInch"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.status"/></label></i></th>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${hardwareDevices}" var="hardwareDevice">
    <tr <c:if test="${alt}">class="alt"</c:if>>
    	<c:if test="${hardwareDevice.name != null}">
			<td><label>${hardwareDevice.name}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.deviceId != null}">
			<td><label>${hardwareDevice.deviceId}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.deviceId == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.displayType != null}">
			<td><label>${hardwareDevice.displayType}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.displayType == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.monitorManufacturer != null}">
			<td><label>${hardwareDevice.monitorManufacturer}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.monitorManufacturer == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.monitorType != null}">
			<td><label>${hardwareDevice.monitorType}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.monitorType == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.pixelsPerXLogicalInch != null}">
			<td><label>${hardwareDevice.pixelsPerXLogicalInch}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.pixelsPerXLogicalInch == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.pixelsPerYLogicalInch != null}">
			<td><label>${hardwareDevice.pixelsPerYLogicalInch}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.pixelsPerYLogicalInch == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.status != null}">
			<td><label>${hardwareDevice.status}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
			<td/>
		</c:if>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>