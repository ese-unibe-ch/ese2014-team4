<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />
<div id="masthead">
	<div class="container">
		<div class="row">
			<div>
				<h1>My Page</h1>
				<hr>
			</div>
		</div>
	</div>
	<!--/container-->
</div>
<!--/masthead-->

<div class="row">

	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>My Profile</h3>
			</div>
			<div class="panel-body">
				<c:import url="embedded/profile.jsp" />
				
				<div class="form-actions col-md-3">
					<a type="button"
						href="${pageContext.request.contextPath}/modifyProfile"
						class="btn btn-primary">Modify Profile</a>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>My Bookmarks</h3>
			</div>
			<div class="panel-body">
				<c:import url="searchResultsList.jsp" />
			</div>
		</div>
	</div>
	<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-heading">
				<h3>My Ads</h3>
		</div>
		<div class="panel-body">
			<c:import url="embedded/myAdsList.jsp" />
		</div>
	</div>
	</div>
<!-- shows all visit dates of all my ads, including visitors -->
	<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-heading">
				<h3>My Visits</h3>
		</div>
		<div class="panel-body">
		</div>

	<hr>


		

		
	</div>
	</div>	
	</div>



<c:import url="template/footer.jsp" />