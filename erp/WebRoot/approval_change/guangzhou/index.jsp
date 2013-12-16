<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>	
	<title>变更审批</title>	
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 	
	<script type="text/javascript">
			$().ready(function(){
				

				$(".cilcka").click(function(){
					var obj = new Object();
					obj.type = "iframe";
					obj.value = "./approval/change/showdiv.action?" 
						+ "changeType=" + $(this).attr("atype")+"&changeId="+$(this).attr("aid")+"&approvalId="+$(this).attr("appid");
					obj.width = "640px";
					obj.height = "400px";
					var dialog = new Dialog(obj,{title:'<font color="black">'+$(this).attr("titt")+'</font>', fixed:true, isReload:true});	
					dialog.show();
					return false;
				
			});
			});
		</script>	
		<style>
			.gbox td {padding-left: 5px}
		</style>
  </head>
 <body>
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">

</s:include>

<%--主体导航页头 --%>
<div class="title02" ><a href="./demo.action" target="_self">变更审批</a></div>
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>

<%--显示弹出框的DIV --%>
<div id="showdiv" style="position: absolute;top: 20% ;left: 40%; z-index: 1100;display: none;background: #3377aa;">
</div>

<div>
<form action="./approval/change/search.action" method="post">
&nbsp;申请类型<select  name="appChangeCond.applyType">
<option value=""> 请选择</option>
	<option value="CHANGE_PRICE"
	<s:if test="#request.appChangeCond.applyType == 'CHANGE_PRICE' ">
	selected="selected"</s:if>
	>变更价格</option>
	<option  value="CHANGE_UNIT"
	<s:if test="#request.appChangeCond.applyType == 'CHANGE_UNIT' ">
	selected="selected"</s:if>
	>换房</option>
	<option value="CHANGE_OUT"
	<s:if test="#request.appChangeCond.applyType == 'CHANGE_OUT' ">
	selected="selected"</s:if>
	>退房</option>
	<option value="CHANGE_OWNER"
	<s:if test="#request.appChangeCond.applyType == 'CHANGE_OWNER' ">
	selected="selected"</s:if>
	>变更权益人</option>
</select>
&nbsp;审批状态<select name="appChangeCond.approvalState">  
			<option value="">请选择</option>
			<option value="1" 
			<s:if test="#request.aappChangeCond.approvalState == '1' ">
			selected="selected"</s:if>
			>待审批</option>
			<option value="2" 
			<s:if test="#request.aappChangeCond.approvalState == '2' ">
			selected="selected"</s:if>
			>已审批</option>
			<option value="3" 
			<s:if test="#request.aappChangeCond.approvalState == '3' ">
			selected="selected"</s:if>
			>未通过</option>
		</select>
<input value="  搜索  " type="submit"/>
</form>
</div>

<div class="blueline"></div>	
<div>

 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox thisdiv" style="margin-top: 10px;">
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; class="gboxbg">
		<td ></td>
	    <td >申请类型</td>
	    <td>审批状态</td>
	    <td>审批意见</td> 
	    <td>批准人</td>
	    <td>批准日期</td> 
	    <td>执行人</td>
	    <td>执行日期</td>
</tr>
	<s:iterator value="appChangeList" id="li">
		<tr bgcolor="#FFFFFF";">
		<td> 
		<b atype="${applyType}" aid="${applyId}" appid="${id}" titt="${descApplyType}" class="cilcka"  style="color: #1199FF;cursor: pointer;text-decoration: underline">查看</b>
		</td>
		<td>${descApplyType}</td>
	    <td>${descApprovalState}</td>
	    <td>${approvalDesc}</td> 
	    <td>${descApprovalMan}</td>
	    <td>
	    	<s:date name="#li.approvalDate" format="yyyy-mm-dd"/>
	    </td> 
	    <td>${descDoMan}</td>
	    <td>
	    	<s:date name="#li.doDate" format="yyyy-mm-dd"/>
	    </td>
		</tr>
	 </s:iterator>
<tr>
	<td colspan="13"></td>
</tr>
</table>
<div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>
</div>	

<%--主体table end --%>
<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
  </body>
</html>

