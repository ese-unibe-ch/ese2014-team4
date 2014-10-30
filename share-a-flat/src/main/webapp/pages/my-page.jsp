<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />



<h1>My Page</h1>

        <!-- Auswahlreiter -->
        <ul>
        <li class="createAd"><a href="createAd" class="inactive"><span>Create Ad</span></a></li> 
		</ul>

        <div class="form-actions">
        	<a type="button" href = "${pageContext.request.contextPath}/modifyProfile" class="btn btn-primary">Modify Profile</a>
            
        </div>
        
 <!-- appends user profile. the /profile method does not get invoked, only /my-page! -->       
<c:import  url="profile.jsp" />


<!--  link to delete profile -->        
<h6><small><a href = "${pageContext.request.contextPath}/deleteProfile">Delete Profile</a></small></h6>

<c:import url="template/footer.jsp" />