<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:import url="template/header.jsp" />

<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>

<script>
	var geocoder;
	var map;
	function initialize() {
		geocoder = new google.maps.Geocoder();
		var latlng = new google.maps.LatLng(46.9479222, 7.4446085, 7);
		var mapOptions = {
			zoom : 10,
			center : latlng
		}
		map = new google.maps.Map(document.getElementById('map-canvas'),
				mapOptions);
	}
	google.maps.event.addDomListener(window, 'load', initialize);
</script>

<script>
	function codeAddress() {
		geocoder.geocode({
			'address' : "${adData.address}"
		}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);
				var marker = new google.maps.Marker({
					map : map,
					position : results[0].geometry.location
				});
			} else {
				alert('the address "'+ "${adData.address}" + '" could not be found on the map for the following reason: '
						+ status);
			}
		});
	}
</script>

<body onload="codeAddress()">

	<div id="masthead">

		<div class="container">
			<div class="row">
				<div>
					<h1 style="color: blue" align="center">
						<b>${adData.title}</b>

							<c:choose><c:when test="${isBookmarked eq false}">
							<a id="bookmarkStar" href="${pageContext.request.contextPath}/addToBookmarks?adId=${adData.id}"><img width=35 height=35 alt="click to bookmark" src="img/notbookmarked.png"></a></c:when>
							<c:otherwise><a id="bookmarkStar" href="${pageContext.request.contextPath}/removeFromBookmarks?adId=${adData.id}"><img width=35 height=35  alt="click to remove from bookmarks" src="img/bookmarked.png"></a></c:otherwise>
							</c:choose>
					</h1>
					
					<h5 align="center">
						<span>${bookmarkResponse}</span>
					</h5>
					
					<hr>
					
				</div>
			</div>
		</div>
		<!--/container-->
	</div>
	<!--/masthead-->

	<c:if test="${isMyAd eq true}">
		<fieldset>
			<form method="post" action="modifyAd?adId=${adData.id}">
				<input name="modify" type="submit" value="Modify ad" class="btn btn-warning"> 
				<input name="delete" type="submit" value="Delete ad" onclick="return confirm('Are you sure you want to delete your ad?')"
					class="btn btn-warning">
			</form>
		</fieldset>
	</c:if>
	
	<div class="row">
		<div class="col-md-3">
			<div class="panel panel-default">
			
				<div class="panel-heading">
				
					<h3>
						<b>General</b>
					</h3>
				</div>
				
				<div class="panel-body">

					<h4>
						<b>Address</b>
					</h4>
					${adData.address.street} ${adData.address.streetNumber}<br>
					${adData.address.zipCode} ${adData.address.city}
					
					<hr>

					<table>
						<tr>
							<!-- label ad correctly either as room or apartment -->
							<c:set var="adTypeToShow" value="Flat" />
							<c:if test="${adData.type eq 'ROOM'}">
								<c:set var="adTypeToShow" value="Room" />
							</c:if>

							<h4>
								<b>${adTypeToShow}</b>
							</h4>
						</tr>

						<tr>
							<c:set var="size" value="${adData.size} m&sup2"></c:set>
							<c:if test="${adData.size eq 0}"><c:set var="size" value="--"></c:set></c:if>
							<td width="140"><b>Size:</b></td>
							<td>${size}</td>
						</tr>

						<tr>
							<c:set var="nrOfRooms" value="${adData.nrOfRooms}"></c:set>
							<c:if test="${adData.nrOfRooms eq 0}"><c:set var="nrOfRooms" value="--"></c:set></c:if>
							<td width="140"><b>Nr of Rooms:</b></td>
							<td>${nrOfRooms}</td>
						</tr>

						<tr>
							<c:set var="availableDate" value="${adData.availableDate}"></c:set>
							<c:if test="${empty adData.availableDate}">
								<c:set var="availableDate" value="--"></c:set>
							</c:if>
							<td width="140"><b>Available From:</b></td>
							<td>${availableDate}</td>
						</tr>
					</table>
					
					<hr>

					<c:if test="${adData.nrOfFlatMates != '0'}">

						<table>
							<tr>
								<td><h4><b>Flatmates</b></h4></td>
							</tr>
	
							<tr>
								<td width="140"><b>Nr of Flatmates:</b></td>
								<td>${adData.nrOfFlatMates}</td>							
							</tr>
							
							<tr>
								<td>							
									<c:forEach items="${adData.flatmateList}" var="flatmate">						
										<a href="${pageContext.request.contextPath}/profile?userId=${flatmate.id}">${flatmate.username}<br></a>					
									</c:forEach>							
									
									<c:forEach items="${adData.flatmateListWithoutAccount}" var="flatmate">						
										${flatmate}<br> 					
									</c:forEach>
									
								</td>
							</tr>
						</table>
						
						<hr>
					
					</c:if>
					
					<table>
						<tr><h4><b>Price</b></h4>
						</tr>

						<tr>
							<c:set var="netto" value=" CHF ${adData.netto}.-"></c:set>
							<c:if test="${adData.netto eq 0}"><c:set var="netto" value="--"></c:set></c:if>
							<td width="140"><b>Netto-Price:</b></td>
							<td>${netto}</td>
						</tr>

						<tr>
							<c:set var="charges" value=" CHF ${adData.charges}.-"></c:set>
							<c:if test="${adData.charges eq 0}"><c:set var="charges" value="--"></c:set></c:if>
							<td width="140"><b>Charges:</b></td>
							<td>${charges}</td>
						</tr>

						<tr>
							<c:set var="brutto" value=" CHF ${adData.brutto}.-"></c:set>
							<c:if test="${adData.brutto eq 0}"><c:set var="brutto" value="--"></c:set></c:if>
							<td width="140"><b>Brutto-Price:</b></td>
							<td>${brutto}</td>
						</tr>
					</table>
					
				</div>
			</div>
		</div>

		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<b>Additional Information</b>
					</h3>
				</div>

				<div class="panel-body">
					<c:import url="embedded/imageOverview.jsp"/>

					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-body"></div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->

					<p>
					
					<h4><b>Description:</b></h4>

					${adData.description}

				</div>
			</div>
			
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3><b>On Map</b></h3>
				</div>
				
				<div class="panel-body">
					<div id="map-canvas" style="width:520px; height:300px"></div>
				</div>
			</div>
					
		</div>

		<div class="col-md-3">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>
						<b>Contact</b>
					</h3>
				</div>
				
				<div class="panel-body">
					<h4>
						<b>Ad placed by <a href="${pageContext.request.contextPath}/profile?userId=${adData.owner.id}">${adData.owner.username}</a></b>
					</h4>
					
					
					<c:set var="receiverName" value="${adData.owner.username}"></c:set><c:import url="embedded/sendMessageBox.jsp" />
					
					
				</div>
			</div>
			
			<c:import url="embedded/showVisits.jsp"></c:import>	
					
		</div>	
	</div>


	<script>
		$(document)
				.ready(
						function() {
							$('li img')
									.on(
											'click',
											function() {
												var src = $(this).attr('src');
												var img = '<img src="' + src + '" class="img-responsive"/>';

												//start of new code new code
												var index = $(this)
														.parent('li').index();

												var html = '';
												html += img;
												html += '<div style="height:25px;clear:both;display:block;">';
												html += '<a class="controls previous text-left" href="'
														+ (index)
														+ '">&laquo; prev</a>';
													
												html += '<a class="controls next pull-right" href="'
													+ (index + 2)
													+ '">next &raquo;</a>';
												html += '</div>';

												$('#myModal').modal();
												$('#myModal')
														.on(
																'shown.bs.modal',
																function() {
																	$(
																			'#myModal .modal-body')
																			.html(
																					html);
																	//new code
																	$(
																			'a.controls')
																			.trigger(
																					'click');
																})
												$('#myModal')
														.on(
																'hidden.bs.modal',
																function() {
																	$(
																			'#myModal .modal-body')
																			.html(
																					'');
																});

											});

						})

		//new code
		$(document).on('click', 'a.controls', function() {
			var index = $(this).attr('href');
			var src = $('ul.row li:nth-child(' + index + ') img').attr('src');

			$('.modal-body img').attr('src', src);

			var newPrevIndex = parseInt(index) - 1;
			var newNextIndex = parseInt(newPrevIndex) + 2;

			if ($(this).hasClass('previous')) {
				$(this).attr('href', newPrevIndex);
				$('a.next').attr('href', newNextIndex);
			} else {
				$(this).attr('href', newNextIndex);
				$('a.previous').attr('href', newPrevIndex);
			}

			var total = $('ul.row li').length + 1;
			//hide next button
			if (total === newNextIndex) {
				$('a.next').hide();
			} else {
				$('a.next').show()
			}
			//hide previous button
			if (newPrevIndex === 0) {
				$('a.previous').hide();
			} else {
				$('a.previous').show()
			}

			return false;
		});
	</script>
	<c:import url="template/footer.jsp" />
