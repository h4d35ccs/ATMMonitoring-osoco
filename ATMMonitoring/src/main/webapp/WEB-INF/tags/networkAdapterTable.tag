<%@tag description="Network Adapter Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h5><spring:message code="label.networkAdapters"/></h5>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.adapterType"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.description"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.dhcpEnabled"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.dhcpServer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.ipAddress"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.ipSubnet"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.defaultIpGateway"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.macAddress"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.speed"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.netConnectionId"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.netConnectionStatus"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.interfaceIndex"/></label></i></th>
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
		
    	<c:if test="${hardwareDevice.adapterType != null}">
			<td><label>${hardwareDevice.adapterType}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.adapterType == null}">
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
		
    	<c:if test="${hardwareDevice.dhcpEnabled != null}">
			<td><label>${hardwareDevice.dhcpEnabled}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.dhcpEnabled == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.dhcpServer != null}">
			<td><label>${hardwareDevice.dhcpServer}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.dhcpServer == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.ipAddress != null}">
			<td><label>${hardwareDevice.ipAddress}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.ipAddress == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.ipSubnet != null}">
			<td><label>${hardwareDevice.ipSubnet}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.ipSubnet == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.defaultIpGateway != null}">
			<td><label>${hardwareDevice.defaultIpGateway}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.defaultIpGateway == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.macAddress != null}">
			<td><label>${hardwareDevice.macAddress}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.macAddress == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.speed != null}">
			<td><label>${hardwareDevice.speed}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.speed == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.netConnectionId != null}">
			<td><label>${hardwareDevice.netConnectionId}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.netConnectionId == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.netConnectionStatus != null}">
			<td><label>${hardwareDevice.netConnectionStatus}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.netConnectionStatus == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.interfaceIndex != null}">
			<td><label>${hardwareDevice.interfaceIndex}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.interfaceIndex == null}">
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