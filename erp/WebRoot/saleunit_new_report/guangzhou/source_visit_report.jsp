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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>售前客户来源统计</title>
    <s:include value="header_report.jsp"></s:include>

    <script type="text/javascript">
		$().ready(function() {
		
	        bindProjectDialogForXKZXOnly("projectName", "hiddenId"); 
			
			$("#customerSource").combobox({
				editable:false,
				width:100
			});
			
			
		});
			
		$(function(){		
			
			$("#source_visit_table").datagrid({
				loadMsg:'加载中...',
				pagination:false, 
				rownumbers:true,
				singleSelect:true,
				striped:true,
				nowrap:true,
				fitColumns:false,
				toolbar:'#toolbar',
				onDblClickRow:function(rowIndex, rowData){					
					
				},
				onLoadSuccess:function(data){			

				}
				
			});

		});
		
		function ajaxSubmitSearch(){
		
			var query = $("#thisForm").serialize();
			//var projectId = $("#hiddenId").val();
			
			$("#source_visit_table").datagrid({
				url:'./customer/report_json/sourceAndVisitAjax.action?' + query
			});
			
		}

    </script>
</head>

	<body style="padding:0px;background:white;">
	
		<form class="registerform" id="thisForm" method="post">
		<table id="source_visit_table" style="width:auto;height:auto;">
	        <thead>  
	            <tr>  
	            	<th field="projectName" width="140px" align="center">项目名称</th>
					
	            	<th field="customerCount" width="140px" align="center">客户量</th> 
					
	                <th field="customerSearch" width="140px" align="center">客户明细</th> 						               
				
	            </tr>  
	        </thead>  
	    </table>  
		
		
			<div id="toolbar" style="height: auto;padding: 5px">   
			
			   <label>&nbsp;<span>项目</span> </label>			   

				<input type="text" id="projectName" size="40"/>
				<input type="hidden" id="hiddenId" name="cond.projectId"/>
				
				<label>&nbsp;<span>客户来源</span></label>		
				<s:select list="selCustomerSource" name="cond.customerSource" id="customerSource"/>	
					
				<label>&nbsp;<span>来访日期</span> </label>
				<input class="easyui-datebox" type="text" style="width:90px" name="cond.visitDate1"/> - 
				<input class="easyui-datebox" type="text" style="width:90px" name="cond.visitDate2" /> 
				&nbsp;
				<a href="javascript:void(0)" onclick="return ajaxSubmitSearch()" class="easyui-linkbutton" iconCls="icon-search">查询</a>
						
			</div> 
	
		</form>
	    
	</body>
</html>