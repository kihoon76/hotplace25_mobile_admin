$(function(common, $) {
	
	String.prototype.money = function() {
		var s = this;
    	s = s.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','); 
    	 
    	return s;
    }
	
	common.getFormatDate = function(date){
		var year = date.getFullYear();                                 
		var month = (1 + date.getMonth());                     
		month = month >= 10 ? month : '0' + month;     
		var day = date.getDate();                      
		day = day >= 10 ? day : '0' + day;             
		return  year + '-' + month + '-' + day;
	}
	
	common.openPopup = function() {
		$.mobile.changePage('#popup', {transition: 'pop', role: 'dialog' });
	}
	
	$('#btnClose').on('click', function() {
		$('#popup').dialog('close');
	});
	
	common.getHtml = function(opt) {
		$.ajax('/resources/templates/' + opt.name + '.html', {
			async : false,
			dataType : 'html',
			method : 'GET',
			activeMask : false,
			success : function(data, textStatus, jqXHR) {
				if(opt.success) opt.success(data, textStatus, jqXHR);
			},
			error: function(jqXHR, textStatus, e) {
				if(opt.error) opt.error(jqXHR, textStatus, e);
			}
		});
	}
}(
	common = window.commom || {},
	jQuery
));