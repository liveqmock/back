/*
 * 
 * Date : 2012-04-24
 * valdate for input  
 */

(function($){
	
	$.fn.inputVal = function(options){
		var defaults = {
				type:'text',//text , num
				minlength:0,//最短
				maxlength:12,//最长
				errClass:'err_input_class',//input错误之后的样式
				errDiv:'org_box',
				massage:''
		}
	/* style:  .poppng{background:url(<%=basePath%>/images/pop.png) no-repeat}
	 * errDiv: <div id="org_box" class="poppng" style="height:20px; width:250px;
	 *		 position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;"></div>
	 *
	 * err_input_class: .err_input_class{
			border-color: red;
			border-width: 2px
		}
	 * */
		var options = $.extend(defaults , options);
		var $errdiv = $("#"+options.errDiv);
		$errdiv.bind('click',function(){$errdiv.hide()});
		var offset = $(this).offset();
		var thisw = $(this).width();
		var massgeoffset = {left:offset.left +5 ,top:offset.top - 30 }
		
		
		$(this).bind('blur',function(){
			var $str = $.trim($(this).val());
			if(options.type == 'num'){
				if(isNaN($str)){
					$(this).addClass(options.errClass);
					$errdiv.css(massgeoffset);
					$errdiv.text(options.massage+"请输入数字");
					$errdiv.css('display','block');
					return;
				}else if( $str.length < options.minlength || $str.length > options.maxlength){
					$(this).addClass(options.errClass);
					$errdiv.css(massgeoffset);
					$errdiv.text(options.massage+"长度范围"+options.minlength+"-"+options.maxlength);
					$errdiv.show();
					return;
				}else{
					$(this).removeClass(options.errClass);
					$errdiv.css('display','none');
					return;
				}
			}else if(options.type == 'text'){
				if( $str.length < options.minlength || $str.length > options.maxlength){
					$(this).addClass(options.errClass);
					$errdiv.css(massgeoffset);
					$errdiv.text(options.massage+"长度范围"+options.minlength+"-"+options.maxlength);
					$errdiv.show();
					return;
				}else{
					$(this).removeClass(options.errClass);
					$errdiv.css('display','none');
					return;
				}
			}
		});	
	}
})(jQuery);