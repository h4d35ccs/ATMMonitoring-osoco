<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="help">
	
<div class="documentation">
<div id="header_g">
		<nav id="breadcrumb">
			<ul>
				<li>
					<a href="dashboard">inicio</a>
				</li>
				<li><spring:message code="label.menu.help"/></li>
			</ul>
		</nav>
	</div>
	<nav class="menu">
		<h1><spring:message code="label.menu.help"/></h1>
			<ul>
				<li><a href="help/dashboard">Dashboard</a></li>
				<li><a href="help/terminals#" class="current">Terminales</a></li>
				<li><a href="#reports">Informes</a></li>
				<li><a href="#scheduler">Planificador</a></li>
				<li><a href="#users">Usuarios</a></li>
			</ul>
		</nav>
	<div class="scroll">
		<c:import url="/resources/help/${localeCode}/terminals.html" />
	</div><!-- /scroll --></div>
</t:osoco-wrapper>