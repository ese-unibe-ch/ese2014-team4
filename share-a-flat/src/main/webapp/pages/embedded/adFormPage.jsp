<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!-- only used as imported part of other pages, therefore no header / footer. -->


<c:set var="titleErrors">
	<form:errors path="title" />
</c:set>
<div
	class="control-group<c:if test="${not empty titleErrors}"> error</c:if>">
	<label class="control-label" for="field-title">Title<span
		style="color: red"> <b>*</b></span></label>

	<div class="controls">
		<form:input type="text" required="true" path="title" id="field-title"
			class="form-control" tabindex="1" maxlength="45" placeholder="Title"
			onfocus="(this.placeholder == 'Title') && (this.placeholder = '')"
			onblur="(this.placeholder == '') && (this.placeholder = 'Title')" />
		<form:errors path="title" cssClass="help-inline" element="span" />
	</div>
</div>

<c:set var="adTypeErrors">
	<form:errors path="adType" />
</c:set>
<div
	class="control-group<c:if test="${not empty adTypeErrors}"> error</c:if>"
	onclick="disableFieldInCreateAd()">
	<label class="control-label" for="field-adType">Type<span
		style="color: red"> <b>*</b></span></label>
	<div class="radio">
		<label><form:radiobutton path="adType" id="room" tabindex="2"
				value="ROOM" checked="true" />Room</label> <label><form:radiobutton
				path="adType" id="flat" tabindex="3" value="FLAT" />Flat</label>
	</div>
</div>


<div class="col-md-8" style="padding-left: 0px; padding-right: 3px">
	<c:set var="streetErrors">
		<form:errors path="street" />
	</c:set>
	<div
		class="control-group<c:if test="${not empty streetErrors}"> error</c:if>">
		<label class="control-label" for="field-street">Street<span
			style="color: red"> <b>*</b></span></label>
		<div class="controls">
			<form:input type="text" required="true" path="street"
				id="field-street" class="form-control" tabindex="4" maxlength="35"
				placeholder="Street"
				onfocus="(this.placeholder == 'Street') && (this.placeholder = '')"
				onblur="(this.placeholder == '') && (this.placeholder = 'Street')" />
			<form:errors path="street" cssClass="help-inline" element="span" />
		</div>
	</div>
</div>

<div class="col-md-4" style="padding-left: 3px; padding-right: 0px">
	<c:set var="streetNumberErrors">
		<form:errors path="streetNumber" />
	</c:set>
	<div
		class="control-group<c:if test="${not empty streetNumberErrors}"> error</c:if>">
		<label class="control-label" for="field-streetNumber">No<span
			style="color: red"> <b>*</b></span></label>
		<div class="controls">
			<form:input type="number" min="1" max="1000" step="1" required="true"
				path="streetNumber" id="field-streetNumber" class="form-control"
				tabindex="5" maxlength="4" value="${adForm.streetNumber}"
				onfocus="(this.value == '0') && (this.value = '')"
				onblur="(this.value == '') && (this.value = '0')"
				pattern="\d{1,3}[A-Za-z]?" title="e.g. 60a" />
			<form:errors path="streetNumber" cssClass="help-inline"
				element="span" />
		</div>
	</div>
</div>

<div class="col-md-4" style="padding-left: 0px; padding-right: 3px">
	<c:set var="zipCodeErrors">
		<form:errors path="zipCode" />
	</c:set>
	<div
		class="control-group<c:if test="${not empty zipCodeErrors}"> error</c:if>">
		<label class="control-label" for="field-zipCode">Zip-Code<span
			style="color: red"> <b>*</b></span></label>
		<div class="controls">
			<form:input type="number" min="1000" max="9658" step="1"
				required="true" path="zipCode" id="field-zipCode"
				class="form-control" tabindex="6" maxlength="4"
				value="${adForm.zipCode}"
				onfocus="(this.value == '0') && (this.value = '')"
				onblur="(this.value == '') && (this.value = '0')" pattern="\d{4}"
				title="e.g. 3000" />
			<form:errors path="zipCode" cssClass="help-inline" element="span" />
		</div>
	</div>
