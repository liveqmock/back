<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询组团明细</title>
<base href="<%=basePath%>" />	
<s:include value="../../header/header_easyui.jsp"></s:include>

<style type="text/css">
		*{margin:0;padding:0;}		
		.tb1 td{padding-left: 2px;width:50px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#FBEC88}
		.add_some{}
		.text_title_cl{
		display:inline-block;
		width:16px;
		height:18px;
		vertical-align:middle;}
		.re_some{display:inline-block;
		}
		.spanbu{color:#aa1122;cursor: pointer;border: 1px solid;padding: 10px;}
		.td_is_check{background: #FBEC88;}
	</style>	

<script type="text/javascript">
var select_group_unit = '';
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

function flush_this_page(){

	location='./saleunit_new/unit/group/searchPropertyGroupDetailMap.action?groupId=${groupId}'
}
function remove_sel_group_class(tablename){
	$("#"+tablename+" td").removeClass("td_is_check");
	select_group_unit = '';
}

function todo_del_group_unit(delids){
	//alert("删除+"+delids);
	if(select_group_unit == ''){$.messager.alert('提示框',"请选择单元","question"); ;return false;}
	//if(select_group == ''){$.messager.alert('提示框',"没有选择的组团","question"); ;return false;}
	$.post('./saleunit_new/unit/group/delGroupUnit.action',{'unitIds':select_group_unit,'groupId':${groupId}},function(date){
		$.messager.alert("添加成功");
		//flush_group_map(select_group);
		select_group_unit = '';
		flush_this_page();
	})
	
}

	$(document).ready(function(){	
		//做一些初始化，或者是提交之后显示提示的事情
		bind_group_table('unitTable')
		$("#_but_del_group_unit").bind('click',function(){todo_del_group_unit(select_group_unit)});
		$("#_but_clear_td_class").bind('click',function(){remove_sel_group_class('unitTable')});
	})

    //页面提交
	function submitSearch() {	
		$("#queryForm").submit();	
	}	
</script>
</head>
<body style="padding:0px;">
	<div class="right99" style="width: 100%"></div>	
<font >当前组团:${thisGroup.groupName}</font>&nbsp;&nbsp;<input id="_but_del_group_unit" type="button" value=" 删除所选 "/>
<input type="button" value=" 清除所选 " id='_but_clear_td_class'/>
<input type="button" id='_dialog_add_unit_group_div'  value=" 添加房间 " />
<input type="button" onclick="location='./saleunit_new/unit/group/searchPropertyGroup.action'" value=" 返回 " />

<div class="right99"></div>
					<div class="blueline"></div>
<s:if test="#request.trList.size > 0">
	<div style="height: auto;border: 0px solid #A9D9FF;float: left;">
		<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;">
			 <s:iterator value="#request.trList" id="c">  
				${c}
			 </s:iterator>
		</table>
	</div>
</s:if>	
	
	 <s:iterator value="#request.groList" id="aa">  
			 <div style="height: auto;border: 0px solid #A9D9FF;">
				 ${aa[0]}
				<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;" >
					 <s:iterator value="#request.aa" id="cc" begin="1">  
						${cc}
					 </s:iterator>
				</table>
			</div>
	</s:iterator>
	
	 <div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe name="new_dialog_ifram" scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
	<div id="new_dialog_div" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-y: scroll; "> 			
	</div> 
	<s:include value="div_create_propertygroup_detail.jsp"/>
	</body>
	</html>					
	
   

