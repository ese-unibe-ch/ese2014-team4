<%@ page language="java"  import="javax.servlet.jsp.PageContext" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<style>
div.transbox {
	position: relative;
	left: 135px;
    width: 300px;
    height: 380px;
    margin: 60px 40px;
    background-color: #fff;
    border: 1px solid black;
    opacity: 0.6;
}
</style>

<c:import url="template/headerLogin.jsp" />


<%-- <h3><a href="${pageContext.request.contextPath}/" >Already have an Account? Go to Login!</a></h3> --%>
<!-- <table> -->
<!--   	<tr> -->
<!-- 		<th><h2> Login!</h2></th> -->
<!-- 	</tr> -->
<!-- 	<tr><td> -->
<%-- 	<form:form method="post" modelAttribute="signupForm" action="createAccount" id="signupForm" cssClass="form-horizontal"  autocomplete="off"> --%>
<!--     <fieldset> -->
<!--         <legend>Enter Your Information</legend> -->

<%--         <c:set var="emailErrors"><form:errors path="email"/></c:set> --%>
<%--         <div class="control-group<c:if test="${not empty emailErrors}"> error</c:if>"> --%>
<!--             <label class="control-label" for="field-email">Email</label> -->

<!--             <div class="controls"> -->
<%--                 <form:input path="email" id="field-email" tabindex="1" maxlength="45" placeholder="Email"/> --%>
<%--                 <form:errors path="email" cssClass="help-inline" element="span"/> --%>
<!--             </div> -->
<!--         </div>       -->
        
<%--         <c:set var="usernameErrors"><form:errors path="username"/></c:set> --%>
<%--         <div class="control-group<c:if test="${not empty usernameErrors}"> error</c:if>"> --%>
<!--             <label class="control-label" for="field-userName">User Name</label> -->
<!--             <div class="controls"> -->
<%--                 <form:input path="username" id="field-username" tabindex="2" maxlength="35" placeholder="User Name"/> --%>
<%--                 <form:errors path="username" cssClass="help-inline" element="span"/> --%>
<!--             </div> -->
<!--         </div> -->
        
<%--         <c:set var="passwordErrors"><form:errors path="password"/></c:set> --%>
<%--         <div class="control-group<c:if test="${not empty passwordErrors}"> error</c:if>"> --%>
<!--             <label class="control-label" for="field-password">password</label> -->
<!--             <div class="controls"> -->
<%--                 <form:password path="password" id="field-password" tabindex="3" maxlength="35" placeholder="password"/> --%>
<%--                 <form:errors path="password" cssClass="help-inline" element="span"/> --%>
<!--             </div> -->
<!--         </div> -->
 
<%--          <div class="control-group<c:if test="${not empty passwordRepeatedErrors}"> error</c:if>"> --%>
<!--             <label class="control-label" for="field-passwordRepeated">repeat password</label> -->
<!--             <div class="controls"> -->
<%--                 <form:password path="passwordRepeated" id="field-passwordRepeated" tabindex="3" maxlength="35" placeholder="repeat password"/> --%>
<%--                 <form:errors path="passwordRepeated" cssClass="help-inline" element="span"/> --%>
<!--             </div> -->
<!--         </div> -->
               
<!--         <div class="form-actions"> -->
<!--             <button type="submit" class="btn btn-primary">Register</button> -->
<!--             <button type="button" class="btn">Cancel</button> -->
<!--         </div> -->
<!--     </fieldset> -->
<%-- </form:form> --%>
<!--        </td> -->

<!--   </tr> -->
<!-- </table> -->

	                <li class="inactive"><a href="${pageContext.request.contextPath}/" >Already a Member? Go back to Login!</a></li>
	               
						</ul>
					</div>
				</div>
	
				<div class="inner cover">
		          	<div class="transbox">
		          		<p>
		           			<h1 class="cover-heading">Register!</h1>
		           			
		            		<form:form method="post" modelAttribute="signupForm" action="createAccount" id="signupForm" cssClass="form-horizontal"  autocomplete="off">
		
			       				<c:set var="emailErrors"><form:errors path="email"/></c:set>
			       				<div class="control-group<c:if test="${not empty emailErrors}"> error</c:if>">
			         			<label class="control-label" for="field-email">Email</label>
				            		<div class="controls">
						                <form:input path="email" id="field-email" tabindex="1" maxlength="45" placeholder="Email"/>
						                <form:errors path="email" cssClass="help-inline" element="span"/><br><br>
				            		</div>
			        			</div>      
			        
						        <c:set var="usernameErrors"><form:errors path="username"/></c:set>
						        <div class="control-group<c:if test="${not empty usernameErrors}"> error</c:if>">
						            <label class="control-label" for="field-userName">User Name</label>
						            <div class="controls">
						                <form:input path="username" id="field-username" tabindex="2" maxlength="35" placeholder="User Name"/>
						                <form:errors path="username" cssClass="help-inline" element="span"/><br><br>
						            </div>
						        </div>
			        
						        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
						        <div class="control-group<c:if test="${not empty passwordErrors}"> error</c:if>">
						            <label class="control-label" for="field-password">Password</label>
						            <div class="controls">
						                <form:password path="password" id="field-password" tabindex="3" maxlength="35" placeholder="Password"/>
						                <form:errors path="password" cssClass="help-inline" element="span"/><br><br>
						            </div>
						        </div>
			 
						         <div class="control-group<c:if test="${not empty passwordRepeatedErrors}"> error</c:if>">
						            <label class="control-label" for="field-passwordRepeated">Repeat password</label>
						            <div class="controls">
						                <form:password path="passwordRepeated" id="field-passwordRepeated" tabindex="3" maxlength="35" placeholder="Repeat password"/>
						                <form:errors path="passwordRepeated" cssClass="help-inline" element="span"/><br><br>
						            </div>
						        </div>
			               
						        <div class="form-actions">
						            <button type="submit" class="btn btn-primary">Register</button>
						            <button type="button" class="btn">Cancel</button>
						        </div>
						        
							</form:form>
						</p>
					</div>
				</div>
	
				<div class="mastfoot">
					<div class="inner">
						<p>ESE 2014 - Team 4</p>
					</div>
				</div>
			
			</div>
		</div>
	</div>
    

	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>
    
<c:import url="template/footer.jsp" />

 