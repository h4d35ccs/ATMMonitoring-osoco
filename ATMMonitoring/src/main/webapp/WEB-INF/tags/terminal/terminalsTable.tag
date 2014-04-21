<%@tag description="Terminals Table" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="t"%>
<%@taglib tagdir="/WEB-INF/tags/terminal/" prefix="terminal"%>
<%@attribute name="terminals" required="true" type="java.util.List"%>
<%@attribute name="baseUrl" required="true" type="java.lang.String"%>
<%@attribute name="stringQueryDate" required="false" type="java.lang.String"%>
<%@attribute name="query" required="false" type="java.lang.Object"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%
    String[] terminalColumns = { "mac" , "ip", "serialNumber", "terminalType", "terminalVendor",
        "geographicAddress", "productClass", "tracerNumber"};
    request.setAttribute("terminalColumns", terminalColumns);
  
%>
<div class="table_buttons">
	<terminal:terminalTableButtons query="${query}"/>
	<div class="margin-box">
		<table class="link">
		  <thead>
		 <c:if test="${terminals.size() > 1}">
		  <tr>
		    <!--th></th-->
		    <c:forEach items="${terminalColumns}" var="column">
		      <c:set var="isColumnSorted" value="${column.equals(sort)}"/>
		      <c:set var="orderValue" value="${(isColumnSorted && 'asc'.equals(order)) ? 'desc' : 'asc'}"/>
		      <c:if test="${isColumnSorted}">
		        <c:set var="sortClass" value="${('asc'.equals(order)) ? 'bottom' : 'top'}"/>
		      </c:if>
		      <c:if test="${!isColumnSorted}">
		        <c:set var="sortClass" value=""/>
		      </c:if>
		      <th class="order ${sortClass}" onclick="loadInnerSection('#tabs','${baseUrl}?p=${pagedListHolder.page}&queryId=${query.id}&sort=${column}&order=${orderValue}&queryDate=${stringQueryDate} #tabs')"><a><spring:message code="label.terminal.${column}"/></a></th>
		    </c:forEach>
		  </tr>
		  </c:if>
		  <c:if test="${terminals.size() == 1}">
		  <tr>
		    <!--th></th-->
		    <c:forEach items="${terminalColumns}" var="column">
		      <th><spring:message code="label.terminal.${column}"/></th>
		    </c:forEach>
		  </tr> 
		  </c:if>
		  </thead>
		  <tbody>
		  <c:forEach items="${terminals}" var="terminal">
		    <tr onclick="loadInnerSection('#primary', 'terminals/details/${terminal.id}?dateTime=${queryDate.time}')">
		      <!--td class="check"><input type="checkbox"/></td-->
		      <td><a>${terminal.mac}</a></td>
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
	</div>
	<terminal:terminalTableButtons query="${query}"/>
</div>
<div class="pagination" id="pagination">
	<div class="t_number">
		<span class="text">
			${pagedListHolder.source.size()}
			<spring:message code="label.terminals"/>
		</span>
	</div>
	<div class="p_number">
		<c:if test="${pagedListHolder.getPageCount() > 1 }">
		<span class="text">
			<spring:message code="label.page"/>
		</span>
		<t:paging pagedListHolder="${pagedListHolder}" 
				  pagedLink="terminals/${(query != null)?'byQuery':'list'}?p=~&queryId=${query.id}&sort=${sort}&order=${order}&queryDate=${stringQueryDate}"/>
		</c:if>
	</div>
</div>