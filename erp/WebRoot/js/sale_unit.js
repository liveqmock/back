/**
  * 主要用于楼盘项目,分区,楼栋
  *
  */
  
$().ready(function(){
	
	//saleUnitBind("_project", "_hiddenId", "_area", "_build");
	
});

function saleUnitBind(projectTextId, projectHiddenId, areaId, buildId){
	
	var projectKey = "projectId_";
	var areaKey = "areaId_";
	var cache = {}; //缓存使用
	
	$("#" + projectTextId).autocomplete("./customer_guangzhou/search/propertyProjects.action", {
		width: 150,  //提示框宽度
		selectFirst: false,
		setHiddenId: projectHiddenId
	});
	
	var emp = "<option value=\"\">请选择</option>";
	
	$("#" + projectTextId).blur(function(){
		
		var propertyValue = $("#" + projectHiddenId).val();
		if(propertyValue != "" && propertyValue != "0"){
			
			if(!cache[projectKey + propertyValue]){
			
				$.ajax({
					type:"post",
					url: "./saleunit/property/guangzhou/getAreaListByPropertyId.action",
					data: "propertyId=" + propertyValue,
					dataType: "html",
					success: function(data){
						
						$("#" + areaId).empty();
						$("#" + areaId).append(data);
						
						cache[projectKey + propertyValue] = data;
						
					}
					
				});
				
			}else{
				
				$("#" + areaId).empty();
				$("#" + areaId).append(cache[projectKey + propertyValue]);
				
			}
			
		}else{
			
			$("#" + areaId).empty();
			$("#" + areaId).append(emp);
			
		}
		
		$("#" + buildId).empty();
		$("#" + buildId).append(emp);

	});
	
	$("#" + areaId).change(function(){
		
		var areaValue = $("#" + areaId).val();
		if(areaValue != "" && areaValue != "0"){
			
			if(!cache[areaKey + areaValue]){
				$.ajax({
					type:"post",
					url: "./saleunit/property/guangzhou/getBuildListByAreaId.action",
					data: "areaId=" + areaValue,
					dataType: "html",
					success: function(data){
						
						$("#" + buildId).empty();
						$("#" + buildId).append(data);
						
						cache[areaKey + areaValue] = data;
						
					}
					
				});
				
			}else{
				
				$("#" + buildId).empty();
				$("#" + buildId).append(cache[areaKey + areaValue]);
				
			}
		}else{
			
			$("#" + buildId).empty();
			$("#" + buildId).append(emp);
			
		}
		
	});
	
}

//closeFn为弹出框关闭后要执行的函数,isArgs是否为关闭函数传递参数,typeFrom为appoint,confirm,contract用于后台判断
function saleUnitShow(closeFn, isArgs, typeFrom){
	
	var unitKey = "unitId_";
	var cache = {};
	
	$("#unitTable td").click(function(){
				
		var unitId = $(this).attr("unitId");
		if(unitId != "" && unitId != "0" && unitId != undefined){
			
			if(!cache[unitKey + unitId]){
			
				$.ajax({
					type:"post",
					url: "./customer_guangzhou/search/getOtherDataByUnitId.action",
					data: "unitId=" + unitId + "&typeFrom=" + typeFrom,
					dataType: "json",
					success: function(data){
						
							cache[unitKey + unitId] = data; //放入缓存
							dialogLoadFn(data, closeFn, isArgs);
						}
					});
				
			}else{
				
				dialogLoadFn(cache[unitKey + unitId], closeFn, isArgs);
			}
			
		}			

	});
	
	$("#unitTable td").hover(function(){
		
		var unitId = $(this).attr("unitid");
		if(unitId != "" && unitId != "0" && unitId != undefined){			
			$(this).addClass("seltd");
			
		}
	},function(){
	
		var unitId = $(this).attr("unitid");
		if(unitId != "" && unitId != "0" && unitId != undefined){			
			$(this).removeClass("seltd");
		}
	
	});

}
		
//显示框
function dialogLoadFn(data, closeFn, isArgs){
	
	//根据返回的值判断是否可以显示"选择"按钮
	var submitBt = "";
	
	if(data.canChange == "true"){
		submitBt = "<tr bgcolor='#FFFFFF' align='center'><td colspan='2' height='28'><span id='suggId'></span>"
			+ "<input id='submitBt' type='button' value='  选择  '/></td></tr>";
	}
	
	var content = 
		  "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:normal' width='400px'>"
		+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:50%'>房间结构</td><td>&nbsp;&nbsp;"
		+ data.roomType
		+ "</td>"
		+ "</tr>"

		+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:50%'>销售状态</td><td>&nbsp;&nbsp;"
		+ data.saleState
		+ "</td>"
		+ "</tr>"
		
		+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:50%'>租售类型</td><td>&nbsp;&nbsp;"
		+ data.saleType
		+ "</td>"
		+ "</tr>"
		
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>面积状态</td><td>&nbsp;&nbsp;"
		+ data.areaState
		+ "</td>"
		+ "</tr>"
		
		+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:50%'>建筑面积</td><td>&nbsp;&nbsp;"
		+ data.buildArea
		+ "</td>"
		+ "</tr>"
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>套内面积</td><td>&nbsp;&nbsp;"
		+ data.insideArea
		+ "</td>"
		+ "</tr>"
		+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:50%'>建筑单价</td><td>&nbsp;&nbsp;"
		+ data.buildPrice 
		+ "&nbsp;元</td>"
		+ "</tr>"
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>套内单价</td><td>&nbsp;&nbsp;"
		+ data.insidePrice
		+ "&nbsp;元</td>"
		+ "</tr>"
		
		+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>标准总价</td><td>&nbsp;&nbsp;"
		+ data.sumPrice 
		+ "&nbsp;元</td>"
		+ "</tr>"
		
		+ submitBt
		
		+ "</table></div>"
		;				
			
		var dialogLoad = "";
		if(isArgs){
			//表示关闭函数有参数
			dialogLoad = new Dialog(content, {title:'<p style="color:black;font-weight: bold;">查看单元详细信息</p>',
									bindCloseId:"submitBt",closeFn:closeFn,closeFnArgs:data,ie6width:'475px',ie6height:'360px',width:"475px"});
		}else{
			//表示关闭函数没有参数
			dialogLoad = new Dialog(content, {title:'<p style="color:black;font-weight: bold;">查看单元详细信息</p>',
									bindCloseId:"submitBt",closeFn:closeFn,closeFnArgs:"",ie6width:'475px',ie6height:'360px',width:"475px"});
		}
		dialogLoad.show(); 
		
}