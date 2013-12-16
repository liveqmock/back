<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>赠品</title>

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
	
	<style type="text/css">
		*{margin:0;padding:0;}
		input{width: 75%}
	</style>
	<script>
			function formsubmit (){
				var pri = $("#price_in").val();
				if(forcheck(pri)){
					document.getElementById("pay_unit_form").submit();
				}else{
					 alert( "请输入大于零的整数!"); 
					 $("#price_in").val('');
				}
				
		};
		
		function forcheck(ss){
				 var   type="^[0-9]*[1-9][0-9]*$"; 
			        var   re   =   new   RegExp(type); 
			       if(ss.match(re)==null) 
			        { 
			        return false;
			        }
			       return true;
			}
		
	</script>
	</head>
<body>
<div class="gbox1">			
<form action="./saleunit_new/appoint/guangzhou/unitGiftDialogForm.action" method="post" id="pay_unit_form">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td  style="width:15%" align="right"><b>赠品管理</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
              <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td  align="right">说明&nbsp;</td>
                <td>				 				 
				 <input name="addGift.mark"/>
				 </td>
              </tr>	
                <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td   align="right">价格&nbsp;</td>
                <td>				 				 
				 <input name="addGift.price" id="price_in" maxlength="9"/>
				 <input name="id" value="${id }" type="hidden"/>
				 </td>
              </tr>	
            
                <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td   align="left" colspan="4" style="color: red">${tips}</td>
              
              </tr>	
			</table>
</form>	
</div>

</body>
</html>