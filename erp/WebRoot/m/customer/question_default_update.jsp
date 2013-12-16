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
	<title>基本问卷</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script>    
    
</head>

<body>

<div data-role="page" id="modify_default_question" data-ajax="false">

	<form id="modify_default_question_form" action="<%=basePath%>m/modifyDefaultQuestion.action" method="post">

	<div data-role="header" data-theme="b">
    	<a href="javascript:void(0)" data-icon="back" data-role="button" onClick="window.history.go(-1);">返回</a>
            
	  	<h1>基本问卷</h1>
        
	</div><!-- /header -->

	<div data-role="content">
    	
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
         	<tr>
            	<td>
                	来访次数
                </td>
                
                <td>
                    
                   <s:select list="selVisitCount"  name="customer.visitCount"/>	
                   
                   <input type="hidden" name="customer.id" value="${customer.id}"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	性别
                </td>
                
                <td> 
                <s:select list="selGender"  name="customer.gender" />	
                </td>
            </tr>
            
            <tr>
            	<td>
                	国籍
              </td>
                
                <td>                	
                    
                   <input type="text" name="customer.nationality" id="nationality"  value="${customer.nationality}"/>
        
                </td>
            </tr>
           
           
             <tr>
            	<td>
                	身份证号码
                </td>
                
                <td>                	
                   <input type="text" name="customer.idcardNo" id="idcardNo" value="${customer.idcardNo}"/>
        
                </td>
            </tr>
            
             <tr>
            	<td>
                	驾车车型
                </td>
                
                <td>                	
                    <input type="text" name="customer.trafficDesc" id="trafficDesc"  value="${customer.trafficDesc}"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	年龄
                </td>
                
                <td>
                    
                    <s:select list="selAgeRange"  name="customer.age" />	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	地址
                </td>
                
                <td>                	
               
                <textarea data-mini="true" cols="40" rows="8" name="customer.address" id="address">${customer.address}</textarea>
               
                </td>
            </tr>
            
            <tr>
            	<td>
                	邮编
                </td>
                
                <td>                	
                    <input type="text" name="customer.postcode" id="postcode"  value="${customer.postcode}"/>	                    
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	家庭结构
                </td>
                
                <td>                	
                    <s:select list="selFamilyType"  name="customer.familyType" />	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	家庭收入
                </td>
                
                <td>                	
                    <s:select list="selFamilyIncome"  name="customer.familyIncome" />	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	行业分类
                </td>
                
                <td>                	
                    <s:select list="selJobType"  name="customer.jobType" />	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	职业
                </td>
                
                <td>                	
                  <s:select list="selJobIndustry"  name="customer.jobIndustry" />			
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	购买单元1
                </td>
                
                <td>                	
                   <input type="text" id="intentUnit1" name="customer.intentUnit1" value="${customer.intentUnit1}"/>
                </td>
            </tr>
            
            <tr>
            	<td>
                	购买单元2
                </td>
                
                <td>                	
                   <input type="text" id="intentUnit2" name="customer.intentUnit2" value="${customer.intentUnit2}"/>
                </td>
            </tr>
            
             <tr>
            	<td>
                	购房目的
                </td>
                
                <td>                	
                    <s:select list="selBuyAim"  name="customer.buyAim" />
                </td>
            </tr>
            
             <tr>
            	<td>
                	付款方式
                </td>
                
                <td>                	
                    <s:select list="selPayType"  name="customer.payType" />	
                    
                </td>
            </tr>
            
             <tr>
            	<td>
                	意向套数
                </td>
                
                <td>                	
                   <s:select list="selIntentBuynum"  name="customer.intentBuynum" />	
                </td>
            </tr>
            
             <tr>
            	<td>
                	意向户型
                </td>
                
                <td>                	
                  <s:select list="selRoomType"  name="customer.roomType" />	
                </td>
            </tr>
            
             <tr>
            	<td>
                	认知途径
                </td>
                
                <td>         
                
                	 <fieldset data-role="controlgroup">
                        ${knownFromSelectOptionHtml}
   					 </fieldset>     
                 
                </td>
            </tr>
            
             <tr>
            	<td>
                	关注点
                </td>
                
                <td>             
                	
                    <fieldset data-role="controlgroup">
                         ${customerFocusSelectOptionHtml}                 
   					 </fieldset>     
                  
                </td>
            </tr>
            
             <tr>
            	<td>
                	未能成交原因
                </td>
                
                <td>                	
                     <textarea data-mini="true" cols="40" rows="8" name="customer.notBuyReson" id="notBuyReson">${customer.notBuyReson}</textarea>		
                </td>
            </tr>
            
             <tr>
            	<td>
                	备注
                </td>
                
                <td>                	
                   <textarea data-mini="true" cols="40" rows="8" name="customer.remark1" id="remark1">${customer.remark1}</textarea>	
                </td>
            </tr>
            
             <tr>
            	<td colspan="2">
                	
                   <button type="submit" value="保存" data-icon="save" data-theme="b"></button>
                	
                </td>
            </tr>
                        
         </table>
        
    </div><!-- /content -->

	<!-- data-position="fixed",把顶部或底部固定; data-fullscreen="true",是否全屏,也是点上去是否隐藏顶部及底部-->
	<div data-role="footer" data-theme="b" data-fullscreen="false">
		<h4>Copyright ©2013合富辉煌 版权所有</h4>
	</div><!-- /footer -->
    
    </form>
    
</div><!-- /page -->
 
	
</body>
</html>