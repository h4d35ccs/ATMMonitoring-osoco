<%@include file="includes/JspImports.jsp"%>
<div id="scheduledContent">
<div id="header_g">
  <%-- <nav id="breadcrumb">
    <ul>
      <li><a href="dashboard"><spring:message code="breadcrumb.home"/></a></li>
      <li><spring:message code="label.scheduler"/></li>
    </ul>
  </nav> --%>
  	<c:set var="navigationBackMain" scope="request" >home</c:set>
			<c:set var="navigationActual" value="label.scheduler" scope="request" />
			<jsp:include page="includes/navigation.jsp" />
  <div class="botonera">
    <ul>
      <li><button onclick="loadInnerSection('#primary','terminals/schedules/new')" class="btn add"><spring:message code="label.schedule.new"/></button></li>
    </ul>
  </div>
</div>
<div id="dialog-confirm" title=''>
<h1><spring:message code="label.scheduledUpdatesManager"/></h1>
 <div id="confirmContainer">
  <c:if test="${success != null}">
  <div class="notification" id="notification">
    <p><spring:message code="${success}" /></p>
  </div>
  <script type="text/javascript">
  	fadeNotification("#notification","notification");
  </script>
  </c:if>
  </div>
<div id="header_g">
	<div id="toggleSchedulerView" class="columns_botonera">
	  <nav>
	    <ul>
	        <li class="calendario current">
	          <a href="#"><span><spring:message code="label.calendar"/></span></a>
	        </li>
	        <li class="lista">
	          <a href="#"><span><spring:message code="label.list"/></span></a>
	        </li>
	    </ul>
	  </nav>
	</div>
</div>
<div id="schedulerList" class="scheduler hide">
<div class="box">
<h2><spring:message code="label.weeklyScheduledUpdates"/></h2>
<div class="margin-box">
<c:if  test="${empty weeklyScheduledUpdates}">
<div class="message"><spring:message code="label.scheduledUpdates.noWeeklyScheduledUpdates"/></div>
</c:if>
<c:if  test="${!empty weeklyScheduledUpdates}">
<c:choose>
<c:when  test="${weeklyScheduledUpdates.size() > 10}">
<div id="tableContainer" class="tableContainer">
<table class="data">
<thead class="fixedHeader">
</c:when>
<c:otherwise>
<table class="data">
</c:otherwise>
</c:choose>
<tr>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.weekDay"/></i></th>
    <th width="50px"><i><spring:message code="label.scheduledUpdate.time"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.query"/></i></th>
	<c:choose>
	<c:when  test="${weeklyScheduledUpdates.size() > 10}">
	<th width="106px">
	</c:when>
	<c:otherwise>
	<th width="90px">
	</c:otherwise>
	</c:choose>
	&nbsp;</th>
</tr>
<c:if  test="${weeklyScheduledUpdates.size() > 10}">
</thead>
<tbody class="scrollContent">
</c:if>
<c:forEach items="${weeklyScheduledUpdates}" var="scheduledUpdate">
    <tr>
        <td width="100px" class="center-cell">
        <c:choose>
	        <c:when test="${scheduledUpdate.weekDay == 1}">
	        <spring:message code="label.scheduledUpdate.weekDay.sunday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 2}">
	        <spring:message code="label.scheduledUpdate.weekDay.monday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 3}">
	        <spring:message code="label.scheduledUpdate.weekDay.tuesday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 4}">
	        <spring:message code="label.scheduledUpdate.weekDay.wednesday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 5}">
	        <spring:message code="label.scheduledUpdate.weekDay.thursday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 6}">
	        <spring:message code="label.scheduledUpdate.weekDay.friday"/>
	        </c:when>
	        <c:when test="${scheduledUpdate.weekDay == 7}">
	        <spring:message code="label.scheduledUpdate.weekDay.saturday"/>
	        </c:when>
        </c:choose>
        </td>
        <td width="50px" class="center-cell">${scheduledUpdate.completeHour}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.query.name}</td>
		<td width="90px" class="center-cell">
			<button onClick="deleteConfirmation('terminals/schedules/delete/${scheduledUpdate.id}',schUpDeleteConfirmation,'#primary','#notification','notification')" class="form-submit delete right"><spring:message code="label.scheduledUpdate.deleteScheduledUpdate"/></button>
		</td>
    </tr>
</c:forEach>
<c:choose>
<c:when  test="${weeklyScheduledUpdates.size() > 10}">
</tbody>
</table>
</div>
</c:when>
<c:otherwise>
</table>
</c:otherwise>
</c:choose>
</c:if>
</div>
</div>
<div class="box">
<h2><spring:message code="label.monthlyScheduledUpdates"/></h2>
<div class="margin-box">
<c:if  test="${empty monthlyScheduledUpdates}">
<div class="message"><spring:message code="label.scheduledUpdates.noMonthlyScheduledUpdates"/></div>
</c:if>
<c:if  test="${!empty monthlyScheduledUpdates}">
<c:choose>
<c:when  test="${monthlyScheduledUpdates.size() > 10}">
<div id="tableContainer" class="tableContainer">
<table class="data">
<thead class="fixedHeader">
</c:when>
<c:otherwise>
<table class="data">
</c:otherwise>
</c:choose>
<tr>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.monthDay"/></i></th>
    <th width="50px"><i><spring:message code="label.scheduledUpdate.time"/></i></th>
    <th width="100px"><i><spring:message code="label.scheduledUpdate.query"/></i></th>
	<c:choose>
	<c:when  test="${monthlyScheduledUpdates.size() > 10}">
	<th width="106px">
	</c:when>
	<c:otherwise>
	<th width="90px">
	</c:otherwise>
	</c:choose>
	&nbsp;</th>
</tr>
<c:if  test="${monthlyScheduledUpdates.size() > 10}">
</thead>
<tbody class="scrollContent">
</c:if>
<c:forEach items="${monthlyScheduledUpdates}" var="scheduledUpdate">
    <tr>
        <td width="100px" class="center-cell">${scheduledUpdate.monthDay}</td>
        <td width="50px" class="center-cell">${scheduledUpdate.completeHour}</td>
        <td width="100px" class="center-cell">${scheduledUpdate.query.name}</td>
		<td width="90px" class="center-cell">
			<button onClick="deleteConfirmation('terminals/schedules/delete/${scheduledUpdate.id}',schUpDeleteConfirmation,'#primary','#notification','notification')" class="form-submit delete right"><spring:message code="label.scheduledUpdate.deleteScheduledUpdate"/></button>
		</td>
    </tr>
</c:forEach>
<c:choose>
<c:when  test="${monthlyScheduledUpdates.size() > 10}">
</tbody>
</table>
</div>
</c:when>
<c:otherwise>
</table>
</c:otherwise>
</c:choose>
</c:if>
</div>
</div>
</div>
<div id="schedulerCalendar" class="scheduler"></div>
</div>
<script type="text/javascript">
function initPageJS() {
	initScheduler();
}	
</script>
</div>
