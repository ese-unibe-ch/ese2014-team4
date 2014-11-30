<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />
<c:import url="functions/searchFunctions.jsp" />

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>

<style>
#map-canvas {
	width: 700px;
	height: 395px;
	}
</style>

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

	function placeAddresses(value, id, src) {
		geocoder
				.geocode(
						{
							'address' : value
						},
						function(results, status) {
							if (status == google.maps.GeocoderStatus.OK) {
								map.setCenter(results[0].geometry.location);
								var marker = new google.maps.Marker({
									url : 'showAd?adId=' + id,
									map : map,
									position : results[0].geometry.location
								});

								var infowindow = new google.maps.InfoWindow({
									content : value
								});
								google.maps.event.addListener(marker,
										'mouseover', function() {
											infowindow.open(map, marker);
										});

								google.maps.event.addListener(marker, 'click',
										function() {
											window.location.href = marker.url;
										});

							} else {
								alert('the address "'
										+ value
										+ '" could not be found on the map for the following reason: '
										+ status);
							}
						});
	}

	function codeAddress() {
		<c:forEach items="${addresses}" var="item">
		var src = "${pageContext.request.contextPath}/imageController/ad/${item.id}/${imgId}";
		placeAddresses("${item.addressAsString}", "${item.id}", src);
		</c:forEach>
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
<body onload="codeAddress()">

	<h1>Search</h1>
	<hr>
</body>

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
			<div class="row"></div>
				<h3>${whatToDisplay}</h3>
				<button id="listButton" onClick="swap('two','one','mapButton', 'listButton')" class="btn btn-info btn-xs"> Switch to List View</button>
				<button style="display: none" id="mapButton" onClick="swap('one','two','listButton', 'mapButton' )" class="btn btn-info btn-xs">Switch to Map View</button>
			</div>
			<div class="panel-body">
				<span style="display: none" id="two">
					<c:import url="searchResultsList.jsp" />
				</span> 
				<span id="one">
					<div id="map-canvas"></div>
				</span>
			</div>
		</div>
	</div>
</div>

<!-- swap between list and map displays as well as changes the button  -->

<script type="text/javascript">
	function swap(one, two, mapButton, listButton) {
		document.getElementById(one).style.display = 'block';
		document.getElementById(two).style.display = 'none';
		document.getElementById(mapButton).style.display = 'block';
		document.getElementById(listButton).style.display = 'none';
	}
</script>

<c:import url="template/footer.jsp" />