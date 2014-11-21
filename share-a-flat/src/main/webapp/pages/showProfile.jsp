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
				<h1></h1>
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
				<h3></h3>
			</div>
			<div class="panel-body">
				<a href="createAd" class="inactive"><span>Create Ad</span></a>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Profile</h3>
			</div>
			<div class="panel-body">
				<c:import url="embedded/profile.jsp" />
				<br> <br>


			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3></h3>
			</div>
			<div class="panel-body">
			<c:import url="embedded/sendMessageBox.jsp" />
			</div>
		</div>
	</div>
</div>


<c:import url="template/footer.jsp" />