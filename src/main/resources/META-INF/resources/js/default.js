$(function() {
//	$('nav#menu').mmenu();
//	
//	var API = $('nav#menu').data('mmenu');
	
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
	
	//$('#dvContent').css('height', document.documentElement.clientHeight + 'px')
	
//	$(document).on(
//		'pageshow',
//		function( e, ui )
//		{
//			$('#menu').trigger( 'setPage', [ $(e.target) ] );
//			$('#menu a').each(
//				function()
//				{
//					if ( $.mobile.path.parseUrl( this.href ).href == window.location.href )
//					{
//						$(this).trigger( 'setSelected.mm' );
//					}
//				}
//			);
//		}
//	);
	
	
});