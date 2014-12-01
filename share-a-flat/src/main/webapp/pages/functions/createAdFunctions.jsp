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
	function createFormIsValid() {

		var nrOfRooms = document.getElementById("field-nrOfRooms").value;
		var availableDate = document.forms["adForm"]["field-availableDate"].value;
		var visitDate = document.getElementById("dateInput0").value;

		if (availableDate != "") {
			if (!availableDate
					.match(/^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\-]\d{4}$/)) {
				alert("Please enter a valid available Date (E.g. 01-01-2000)");
				document.getElementById("field-availableDate").focus();
				return false;
			} else {
				var pdate = availableDate.split('-');

				var dd = parseInt(pdate[0]);
				var mm = parseInt(pdate[1]);
				var yy = parseInt(pdate[2]);

				// Create list of days of a month [assume there is no leap year by default]  
				var ListofDays = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
						31 ];

				if (mm == 1 || mm > 2) {
					if (dd > ListofDays[mm - 1]) {
						alert('Invalid Date!\nBe careful how many days a month has!');
						document.getElementById("field-availableDate").focus();
						return false;
					}
				}

				if (mm == 2) {
					var lyear = false;

					if ((!(yy % 4) && yy % 100) || !(yy % 400)) {
						lyear = true;
					}

					if ((lyear == false) && (dd >= 29)) {
						alert('Leap year:\nFebruary only has 28 days!');
						document.getElementById("field-availableDate").focus();
						return false;
					}

					if ((lyear == true) && (dd > 29)) {
						alert('Not leap year:\nFebruary has only 29 days!');
						document.getElementById("field-availableDate").focus();
						return false;
					}
				}
			}
		}

		if (visitDate != "") {
			if (!visitDate
					.match(/^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\-]\d{4}$/)) {
				alert("Please enter a valid visit Date (E.g. 01-01-2000)");
				document.getElementById("field-visitDate").focus();
				return false;
			} else {
				var pdate = visiteDate.split('-');

				var dd = parseInt(pdate[0]);
				var mm = parseInt(pdate[1]);
				var yy = parseInt(pdate[2]);

				// Create list of days of a month [assume there is no leap year by default]  
				var ListofDays = [ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
						31 ];

				if (mm == 1 || mm > 2) {
					if (dd > ListofDays[mm - 1]) {
						alert('Invalid Date!\nBe careful how many days a month has!');
						return false;
					}
				}

				if (mm == 2) {
					var lyear = false;

					if ((!(yy % 4) && yy % 100) || !(yy % 400)) {
						lyear = true;
					}

					if ((lyear == false) && (dd >= 29)) {
						alert('Leap year:\nFebruary only has 28 days!');
						document.getElementById("field-visitDate").focus();
						return false;
					}

					if ((lyear == true) && (dd > 29)) {
						alert('Not leap year:\nFebruary has only 29 days!');
						document.getElementById("field-visitDate").focus();
						return false;
					}
				}
			}
		}
		return true;
	}
</script>

<script>
	function showAlert() {
		var cancelYes = confirm("Cancel and discard all?");
		if (cancelYes == true) {
			//alert("User wants to continue!");
			return true;
		} else {
			//alert("User does not want to continue!");
			return false;
		}
		//return true;
	}
</script>

<script type="text/javascript">
	function disableFieldInCreateAd() {
		if (document.getElementById("room").checked == true) {
			$('#field-nrOfFlatMates').prop('disabled', false);
		}

		if (document.getElementById("flat").checked == true) {
			$('#field-nrOfFlatMates').prop('disabled', true);

		}

	}
</script>

<script type="text/javascript">
$(document).ready(function() {
	checkAdOwnerAndPrincipal();	
});

checkAdOwnerAndPrincipal() {
	var owner = "$adData.owner.username";
	var principal = "$user";
	
	if (owner == principal) {
		document.getElementById("field-title").value="$adData.title";
		
		if ("$adData.adType" == 'ROOM'){
			document.getElementById("field-room").checked=true;
			document.getElementById("field-flat").checked=false;
		}
		else {
			document.getElementById("field-room").checked=false;
			document.getElementById("field-flat").checked=true;	
		}
		
		document.getElementById("field-street").value="$adData.address.street";
		document.getElementById("field-streetNumber").value="$adData.address.streetNumber";
		document.getElementById("field-zipCode").value="$adData.address.zipCode";
		document.getElementById("field-size").value="$adData.size";
		document.getElementById("field-nrOfRooms").value="$adData.nrOfRooms";
		document.getElementById("field-netto").value="$adData.netto";
		document.getElementById("field-charges").value="$adData.charges";
		document.getElementById("field-nrOfFlatMates").value="$adData.nrOfFlatMates";
		document.getElementById("field-availableDate").value="$adData.availableDate";
		document.getElementById("field-description").value="$adData.description";
		
	}
	
	return true;
}
</script>

<script type="text/javascript">
	function zipToCity() {
		var field = document.getElementById("field-city");

		<c:forEach items="${zipCityAsArray}" var="item">

		var zipFromObj = parseInt("${item.zip}");
		if (zipFromObj == zip.value) {
			field.value = "${item.city}"; //do not disable cityfield! otherwise city does not get saved!
			$('#field-city').prop('readonly', true);
		}
		</c:forEach>

		if (field.value == "") {
			field.value = "no city found";
			zip.value = "";
			zip.focus();
		}
		return true;
	}
</script>

