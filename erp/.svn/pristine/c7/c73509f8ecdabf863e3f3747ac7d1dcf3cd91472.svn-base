<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head><s:include value="include/header.jsp"/>

<script language="javascript" type="text/javascript">
	$().ready(function(){
		$("#quartzSub").click(function(){
			var firstMonitorDay = $("#firstMonitorDay").val();
			if(firstMonitorDay == ""){
				alert("请选择开始时间");
				$("#firstMonitorDay").focus();
				return false;				
			}
			
			var endMonitorDay = $("#endMonitorDay").val();
			if(endMonitorDay == ""){
				alert("请选择结束时间");
				$("#endMonitorDay").focus();
				return false;
			}
			
			if(firstMonitorDay > endMonitorDay){
				alert("开始时间不能大于结束时间");
				return false;
			}
			
		});
		
	});
	
	function clear(){
		setTimeout("document.getElementById('suggestion').innerHTML = ''", 2000);
	}
</script>

<title>priv_func</title>
</head> 
  
<body onload="clear()">
<!-- top -->
<s:include value="include/top.jsp"></s:include>
<!-- top end -->

<!--main-->   
   

<table width="100%" border="0" cellspacing="0">
<tr>

  <!--left begin-->
    <td width="213" valign="top">
	<s:include value="include/left.jsp"/>	
  </td>
  
  
<td width="9" valign="middle">
<img src="<%=basePath%>images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩"/>
</td>
 <!--left.end-->
  
  
	
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
    <div>
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
       <!-- 菜单开始 -->
        <div class="titlebg" style=" height:auto;overflow:hidden;">
		<div class="title02" ><a href="./cache!toCachePage.action" target="_self">系统设置</a></div>
		
 <!--提示begin-->

          <div class="c"></div>
 		  
   <table width="98%" border="0" align="left" cellspacing="0">
	<!-- 蓝色边条begin -->	
		 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
        </tr>
<!-- 蓝色边条end -->		
		
		<form action="cache!cleanCache.action" method="post">
            <tr>
			
              <td height="0" colspan="2">&nbsp;&nbsp;
			    缓存名称:
			    <s:select list="caches" name="cacheName"/>
				<input type="submit" value=" 清理缓存(缓存剩余个数:<s:property value='#request.cacheSize'/>)" id="searchSubmit" />
				<font color="#FF0000"><span id="suggestion"><s:property value="#request.message"/></span></font>
			  </td> 
		  
            
		 </tr>
	 	</form>
		
		<!--
		<form action="quartzAction.action" method="get"> 
            <tr>
			
              <td height="0" colspan="6">
			  	<input class="Wdate" type="text" id="firstMonitorDay" name="firstMonitorDay" style="width: 90px" onClick="WdatePicker()" />
				-
				<input class="Wdate" type="text" id="endMonitorDay" name="endMonitorDay" style="width: 90px" onClick="WdatePicker()" />
				<input type="submit" id="quartzSub" value=" 手工执行定时器 "/>
				(开始的日期不能小于<font color="#FF0000">2011-08-01</font>,结束日期不能大于<font color="#FF0000"><s:property value="#session.quartzDate"/></font>)
			  </td> 
		  
             
		 </tr>
	 	</form>
		-->
		
		
<!-- 列表 end -->
           
            </table>
   
  </div>
        <div class="titler"></div>
        <div class="c"></div>
    </div>
    <div class="right06"></div>
    <div class="c"></div>
    </div>
    <div class="right07"></div>
    <div class="right08"></div>
    <div class="right09"></div>
    <div class="c" ></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
  
</table>
<s:include value="include/bottom.jsp"></s:include>
  </body>
</html>


