<%@tag description="New widget form content" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row">
	<label for="name"><spring:message code="widget.name.label" /></label>
	<input type="text" id="name" name="name">
</div>
<h2><spring:message code="widget.chartType.label" /></h2>
<div id="inputGraph" class="graph_component">
	<c:set var="index" value="0" />
	<c:forEach var="chartType" items="${chartTypes}">
		<label class="graph graph_0${index + 1}">
			<span><spring:message code="ChartType.${chartType.name()}" /></span>
			<input type="radio" name="graph" class="inputGraph" value="${chartType.name()}" name="chartType"/> 
		</label>
		<c:set var="index" value="${index + 1}" />
	</c:forEach>
</div>

<div class="row">
	<label for="apquery"><spring:message code="widget.query.label" /></label>
	<select name="query" size="1">
		<option value="" ><spring:message code="label.select.default"/></option>
		<c:forEach items="${userQueries}" var="userQuery">
			<option value="${userQuery.id}">
				${userQuery.name}
			</option>
		</c:forEach>
	</select>	
</div>
<div class="row">
	<label><spring:message code="widget.join.label" /> </label>
	
	<select id="groupByEntity" name="groupByEntity" > 
		<option><spring:message code="label.select.default"/></option>
		<c:forEach items="${queryTypes}" var="queryType">
			<option value="${queryType.name()}">
				<spring:message code="WidgetQueryAssociationType.${queryType}" />
			</option>
		</c:forEach>
	</select>
</div>
	
<c:forEach items="${queryTypes}" var="queryType">
	<div id="${queryType.name()}" class="row hide queryTypeValueRows">
		<label></label>
		<select id="groupBy" name="groupBy" disabled="disabled">
			<option><spring:message code="label.select.default"/></option>
			<c:forEach items="${queryType.comboboxes}" var="groupByField">
				<option value="${groupByField.key}">
					${groupByField.key}
				</option>
			</c:forEach>
		</select>
	</div>
</c:forEach>
		


<div class="botonera">
	<input type="button" class="btn next" value="<spring:message code="widget.create.button.label"/>">
</div>

<script type="text/javascript">
$(function() {
	
	var queryTypeValueRows = $("div.queryTypeValueRows");
	var queryTypeValuesByRow = $("div.queryTypeValueRows select#groupBy");
	
	$('select#groupByEntity').change(function(event) {
		var queryTypeSelect = $(this);
		var queryType = queryTypeSelect.val();
		
		queryTypeValueRows.addClass("hide");
		queryTypeValuesByRow.attr("disabled");
		
		$('div#' + queryType).removeClass("hide");
		$('div#' + queryType + ' select#groupBy' ).removeAttr("disabled");	
	})
});

</script>