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

<h1>Nueva Planificación</h1>
<div class="content">
<div class="form w33">
<c:if test="${error != null}">
    <div class="alert">
      <p><spring:message code="label.${error}"/></p>
    </div>
</c:if>

<form:form method="post" action="terminals/schedules/list" commandName="scheduledUpdate">

<div class="row"><label for="query"><strong>Elegir consulta:</strong></label>
<form:select name="query" size="1" path="query.id">
  <option value="" >Seleccionar</option>
  <c:forEach items="${userQueries}" var="userQuery">
    <form:option value="${userQuery.id}" label="${userQuery.name}"/>
  </c:forEach>
</form:select></div>

<div class="row">
  <label for="name"><strong>Nombre de la planificación</strong></label>
  <input type="text" id="name"/>
</div>

<div class="row">
  <label for="description"><strong>Descripción</strong></label>
  <textarea id="description"></textarea>
</div>

<div class="row">
  <label for="periodicity"><strong>Se repite:</strong></label>
  <select id="periodicity">
    <option value=""></option>
    <option value="weekly">Cada semana</option>
    <option value="monthly">Cada mes</option>
  </select>
</div>


<div id="weekly" class="periodicity hide row">

<form:label path="weekDay"><strong>Elige días:</strong></form:label>
<ul class="weekDay">
  <li><form:radiobutton id="monday" path="weekDay" value="2"/><label for="monday"><spring:message code="label.scheduledUpdate.weekDay.monday"/></label></li>
  <li><form:radiobutton id="tuesday" path="weekDay" value="3"/><label for="tuesday"><spring:message code="label.scheduledUpdate.weekDay.tuesday"/></label></li>
  <li><form:radiobutton id="wednesday" path="weekDay" value="4"/><label for="wednesday"><spring:message code="label.scheduledUpdate.weekDay.wednesday"/></label></li>
  <li><form:radiobutton id="thursday" path="weekDay" value="5"/><label for="thursday"><spring:message code="label.scheduledUpdate.weekDay.thursday"/></label></li>
  <li><form:radiobutton id="friday" path="weekDay" value="6"/><label for="friday"><spring:message code="label.scheduledUpdate.weekDay.friday"/></label></li>
  <li><form:radiobutton id="saturday" path="weekDay" value="7"/><label for="saturday"><spring:message code="label.scheduledUpdate.weekDay.saturday"/></label></li>
  <li><form:radiobutton id="sunday" path="weekDay" value="1"/><label for="sunday"><spring:message code="label.scheduledUpdate.weekDay.sunday"/></label></li>
</ul>
</div>

<div id="monthly" class="periodicity hide row">

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
<div class="botonera">
  <input type="submit" id="form-submit" class="form-submit" value="<spring:message code="label.scheduledUpdate.addScheduledUpdate"/>"/>
  <a href="terminals/schedules/list" class="btn cancel">Cancelar</a>
</div>
</div>
</form:form></div>

</jsp:body>

</t:osoco-wrapper>
