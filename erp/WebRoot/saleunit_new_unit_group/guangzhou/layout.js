var select_build = '';
var select_unit = '';
var select_group = '';
var select_pro = '';
var select_group_unit = '';
var unit_map_table_id = 'unitTable1';
$.messager.defaults = { ok: "确定", cancel: "取消" };

$().ready(function(){
	
	bindLeftCombobox("__myProjectId__", "__group__", bindLeftTree, ["__group__"]);

	$("#_but_clear_td_class").bind('click',function(){remove_sel_class(unit_map_table_id)});	
	$("#_but_add_sel_unit").bind('click',function(){todo_add_sel_unit_to_group()});
	$("#_but_add_add_unit").bind('click',function(){todo_add_add_unit_by_build()});
	$("#_but_dialog_add_unit_group").bind('click',function(){dialog_add_unit_group_div(select_pro)});
	$("#_but_dialog_update_unit_group").bind('click',function(){dialog_update_unit_group(select_group)});
	
	$("#_but_clear_group_unit").bind('click',function(){remove_sel_group_class('unitTable')});	
	$("#_but_del_group_unit").bind('click',function(){todo_del_group_unit(select_group_unit)});
	
});

function bindLeftTree(selectType){
	
	$("#left_tree").tree({
		animate:false,
		url:'./saleunit_new/appoint/guangzhou/layoutLeft.action?selectType=' + selectType,
		onLoadSuccess:function(node, data){
		},		
		onClick:function(node){
			var attr = node.attributes;
			
			if(attr != undefined && attr.type == "p"){
				select_pro= node.id;
			}
			
			if(attr != undefined && attr.type == "endNode"){
				if(attr.bid == '0'){
					return;
				}
				//2012-10-22 只显示组团
				//flush_unit_map(attr.bid);
				select_build = attr.bid;
				select_unit = '';
			}else if(attr.type == 'endNodeGro'){
				//2012-10-22 只显示组团
				flush_group_map(attr.gid);
				select_group = attr.gid;
			}
			$(this).tree('toggle', node.target);
		}
	});	
}

function flush_unit_map(buildId){
	$.ajax({
		type:"get",
		url: "./saleunit_new/unit/group/unitMap.action",	
		data: "buildId=" + buildId + "&ts=" + new Date(),
		dataType: "html",
		beforeSend: function(){
			$("#unit_map").html("加载中...");
		},
		success: function(data){								
			$("#unit_map").html(data);	
			bind_unit_table(unit_map_table_id);//绑定事件
		}		
	});	
}

//显示组团界面 2012-10-22修改
function flush_group_map(gid){
	$('#_centerFrame').attr('src',"./saleunit_new/unit/group/searchPropertyGroupDetailMap.action?groupId="+gid);
}

function bind_unit_table(tablename){
	$("#"+tablename+" td").bind('click',function(){
		var clickUnitId = $(this).attr("unitId");
		if(clickUnitId == '0' || clickUnitId == undefined || clickUnitId == ""){
			return false;
		}else{
			$(this).addClass("td_is_check");
			select_unit += ','+clickUnitId;
		}
	}).bind('mouseenter ',function(){//单元背景色HOVER
		var unitId = $(this).attr("unitid");
		if(unitId != "" && unitId != "0" && unitId != undefined){			
			$(this).addClass("seltd");
		}
	}).bind('mouseleave  ',function(){//单元背景色HOVER
		var unitId = $(this).attr("unitid");
		if(unitId != "" && unitId != "0" && unitId != undefined){			
			$(this).removeClass("seltd");
		}
	});
}

function bind_group_table(tablename){
	$("#"+tablename+" td").bind('click',function(){
		var clickUnitId = $(this).attr("unitId");
		if(clickUnitId == '0' || clickUnitId == undefined || clickUnitId == ""){
			return false;
		}else{
			$(this).addClass("td_is_check");
			select_group_unit += ','+clickUnitId;
		}
	}).bind('mouseenter ',function(){//单元背景色HOVER
		var unitId = $(this).attr("unitid");
		if(unitId != "" && unitId != "0" && unitId != undefined){			
			$(this).addClass("seltd");
		}
	}).bind('mouseleave  ',function(){//单元背景色HOVER
		var unitId = $(this).attr("unitid");
		if(unitId != "" && unitId != "0" && unitId != undefined){			
			$(this).removeClass("seltd");
		}
	});
}

function remove_sel_class(tablename){
	$("#"+tablename+" td").removeClass("td_is_check");
	select_unit = '';
}

function remove_sel_group_class(tablename){
	$("#"+tablename+" td").removeClass("td_is_check");
	select_group_unit = '';
}

