<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	
	<title>成交客户</title>
	
	<base href="<%=basePath%>" />		
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	
	<script language="javascript" type="text/javascript" src="./js/project.list.utils.js"></script>

	<script type="text/javascript" language="javascript">
	
		$().ready(function() {
		
	        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择	       
			
			$("#save").click(function(){
				
				var query = $("#thisForm").serialize();
				
				window.location.href = "./saleunit_new/contract/customer/download.action?" + query;
				
			});
			
		});
	
		$(function(){		
			
			$("#contract_customer_table").datagrid({
				loadMsg:'加载中...',
				pagination:false, 
				rownumbers:true,
				singleSelect:true,
				striped:true,
				nowrap:true,
				fitColumns:false,
				pageSize:20,
				width:$(document).width(),
				height:$(document).height(),
				toolbar:'#customer_tb',
				onDblClickRow:function(rowIndex, rowData){
					
				},
				onLoadSuccess:function(data){			
					<%/** 
					var rows = $($("#contract_customer_table").datagrid("getPanel").find(".datagrid-body").last()).find("tr");
					$(rows).each(function(){
						$(this).attr("title", "双击查看详情");
					});
					*/%>
				}
				
			});
			
		});
		
		function ajaxSubmitSearch(){
		
			var query = $("#thisForm").serialize();
			
			$("#contract_customer_table").datagrid({
				url:'./saleunit_new_report/report/zhongshan/customerAjax.action?' + query
			});
		}

	</script>

	
  </head>
  
<body style="padding:0px;background:white;">
		
	<form class="registerform" id="thisForm" method="post">
        
        <table id="contract_customer_table">  
				
			<thead>
				<tr>
					
					<th field="id" hidden="true"></th>
					
	            	<th field="questionName" width="140px" align="center">分析项(问题)</th> 
					<th field="countPerson" width="80px" align="center">总人数</th>
	                <th field="answer" width="140px" align="center">选择项(答案)</th> 					
	                <th field="answerPerson" width="140px" align="center">所占人数</th>
					<th field="answerProportion" width="140px" align="center">所占比例(%)</th>
					
				</tr>
										
			</thead>
		</table>	
		
			<div id="customer_tb" style="height: auto;padding: 5px">   
			
			    <label>&nbsp;<span>项目</span> </label>		
				<input type="text" id="projectName" size="40" style="width:200px"/>
				<input type="hidden" id="hiddenId" name="cond.projectId"/>
					
				<label>&nbsp;<span>来访日期</span> </label>
				<input class="easyui-datebox" type="text" style="width:90px" id="date1"
                name="cond.date1" value="${cond.date1}" /> - 
				<input class="easyui-datebox" type="text" style="width:90px" id="date2"
				name="cond.date2" value="${cond.date2}" /> 
                
                <input type="radio" id="laidian" value="1" name="cond.type" />
                <label for="laidian">来电</label>
                <input type="radio" id="laifan" value="2" name="cond.type" />
                <label for="laifan">来访</label>                          
							
				&nbsp;
				<a href="javascript:void(0)" onclick="return ajaxSubmitSearch()" class="easyui-linkbutton" iconCls="icon-search">查询</a>

                <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
				<a href="javascript:void(0)" id="save" class="easyui-linkbutton" iconCls="icon-save">导出</a> 
                <%} %>
			</div> 			
	
		</form>
	    
	</body>
</html>