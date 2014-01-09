<%@tag description="Historical timeline" pageEncoding="UTF-8"%>
<%@attribute name="historicalChanges" required="true" type="java.util.Map"%>
<%@attribute name="timelineDates" required="true" type="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h2><spring:message code="label.terminal.history"/></h2>
<div id="timeline" style="height:150px"> </div>
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
    var tl;
    function loadTimeline() {
        var eventSource = new Timeline.DefaultEventSource();
       
       // var minDate = new Date(${timelineDates.min.time})
       // var maxDate = new Date(${timelineDates.max.time})
       
        var zones = [
            
        ];
        var zones2 = [
            
        ];
        
        var theme = Timeline.ClassicTheme.create();
        theme.event.bubble.width = 250;
        
        var date = "12 1 2013 00:00:00 GMT-0600"
        var bandInfos = [
            Timeline.createHotZoneBandInfo({
                width:          "80%", 
                intervalUnit:   Timeline.DateTime.WEEK, 
                intervalPixels: 200,
                zones:          zones,
                eventSource:    eventSource,
                date:           date,
                timeZone:       -6,
         /*         zoomIndex:      10,
            zoomSteps:      new Array(
              {pixelsPerInterval: 280,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 140,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval:  70,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval:  35,  unit: Timeline.DateTime.HOUR},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 200,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 100,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval:  50,  unit: Timeline.DateTime.DAY},
              {pixelsPerInterval: 400,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 200,  unit: Timeline.DateTime.MONTH},
              {pixelsPerInterval: 100,  unit: Timeline.DateTime.MONTH} // DEFAULT zoomIndex
            )*/
                
              //  theme:          theme
            }),
            Timeline.createHotZoneBandInfo({
                width:          "20%", 
                intervalUnit:   Timeline.DateTime.YEAR, 
                intervalPixels: 500,
                zones:          zones2, 
                eventSource:    eventSource,
                date:           date, 
                overview:       true
               // theme:          theme
            })
        ];
        bandInfos[1].syncWith = 0;
        bandInfos[1].highlight = true;
        
        
        tl = Timeline.create(document.getElementById("timeline"), bandInfos, Timeline.HORIZONTAL);
        eventSource.loadJSON(buildEventsJSONData(), '');
        
        Timeline.OriginalEventPainter.prototype._showBubble = function(x, y, evt) {
   	    document.location.href=evt.getLink();
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
    	         	 start : "<fmt:formatDate value="${changeDate}" pattern="MM dd yyyy HH:mm:ss "/>",
    	          	 link : "${terminal.id}?date=<fmt:formatDate value="${changeDate}" pattern="dd/MM/yyyy" />",
    	          	 icon : '<c:url value="/resources/timeline/api/images/${changesByType.key.simpleName}.png" />'
    	      		},
    	      	    </c:forEach>
    	        </c:forEach>	
    	   ] 
        }
        return eventData;
    }
    
    window.onload = function() {
    	tryLoadTimeline()
    } 
    
    function tryLoadTimeline() {
    	try {
    	    loadTimeline()
    	} catch(e) {
    	    setTimeout(tryLoadTimeline,500);	
    	}
    }
    
</script>