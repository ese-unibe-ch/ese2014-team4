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
		modelAttribute="searchForm"
		action="submitSearch"
		onSubmit="return checkSearchInput()" id="searchForm"
		cssClass="form-horizontal" autocomplete="off">
		<fieldset>

			<div class="col-md-12" style="padding-left: 0px; padding-right: 3px">

				<c:set var="adTypeErrors">
					<form:errors path="adType" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty adTypeErrors}"> error</c:if>"
					onclick="disableFieldInSearch()">
					<label class="control-label" for="field-adType">Type</label>
					<div class="radio">
						<label><form:radiobutton path="adType" id="room"
								tabindex="1" value="ROOM" checked="true" />Room</label> <label><form:radiobutton
								path="adType" id="flat" tabindex="2" value="FLAT" />Flat</label>
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
						<form:input class="form-control" path="cityOrZip" 
							id="field-cityOrZip" tabindex="3" maxlength="35"
							placeholder="City or Zip"
							onfocus="(this.placeholder == 'City or Zip') && (this.placeholder = '')"
							onblur="(this.placeholder == '') && (this.placeholder = 'City or Zip')" 
							x-moz-errormessage="Please enter a Zip or a City."/>
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
							<form:input type="number" min="0" max="10000000" step="100"
								class="form-control" path="minPrice" id="field-minPrice"
								tabindex="4" maxlength="35" value="0"
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
							<form:input type="number" min="0" max="10000000" step="100"
								class="form-control" path="maxPrice" id="field-maxPrice"
								tabindex="5" maxlength="35" value="0"
								onfocus="(this.value == '0') && (this.value = '')"
								onblur="(this.value == '') && (this.value = '0')" />
							<form:errors path="maxPrice" cssClass="help-inline"
								element="span" />
						</div>
					</div>
				</div>

				<div class="col-md-6" style="padding-left: 0px; padding-right: 3px">
					<c:set var="minNrOfRoomsErrors">
						<form:errors path="minNrOfRooms" />
					</c:set>
					<div
						class="control-group<c:if test="${not empty minNrOfRoomsErrors}">error</c:if>">
						<label class="control-label" for="field-minNrOfRooms">Nr of Rooms from: </label>
						<div class="controls">

							<form:input type="number" min="0" max="100" step="0.5"
								class="form-control" path="minNrOfRooms" id="field-minNrOfRooms"
								tabindex="6" maxlength="35" value="0"
								onfocus="(this.value == '0') && (this.value = '')"
								onblur="(this.value == '') && (this.value = '0')" />
							<form:errors path="minNrOfRooms" cssClass="help-inline"
								element="span" />
						</div>
					</div>
				</div>

				<div class="col-md-6" style="padding-left: 3px; padding-right: 0px">
				<c:set var="maxNrOfRoomsErrors">
						<form:errors path="maxNrOfRooms" />
					</c:set>
					<div
						class="control-group<c:if test="${not empty maxNrOfRoomsErrors}">error</c:if>">
						<label class="control-label" for="field-maxNrOfRooms">to:</label>
						<div class="controls">

							<form:input type="number" min="0" max="100" step="0.5"
								class="form-control" path="maxNrOfRooms" id="field-maxNrOfRooms"
								tabindex="6" maxlength="35" value="0"
								onfocus="(this.value == '0') && (this.value = '')"
								onblur="(this.value == '') && (this.value = '0')" />
							<form:errors path="maxNrOfRooms" cssClass="help-inline"
								element="span" />
						</div>
					</div>
				</div>


					<div class="col-md-6" style="padding-left: 0px; padding-right: 3px">
						<c:set var="minNrOfFlatMatesErrors">
							<form:errors path="minNrOfFlatMates" />
						</c:set>
						<div
							class="control-group<c:if test="${not empty minNrOfFlatMatesErrors}"> error</c:if>">
							<label class="control-label" for="field-minNrOfFlatMates">Nr of Flatmates from:</label>
							<div class="controls">
								<form:input type="number" min="0" max="100" step="1"
									class="form-control" path="minNrOfFlatMates"
									id="field-minNrOfFlatMates" tabindex="7" maxlength="35"
									value="0" onfocus="(this.value == '0') && (this.value = '')"
									onblur="(this.value == '') && (this.value = '0')" />
								<form:errors path="minNrOfFlatMates" cssClass="help-inline"
									element="span" />
							</div>
						</div>
					</div>
					
					<div class="col-md-6" style="padding-left: 3px; padding-right: 0px">
					<c:set var="maxNrOfFlatMatesErrors">
							<form:errors path="maxNrOfFlatMates" />
						</c:set>
						<div
							class="control-group<c:if test="${not empty maxNrOfFlatMatesErrors}"> error</c:if>">
							<label class="control-label" for="field-maxNrOfFlatMates">to:</label>
							<div class="controls">
								<form:input type="number" min="0" max="100" step="1"
									class="form-control" path="maxNrOfFlatMates"
									id="field-maxNrOfFlatMates" tabindex="7" maxlength="35"
									value="0" onfocus="(this.value == '0') && (this.value = '')"
									onblur="(this.value == '') && (this.value = '0')" />
								<form:errors path="maxNrOfFlatMates" cssClass="help-inline"
									element="span" />
							</div>
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
							<form:input type="text" class="form-control" path="availableDate"
								id="field-availableDate" tabindex="8" placeholder="DD-MM-YYYY" />
							<form:errors path="availableDate" cssClass="help-inline"
								element="span" />
							<br>
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
					
					 <tr>
            <td>Order Search Results By:</td>
            <td><form:select path="orderBy">
               <option value="newestFirst">newest first</option>
               <option value="availableDate">available date (earlier first)</option>
               <option value="price">Price (cheapest first)</option>               
                </form:select>
            </td>
        </tr>

					<span id="SearchErrorMessage"></span>

					<div class="form-actions">
						<br>
						<button type="submit" name="search" tabindex="9" class="btn btn-primary">Search
							Ad</button>
							<button type="submit" name="save" tabindex="9" class="btn btn-primary"> Save search</button>
						<!-- 					<button type="button" onclick="history.go(-1);return true" class=" btn" tabindex="7">Back</button> -->
						<button type="reset" tabindex="10" class="btn btn-default">Reset</button>
					</div>

				</div>
		</fieldset>
	</form:form>
	
<script type="text/javascript">
	var minPrice = document.getElementById("field-minPrice");
	minPrice.addEventListener("blur", autofillMaxPrice, false);
	minPrice.addEventListener("click", autofillMaxPrice, false);
	
	var minNrOfRooms = document.getElementById("field-minNrOfRooms");
	minNrOfRooms.addEventListener("blur", autofillMaxNrOfRooms, false);
	minNrOfRooms.addEventListener("click", autofillMaxNrOfRooms, false);
	
	var minNrOfFlatMates = document.getElementById("field-minNrOfFlatMates");
	minNrOfFlatMates.addEventListener("blur", autofillMaxNrOfFlatMates, false);
	minNrOfFlatMates.addEventListener("click", autofillMaxNrOfFlatMates, false);
</script>