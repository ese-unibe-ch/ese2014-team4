<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/headerLogin.jsp" />
 <th><h1>Index Page: Not used currently. You should not be here!</h1></th> <!-- 
<table>
  <tr>
    
    <th><h1>Not a member yet?<br>Register here!</h1></th>
  </tr>
  
  <tr>
    <td><form:form method="post" modelAttribute="signupForm" action="signIn" id="signupForm" cssClass="form-horizontal"  autocomplete="off">
    <fieldset>
        <legend>Enter Your Information</legend>

        <c:set var="emailErrors"><form:errors path="email"/></c:set>
        <div class="control-group<c:if test="${not empty emailErrors}"> error</c:if>">
            <label class="control-label" for="field-email">Email</label>

            <div class="controls">
                <form:input path="email" id="field-email" tabindex="1" maxlength="45" placeholder="Email"/>
                <form:errors path="email" cssClass="help-inline" element="span"/>
            </div>
        </div>      
        
        <c:set var="userNameErrors"><form:errors path="userName"/></c:set>
        <div class="control-group<c:if test="${not empty userNameErrors}"> error</c:if>">
            <label class="control-label" for="field-userName">User Name</label>
            <div class="controls">
                <form:input path="userName" id="field-userName" tabindex="2" maxlength="35" placeholder="User Name"/>
                <form:errors path="userName" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
        <div class="control-group<c:if test="${not empty passwordErrors}"> error</c:if>">
            <label class="control-label" for="field-password">password</label>
            <div class="controls">
                <form:password path="password" id="field-password" tabindex="3" maxlength="35" placeholder="password"/>
                <form:errors path="password" cssClass="help-inline" element="span"/>
            </div>
        </div>
 
         <div class="control-group<c:if test="${not empty passwordRepeatedErrors}"> error</c:if>">
            <label class="control-label" for="field-passwordRepeated">repeat password</label>
            <div class="controls">
                <form:password path="passwordRepeated" id="field-passwordRepeated" tabindex="3" maxlength="35" placeholder="repeat password"/>
                <form:errors path="passwordRepeated" cssClass="help-inline" element="span"/>
            </div>
        </div>
               
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Register</button>
            <button type="button" class="btn">Cancel</button>
        </div>
    </fieldset>
</form:form></td>

  </tr>
</table>

        <H1>Test Login index page</H1>
        <form id="form" action="<c:url value="/index"/>" method="POST">
         
            <c:if test="${not empty param.err}">
                <div><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></div>
            </c:if>
            <c:if test="${not empty param.out}">
                <div>You've logged out successfully.</div>
            </c:if>
            <c:if test="${not empty param.time}">
                <div>You've been logged out due to inactivity.</div>
            </c:if>
             
            Username:<br>
            <input type="text" name="j_username" value=""/><br><br>
            Password:<br>
            <input type="password" name="j_password" value=""/>
             
            <input value="Login" name="submit" type="submit"/>
        </form>-->
<!-- 

<table>
  <tr>
    <th><h1>Login</h1></th>
  </tr>
  
  <tr>
    <td><form:form method="post" modelAttribute="loginForm" action="login" id="loginForm" cssClass="form-horizontal"  autocomplete="off">
    <fieldset>
        <legend>Enter Your Information</legend>
     
        
        <c:set var="userNameErrors"><form:errors path="userName"/></c:set>
        <div class="control-group<c:if test="${not empty userNameErrors}"> error</c:if>">
            <label class="control-label" for="field-userName">User Name</label>
            <div class="controls">
                <form:input path="userName" id="field-userName" tabindex="2" maxlength="35" placeholder="User Name"/>
                <form:errors path="userName" cssClass="help-inline" element="span"/>
            </div>
        </div>
        
        <c:set var="passwordErrors"><form:errors path="password"/></c:set>
        <div class="control-group<c:if test="${not empty passwordErrors}"> error</c:if>">
            <label class="control-label" for="field-password">password</label>
            <div class="controls">
                <form:password path="password" id="field-password" tabindex="3" maxlength="35" placeholder="password"/>
                <form:errors path="password" cssClass="help-inline" element="span"/>
            </div>
        </div>
 
               
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="button" class="btn">Cancel</button>
        </div>
    </fieldset>
</form:form></td>

  </tr>
</table>
-->

	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>


<c:import url="template/footer.jsp" />
