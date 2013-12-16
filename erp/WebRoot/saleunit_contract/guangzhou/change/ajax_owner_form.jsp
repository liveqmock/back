<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript" language="javascript" src="<%=path %>/js/jquery-1.6.2.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#add_owner_bu").click(function(){
				$("#add_owner_for_change").show();
			});
		$("#add_div_hid").click(function(){
			$("#add_owner_for_change").hide();
		});

		$("#show_div_submit_for_owner").click(function(){
			
			$str= $.trim($("#change_owner_reson_type").val());
			if($str == ""){
					alert("请选择变更原因");
	
					return false;
				}	
		})	
	});
</script>

<base href="<%=basePath%>">
<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
<style>
		tr{background: #ffffff;line-height: 25px;}
		td{padding-left: 5px}
		em{color: red;margin-right: 5px}
	</style>
	
<!-- 增加权益人 -->	
<div id="add_owner_for_change" style="width: 550px;position: absolute;z-index: 1400;left: 50px;top: 20px;background: #777777;margin: 5px;font-size: 12px;
 display: none" >
 <form action="./saleunit/contract/guangzhou/addForChangeOwner_addOwner.action" method="post">
	<table background="#f1f9fe" width="100%" style="font-size: 12;padding: 8px">
		<tr>
			<td width="120px">客户名称</td>
			<td><input type="text" name="ownerForAdd. customerName"/> </td>
			<td width="120px">电话</td>
			<td><input type="text" name="ownerForAdd. phone"/> </td>
		</tr>
		<tr>
			<td>证件号码</td>
			<td><input type="text" name="ownerForAdd. idcardNo"/> </td>
			<td>产权比例</td>
			<td><input type="text" name="ownerForAdd. rightPercent"/> </td>
		</tr>
		<tr>
			<td>代理人名称</td>
			<td><input type="text" name="ownerForAdd. agentName"/> </td>
			<td>代理人国籍</td>
			<td><input type="text" name="ownerForAdd. agentNation"/> </td>
		</tr>
		<tr>
			<td>代理人证件号码</td>
			<td><input type="text" name="ownerForAdd. cardNum"/> </td>
			<td>代理人电话</td>
			<td><input type="text" name="ownerForAdd. agentPhone"/> </td>
		</tr>
		<tr>
			<td colspan="4" align="center" style="line-height: 35px">
			<input type="hidden" value="${contract.id}" name="contract.id"/>
				<input type="submit" value="  确定  ">&nbsp;<input type="button" value="  取消 " id="add_div_hid">
			</td>
		</tr>
	</table>
	</form>
</div>	
<<s:actionmessage cssStyle="color:red"/>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
  <tr>
    <td width="18%" style="font-weight: bold">销售单</td>
    <td colspan="3"> ${contract.id} </td>
    
  </tr>
   <tr>
    <td width="18%" >房间</td>
    <td colspan="3">${contract.unit.unitNo} </td>

  </tr>
  </table>
  
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更前的信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	<tr >
    <td>客户姓名</td>
    <td>电话</td>
    <td>证件号码</td>
   
    <td>产权比例</td>
 
  </tr>
  <s:iterator value="ownerList" id="blis">
  <tr>
    <td>${blis.customerName }</td>
    <td>${blis.phone }</td>
    <td>${blis.idcardNo }</td>
    <td>${blis.rightPercent }%</td>

  </tr>
   </s:iterator>
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更后的信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	<tr >
    <td>客户姓名</td>
    <td>电话</td>

    <td>证件号码</td>
    <td>产权比例</td>
  </tr>
  <s:iterator value="#session.changeOwnerList" id="flis">
  <tr>
    <td>${flis.customerName }</td>
    <td>${flis.phone }</td>
    <td>${flis.idcardNo }</td>
    <td>${flis.rightPercent }%</td>
  </tr>
   </s:iterator>
   <tr>
    <td colspan="5" align="right">
   		<input type="button" value="  新增  " id="add_owner_bu"> 	
    </td>
  </tr>
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更信息</div>
<form action="./saleunit/contract/guangzhou/addChangeOwnerForm.action" method="post">
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">

	<tr>
		<td width="100px">手续费</td>
		<td>
			<input type="text" id="change_owner_hand_fee" name="ownerForm.handFee"/>
		</td>
		<td width="100px">变更原因</td>
		<td >
			<select id="change_owner_reson_type" name="ownerForm.resonType">
				<option value="">请选择</option>
				<option value="1">原因1</option>
				<option value="2">原因2</option>
			</select>
		</td>
	</tr>
	
	<tr>
		<td>原因说明</td>
		<td colspan="3">
			<input type="text" id="change_owner_reson_desc" name="ownerForm.resonDesc" style="width: 100%"/>
		</td>
	</tr>
	<tr>
		<td>已交金额</td>
		<td colspan="3">
			<input type="text"/>
		</td>
	</tr>
	<tr>
		<td colspan="4" align="center">
			<input type="hidden" value="${contract.id}" name="contract.id"/>
		<input value="  提交申请  " type="submit" id="show_div_submit_for_owner"/>
		</td>
	</tr>
</table>
</form>
<div id="select_unit_div" style="width: 680px;height: 400px;background:		#0072E3;display: none;position: absolute">
	<div id="select_unit_div_head" style="width: 100%;height: 30px;background:	#0072E3;"><div id="select_unit_div_close" style="float: right;color:#ffffff;line-height: 30px;cursor: pointer;font-weight: bold;">关闭&nbsp;&nbsp;</div></div>
	<div id="select_unit_div_body" style="height: 88%;width: 670px;background: #FFF8D7;overflow: hidden;margin: 0px 4px"></div>
</div>