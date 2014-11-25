<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />


<h1>
	<b>Hi ${username}</b>
</h1>

<div class="row">
	<div class="panel panel-default">

		<div class="panel-heading">
			<h3>Here are the newest adds in RoomMate</h3>
		</div>

		<div class="panel-body">
			<c:import url="resultsTable.jsp" />
		</div>
	</div>
</div>

<c:import url="template/footer.jsp" />