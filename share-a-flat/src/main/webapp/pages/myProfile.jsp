<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />
<c:set var="userProfile" value="${user}"/>
<div class="container">
	<h1 align="center">My Profile</h1>
	<hr>
</div>
<fieldset>
	<div class="col-md-2"></div>

	<div class="col-md-3">
		<div class="text-center">
			<img
				src="${pageContext.request.contextPath}/imageController/profile/${user.id}"
				class="img-responsive" alt="profileImage">
		</div>
	</div>

	<!-- edit form column -->
	<div class="col-md-5 personal-info">
		<c:import url="embedded/profile.jsp" />
		<div class="col-md-12" align="right">
		<a type="button"
			href="${pageContext.request.contextPath}/modifyProfile"
			class="btn btn-primary">Modify Profile</a>
			</div>

	</div>
</fieldset>

<c:import url="template/footer.jsp" />