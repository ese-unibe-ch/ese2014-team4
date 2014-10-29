<%@ page language="java"  import="javax.servlet.jsp.PageContext" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/headerLogin.jsp" />
<h1><a href="${pageContext.request.contextPath}/register" >Not yet a Member? Register!</a></h1>
<table>
  	<tr>
		<th><h2> Login!</h2></th>
	</tr>
	<tr><td><fieldset> 
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
            <input type="password" name="j_password" value=""/>
            <div class="form-actions">
            	<input value="Login" name="submit" type="submit" class="btn btn-primary"/>
        	</div>
            
        </form></fieldset>
       </td>

  </tr>
</table>


    

	<c:if test="${page_error != null }">
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <h4>Error!</h4>
                ${page_error}
        </div>
    </c:if>
    
<c:import url="template/footer.jsp" />