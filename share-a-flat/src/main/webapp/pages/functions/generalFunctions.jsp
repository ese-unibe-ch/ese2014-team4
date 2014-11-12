<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">
	function FocusOnInput() {
		document.getElementById("field-cityOrZip").focus();
	}
</script>


<script>

function showAlert(){
	var cancelYes = confirm ( "Cancel and discard all?" );
	 if( cancelYes == true ){
	      //alert("User wants to continue!");
		  return true;
	   }else{
	      //alert("User does not want to continue!");
		  return false;
	   }
	//return true;
}

</script>