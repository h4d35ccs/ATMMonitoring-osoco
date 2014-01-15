<div id="terminalsMap"> </div>

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false"></script>
<script type="text/javascript" >

var map;

function initializeTerminalsMap() {
	var mapOptions = {
		zoom: 8,
		center: new google.maps.LatLng(-34.397, 150.644)
	};
	
	map = new google.maps.Map(document.getElementById('terminalsMap'), mapOptions);
}

$(function() {
	initializeTerminalsMap();
});
</script>
