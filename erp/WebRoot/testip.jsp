<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 13-9-6
  Time: 上午9:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    String ip;
    if (request.getHeader("x-forwarded-for") == null) {
        ip = request.getRemoteAddr();

    } else {
        ip = request.getHeader("x-forwarded-for");
    }
    out.print(ip);
%>
</body>
</html>