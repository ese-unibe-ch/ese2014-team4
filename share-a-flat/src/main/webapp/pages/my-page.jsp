<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />



<h1>My Page</h1>

        <!-- Auswahlreiter -->
        <ul>
  		<li class="profile"><a href="profile" class="inactive"><span>Profile</span></a></li>
        <li class="createAd"><a href="createAd" class="inactive"><span>Create Ad</span></a></li> 
		</ul>

<c:import url="template/footer.jsp" />