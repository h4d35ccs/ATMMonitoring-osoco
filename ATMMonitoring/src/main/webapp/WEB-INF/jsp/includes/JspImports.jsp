<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib tagdir="/WEB-INF/tags/utils/" prefix="utils"%>
<%@taglib tagdir="/WEB-INF/tags/terminal/" prefix="terminal" %>
 <c:set var="req" value="${pageContext.request}" />
 <c:set var="url">${req.requestURL}</c:set>
 <c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
 <c:set var="currentUrl" value='${req.getAttribute("javax.servlet.forward.request_uri")}'/>
 <!-- Roles assigned to variables -->
<spring:eval expression="@settings.getProperty('security.dashboardAccessAllowedRoles')" var="dashboardAccessAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.helpAccessAllowedRoles')" var="helpAccessAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.usersAccessAllowedRoles')" var="usersAccessAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.schedulesAccessAllowedRoles')" var="schedulesAccessAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.terminalsAccessAllowedRoles')" var="terminalsAccessAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.terminalsManagementAllowedRoles')" var="terminalsManagementAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.terminalsUpdateRequestAllowedRoles')" var="terminalsUpdateRequestAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.queriesAccessAllowedRoles')" var="queriesAccessAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.reportsAccessAllowedRoles')" var="reportsAccessAllowedRoles" scope="request"/>
<spring:eval expression="@settings.getProperty('security.editWidgetsLibraryAllowedRoles')" var="editWidgetsLibraryAllowedRoles" scope="request"/>

