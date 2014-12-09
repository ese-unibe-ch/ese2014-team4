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
						<div class="col-lg-5">
						
							<c:set var="username" value="${user.username}" />
							<c:if test="${userProfile.username!=null}">
								<c:set var="username" value="${userProfile.username}"/>
							</c:if>
							
							${username}
						</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label">Email:</label>
						<div class="col-lg-5">
						
							<c:set var="email" value="${user.email}" />
							<c:if test="${userProfile.username!=null}">
								<c:set var="email" value="${userProfile.email}"/>
							</c:if>
							
							${email}
						</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-phoneNumber">Phone Number:</label>
													
						<div class="col-lg-5">
						
							<c:set var="phone" value="${user.phoneNumber}" />
							<c:if test="${userProfile.username!=null}">
								<c:set var="phone" value="${userProfile.phoneNumber}"/>
							</c:if>
							
							<c:if test="${empty phone}" >
								<c:set var="phone" value="--"/>
							</c:if>
															
							${phone}						
						</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-age">Age:</label>
						<c:set var="age" value="${userProfile.age}" />

						<div class="col-lg-5">
						
							<c:set var="age" value="${user.age}" />
							<c:if test="${userProfile.username!=null}">
								<c:set var="age" value="${userProfile.age}"/>
							</c:if>
								
							<c:if test="${empty age}" >
								<c:set var="age" value="--"/>
							</c:if>
																
							${age}							
						</div>
						<br>
					</div>

					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-sex">Sex:</label>
				
						<div class="col-lg-5">
						
							<c:set var="sex" value="${user.sex}" />
							<c:if test="${userProfile.username!=null}">
								<c:set var="sex" value="${userProfile.sex}"/>
							</c:if>
								
							<c:if test="${sex ne 'M' && sex ne 'F'}" >
								<c:set var="sex" value="--"/>
							</c:if>
						
							${sex}
						</div>
						<br>
					</div>
					
					<div class="form-group">
						<label class="col-lg-5 control-label" for="field-description">Description:</label>
	
						<div class="col-lg-5">
						
							<c:set var="descr" value="${user.userDescription}" />
							<c:if test="${userProfile.username!=null}">
								<c:set var="descr" value="${userProfile.userDescription}"/>
							</c:if>
								
							<c:if test="${empty descr}" >
								<c:set var="descr" value="--"/>
							</c:if>
						
							${descr}
						</div>
						<br>
					</div>
					
				</td>									
			</tr>
		</table>
