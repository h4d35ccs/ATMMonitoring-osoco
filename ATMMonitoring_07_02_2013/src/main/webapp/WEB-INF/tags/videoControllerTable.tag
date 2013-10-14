<%@tag description="Video Controller Table" pageEncoding="UTF-8"%>
<%@attribute name="hardwareDevices" required="true" type="java.util.Set"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<h5><spring:message code="label.videoControllers"/></h5>

<table class="data subform">
<tr>
	<th><i><label><spring:message code="label.hardwareDevice.name"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.description"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.videoProcessor"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.adapterRam"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentBitsPerPixel"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentNumberOfColors"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentVerticalResolution"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentHorizontalResolution"/></label></i></th>
	<th><i><label><spring:message code="label.hardwareDevice.currentRefreshRate"/></label></i></th>
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
		
    	<c:if test="${hardwareDevice.description != null}">
			<td><label>${hardwareDevice.description}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.description == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.videoProcessor != null}">
			<td><label>${hardwareDevice.videoProcessor}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.videoProcessor == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.adapterRam != null}">
			<td><label>${hardwareDevice.adapterRam}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.adapterRam == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentBitsPerPixel != null}">
			<td><label>${hardwareDevice.currentBitsPerPixel}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentBitsPerPixel == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentNumberOfColors != null}">
			<td><label>${hardwareDevice.currentNumberOfColors}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentNumberOfColors == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentHorizontalResolution != null}">
			<td><label>${hardwareDevice.currentHorizontalResolution}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentHorizontalResolution == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentVerticalResolution != null}">
			<td><label>${hardwareDevice.currentVerticalResolution}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentVerticalResolution == null}">
			<td/>
		</c:if>
		
    	<c:if test="${hardwareDevice.currentRefreshRate != null}">
			<td><label>${hardwareDevice.currentRefreshRate}</label></td>
		</c:if>
		<c:if test="${hardwareDevice.currentRefreshRate == null}">
			<td/>
		</c:if>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>