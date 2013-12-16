<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title></title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
</head>
<body  style="padding:10px;">
<b>弹窗(内容框)说明：</b>

<br/>

<p></p>
<p><b>参考：</b></p>
<p>/js/easyui.utils.js</p>
<p><b>myConfirm()</b><br/>
  <br/>
  <br/>
  <b>MyAjaxIframeDialog</b><br/>
  弹出框建议用iframe的方式，可以重用原有实现的任何组件<br/>
  iframe的方式,也很容易做到弹出框,再弹出框;例如MyAjaxIframeDialogX2表示调用第二层弹出框(弹出框的弹出框)<br/>
  div的方式，适用于简单的页面，页面中的元素是基本的元素<br/>
  已经封装了基本的数据录入校验,可以参考"数据校验"<br/>
  <br/>
</p>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="30" cols="150">

	myConfirm("确定作废?", function cancelData(){
		$.ajax({
			type:"get",
			url: "./saleunit_new_init/appoint/guangzhou/cancelContractManager.action?id=" + contractManagerId,
			dataType: "json",
			success: function(data){
				
				var type = data.type;
				if(type == "true"){
					treeToContractManager();
				}else{
					myAlert("操作失败,请重试");
				}
			},
			error: function(XMLHttpRequest, textStatus, errorThrown){
				myAlert("出现异常,请重试");
			}
		})	
	});
	
	
	new MyAjaxIframeDialog({title:'新建用户账户', formId:'inputform',
		height:450,
		src:'./user/manager/inputUser.action',
		ids:['userName','userPwd','realName'],
		closeFn:function(){$("#queryForm").submit();}
		});	
</textarea>
<br/>

</body>
</html>

