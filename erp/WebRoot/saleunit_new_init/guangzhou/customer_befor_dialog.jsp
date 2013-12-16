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
<form action="./saleunit_new_init/appoint/guangzhou/customerBeforeDialogForm.action" id="question_toc_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">
		<tr bgcolor="#ffffff">
			<td>题目名</td>
			<td>
				<input name="newQuestionTopic.topicName" id="topic_name"/>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff">
			<td>是否必填</td>
			<td>
				否<input name="newQuestionTopic.fillType" type="radio" value="0" checked="checked" style="vertical-align: middle;"/>
				
				是<input name="newQuestionTopic.fillType" type="radio" value="1" style="vertical-align: middle;"/>
			</td>
		</tr>
		
		<tr bgcolor="#ffffff">
			<td>答案类型</td>
			<td>
				<input type="radio" name="newQuestionTopic.topicType" value="1" checked="checked"/>单选
				<input type="radio" name="newQuestionTopic.topicType" value="2"/>多选
				<input type="radio" name="newQuestionTopic.topicType" value="3"/>文本框
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>答案内容</td>
			<td>
			<input type="hidden" name="qid" value="${qid}"/>
			换行区分答案选项
			<textarea id="answer_id" rows="" cols="" style="width: 90%;height: 80px;font-size: 12px" name="newQuestionTopic.topicContent"></textarea>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td colspan="4" style="color: red"><s:actionmessage/></td>
			<input type="hidden" name="selectType" value="__init__"/>
		</tr>
	</table>
	</form>
</div>
</body>
</html>