</div>

<div class="col-md-8" style="padding-left: 3px; padding-right: 0px">
	<c:set var="cityErrors">
		<form:errors path="city" />
	</c:set>
	<div
		class="control-group<c:if test="${not empty cityErrors}"> error</c:if>">
		<label class="control-label" for="field-city">City<span
			style="color: red"> <b>*</b></span></label>
		<div class="controls">
			<form:input type="text" required="true" path="city" id="field-city"
				class="form-control" tabindex="7" maxlength="35" placeholder="City"
				onfocus="(this.placeholder == 'City') && (this.placeholder = '')"
				onblur="(this.placeholder == '') && (this.placeholder = 'City')" />
			<form:errors path="city" cssClass="help-inline" element="span" />
		</div>
	</div>
</div>


<c:set var="sizeErrors">
	<form:errors path="size" />
</c:set>
<div
	class="control-group<c:if test="${not empty sizeErrors}"> error</c:if>">
	<label class="control-label" for="field-size">Size of Room or
		Flat (m<sup>2</sup>)
	</label>

	<div class="controls">
		<form:input type="number" min="0" max="1000000" step="1" path="size"
			id="field-size" class="form-control" tabindex="8" maxlength="6"
			value="${adForm.size}"
			onfocus="(this.value == '0') && (this.value = '')"
			onblur="(this.value == '') && (this.value = '0')" />
		<form:errors path="size" cssClass="help-inline" element="span" />
	</div>
</div>

<c:set var="nrOfRoomsErrors">
	<form:errors path="nrOfRooms" />
</c:set>
<div
	class="control-group<c:if test="${not empty nrOfRoomsErrors}"> error</c:if>">
	<label class="control-label" for="field-nrOfRooms">Number of
		Rooms (whole flat)</label>

	<div class="controls">
		<form:input type="number" min="0" max="1000000" step="0.5"
			path="nrOfRooms" id="field-nrOfRooms" class="form-control"
			tabindex="9" maxlength="6" value="${adForm.nrOfRooms}"
			onfocus="(this.value == '0.0') && (this.value = '')"
			onblur="(this.value == '') && (this.value = '0.0')" />
		<form:errors path="nrOfRooms" cssClass="help-inline" element="span" />
	</div>
</div>

<div class="col-md-6" style="padding-left: 0px; padding-right: 3px">
	<c:set var="nettoErrors">
		<form:errors path="netto" />
	</c:set>
	<div
		class="control-group<c:if test="${not empty nettoErrors}"> error</c:if>">
		<label class="control-label" for="field-netto">Netto-Price:</label>
		<div class="controls">
			<form:input type="number" min="0" max="1000000" step="1" path="netto"
				id="field-netto" class="form-control" tabindex="10" maxlength="6"
				value="${adForm.netto}"
				onfocus="(this.value == '0') && (this.value = '')"
				onblur="(this.value == '') && (this.value = '0')" />
			<form:errors path="netto" cssClass="help-inline" element="span" />
		</div>
	</div>
</div>

<div class="col-md-6" style="padding-left: 3px; padding-right: 0px">
	<c:set var="chargesErrors">
		<form:errors path="charges" />
	</c:set>
	<div
		class="control-group<c:if test="${not empty chargesErrors}"> error</c:if>">
		<label class="control-label" for="field-charges">Charges:</label>
		<div class="controls">
			<form:input type="number" min="0" max="1000000" step="1"
				path="charges" id="field-charges" class="form-control" tabindex="11"
				maxlength="6" value="${adForm.charges}"
				onfocus="(this.value == '0') && (this.value = '')"
				onblur="(this.value == '') && (this.value = '0')" />
			<form:errors path="charges" cssClass="help-inline" element="span" />
		</div>
	</div>
</div>

<c:set var="nrOfFlatMatesErrors">
	<form:errors path="nrOfFlatMates" />
