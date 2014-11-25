
<p id="plz"></p>
<script src="jquery.csv-0.71.js">
	$.ajax({
		url : "files/plz.csv",
		async : false,
		success : function(csvd) {
			data = $.csv.toArrays(csvd);
		},
		dataType : "text",
		complete : function() {
			document.getElementById("plz").innerHTML = data[0][0];
		}
	});
</script>

<p id="demo"></p>

<script>
	var cars = [ "Saab", "Volvo", "BMW" ];
	document.getElementById("demo").innerHTML = cars[0];
</script>

<script>
	var tt = document.getElementById("field-zipCode");

	function checkIt() {
		if (tt.value != "z") {
			alert("wrong! You should have typed z.");
			return false;
		} else {
			alert('good');
			return true;
		}
	}

	tt.addEventListener("blur", checkIt, false);
</script>

<c:forEach items="${zipCityAsArray}" var="zipCity">
	<c:if test="${zipCity.zip==2504}">
		<c:out value="${zipCity.city}"></c:out>
	</c:if>
</c:forEach>











<script type="text/javascript">

	var zip = document.getElementById("field-zipCode");
	zip.addEventListener("blur", zipToCity, false);

	function zipToCity() {
		var field = document.getElementById("field-city");
	
		for (var i = 0; i < 5; i++) {
			if ("${zipCityAsArray[1].zip==zip.value}") {
				field.value = "${zipCityAsArray[1].city}";
			}
		}
		return true;
	}
</script>

