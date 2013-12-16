/**
  *
  * 一些公用的方法
  */
  

//节点的点击方法,isRefresh表示是否为刷新,主要给addChangeClass()使用,moduleId要为其上方增加刷新框的组件
function treeNodeClick(treeId, node, isRefresh, moduleId){
	
	if(moduleId == undefined || moduleId == ""){
		//主要为了兼容"销控中心"
		moduleId = "center_main";
	}
	var hiddenUnitId = $("#hiddenUnitId").val(); //在刷新之前,要先获取之前选择的单元
		
	var attr = node.attributes;
	if(attr != undefined && attr.type == "p"){
        $.ajax({
            type:"get",
            url: "./saleunit_new/appoint/guangzhou/proInfoBySaleUnit.action",
            data: "proId=" + attr.id + "&ts=" + new Date(),
            dataType: "html",
            beforeSend: function(){
            	moduleMask(moduleId);
            },
            success: function(data){
            	$("#" + moduleId).html(data);
            }
        });

		$("#" + treeId).tree('toggle', node.target);
    }else if(attr != undefined && attr.type == "endNode"){
		$.ajax({
			type:"get",
			url: "./saleunit_new/appoint/guangzhou/getUnit.action",							
			data: "buildId=" + attr.bid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html($.trim(data));
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
		
	}else if(attr != undefined && attr.type == "endNodeGro"){
		$.ajax({
			type:"get",
			url: "./saleunit_new/appoint/guangzhou/getGro.action",							
			data: "groId=" + attr.gid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html($.trim(data));
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
	}else if(attr != undefined && attr.type == "area"){
		$.ajax({
			type:"get",
			url: "./saleunit_new/appoint/guangzhou/getAreaUnit.action",							
			data: "areaId=" + attr.aid + "&isRefresh=" + isRefresh + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				//$("#center_main").html("加载中...");
				moduleMask(moduleId);
			},
			success: function(data){								
				$("#" + moduleId).html($.trim(data));
				
				addChangeClass(isRefresh, hiddenUnitId);
			}			
		});	
		
		$("#" + treeId).tree('toggle', node.target);
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

//该方法只能用于"销控中心"和"财务管理"
//刷新的具体函数("销控中心"外部没有调用,调用的是gotoRefreshFn(););以后应该直接调用该刷新函数,但是应该增加参数来判断具体刷新哪个组件
function refreshFn(){
	
	//为了兼容组合的情况,不能通过楼栋的id的方法,应该通过节点的url来
	
	var selectNode = $("#left_tree").tree("getSelected");
		
	if(selectNode == undefined || selectNode == null){
		
		selectNode = $("#left_financial_tree").tree("getSelected");
		if(selectNode != undefined && selectNode != null){
			//兼容"财务管理"
			treeNodeClickForFinancialManager("left_financial_tree", selectNode, "false", "left_main");
		}else{
			//第一次进来,默认的选择
			
			var buildId = $("#hiddenBuildId").attr("value");
			var hiddenUnitId = $("#hiddenUnitId").attr("value");
			
			defaultRefreshFn(buildId, hiddenUnitId, "true", "center_main");	
			
		}

	}else{
		
		treeNodeClick("left_tree", selectNode, "true", "center_main");			
	}
}

//默认的选择操作
function defaultRefreshFn(buildId, hiddenUnitId, isRefresh, moduleId){
	
	$.ajax({
		type:"get",
		url: "./saleunit_new/appoint/guangzhou/getUnit.action",							
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

//根据iframe中的标示id组件是否有isReload为true的属性,如果有就重新加载(外部调用的方法),废弃,为了兼容以前的代码,不删除,但新的页面应该直接调用refreshFn()
function gotoRefreshFn(iframeId, moduleId, attrId){
	
	refreshFn(); //刷新改成了局部的table刷新,所以每一次都刷新,不进行判断
}

//