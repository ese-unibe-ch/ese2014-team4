<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>My Profile</h2> -->
<br>
<span class=".hasError">${errorMessage}</span>


<img src="${pageContext.request.contextPath}/imageController/profile/${user.profile.id}" class="img-responsive" alt="profileImage" >
<p><b>Username: </b>${user.username}</p> 
<p><b>Email: </b>${user.email}</p>
<p><b>Phone: </b>${user.profile.phoneNumber}</p>    
<p><b>Age: </b>${user.profile.age}</p>  
<p><b>Sex: </b>${user.profile.sex}</p>
<p><b>Description: </b>${user.profile.userDescription}</p>



