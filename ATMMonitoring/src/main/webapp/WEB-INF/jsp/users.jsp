<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.queryEngine" userMsg="${userMsg}"  section="users">
	<div  class="documentation">
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
		<div class="menu">
			<nav>
			<h1>
				<spring:message code="label.usersManager"/>
			</h1>
				<h2>Grupos de usuarios</h2>
				<ul class="user_groups">
					<li><a href="#" class="current">Grupo 1</a></li>
					<li><a href="#">Grupo 2</a></li>
					<li><a href="#">Grupo 3</a></li>
					<li><a href="#">Grupo 4</a></li>
					<li><a href="#">Grupo 5</a></li>
					<li><a href="#">Grupo 6</a></li>
				</ul>
			</nav>

			<div class="botonera">
					<a href="#" class="btn add">Crear nuevo grupo</a>
			</div>
		</div>
			<div class="scroll">
				<h2>Funcionalidades</h2>
				<ul class="features">
					<li><h3>Terminales</h3>
						<ul>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
						</ul>
					</li>
					<li><h3>Consultas</h3>
						<ul>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
						</ul>
					</li>
					<li><h3>Informes</h3>
						<ul>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
							<li><input type="checkbox" checked="checked"><label>Lorem ipsum</label></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>
</t:osoco-wrapper>