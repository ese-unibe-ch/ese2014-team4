<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<head>
    <style>
      #map_canvas {
        width: 500px;
        height: 400px;
      }
    </style>
    <script src="https://maps.googleapis.com/maps/api/js"></script>
    <script>
      function initialize() {
        var mapCanvas = document.getElementById('map_canvas');
        var mapOptions = {
          center: new google.maps.LatLng(46.9479222,7.4446085,7),
          zoom: 8,
          mapTypeId: google.maps.MapTypeId.ROADMAP
        }
        var map = new google.maps.Map(mapCanvas, mapOptions)
      }
      google.maps.event.addDomListener(window, 'load', initialize);
      
      var kmlLayer = new google.maps.KmlLayer();

      var kmlUrl = 'https://docsouth.unc.edu/gtts/map/kml/city/new-bern.kml';
      var kmlOptions = {
        suppressInfoWindows: true,
        preserveViewport: false,
        map: map
      };
      var kmlLayer = new google.maps.KmlLayer(kmlUrl, kmlOptions);

    </script>
  </head>

<h1>Search Map</h1>

        <!-- Auswahlreiter -->
        <ul>
  		<li class="buton"><a href="search-list" class="inactive">
                <span><!--  <img src="/neutral/images/homegate/icon_tab_list_active.gif" />-->Auf Liste</span></a></li>
		</ul>

  <body>
    <div id="map_canvas"></div>
  </body>


<c:import url="template/footer.jsp" />