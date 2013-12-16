<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>新建认购</title>
	
	<base href="<%=basePath%>">		
	
	<style type="text/css">
		*{margin:0;padding:0;}		
		
		.tb1 td{padding-left: 5px;width:75px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#EEAD0E}

	</style>

	
  </head>
  
 <body>
 
<table style="width: 100%;" align="left" border="0" cellspacing="0">		  
		 
			 <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
				  <div>			  
				  
				  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
					  <tr class="gboxbg">
							
						 <td height="20" colspan="6">
							&nbsp;&nbsp;<b>楼盘项目:</b>${build.descPropertyId},<b>楼盘分区:</b>${build.areaName},<b>楼盘楼栋:</b>${build.buildName}
						</td>					
						  
				  </tr>
				 </table>
				 </div>
				 </td>
				 </tr>
				 
				 
				 <tr>
				<td colspan="6">
				
						<div style="float: left;width: auto;height: 300px;border: 1px solid #A9D9FF">
							
							<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto">
								
								 <s:iterator value="#request.trList" id="c">  
								 	${c}
								 </s:iterator>
							 
							 	
							</table>
								
										

						</div>
				
				</td>
			</tr>
			
			<tr>
				<td colspan="6">
				
						<div style="width: 100%;height: auto;"> 
							<table>
								<tr>
									<td title="销控" width="40px" ><div class="sale_state_1"></div> <div style="float: left">销控</div>  </td>
									<td title="待售" width="40px" ><div class="sale_state_2"></div> <div style="float: left">待售</div>  </td>
									<td title="预约" width="40px" ><div class="sale_state_3"></div> <div style="float: left">预约</div>  </td>
									<td title="预留" width="40px" ><div class="sale_state_4"></div> <div style="float: left">预留</div>  </td>
									<td title="小订" width="40px" ><div class="sale_state_5"></div> <div style="float: left">小订</div>  </td>
									<td title="认购" width="40px" ><div class="sale_state_6"></div> <div style="float: left">认购</div>  </td>
									<td title="签约" width="40px" ><div class="sale_state_7"></div> <div style="float: left">签约</div>  </td>
									<td title="非售" width="40px" ><div class="sale_state_8"></div> <div style="float: left">非售</div>  </td>
									<td title="交楼" width="40px" ><div class="sale_state_9"></div> <div style="float: left">交楼</div>  </td>
									<td title="出证" width="40px" ><div class="sale_state_10"></div> <div style="float: left">出证</div>  </td>
								</tr>
							 </table>
						</div>
				
				</td>
			</tr>			
           
 </table>
   
</body>
</html>

