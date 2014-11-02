<%@ page language="java"  import="javax.servlet.jsp.PageContext" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<style>
div.transbox {
	position: relative;
	left: 135px;
    width: 300px;
    height: 270px;
    margin: 60px 40px;
    background-color: #fff;
/*     background-color: rgba(255,255,255,.5); */
    border: 1px solid black;
    opacity: 0.6;
}
</style>


<c:import url="template/headerLogin.jsp" />

<%-- <h1><a href="${pageContext.request.contextPath}/register" >Not yet a Member? Register!</a></h1> --%>
<!-- <table> -->
<!--   	<tr> -->
<!-- 		<th><h2> Login!</h2></th> -->
<!-- 	</tr> -->
<!-- 	<tr><td><fieldset>  -->
<%--         <form id="form" action="<c:url value="/letMeIn!"/>" Class="form-horizontal" method="POST"> --%>
         
<%--             <c:if test="${not empty param.err}"> --%>
<%--                 <div><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></div> --%>
<%--             </c:if> --%>
<%--             <c:if test="${not empty param.out}"> --%>
<!--                 <div>You've logged out successfully.</div> -->
<%--             </c:if> --%>
<%--             <c:if test="${not empty param.time}"> --%>
<!--                 <div>You've been logged out due to inactivity.</div> -->
<%--             </c:if> --%>

          
<!--             Username:<br> -->
<!--             <input type="text" name="j_username" value=""/><br><br> -->
<!--             Password:<br> -->
<!--             <input type="password" name="j_password" value=""/> -->
<!--             <div class="form-actions"> -->
<!--             	<input value="Login" name="submit" type="submit" class="btn btn-primary"/> -->
<!--         	</div> -->
            
<%--         </form></fieldset> --%>
<!--        </td> -->

<!--   </tr> -->
<!-- </table> -->


                <li class="inactive"><a href="${pageContext.request.contextPath}/register">Not yet a Member? Register!</a></li>
               
              </ul>
            </div>
          </div>

          <div class="inner cover">
          	<div class="transbox">
          		<p>
            		<h1 class="cover-heading">Login!</h1>
            		
             		<form id="form" action="<c:url value="/letMeIn!"/>" Class="form-horizontal" method="POST">
         
			            <c:if test="${not empty param.err}">
			                <div><c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></div>
			            </c:if>
			            <c:if test="${not empty param.out}">
			                <div>You've logged out successfully.</div>
			            </c:if>
			            <c:if test="${not empty param.time}">
			                <div>You've been logged out due to inactivity.</div>
			            </c:if>
	
	          
			            Username:<br>
			            <input type="text" name="j_username" value=""/><br><br>
			           
			            Password:<br>
			            <input type="password" name="j_password" value=""/><br><br>
			            
			            <div class="form-actions">
			            	<input value="Login" name="submit" type="submit" class="btn btn-primary"/>
			        	</div>
            
        			</form>
            	</p>
            </div>
          </div>

          <div class="mastfoot">
            <div class="inner">
              <p>ESE 2014 - Team 4</p>
            </div>
          </div>

        </div>
      </div>
    </div>


	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>
    
    
<c:import url="template/footer.jsp" />