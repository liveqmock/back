/**
 *关于金额的帮助类
 *
 */
 
//只能修改小数点后面的位数,moduleId为要绑定的组件,toFixed为位数
function modifyPoint(moduleId, toFixed){
	
	var realFixed = toFixed;
	if(toFixed == undefined || isNaN(toFixed)){
		realFixed = 2;
	}
	var endZero  = "";
	for(var zeroIndex=1; zeroIndex<=realFixed; zeroIndex++){
		endZero += "0";
	}
	
	$("#" + moduleId).attr("title", "可修改小数部分");
	
	$("#" + moduleId).focus(function(){
		var val = $(this).val();
		if(val == ""){
			val = "0";
		}
		var index = val.indexOf(".");
		
		var point = "" //小数点后面的数
		if(index > -1){
			//表示有小数点
			point = val.substring(index+1, val.length);
			val = val.substring(0, index);
		}
		
		var hiddenId = "__" + moduleId + "_hiddenId__";
		var hidden = "<input type='hidden' id='" + hiddenId + "' value='" + val + "'/>";
		$(this).after(hidden);
		
		$(this).removeAttr("readonly");
		$(this).val(point);
		
	}).blur(function(){
		
		var hiddenId = "__" + moduleId + "_hiddenId__";
		
		var getPoint = $(this).val();
		if(isNaN(getPoint)){
			getPoint = "00";
		}else{
			getPoint = (getPoint + endZero).substring(0, realFixed);
		}
		$(this).val($("#" + hiddenId).val() + "." + getPoint);
		
		$("#" + hiddenId).remove();
		$(this).attr("readonly", "readonly");
		
	});
}

/**
 * 给金额加 千分位 如：123456 ==> 123,456
 * @param num
 * @returns {string}
 */
function commafy(num){
    if((num+"").trim()==""){
        return"";
    }
    if(isNaN(num)){
        return"";
    }
    num = num+"";
    if(/^.*\..*$/.test(num)){
        var pointIndex =num.lastIndexOf(".");
        var intPart = num.substring(0,pointIndex);
        var pointPart =num.substring(pointIndex+1,num.length);
        intPart = intPart +"";
        var re =/(-?\d+)(\d{3})/
        while(re.test(intPart)){
            intPart =intPart.replace(re,"$1,$2")
        }
        num = intPart+"."+pointPart;
    }else{
        num = num +"";
        var re =/(-?\d+)(\d{3})/
        while(re.test(num)){
            num =num.replace(re,"$1,$2")
        }
    }
    return num;
}