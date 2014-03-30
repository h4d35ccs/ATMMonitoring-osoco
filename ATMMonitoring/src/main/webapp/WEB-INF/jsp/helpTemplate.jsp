<%@include file="includes/JspImports.jsp"%>
<script>
 function initPageJS() {
	 loadHelpContent("#userMainHelp",'current','user-main','#helpContent');
	
} 
</script>
<div class="documentation">
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
					<li><spring:message code="label.menu.help"/></li>
				</ul>
			</nav>
		</div>
		<nav class="menu">
			<h1><spring:message code="label.menu.help"/></h1>
				<ul class="clickeableMenu">
					<li><a id ="userMainHelp"  onclick="loadHelpContent('#'+this.id,'current','user-main','#helpContent')">
						<spring:message code="label.help.userMain"/></a></li>
					<li><a id="loginLogoutHelp" onclick="loadHelpContent('#'+this.id,'current','login-logout','#helpContent')">
					<spring:message code="label.help.loginLogout"/></a></li>
					<li><a id ="dashboardHelp" onclick="loadHelpContent('#'+this.id,'current','dashboard','#helpContent')"> 
					<spring:message code="label.help.dashboard"/></a></li>
					<li><a id="terminalsHelp" onclick="loadHelpContent('#'+this.id,'current','terminals','#helpContent')"> 
					<spring:message code="label.help.terminals"/></a></li>
					<li><a  id="reportsHelp" onclick="loadHelpContent('#'+this.id,'current','reports','#helpContent')"> 	
					<spring:message code="label.help.reports"/></a></li>
					<li><a   id="scheduledHelp" onclick="loadHelpContent('#'+this.id,'current','scheduled_updates','#helpContent')"> 
					<spring:message code="label.help.scheduledUpdates"/></a></li>
	                <sec:authorize access="hasAnyRole(${usersAccessAllowedRoles})">
						<li><a id="userHelp" onclick="loadHelpContent('#'+this.id,'current','users','#helpContent')">
							<spring:message code="label.help.users"/></a></li>
	                </sec:authorize>
				</ul>
			</nav>
		<div class="scroll" id="helpContent">
		</div>
</div>