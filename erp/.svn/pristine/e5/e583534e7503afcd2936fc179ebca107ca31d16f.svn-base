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
	
	<title>新建预约收款单明细</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/appoint_guangzhou_update.js"></script>
			
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
<div class="title01"><a href="./saleunit/appoint/guangzhou/forInput.action" target="_self">新建预约排号</a></div>	
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">
			  &nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
	  <form class="registerform" action="./saleunit/appointbilldetail/guangzhou/inputAppointBillDetail.action" method="post" >	
		  
		  <table style="width: 900px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
		 	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t16" colspan="4">
					&nbsp;&nbsp;<font color="#000000">新建预约收款单明细(客户名称:${appoint.customerName})</font>
				</td>
				
              </tr>
		  			 
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">款项类型&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="payType" name="detail.payType" class="leftcreateinputbox01"/>
			    </td>
                 <td id="t13" style="width:15%" align="right">款项名称&nbsp;</td>
                <td id="t14">
					 <input type="text" id="payName" name="detail.payName" class="leftcreateinputbox01" />
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">金额&nbsp;</td>
                <td id="t12">
				 	<input type="text" id="payMoney" name="detail.payMoney" class="leftcreateinputbox01"/>
				</td>
				
				 <td id="t11"  align="right">支付方式&nbsp;</td>
                <td id="t12">	
					<input type="text" id="payWay" name="detail.payWay" class="leftcreateinputbox01"/>
				</td>
				
              
             </tr>
			 
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">入账银行&nbsp;</td>
                <td id="t12">
					<input type="text" id="inBank" name="detail.inBank" class="leftcreateinputbox01"/>
					
				</td>
                <td id="t11"  align="right">银付方式&nbsp;</td>
                <td id="t12">	
					<input type="text" id="bankWay" name="detail.bankWay" class="leftcreateinputbox01"/>
				</td>
				
              
             </tr>
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">摘要&nbsp;</td>

				<td colspan="3" style="white-space:normal">	
					<input type="text" name="detail.summary" id="summary" class="leftcreateinputbox02" style="width:80%"/>			
				</td>
			  </tr>
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">备注&nbsp;</td>

				<td colspan="3" style="white-space:normal">	
					<input type="text" name="detail.remark" id="remark" class="leftcreateinputbox02" style="width:80%"/>			
				</td>
			  </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="billSub"/>				 
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onclick="billDetailRet('${appointBill.id}')"/>
				  <input type="hidden" name="detail.billId" value="${appointBill.id}"/>
				</td>
			  </tr>
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4"><font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font></td>
			  </tr>
			 
			
			</table>

			
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

