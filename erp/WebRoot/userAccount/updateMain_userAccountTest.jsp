<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>inputMain</title>
    
	<link href="../css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" />
	


  </head>
  
  <body>
   
   
<form action="user/updateUserAccount.action" method="post">
	
		name	<input type="text" name="userAccount.userName" 
					value="<s:property value='#session.tempUser.userName'/>"/>
		password	<input type="text" name="userAccount.userPwd" 
					value="<s:property value='#session.temUser.userPwd'/>"/><b/>
		
		company <input type="text" name="userAccount.companyId"
					 value="<s:property value='#session.tempUser.companyId'/>"/>
		isdeleted<input type="text" name="userAccount.isDeleted" 
					value="<s:property value='#session.tempUser.isDeleted'/>"/>
		
		<input type="submit" value="submit"/>
		
	
	
	</form>
	<!-- right form end-->
	
	
  </tr>
   
</table>

<!--main.end-->
   
   
  </body>
</html>
