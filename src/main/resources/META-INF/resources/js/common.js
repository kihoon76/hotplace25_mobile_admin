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
}(
	common = window.commom || {},
	jQuery
));