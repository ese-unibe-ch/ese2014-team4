<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<c:import url="template/header.jsp" />
<div id="masthead">
	<div class="container">
		<div class="row">
			<div>
				<h1 align="center">My Page</h1>
				<hr>
			</div>
		</div>
	</div>
	<!--/container-->
</div>
<!--/masthead-->

<div class="row">

	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>My Bookmarks</h3>
			</div>
			<div class="panel-body">
			<c:choose><c:when test="${fn:length(adList) eq 0}">You have no bookmarks.</c:when><c:otherwise>
				<c:import url="searchResultsList.jsp" />
			</c:otherwise></c:choose>
			</div>
		</div>
	</div>
	<div class="col-md-9">
	<div class="panel panel-default" style="max-height: 560px ;overflow-y: scroll;">
		<div class="panel-heading">
				<h3>My Ads</h3>
		</div>
		<div class="panel-body">
		<c:choose><c:when test="${fn:length(myAdsList) eq 0}">You have not submitted ads.</c:when><c:otherwise>
			<c:import url="embedded/myAdsList.jsp" />
		</c:otherwise></c:choose>
		</div>
	</div>
	</div>

<!-- shows all searches with search button -->

	<div class="col-md-3">
	<div class="panel panel-default">
		<div class="panel-heading">
				<h3>My Searches</h3>
		</div>
		<div class="panel-body">
		<c:choose><c:when test="${fn:length(mySearchList) eq 0}">No searches saved.</c:when><c:otherwise>
		<c:forEach items="${mySearchList}" var="search">
			<form  action="restoreSavedSearch?id=${search.id}" method="POST">
			${search.cityOrZip}
			<button type="submit" name="search">Search</button>
			<button type="submit" name="delete">Delete search</button>
			</form> 
		</c:forEach>
		</c:otherwise></c:choose>
		</div>

		
	</div>
	</div>	
	</div>



<c:import url="template/footer.jsp" />