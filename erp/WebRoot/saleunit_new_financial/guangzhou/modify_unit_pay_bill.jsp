<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>修改应收款</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");
			
			bindPayTypeByFee("typeName", "selFeeTypeId");
									
		});
		
		
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>

<form action="./saleunit_financial_manager/guangzhou/updateUnitPayBill.action" method="post" id="modifyUnitPayBillFormId">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">		
			   
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款类别&nbsp;</td>
                <td id="t14" style="width:30%">
					<s:select list="selPayType" id="typeName" name="payBill.typeName"></s:select>
				</td>		
                <td id="t15" style="width:15%" align="right">收款内容&nbsp;</td>
                <td id="t16" style="width:30%">
					<!--
					<input name="payBill.feeType"  id="selFeeTypeId"/>
					-->
					<pt:sel cssStyle="width:auto" id="selFeeTypeId" name="payBill.feeType" typeName="${payBill.typeName}" value="${payBill.feeType}"/>
				</td>			
              </tr>	 
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13"  align="right"><font color="red">*</font>应收日期&nbsp;</td>
                <td id="t14">
					<input class="easyui-datebox" id="payDate" name="payBill.payDate" value='<s:date name="payBill.payDate" format="yyyy-MM-dd"/>' style="width:90px"/>
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>应收金额&nbsp;</td>
                <td id="t16" style="width:30%">
					<input type="text" id="shouldPay" name="payBill.shouldPay" value="${payBill.shouldPay}" style="width:40%" class="easyui-numberbox" min="0"/>				
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">备注&nbsp;</td>
                <td id="t14" colspan="3">
					<input type="text" id="remark" name="payBill.remark" style="width:76%" value="${payBill.remark}"/>
					<input type="hidden" name="payBill.unitId" value="${payBill.unitId}"/>
					<input type="hidden" name="payBill.wayDetailId" value="${payBill.wayDetailId}"/>
					<input type="hidden" name="payBill.id" value="${payBill.id}"/>
				</td>		
              	
              </tr>	 
			  
			  
			  
			</table>
</form>	

</body>
</html>
