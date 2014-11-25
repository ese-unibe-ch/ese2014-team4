<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />
<div id="masthead">
	<div class="container">
		<div class="row">
			<div>
				<h1>My Page</h1>
				<hr>
			</div>
		</div>
	</div>
	<!--/container-->
</div>
<!--/masthead-->

<div class="row">






	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>My Profile</h3>
			</div>
			<div class="panel-body">
				<c:import url="embedded/profile.jsp" />
				<br>

				<div class="form-actions">
					<a type="button"
						href="${pageContext.request.contextPath}/modifyProfile"
						class="btn btn-primary">Modify Profile</a>

					<!--  link to delete profile -->
					<h6>
						<small><a
							href="${pageContext.request.contextPath}/deleteProfile">Delete
								Profile</a></small>
					</h6>
				</div>
			</div>
		</div>
	</div>

	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>My Bookmarks</h3>
			</div>
			<div class="panel-body">
				<c:import url="searchResultsList.jsp" />
			</div>
		</div>
	</div>
	<div class="col-md-6">
	<div class="panel panel-default">
		<div class="panel-heading">
				<h3>My Ads</h3>
		</div>
		<div class="panel-body">
<c:forEach items="${myAdsList}" var="ad">
	<a href="showAd?adId=${ad.id}" style="font-size: 14pt; color: blue"><b>${ad.title}</b></a>
	<table>

		<tr>
			<td width="110"><a href="showAd?adId=${ad.id}"><img
					src="${pageContext.request.contextPath}/imageController/ad/${ad.id}/0"
					class="img-responsive" width="100"></a></td>

			<td width="80"><b>Address:</b><br> <b></b> <b>Place:</b><br>
			</td>


			<td width="150">${ad.address.street} ${ad.address.streetNumber}<br>
				${ad.address.zipCode} ${ad.address.city}
			</td>

			<td width="60"><b>Price:</b><br> <b>Size:</b><br></td>

			<td width="100">${ad.brutto} CHF<br> ${ad.size} m&sup2<br>
			</td>
		</tr>
	</table>
	<hr>
</c:forEach>
</div>
		
		</div>
	</div>
	</div>



<c:import url="template/footer.jsp" />