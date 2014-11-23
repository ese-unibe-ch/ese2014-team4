<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>



<!-- only used as imported part of other pages, therefore no header / footer. -->


 <h4>Send a message to ${adData.owner.username}</h4>
 



<textarea required="true" class="form-control" path="mefssage" id="field-message"
						style="width:100%; height:121px; resize:none" tabindex="12"
						placeholder="Message"></textarea>
<br>

