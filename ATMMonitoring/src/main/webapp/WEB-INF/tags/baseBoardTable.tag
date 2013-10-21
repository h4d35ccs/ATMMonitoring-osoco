<%@tag description="Base Board Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.baseBoards"/></h3>

<table class="data subform link">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.model"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.product"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.serialNumber"/></label></i></th>
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

		<c:if test="${hardwareDevice.product != null}">
			<td><label>${hardwareDevice.product}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.product == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.serialNumber != null}">
			<td><label>${hardwareDevice.serialNumber}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
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