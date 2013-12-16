/**
 * 恒大的js
 */

$().ready(function(){
	//tip	sub
	
	
	$("#sub").click(function(){
		
		var projectId = $("#saleMonitor_projectId").val();
		if(projectId == ""){
			//""表示为管理员, undefined表示为普通录入人员
			clearTip("请先选择项目");
			return false;
		}
		
		var phoneNum = $("#phoneNum").val();
		if(phoneNum == "" || phoneNum.match("^\\d*$") == null){
			clearTip("来电只能为数字");
			$("#phoneNum").val("");
			$("#phoneNum").focus();
			$("#phoneNum").addClass("leftcreateinputbox01x");
			$("#phoneNum").removeClass("leftcreateinputbox01");
			return false;
		}else{
			$("#phoneNum").removeClass("leftcreateinputbox01x");
			$("#phoneNum").addClass("leftcreateinputbox01");
			
		}
		
		var visitorNum = $("#visitorNum").val();
		if(visitorNum == "" || visitorNum.match("^\\d*$") == null){
			clearTip("来访只能为数字");
			$("#visitorNum").val("");
			$("#visitorNum").focus();
			$("#visitorNum").addClass("leftcreateinputbox01x");
			$("#visitorNum").removeClass("leftcreateinputbox01");
			
			return false;
		}else{
			$("#visitorNum").removeClass("leftcreateinputbox01x");
			$("#visitorNum").addClass("leftcreateinputbox01");
			
		}
		
		
		///----
		
		var houseNum = $("#houseNum").val();
		if(houseNum == "" ){
			clearTip("住宅只能为数字");
			$("#houseNum").val("");
			$("#houseNum").focus();
			return false;
		}
		
		var shopNum = $("#shopNum").val();
		if(shopNum == "" ){
			clearTip("商铺只能为数字");
			$("#shopNum").val("");
			$("#shopNum").focus();
			return false;
		}
		
		var parkNum = $("#parkNum").val();
		if(parkNum == "" ){
			clearTip("车位只能为数字");
			$("#parkNum").val("");
			$("#parkNum").focus();
			return false;
		}
		
		var houseArea = $("#houseArea").val();
		if(houseArea == "" ){
			clearTip("面积只能为数字");
			$("#houseArea").val("");
			$("#houseArea").focus();
			return false;
		}
		
		var shopArea = $("#shopArea").val();
		if(shopArea == "" ){
			clearTip("面积只能为数字");
			$("#shopArea").val("");
			$("#shopArea").focus();
			return false;
		}
		
		
		var parkArea = $("#parkArea").val();
		if(parkArea == "" ){
			clearTip("面积只能为数字");
			$("#parkArea").val("");
			$("#parkArea").focus();
			return false;
		}
		
		var houseMoney = $("#houseMoney").val();
		if(houseMoney == "" ){
			clearTip("住宅金额只能为数字");
			$("#houseMoney").val("");
			$("#houseMoney").focus();
			return false;
		}
		
		var shopMoney = $("#shopMoney").val();
		if(shopMoney == "" ){
			clearTip("商铺金额只能为数字");
			$("#shopMoney").val("");
			$("#shopMoney").focus();
			return false;
		}
		
		var parkMoney = $("#parkMoney").val();
		if(parkMoney == "" ){
			clearTip("车位金额只能为数字");
			$("#parkMoney").val("");
			$("#parkMoney").focus();
			return false;
		}
		
		var undoHouseNum = $("#undoHouseNum").val();
		if(undoHouseNum == "" ){
			clearTip("住宅只能为数字");
			$("#undoHouseNum").val("");
			$("#undoHouseNum").focus();
			return false;
		}
		
		var undoShopNum = $("#undoShopNum").val();
		if(undoShopNum == "" ){
			clearTip("商铺只能为数字");
			$("#undoShopNum").val("");
			$("#undoShopNum").focus();
			return false;
		}
		var undoParkNum = $("#undoParkNum").val();
		if(undoParkNum == "" ){
			clearTip("车位只能为数字");
			$("#undoParkNum").val("");
			$("#undoParkNum").focus();
			return false;
		}
	
		var undoHouseArea = $("#undoHouseArea").val();
		if(undoHouseArea == "" ){
			clearTip("面积只能为数字");
			$("#undoHouseArea").val("");
			$("#undoHouseArea").focus();
			return false;
		}
		
		var undoShopArea = $("#undoShopArea").val();
		if(undoShopArea == "" ){
			clearTip("面积只能为数字");
			$("#undoShopArea").val("");
			$("#undoShopArea").focus();
			return false;
		}
	
		var undoParkArea = $("#undoParkArea").val();
		if(undoParkArea == "" ){
			clearTip("面积只能为数字");
			$("#undoParkArea").val("");
			$("#undoParkArea").focus();
			return false;
		}
		
		var undoHouseMoney = $("#undoHouseMoney").val();
		if(undoHouseMoney == "" ){
			clearTip("住宅退挞定金额只能为数字");
			$("#undoHouseMoney").val("");
			$("#undoHouseMoney").focus();
			return false;
		}
		
		var undoShopMoney = $("#undoShopMoney").val();
		if(undoShopMoney == "" ){
			clearTip("商铺退挞定金额金额只能为数字");
			$("#undoShopMoney").val("");
			$("#undoShopMoney").focus();
			return false;
		}
		
		var undoParkMoney = $("#undoParkMoney").val();
		if(undoParkMoney == "" ){
		clearTip("车位退挞定金额金额只能为数字");
			$("#undoParkMoney").val("");
			$("#undoParkMoney").focus();
			return false;
		}
		
		
		var monitorDate = $("#monitorDate").val();
		if(monitorDate == ""){
			clearTip("日期不能为空");
			$("#monitorDate").focus();
			return false;
		}
		
		var intentionNum = $("#intentionNum").val();
		if(intentionNum == "" ){
			$("#intentionNum").val(0);
		}else if(intentionNum.match("^\\d*$") == null){
			$("#intentionNum").val("");
			$("#intentionNum").focus();
			return false;
		}
	
		
		
//		var rescissionNum = $("#rescissionNum").val();
//		if(rescissionNum == "" || rescissionNum.match("^\\d*$") == null){
//			clearTip("挞订只能为数字");
//			$("#rescissionNum").val("");
//			$("#rescissionNum").focus();
//			return false;
//		}				
//		
//		var tempNum = $("#tempNum").val();
//		if(tempNum == "" || tempNum.match("^\\d*$") == null){
//			clearTip("临定只能为数字");
//			$("#tempNum").val("");
//			$("#tempNum").focus();
//			return false;
//		}
//		
//		var completeArea = $("#completeArea").val();
//		if(completeArea == "" || completeArea.match("^\\d*$") == null){
//			clearTip("齐定面积只能为数字");
//			$("#completeArea").val("");
//			$("#completeArea").focus();
//			return false;
//		}
//		
//		var completeMoney = $("#completeMoney").val();
//		if(completeMoney == "" || completeMoney.match("^\\d*$") == null){
//			clearTip("齐定金额只能为数字");
//			$("#completeMoney").val("");
//			$("#completeMoney").focus();
//			return false;
//		}
//		$("input[type=text]").each(function(){
//			var inputvalue = $(this).val().replace(/(^\s*)|(\s*$)/g, "");
//			if(inputvalue==""||inputvalue==null){
//				$(this).val(0);
//				return true;
//			}
//			
//		});


		///sman start
		
		var contractHouseNum = $("#contractHouseNum").val();
		if(contractHouseNum == "" ){
			clearTip("住宅只能为数字");
			$("#contractHouseNum").val("");
			$("#contractHouseNum").focus();
			return false;
		}
		
		var contractShopNum = $("#contractShopNum").val();
		if(contractShopNum == "" ){
			clearTip("商铺只能为数字");
			$("#contractShopNum").val("");
			$("#contractShopNum").focus();
			return false;
		}
		
		var contractParkNum = $("#contractParkNum").val();
		if(contractParkNum == "" ){
			clearTip("车位只能为数字");
			$("#contractParkNum").val("");
			$("#contractParkNum").focus();
			return false;
		}
		
		var contractHouseArea = $("#contractHouseArea").val();
		if(contractHouseArea == "" ){
			clearTip("面积只能为数字");
			$("#contractHouseArea").val("");
			$("#contractHouseArea").focus();
			return false;
		}
		
		var contractShopArea = $("#contractShopArea").val();
		if(contractShopArea == "" ){
			clearTip("面积只能为数字");
			$("#contractShopArea").val("");
			$("#contractShopArea").focus();
			return false;
		}
		
		
		var contractParkArea = $("#contractParkArea").val();
		if(contractParkArea == "" ){
			clearTip("面积只能为数字");
			$("#contractParkArea").val("");
			$("#contractParkArea").focus();
			return false;
		}
		
		var contractHouseMoney = $("#contractHouseMoney").val();
		if(contractHouseMoney == "" ){
			clearTip("住宅金额只能为数字");
			$("#contractHouseMoney").val("");
			$("#contractHouseMoney").focus();
			return false;
		}
		
		var contractShopMoney = $("#contractShopMoney").val();
		if(contractShopMoney == "" ){
			clearTip("商铺金额只能为数字");
			$("#contractShopMoney").val("");
			$("#contractShopMoney").focus();
			return false;
		}
		
		var contractParkMoney = $("#contractParkMoney").val();
		if(contractParkMoney == "" ){
			clearTip("车位金额只能为数字");
			$("#contractParkMoney").val("");
			$("#contractParkMoney").focus();
			return false;
		}
		
		///sman end
		
			
		
		return true;
	
	});
	
 
//	$('#houseNum').bind('keyup', getsunNum );

	
	
	
	$("#houseNum").blur(function(){	
	getsunNum();
	});	
	$("#parkNum").blur(function(){
	getsunNum();
	}); 
	$("#shopNum").blur(function(){
	getsunNum();
	}); 
	

	$("#houseArea").blur(function(){
		getsumArea();
	}); 
	$("#shopArea").blur(function(){
		getsumArea();
	}); 
	$("#parkArea").blur(function(){
		getsumArea();
	}); 
	
	
	$("#houseMoney").blur(function(){
		getTotalMoneySum();
		$("#MhouseMoney").text(changeCNAMoney($("#houseMoney").val()));
	}); 	
	$("#shopMoney").blur(function(){
		getTotalMoneySum();	
		$("#MshopMoney").text(changeCNAMoney($("#shopMoney").val()));
	}); 
	$("#parkMoney").blur(function(){
		getTotalMoneySum();
		$("#MparkMoney").text(changeCNAMoney($("#parkMoney").val()));
	}); 
	
	
	$("#undoHouseNum").blur(function(){
		getunDoHouseSunNum();
	}); 
	$("#undoShopNum").blur(function(){
		getunDoHouseSunNum();
	}); 
	$("#undoParkNum").blur(function(){
		getunDoHouseSunNum();
	}); 
	
	
	$("#undoHouseArea").blur(function(){
		getundoHouseAreaSum();		 
	}); 
	$("#undoShopArea").blur(function(){
		getundoHouseAreaSum();
	}); 
	$("#undoParkArea").blur(function(){
		getundoHouseAreaSum();
	}); 

	$("#undoHouseMoney").blur(function(){
		getTotalUndoMoneySum();
		 $("#MundoHouseMoney").text(changeCNAMoney($("#undoHouseMoney").val()));
	}); 
	$("#undoShopMoney").blur(function(){
		getTotalUndoMoneySum();
		$("#MundoShopMoney").text(changeCNAMoney($("#undoShopMoney").val()));
	}); 
	$("#undoParkMoney").blur(function(){
		getTotalUndoMoneySum();
		$("#MundoParkMoney").text(changeCNAMoney($("#undoParkMoney").val()));
	}); 
	
	//sman start 
	
	$("#contractHouseNum").blur(function(){
		getContractHouseNum();
	}); 
	$("#contractShopNum").blur(function(){
		getContractHouseNum();
	}); 
	$("#contractParkNum").blur(function(){
		getContractHouseNum();
	}); 
	
	$("#contractHouseArea").blur(function(){
		getContractSumArea();		 
	}); 
	$("#contractShopArea").blur(function(){
		getContractSumArea();
	}); 
	$("#contractParkArea").blur(function(){
		getContractSumArea();
	}); 

	$("#contractHouseMoney").blur(function(){
	    getContractMoneySum();
		$("#contractHouseMoneySum").text(changeCNAMoney($("#contractHouseMoney").val()));
	}); 
	$("#contractShopMoney").blur(function(){
		getContractMoneySum();
		$("#contractShopMoneySum").text(changeCNAMoney($("#contractShopMoney").val()));
	}); 
	$("#contractParkMoney").blur(function(){
		getContractMoneySum();
		$("#contractParkMoneySum").text(changeCNAMoney($("#contractParkMoney").val()));
	}); 
	
	//sman end
	
	
});


