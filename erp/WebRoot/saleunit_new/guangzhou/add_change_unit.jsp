<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script language="javascript" type="text/javascript">

	$.ed().ready(function(){
		$.ed("#showConfirmDetailFormId").bind('click', function(){
			showConfirmDetail(${confirm.id});	
		});
		$.ed("#chooseNewUnit").bind('click', function(){
			showUnitList(${unit.propertyProjectId});	
		});
		$.ed("#createNewConfirm").bind('click', function(){
			if($.ed("#newUnitId").val()!=""){
				createChangeUnitConfirmDialog($.ed("#newUnitId").val(),$.ed("#unitId").val());
			}
			else{
				alert('请先选择换房单元');
			}
		});
	});
	
	


</script>


<div class="gbox1">			

<form action="./saleunit/operation/submitReplaceUnit.action" method="post" id="submitReplaceUnitFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t1" style="width:15%" align="right"><font color="red"></font>单元编号&nbsp;</td>
			<td id="t2" style="width:25%" colspan="3">
			${unit.allName}
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="  查看详细  "  id="showConfirmDetailFormId"/>
			<input type="hidden" id="unitId" name="unitId" value="${unit.id}" />
			</td>						
		  </tr>	 
		  
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t3" style="width:15%" align="right"><font color="red">*</font>单元编号&nbsp;</td>
			<td id="t4" style="width:25%" colspan="3">
				<span id="newUnitShow"></span>	
				<input type="hidden" id="newUnitId" name="replaceUnit.unitId2"/>
				<a href="javascript:void(0)" id="chooseNewUnit" style="color:#1199FF; text-decoration:underline;padding: 0px 15px 0px 15px">点击选择新单元</a>	
				<input type="hidden" id="newConfirmId" name="replaceUnit.confirmId2"/>						
				<a href="javascript:void(0)" id="createNewConfirm" style="color:#1199FF; text-decoration:underline;padding: 0px 0px 0px 0px">新建成交</a>	
			</td>			
              </tr>	 
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t7" style="width:15%" align="right"><font color="red">*</font>换房日期&nbsp;</td>
			<td id="t8" style="width:25%">
				<input class="easyui-datebox" type="text" id="changeUnitDate" style="width:90px" name="replaceUnit.replaceDate" value="${nowDate}"/>	</td>			
			<td id="t9" style="width:15%" align="right"><font color="red">*</font>批准人&nbsp;</td>
			<td id="t10" style="width:25%">
				<input type="text" id="approverMan" name="replaceUnit.approverMan"/></td>	
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t11" style="width:15%" align="right"><font color="red">*</font>经办人&nbsp;</td>
			<td id="t12" style="width:25%">
				<input type="text" id="inputMan" name="replaceUnit.inputMan"/></td>					
			<td id="t13" style="width:15%" align="right"><font color="red"></font>备注&nbsp;</td>
			<td id="t14" style="width:25%">
				<input type="text" id="remark" name="replaceUnit.remark" style="width:90px"/></td>	
		  </tr>	 
		  
		   
			  
			</table>
</form>	
	
	</div>


