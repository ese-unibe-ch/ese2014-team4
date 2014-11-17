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
		return (checkZip() && checkMaxPrice() && checkCityZipField());
	}
	
	function checkCityZipField() {
		var input = document.getElementById("field-cityOrZip");
		
		if (input.value.length == 0) {
			SearchErrorMessage = "Please enter at least a City or a Zip.";
			document.getElementById("SearchErrorMessage").innerHTML = SearchErrorMessage;
			input.focus();
			return false;
		} else
			return true;
	}
	
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