///sman start 

function getContractHouseNum(){
	IntCheck("contractHouseNum","请输入整数");
	IntCheck("contractShopNum","请输入整数");
	IntCheck("contractParkNum","请输入整数");
	var sum = Number($("#contractHouseNum").val())+Number($("#contractShopNum").val())+Number($("#contractParkNum").val());
	
	 $("#getContractHouseNum").text(sum);
}
	
function getContractSumArea(){
	numblurCheck("contractHouseArea","请输入合法数字,非负整数或小数");
	numblurCheck("contractShopArea","请输入合法数字,非负整数或小数");
	numblurCheck("contractParkArea","请输入合法数字,非负整数或小数");
	var sum =Number($("#contractHouseArea").val())+Number($("#contractShopArea").val())+Number($("#contractParkArea").val());
	
	 $("#getContractSumArea").text(sum);
}

function getContractMoneySum(){
	
	numblurCheck("contractHouseMoney","请输入合法数字,非负整数或小数");
	numblurCheck("contractShopMoney","请输入合法数字,非负整数或小数");
	numblurCheck("contractParkMoney","请输入合法数字,非负整数或小数");
	//alert($("#houseMoney").val());
	
	var sum = Number($("#contractHouseMoney").val())+Number($("#contractShopMoney").val())+Number($("#contractParkMoney").val());
	 $("#getContractMoneySum").text(displayComma(sum));
	
}

