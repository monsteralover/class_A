<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="Controller를 거치는 JSP: view에서 보여줄 데이터가 존재하는 jsp"
    %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<strong> 공통디자인</strong><br/>
<ul>
	<c:forEach var="subject" items="${requestScope.controller_data }">
	<li><c:out value="${subject }"/></li>
	</c:forEach>
</ul>