<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<c:import url="template/header.jsp" />
<c:import url="functions/searchFunctions.jsp" />





<h1>Search List</h1>


<!-- Auswahlreiter -->



<ul>
	<li class="map"><a href="search?searchType=<c:choose><c:when test="${resultType eq 'list'}">map</c:when><c:otherwise>list</c:otherwise>
			</c:choose>" class="inactive"><span>Search Map</span></a></li>
</ul>




<div class="row">
	<div class="col-md-4">
 		<div class="panel panel-default">
 		
			<div class="panel-heading">
				<h3>Search-Criteria</h3>
			</div>
			
			<div class="panel-body">
				<c:import url="search-criteria.jsp" />
			</div>
			
 		</div>
	</div>

	<div class="col-md-8">
  		<div class="panel panel-default">
    		
    		<div class="panel-heading">
    			<h3>${whatToDisplay}</h3>
    		</div>
    		
    		<div class="panel-body">
    			<c:if test="${resultType eq 'list'}">
				<c:import url="searchResultsList.jsp" />
				</c:if>
				<c:if test=" ${resultType eq 'map'}">
				<c:import url="searchResultsMap.jsp" />
				</c:if>
    		</div>
    		
  		</div>
	</div>  
</div> 


<c:import url="template/footer.jsp" />

