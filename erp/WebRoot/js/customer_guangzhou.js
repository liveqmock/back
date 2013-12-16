/**
 * 广州的js
 */

var afterTwoLineIsCheck = false; //必填中除了最顶两行,其他的是否检查
var redFiledsIsCheck = false; //选填中的标红字段是否检查

var	redFileds = "";

$().ready(function(){
	//tip	sub

	$("#showOrHide").click(function(){

		$("#changeTable").toggle();
		$("#buttonTr").toggle();
		//$('table').find('tr:last').toggle();
		
	});
	
	
	///
	$("#customer_homeProvince").change(function(){
		proviToCity("customer_homeProvince", "customer_homeCity", "customer_homeRegion", "customer_homeBlock");
	});
	
	$("#customer_homeCity").change(function(){
		cityToRegion("customer_homeCity", "customer_homeRegion", "customer_homeBlock");
	});
	
	/**
	$("#customer_homeRegion").change(function(){
		regionToBlock("hiddenId", "customer_homeRegion", "customer_homeBlock");
	});
	*/
	
	///
	
	$("#customer_workProvince").change(function(){
		proviToCity("customer_workProvince", "customer_workCity", "customer_workRegion", "customer_workBlock");
	});
	
	$("#customer_workCity").change(function(){
		cityToRegion("customer_workCity", "customer_workRegion", "customer_workBlock");
	});
	
	/**
	$("#customer_homeRegion").change(function(){
		regionToBlock("hiddenId", "customer_homeRegion", "customer_homeBlock");
	});
	*/
	
	$("#customer_nativeProvince").change(function(){
		proviToCity("customer_nativeProvince", "customer_nativeCity", "customer_nativeRegion", "customer_nativeBlock");
	});
	
	$("#customer_nativeCity").change(function(){
		cityToRegion("customer_nativeCity", "customer_nativeRegion", "customer_nativeBlock");
	});
	
		
	$("#copyHome").click(function(){

		if ($("#copyHome").attr("checked") == "checked") {
			//整个copy过来,并设定选中
			var homeProvince = $("#customer_homeProvince").val();
			$("#customer_workProvince").attr("value", homeProvince);
			
			var homeCityHtml = $("#customer_homeCity").html();
			var homeCity = $("#customer_homeCity").val();				
			$("#customer_workCity").empty();
			$("#customer_workCity").append(homeCityHtml);
			$("#customer_workCity").attr("value", homeCity);					
			
			var homeRegion = $("#customer_homeRegion").val();
			//var homeRegionHtml = $('#customer_homeRegion option:selected').text(); //选中的文本值
			var homeRegionHtml = $("#customer_homeRegion").html();
			$("#customer_workRegion").empty();
			$("#customer_workRegion").append(homeRegionHtml);
			$("#customer_workRegion").attr("value", homeRegion);
			
			var homeBlock = $("#customer_homeBlock").val();
			var homeBlockHtml = $("#customer_homeBlock").html();
			$("#customer_workBlock").empty();
			$("#customer_workBlock").append(homeBlockHtml);
			$("#customer_workBlock").attr("value", homeBlock);
			
			var homeContent = $("#homeContent").val();
			$("#workContent").val(homeContent);

		}else{
			//还原
			var empty = "<option value=\"\">请选择</option>";
			$("#customer_workProvince").attr("value", "");
			
			$("#customer_workCity").empty();
			$("#customer_workCity").append(empty);
			
			$("#customer_workRegion").empty();
			$("#customer_workRegion").append(empty);
			
			//$("#customer_workBlock").empty();
			//$("#customer_workBlock").append(empty);
			$("#customer_workBlock").attr("value", "");
			
			$("#workContent").val("");

		}
	});

	//提示框 top
	$("#projectName").autocomplete("./customer_guangzhou/search/projects.action", {
		width: 150,  //提示框宽度
		selectFirst: false,
		setHiddenId: "hiddenId",
		selectFunIsArg: "true"
	});
	
	$("#projectName").result(function(event, data, formatted) {
		if (data){
			//$(this).parent().next().find("input").val(data[0]);
			//$("#suggestion").html(data[0]);
			
		}
	});	
	
	$("#projectName").blur(function(){
		
		var projectName = $("#projectName").val();	
		if(projectName == ""){
			$("#hiddenId").val("0");
			$(".red").remove();
		}
		
		$("#showProject").html("<font color=\"red\">" + projectName + "</red>");
	});
	
	
		
	/**
	var projectName = $("#projectName").val();		
	if(projectName != "" && projectName != " "){
		$.ajax({
			type:"post",
			url: "./customer_guangzhou/search/projectIsExists.action",
			data: "projectName=" + projectName,
			dataType: "html",
			success: function(data){
				var dataJson = eval("("+data+")");
				var isExists = dataJson.isExists;
				
				//先移除之前的
				$(".red").remove();
				
				if(isExists == "false"){
					//clearTip("项目: \"" + projectName + "\" 不存在");
					$("#projectName").val("");
					$("#projectName").focus();
					$("#showProject").html("");
					
					$("#hiddenId").val("0");
					
				}else{						
					$("#showProject").html("<font color=\"red\">" + projectName + "</red>");
					
					//设置项目id
					$("#hiddenId").val(dataJson.projectId);
					
					var reds = dataJson.redFiled.split("|");
					
					for(var i=0; i<reds.length; i++){
						
						var redVal = "<font color=\"red\" class=\"red\">*</font>";
						obj = $("#" + reds[i]).parent().prev();
						obj.prepend(redVal);
						
						//并设置标红字段不能为空						
						redFileds = reds;
							
						}
					}
				}
								
			});
			
			//设置家庭收入 setSelByIdAndAction(selId, action, args)
			setSelByIdAndAction("customer_familyIncome", "./customer_guangzhou/search/getSelFamilyIncome.action", "projectName=" + projectName);
			//设置客户评级
			setSelByIdAndAction("customer_rating", "./customer_guangzhou/search/getSelRating.action", "projectName=" + projectName);
				
		}else{
			
			$("#hiddenId").val("0");
			$(".red").remove();
		}
		
		
	});
	*/
	
	//提示框 end
	
	$("#selCustomerSource").change(function(){
		if($("#selCustomerSource").find("option:selected").val()==null || $("#selCustomerSource").find("option:selected").val()==""){
			myAlert("请先选择客户来源");
			$("#phone").val("");
			$("#homePhone").val("");
			$("#phoneCount").html("");
		}
		var projectId = $("#hiddenId").val();
		var phone = $("#phone").val();
		var customerSource = $("#selCustomerSource").find("option:selected").val();
		if(projectId == "" || projectId == "0"){
			
			clearTip("项目为空或者项目不存在");
			$("#phone").val("");
			$("#homePhone").val("");
			
		}else{
			
			//不为空,且符合电话格式
			if(phone != "" && phone.match("^\\d*$|^\\d*-\\d*$") != null){
				$.ajax({
					type:"post",
					url: "./customer_guangzhou/search/phoneIsExistsForMap.action",  
					data: "phone=" + phone + "&projectId=" + projectId + "&customerSource=" + customerSource,
					dataType: "json",
					success: function(data){
						if(data.customerId != "0"){
							//0表示不存在
							//如果存在,且为自己的客户,就出现查看按钮,否则就隐藏
						
							var base = $("#baseUrl").val();
							var tip = "电话: " + phone + " 已经存在(所属销售:" + data.userName + ")";
							
							if(data.isDeleted != "0"){
								
								tip += ",该号码已存在，状态为作废，请联系主管";
								
							}else if(data.show == "true"){
								
								tip += ",是否查看?<input type='button' value='  查看  ' " + 
									"onclick='window.location.href = \"" + base + "customer_guangzhou/update/getById.action?id=" + data.customerId + "\"'/>" 
								;
							}
							
							var dialog = new Dialog(tip,{title:'电话查看', closeFn:function closeFn(){$("#phone").val("");$("#phoneCount").html("")}});
							dialog.show();
							$("#phone").val("");
							$("#phoneCount").html("");
						}
					}
				});
			}
			var homePhone = $("#homePhone").val();
			if(homePhone != "" && homePhone.match("^\\d*$|^\\d*-\\d*$") != null){
				$.ajax({
					type:"post",
					url: "./customer_guangzhou/search/homePhoneIsExistsForMap.action",  
					data: "homePhone=" + homePhone + "&projectId=" + projectId + "&customerSource=" + customerSource,
					dataType: "json",
					success: function(data){
						if(data.customerId != "0"){
							
							var base = $("#baseUrl").val();
							var tip = "电话: " + homePhone + " 已经存在(所属销售:" + data.userName + ")";
							if(data.isDeleted != "0"){
								
								tip += ",该号码已存在，状态为作废，请联系主管";
								
							}else if(data.show == "true"){
								
								tip += ",是否查看?<input type='button' value='  查看  ' " + 
									"onclick='window.location.href = \"" + base + "customer_guangzhou/update/getById.action?id=" + data.customerId + "\"'/>" 
								;
							}								
							//$("#homePhone").val("");							
							var dialog = new Dialog(tip,{title:'电话查看', afterClose:function closeFn(){$("#homePhone").val("");}});	
							dialog.show();
							$("#homePhone").val("");
						}
					}
				});
			}
		}
	});
	
	$("#phone").blur(function(){
		var projectId = $("#hiddenId").val();
		var phone = $("#phone").val();
		var customerId = $("#customerId").val();
		var customerSource = $("#selCustomerSource").find("option:selected").val();
		if(projectId == "" || projectId == "0"){
			
			clearTip("项目为空或者项目不存在");
			$("#phone").val();
			
		}else{
			
			//不为空,且符合电话格式
			if(phone != "" && phone.match("^\\d*$|^\\d*-\\d*$") != null){
				$.ajax({
					type:"post",
					url: "./customer_guangzhou/search/phoneIsExistsForMap.action",  
					data: "phone=" + phone + "&projectId=" + projectId + "&customerId="+customerId + "&customerSource=" + customerSource,
					dataType: "json",
					success: function(data){
						if(data.customerId != "0"){
							//0表示不存在
							//如果存在,且为自己的客户,就出现查看按钮,否则就隐藏
							var base = $("#baseUrl").val();
							var tip = "电话: " + phone + " 已经存在(所属销售:" + data.userName + ")";
							
							if(data.isDeleted != "0"){
								
								tip += ",该号码已存在,状态为作废,请联系主管";
								
							}else if(data.show == "true"){
								
								tip += ",是否查看?<input type='button' value='  查看  ' " + 
									"onclick='window.location.href = \"" + base + "customer_guangzhou/update/getById.action?id=" + data.customerId + "\"'/>" 
								;
							}
							
							var dialog = new Dialog(tip,{title:'电话查看', closeFn:function closeFn(){$("#phone").val("");$("#phoneCount").html("")}});
							dialog.show();
							$("#phone").val("");
							$("#phoneCount").html("");
						}
					}
				});
			}
		}
									  
	});
	
	$("#homePhone").blur(function(){
		var projectId = $("#hiddenId").val();
		var homePhone = $("#homePhone").val();
		var customerId = $("#customerId").val();
		var customerSource = $("#selCustomerSource").find("option:selected").val();
		if(projectId == "" || projectId == "0"){
			
			clearTip("项目为空或者项目不存在");
			$("#homePhone").val("");
			
		}else{
			//不为空,且符合电话格式
			if(homePhone != "" && homePhone.match("^\\d*$|^\\d*-\\d*$") != null){
				$.ajax({
					type:"post",
					url: "./customer_guangzhou/search/homePhoneIsExistsForMap.action",  
					data: "homePhone=" + homePhone + "&projectId=" + projectId + "&customerId="+customerId + "&customerSource=" + customerSource,
					dataType: "json",
					success: function(data){
						if(data.customerId != "0"){ 
							//0表示不存在
							//如果存在,且为自己的客户,就出现查看按钮,否则就隐藏
							
							var base = $("#baseUrl").val();
							var tip = "电话: " + homePhone + " 已经存在(所属销售:" + data.userName + ")";
							if(data.isDeleted != "0"){
								
								tip += ",该号码已存在，状态为作废，请联系主管";
								
							}else if(data.show == "true"){
								
								tip += ",是否查看?<input type='button' value='  查看  ' " + 
									"onclick='window.location.href = \"" + base + "customer_guangzhou/update/getById.action?id=" + data.customerId + "\"'/>" 
								;
							}
							//$("#homePhone").val("");							
							var dialog = new Dialog(tip,{title:'电话查看', afterClose:function closeFn(){}});	
							dialog.show();
							$("#homePhone").val("");
						}
					}
				});
			}
		}
							  
	});
		
	
});

