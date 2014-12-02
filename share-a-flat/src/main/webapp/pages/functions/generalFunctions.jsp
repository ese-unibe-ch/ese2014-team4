<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<script type="text/javascript">
	function FocusOnInput() {
		document.getElementById("field-cityOrZip").focus();
	}
</script>


<script type="text/javascript">

function deleteMessageAlert() {

    if (confirm("Delete the message?") == true) {
      //  alert("Message deleted!");
        return true;
    } else {
      // alert("Message kept!");
       return false;
    }
}
</script>


<script type="text/javascript">

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

<script>
function validateDate() {  
	var dateformat = new RegExp("/^(0?[1-9]|[12][0-9]|3[01])[\-](0?[1-9]|1[012])[\-]\d{4}$/");  
// 	var dateformat = new RegExp("/^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/");  
	var inputText = document.forms["adForm"]["field-availableDate"].value;
	
	// Match the date format through regular expression  
	if(!dateformat.text(inputText)) {  
// 		document.form1.text1.focus();  
		inputText.focus();
		
		//Test which seperator is used '/' or '-'  
// 		var opera1 = inputText.value.split('/');  
		var opera2 = inputText.value.split('-');  
		
// 		lopera1 = opera1.length;  
		lopera2 = opera2.length; 
		
		// Extract the string into month, date and year  
// 		if (lopera1>1) {  
// 			var pdate = inputText.value.split('/');  
// 		}  
// 		else 
			if (lopera2>1) {  
			var pdate = inputText.value.split('-');  
		}  
		
		var dd = parseInt(pdate[0]);  
		var mm  = parseInt(pdate[1]);  
		var yy = parseInt(pdate[2]);
		
		// Create list of days of a month [assume there is no leap year by default]  
		var ListofDays = [31,28,31,30,31,30,31,31,30,31,30,31];  
		
		if (mm==1 || mm>2) {  
			if (dd>ListofDays[mm-1]) {  
				alert('Invalid date format!');  
				return false;  
			}  
		}  
		
		if (mm==2) {  
			var lyear = false;  
			
			if ( (!(yy % 4) && yy % 100) || !(yy % 400)) {  
				lyear = true;  
			}  
			
			if ((lyear==false) && (dd>=29)) {  
				alert('Invalid date format!');  
				return false;  
			}  
			
			if ((lyear==true) && (dd>29)) {  
				alert('Invalid date format!');  
				return false;  
			}  
		}  
	} 
	else {  
		alert("Invalid date format!");  
		inputText.focus();  
		return false;  
	}  
}
</script>