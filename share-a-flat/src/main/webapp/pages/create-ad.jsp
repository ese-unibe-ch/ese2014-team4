<%@ page language="java"  import="javax.servlet.jsp.PageContext" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />



<form:form method="post" modelAttribute="adForm" action="createAd" id="adForm" cssClass="form-horizontal"  autocomplete="off">
    <fieldset>
        <legend>Enter Your Information</legend>

        <c:set var="addressErrors"><form:errors path="address"/></c:set>
        <div class="control-group<c:if test="${not empty addressErrors}"> error</c:if>">
            <label class="control-label" for="field-address">Address</label>

            <div class="controls">
                <form:input path="address" id="field-address" tabindex="1" maxlength="45" placeholder="Address"/>
                <form:errors path="address" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="placeErrors"><form:errors path="place"/></c:set>
        <div class="control-group<c:if test="${not empty placeErrors}"> error</c:if>">
            <label class="control-label" for="field-place">Place</label>
            <div class="controls">
                <form:input path="place" id="field-place" tabindex="2" maxlength="35" placeholder="Place"/>
                <form:errors path="place" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="descriptionErrors"><form:errors path="description"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-description">Description</label>
            <div class="controls">
                <form:input path="description" id="field-description" tabindex="3" maxlength="35" placeholder="Description"/>
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