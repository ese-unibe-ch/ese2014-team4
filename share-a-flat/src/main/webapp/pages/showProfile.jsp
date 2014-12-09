<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />

<div class="container">
	<h1 align="center">Profile of ${userProfile.username}</h1>
	<hr>
</div>



<div class="col-md-3">
	<div class="text-center">
		<img
			src="${pageContext.request.contextPath}/imageController/profile/${userProfile.id}"
			class="img-responsive" alt="profileImage">
	</div>
</div>


<!-- edit form column -->
<div class="col-md-5 personal-info">
	<c:import url="embedded/profile.jsp" />
</div>


<div class="col-md-4">
	<br>
	
	<c:set var="receiverName">
		<c:if test="${userProfile.username!=null}">${userProfile.username}</c:if>
	</c:set>
	
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