<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>复制楼栋</title>

	<s:include value="../../header/header_easyui.jsp"></s:include>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		input{width: 75%}
	</style>
	<script>
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
				<td  align="left" colspan="2" style="line-height: 30px" >
				<b>复制的原楼栋:<font color="red"> ${text1 }</font></b>
				</td>
			  </tr>
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">复制后的名称</td>
                <td >				 				 
				 <input name="newName"/>
				 <input type="hidden" value="${id }" name="id"/>
				</td>
              </tr>	
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">复制到</td>
                <td >				 				 
				<s:select list="selAreaMap" name="copyToAreaId"></s:select>
				</td>
              </tr>	
               <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">认筹类型</td>
                <td >				 				 
				<s:select list="selChipMap" name="chipType"></s:select>
				</td>
              </tr>	
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td colspan="2" width="100%"  align="center">${sug }</td>
               
              </tr>	
			</table>
</form>	
</div>

</body>
</html>