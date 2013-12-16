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

	<s:include value="../../header/header_easyui.jsp"></s:include>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_common_min.js"></script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		input{width: 75%}
	</style>
	<script>
	$().ready(function(){
		closeIframeDialog("new_dialog", "${closeMark}", "", "${suggestion}");
	})
			function formsubmit (){
				document.getElementById("pay_unit_form").submit();
			}  


			
			function getNewName(){
				return "${newName}";
			}
	</script>
	</head>
<body>
<div class="gbox1">			
<form action="${actionPath}" method="post" id="pay_unit_form">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;background-color: #A9D9FF">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td  align="left" colspan="2" style="line-height: 30px" ><b>&nbsp;您现在的操作:${text1}&nbsp;</b></td>
			  </tr>
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right"><font color="red"> * </font> 名称&nbsp;</td>
                <td >				 				 
				 <input name="newName" type="text" maxlength="25"/>
				 <input type="hidden" value="${id }" name="id"/>
				</td>
              </tr>	
			</table>
</form>	
</div>

</body>
</html>