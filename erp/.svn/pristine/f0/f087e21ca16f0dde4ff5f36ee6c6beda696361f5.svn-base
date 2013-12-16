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
	<title>自定义问卷</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script>        
    
</head>

<body>

<div data-role="page" id="input_own_question">

	<form id="input_own_question_form" action="<%=basePath%>m/addOwnQuestion.action" method="post">

	<div data-role="header" data-theme="b">        
       <a href="<%=basePath%>m/toChangeQuestion.action?customerId=${customerId}&ts=<%=new Date()%>" data-icon="back" data-role="button" data-ajax="false">返回</a>
        
	  <h1>自定义问卷</h1>
        
	</div><!-- /header -->

	<div data-role="content">
    	
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
         
          <s:iterator value="#request.topicList" id="c">
         
         	<tr>
            	<td style="width:50%">
                	<s:if test="#c.isRequired">
                        <font color="red">*</font>
                    </s:if> 
                    ${c.topicName}
                </td>
                
                <td>                    
                  	${c.inputAndOtherHtmlForMobile}
                </td>
            </tr>
            
           </s:iterator>
           
            <tr>
            	<td colspan="2">
                	                   
                   <input type="hidden" name="customerId" value="${customerId}"/>
                   <input type="hidden" name="questionId" value="${questionId}"/>  
                   <input type="hidden" name="projectId" value="${projectId}"/>                    
                   
                   <button type="submit" value="保存" data-icon="save" data-theme="b"></button>
                	
                </td>
            </tr>
            
         </table>
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-position="fixed" data-fullscreen="false">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->
    
     </form>
    
</div><!-- /page -->   
 
	
</body>
</html>