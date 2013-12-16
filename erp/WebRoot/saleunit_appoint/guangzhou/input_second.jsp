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
	
	<title>新建预约排号</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/sale_unit.js"></script>	 
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript">
	
		$(document).ready(function(){
			saleUnitShow(closeFn, true, "appoint");
			
			$("#changeUnitToThird").click(function(){
				var changeUnitId = $("#changeUnit").attr("unitId");
				if(changeUnitId == undefined){
				
					alert("请先选择房间");
				}else{
				
					loading();
					location.href = "./saleunit/appoint/guangzhou/changeUnitToThird.action?unitId=" + changeUnitId;
				}

			});
		});
		
		function closeFn(data){
			//alert(data.id + ":" + data.unitNo);
			$("#changeUnit").html(data.unitNo).attr("unitId", data.id);				
		}
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}		
		
		.tb1 td{padding-left: 5px;width:75px; text-align:center; cursor: pointer}
		.tb1 tr{background-color:#FFFFFF}
		.seltd{background-color:#EEAD0E}

	</style>
	
  </head>
  
 <body>
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="./saleunit/appoint/guangzhou/index.action" target="_self">查询预约排号</a></div>
<div class="title02"><a href="./saleunit/appoint/guangzhou/forInput.action" target="_self">新建预约排号</a></div>	
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		第一步:选择楼栋
	</div>		
	<div class="d_over">
		<b>第二步:选择房间</b>
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
				
						<div style="float: left;width: auto;overflow: scroll;height: 400px;border: 1px solid #A9D9FF">
							
							<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto">
								
								 <s:iterator value="#request.trList" id="c">  
								 	${c}
								 </s:iterator>
							 
							 	
							</table>
								
										

						</div>
				
				</td>
			</tr>
			
			<tr>
				<td colspan="6" id="unit_sale_state">
					
						<s:include value="../../saleunit_new/guangzhou/unit_sale_state.jsp"/>	
				
				</td>
			</tr>
			
            <tr>
				<td colspan="6">
				选择单元:<span style="color:black;font-weight: bold;" id="changeUnit"></span><input type="button" value="  确定  " id="changeUnitToThird"/>
				&nbsp;&nbsp;<input type="button" value="  跳过  " id="next" 
					onclick="javascript:window.location.href='./saleunit/appoint/guangzhou/noChangeUnitToThird.action?buildId=${buildId}'"/>
				</td>
			</tr>
			
            <tr>
              <td colspan="6"></td>
            </tr>
 </table>

<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

