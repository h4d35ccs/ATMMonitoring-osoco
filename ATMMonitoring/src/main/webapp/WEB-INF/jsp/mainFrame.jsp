<%@include file="includes/JspImports.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="includes/HtmlHead.jsp" %>
<c:if test="${exception == null}">
	<c:if test="${empty error}">
		<script type="text/javascript">
			var mainContent ="#dashboardMenu";
				$( document ).ready(function() {
					 $(mainContent).click();
					 loggedTimeUser(${loginTime});
				}); 
		</script> 
	</c:if>
	<c:if test="${!empty error}">
			<script type="text/javascript">
			<%-- an 404 or 403 has occur so i load the content--%>
				$( document ).ready(function() {
					loadInnerSection("#primary","show${error}");
					loggedTimeUser(${loginTime});
				});
			</script>
	</c:if>
	</c:if>
</head>
<body>
<div class="loader"></div>
      <div id="mainContent"> 
        <div id="main_header">
        	<input type="hidden" id="lastVisit">
            <div id="rButton" class="hide btn_close">
            </div>
            <h1>
	                <a onclick="$('#dashboardMenu').click();"><img src="resources/images/general/logo.png"/></a>
	                <div id="headName"><span><acronym title="Hardware and Software Asset Management">HSAM</acronym></span></div>
            </h1>
            <div id="user_info">
               <div class="welcome" style="cursor: default;"><spring:message code="label.welcomeMessage"/> ${userMsg}</div>-
               <div class="date" id="welcomeDate" title="logged time h:m:s" style="cursor: default;"></div>
                <div id="lang" class="desplegable autofold">
                    <div class="txt content_hide">
                        <span><spring:message code="language.${pageContext.response.locale}"/></span>
                    </div>
                    <ul class="collapsible">
                        <li><a href="${currentUrl}?lang=es"><spring:message code="language.es"/></a></li>
                        <li><a href="${currentUrl}?lang=en"><spring:message code="language.en"/></a></li>
                    </ul>
                </div>
                <sec:authorize access="isAuthenticated()">
                    <div id="exit">
                        <a href="logout"><span><spring:message code="label.menu.logout"/></span></a>
                    </div>
                </sec:authorize>
            </div>
        </div> 
        <div id="main_menu">
	        <nav id="main_nav" class="btn_close">
	            <ul id="nav_icons" class="clickeableMenu">
	                <sec:authorize access="hasAnyRole(${dashboardAccessAllowedRoles})">
		                <li class="dashboard">
		                    <a id="dashboardMenu" onclick="loadInnerSectionMenu('#'+this.id, '#primary', 'dashboard')"><span id="dashboard"><spring:message code="label.menu.dashboard"/></span></a>
		                </li>
	                </sec:authorize>
	                <sec:authorize access="hasAnyRole(${terminalsAccessAllowedRoles})">
		                <li class="terminals">
		                    <a id="terminalMenu" onclick="loadInnerSectionMenu('#'+this.id, '#primary', 'terminals')"><span><spring:message code="label.menu.terminals"/></span></a>
		                </li>
	                </sec:authorize>
	                <sec:authorize access="hasAnyRole(${reportsAccessAllowedRoles})">
		                <li class="reports">
		                    <a id="externalReportsMenu" onClick="loadInnerSectionMenu('#'+this.id, '#primary', 'externalreports')"><span><spring:message code="label.menu.externalreports"/></span></a>
		                </li>
	                </sec:authorize>
	                <sec:authorize access="hasAnyRole(${schedulesAccessAllowedRoles})">
	                <li class="schedule">
	                    <a id="scheduleMenu" onClick="loadInnerSectionMenu('#'+this.id, '#primary', 'terminals/schedules/list')"><span><spring:message code="label.menu.scheduler"/></span></a>
	                </li>
	                </sec:authorize>
	                <sec:authorize access="hasAnyRole(${usersAccessAllowedRoles})">
		                <li class="users">
		                    <a id ="userMenu" onClick="loadInnerSectionMenu('#'+this.id, '#primary', 'users')"><span><spring:message code="label.menu.users"/></span></a>
		                </li>
		                <script>mainContent ="#userMenu";</script>
	                </sec:authorize>
	                <sec:authorize access="hasAnyRole(${helpAccessAllowedRoles})">
		                <li class="help">
		                    <a id ="helpMenu" onClick="loadInnerSectionMenu('#'+this.id, '#primary', 'help')"><span><spring:message code="label.menu.help"/></span></a>
		                </li>
	                </sec:authorize>
	            </ul>
	        </nav>
		</div>
        <div id="main" class="btn_close">
            <c:if test="${exception == null}">  
            <div id="primary"></div>
            <!-- /primary -->
            </c:if>
            <c:if test="${exception != null}">
            	<div id="primary">
            	   <%@include file="error.jsp" %>
           	 </div>
            </c:if>
            <div> 
    
            </div>
        </div>
        <!-- /#main -->
        </div>
    </body>
</html>