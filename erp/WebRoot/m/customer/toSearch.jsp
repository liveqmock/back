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
	<title>erp手机客户查询</title>
    
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
     
</head>

<body>

<div data-role="page" id="input_follow">

	<form id="search_form" action="<%=basePath%>m/search.action?ts=<%=new Date()%>" method="post" data-ajax="false">

	<div data-role="header" data-theme="b">
    	
        <!--
        <a href="<%=basePath%>m/search.action" data-icon="back" data-role="button" data-ajax="false">返回</a>
        -->
        
        <a href="javascript:void(0)" data-icon="back" data-role="button" onClick="window.history.go(-1);">返回</a>
        
		<h1>客户查询</h1>                

	</div><!-- /header -->

	<div data-role="content">
    	
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
         	<tr>
            	<td>
                	手机号码
                </td>
                
                <td>
                   
                   <input type="text" id="searchPhone" name="cusCond.searchPhone" value="${cusCond.searchPhone}"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	客户来源
                </td>
                
                <td>       
                    
					 <s:select list="selCustomerSource"  name="cusCond.customerSource" id="customerSource"/>
                     
                     
                </td>
            </tr>
            
             <tr>
            	<td>
                	客户评级
                </td>
                
                <td>       
                    
					 <s:select list="selRating"  name="cusCond.rating" id="rating"></s:select>
                </td>
            </tr>
            
             <tr>
            	<td>
                	最后跟进日期
                </td>
                
                <td>
                    
                    <input type="text" data-role="datebox" id="followTime1" name="cusCond.followTime1" value="${cusCond.followTime1}"/>

                </td>
            </tr>
            
             <tr>
            	<td>
                	
                </td>
                
                <td>
                    
                    <input type="text" data-role="datebox" id="followTime2" name="cusCond.followTime2" value="${cusCond.followTime2}"/>

                </td>
            </tr>
            
            
            <tr>
            	<td>
                	来访日期
                </td>
                
                <td>
                    
                    <input type="text" data-role="datebox" id="visitDate1" name="cusCond.visitDate1" value="${cusCond.visitDate1}"/>
                    
                </td>
            </tr>
            
             <tr>
            	<td>
                	
                </td>
                
                <td>
                    
                    <input type="text" data-role="datebox" id="visitDate2" name="cusCond.visitDate2" value="${cusCond.visitDate2}"/>

                </td>
            </tr>
            
             <tr>
            	<td colspan="2">
                	
                    <button type="submit" value="查询" data-icon="search" data-theme="b"></button>
                    
                </td>
            </tr>
            
         </table>
         
         
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-fullscreen="false" data-position="fixed">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->
    
    </form>
    
</div><!-- /page -->

	
</body>
</html>