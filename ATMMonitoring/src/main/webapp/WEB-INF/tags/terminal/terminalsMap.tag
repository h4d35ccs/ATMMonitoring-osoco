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
	
	var terminalLocations = buildTerminalLocationsInfo();
	
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

function buildTerminalLocationsInfo() {
    return [
        {"lat":41.3793987,"long":2.18921639999996,"id":null},
        {"lat":41.4021204,"long":2.20455259999994,"id":null},
        {"lat":41.385341350272114,"long":2.1932616470825224,"id":null},
        {"lat":41.4069027,"long":2.133646,"id":null},
        {"lat":41.3983016,"long":2.12504739999997,"id":null},
        {"lat":41.3719071,"long":2.15663519999998,"id":null},
        {"lat":41.4263594,"long":2.18427710000003,"id":null},
        {"lat":41.4038224,"long":2.182773,"id":null},
        {"lat":41.4012926468757,"long":2.133681285180728,"id":null},
        {"lat":41.3899414528121,"long":2.12868116693426,"id":null},
        {"lat":41.4418491,"long":2.17757559999995,"id":null},
        {"lat":41.385592342744204,"long":2.17697127591862,"id":null},
        {"lat":41.3988039,"long":2.1536773000000298,"id":null},
        {"lat":41.4043369,"long":2.2148629000000697,"id":null},
        {"lat":41.3827792,"long":2.19427759999996,"id":null},
        {"lat":41.4277667,"long":2.17723590000003,"id":null},
        {"lat":41.3792325,"long":2.16950380000003,"id":null},
        {"lat":41.4057342,"long":2.16264990000002,"id":null},
        {"lat":41.3815621,"long":2.1702030999999806,"id":null},
        {"lat":41.3881922,"long":2.1973375999999702,"id":null},
        {"lat":41.3910528,"long":2.14771659999997,"id":null},
        {"lat":41.4165142,"long":2.18040300000007,"id":null},
        {"lat":41.4084455,"long":2.16929019999998,"id":null},
        {"lat":41.3870257,"long":2.19700119999993,"id":null},
        {"lat":41.4054005,"long":2.14255079999998,"id":null},
        {"lat":41.3809954227736,"long":2.1819662534424,"id":null},
        {"lat":41.4042817,"long":2.18983900000001,"id":null},
        {"lat":41.3753928157338,"long":2.1696774539673243,"id":null},
        {"lat":41.37443,"long":2.15968910000004,"id":null},
        {"lat":41.4001425,"long":2.18456779999997,"id":null},
        {"lat":41.4016011,"long":2.15703729999996,"id":null},
        {"lat":41.381883,"long":2.16862730000003,"id":null},
        {"lat":41.412607685177704,"long":2.22170491179202,"id":null},
        {"lat":41.3997157,"long":2.1233202999999303,"id":null},
        {"lat":41.4043012,"long":2.1973259999999755,"id":null},
        {"lat":41.3719504,"long":2.15120079999997,"id":null},
        {"lat":41.4048893,"long":2.1773034000000298,"id":null},
        {"lat":41.4303715,"long":2.1879601000000597,"id":null},
        {"lat":41.4248336,"long":2.14266559999999,"id":null},
        {"lat":41.4015876,"long":2.16059150000001,"id":null},
        {"lat":41.384185,"long":2.122297,"id":null},
        {"lat":41.3856591,"long":2.14290870000002,"id":null},
        {"lat":41.3840886,"long":2.14273070000002,"id":null},
        {"lat":41.3903949,"long":2.14329599999996,"id":null},
        {"lat":41.4073627,"long":2.15133779999996,"id":null},
        {"lat":41.3797545,"long":2.16151820000005,"id":null},
        {"lat":41.3830352,"long":2.15049799999997,"id":null},
        {"lat":41.3746425,"long":2.14212309999993,"id":null},
        {"lat":41.388676649314306,"long":2.19260262009902,"id":null},
        {"lat":41.3868558,"long":2.1578256000000198,"id":null},
        {"lat":41.4035557,"long":2.12816090000001,"id":null},
        {"lat":41.3959951,"long":2.1670967999999675,"id":null},
        {"lat":41.3827094,"long":2.1431569999999702,"id":null},
        {"lat":41.3766531,"long":2.16377490000002,"id":null},
        {"lat":41.3963176,"long":2.16796490000002,"id":null},
        {"lat":41.3887704,"long":2.1308765,"id":null},
        {"lat":41.4182458,"long":2.18765710000002,"id":null},
        {"lat":41.4128731,"long":2.14159399999994,"id":null},
        {"lat":41.3976549,"long":2.13008639999998,"id":null},
        {"lat":41.3942253,"long":2.17483919999995,"id":null},
        {"lat":41.4027066,"long":2.13939010000001,"id":null},
        {"lat":41.4072969,"long":2.1806828,"id":null},
        {"lat":41.3943819,"long":2.11311539999997,"id":null},
        {"lat":41.3783128,"long":2.15462130000003,"id":null},
        {"lat":41.407891,"long":2.13645480000002,"id":null},
        {"lat":41.3952769,"long":2.14643169999999,"id":null},
        {"lat":41.3851406,"long":2.13807480000003,"id":null},
        {"lat":41.3844497,"long":2.1341797,"id":null},
        {"lat":41.40472,"long":2.13848440000004,"id":null},
        {"lat":41.3780697,"long":2.1457080999999802,"id":null},
        {"lat":41.4020125,"long":2.15890560000003,"id":null},
        {"lat":41.3895629,"long":2.14870799999994,"id":null},
        {"lat":41.386109,"long":2.15350890000002,"id":null},
        {"lat":41.4003718,"long":2.17334849999997,"id":null},
        {"lat":41.3923854,"long":2.16272609999999,"id":null},
        {"lat":41.4057101,"long":2.18043929999999,"id":null},
        {"lat":41.3580242,"long":2.14028959999996,"id":null},
        {"lat":41.358524261723204,"long":2.143289505557277,"id":null},
        {"lat":41.4214546,"long":2.18647199999998,"id":null},
        {"lat":41.3726087,"long":2.12815430000001,"id":null},
        {"lat":41.386669788935215,"long":2.1267867073211164,"id":null},
        {"lat":41.38529558259189,"long":2.176671852253776,"id":null},
        {"lat":41.41187192773334,"long":2.132817490490652,"id":null},
        {"lat":41.39253340675258,"long":2.1699850074401184,"id":null},
        {"lat":41.39688835752183,"long":2.1593594991279588,"id":null},
        {"lat":41.391155593226074,"long":2.1660503608216004,"id":null},
        {"lat":41.39262629895504,"long":2.1645593954925744,"id":null},
        {"lat":41.39105008153924,"long":2.123578232540922,"id":null},
        {"lat":41.38929596979449,"long":2.153952997375427,"id":null},
        {"lat":41.414383708719306,"long":2.172495730024707,"id":null},
        {"lat":41.3883676,"long":2.1286426000000347,"id":null},
        {"lat":41.39114390723766,"long":2.180002639147915,"id":null},
        {"lat":41.38908153171162,"long":2.133154774313425,"id":null},
        {"lat":41.39361928020896,"long":2.143211536592844,"id":null},
        {"lat":41.3955819,"long":2.1635306000000583,"id":null},
        {"lat":41.38590855472945,"long":2.1702932162246498,"id":null},
        {"lat":41.389624853120495,"long":2.1735766683700604,"id":null},
        {"lat":41.38822550994968,"long":2.1673169116699,"id":null},
        {"lat":41.39442041830326,"long":2.146743310450802,"id":null},
        {"lat":41.39537908715899,"long":2.1483000392868234,"id":null}]

}

</script>
