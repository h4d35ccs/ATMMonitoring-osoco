<%@include file="JspImports.jsp"%>
	<nav id="breadcrumb">	
		<ul>
				
					<c:forTokens items="${navigationBackMain}" delims="," var="sectionBack">
			   				
			   				<c:if test="${sectionBack == 'home'}">
				   				<li>
				   					<a onclick="$('#dashboardMenu').click()"> 
				   						<spring:message code="breadcrumb.home"/>  
				   					</a> 
				   				</li>
			   				</c:if>
			   				
			   				<c:if test="${sectionBack == 'terminals'}">
				   				<li>
				   					<a onclick="$('#terminalMenu').click()"> 
				   						<spring:message code="breadcrumb.terminals"/> 
				   					</a>
				   				</li>
			   				</c:if>
			   				<c:if test="${sectionBack == 'reports'}">
				   				<li>
				   					<a onclick="$('#externalReportsMenu').click()">
				   						 <spring:message code="breadcrumb.reports"/>
				   					 </a>
				   				</li>
				   				</c:if>
			   				<c:if test="${sectionBack == 'schedulers'}">
			   					<li>
			   						<a onclick="$('#scheduleMenu').click()"> 
			   							<spring:message code="label.scheduler"/>
			   						</a>
			   					</li>
			   				</c:if>
			   				<c:if test="${sectionBack == 'queries'}">
			   					<li>
			   						<a onclick="loadInnerSection('#primary', 'queries')"> 
			   							<spring:message code="label.queries.mine"/>
			   						</a>
			   					</li>
			   				</c:if>
					</c:forTokens>	
							<li><spring:message code="${navigationActual}"/>
								<c:if test="${!empty navigationActualExtra}">
									${navigationActualExtra}
								</c:if>
							</li>
								 
							
							</ul>
					</nav>