<%@ page language="java" import="javax.servlet.jsp.PageContext"
	pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />

<div id="masthead">
	<div class="container">
		<div class="row">
			<div>
				<h1>Ad-Creation</h1>
				<hr>
			</div>


		</div>
	</div>
	<!--/container-->
</div>
<!--/masthead-->

<form:form enctype="multipart/form-data" method="post"
	modelAttribute="adForm" action="submitAd" id="adForm"
	cssClass="form-horizontal" autocomplete="off">

	<div class="col-md-3">

		<c:set var="titleErrors">
			<form:errors path="title" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty titleErrors}"> error</c:if>">
			<label class="control-label" for="field-title">Title:</label>

			<div class="controls">
				<form:input path="title" id="field-title" class="form-control"
					tabindex="1" maxlength="45" placeholder="Title" />
				<form:errors path="title" cssClass="help-inline" element="span" />
			</div>
		</div>

		<c:set var="adTypeErrors">
			<form:errors path="adType" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty adTypeErrors}"> error</c:if>">
			<label class="control-label" for="field-adType">Type:</label>
			<div class="radio">
				<label><form:radiobutton path="adType" id="room"
						tabindex="2" value="ROOM" checked="true" />Room</label> <label><form:radiobutton
						path="adType" id="flat" tabindex="3" value="FLAT" />Flat</label>
			</div>
		</div>

		<!-- 
			<c:if test="${adType eq 'ROOM'}">
			asdfasdf
			</c:if> -->
		<c:set var="streetErrors">
			<form:errors path="street" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty streetErrors}"> error</c:if>">
			<label class="control-label" for="field-street">Street:</label>
			<div class="controls">
				<form:input path="street" id="field-street" class="form-control"
					tabindex="4" maxlength="35" placeholder="Street" />
				<form:errors path="street" cssClass="help-inline" element="span" />
			</div>
		</div>
		<c:set var="streetNumberErrors">
			<form:errors path="streetNumber" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty streetNumberErrors}"> error</c:if>">
			<label class="control-label" for="field-streetNumber">StreetNumber:</label>
			<div class="controls">
				<form:input path="streetNumber" id="field-streetNumber"
					class="form-control" tabindex="5" maxlength="35"
					placeholder="StreetNumber" />
				<form:errors path="streetNumber" cssClass="help-inline"
					element="span" />
			</div>
		</div>

		<c:set var="cityErrors">
			<form:errors path="city" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty cityErrors}"> error</c:if>">
			<label class="control-label" for="field-city">City:</label>
			<div class="controls">
				<form:input path="city" id="field-city" class="form-control"
					tabindex="6" maxlength="35" placeholder="City" />
				<form:errors path="city" cssClass="help-inline" element="span" />
			</div>
		</div>

		<c:set var="zipCodeErrors">
			<form:errors path="zipCode" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty zipCodeErrors}"> error</c:if>">
			<label class="control-label" for="field-zipCode">Zip-Code:</label>
			<div class="controls">
				<form:input path="zipCode" id="field-zipCode" class="form-control"
					tabindex="7" maxlength="35" placeholder="Zip-Code" />
				<form:errors path="zipCode" cssClass="help-inline" element="span" />
			</div>
		</div>

		<c:set var="sizeErrors">
			<form:errors path="size" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty sizeErrors}"> error</c:if>">
			<label class="control-label" for="field-size">Size of Room or
				Flat (m<sup>2</sup>):
			</label>

			<div class="controls">
				<form:input path="size" id="field-size" class="form-control"
					tabindex="8" maxlength="45" placeholder="Size" />
				<form:errors path="size" cssClass="help-inline" element="span" />
			</div>
		</div>

		<c:set var="nrOfRoomsErrors">
			<form:errors path="nrOfRooms" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty nrOfRoomsErrors}"> error</c:if>">
			<label class="control-label" for="field-nrOfRooms">Number of
				Rooms (whole flat):</label>

			<div class="controls">
				<form:input path="nrOfRooms" id="field-nrOfRooms"
					class="form-control" tabindex="9" maxlength="45"
					placeholder="nrOfRooms" />
				<form:errors path="nrOfRooms" cssClass="help-inline" element="span" />
			</div>
		</div>

		<c:set var="priceErrors">
			<form:errors path="price" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty priceErrors}"> error</c:if>">
			<label class="control-label" for="field-price">Price:</label>
			<div class="controls">
				<form:input path="price" id="field-price" class="form-control"
					tabindex="10" maxlength="35" placeholder="Price" />
				<form:errors path="price" cssClass="help-inline" element="span" />
			</div>
		</div>

		<c:set var="nrOfRoomMatesErrors">
			<form:errors path="nrOfRoomMates" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty nrOfRoomMatesErrors}"> error</c:if>">
			<label class="control-label" for="field-nrOfRoomMates">Number
				of RoomMates:</label>
			<div class="controls">
				<form:input path="nrOfRoomMates" id="field-nrOfRoomMates"
					class="form-control" tabindex="11" maxlength="35"
					placeholder="Number of Roommates" />
				<form:errors path="nrOfRoomMates" cssClass="help-inline"
					element="span" />
				<br>
				<br>
			</div>
		</div>

	</div>

	<div class="col-md-6">
		<!-- middle column -->

		<div class="layout-content-column">
			<table id="fileTable">
				<tr>
					<td><form:input path="uploadedAdPictures" class="form-control"
							type="file" /></td>
				</tr>
			</table>
			<button id="addFile" type="button" onclick="addMore">Add
				more pictures</button>

			<!--  script for adding another file upload possibility -->
			<!--  needs to be placed within <form:form></form:form> -->
			<script
				src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
			<script>
				$(document).ready(function() {
					//add more file components if Add is clicked
					$('#addFile').click(function() {
							$('#fileTable').append('<tr><td>' 
												 + '<form:input path="uploadedAdPictures" class="form-control" type="file"/>'
												 + '</td></tr>');
					});
				});
			</script>

			<c:set var="descriptionErrors">
				<form:errors path="description" />
			</c:set>
			<div
				class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
				<label class="control-label" for="field-description">Description:</label>
				<div class="controls">
					<form:textarea path="description" id="field-description"
						style="width:483px; height:121px" tabindex="12"
						placeholder="Description" />
					<form:errors path="description" cssClass="help-inline"
						element="span" />
				</div>
			</div>

			<div class="form-actions">
				<button type="submit" class="btn btn-primary" tabindex="13">Create
					Ad</button>
				<a type="button" href="${pageContext.request.contextPath}/my-page" tabindex="14" class="btn btn-default">Cancel</a>
			</div>
		</div>
	</div>
</form:form>

<div class="col-md-3">
	<!-- right column -->
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>Options</h3>
		</div>
		<div class="panel-body">
			<a href="createAd" class="inactive"><span>Create Ad</span></a>
		</div>
	</div>


</div>
<c:if test="${page_error != null }">
	<div class="alert alert-error">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<h4>Error!</h4>
		${page_error}
	</div>
</c:if>

<c:import url="template/footer.jsp" />