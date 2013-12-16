<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html> 
<html>
<head>
	<meta charset="utf-8">
	<title>erp手机修改客户选择问卷</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script>    
    
</head>

<body>

<div data-role="page" id="change_question_page">

	<div data-role="header" data-theme="b">
        <a href="<%=basePath%>m/search.action?p=${currentPage}" data-icon="back" data-role="button" data-ajax="false">返回</a>
		<h1></h1>        
        
	</div><!-- /header -->

	<div data-role="content">
    
    	<form id="to_update_question_form" action="<%=basePath%>m/toModifyQuestion.action" method="get" data-ajax="false">
    	
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
          <tr>
            	<td>
                	<font color="red">*</font>售前问卷选择
                </td>
                
                <td>                	
                    <select name="questionId" id="question" data-inline="false">
                        ${questionSelectOptionHtml}
                    </select>
                    
                    <input type="hidden" name="projectId" value="${projectId}" />
                    <input type="hidden" name="customerId" value="${customerId}"/>
                    
                </td>
            </tr>
            
            <tr>
            	<td colspan="2">               
                        
                     <button type="submit" value="录入/修改问卷" data-icon="check" data-theme="b"></button>
        
                </td>
            </tr>
            
           </table>
           
           </form>
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-fullscreen="false" data-position="fixed">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->
   
    
</div><!-- /page -->
 
	
</body>
</html>