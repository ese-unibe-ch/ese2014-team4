<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />


RESULT!!

<!--  <label class="control-labe" for="field-adId"><b>Ad Id: </b><c:out value="${ad.title}" /></label> -->
<%-- <label class="control-labe" for="field-adId"><b>Ad Id: </b><c:out value="${price}" /></label>  --%>

<c:forEach items="${ads}" var="ad">
price: ${ad.price}
<c:out value="ad"/>
</c:forEach>



<c:import url="template/footer.jsp" />