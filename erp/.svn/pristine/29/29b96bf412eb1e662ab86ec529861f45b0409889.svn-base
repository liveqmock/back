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
	<title>erp手机客户跟进</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script>    
    
    <script type="text/javascript" language="javascript">
	
		$().ready(function(e) {
						
        });
	
		$(function () {
		  
		   //初始化日期控件
			var opt = {
				theme: "sense-ui", 
				preset: 'date', //日期
				theme: 'jqm', //皮肤样式
				display: 'modal', //显示方式 
				mode: 'scroller', //日期选择模式
				dateFormat: 'yy-mm-dd', // 日期格式
				setText: '确定', //确认按钮名称
				cancelText: '取消',//取消按钮名籍我
				dateOrder: 'yymmdd', //面板中日期排列格式
				dayText: '日', monthText: '月', yearText: '年', //面板中年月日文字
				endYear:2020 //结束年份
			};
			
			$('input:jqmData(role="datebox")').mobiscroll(opt);
			  
		 });
		  
	  </script>
      
      <script type="text/javascript" language="javascript">
	  		
			function inputCheck(){		
			
				var followDesc = $("#followDesc").val();		
				if(followDesc == ""){	
					alert("跟进内容不能为空");
					return false;
				}
				
				return true;
			}
	  </script>
    
</head>

<body>

<div data-role="page" id="input_follow">

	<form id="follow_form" action="<%=basePath%>m/inputCustomerFollow.action" method="post">

	<div data-role="header" data-theme="b">
        <a href="<%=basePath%>m/search.action" data-icon="back" data-role="button" data-ajax="false">返回</a>
		<h1>客户跟进</h1>                

	</div><!-- /header -->

	<div data-role="content">
    	
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
         	<tr>
            	<td>
                	<font color="red">*</font>跟进类型
                </td>
                
                <td>
                    
                    <s:select list="followTypes" name="customerFollow.followType" id="followType"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>跟进内容
                </td>
                
                <td>       
                    
					<textarea id="followDesc" name="customerFollow.followDesc"></textarea>
                            
                </td>
            </tr>
            
             <tr>
            	<td>
                	跟进日期
                </td>
                
                <td>
                    
                    <input type="text" data-role="datebox" id="createdTime" name="customerFollow.createdTime" value="${nowDate}"/>	
        
                </td>
            </tr>
            
             <tr>
            	<td colspan="2">
                	
                    <input type="hidden" name="customerFollow.customerId" value="${customerId}"/>
                    
                    <button type="submit" value="保存" data-icon="save" data-theme="b" onClick="return inputCheck();"></button>
                	
                </td>
            </tr>
            
         </table>
         
         <s:iterator value="#request.follows" id="c">
         <table data-role="table" data-mode="reflow" class="ui-responsive table-stroke">
              <thead>
                <tr>
                  <th data-priority="1">跟进类型</th>
                  <th data-priority="2">跟进人</th>
                  <th data-priority="3">跟进日期</th>
                  <th data-priority="persist">跟进内容</th>
                </tr>
              </thead>
            
              <tbody>
               
                <tr>
                  <td>${c.descFollowType}</td>    
                  <td>${c.descUserId}</td>
                  <td>${c.followDate}</td>
                   <td>${c.followDesc}</td>
                </tr>
            
              </tbody>
            </table>
            
          	</s:iterator>
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-fullscreen="false" data-position="fixed">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->
    
    </form>
    
</div><!-- /page -->

	
</body>
</html>