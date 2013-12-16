<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="p" uri="/WEB-INF/property.tld"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>新建合同</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	
	<script type="text/javascript" language="javascript" src="./js/sale_unit.js"></script>	 
	
	<script type="text/javascript" language="javascript">
	
		$(document).ready(function(){
		
			/**
			propertyProjectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
			getBuildListFromPropertyIdForAuto("buildName", "hiddenId", "hiddenBulidId");  //根据楼盘项目id,获取对应的楼栋联想提
			
			//项目id有变化,要清空楼栋的值与id
			$("#projectName").change(function(){
				$("#buildName").val("");
				//$("#hiddenBulidId").html("");
				$("#hiddenBulidId").attr("value", ""); 				
			});
			**/
			
			saleUnitBind("projectName", "projectHiddenId", "areaId", "buildId");		
		
		});
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body>
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="<%=basePath%>saleunit/contract/guangzhou/searchList.action" target="_self">查询合同</a></div>
<div class="title02"><a href="<%=basePath%>saleunit/contract/guangzhou/forInput.action" target="_self">新建合同</a></div>	
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_over">
		<b>第一步:选择楼栋</b>
	</div>		
	<div class="d_out">
		第二步:选择房间
	</div>		
	<div class="d_out">
		第三步:选择客户					
	</div>
	<div class="d_out">
		第四步:主要信息
	</div> 

	<div class="d_out">
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>					
	</div>
		
	 </td>
	</tr>
</table>
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c"></div>	
		  
	<table style="width: 100%;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/saleunit/contract/guangzhou/contractInputFirst.action" method="post" >
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle" width="180">楼盘项目</td>
	
	<td width="187" align="left" valign="middle">
		<%--
		<input type="text" id="projectName" name="buildCond.propertyName" value="${buildCond.propertyName}"/>	
		<input type="hidden" id="hiddenId" name="buildCond.propertyId" value="${buildCond.propertyId}"/>
		--%>
		<p:project id="projectName" name="buildCond.propertyName" value="${buildCond.propertyName}"
		 hiddenId="projectHiddenId" hiddenName="buildCond.propertyId" hiddenValue="${buildCond.propertyId}"/>
	</td>
	
   <td align="center" valign="middle" width="180">
   楼盘分区
	</td>
	
     <td width="187" align="left" valign="middle">
	 <%--
	<input type="text" id="buildName" name="buildCond.buildName" value="${buildCond.buildName}"/>	
	<input type="hidden" id="hiddenBulidId" name="buildCond.buildId" value="${buildCond.buildId}"/>
	--%>
	<p:area id="areaId" name="buildCond.areaId" value="${buildCond.areaId}" relyValue="${buildCond.propertyId}"/>
	 </td>
	
   <td align="center" valign="middle" width="180px">
   楼盘楼栋
	</td>
	
	 <td width="187" align="left" valign="middle">
	 <%--
	<input type="text" id="buildName" name="buildCond.buildName" value="${buildCond.buildName}"/>	
	<input type="hidden" id="hiddenBulidId" name="buildCond.buildId" value="${buildCond.buildId}"/>
	--%>
	<p:build id="buildId" name="buildCond.buildId" value="${buildCond.buildId}" relyValue="${buildCond.areaId}"/>
	 </td>
	 
  </tr>
  
  
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle" width="180">
		<input type="submit" value="  搜索  " id="searchSubmit"/>
	</td>
	
	<td width="187" align="left" valign="middle"></td>
	
   <td align="center" valign="middle" width="180"></td>
	
     <td width="187" align="left" valign="middle"></td>
	
   <td align="center" valign="middle" width="180px"></td>
	
	<td></td>
	 
  </tr>
  
  </table>

			
			
		  </td>
		  </tr>
			
		</form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
            </tr>		
		
			 <tr>
              <td height="20" colspan="6">
				<div id="load"></div>
				
				</td>
            </tr>
			
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    	
	 <td width="100" align="center" valign="middle">
		楼盘项目
	</td>
	
	 <td width="100" align="center" valign="middle">
		楼盘分区
	</td>
		
     <td width="100" align="center" valign="middle">
		楼盘楼栋
	</td>
	
	 <td width="50" align="center" valign="middle">
		操作
	</td>
      
  </tr>
 
 
  
   <s:iterator value="#request.buildList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
	
		<td align="center" valign="middle">	
			${c.descPropertyId}
		</td>
		
		<td align="center" valign="middle">
			${c.areaName}
		</td>
		
		<td align="center" valign="middle">
			${c.buildName}
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/contract/guangzhou/changeBuildToSecond.action?buildId=${c.id}">选择</a>
		</td>
		
		
	  </tr>
    </s:iterator>
  
</table>
</div>

<!-- 列表 end -->


</td>
            </tr>
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
			</td>
            </tr>
 </table>

<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