///sman end

function getTotalUndoMoneySum(){
	numblurCheck("undoHouseMoney","请输入合法数字,非负整数或小数");
	numblurCheck("undoShopMoney","请输入合法数字,非负整数或小数");
	numblurCheck("undoParkMoney","请输入合法数字,非负整数或小数");
	var sum = Number($("#undoHouseMoney").val())+Number($("#undoShopMoney").val())+Number($("#undoParkMoney").val());
	 $("#undoSumMoney").text(displayComma(sum)); 
}

function getTotalMoneySum(){
	
	numblurCheck("houseMoney","请输入合法数字,非负整数或小数");
	numblurCheck("shopMoney","请输入合法数字,非负整数或小数");
	numblurCheck("parkMoney","请输入合法数字,非负整数或小数");
	//alert($("#houseMoney").val());
	
	var sum = Number($("#houseMoney").val())+Number($("#shopMoney").val())+Number($("#parkMoney").val());
	 $("#sumMoney").text(displayComma(sum));
	
}
function getsunNum(){
	IntCheck("houseNum","请输入整数");
	IntCheck("shopNum","请输入整数");
	IntCheck("parkNum","请输入整数");
	var sum = Number($("#houseNum").val())+Number($("#shopNum").val())+Number($("#parkNum").val());
	
	 $("#sunNum").text(sum);
}
function getsumArea(){
	numblurCheck("houseArea","请输入合法数字,非负整数或小数");
	numblurCheck("shopArea","请输入合法数字,非负整数或小数");
	numblurCheck("parkArea","请输入合法数字,非负整数或小数");
	var sum =Number($("#houseArea").val())+Number($("#shopArea").val())+Number($("#parkArea").val());
	
	 $("#sumArea").text(sum);
}
function getunDoHouseSunNum(){
	IntCheck("undoParkNum","请输入整数");
	IntCheck("undoShopNum","请输入整数");
	IntCheck("undoHouseNum","请输入整数");
	var sum =Number($("#undoParkNum").val())+Number($("#undoShopNum").val())+Number($("#undoHouseNum").val());
	$("#unDoHouseSunNum").text(sum);
	
}
function getundoHouseAreaSum(){
	numblurCheck("undoHouseArea","请输入合法数字,非负整数或小数");
	numblurCheck("undoShopArea","请输入合法数字,非负整数或小数");
	numblurCheck("undoParkArea","请输入合法数字,非负整数或小数");
	
	var sum = Number($("#undoHouseArea").val())+Number($("#undoShopArea").val())+Number($("#undoParkArea").val());
	 $("#undoHouseAreaSum").text(sum.toFixed(0));
}

