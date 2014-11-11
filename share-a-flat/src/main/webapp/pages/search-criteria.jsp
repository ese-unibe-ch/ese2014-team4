<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">
	function FocusOnInput() {
		document.getElementById("field-cityOrZip").focus();
	}
</script>

<script type="text/javascript">
	//SearchErrorMessage = "Hallo";
	//document.getElementById("SearchErrorMessage").innerHTML= SearchErrorMessage;
	function checkMaxPrice() {
		var max = document.getElementById("field-maxPrice");
		var min = document.getElementById("field-minPrice");
		if (max.value < min.value) {
			SearchErrorMessage = "Max price must be higher than min price (that's like basic math, dude..)";
			document.getElementById("SearchErrorMessage").innerHTML = SearchErrorMessage;
			max.focus();
			return false;
		} else
			return true;
	}
</script>

<body onload="FocusOnInput()">


	<form:form method="post" modelAttribute="searchForm" action="search"
		onSubmit="return checkMaxPrice()" id="searchForm"
		cssClass="form-horizontal" autocomplete="off">

		<c:set var="cityOrZipErrors">
			<form:errors path="cityOrZip" />
		</c:set>
		<div
			class="control-group<c:if test="${not empty cityOrZipErrors}"> error</c:if>">
			<label class="control-label" for="field-cityOrZip">City or
				Zip</label>
			<div class="controls">
				<form:input class="form-control" path="cityOrZip"
					id="field-cityOrZip" tabindex="1" maxlength="35"
					placeholder="CityOrZip" />
				<form:errors path="cityOrZip" cssClass="help-inline" element="span" />
				<form:errors path="cityOrZip" cssClass="help-inline" element="span" />
				<div>
					<div class="col-md-6" style="padding-left: 0px; padding-right: 3px">
						<c:set var="minPriceErrors">
							<form:errors path="minPrice" />
						</c:set>
						<div
							class="control-group<c:if test="${not empty minPriceErrors}"> error</c:if>">
							<label class="control-label" for="field-minPrice">Min-Price (CHF)</label>
							<div class="controls">
								<form:input class="form-control" path="minPrice"
									id="field-minPrice" tabindex="3" maxlength="35"
									placeholder="Min-Price" />
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
							<label class="control-label" for="field-maxPrice">Max-Price (CHF)</label>
							<div class="controls">
								<form:input class="form-control" path="maxPrice"
									id="field-maxPrice" tabindex="4" maxlength="35"
									placeholder="Max-Price" />
								<form:errors path="maxPrice" cssClass="help-inline"
									element="span" />
							</div>
						</div>
					</div>
				</div>

				<c:set var="nrOfRoomsErrors">
					<form:errors path="nrOfRooms" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
					<label class="control-label" for="field-nrOfRooms">Number
						of Rooms </label>
					<div class="controls">
						<form:input class="form-control" path="nrOfRooms"
							id="field-nrOfRooms" tabindex="5" maxlength="35"
							placeholder="Number of Rooms" />
						<form:errors path="nrOfRooms" cssClass="help-inline"
							element="span" />
					</div>

					<c:set var="nrOfFlatMatesErrors">
						<form:errors path="nrOfFlatMates" />
					</c:set>
					<div
						class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
						<label class="control-label" for="field-nrOfFlatMates">Number
							of Flat Mates </label>
						<div class="controls">
							<form:input class="form-control" path="nrOfFlatMates"
								id="field-nrOfFlatMates" tabindex="5" maxlength="35"
								placeholder="Number of Flatmates" />
							<form:errors path="nrOfFlatMates" cssClass="help-inline"
								element="span" />
							<br>
						</div>
					</div>

					<span id="SearchErrorMessage"></span>

					<div class="form-actions">
						<br>
						<button type="submit" tabindex="6" class="btn btn-primary">Search
							Ad</button>
						<a type="button" href="${pageContext.request.contextPath}/home" tabindex="7" class="btn btn-default">Cancel</a>
					</div>
				</div>
			</div>
		</div>

	</form:form>