<%@tag description="Users Table" pageEncoding="UTF-8"%>
<%@attribute name="users" required="true" type="java.util.List"%>
<%@attribute name="baseUrl" required="true" type="java.lang.String"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%
    String[] userSortColumns = { "username" , "firstname", "lastname" };
	String[] userNotSortColumns = { "role", "bankCompany" };
    request.setAttribute("userSortColumns", userSortColumns);
    request.setAttribute("userNotSortColumns", userNotSortColumns);
%>

<table class="link">
  <thead>
  <tr>
    <!--th></th-->
    <c:forEach items="${userSortColumns}" var="column">
      <c:set var="isColumnSorted" value="${column.equals(sort)}"/>
      <c:set var="orderValue" value="${(isColumnSorted && 'asc'.equals(order)) ? 'desc' : 'asc'}"/>
      <c:if test="${isColumnSorted}">
        <c:set var="sortClass" value="${('asc'.equals(order)) ? 'top' : 'bottom'}"/>
      </c:if>
      <c:if test="${!isColumnSorted}">
        <c:set var="sortClass" value=""/>
      </c:if>
      <th class="order ${sortClass}"><a href="${baseUrl}?p=${pagedListHolder.page}&sort=${column}&order=${orderValue}"><spring:message code="label.user.${column}"/></a></th>
    </c:forEach>
    <c:forEach items="${userNotSortColumns}" var="column">
    	<th><spring:message code="label.user.${column}"/></th>
    </c:forEach>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${users}" var="user">
    <tr>
      <td><a href="users/details/${user.id}">${user.username}</a></td>
      <td>${user.firstname}</td>
	  <td>${user.lastname}</td>
      <td>${user.role.name}</td>
      <td>${user.bankCompany.name}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
