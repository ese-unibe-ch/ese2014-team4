<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />



<table>
  	<tr>
		<th><h2> Modify your Profile</h2></th>
	</tr>
	<tr><td>
	<form:form method="post" modelAttribute="profileForm" action="saveProfile" id="profileForm" cssClass="form-horizontal"  autocomplete="off">
<fieldset>
        <legend>Enter Your Information</legend>

        <c:set var="ageErrors"><form:errors path="age"/></c:set>
        <div class="control-group<c:if test="${not empty ageErrors}"> error</c:if>">
            <label class="control-label" for="field-age">age</label>

            <div class="controls">
                <form:input path="age" id="field-age" tabindex="1" maxlength="45" value="${profile.age}"/>
                <form:errors path="age" cssClass="help-inline" element="span" />
            </div>
        </div>      

        <!-- sets current_profile sex -->
        <c:set var="checkedM" value="" />
		<c:if test="${profile.sex eq 'M'}">
   		<c:set var="checkedM" value="checked" />
		</c:if>
		
		<c:set var="checkedF" value="" />
		<c:if test="${profile.sex eq 'F'}">
   		<c:set var="checkedF" value="checked" />
		</c:if>
		
        <c:set var="sexErrors"><form:errors path="sex"/></c:set>
        <div class="control-group<c:if test="${not empty sexErrors}"> error</c:if>">
            <label class="control-label" for="field-sex">Sex</label>
            <div class="radio">
                <label><input type="radio" name="sex" id="male" value="M" ${checkedM}>Male</label>
                <label><input type="radio" name="sex" id="Female" value="F" ${checkedF}>Female</label>
            </div>
        </div>
        
        <c:set var="descriptionErrors"><form:errors path="description"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-description">Further Information</label>
            <form:textarea path="description" rows="4" class="form-control" value="${profile.description}"/>
        </div>
        
        <c:set var="descriptionErrors"><form:errors path="description"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <form:form path="profileForm.description">
            <label class="control-label" for="field-description">Further Information</label>
            <textarea>${profile.description}</textarea>
            </form:form>
        </div>




        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Save Profile</button>
            <a href="profile" type="button" class="btn">Cancel</a>
        </div>
</fieldset>
</form:form>
       </td>

  </tr>
</table>


<c:import url="template/footer.jsp" />