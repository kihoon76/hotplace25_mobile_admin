<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<content tag="script">
<script src="/resources/js/jtsage-datebox.min.js" type="text/javascript"></script>
<script src="/resources/js/jtsage-datebox.i18n.ko.utf8.js" type="text/javascript" ></script>
<!-- ECharts -->
<script type="text/javascript" src="/resources/vendors/echarts/echarts.min.js"></script>
<script type="text/javascript" src="/resources/js/main.js"></script>
</content>
<content tag="style">
<link href="/resources/css/jtsage-datebox.min.css" rel="stylesheet" type="text/css">
<link href="/resources/css/main.css" rel="stylesheet" type="text/css">
</content>
<body>
	<input type="text" id="maechoolCal" value="${date}" style="text-align:center;"
		   data-role="datebox" 
		   data-options='{"mode":"calbox", "closeCallback":"selectPicker"}'>

	<form>
		<div class="ui-field-contain">
			<select id="maechoolType" data-type="${type}">
				<option value="MM" <c:if test="${type eq 'MM'}">selected</c:if>>월매출</option>
				<option value="DD" <c:if test="${type eq 'DD'}">selected</c:if>>일매출</option>
			</select>
		</div>
	</form>
	<c:choose>
		<c:when test="${json eq null}">
			<div class="no-data">매출이 없습니다.</div>
		</c:when>
		<c:otherwise>
			<div id="maechoolChart" style="width:100%; height: 400px; " data-json='${json}'></div>
		</c:otherwise>
	</c:choose>

</body>
