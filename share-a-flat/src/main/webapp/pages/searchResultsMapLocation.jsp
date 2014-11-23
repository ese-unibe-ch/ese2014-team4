<%@ page language="java" import="javax.servlet.jsp.PageContext"
	pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<h1>Search Map</h1>
        <!-- Auswahlreiter -->
        <c:out value="${addresses[0]}"></c:out>
        <ul>
              <div class="panel-body"><a href="search" class="inactive"><span>back to list</span></a>

		</ul>
  <!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Geocoding service</title>
    <style>
      html, body, #map-canvas {
        height: 90%;
        margin: 0px;
        padding: 0px
      }
      #panel {
        position: absolute;
        top: 5px;
        left: 50%;
        margin-left: -180px;
        z-index: 5;
        background-color: #fff;
        padding: 5px;
        border: 1px solid #999;
      }
    </style>
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
</script>
<script>
function codeAddress() {
	for (var i=0; i<2; i++){
 // var address = document.getElementById('address').value;
  geocoder.geocode( {'address':"${addresses[0]}"}, function(results, status) {
    if (status == google.maps.GeocoderStatus.OK) {
      map.setCenter(results[0].geometry.location);
      var marker = new google.maps.Marker({
          map: map,
          position: results[0].geometry.location
      });
    } else {
      alert('Geocode was not successful for the following reason: ' + status);
    }
  });
	}
  
//   geocoder.geocode( {'address':address[1]}, function(results, status) {
// 	    if (status == google.maps.GeocoderStatus.OK) {
// 	      map.setCenter(results[0].geometry.location);
// 	      var marker = new google.maps.Marker({
// 	          map: map,
// 	          position: results[0].geometry.location
// 	      });
// 	    } else {
// 	      alert('Geocode was not successful for the following reason: ' + status);
// 	    }
// 	  });
  
}
google.maps.event.addDomListener(window, 'load', initialize);


    </script>
  </head>
  <body>
  <body onload="codeAddress()">
  
<!--     <div id="panel"> -->
<!--       <input id="address" type="textbox" value="Sydney, NSW"> -->
<%--       <input type="button" value="show me locations!" onclick="codeAddress('${addresses[0]}')"> --%>

      <c:forEach  items="${addresses}" var="address">
      <script type="text/javascript">codeAddress('${address}')</script>
      
      </c:forEach>
      
<!--     </div> -->
    <div id="map-canvas"></div>
  </body>
</html>
<c:import url="template/footer.jsp" />

