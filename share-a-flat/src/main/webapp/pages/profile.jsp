<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>My Profile</h2> -->

<%-- <label class="col-lg-2">Username:</label>${profile.owner.username}<br><br> --%>

<%-- <label class="col-lg-2">Email:</label>${profile.owner.email}<br><br> --%>

<%-- <label class="col-lg-2">Age:</label>${profile.age}<br><br> --%>

<%-- <label class="col-lg-2">Sex:</label>${profile.sex}<br><br> --%>

<br>
<p><b>Username: </b>${profile.owner.username}</p> 
<p><b>Email: </b>${profile.owner.email}</p>  
<p><b>Age: </b>${profile.age}</p>  
<p><b>Sex: </b>${profile.sex}</p>
...
<%-- <p><b>Further Information: </b>${profile.description}</p> --%>

