<%@ page language="java" import="javax.servlet.jsp.PageContext"
	pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<style>
div.transbox {
	position: relative;
	left: 135px;
	width: 300px;
	height: 420px;
	margin: 60px 40px;
	background-color: #fff;
	border: 1px solid black;
	opacity: 0.6;
}

#error {
	color: red
}
</style>
<!-- focuses email field on load -->
<script type="text/javascript">
window.onload = function(){
  var text_input = document.getElementById ('field-email');
  text_input.focus ();
  text_input.select ();
}
</script>

<script>
  function checkPassword(password, passwordRepeated)
  {
    if (password.value != passwordRepeated.value) {
    	passwordRepeated.setCustomValidity('Passwords do not match!');
    } else {
    	passwordRepeated.setCustomValidity('');
    }
  }
</script>

<!-- <script type="text/javascript">                 -->
// 	function isValid() {
// 		var email = document.forms["signupForm"]["field-email"].value;
// 	    var userName = document.forms["signupForm"]["field-username"].value;
// 	    var pwd = document.forms["signupForm"]["field-password"].value;
// 	    var pwdRepeated = document.forms["signupForm"]["field-passwordRepeated"].value;
	    
	    
// 	    if (email=="" || userName=="" || pwd=="" || pwdRepeated=="") {
// 	    	alert("Please fill all required fields!");
// 	        return false;
// 	    }
	    
// 	    var regex = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
// 	    if (!regex.test(email)) {
// 	    	alert("Please enter a valid Email (E.g. example@example.example)");
// 	    	return false;
// 	    }
	    
// 	    if (pwd!=pwdRepeated) {
// 	    	alert("Reentered Password doesn't match!")
// 	    	return false;
// 	    }
// 	}                
<!-- </script> -->

<c:import url="template/headerLogin.jsp" />


<li class="inactive"><a href="${pageContext.request.contextPath}/">Already
		a Member? Go back to Login!</a></li>

</ul>
</div>
</div>

<div class="inner cover">
	<div class="transbox">

		<h1 class="cover-heading">Register!</h1>

		<c:if test="${page_error != null }">
			<div class="text-danger">
				<div id="error">
					<b>Error!</b>
				</div>
				${page_error}
			</div>
		</c:if>

		<form:form method="post" modelAttribute="signupForm"
			action="createAccount" onsubmit="return isValid()" id="signupForm"
			cssClass="form-horizontal" autocomplete="off">

			<c:set var="emailErrors">
				<form:errors path="email" />
			</c:set>
			<div
				class="control-group<c:if test="${not empty emailErrors}"> error</c:if>">
				<label class="control-label" for="field-email"><b>Email*</b></label>
				<div class="controls">
					<form:input required="true" path="email" id="field-email" tabindex="1"
						maxlength="45" placeholder="example@hotmail.com" type='email' pattern=".*@.*\..*" title="e.g. 'example@hotmail.com"/>
					<form:errors path="email" cssClass="help-inline" element="span" />
					<br>
					<br>
				</div>
			</div>

			<c:set var="usernameErrors">
				<form:errors path="username" />
			</c:set>
			<div
				class="control-group<c:if test="${not empty usernameErrors}"> error</c:if>">
				<label class="control-label" for="field-userName"><b>User
						Name*</b></label>
				<div class="controls">
					<form:input required="true" path="username" id="field-username" tabindex="2"
						maxlength="35" placeholder="User Name" />
					<form:errors path="username" cssClass="help-inline" element="span" />
					<br>
					<br>
				</div>
			</div>

			<c:set var="passwordErrors">
				<form:errors path="password" />
			</c:set>
			<div
				class="control-group<c:if test="${not empty passwordErrors}"> error</c:if>">
				<label class="control-label" for="field-password"><b>Password*</b></label>
				<div class="controls">
					<form:password required="true" path="password" id="field-password" tabindex="3"
						maxlength="35" placeholder="Password" />
					<form:errors path="password" cssClass="help-inline" element="span" />
					<br>
					<br>
				</div>
			</div>

			<div
				class="control-group<c:if test="${not empty passwordRepeatedErrors}"> error</c:if>">
				<label class="control-label" for="field-passwordRepeated"><b>Repeat
						password*</b></label>
				<div class="controls">
					<form:password required="true" path="passwordRepeated" id="field-passwordRepeated"
						tabindex="4" maxlength="35" placeholder="Repeat password" oninput="checkPassword(document.getElementById('field-password'), this);"/>
					<form:errors path="passwordRepeated" cssClass="help-inline"
						element="span" />
					<br>
					<br>
				</div>
			</div>

			<div class="form-actions">
				<button type="submit" class="btn btn-primary" tabindex="5">Register</button>
				<button type="button" onclick="history.go(-1);return true"
					tabindex="6" class=" btn">Cancel</button>
			</div>

		</form:form>
	</div>
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


<c:import url="template/footer.jsp" />