<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">
	function FocusOnInput() {
		document.getElementById("field-cityOrZip").focus();
	}
</script>


<script type="text/javascript">
	
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


