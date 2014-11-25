<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- special css for thumbnail view -->
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<meta charset="utf-8">

<!DOCTYPE html>
<html>
<head>
<style>
#map-canvas {
	width: 350px;
	height: 250px;
}
</style>
</head>
</html>


<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
var geocoder;
var map;
function initialize() {
  geocoder = new google.maps.Geocoder();
  var latlng = new google.maps.LatLng(46.9479222,7.4446085,7);
  var mapOptions = {
    zoom: 8,
    center: latlng
  }
  map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
}

function placeAddresses(value, id){
	 geocoder.geocode( {'address':value}, function(results, status) {
		    if (status == google.maps.GeocoderStatus.OK) {
		      map.setCenter(results[0].geometry.location);
		      var marker = new google.maps.Marker({url:'showAd?adId='+id,
		          map: map,
		          position: results[0].geometry.location
		      });
		      
		      var contentString = "" + value + "";	
		  	var infowindow = new google.maps.InfoWindow( { content:value} );  	
		  	google.maps.event.addListener( marker, 'mouseover', function() { infowindow.open( map, marker ); });
		  	
		  	google.maps.event.addListener(marker, 'click', function() {
		  	  window.location.href = marker.url;
		  	});
		      
		    } else {
		      alert('Geocode was not successful for the following reason: ' + status);
		    }
		  });
}

	function codeAddress() {	
		<c:forEach items="${addresses}" var="item">
		placeAddresses("${item.addressAsString}", "${item.id}");
		</c:forEach>
	}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
<body onload="codeAddress()">