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

		var availableDate = document.getElementById("field-availableDate").value;
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
						return false;
					}

					if ((lyear == true) && (dd > 29)) {
						alert('Not leap year:\nFebruary has only 29 days!');
						return false;
					}
				}
			}
		}
		storeValues();
		return (checkCityZipField());
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

	function checkZip() {
		var zip = document.getElementById("field-cityOrZip");

		if (isNumber(zip.value) && zip.value.length != 4) {
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
		autofillSearchInputs();
	});

	function disableFieldInSearch() {
		if (document.getElementById("room").checked == true) {
			$('#field-minNrOfFlatMates').prop('readonly', false);
			$('#field-maxNrOfFlatMates').prop('readonly', false);
		}

		if (document.getElementById("flat").checked == true) {
			$('#field-minNrOfFlatMates').prop('readonly', true);
			$('#field-maxNrOfFlatMates').prop('readonly', true);
		}
	}
</script>

<script type="text/javascript">
	function autofillMaxPrice() {
		var minPrice = parseInt(document.getElementById("field-minPrice").value);
		var maxPrice = document.getElementById("field-maxPrice");

		if (minPrice > 0) {
			maxPrice.min = minPrice;
		}

		return true;
	}
</script>

<script type="text/javascript">
	function autofillMaxNrOfRooms() {
		var minNrOfRooms = parseInt(document
				.getElementById("field-minNrOfRooms").value);
		var maxNrOfRooms = document.getElementById("field-maxNrOfRooms");

		if (minNrOfRooms > 0) {
			maxNrOfRooms.min = minNrOfRooms;
		}

		return true;
	}
</script>

<script type="text/javascript">
	function autofillMaxNrOfFlatMates() {
		var minNrOfFlatMates = parseInt(document
				.getElementById("field-minNrOfFlatMates").value);
		var maxNrOfFlatMates = document
				.getElementById("field-maxNrOfFlatMates");

		if (minNrOfFlatMates > 0) {
			maxNrOfFlatMates.min = minNrOfFlatMates;
		}

		return true;
	}
</script>


<script type="text/javascript">
	function getCookie(name) {
		var re = new RegExp(name + "=([^;]+)");
		var value = re.exec(document.cookie);

		return (value != null) ? unescape(value[1]) : null;
	}

	var today = new Date();
	var expiry = new Date(today.getTime() + 30 * 24 * 3600 * 1000);
	var expired = new Date(today.getTime() - 24 * 3600 * 1000);

	function setCookie(name, value) {
		document.cookie = name + "=" + escape(value) + "; path=/; expires="
				+ expiry.toGMTString();
	}

	function deleteCookie(name) {
		document.cookie = name + "=null; path=/; expires="
				+ expired.toGMTString();
	}

	function storeValues() {
		setCookie("field1", document.getElementById("field-cityOrZip").value);
		setCookie("field2", document.getElementById("field-minPrice").value);
		setCookie("field3", document.getElementById("field-maxPrice").value);
		setCookie("field4", document.getElementById("field-minNrOfRooms").value);
		setCookie("field5", document.getElementById("field-maxNrOfRooms").value);
		setCookie("field6", document.getElementById("field-minNrOfFlatMates").value);
		setCookie("field7", document.getElementById("field-maxNrOfFlatMates").value);
		setCookie("field8", document.getElementById("field-availableDate").value);
		setCookie("field9", document.getElementById("dropDown").value);

		return true;
	}
</script>

<script type="text/javascript">
	function autofillSearchInputs() {
		if (field1 = getCookie("field1")) {
			document.getElementById("field-cityOrZip").value = field1;
			deleteCookie("field1");
		}

		if (field2 = getCookie("field2")) {
			document.getElementById("field-minPrice").value = field2;
			deleteCookie("field2");
		}

		if (field3 = getCookie("field3")) {
			document.getElementById("field-maxPrice").value = field3;
			deleteCookie("field3");
		}

		if (field4 = getCookie("field4")) {
			document.getElementById("field-minNrOfRooms").value = field4;
			deleteCookie("field4");
		}

		if (field5 = getCookie("field5")) {
			document.getElementById("field-maxNrOfRooms").value = field5;
			deleteCookie("field5");
		}

		if (field6 = getCookie("field6")) {
			document.getElementById("field-minNrOfFlatMates").value = field6;
			deleteCookie("field6");
		}

		if (field7 = getCookie("field7")) {
			document.getElementById("field-maxNrOfFlatMates").value = field7;
			deleteCookie("field7");
		}

		if (field8 = getCookie("field8")) {
			document.getElementById("field-availableDate").value = field8;
			deleteCookie("field8");
		}
		
		if (field9 = getCookie("field9")) {
			document.getElementById("dropDown").value = field9;
			deleteCookie("field9");
		}

	}
</script>

