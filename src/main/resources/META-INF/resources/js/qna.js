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
	.off('click', '.QNA')
	.on('click', '.QNA', function() {
		var $this = $(this);
		_key = $this.data('seq');
		//_link = $this.prop('name');
		
		common.getHtml({
			name: 'qnaDetail',
			success: function(data, textStatus, jqXHR) {
				$('#content1').hide(300);
				$('#dvContent').append(data);
				
				$('#reqTime').val($this.data('reqTime'));
				$('#phone').prop('href', 'tel:' + $this.data('phone')).text($this.data('phone'));
				
				$('#question').val($this.data('question'));
				
				var processYN = $this.data('processYn');
				
				if('N' == processYN) {
					$('#processContent').val($this.data('processContent'));
					$('#processContent').prop('readonly', false);
					
					if($('#processQuestion').hasClass('zbtn-default')) {
						$('#processQuestion').toggleClass('zbtn-default zbtn-primary');
					}
					
					$('#processQuestion').prop('disabled', false);
					_validate();
				}
				else {
					if($('#processQuestion').hasClass('zbtn-primary')) {
						$('#processQuestion').toggleClass('zbtn-primary zbtn-default');
					}
					
					$('#processQuestion').prop('disabled', true);
					$('#processContent').val($this.data('processContent'));
					$('#processContent').prop('readonly', true);
				}
			}
		});
	});
	
	function _validate() {
        $('#qnaDetail').mvalidate({
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
            	processContent:{
                    required : '처리내용을 입력하세요'
                },
            }
        });
	}
	
	function _submit() {
		$.ajax('/qna/process', {
			dataType: 'json',
			contentType: 'application/json; charset=UTF-8',
			data: JSON.stringify({
				seq: _key,
				processContent: $.trim($('#processContent').val())
			}),
			method: 'POST',
			context: document.body,
			success: function(data, textStatus, jqXHR) {
				console.log(data)
				if(data.success) {
					var y = $('#searchYear').val();
					var m = $('#searchMonth').val();
					window.location.href = '/qna/list?searchYear=' + y + '&searchMonth=' + m;
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
	
	$('#btnSearchQnA').on('click', function() {
		var y = $('#searchYear').val();
		var m = $('#searchMonth').val();
		
		window.location.href = '/qna/list?searchYear=' + y + '&searchMonth=' + m;
	});
});