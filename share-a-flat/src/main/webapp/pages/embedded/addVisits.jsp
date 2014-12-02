<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<!-- only used as imported part of other pages, therefore no header / footer. -->


				<table id="visitTable">
					<tr><th></th>
						<th>Date</th>
						<th>from</th>
						<th>to</th>
					</tr>

					<tr>
					<c:choose><c:when test="${fn:length(visitList) eq 0}">
						<TD><INPUT type="checkbox" name="chk"/></TD>
						<td><input type="text" name="visitDate[0]" id="dateInput0"
							size="7" tabindex="15" /></td>
						<td><input name="startTime[0]" size="3" tabindex="15" /></td>
						<td><input name="endTime[0]" size="3" tabindex="15" /></td>	
					</c:when><c:otherwise><c:forEach items="${visitList}" var="visit" varStatus="loop">
						<tr><TD><INPUT type="checkbox" name="chk" value="${visit.date}"/></TD>
						<td><input type="text" name="visitDate[${loop.index}]" id="dateInput${loop.index}"
							size="7" tabindex="15" value="${visit.date}" /></td>
						<td><input name="startTime[${loop.index}]" size="3" tabindex="15" value="${visit.startTime}" /></td>
						<td><input name="endTime[${loop.index}]" size="3" tabindex="15" value="${visit.endTime}" /></td></tr>					
					</c:forEach></c:otherwise></c:choose>
</tr>



					
				</table>

				    <INPUT type="button" value="Add visit" onclick="addRowVisit('visitTable')" />
 
    				<INPUT type="button" value="Delete selected visit" onclick="deleteRow('visitTable')" />



				<script type="text/javascript">
					// When the document is ready
					$(document).ready(function() {
						$('#dateInput0').datepicker({ format: "dd-mm-yyyy" });
					});
				</script>
		
				    <SCRIPT type="text/javascript">
        function addRowVisit(tableID) {
 
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
 
		//delete defined in addFlatmates	
 
    </SCRIPT>

 

 
