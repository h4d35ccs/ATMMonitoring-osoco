<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@attribute name="titleCode" %>
<%@attribute name="section" required="true" type="java.lang.String"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML>
<html>
    <head>
        <c:set var="req" value="${pageContext.request}" />
        <c:set var="url">${req.requestURL}</c:set>
        <c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
        <base href="${base}">
        <script src="resources/js/jquery-1.8.3.min.js"></script>

        <title><spring:message code="label.baseTitle"/> - <spring:message code="${titleCode}"/></title>
        <link rel="stylesheet" type="text/css" media="all" href="resources/css/ncr_screen.css" />
    </head>
    <body id="${section}">

      <jsp:doBody/>

    </body>
</html>
