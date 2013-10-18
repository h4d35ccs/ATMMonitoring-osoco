<%@tag description="Bios Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h3><spring:message code="label.bios"/></h3>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.manufacturer"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.smbiosVersion"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.smbiosMajorVersion"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.smbiosMinorVersion"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.caption"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentLanguage"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.primaryBios"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.releaseDate"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.smbiosPresent"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.serialNumber"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.version"/></label></i></th>
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

		<c:if test="${hardwareDevice.smbiosVersion != null}">
			<td><label>${hardwareDevice.smbiosVersion}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosVersion == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.smbiosMajorVersion != null}">
			<td><label>${hardwareDevice.smbiosMajorVersion}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosMajorVersion == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.smbiosMinorVersion != null}">
			<td><label>${hardwareDevice.smbiosMinorVersion}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosMinorVersion == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.caption != null}">
			<td><label>${hardwareDevice.caption}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.caption == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.currentLanguage != null}">
			<td><label>${hardwareDevice.currentLanguage}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentLanguage == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.primaryBios != null}">
			<td><label>${hardwareDevice.primaryBios}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.primaryBios == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.releaseDate != null}">
			<td><label>${hardwareDevice.releaseDate}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.releaseDate == null}">
			<td/>
		</c:if>

		<c:if test="${hardwareDevice.smbiosPresent != null}">
			<td><label>${hardwareDevice.smbiosPresent}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.smbiosPresent == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.serialNumber != null}">
			<td><label>${hardwareDevice.serialNumber}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.serialNumber == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.version != null}">
			<td><label>${hardwareDevice.version}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.version == null}">
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