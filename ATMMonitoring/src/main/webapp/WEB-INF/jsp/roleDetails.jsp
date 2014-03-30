<%@include file="includes/JspImports.jsp"%>
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
				<c:if test="${success != null}">
					<div id ="updateRoleNotification" class="notification">
						<p>
							<spring:message code="${success}" />
						</p>
					</div>
					<script type="text/javascript">
						fadeNotification("#updateRoleNotification", "notification");
					</script>
				</c:if>
				<div class="action_box data desplegable">
					<h2 class="txt last"><spring:message code="label.roleDetails"/></h2>
					<div class="collapsible last">
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
										<li style="width: 100%;">
											<h3>
												<spring:message code="label.role.permissions"/>
											</h3>
											<br>
										</li>
										<li style="width: 100%;">
											<h4>
								 				<form:label path="canViewTerminals" style="padding: 0.1em 1em 0.1em 0.1em;">
													<spring:message code="label.role.canViewTerminals"/>
												</form:label>
											</h4>

											<form:checkbox id="canViewTerminals" class='form-tf-grey' path="canViewTerminals" style="margin: 0;"/><br>
				
								 			<h5>
								 				<form:label path="canEditTerminals" style="padding: 0.1em 1em 0.1em 3.0em;">
													<spring:message code="label.role.canEditTerminals"/>
												</form:label>
											</h5>

											<form:checkbox id="canEditTerminals" class='form-tf-grey' path="canEditTerminals" style="margin: 0;"/><br>
				
								 			<h5>
								 				<form:label path="canRequestUpdate" style="padding: 0.1em 1em 0.1em 3.0em;">
													<spring:message code="label.role.canRequestUpdate"/>
												</form:label>
											</h5>

											<form:checkbox id="canRequestUpdate" class='form-tf-grey' path="canRequestUpdate" style="margin: 0;"/><br>
				
											<h5>
								 				<form:label path="canUseQueries" style="padding: 0.1em 1em 0.1em 3.0em;">
													<spring:message code="label.role.canUseQueries"/>
												</form:label>
											</h5>

											<form:checkbox id="canUseQueries" class='form-tf-grey' path="canUseQueries" style="margin: 0;"/><br>
										</li>
										<li style="width: 100%;">
								 			<h4>
								 				<form:label path="canSchedule" style="padding: 0.1em 1em 0.1em 0.1em;">
													<spring:message code="label.role.canSchedule"/>
												</form:label>
											</h4>

											<form:checkbox id="canSchedule" class='form-tf-grey' path="canSchedule" style="margin: 0;"/><br>
										</li>
										<li style="width: 100%;">
								 			<h4>
								 				<form:label path="canAccessReports" style="padding: 0.1em 1em 0.1em 0.1em;">
													<spring:message code="label.role.canAccessReports"/>
												</form:label>
											</h4>

											<form:checkbox id="canAccessReports" class='form-tf-grey' path="canAccessReports" style="margin: 0;"/><br>
										</li>
									</ul>
								<div class="botonera">

									<button class="btn" onclick="loadInnerSectionFromForm('#role','#primary'); return false;" ><spring:message code="label.role.updateRole"/></button>
                                    <input id="cancelEdit" type="reset" class="cancel right" value="<spring:message code="label.cancel"/>" />
								</div>
								</div>
							</form:form>
					            </div>
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
										<li style="width: 100%;">
											<h3>
												<spring:message code="label.role.permissions"/><br>
											</h3>
											<br>
										</li>
										<li style="width: 100%;">
											<c:if test="${role.canViewTerminals == true}">
								 				<h4>
													<label style="padding: 0.1em 1em 0.1em 0.1em;">
														<spring:message code="label.role.canViewTerminals"/>
													</label>
												</h4><br>
											</c:if>

											<c:if test="${role.canEditTerminals == true}">
												<h5>
													<label style="padding: 0.1em 1em 0.1em 3em;">
														<spring:message code="label.role.canEditTerminals"/>
													</label>
												</h5><br>
											</c:if>

											<c:if test="${role.canRequestUpdate == true}">
												<h5>
													<label style="padding: 0.1em 1em 0.1em 3em;">
														<spring:message code="label.role.canRequestUpdate"/>
													</label>
												</h5><br>
											</c:if>

											<c:if test="${role.canUseQueries == true}">
												<h5>
													<label style="padding: 0.1em 1em 0.1em 3em;">
														<spring:message code="label.role.canUseQueries"/>
													</label>
												</h5><br>
											</c:if>
										</li>
										<li style="width: 100%;">
								 			<c:if test="${role.canSchedule == true}">
								 				<h4>
													<label style="padding: 0.1em 1em 0.1em 0.1em;">
														<spring:message code="label.role.canSchedule"/>
													</label>
												</h4><br>
											</c:if>
										</li>
										<li style="width: 100%;">
								 			<c:if test="${role.canAccessReports == true}">
								 				<h4>
													<label style="padding: 0.1em 1em 0.1em 0.1em;">
														<spring:message code="label.role.canAccessReports"/>
													</label>
												</h4><br>
											</c:if>
										</li>
									</ul>

								<div class="botonera">
									<button id="editRoleButton" class="btn">Editar Rol</button>
								</div>

								</div>
								<!-- //ul-data -->

					</div>
					<!-- // collapsible -->
				</div>
			</div>
<script type="text/javascript">
function initPageJS() { 
            $("#editRoleButton").click(function(event) {
                $("#showRole").hide();
                $("#editForm").show();
	        });
            $("#cancelEdit").click(function(event) {
                $("#showRole").show();
                $("#editForm").hide();
	        });
            $("#canViewTerminals").click(function(event) {
            	if (!$("#canViewTerminals").is(':checked')) {
                	$("#canEditTerminals").attr('checked', false);
                	$("#canRequestUpdate").attr('checked', false);
                   	$("#canUseQueries").attr('checked', false);
                	$("#canEditTerminals").prop('readonly', 'readonly');
                	$("#canRequestUpdate").prop('readonly', 'readonly');
                   	$("#canUseQueries").prop('readonly', 'readonly');
            	} else {
                	$("#canEditTerminals").prop('readonly', '');
                	$("#canRequestUpdate").prop('readonly', '');
                	$("#canUseQueries").prop('readonly', '');
            	}
	        });
            <c:if test="${role.canViewTerminals != true}">
           	$("#canEditTerminals").attr('checked', false);
           	$("#canRequestUpdate").attr('checked', false);
           	$("#canUseQueries").attr('checked', false);
           	$("#canEditTerminals").prop('readonly', 'readonly');
           	$("#canRequestUpdate").prop('readonly', 'readonly');
           	$("#canUseQueries").prop('readonly', 'readonly');
           	</c:if>
            <c:if test="${duplicatedName == true}">
           	$("#showRole").hide();
           	$("#editForm").show();
			</c:if>
	    }
    </script>