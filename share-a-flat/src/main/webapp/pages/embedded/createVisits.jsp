<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->

<c:import url="template/header.jsp" />
<h4>sendmessagebox</h4>
<form class="sandbox-container" role="form" action="/'.$ref.'/edit"
	method="get">
	<div class="form-group" id="sandbox-container">
		<input type="text" id="cal" data-date="12/03/2012">
	</div>

</form>

<!-- Load jQuery and bootstrap datepicker scripts -->
<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script type="text/javascript">
            // When the document is ready
            $(document).ready(function () {
            	$('#cal').datepicker({
            		
            	});
            });
        </script>

