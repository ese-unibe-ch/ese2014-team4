<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />

<div class="container">
	<h1>Profile of ${user.username}</h1>
	<hr>
</div>

<fieldset>
	<div class="col-md-3">
		<div class="text-center">
			<img
				src="${pageContext.request.contextPath}/imageController/profile/${user.profile.id}"
				class="img-responsive" alt="profileImage">
		</div>
	</div>

	<!-- edit form column -->
	<div class="col-md-9 personal-info">
		<div class="alert alert-info alert-dismissable">Let's know
			${user.username} better!</div>

		<table>
			<tr>
				<td width="400"><legend>Personal info</legend>

					<div class="form-group">
						<label class="col-lg-5 control-label">Username:</label>
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


					<div class="form-group">
						<label class="col-lg-5 control-label">Description:</label>
						<div class="col-lg-5">${user.profile.userDescription}</div>
						<br>
					</div></td>

				<td width="400"><c:import url="embedded/sendMessageBox.jsp" />
			</tr>
		</table>
	</div>

</fieldset>
<hr>

<!-- <div class="row"> -->
<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>${user.username}'sads</h3>
		</div>
		<div class="panel-body">
			sfsdf</a>
		</div>
	</div>
</div>

<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>${user.username}'sads</h3>
		</div>
		<div class="panel-body">
			sfsdf</a>
		</div>
	</div>
</div>


<!-- <div id="masthead"> -->
<!-- 	<div class="container"> -->
<!-- 		<div class="row"> -->
<!-- 			<div> -->
<!-- 				<h1></h1> -->
<!-- 				<hr> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<!--/container-->

<!-- </div> -->
<!-- <!--/masthead-->


<!-- <div class="row"> -->
<!-- 	<div class="col-md-4"> -->
<!-- 		<div class="panel panel-default"> -->
<!-- 			<div class="panel-heading"> -->
<!-- 				<h3></h3> -->
<!-- 			</div> -->
<!-- 			<div class="panel-body"> -->
<!-- 				<a href="createAd" class="inactive"><span>Create Ad</span></a> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<div class="col-md-4"> -->
<!-- 		<div class="panel panel-default"> -->
<!-- 			<div class="panel-heading"> -->
<!-- 				<h3>Profile</h3> -->
<!-- 			</div> -->
<!-- 			<div class="panel-body"> -->
<%-- 				<c:import url="embedded/profile.jsp" /> --%>
<!-- 				<br> <br> -->


<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<div class="col-md-4"> -->
<!-- 		<div class="panel panel-default"> -->
<!-- 			<div class="panel-heading"> -->
<!-- 				<h3></h3> -->
<!-- 			</div> -->
<!-- 			<div class="panel-body"> -->
<%-- 			<c:import url="embedded/sendMessageBox.jsp" /> --%>
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->


<c:import url="template/footer.jsp" />