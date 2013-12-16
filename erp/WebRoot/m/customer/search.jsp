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
	<title>erp手机查询客户</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script>    
    
    <script type="text/javascript" language="javascript">
		
		//上一页
		function pre(currentPage, pageCount){
			
			if(currentPage <= 1){
				alert("已是第一页");
				return false;
			}
			location.href='<%=basePath%>m/search.action?p=' + (currentPage-1) + '&ts=<%=new Date()%>';
		}
		
		//下一页
		function next(currentPage, pageCount){
			if(currentPage >= pageCount){
				alert("已是最后一页");
				return false;
			}
			location.href='<%=basePath%>m/search.action?p=' + (currentPage+1) + '&ts=<%=new Date()%>';
		}
		
	</script>
    
</head>

<body>

<div data-role="page" id="search_customer">

	<div data-role="header" data-theme="b">
    	<a href="<%=basePath%>m/back.action" data-icon="back" data-role="button" data-ajax="false">返回</a>
		<h1>页数(${currentPage}/${pageCount})</h1>   
        <a href="<%=basePath%>m/toSearch.action" data-icon="search" data-role="button" data-ajax="false">查询</a>
        
        <fieldset class="ui-grid-a">
            <div class="ui-block-a">
            	<button type="button" data-theme="d" onClick="return pre(${currentPage}, ${pageCount});">
                上一页(${currentPage <= 1 ? 1 : currentPage-1})
                </button>
            </div>
            
            <div class="ui-block-b">
            	<button type="button" data-theme="a" onClick="return next(${currentPage}, ${pageCount});">
                下一页(${currentPage >= pageCount ? pageCount : currentPage+1})
                </button>
            </div>
        </fieldset>
       

	</div><!-- /header -->

	<div data-role="content">
    	
         <s:iterator value="#request.cusList" id="c">
        
            <div class="ui-grid-b">
                <div class="ui-block-a">
                	<div class="ui-body ui-body-d" style="height:30px; padding:12px 0px 0px 0px">
                    <a href="<%=basePath%>m/toUpdate.action?id=${c.id}&currentPage=${currentPage}&ts=<%=new Date()%>" data-ajax="false">${c.customerName}</a>
	                </div>
                </div>
                
                <div class="ui-block-b">
                	<div class="ui-body ui-body-d" style="height:30px; text-align:left; padding:12px 0px 0px 0px">
                        
                        <s:if test="#c.isCanShowCustomerPhone">
                        
                        ${c.phone}
                        
                        </s:if>
                        
                        <s:else>
							***
                        </s:else>
                    
                	</div>
                </div>
                
                <div class="ui-block-c">
                	<div class="ui-body ui-body-d" style="height:30px; text-align:center; padding:12px 0px 0px 0px">
                    
                    <a href="<%=basePath%>m/toFollow.action?customerId=${c.id}&ts=<%=new Date()%>" data-ajax="false">跟进</a>
                    
                	</div>
                </div>
            </div>
        
         </s:iterator>    
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-fullscreen="false" data-position="fixed">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->    
    
</div><!-- /page -->

	
</body>
</html>