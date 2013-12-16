<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
         isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>客户转化率分析报表</title>
    <s:include value="header_report.jsp"></s:include>
	<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/parent_dialog_by_report.js"></script><!-- 分类分析需要的弹出框 -->
    <script type="text/javascript">
    $().ready(function() {
    	bindProjectDialogForSQKHOnly("projectName", "hiddenId"); //单个项目的选择
	});
		
	$(function(){	
		
		$("#dg").datagrid({
			loadMsg:'加载中...',
			rownumbers:true,
			singleSelect:true,
			striped:true,
			nowrap:true,
			fitColumns:true,
			toolbar:'#toolbar',
			onDblClickRow:function(rowIndex, rowData){					
				
			},
			onLoadSuccess:function(data){			

			}
			
		});
		
		

	});
   
  	//点击按钮
	function ajaxSubmitSearch(){
		var projectId = $("#hiddenId").val();
		var countType = $("#countType").val();
		$("#dg").datagrid({
			url:"./saleunit_new_report/report/guangzhou/customerChangeReportAjax.action?projectId="+projectId,
			queryParams:getInputsAsOjbect(["countType","contractCustomerCond.date1","contractCustomerCond.date2"])
		});
		
	}
    </script>
  </head>
  
  <body style="padding:0px;background:white;">
  
  	
  		<table 
		 	id="dg" 
		 	style="width:auto;height:auto;"  
            toolbar="#toolbar" 
            pagination="false"  
            rownumbers="true" fitColumns="true"
            singleSelect="true"
            showFooter='true'
            striped='true'
            >  
	        <thead>  
	            <tr>  
	                <th field="fixList" width="100px">${countType}</th> 
	                <th field="changed" width="100px">已转</th> 
	            	<th field="notChanged" width="100px">未转</th>
	            	
	            </tr>  
	        </thead>  
	    </table>
  	
  	
  		<div id="toolbar" style="height: auto;padding: 5px">   
			   <label>&nbsp;<span>项目</span> </label>
			   <!--
				<input type="text" id="projectName" size="40" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
				<input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
				-->

				<input type="text" id="projectName" size="40"/>
				<input type="hidden" id="hiddenId" />
				
				&nbsp;
				统计类型 <s:select list="countTypeList" name="countType" id="countType"></s:select>
				&nbsp;
				筛选日期	
				<input class="easyui-datebox" type="text" style="width:90px"
				name="contractCustomerCond.date1" value="${contractCustomerCond.date1}" /> - 
				<input class="easyui-datebox" type="text" style="width:90px"
				name="contractCustomerCond.date2" value="${contractCustomerCond.date2}" /> 
				
				&nbsp;
				<a href="javascript:void(0)" onclick="return ajaxSubmitSearch()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
						
		</div> 	  
			  
  </body>
</html>
