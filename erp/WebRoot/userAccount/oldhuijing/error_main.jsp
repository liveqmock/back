<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%
String tips=(String)request.getAttribute("tips");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>错误提示</title>
<link href="css/style.css" rel="stylesheet">
</head>

<body>
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr bgcolor="#FFFFFF">
    <td align="center"><table width="419" height="226" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center" background="images/error.jpg"><table width="388" height="194" border="0" cellpadding="0" cellspacing="0">
          <tr>
            <td align="center" bordercolor="#FFFFFF" bgcolor="#FFFFFF">&nbsp;&nbsp;<strong>错误提示信息</strong>：  <br>
              <br>
              <font color="red">
                <%
			   if (tips==null)
			     out.println("<P>非法操作!请稍后再试试!</P>");
			 else
			  {
			    out.println("<P>"+tips+"</P>");
			   }
			%>
			</font>
              <input name="Submit" type="submit" class="btn_grey" value="返回" onClick="history.back(-1)"></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<center>
</center>

</body>
</html>
