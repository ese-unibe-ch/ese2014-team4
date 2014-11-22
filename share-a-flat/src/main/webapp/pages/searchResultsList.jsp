<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>




<br><hr>
<c:forEach items="${adList}" var="ad">
	<a href="showAd?adId=${ad.id}" style="font-size:14pt; color:blue"><b>${ad.title}</b></a>
	<table>
	
		<tr>
			<td width="110">
				<a href="showAd?adId=${ad.id}"><img src="${pageContext.request.contextPath}/imageController/ad/${ad.id}/0" class="img-responsive" width="100"></a>

			</td>
					
			<td width="80"> 
				<b>Address:</b><br> <b></b>
				<b>Place:</b><br> 
			</td>
				

			<td width="150">
				${ad.address.street} ${ad.address.streetNumber}<br>
				${ad.address.zipCode} ${ad.address.city}
			</td>
			
			<td width="60">
				<b>Price:</b><br>
				<b>Size:</b><br>
			</td>
			
			<td width="100">
				${ad.brutto} CHF<br>
				${ad.size} m&sup2<br>
			</td>
			</tr>
	</table>
	<hr>
</c:forEach>
