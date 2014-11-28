<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->


				<table id="visitTable">
					<tr><th></th>
						<th>Date</th>
						<th>from</th>
						<th>to</th>
					</tr>

					<tr>
					<TD><INPUT type="checkbox" name="chk"/></TD>
						<td><input type="text" name="visitDate[0]" id="dateInput0"
							size="7" tabindex="15" /></td>
						<td><input name="startTime[0]" size="3" tabindex="15" /></td>
						<td><input name="endTime[0]" size="3" tabindex="15" /></td>
</tr>
						<!--if using type="date" it doesn't work in chrome because it wants to use the date-input type of html5
				that includes a date picker	wich doesn't work in firefox with the format mm/dd/yyyy, wich does not match 
				MM-DD-YYYY, wich is the format we specified. Result: unusable date, like 1009-07-06 or so-->



					
				</table>

				    <INPUT type="button" value="Add visit" onclick="addRow('visitTable')" />
 
    				<INPUT type="button" value="Delete selected visit" onclick="deleteRow('visitTable')" />



				<script type="text/javascript">
					// When the document is ready
					$(document).ready(function() {
						$('#dateInput0').datepicker({ format: "dd-mm-yyyy" });
					});
				</script>
		
				    <SCRIPT type="text/javascript">
        function addRow(tableID) {
 
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            rowCount--;
            var cell1 = row.insertCell(0);
            var element1 = document.createElement("input");
            element1.type = "checkbox";
            element1.name="chkbox[]";
            cell1.appendChild(element1);
 			
            var id = "dateInput" + rowCount
            var cell2 = row.insertCell(1);
            var element2 = document.createElement("input");
            element2.id = id ;
            element2.type = "text";
            element2.name = "visitDate["+rowCount+"]";
            element2.size="7"
            cell2.appendChild(element2);
 
            var cell3 = row.insertCell(2);
            var element3 = document.createElement("input");
            element3.type = "text";
            element3.name = "startTime["+rowCount+"]";
            element3.size="3"
            cell3.appendChild(element3);
            
            var cell4 = row.insertCell(3);
            var element4 = document.createElement("input");
            element4.type = "text";
            element4.name = "endTime["+rowCount+"]";
            element4.size="3"
            cell4.appendChild(element4); 
            
      
                $(element2).datepicker({ format: "dd-mm-yyyy" });
        }
 
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                if(null != chkbox && true == chkbox.checked) {
                    table.deleteRow(i);
                    rowCount--;
                    i--;
                }
 
 
            }
            }catch(e) {
                alert(e);
            }
        }
 
    </SCRIPT>

 

 
