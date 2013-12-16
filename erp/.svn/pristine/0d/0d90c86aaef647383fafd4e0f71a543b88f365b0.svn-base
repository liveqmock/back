<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
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
    <title>客户交易明细(项目)</title>
    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
    <script type="text/javascript">
		$().ready(function() {
	        bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
			baseProjectListForHiddenId("createdUserName", "createdUserId", "./customer_guangzhou/search/sales.action", "");//销售人员的下拉选择
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
				height:$(document).height(),
				toolbar:'#toolbar',
				pageSize:20,
				onDblClickRow:function(rowIndex, rowData){					
					
				},
				onLoadSuccess:function(data){			

				}
				
			});
			
			 $("#save").click(function(){					
					var query = $("#thisForm").serialize();					
					window.location.href = "./saleunit_new/contract/customer/projectDownload.action?" + query;
					
				});
		});
		
		//DEMO 点击按钮
		function ajaxSubmitSearch(){		
			var query = $("#thisForm").serialize();
			var projectId = $("#hiddenId").val();
			
			$("#khcj_table").datagrid({
				url:'./customer/report_json/khcjReportAjax.action?' + query + "&contractCustomerCond.searchProjectIdStr=" + projectId
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
	            	<th field="projectName" width="80px" align="center">项目</th>
					<th field="confirmType" width="80px" align="center">客户类型</th> 
					<th field="area" width="80px" align="center">分区</th>
	            	<th field="buildName" width="140px" align="center">楼栋</th> 
					<th field="floor" width="80px" align="center">楼层</th>
	                <th field="unitNo" width="140px" align="center">房号</th> 					
	                <th field="buildArea" width="140px" align="center">建筑面积</th>
					<th field="insideArea" width="140px" align="center">套内面积</th>
					<th field="agreeNo" width="140px" align="center">成交/合同编号</th>
					<th field="payType" width="140px" align="center">付款方式</th> 	
					<th field="workDate" width="140px" align="center">成交/合同日期</th> 	
	                <th field="sumMoney" width="140px" align="center">成交总价</th> 
					
					<th field="customerName" width="140px" align="center">客户姓名</th>
					<th field="phone" width="140px" align="center">电话号码</th>
					<th field="homePhone" width="140px" align="center">固定电话</th>
					<th field="idcardType" width="140px" align="center">证件类型</th>
	                <th field="idcardNo" width="190px" align="center">证件号码</th>
	                <th field="gender" width="50px" align="center">性别</th> 
					<th field="address" width="240px" align="center">通信地址</th>
					<th field="household" width="140px" align="center">户籍</th>
					<th field="home" width="140px" align="center">居住区域</th>
				
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
					
				<label>&nbsp;<span>成交/合同日期</span> </label>
				<input class="easyui-datebox" type="text" style="width:90px"
				name="contractCustomerCond.date1" value="${contractCustomerCond.date1}" /> - 
				<input class="easyui-datebox" type="text" style="width:90px"
				name="contractCustomerCond.date2" value="${contractCustomerCond.date2}" /> 
				
				<s:radio list="selConfirmType" name="contractCustomerCond.confirmType"/>
			&nbsp;操作人员
                    <input type="text" id="createdUserName" title="按空格键可以查找前十条数据"/>
                    <input type="hidden" id="createdUserId" name="contractCustomerCond.createdUserId" />  
				
				&nbsp;
				<a href="javascript:void(0)" onclick="return ajaxSubmitSearch()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
                <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_DOWNLOAD, EnumDevFlag.GUANGZHOU) ){%>
				<a href="javascript:void(0)" id="save" class="easyui-linkbutton" iconCls="icon-save">导出</a>
                <%} %>
			</div> 
	
		</form>
	    
	</body>
</html>