<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<script type="text/javascript">
$().ready(function(){
	$("#_dialog_add_unit_group_div").bind('click',function(){
		dialog_add_unit_group_div(${groupId});
		});
})

function dialog_add_unit_group_div(groupId){
	var grou_id = groupId;
	$("#new_dialog_div").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		onClose:function(){
			$('#new_dialog_div div:first-child').children().html("");
			flush_this_page();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				submit_div_sub();
			}},
			{text:'关闭',
				iconCls:'icon-cancel',
			handler:function(){
				$('#new_dialog_div').dialog('close');
				flush_this_page();
			}}
		]
	});
	$.post('./saleunit_new/unit/group/dialogAddUnitForGroup.action',{'groupId':grou_id},function(date){
		$('#new_dialog_div div:first-child').children().html(date);
		$(".build_a").bind('click',function(){
			//alert('bindok')
			add_get_unit_map_for_add_group($(this).attr('buildId'));
		})
	});
	$('#new_dialog_div').dialog('open');
	$('#new_dialog_div').dialog('setTitle', '添加单元');
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


//打开新建弹出窗口
function openDivCreatePropertyGroup(){	
	
	$("#div_create_propertygroup").dialog({
		resizable: true,
		onClose:function(){			
			$('#createFormpropertygroup')[0].reset();
			
            //清理form中的所有填充值

			
			moduleMask("searchChipTableId");//遮罩层
			//window.parent.refreshSelectedTab("chip_tabs");  //在easyui.utils.js中(刷新tab)
					
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				
				submitCreatePropertyGroup(this);				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#div_create_propertygroup').dialog('close');
			}
		}]
	});
	
	$('#div_create_propertygroup').dialog('open');
	$('#div_create_propertygroup').dialog('setTitle', '新建组团');
	return false;
}


//保存组团
function submitCreatePropertyGroup(dialogSaveButton){
    //做填充的验证
	//var chipCustomerName = $("#chipCustomerName").val();	
	//if(chipCustomerName == ""){		
	//	$("#chipCustomerName").focus();
	//	dialogNewSugg(dialogSaveButton, "客户名称不能为空");
	//	return false;
	//}
    //使用easyui的validatebox进行验证，如果不够，直接在easyui.utils.js进行补充扩展
	//if($("#createFormPropertyGroup").form('validate')==false){
	//	dialogNewSugg(dialogButton, "填写的数据有误或没有填全");
	//	return;
	//};
	dialogNewSugg(dialogSaveButton, "提交中...");
	
	$.ajax({
		type:"post",
		url: "./saleunit_new/unit/group/ajaxCreatePropertyGroup.action",//TODO 填好完整的action地址
		data: $("#createFormpropertygroup").serialize() ,
		dataType: "json",
		success: function(data){			
			//根据返回的类型type判断是否成功,message做为提示内容			
			var type = data.type;
			
			if(type == "true"){
				//保存成功				
				$('#createFormpropertygroup')[0].reset();	
				$('#div_create_propertygroup').dialog('close');
				
			}else{				
				//保存失败				
				var sugg = "<font color='red'>" + data.message + "</font>";
				dialogNewSugg(dialogSaveButton, sugg);
			}			
		}		
	});
}
</script>



