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
	
	<title>easyui用户</title>
	
	<base href="<%=basePath%>" />		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	
	<script language="javascript" type="text/javascript" src="./js/project.list.utils.js"></script>
    
    <script type="text/javascript" language="javascript">			
		//新建用户账户
		function dialog_input_user(){		
			new MyAjaxIframeDialog({title:'新建用户账户', formId:'inputform',
				height:430,
				src:'./user/manager/inputUser.action',
				ids:['userName','userPwd','realName'],
				closeFn:ajaxSubmitSearch
			});		
		}
		
		//批量新建用户账户
		function batAddUsers(){		
			new MyAjaxIframeDialog({title:'批量新建用户账户', formId:'inputform',
				height:650,
				src:'./user/manager/batInputUser.action',
				ids:['hiddenId','selRoleId'],
				closeFn:ajaxSubmitSearch
			});			
		}

		//查看修改用户
		function dialog_update_user(user_id){
		
			new MyAjaxIframeDialog({title:'查看/修改用户',
				width:650,
				height:550,
				src:'./user/manager/updateUser.action?userId='+user_id,
				buttons:false,
				closeFn:ajaxSubmitSearch
			});					
		}
		
		//删除多个用户
		function delUsers() {			
		
			var selecteds = $("#userAccount_table").datagrid("getSelections");
			if(selecteds == null || selecteds.length <= 0){
				
				myAlert("请选择要删除的用户");
				return ;
			}
			
			//过滤掉已删除的,避免重复删除
			var ids = "";
			$(selecteds).each(function(index, element) {
				
				var isDeleted = element.isDeleted;
				if(isDeleted != 1){
					ids += element.id + "_";
				}
            });

			if (ids != "") {
				deletePojo('./user/manager/delUsers.action?ids='+ids, function(){ajaxSubmitSearch();}, '');

			} else {
				myAlert("请确定要删除的用户为正常状态");
				return false;
			}
		}			
		
	</script>

	<script type="text/javascript" language="javascript">
	
		$().ready(function() {
		
	        bindProjectDialogForRYSQ("projectName", "hiddenId"); //多个项目的选择			
		});
	
		$(function(){		
			
			$("#userAccount_table").datagrid({
				loadMsg:'加载中...',
				pagination:true, 
				rownumbers:false,
				singleSelect:false,
				striped:true,
				nowrap:true,
				fitColumns:true,
				fit:false,
				pageSize:20,
				width:$(document).width(),
				height:$(document).height(),
				toolbar:'#table_tb',
				url:'./user/manager/ajaxSearch.action',
				onDblClickRow:function(rowIndex, rowData){
					
					dialog_update_user(rowData.id);
				},
				onLoadSuccess:function(data){			
					
					//var rows = $($("#userAccount_table").datagrid("getPanel").find(".datagrid-body").last()).find("tr");
					/**
					var rows = $("#userAccount_table").datagrid("getRows");
					$(rows).each(function(){
						$(this).attr("title", "双击查看/修改客户");
					});
					*/
				}
				
			});
			
		});
		
		//用户角色列的格式化
		function roleFormat(val,row){
			
			var tmp = "";
			
			if(val.length < 10){
				tmp = "" + val + "";
			}else{
				tmp = val.substr(0, 7) + "...";
			}
			
			return "<span title='" + val + "'>" + tmp + "</span>";
		}
		
		function ajaxSubmitSearch(){
			
			var query = $("#searchFormId").serialize();
			
			$("#userAccount_table").datagrid({
				url:'./user/manager/ajaxSearch.action?' + query,
				onLoadError:function(){
					myAlert("请求异常,请刷新重试");
				}
			});
			
			return false;
		}

	</script>

	
  </head>
  
