<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">

$(document).ready(function() {
	autofillSearchInputs();
});

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
		setCookie("field1", document.getElementById("field-phoneNumber").value);
		setCookie("field2", document.getElementById("field-age").value);
		setCookie("field3", document.getElementById("male").value);
		setCookie("field4", document.getElementById("female").value);
		setCookie("field5", document.getElementById("field-description").value);

		return true;
	}
</script>

<script type="text/javascript">
	function autofillSearchInputs() {
		if (field1 = getCookie("field1")) {
			document.getElementById("field-phoneNumber").value = field1;
			deleteCookie("field1");
		}

		if (field2 = getCookie("field2")) {
			document.getElementById("field-age").value = field2;
			deleteCookie("field2");
		}

		if (field3 = getCookie("field3")) {
			document.getElementById("male").value = field3;
			deleteCookie("field3");
		}

		if (field4 = getCookie("field4")) {
			document.getElementById("female").value = field4;
			deleteCookie("field4");
		}

		if (field5 = getCookie("field5")) {
			document.getElementById("field-description").value = field5;
			deleteCookie("field5");
		}
	}
</script>

