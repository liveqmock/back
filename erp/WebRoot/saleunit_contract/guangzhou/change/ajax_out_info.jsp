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
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
 
  <tr>
    <td style="font-weight: bold"  width="18%">销售单</td>
    <td  width="30%">${contract.id}</td>
    <td style="font-weight: bold"  width="18%">申请单状态</td>
    <td  width="30%">${changeOutInfo.applyState }</td>
  </tr>
   <tr>
    <td >房间</td>
    <td colspan="3">${contract.unit.unitNo }</td>

  </tr>
   <tr>
    
    <td>客户名称</td>
    <td>${contract.customerName }</td>
    <td></td>
    <td></td>
  </tr>
   <tr>
    <td>建筑面积</td>
    <td>${contract.unit.buildArea }</td>
    <td>套内面积</td>
    <td>${contract.unit.insideArea } </td>
  </tr>
   <tr>
    <td>建筑单价</td>
    <td>${contract.unit.buildPrice } </td>
    <td>套内单价</td>
    <td>${contract.unit.insidePrice } </td>
  </tr>
   <tr>
    <td>计价方式</td>
    <td>${contract.priceWay} </td>
    <td></td>
    <td> </td>
  </tr>
 
   <tr>
    <td>建筑成交单价</td>
    <td>${contract.buildPrice}</td>
    <td>套内成交单价</td>
    <td>${contract.insideUnitPrice}</td>
  </tr>
   <tr>
    <td>附属房间价格</td>
    <td></td>
    <td>标准总价</td>
    <td>${contract.unit.sumPrice}</td>
  </tr>
   <tr>
    <td>付款方式</td>
    <td>${contract.payType} </td>
    <td>折扣</td>
    <td>${contract.discountPercent} </td>
  </tr>
   <tr>
    <td>协议总价</td>
    <td> </td>
    <td></td>
    <td></td>
  </tr>
  </table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	
	<tr>
		<td width="18%">变更原因</td>
		<td width="30%">
			&nbsp;${changeOutInfo.resonType}
		</td>
		<td width="18%">手续费</td>
		<td width="30%">
			&nbsp;${changeOutInfo.handFee}
		</td>
	</tr>
   <tr>
		<td>原因说明</td>
		<td>
			&nbsp;${changeOutInfo.resonDesc}
		</td>
		<td>申请人</td>
		<td>
			&nbsp;${changeOutInfo.applyUser}
		</td>
	</tr>
	 <tr>
		<td>申请日期</td>
		<td>
			&nbsp;${changeOutInfo.applyDate}
		</td>
		<td>申请状态</td>
		<td>
			&nbsp;${changeOutInfo.applyState}
		</td>
	</tr>	
</table>


