<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>My Profile</h2> -->
<br>
<span class=".hasError">${errorMessage}</span>


<img
	src="${pageContext.request.contextPath}/imageController/profile/${user.profile.id}"
	class="img-responsive" alt="profileImage">
<table>
	<tr>
		<td width="110">
			<p><b>Username: </b></p></td>
		<td><p>${user.username}</p></td>
	</tr>
	
	<tr>
		<td><p><b>Email: </b></p></td>
		<td><p>${user.email}</p></td>
	</tr>
	
	<tr>
		<td><p><b>Phone: </b></p></td>
		<td><p>${user.profile.phoneNumber}</p></td>
	</tr>
	
	<tr>
		<td width="30"><p><b>Age: </b></p></td>
		<td><p>${user.profile.age}</p></td>
		
		<td width="120"><p><b>Gender: </b></p></td>
		<td><p>${user.profile.sex}</p></td>
	</tr>
	
<!-- 	<tr> -->
<!-- 	<p><b>Description: </b></p> -->
<%-- 	<p>${user.profile.userDescription}</p> --%>
<!-- 	</tr> -->
	
</table>

<%-- <p><b>Username: </b>${user.username}</p>  --%>
<%-- <p><b>Email: </b>${user.email}</p> --%>
<%-- <p><b>Phone: </b>${user.profile.phoneNumber}</p>     --%>
<%-- <p><b>Age: </b>${user.profile.age}</p>   --%>
<%-- <p><b>Gender: </b>${user.profile.sex}</p> --%>
<p><b>Description: </b><br>${user.profile.userDescription}</p>



