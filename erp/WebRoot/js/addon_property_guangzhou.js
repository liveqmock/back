/**
 *  附属房产
 */
 
 
$().ready(function(){
	
	propertyProjectListForHiddenId("addPropertyName", "addPropertyHiddenId"); //项目的联想框,及用隐藏域保存其id
	
	getBuildListFromPropertyIdForAuto("addBuildName", "addPropertyHiddenId", "addBulidHiddenId");  //根据楼盘项目id,获取对应的楼栋联想提示框
	
	showDiv("addUnitName","addUnitHiddenId","addBulidHiddenId","addPropertyHiddenId");	
	
	//项目id有变化,要清空楼栋的值与id
	$("#addPropertyName").change(function(){
		$("#addBuildName").val("");
		$("#addBulidHiddenId").attr("value", ""); 				
	});
	
});

// 新建操作
function saveAddProperty(mainId){
	
	$('#suggId').html('提交中...');
	
	var unitId = $("#addUnitHiddenId").val();
		
	$.ajax({
		type:"post",
		url: "./saleunit/confirm/guangzhou/inputAddonProperty.action",
		data: "addProperty.mainId=" + mainId + "&addProperty.unitId=" + unitId,
		dataType: "html",
		success: function(data){
			
			$("#addPropertyName").val("");
			$("#addBuildName").val("");
			$("#addUnitName").val("");
						
			$("#addPropertyHiddenId").attr("value", ""); 		
			$("#addBulidHiddenId").attr("value", ""); 		
			$("#addUnitHiddenId").attr("value", ""); 		
			
			if(data != ""){
				//保存成功
				
				$('#suggId').html("<font color='red'>保存成功</font>");
				
			}else{				
				//保存失败
				
				$('#suggId').html("<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
	
}

// 新建弹出框
function createAddPropertyDialog(confirmId){
	
	var followDialog = 	
		 "<head>"
		+ "<script type=\"text/javascript\" language=\"javascript\" src=\"./js/addon_property_guangzhou.js\"></script>"
		+ "<script type=\"text/javascript\" language=\"javascript\" src=\"./js/customer_guangzhou_project.js\"></script>"
		+ "<script type=\"text/javascript\" language=\"javascript\" src=\"./js/unit_table.js\"></script>"
		+ "<link href=\"./css/unit_table.css\"  rel=\"stylesheet\" type=\"text/css\" charset=\"utf-8\"/>"
		+ "</head>"
		+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:nowrap' width='450px'>"
		+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:150px'>项目</td><td>&nbsp;&nbsp;"
		+ "<input type='text' id='addPropertyName'/>"
		+ "<input type='hidden' id='addPropertyHiddenId'/>"
		+ "</td></tr>"
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>分区楼栋</td><td>&nbsp;&nbsp;"
		+ "<input type='text' id='addBuildName'/>"
		+ "<input type='hidden' id='addBulidHiddenId'/>"
		+ "<td></tr>"
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>房间号</td><td>&nbsp;&nbsp;"
		+ "<input type='text' id='addUnitName'/>"
		+ "<input type='hidden' id='addUnitHiddenId'/>"
		+ "<td></tr>"
		+ "<tr bgcolor='#FFFFFF' align='center'><td colspan='2' height='28'>"
		+ "<input id='addPropertySubmit' type='button' value='  提交  ' "
		+ "onClick=\"saveAddProperty(" + confirmId + ")\"/><span id='suggId'></span></td></tr>"
		+ "</table></div>"
		;		
		
		var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">新建附属房产</p>', isReload:true});
		dialog.show();
		
}

// 修改操作
function updateAddProperty(addPropertyId){
	
	$('#suggId').html('提交中...');
	
	var unitId = $("#addUnitHiddenId").val();
		
	$.ajax({
		type:"post",
		url: "./saleunit/confirm/guangzhou/updateAddonProperty.action",
		data: "addProperty.id=" + addPropertyId + "&addProperty.unitId=" + unitId,
		dataType: "html",
		success: function(data){
			
			var dataJson = eval("("+data+")");
			
			$("#addPropertyName").val(dataJson.addPropertyName);
			$("#addBuildName").val(dataJson.addBuildName);
			$("#addUnitName").val(dataJson.addUnitName);
						
			$("#addPropertyHiddenId").attr("value", dataJson.addPropertyHiddenId); 		
			$("#addBulidHiddenId").attr("value", dataJson.addBulidHiddenId); 		
			$("#addUnitHiddenId").attr("value", dataJson.addUnitHiddenId); 		
			
			if(dataJson.isSucc == "true"){
				//保存成功
				
				$('#suggId').html("<font color='red'>保存成功</font>");
				
			}else{				
				//保存失败
				
				$('#suggId').html("<font color='red'>保存失败,请重新新建</font>");
			}
		}		
	});
	
}

// 修改弹出框
function updateAddPropertyDialog(addPropertyId){
	
	$.ajax({
		type:"post",
		url: "./saleunit/confirm/guangzhou/getAddonProperty.action",
		data: "addPropertyId=" + addPropertyId,
		dataType: "html",
		success: function(data){
			
			var followDialog = 	updateAddPropertyDialogStr(addPropertyId, data);
			
			var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">修改附属房产</p>', isReload:true});
			dialog.show();
		}
	});
	
	return false;
			
}

// 修改弹出框字符串
function updateAddPropertyDialogStr(addPropertyId, data){
	
	var dataJson = eval("("+data+")");
	
	var retStr = "<head>"
		+ "<script type=\"text/javascript\" language=\"javascript\" src=\"./js/addon_property_guangzhou.js\"></script>"
		+ "<script type=\"text/javascript\" language=\"javascript\" src=\"./js/customer_guangzhou_project.js\"></script>"
		+ "<script type=\"text/javascript\" language=\"javascript\" src=\"./js/unit_table.js\"></script>"
		+ "<link href=\"./css/unit_table.css\"  rel=\"stylesheet\" type=\"text/css\" charset=\"utf-8\"/>"
		+ "</head>"
		+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:nowrap' width='450px'>"
		+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:150px'>项目</td><td>&nbsp;&nbsp;"
		+ "<input type='text' id='addPropertyName' value='" + dataJson.addPropertyName + "'/>"
		+ "<input type='hidden' id='addPropertyHiddenId' value='" + dataJson.addPropertyHiddenId + "'/>"
		+ "</td></tr>"
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>分区楼栋</td><td>&nbsp;&nbsp;"
		+ "<input type='text' id='addBuildName' value='" + dataJson.addBuildName + "'/>"
		+ "<input type='hidden' id='addBulidHiddenId' value='" + dataJson.addBulidHiddenId + "'/>"
		+ "<td></tr>"
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>房间号</td><td>&nbsp;&nbsp;"
		+ "<input type='text' id='addUnitName' value='" + dataJson.addUnitName + "'/>"
		+ "<input type='hidden' id='addUnitHiddenId' value='" + dataJson.addUnitHiddenId + "'/>"
		+ "<td></tr>"
		+ "<tr bgcolor='#FFFFFF' align='center'><td colspan='2' height='28'>"
		+ "<input id='addPropertySubmit' type='button' value='  提交  ' "
		+ "onClick=\"updateAddProperty(" + addPropertyId + ")\"/><span id='suggId'></span></td></tr>"
		+ "</table></div>"
		;		
	
	return retStr;	
	
}


function showTip(tipSug){
	$("#suggestion").html(tipSug);
}


