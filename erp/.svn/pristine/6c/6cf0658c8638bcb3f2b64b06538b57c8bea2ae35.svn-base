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
<title>客户分类明细表</title>

		<s:include value="header_report.jsp"></s:include>		
		
		<script type="text/javascript" src="<%=basePath%>js/parent_dialog_by_report.js"></script><!-- 分类分析需要的弹出框 -->
		
		<script type="text/javascript">
			
			$().ready(function(){				
				//projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				bindProjectDialogForSQKHOnly("projectName", "hiddenId"); //多个项目的选择
				
				/**先隐藏
				$("#selCategory").change(function(){
					getRangeFromProjectIdAndType("hiddenId", "selCategory", "PRICE_AMOUNT", "rangeId");
				});
				*/
				//function getRangeFromProjectIdAndType(projectId, typeId, typeValue, rangeId){
			});
				
				
			function submitSearch(){
				$("#thisForm").submit();		
			}
			
			function submitSearch_CategoryNum(){
				$(window.parent.document).find("#showTitle").text('单项环比走势图');	
				$("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/categoryNum.action").submit();				
			}
			
			function submitSearch_CustomerPie(){
				$(window.parent.document).find("#showTitle").text('单项比例分析图');	
				$("#thisForm").attr("action", "./saleunit_new_report/report/guangzhou/customerPie.action").submit();
			}
			
			function exportMessage(){
				$(function(){
					$('#exportFm').form({
						url:'./saleunit_new_report/report/guangzhou/customerExport.action'
					});
					$('#exportFm').submit();  
				});
			}
		</script>
</head>
<body style="padding:0px;background:white;">

<div class="right99"></div>				
  	
	
    <form class="registerform" id="thisForm" method="post" style="margin:0px;display: inline" action="./saleunit_new_report/report/guangzhou/customerTable.action">	
		
		&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
		<input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>
		
		<label>&nbsp;<span>分析类型</span></label><s:select list="listSelCategory" name="selCategory"></s:select>
		<!--
		<label>&nbsp;<span>区间范围</span></label><select id="rangeId" name="rangeId"><option value="">请选择</option></select>
		-->
		日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}"/>
		-
		<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}"/>		
		
		&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
		<a style="color:#1199FF;" href="javascript:submitSearch_CategoryNum();">环比走势</a>&nbsp;
		<a style="color:#1199FF;" href="javascript:submitSearch_CustomerPie();">比例分析</a>&nbsp;
		
		 <table id="toolbar" style="width:auto;height:612px;"  
            toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
            rownumbers="true" fitColumns="true" singleSelect="true">	 
       	<thead>
		  	<tr>
     			<th field="id" hidden="true"></th>
	 		</tr>
	 	</thead>
	  </table>
	  
	  <div id="toolbar" style="padding:5px;height:auto">
		
		
		
     	
		<!-- 
		<a style="color:#1199FF;" href="./customer_guangzhou/chart/downLoad.action">下载</a>&nbsp;
		 -->
		</form>
		<form id="exportFm" method="post" style="margin:0px;display: inline">	
			<input type="button" onclick="return exportMessage()" value="导出" />
		</form>
		
		  
		<!-- 搜索表单 end -->





   
		
</body>
</html>

