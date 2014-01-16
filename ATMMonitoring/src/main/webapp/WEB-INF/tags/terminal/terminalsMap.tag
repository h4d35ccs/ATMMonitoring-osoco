<%@tag description="Terminals location map" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:choose>
	<c:when test="${empty terminalLocations }">
		<div class="message">
			<p> <spring:message code="label.terminal.noTerminalsLocations"/> </p>
		</div>
	</c:when>
	<c:otherwise>
	
		<div id="terminalsMap"> </div>
		<div class="hide">
			<div id="defaultInfoWindowContent"> <spring:message code="label.terminal.map.summary.wait"/> </div>
		</div>
		
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		<script src="resources/js/markerClusterer.js"></script>
		<script type="text/javascript" >
		
		$(function() {
			terminalMap = new TerminalsMap();
			terminalMap.initialize();
		});
		
		function TerminalsMap() {
			var terminalSummaryUrl = 'terminals/summary/'
			var map;
			var bounds;
			var isMapPainted;
			
			this.paintIfNecessary = function() {
				if(!isMapPainted) {
					isMapPainted = true;
					google.maps.event.trigger(map, 'resize');
					fitMapToBounds();
				}
			}
			
			this.initialize = function() {
				var mapOptions = {
					zoom: 8,
					mapTypeId: google.maps.MapTypeId.ROADMAP
				};
			
				map = new google.maps.Map(document.getElementById('terminalsMap'), mapOptions);
				initMarkers();
			}
			
			function initMarkers() {
				bounds = new google.maps.LatLngBounds(); 
				
				var terminalLocations = retrieveTerminalLocationsInfo();
				
				var locationIndex, locationInfo, googleLocation, markerOptions;
				var markers = []
				for (locationIndex = 0; locationIndex < terminalLocations.length; locationIndex++) {
			    	locationInfo = terminalLocations[locationIndex];
			    	googleLocation = new google.maps.LatLng(locationInfo.lat, locationInfo.long); 
			    	bounds.extend(googleLocation);
				
					markerOptions = { 
				      icon: 'resources/images/maps/simpleMarker.png',
				      title: '<spring:message code="label.terminals" />' 
				    }
				    
				    markers.push(createMarker(map, googleLocation, markerOptions, locationInfo.id));
				    
				}
				fitMapToBounds();
				initMarkerClusterer(markers); 
			}
			
			function fitMapToBounds() {
				map.fitBounds(bounds);
			}
			
			function initMarkerClusterer(markers) {
				var markerClusterOptions = {
					styles : [
						{ url : 'resources/images/maps/clusteredMarker.png' , height:45 , width: 45}
					]
				}
					
				var markerCluster = new MarkerClusterer(map, markers, markerClusterOptions);
			}
			
			function createMarker(map, location, options, terminalId) {
			    var marker = new google.maps.Marker( {
			    	position: location,
			    	options:options
			    });
			     
			    var infoWindow = new google.maps.InfoWindow({
      			 	content: document.getElementById('defaultInfoWindowContent')
  				});

				google.maps.event.addListener(marker, 'click', function() {
					infoWindow.open(map,marker);
					loadTerminalSummary(infoWindow, terminalId);
				});
				
			    return marker
			}
			
			function loadTerminalSummary(infoWindow, terminalId) {
				$.ajax( terminalSummaryUrl + terminalId + '?dateTime=${queryDate.time}')
					.done(function(html) {
						infoWindow.setContent(html);
					})
					.fail(function() {
						infoWindow.setContent('<spring:message code="label.terminal.map.summary.error"/>');
					})
			}
			
			function retrieveTerminalLocationsInfo() {
			    return [
					<c:forEach items="${terminalLocations}" var="terminalLocation">
						{ 'lat' : ${terminalLocation.get("lat")} , 'long': ${terminalLocation.get("long")} , 'id': '${terminalLocation.get("id")}'} ,	
					</c:forEach>
			    ]
			}
		}
		
		</script>
	</c:otherwise>
</c:choose>
