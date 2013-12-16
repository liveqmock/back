<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>客户数量环比图(已经废弃20130813)</title>		
		<s:include value="header_report.jsp"></s:include>	
		
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		
		<script type="text/javascript">	
			$().ready(function(){				
				$("#saleMonitorCond_companyId").change(function(){
					companyToProject(this.value, "saleMonitorCond_projectId");
				});				
				
				//projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				bindProjectDialogForSQKH("projectName", "hiddenId"); //多个项目的选择
			});
			
			function submitSearch(){
				$("#thisForm").submit();			
			}
				
		</script>
		 

	</head>
	
	<body style="padding:0px;background:white;">
<div class="right99"></div><!-- 小空行 -->
		         
   <form class="registerform" id="thisForm" method="post" action="./saleunit_new_report/report/guangzhou/customerNum.action">
	<table width="100%" border="0" align="left" cellspacing="0">	
	  <tr>
	 
     	<td >	
     	&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
		<input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>
		&nbsp;日期
		<input id="date1" type="text" class="easyui-datebox" required="required" name="customerCond.date1" value="${customerCond.date1}" style="width:90px" >
				-
		<input id="date2" type="text" class="easyui-datebox" required="required" name="customerCond.date2" value="${customerCond.date2}" style="width:90px" >
		<label> &nbsp;<span>周期</span></label><s:select list="listSelCycel" name="selCycel" value="%{selCycel}" />
		&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
		</td>
	 </tr>   
	 <tr><td>
	 
	 
<div class="right99"></div>
<div class="blueline"></div>
 
		<div class="gbox1">	
		<div id="container" style="width: 100%; height:600px; margin: 0 auto"></div>
		  		
		</div>
	 </td></tr>       
 </table>
 
		</form>
    <!--<form id="dnform" action="./saleunit_new_report/report/guangzhou/NumExport.action" enctype="multipart/form-data" method="post">
			    <input type="submit" value="导出" ></input>
	</form>
--></body>
</html>

