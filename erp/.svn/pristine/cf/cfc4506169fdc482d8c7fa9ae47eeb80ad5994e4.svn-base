<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<script type="text/javascript">
function dialog_add_question(){
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:300,
		onClose:function(){
		$('#new_dialog_ifram').html('......');
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
				doQuestion();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '新建问卷'); 
	$('#new_dialog_ifram')[0].src="./saleunit_new_questions/appoint/guangzhou/questionDialog.action?treeId="+pro_pro_id;  
	
}

function dialog_add_question_de(hhhid){
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
				doQuestion();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '新建问题'); 
	$('#new_dialog_ifram')[0].src="./saleunit_new_questions/appoint/guangzhou/questionTocAdd.action?qid="+hhhid; 
}

function mod_one_question_toc(hhhid){
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
				doQuestion();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '修改问题'); 
	$('#new_dialog_ifram')[0].src="./saleunit_new_questions/appoint/guangzhou/questionTocMod.action?qtid="+hhhid; 
}

function order_question(questionId){
	new MyAjaxIframeDialog({title:'题目排序',height:400, width:500,formId:'question_toc_form',
		closeFn:doQuestion,ids:["topic_name","answer_id"],
		src:'./saleunit_new_questions/appoint/guangzhou/customerTopicOrder.action?qid='+questionId});
}

function del_one_question_toc(tocid){
	$.messager.confirm('确认框','是否确定删除',function(r){  
	    if (r){  
	    	$.post('./saleunit_new_init/appoint/guangzhou/delQuestionToc.action',{'questionTocId':tocid},function(date){
	    		$.messager.alert('消息',date);
	    		doQuestion();
	    	})
	    }
	});
	
}

function del_one_question(qid){
	$.messager.confirm('确认框','是否确定删除',function(r){  
	    if (r){  
	    	$.post('./saleunit_new_init/appoint/guangzhou/delQuestion.action',{'qid':qid},function(date){
	    		$.messager.alert('消息',date);
	    		doQuestion();
	    	})
	    }
	});
	
}

function copy_question(qid){
	$("#new_dialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:500,
		height:400,
		onClose:function(){
		$('#new_dialog_ifram').html('......');
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
				doQuestion();
			}}
		]
	});
	$('#new_dialog').dialog('open');
	$('#new_dialog').dialog('setTitle', '复制问卷'); 
	$('#new_dialog_ifram')[0].src="./saleunit_new_questions/appoint/guangzhou/copyDialog.action?qid="+qid;  
}

$().ready(function(){
	$("#_add_question").click(function(){
		dialog_add_question();
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
})

</script>

<input type="button" value="添加问卷" id="_add_question" class="btn1" />
<font color="red">说明:同一个楼盘下，使用同一套售后问卷列表。</font> 
<table width="95%"  border="0" align="center" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF"  id="questiontable">
	<tr style="line-height: 20px;background: #E9F5FF">
		<th>调查问卷名称	</th>
		<th>创建人</th>
		<th>题目</th>
		<th></th>
	</tr>
	<s:iterator value="queMap" var="c">
	<tr qid="${c.ques.id}" class="questr" style="line-height: 16px;background-color: #ffffff"  > 
		<td width="150px" valign="top">${c.ques.questionName }</td>
		<td width="80px" valign="top">${c.ques.createdIdStr }</td>
		<td style="margin: 0px;padding: 0" valign="top">
			<table border="0" align="center" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF;width: 100%;margin-bottom: 10px">
				<s:iterator value="#request.c.toc" var="n" status="st">
						
						<tr style="background-color: #eeeeee" onMouseOver="this.style.backgroundColor='#FBEC88';" onMouseOut="this.style.backgroundColor='#ffffff'">
						<td width="80px">${n.topicGroup}</td><td width="150px">${n.topicName}</td><td>${n.inputAndOtherHtml}</td>
						<td valign="top" width="80px"><input  type="button" value="删除问题" onclick="del_one_question_toc(${n.id})"  class="btn1" style="margin: 0 5px;"/></td>
						<td valign="top" width="80px"><input  type="button" value="修改问题" onclick="mod_one_question_toc(${n.id})"  class="btn1" style="margin: 0 5px;"/></td>
						</tr>
				</s:iterator>
			</table>
		</td>
		<td valign="top" width="90px" > 
			<input  type="button"  value="添加题目" onclick="dialog_add_question_de(${c.ques.id})" class="btn1" style="margin: 2px 5px;"/> <br>
			<input  type="button" value="删除问卷" onclick="del_one_question(${c.ques.id})" class="btn1" style="margin: 2px 5px;"/><br>
			<input  type="button"  value="复制问卷" onclick="copy_question(${c.ques.id})" class="btn1" style="margin: 2px 5px; "/><br>
			<input  type="button"  value="题目排序" onclick="order_question(${c.ques.id})" class="btn1" style="margin: 2px 5px; "/><br>
		</td>
	</tr>
	</s:iterator>
</table>







