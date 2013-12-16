<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../customer/guangzhou/header.jsp"></s:include>	
		<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	
		
		<title>号码归属地</title>
		<script language="javascript" type="text/javascript">
		
			function clear(){
				setTimeout("document.getElementById('suggestion').innerHTML = ''", 2000);
			}
		</script>
	</head>
	
	<body>
	
<%--固定的上部 --%>

<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title02"><a href="./customer/phone_from/to.action" target="_self">号码归属地</a></div>	

<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>
	
	 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
	 
	 <form action="./customer/phone_from/getCustomerBySql.action" method="post">
	 	 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td height="30px" colspan="3">
				<textarea style="height: 200px; width: 66%;" name="sql"></textarea>
				<input type="submit" value="  查询  " />
			</td>
		</tr>
	</form>
	
		 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td height="30px" colspan="3"><font color="#FF0000"><span id="suggestion"><s:property value="#request.message"/></span></font></td>
		</tr>
		
		<s:iterator value="#request.showCaches" id="c">  
					
		 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td>
				${showCacheName}
			</td>
			<td>
				${c[1]}
			</td>
			<td>
				${c[2]}
			</td>
		</tr>
		
		</s:iterator>
			
	</table>	
		
<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>


