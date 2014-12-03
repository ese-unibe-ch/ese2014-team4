<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />

<div class="container">
	<h1 align="center">Profile of ${user.username}</h1>
	<hr>
</div>



<div class="col-md-3">
	<div class="text-center">
		<img
			src="${pageContext.request.contextPath}/imageController/profile/${user.profile.id}"
			class="img-responsive" alt="profileImage">
	</div>
</div>


<!-- edit form column -->
<div class="col-md-5 personal-info">
	<c:import url="embedded/profile.jsp" />
</div>


<div class="col-md-4">
	<br>
	
	<div class="alert alert-success" align="left" style="height: 50px">
		<h4>
			<u><b>Messaging:</b></u>
		</h4>
	</div>
	
	<div>
		<c:import url="embedded/sendMessageBox.jsp" />
	</div>

	<div class="col-md-12" align="right">
		<button type="button" onclick="history.go(-1);return true"
			class=" btn btn-warning" tabindex="7">Go Back</button>
	</div>
	
</div>

<hr>

<script>
	function goBack() {
		window.history.back()
	}
</script>



<c:import url="template/footer.jsp" />