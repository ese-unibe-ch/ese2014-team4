<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />



<h1>Search List</h1>
        

        <!-- Auswahlreiter -->
        
        <ul>
            <li class="map"><a href="search-map" class="inactive">
                <span><!-- <img src="/neutral/imids/homegate/icon_tab_map.gif" />-->Auf Karte</span></a></li>
        </ul>


<form:form method="post" modelAttribute="searchForm" action="search" id="searchForm" cssClass="form-horizontal"  autocomplete="off">

    <div class="col-md-3">    
          
        <c:set var="cityErrors"><form:errors path="city"/></c:set>
        <div class="control-group<c:if test="${not empty cityErrors}"> error</c:if>">
            <label class="control-label" for="field-city">City</label>
            <div class="controls">
                <form:input class="form-control" path="city" id="field-city" tabindex="1" maxlength="35" placeholder="City"/>
                <form:errors path="city" cssClass="help-inline" element="span"/>
            </div>
        </div>    
        
        <c:set var="priceErrors"><form:errors path="price"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-price">Price</label>
            <div class="controls">
                <form:input class="form-control" path="price" id="field-price" tabindex="2" maxlength="35" placeholder="Price"/>
                <form:errors path="price" cssClass="help-inline" element="span"/>
            </div>
        </div>
            
<%--         <c:set var="titleErrors"><form:errors path="title"/></c:set> --%>
<%--         <div class="control-group<c:if test="${not empty titleErrors}"> error</c:if>"> --%>
<!--             <label class="control-label" for="field-title">Title</label> -->

<!--             <div class="controls"> -->
<%--                 <form:input class="form-control" path="title" id="field-title" tabindex="3" maxlength="45" placeholder="Title"/> --%>
<%--                 <form:errors path="title" cssClass="help-inline" element="span"/> --%>
<!--             </div> -->
<!--         </div> -->
        
<%--         <c:set var="streetErrors"><form:errors path="street"/></c:set> --%>
<%--         <div class="control-group<c:if test="${not empty streetErrors}"> error</c:if>"> --%>
<!--             <label class="control-label" for="field-street">Street</label> -->
<!--             <div class="controls"> -->
<%--                 <form:input class="form-control" path="street" id="field-title" tabindex="4" maxlength="35" placeholder="Street"/> --%>
<%--                 <form:errors path="street" cssClass="help-inline" element="span"/> --%>
<!--             </div> -->
<!--         </div> -->

<%--         <c:set var="streetNumberErrors"><form:errors path="streetNumber"/></c:set> --%>
<%--         <div class="control-group<c:if test="${not empty streetNumberErrors}"> error</c:if>"> --%>
<!--             <label class="control-label" for="field-streetNumber">StreetNumber</label> -->
<!--             <div class="controls"> -->
<%--                 <form:input class="form-control" path="streetNumber" id="field-streetNumber" tabindex="5" maxlength="35" placeholder="StreetNumber"/> --%>
<%--                 <form:errors path="streetNumber" cssClass="help-inline" element="span"/> --%>
<!--             </div> -->
<!--         </div> -->

        <c:set var="zipCodeErrors"><form:errors path="zipCode"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-zipCode">Zip-Code</label>
            <div class="controls">
                <form:input class="form-control" path="zipCode" id="field-zipCode" tabindex="6" maxlength="35" placeholder="Zip-Code"/>
                <form:errors path="zipCode" cssClass="help-inline" element="span"/>
            </div>
        </div>   
        
        <c:set var="nrOfRoomMatesErrors"><form:errors path="nrOfRoomMates"/></c:set>
        <div class="control-group<c:if test="${not empty descriptionErrors}"> error</c:if>">
            <label class="control-label" for="field-nrOfRoomMates">Number of RoomMates</label>
            <div class="controls">
                <form:input class="form-control" path="nrOfRoomMates" id="field-nrOfRoomMates" tabindex="7" maxlength="35" placeholder="Number of Roommates"/>
                <form:errors path="nrOfRoomMates" cssClass="help-inline" element="span"/><br><br>
            </div>
        </div>     

        
        <div class="form-actions">
            <button type="submit" tabindex="8" class="btn btn-primary">Search Ad</button>
            <button type="button" onclick="${pageContext.request.contextPath}/my-page" tabindex="9" class=" btn">Cancel</button>
        </div>
	</div>
</form:form>

<c:forEach items="${searchResults}" var="ad"></c:forEach>

<c:import url="template/footer.jsp" />