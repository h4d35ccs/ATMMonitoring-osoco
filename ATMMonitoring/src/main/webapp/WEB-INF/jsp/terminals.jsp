<%@include file="includes/JspImports.jsp"%>
  <fmt:formatDate value="${queryDate}" pattern="dd/MM/yyyy" var="stringQueryDate"/>
		<div id="header_g">
			<%-- <nav id="breadcrumb">
				<ul>
					<li><a href="dashboard"> <spring:message code="breadcrumb.home"/> </a> </li>
					<li> <spring:message code="breadcrumb.terminals"/> </li>
				</ul>
			</nav> --%>
			<c:set var="navigationBackMain" scope="request" >home</c:set>
			<c:set var="navigationActual" value="breadcrumb.terminals" scope="request" />
			<jsp:include page="includes/navigation.jsp" />
			<div class="botonera">
				<ul>
					<sec:authorize access="hasAnyRole(${terminalsManagementAllowedRoles})">
						<li> <button onclick="loadInnerSection('#primary', 'terminals/new')" class="btn add"> <spring:message code="label.terminal.new"/> </button> </li>
					</sec:authorize>
				</ul>
			</div>
		</div>
		<div  id="contentparent">
			<div class="content" id="contentTerminal">
				<h1>
					<spring:message code="label.terminals"/>
				</h1>
				<sec:authorize access="hasAnyRole(${queriesAccessAllowedRoles})">
					<terminal:terminalQueryForm stringQueryDate="${stringQueryDate}" userQueries="${userQueries}" 
												selectedQuery="${query}" />
				</sec:authorize>
				<c:if test="${timeout}">
					<div class="message">
						<p>${timeout}</p>
					</div>
				</c:if>
				<c:if test="${success}">
					<div class="notification">
						<p>${success}</p>
					</div>
				</c:if>
				<div id="ajaxMsg"><p id="ajaxMsg"></p></div>
				<c:if  test="${empty pagedListHolder.pageList}">
					<div class="message">
						<p> <spring:message code="label.terminal.noTerminals"/> </p>
					</div>
				</c:if>
				<c:if  test="${!empty pagedListHolder.pageList}">
					<h2 id="terminalsTotalResult"> 
					    ${pagedListHolder.source.size()}
						<spring:message code="label.terminals"/>
		
						<c:if test="${query != null}">
							<spring:message code="label.forquery"/> : ${query.name}
							<a href="queries/show?queryId=${query.id}" class="edit">
								<span> <g:message code="label.edit"/> </span>
							</a>
						</c:if>
					</h2>
					<div class="tab_buttons">
						<div id="columns" class="columns_botonera">
							<nav>
								<ul class="sub_nav">
									<li class="lista">
										<a href=#><span><spring:message code="terminals.show.list.label" /></span></a>
									</li>
									<li class="mapa" data-on-show="terminalMap.paintIfNecessary()" >
										<a href=# > <span><spring:message code="terminals.show.map.label" /></span></a>
									</li>
								</ul>
							</nav>
						</div>
					</div>
					<div id="pagTable">
						<div id="tabs">
							<div class="content_tab">
								<terminal:terminalsTable terminals="${pagedListHolder.pageList}" stringQueryDate="${stringQueryDate}"
						                             baseUrl="${query != null ? 'terminals/byQuery' : 'terminals/list'}"
						                             query="${selectedQuery}"/> 
							</div>
							<div class="content_tab">
								<terminal:terminalsMap/>
							</div>
						</div>
					</div>
				</c:if>
				<div class="hide">
					<div id="help_pop" class="inline">
						<c:import url="/resources/help/${localeCode}/terminals.html" />
					</div>
				</div>
			</div>
		</div>
<script type="text/javascript">
		 function initPageJS() { 
			defaultInitTabs();
			terminalMap = new TerminalsMap();
			terminalMap.initialize();   
		 }
</script>