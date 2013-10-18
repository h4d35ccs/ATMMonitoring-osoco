<%@tag description="Physical Memory Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.physicalMemories"/></h3>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.capacity"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.speed"/></label></i></th>
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

		<c:if test="${hardwareDevice.capacity != null}">
			<td><label>${hardwareDevice.capacity}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.capacity == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.speed != null}">
			<td><label>${hardwareDevice.speed}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.speed == null}">
			<td/>
		</c:if>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>