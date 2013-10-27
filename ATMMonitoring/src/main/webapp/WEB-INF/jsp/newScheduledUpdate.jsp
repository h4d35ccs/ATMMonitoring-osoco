<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8"%>

<t:osoco-wrapper titleCode="label.scheduledUpdatesManager" userMsg="${userMsg}" section="schedule">

<jsp:attribute name="header">
<script type="text/javascript">
	$(document).ready(function(){
        $("#periodicity").change(function(event) {
            var periodicity = $(this).val();
            $(".periodicity").hide();
            $("#" + periodicity).show();
        });
	});
</script>
</jsp:attribute>

<jsp:body>

<div id="header_g">
  <nav id="breadcrumb">
    <ul>
      <li><a href="#">inicio</a></li>
      <li><a href="terminals/schedules/list">Planificador</a></li>
      <li>Nueva planificación</li>
    </ul>
  </nav>
</div>

<h1><spring:message code="label.scheduledUpdatesManager"/></h1>

<c:if test="${duplicatedScheduledUpdate == true}">
    <div class="alert">
	    <p><spring:message code="label.scheduledUpdate.duplicatedScheduledUpdate"/></p>
    </div>
</c:if>

<form:form method="post" action="terminals/schedules/list" commandName="scheduledUpdate">

<label for="query">Elegir consulta:</label>
<select name="queryId" size="1">
  <option value="" >Seleccionar</option>
  <c:forEach items="${userQueries}" var="userQuery">
    <option value="${userQuery.id}">${userQuery.name}</option>
  </c:forEach>
</select>

<label for="name">Nombre de la planificación</label>
<input type="text" id="name"/>

<label for="description">Descripción</label>
<textarea id="description"></textarea>

<label for="periodicity">Se repite:</label>
<select id="periodicity">
  <option value=""></option>
  <option value="weekly">Cada semana</option>
  <option value="monthly">Cada mes</option>
</select>



<div id="weekly" class="periodicity hide">

<form:label path="weekDay">Elige días:</form:label>

<form:radiobutton id="monday" path="weekDay" value="2"/><label for="monday"><spring:message code="label.scheduledUpdate.weekDay.monday"/></label>
<form:radiobutton id="tuesday" path="weekDay" value="3"/><label for="tuesday"><spring:message code="label.scheduledUpdate.weekDay.tuesday"/></label>
<form:radiobutton id="wednesday" path="weekDay" value="4"/><label for="wednesday"><spring:message code="label.scheduledUpdate.weekDay.wednesday"/></label>
<form:radiobutton id="thursday" path="weekDay" value="5"/><label for="thursday"><spring:message code="label.scheduledUpdate.weekDay.thursday"/></label>
<form:radiobutton id="friday" path="weekDay" value="6"/><label for="friday"><spring:message code="label.scheduledUpdate.weekDay.friday"/></label>
<form:radiobutton id="saturday" path="weekDay" value="7"/><label for="saturday"><spring:message code="label.scheduledUpdate.weekDay.saturday"/></label>
<form:radiobutton id="sunday" path="weekDay" value="1"/><label for="sunday"><spring:message code="label.scheduledUpdate.weekDay.sunday"/></label>

</div>

<div id="monthly" class="periodicity hide">

<form:label path="monthDay">Día del mes:</form:label>

<form:select path="monthDay" id="month-selector">
  <form:option value=""/>
  <c:forEach begin="1" end="31" var="day">
    <form:option value="${day}"/>
  </c:forEach>
</form:select>

</div>

<form:label path="hour"><spring:message code="label.scheduledUpdate.time"/></form:label>

<form:select path="hour" class="number-selector">
  <c:forEach begin="0" end="23" var="hour">
    <form:option value="${hour}">${hour < 10 ? '0' : ''}${hour}</form:option>
  </c:forEach>
</form:select> :
<form:select path="minute" class="number-selector">
  <c:forEach begin="0" end="59" var="minute">
    <form:option value="${minute}">${minute < 10 ? '0' : ''}${minute}</form:option>
  </c:forEach>
</form:select>

<a href="terminals/schedules/list">Cancelar</a>

<input type="submit" id="form-submit" class="form-submit" value="<spring:message code="label.scheduledUpdate.addScheduledUpdate"/>"/>

</form:form>

</jsp:body>

</t:osoco-wrapper>
