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
		<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
		<script type="text/javascript" src="/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
		<script type="text/javascript" src="/resources/js/jquery.mmenu.all.js"></script>
		<script>
		$(function() {
			$('#menu').mmenu({
				onClick		: {
					blockUI			: false,
					preventDefault	: function() {
						return this.rel != 'external';
					}
				}
			}, {
				pageSelector: 'div[data-role="page"]:first'
			});
			$('#menu a[rel!="external"]').on(
				'click',
				function()
				{
					var _t = this;
					$('#menu').one(
						'closed.mm',
						function()
						{
							$.mobile.changePage( _t.href, {
								transition: 'slide'
							});
						}
					);
				}
			);
		});
		$(document).on(
			'pageshow',
			function( e, ui )
			{
				$('#menu').trigger( 'setPage', [ $(e.target) ] );
				$('#menu a').each(
					function()
					{
						if ( $.mobile.path.parseUrl( this.href ).href == window.location.href )
						{
							$(this).trigger( 'setSelected.mm' );
						}
					}
				);
			}
		);
		</script>
	</head>
	<body>
		<!-- https://github.com/FrDH/jQuery.mmenu/blob/v4.1.0/demo/jqmobile/index.html -->
		<div data-role="page">
			<div class="header">
				<a href="#menu" data-ajax="false"></a>
				jQuery Mobile demo
			</div>
			<div id="content" data-role="content">
				<p>This is a testpage for integrating the jQuery.mmenu plugin in a jQuery Mobile project.<br />
					It includes internal (#page2) and external linking (page3.html)</p>

				<p><em>Note:</em> Since jQuery Mobile uses AJAX to load pages, this example will only work in a server environment.</p>

				<p>Here are some links for testing purposes:</p>
				<ul>
					<li><a href="#menu">Open the menu.</a></li>
					<li><a href="/main#page2">Go to &quot;#page2&quot; (an internal page).</a></li>
					<li><a href="/payment/list">Go to &quot;page3.html&quot; (an external page).</a></li>
				</ul>
			</div>
		</div>

		<div id="page2" data-role="page">
			<div class="header">
				<a href="#menu" data-ajax="false"></a>
				jQuery Mobile
			</div>
			<div class="content" data-role="content">
				<p>This is the internal testpage (#page2).</p>
				<ul>
					<li><a href="#menu">Open the menu.</a></li>
					<li><a href="index.html">Go to &quot;index.html&quot; (the original page).</a></li>
					<li><a href="page3.html">Go to &quot;page3.html&quot; (an external page).</a></li>
				</ul>
			</div>
		</div>

		<nav id="menu">
			<ul>
				<li class="Selected"><a href="index.html">Page 1</a></li>
				<li><a href="index.html#page2">Page 2</a></li>
				<li><a href="/payment/list">Page 3</a></li>
				<li class="Label">External</li>
				<li><a href="../index.html" rel="external">Back to the documentation</a></li>
			</ul>
		</nav>
	</body> 
</html>
