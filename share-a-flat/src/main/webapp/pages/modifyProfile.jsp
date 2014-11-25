<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:import url="functions/generalFunctions.jsp" />
<c:import url="template/header.jsp" />



<script type="text/javascript">                
	function isValid() {
		var email = document.forms["profileForm"]["field-email"].value;
	    var userName = document.forms["profileForm"]["field-username"].value;
	    var pwd = document.forms["profileForm"]["field-password"].value;
	    var pwdRepeated = document.forms["profileForm"]["field-passwordRepeated"].value;
	    var oldPwd = document.forms["profileForm"]["field-oldPassword"].value;
		var mailRegex = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
	    
		if (!mailRegex.test(email)) {
	    	alert("Please enter a valid Email (E.g. example@example.example)");
	    	return false;
	    }
	    
		if(oldPwd!=profile.password){
			alert("Old Password was wrong!)")
			return false;
		}
		
	    if (pwd!=pwdRepeated) {
	    	alert("Reentered Password doesn't match!")
	    	return false;
	    }
	}
	
	function isRightPassword(){
    	return pwd == user.password;
    }
</script>



<div class="container">
	<h1>Edit Profile</h1>
	<hr>
	<div class="row">
		<!-- left column -->
		<!-- enctyp="multipart/form-data": enables MultipartFile-upload -->


		<form:form enctype="multipart/form-data" method="post"
			modelAttribute="profileForm" action="saveProfile"
			onsubmit="return isValid()" id="profileForm"
			cssClass="form-horizontal" autocomplete="off">


			<fieldset>
				<div class="col-md-3">
					<div class="text-center">
						<img
							src="${pageContext.request.contextPath}/imageController/profile/${user.profile.id}"
							class="img-responsive" alt="profileImage">
						<h6>Upload a different photo...</h6>

						<form:input path="uploadedProfileImage" type="file" />
					</div>
				</div>



				<!-- edit form column -->
				<div class="col-md-9 personal-info">
					<div class="alert alert-info alert-dismissable">Username,
						Email, Password can't be changed yet.</div>



					<legend>Personal info</legend>

					<c:set var="usernameErrors">
						<form:errors path="username" />
					</c:set>
					<div
						class="form-group<c:if test="${not empty usernameErrors}"> error</c:if>">
						<label class="col-lg-3 control-label">Username:</label>
						<div class="col-lg-8">
							<form:input path="username" class="form-control"
								value="${user.username}" type="text" tabindex="1" />
							<form:errors path="username" cssClass="help-inline"
								element="span" />
						</div>
					</div>



					<c:set var="emailErrors">
						<form:errors path="email" />
					</c:set>
					<div class="form-group">
						<label class="col-lg-3 control-label">Email:</label>
						<div class="col-lg-8">
							<form:input path="email" class="form-control"
								value="${user.email}" type="text" tabindex="2" />
							<form:errors path="email" cssClass="help-inline" element="span" />
						</div>
					</div>


					<!-- 
          <c:set var="passwordErrors"><form:errors path="oldPassword"/></c:set>
	        <div class="form-group<c:if test="${not empty passwordErrors}">error</c:if>">
	            <label class="col-lg-3 control-label" for="field-oldPassword">Old Password:</label>
	            <div class="col-lg-8">
	                <form:input path="oldPassword" class="form-control"  id="field-oldPassword" tabindex="3" maxlength="35" placeholder="Password" />
	                <form:errors path="oldPassword" cssClass="help-inline" element="span"/>
	            </div>
	        </div>
	        
	        -->

					<!-- TODO password does not work yet (is in wrong format) -->

					<c:set var="passwordErrors">
						<form:errors path="password" />
					</c:set>
					<div
						class="form-group<c:if test="${not empty passwordErrors}">error</c:if>">
						<label class="col-lg-3 control-label" for="field-password">New
							Password:</label>
						<div class="col-lg-8">
							<form:password path="password" class="form-control"
								id="field-password" tabindex="3" maxlength="35"
								placeholder="Password" />
							<form:errors path="password" cssClass="help-inline"
								element="span" />
						</div>
					</div>


					<div
						class="form-group<c:if test="${not empty passwordRepeatedErrors}"> error</c:if>">
						<label class="col-lg-3 control-label" for="field-passwordRepeated">Repeat
							new password:</label>
						<div class="col-lg-8">
							<form:password path="passwordRepeated" class="form-control"
								id="field-passwordRepeated" tabindex="4" maxlength="35"
								placeholder="Repeat password" />
							<form:errors path="passwordRepeated" cssClass="help-inline"
								element="span" />
						</div>
					</div>





					<c:set var="phoneNumberErrors">
						<form:errors path="phoneNumber" />
					</c:set>
					<div
						class="form-group<c:if test="${not empty phoneNumberErrors}"> error</c:if>">
						<label class="col-lg-3 control-label" for="field-phoneNumber">phoneNumber:</label>
						<div class="col-lg-8">
							<form:input class="form-control" path="phoneNumber"
								id="field-phoneNumber" type="number" min="" max="9999999999999"
								step="1" pattern="[0-9]{0,13}" tabindex="5" maxlength="45"
								value="${user.profile.phoneNumber}" placeholder="phone number" />
							<form:errors path="phoneNumber" cssClass="help-inline"
								element="span" />
						</div>
					</div>

					<c:set var="ageErrors">
						<form:errors path="age" />
					</c:set>
					<div
						class="form-group<c:if test="${not empty ageErrors}"> error</c:if>">
						<label class="col-lg-3 control-label" for="field-age">Age:</label>
						<div class="col-lg-8">
							<form:input type="number" min="10" max="120" step="1"
								class="form-control" path="age" id="field-age" tabindex="6"
								maxlength="45" value="${user.profile.age}" />
							<form:errors path="age" cssClass="help-inline" element="span" />
						</div>
					</div>

					<!-- sets current_profile sex -->
					<c:set var="checkedM" value="" />
					<c:if test="${user.profile.sex eq 'M'}">
						<c:set var="checkedM" value="checked" />
					</c:if>

					<c:set var="checkedF" value="" />
					<c:if test="${user.profile.sex eq 'F'}">
						<c:set var="checkedF" value="checked" />
					</c:if>

					<c:set var="sexErrors">
						<form:errors path="sex" />
					</c:set>
					<div
						class="form-group<c:if test="${not empty sexErrors}"> error</c:if>">
						<label class="col-lg-3 control-label" for="field-sex">Sex:</label>
						<div class="radio">
							<label><input type="radio" name="sex" id="male"
								tabindex="7" value="M" ${checkedM}>Male</label> <label><input
								type="radio" name="sex" id="female" tabindex="8" value="F"
								${checkedF}>Female</label><br>
							<br>
						</div>
					</div>


					<div class="form-group">
						<label class="col-lg-3 control-label">Description:</label>
						<div class="col-lg-8">
							<form:input class="form-control"
								value="${user.profile.userDescription}" type="text"
								path="userDescription" tabindex="8"
								placeholder="describe yourself" />
							<form:errors path="userDescription" cssClass="help-inline"
								element="span" />
						</div>
					</div>



					<div class="form-group">
						<label class="col-md-3 control-label"></label>
						<div class="col-md-8">
							<button type="submit" value="saveProfile" tabindex="6"
								class="btn btn-primary">Save Profile</button>
							<!--             <input type="reset" value="Reset"> -->
							<a type="button" href="${pageContext.request.contextPath}/myPage"
								onclick="return showAlert()" tabindex="7"
								class="btn btn-default">Cancel</a>
						</div>
					</div>
			</fieldset>
		</form:form>


	</div>
</div>
</div>
<hr>

<c:import url="template/footer.jsp" />