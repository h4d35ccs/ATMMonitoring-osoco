<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="users">
<div id="header_g">
	<nav id="breadcrumb">
		<ul>
			<li>
				<a href="dashboard">inicio</a>
			</li>
			<li><a href="users">Usuarios</a></li>
			<li>Nuevo grupo</li>
		</ul>
	</nav>
</div>

<div class="content">
	<h1>Nuevo grupo</h1>
	<div class="row"><label for="name">Nombre del grupo</label> <input id="name" type="text"></div>
	<div class="row"><label for="ldapQuery">Consulta LDAP</label> <textarea id="ldapQuery" ></textarea></div>
</div>
</t:osoco-wrapper>