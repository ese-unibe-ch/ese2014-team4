<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<<script type="text/javascript">
function addReceiverId(){
	var receicerId = document.getElementById("field-receiverId");
	
		receiverId.value = "${adData.owner.id}";
}

</script>


<!-- only used as imported part of other pages, therefore no header / footer. -->


<h4>Send a message to ${adData.owner.username}</h4>


<form:form method="post" modelAttribute="messageForm"
	action="sendMessage" id="messageForm" cssClass="form-horizontal"
	autocomplete="off" onsubmit="addReceiverId()">

	<textarea required="true" class="form-control" path="message"
		id="field-message" style="width: 100%; height: 121px; resize: none"
		tabindex="1" placeholder="Message"></textarea>
	<div class="form-actions">
		<button type="submit" class="btn btn-primary" tabindex="13">Send</button>
	</div>
	<br>
	
<!-- 	<div -->
<!-- 			class="control-group"> -->
<!-- 			<label class="control-label" for="receiverId">Id of receiver</label> -->
<!-- 			<div class="controls"> -->
<%-- 				<form:input type="text"  --%>
<%-- 					path="receiverId" id="field-receiverId" class="form-control" --%>
<%-- 					tabindex="2" maxlength="35" value="0"	/> --%>
				
<!-- 			</div> -->
<!-- 		</div> -->
	
</form:form>

<script type="text/javascript">
	
</script>

