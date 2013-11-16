<%@tag description="Terminals Table" pageEncoding="UTF-8"%>
<%@attribute name="terminals" required="true" type="java.util.List"%>
<%@attribute name="baseUrl" required="true" type="java.lang.String"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%
    String[] terminalColumns = { "mac" , "ip", "serialNumber", "terminalType", "terminalVendor",
        "geographicAddress", "productClass", "tracerNumber"};
    request.setAttribute("terminalColumns", terminalColumns);
%>

<table class="link">
  <thead>
  <tr>
    <!--th></th-->
    <c:forEach items="${terminalColumns}" var="column">
      <c:set var="isColumnSorted" value="${column.equals(sort)}"/>
      <c:set var="orderValue" value="${(isColumnSorted && 'asc'.equals(order)) ? 'desc' : 'asc'}"/>
      <c:if test="${isColumnSorted}">
        <c:set var="sortClass" value="${('asc'.equals(order)) ? 'top' : 'bottom'}"/>
      </c:if>
      <c:if test="${!isColumnSorted}">
        <c:set var="sortClass" value=""/>
      </c:if>
      <th class="order ${sortClass}"><a href="${baseUrl}?p=${pagedListHolder.page}&queryId=${query.id}&sort=${column}&order=${orderValue}"><spring:message code="label.terminal.${column}"/></a></th>
    </c:forEach>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${terminals}" var="terminal">
    <tr>
      <!--td class="check"><input type="checkbox"/></td-->
      <td><a href="terminals/details/${terminal.id}">${terminal.mac}</a></td>
      <td>${terminal.ip}</td>
	  <td>${terminal.serialNumber}</td>
      <td>${terminal.terminalType}</td>
      <td>${terminal.terminalVendor}</td>
      <td>${terminal.geographicAddress}</td>
      <td>${terminal.terminalModel.productClass}</td>
      <td>${terminal.tracerNumber}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
