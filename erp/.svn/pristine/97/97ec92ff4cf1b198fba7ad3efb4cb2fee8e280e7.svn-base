<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <s:include value="../../customer/guangzhou/header.jsp"></s:include>


    <title>系统功能点击记录</title>
    <style >
        .thisdiv td{padding-left:15px}
        tr{height: 26px;}
    </style>
    <script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>

    <script type="text/javascript">
        $().ready(function(){

            projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
        	queryForm();
        });
        $(window).resize(function(){
			$('#dg').datagrid('resize');
		});	
        function queryFormByWeek(){
			setTwoDatebox("thisweek",$("#date1"),$("#date2"));
			queryForm();
		}		
		
		//查询本月
		function queryFormByMonth(){
			setTwoDatebox("thismonth",$("#date1"),$("#date2"));
			queryForm();
		}	
        function queryForm(){
			//使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染		
			$("#dg").datagrid({
				remoteSort:false,
				width:this.width,
				toolbar:'#toolbar',
				height:$(this).height()-10,
				rownumbers:true,
				singleSelect:true,
				pagination:true,
				striped:true,
				nowrap:true,
				fitColumns: true,
				striped:true,
				pageSize: 25,
				pageList:[25,50],
				url:"./property/oper/actionRecordSearchLog.action",
				queryParams:getInputsAsOjbect(["cond.projectName","cond.searchName","cond.date1","cond.date2","cond.sort","cond.order","cond.logType"]),
				columns :[[
				{field:'userName',title:'账号',sortable:true,align:'center',width:$(this).width() * 0.2},
				{field:'realName',title:'姓名',sortable:true,align:'center',width:$(this).width() * 0.2},
				{field:'companyName',title:'公司',sortable:true,align:'center',width:$(this).width() * 0.2},
				{field:'descProjectId',title:'项目',sortable:true,align:'center',width:$(this).width() * 0.2},
				{field:'logTime',title:'点击时间',sortable:true,align:'center',width:$(this).width() * 0.2},
				{field:'logType',title:'点击功能',sortable:true,align:'center',width:$(this).width() * 0.2},
				{field:'logDesc',title:'备注',sortable:true,align:'center',width:$(this).width() * 0.2},
				]]
				});
			}
		function sortNUM(a,b){
			return parseInt(a)>parseInt(b)?1:-1;;
		}
		function sortGBK(a,b){
			return a.localeCompare(b);
		}
    </script>
</head>
<body>


<%--主体 --%>
<div class="ui_listview">
	<table id="dg"></table>
	<div id="toolbar" style="padding:5px;height:auto">
		&nbsp;项目<input type="text" maxlength="20" name="cond.projectName" id="projectName"/>
		&nbsp;姓名<input style="height: 20px" type="text" maxlength="20"  name="cond.searchName" />
		&nbsp;点击的功能<s:select list="recordAction" listKey="key" listValue="value" id="logType" name="cond.logType"></s:select>
		日期<input class="easyui-datebox" type="text" id="date1" name="cond.date1" style="width:90px" />
			-
		<input class="easyui-datebox" type="text" id="date2" name="cond.date2" style="width:90px" />
		&nbsp;<input type="button" onclick="queryForm();" value="查询">
			<input type="button" onclick="queryFormByWeek();" value=" 查询本周 "/>	
			<input type="button" onclick="queryFormByMonth();" value=" 查询本月 "/>	
	</div>
  
</div>


</body>
</html>




