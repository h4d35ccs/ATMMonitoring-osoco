<%@include file="includes/JspImports.jsp"%>
		<div id="header_g">
			<%-- <nav id="breadcrumb">
				<ul>
					<li><a href="dashboard"> <spring:message code="breadcrumb.home"/> </a> </li>
					<li> <spring:message code="breadcrumb.terminals"/> </li>
				</ul>
			</nav> --%>
			<c:set var="navigationBackMain" scope="request" >home</c:set>
			<c:set var="navigationActual" value="breadcrumb.ups" scope="request" />
			<jsp:include page="includes/navigation.jsp" />
		</div>
		<div  id="contentparent">
			<div class="content" id="contentUps">
				<h1>
					<spring:message code="label.upss"/>
				</h1>
				<sec:authorize access="hasAnyRole(${upsQueriesAccessAllowedRoles})">
					<ups:upsQueryForm userQueries="${userQueries}" selectedQuery="${query}" />
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
						<p> <spring:message code="label.ups.noUpss"/> </p>
					</div>
				</c:if>
				<c:if  test="${!empty pagedListHolder.pageList}">
					<h2 id="upsTotalResult"> 
					    ${pagedListHolder.source.size()}
						<spring:message code="label.upss"/>
		
						<c:if test="${query != null}">
							<spring:message code="label.forquery"/> : ${query.name}
							<a href="ups/queries/show?queryId=${query.id}" class="edit">
								<span> <g:message code="label.edit"/> </span>
							</a>
						</c:if>
					</h2>
					<div id="pagTable">
						<ups:upsTable upss="${pagedListHolder.pageList}" baseUrl="${query != null ? 'ups/byQuery' : 'ups/list'}"
				                             query="${selectedQuery}"/>
					</div>
				</c:if>
				<div class="hide">
					<div id="help_pop" class="inline" style="width:800px;height: 500px">
						
					</div>
				</div>
			</div>
		</div>
<script type="text/javascript">
		 function initPageJS() {
			loadHelpHTML('terminals',"#help_pop",'#queries'); 
			$("#queryHelp").click(function() {
				$("#queryHelp").colorbox({inline:true, href: "#help_pop"});
			});
		 }
</script>