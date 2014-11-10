<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />


<h1>${adData.title} </h1>
        <!-- sets current_profile sex -->
        <c:set var="adTypeToShow" value="apartment" />
		<c:if test="${adData.type eq 'ROOM'}">
   		<c:set var="adTypeToShow" value="room" />
		</c:if>
		
<br>		
<p>${adTypeToShow}</p>

<p><b>Address</b><br>
${adData.address.street} ${adData.address.streetNumber}<br>
${adData.address.zipCode} ${adData.address.city}</p>

<div class="col-md-3">
<table><tr>
<c:forEach items="${imageList}" var="imgId">
	<td>
	<img src="${pageContext.request.contextPath}/imageController/ad/${adData.id}/${imgId}" class="img-responsive" alt="${adData.id}/${imgId}" width="100px" height="100px"/>
	</td>
</c:forEach>
</tr></table></div>
<c:import url="template/footer.jsp" />