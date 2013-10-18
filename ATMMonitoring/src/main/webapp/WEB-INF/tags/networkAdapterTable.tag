<%@tag description="Network Adapter Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.networkAdapters"/></h3>

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
    <tr class="showdetail open">
    	<c:if test="${hardwareDevice.name != null}">
			<td>${hardwareDevice.name}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.name == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.manufacturer != null}">
			<td>${hardwareDevice.manufacturer}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.manufacturer == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.adapterType != null}">
			<td>${hardwareDevice.adapterType}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.adapterType == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.description != null}">
			<td>${hardwareDevice.description}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.dhcpEnabled != null}">
			<td>${hardwareDevice.dhcpEnabled}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.dhcpEnabled == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.dhcpServer != null}">
			<td>${hardwareDevice.dhcpServer}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.dhcpServer == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.ipAddress != null}">
			<td>${hardwareDevice.ipAddress}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.ipAddress == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.ipSubnet != null}">
			<td>${hardwareDevice.ipSubnet}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.ipSubnet == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.defaultIpGateway != null}">
			<td>${hardwareDevice.defaultIpGateway}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.defaultIpGateway == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.macAddress != null}">
			<td>${hardwareDevice.macAddress}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.macAddress == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.speed != null}">
			<td>${hardwareDevice.speed}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.speed == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.netConnectionId != null}">
			<td>${hardwareDevice.netConnectionId}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.netConnectionId == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.netConnectionStatus != null}">
			<td>${hardwareDevice.netConnectionStatus}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.netConnectionStatus == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.interfaceIndex != null}">
			<td>${hardwareDevice.interfaceIndex}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.interfaceIndex == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.status != null}">
			<td>${hardwareDevice.status}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.status == null}">
			<td/>
		</c:if>
    </tr>
    <tr class="detail">
    	<td colspan="16">
	    	<div>
		    	<ul>
		    	<c:if test="${hardwareDevice.name != null}">
					<li><strong><spring:message code="label.hardwareDevice.name"/>: </strong>${hardwareDevice.name}</li>
				</c:if>
				<c:if test="${hardwareDevice.name == null}">
					<li><strong><spring:message code="label.hardwareDevice.name"/>: </strong></li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.manufacturer != null}">
					<li><strong><spring:message code="label.hardwareDevice.manufacturer"/>:</strong> ${hardwareDevice.manufacturer}</li>
				</c:if>
				<c:if test="${hardwareDevice.manufacturer == null}">
					<li><strong><spring:message code="label.hardwareDevice.manufacturer"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.adapterType != null}">
					<li><strong><spring:message code="label.hardwareDevice.adapterType"/>:</strong> ${hardwareDevice.adapterType}</li>
				</c:if>
				<c:if test="${hardwareDevice.adapterType == null}">
					<li><strong><spring:message code="label.hardwareDevice.adapterType"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.caption != null}">
					<li><strong><spring:message code="label.hardwareDevice.caption"/>:</strong> ${hardwareDevice.caption}</li>
				</c:if>
				<c:if test="${hardwareDevice.caption == null}">
					<li><strong><spring:message code="label.hardwareDevice.caption"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.description != null}">
					<li><strong><spring:message code="label.hardwareDevice.description"/>:</strong> ${hardwareDevice.description}</li>
				</c:if>
				<c:if test="${hardwareDevice.description == null}">
					<li><strong><spring:message code="label.hardwareDevice.description"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.dhcpEnabled != null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpEnabled"/>:</strong> ${hardwareDevice.dhcpEnabled}</li>
				</c:if>
				<c:if test="${hardwareDevice.dhcpEnabled == null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpEnabled"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.dhcpServer != null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpServer"/>:</strong> ${hardwareDevice.dhcpServer}</li>
				</c:if>
				<c:if test="${hardwareDevice.dhcpServer == null}">
					<li><strong><spring:message code="label.hardwareDevice.dhcpServer"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.ipAddress != null}">
					<li><strong><spring:message code="label.hardwareDevice.ipAddress"/>:</strong> ${hardwareDevice.ipAddress}</li>
				</c:if>
				<c:if test="${hardwareDevice.ipAddress == null}">
					<li><strong><spring:message code="label.hardwareDevice.ipAddress"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.ipSubnet != null}">
					<li><strong><spring:message code="label.hardwareDevice.ipSubnet"/>:</strong> ${hardwareDevice.ipSubnet}</li>
				</c:if>
				<c:if test="${hardwareDevice.ipSubnet == null}">
					<li><strong><spring:message code="label.hardwareDevice.ipSubnet"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.defaultIpGateway != null}">
					<li><strong><spring:message code="label.hardwareDevice.defaultIpGateway"/>:</strong> ${hardwareDevice.defaultIpGateway}</li>
				</c:if>
				<c:if test="${hardwareDevice.defaultIpGateway == null}">
					<li><strong><spring:message code="label.hardwareDevice.defaultIpGateway"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.macAddress != null}">
					<li><strong><spring:message code="label.hardwareDevice.macAddress"/>:</strong> ${hardwareDevice.macAddress}</li>
				</c:if>
				<c:if test="${hardwareDevice.macAddress == null}">
					<li><strong><spring:message code="label.hardwareDevice.macAddress"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.speed != null}">
					<li><strong><spring:message code="label.hardwareDevice.speed"/>:</strong> ${hardwareDevice.speed}</li>
				</c:if>
				<c:if test="${hardwareDevice.speed == null}">
					<li><strong><spring:message code="label.hardwareDevice.speed"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.netConnectionId != null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionId"/>:</strong> ${hardwareDevice.netConnectionId}</li>
				</c:if>
				<c:if test="${hardwareDevice.netConnectionId == null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionId"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.netConnectionStatus != null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionStatus"/>:</strong> ${hardwareDevice.netConnectionStatus}</li>
				</c:if>
				<c:if test="${hardwareDevice.netConnectionStatus == null}">
					<li><strong><spring:message code="label.hardwareDevice.netConnectionStatus"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.interfaceIndex != null}">
					<li><strong><spring:message code="label.hardwareDevice.interfaceIndex"/>:</strong> ${hardwareDevice.interfaceIndex}</li>
				</c:if>
				<c:if test="${hardwareDevice.interfaceIndex == null}">
					<li><strong><spring:message code="label.hardwareDevice.interfaceIndex"/>:</strong> </li>
				</c:if>
				
		    	<c:if test="${hardwareDevice.status != null}">
					<li><strong><spring:message code="label.hardwareDevice.status"/>:</strong> ${hardwareDevice.status}</li>
				</c:if>
				<c:if test="${hardwareDevice.status == null}">
					<li><strong><spring:message code="label.hardwareDevice.status"/>:</strong> </li>
				</c:if>
				</ul>
			</div>
		</td>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>