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
		td{padding: 5px}
	</style>
	<script>
	function formsubmit (){
		document.getElementById("question_form").submit();
    };

    function flushToc(tocid){
    	$.ajax({
			type:"get",
			url: "./saleunit_new_questions/appoint/guangzhou/selectQuestionOption.action",							
			data: "id=" + tocid + "&ts=" + new Date(),
			dataType: "html",
			beforeSend: function(){
				$("#ques_toc_div").html("加载中...");
			},
			success: function(data){								
				$("#ques_toc_div").html(data);	
			}		
		});	
    }
    
    $().ready(function(){
		if($("#selectq").val() != ''){
			flushToc($("#selectq").val());
		}
        
		$("#selectq").change(function(){<%-- 加载选择的问卷问题--%>
			flushToc($(this).val());
		});
		
    });
	</script>
	
	
	</head>
<body>
<form id="question_form" action="${path}" method="post">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px">
		<tr bgcolor="#ffffff">
			<td align="right" width="80px" style="font-weight: bold;"><font style="color: red">*</font> 调查表</td>
			<td colspan="3" >
				<s:select cssStyle="min-width: 200px" name="questionId" list="quesList" id="selectq"  listKey="id" listValue="questionName" ></s:select>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="right" style="font-weight: bold;"><font style="color: red">*</font> 回答人</td>
			<td>
				<s:select list="customerList" id='customerList' name='customerId' value='customerName'></s:select>
			</td>
		</tr>
		<tr bgcolor="#ffffff">
			<td align="right" style="font-weight: bold;">备注</td>
			<td>
				<input type="text" name="reMark" style="width: 360px" maxlength="200"/>
			</td>
		</tr>
	</table>
<div style="" id="ques_toc_div">
</div>
<input type="hidden" name="unitId" value="${id}"/>
</form>
<p style="color: red">${tips}</p>
</body>
</html>