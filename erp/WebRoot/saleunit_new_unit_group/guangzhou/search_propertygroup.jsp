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
<title>查询组团</title>
<base href="<%=basePath%>" />	
<s:include value="../../header/header_easyui.jsp"></s:include>
<script type="text/javascript">
function dialog_add_unit_group_div(){
	if(proid == ''){
		$.messager.alert('提示框','请先选择楼盘',"question");
		return false;
	}
	//var pro_id = proid.substring(1);

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

	$(document).ready(function(){	
		//做一些初始化，或者是提交之后显示提示的事情


		$("#_but_dialog_add_unit_group").bind('click',function(){dialog_add_unit_group_div(select_pro)});
	})

    //页面提交
	function submitSearch() {	
		$("#queryForm").submit();	
	}	
</script>
</head>
<body style="padding:0px;">
	<div class="right99"></div>	
		<table width="100%" border="0" align="left" cellspacing="0" id="queryTable">
			<tr>
				<td colspan="6">
		        <form class="queryForm" id="queryForm" method="post">
				<!--查询框-->
				<%--
					<span>项目id</span><input type="text" style="width:90px" id="searchPropertyGroupCond_projectId"  name="searchPropertyGroupCond.projectId" value="${searchPropertyGroupCond.projectId}" /> 
					<span>分区id</span><input type="text" style="width:90px" id="searchPropertyGroupCond_areaId"  name="searchPropertyGroupCond.areaId" value="${searchPropertyGroupCond.areaId}" /> 
					<span>组团名称</span><input type="text" style="width:90px" id="searchPropertyGroupCond_groupName"  name="searchPropertyGroupCond.groupName" value="${searchPropertyGroupCond.groupName}" /> 
					<span></span><input type="text" style="width:90px" id="searchPropertyGroupCond_chipType"  name="searchPropertyGroupCond.chipType" value="${searchPropertyGroupCond.chipType}" /> 
					<span>备注</span><input type="text" style="width:90px" id="searchPropertyGroupCond_remark"  name="searchPropertyGroupCond.remark" value="${searchPropertyGroupCond.remark}" /> 
					<span>序号</span><input type="text" style="width:90px" id="searchPropertyGroupCond_orderIndex"  name="searchPropertyGroupCond.orderIndex" value="${searchPropertyGroupCond.orderIndex}" /> 
                
					日期<input class="easyui-datebox" type="text" style="width:90px" name="propertyGroupCond.date1" value="${propertyGroupCond.date1}" />-
					<input class="easyui-datebox" type="text" style="width:90px" name="propertyGroupCond.date2" value="${propertyGroupCond.date2}" />
					
					 <input type="button" id="_but_dialog_add_unit_group"  value=" 新建组团 " />		--%>
					 <span>组团名称</span><input type="text" style="width:90px" id="searchPropertyGroupCond_groupName"  name="searchPropertyGroupCond.groupName" value="${searchPropertyGroupCond.groupName}" /> 
					&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询 " />
					 <input type="button" onclick="return openDivCreatePropertyGroup()" value=" 新建组团 " />
					<div class="right99"></div>
					<div class="blueline"></div>					
			    </form>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<div class="gbox1">
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" 
							style="text-align: center;font-size:12px; line-height:26px; white-space:normal">						
							<tr class="gboxbg">
                                    <!--<th>项目id</th>-->
                                    <th>组团名称</th>
                                    <th>所属单元</th>
                                    <th>认筹类型</th>
                                    <th>备注</th>
                                    <th>创建人</th>
                                    <th>创建时间</th>
							</tr>							
   						<s:iterator value="searchListPropertyGroup" id="c">   						
						  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
						  <!-- <td><a href="javascript:;" style="color:#5482de;" onclick="return openDivEditPropertyGroup('<s:property value="id"/>');"><s:property value="projectId"/></a></td> --> 
                            <td><a href="javascript:;" style="color:#5482de;" onclick="return openDivEditPropertyGroup('<s:property value="id"/>');"> <s:property value="groupName"/></a>   </td>
                            <th><a style="color:#5482de" href="./saleunit_new/unit/group/searchPropertyGroupDetailMap.action?groupId=${id}">所属单元</a> </th>
                            <td><s:property value="chipStr"/></td>
                            <td><s:property value="remark"/></td>
                            <td><s:property value="createdIdStr"/></td>
                            <td><s:property value="createdTime"/></td>
						   </tr>
   						</s:iterator>  
						</table>
					</div></td>
			</tr>			
			 <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
				</td>
            </tr>			
		</table>	
    <!--弹出新建的div-->
	<s:include value="div_create_propertygroup.jsp"/>
    
    <!--弹出修改的div-->
	<s:include value="div_edit_propertygroup.jsp"/>
    
</body>
</html>


