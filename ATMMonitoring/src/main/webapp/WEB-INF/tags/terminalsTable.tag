<%@tag description="Terminals Table" pageEncoding="UTF-8"%>
<%@attribute name="terminals" required="true" type="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<table>
<tr>
    <th class="order top"><spring:message code="label.terminal.mac"/></th>
    <th class="order bottom"><spring:message code="label.terminal.ip"/></th>
    <th class="order"><spring:message code="label.terminal.serialNumber"/></th>
    <th class="order"><spring:message code="label.terminal.terminalType"/></th>
    <th class="order"><spring:message code="label.terminal.terminalVendor"/></th>
    <th class="order"><spring:message code="label.terminal.geographicAddress"/></th>
    <th class="order"><spring:message code="label.terminal.model"/></th>
    <th class="order"><spring:message code="label.terminal.productClass"/></th>
	<th class="order"><spring:message code="label.terminal.tracerNumber"/></th>
</tr>
<c:forEach items="${terminals}" var="terminal">
    <tr>
        <td><a href="terminals/details/${terminal.id}">${terminal.mac}</a></td>
        <td>${terminal.ip}</td>
	    <td>${terminal.serialNumber}</td>
        <td>${terminal.terminalType}</td>
        <td>${terminal.terminalVendor}</td>
        <td>${terminal.geographicAddress}</td>
        <td>${terminal.model}</td>
        <td>${terminal.productClass}</td>
        <td>${terminal.tracerNumber}</td>
    </tr>
</c:forEach>
</table>
