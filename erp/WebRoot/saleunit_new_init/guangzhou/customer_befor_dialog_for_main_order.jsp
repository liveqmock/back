<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>新建问卷详细信息</title>
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
		input{width: auto;}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("question_toc_form").submit();
    }
	</script>
	</head>
<body>
<div class="gbox1" style="">		
<form action="./saleunit_new_init/appoint/guangzhou/customerBeforeDialogFormForMainOrder.action" id="question_toc_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">
		<tr bgcolor="#ffffff">
				<td><font color="red">排序序号</font></td>
				<td><font color="red">题目名称</font></td>
			</tr>
		<s:iterator value="tocList" var="toc">
			<tr bgcolor="#ffffff">
				<input type="hidden" name="newTopicIndex${toc.id}Id" value="${toc.id}"/>
				<td><input type="text" name="newTopicIndex${toc.id}OrderIndex" value="${toc.orderIndex}"/></td>
				<td>${toc.topicName}</td>
			</tr>
		</s:iterator>
		<input type="hidden" name="selectQuestionId" value="${selectQuestionId}"/>
	</table>
	</form>
</div>
</body>
</html>