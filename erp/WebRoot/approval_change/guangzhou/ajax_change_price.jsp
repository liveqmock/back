 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>	
	<script type="text/javascript">
	$().ready(function(){
	
		$("#app_for_ok").click(function(){
			
			$("#appdiv").html("");
			$("#appdiv").remove();
			$("#movediv").remove();
			$("#closediv").remove();
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


<link href="./css/blue_guangzhou.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
<style>
		tr{background: #ffffff;line-height: 25px}
		td{padding-left: 5px}
	</style>
	
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">

  <tr style="background: #ffffff">
    <td style="font-weight: bold" width="18%">销售单</td>
    <td  width="32%">${confirm.id }</td>
    <td  width="18%"style="font-weight: bold">申请单状态</td>
    <td >${changePriceInfo.applyState }</td>
  </tr>
   <tr>
    <td >房间</td>
    <td colspan="3">${confirm.unit.unitNo } </td>

  </tr>
   <tr>
    
    <td>客户名称</td>
    <td>${confirm.customerName }</td>
    <td></td>
    <td></td>
  </tr>
   <tr>
    <td>建筑面积</td>
    <td>${confirm.unit.buildArea } </td>
    <td>套内面积</td>
    <td>${confirm.unit.insideArea } </td>
  </tr>
    <tr>
    <td>建筑单价</td>
    <td>${confirm.unit.buildPrice }</td>
    <td>套内单价</td>
    <td>${confirm.unit.insidePrice } </td>
  </tr>
   <tr>
    <td>计价方式</td>
    <td colspan="3">${confirm.priceWay } </td>
  </tr>
  <tr>
    <td>附属房间价格</td>
    <td></td>
    <td>标准总价</td>
    <td></td>
  </tr>
</table>


<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更前的信息</div>

<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">
		<td width="18%">付款方式</td>
		<td>
			${changePriceInfo.discountPercent1}
		</td>
		<td width="18%">折扣</td>
		<td>
			${changePriceInfo.buildPrice1}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  

		<td>建筑成交单价</td>
		<td>
			${changePriceInfo.insideUnitPrice1}
		</td>
		<td>套内成交单价</td>
		<td>
			${changePriceInfo.discountDesc1}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  

		<td>协议总价</td>
		<td>
			${changePriceInfo.agreeMoney1}
		</td>
		<td></td>
		<td>
			
		</td>
	</tr>
	
</table>

<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更后的信息</div>

<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">
		<td width="18%">计价方式</td>
		<td width="30%">
			${changePriceInfo.priceWay2}
		</td>
		<td width="18%">付款方式</td>
		<td width="30%">
			${changePriceInfo.payType2}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">
		<td>折扣百分比</td>
		<td>
			${changePriceInfo.discountPercent2}
		</td>
		<td>建筑成交单价</td>
		<td>
			${changePriceInfo.buildPrice2}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  

		<td>套内成交单价</td>
		<td>
			${changePriceInfo.insideUnitPrice2}
		</td>
		<td>折扣说明</td>
		<td>
			${changePriceInfo.discountDesc2}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  

		<td>房间总价</td>
		<td>
			${changePriceInfo.sumMoney2}
		</td>
		<td>装修标准</td>
		<td>
			${changePriceInfo.renovateDesc2}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  
 
		<td>装修单价</td>
		<td>
			${changePriceInfo.renovatePrice2}
		</td>
		<td>是否并入合同</td>
		<td>
			${changePriceInfo.isMerge2}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  

		<td>装修总价</td>
		<td>
			${changePriceInfo.renovateMoney2}
		</td>
		<td>协议编号</td>
		<td>
			${changePriceInfo.agreeNo2}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  

		<td>应收定金</td>
		<td>
			${changePriceInfo.shouldDeposit2}
		</td>
		<td>协议总价</td>
		<td>
			${changePriceInfo.agreeMoney2}
		</td>
	</tr>
	
	
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  
		<td width="18%">变更原因</td>
		<td width="30%">
			${changePriceInfo.resonType}
		</td>
		<td width="18%">手续费</td>
		<td width="30%">
			${changePriceInfo.handFee}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  
		<td>原因说明</td>
		<td>
			${changePriceInfo.resonDesc}
		</td>
		<td>申请人id</td>
		<td>
			${changePriceInfo.applyUser}
		</td>
	</tr>
	
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  
		<td>申请日期</td>
		<td>
		<s:date name="#request.changePriceInfo.applyDate" format="yyyy-MM-dd HH:ss"/>
		</td>
		<td>申请状态</td>
		<td>
			${changePriceInfo.applyState}
		</td>
	</tr>
	<tr bgcolor="#FFFFFF" onmouseout="this.style.backgroundColor=''" onmouseover="this.style.backgroundColor='#f1f9fe';" style="">  
		<td colspan="4" align="center">
			<input value="  通过审批  " id="app_for_ok" type="button" aid="${approvalId}"/>
		</td>
	</tr>
	</table>
