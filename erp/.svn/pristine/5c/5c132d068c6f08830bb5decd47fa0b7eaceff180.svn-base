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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <title>项目推货情况</title>
    <s:include value="../../customer/guangzhou/header.jsp"></s:include>

    <link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	
	<script language="javascript" type="text/javascript" src="./js/project.list.utils.js"></script>

	<script type="text/javascript" language="javascript">

		$().ready(function() {
	        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
	       // parent.hideLoading("客户交易明细(项目)");
		});
			
		$(function(){		
			//DEMO easyui的声明,按easyui的要求
			$("#khcj_table").datagrid({
				loadMsg:'加载中...',
				pagination:true, 
				rownumbers:true,
				singleSelect:true,
				striped:true,
				nowrap:true,
				fitColumns:false,
				toolbar:'#toolbar',
				pageSize:20,
				width:'auto',
				height:$(this).height(),
				onDblClickRow:function(rowIndex, rowData){					
					
				},
				onLoadSuccess:function(data){			

				}
				
			});
			
			 $("#save").click(function(){
					
					var query = $("#thisForm").serialize();
					
					window.location.href = "./customer/report_json/projectPushDetailDownload.action?" + query;
					
				});

		});
		
		//DEMO 点击按钮
		function ajaxSubmitSearch(){
		
			var query = $("#thisForm").serialize();
			var projectId = $("#hiddenId").val();
			
			$("#khcj_table").datagrid({
				url:'./customer/report_json/projectPushDetailAjax.action?' + query + "&customerCond.strSearchCompanyProjectIds=" + projectId
			});
			
		}

		//可以删除，废弃过时
        function submitSearch(dir){
            
            parent.showLoading();
            $("#thisForm").submit();           
        }
		
       
		
    </script>
</head>

	<body style="padding:0px;background:white;">
			
		<!--
		 <table id="khcj_table" class="easyui-datagrid" style="width:auto;height:612px;"  
            url="./customer/report_json/khcjReportAjax.action"  
            toolbar="#toolbar" pagination="true"  
            rownumbers="true" singleSelect="true"
            showFooter='true' fitColumns='false'
            striped='true' nowrap='true' loadMsg='数据加载中...' khcjTable
            >  
		-->
		
		<form class="registerform" id="thisForm" method="post">
		
		<!-- DEMO 结果的表头  --> 
		<table id="khcj_table" style="width:auto;height:612px;">
	        <thead>  
	            <tr>  
	            	<th field="product" width="80px" align="center">产品</th>
					<th field="havePush" width="80px" align="center">已推出</th> 
					<th field="haveNotPush" width="80px" align="center">未推出</th>
	            	<th field="weekConfirm" width="140px" align="center">本周成交</th> 
					<th field="monthConfirm" width="80px" align="center">本月成交</th>
	                <th field="allConfirm" width="140px" align="center">入场总成交</th> 					
	                <th field="confirmPercent" width="140px" align="center">成交比例</th>
					<th field="confirmArea" width="140px" align="center">总成交面积</th>
					<th field="confirmMoney" width="140px" align="center">总成交金额</th>
					<th field="confirmPrice" width="140px" align="center">成交单价</th>
					<th field="havePushLeave" width="140px" align="center">已推剩余</th> 	
					<th field="havePushLeavePercent" width="140px" align="center">已推剩余比例</th>
					<th field="allLeave" width="140px" align="center">总剩余（含未推）</th>
					<th field="leaveArea" width="140px" align="center">剩余总面积（已推）</th>
					<th field="leaveMoney" width="140px" align="center">剩余总金额（已推）</th>
	            </tr>  
	        </thead>  
	    </table>  
		
		
		<!-- DEMO 查询的条件栏  --> 
			<div id="toolbar" style="height: auto;padding: 5px">   
			
			   <label>&nbsp;<span>项目</span> </label>
			   <!--
				<input type="text" id="projectName" size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
				<input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
				-->

				<input type="text" id="projectName" size="40"/>
				<input type="hidden" id="hiddenId" value="${propertyUnitCond.strSearchProjectIds}" />
				  	
				<label>&nbsp;<span>日期</span> </label>
				<input class="easyui-datebox" type="text" style="width:90px"
				name="customerCond.date1" value="${customerCond.date1}" />  
				
				
				&nbsp;
				<a href="javascript:void(0)" onclick="return ajaxSubmitSearch()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
				<a href="javascript:void(0)" id="save" class="easyui-linkbutton" iconCls="icon-save">导出</a> 		
			</div> 
	
		</form>
	    
	</body>
</html>