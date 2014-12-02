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

<fieldset>

<div class="col-md-2">
		
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
	<br><br>


<c:import url="embedded/profile.jsp" />

		<table>
			<tr>
				<td width="450">
					<div class="form-group">
						<label class="col-lg-5 control-label"></label>
						<div class="col-lg-5">
							<button type="button" onclick="history.go(-1);return true"
								class=" btn btn-primary" tabindex="7">Go Back</button>
						</div>
						<br>
					</div>
				</td>
			</tr>
		</table>
	</div>
</fieldset>
<hr>

<script>
	function goBack() {
		window.history.back()
	}
</script>



<c:import url="template/footer.jsp" />