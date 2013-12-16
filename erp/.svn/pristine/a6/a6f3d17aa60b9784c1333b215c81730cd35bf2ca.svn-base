<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>售前客户统计 </title>
		<s:include value="header_report.jsp"></s:include>
		
		<script type="text/javascript">
						
			$().ready(function(){				
				//页面加载时执行
				projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			});
				
				
			function submitSearch(){
				$("#thisForm").submit();	
			}
		</script>	
</head>
<body style="padding:0px;background:white;">

<div class="right99"></div>				
  	<form class="registerform" id="thisForm"  method="post">
	 <table width="100%" border="0" align="left" cellspacing="0">	 
       
		<tr>
     	<td colspan="6">	
     	<label>&nbsp;<span>项目</span></label><input type="text" id="projectName" name="projectName" value="${projectName}"/>
     	<input type="hidden" id="hiddenId" name="customerCond.projectId" value="${customerCond.projectId}" />		
		日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="customerCond.date1" value="${customerCond.date1}"/>
		-
		<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="customerCond.date2" value="${customerCond.date2}"/>		
		
		&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
		
        <div class="right99"></div>	
	     <div class="blueline"></div>	 
		</td>
	   </tr>  
		  
		<!-- 搜索表单 end -->
					
			<!-- 说明：左侧纵向数据来源于调查表内容，调查表各个项目的都不一样，是变量，横向为定量 -->
            <tr>
              <td colspan="6">			  
			  
			  	<div class="gbox1">	
				<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">   
 <tr style="background-image: url(/erp/images/tianluan/gboxbg.gif);">
  <td></td>
  <td></td>
  <td>现<br/>场<br/>来<br/>访<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>老<br/>客<br/>来<br/>访<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>外<br/>展<br/>来<br/>访<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>来<br/>电<br/>统<br/>计<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>房<br/>展<br/>会<br/>来<br/>访<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>兼<br/>职<br/>派<br/>单<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>电<br/>话<br/>回<br/>访<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>活<br/>动<br/>统<br/>计<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>电<br/>转<br/>访<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>陌<br/>生<br/>拜<br/>访<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>电<br/>话<br/>CALL<br/>客<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>入<br/>会<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>诚<br/>意<br/>金<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td>成<br/>交<br/>量</td>
  <td>百<br/>分<br/>比</td>
  <td></td>
 </tr>
 
 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>　</td>
  <td>总计</td>
  <td>206</td>
  <td>　</td>
  <td>27</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>#</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>4</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>#</td>
  <td>　</td>
  <td>10</td>
  <td>　</td>
  <td></td>
 </tr>
 
 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td rowspan=6>年龄</td>
  <td>25以下</td>
  <td>2</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td></td>
 </tr>
 
 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>25-30</td>
  <td>35</td>
  <td>　</td>
  <td>4</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>6</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>3</td>
  <td>　</td>
  <td>2</td>
  <td>　</td>
  <td></td>
 </tr>
 
 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>31-35</td>
  <td>46</td>
  <td>　</td>
  <td>4</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>5</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td></td>
 </tr>
 
 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>36-40<br></td>
  <td>22</td>
  <td>　</td>
  <td>2</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>5</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>6</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td></td>
 </tr>
 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>41-45<br></td>
  <td>23</td>
  <td>　</td>
  <td>4</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>2</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>1</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td >#</td>
  <td>　</td>
  <td>1</td>
  <td >　</td>
  <td></td>
 </tr>
 
 <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td>46或以上</td>
  <td>19</td>
  <td>　</td>
  <td>3</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>0</td>
  <td>　</td>
  <td>#</td>
  <td>　</td>
  <td>4</td>
  <td>　</td>
  <td></td>
 </tr>
</table>
			</div>


			</td>
            </tr>
			
 </table>

</form>


   

</body>
</html>