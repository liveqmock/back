<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String tips=(String)request.getAttribute("tips");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>错误提示</title>
<link href="css/style.css" rel="stylesheet">



</head>

<body>

<table width="100%" height="50%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="center" bgcolor="#FFFFFF"><table width="419" height="226" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center" background="images/error.jpg"><table width="388" height="194" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center" bgcolor="#FFFFFF">错误提示信息：  <br>
              <br>
                <%
			   if (tips==null)
			     out.println("<P>非法操作!请稍后再试试!</P>");
			 else
			  {
			    out.println("<P>"+tips+"</P>");
			   }
			%>
              <input name="Submit" type="submit" class="btn_grey" value="返回" onClick="javascript:location.href='<%=basePath%>login.jsp'"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<center>
</center>
<s:include value="customer/bottom_customer.jsp"></s:include>
</body>
</html>