function validateCustForm(){
	var companyId = $("#hiddenCompanyId").val();
	var projectName = $("#projectName").val();
	
	if(projectName == ""){
		myAlert("项目不能为空");
		//$("#projectName").focus();
		return false;
	}

	var customerName = $.trim($("#customerName").val());
	if(customerName == ""){
		myAlert("客户姓名不能为空");
		$("#customerName").focus();
		$("#customerName").val("");
		return false;
	}

	//来访日期不能大于当天
	var visitDate = $("#visitDate").val();
	if(visitDate != undefined && visitDate != ""){

		var arr = visitDate.split("-");
		var visitDateTime = new Date(arr[0], parseInt(arr[1])-1, arr[2]);
		var visitDateTimeLong = visitDateTime.getTime();

		var nowTime = new Date();
		var nowTimeLong = nowTime.getTime();

		if(visitDateTimeLong > nowTimeLong){
			myAlert("来访日期不能超过当前日期");
			$("#visitDate").focus();
			$("#visitDate").val("");
			return false;
		}
	}

	//移动电话,固定电话可以只填一个
	var phone = $("#phone").val();
	if(phone != "" && phone.match("^\\d*$|^\\d*-\\d*$") == null){
		myAlert("移动电话不合规则");
		$("#phone").val("");
		$("#phone").focus();
		return false;
	}

	var homePhone = $("#homePhone").val();
	if(homePhone != "" && homePhone.match("^\\d*$|^\\d*-\\d*$") == null){
		myAlert("固定电话不合规则");
		$("#homePhone").val("");
		$("#homePhone").focus();
		return false;
	}

	if(phone == "" && homePhone == ""){
		myAlert("移动电话,固定电话至少要填写一个");
		$("#phone").focus();
		return false;
	}

	var customer_customerSource = $("#customer_customerSource").val();
	if(customer_customerSource == ""){
		myAlert("客户来源不能为空");
		$("#customer_customerSource").focus();
		return false;
	}

	if(afterTwoLineIsCheck == true){ // ---

		var customer_homeProvince = $("#customer_homeProvince").val();
		var customer_homeCity = $("#customer_homeCity").val();
		var customer_homeRegion = $("#customer_homeRegion").val();
		if(customer_homeProvince == "" || customer_homeCity == "" || customer_homeRegion == ""){
			myAlert("居住区域不完整");
			return false;
		}

		var customer_workProvince = $("#customer_workProvince").val();
		var customer_workCity = $("#customer_workCity").val();
		var customer_workRegion = $("#customer_workRegion").val();
		if(customer_workProvince == "" || customer_workCity == "" || customer_workRegion == ""){
			myAlert("工作区域不完整");
			return false;
		}

		var customer_buyUse = $("#customer_buyUse").val();
		if(customer_buyUse == ""){
			myAlert("购房用途不能为空");
			return false;
		}

		var customer_buyCount = $("#customer_buyCount").val();
		if(customer_buyCount == ""){
			myAlert("置业次数不能为空");
			return false;
		}

		var priceNum = $("#priceNum").val();
		if(priceNum == "" || priceNum.match("^\\d*$") == null){
			myAlert("意向总价不合规则");
			$("#priceNum").val("");
			$("#priceNum").focus();
			return false;
		}

		var customer_houseType = $("#customer_houseType").val();
		if(customer_houseType == ""){
			myAlert("产品类型不能为空");
			$("#customer_houseType").focus();
			return false;
		}

		var areaNum = $("#areaNum").val();
		if(areaNum == "" || areaNum.match("^\\d*$") == null){
			myAlert("意向面积不合规则");
			$("#areaNum").val("");
			$("#areaNum").focus();
			return false;
		}
	} // ----
	
	//中山公司的录入要求
	if(companyId == 32){
		
		var customer_homeProvince = $("#customer_homeProvince").val();
		var customer_homeCity = $("#customer_homeCity").val();
		var customer_homeRegion = $("#customer_homeRegion").val();
		var customer_workProvince = $("#customer_workProvince").val();
		var customer_workCity = $("#customer_workCity").val();
		var customer_workRegion = $("#customer_workRegion").val();
		var flag1 = true;
		var flag2 = true;
		if(customer_homeProvince == "" || customer_homeCity == "" || customer_homeRegion == ""){
			flag1 = false;
			//clearTip("居住区域不完整");
			//return false;
		}
		if(customer_workProvince == "" || customer_workCity == "" || customer_workRegion == ""){
			//clearTip("工作区域不完整");
			//return false;
			flag2 = false;
		}
		if(flag1 == false && flag2 == false){
			myAlert("居住区域和工作区域至少一个需填完整");
			return false;
		}

		var customer_buyUse = $("#customer_buyUse").val();
		if(customer_buyUse == ""){
			myAlert("购房用途不能为空");
			return false;
		}

		var customer_buyCount = $("#customer_buyCount").val();
		if(customer_buyCount == ""){
			myAlert("置业次数不能为空");
			return false;
		}

		var priceNum = $("#priceNum").val();
		if(priceNum == "" || priceNum.match("^\\d*$") == null){
			myAlert("意向总价不合规则");
			$("#priceNum").val("");
			$("#priceNum").focus();
			return false;
		}

		var customer_houseType = $("#customer_houseType").val();
		if(customer_houseType == ""){
			myAlert("产品类型不能为空");
			$("#customer_houseType").focus();
			return false;
		}

		var areaNum = $("#areaNum").val();
		if(areaNum == "" || areaNum.match("^\\d*$") == null){
			myAlert("意向面积不合规则");
			$("#areaNum").val("");
			$("#areaNum").focus();
			return false;
		}
	}

	if(redFiledsIsCheck == true){ // ----
		//设置标红字段不能为空 redFileds
		for(var i=0; i<redFileds.length; i++){
			//knownFrom  focusPoint
			var getRedFiled = redFileds[i];

			if(getRedFiled == "knownFrom"){
				var knownFroms = document.getElementsByName("knownFrom");
				var isCheck = false;

				for(var j=0; j<knownFroms.length; j++){
					if(knownFroms[j].checked == true){
						isCheck = true;
						break;
					}
				}

				if(!isCheck){
					myAlert("认知途径不能为空");
					return false;
				}

			}else if(getRedFiled == "focusPoint"){
				var focusPoints = document.getElementsByName("customerFocus"); //注意标红字段和多选框的name不一样
				var isCheck = false;

				for(var k=0; k<focusPoints.length; k++){
					if(focusPoints[k].checked == true){
						isCheck = true;
						break;
					}
				}

				if(!isCheck){
					myAlert("关注点不能为空");
					return false;
				}

			}else{

				var obj = $("#" + getRedFiled);
				var value = obj.val();
				if(value == ""){
					var tip = obj.parent().prev().text().trim();
					var index = tip.indexOf("*");
					if(index == 0){
						tip = tip.substr(1);
					}
					myAlert(tip + "不能为空");
					obj.focus();
					return false;
				}
			}

		}
	}
	var thisform = $("#thisform").serialize();
	$.ajax({
		type:"post",
		async:false,
		url:"./customer_guangzhou/update/validateQuestion.action?"+thisform,
		dataType:"json",
		success:function(data){
			if(data!=null){
				if(data.mustInput=="false"){
					myAlert("带*号为必填项，问卷存在必填项未填");
					return false;
				}else{
					//禁用提交按钮并提示提交中
					//$(this).attr("disabled", "disabled");
					$("#sub").attr("disabled", "disabled");
					//$("<font color='red' style='padding:0 10px 0 0'>提交中...</font>").insertBefore(this);
					$("#suggestion").html("");
					$("#tip").html("<img src='images/loading.gif' />提交中...");
					$("#thisform").submit();
					return true;
				}
				
			}
			
		},
		error:function (XMLHttpRequest, textStatus, errorThrown) {
			  // 通常情况下textStatus和errorThown只有其中一个有值 
			alert("error");
			  this; // the options for this ajax request
		}
	});	
// ----


}

