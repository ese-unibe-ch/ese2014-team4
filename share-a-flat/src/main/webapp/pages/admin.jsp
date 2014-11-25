<%@ page language="java" import="javax.servlet.jsp.PageContext"
	pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<c:import url="template/headerLogin.jsp" />
<h3>hi, admin ${user.username}</h3>
<c:import url="template/footer.jsp" />