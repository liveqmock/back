<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>查看或者修改答卷</title>
<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		td{padding: 5px}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("question_form").submit();
    };
    
	</script>
	</head>
<body>
<div >		
	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px">
		<tr bgcolor="#ffffff">
			<td align="center" width="100px">问卷</td>
			<td colspan="3">
				${topShow}
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center" width="100px">回答人</td>
			<td colspan="3">
				${upQuestionAnwser.customerName}
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="center" width="100px">备注</td>
			<td colspan="3">
				${upQuestionAnwser.remark}
			</td>
		</tr>
	</table>
	
	
</div>
<form id="question_form" action="${path }" method="post">
<div   >

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px">
	<tr style="background: #E9F5FF">
		<th width="110px">类型</th>
		<th width="150px">问题</th>
		<th>选项</th>
	</tr>
	<s:iterator value="tocList" var="c">
	<tr style="background: #ffffff;">
		<td >${c.group}</td><td width="150px">${c.name}</td><td nowrap="nowrap">${c.content}</td>
	</tr>
	</s:iterator>
	
</table>
<input type="hidden" value="${id }" name="id"/>
</div>
</form>
</body>
</html>