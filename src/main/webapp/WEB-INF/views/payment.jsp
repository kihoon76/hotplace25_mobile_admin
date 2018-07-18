<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<content tag="style">
<link rel="stylesheet" type="text/css"  href="/resources/css/form.css" />
<link rel="stylesheet" type="text/css"  href="/resources/css/button.css" />
<link rel="stylesheet" type="text/css"  href="/resources/css/validate.css" />
<style>
.control-field label {text-align:left; font-size:.9em;}
</style>
</content>
<content tag="script">
<script type="text/javascript" src="/resources/js/mvalidate.js"></script>
<script type="text/javascript" src="/resources/js/payment.js"></script>
</content>
<body>
	<form>
	<fieldset data-role="controlgroup" data-type="horizontal">
		<label for="searchYear">검색연도</label>
		<select id="searchYear">
			<c:forEach var="item" begin="${startYear}" end="${endYear}" step="1">
			<option value="${item}" <c:if test="${item eq year}">selected</c:if>>${item}년</option>
			</c:forEach>
		</select>
		<label for="searchMonth">검색월</label>
		<select id="searchMonth">
			<c:forEach var="item" begin="1" end="12" step="1">
			<option value="${item}" <c:if test="${item eq month}">selected</c:if>>${item}월</option>
			</c:forEach>
		</select>
		<input id="btnSearchPayment" type="button" value="검색"> 
	</fieldset>
	</form>
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
	    			<a  name="${payment.accountId}"
	    				data-account-id="${payment.accountId}" 
	    				data-depositor="${payment.depositor}"
	    				data-key="${payment.key}"
	    				data-price="${payment.sum}"
	    				data-coupon-yn="${payment.useCoupon}"
	    				data-coupon-value="${payment.couponValue}"
	    				data-coupon-unit="${payment.couponUnit}"
	    				data-comment="${payment.applyComment}"
	    				data-processor-id="${payment.processorId}"
	    				data-processor-name="${payment.processorName}"
	    				data-status="${payment.status}"
	    				data-payment-date="${payment.paymentDate}"
	    				class="PAYMENT" href="#" <c:if test="${payment.status eq 'N'}"> style="background-color:#ff0000;"</c:if>>
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
