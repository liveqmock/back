<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%--<script type="text/javascript" language="javascript" src="<%=basePath%>js/validate.js"></script>--%>
<script type="text/javascript">
function _customer_before_addtoc_dialog(){//hidid = qid
	new MyAjaxIframeDialog({title:'新建问题',height:400, width:500,formId:'question_toc_form',
		closeFn:doCustomerBeforTab,ids:["topic_name","answer_id"],
		src:'./saleunit_new_init/appoint/guangzhou/customerBeforeDialog.action'
		}) 
};

$().ready(function(){

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
<input type="button" value="  添加  " class="btn1" id="_but_cus_before_add" onclick="_customer_before_addtoc_dialog()"/>
<input type="button" value="  刷新  " class="btn1" id="" onclick="doCustomerBeforTab()"/>
<font color="red">说明:同一个项目下，售前客户问卷初始化的问题相同。</font>
<br/>

<table width="95%"  border="0" align="left" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF"  id="questiontable">
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