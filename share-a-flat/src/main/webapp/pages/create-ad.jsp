<%@ page language="java" import="javax.servlet.jsp.PageContext"
	pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<c:import url="template/header.jsp" />
<c:import url="functions/generalFunctions.jsp" />
<%-- <c:import url="functions/searchFunctions.jsp" /> --%>
<c:import url="functions/createAdFunctions.jsp" />



<%-- <c:forEach items="${zipCityAsArray}" var="zipCity"> --%>
<%-- <c:if test="${zipCity.zip==2504}"> --%>
<%-- <c:out value="${zipCity.city}"></c:out> --%>
<%-- </c:if> --%>
<%-- </c:forEach> --%>


<div id="masthead">
	<div class="container">
		<div class="row">
			<div>
				<h1>Ad-Creation</h1>
				<hr>
			</div>
		</div>
	</div>
</div>
<!--/container-->

<!--/masthead-->


<span class="error">${errorMessage}</span>
<form:form enctype="multipart/form-data" method="post"
	modelAttribute="adForm" action="submitAd"
	onSubmit="return createFormIsValid()" id="adForm"
	cssClass="form-horizontal" autocomplete="off">

	<div class="col-md-3">

		<c:set var="titleErrors">
			<form:errors path="title" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty titleErrors}"> error</c:if>">
			<label class="control-label" for="field-title">Title*</label>

			<div class="controls">
				<form:input type="text" required="true" path="title"
					id="field-title" class="form-control" tabindex="1" maxlength="45"
					placeholder="Title"
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
			<label class="control-label" for="field-adType">Type</label>
			<div class="radio">
				<label><form:radiobutton path="adType" id="room"
						tabindex="2" value="ROOM" checked="true" />Room</label> <label><form:radiobutton
						path="adType" id="flat" tabindex="3" value="FLAT" />Flat</label>
			</div>
		</div>


		<div class="col-md-9" style="padding-left: 0px; padding-right: 3px">
			<c:set var="streetErrors">
				<form:errors path="street" />
			</c:set>
			<div
				class="control-group<c:if test="${not empty streetErrors}"> error</c:if>">
				<label class="control-label" for="field-street">Street*</label>
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

		<div class="col-md-3" style="padding-left: 3px; padding-right: 0px">
			<c:set var="streetNumberErrors">
				<form:errors path="streetNumber" />
			</c:set>
			<div
				class="control-group<c:if test="${not empty streetNumberErrors}"> error</c:if>">
				<label class="control-label" for="field-streetNumber">No*</label>
				<div class="controls">
					<form:input type="number" min="1" max="1000" step="1"
						required="true" path="streetNumber" id="field-streetNumber"
						class="form-control" tabindex="5" maxlength="35" value="0"
						onfocus="(this.value == '0') && (this.value = '')"
						onblur="(this.value == '') && (this.value = '0')" />
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
				<label class="control-label" for="field-zipCode">Zip-Code*</label>
				<div class="controls">
					<form:input type="number" min="1000" max="9658" step="1"
						required="true" path="zipCode" id="field-zipCode"
						class="form-control" tabindex="6" maxlength="35" value="0"
						onfocus="(this.value == '0') && (this.value = '')"
						onblur="(this.value == '') && (this.value = '0')" />
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
				<label class="control-label" for="field-city">City*</label>
				<div class="controls">
					<form:input type="text" required="true" path="city" id="field-city"
						class="form-control" tabindex="7" maxlength="35"
						placeholder="City"
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
				<form:input type="number" min="0" max="1000" step="1" path="size"
					id="field-size" class="form-control" tabindex="8" maxlength="45"
					value="0" onfocus="(this.value == '0') && (this.value = '')"
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
				<form:input type="number" min="0" max="100" step="0.5"
					path="nrOfRooms" id="field-nrOfRooms" class="form-control"
					tabindex="9" maxlength="45" value="0"
					onfocus="(this.value == '0') && (this.value = '')"
					onblur="(this.value == '') && (this.value = '0')" />
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
					<form:input type="number" min="0" max="100000" step="1"
						path="netto" id="field-netto" class="form-control" tabindex="10"
						maxlength="35" value="0"
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
					<form:input type="number" min="0" max="100000" step="1"
						path="charges" id="field-charges" class="form-control"
						tabindex="10" maxlength="35" value="0"
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
				<form:input type="number" min="0" max="10" step="1"
					path="nrOfFlatMates" id="field-nrOfFlatMates" class="form-control"
					tabindex="11" maxlength="35" value="0"
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
				<form:input type="text" path="availableDate"
					id="field-availableDate" class="form-control" tabindex="12"
					maxlength="35" placeholder="DD-MM-YYYY"
					onfocus="(this.placeholder == 'DD-MM-YYYY') && (this.placeholder = '')"
					onblur="(this.placeholder == '') && (this.placeholder = 'DD-MM-YYYY')" />
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
							format: "dd-mm-yyyy"
						});
					});
				</script>
		</div>

		<div style="color: red">(* are mandatory fields!)</div>
	</div>

	<div class="col-md-6">
		<!-- middle column -->

		<div class="layout-content-column">
			<table id="fileTable">
				<tr>
					<td><form:input path="uploadedAdPictures" type="file" /></td>
				</tr>
			</table>
			<button id="addFile" type="button" onclick="addMore">Add
				more pictures</button>

			<!--  script for adding another file upload possibility -->
			<!--  needs to be placed within <form:form></form:form> -->

			<script>
				$(document).ready(function() {
					//add more file components if Add is clicked
					$('#addFile').click(function() {
						$('#fileTable').append('<tr><td>'
												+ '<form:input path="uploadedAdPictures" type="file"/>'
												+ '</td></tr>');
					});
				});
			</script>

			<c:set var="descriptionErrors">
				<form:errors path="description" />
			</c:set>
			<div
				class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
				<label class="control-label" for="field-description">Description*</label>
				<div class="controls">
					<form:textarea required="true" class="form-control"
						path="description" id="field-description"
						style="width:100%; height:160px; resize:none" tabindex="12"
						placeholder="Description"
						onfocus="(this.placeholder == 'Description') && (this.placeholder = '')"
						onblur="(this.placeholder == '') && (this.placeholder = 'Description')" />
					<form:errors path="description" cssClass="help-inline"
						element="span" />
					<br> <br>
				</div>
			</div>


		</div>
	</div>

	<div class="col-md-3">
		<!-- right column -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Visiting Dates</h3>
				<br>
				<h4>Leave empty for appointments only</h4>
			</div>

			<div class="panel-body">

				<table id="visitTable">
					<tr>
						<th>Date</th>
						<th>from</th>
						<th>to</th>
					</tr>

					<tr>
						<td><input type="text" name="visitDate[0]" id="dateInput0"
							size="10" tabindex="15" /></td>
						<td><input name="startTime[0]" size="4" tabindex="15" /></td>
						<td><input name="endTime[0]" size="4" tabindex="15" /></td>

						<!--if using type="date" it doesn't work in chrome because it wants to use the date-input type of html5
				that includes a date picker	wich doesn't work in firefox with the format mm/dd/yyyy, wich does not match 
				MM-DD-YYYY, wich is the format we specified. Result: unusable date, like 1009-07-06 or so-->


					</tr>
				</table>

				<button id="addVisit" type="button" onclick="addMore">Add
					another visit</button>

				<script>
					$(document).ready(function() {
						//add more file components if Add is clicked
						$('#addVisit').click(function() {
							var index = document.getElementById('visitTable').rows.length-1;
							$('#visitTable').append( '<tr><td><input type="text" name="visitDate['+index+']" id="dateInput'+index+'" size="10" tabindex="15"/></td>'
													+ '<td><input name="startTime['+index+']" size="4" tabindex="15"/></td>'
													+ '<td><input name="endTime['+index+']" size="4" tabindex="15"/></td></tr>');
						});
					});
					
					
				</script>

				<script type="text/javascript">
					// When the document is ready
					$(document).ready(function() {
						$('#dateInput0').datepicker({ format: "dd-mm-yyyy" });
					});
				</script>


			</div>
		</div>
	</div>
	<div class="col-md-3">
		<!-- right column -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Flatmates</h3>
				<br>
			</div>

			<div class="panel-body">
				<table id="flatmateTable">
					<tr>
						<th>Name</th>

					</tr>
					<tr>
						<td><input name="flatmateList[0]" size="4" tabindex="16" /></td>
					</tr>
				</table>

				<button id="addFlatmate" type="button" onclick="addMore">Add
					another flatmate</button>

				<script>
					$(document).ready(function() {
						//add more file components if Add is clicked
						$('#addFlatmate').click(function() {
							var index = document.getElementById('flatmateTable').rows.length-1;
							$('#flatmateTable').append( '<tr><td><input name="flatmateList['+index+']" size="4" tabindex="16" /></td></tr>');
						});
					});
				</script>
			</div>
		</div>
	</div>
				<div class="form-actions">
				<button type="submit" class="btn btn-primary" tabindex="13">Create
					Ad</button>
				<!-- 				<input type="reset" value="Reset"> -->
				<a type="button" href="${pageContext.request.contextPath}/my-page"
					tabindex="14" class="btn btn-default" onclick="return showAlert()">Cancel</a>
			</div>
