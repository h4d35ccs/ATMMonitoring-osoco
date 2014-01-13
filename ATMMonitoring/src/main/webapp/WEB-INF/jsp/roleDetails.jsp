<%@taglib uri="http://www.ncr.com/tags" prefix="ncr"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.rolesManager" userMsg="${userMsg}" section="roles">

<jsp:attribute name="header">
    <script type="text/javascript">
        $(function() {
            $("#editRoleButton").click(function(event) {
                $("#showRole").hide();
                $("#editForm").show();
	        });
            $("#cancelEdit").click(function(event) {
                $("#showRole").show();
                $("#editForm").hide();
	        });
            <c:if test="${duplicatedName == true}">
           	$("#showRole").hide();
           	$("#editForm").show();
			</c:if>
	    });
    </script>
</jsp:attribute>

<jsp:body>
			<div id="header_g">
					<nav id="breadcrumb">
						<ul>
							<li>
								<a href="dashboard"><spring:message code="breadcrumb.home"/></a>
							</li>
							<li>
								<a href="users"><spring:message code="breadcrumb.users"/></a>
							</li>
							<li><spring:message code="label.role"/> ${role.name}</li>
						</ul>
					</nav>
				</div>
			<div class="content">
				<h1><spring:message code="label.role.name"/> ${role.name}</h1>

				<div class="action_box data desplegable">
					<h2 class="txt last"><spring:message code="label.roleDetails"/></h2>
					<div class="collapsible last">
							<c:if test="${((canEdit == true) && (role.manageable == true))}">
						      <div id="editForm" class="${errors != null ? '': 'hide'}">
								<form:form method="post" action="users/roles/update" commandName="role">
									<form:hidden path="id"/>
									<div class="ul_data ul_data_wide editable">
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
											</li>
											<li> <strong><form:label path="description">
														<spring:message code="label.role.description"/>
													</form:label></strong>

												<form:input class='form-tf-grey' path="description" maxlength="300"/>
											</li>
											<li>
												<strong>
													<spring:message code="label.role.permissions"/>
												</strong>
												<br>
					
									 			<form:label path="canEditTerminals">
													<spring:message code="label.role.canEditTerminals"/>
												</form:label>

												<form:checkbox class='form-tf-grey' path="canEditTerminals"/><br>
											</li>
										</ul>
									<div class="botonera">

										<input type="submit" class="btn" value="<spring:message code="label.role.updateRole"/>"/>
	                                    <input id="cancelEdit" type="reset" class="cancel right" value="<spring:message code="label.cancel"/>" />
									</div>

									</div>
								</form:form>
						            </div>
							</c:if>

								<div id="showRole"  class="ul_data ul_data_wide ${errors  != null ? 'hide': ''}">
									<ul>
										<li>
											<strong>
												<spring:message code="label.role.name"/>
											</strong>
											${role.name}
										</li>
										<li>
											<strong>
												<spring:message code="label.role.description"/>
											</strong>
											${role.description}
										</li>
										<li>
											<strong>
												<spring:message code="label.role.permissions"/>
											</strong>
											<br>
											<c:if test="${role.canEditTerminals == true}">
												<spring:message code="label.role.canEditTerminals"/><br>
											</c:if>
										</li>
									</ul>

								<c:if test="${((canEdit == true) && (role.manageable == true))}">
									<div class="botonera">
										<button id="editRoleButton" class="btn">Editar Rol</button>
									</div>
								</c:if>

								</div>
								<!-- //ul-data -->

					</div>
					<!-- // collapsible -->
				</div>
			</div>

</jsp:body>

</t:osoco-wrapper>