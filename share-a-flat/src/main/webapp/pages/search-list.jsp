<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />

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

<h1>Search List</h1>


<!-- Auswahlreiter -->

<ul>
	<li class="map"><a href="search-map" class="inactive"><span>Search Map</span></a></li>
</ul>

<!-- <div class="col-md-3"> -->
<%-- 	<c:import url="search-criteria.jsp" /> --%>
<!-- </div> -->

<div class="row">
	<div class="col-md-4">
 		<div class="panel panel-default">
 		
			<div class="panel-heading">
				<h3>Search-Criteria</h3>
			</div>
			
			<div class="panel-body">
				<c:import url="search-criteria.jsp" />
			</div>
			
 		</div>
	</div>

	<div class="col-md-8">
  		<div class="panel panel-default">
    		
    		<div class="panel-heading">
    			<h3>Newest Adds</h3>
    		</div>
    		
    		<div class="panel-body">
				<c:import url="resultsTable.jsp" />
    		</div>
    		
  		</div>
	</div>  
</div> 


<c:import url="template/footer.jsp" />