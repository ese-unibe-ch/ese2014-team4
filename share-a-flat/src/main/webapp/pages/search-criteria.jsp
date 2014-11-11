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

<script>
function disableField(){
	if (document.getElementById("room").checked == true) {
		disableNrOfRooms();
		enableNrOfFlatMates();
	}
	
	if (document.getElementById("flat").checked == true){
		disableNrOfFlatMates();
		enableNrOfRooms();
	}
}

function disableNrOfRooms() {
    document.getElementById("field-nrOfRooms").disabled = true;
}

function disableNrOfFlatMates() {
    document.getElementById("field-nrOfFlatMates").disabled = true;
}

function enableNrOfRooms() {
    document.getElementById("field-nrOfRooms").disabled = false;
}

function enableNrOfFlatMates() {
    document.getElementById("field-nrOfFlatMates").disabled = false;
}


</script>

<body onload="FocusOnInput()">


	<form:form enctype="multipart/form-data" method="post" modelAttribute="searchForm" action="search"onSubmit="return checkMaxPrice()" id="searchForm" cssClass="form-horizontal"autocomplete="off">
		<fieldset>
			
	<div class="col-md-10" style="padding-left: 0px; padding-right: 3px">
						
			<c:set var="adTypeErrors"><form:errors path="adType"/></c:set>
        		<div class="control-group<c:if test="${not empty adTypeErrors}"> error</c:if>" onclick="disableField()">
           			<label class="control-label" for="field-adType">Type</label>
            		<div class="radio">
               			<label><form:radiobutton path="adType" id="room" tabindex="1" value="ROOM" checked="true" />Room</label>
                		<label><form:radiobutton path="adType" id="flat" tabindex="2" value="FLAT"/>Flat</label>
           			</div>
       	 		</div>		
						
			
				<c:set var="cityOrZipErrors"><form:errors path="cityOrZip" /></c:set>
				<div class="control-group<c:if test="${not empty cityOrZipErrors}"> error</c:if>">
					<label class="control-label" for="field-cityOrZip">City or Zip</label>
					<div class="controls">
						<form:input class="form-control" path="cityOrZip" id="field-cityOrZip"tabindex="3" maxlength="35" placeholder="cityOrZip" />
						<form:errors path="cityOrZip" cssClass="help-inline" element="span" />	
						<form:errors path="cityOrZip" cssClass="help-inline" element="span"/>
					</div>
				</div>
				
				
				<div class="col-md-6" style="padding-left: 0px; padding-right: 3px">
					<c:set var="minPriceErrors"><form:errors path="minPrice" /></c:set>
					<div class="control-group<c:if test="${not empty minPriceErrors}"> error</c:if>">
						<label class="control-label" for="field-minPrice">Min-Price</label>
						<div class="controls">
							<form:input class="form-control" path="minPrice"id="field-minPrice" tabindex="4" maxlength="35"placeholder="Min-Price"/>
							<form:errors path="minPrice" cssClass="help-inline"element="span" />
						</div>
					</div>
				</div>
				

				<div class="col-md-6" style="padding-left: 3px; padding-right: 0px">	
					<c:set var="maxPriceErrors"><form:errors path="maxPrice" /></c:set>
					<div class="control-group<c:if test="${not empty maxPriceErrors}"> error</c:if>">
						<label class="control-label" for="field-maxPrice">Max-Price</label>
						<div class="controls">
							<form:input class="form-control" path="maxPrice" id="field-maxPrice" tabindex="5" maxlength="35"placeholder="Max-Price" />
							<form:errors path="maxPrice" cssClass="help-inline" element="span" />
						</div>
					</div>
				</div>
					
				
				<c:set var="nrOfRoomsErrors"><form:errors path="nrOfRooms" /></c:set>
				<div class="control-group<c:if test="${not empty descriptionErrors}">error</c:if>">
					<label class="control-label" for="field-nrOfRooms">Number of Rooms </label>
					<div class="controls">
						<form:input class="form-control" path="nrOfRooms"id="field-nrOfRooms"tabindex="6" maxlength="35"placeholder="Number of Rooms" disabled = "true"/>
						<form:errors path="nrOfRooms" cssClass="help-inline"element="span" />							
					</div>
				</div>

				<c:set var="nrOfFlatMatesErrors"><form:errors path="nrOfFlatMates" /></c:set>
				<div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
					<label class="control-label" for="field-nrOfFlatMates">Number of Room Mates</label>
					<div class="controls">
						<form:input class="form-control" path="nrOfFlatMates" id="field-nrOfFlatMates" tabindex="7" maxlength="35" placeholder="Number of Flatmates" />
						<form:errors path="nrOfFlatMates" cssClass="help-inline" element="span" />							
						<br>
					</div>
				</div>
				
				
				<span id = "SearchErrorMessage"></span>				

				<div class="form-actions">
					<br>
					<button type="submit" tabindex="6" class="btn btn-primary">Search Ad</button>
					<button type="button" onclick="history.go(-1);return true" class=" btn" tabindex="14">Back</button>
					<input type="reset" value="Reset"><br>
					<input type="checkbox" value="Reset" ><br>
				</div>
	
	</div>
	
	
		
		
		</fieldset>		
	</form:form>