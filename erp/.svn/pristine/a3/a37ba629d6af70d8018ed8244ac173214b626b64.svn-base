<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>新建问卷</title>
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
		document.getElementById("question_form").submit();
    }
	</script>
	</head>
<body>
<div class="gbox1" style="">		
<form action="./saleunit_new_init/appoint/guangzhou/customerBeforeAddQuestionForm.action" id="question_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">
		<tr bgcolor="#ffffff">
			<td><font style="color:red">*</font>问卷名称</td>
			<td>
				<input name="newQuestion.questionName" id="question_name"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td><font style="color:red"></font>备注</td>
			<td>
				<input name="newQuestion.remark" id="remark"/>
			</td>
		</tr>
	</table>
	<input type="hidden" id="projectId" name="newQuestion.companyProjectId" value="${projectId}"/>
	<input type="hidden" id="questionId" name="selectQuestionId" value="${selectQuestionId}"/>
	<input type="hidden" id="flag" name="flag" value="${flag}"/>
	</form>
</div>
</body>
</html>