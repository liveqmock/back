<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>查看收款明细</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui.utils.js"></script>
	
	<script type="text/javascript" language="javascript">
		function deleteReceipt(checkfeeId, receiptId){
			
			if(checkfeeId>0){
				myAlert('该实收已经有对应的对数,不能删除.');
				return false;
			}
			deletePojo('./saleunit_financial_tabs/guangzhou/deleteReceipt.action?receiptId=' + receiptId, 
				function(){
					location.href = location.href;
				}, 
				'');
		}
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.rmb_format{text-align: right}
		.isVoid1{text-decoration:line-through}
		.isVoid0{}
		.exChangetd{background-color:#EEAD0E}
		.unit_table td {
			line-height: 20px;
			padding-left: 5px;
			padding-right: 5px;
		}
		
	</style>
	
</head>
<body>
<div class="gbox1">			
			  
	<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" id="receiptListTableId" style="font-size:12px">			

	<tr  style="line-height: 20px;background:#E9F5FF" > 
		
		<th width="100" align="center">单元编号</th>
		
		<th width="100" align="center">收款类别</th>
		<th width="100" align="center">收款内容</th>
		
		<th width="100" align="center">收款日期</th>
		
		<th width="100" align="center">收款金额</th>
		
		<th width="100" align="center">收款人</th>
		
		<th width="100" align="center">对佣日期</th>
		<th width="100" align="center">操作</th>
		
	</tr>
	<tr  style="line-height: 20px;background:#ffffff" > 
		<td width="100" align="center">总计 </td>
		
		<td width="100" align="center"></td>
		<td width="100" align="center"></td>
		
		<td width="100" align="center"></td>
		<td width="100" class="rmb_format"><my:format value="${allReceiptMoney}"/></td>
		
		<td width="100" align="center"></td>
		<td width="100" align="center"></td>
		<td width="100" align="center"></td>
	</tr>
	
	<s:iterator value="receiptList" var="c">
		 <tr bgcolor="#FFFFFF" style="line-height: 20px;" receiptId="${c.id}">  
			
			<td width="100" align="center">${c.unit.allName}</td>
			
			<td width="100" align="center">${c.typeName}</td>
			<td width="100" align="center">${c.feeType}</td>
			
			<td width="100" align="center"> 
				<s:date name="#request.c.receiptDate" format="yyyy-MM-dd"/>
			  </td>
			  
			<td width="100" class="rmb_format"><my:format value="${c.receiptMoney}"/></td>
			
			<td width="100" align="center">${c.inputMan}</td>
			
			<td width="100" align="center">
				<s:date name="#request.c.checkfee.checkfeeDate" format="yyyy-MM-dd"/>
			</td>
			
			<td width="100" align="center">
				<!--
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 0px 0px" id="receiptModifyId">修改</a>
				-->
				<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0px 5px 0px;" onclick="deleteReceipt(${c.checkfeeId}, ${c.id})">删除</a>		
			</td>
			
		</tr>
	</s:iterator>
	
</table>

	</div>
	
	
</body>
</html>
