<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>合同</title>
	<s:include value="../../header/header_easyui.jsp"></s:include>	  
	<style type="text/css">
		*{margin:0;padding:0;}
		input{width: 75%}
		td{padding: 5px}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("question_form").submit();
    }
	</script>
	</head>
<body>
<form action="./saleunit_new_questions/appoint/guangzhou/questionDialogForm.action" id="question_form" method="post">	
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px">
		<tr bgcolor="#E9F5FF">
			<td style="padding-left: 5px" colspan="2" width="150px">${topText}</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>问卷名称</td>
			<td>
			<input name="newQuestion.questionName" style="width: 150px"/>
			<input type="hidden" name="treeId" value="${treeId}"/>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td>说明</td>
			<td>
				<textarea rows="20" cols="20" style="width: 150px;height: 30px;" name="newQuestion.remark"></textarea>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td colspan="2" style="color: red">${tips }</td>
		</tr>
	</table>
	</form>

</body>
</html>