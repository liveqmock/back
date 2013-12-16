<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>合同</title>
<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
	
	<style type="text/css">
		*{margin:0;padding:0;}
		input{width: 75%}
	</style>
	<script>
			function formsubmit (){
				document.getElementById("pay_unit_form").submit();
		}  ;

		
	</script>
	</head>
<body>
<div class="gbox1">			
<form action="./saleunit_new/appoint/guangzhou/payForUnitForm.action" method="post" id="pay_unit_form">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td  style="width:15%" align="right"><b>付款单据</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
              <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td  align="right">应付&nbsp;</td>
                <td >				 				 
				 <input value="${unitPayBill.shouldPayFormat}" readonly="readonly" dir="rtl" disabled="disabled" />
				 </td>
              </tr>	
                <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td   align="right">已付&nbsp;</td>
                <td   >				 				 
				 <input value="${unitPayBill.hadPayFormat}" readonly="readonly" dir="rtl" disabled="disabled"/>
				 </td>
              </tr>	
                <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td   align="right">未付&nbsp;</td>
                <td>				 				 
				 <input value="${unitPayBill.notPayFormat}" readonly="readonly" dir="rtl" disabled="disabled"/>
				 </td>
              </tr>	
               <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td   align="right">付款&nbsp;</td>
                <td>			
                <input type="hidden" name="payId" value="${payId }"/>	 				 
				 <input value="0.00"  dir="rtl" name="payMoney" id="pay_money"/>
				 </td>
              </tr>	
			</table>
</form>	
</div>

</body>
</html>