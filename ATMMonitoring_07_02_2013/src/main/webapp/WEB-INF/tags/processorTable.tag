<%@tag description="Processor Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h5><spring:message code="label.processors"/></h5>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.architecture"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.addressWidth"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.dataWidth"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentClockSpeed"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.extClock"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.stepping"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.maxClockSpeed"/></label></i></th>
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

		<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.architecture != null}">
			<td><label>${hardwareDevice.architecture}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.architecture == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.addressWidth != null}">
			<td><label>${hardwareDevice.addressWidth}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.addressWidth == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.dataWidth != null}">
			<td><label>${hardwareDevice.dataWidth}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.dataWidth == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.currentClockSpeed != null}">
			<td><label>${hardwareDevice.currentClockSpeed}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentClockSpeed == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.extClock != null}">
			<td><label>${hardwareDevice.extClock}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.extClock == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.stepping != null}">
			<td><label>${hardwareDevice.stepping}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.stepping == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.maxClockSpeed != null}">
			<td><label>${hardwareDevice.maxClockSpeed}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.maxClockSpeed == null}">
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