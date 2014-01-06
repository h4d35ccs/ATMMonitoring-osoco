<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.usersManager" userMsg="${userMsg}"  section="users">

	<jsp:attribute name="header">
		<script type="text/javascript">
        $(function() {
            $("thead th.order").click(function(event) {
                var headerUrl = $(this).find("a").attr("href");
                document.location.href = headerUrl;
            });
            $("#users tbody tr").click(function(event) {
                var userUrl = $(this).find("a").attr("href");
                document.location.href = userUrl;
            });
        });
    </script>
	</jsp:attribute>

	<jsp:body>
		<div id="header_g">
			<nav id="breadcrumb">
				<ul>
					<li>
						<a href="dashboard">
							<spring:message code="breadcrumb.home"/>
						</a>
					</li>
					<li>
						<spring:message code="breadcrumb.users"/>
					</li>
				</ul>
			</nav>
		</div>

		<div class="content">
			<h1>
				<spring:message code="label.users"/>
			</h1>

			<h2>
				${pagedListHolder.source.size()}
				<spring:message code="label.users"/>
			</h2>

			<c:if  test="${empty pagedListHolder.pageList}">
				<div class="message">
					<p>
						<spring:message code="label.user.noUsers"/>
					</p>
				</div>
			</c:if>
			<c:if  test="${!empty pagedListHolder.pageList}">
					<div class="margin-box">
						<t:usersTable users="${pagedListHolder.pageList}"
                                           baseUrl="users/list"/>
					</div>
				</div>
				<!-- /table_buttons -->

				<div class="pagination">
					<div class="t_number">
						<span class="text">
							${pagedListHolder.source.size()}
							<spring:message code="label.users"/>
						</span>

					</div>

					<div class="p_number">
						<c:if test="${pagedListHolder.getPageCount() >
							1 }">
							<span class="text">
								<spring:message code="label.page"/>
							</span>

							<t:paging pagedListHolder="${pagedListHolder}" pagedLink="users/list?p=~&sort=${sort}&order=${order}"/>
						</div>
					</c:if>
				</div>

			</div>

		</c:if>

		<div class="hide">
			<div id="help_pop" class="inline">
				<!-- <div class="content">
					<h1>
						<spring:message code="label.terminals"/>
					</h1>
					<h2>
						<spring:message code="label.queries"/>
					</h2>
					<p>
						Scelerisque montes est et! Sit dignissim, sed, aenean ac scelerisque. Pulvinar ac! Elementum natoque penatibus scelerisque sociis tempor, hac ridiculus ac augue non et. Magna dignissim lundium rhoncus turpis! Porttitor eros dis proin pulvinar sagittis ac, facilisis porta mauris tincidunt scelerisque pulvinar. Arcu augue eu. Penatibus sit phasellus lorem in.
					</p>

					<p>
						Ultrices! A, nisi. Parturient amet ac ut et, phasellus odio aenean montes tincidunt eu. Aliquet? Turpis augue? Porta ultrices dignissim enim, sed sit arcu ac porttitor dapibus augue? Turpis nec dignissim augue scelerisque. Dignissim tempor amet sed turpis aliquet, arcu vel in diam? In, in, scelerisque montes eu, velit.
					</p>

					<ol>
						<li>Pulvinar ac!</li>
						<li>Dignissim vel</li>
						<li>Egestas etiam</li>
						<li>Ridiculus elementum</li>
						p
					</ol>

					<p>
						Etiam amet dignissim vel pulvinar, sit in pulvinar habitasse! In scelerisque! Platea hac natoque proin placerat in, elementum, augue etiam dolor amet augue urna nascetur egestas mauris habitasse. Velit? Sed mattis? Magna sed egestas mauris amet et ridiculus sociis! Et velit ut vel, aliquam et pulvinar, et enim turpis.
					</p>

					<p>
						Aliquet. Ridiculus elementum. Egestas etiam? Porttitor porta nisi. Rhoncus. Arcu aenean? Nunc nisi hac, magna montes dis, dolor ridiculus porta purus rhoncus proin augue ut, mauris pulvinar ultricies parturient vut elementum lacus! Enim magna? Sed magnis in dis ultricies dolor pulvinar, parturient porttitor pulvinar, pellentesque auctor lundium, hac ridiculus.
					</p>

					<p>
						Nisi, lorem arcu eu ut cursus, massa! Sit, sit, turpis penatibus elit ut tristique? Placerat! Dolor turpis in integer ac phasellus vut augue, eu ridiculus et sagittis platea hac nunc et, habitasse rhoncus, elementum pulvinar parturient sit facilisis non? Platea dolor egestas diam in dapibus. Urna non eu odio.
					</p>

					<p>
						Tristique? Pulvinar dis, porta! Integer? Nunc sit nisi vel, scelerisque aliquam phasellus dictumst, pid a risus mid platea tincidunt a vel, augue mid? Nunc lorem! Dolor natoque lorem elementum tristique dignissim placerat sed. Natoque, amet elementum sed? Rhoncus turpis a sociis auctor aliquam et cursus dapibus lectus porttitor proin.
					</p>
				</div> -->
				<c:import url="/resources/help/${localeCode}/terminals.html" />
			</div>
		</div>
	</article>
</div>
<!-- /primary -->
</div>

</jsp:body>

</t:osoco-wrapper>
