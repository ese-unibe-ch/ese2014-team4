<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>My Messages</h2> -->

<div>TODO show inbox and sent messages of the user</div>









<!-- put this back to myPage.jsp when implmented -->

<div class="col-md-2">
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3>My Messages</h3>
		</div>
		<div class="panel-body">
			<c:import url="embedded/messages.jsp" />
		</div>
	</div>
</div>
