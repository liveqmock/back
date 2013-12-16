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
	<title>变更权益人</title>
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery-1.6.2.min.js"></script>	
			<script type="text/javascript" src="<%=basePath %>js/move_id.js"></script>
	<script type="text/javascript">
	$().ready(function(){
		moveForId('movediv','showdiv');
		$("#appok").click(function(){
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
						location = location;
					}
				});
			
			});
		$("#appno").click(function(){
			$("#appdiv").html("");
			$("#appdiv").remove();
			$("#movediv").remove();
			$("#closediv").remove();
			$.ajax({
				type:"post",
				url: "./approval/change/update.action",
				data: "changeId=" + $(this).attr("aid")+"&changeState=no",
				dataType: "html",
				success: function(data)
					{
						alert(data);
						location = location;
					}
				});
		});
		$("#hid").click(function(){
			$("#appdiv").html("");
			$("#appdiv").remove();
			$("#movediv").remove();
			$("#closediv").remove();
		});
		$("#closediv").click(function(){
			$("#appdiv").html("");
			$("#appdiv").remove();
			$("#movediv").remove();
			$("#closediv").remove();
		});
	});
	</script>
		
  </head>
 <body>
  <div style="float: left;width: 450px;height: 28px;z-index: 1500;color: #ffffff;cursor: move;" id="movediv">&nbsp;<b>权益人变更</b></div>
 <div style="float: right;width: 30px;height: 12px;z-index: 1500;color: #ffffff;cursor: pointer;" id="closediv"><b>关闭</b></div>
 <div id="appdiv" style="background:#3377aa;width: 500px;height: 400px">
 	 <div style="background:#ffffff;width: 490px;height: 350px;overflow: scroll;margin-left: 5px;margin-top: 30px">
<table bgcolor="#ffffff">
	<tr>
		<td>认购或合同</td>
		<td>
			&nbsp;${changeOwnerInfo.confirmType}
		</td>
		<td>主单ID</td>
		<td>
			&nbsp;${changeOwnerInfo.mainId}
		</td>
	</tr>
   <tr>
		<td>变更原因</td>
		<td>
			&nbsp;${changeOwnerInfo. resonType}
		</td>
		<td>主单ID</td>
		<td>
			&nbsp;${changeOwnerInfo. handFee}
		</td>
	</tr>
   <tr>
		<td>原因说明</td>
		<td>
			&nbsp;${changeOwnerInfo. resonDesc}
		</td>
		<td>申请人</td>
		<td>
			&nbsp;${changeOwnerInfo. applyUser}
		</td>
	</tr>
    <tr>
		<td>申请日期</td>
		<td>
			&nbsp;${changeOwnerInfo. applyDate}
		</td>
		<td>申请状态</td>
		<td>
			&nbsp;${changeOwnerInfo. applyState}
		</td>
	</tr>

</table>
</div>

		<div style="float: right;margin-top: 20px;margin-right: 5px">
			<input value="  确定审批  " type="button" aid="${approvalId}" id="appok"/><input aid="${approvalId}" value="  否定审批  " type="button" id="appno"/><input value="  取消  " type="button" id="hid"/>
	</div>
</div>
</body>
</html>