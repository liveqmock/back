<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>售前客户问卷 </title>
<s:include value="header_report.jsp"></s:include>
<script type="text/javascript">
function _customer_before_addtoc_dialog(){//hidid = qid
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:400,
		onClose:function(){
		$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("new_dialog_ifram").contentWindow.formsubmit();
			}},
			{text:'关闭',
				iconCls:'icon-cancel',
			handler:function(){
				$('#new_dialog').dialog('close');
				doCustomerBeforTab();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '新建问题'); 
	$('#new_dialog_ifram')[0].src="./saleunit_new_init/appoint/guangzhou/customerBeforeDialog.action"; 
};

$().ready(function(){
			
	//页面加载时执行
	//projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
	bindProjectDialogForSQKHOnly("projectName", "hiddenId"); //多个项目的选择

	$(".btn1").hover(
			  function () {
				    $(this).addClass("btn1_mouseover");
				  },
				  function () {
				    $(this).removeClass("btn1_mouseover btn1_d");
				  }
				); 
	$(".btn1").mousedown(function(){
		 $(this).removeClass("btn1_mouseover").addClass("btn1_d");
	});

	
})

function submitSearch(dir){
				$("#thisForm").submit();	
			}

function do_del_question_by_deid(delid){
	$.post('./saleunit_new_init/appoint/guangzhou/customerBeforeDelByDeId.action',{'deId':delid},doCustomerBeforTab());
}


$.messager.defaults = { ok: "确定", cancel: "取消" };
function del_select_question(delid){

	$.messager.confirm('询问框','是否确定删除问题?',function(r){  
	    if (r){  
	    	do_del_question_by_deid(delid);
	    }
	});  
		return false;
	}
	
/* */
 
 
</script>
</head>
<body style="padding:0px;background:white;">

<form class="registerform" id="thisForm"  method="post">
	

<table width="95%"  border="0" align="left" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF"  id="questiontable">
<tr>
	<td colspan="6">
&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
<input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>
&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>

&nbsp;<input type="button" value="  添加  " class="btn1" id="_but_cus_before_add" onclick="_customer_before_addtoc_dialog()"/>
<font color="red">说明:同一个项目下，售前客户问卷初始化的问题相同。</font>
<br/>
	</td>
</tr>
		<tr style="line-height: 20px;background: #E9F5FF">
		<th width="150px">问题</th>
		<th>选项</th>
		<th width="50px"></th>
		</tr>
	<s:iterator value="tocList" var="c">
	<tr style="background-color: #ffffff;;line-height: 24px">
			<td>${c.topicName }</td>
			<td>${c.inputAndOtherHtml }</td>
			<td><a class="btn1" style="cursor: pointer;"   onclick="del_select_question(${c.id});">  删除  </a> </td>
	</tr>
	</s:iterator>
	
</table>
</form>
</body>
</html>