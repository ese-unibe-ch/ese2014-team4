<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="functions/searchFunctions.jsp" />

<script type="text/javascript">
	function FocusOnInput() {
		document.getElementById("field-cityOrZip").focus();
	}
</script>


<body onload="FocusOnInput()">


	<form:form enctype="multipart/form-data" method="post"
		modelAttribute="searchForm" action="submitSearch?resultType=${resultType}"
		onSubmit="return checkSearchInput()" id="searchForm"
		cssClass="form-horizontal" autocomplete="off">
		<fieldset>

			<div class="col-md-12" style="padding-left: 0px; padding-right: 3px">

				<c:set var="adTypeErrors">
					<form:errors path="adType" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty adTypeErrors}"> error</c:if>"
					onclick="disableField()">
					<label class="control-label" for="field-adType">Type</label>
					<div class="radio">
						<label><form:radiobutton path="adType" id="room" tabindex="1" value="ROOM" checked="true" />Room</label> 
						<label><form:radiobutton path="adType" id="flat" tabindex="2" value="FLAT" />Flat</label>
					</div>
				</div>



				<c:set var="cityOrZipErrors">
					<form:errors path="cityOrZip" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty cityOrZipErrors}"> error</c:if>">
					<label class="control-label" for="field-cityOrZip">City or
						Zip</label>
					<div class="controls">
						<form:input class="form-control" path="cityOrZip" required="true"
							id="field-cityOrZip" tabindex="3" maxlength="35"
							placeholder="City or Zip"
							onfocus="(this.placeholder == 'City or Zip') && (this.placeholder = '')"
							onblur="(this.placeholder == '') && (this.placeholder = 'City or Zip')" />
						<form:errors path="cityOrZip" cssClass="help-inline"
							element="span" />
					</div>
				</div>


				<div class="col-md-6" style="padding-left: 0px; padding-right: 3px">
					<c:set var="minPriceErrors">
						<form:errors path="minPrice" />
					</c:set>
					<div
						class="control-group<c:if test="${not empty minPriceErrors}"> error</c:if>">
						<label class="control-label" for="field-minPrice">Min-Price</label>
						<div class="controls">
							<form:input type="number" min="0" max="10000" step="1" class="form-control" path="minPrice"
								id="field-minPrice" tabindex="4" maxlength="35" value="0"
								onfocus="(this.value == '0') && (this.value = '')"
								onblur="(this.value == '') && (this.value = '0')" />
							<form:errors path="minPrice" cssClass="help-inline"
								element="span" />
						</div>
					</div>
				</div>



				<div class="col-md-6" style="padding-left: 3px; padding-right: 0px">
					<c:set var="maxPriceErrors">
						<form:errors path="maxPrice" />
					</c:set>
					<div
						class="control-group<c:if test="${not empty maxPriceErrors}"> error</c:if>">
						<label class="control-label" for="field-maxPrice">Max-Price</label>
						<div class="controls">
							<form:input type="number" min="0" max="10000" step="1" class="form-control" path="maxPrice"
								id="field-maxPrice" tabindex="5" maxlength="35" value="0"
								onfocus="(this.value == '0') && (this.value = '')"
								onblur="(this.value == '') && (this.value = '0')" />
							<form:errors path="maxPrice" cssClass="help-inline"
								element="span" />
						</div>
					</div>
				</div>


				<c:set var="nrOfRoomsErrors">
					<form:errors path="nrOfRooms" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty nrOfRoomsErrors}">error</c:if>">
					<label class="control-label" for="field-nrOfRooms">Number of Rooms </label>
					<div class="controls">

						<form:input type="number" min="0" max="100" step="0.5" class="form-control" path="nrOfRooms"
							id="field-nrOfRooms" tabindex="6" maxlength="35" value="0"
							onfocus="(this.value == '0') && (this.value = '')"
							onblur="(this.value == '') && (this.value = '0')" disabled="true" />
						<form:errors path="nrOfRooms" cssClass="help-inline"
							element="span" />
					</div>
				</div>


				<c:set var="nrOfFlatMatesErrors">
					<form:errors path="nrOfFlatMates" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty nrOfFlatMatesErrors}"> error</c:if>">
					<label class="control-label" for="field-nrOfFlatMates">Number of Room Mates</label>
					<div class="controls">
						<form:input type="number" min="0" max="100" step="1" class="form-control" path="nrOfFlatMates"
							id="field-nrOfFlatMates" tabindex="7" maxlength="35" placeholder="number of room mates"
							 />
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
						Date:</label>
					<div class="controls">
						<form:input type="date" class="form-control" path="availableDate"
							id="field-availableDate" tabindex="8"
							/>
						<form:errors path="availableDate" cssClass="help-inline"
							element="span" />
						<br>
					</div>
				</div>

				<span id="SearchErrorMessage"></span>


				<div class="form-actions">
					<br>
					<button type="submit" tabindex="9" class="btn btn-primary">Search
						Ad</button>
					<!-- 					<button type="button" onclick="history.go(-1);return true" class=" btn" tabindex="7">Back</button> -->
					<button type="reset" tabindex="10" class="btn btn-default">Reset</button>
				</div>

			</div>




		</fieldset>
	</form:form>