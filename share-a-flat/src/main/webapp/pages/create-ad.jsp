<%@ page language="java"  import="javax.servlet.jsp.PageContext" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div id="masthead">  
  <div class="container">
      <div class="row">
      	<div>
          <h1>Ad-Creation</h1>
          <hr>
        </div>

      </div> 
  </div><!--/container-->
</div><!--/masthead-->


<form:form method="post" modelAttribute="adForm" action="submitAd" id="adForm" cssClass="form-horizontal"  autocomplete="off">

    <div class="col-md-3">    

        <c:set var="titleErrors"><form:errors path="title"/></c:set>
        <div class="control-group<c:if test="${not empty titleErrors}"> error</c:if>">
            <label class="control-label" for="field-title">Title</label>

            <div class="controls">
                <form:input path="title" id="field-title" tabindex="1" maxlength="45" placeholder="Title"/>
                <form:errors path="title" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="streetErrors"><form:errors path="street"/></c:set>
        <div class="control-group<c:if test="${not empty streetErrors}"> error</c:if>">
            <label class="control-label" for="field-street">Street</label>
            <div class="controls">
                <form:input path="street" id="field-street" tabindex="2" maxlength="35" placeholder="Street"/>
                <form:errors path="street" cssClass="help-inline" element="span"/>
            </div>
        </div>
        <c:set var="streetNumberErrors"><form:errors path="streetNumber"/></c:set>
        <div class="control-group<c:if test="${not empty streetNumberErrors}"> error</c:if>">
            <label class="control-label" for="field-streetNumber">StreetNumber</label>
            <div class="controls">
                <form:input path="streetNumber" id="field-streetNumber" tabindex="3" maxlength="35" placeholder="StreetNumber"/>
                <form:errors path="streetNumber" cssClass="help-inline" element="span"/>
            </div>
        </div>

		<c:set var="cityErrors"><form:errors path="city"/></c:set>
        <div class="control-group<c:if test="${not empty cityErrors}"> error</c:if>">
            <label class="control-label" for="field-city">City</label>
            <div class="controls">
                <form:input path="city" id="field-city" tabindex="4" maxlength="35" placeholder="City"/>
                <form:errors path="city" cssClass="help-inline" element="span"/>
            </div>
        </div>      

        <c:set var="zipCodeErrors"><form:errors path="zipCode"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-zipCode">Zip-Code</label>
            <div class="controls">
                <form:input path="zipCode" id="field-zipCode" tabindex="5" maxlength="35" placeholder="Zip-Code"/>
                <form:errors path="zipCode" cssClass="help-inline" element="span"/>
            </div>
        </div>   
       
        <c:set var="sizeErrors"><form:errors path="size"/></c:set>
        <div class="control-group<c:if test="${not empty sizeErrors}"> error</c:if>">
            <label class="control-label" for="field-size">Size</label>

            <div class="controls">
                <form:input path="size" id="field-size" tabindex="6" maxlength="45" placeholder="Size"/>
                <form:errors path="size" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="priceErrors"><form:errors path="price"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-price">Price</label>
            <div class="controls">
                <form:input path="price" id="field-price" tabindex="7" maxlength="35" placeholder="Price"/>
                <form:errors path="price" cssClass="help-inline" element="span"/>
            </div>
        </div>
 
         <c:set var="nrOfRoomMatesErrors"><form:errors path="nrOfRoomMates"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-nrOfRoomMates">Number of RoomMates</label>
            <div class="controls">
                <form:input path="nrOfRoomMates" id="field-nrOfRoomMates" tabindex="8" maxlength="35" placeholder="Number of Roommates"/>
                <form:errors path="nrOfRoomMates" cssClass="help-inline" element="span"/><br><br>
            </div>
        </div>     

        
        <div class="form-actions">
            <button type="submit" class="btn btn-primary" tabindex="10">Create Ad</button>
            <button type="button" onclick="history.go(-1);return true" class=" btn" tabindex="11">Cancel</button>
        </div>


</div>

<div class="col-md-6">
<!-- middle column -->

	<div class="layout-content-column">
	
	    <!-- gallery -->
	    <div class="gallery" data-gallery-closetext="Schliessen">
	
	        <a class="gallery-opener cover" target="_blank" data-gallery-image-desc="" data-gallery-image-title="Sicht" data-gallery-image-enum="Bild 1 von 5" href="http://img.immoscout24.ch/rev33mr-15.jpg">
	            <img height="363" alt="Sicht" src="http://img.immoscout24.ch/rev33mr-14.jpg"></img>
	        </a><br><br>
	
	        <div class="image-list ">
	
	            <a class="gallery-opener thumb " target="_blank" data-gallery-image-desc="" data-gallery-image-title="Wohnzimmer" data-gallery-image-enum="Bild 2 von 5" href="http://img.immoscout24.ch/hup3ipe-15.jpg">
	                <img width="74" height="56" src="http://img.immoscout24.ch/hup3ipe-10.jpg"></img>
	            </a>
	  
	        </div>
	    </div>
	    
	<c:set var="descriptionErrors"><form:errors path="description"/></c:set>
	        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
	            <label class="control-label" for="field-description">Description</label>
	            <div class="controls">
	                <form:textarea path="description" id="field-description" style="width:483px; height:121px"tabindex="9" placeholder="Description"/>
	                <form:errors path="description" cssClass="help-inline" element="span"/>
	            </div>
	        </div>
	</div>
</div>

<div class="col-md-3">
<!-- right column -->	
<div class="panel panel-default">
              <div class="panel-heading"><h3>Options</h3></div>
              <div class="panel-body"><a href="createAd" class="inactive"><span>Create Ad</span></a>
              </div>
            </div>
            
            <div class="panel panel-default">
              <div class="panel-heading"><h3>Options</h3></div>
              <div class="panel-body"><a href="createAd" class="inactive"><span>Create Ad</span></a>
              </div>
            </div>
</div>
	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>

</form:form>

<c:import url="template/footer.jsp" />