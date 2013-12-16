
//节点的点击方法,isRefresh表示是否为刷新,主要给addChangeClass()使用,moduleId要为其上方增加刷新框的组件
function treeNodeClickForScene(treeId, node, isRefresh, moduleId){
	
	if(moduleId == undefined || moduleId == ""){
		//主要为了兼容"销控中心"
		moduleId = "center_main";
	}
	var hiddenUnitId = $("#hiddenUnitId").val(); //在刷新之前,要先获取之前选择的单元
		
	var attr = node.attributes;
	if(attr != undefined && attr.type == "endNode"){
		$.ajax({
			type:"get",
			url: "./saleunit/scene/guangzhou/getUnit.action",							
			data: "buildId=" + attr.bid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
		
	}else if(attr != undefined && attr.type == "endNodeGro"){
		$.ajax({
			type:"get",
			url: "./saleunit/scene/guangzhou/getGroup.action",							
			data: "groId=" + attr.gid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
	}else if(attr != undefined && attr.type == "area"){
		$.ajax({
			type:"get",
			url: "./saleunit/scene/guangzhou/getAreaUnit.action",							
			data: "areaId=" + attr.aid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html(data);	
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
	}else{
		$("#" + treeId).tree('toggle', node.target);
	}
}

//为之前选定的td加上选中的class
function addChangeClass(isRefresh, unitId){
	
	if(isRefresh != "false"){
		if(unitId != undefined){
		
			$("#unitTable td").each(function(index){
			
				var getUnitId = $(this).attr("unitid");
				if(getUnitId == unitId){
					$(this).addClass("changetd");
					return false;
				}
			});
		}
	}
	
}

function tdOver(td) {
    var unitId = $(td).attr("unitid");
    if (unitId != "" && unitId != "0" && unitId != undefined) {
        $(td).addClass("seltd");

    }
}

function tdOut(td) {
    var unitId = $(td).attr("unitid");
    if (unitId != "" && unitId != "0" && unitId != undefined) {
        $(td).removeClass("seltd");
    }
}

//自动刷新
var autoRefreshInt = "";
function autoRefresh(){
	var autoTime = $("#autoRefrehTimeId").val();
	
	if(autoRefreshInt != ""){
		//如果是重复设置,就要先消除再重新设置			
		window.clearInterval(autoRefreshInt);
	}
	var time = "";
	if(autoTime == "0.5"){
		time = 30 * 1000;
	}else{
		time = parseInt(autoTime) * 60 * 1000;
	}
	autoRefreshInt = window.setInterval(function(){refreshFn();}, time);		
	$('#setShowId').html("<font color='red'>设置自动刷新成功</font>");
	setTimeout("$('#setShowId').html('')", 2000);
}

//取消自动刷新
function cancelAutoRefresh(){
	if(autoRefreshInt != ""){
		//如果是重复设置,就要先消除再重新设置			
		window.clearInterval(autoRefreshInt);
	}
	$('#setShowId').html("<font color='red'>取消自动刷新成功</font>");
	setTimeout("$('#setShowId').html('')", 2000);
}

//刷新的具体函数("销控中心"外部没有调用,调用的是gotoRefreshFn(););以后应该直接调用该刷新函数,但是应该增加参数来判断具体刷新哪个组件
function refreshFn(){
	
	//为了兼容组合的情况,不能通过楼栋的id的方法,应该通过节点的url来
	
	var selectNode = $("#left_tree").tree("getSelected");
		
	if(selectNode == undefined || selectNode == null){
		
		//第一次进来,默认的选择			
		var buildId = $("#hiddenBuildId").attr("value");
		var hiddenUnitId = $("#hiddenUnitId").attr("value");
		
		defaultRefreshFn(buildId, hiddenUnitId, "true", "center_main");	

	}else{
		
		treeNodeClick("left_tree", selectNode, "true", "center_main");			
	}
}

//默认的选择操作
function defaultRefreshFn(buildId, hiddenUnitId, isRefresh, moduleId){
	
	$.ajax({
		type:"get",
		url: "./saleunit/scene/guangzhou/getUnit.action",							
		data: "buildId=" + buildId + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
		dataType: "html",
		beforeSend: function(){
			//$("#center_main").html("加载中...");
			moduleMask(moduleId);
		},
		success: function(data){								
			$("#" + moduleId).html(data);	
			
			addChangeClass(isRefresh, hiddenUnitId);
		}			
	});	
}