function numblurCheck(id, tipValue){
	//判断是否数字
	var value=$("#"+id).val();


		//非负整数或小数[小数最多精确到小数点后两位]
		var   reg   =   /^[0-9]+([.]{1}[0-9]{1,2})?$/;
		//去空格
		var tempvalue =value.replace(/(^\s*)|(\s*$)/g, "");
		 if(tempvalue!=""){
		if(tempvalue.match(reg)){
			$("#"+id).addClass("leftcreateinputbox01");
			$("#"+id).removeClass("leftcreateinputbox01x");
			return true;
		}else{
			$("#"+id).val("");
			$("#" + id).focus();
			$("#"+id).addClass("leftcreateinputbox01x");
			$("#"+id).removeClass("leftcreateinputbox01");
			
			clearTip(tipValue);
			
			return false;
		}
	}
};
function IntCheck(valId, tipValue){
	//判断是否整数
	var value = $("#" + valId).val();
	var tempvalue =value.replace(/(^\s*)|(\s*$)/g, "");
	if(tempvalue !=""){
	if(tempvalue.match("^\\d*$") == null){
		
		
		$("#" + valId).val("");
		$("#" + valId).focus();
		$("#"+valId).addClass("leftcreateinputbox01x");
		$("#"+valId).removeClass("leftcreateinputbox01");
		
		clearTip(tipValue);
		return false;
	}else{
		$("#"+valId).addClass("leftcreateinputbox01");
		$("#"+valId).removeClass("leftcreateinputbox01x");
		
		return true;
	}
	}
};

