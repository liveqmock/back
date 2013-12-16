<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>">
<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>	
	<script type="text/javascript">
	$().ready(function(){

		$("#app_for_ok").click(function(){
	
			$.ajax({
				type:"post",
				url: "./approval/change/update.action",
				data: "changeId=" + $(this).attr("aid")+"&changeState=ok",
				dataType: "html",
				success: function(data)
					{
						alert(data);
					
					}
				});
			
			});
		
	
	});
	</script>
		<style>
		tr{background: #ffffff;line-height: 25px}
		td{padding-left: 5px}
	</style>

<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
  <tr>
    <td style="font-weight: bold" width="18%">销售单</td>
    <td width="32%">${confirm.id}</td>
    <td width="18%" style="font-weight: bold">申请单状态</td>
    <td width="32%"></td>
  </tr>
   <tr>
    <td >客户姓名</td>
    <td colspan="3">${confirm.customerName} </td>

  </tr>
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>房间变更信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	<tr>
		<td  width="18%"width="100px">变更前房间</td>
		<td   align="left">
			${changeUnitInfo.descUnitId1}
		</td>
	</tr>
	<tr>
		<td width="18%">变更后房间</td>
		<td colspan="3" align="left">
			${changeUnitInfo.descUnitId2}
		</td>
	</tr>
	
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">

	<tr>
		<td width="18%">变更原因</td>
		<td width="32%">
			${changeUnitInfo.resonType}
		</td>
		<td width="18%">手续费</td>
		<td width="32%">
			${changeUnitInfo.handFee}
		</td>
	</tr>
 	<tr>
		<td>原因说明</td>
		<td>
			${changeUnitInfo.resonDesc}
		</td>
		<td>申请人id</td>
		<td>
			${changeUnitInfo.applyUser}
		</td>
	</tr>
	<tr>
		<td>申请日期</td>
		<td>
		<s:date name="#request.changeUnitInfo.applyDate" format="yyyy-MM-dd HH:ss"/>
		</td>
		<td></td>
		<td>
			
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  
		<td colspan="4" align="center">
			<input value="  通过审批  " id="app_for_ok" type="button" aid="${approvalId}"/>
		</td>
	</tr>
	
</table>
