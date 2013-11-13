var map;
var marker;
var geocoder;
var address;
var coordX;
var coordY;

$.fn.extend({
    clearFormElements: function() {
        this.each(function() {
            $(this).find(":input").val("").trigger("change");
        });
    }
});

$(function() {
    initHandlers();
    initUI();
});

function initHandlers() {
    $("#inOffice").change(function() {
        $(".outOffice").hide();
        $(".outOffice").clearFormElements();
        $(".inOffice").show();
    });
    $("#outOffice").change(function() {
        $(".inOffice").hide();
        $(".inOffice").clearFormElements();
        $(".outOffice").show();
    });
    $("#office").change(function(event) {
        var optionSelected = $("option:selected", this)[0];
        address = optionSelected.text;
        onAddressChanged(address);
    });
    $("#address").change(function(event) {
        address = $(this).val();
        onAddressChanged(address);
    });
    $("#coordX,#coordY").change(function(event) {
        coordX = parseCoord($("#coordX").val());
        coordY = parseCoord($("#coordY").val());
        onLatLngChanged();
    });
    $("#startDateButton").click(function(event) {
        event.preventDefault();
        $("#startDate").datepicker("show");
    });
    $("#endDateButton").click(function(event) {
        event.preventDefault();
        $("#endDate").datepicker("show");
    });
}

function initUI() {
    loadMap();
    $("#inOffice").attr("checked", true).trigger("change");
    $(".date").datepicker();
}

function loadMap() {
    var script = document.createElement("script");
    script.type = "text/javascript";
    script.src = "http://maps.googleapis.com/maps/api/js?key=AIzaSyBsMnKofj-RpAHA8ADXamYPaLbT4HSHaZE&sensor=false&callback=initMap";
    document.body.appendChild(script);
}

function initMap() {
    geocoder = new google.maps.Geocoder();
    var mapOptions = {
        zoom: 17,
        center: new google.maps.LatLng(0, 0),
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("map"), mapOptions);
    marker = new google.maps.Marker({
        map: map,
        draggable: false,
        animation: google.maps.Animation.DROP
    });
    google.maps.event.addListener(marker, 'dragend', function(event) {
        updateCoordsFromLatLng(event.latLng);
        showMapAndCenterAtLatLng(event.latLng);
    });
}

function onAddressChanged() {
    if (!coordX || !coordY) {
        if (address) {
            showMapAndCenterAtAddress(address);
        } else {
            hideMap();
        }
    }
}

function onLatLngChanged() {
    if (coordX && coordY) {
        showMapAndCenterAtLatLng(new google.maps.LatLng(coordY, coordX));
    } else {
        onAddressChanged();
    }
}

function encodeAddress(address, callback) {
    geocoder.geocode({ 'address': address}, callback);
}

function showMapAndCenterAtAddress(address) {
    encodeAddress(address, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
            var location = results[0].geometry.location;
            if (isOutOfOfficeInstallation()) {
                updateCoordsFromLatLng(location);
            }
            showMapAndCenterAtLatLng(location);
        } else {
            console.error("Geocode was not successful for the following reason: " + status);
        }
    });
}

function showMapAndCenterAtLatLng(latlng) {
    showMap();
    placeMarker(latlng);
}

function placeMarker(latlng) {
    marker.setPosition(latlng);
    if (isOutOfOfficeInstallation()) {
        marker.setDraggable(true);
    } else {
        marker.setDraggable(false);
    }
    map.setCenter(latlng);
}

function hideMap() {
    $("#map").hide();
}

function showMap() {
    $("#map").show();
    google.maps.event.trigger(map, 'resize');
}

function parseCoord(coord) {
    return parseFloat(coord.replace(',','.').replace(' ',''));
}

function isOutOfOfficeInstallation() {
    return $("#outOffice").is(":checked");
}

function updateCoordsFromLatLng(latLng) {
    coordX = latLng.lng();
    coordY = latLng.lat();
    $("#coordX").val(coordX);
    $("#coordY").val(coordY);
}
