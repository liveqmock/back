
//清空提示框
function clearSome(id, time){
	var ele = document.getElementById(id);
	if(ele != null){
		//setTimeout("document.getElementById('" + id + "').innerHTML = ''", time);
		//$("#" + id).html("");
	}
}


//去空格,可以利用正则,或者调用jquery的trim函数
function trim(str){
	return $.trim(str);
}


//排序的图标转换
function obIcon(){
	var url =  location.search;
	var index = url.indexOf("ob");
	
	if(index != -1){
		var ob = url.substring(index+3, index+5);
		
		if(ob % 2 == 1){
			
			$("#img" + ob).attr("src", "images/blue/downopen.gif");
		}else{
			$("#img" + ob).attr("src", "images/blue/upopen.gif");
		}

	}
}

//获取basePath
function getBasePath(){
	var basePath = $("base").first().attr("href");
	if(basePath == undefined){		
	
		basePath = "./";		
	}
	
	return basePath;
}

//重新加载页面
function reloadFn(){
	window.location.href = window.location.href;
}

//数字的正则判断,利用js本身的isNaN


//金额的正则判断
function isMoney(money){
	if(money == "" || !/^\d*\.?\d*$/.test(money)){
		return false;
	}
	return true;
}

//电话的正则判断
function isPhone(phone){	
	if(phone == "" || !/^\d*$|^\d*-\d*$/.test(phone)){
		return false;
	}
	return true;
}

//邮箱的正则判断
function isMail(mail){	
	if(mail == "" || !/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/.test(mail)){
		return false;
	}
	return true;
}

//日期(只是判断是否为合法的日期格式yyyy-MM-dd,而没有进行相关的值的验证,如2012-02-30一样视为合法)
function isDate(date){
	
	var d = Date.parse(date);	
	return !isNaN(d);
}

