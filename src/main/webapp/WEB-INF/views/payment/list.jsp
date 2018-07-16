<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<body>
	<c:choose>
	<c:when test="${error eq null}">
		<c:choose>
			<c:when test="${result eq null}">
				결제내역이 존재하지 않습니다.
			</c:when>
			<c:otherwise>
			<ul data-role="listview" data-inset="true">
			<c:forEach var="entry" items="${result}" varStatus="status">
				<li data-role="list-divider">${entry.key}<span class="ui-li-count">${entry.value['count']}</span></li>
				<c:forEach var="payment" items="${entry.value['list']}">
				<li>
	    			<a href="#popupPayment" <c:if test="${payment.status eq 'N'}"> style="background-color:#ff0000;"</c:if>>
		    			<h2><span class="text-ellip">${payment.accountId} (${payment.depositor})</span></h2>
		    			<p>${payment.applyComment}</p>
		    			<p><fmt:formatNumber type="number"  value="${payment.sum}" />원</p>
		        		<p class="ui-li-aside">결제시간: <strong>${payment.applyTime}</strong></p>
		    		</a>
	    		</li>
				</c:forEach>
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
