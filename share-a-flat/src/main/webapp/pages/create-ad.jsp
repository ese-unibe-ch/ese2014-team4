<%@ page language="java"  import="javax.servlet.jsp.PageContext" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />



<form:form method="post" modelAttribute="adForm" action="submitAd" id="adForm" cssClass="form-horizontal"  autocomplete="off">
    <fieldset>
        <legend>Enter Your Information</legend>

        <c:set var="titleErrors"><form:errors path="title"/></c:set>
        <div class="control-group<c:if test="${not empty titleErrors}"> error</c:if>">
            <label class="control-label" for="field-title">Title</label>

            <div class="controls">
                <form:input path="title" id="field-title" tabindex="1" maxlength="45" placeholder="Ad Title"/>
                <form:errors path="title" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="streetErrors"><form:errors path="street"/></c:set>
        <div class="control-group<c:if test="${not empty streetErrors}"> error</c:if>">
            <label class="control-label" for="field-street">street</label>
            <div class="controls">
                <form:input path="street" id="field-street" tabindex="2" maxlength="35" streetholder="street"/>
                <form:errors path="street" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="streetNumberErrors"><form:errors path="streetNumber"/></c:set>
        <div class="control-group<c:if test="${not empty streetNumberErrors}"> error</c:if>">
            <label class="control-label" for="field-streetNumber">streetNumber</label>
            <div class="controls">
                <form:input path="streetNumber" id="field-streetNumber" tabindex="2" maxlength="35" streetNumberholder="streetNumber"/>
                <form:errors path="streetNumber" cssClass="help-inline" element="span"/>
            </div>
        </div>

        <c:set var="zipCodeErrors"><form:errors path="zipCode"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-zipCode">zipCode</label>
            <div class="controls">
                <form:input path="zipCode" id="field-zipCode" tabindex="3" maxlength="35" placeholder="zipCode"/>
                <form:errors path="zipCode" cssClass="help-inline" element="span"/>
            </div>
        </div>   
                        
          <c:set var="cityErrors"><form:errors path="city"/></c:set>
        <div class="control-group<c:if test="${not empty cityErrors}"> error</c:if>">
            <label class="control-label" for="field-city">city</label>
            <div class="controls">
                <form:input path="city" id="field-city" tabindex="2" maxlength="35" cityholder="city"/>
                <form:errors path="city" cssClass="help-inline" element="span"/>
            </div>
        </div>           
        
   
        
        <c:set var="descriptionErrors"><form:errors path="description"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-description">Description</label>
            <div class="controls">
                <form:textarea path="description" id="field-description" rows="6" width="350px" style="resize:vertical"tabindex="3" maxlength="35" placeholder="Description"/>
                <form:errors path="description" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="priceErrors"><form:errors path="price"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-price">Price</label>
            <div class="controls">
                <form:input path="price" id="field-price" tabindex="3" maxlength="35" placeholder="Price"/>
                <form:errors path="price" cssClass="help-inline" element="span"/>
            </div>
        </div>
 
         <c:set var="nrOfRoomMatesErrors"><form:errors path="nrOfRoomMates"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-nrOfRoomMates">nrOfRoomMates</label>
            <div class="controls">
                <form:input path="nrOfRoomMates" id="field-nrOfRoomMates" tabindex="3" maxlength="35" placeholder="Number of Roommates"/>
                <form:errors path="nrOfRoomMates" cssClass="help-inline" element="span"/>
            </div>
        </div>     

        
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Create Ad</button>
            <button type="button" class="btn">Cancel</button>
        </div>
    </fieldset>
</form:form>

	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>



<c:import url="template/footer.jsp" />