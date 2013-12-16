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
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
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

<script type="text/javascript">
var qid = ${qid};
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
		question_toc_add(qid);
	});
});

</script>
</head>
<body>
<div style="width: 100%; float: left;margin: 5px"> 
<input id="toc_add" type="button" class="btn1" value="  添加  "/>
<input id="toc_del" type="button" class="btn1" value="  删除  "/>
</div>
<div style="width: 30%;height: auto; float: left"> 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox patable" style="font-size:12px; line-height:26px">
	<tr style="background: #E9F5FF">
		<th>类型</th>
		<th>问题</th>
		<th>选项</th>
	</tr>
	<s:iterator value="queTopicList" var="c">
	<tr class="top_name_tr enclick" style="background-color: #eeeeee">
		<td >${c.topicGroup}</td><td width="150px">${c.topicName}</td><td>${c.inputHtml}</td>
	</tr>
	</s:iterator>
</table>
</div>
<div id="mid_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:800px;height:400px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='mid_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
</body></html>