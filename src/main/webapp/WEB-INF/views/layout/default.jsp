<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width initial-scale=1.0 maximum-scale=1.0 user-scalable=yes" />
		<!-- Style Sheets --> 
		<link rel="stylesheet" type="text/css"  href="/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css" />
		<link rel="stylesheet" type="text/css"  href="/resources/css/mmenu.css" />
		<link rel="stylesheet" type="text/css"  href="/resources/css/jquery.mmenu.all.css" />
		<style>
			.menu-nav {width:100%; height:20px; margin-top: -20px; margin-bottom: 10px; text-align: left;}
		</style>
		<sitemesh:write property="page.style" />
		
		<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<script type="text/javascript" src="/resources/js/jquery.mmenu.all.js"></script>
	</head>
	<body>
		<div id="page" data-role="page">
			<div class="header">
				<a href="#menu"><span></span></a>
				Hotplace25 관리자
			</div>
			<div id="dvContent"  class="content">
				<div id="content1">
					<div class="menu-nav"><span id="spMenuNav"><c:out value="${menuNav}" /></span></div>
					<sitemesh:write property="body" />
				</div>
			</div>
		</div>
		<nav id="menu">
			<ul>
				<li><a href="/" rel="external">Home</a></li>
<!-- 					<li><span>About us</span> -->
<!-- 						<ul> -->
<!-- 							<li><a href="#about/history">History</a></li> -->
<!-- 							<li><span>The team</span> -->
<!-- 								<ul> -->
<!-- 									<li><a href="#about/team/management">Management</a></li> -->
<!-- 									<li><a href="#about/team/sales">Sales</a></li> -->
<!-- 									<li><a href="#about/team/development">Development</a></li> -->
<!-- 								</ul> -->
<!-- 							</li> -->
<!-- 							<li><a href="#about/address">Our address</a></li> -->
<!-- 						</ul> -->
<!-- 					</li> -->
				<li><a id="logout" href="#">로그아웃</a></li>
				<li><a href="/payment/list" rel="external">결제관리</a></li>
				<li><a href="/qna/list" rel="external">Q&A 관리</a></li>
			</ul>
		</nav>
		
		<script type="text/javascript" src="/resources/js/common.js"></script>
		<script type="text/javascript" src="/resources/js/default.js"></script>
		<sitemesh:write property="page.script" />
	</body> 
</html>