//金额三位进行截取
function displayComma(str) { 
	str = '' + str; 
	if ((str.indexOf("."))!= -1){ 
	str1 = str.substring(0,str.indexOf(".")); 
	str2 = str.substring(str.indexOf(".")); 
	}else{ 
	str1 = str; 
	} 
	if (str1.length > 3) { 
	var mod = str1.length % 3; 
	var output = (mod > 0 ? (str1.substring(0,mod)) : ''); 
	for (i=0 ; i < Math.floor(str1.length / 3); i++) { 
	if ((mod == 0) && (i == 0)) 
	output += str1.substring(mod+ 3 * i, mod + 3 * i + 3); 
	else 
	output += ',' + str1.substring(mod + 3 * i, mod + 3 * i + 3); 
	} 
	if ((str.indexOf("."))!= -1){ 
	output = output + str2; 
	} 
	return (output); 
	} 
	else return str; 
	} 
/* 
数字金额转换为中文
*/
function changeCNAMoney (money)
{
    //要先判断是否小数
	var index = money.indexOf(".");
	if(index > 0){
		money = money.substring(0, index);
	}

    var tempmoney="";
    if(money.length>4&&money.length<9){
    	if(money.length==5){
    	tempmoney="约"+ money.substring(0,1)+"万";
    	}
    	if(money.length==6){
        	tempmoney="约"+ money.substring(0,2)+"万";
        }
    	if(money.length==7){
        	tempmoney="约"+ money.substring(0,3)+"万";
        	}
        if(money.length==8){
           tempmoney="约"+ money.substring(0,4)+"万";
            }
    }
    if(money.length>8&&money.length<13){
    	if(money.length==9){
    	tempmoney ="约"+ money.substring(0,1)+"亿";
    	}
    	if(money.length==10){
        	tempmoney ="约"+ money.substring(0,2)+"亿";
        }
    	if(money.length==11){
        	tempmoney ="约"+ money.substring(0,3)+"亿";
        }
    	if(money.length==12){
        	tempmoney ="约"+ money.substring(0,4)+"亿";
        }
    }
   
    return tempmoney;

};

