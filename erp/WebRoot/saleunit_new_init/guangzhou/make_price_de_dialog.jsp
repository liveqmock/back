<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>模板弹出框</title>

	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<style type="text/css">
		*{margin:0;padding:0;}
		.showtable td{padding-left: 5px}
	</style>
	<script>
			function dosubmit (){
				location.href="./saleunit_new_init/appoint/guangzhou/showMakePriceDaDialogForm.action?makeId=${makeId}";
			}  

	</script>
	</head>
<body>
<div class="gbox1">			
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="showtable"  style="font-size:12px; line-height:22px;background-color: #A9D9FF">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
		 	   	<th colspan="2">单元</th>
		 	   	<th nowrap="nowrap">套内面积</th>
				<th nowrap="nowrap">套内价格</th>
				<th nowrap="nowrap">建筑面积</th>
				<th nowrap="nowrap">建筑价格</th>
				<th nowrap="nowrap">标准总价</th>
				<th nowrap="nowrap">朝向</th>
				
				<th nowrap="nowrap">房间数</th>
				<th nowrap="nowrap">厅数</th>
				<th nowrap="nowrap">卫数</th>
				<th nowrap="nowrap">产品类型</th>
				<th nowrap="nowrap">计价方式</th>
				<th nowrap="nowrap">装修标准</th>
				<th nowrap="nowrap">装修单价</th>
				<th nowrap="nowrap">装修款</th>
				
				<th nowrap="nowrap">景观</th>
				<th nowrap="nowrap">备注</th>
			  </tr>
			  <s:iterator value="pagMakList" var="c" status="ts">
              <tr  style="empty-cells:show" 
              	<s:if test="#ts.odd">bgcolor="#FFFFFF"</s:if>
              	<s:else>bgcolor="#f1f9fe"</s:else>
              >
              	<td nowrap="nowrap">${floor}层</td>
              	<td nowrap="nowrap">${unitId }</td>
              	<td nowrap="nowrap">${insideArea }</td>
              	<td nowrap="nowrap">${insidePrice }</td>
              	
              	<td nowrap="nowrap">${buildArea }</td>
              	<td nowrap="nowrap">${buildPrice }</td>
              	<td nowrap="nowrap">${sumPrice }</td>
              	<td nowrap="nowrap">${orientation }</td>
              	
              	<td nowrap="nowrap">${roomNum }</td>
              		<td nowrap="nowrap">${hallNum }</td>
              			<td nowrap="nowrap">${toiletNum }</td>
              	
              	<td nowrap="nowrap">${productType }</td>
              	<td nowrap="nowrap">${priceWay }</td>
              	
              	<td nowrap="nowrap">${renovateDesc }</td>
              	<td nowrap="nowrap">${renovatePrice }</td>
              	<td nowrap="nowrap">${renovateMoney }</td>
              	
              	<td nowrap="nowrap">${scenery }</td>
              	<td nowrap="nowrap">${remark }</td>
              	
              </tr>	
              </s:iterator>
	</table>
	<font color="red">${tips}</font>
</div>

</body>
</html>