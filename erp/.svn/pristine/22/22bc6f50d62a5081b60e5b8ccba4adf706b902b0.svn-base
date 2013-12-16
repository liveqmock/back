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
	
	<title>修改实收单据</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/appoint_guangzhou_update.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 
	
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
			<font color="#FF0000"><span id="suggestion">
			<s:property value="#request.session.suggestion"/></span></font>
 </div>	
		  
	  <form class="registerform" action="./saleunit/appointbill/guangzhou/updateAppointBill.action" method="post" >	
		  
		  <table style="width: 900px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
		 	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t16" colspan="4">
					&nbsp;&nbsp;<font color="#000000">修改实收单据(客户名称:${appoint.customerName})</font>
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
					 <input type="text" id="payMan" name="appointBill.payMan" class="leftcreateinputbox01" value="${appointBill.payMan}"/>
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>开票人&nbsp;</td>
                <td id="t12">
					<input type="text" id="writerName" value="${appointBill.writerName}" class="leftcreateinputbox01"/>
					<input type="hidden" id="writerHiddenId" name="appointBill.writerId" value="${appointBill.writerId}"/>
					
				</td>
				
				 <td id="t11"  align="right"><font color="#FF0000">*</font>缴款日期&nbsp;</td>
                <td id="t12">	
					<input class="Wdate" type="text" id="payDate" style="width:90px" name="appointBill.payDate" 
					value='<s:date name="#request.appointBill.payDate" format="yyyy-MM-dd "/>'/>
				</td>
				
              
             </tr>
			 
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>票据类型&nbsp;</td>
                <td id="t12">
					<s:select list="selBillType" name="appointBill.billType" value="#request.appointBill.billType"/>
					
				</td>
                <td id="t11"  align="right">票据批次号&nbsp;</td>
                <td id="t12">	
					<input type="text" id="batchNo" name="appointBill.batchNo" class="leftcreateinputbox01" value="${appointBill.batchNo}"/>
				</td>
				
              
             </tr>
			 
			  
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>票据编号&nbsp;</td>
                <td id="t12">
					<input type="text" id="billNo" name="appointBill.billNo" class="leftcreateinputbox01" value="${appointBill.billNo}"/>
				</td>
                <td id="t11"  align="right">审核人&nbsp;</td>
                <td id="t12">	
					<input type="text" id="approvalUserName" value="${appointBill.approvalUserName}" class="leftcreateinputbox01"/>
					<input type="hidden" id="approvalUserHiddenId" name="appointBill.approvalUserid" value="${appointBill.approvalUserid}"/>
					
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>开票日期&nbsp;</td>
                <td id="t12">
					<input class="Wdate" type="text" id="writeDate" style="width:90px" name="appointBill.writeDate" 
					value='<s:date name="#request.appointBill.writeDate" format="yyyy-MM-dd "/>'/>
				</td>
                <td id="t11"  align="right"></td>
                <td id="t12"></td>
               
             </tr>
			 
			  			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">备注&nbsp;</td>

				<td colspan="3" style="white-space:normal">	
					<input type="text" name="appointBill.remark" id="remark" class="leftcreateinputbox02" style="width:80%" value="${appointBill.remark}"/>		
				</td>
		   </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="billSub"/>				 
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onclick="billRet(${appointBill.appointId})"/>
				  <input type="hidden" id="appointBillId" name="appointBill.id" value="${appointBill.id}"/>
				  <input type="hidden" name="appointBill.appointId" value="${appointBill.appointId}"/>
					&nbsp;&nbsp;
				   <input type="button" id="appointBillDetail" value="  新建实收款项  " onclick="return inputBillDetail(${appointBill.id})"/>
				</td>
			  </tr>
			 
			
			</table>

			
		  </td>
		  </tr>
		  
		  
		  <tr>
		  	<td colspan="4">
			
				<div>			  
			  
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		
		 <tr class="gboxbg">
		 	<td colspan="11">&nbsp;&nbsp;<font color="#000000">实收款项列表</font></td>
		 </tr>
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
	 金额
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

