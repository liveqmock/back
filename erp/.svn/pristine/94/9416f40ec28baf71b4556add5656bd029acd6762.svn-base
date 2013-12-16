<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>添加收款单据</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>

	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.isVoid1{text-decoration:line-through}
		.isVoid0{}
		
	</style>
	
</head>
<body>
<div class="gbox1">			

<form action="./saleunit_financial_tabs/guangzhou/addReceipt.action" method="post" id="addReceiptFormId">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:15%" align="right">单元编号&nbsp;</td>
			<td id="t14" style="width:25%" colspan="3">
			${unit.allName}
			<input type="hidden" name="receipt.unitId" value="${unit.id}" />
			<input type="hidden" name="receipt.billId" value="${bill.id}" />
			<input type="hidden" name="receipt.checkfeeId" value="0" />
			</td>						
		  </tr>	 
		  
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">收款类别&nbsp;</td>
                <td id="t14" style="width:30%">
					${bill.typeName}
				</td>		
                <td id="t15" style="width:15%" align="right">收款内容&nbsp;</td>
                <td id="t16" style="width:30%">
					${bill.feeType}
				</td>			
              </tr>	 
	
		  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t13" style="width:15%" align="right">收款日期&nbsp;</td>
			<td id="t14" style="width:25%">
				<input class="easyui-datebox" id="receiptDate" name="receipt.receiptDate" style="width:90px" value="${nowDate}"/>				</td>					
			<td id="t15" style="width:15%" align="right"><font color="red">*</font>收款金额&nbsp;</td>
			<td id="t16" style="width:25%">
				<input type="text" id="receiptMoney" name="receipt.receiptMoney" style="width:90px" value="${bill.notPay}"/>
			</td>	
		  </tr>	 
		  
		   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			style="empty-cells:show">
			<td id="t15" style="width:15%" align="right">收款人&nbsp;</td>
			<td id="t16" style="width:25%">
				<input type="text" id="inputMan" name="receipt.inputMan"/>				</td>				
			<td id="t15" style="width:15%" align="right"></td>
			<td id="t16" style="width:25%"></td>	
		  </tr>	 
			  
			</table>
			
</form>	
	
	</div>



</body>
</html>
