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
	
	<title>修改预约排号</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/appoint_guangzhou_update.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
		
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
			
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body>
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="./saleunit/appoint/guangzhou/index.action" target="_self">查询预约排号</a></div>
<div class="title02"><a href="./saleunit/appoint/guangzhou/getById.action?id=${appoint.id}" target="_self">修改预约排号</a></div>	
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">  		  
		   &nbsp;&nbsp;		
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
	  <form class="registerform" action="./saleunit/appoint/guangzhou/updateAppoint.action" method="post" >	
		  
		  <table style="width: 900px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right">楼盘项目&nbsp;</td>
                <td id="t16">
					${appoint.propertyProjectName}
					<input type="hidden" id="hiddenId" name="appoint.propertyId" value="${appoint.propertyId}"/>
				</td>
								
				 <td id="t13" style="width:15%" align="right">楼栋&nbsp;</td>				
				
				<td>
					
					${appoint.buildName}
					<input type="hidden" id="hiddenBulidId" name="appoint.buildId" value="${appoint.buildId}"/>
				</td>
				
              </tr>
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">房间&nbsp;</td>
                <td id="t16" style="width:30%">
				  <input type="text" id="unitId" value="${appoint.unitName}" class="leftcreateinputbox01"/>
 				 <input type="hidden"  name="appoint.unitId" id="hiddenUnitId" value="${appoint.unitId}"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">实际排号&nbsp;</td>
                <td id="t14">
					 <input type="text" id="realNum" name="appoint.realNum" class="leftcreateinputbox01" value="${appoint.realNum}"/>
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11" align="right">客户名称&nbsp;</td>
                <td id="t12" class="fontblue">
					<a href="#" onclick="return false;" id="showAppointCustomer">${appoint.customerName}</a>
					<input type='hidden' id='appointCustomerId'  name="appoint.customerId" value="${appoint.customerId}"/>
					
				</td>
				
				 <td id="t11"  align="right">业务员&nbsp;</td>
                <td id="t12">	
					<input type="text" id="saleName" value="${appoint.saleName}" class="leftcreateinputbox01"/>
					<input type="hidden" id="saleHiddenId" name="appoint.salesId" value="${appoint.salesId}"/>
				</td>
				
              
             </tr>
			 
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>预约日期&nbsp;</td>
                <td id="t12">
					<input class="Wdate" type="text" id="date1" style="width:90px" name="appoint.appointDate" 
						value='<s:date name="#request.appoint.appointDate" format="yyyy-MM-dd "/>'/>
					
				</td>
                <td id="t11"  align="right">失效日期&nbsp;</td>
                <td id="t12">	
					<input class="Wdate" type="text" id="date2" style="width:90px" name="appoint.endDate"
						value='<s:date name="#request.appoint.endDate" format="yyyy-MM-dd "/>'/>
				</td>
				
              
             </tr>
			 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>项目排号&nbsp;</td>
                <td id="t12">
					<input type="text" id="appointNum" name="appoint.appointNum" class="leftcreateinputbox01" value="${appoint.appointNum}"/>
				</td>
                <td id="t11"  align="right">房间排号&nbsp;</td>
                <td id="t12">	
					<input type="text" id="unitNum" name="appoint.unitNum" class="leftcreateinputbox01" value="${appoint.unitNum}"/>
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">应收预约金&nbsp;</td>
                <td id="t12">
					<input type="text" id="apponitMoney" name="appoint.apponitMoney" class="leftcreateinputbox01" value="${appoint.apponitMoney}" style="width:25%"/>
					元
				</td>
                <td id="t11"  align="right">实收预约金&nbsp;</td>
                <td id="t12">
					<%--
					<input type="text" id="realMoney" name="appoint.realMoney" class="leftcreateinputbox01" value="${appoint.realMoney}" style="width:20%"/>
					--%>
					${appoint.realMoney}
					元
				</td>
               
             </tr>
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">备注&nbsp;</td>
				<td colspan="3" style="white-space:normal">	
					<input type="text" name="appoint.remark" id="remark1" class="leftcreateinputbox02" style="width:80%" value="${appoint.remark}"/>			
				</td>
			  </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="sub"/>
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
				  <input type="hidden" id="appointId" name="appoint.id" value="${appoint.id}"/>
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>saleunit/appoint/guangzhou/index.action'" />
					&nbsp;&nbsp;
				   <input type="button" value="  新建实收单据  " id="appointBill"/>

				   <s:if test="appoint.canChangeToConfirm"> 
				    &nbsp;&nbsp;					
				   <input type="button" value="  转认购  " id="changeToConfirmButton" onclick="return changeToConfirm(${appoint.id})"/>
				   </s:if>

		
				</td>
			  </tr>
			  			  
			   <tr class="gboxbg" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="left">
				<td colspan="4">				
					&nbsp;&nbsp;<a href="#" onclick="return false;" id="billListButton" style="color:#000000;text-decoration: underline;">实收单据列表</a>
					&nbsp;&nbsp;<a href="#" onclick="return false;" id="detailListButton" style="color:#5482DE;text-decoration: underline;">实收款项列表</a>
				</td>
				</tr>
			 
			
			</table>

			
		  </td>
		  </tr>
			
		 <tr id="billList">
		<td colspan="4">			

		<div>			  
			  
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		
		 
  <tr class="gboxbg">

    <td width="120" align="center">
		开票日期
	</td>
   
	
    <td width="120" align="center">
	单据类型
	</td>
	
	<td width="120" align="center">
	票据类型
	</td>
	
     <td width="120" align="center" valign="middle">
	 票据编号
	</td>
	
	 <td width="100" align="center" valign="middle">
		金额(元)
	</td>
	
	<td width="100" align="center" valign="middle">
		交款人
	</td>
	
	
	 <td width="100" align="center" valign="middle">
	 开票人
	</td>
	
	
	 <td width="100" align="center" valign="middle">
		审核日期
	</td>
   
	
	<td width="50" align="center" valign="middle" style="white-space:nowrap">
		操作
	</td>
	
  </tr>
 
 
  
   <s:iterator value="#request.appointBillList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
	   
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/appointbill/guangzhou/getById.action?appointBillId=<s:property value='#c.id'/>" title="点击修改实收单据">
				<s:date name="#c.writeDate" format="yyyy-MM-dd "/></a>
		</td>
		
		<td align="center" valign="middle">
			收款单
		</td>
		<td align="center" valign="middle">
			<s:property value="#c.billTypeStr"/>
		</td>
		<td align="center" valign="middle">	
			<s:property value="#c.billNo"/>
		</td>
		<td align="center" valign="middle">
			${c.payMoney}
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.payMan"/>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.writerName"/>
		</td>
		
		<td align="center" valign="middle">
			<s:date name="#c.approvalDate" format="yyyy-MM-dd "/>
		</td>
		
		<td align="center" valign="middle" class="fontblue" style="white-space:nowrap">
			<a href="#" onclick="return delAppointBill(${c.id}, ${appoint.id})">删除</a>
		</td>
		
		
	  </tr>
    </s:iterator>
  
