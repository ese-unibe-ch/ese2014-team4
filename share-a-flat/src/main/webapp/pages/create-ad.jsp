<%@ page language="java" import="javax.servlet.jsp.PageContext"
	pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />
<c:import url="functions/generalFunctions.jsp" />
<c:import url="functions/createAdFunctions.jsp" />


<div id="masthead">
	<div class="container">
		<div class="row">
			<div>

				<h1 align="center">${adCreationOrModification}</h1>

				<hr>
			</div>
		</div>
	</div>
</div>
<!--/container-->

<!--/masthead-->


<form:form enctype="multipart/form-data" method="post" modelAttribute="adForm" action="submitAd"
	onSubmit="return createFormIsValid()" id="adForm" cssClass="form-horizontal" autocomplete="off">

	<div class="col-md-3">

		<c:import url="embedded/adFormPage.jsp"></c:import>
		
		<div class="form-actions">
			<span class="error">${errorMessage}</span>

			<fieldset style="padding-left:376px" id="basicButtons">
				<button type="submit" class="btn btn-primary" tabindex="13"
					value="Create Ad">Save ad</button>
				<a type="button" href="${pageContext.request.contextPath}/myPage"
					tabindex="14" class="btn btn-default" onclick="return showAlert()">Cancel</a>
					
			</fieldset>
			

		</div>
	</div>

	<div class="col-md-3">
		<!-- right column -->
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Visiting Dates</h3>
				<br>
				<h4>Leave empty for appointments only</h4>
			</div>

			<div class="panel-body">
				<c:import url="embedded/addVisits.jsp"></c:import>
			</div>
		</div>
			<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Flatmates</h3>
				<br>
			</div>

			<div class="panel-body">
				<c:import url="embedded/addFlatmates.jsp"></c:import>
			</div>
		</div>
		
	</div>




</form:form>

<script type="text/javascript">
	var zip = document.getElementById("field-zipCode");
	zip.addEventListener("blur", zipToCity, false);
</script>


<c:import url="template/footer.jsp" />