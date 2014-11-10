<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />

<script type="text/javascript">
	function FocusOnInput() {
		document.getElementById("field-city").focus();
	}
</script>


<h1>Search List</h1>


<!-- Auswahlreiter -->

<ul>
	<li class="map"><a href="search-map" class="inactive"> <span>
				<!-- <img src="/neutral/imids/homegate/icon_tab_map.gif" />-->Auf
				Karte
		</span></a></li>
</ul>

<body onload="FocusOnInput()">




	<form:form method="post" modelAttribute="searchForm" action="search"
		onSubmit="return(f(this));" id="searchForm" cssClass="form-horizontal"
		autocomplete="off">
		<fieldset>
			<div class="col-md-3">

				<c:set var="cityErrors">
					<form:errors path="city" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty cityErrors}"> error</c:if>">
					<label class="control-label" for="field-city">City</label>
					<div class="controls">
						<form:input class="form-control" path="city" id="field-city"
							tabindex="1" maxlength="35" placeholder="City" />
						Or
						<form:errors path="city" cssClass="help-inline" element="span" />

						<c:set var="zipCodeErrors">
							<form:errors path="zipCode" />
						</c:set>
						<div
							class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
							<label class="control-label" for="field-zipCode">Zip-Code</label>
							<div class="controls">
								<form:input class="form-control" path="zipCode"
									id="field-zipCode" tabindex="2" maxlength="35"
									placeholder="Zip-Code" />
								<form:errors path="zipCode" cssClass="help-inline"
									element="span" />
							</div>
						</div>


					</div>
				</div>

				<script type="text/javascript">
				   var zip = document.getElementById("field-zipCode");
					var city = document.getElementById("field-city");

					function checkCity() {
						if (city.value == "" && zip.value == 0) {
							alert("You must enter a city or a zip!");
							city.focus();
							return false;
						} else {
							return true;
						}
					}
					city.addEventListener("blur", checkCity, false);
				</script>

				<div>
					<div class="col-md-6" style="padding-left: 0px; padding-right: 3px">
						<c:set var="minPriceErrors">
							<form:errors path="minPrice" />
						</c:set>
						<div
							class="control-group<c:if test="${not empty minPriceErrors}"> error</c:if>">
							<label class="control-label" for="field-minPrice">Min-Price</label>
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
							<label class="control-label" for="field-maxPrice">Max-Price</label>
							<div class="controls">
								<form:input class="form-control" path="maxPrice"
									id="field-maxPrice" tabindex="4" maxlength="35"
									placeholder="Max-Price" />
								<form:errors path="maxPrice" cssClass="help-inline"
									element="span" />

								<script type="text/javascript">
									var max = document
											.getElementById("field-maxPrice");
									var min = document
											.getElementById("field-minPrice");

									function checkMaxPrice() {
										if (max.value <= min.value) {
											alert("Max prive must be higher than min price (that's like basic math, dude..)");
											max.focus();
											return false;
										} else {
											return true;
										}
									}

									max.addEventListener("blur", checkMaxPrice,
											false);
								</script>

							</div>
						</div>
					</div>

				</div>

				<%--         <c:set var="titleErrors"><form:errors path="title"/></c:set> --%>
				<%--         <div class="control-group<c:if test="${not empty titleErrors}"> error</c:if>"> --%>
				<!--             <label class="control-label" for="field-title">Title</label> -->

				<!--             <div class="controls"> -->
				<%--                 <form:input class="form-control" path="title" id="field-title" tabindex="3" maxlength="45" placeholder="Title"/> --%>
				<%--                 <form:errors path="title" cssClass="help-inline" element="span"/> --%>
				<!--             </div> -->
				<!--         </div> -->



				<%--         <c:set var="streetNumberErrors"><form:errors path="streetNumber"/></c:set> --%>
				<%--         <div class="control-group<c:if test="${not empty streetNumberErrors}"> error</c:if>"> --%>
				<!--             <label class="control-label" for="field-streetNumber">StreetNumber</label> -->
				<!--             <div class="controls"> -->
				<%--                 <form:input class="form-control" path="streetNumber" id="field-streetNumber" tabindex="5" maxlength="35" placeholder="StreetNumber"/> --%>
				<%--                 <form:errors path="streetNumber" cssClass="help-inline" element="span"/> --%>
				<!--             </div> -->
				<!--         </div> -->



				<c:set var="nrOfRoomMatesErrors">
					<form:errors path="nrOfRoomMates" />
				</c:set>
				<div
					class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
					<label class="control-label" for="field-nrOfRoomMates">Number
						of RoomMates </label>
					<div class="controls">
						<form:input class="form-control" path="nrOfRoomMates"
							id="field-nrOfRoomMates"  
							 tabindex="5" maxlength="35"
							placeholder="Number of Roommates"/>
						<form:errors path="nrOfRoomMates" cssClass="help-inline"
							element="span" />							
						<br> <br>
					</div>
				</div>
				

				<div class="form-actions">
					<button type="submit" tabindex="6" class="btn btn-primary">Search
						Ad</button>
					<input type="button"
						onclick="location.href('http://localhost:8080/share-a-flat/my-page');"
						value="Cancel">
				</div>
			</div>
		</fieldset>
	</form:form>




	<c:import url="template/footer.jsp" />