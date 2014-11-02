<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<div id="masthead">  
  <div class="container">
      <div class="row">
      	<div>
<!--         <div class="col-md-7"> -->
          <h1>My Page</h1>
          <hr>
        </div>
<!--         <div class="col-md-5"> -->
<!--             <div class="well well-lg">  -->
<!--               <div class="row"> -->
<!--                 <div class="col-sm-6"> -->
<!--         	      	<img src="//placehold.it/180x100" class="img-responsive"> -->
<!--                 </div> -->
<!--                 <div class="col-sm-6"> -->
<!-- 	              	Some text here -->
<!--                 </div> -->
<!--               </div> -->
<!--             </div> -->
<!--         </div> -->
      </div> 
  </div><!--/container-->
</div><!--/masthead-->

<div class="row">
          <div class="col-md-4">
            <div class="panel panel-default">
              <div class="panel-heading"><h3>Options</h3></div>
              <div class="panel-body"><a href="createAd" class="inactive"><span>Create Ad</span></a>
              </div>
            </div>
          </div>
          <div class="col-md-4">
            <div class="panel panel-default">
              <div class="panel-heading"><h3>My Profile</h3></div>
              <div class="panel-body"><c:import  url="profile.jsp" />
              <br><br>

			<div class="form-actions">
	        	<a type="button" href = "${pageContext.request.contextPath}/modifyProfile" class="btn btn-primary">Modify Profile</a>
	            
	            <!--  link to delete profile -->        
				<h6><small><a href = "${pageContext.request.contextPath}/deleteProfile">Delete Profile</a></small></h6>          
        	</div>
              </div>
            </div>
          </div> 
          <div class="col-md-4">
            <div class="panel panel-default">
              <div class="panel-heading"><h3>Subscriptions</h3></div>
              <div class="panel-body">b.
              </div>
            </div>
          </div>  
        </div> 

<!-- <hr> -->

<!-- <!--main--> 
<!-- <div class="container"> -->
<!-- 	<div class="row"> -->
<!--       left -->
<!--       <div class="col-md-3" id="leftCol"> -->
<!--         <ul class="nav nav-stacked" id="sidebar"> -->
<!--           <li><a href="#sec0">Section 0</a></li> -->
<!--           <li><a href="#sec1">Section 1</a></li> -->

<!--         </ul> -->
<!--       </div>/left -->
      
<!--       right -->
<!--       <div class="col-md-9"> -->
        
<!--         <hr> -->
<!--         <h4><a href="http://www.bootply.com/Gygh9swISB">Edit on Bootply (alternative layout)</a></h4> -->
<!--         <hr> -->

<!--         </div>/right -->
<!--   	</div>/row -->
<!-- </div>/container -->

<!-- <hr> -->

<!-- <div class="container"> -->
<!--     <h1>My Page</h1> -->
  	
<!--   	<hr> -->
  	
<!-- 	<div class="row"> -->
<!--       	left column -->
<!--       	<div class="col-md-3"> -->
<!--         	Auswahlreiter -->
<!--         	<ul> -->
<!--         		<li class="createAd"><a href="createAd" class="inactive"><span>Create Ad</span></a></li>  -->
<!-- 			</ul>     -->
<!--       	</div> -->
      
<!--       	edit form column -->
<!--       	<div class="col-md-9 personal-info"> -->

<!--        		appends user profile. the /profile method does not get invoked, only /my-page!        -->
<%-- 			<c:import  url="profile.jsp" /> --%>

<!-- 			<div class="form-actions"> -->
<%-- 	        	<a type="button" href = "${pageContext.request.contextPath}/modifyProfile" class="btn btn-primary">Modify Profile</a> --%>
	            
<!-- 	             link to delete profile         -->
<%-- 				<h6><small><a href = "${pageContext.request.contextPath}/deleteProfile">Delete Profile</a></small></h6>           --%>
<!--         	</div> -->
<!-- 		</div> -->
<!--   	</div> -->
  	
<!-- </div> -->

<c:import url="template/footer.jsp" />