//检查函数,ids,suggs都是利用数组的形式传递,且二者要一一对应,如：myCheck(["id","name"],["id","名字"])
function myCheck(ids, suggs){
	
	for(var i=0; i<ids.length; i++){
		
		var id = ids[i];
		
		if(typeof id == "function"){
			
			return id();
			
		}else{
			
			var fIndex = id.indexOf(":");
			if(fIndex > 0){
				
				var checkType = id.substring(fIndex+1, id.length);
				id = id.substring(0,fIndex);
				if(checkType.toLowerCase() == "money"){
					
					var value = $("#" + id).val();
					if(!isMoney(value)){
						
						showTip(suggs[i] + "不合规则");
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
					
				}else if(checkType.toLowerCase() == "mail"){
					
					var value = $("#" + id).val();
					if(!isMail(value)){
						
						showTip(suggs[i] + "不合规则");
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
					
					
				}else if(checkType.toLowerCase() == "phone"){
					
					var value = $("#" + id).val();
					if(!isPhone(value)){					
						
						showTip(suggs[i] + "不合规则");
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
					
				}else if(checkType.toLowerCase() == "number"){
					
					var value = $("#" + id).val();
					if(value=="" || isNaN(value)){
						var sugg = $("#"+id).parent().prev().text();
						if(sugg != ""){
							sugg = trim(sugg);
							var index = sugg.indexOf("*");
							if(index > -1){
								sugg = sugg.substring(index+1, sugg.length);
							}
						}
			
						showTip(sugg + "不合规则");
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
				}else if(checkType.toLowerCase() == "function"){
					
					id();
					
				}else{
					
					alert("没有" + checkType + ",这种检查类型");
				}
				
			}else{
			
				var value = $("#" + id).val();
				//处理easyui 日期控件的值
				try{
					value = $("#" + id).datebox('getValue');
				}catch(e){
				}
				
				if(value == ""){				
		
					showTip(suggs[i] + "不能为空");
					$("#" + id).focus();
					return false;
				}
			}
		}
		
	}
	
	return true;
}

/**
	var ids = ["payType","payName","payMoney:money","payWay","inBank","bankWay"];
	return myCheckOnlyById(ids);
*/
function myCheckOnlyById(ids){
	//var ids = ["payType","payName","payMoney:money","payWay","inBank","bankWay"];
	for(var i=0; i<ids.length; i++){
		
		var id = ids[i];
		
		if(typeof id == "function"){
			
			return id();
			
		}else{
			
			var fIndex = id.indexOf(":");
			if(fIndex > 0){
				
				var checkType = id.substring(fIndex+1, id.length);
				id = id.substring(0,fIndex); //如果checkType为function,那么id为对应的function name
				if(checkType.toLowerCase() == "money"){
					
					var value = $("#" + id).val();
					if(!isMoney(value)){
						var sugg = $("#"+id).parent().prev().text();
						if(sugg != ""){
							sugg = trim(sugg);
							var index = sugg.indexOf("*");
							if(index > -1){
								sugg = sugg.substring(index+1, sugg.length);
							}
						}
			
						showTip(sugg + "不合规则");					
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
					
				}else if(checkType.toLowerCase() == "mail"){
					
					var value = $("#" + id).val();
					if(!isMail(value)){
						var sugg = $("#"+id).parent().prev().text();
						if(sugg != ""){
							sugg = trim(sugg);
							var index = sugg.indexOf("*");
							if(index > -1){
								sugg = sugg.substring(index+1, sugg.length);
							}
						}
			
						showTip(sugg + "不合规则");
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
					
					
				}else if(checkType.toLowerCase() == "phone"){
					
					var value = $("#" + id).val();
					if(!isPhone(value)){
						var sugg = $("#"+id).parent().prev().text();
						if(sugg != ""){
							sugg = trim(sugg);
							var index = sugg.indexOf("*");
							if(index > -1){
								sugg = sugg.substring(index+1, sugg.length);
							}
						}
			
						showTip(sugg + "不合规则");
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
					
				}else if(checkType.toLowerCase() == "number"){
					
					var value = $("#" + id).val();
					if(value=="" || isNaN(value)){
						var sugg = $("#"+id).parent().prev().text();
						if(sugg != ""){
							sugg = trim(sugg);
							var index = sugg.indexOf("*");
							if(index > -1){
								sugg = sugg.substring(index+1, sugg.length);
							}
						}
			
						showTip(sugg + "不合规则");
						$("#" + id).focus();
						$("#" + id).val("");
						return false;
					}
					
				}else{
					
					alert("没有" + checkType + ",这种检查类型");
				}
				
			}else{
					
				var value = $("#" + id).val();
				//处理easyui 日期控件的值
				try{
					value = $("#" + id).datebox('getValue');
				}catch(e){
				}
					
				if(value == ""){
					
					var sugg = $("#"+id).parent().prev().text();
					if(sugg != ""){
						sugg = trim(sugg);
						var index = sugg.indexOf("*");
						if(index > -1){
							sugg = sugg.substring(index+1, sugg.length);
						}
					}
		
					showTip(sugg + "不能为空");
					$("#" + id).focus();
					return false;
					//return sugg + "不能为空";
				}			
				
			}
			
		}
		
	}
	
	return true;
}

function showTip(tipSug){
	$("#suggestion").html(tipSug);
	$("#suggestion2").html(tipSug);
}

//日期控件date input 的中文
var dateInputCN = {   
	month_names: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],   
	short_month_names: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],   
	short_day_names: ["日", "一", "二", "三", "四", "五", "六"],  
	start_of_week:0,
	dateToString: function(date) {  
		var month = (date.getMonth() + 1).toString();  
		var dom = date.getDate().toString();  
		if (month.length == 1) month = "0" + month;  
		if (dom.length == 1) dom = "0" + dom;  
		return date.getFullYear() + "-" + month + "-" + dom;  
   }  
	  
};
	
	
function datepicker(dateId){
	jQuery.extend(DateInput.DEFAULT_OPTS, dateInputCN);   	
	$("#" + dateId).date_input();
}


//内存list的分页,pageNo为第几页,action为ajax url,htmlId为接收ajax返回值的id
function listPage(pageNo, action, htmlId){
	$.ajax({
		type:"post",
		url: action,
		data: "pageNo=" + pageNo,
		dataType: "html",
		success: function(data){
			
			$("#" + htmlId).html(data);
		}		
	});	
	
	return false;
}

