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
<b>easyui版查询与分页(json)说明：</b>

<br/>

<p></p>
<p><b>参考：</b><br/>
<b>例子地址:</b>(可以点击打开)<br/>
<a style="color:blue;" href="./saleunit_new_report/report/guangzhou/khcj.action" target="_blank">saleunit_new_report/report/guangzhou/khcj.action</a>

<br/><br/>
<b>做法步骤</b><br/>
<table>
<tr><th>序号</th><th>说明</th><th>参考</th><th>注意</th></tr>
<tr><td>1</td><td>配置struts.xml文件，增加节点</td><td>struts-saleunit-new-report.xml</td><td>
<textarea rows=10 cols=80 >
<action name="khcj" class="com.ihk.customer.action.KhcjReportAction" method="khcj" >
<result name="success">/saleunit_new_report/guangzhou/khcj_report.jsp</result>
</action>
</textarea>
</td></tr>
<tr><td>2</td><td>java中的action类，添加对应的查询方法</td><td>KhcjReportAction.java</td><td>
<textarea rows=10 cols=80 >
khcj里面实现查询数据
	private void initSearchData(){
		
		if(contractCustomerCond == null){
			contractCustomerCond = new ContractCustomerCond();
		
			contractCustomerCond.setDate1(CommonUtils.getMonthFirstForString());
			contractCustomerCond.setDate2(CommonUtils.getMonthEndForString());
		}
		
		selConfirmType = ContractCustomerUtils.initConfirmType(false);
		contractCustomerCond.setConfirmType(ContConfirmType.CONFIRM);
		
		initPermissionProjectIds();
	}
</textarea>
</td></tr>
<tr><td>3</td><td>编写jsp页面，在页面中定义好表头</td><td>khcj_report.jsp</td><td>
<textarea rows=10 cols=80 >
		<table id="khcj_table" style="width:auto;height:612px;">
	        <thead>  
	            <tr>  
	            	<th field="projectName" width="140px" align="center">楼盘名称</th>
					
	            	<th field="buildName" width="140px" align="center">楼栋</th> 
					
	                <th field="unitNo" width="140px" align="center">房号</th> 					
	                <th field="buildArea" width="140px" align="center">建筑面积</th>
</textarea>
</td></tr>
<tr><td>4</td><td>在jsp页面中，编写easyui对应的加载方式</td><td>khcj_report.jsp</td><td>
<textarea rows=10 cols=80 >
$(function(){		
			//DEMO easyui的声明,按easyui的要求
			$("#khcj_table").datagrid({
				loadMsg:'加载中...',
				pagination:true, 
				rownumbers:true,
				singleSelect:true,
				striped:true,
</textarea>
</td></tr>

<tr><td>5</td><td>在jsp页面中，点击查询的ajax查询</td><td>KhcjReportAction.java</td><td>
<textarea rows=10 cols=80 >
<action name="khcjReportAjax" class="com.ihk.customer.action.KhcjReportAction" method="khcjReportAjax"/>

ActionTemplate.executeAjaxPage这个方法已经封装了具体的分页功能
ActionTemplate.executeAjaxPage(this, contractCustomerCond, new ActionAjaxPageCallback() {... ...
</textarea>
</td></tr>
</table>
<br/>

<hr/>		
<br/><br/>
<b>配置文件:</b><br/>
  struts-saleunit-new-report.xml</p>
<p>&lt;action name=&quot;khcj&quot; class=&quot;com.ihk.customer.action.KhcjReportAction&quot; method=&quot;khcj&quot; &gt;<br />
&lt;result name=&quot;success&quot;&gt;/saleunit_new_report/guangzhou/khcj_report.jsp&lt;/result&gt;<br />
&lt;/action&gt;<br/>
</p>
点击"查找"按钮执行的action<br/>
<p>&lt;action name=&quot;khcjReportAjax&quot; class=&quot;com.ihk.customer.action.KhcjReportAction&quot; method=&quot;khcjReportAjax&quot;/&gt;</p>
<p></p><br/>
<br/>
<b>khcj_report.jsp的说明：</b><br/>
要按照easyui的datagrid的声明,详细看里面的demo注释<br/><br/>


<b>khcjReportAjax的说明(详细看KhcjReportAction.java中的khcjReportAjax)</b><br/>
实现"查找"的action代码:<br/>
ActionTemplate.executeAjaxPage这个方法已经封装了具体的分页功能<br/>

		ActionTemplate.executeAjaxPage(this, contractCustomerCond, new ActionAjaxPageCallback() {... ...<br/>
		

<br/><br/>
分页的table,easyui的jsp写法<br/>
注意不要直接写了table的class为easyui-datagrid，因为js写绑定，如果再写class,则会导致加载两次<br/>
<textarea cols="100" rows="15">
		function queryForm(){
			var selRoleId = $("#roleIds").val();
			var url = "./user/manager/searchRoleprivAjax.action?selRoleId=" + selRoleId;
			//使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染			
			$("#dg").datagrid({
				url:"./user/manager/searchRoleprivAjax.action",
				queryParams:{"selRoleId":selRoleId}
			});
			//alert(url);
		}		
		$().ready(function(){				
			queryForm();
		});	
</textarea>
<br/><br/>


</body>
</html>

