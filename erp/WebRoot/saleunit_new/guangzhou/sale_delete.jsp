<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>删除销售</title>

	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	
</head>
	
<body>
<div class="gbox1">			
		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	   
	  <tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:30%" align="center"><b>已选择销售</b>&nbsp;</td>
		<td>(请选择要删除的销售)</td>
	  </tr>
	  
	   <s:iterator value="#request.trList" id="c">  
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
	  
		<td id="t15" style="width:15%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[0].id}" label="${c[0].realName}" name="sale"/></td>
		<td id="t16" style="width:30%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[1].id}" label="${c[1].realName}" name="sale"/></td>
					
	  </tr>	
	  
	  </s:iterator>
</table>
	
</div>


</body>
</html>