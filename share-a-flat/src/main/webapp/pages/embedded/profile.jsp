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
           <h4><u><b>Personal Info:</b></u></h4>
        </div>
		<table>

			<tr>
				<td width="450">
				
					<div class="form-group">
						<label class="col-md-5 control-label">Username:</label>
						<div class="col-lg-5">${user.username}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label">Email:</label>
						<div class="col-lg-5">${user.email}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-phoneNumber">Phone Number:</label>
						<c:set var="phoneNr" value="${user.phoneNumber}" />
							<c:if test="${user.phoneNumber eq ''}">
								<c:set var="phoneNr" value="--" />
							</c:if>
						<div class="col-lg-5">${phoneNr}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-age">Age:</label>
						<c:set var="age" value="${user.age}" />
							
							<c:if test="${user.age eq ''}">
								<c:set var="age" value="--" />
							</c:if>
						<div class="col-lg-5">${age}</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-sex">Sex:</label>
						<c:set var="sex" value="${user.sex}" />
							<c:if test="${user.sex ne 'M' && user.sex ne 'F'}">
								<c:set var="sex" value="--" />
							</c:if>
						<div class="col-lg-5">${sex}</div>
						<br>
					</div>
					
					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-description">Description:</label>
						<c:set var="descr" value="${user.userDescription}" />
							<c:if test="${user.userDescription eq ''}">
								<c:set var="descr" value="--" />
							</c:if>
						<div class="col-lg-5">${descr}</div>
						<br>
					</div>
					
				</td>									
			</tr>
		</table>
