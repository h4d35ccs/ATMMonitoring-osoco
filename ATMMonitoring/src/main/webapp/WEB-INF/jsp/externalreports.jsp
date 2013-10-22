<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="reports">
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
						<spring:message code="label.externalreportsMan"/>
					</h1>

					<h2>
						<spring:message code="label.externalreports"/>
					</h2>
					<div class="box-tableContainer">
						<iframe width="1000" height="900" src="http://1.0.0.2/MicroStrategy/asp/Main.aspx?Server=PC-ELI&Project=inventory&port=0&evt=2048001&src=Main.aspx.2048001&visMode=0&documentID=3438E8F542936CA3E0D0C7A1662D35DB&currentViewMedia=2&hiddensections=header,path,dockTop,dockLeft,footer"  name='iframe'></iframe>
					</div>
				</div>
			</article>
		</div>
	</div>
</t:osoco-wrapper>