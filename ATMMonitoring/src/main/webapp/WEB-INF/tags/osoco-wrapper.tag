<%@tag description="OSOCO version of Simple Wrapper Tag" pageEncoding="UTF-8"%>
<%@attribute name="titleCode" required="true" type="java.lang.String"%>
<%@attribute name="section" required="true" type="java.lang.String"%>
<%@attribute name="userMsg" required="false" type="java.lang.String"%>
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
        <script src="resources/js/menu.js"></script>
	<script type='text/javascript' src="resources/js/jquery-ui.min.js"></script>
	<script type='text/javascript' src="resources/js/jquery.ui.touch-punch.min.js"></script>
	<script type='text/javascript' src='https://www.google.com/jsapi'></script>
	<script type='text/javascript' src='resources/js/google_charts.js'></script>
	<script type='text/javascript' src='resources/js/jquery.colorbox-min.js'></script>

        <title><spring:message code="label.baseTitle"/> - <spring:message code="${titleCode}"/></title>
        <link rel="stylesheet" type="text/css" href="resources/css/ncr_screen.css">
        <!--[if lt IE 9]>
        <script type="text/javascript">
            document.createElement("nav");
            document.createElement("header");
            document.createElement("footer");
            document.createElement("section");
            document.createElement("article");
            document.createElement("aside");
            document.createElement("hgroup");
        </script>
        <![endif]-->
    </head>
    <body id="${section}">
        <header id="main_header">
            <h1>
                <a href="dashboard"><img src="resources/images/general/logo.png"/></a>
                <span>NCR</span> <strong>HASM</strong>
            </h1>
            <div id="user_info">
                <div class="wellcome"><spring:message code="label.welcomeMessage"/> <a href="#">${userMsg}</a></div>
                <div class="date">02/10/13 - 8:30 am</div>
                <div id="lang" class="desplegable">
                    <div class="txt content_hide">
                        <span>Castellano</span>
                    </div>
                    <ul class="ocultable">
                        <li><a href="#">Castellano</a></li>
                        <li><a href="#">English</a></li>
                    </ul>
                </div>
                <sec:authorize access="isAuthenticated()">
                    <div id="exit">
                        <a href="logout"><spring:message code="label.menu.logout"/></a>
                    </div>
                </sec:authorize>
            </div>
        </header>
        <nav id="main_nav">
            <ul>
                <li class="dashboard">
                    <a href="dashboard"><span><spring:message code="label.menu.dashboard"/></span></a>
                </li>
                <li class="terminals">
                    <a href="terminals"><span><spring:message code="label.menu.terminals"/></span></a>
                </li>
                <li class="reports">
                    <a href="externalreports"><span><spring:message code="label.menu.externalreports"/></span></a>
                </li>
                <li class="schedule">
                    <a href="terminals/schedules/list"><span><spring:message code="label.menu.scheduler"/></span></a>
                </li>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_SUPERADMIN')">
                    <li class="users">
                        <a href="users"><span><spring:message code="label.menu.users"/></span></a>
                    </li>
                </sec:authorize>
                <li class="help">
                    <a href="help"><span><spring:message code="label.menu.help"/></span></a>
                </li>
            </ul>
        </nav>

        <jsp:doBody/>

    </body>
</html>
