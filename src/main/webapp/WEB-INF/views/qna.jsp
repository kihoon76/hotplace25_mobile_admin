<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<body>
	<c:choose>
	<c:when test="${error eq null}">
		<c:choose>
			<c:when test="${result eq null}">
				문의사항이 없습니다.
			</c:when>
			<c:otherwise>
			<ul data-role="listview" data-inset="true">
			<c:forEach var="qna" items="${result}" varStatus="status">
				<li data-role="list-divider">${qna.reqTime}</li>
				<li>
	    			<a href="#">
		    			<h2><span class="text-ellip">${qna.phone}</span></h2>
		    			<p>${qna.question}</p>
		    		</a>
	    		</li>
			</c:forEach>
			</ul>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>
		<c:out value="${error}" />
	</c:otherwise>
	</c:choose>

</body>
