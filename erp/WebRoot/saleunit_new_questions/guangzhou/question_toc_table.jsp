<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
	.enclick{background: #ffffff}
	
	.anclick{background: #FBEC88;}
	.patable td{padding: 0px 5px}
	.patable{margin: 5px}
</style>
<script type="text/javascript">

function question_toc_add(hhid){//hidid = qid
	$("#mid_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		onClose:function(){
		$('#mid_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("mid_dialog_ifram").contentWindow.formsubmit();
			}},
			{text:'关闭',
				iconCls:'icon-cancel',
			handler:function(){
				$('#mid_dialog').dialog('close');
			}}
		]
	});
	$('#mid_dialog').dialog('open');
	$('#mid_dialog').dialog('setTitle', '新建问题'); 
	$('#mid_dialog_ifram')[0].src="./saleunit_new_questions/appoint/guangzhou/questionTocAdd.action?qid="+hhid; 
	
};

$().ready(function(){
	$(".top_name_tr").click(function(){
		$(".top_name_tr").removeClass("anclick");
		$(this).addClass("anclick");
	});

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
	
	$("#toc_add").unbind("click"); 
	$("#toc_add").click(function(){
	//	alert(qid);
		question_toc_add(qid);
	});

	
});
function question_toc_dialog(hhid){
	
}
</script>
<div style="width: 100%; float: left;margin: 5px"> 
<input id="toc_add" type="button" class="btn1" value="  添加  "/>
<input id="toc_update" type="button" class="btn1" value="  修改  "/>
<input id="toc_del" type="button" class="btn1" value="  删除  "/>
</div>
<div style="width: 100%;height: auto; float: left"> 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox patable" style="font-size:12px; line-height:26px">
	<tr style="background: #E9F5FF">
		<th>类型</th>
		<th>问题</th>
		<th>选项</th>
	</tr>
	<s:iterator value="queTopicList" var="c">
	<tr class="top_name_tr enclick">
		<td >${c.topicGroup}</td><td width="150px">${c.topicName}</td><td>${c.inputHtml}</td>
	</tr>
	</s:iterator>
</table>
</div>