</table>
</div>
		 </td>
		 </tr>
		 
		 <tr id="detailList" style="display:none">
		  	<td colspan="4">
			
				<div>			  
			  
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
				
  <tr class="gboxbg">
    
    <td width="120" align="center">
		缴费日期
	</td>
   	
    <td width="120" align="center">
	款项类型
	</td>
	
	<td width="120" align="center">
	款项名称
	</td>
	
     <td width="100" align="center" valign="middle">
	 金额(元)
	</td>
	
	<td width="50" align="center" valign="middle" style="white-space:nowrap">
		操作
	</td>
	
  </tr>
 
 
  
   <s:iterator value="#request.detailList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		
		<td align="center" valign="middle" class="fontblue">
			<a onclick="return updateBillDetail(${c.id})" href="#" title="点击修改预约收款单明细" >
				<s:date name="#c.modTime" format="yyyy-MM-dd "/></a>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.payTypeStr"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#c.payName"/>
		</td>
		<td align="center" valign="middle">	
			<s:property value="#c.payMoney"/>
		</td>
					
		<td align="center" valign="middle" class="fontblue" style="white-space:nowrap">
			<a href="#" onclick="return delAppointDetail(${c.id}, ${appoint.id})">删除</a>
		</td>
		
	  </tr>
    </s:iterator>
  
</table>
</div>
			
			</td>
		  </tr>
		  
           
            </table>
</form>

<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
  </body>
</html>

