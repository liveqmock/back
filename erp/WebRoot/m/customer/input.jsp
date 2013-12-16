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
	<title>erp手机录入客户</title>
    
    <base href="<%=basePath%>"/>
    
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    
    <link rel="stylesheet" href="./m/js/jquery.mobile-1.3.1.min.css"/>    
    <link rel="stylesheet" href="./m/css/mobiscroll.custom-2.5.0.min.css"/>
    
	<script type="text/javascript" language="javascript" src="./m/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/jquery.mobile-1.3.1.min.js"></script>
	<script type="text/javascript" language="javascript" src="./m/js/mobiscroll.js"></script>    
    
    <script type="text/javascript" language="javascript">
	
		$().ready(function(e) {
			
			//居住区域中的省份
			$("#homeProvince").on("change", function(){
				
				$.ajax({
					type:"get",
					url: "./customer_guangzhou/search/proviToCity.action",  
					data: "provinceId=" + this.value,
					dataType: "html",
					success: function(data){
						$("#homeCity").empty();
						$("#homeCity").append(data);
						
						$("#homeCity").val("");						
						$("#homeCity").prev(".ui-btn-inner").find('.ui-btn-text span').html("请选择");
						
						$("#homeRegion").empty();
						$("#homeRegion").append("<option value=''>请选择</option>");
						
						$("#homeRegion").val("");						
						$("#homeRegion").prev(".ui-btn-inner").find('.ui-btn-text span').html("请选择");
						
					}
				});
				
			});
			
			//居住区域中的城市
			$("#homeCity").on("change", function(){
				
				$.ajax({
					type:"get",
					url: "./customer_guangzhou/search/cityToRegion.action",  
					data: "cityId=" + this.value,
					dataType: "html",
					success: function(data){
						$("#homeRegion").empty();
						$("#homeRegion").append(data);
						
						$("#homeRegion").val("");						
						$("#homeRegion").prev(".ui-btn-inner").find('.ui-btn-text span').html("请选择");
						
					}
				});
				
			});			
			
			//工作区域中的省份
			$("#workProvince").on("change", function(){
				
				$.ajax({
					type:"get",
					url: "./customer_guangzhou/search/proviToCity.action",  
					data: "provinceId=" + this.value,
					dataType: "html",
					success: function(data){
						$("#workCity").empty();
						$("#workCity").append(data);
						
						$("#workCity").val("");						
						$("#workCity").prev(".ui-btn-inner").find('.ui-btn-text span').html("请选择");
						
						$("#workRegion").empty();
						$("#workRegion").append("<option value=''>请选择</option>");
						
						$("#workRegion").val("");						
						$("#workRegion").prev(".ui-btn-inner").find('.ui-btn-text span').html("请选择");
						
					}
				});
				
			});
			
			//工作区域中的城市
			$("#workCity").on("change", function(){
				
				$.ajax({
					type:"get",
					url: "./customer_guangzhou/search/cityToRegion.action",  
					data: "cityId=" + this.value,
					dataType: "html",
					success: function(data){
						$("#workRegion").empty();
						$("#workRegion").append(data);
						
						$("#workRegion").val("");						
						$("#workRegion").prev(".ui-btn-inner").find('.ui-btn-text span').html("请选择");
						
					}
				});
				
			});			
			
			//项目-->客户评级,默认的省份,城市(暂时不加)
			$("#projectId").on("change", function(){
				
				$.ajax({
					type:"get",
					url: "./customer_guangzhou/search/getSelRatingByProjectId.action",  
					data: "projectId=" + this.value,
					dataType: "html",
					success: function(data){
						$("#rating").empty();
						$("#rating").append(data);
						
						$("#rating").val("");						
						$("#rating").prev(".ui-btn-inner").find('.ui-btn-text span').html("请选择");
						
					}
				});
				
				//$("#homeProvince").val(20);
				
			});
			
						
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
				
				var customerSource = $("#customerSource").val();
				if(customerSource == ""){
					alert("客户来源不能为空");
					$("#customerSource").focus();
					return false;
				}
				
				var customerName = $("#customerName").val();
				if(customerName == ""){
					alert("客户姓名不能为空");
					$("#customerName").focus();
					return false;
				}

				 //移动电话,固定电话可以只填一个
				var phone = $("#phone").val();
				if(phone != "" && phone.match("^\\d*$|^\\d*-\\d*$") == null){
					alert("移动电话不合规则");
					$("#phone").val("");
					$("#phone").focus();
					return false;
				}
			
				var homePhone = $("#homePhone").val();
				if(homePhone != "" && homePhone.match("^\\d*$|^\\d*-\\d*$") == null){
					alert("固定电话不合规则");
					$("#homePhone").val("");
					$("#homePhone").focus();
					return false;
				}
			
				if(phone == "" && homePhone == ""){
					alert("移动电话,固定电话至少要填写一个");
					$("#phone").focus();
					return false;
				}
				
				// priceNum areaNum 如果不为空,那么就要为数字
				var priceNum = $.trim($("#priceNum").val());
				if(priceNum != "" && isNaN(priceNum)){
					alert("意向总价只能为数值");
					$("#priceNum").focus();
					return false;
				}
				
				var areaNum = $.trim($("#areaNum").val());
				if(areaNum != "" && isNaN(areaNum)){
					alert("意向面积只能为数值");
					$("#areaNum").focus();
					return false;
				}
				
				if("${isZhongShan}" == "true"){
					return zsCheck();
				}
				
				return true;
			}
			
			//中山公司的验证
			function zsCheck(){
				
				//来访日期
				var visitDate = $("#visitDate").val();
				if(visitDate == ""){
					alert("来访日期不能为空");
					$($("#visitDate").datebox("getText")).focus();
					return false;
				}
				
				//居住区域,工作区域至少有一个选到区域
				var homeRegion = $("#homeRegion").val();
				var workRegion = $("#workRegion").val();				
				if(homeRegion == "" && workRegion == ""){
					alert("居住区域,工作区域至少有一个选到区域");
					return false;
				}
				
				var buyUse = $("#buyUse").val();
				if(buyUse == ""){
					alert("购房用途不能为空");
					$("#buyUse").focus();
					return false;
				}
				
				var buyCount = $("#buyCount").val();
				if(buyCount == ""){
					alert("置业次数不能为空");
					$("#buyCount").focus();
					return false;
				}
				
				var priceNum = $("#priceNum").val();
				if(priceNum == ""){
					alert("意向总价不能为空");
					$("#priceNum").focus();
					return false;
				}
				
				var houseType = $("#houseType").val();
				if(houseType == ""){
					alert("产品类型不能为空");
					$("#houseType").focus();
					return false;
				}
				
				var areaNum = $("#areaNum").val();
				if(areaNum == ""){
					alert("意向面积不能为空");
					$("#areaNum").focus();
					return false;
				}			
			}
			
	  </script>
    
</head>

<body>

<div data-role="page" id="input_customer">

	<form id="common_form" action="<%=basePath%>m/inputCustomer.action" method="post">

	<div data-role="header" data-theme="b">
        <a href="<%=basePath%>m/back.action" data-icon="back" data-role="button" data-ajax="false">返回</a>
		<h1>新增基本信息</h1>                

	</div><!-- /header -->

	<div data-role="content">
    	
         <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" style="text-align:center">
         	<tr>
            	<td>
                	<font color="red">*</font>项目
                </td>
                
                <td>
                    
                    <s:select list="projectList" listKey="id" listValue="projectName"
                    	name="customer.projectId" value="#session.loginAccount.projectId" id="projectId"/>
        
                </td>
            </tr>
            
              <tr>
            	<td>
                	<font color="red">*</font>客户来源
                </td>
                
                <td>                	
                   <s:select list="selCustomerSource"  name="customer.customerSource" id="customerSource"/>		
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>客户姓名
                </td>
                
                <td> <input type="text" name="customer.customerName" id="customerName" maxlength="10" /></td>
            </tr>
            
             <tr>
            	<td>
                	<font color="red">*</font>移动电话
                </td>
                
                <td>                	
                    <input name="customer.phone" id="phone"/>	
        
                </td>
            </tr>
            
            
            
             <tr>
            	<td>
                	<font color="red">*</font>固定电话
                </td>
                
                <td>                	
                    <input type="text" name="customer.homePhone" id="homePhone"/>	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	客户评级
              </td>
                
                <td>                	
                    
                     <s:select list="selRating"  name="customer.rating" id="rating"/>	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>来访日期
                </td>
                
                <td>                	
                    <input type="text" data-role="datebox" id="visitDate" name="customer.visitDate" value="${nowDate}"/>	        
                </td>
            </tr>
            
             <tr>
            	<td>
                	<font color="red">*</font>居住区域
                </td>
                
                <td>
                    
                     <s:select list="selProvince"  name="customer.homeProvince" id="homeProvince" value="#request.project.provinceId"/>	
                     
                     <s:select list="selHomeCity"  name="customer.homeCity" id="homeCity" value="#request.project.cityId"/>	
                     
                     <s:select list="selHomeRegion"  name="customer.homeRegion" id="homeRegion"/>	
                                       
	                  <input type="text" name="customer.homeContent" id="homeContent"/>	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>工作区域
                </td>
                
                <td>                	
                
                 <s:select list="selProvince"  name="customer.workProvince" id="workProvince" value="#request.project.provinceId"/>	
                     
                 <s:select list="selWorkCity"  name="customer.workCity" id="workCity" value="#request.project.cityId"/>	
                 
                 <s:select list="selWorkRegion"  name="customer.workRegion" id="workRegion"/>	
                                   
                  <input type="text" name="customer.workContent" id="workContent"/>	
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>购房用途
                </td>
                
                <td>                	
                    <s:select list="selBuyUse"  name="customer.buyUse" id="buyUse"/>	                    
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>置业次数
                </td>
                
                <td>                	
                    <s:select list="selBuyCount"  name="customer.buyCount" id="buyCount"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>意向总价(万)
                </td>
                
                <td>                	
                    <input type="text" name="customer.priceNum" id="priceNum"/>
        
                </td>
            </tr>
            
            <tr>
            	<td>
                	<font color="red">*</font>产品类型
                </td>
                
                <td>                	
                    <s:select list="selHouseType"  name="customer.houseType" id="houseType"/>	
        
                </td>
            </tr>
            
            
            <tr>
            	<td>
                	<font color="red">*</font>意向面积(㎡)
                </td>
                
                <td>                	
                   <input type="text" name="customer.areaNum" id="areaNum"/>     
                </td>
            </tr>
            
             <tr>
            	<td colspan="2">
                	
                    <button type="submit" value="保存" data-icon="save" data-theme="b" onClick="return inputCheck();"></button>
                	
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