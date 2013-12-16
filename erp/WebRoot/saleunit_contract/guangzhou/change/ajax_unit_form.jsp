<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
<style>
		tr{background: #ffffff;line-height: 25px}
		td{padding-left: 5px}
	</style>
<link href="<%=basePath%>/css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
<link href="<%=basePath%>/css/jquery.autocomplete.css" rel="stylesheet" type="text/css" charset="utf-8"/>
<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>

<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.form.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.autocomplete.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/sale_unit.js"></script>	
<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-ui-1.8.19.custom.min.js"></script>
<script type="text/javascript" language="javascript" src="./js/unit_table.js"></script>	<!-- unit table -->
<script type="text/javascript">
	$().ready(function(){
		showDiv("change_unit_unit_id2","change_unit_unit_id2_hid","","");
		$("#select_unit_div").draggable();
		$("#show_div_submit_for_unit").click(function(){
			
		
			if($("#change_unit_unit_id2").val() == ''){
					alert('变更后的房间不能为空');
					return false;
				}		
		});
	});
</script>
<s:actionmessage cssStyle="color:red"/>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
  <tr>
    <td style="font-weight: bold" width="18%">销售单</td>
    <td width="32%">${contract.id}</td>
    <td style="font-weight: bold" width="18%">申请单状态</td>
    <td width="32%"></td>
  </tr>
   <tr>
    <td  width="18%">客户姓名</td>
    <td  colspan="3">${contract.customerName}</td>

  </tr>
</table>

<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更前的信息</div>
<form action="./saleunit/contract/guangzhou/addChangeUnitForm.action" method="post">
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	<tr>
		<td  width="18%">房间</td>
		<td  width="82%" align="left">
			${contract.unit.unitNo}
		</td>
	</tr>
	<tr>
		<td >变更后房间</td>
		<td  colspan="3" align="left">
			<input type="text" id="change_unit_unit_id2" />
			<input type="hidden" id="change_unit_unit_id2_hid" name="unitForm.unitId2">
		</td>
	</tr>
	
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
  <tr>
		<td  width="18%">手续费</td>
		<td   width="82%"  colspan="3" align="left">
			<input type="text" id="change_unit_hand_fee" name="unitForm.handFee"/>
		</td>
	</tr>
	<tr>
		<td >变更原因</td>
		<td  colspan="3" align="left">
			<select id="change_unit_reson_type" name="unitForm.resonType">
				<option value="">请选择</option>
				<option value="1">原因1</option>
				<option value="2">原因2</option>
			</select>
		</td>
	</tr>
	<tr>
		<td>原因说明</td>
		<td align="left">
			<input type="text" id="change_unit_reson_desc" name="unitForm.resonDesc" style="width: 100%"/>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="right">
			<input type="hidden" value="${contract.id}" name="contract.id"/><br>
			<input value="  提交申请  " type="submit" id="show_div_submit_for_unit"/>
		</td>
	</tr>
</table>
</form>
<div id="select_unit_div" style="width: 500px;height: 300px;background:		#0072E3;display: none;position: absolute">
	<p id="select_unit_div_head" style="width: 98%;height: 30px;background: #0052E3;border:#333333 groove;margin-top: 0px"><font id="select_unit_div_close" style="float: right;color:#ffffff;line-height: 30px;cursor: pointer;font-weight: bold;">关闭&nbsp;&nbsp;</font></p>
	<div id="select_unit_div_body" style="height: 97%;width: 100%px;background: #FFF8D7; border:#555555 solid;overflow: scroll"></div>
</div>
