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

		<table>
			<tr>
				<td width="450">
<!-- 				<legend style="font-size:2em"><br>Personal info</legend> -->

					<div class="form-group">
						<label class="col-md-5 control-label">Username:</label>
						<div class="col-lg-5">${user.username}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label">Email:</label>
						<div class="col-lg-5">${user.email}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-phoneNumber">phoneNumber:</label>
						<div class="col-lg-5">${user.profile.phoneNumber}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-age">Age:</label>
						<div class="col-lg-5">${user.profile.age}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-sex">Sex:</label>
						<div class="col-lg-5">${user.profile.sex}</div>
						<br>
					</div>

					</td>
									
			</tr>
		</table>


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