</form:form>

<script type="text/javascript">
	var zip = document.getElementById("field-zipCode");
	zip.addEventListener("blur", zipToCity, false);
</script>

    <SCRIPT type="text/javascript">
        function addRow(tableID) {
 
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 
            var cell1 = row.insertCell(0);
            var element1 = document.createElement("input");
            element1.type = "checkbox";
            element1.name="chkbox[]";
            cell1.appendChild(element1);
 
            var cell2 = row.insertCell(1);
            var element2 = document.createElement("input");
            element2.type = "text";
            element2.name = "txtbox[]";
            cell3.appendChild(element2);
 
            var cell3 = row.insertCell(2);
            var element2 = document.createElement("input");
            element2.type = "text";
            element2.name = "txtbox[]";
            cell3.appendChild(element2);
 
 
        }
 
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
 
    </SCRIPT>

 

 
    <TABLE id="dataTable" >
        
        <tr><th><th>Date</th><th>from</th><th>to<th><th></th></tr>
        <TR>
            <TD><INPUT type="checkbox" name="chk"/></TD>

            <TD> <INPUT type="date" /> </TD>
            <TD> <INPUT type="time" /> </TD>
            <TD> <INPUT type="time" /> </TD>
        </TR>
    </TABLE>
    <INPUT type="button" value="Add visit" onclick="addRow('dataTable')" />
 
    <INPUT type="button" value="Delete selected visit" onclick="deleteRow('dataTable')" />


<c:if test="${page_error != null }">
	<div class="alert alert-error">
		<button type="button" class="close" data-dismiss="alert">&times;</button>
		<h4>Error!</h4>
		${page_error}
	</div>
</c:if>

<c:import url="template/footer.jsp" />