<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!-- special css for thumbnail view -->
  <style>    ul {         
          padding:0 0 0 0;
          margin:0 0 0 0;
      }
      ul li {     
          list-style:none;
          margin-bottom:25px;           
      }
      ul li img {
          cursor: pointer;
      }
</style>


<c:import url="template/header.jsp" />

<h1>${adData.title} </h1>
        <!-- sets current_profile sex -->
        <c:set var="adTypeToShow" value="apartment" />
		<c:if test="${adData.type eq 'ROOM'}">
   		<c:set var="adTypeToShow" value="room" />
		</c:if>
		
<br>		
<p>${adTypeToShow}</p>

<script src="js/test.js" type="text/javascript">
function test(){document.getElementById("test").align = 'left';}
</script>
<p id="test">g</p>
<a href="javascript:test">sdf</a>
<p><b>Address</b><br>
${adData.address.street} ${adData.address.streetNumber}<br>
${adData.address.zipCode} ${adData.address.city}</p>

<div class="container">
<ul class="row">
<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4"><img src="img/defaultProfileImage.png" class="img-responsive" alt="${adData.id}/${imgId}" width="100px" height="100px" id="img${imgId}"></li>

<c:forEach items="${imageList}" var="imgId">
	
	<li class="col-lg-2 col-md-2 col-sm-3 col-xs-4"><img src="${pageContext.request.contextPath}/imageController/ad/${adData.id}/${imgId}" class="img-responsive" alt="${adData.id}/${imgId}" width="100px" height="100px" id="img${imgId}"></li>
	


</c:forEach>
</ul></div>
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">         
          <div class="modal-body">                
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
 <script>
       $(document).ready(function(){
           $('li img').on('click',function(){
                var src = $(this).attr('src');
                var img = '<img src="' + src + '" class="img-responsive"/>';
                $('#myModal').modal();
                $('#myModal').on('shown.bs.modal', function(){
                    $('#myModal .modal-body').html(img);
                });
                $('#myModal').on('hidden.bs.modal', function(){
                    $('#myModal .modal-body').html('');
                });
           });  
        })
 </script>
<c:import url="template/footer.jsp" />

 