 <%@include file="includes/JspImports.jsp"%> 
<%
    String[] userSortColumns = { "username" , "firstname", "lastname" };
	String[] userNotSortColumns = { "role", "bankCompany" };
    request.setAttribute("userSortColumns", userSortColumns);
    request.setAttribute("userNotSortColumns", userNotSortColumns);

    String[] roleSortColumns = { "name", "description"};
    request.setAttribute("roleSortColumns", roleSortColumns);
%>
		<div id="header_g">
			<nav id="breadcrumb">
				<ul>
					<sec:authorize access="hasAnyRole(${dashboardAccessAllowedRoles})">
						<li>
							<a href="dashboard">
								<spring:message code="breadcrumb.home"/>
							</a>
						</li>
					</sec:authorize>
					<li>
						<spring:message code="breadcrumb.users"/>
					</li>
				</ul>
			</nav>
		</div>
		
		<div class="content">
			<div id="userSection" style="min-height:300px;">
			<h1>
				<spring:message code="label.users"/>
			</h1>

			<h2>
				${pagedListHolder1.source.size()}
				<spring:message code="label.users"/>
			</h2>
			<c:if  test="${empty pagedListHolder1.pageList}">
				<div class="message">
					<p>
						<spring:message code="label.user.noUsers"/>
					</p>
				</div>
			</c:if>
			<c:if  test="${!empty pagedListHolder1.pageList}">
			 <div id="pagTable">	
				<div class="margin-box">
					<%-- the min-heigth avoid the lower table to rise wile rendering the pagination or sorting--%>
					<div id="userTableCont" style="min-height:100px;">
					<table class="link" >
					  <thead>
					  <tr>
					    <!--th></th-->
					    <c:forEach items="${userSortColumns}" var="column">
					      <c:set var="isColumnSorted" value="${column.equals(sort1)}"/>
					      <c:set var="orderValue" value="${(isColumnSorted && 'asc'.equals(order1)) ? 'desc' : 'asc'}"/>
					      <c:if test="${isColumnSorted}">
					        <c:set var="sortClass" value="${('asc'.equals(order1)) ? 'top' : 'bottom'}"/>
					      </c:if>
					      <c:if test="${!isColumnSorted}">
					        <c:set var="sortClass" value=""/>
					      </c:if>
					      <th class="order ${sortClass} clickeableMenu" onclick="loadInnerSection('#userTableCont','users/list?p2=${pagedListHolder2.page}&sort2=${sort2}&order2=${order2}&p1=${pagedListHolder1.page}&sort1=${column}&order1=${orderValue} #userTableCont')"><spring:message code="label.user.${column}"/></th>
					    </c:forEach>
					    <c:forEach items="${userNotSortColumns}" var="column">
					    	<th><spring:message code="label.user.${column}"/></th>
					    </c:forEach>
					  </tr>
					  </thead>
					  <tbody>
					  <c:forEach items="${pagedListHolder1.pageList}" var="user">
					    <tr>
					      <td><a class="clickeableMenu" onclick="loadInnerSection('#primary','users/details/${user.id}')">${user.username}</a></td>
					      <td>${user.firstname}</td>
						  <td>${user.lastname}</td>
					      <td>${user.role.name}</td>
					      <td>${user.bankCompany.name}</td>
					    </tr>
					  </c:forEach>
					  </tbody>
					</table>
					</div>
				</div>
				
				<!-- /table_buttons -->
				<div class="pagination" >
					<div class="t_number">
						<span class="text">
							${pagedListHolder1.source.size()}
							<spring:message code="label.users"/>
						</span>
					</div>
					<div class="p_number">
						<c:if test="${pagedListHolder1.getPageCount() >
							1 }">
							<span class="text">
								<spring:message code="label.page"/>
							</span>

							<t:paging pagedListHolder="${pagedListHolder1}" pagedLink="users/list?p1=~&p2=${pagedListHolder2.page}&sort1=${sort1}&order1=${order1}&sort2=${sort2}&order2=${order2}"/>
						</c:if>
					</div>
				</div>
			</div>
			</c:if>
			</div>
			<div id="roleSection" style="min-height:300px;">
					<h1>
						<spring:message code="label.roles"/>
					</h1>
		
					<h2>
						${pagedListHolder2.source.size()}
						<spring:message code="label.roles"/>
					</h2>
					<c:if  test="${empty pagedListHolder2.pageList}">
						<div class="message">
							<p>
								<spring:message code="label.role.noRoles"/>
							</p>
						</div>
					</c:if>
					<c:if  test="${!empty pagedListHolder2.pageList}">
					 <div id="pagRoleTable">
						<div id="roleTableCont" style="min-height:100px;">
							<div class="margin-box">
								<table class="link">
								  <thead>
								  <tr>
								    <!--th></th-->
								    <c:forEach items="${roleSortColumns}" var="column">
								      <c:set var="isColumnSorted" value="${column.equals(sort2)}"/>
								      <c:set var="orderValue" value="${(isColumnSorted && 'asc'.equals(order2)) ? 'desc' : 'asc'}"/>
								      <c:if test="${isColumnSorted}">
								        <c:set var="sortClass" value="${('asc'.equals(order2)) ? 'top' : 'bottom'}"/>
								      </c:if>
								      <c:if test="${!isColumnSorted}">
								        <c:set var="sortClass" value=""/>
								      </c:if>
								      <th class="order ${sortClass} clickeableMenu" onclick="loadInnerSection('#roleTableCont','users/list?p1=${pagedListHolder1.page}&sort1=${sort1}&order1=${order1}&p2=${pagedListHolder2.page}&sort2=${column}&order2=${orderValue} #roleTableCont')"><spring:message code="label.role.${column}"/></th>
								    </c:forEach>
								  </tr>
								  </thead>
								  <tbody>
								  <c:forEach items="${pagedListHolder2.pageList}" var="role">
								    <tr>
								      <td class="editable w33">
								      	<div class="relative">
								      		<c:choose>
												<c:when test="${role.users.size() == 0}">
													<div class="icons_action"><a href="#" class="delete" data-role-id="${role.id}"><span><spring:message code="label.delete"/></span></a></div>
												</c:when>
												<c:otherwise>
													<div class="icons_action"><a href="#" class="delete_wrong"><span><spring:message code="label.delete"/></span></a></div>
												</c:otherwise>
											</c:choose>
											 <a class="clickeableMenu" onclick="loadInnerSection('#primary','users/roles/details/${role.id}')">${role.name}</a>
										</div>
									  </td>
									  <td>${role.description}</td>
								    </tr>
								  </c:forEach>
								  </tbody>
								</table>
							</div>
						</div>
						<!-- /table_buttons -->
						<div class="pagination">
							<div class="t_number">
								<span class="text">
									${pagedListHolder2.source.size()}
									<spring:message code="label.roles"/>
								</span>
		
							</div>
							<div class="p_number">
								<c:if test="${pagedListHolder2.getPageCount() >
									1 }">
									<span class="text">
										<spring:message code="label.page"/>
									</span>
		
									<t:paging pagedListHolder="${pagedListHolder2}" pagedLink="users/list?p1=${pagedListHolder1.page}&p2=~&sort1=${sort1}&order1=${order1}&sort2=${sort2}&order2=${order2}" tableSection="#pagRoleTable"/>
								</c:if>
							</div>
						</div>
						</div>
					</c:if>
					<form:form method="post" action="users/roles/add" commandName="role">
						<div class="ul_data ul_data_wide editable" style="float: right;">
							<ul>
								<li> <strong><form:label path="name">
											<spring:message code="label.role.name"/>
										</form:label></strong>
		
									<form:input class='form-tf-grey' path="name" maxlength="100"/>
		
									<form:errors path="name" element="div" cssClass="error top"/>
									<c:if test="${duplicatedName == true}">
									   	<div class="error top">
										<spring:message code="label.role.duplicatedName"/>
										</div>
									</c:if>
									<div id="errortopAjax"></div>
								</li>
							</ul>
						<div class="botonera">
							<button class="btn" onclick="addNewRole('#role','POST','#errortopAjax','error top',duplicadedNameErrorMsg,'#primary'); return false;"><spring:message code="label.role.addRole"/></button>
						</div>
						</div>
					</form:form>
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
		</div>
</div>
<script type="text/javascript">
var duplicadedNameErrorMsg = '';
function initPageJS() {
	 duplicadedNameErrorMsg = '<spring:message code="label.role.duplicatedName"/>';

            $(".delete").click(function(event) {
                event.stopPropagation();
                event.preventDefault();
                var roleId= $(this).data('roleId');
                deleteQueryIcon("#primary","users/roles/delete?roleId=" + roleId, "¿Estás seguro de que quieres borrar el rol?");
            });
            $(".delete_wrong").click(function(event) {
                event.stopPropagation();
                event.preventDefault();
                alert('No se puede borrar un rol con usuarios asignados.');
            });
        };
    </script>