<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />


<h1>Search Result</h1>

<div class="map">
	<a href="search-map" class="inactive"> <span> <!-- <img src="/neutral/imids/homegate/icon_tab_map.gif" />-->Map Search</span></a>
</div>
<hr>



<c:import url="resultsTable.jsp" />



<c:import url="template/footer.jsp" />