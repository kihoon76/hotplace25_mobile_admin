<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c"	uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"  href="/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css" />
    <script src="/resources/js/jquery.min.js"></script>
    <script src="/resources/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>

<body>
	<div data-role="page" id="callAjaxPage">
    	<div data-role="header">
      		<h1>mHotplace25 로그인</h1>
    	</div>
    
    	<div data-role="content">
      		<form method="post" action="/login">
        		<div data-role="fieldcontain">
          			<label for="id">아이디</label> 
          			<input type="text"	name="id" id="id" /> 
          			<label for="pw" style="margin-top:10px;">비밀번호</label>
          			<input type="password" name="pw" id="pw" />
          			<button data-theme="b" id="btnLogin" type="button" style="margin-top:15px;">로그인</button>
        		</div>
      		</form>
    	</div>
	</div>
	
  	<div data-role="page" id="alert">
		<div data-role="header">
			<h1></h1>
		</div>

		<div data-role="content" data-theme="b">	
			<p id="msg"></p>
			<br><br>
			<button data-rel="back">닫기</button>
		</div>
	</div>
	 <script type="text/javascript">
    	$('#btnLogin').on('click', function() {
    		$.ajax('/login', {
        		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
    			dataType: 'json',
    			method: 'POST',
    			context: document.body,
    			data: {
    				id:$('#id').val(),
    				pw:$('#pw').val()
    			},
    			success: function(data, textStatus, jqXHR) {
    				console.log(data)
    				if(data.success) {
    					window.location.href = 'main';
    				}
    				else {
    					$('#msg').html('아이디/비번을 확인해주세요.');
    					$.mobile.changePage( "#alert", {transition: 'pop', role: "dialog" } );
    				}
    			}
        	});
    	});
    
    </script>
</body>

</html>