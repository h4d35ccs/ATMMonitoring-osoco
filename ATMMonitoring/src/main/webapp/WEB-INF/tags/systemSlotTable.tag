<%@tag description="System Slot Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.systemSlots"/></h3>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentUsage"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.serialNumber"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.slotDesignation"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.tag"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.version"/></label></i></th>
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
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentUsage != null}">
			<td><label>${hardwareDevice.currentUsage}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentUsage == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.serialNumber != null}">
			<td><label>${hardwareDevice.serialNumber}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.slotDesignation != null}">
			<td><label>${hardwareDevice.slotDesignation}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.slotDesignation == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.tag != null}">
			<td><label>${hardwareDevice.tag}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.tag == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.version != null}">
			<td><label>${hardwareDevice.version}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.version == null}">
			<td/>
		</c:if>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>