</c:set>
<div
	class="control-group<c:if test="${not empty nrOfFlatMatesErrors}"> error</c:if>">
	<label class="control-label" for="field-nrOfFlatMates">Number
		of Flatmates</label>
	<div class="controls">
		<form:input type="number" min="0" max="1000000" step="1"
			path="nrOfFlatMates" id="field-nrOfFlatMates" class="form-control"
			tabindex="12" maxlength="6" value="${adForm.nrOfFlatMates}"
			onfocus="(this.value == '0') && (this.value = '')"
			onblur="(this.value == '') && (this.value = '0')" />
		<form:errors path="nrOfFlatMates" cssClass="help-inline"
			element="span" />
	</div>
</div>


<c:set var="availableDateErrors">
	<form:errors path="availableDate" />
</c:set>
<div
	class="control-group<c:if test="${not empty availableDateErrors}"> error</c:if>">
	<label class="control-label" for="field-availableDate">Available
		from</label>
	<div class="controls">
		<form:input type="text" path="availableDate" id="field-availableDate"
			class="form-control" tabindex="13" maxlength="35"
			placeholder="e.g. 01-01-2015"
			onfocus="(this.placeholder == 'e.g. 01-01-2015') && (this.placeholder = '')"
			onblur="(this.placeholder == '') && (this.placeholder = 'e.g. 01-01-2015')" />
		<form:errors path="availableDate" cssClass="help-inline"
			element="span" />
		<br>
		<!--if using type="date" it doesn't work in chrome because it wants to use the date-input type of html5
				that includes a date picker	wich doesn't work in firefox with the format mm/dd/yyyy, wich does not match 
				MM-DD-YYYY, wich is the format we specified. Result: unusable date, like 1009-07-06 or so-->
	</div>

	<script type="text/javascript">
		// When the document is ready
		$(document).ready(function() {
			$('#field-availableDate').datepicker({
				format : "dd-mm-yyyy"
			});
		});
	</script>
</div>


</div>

<div class="col-md-6">
	<!-- middle column -->

	<div class="alert alert-warning" align="left"
		style="height: 50px; text-align: center">
		<b>( <span style="color:red">*</span> are mandatory fields! )</b>
	</div>

	<div class="layout-content-column">
		<table id="fileTable">
			<tr>
				<th>File name</th>
			</tr>
		</table>

		<INPUT type="button" value="Add more pictures"
			onclick="addRowFile('fileTable')" /> <INPUT type="button"
			value="Delete selected picture" onclick="deleteRow('fileTable')" />

		<script>
			<c:forEach items="${adForm.uploadedAdPictures}" var="picture">
			addRowFile('fileTable');
			</c:forEach>
		</script>

		<!--  script for adding another file upload possibility -->
		<SCRIPT type="text/javascript">
			function addRowFile(tableID) {

				var table = document.getElementById(tableID);

				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
				rowCount--;
				var cell1 = row.insertCell(0);
				var element1 = document.createElement("input");
				element1.type = "checkbox";
				element1.name = "chkbox[]";
				cell1.appendChild(element1);

				var id = "imageInput" + rowCount
				var cell2 = row.insertCell(1);
				var element2 = document.createElement("input");
				element2.setAttribute("type", "file");
				element2.type = "file";
				element2.name = "uploadedAdPictures[" + rowCount + "]";

				cell2.appendChild(element2);

			}

			<!--
			delete defined in addFlatmates.jsp
			-->
		</SCRIPT>

		<c:set var="descriptionErrors">
			<form:errors path="description" />
		</c:set>

		<div
			class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
			<label class="control-label" for="field-description">Description<span
				style="color: red"> <b>*</b></span></label>
			<div class="controls">
				<form:textarea required="true" class="form-control"
					path="description" id="field-description"
					style="width:100%; height:160px; resize:none" tabindex="14"
					placeholder="Description"
					onfocus="(this.placeholder == 'Description') && (this.placeholder = '')"
					onblur="(this.placeholder == '') && (this.placeholder = 'Description')" />
				<form:errors path="description" cssClass="help-inline"
					element="span" />
				<br> <br>
			</div>
		</div>

	</div>
