$(function() {
	$('nav#menu').mmenu();
	
	$('#logout').on('click', function() {
		$.ajax('/logout', {
			dataType: 'json',
			method: 'GET',
			context: document.body,
			success: function(data, textStatus, jqXHR) {
				console.log(data)
				if(data.success) {
					window.location.href = '/';
				}
				else {
					
				}
			}
    	});
	});
	
	$('#payment').on('click', function() {
		window.location.href = '/payment/list';
	});
	
	$('#home').on('click', function() {
		window.location.href = '/';
	});
	
	$('#qna').on('click', function() {
		window.location.href = '/qna/list';
	});
});