<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:import url="functions/generalFunctions.jsp" /> 
<c:import url="template/header.jsp" />

<div class="container">
    <h1>Edit Profile</h1>
  	<hr>
	<div class="row">
      <!-- left column -->
      <!-- enctyp="multipart/form-data": enables MultipartFile-upload -->
    <form:form enctype="multipart/form-data" method="post" modelAttribute="profileForm" action="saveProfile" id="profileForm" cssClass="form-horizontal"  autocomplete="off">
    <fieldset>
      <div class="col-md-3">
        <div class="text-center">
          <img src="${pageContext.request.contextPath}/imageController/profile/${user.profile.id}" class="img-responsive" alt="profileImage" >
          <h6>Upload a different photo...</h6>
          
          <form:input path="uploadedProfileImage" type="file"/>
        </div>
      </div>
      
      
      
      <!-- edit form column -->
      <div class="col-md-9 personal-info">
        <div class="alert alert-info alert-dismissable">
           Username, Email, Password can't be changed yet.
        </div>
              
          

        <legend>Personal info</legend>
          
          <div class="form-group">
            <label class="col-lg-3 control-label">Username:</label>
            <div class="col-lg-8">
              <form:input path="username" class="form-control" value="${user.username}" type="text" tabindex="1"/>
              <form:errors path="username" cssClass="help-inline" element="span"/>
            </div>
          </div>
          
          
          <div class="form-group">
            <label class="col-lg-3 control-label">Email:</label>
            <div class="col-lg-8">
              <form:input path="email" class="form-control" value="${user.email}" type="text" tabindex="2"/>
              <form:errors path="email" cssClass="help-inline" element="span"/>
            </div>
          </div>

        <c:set var="phoneNumberErrors"><form:errors path="phoneNumber"/></c:set>
        <div class="form-group<c:if test="${not empty phoneNumberErrors}"> error</c:if>">
            <label class="col-lg-3 control-label" for="field-phoneNumber">phoneNumber:</label>
            <div class="col-lg-8">
                <form:input class="form-control" path="phoneNumber" id="field-phoneNumber" type="number" min="1" max="9999999999999" step="1" pattern="[0-9]{10,12}"  tabindex="3" maxlength="45" value="${user.profile.phoneNumber}" placeholder="phone number"/>
                <form:errors path="phoneNumber" cssClass="help-inline" element="span" />
            </div>
        </div>

        <c:set var="ageErrors"><form:errors path="age"/></c:set>
        <div class="form-group<c:if test="${not empty ageErrors}"> error</c:if>">
            <label class="col-lg-3 control-label" for="field-age">Age:</label>
            <div class="col-lg-8">
                <form:input type="number" min="10" max="120" step="1" class="form-control" path="age" id="field-age" tabindex="3" maxlength="45" value="${user.profile.age}"/>
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
		
        <c:set var="sexErrors"><form:errors path="sex"/></c:set>
        <div class="form-group<c:if test="${not empty sexErrors}"> error</c:if>">
            <label class="col-lg-3 control-label" for="field-sex">Sex:</label>
            <div class="radio">
                <label><input type="radio" name="sex" id="male" tabindex="4" value="M" ${checkedM}>Male</label>
                <label><input type="radio" name="sex" id="female" tabindex="5" value="F" ${checkedF}>Female</label><br><br>
            </div>
        </div>
        
        
        <div class="form-group">
            <label class="col-lg-3 control-label">Description:</label>
            <div class="col-lg-8">
              <input class="form-control" value="${user.userDescription}" type="textarea"  style="width:100%; height:121px" tabindex="6">
            </div>
        </div>
        
  
        
        <div class="form-group">
        	<label class="col-md-3 control-label"></label>
            <div class="col-md-8">
            <button type="submit" value="saveProfile" tabindex="6" class="btn btn-primary">Save Profile</button>
<!--             <input type="reset" value="Reset"> -->
            <a type="button" href="${pageContext.request.contextPath}/myPage" onclick = "return showAlert()" tabindex="7" class="btn btn-default">Cancel</a>
            </div>
        </div>

    </fieldset>
</form:form>
       
        
      </div>
  </div>
</div>
<hr>

<c:import url="template/footer.jsp" />