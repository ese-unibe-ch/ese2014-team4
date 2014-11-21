<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:import url="template/header.jsp" />
<!-- special css for thumbnail view -->



<div class="row">
	<div class="col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Search Results</h3>
			</div>
			<div class="panel-body"></div>

		</div>
	</div>

	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1>${adData.title}<a id="bookmarkStar"
						href="${pageContext.request.contextPath}/addToBookmarks?adId=${adData.id}"
						class="glyphicon glyphicon-star-empty"></a>
				</h1>
				<h6>
					<span>${bookmarkResponse}</span>
				</h6>
			</div>



			<!-- label ad correctly either as room or apartment -->
			<c:set var="adTypeToShow" value="Apartment" />
			<c:if test="${adData.type eq 'ROOM'}">
				<c:set var="adTypeToShow" value="Room" />
			</c:if>

			<br>
			<p>${adTypeToShow}</p>


			<p>
				<b>Address</b><br> ${adData.address.street}
				${adData.address.streetNumber}<br> ${adData.address.zipCode}
				${adData.address.city}
			</p>

			<p>
				<b>Description</b><br> ${adData.description}
		</div>
	</div>

	<div class="col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Contact</h3>
			</div>
			<div class="panel-body">
			<b>Ad placed by <a href="${pageContext.request.contextPath}/profile?userId=${adData.owner.id}">${adData.owner.username}</a></b><br>
			<a href="mailTo:${adData.owner.email}">${adData.owner.email}</a><br>
			${adData.owner.profile.phoneNumber}<br>
			<c:import url="embedded/sendMessageBox.jsp"/>
			
			</div>

		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<!-- image address will get mapped by ImageController -->
		<div class="container">
			<ul class="row">

				<c:forEach items="${imageList}" var="imgId">
					<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 gallery"><img
						src="${pageContext.request.contextPath}/imageController/ad/${adData.id}/${imgId}"
						class="img-responsive" alt="${adData.id}/${imgId}" width="100px"
						height="100px" id="img${imgId}"></li>
				</c:forEach>
			</ul>
		</div>

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
											var index = $(this).parent('li')
													.index();

											var html = '';
											html += img;
											html += '<div style="height:25px;clear:both;display:block;">';
											html += '<a class="controls next" href="'
													+ (index + 2)
													+ '">next &raquo;</a>';
											html += '<a class="controls previous" href="'
													+ (index)
													+ '">&laquo; prev</a>';
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
																$('a.controls')
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