<body style="padding:0px;background:white;">
        
        <table id="userAccount_table">  
				
			<thead>
				<tr>
                    <!--
                    <th data-options="field:'id',checkbox:true"></th>
                   -->
                    <th field="id" checkbox="true" align="center"></th>
                    <th field="isDeleted" hidden="true"></th>
                    
	            	<th field="userNameClick" width="120px" align="center" sortable="true">账号</th> 
					<th field="realName" width="100px" align="center" sortable="true">姓名</th>
                    <th field="jobNumber" width="100px" align="center" sortable="true">工号</th>
                    
	                <th field="descCompanyId" width="100px" align="center">公司</th>				
	                <th field="descProjectId" width="140px" align="center" sortable="true">项目</th>
                    
                    <th field="userRole" width="150px" align="center" formatter=roleFormat>角色</th>
                    
                    <th field="descIsDeleted" width="80px" align="center">状态</th>
                    
					<th field="mobilePhone" width="120px" align="center">手机号</th>                    
                    <th field="remark" width="100px" align="center">部门</th>
                    
                    <th field="createdTimeStr" width="150px" align="center">创建时间</th>
                    <th field="modTimeStr" width="150px" align="center">修改时间</th>
					
                    <th field="changePwd" width="80px" align="center">已改密码</th>
					
				</tr>
										
			</thead>
		</table>	
       
        
		<div id="table_tb" style="height: auto;padding: 5px">   
        	
            <form class="registerform" id="searchFormId" method="post">
			
			    <label>&nbsp;<span>帐号</span> </label>		
				<input type="text" id="userName" name="searchCond.userName" style="width:110px"/>
                                
                <label>&nbsp;<span>姓名</span> </label>		
				<input type="text" id="realName" name="searchCond.realName" style="width:110px"/>
                
                <label>&nbsp;<span>项目</span> </label>		
                
                <!--
                <input type="text" id="projectName" name="projectName" size="40" value="${searchCond.strSearchCompanyProjectNames}"/>
				<input type="hidden" id="hiddenId" name="projectIds" value="${searchCond.strSearchCompanyProjectIds}"/>
                -->
                <input type="text" id="projectName" name="pn"/>
				<input type="hidden" id="hiddenId"/>
                
               	<label>&nbsp;<span>工号</span> </label>		
				<input type="text" id="jobNumber" name="searchCond.jobNumber" style="width:110px"/>
                
                <br/>
                
                 <label>&nbsp;<span>角色</span> </label>		
				<s:select list="roleList" listValue="roleName" listKey="id" name="searchCond.roleId" headerKey="" headerValue="全部"></s:select>
					
				<label>&nbsp;<span>创建日期</span> </label>
				<input name="searchCond.date1" class="easyui-datebox" style="width:90px"/>
                - 
				<input name="searchCond.date2" class="easyui-datebox" style="width:90px"/>
                
                <%if(SessionUser.getUserId() == ContUserId.ADMIN){%>
                    <s:checkbox label="是否包括恒大项目" name="cbxIncludeHD" theme="xhtml"></s:checkbox>
                <%} %>	
                
                <label>&nbsp;<span>状态</span> </label>		
                <select id="isDeleted" name="searchCond.isDeleted">
                	<option value="-1">全部</option>
                    <option value="1">已删除</option>
                    <option value="0">正常</option>
                </select>
                
                <input type="submit" onclick="return ajaxSubmitSearch();"  value="  查询  " align="left" />		
                
                <br/>
				
                 <%if(PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_CREATE, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN){%>
                <input type="button" onclick="dialog_input_user()"  value="  新建  " align="left" />
                <%} %>
                
                <%if(PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_DELETE, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN){%>
                <input  type="button" value="  删除  "  onclick="delUsers()"/>
                <%} %>
                
				<%if(SessionUser.getUserId() == ContUserId.ADMIN){%>                   
                    <input  type="button" value="  批量新建  "  onclick="batAddUsers()"/>
                <%} %>	
                
				<s:actionmessage cssStyle="color:red" />
                
            </form>
            
        </div> 		
	    
	</body>
</html>