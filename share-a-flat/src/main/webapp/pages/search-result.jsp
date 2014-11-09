<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />


<h1>Search Result</h1>

<div class="map">
	<a href="search-map" class="inactive"> <span> <!-- <img src="/neutral/imids/homegate/icon_tab_map.gif" />-->Auf
			Karte
	</span></a>
</div>
<hr>



<c:forEach items="${adsToAdd}" var="ad">
	<table>
		<tr>
			<td width="80">
				<b style="font-size:14pt; color:blue">${ad.title}</b><br> 
				<b>Address:</b><br> <b></b>
				<b>Place:</b><br> 
			</td>
				

			<td width="150">
				<b style="font-size:14pt"> </b><br> 
				${ad.address.street} ${ad.address.streetNumber}<br>
				${ad.address.zipCode} ${ad.address.city}
			</td>
			
			<td width="60">
				<b style="font-size:14pt; color:blue"> </b><br> 
				<b>Price:</b><br>
				<b>Size:</b><br>
			</td>
			
			<td width="100">
				<b style="font-size:14pt"> </b><br> 
				${ad.price} CHF<br>
				${ad.size} m&sup2<br>
			</td>
			
	</table>
	<hr>
</c:forEach>



<c:import url="template/footer.jsp" />