<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page import="com.ihk.constanttype.ContUserId" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	<title>查看角色</title>
	<base href="<%=basePath%>" />		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script language="javascript" type="text/javascript" src="./js/project.list.utils.js"></script>
	<script type="text/javascript" language="javascript">
	
		$().ready(function() {
	        bindProjectDialogForRYSQ("projectName", "hiddenId"); //多个项目的选择			
		});
	
		$(function(){		
			$("#userAccount_table").datagrid({
				loadMsg:'加载中...',
				singleSelect:false,
				rownumbers:false,
				striped:true,
				nowrap:true,
				fitColumns:true,
				fit:false,
				width:$(document).width(),
				height:$(document).height(),
				toolbar:'#table_tb',
				url:'./user/manager/ajaxSearchRole.action',
				onLoadSuccess:function(data){			
					var rows = $($("#userAccount_table").datagrid("getPanel").find(".datagrid-body").last()).find("tr");
					$(rows).each(function(){
						$(this).attr("title", "双击查看/修改客户");
					});
				}
			});
		});
		
		function ajaxSubmitSearch(){
		if(!check())
			return false;
		var query = $("#searchFormId").serialize();
			$("#userAccount_table").datagrid(
					{
						url : './user/manager/ajaxSearchRole.action?' + query,
						onLoadError : function() {
							myAlert("请求异常,请刷新重试");
						},
						onLoadSuccess : function() {
							var checkedsArray = new Array();
							$("#replaceRoleButton").attr("disabled",
							"disabled");
							var checkeds = $("#projectName").combotree("tree")
									.tree('getChecked');
							if (checkeds.length == 0)
								return;
							for ( var s in checkeds) {
								if (isNaN(checkeds[s].id)|| checkeds[s].id.length==0) {
									checkeds.splice(s, s+1);
								}
							}
							var temp = checkeds[0].attributes.companyId;
							for ( var s in checkeds) {
								if (temp != checkeds[s].attributes.companyId) {
									$("#replaceRoleButton").attr("disabled",
											"disabled");
									return;
								}
							}
							$("#replaceRoleButton").removeAttr("disabled");
						}
					});
			return false;
		}

		function replaceRole() {

			var query = $("#searchFormId").serialize();
			new MyAjaxIframeDialogX2({
				title : '替换角色',
				width : 700,
				height : 150,
				src : "./user/manager/replaceRoleFrist.action?" + query,
				formId : "roleFormId",
				closeFn : function(){ajaxSubmitSearch();}
			});
		}
		function check(){
			var checkValue=$("#roleList").val();
			if(checkValue.length==0){
				myAlert("请选择一个角色");
				return false;
			}
			var checkeds = $("#projectName").combotree("tree").tree('getChecked');
			if (checkeds.length == 0) {
				myAlert("最少要选择一个项目");
				return false;
			}
			return true;
		}
	</script>

	
  </head>
  
<body style="padding:0px;background:white;">
        <table id="userAccount_table">  
			<thead>
				<tr>
                    <th field="id" checkbox="true" align="center"></th>
                    <th field="isDeleted" hidden="true"></th>
	            	<th field="userNameClick" width="100px" align="center">账号</th> 
					<th field="realName" width="100px" align="center">姓名</th>
	                <th field="descCompanyId" width="100px" align="center">公司</th>				
	                <th field="descProjectId" width="100px" align="center">项目</th>
					<th field="mobilePhone" width="120px" align="center">手机号</th>                    
                    <th field="remark" width="100px" align="center">部门</th>
                    <th field="jobNumber" width="100px" align="center">工号</th>
                    <th field="createdTimeStr" width="120px" align="center">创建时间</th>
                    <th field="modTimeStr" width="120px" align="center">修改时间</th>
                    <th field="descIsDeleted" width="80px" align="center">状态</th>
                    <th field="changePwd" width="80px" align="center">已改密码</th>
				</tr>
			</thead>
		</table>	
		<div id="table_tb" style="height: auto;padding: 5px">   
            <form class="registerform" id="searchFormId" method="post">
                <label>&nbsp;<span>项目</span> </label>		
                <input type="text" id="projectName" name="pn"/>
				<input type="hidden" id="hiddenId"/>
                <label>&nbsp;<span>角色</span> </label>		
				<s:select list="roleList" listValue="roleName" listKey="id" name="roleId" headerKey="" headerValue="全部" id="roleList"></s:select>
				<label>&nbsp;<span>创建日期</span> </label>
				<input name="date1" class="easyui-datebox" style="width:90px"/>
                - 
				<input name="date2" class="easyui-datebox" style="width:90px"/>
                <input type="submit" onclick="return ajaxSubmitSearch();" value="  查询  " align="left" />
                <%if(SessionUser.getUserId() == ContUserId.ADMIN){%>                   
                    <input  type="button" value="  替换角色 "  onclick="replaceRole()" id="replaceRoleButton"  disabled="disabled"/>
                <%} %>
				<s:actionmessage cssStyle="color:red" />
                <br/>
            </form>
        </div> 		
	</body>
</html>