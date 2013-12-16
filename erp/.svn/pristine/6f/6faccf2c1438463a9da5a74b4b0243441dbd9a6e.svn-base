<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>售前客户分类统计 </title>
		<s:include value="header_report.jsp"></s:include>
		
		<script type="text/javascript">
						
			$().ready(function(){				
				//页面加载时执行
				//projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				bindProjectDialogForSQKHOnly("projectName", "hiddenId"); //多个项目的选择
			});
				
				
			function submitSearch(dir){
				$("#thisForm").submit();	
			}
			
		</script>	
</head>
<body style="padding:0px;background:white;">

<div class="right99"></div>				
  	<form class="registerform" id="thisForm"  method="post">
	 <table width="100%" border="0" align="left" cellspacing="0">	 
       
		<tr>
     	<td colspan="6">	
     	&nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${customerCond.strSearchProjectNames}"/>
		<input type="hidden" id="hiddenId" name="customerCond.strSearchProjectIds" value="${customerCond.strSearchProjectIds}"/>
     	
		<label>&nbsp;<span>分类</span></label><s:select list="listSelCategory1" name="selCategory1" value="%{selCategory1}" />
		录入日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}"/>
		-
		<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}"/>		
		
		&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
        <div class="right99"></div>	
	     <div class="blueline"></div>	 
		</td>
	   </tr>  
		  
		<!-- 搜索表单 end -->
					
			<!-- 说明：左侧纵向数据来源于调查表内容，调查表各个项目的都不一样，是变量，横向为定量 -->
            <tr>
              <td colspan="6">			  
			  
			  	<div class="gbox1">	
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">   
	 					<s:property value="showTrs"  escape="false"/> 
				</table>
				</div>


			</td>
           </tr>
			
 </table>

</form>


   

</body>
</html>