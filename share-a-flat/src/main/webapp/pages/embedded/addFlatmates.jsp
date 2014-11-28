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
						<td><input name="flatmateList[0]" size="4" tabindex="16" /></td>
					</tr>
				</table>

				<button id="addFlatmate" type="button" onclick="addMore">Add
					another flatmate</button>

				<script>
					$(document).ready(function() {
						//add more file components if Add is clicked
						$('#addFlatmate').click(function() {
							var index = document.getElementById('flatmateTable').rows.length-1;
							$('#flatmateTable').append( '<tr><td><input name="flatmateList['+index+']" size="4" tabindex="16" /></td></tr>');
						});
					});
				</script>
			</div>
		</div>