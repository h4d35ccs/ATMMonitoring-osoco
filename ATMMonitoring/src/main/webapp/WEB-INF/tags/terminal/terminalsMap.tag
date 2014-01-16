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
		
		<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
		<script src="resources/js/markerClusterer.js"></script>
		<script type="text/javascript" >
		
		$(function() {
			terminalMap = new TerminalsMap();
			terminalMap.initialize();
		});
		
		function TerminalsMap() {
			
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
				      title: locationInfo.id 
				    }
				    
				    markers.push(createMarker(map, googleLocation, markerOptions));
				    
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
			
			function createMarker(map, location, options) {
			     var marker = new google.maps.Marker();
			     marker.setPosition(location);
			     marker.setOptions(options);
			     
			     //No added to map because markerClusterer added it later
			     //marker.setMap(map);
			     
			     return marker
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