function setSomeSel(projectId){
	if(projectId != "" && projectId != "0"){
		//设置家庭收入 setSelByIdAndAction(selId, action, args)
		setSelByIdAndAction("customer_familyIncome", "./customer_guangzhou/search/getSelFamilyIncomeByProjectId.action", "projectId=" + projectId);
		//设置客户评级
		setSelByIdAndAction("customer_rating", "./customer_guangzhou/search/getSelRatingByProjectId.action", "projectId=" + projectId);
	}
}

function selectFun(id){
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/search/getRedsByProjectId.action",
		data: "projectId=" + id,
		dataType: "json",
		success: function(data){
					
			//设置项目id
			$("#hiddenId").val(id);
			
			var reds = data.redFiled.split("|");
			
			for(var i=0; i<reds.length; i++){
				
				var redVal = "<font color=\"red\" class=\"red\">*</font>";
				obj = $("#" + reds[i]).parent().prev();
				obj.prepend(redVal);
				
				//并设置标红字段不能为空						
				redFileds = reds;					
				
			}
			
		}
		
	});			
	
	setSomeSel(id);
		
}

function loadReds(){
	
	var projectName = $("#projectName").val();
	var projectId = $("#hiddenId").val();
	
	if(projectId != ""){
		$.ajax({
			type:"post",
			url: "./customer_guangzhou/search/getRedsByProjectId.action",
			data: "projectId=" + projectId,
			dataType: "json",
			success: function(data){
						
				//设置项目
				$("#showProject").html("<font color=\"red\">" + projectName + "</red>");
				
				var reds = data.redFiled.split("|");
				
				for(var i=0; i<reds.length; i++){
					
					var redVal = "<font color=\"red\" class=\"red\">*</font>";
					obj = $("#" + reds[i]).parent().prev();
					obj.prepend(redVal);
					
					//并设置标红字段不能为空						
					redFileds = reds;					
					
				}
				
			}
			
		});			
	}
	
	//setSomeSel(projectId);
	
	/**
	var projectName = $("#projectName").val();
	
	if(projectName != ""){
		$.ajax({
			type:"post",
			url: "./customer_guangzhou/search/projectIsExists.action",
			data: "projectName=" + projectName,
			dataType: "html",
			success: function(data){
				var dataJson = eval("("+data+")");
				var isExists = dataJson.isExists;
				
				//先移除之前的
				$(".red").remove();
				
				if(isExists == "false"){
					clearTip("该项目不存在");
					$("#projectName").val("");
					$("#projectName").focus();
					$("#showProject").html("");
					
				}else{						
					$("#showProject").html("<font color=\"red\">" + projectName + "</red>");
					
					var reds = dataJson.redFiled.split("|");
					
					for(var i=0; i<reds.length; i++){
						
						var redVal = "<font color=\"red\" class=\"red\">*</font>";
						obj = $("#" + reds[i]).parent().prev();
						obj.prepend(redVal);
					}
					
					//并设置标红字段不能为空						
					redFileds = reds;
				}
			}
			
		});
		**/
		
		//设置家庭收入 setSelByIdAndAction(selId, action, args)
		//setSelByIdAndAction("customer_familyIncome", "./customer_guangzhou/search/getSelFamilyIncome.action", "projectName=" + projectName);
		//设置客户评级
		//setSelByIdAndAction("customer_rating", "./customer_guangzhou/search/getSelRating.action", "projectName=" + projectName);
	
}


