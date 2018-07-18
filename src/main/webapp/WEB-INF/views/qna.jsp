<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<content tag="style">
<link rel="stylesheet" type="text/css"  href="/resources/css/form.css" />
<link rel="stylesheet" type="text/css"  href="/resources/css/button.css" />
<link rel="stylesheet" type="text/css"  href="/resources/css/validate.css" />
<style>
.control-field label {text-align:left; font-size:.9em;}
.qna-form {text-align:left; font-size:.9em;}
</style>
</content>
<content tag="script">
<script type="text/javascript" src="/resources/js/mvalidate.js"></script>
<script type="text/javascript" src="/resources/js/qna.js"></script>
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
		<input id="btnSearchQnA" type="button" value="검색"> 
	</fieldset>
	</form>
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
	    			<a  data-seq="${qna.seq}"
	    				data-phone="${qna.phone}"
	    				data-req-time="${qna.reqTime}"
	    				data-question="${qna.question}"
	    				data-process-yn="${qna.processYN}"
	    				data-process-content="${qna.processContent}"
	    				class="QNA"
	    				href="#"
	    				<c:if test="${qna.processYN eq 'N'}"> style="background-color:#ff0000;"</c:if>>
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
