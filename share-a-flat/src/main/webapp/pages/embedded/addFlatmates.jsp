<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!-- only used as imported part of other pages, therefore no header / footer. -->
	<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Flatmates</h3>
				<br>
			</div>

			<div class="panel-body">
				<table id="flatmateTable">
					<tr>
						<th>Name</th>

					</tr>
					<tr>
					<TD><INPUT type="checkbox" name="chk"/></TD>
						<td><input name="flatmateList[0]" size="10" tabindex="16" /></td>
					</tr>
				</table>
				    <INPUT id="button-addFlatmate" type="button" value="Add flatmate" onclick="addRowFlatmate('flatmateTable')" />
 
    				<INPUT id="button-deleteFlatmate" type="button" value="Delete selected flatmate" onclick="deleteRow('flatmateTable')" />


		    <SCRIPT type="text/javascript">
        function addRowFlatmate(tableID) {
 
            var table = document.getElementById(tableID);
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
            rowCount--;
            var cell1 = row.insertCell(0);
            var element1 = document.createElement("input");
            element1.type = "checkbox";
            element1.name="chkbox[]";
            cell1.appendChild(element1);
 			
            var id = "input" + rowCount
            var cell2 = row.insertCell(1);
            var element2 = document.createElement("input");
            element2.type = "text";
            element2.id = id;
            element2.name = "flatmateList["+rowCount+"]";
            element2.size="10"
            cell2.appendChild(element2);

        }
 
        function deleteRow(tableID) {
            try {
            var table = document.getElementById(tableID);
            var rowCount = table.rows.length;
 
            for(var i=0; i<rowCount; i++) {
            	alert(i);
                var row = table.rows[i];
                var chkbox = row.cells[0].childNodes[0];
                alert(rowCount);
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
			</div>
		</div>