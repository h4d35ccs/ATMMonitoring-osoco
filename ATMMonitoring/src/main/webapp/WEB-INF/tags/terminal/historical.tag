<%@tag description="Historical timeline" pageEncoding="UTF-8"%>
<%@attribute name="historicalChanges" required="true" type="java.util.Map"%>
<%@attribute name="timelineDates" required="true" type="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="timelineDatesPattern" value="MM dd yyyy HH:mm:ss"/>

<h2><spring:message code="label.terminal.history"/></h2>
<c:forEach items="${historicalChanges}" var="changesByType">
    <c:set var="changeName" value="${changesByType.key.simpleName}"> </c:set>
    <img src="<c:url value="/resources/timeline/api/images/${changeName}.png" />" />
    <spring:message code="label.historical.${changeName}"/>
</c:forEach>	

<div id="timeline" style="height:200px"> </div>
<!-- <div class="action_box data desplegable"> -->
<%--     <h2 class="txt content_hide last"><spring:message code="label.terminal.history"/></h2> --%>
<!--     <div id="timeline" class="collapsible last hide"> -->
<%--     <c:forEach items="${historicalChanges}" var="changesByType"> --%>
<%--     <p><spring:message code="label.historical.${changesByType.getKey().getSimpleName()}"/></p> --%>
<!--         <ul> -->
<%-- 	    <c:forEach items="${changesByType.getValue()}" var="changeDates"> --%>
<%-- 	        <c:set var="changeDate" value="${changeDates.getKey()}" /> --%>
<%-- 	        <c:set var="numberOfChanges" value="${changeDates.getValue()}" /> --%>
<!-- 		<li> -->
<%-- 	<a href="terminals/details/${terminal.id}?date=<fmt:formatDate value="${changeDate}" pattern="dd/MM/yyyy" />"> --%>
<%-- 	El día <fmt:formatDate value="${changeDate}" pattern="dd/MM/yyyy" /> hubo ${numberOfChanges} cambios  ${changeDate } --%>
<!-- 	</a> -->
<!-- 	</li> -->
<%-- 	</c:forEach>	 --%>
<!-- 	</ul> -->
<%--     </c:forEach> --%>
<!--     </div> -->
<!-- </div> -->


<script>
    var Timeline_urlPrefix = 'resources/timeline/api/';
    var Timeline_ajax_url= 'resources/timeline/ajax/simile-ajax-api.js';       
</script>
<script src="resources/timeline/api/timeline-api.js" type="text/javascript"></script>
<script>
    window.onload = function() { loadTimeline() };
    
    var tl;
    
    function loadTimeline() {
    
    	if(SimileAjax.loadedScriptsCount != 22) {
    	    setTimeout(loadTimeline, 50);
    	    return;
    	}
    	 
    	var eventSource = new Timeline.DefaultEventSource();

        var zones = [];
        var zones2 = [];
        
        var theme = Timeline.ClassicTheme.create();
        theme.event.bubble.width = 250;
        
        var bandInfos = [
            Timeline.createHotZoneBandInfo({
            	<c:if test="${!(date == null)}">  
	            date : "<fmt:formatDate value="${date}" pattern="${timelineDatesPattern}"/>" ,     
	        </c:if>  
                width:          "80%", 
                intervalUnit:   Timeline.DateTime.MONTH, 
                intervalPixels: 200,
                zones:          zones,
                eventSource:    eventSource,
                timeZone:       -6,
                zoomIndex:      16,
            zoomSteps:      new Array(
              {pixelsPerInterval: 3000,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2500,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2000,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 1600,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 2500,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 2000,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1700,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1500,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 1500,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 1200,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 800,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.WEEK},
              {pixelsPerInterval: 500,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 300,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 200,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.YEAR}
            )
                
              //  theme:          theme
            }),
            Timeline.createHotZoneBandInfo({
                width:          "20%", 
                intervalUnit:   Timeline.DateTime.YEAR, 
                zones:          zones2, 
                intervalPixels: 400,
                eventSource:    eventSource,
                overview:       true,
                zoomIndex:      6,
                zoomSteps:      new Array(
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.DECADE},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.DECADE},
                    {pixelsPerInterval: 50,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 400,  unit: Timeline.DateTime.YEAR}
                 )
               // theme:          theme
            })
        ];
        bandInfos[1].syncWith = 0;
        bandInfos[1].highlight = true;
        
        
        tl = Timeline.create(document.getElementById("timeline"), bandInfos, Timeline.HORIZONTAL);
        eventSource.loadJSON(buildEventsJSONData(), '');
        
        Timeline.OriginalEventPainter.prototype._showBubble = function(x, y, evt) {
            document.location.pathname = document.location.pathname + evt.getDescription();
  	} 
    }
    
    function buildEventsJSONData() {
    	var eventData = {
    	   events : [
    	       <c:forEach items="${historicalChanges}" var="changesByType">
    	           <c:forEach items="${changesByType.getValue()}" var="changeDates">
	               <c:set var="changeDate" value="${changeDates.getKey()}" />
	               <c:set var="numberOfChanges" value="${changeDates.getValue()}" />
			{
			 start : "<fmt:formatDate value="${changeDate}" pattern="${timelineDatesPattern}"/>",
    	          	 description : "?dateTime=${changeDate.time}",
    	          	 icon : '<c:url 
    	          	 	value="/resources/timeline/api/images/${date.time == changeDate.time ? 'Current' : changesByType.key.simpleName}.png" 
    	          	 />'
    	      		},
    	      	    </c:forEach>
    	        </c:forEach>	
    	   ] 
        }
        return eventData;
    }
    
</script>