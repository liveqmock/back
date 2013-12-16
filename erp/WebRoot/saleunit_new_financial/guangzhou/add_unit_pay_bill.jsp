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
	
	<title>添加应收款</title>
	
	<s:include value="../../header/header_easyui.jsp"></s:include>	  

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");

			bindPayTypeByFee("typeName", "selFeeTypeId");
			
			bindModuleShowHidePanelById(["typeName"]);
												
		});
		
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>

<form action="./saleunit_financial_manager/guangzhou/addUnitPayBill.action" method="post" id="addUnitPayBillFormId">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">		
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>收款类别&nbsp;</td>
                <td id="t14" style="width:30%">
					<s:select list="selPayType" id="typeName" name="payBill.typeName" value=""></s:select>
				</td>		
                <td id="t15" style="width:15%" align="right">收款内容&nbsp;</td>
                <td id="t16" style="width:30%">
					<!--
					<input name="payBill.feeType"  id="selFeeTypeId"/>
					-->
					<pt:sel cssStyle="width:auto" id="selFeeTypeId" name="payBill.feeType" typeName=""/>
				</td>			
              </tr>	 
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13"  align="right"><font color="red">*</font>应收日期&nbsp;</td>
                <td id="t14">
					<input class="easyui-datebox" id="payDate" name="payBill.payDate" style="width:90px"/>
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>应收金额&nbsp;</td>
                <td id="t16" style="width:30%">
					<input type="text" id="shouldPay" name="payBill.shouldPay" style="width:40%" class="easyui-numberbox" min="0"/>				
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">备注&nbsp;</td>
                <td id="t14" colspan="3">
					<input type="text" id="remark" name="payBill.remark" style="width:76%"/>
					<input type="hidden" name="payBill.unitId" value="${unit.id}"/>
					<input type="hidden" name="payBill.wayDetailId" value="0"/>
				</td>		
              </tr>	 
			</table>
</form>	
	
</body>
</html>
