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
    <td width="18%" style="font-weight: bold">销售单</td>
    <td width="32%">${contract.id }</td>
    <td width="18%" style="font-weight: bold">申请单状态</td>
    <td></td>
  </tr>
   <tr>
    <td >房间</td>
    <td colspan="3">${contract.unit.unitNo }</td>

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
  <s:iterator value="ownerList" id="clist">
  <tr>
    <td>${clist.customerName }</td>
    <td>${clist.phone }</td>
    <td>${clist.idcardNo }</td>
    <td>${clist.rightPercent }%</td>

  </tr>
   </s:iterator>
</table>

  <div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更后信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	<tr >
    <td>客户姓名</td>
    <td>电话</td>
    <td>证件号码</td>
   
    <td>产权比例</td>
 
  </tr>
  <s:iterator value="OwnerListForDetail" id="blis">
  <tr>
    <td>${blis.customerName }</td>
    <td>${blis.phone }</td>
    <td>${blis.idcardNo }</td>
    <td>${blis.rightPercent }%</td>

  </tr>
   </s:iterator>
</table>
<div style="font-size: 12;font-weight: bold;background:#f1f9fe " ><br/>变更信息</div>
<table bgcolor="#ffffff" style="font-size: 12"  class="gbox" width="100%" align="center" cellspacing="1" cellpadding="0" border="0">
	
   <tr>
		<td width="18%" background="#eeeeee">变更原因</td>
		<td width="32%">
			${changeOwnerInfo. resonType}
		</td>
		<td width="18%">主单ID</td>
		<td>
			${changeOwnerInfo. handFee}
		</td>
	</tr>
   <tr>
		<td>原因说明</td>
		<td>
			${changeOwnerInfo. resonDesc}
		</td>
		<td>申请人</td>
		<td>
			${changeOwnerInfo. applyUser}
		</td>
	</tr>
    <tr>
		<td>申请日期</td>
		<td>
			<s:date name="#request.changeOwnerInfo.applyDate" format="yyyy-MM-dd HH:ss"/>
		
		</td>
		<td>申请状态</td>
		<td>
			${changeOwnerInfo. applyState}
		</td>
	</tr>

</table>

