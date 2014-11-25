<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />


<h1>${adData.title}</h1>

<h2>Send e-mail to someone@example.com:</h2>

<form action="MAILTO:someone@example.com" method="post"
	enctype="text/plain">
	Name:<br> <input type="text" name="name" value="your name"><br>
	E-mail:<br> <input type="text" name="mail" value="your email"><br>
	Comment:<br> <input type="text" name="comment"
		value="your comment" size="50"><br>
	<br> <input type="submit" value="Send"> <input
		type="reset" value="Reset">
</form>


<c:import url="template/footer.jsp" />