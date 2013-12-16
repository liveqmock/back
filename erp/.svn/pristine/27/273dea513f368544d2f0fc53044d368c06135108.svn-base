<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
	.trselect{ background: #FBEC88;}	
	.trmod{ background: #ffffff;}
	.unit_table td{padding: 5px}
	.unit_table{margin: 5px}
</style>
<script type="text/javascript">
$().ready(function(){
/*	${"questiontable>tr"}.click(function(){
		${"questiontable>tr"}.removeClass("trselect");
		$(this).addClass("trselect");
		
	});*/
	$(".quetr").click(function(){
		$(".quetr").removeClass("trselect").addClass("trmod");
		$(this).addClass('trselect').removeClass("trmod");
		qid = $(this).attr('qid');
		flushQuetionToc(qid);
	})

	//新建question
		$("#bar_add_question").unbind("click"); 
		$("#bar_add_question").click(function(){
			$("#min_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				onClose:function(){
				$('#min_dialog_ifram').html('......'); //清空内容
				},
				buttons:[ {
					text:'提交',
					iconCls:'icon-ok',
					handler:function(){
					window.document.getElementById("min_dialog_ifram").contentWindow.formsubmit();
					flushQuestionTable();
					}},
					{text:'关闭',
						iconCls:'icon-cancel',
					handler:function(){
						$('#min_dialog').dialog('close');
						flushQuestionTable();
					}}
				]
			});
			$('#min_dialog').dialog('open');
			$('#min_dialog').dialog('setTitle', '新建问卷'); 
			$('#min_dialog_ifram')[0].src="./saleunit_new_questions/appoint/guangzhou/questionDialog.action?treeId="+treeId+"&treeType="+treeType; 
			return false;
		});	


		$("#bar_update_question").unbind("click"); 
		$("#bar_update_question").click(function(){
			alert(qid);
		});	


		function flushQuetionToc(hhid){
			$.ajax({
				type:"get",
				url: "./saleunit_new_questions/appoint/guangzhou/questionTocTable.action",							
				data: "qid=" + hhid + "&ts=" + new Date(),
				dataType: "html",
				beforeSend: function(){
					$("#center_bottom").html("加载中...");
				},
				success: function(data){								
					$("#center_bottom").html(data);	
				}		
			});	
		};
});
</script>
<div style="width: 100%;height: auto; float: left"> 
<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" id="questiontable">
	<tr style="line-height: 20px;background: #E9F5FF">
		<th>调查问卷名称</th>
		<th>修改人</th>
		<th>修改时间</th>
	</tr>
	<s:iterator value="queList" var="c">
	<tr qid="${c.id}" class="quetr trmod" style="line-height: 16px">
		<td width="150px">${c.questionName }</td>
		<td width="150px">${c.modId }</td>
		<td width="200px">
			<s:date name="#request.c.modTime" format="yyyy-MM-dd"/>
			
		</td>
	</tr>
	</s:iterator>
</table>
</div>





