<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div id="div_edit_PropertyGroup" class="easyui-dialog" closed="true" modal="true" title="修改组团" style="width:450px;height:350px;">
	<form id="editFormPropertyGroup">
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">			
			<input type="hidden" id="editPropertyGroup_id" name="editPropertyGroup.id"/></td>
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>所属楼盘			
			<td id="t16" style="width:70%">&nbsp;
			<s:select list="propertyProjectSel" name="editPropertyGroup.projectId" id="editPropertyGroup_projectId"></s:select>
			</td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>组团名称				
			<td id="t16" style="width:70%">&nbsp;&nbsp;<input type="text" id="editPropertyGroup_groupName" name="editPropertyGroup.groupName" required="required"  style="width:90px" /></td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center"><font color="#FF0000">*</font>认筹类型				
			<td id="t16" style="width:70%">&nbsp;
			<select name="editPropertyGroup.chipType">
				<option value="1">普通筹</option>
				<option value="2">AB筹</option>
			</select>
		</td>
			</tr>            
            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
			<td id="t15" style="width:30%" align="center">备注				
			<td id="t16" style="width:70%">&nbsp;
			<textarea rows="" cols="" name="editPropertyGroup.remark" style="width:160px;font-size: 12px" ></textarea>
			</td>
			</tr>            
		</table>
	</form>	
</div>

<script type="text/javascript">
//修改组团,弹出窗口
function openDivEditPropertyGroup(id){	
//异步获取数据
	$.ajax({
		type:"post",
		url: "./saleunit_new/unit/group/ajaxGetPropertyGroupById.action",//TODO 填好完整的action地址
		data: "id=" + id,
		dataType: "json",
		success: function(data){			
			if(data != "" && data != null){	
				//	赋值到form中		
				$('#editFormPropertyGroup').form('load',data);
				
                //其他预处理
				//$("#editChip_chipNo").html(data["editChip.chipNo"]);
			}else{				
				//加载失败
				myAlert('加载失败');			
			}
		}	
	});

	$("#div_edit_PropertyGroup").dialog({
		resizable: true,
		onClose:function(){					
			$('#editFormPropertyGroup')[0].reset();	
						
		},
		buttons:[{
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
				//具体的update方法
				submitUpdatePropertyGroup(this);				
			}
		},
		{
			text:'关闭',
			iconCls:'icon-cancel',
			handler:function(){
				
				$('#div_edit_PropertyGroup').dialog('close');
			}
		}]
	});
	
	$('#div_edit_PropertyGroup').dialog('open');
	$('#div_edit_PropertyGroup').dialog('setTitle', '修改组团');
	
	return false;
}

//进行修改
function submitUpdatePropertyGroup(dialogButton){   
    //使用easyui的validatebox进行验证，如果不够，直接在easyui.utils.js进行补充扩展 
	if($("#editFormPropertyGroup").form('validate')==false){
		dialogNewSugg(dialogButton, "填写的数据有误或没有填全");
		return;
	};
    
	dialogNewSugg(dialogButton, "提交中...");
    
	$.ajax({
		type:"post",
		url: "./saleunit_new/unit/group/ajaxUpdatePropertyGroup.action",//TODO 填好完整的action地址
		data: $("#editFormPropertyGroup").serialize(),
		dataType: "json",
		success: function(data){
			
			//根据返回的类型type判断是否成功,message做为提示内容			
			var type = data.type;
			
			if(type == "true"){			
				//保存成功	
				var sugg = "<font color='red'>保存成功</font>";	
				dialogNewSugg(dialogButton, sugg);		
				
				$('#div_edit_PropertyGroup').dialog('close');
				
				submitSearch();
				
			}else{				
				//保存失败				
				var sugg = "<font color='red'>" + data.message + "</font>";
				dialogNewSugg(dialogButton, sugg);
			}
			
		}		
	});

}

</script>
