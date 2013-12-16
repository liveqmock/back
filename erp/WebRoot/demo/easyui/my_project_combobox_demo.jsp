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
<b>项目下拉框(单选，多选)说明：</b>

<br/>

<p></p>
<p><b>参考：</b></p>
成交客户背景分析(多选)<br/>
<a href="./saleunit_new_report/report/guangzhou/cjkhbjFirst.action" target="_blank">./saleunit_new_report/report/guangzhou/cjkhbjFirst.action</a>
<br/>

<p>struts-saleunit-common.xml</p>
<p>&lt;!-- 销控中心的公司项目下拉框 --&gt;<br />
&lt;action name=&quot;modifyProjectXKZXajax&quot; class=&quot;com.ihk.saleunit.action.common.CommonAction&quot; method=&quot;modifyProjectXKZXajax&quot;/&gt;<br />
<br />
&lt;!-- 售前客户的公司项目下拉框 --&gt;<br />
&lt;action name=&quot;modifyProjectSQKHajax&quot; class=&quot;com.ihk.saleunit.action.common.CommonAction&quot; method=&quot;modifyProjectSQKHajax&quot;/&gt;</p>
<p>project.list.utils.js</p>
<p>//销控中心角色的多选公司项目<br />
  function bindProjectDialogForXKZX(projectTextId, projectHiddenId){<br />
bindProjectDialog(projectTextId, projectHiddenId, &quot;modifyProjectXKZX&quot;);<br />
}</p>
<p>//售前客户角色的多选公司项目<br />
  function bindProjectDialogForSQKH(projectTextId, projectHiddenId){<br />
  bindProjectDialog(projectTextId, projectHiddenId, &quot;modifyProjectSQKH&quot;);<br />
  }</p>
<p>//销控中心角色的单选公司项目<br />
  function bindProjectDialogForXKZXOnly(projectTextId, projectHiddenId){<br />
  bindProjectDialog(projectTextId, projectHiddenId, &quot;modifyProjectXKZX&quot;, false);<br />
  }</p>
<p>//售前客户角色的单选公司项目<br />
  function bindProjectDialogForSQKHOnly(projectTextId, projectHiddenId){<br />
  bindProjectDialog(projectTextId, projectHiddenId, &quot;modifyProjectSQKH&quot;, false);<br />
  }</p>
<p><br/>
  
  <br/>
</p>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b>
<textarea rows="10" cols="150">
1，配置文件：

	    <!-- 成交客户背景分析 -->
	    <action name="cjkhbjFirst" class="com.ihk.customer.action.CjkhbjReportAction" method="cjkhbjFirst" >
			<result name="cjkhbjFirst">/saleunit_new_report/guangzhou/cjkhbj_report_first.jsp</result>
		</action>
		
2，jsp代码调用		
		$().ready(function() {
	        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
	        
</textarea>
<br/>

</body>
</html>

