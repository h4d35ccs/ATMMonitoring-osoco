<%@tag description="Historical timeline" pageEncoding="UTF-8"%>
<%@attribute name="historicalChanges" required="true" type="java.util.Map"%>
<%@attribute name="timelineDates" required="true" type="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h2><spring:message code="label.terminal.history"/></h2>

<c:forEach items="${historicalChanges}" var="changesByType">
    <c:set var="changeName" value="${changesByType.key.simpleName}"> </c:set>
    <img src="<c:url value="/resources/timeline/api/images/${changeName}.png" />" />
    <spring:message code="label.historical.${changeName}"/>
</c:forEach>	

<div class="history_legend">
	<div id="timeline" style="height:80px"> </div>
</div>
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

    window.onload = function() { executeOnTimelineLoaded(loadTimeline) };
    
    var tl;
    
    function loadTimeline() {
    	var eventSource = new Timeline.DefaultEventSource();

        var zones = [];
        var zones2 = [];
        
        var theme = Timeline.ClassicTheme.create();
        theme.event.bubble.width = 250;
        
        var bandInfos = [
            Timeline.createHotZoneBandInfo({
            	<c:if test="${!(date == null)}">  
	            	date : new Date(${date.time}) ,     
	        	</c:if>  
                width:          "66%", 
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
                width:          "34%", 
                intervalUnit:   Timeline.DateTime.YEAR, 
                zones:          zones2, 
                intervalPixels: 400,
                eventSource:    eventSource,
                overview:       true,
                zoomIndex:      1,
                zoomSteps:      new Array(
                    {pixelsPerInterval: 400,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 50,  unit: Timeline.DateTime.YEAR},
                    {pixelsPerInterval: 200,  unit: Timeline.DateTime.DECADE},
                    {pixelsPerInterval: 100,  unit: Timeline.DateTime.DECADE}
                 )
               // theme:          theme
            })
        ];
        bandInfos[1].syncWith = 0;
        bandInfos[1].highlight = true;
        
        
        tl = Timeline.create(document.getElementById("timeline"), bandInfos, Timeline.HORIZONTAL);
        eventSource.loadJSON(buildEventsJSONData(), '');
        
        Timeline.OriginalEventPainter.prototype._showBubble = function(x, y, evt) {
            document.location.assign(document.location.pathname + evt.getDescription());
  		}
  		
  		var resizeTimerID = null;
		function onResize() {
			if (resizeTimerID == null) {
				resizeTimerID = window.setTimeout(function() {
					resizeTimerID = null;
					tl.layout();
				}, 500);
			}
		}
		
		window.onresize = onResize;  
    }
    
    function buildEventsJSONData() {
    	var eventData = {
    	   events : [
    	       <c:forEach items="${historicalChanges}" var="changesByType">
    	           <c:forEach items="${changesByType.getValue()}" var="changeDates">
	               <c:set var="changeDate" value="${changeDates.getKey()}" />
	               <c:set var="numberOfChanges" value="${changeDates.getValue()}" />
			{
			 		 start : new Date(${changeDate.time}) ,
    	          	 description : "?dateTime=${changeDate.time}&preselectedTab=${changesByType.key.simpleName}",
    	          	 icon : '<c:url 
    	          	 	value="/resources/timeline/api/images/${changesByType.key.simpleName}${date.time == changeDate.time ? '_current' : ''}.png" 
    	          	 />'
    	      		},
    	      	    </c:forEach>
    	        </c:forEach>	
    	   ] 
        }
        return eventData;
    }
    
</script>