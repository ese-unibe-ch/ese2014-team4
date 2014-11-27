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
	
	function checkSearchInput() {
		return (checkMaxPrice() && checkCityZipField());
	}
	
// 	function checkCityZipField() {
// 		var input = document.getElementById("field-cityOrZip");
		
// 		if (input.value.length == 0) {
// 			SearchErrorMessage = "Please enter at least a City or a Zip.";
// 			document.getElementById("SearchErrorMessage").innerHTML = SearchErrorMessage;
// 			input.focus();
// 			return false;
// 		} else
// 			return true;
// 	}
	
	function checkMaxPrice() {
		var max = document.getElementById("field-maxPrice");
		var min = document.getElementById("field-minPrice");
		if (max.value < min.value) {
			SearchErrorMessage = "Max price must be higher than min price.";
			document.getElementById("SearchErrorMessage").innerHTML = SearchErrorMessage;
			max.focus();
			return false;
		} else
			return true;
	}

	
	function checkZip() {
		var zip = document.getElementById("field-cityOrZip");

		
		if (isNumber(zip.value) && zip.value.length!=4) {
			SearchErrorMessage = "Zip Code needs to be 4 digits.";
			document.getElementById("SearchErrorMessage").innerHTML = SearchErrorMessage;
			zip.focus();
			return false;
		} else
			return true;
	}
	
	function isNumber(n) {
		  return !isNaN(parseFloat(n)) && isFinite(n);
		}
	
	
</script>

<script>
$(document).ready(function() {
	disableFieldInSearch();	
});

function disableFieldInSearch() {
	if (document.getElementById("room").checked == true) {
		$('#field-minNrOfFlatMates').prop('disabled', false);
		$('#field-maxNrOfFlatMates').prop('disabled', false);
	}
	
	if (document.getElementById("flat").checked == true){
		$('#field-minNrOfFlatMates').prop('disabled', true);
		$('#field-maxNrOfFlatMates').prop('disabled', true);
	}
}

</script>

<script type="text/javascript">
function autofillMaxPrice() {
	var minPrice = parseInt(document.getElementById("field-minPrice").value);
	var maxPrice = document.getElementById("field-maxPrice");
	
	if (minPrice > 0) {		
		maxPrice.value = minPrice;
	}
	
	return true;
}
</script>

<script type="text/javascript">
// function autofillMinPrice() {
// 	var maxPrice = parseInt(document.getElementById("field-maxPrice").value);
// 	var minPrice = document.getElementById("field-minPrice");

// 	if (maxPrice < parseInt(minPrice)) {		
// 		minPrice.value = maxPrice;
// 	}
	
// 	return true;
// }
</script>

<script type="text/javascript">
function autofillMaxNrOfRooms() {
	var minNrOfRooms = parseInt(document.getElementById("field-minNrOfRooms").value);
	var maxNrOfRooms = document.getElementById("field-maxNrOfRooms");
	
	if (minNrOfRooms > 0) {	
		maxNrOfRooms.value = minNrOfRooms;
	}
	
	return true;
}
</script>

<script type="text/javascript">
// function autofillMinNrOfRooms() {
// 	var maxNrOfRooms = parseInt(document.getElementById("field-maxNrOfRooms").value);
// 	var minNrOfRooms = document.getElementById("field-minNrOfRooms");
	
// 	if (minNrOfRooms > parseInt(maxNrOfRooms)) {	
// 		minNrOfRooms.value = maxNrOfRooms;
// 	}
	
// 	return true;
// }
</script>

<script type="text/javascript">
function autofillMaxNrOfFlatMates() {
	var minNrOfFlatMates = parseInt(document.getElementById("field-minNrOfFlatMates").value);
	var maxNrOfFlatMates = document.getElementById("field-maxNrOfFlatMates");
	
	if (minNrOfFlatMates > 0) {	
		maxNrOfFlatMates.value = minNrOfFlatMates;
	}
	
	return true;
}
</script>

<script type="text/javascript">
// function autofillMinNrOfFlatMates() {
// 	var maxNrOfFlatMates = parseInt(document.getElementById("field-maxNrOfFlatMates").value);
// 	var minNrOfFlatMates = document.getElementById("field-minNrOfFlatMates");
	
// 	if (minNrOfFlatMates > maxNrOfFlatMates) {	
// 		minNrOfFlatMates.value = maxNrOfFlatMates;
// 	}
	
// 	return true;
// }
</script>





