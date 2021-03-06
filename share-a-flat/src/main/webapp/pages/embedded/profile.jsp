<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->


<!-- <h2>My Profile</h2> -->
<br>
<span class=".hasError">${errorMessage}</span>



		<div class="alert alert-info" align="left" style="height:50px">
           <h4><b>Personal Info</b></h4>
        </div>
		<table>

			<tr>
				<td width="450">
							
					<div class="form-group">
						<label class="col-md-5 control-label">Username:</label>

						<div class="col-lg-5">${userProfile.username}</div>

						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label">Email:</label>
						<div class="col-lg-5">${userProfile.email}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-phoneNumber">Phone Number:</label>

						<c:set var="phoneNr" value="${userProfile.phoneNumber}" />
							<c:if test="${empty userProfile.phoneNumber}">
								<c:set var="phoneNr" value="--" />

							</c:if>
															
							<div class="col-lg-5">${phoneNr}</div>					
					</div>
					<br><br>
					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-phoneNumber">Age:</label>

						<c:set var="age" value="${userProfile.age}" />
							<c:if test="${empty userProfile.age}">
								<c:set var="age" value="--" />

							</c:if>
															
							<div class="col-lg-5">${age}</div>					
					</div>	
					<br>
					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-sex">Sex:</label>

						<c:set var="sex" value="${userProfile.sex}" />
							<c:if test="${userProfile.sex ne 'M' && userProfile.sex ne 'F'}">
								<c:set var="sex" value="--" />

							</c:if>
						
							<div class="col-lg-5">${sex}</div>
						</div>
						<br>

					
					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-description">Description:</label>

						<c:set var="descr" value="${userProfile.userDescription}" />
							<c:if test="${empty userProfile.userDescription}">
								<c:set var="descr" value="--" />

							</c:if>
						
							<pre>${descr}</pre>
						</div>
						<br>

				</td>									
			</tr>
		</table>
