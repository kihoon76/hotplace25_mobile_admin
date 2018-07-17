$(function() {
	var _html = '';
	$(document).on('click', '#btnBack', function() {
		$('#dvContent').html('<div id="content1">' + _html + '</div>');
	});
	
	$(document)
	.off('click', '.PAYMENT')
	.on('click', '.PAYMENT', function() {
		var $this = $(this);
		_html = $('#content1').html();
		
		common.getHtml({
			name: 'paymentDetail',
			success: function(data, textStatus, jqXHR) {
				$('#content1').hide();
				$('#dvContent').html(data);
				$('#id').val($this.data('accountId'));
				$('#depositor').val($this.data('depositor'));
				$('#price').val($this.data('price').toString().money() + '원 (' + $this.data('comment') + ')');
				
				var couponYN = $this.data('couponYn');
				var couponValue = $this.data('couponValue');
				var couponUnit = $this.data('couponUnit');
				var status = $this.data('status');
				
				if(couponUnit) {
					couponUnit = (couponUnit == 1) ? '%' : '원';
				}
				
				if('N' == couponYN) {
					$('#coupon').val('쿠폰사용안함');
				}
				else {
					$('#coupon').val(couponValue.toString().money() + couponUnit + '할인');
				}
				
				if(status == 'Y') {
					if($("#confirmPayment").hasClass('zbtn-primary')) {
						$("#confirmPayment").toggleClass('zbtn-primary zbtn-default');
					}
					
					$('#confirmPayment').prop('disabled', true);
				}
				else {
					if($("#confirmPayment").hasClass('zbtn-default')) {
						$("#confirmPayment").toggleClass('zbtn-default zbtn-primary');
					}
					
					$('#confirmPayment').prop('disabled', false);
					_validate();
				}
			}
		});
	});
	
	function _validate() {
        $('#paymentDetail').mvalidate({
            type:1,
            onKeyup:true,
            sendForm:true,
            firstInvalidFocus:false,
            valid:function(event,options){
            	//$('#paymentDetail').submit();
            	_submit();
            },
            invalid:function(event, status, options){
               
            },
            eachField:function(event,status,options){
               
            },
            eachValidField:function(val){},
            eachInvalidField:function(event, status, options){},
            descriptions:{
            	paydate:{
                    required : '결제일자를 입력하세요',
                    pattern : '날짜형식은 YYYY-MM-DD 입니다.',
                },
            }
        });
	}
	
	function _submit() {
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
	}
});