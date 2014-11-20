
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
