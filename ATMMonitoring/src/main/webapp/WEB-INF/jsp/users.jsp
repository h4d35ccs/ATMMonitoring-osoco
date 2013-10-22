<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="users">
	<div id="main">
		<div id="primary">
			<article>
				<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard">inicio</a>
							</li>
							<li>
								<a href="terminals">Terminales</a>
							</li>
							<li>Mis consultas</li>
						</ul>
					</nav>
				</div>

				<div class="content">
					<h1>
						<spring:message code="label.usersManager"/>
					</h1>
					<div class="column33">
						<h2>Grupos de usuarios</h2>
					</div>
					<div class="column66">
						<h2>Funcionalidades</h2>
					</div>
				</div>
			</article>
		</div>
	</div>
</t:osoco-wrapper>