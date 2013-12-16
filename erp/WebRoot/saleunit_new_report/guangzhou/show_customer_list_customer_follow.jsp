<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<s:include value="../../header/header_easyui.jsp"></s:include>
<title>客户分列表</title>
<script type="text/javascript">
		function getDownload(){
			//预设好拿那个session里面的cond
			var sessionKey = 'customerCond';
	        window.location.href = "./saleunit_new_report/report/guangzhou/customerListByFollowDownload.action?sessionKey="+sessionKey;
		}
		$().ready(function(){
			$("#dg").datagrid({
				height:$(this).height(),
				width:'auto',
				rownumbers:true,
				singleSelect:true,
				pagination:false,
				striped:true,
				nowrap:true,
				toolbar:'#toolbar',
				pagination:true,
				url:"./saleunit_new_report/report/guangzhou/customerListByFollowAjaxResult.action?cond.followType=${cond.followType}&cond.followUserId=${cond.followUserId}&cond.date1=${cond.date1}&cond.date2=${cond.date2}&value=${value}&cond.projectId=${cond.projectId}&cond.companyId=${cond.companyId}",
				columns :[[
					{field:'name',title:'客户名称',sortable:true,align:'center',width:'100'},
					{field:'phone1',title:'固定电话',sortable:true,align:'center',width:'100'},
					{field:'phone2',title:'移动电话',sortable:true,align:'center',width:'100'},
					{field:'area',title:'意向面积',sortable:true,align:'center',width:'100'},
					{field:'price',title:'意向总价',sortable:true,align:'center',width:'100'},
					{field:'pro',title:'项目',sortable:true,align:'center',width:'100'},
					{field:'createdTime',title:'录入时间',sortable:true,align:'center',width:'100'},
				]]
			});
		});
</script>
</head>
<body style="padding:0px;background:white;">
 	<table id="dg">  
	</table>  
    <div id="toolbar">  
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="getDownload();">导出</a>  
    </div> 
</body>
</html>

