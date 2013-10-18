<%@tag description="Disk Drive Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.diskDrives"/></h3>

<table class="data subform">
<tr>	
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.model"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.partitions"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.size"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.status"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.description"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.deviceId"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.firmwareRevision"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.serialNumber"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.mediaType"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.maxMediaSize"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.totalCylinders"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.tracksPerCylinder"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.sectorsPerTrack"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.bytesPerSector"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.signature"/></label></i></th>
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

		<c:if test="${hardwareDevice.manufacturer != null}">
			<td><label>${hardwareDevice.manufacturer}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.manufacturer == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.model != null}">
			<td><label>${hardwareDevice.model}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.model == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.partitions != null}">
			<td><label>${hardwareDevice.partitions}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.partitions == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.size != null}">
			<td><label>${hardwareDevice.size}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.size == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.status != null}">
			<td><label>${hardwareDevice.status}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
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

		<c:if test="${hardwareDevice.firmwareRevision != null}">
			<td><label>${hardwareDevice.firmwareRevision}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.firmwareRevision == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.serialNumber != null}">
			<td><label>${hardwareDevice.serialNumber}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.mediaType != null}">
			<td><label>${hardwareDevice.mediaType}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.mediaType == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.maxMediaSize != null}">
			<td><label>${hardwareDevice.maxMediaSize}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.maxMediaSize == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.totalCylinders != null}">
			<td><label>${hardwareDevice.totalCylinders}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.totalCylinders == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.tracksPerCylinder != null}">
			<td><label>${hardwareDevice.tracksPerCylinder}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.tracksPerCylinder == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.sectorsPerTrack != null}">
			<td><label>${hardwareDevice.sectorsPerTrack}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.sectorsPerTrack == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.bytesPerSector != null}">
			<td><label>${hardwareDevice.bytesPerSector}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.bytesPerSector == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.signature != null}">
			<td><label>${hardwareDevice.signature}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.signature == null}">
			<td/>
		</c:if>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>