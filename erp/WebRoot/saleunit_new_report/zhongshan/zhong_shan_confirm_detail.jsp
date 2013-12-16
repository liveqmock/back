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
    
    <title>来访来电成交简况(项目)</title>
    <s:include value="../../customer/guangzhou/header.jsp"></s:include>

    <link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui-lang-zh_CN.js"></script>	
	
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	
	<script language="javascript" type="text/javascript" src="./js/project.list.utils.js"></script>
	<script language="javascript" type="text/javascript" src="./js/datetime.utils.js"></script>

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
					
					window.location.href = "./customer/report_json/zhongshanConfirmDetailDownload.action?" + query;
					
				});

		});
		
		//查询本周
		function queryFormByWeek(){
			setTwoDatebox("thisweek",$("#date1"),$("#date2"));
			ajaxSubmitSearch();
		}		
		
		//查询本月
		function queryFormByMonth(){
			setTwoDatebox("thismonth",$("#date1"),$("#date2"));
			ajaxSubmitSearch();
		}
		
		//DEMO 点击按钮
		function ajaxSubmitSearch(){
			
			var query = $("#thisForm").serialize();
			var projectId = $("#hiddenId").val();
			
			$("#khcj_table").datagrid({
				url:'./customer/report_json/zhongshanConfirmDetailAjax.action?' + query + "&customerCond.strSearchCompanyProjectIds=" + projectId
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
	            	<th field="visit_date" width="80px" align="center">日期</th>
					<th field="coming_customer" width="80px" align="center">总来访</th> 
					<th field="new_customer" width="80px" align="center">新客</th>
	            	<th field="old_customer" width="140px" align="center">旧客</th> 
					<th field="phone_customer" width="80px" align="center">总来电</th>
	                <th field="confirm_amount" width="140px" align="center">成交套数</th> 					
	                <th field="sum_money" width="140px" align="center">成交金额</th>
					<th field="confirm_area" width="140px" align="center">成交面积</th>
					<th field="average_price" width="140px" align="center">均价</th>
					<th field="remark" width="140px" align="center">备注</th> 	
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
				name="customerCond.date1" id="date1" value="${customerCond.date1}" /> - 
				<input class="easyui-datebox" type="text" style="width:90px"
				name="customerCond.date2" id="date2" value="${customerCond.date2}" /> 
				
				&nbsp;
				<a href="javascript:void(0)" onclick="return ajaxSubmitSearch()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
				<a href="javascript:void(0)" onclick="return queryFormByWeek()" class="easyui-linkbutton" iconCls="icon-search">查询本周</a>
				<a href="javascript:void(0)" id="save" class="easyui-linkbutton" iconCls="icon-save">导出</a> 		
			</div> 
	
		</form>
	    
	</body>
</html>