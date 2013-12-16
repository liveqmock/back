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
<title>交叉分析组合图</title>
		<s:include value="header.jsp"></s:include>	
		<s:include value="header_left_js.jsp"></s:include>	
		<style>
		* {margin:0;padding:0;}
		</style>
	
		<script type="text/javascript">
						
			$().ready(function(){				
				$("#saleMonitorCond_companyId").change(function(){
					companyToProject(this.value, "saleMonitorCond_projectId");
				});				
			
				projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			});
				
		</script>
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
</head>

<body>

<%--固定的上部 --%>
<s:include value="body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title02" ><a href="./customer_guangzhou/chart/customerDoublePie.action" target="_self">交叉分析组合图</a></div>
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  	
	 <table width="100%" border="0" align="left" cellspacing="0">	  
		  
		  <!-- 搜索表单 top -->
       
   <form class="registerform" action="<%=request.getContextPath() %>/customer_guangzhou/chart/customerDoublePie.action" method="post" >
		  <tr>
     	<td colspan="6">	
     	<label>&nbsp;<span>项目</span></label><input type="text" id="projectName" name="projectName" value="${projectName}"/>
		<input type="hidden" id="hiddenId" name="customerCond.projectId" value="${customerCond.projectId}"/>	
		
		<label>&nbsp;<span>分析类型1</span></label><s:select list="listSelCategory" name="selCategory1" value="%{selCategory1}" />
		<label>&nbsp;<span>分析类型2</span></label><s:select list="listSelCategory" name="selCategory2" value="%{selCategory2}" />
				&nbsp;			
				日期<input class="Wdate" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}"/>
				-
				<input class="Wdate" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}"/>
		
		<s:submit value="  查询  " name="search" />	
		
		
	<div class="blueline"></div>	 
		</td>
	 </tr>
		</form>
		  
		<!-- 搜索表单 end -->
					
			
			
            <tr>
              <td colspan="6">
			  
				  <div class="gbox1">	
						<table style="width:95%; text-align:center">
							<tr>
								<td width="95%">
				
								<div class="gbox1">	
								 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center; white-space:nowrap;">     
								  
										 <s:iterator value="#request.tableList" id="tRow">
										 	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
												<s:iterator value="#tRow" id="tCol">
													<td><s:property value="#tCol"/></td>
												</s:iterator>
											</tr>
										 </s:iterator>	
										  
								  </table>
								  
								  </div>
							</td>
							
							
						</tr>		
						</table>		  		
					</div>
                          
			</td>
            </tr>
 </table>


<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

