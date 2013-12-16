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
	
	<title>新建实收单据</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/appoint_guangzhou_update.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
		
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript">
		 
		 $(document).ready(function(){				
						
			userListForHiddenId("writerName", "writerHiddenId");
			userListForHiddenId("approvalUserName", "approvalUserHiddenId");
			
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
		  
	  <form class="registerform" action="./saleunit/appointbill/guangzhou/inputAppointBill.action" method="post" >	
		  
		  <table style="width: 900px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
		 	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t16" colspan="4">
					&nbsp;&nbsp;<font color="#000000">新建实收单据(客户名称:${appoint.customerName})</font>
				</td>
				
              </tr>
		  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15"  style="width:15%"  align="right"><font color="#FF0000">*</font>楼盘项目&nbsp;</td>
                <td id="t16">
					${appoint.propertyProjectName}
				</td>
				<td id="t13" style="width:15%" align="right">楼盘楼栋&nbsp;</td>
                <td id="t14">
					${appoint.buildName}
				</td>
				
              </tr>
		   
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">购买房间&nbsp;</td>
                <td id="t16" style="width:30%">
					${appoint.unitName}
				 </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>交款人&nbsp;</td>
                <td id="t14">
					 <input type="text" id="payMan" name="appointBill.payMan" class="leftcreateinputbox01" value="${appoint.customerName}"/>
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>开票人&nbsp;</td>
                <td id="t12">
					<input type="text" id="writerName" class="leftcreateinputbox01"/>
					<input type="hidden" id="writerHiddenId" name="appointBill.writerId"/>
				</td>
				
				 <td id="t11"  align="right"><font color="#FF0000">*</font>缴款日期&nbsp;</td>
                <td id="t12">	
					<input class="Wdate" type="text" id="payDate" style="width:90px" name="appointBill.payDate" />
				</td>
				
              
             </tr>
			 
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>票据类型&nbsp;</td>
                <td id="t12">
					<s:select list="selBillType"  name="appointBill.billType" />
					
				</td>
                <td id="t11"  align="right">票据批次号&nbsp;</td>
                <td id="t12">	
					<input type="text" id="batchNo" name="appointBill.batchNo" class="leftcreateinputbox01"/>
				</td>
				
              
             </tr>
			 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>票据编号&nbsp;</td>
                <td id="t12">
					<input type="text" id="billNo" name="appointBill.billNo" class="leftcreateinputbox01"/>
				</td>
                <td id="t11"  align="right">审核人&nbsp;</td>
                <td id="t12">	
					<input type="text" id="approvalUserName" class="leftcreateinputbox01"/>
					<input type="hidden" id="approvalUserHiddenId" name="appointBill.approvalUserid"/> 
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>开票日期&nbsp;</td>
                <td id="t12">
					<input class="Wdate" type="text" id="writeDate" style="width:90px" name="appointBill.writeDate" value="${now}"/>
				</td>
                <td id="t11"  align="right"></td>
                <td id="t12"></td>
               
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
				  <input type="button" value="  取消  " onclick="billRet('${appointId}')"/>
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

<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