function todo_add_sel_unit_to_group(){		
	if(select_unit == ''){$.messager.alert('提示框',"没有选择的单元","question"); ;return false;}
	if(select_group == ''){$.messager.alert('提示框',"没有选择的组团","question"); ;return false;}
	$.post('./saleunit_new/unit/group/addUnitByUnitIds.action',{'unitIds':select_unit,'groupId':select_group},function(date){
			$.messager.alert('提示框',date+"操作成功","question");
			flush_group_map(select_group);
	})
}

function todo_add_add_unit_by_build(){
	if(select_build == ''){$.messager.alert('提示框',"没有选择的楼栋","question"); ;return false;}
	if(select_group == ''){$.messager.alert('提示框',"没有选择的组团","question"); ;return false;}
	$.post('./saleunit_new/unit/group/addAddUnitByBuildId.action',{'buildId':select_build,'groupId':select_group},function(date){
		$.messager.alert('提示框',date+"操作成功","question");
		flush_group_map(select_group);
	})
}

function todo_del_group_unit(delids){
	//alert("删除+"+delids);
	if(select_group_unit == ''){$.messager.alert('提示框',"请在组团选择单元","question"); ;return false;}
	if(select_group == ''){$.messager.alert('提示框',"没有选择的组团","question"); ;return false;}
	$.post('./saleunit_new/unit/group/delGroupUnit.action',{'unitIds':select_group_unit,'groupId':select_group},function(date){
		$.messager.alert('提示框',date+"操作成功","question");
		flush_group_map(select_group);
		select_group_unit = '';
	})
}

function dialog_add_unit_group(proid){
	if(proid == ''){
		$.messager.alert('提示框','请先选择楼盘',"question");
		return false;
	}
	var pro_id = proid.substring(1);
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:350,
		height:350,
		onClose:function(){
			$('#new_dialog_ifram').html("");
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			}},
			{text:'关闭',
				iconCls:'icon-cancel',
			handler:function(){
				$('#new_dialog').dialog('close');
				reload();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '新建组团'); 
	$('#new_dialog_ifram')[0].src='./saleunit_new/unit/group/dialogAddUnitGroup.action?proId='+pro_id; 
}

function dialog_add_unit_group_div(proid){
	if(proid == ''){
		$.messager.alert('提示框','请先选择楼盘',"question");
		return false;
	}
	var pro_id = proid.substring(1);

	//$.post('./saleunit_new/unit/group/dialogAddUnitGroup.action',{'proId':pro_id},function(date){
	//	$('#new_dialog_div').html(date);
		
	//});

	
	$("#new_dialog_div").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		onClose:function(){
			$('#new_dialog_div div:first-child').children().html("");
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				//window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
				submit_div_sub();
			}},
			{text:'关闭',
				iconCls:'icon-cancel',
			handler:function(){
				$('#new_dialog_div').dialog('close');
			}}
		]
	});
	$.post('./saleunit_new/unit/group/dialogAddUnitGroup.action',{'proId':pro_id},function(date){
		$('#new_dialog_div div:first-child').children().html(date);
		$(".build_a").bind('click',function(){
			//alert('bindok')
			add_get_unit_map_for_add_group($(this).attr('buildId'));
		})
	});
	$('#new_dialog_div').dialog('open');
	$('#new_dialog_div').dialog('setTitle', '新建组团');
}


function dialog_update_unit_group(sle_gid){
	if(sle_gid == ''){
		$.messager.alert('提示框','请选择组团!',"question");
		return false;
	}
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:300,
		onClose:function(){
			$('#new_dialog_ifram').html("");
			select_group = '';
			reload();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			}},
			{text:'关闭',
				iconCls:'icon-cancel',
				handler:function(){
				$('#new_dialog').dialog('close');
				$('#new_dialog_ifram').html("");
				select_group = '';
				reload();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '修改组团'); 
	$('#new_dialog_ifram')[0].src='./saleunit_new/unit/group/dialogUpdateUnitGroup.action?groupId='+sle_gid; 
}

var sel_dialog_build_id = '';
function add_get_unit_map_for_add_group(bid){
	if(bid == ''){
		$.messager.alert('提示框','楼栋错误!',"question");
		return false;
	}
	sel_dialog_build_id = bid;
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:500,
		onClose:function(){
			$('#new_dialog_ifram').html("");
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				 var temp = window.document.getElementById("new_dialog_ifram").contentWindow.sleunit;
				 $('#new_dialog').dialog('close');
				 a_unit_id += temp;
				 
				// alert(temp);
				// alert(sel_dialog_build_id);
					$("#a_"+sel_dialog_build_id).after(temp); 
					$('#new_dialog_ifram').html("");
			}},
			{text:'关闭',
				iconCls:'icon-cancel',
			handler:function(){
				$('#new_dialog').dialog('close');
				$('#new_dialog_ifram').html("");
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '选择楼栋'); 
	$('#new_dialog_ifram')[0].src='./saleunit_new/unit/group/unitMapForAddGroup.action?buildId='+bid; 
	
}

function reload(){
		$('#left_tree').tree('reload');
}