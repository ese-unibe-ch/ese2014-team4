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
			<h4>${message}</h4>
		</div>
	</div>
	<!--/container-->
</div>
<!--/masthead-->

	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3><a data-toggle="collapse" data-parent="#accordion" href="#collapseBookmarks">My Bookmarks</a></h3>
			</div>
			<div class="panel-collapse collapse" id="collapseBookmarks">
			<div class="panel-body" >
			<c:choose><c:when test="${fn:length(adList) eq 0}">You have no bookmarks.</c:when><c:otherwise>
				<c:import url="searchResultsList.jsp" />
			</c:otherwise></c:choose>
			</div></div>
		</div>
	</div>
	<div class="col-md-12">
	<div class="panel panel-default">
		<div class="panel-heading">
				<h3><a data-toggle="collapse" data-parent="#accordion" href="#collapseMyAds">My Ads</a></h3>
		</div>
		<div class="panel-collapse collapse" id="collapseMyAds">
		<div class="panel-body">
		<c:choose><c:when test="${fn:length(myAdsList) eq 0}">You have not submitted ads.</c:when><c:otherwise>
			<c:import url="embedded/myAdsList.jsp" />
		</c:otherwise></c:choose>
		</div></div>
	</div>
	</div>

<!-- shows all searches with search button -->

	<div class="col-md-12">
	<div class="panel panel-default">
		<div class="panel-heading">
				<h3><a data-toggle="collapse" data-parent="#accordion" href="#collapseMySearches">My Searches</a></h3>
		</div>
		<div class="panel-collapse collapse" id="collapseMySearches">
		<div class="panel-body">
		<c:choose><c:when test="${fn:length(mySearchList) eq 0}">No searches saved.</c:when><c:otherwise>
		<c:forEach items="${mySearchList}" var="search">
			<form  action="restoreSavedSearch?id=${search.id}" method="POST">
			${search.adType} in ${search.cityOrZip}. 
			<button type="submit" name="search">Search</button>
			<button type="submit" name="delete">Delete search</button>
			</form> 
		</c:forEach>
		</c:otherwise></c:choose>
		</div>

		
	</div></div>
	</div>	
	<div class="col-md-12">
 <div class="panel panel-default">
				<div class="panel-heading">
					
						<h3><a data-toggle="collapse" data-parent="#accordion" href="#collapseMyVisits">My Visits</a></h3>
					
				</div>
				<div class="panel-collapse collapse" id="collapseMyVisits">
				<div class="panel-body">
				<c:choose><c:when test="${fn:length(myVisitsList) eq 0}">You have not registered for any visits</c:when><c:otherwise>
						<c:forEach items="${myVisitsList}" var="visit">
							<a href="showAd?adId=${visit.adId}">${visit}</a>
							<br>
						</c:forEach> 
					</c:otherwise></c:choose>
				</div>
</div></div></div>
<div class="col-md-12">
 <div class="panel panel-default">
				<div class="panel-heading">
						<h3><a data-toggle="collapse" data-parent="#accordion" href="#collapseMyVisitors">My Visitors</a></h3>
				</div>
				<div class="panel-collapse collapse" id="collapseMyVisitors">
				<div class="panel-body">
				<c:choose><c:when test="${fn:length(myAdsList) eq 0}">You have not announced visit dates</c:when><c:otherwise>
						<c:forEach items="${myAdsList}" var="ad">
						<c:forEach items="${ad.visitList}" var="visit">
							<a href="showAd?adId=${ad.id}">${visit}</a>: <c:forEach items="${visit.visitorList}" var="user"><a href="profile?userId=${user.id}">${user.username}  </a> </c:forEach>
							<br>
						</c:forEach> </c:forEach>
					</c:otherwise></c:choose>
				</div>
</div></div></div>


<c:import url="template/footer.jsp" />