/**
 * 搜索 top 
 */
function check(){
	var searchPhone = document.getElementById("searchPhone").value;
	var homePhone = document.getElementById("homePhone").value;
	var date1 = document.getElementById("date1").value;
	var date2 = document.getElementById("date2").value;
	
	if(searchPhone != ""){
		if(searchPhone.length < 3){
			alert("电话号码至少要3位");
			return false;
		}
		if(searchPhone.match("^\\d*$") == null){
			alert("电话号码只能为数字");
			document.getElementById("searchPhone").value = "";
			return false;
		}
	}
	
	if(homePhone != ""){
		if(homePhone.length < 3){
			alert("电话号码至少要3位");
			return false;
		}
		if(homePhone.match("^\\d*$") == null){
			alert("电话号码只能为数字");
			document.getElementById("homePhone").value = "";
			return false;
		}
	}
	
	if(date1 != "" && date2 != "" && date1 > date2){
		alert("前面的日期不能大于后面的日期");
		return false;
	}
	return true;
}

function clearTip(tipSug){
	
	$("#tip").html(tipSug);
	clearSome("tip",2000); //在天銮项目的更新中没有这个
	
	$("#suggestion").html(tipSug);
	clearSome("suggestion",2000);
}

function clearSuggestion(){
	
	clearSome("suggestion",2000);
	nowTime("nowTime");
	loadReds();
	
	//确定意向面积的单位,areaNumUnit
	if($("#hiddenId").val() == 158){
		$("#areaNumUnit").html("呎");
	}else{
		$("#areaNumUnit").html("㎡");
	}
}

//如果要清空就把下面的注释去掉
function clearSome(id, time){
	var ele = document.getElementById(id);
	if(ele != null){
		//setTimeout("document.getElementById('" + id + "').innerHTML = ''", time);
	}
}


function nowTime(id){

	//setInterval(getNowTime(), 1000); //重写setInterval方法,让其可以接收参数,默认的setInterval是不能接收参数的
	window.setInterval(function(){
		getNowTime(id);}, 1000);
}

function getNowTime(id){
	var nowTime = new Date();
	var hh = "0" + nowTime.getHours();
	var mm = "0" + nowTime.getMinutes();
	var ss = "0" + nowTime.getSeconds();
	var showNowTime = hh.substring(hh.length-2) + ":" + mm.substring(mm.length-2) + ":" + ss.substring(ss.length-2);
	var getEle = document.getElementById(id);
	if(getEle != null){
		getEle.innerHTML = showNowTime;
	}
}

/**

var js_element=document.createElement("script");  //创建一个script标签
js_element.setAttribute("type","text/javascript"); //脚本用的是javascript
js_element.setAttribute("src","./js/nowtime.js"); //script标签中引进的js文件
document.getElementsByTagName("head")[0].appendChild(js_element); //把script标签加入到<head></head>中

**/
