<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:forEach items="${adList}" var="ad">
	<a href="showAd?adId=${ad.id}" style="font-size: 14pt; color: blue"><b>${ad.title}</b></a> <font size="1">(${ad.type})</font>
	
<!-- 	<span style="float:right; width:50px; displas:block"> -->
<%-- 		<c:choose><c:when test="${isBookmarked eq false}"> --%>
<%-- 			<a id="bookmarkStar" href="${pageContext.request.contextPath}/addToBookmarks?adId=${adData.id}"><img width=35 height=35 alt="click to bookmark" src="img/notbookmarked.png"></a></c:when> --%>
<%-- 		<c:otherwise> --%>
<%-- 			<a id="bookmarkStar" href="${pageContext.request.contextPath}/removeFromBookmarks?adId=${adData.id}"><img width=35 height=35  alt="click to remove from bookmarks" src="img/bookmarked.png"></a></c:otherwise> --%>
<%-- 		</c:choose> --%>
<!-- 	</span> -->
	
	<table>

		<tr>
			<td width="110"><a href="showAd?adId=${ad.id}"><img
					src="${pageContext.request.contextPath}/imageController/ad/${ad.id}/0"
					class="img-responsive" width="100"></a></td>

			<td width="80"><b>Address:</b><br> <b></b> <b>Place:</b><br>
			</td>


			<td width="150">${ad.address.street} ${ad.address.streetNumber}<br>
				${ad.address.zipCode} ${ad.address.city}
			</td>

			<td width="60"><b>Price:</b><br> <b>Size:</b><br></td>
			
			<c:if test="${ad.brutto eq 0}"><c:set var="brutto" value="--"></c:set></c:if>
			<c:if test="${ad.brutto ne 0}"><c:set var="brutto" value="${ad.brutto} CHF"></c:set></c:if>
			<c:if test="${ad.size eq 0}"><c:set var="size" value="--"></c:set></c:if>
			<c:if test="${ad.size ne 0}"><c:set var="size" value="${ad.size} m&sup2"></c:set></c:if>

			<td width="100">${brutto}<br> ${size}<br>
			</td>
			
			<td width="150"><b>Available from:</b><br>${ad.availableDate}</td>
		</tr>
	</table>
	<hr>
</c:forEach>