function numCheck(valId, tipValue){
	//判断是否数字
	var value = $("#" + valId).val();
	
	if(value.match("^\\d*$") == null){
		clearTip(tipValue);
		$("#" + valId).val("");
		$("#" + valId).focus();
		return false;
	}
};


/**
 * 搜索 top 
 */
function check(){
	var date1 = document.getElementById("date1").value;
	var date2 = document.getElementById("date2").value;
	
	if(date1 != "" && date2 != "" && date1 > date2){
		alert("前面的日期不能大于后面的日期");
		return false;
	}
	return true;
}

function allDel(){
	var delIds = document.getElementsByName("delId");
	var allDelVal = document.getElementById("allDel");
	
	if(allDelVal.checked == true){
		for(var i=0; i<delIds.length; i++){
			delIds[i].checked = true;
		}
	}else{
		for(var i=0; i<delIds.length; i++){
			delIds[i].checked = false;
		}
	}
}

function delId(){
	var delIds = document.getElementsByName("delId");
	var allDel = true;
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == false){
			allDel = false;
		}
	}
	
	if(allDel){
		document.getElementById("allDel").checked = true;
	}else{
		document.getElementById("allDel").checked = false;
	}
}

function delSales(action){
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == true){
			ids += delIds[i].value + "_";
		}
	}
	
	if(ids != ""){
		var r = confirm("确定删除所选数据?");
		if(r == true){
			location.href = action + "!delSales.action?ids=" + ids;
			
		}else{
			return false;
		}
	}else{
		alert("请选择要删除的数据.");
		return false;
	}
	
}
//presale删除
function delPre(action){
	var delIds = document.getElementsByName("delId");
	var ids = "";
	
	for(var i=0; i<delIds.length; i++){
		if(delIds[i].checked == true){
			ids += delIds[i].value + "_";
		}
	}
	
	if(ids != ""){
		var r = confirm("确定删除?");
		if(r == true){
			location.href = action + "!delPre.action?ids=" + ids;
			
		}else{
			return false;
		}
	}else{
		alert("请选择要删除的数据.");
		return false;
	}
	
}

function clearTip(tipSug){
		
	$("#suggestion").html(tipSug);
	clearSome("suggestion",5000);
}

function clearSuggestion(){
	clearSome("suggestion",5000);
}

function clearSome(id, time){
	var ele = document.getElementById(id);
	if(ele != null){
		setTimeout("document.getElementById('" + id + "').innerHTML = ''", time);
	}
}
