<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="terminalsMap"> </div>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script src="resources/js/markerClusterer.js"></script>
<script type="text/javascript" >

$(function() {
	initializeTerminalsMap();
	initialiceMarkers();
});

var map;

function initializeTerminalsMap() {
	var mapOptions = {
		zoom: 8,
		mapTypeId: google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById('terminalsMap'), mapOptions);
}

function initialiceMarkers() {
	var bounds = new google.maps.LatLngBounds();
	
	var terminalLocations = retrieveTerminalLocationsInfo();
	
	var locationIndex, locationInfo, googleLocation, markerOptions;
	var markers = []
	for (locationIndex = 0; locationIndex < terminalLocations.length; locationIndex++) {
    	locationInfo = terminalLocations[locationIndex];
    	googleLocation = new google.maps.LatLng(locationInfo.lat, locationInfo.long); 
    	bounds.extend(googleLocation);
	
		markerOptions = { 
	      //icon: '',
	      title: locationInfo.id 
	    }
	    
	    markers.push(createMarker(map, googleLocation, markerOptions));
	    
	}
	var markerCluster = new MarkerClusterer(map, markers);
	map.fitBounds(bounds);
}

function createMarker(map, location, options) {
     var marker = new google.maps.Marker();
     marker.setPosition(location);
     marker.setOptions(options);
     //marker.setMap(map);
     return marker
}

function retrieveTerminalLocationsInfo() {
    return [
		<c:forEach items="${terminals}" var="terminal">
			<c:set var="installation" value="${terminal.getCurrentInstallationByDate(queryDate)}"/>
			<c:if test="${!empty installation && !empty installation.location}">
				{ 'lat' : ${installation.location.coordY} , 'long': ${installation.location.coordX} , 'id': '${terminal.id}'} ,	
			</c:if>
		</c:forEach>
    ]
}

</script>
