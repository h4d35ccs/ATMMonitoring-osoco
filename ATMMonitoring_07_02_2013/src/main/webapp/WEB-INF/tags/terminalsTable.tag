<%@tag description="Terminals Table" pageEncoding="UTF-8"%>
<%@attribute name="terminals" required="true" type="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table class="data subform">
<tr>
    <th width="135px"><i><spring:message code="label.terminal.mac"/></i></th>
    <th width="120px"><i><spring:message code="label.terminal.ip"/></i></th>
    <th width="110px"><i><spring:message code="label.terminal.serialNumber"/></i></th>
    <th width="80px"><i><spring:message code="label.terminal.terminalType"/></i></th>
    <th width="80px"><i><spring:message code="label.terminal.terminalVendor"/></i></th>
    <th width="160px"><i><spring:message code="label.terminal.geographicAddress"/></i></th>
    <th width="75px"><i><spring:message code="label.terminal.model"/></i></th>
    <th width="105px"><i><spring:message code="label.terminal.productClass"/></i></th>
	<th width="60px"><i><spring:message code="label.terminal.tracerNumber"/></i></th>
</tr>
<c:set var="alt" value="${false}"/>
<c:forEach items="${terminals}" var="terminal">
    <tr <c:if test="${alt}">class="alt"</c:if>>
        <td width="135px"><a href="terminals/details/${terminal.id}">${terminal.mac}</a></td>
        <td width="120px">${terminal.ip}</td>
	    <td width="110px">${terminal.serialNumber}</td>
        <td width="80px">${terminal.terminalType}</td>
        <td width="80px">${terminal.terminalVendor}</td>
        <td width="160px">${terminal.geographicAddress}</td>
        <td width="75px">${terminal.model}</td>
        <td width="105px">${terminal.productClass}</td>
        <td width="60px">${terminal.tracerNumber}</td>
    </tr>
	<c:set var="alt" value="${!alt}"/>
</c:forEach>
</table>
