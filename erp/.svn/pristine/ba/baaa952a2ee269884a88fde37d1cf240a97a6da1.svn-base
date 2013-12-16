/**
 *  其它一些公用的方法 
 *
 */

//返回格式:2012-01-01 
function getDateStr(date) {     

	var month = (date.getMonth() + 1).toString();  
	var dom = date.getDate().toString();  
	if (month.length == 1) month = "0" + month;  
	if (dom.length == 1) dom = "0" + dom;  
	
	return date.getFullYear() + "-" + month + "-" + dom;  
}  

//返回日期增加或减少天数,date为日期的getTime(),diffDay可以为正负
function getDateStrDiff(dateLong, diffDay){
	 
	var newLong = parseInt(dateLong) + parseInt(diffDay) * 24 * 60 * 60 * 1000;
	
	var date = new Date();
	date.setTime(newLong);
	
	return getDateStr(date);	
}

//获取yyyy-MM-dd与long之间的天数
function getDayDiff(dateStr, dateLong){
	
	var dates = dateStr.split("-");
	
	var date = new Date();
	date.setFullYear(dates[0], parseInt(dates[1]) - 1, dates[2]);	
	var newDateLong = date.getTime();
	
	return parseInt((newDateLong - parseInt(dateLong)) / (24 * 60 * 60 * 1000));
}

//清空还原下拉框
function initEmpeySelect(selectId){
	
	var empty = "<option value=\"\">请选择</option>";
	
	$("#" + selectId).empty();
	$("#" + selectId).append(empty);
}

//为第二个select赋值
function initAjaxDataSelect(selectId, data){
	
	$("#" + selectId).empty();
	$("#" + selectId).append(data);
}

//智能下拉框的共用方法,action的返回值格式为"text1|id1\ntext2|id2",如:荔园香堤|65\n合富|66,text为下拉框要显示的值,id为给hiddenId设置的值,otherDataId不使用就为""
function baseAutoComplete(textId, hiddenId, searchAction, otherDataId){
	
	$("#" + textId).autocomplete(searchAction, {
		width: 150,  //提示框宽度
		selectFirst: false,
		setHiddenId: hiddenId,
		otherDataId: otherDataId
	});	
	
	$("#" + textId).blur(function(){
		
		var value = $("#" + textId).val();
		
		if(trim(value) == ""){
			
			$("#" + hiddenId).val("");	
		}
	});

}

//判断数组是否包含
function isArrayInclude(array, value){
	
	var isInclude = false;
	
	for(var arr in array){
		if(array[arr] == value){
			
			isInclude = true;
			break;
		}
	}
	
	return isInclude;
}

//判断checkbox是否有选中
function isCheckboxCheck(checkboxs){
	
	var isCheck = false;
	$(checkboxs).each(function(index){
		
		var checked = $(this).attr('checked');
		if(checked == 'checked'){
			isCheck = true;
			return false;
		}
	});
	return isCheck;
}

//check label,点击多选框后面的文字可以选定对应的checkbox
function bindCheckboxLabel(){
	
	$('input:checkbox').each(function(index){
		
		var myCheckBox = $($(this).next()).attr('myCheckBox');
		if(myCheckBox == undefined){
			return true;
		}
		
		bindOneCheckbox(this);
		
	});
	
}

//为单个checkbox绑定事件
function bindOneCheckbox(checkbox){
	
	var label = $(checkbox).next();
	$(label).bind('click', function(){
			
		var checked = $(checkbox).attr('checked');
		if(checked == 'checked'){
			$(checkbox).removeAttr('checked');
		}else{
			$(checkbox).attr('checked', 'checked');
		}
		
	}).bind('mouseover', function(){
		
		//$(label).attr('style', 'color:#5482DE');
		$(label).css('color', '#5482DE');
	}).bind('mouseout', function(){
		
		$(label).css('color', '');
	});
}

$(document).ready(function(){
	bindCheckboxLabel();
});