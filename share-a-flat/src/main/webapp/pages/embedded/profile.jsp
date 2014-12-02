<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>My Profile</h2> -->
<br>
<span class=".hasError">${errorMessage}</span>

<div class="col-md-12" align="center">
<img
	src="${pageContext.request.contextPath}/imageController/profile/${user.profile.id}"
	class="img-responsive" alt="profileImage">
</div>

<div class="col-md-5">
	<p>
		<b>Username: </b>
	</p>
</div>

<div class="col-md-6">
	<p>${user.username}</p>
</div>

<div class="col-md-5">
	<p>
		<b>Email: </b>
	</p>
</div>

<div class="col-md-6">
	<p>${user.email}</p>
</div>

<div class="col-md-5">
	<p>
		<b>Phone: </b>
	</p>
</div>

<div class="col-md-6">
	<c:set var="phoneNr" value="${user.profile.phoneNumber}" />
	<c:if test="${user.profile.phoneNumber eq '' || user.profile.phoneNumber eq 'NULL'}">
		<c:set var="phoneNr" value="--" />
	</c:if>

	<p>${phoneNr}</p>
</div>

<div class="col-md-3">
	<p>
		<b>Age: </b>
	</p>
</div>

<div class="col-md-3">
<c:set var="userAge" value="${user.profile.age}" />
	<c:if test="${user.profile.age eq '' || user.profile.age eq 'NULL'}">
		<c:set var="userAge" value="--" />
	</c:if>

	<p>${userAge}</p>
</div>

<div class="col-md-3">
	<p>
		<b>Gender: </b>
	</p>
</div>

<div class="col-md-3">
	<c:set var="userSex" value="${user.profile.sex}" />
  	<c:if test="${user.profile.sex ne 'F' && user.profile.sex ne 'M'}">
		<c:set var="userSex" value="--" />
	</c:if>

	<p>${userSex}</p>
</div>

<div class="col-md-12">
	<b>Description: </b>
</div>

<div class="col-md-12">
<c:set var="userDescription" value="${user.profile.userDescription}" />
	<c:if test="${user.profile.userDescription eq '' || user.profile.userDescription eq 'NULL'}">
		<c:set var="userDescription" value="--" />
	</c:if>

	${userDescription}
</div>

<div class="col-md-12">
	<p><br></p>
</div>


<!-- <table> -->
<!-- 	<tr> -->
<!-- 		<td width="110"> -->
<!-- 			<p> -->
<!-- 				<b>Username: </b> -->
<!-- 			</p> -->
<!-- 		</td> -->
<%-- 		<td><p>${user.username}</p></td> --%>
<!-- 	</tr> -->

<!-- 	<tr> -->
<!-- 		<td><p> -->
<!-- 				<b>Email: </b> -->
<!-- 			</p></td> -->
<%-- 		<td><p>${user.email}</p></td> --%>
<!-- 	</tr> -->

<!-- 	<tr> -->
<!-- 		<td><p> -->
<!-- 				<b>Phone: </b> -->
<!-- 			</p></td> -->
<%-- 		<td><p>${user.profile.phoneNumber}</p></td> --%>
<!-- 	</tr> -->

<!-- 	<tr> -->
<!-- 		<td width="30"><p> -->
<!-- 				<b>Age: </b> -->
<!-- 			</p></td> -->
<%-- 		<td><p>${user.profile.age}</p></td> --%>

<!-- 		<td><p> -->
<!-- 				<b>Gender: </b> -->
<!-- 			</p></td> -->
<%-- 		<td><p>${user.profile.sex}</p></td> --%>
<!-- 	</tr> -->
<!-- </table> -->

<!-- <div class="col-md-3"> -->
<!-- <b>Age: </b> -->
<!-- 			</p></td> -->
<%-- 		<td><p>${user.profile.age}</p> --%>

<!-- </div> -->
<%-- <p><b>Description: </b><br>${user.profile.userDescription}</p> --%>



