<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->
<form action="registerForVisit">
<c:forEach items="${adData.visitList}" var="visit">
	<input type="radio" name="selectedVisit" value="${visit.id}"/>}${visit}
</c:forEach>
<input type="submit" value="register for visit">
</form>

 

 
