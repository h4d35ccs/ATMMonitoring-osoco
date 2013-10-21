<%@tag description="Computer System Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.computerSystems"/></h3>

<table class="data subform link">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.model"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.numberOfProcessors"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.totalPhysicalMemory"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.description"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentTimeZone"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.daylightInEffect"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.domain"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.workgroup"/></label></i></th>
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
		
		<c:if test="${hardwareDevice.numberOfProcessors != null}">
			<td><label>${hardwareDevice.numberOfProcessors}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.numberOfProcessors == null}">
			<td/>
		</c:if>
		
		<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
		<c:if test="${hardwareDevice.totalPhysicalMemory != null}">
			<td><label>${hardwareDevice.totalPhysicalMemory}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.totalPhysicalMemory == null}">
			<td/>
		</c:if>
		
		<c:if test="${hardwareDevice.description != null}">
			<td><label>${hardwareDevice.description}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>
		
		<c:if test="${hardwareDevice.currentTimeZone != null}">
			<td><label>${hardwareDevice.currentTimeZone}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentTimeZone == null}">
			<td/>
		</c:if>
		
		<c:if test="${hardwareDevice.daylightInEffect != null}">
			<td><label>${hardwareDevice.daylightInEffect}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.daylightInEffect == null}">
			<td/>
		</c:if>
		
		<c:if test="${hardwareDevice.domain != null}">
			<td><label>${hardwareDevice.domain}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.domain == null}">
			<td/>
		</c:if>
		
		<c:if test="${hardwareDevice.workgroup != null}">
			<td><label>${hardwareDevice.workgroup}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.workgroup == null}">
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