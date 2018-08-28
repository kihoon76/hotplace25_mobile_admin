$(function() {
	var _key = '';
	var _link = '';
	
	$(document).on('click', '#btnBack', function() {
		$('#content2').remove();
		$('#content1').show(300, function() {
			//document.location.href = '#' + _link;
		});
	});
	
	$(document)
	.off('click', '.PAYMENT')
	.on('click', '.PAYMENT', function() {
		var $this = $(this);
		_key = $this.data('key');
		_link = $this.prop('name');
		
		common.getHtml({
			name: 'paymentDetail',
			success: function(data, textStatus, jqXHR) {
				$('#content1').hide(300);
				$('#dvContent').append(data);
				$('#id').val($this.data('accountId'));
				$('#depositor').val($this.data('depositor'));
				$('#method').val($this.data('method'));
				$('#price').val($this.data('price').toString().money() + '원 (' + $this.data('comment') + ')');
				
				var couponYN = $this.data('couponYn');
				var couponValue = $this.data('couponValue');
				var couponUnit = $this.data('couponUnit');
				var status = $this.data('status');
				var paymentDate = $this.data('paymentDate');
				
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
					$('#paydate').prop('readonly', true).val(paymentDate);
					
				}
				else {
					if($("#confirmPayment").hasClass('zbtn-default')) {
						$("#confirmPayment").toggleClass('zbtn-default zbtn-primary');
					}
					
					$('#confirmPayment').prop('disabled', false);
					$('#paydate').prop('readonly', false);
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
            	event.preventDefault();
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
		$.ajax('/payment/confirm', {
			dataType: 'json',
			contentType: 'application/json; charset=UTF-8',
			data: JSON.stringify({
				key: _key,
				paymentDate: $.trim($('#paydate').val())
			}),
			method: 'POST',
			context: document.body,
			success: function(data, textStatus, jqXHR) {
				console.log(data)
				if(data.success) {
					var y = $('#searchYear').val();
					var m = $('#searchMonth').val();
					window.location.href = '/payment/list?searchYear=' + y + '&searchMonth=' + m;
				}
				else {
					alert(data.errMsg);
				}
			},
			error: function() {
				alert('시스템 오류입니다.')
			}
    	});
	}
	
	//$('#dvContent').css('height', document.documentElement.clientHeight - 100 + 'px');
	
	$('#btnSearchPayment').on('click', function() {
		var y = $('#searchYear').val();
		var m = $('#searchMonth').val();
		
		window.location.href = '/payment/list?searchYear=' + y + '&searchMonth=' + m;
	});
});