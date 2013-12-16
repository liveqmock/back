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
<b>公司下拉框(单选，多选)说明：</b>

<br/>

<p></p>
<p><b>参考：</b></p>

公司结佣明细(多选)<br/>
<a href="./saleunit_new_report/report/guangzhou/commission_companyFirst.action" target="_blank">./saleunit_new_report/report/guangzhou/commission_company.action</a>
<br/>

<p>struts-saleunit-common.xml</p>
<p>&lt;!-- 通配符 --&gt;<br />
&lt;action name=&quot;*&quot; class=&quot;com.ihk.saleunit.action.common.CommonAction&quot; method=&quot;{1}&quot;/&gt;</p>
<p>project.list.utils.js<br/>
  
</p>
<p>//销控中心角色的公司多选<br />
  function bindCompanyForXKZX(companyTextId, companyHiddenId){<br />
  bindProjectDialog(companyTextId, companyHiddenId, &quot;modifyCompanyXKZX&quot;);<br />
  }</p>
<p>//销控中心角色的公司单选<br />
  function bindCompanyForXKZXOnly(companyTextId, companyHiddenId){<br />
  bindProjectDialog(companyTextId, companyHiddenId, &quot;modifyCompanyXKZX&quot;, false);<br />
  }</p>
<br/>


<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b>
<textarea rows="10" cols="150">
1,公司多选
$(document).ready(function(){
            bindCompanyForXKZX("companyName", "companyID"); //单个项目的选择

2,公司单选            
</textarea>
<br/>

</body>
</html>

