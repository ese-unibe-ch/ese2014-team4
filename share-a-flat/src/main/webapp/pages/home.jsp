<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />


<h2><b>Hi ${username}</b></h2>
<h3>Here are the newest adds in RoomMate:</h3>



<c:import url="addList.jsp" />

<c:import url="template/footer.jsp" />