<%@tag description="Logical Disk Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.logicalDisks"/></h3>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.size"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.freeSpace"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.fileSystem"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.description"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.deviceId"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.volumeName"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.volumeSerialNumber"/></label></i></th>
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

		<c:if test="${hardwareDevice.size != null}">
			<td><label>${hardwareDevice.size}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.size == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.freeSpace != null}">
			<td><label>${hardwareDevice.freeSpace}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.freeSpace == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.fileSystem != null}">
			<td><label>${hardwareDevice.fileSystem}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.fileSystem == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.description != null}">
			<td><label>${hardwareDevice.description}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.deviceId != null}">
			<td><label>${hardwareDevice.deviceId}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.deviceId == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.volumeName != null}">
			<td><label>${hardwareDevice.volumeName}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.volumeName == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.volumeSerialNumber != null}">
			<td><label>${hardwareDevice.volumeSerialNumber}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.volumeSerialNumber == null}">
			<td/>
		</c:if>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>