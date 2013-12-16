<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>售后问卷分析</title>
		<s:include value="header_report.jsp"></s:include>
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>	
	
		<script type="text/javascript">
						
			$().ready(function(){				
				$("#saleMonitorCond_companyId").change(function(){
					companyToProject(this.value, "saleMonitorCond_projectId");
				});				
			
				bindProjectDialogForXKZXOnly("projectName", "hiddenId"); //多个项目的选择
			});
				
				
			function submitSearch(){
	           $("#thisForm").submit();
			}
			
			function submitExport(){
				$(function(){
					$('#exportForm').form({
						url:'./saleunit_new_report/report/guangzhou/shwjReportDownload.action'  
					});
					$('#exportForm').submit();  
				});
			}
		</script>
			 
</head>

<body style="padding:0px;background:white;">


<div class="right99"></div>
				
  	
	 <table width="100%" border="0" align="left" cellspacing="0">	  
		  
		  <!-- 搜索表单 top -->
       
		  <tr>
     	<td colspan="6">
     	<form class="registerform" id="thisForm"  method="post" style="margin:0px;display: inline">	
     	<label>&nbsp;<span>项目</span></label>
		     	<input type="text" id="projectName" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}"/>
		     	<input type="hidden" id="hiddenId" name="propertyUnitCond.projectId" value="${propertyUnitCond.projectId}" />
				&nbsp;			
				日期<input class="easyui-datebox" type="text" style="width:90px"
					name="questionCond.date1" value="${questionCond.date1}" /> - <input
					class="easyui-datebox" type="text" style="width:90px"
					name="questionCond.date2" value="${questionCond.date2}" /> &nbsp;<input
					type="button" onclick="return submitSearch()" value=" 查询  " />
		</form>
		<form id="exportForm" method="post" style="margin:0px;display: inline">			
					<input type="button" onclick="return submitExport()" value="导出" />
		</form>
		
<div class="right99"></div>
	<div class="blueline"></div>	 
		</td>
	 </tr>		  
		<!-- 搜索表单 end -->		
            <tr>
              <td colspan="6">
			  
				  <div class="gbox1">	
								
						<table style="width:95%; text-align:center">
							<tr>
								<td width="95%">
				
								<div class="gbox1">	
								
								<s:property value="showTables" escape="false"/>
								
								</div>
							</td>
							
							
						</tr>		
						</table>	  		
					</div>
					

                          
			</td>
            </tr>
 </table>
   
</body>
</html>

