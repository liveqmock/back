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
	
	<title>新建预约排号实收单据</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  

	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/appoint_guangzhou_input.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
			
		});
		
	</script>
	
			
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body>
 
 <DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
	<table width="100%" class="mainbg20111112" style="height: 100%">
		<tr>


			<td width="100%" valign="top" height="100%" style="overflow: hidden;">
				<div class="titlebg" style="height: auto; overflow: scroll;">
				
				
		<form class="registerform" action="./saleunit/appointbill/guangzhou/inputAppointBill.action" method="post" >	
		  
		  <table style="width: 800px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right">项目&nbsp;</td>
                <td id="t16" colspan="3">
					<input type="text" id="projectName" name="projectName" value="<s:property value='#request.project.projectName'/>"/>
					<input type="hidden" id="hiddenId" name="appointBill.propertyId" value="<s:property value='#request.project.id'/>"/>
					(按空格键可以查找前十条数据)
				</td>
				
              </tr>
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">购买房间&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="unitId" name="appointBill.unitId" class="leftcreateinputbox01"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">交款人&nbsp;</td>
                <td id="t14">
					 <input type="text" id="payMan" name="appointBill.payMan" class="leftcreateinputbox01" />
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">开票人&nbsp;</td>
                <td id="t12">
				 	<input type="text" id="writerId" name="appointBill.writerId" class="leftcreateinputbox01"/>
				</td>
				
				 <td id="t11"  align="right">缴款日期&nbsp;</td>
                <td id="t12">	
					<input class="Wdate" type="text" id="payDate" style="width:90px" name="appointBill.payDate" />
				</td>
				
              
             </tr>
			 
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">票据类型&nbsp;</td>
                <td id="t12">
					<input type="text" id="billType" name="appointBill.billType" class="leftcreateinputbox01"/>
					
				</td>
                <td id="t11"  align="right">票据批次号&nbsp;</td>
                <td id="t12">	
					<input type="text" id="batchNo" name="appointBill.batchNo" class="leftcreateinputbox01"/>
				</td>
				
              
             </tr>
			 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">票据编号&nbsp;</td>
                <td id="t12">
					<input type="text" id="billNo" name="appointBill.billNo" class="leftcreateinputbox01"/>
				</td>
                <td id="t11"  align="right">审核人&nbsp;</td>
                <td id="t12">	
					<input type="text" id="approvalUserid" name="appointBill.approvalUserid" class="leftcreateinputbox01"/>
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right">审核日期&nbsp;</td>
                <td id="t12">
					<input class="Wdate" type="text" id="approvalDate" style="width:90px" name="appointBill.approvalDate" />
				</td>
                <td id="t11"  align="right">开票日期&nbsp;</td>
                <td id="t12">
					<input class="Wdate" type="text" id="writeDate" style="width:90px" name="appointBill.writeDate" />
				</td>
               
             </tr>
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">备注&nbsp;</td>
				<td colspan="3" style="white-space:normal">	
					<input type="text" name="appointBill.remark" id="remark1" class="leftcreateinputbox02" style="width:80%"/>			
				</td>
			  </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="billSub"/>				 
					&nbsp;&nbsp;
				  <input type="reset" value="  取消  " />
				  <input type="hidden" name="appointBill.appointId" value="${appointId}"/>
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
				
				
				</div>
			</td>
		</tr>
	</table>
</DIV>
				


 	
 

  </body>
</html>

