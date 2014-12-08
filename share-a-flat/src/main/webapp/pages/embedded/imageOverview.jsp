<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- only used as imported part of other pages, therefore no header / footer. -->


 

					<!-- image address will get mapped by ImageController -->
					<div class="container">

						<ul class="row">
							<c:forEach items="${adData.bytePictureList}" var="img" varStatus="loop">
								<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4 gallery"><img
									src="${pageContext.request.contextPath}/imageController/ad/${adData.id}/${loop.index}"
									class="img-responsive" alt="${adData.id}/${loop.index}"
									width="100px" height="100px" id="img${loop.index}"></li>
							</c:forEach>
						</ul>

					</div>