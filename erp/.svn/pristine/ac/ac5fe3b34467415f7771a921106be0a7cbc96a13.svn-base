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
<title>成交数据交叉分析</title>
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
			
				var projectId = $("#hiddenId").val();
				
				if(projectId == "" || projectId == "0" || isNaN(projectId)){
					
					myAlert("请先选择项目");
					return false;
				}
				
				$("#thisForm").submit();			
			}
		</script>
			 
</head>

<body style="padding:0px;background:white;">


<div class="right99"></div>
				
  	
   <form class="registerform" id="thisForm"  method="post" action="./saleunit_new_report/report/guangzhou/cjsjjcReport.action">
	 <table width="100%" border="0" align="left" cellspacing="0">	  
		  
		  <!-- 搜索表单 top -->
       
		  <tr>
     	<td colspan="6">
		
     	<label>&nbsp;<span>公司项目</span></label>
		<input type="text" id="projectName" size="40" name="propertyUnitCond.strSearchProjectNames"/> 
		<input type="hidden" id="hiddenId" name="propertyUnitCond.companyProjectId" value="${propertyUnitCond.companyProjectId}" />						
		
		<label>&nbsp;<span>分析内容1</span></label><s:select list="listSelCategory1" name="selCategory1" value="%{selCategory1}" cssClass="easyui-combobox"/>
		<label>&nbsp;<span>分析内容2</span></label><s:select list="listSelCategory2" name="selCategory2" value="%{selCategory2}" cssClass="easyui-combobox"/>
		<label>&nbsp;<span>分析内容3</span></label><s:select list="listSelCategory3" name="selCategory3" value="%{selCategory3}" cssClass="easyui-combobox"/>
	
		</td>
	 </tr>		  
	 
	 <tr>
	 	
		<td colspan="6">
			
			<label>&nbsp;<span>成交日期</span></label>
			<input class="easyui-datebox" type="text" style="width:90px"
					name="propertyUnitCond.date1" value="${propertyUnitCond.date1}" /> - <input
					class="easyui-datebox" type="text" style="width:90px"
					name="propertyUnitCond.date2" value="${propertyUnitCond.date2}" /> 
		&nbsp;
		<s:checkboxlist name="selCountType"  list="listCountType" label=""></s:checkboxlist>
		&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>	
		
		<div class="right99"></div>
		<div class="blueline"></div>	 
		
		</td>
		
	 </tr>
	 
		<!-- 搜索表单 end -->		
		
 </table>
		</form>
   
</body>
</html>

