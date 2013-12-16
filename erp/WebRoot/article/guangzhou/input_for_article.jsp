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

	<base href="<%=basePath%>">
    <s:include value="../../customer/guangzhou/header.jsp"></s:include>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script charset="utf-8" src="<%=basePath%>js/editor/kindeditor.js"></script>
    <script charset="utf-8" src="<%=basePath%>js/editor/kindeditor-upload.js"></script>
    <script charset="utf-8" src="<%=basePath%>js/editor/lang/zh_CN.js"></script>
	<!-- 项目多选 -->
	<script language="javascript" type="text/javascript" src="./js/project.list.utils.js?v=1.2"></script>
    <script>
        $(function() {
            createKindEditorIncludeUpload("article.content");
        });
        
        $(document).ready(function(){
            bindCompanyForXKZXOnly("companyName", "companyID"); //单个公司的选择(单选)
        });
        
    </script>

    <title>录入通告</title>

</head>
<body>

     <form class="registerform" id ="inputform" action="./customer_guangzhou/article/input.action" method="post" >
         <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox"  >
         
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
             <td width="100" align="center" id="t15"  >指定公司</td>
             <td  colspan="3">
                 &nbsp;				
					<input type="text" id="companyName" value="" />
					<input type="hidden" id="companyID" name="article.companyId" value="" />(如果不选择，则所有公司都能够查看)
             </td>
             </tr>
         
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
             <td width="100" align="center" id="t15"  >文章类型</td>
             <td  colspan="3">
                 &nbsp;
                 <select name="article.articleType">
                     <option value="1">系统公告</option>
                     <option value="2">更新公告</option>
                 </select>
             </td>
             </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
             <td width="100" align="center" id="t15"  nowrap="nowrap">标题</td>
             <td width="191"  id="t16" colspan="3">
                 &nbsp;
                 <input type="text"  id="title"  name="article.title" style="width: 70%"/></td>
             </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
             <td width="100" align="center" id="t15"   >摘要</td>

             <td   id="t16" colspan="3">
                 &nbsp;
                 <input type="text"  id="summary"  name="article.summary" style="width: 70%"/>
                 </td>
             </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; >
             <td colspan="4" align="left"><textarea name="article.content" style="width:98%;height:400px;"></textarea>
             </td>
             </tr>
         </table>
     </form>

</body>
</html>
