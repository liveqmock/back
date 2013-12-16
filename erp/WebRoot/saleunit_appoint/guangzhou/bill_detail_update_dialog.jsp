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
	
	<title>修改实收款项</title>
	
	<base href="<%=basePath%>">
			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  

	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			$("#detailSub").click(function(){				

				var ids = ["payType","payName","payMoney:money","inBank",fn];
				return myCheckOnlyById(ids);
			});
			
		});
		
		var fn = function payWayCheck(){
		
			var payWay = $("#payWay").val();
			if(payWay != 1){
				//选择了非现金
				if(payWay == ""){
					
					showTip("支付方式不能为空");
					return false;
				}else{
					
					var bankWay = $("#bankWay").val();
					if(bankWay == ""){
						
						showTip("银付方式不能为空");
						return false;
					}
				}
			}
		}
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
				<div class="titlebg" style="height: auto; overflow: visible;">
				
				<div class="c"></div>
				  <div class="c"></div>

		 <form class="registerform" action="./saleunit/appointbilldetail/guangzhou/updateAppointBillDetail.action" method="post" >	
		  
		  <table style="width: 600px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		 
		 	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t16" colspan="4">
					&nbsp;&nbsp;<font color="#000000">客户名称:${appoint.customerName}</font> 
					&nbsp;&nbsp;<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
				</td>
				
              </tr>
		  			 
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>款项类型&nbsp;</td>
                <td id="t16" style="width:30%">				 
				 <s:select list="selPayType" name="detail.payType" value="#request.detail.payType" id="payType"/>
				 				 
			    </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>款项名称&nbsp;</td>
                <td id="t14">
					 <input type="text" id="payName" name="detail.payName" class="leftcreateinputbox01" value="${detail.payName}"/>
				</td>
				
              </tr>
            
			
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>金额&nbsp;</td>
                <td id="t12">
				 	<input type="text" id="payMoney" name="detail.payMoney" class="leftcreateinputbox01" value="${detail.payMoney}" style="width:50%"/>
					元
				</td>
				
				 <td id="t11"  align="right"><font color="#FF0000">*</font>支付方式&nbsp;</td>
                <td id="t12">	
					 <s:select list="selPayWay" name="detail.payWay" value="#request.detail.payWay" id="payWay"/>
				</td>
				
              
             </tr>
			 
			 
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11"  align="right"><font color="#FF0000">*</font>入账银行&nbsp;</td>
                <td id="t12">
					<input type="text" id="inBank" name="detail.inBank" class="leftcreateinputbox01" value="${detail.inBank}"/>
					
				</td>
                <td id="t11"  align="right"><font color="#FF0000">*</font>银付方式&nbsp;</td>
                <td id="t12">	
					 <s:select list="selBankWay" name="detail.bankWay" value="#request.detail.bankWay" id="bankWay"/>
				</td>
				
              
             </tr>
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">摘要&nbsp;</td>

				<td colspan="3" style="white-space:normal">	
					<input type="text" name="detail.summary" id="summary" class="leftcreateinputbox02" style="width:80%" value="${detail.summary}"/>	
				</td>
			  </tr>
			 
			 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td id="t7"  align="right">备注&nbsp;</td>

				<td colspan="3" style="white-space:normal">	
					<input type="text" name="detail.remark" id="remark" class="leftcreateinputbox02" style="width:80%" value="${detail.remark}"/>			
				</td>
			  </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="detailSub"/>				 
					&nbsp;&nbsp;
				  <input type="reset" value="  重置  "/>
				  <input type="hidden" name="detail.id" value="${detail.id}"/>
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

