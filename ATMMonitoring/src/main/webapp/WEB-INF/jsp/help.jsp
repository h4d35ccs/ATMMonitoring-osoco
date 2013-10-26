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
				<li><a href="#dasboard">Dasboard</a>
					<ul>
						<li><a href="#" class="current">Opcion 1</a></li>
						<li><a href="#">Opcion 2</a></li>
						<li><a href="#">Opcion 3</a></li>
						<li><a href="#">Opcion 4</a></li>
						<li><a href="#">Opcion 5</a></li>
					</ul>
				</li>
				<li><a href="#terminals">Terminales</a></li>
				<li><a href="#reports">Informes</a></li>
				<li><a href="#scheduler">Planificador</a></li>
				<li><a href="#users">Usuarios</a></li>
			</ul>
		</nav>
	<div class="scroll">
		<div class="content">
			
			<h2>Dasboard</h2>
				<p><a href="resources/images/ejemplo/db_b.png" class="colorbox photo right"><img src="resources/images/ejemplo/db_s.png" /></a>Scelerisque montes est et! Sit dignissim, sed, aenean ac scelerisque. Pulvinar ac! Elementum natoque penatibus scelerisque sociis tempor, hac ridiculus ac augue non et. Magna dignissim lundium rhoncus turpis! Porttitor eros dis proin pulvinar sagittis ac, facilisis porta mauris tincidunt scelerisque pulvinar. Arcu augue eu. Penatibus sit phasellus lorem in.</p>

				<h3>Pulvinar ac!</h3>

				<p>Ultrices! A, nisi. Parturient amet ac ut et, <strong>phasellus odio aenean montes</strong> tincidunt eu. Aliquet? Turpis augue? Porta ultrices dignissim enim, sed sit arcu ac porttitor dapibus augue? Turpis nec dignissim augue scelerisque. <a href="#">Dignissim tempor amet sed turpis aliquet</a>, arcu vel in diam? In, in, scelerisque montes eu, velit.</p>

				<ul>
					<li>Pulvinar ac!</li>
					<li>Dignissim vel</li>
					<li>Egestas etiam</li>
					<li>Ridiculus elementum</li>
				</ul>

				<p class="notification">Etiam amet dignissim vel pulvinar, sit in pulvinar habitasse! In scelerisque! Platea hac natoque proin placerat in, elementum, augue etiam dolor amet augue urna nascetur egestas mauris habitasse. Velit? Sed mattis? Magna sed egestas mauris amet et ridiculus sociis! Et velit ut vel, aliquam et pulvinar, et enim turpis.</p>

				<p>Aliquet. Ridiculus elementum. Egestas etiam? Porttitor porta nisi. Rhoncus. Arcu aenean? Nunc nisi hac, magna montes dis, dolor ridiculus porta purus rhoncus proin augue ut, mauris pulvinar ultricies parturient vut elementum lacus! Enim magna? Sed magnis in dis ultricies dolor pulvinar, parturient porttitor pulvinar, pellentesque auctor lundium, hac ridiculus.</p>

				<p>Nisi, lorem arcu eu ut cursus, massa! Sit, sit, turpis penatibus elit ut tristique? Placerat! Dolor turpis in integer ac phasellus vut augue, eu ridiculus et sagittis platea hac nunc et, habitasse rhoncus, elementum pulvinar parturient sit facilisis non? Platea dolor egestas diam in dapibus. Urna non eu odio.</p>

				<p>Tristique? Pulvinar dis, porta! Integer? Nunc sit nisi vel, scelerisque aliquam phasellus dictumst, pid a risus mid platea tincidunt a vel, augue mid? Nunc lorem! Dolor natoque lorem elementum tristique dignissim placerat sed. Natoque, amet elementum sed? Rhoncus turpis a sociis auctor aliquam et cursus dapibus lectus porttitor proin.</p>
		</div>
		<div class="content">
			<h2>Terminales</h2>
			<p>Scelerisque montes est et! Sit dignissim, sed, aenean ac scelerisque. Pulvinar ac! Elementum natoque penatibus scelerisque sociis tempor, hac ridiculus ac augue non et. Magna dignissim lundium rhoncus turpis! Porttitor eros dis proin pulvinar sagittis ac, facilisis porta mauris tincidunt scelerisque pulvinar. Arcu augue eu. Penatibus sit phasellus lorem in.</p>

				<p>Ultrices! A, nisi. Parturient amet ac ut et, phasellus odio aenean montes tincidunt eu. Aliquet? Turpis augue? Porta ultrices dignissim enim, sed sit arcu ac porttitor dapibus augue? Turpis nec dignissim augue scelerisque. Dignissim tempor amet sed turpis aliquet, arcu vel in diam? In, in, scelerisque montes eu, velit.</p>

				<ol>
					<li>Pulvinar ac!</li>
					<li>Dignissim vel</li>
					<li>Egestas etiam</li>
					<li>Ridiculus elementum</li>
				</ol>

				<p>Etiam amet dignissim vel pulvinar, sit in pulvinar habitasse! In scelerisque! Platea hac natoque proin placerat in, elementum, augue etiam dolor amet augue urna nascetur egestas mauris habitasse. Velit? Sed mattis? Magna sed egestas mauris amet et ridiculus sociis! Et velit ut vel, aliquam et pulvinar, et enim turpis.</p>

				<p>Aliquet. Ridiculus elementum. Egestas etiam? Porttitor porta nisi. Rhoncus. Arcu aenean? Nunc nisi hac, magna montes dis, dolor ridiculus porta purus rhoncus proin augue ut, mauris pulvinar ultricies parturient vut elementum lacus! Enim magna? Sed magnis in dis ultricies dolor pulvinar, parturient porttitor pulvinar, pellentesque auctor lundium, hac ridiculus.</p>

				<p>Nisi, lorem arcu eu ut cursus, massa! Sit, sit, turpis penatibus elit ut tristique? Placerat! Dolor turpis in integer ac phasellus vut augue, eu ridiculus et sagittis platea hac nunc et, habitasse rhoncus, elementum pulvinar parturient sit facilisis non? Platea dolor egestas diam in dapibus. Urna non eu odio.</p>

				<p>Tristique? Pulvinar dis, porta! Integer? Nunc sit nisi vel, scelerisque aliquam phasellus dictumst, pid a risus mid platea tincidunt a vel, augue mid? Nunc lorem! Dolor natoque lorem elementum tristique dignissim placerat sed. Natoque, amet elementum sed? Rhoncus turpis a sociis auctor aliquam et cursus dapibus lectus porttitor proin.</p>
		</div>
		<div class="content">
			<h2>Usuarios</h2>
			<p>Scelerisque montes est et! Sit dignissim, sed, aenean ac scelerisque. Pulvinar ac! Elementum natoque penatibus scelerisque sociis tempor, hac ridiculus ac augue non et. Magna dignissim lundium rhoncus turpis! Porttitor eros dis proin pulvinar sagittis ac, facilisis porta mauris tincidunt scelerisque pulvinar. Arcu augue eu. Penatibus sit phasellus lorem in.</p>

				<p>Ultrices! A, nisi. Parturient amet ac ut et, phasellus odio aenean montes tincidunt eu. Aliquet? Turpis augue? Porta ultrices dignissim enim, sed sit arcu ac porttitor dapibus augue? Turpis nec dignissim augue scelerisque. Dignissim tempor amet sed turpis aliquet, arcu vel in diam? In, in, scelerisque montes eu, velit.</p>

				<p>Etiam amet dignissim vel pulvinar, sit in pulvinar habitasse! In scelerisque! Platea hac natoque proin placerat in, elementum, augue etiam dolor amet augue urna nascetur egestas mauris habitasse. Velit? Sed mattis? Magna sed egestas mauris amet et ridiculus sociis! Et velit ut vel, aliquam et pulvinar, et enim turpis.</p>

				<p>Aliquet. Ridiculus elementum. Egestas etiam? Porttitor porta nisi. Rhoncus. Arcu aenean? Nunc nisi hac, magna montes dis, dolor ridiculus porta purus rhoncus proin augue ut, mauris pulvinar ultricies parturient vut elementum lacus! Enim magna? Sed magnis in dis ultricies dolor pulvinar, parturient porttitor pulvinar, pellentesque auctor lundium, hac ridiculus.</p>

				<p>Nisi, lorem arcu eu ut cursus, massa! Sit, sit, turpis penatibus elit ut tristique? Placerat! Dolor turpis in integer ac phasellus vut augue, eu ridiculus et sagittis platea hac nunc et, habitasse rhoncus, elementum pulvinar parturient sit facilisis non? Platea dolor egestas diam in dapibus. Urna non eu odio.</p>

				<p>Tristique? Pulvinar dis, porta! Integer? Nunc sit nisi vel, scelerisque aliquam phasellus dictumst, pid a risus mid platea tincidunt a vel, augue mid? Nunc lorem! Dolor natoque lorem elementum tristique dignissim placerat sed. Natoque, amet elementum sed? Rhoncus turpis a sociis auctor aliquam et cursus dapibus lectus porttitor proin.</p>
		</div>
		<div class="content">
			<h2>Informes</h2>
			<p>Scelerisque montes est et! Sit dignissim, sed, aenean ac scelerisque. Pulvinar ac! Elementum natoque penatibus scelerisque sociis tempor, hac ridiculus ac augue non et. Magna dignissim lundium rhoncus turpis! Porttitor eros dis proin pulvinar sagittis ac, facilisis porta mauris tincidunt scelerisque pulvinar. Arcu augue eu. Penatibus sit phasellus lorem in.</p>

				<p>Ultrices! A, nisi. Parturient amet ac ut et, phasellus odio aenean montes tincidunt eu. Aliquet? Turpis augue? Porta ultrices dignissim enim, sed sit arcu ac porttitor dapibus augue? Turpis nec dignissim augue scelerisque. Dignissim tempor amet sed turpis aliquet, arcu vel in diam? In, in, scelerisque montes eu, velit.</p>

				<p>Etiam amet dignissim vel pulvinar, sit in pulvinar habitasse! In scelerisque! Platea hac natoque proin placerat in, elementum, augue etiam dolor amet augue urna nascetur egestas mauris habitasse. Velit? Sed mattis? Magna sed egestas mauris amet et ridiculus sociis! Et velit ut vel, aliquam et pulvinar, et enim turpis.</p>

				<p>Aliquet. Ridiculus elementum. Egestas etiam? Porttitor porta nisi. Rhoncus. Arcu aenean? Nunc nisi hac, magna montes dis, dolor ridiculus porta purus rhoncus proin augue ut, mauris pulvinar ultricies parturient vut elementum lacus! Enim magna? Sed magnis in dis ultricies dolor pulvinar, parturient porttitor pulvinar, pellentesque auctor lundium, hac ridiculus.</p>

				<p>Nisi, lorem arcu eu ut cursus, massa! Sit, sit, turpis penatibus elit ut tristique? Placerat! Dolor turpis in integer ac phasellus vut augue, eu ridiculus et sagittis platea hac nunc et, habitasse rhoncus, elementum pulvinar parturient sit facilisis non? Platea dolor egestas diam in dapibus. Urna non eu odio.</p>

				<p>Tristique? Pulvinar dis, porta! Integer? Nunc sit nisi vel, scelerisque aliquam phasellus dictumst, pid a risus mid platea tincidunt a vel, augue mid? Nunc lorem! Dolor natoque lorem elementum tristique dignissim placerat sed. Natoque, amet elementum sed? Rhoncus turpis a sociis auctor aliquam et cursus dapibus lectus porttitor proin.</p>
		</div>
		<div class="content">
			<h2>Planificador</h2>
			<p>Scelerisque montes est et! Sit dignissim, sed, aenean ac scelerisque. Pulvinar ac! Elementum natoque penatibus scelerisque sociis tempor, hac ridiculus ac augue non et. Magna dignissim lundium rhoncus turpis! Porttitor eros dis proin pulvinar sagittis ac, facilisis porta mauris tincidunt scelerisque pulvinar. Arcu augue eu. Penatibus sit phasellus lorem in.</p>

				<p>Ultrices! A, nisi. Parturient amet ac ut et, phasellus odio aenean montes tincidunt eu. Aliquet? Turpis augue? Porta ultrices dignissim enim, sed sit arcu ac porttitor dapibus augue? Turpis nec dignissim augue scelerisque. Dignissim tempor amet sed turpis aliquet, arcu vel in diam? In, in, scelerisque montes eu, velit.</p>

				<p>Etiam amet dignissim vel pulvinar, sit in pulvinar habitasse! In scelerisque! Platea hac natoque proin placerat in, elementum, augue etiam dolor amet augue urna nascetur egestas mauris habitasse. Velit? Sed mattis? Magna sed egestas mauris amet et ridiculus sociis! Et velit ut vel, aliquam et pulvinar, et enim turpis.</p>

				<p>Aliquet. Ridiculus elementum. Egestas etiam? Porttitor porta nisi. Rhoncus. Arcu aenean? Nunc nisi hac, magna montes dis, dolor ridiculus porta purus rhoncus proin augue ut, mauris pulvinar ultricies parturient vut elementum lacus! Enim magna? Sed magnis in dis ultricies dolor pulvinar, parturient porttitor pulvinar, pellentesque auctor lundium, hac ridiculus.</p>

				<p>Nisi, lorem arcu eu ut cursus, massa! Sit, sit, turpis penatibus elit ut tristique? Placerat! Dolor turpis in integer ac phasellus vut augue, eu ridiculus et sagittis platea hac nunc et, habitasse rhoncus, elementum pulvinar parturient sit facilisis non? Platea dolor egestas diam in dapibus. Urna non eu odio.</p>

				<p>Tristique? Pulvinar dis, porta! Integer? Nunc sit nisi vel, scelerisque aliquam phasellus dictumst, pid a risus mid platea tincidunt a vel, augue mid? Nunc lorem! Dolor natoque lorem elementum tristique dignissim placerat sed. Natoque, amet elementum sed? Rhoncus turpis a sociis auctor aliquam et cursus dapibus lectus porttitor proin.</p>
		</div>
	</div><!-- /scroll --></div>
</t:osoco-wrapper>