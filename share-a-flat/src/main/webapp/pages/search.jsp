<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />
<c:import url="functions/searchFunctions.jsp" />

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>


<!DOCTYPE html>
<html>
<head>
<style>
#map-canvas {
	width: 700px;
	height: 280px;
}
</style>
</head>
</html>


<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
	//     document.getElementById("map-canvas").style.visibility="hidden";

	var geocoder;
	var map;
	function initialize() {
		geocoder = new google.maps.Geocoder();
		var latlng = new google.maps.LatLng(46.9479222, 7.4446085, 7);
		var mapOptions = {
			zoom : 8,
			center : latlng
		}
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
	}

	function placeAddresses(value, id) {
		geocoder.geocode({
			'address' : value
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);
				var marker = new google.maps.Marker({
					url : 'showAd?adId=' + id,
					map : map,
					position : results[0].geometry.location
				});

				var contentString = "" + value + "";
				var infowindow = new google.maps.InfoWindow({
					content : value
				});
				google.maps.event.addListener(marker, 'mouseover', function() {
					infowindow.open(map, marker);
				});

				google.maps.event.addListener(marker, 'click', function() {
					window.location.href = marker.url;
				});

			} else {
				alert('Geocode was not successful for the following reason: '
						+ status);
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



	<h1>Search List</h1>
	<!-- 	<div class="panel-body"> -->
	<!-- 		<a href="getMap" class="inactive"><span>see on map</span></a> -->
	</div>
	<!-- Auswahlreiter -->
	<!-- 	<ul> -->
	<!-- 		<li class="map"><a -->
	<%-- 			href="search?searchType=<c:choose><c:when test="${resultType eq 'list'}">map</c:when><c:otherwise>list</c:otherwise> --%>
	<%-- 			</c:choose>" --%>
	<!-- 			class="inactive"><span>Search Map</span></a></li> -->
	<!-- 	</ul> -->

	<div class="row">
		<div class="col-md-4">
			<div class="panel panel-default">

				<div class="panel-heading">
					<h3>Search-Criteria</h3>
				</div>

				<div class="panel-body">
					<c:import url="searchCriteria.jsp" />
				</div>

			</div>
		</div>

		<div class="col-md-8">
			<div class="panel panel-default">

				<div class="panel-heading">
					<h3>${whatToDisplay}</h3>
				</div>
				<div class="panel-body">
					<c:import url="searchResultsList.jsp" />
					<div id="map-canvas"></div>
				</div>
			</div>
		</div>
	</div>

	<c:import url="template/footer.jsp" />