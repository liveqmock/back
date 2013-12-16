<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="p" uri="/WEB-INF/property.tld"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>对数</title>
	
	<base href="<%=basePath%>">
	
	<s:include value="../../customer/guangzhou/header_min.jsp"/>
	<script type="text/javascript" language="javascript" src="./js/sale_unit.js"></script>	 
	
	<script type="text/javascript" language="javascript">
	
		$(document).ready(function(){
		
			/**
			propertyProjectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
			getBuildListFromPropertyIdForAuto("buildName", "hiddenId", "hiddenBulidId");  //根据楼盘项目id,获取对应的楼栋联想提
			
			//项目id有变化,要清空楼栋的值与id
			$("#projectName").change(function(){
				$("#buildName").val("");
				//$("#hiddenBulidId").html("");
				$("#hiddenBulidId").attr("value", ""); 				
			});
			**/
			
			saleUnitBind("projectName", "projectHiddenId", "areaId", "buildId");	
		
		});
		
		function download(){
			window.location.href = "./saleunit_new/appoint/guangzhou/download.action";
		}
		
		
	</script>
	
	
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	
  </head>
  
 <body>

	
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c"></div>	
		  
	<table style="width: 100%;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/saleunit/confirm/guangzhou/confirmInputFirst.action" method="post" >
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:26px">

    <td align="center" valign="middle" width="190">楼盘项目</td>
	
	<td width="277" align="left" valign="middle">
		
		<p:project id="projectName" name="buildCond.propertyName" value="${buildCond.propertyName}"
		 hiddenId="projectHiddenId" hiddenName="buildCond.propertyId" hiddenValue="${buildCond.propertyId}"/>
	
	</td>
	
   <td align="center" valign="middle" width="229">
   楼盘分区	</td>
	
     <td width="238" align="left" valign="middle">
	
	<p:area id="areaId" name="buildCond.areaId" value="${buildCond.areaId}" relyValue="${buildCond.propertyId}"/>

	 </td>
	
   <td align="center" valign="middle" width="229">
   楼盘楼栋	</td>
	
	 <td width="241" align="left" valign="middle">
	
	<p:build id="buildId" name="buildCond.buildId" value="${buildCond.buildId}" relyValue="${buildCond.areaId}"/>
	 </td>
	 
  </tr>
  
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:26px">

    <td align="center" valign="middle" width="190">单价</td>
	
	<td width="277" align="left" valign="middle">
		
		<input type="text"  />
	
	</td>
	
   <td align="center" valign="middle" width="229">
   总价	</td>
	
     <td width="238" align="left" valign="middle">
	
	<input type="text"  />

	 </td>
	 
	  <td align="center" valign="middle" width="229">
   	面积	</td>
	
	 <td width="241" align="left" valign="middle">	
	<input type="text"  />
	 </td>
	
  
	 
  </tr>
  
  
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  
  	 <td align="center" valign="middle" width="190">
   	对数日期	</td>
	
	 <td width="277" align="left" valign="middle">	
	<input class="Wdate" type="text" id="date1" style="width:90px" name="searchCond.date1" value=""/>
	-
	<input class="Wdate" type="text" id="date2" style="width:90px" name="searchCond.date2" value=""/>
	 </td>
	 
	  <td align="center" valign="middle" width="229">
   	组团	</td>
	
	 <td width="238" align="left" valign="middle">	
	<input type="text"  />
	 </td>

    <td align="center" valign="middle" width="229">
		<input type="submit" value="  搜索  " id="searchSubmit"/>
	</td>
	
	<td width="241" align="left" valign="middle">
		<input type="button" value="  对数下载  " id="downCheckUp" onclick='window.location.href = "./saleunit_new/appoint/guangzhou/download.action"'/>
	</td>
	
  	 
  </tr>
  
  </table>

			
			
		  </td>
		  </tr>
			
		</form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
            </tr>		
		
			 <tr>
              <td height="20" colspan="6">
				<div id="load"></div>
				
				</td>
            </tr>
			
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    	
	 <td width="100" align="center" valign="middle">
		楼盘项目
	</td>
	
	 <td width="100" align="center" valign="middle">
		楼盘分区
	</td>
		
     <td width="100" align="center" valign="middle">
		楼盘楼栋
	</td>
	
	 <td width="100" align="center" valign="middle">
		房号
	</td>
	
	<td width="100" align="center" valign="middle">
		客户
	</td>
	
	 <td width="100" align="center" valign="middle">
		单价
	</td>
	
	 <td width="100" align="center" valign="middle">
		面积
	</td>
	
	 <td width="100" align="center" valign="middle">
		总价
	</td>
	
	 <td width="100" align="center" valign="middle">
		是否对数
	</td>
	
	 <td width="100" align="center" valign="middle">
		对数日期
	</td>
	
	 <td width="50" align="center" valign="middle">
		操作
	</td>
      
  </tr>
 
 
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			金域蓝湾
		</td>
		
		<td align="center" valign="middle">
			东区A8 
		</td>
		
		<td align="center" valign="middle">
			1单元
		</td>
		
		<td align="center" valign="middle">
			C1-1
		</td>
		
		<td align="center" valign="middle">
			林小姐
		</td>
		
		<td align="center" valign="middle">
			10000
		</td>
		
		<td align="center" valign="middle">
			200
		</td>
		
		<td align="center" valign="middle">
			1000000
		</td>
		
		<td align="center" valign="middle">
			是
		</td>
		
		<td align="center" valign="middle">
			2012-07-01
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			金域蓝湾
		</td>
		
		<td align="center" valign="middle">
			东区C4
		</td>
		
		<td align="center" valign="middle">
			3单元
		</td>
		
		<td align="center" valign="middle">
			C1-3
		</td>
		
		<td align="center" valign="middle">
			马生
		</td>
		
		<td align="center" valign="middle">
			14000
		</td>
		
		<td align="center" valign="middle">
			180
		</td>
		
		<td align="center" valign="middle">
			1500000
		</td>
		
		<td align="center" valign="middle">
			是
		</td>
		
		<td align="center" valign="middle">
			2012-07-01
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			金域蓝湾
		</td>
		
		<td align="center" valign="middle">
			西区B6
		</td>
		
		<td align="center" valign="middle">
			4单元
		</td>
		
		<td align="center" valign="middle">
			B1-1
		</td>
		
		<td align="center" valign="middle">
			邓生
		</td>
		
		<td align="center" valign="middle">
			25000
		</td>
		
		<td align="center" valign="middle">
			220
		</td>
		
		<td align="center" valign="middle">
			2400000
		</td>
		
		<td align="center" valign="middle">
			是
		</td>
		
		<td align="center" valign="middle">
			2012-07-01
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			轩逸荟
		</td>
		
		<td align="center" valign="middle">
			逸荟园 
		</td>
		
		<td align="center" valign="middle">
			1单元
		</td>
		
		<td align="center" valign="middle">
			C9-1
		</td>
		
		<td align="center" valign="middle">
			汪小姐
		</td>
		
		<td align="center" valign="middle">
			17000
		</td>
		
		<td align="center" valign="middle">
			198
		</td>
		
		<td align="center" valign="middle">
			2500000
		</td>
		
		<td align="center" valign="middle">
			<font color="#FF0000">否</font>
		</td>
		
		<td align="center" valign="middle">
			
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			轩逸荟
		</td>
		
		<td align="center" valign="middle">
			逸荟园
		</td>
		
		<td align="center" valign="middle">
			A座 
		</td>
		
		<td align="center" valign="middle">
			C1-4
		</td>
		
		<td align="center" valign="middle">欧阳生</td>
		
		<td align="center" valign="middle">
			12500
		</td>
		
		<td align="center" valign="middle">
			180
		</td>
		
		<td align="center" valign="middle">
			4200000
		</td>
		
		<td align="center" valign="middle">
			是
		</td>
		
		<td align="center" valign="middle">
			2012-07-01
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			轩逸荟
		</td>
		
		<td align="center" valign="middle">
			西区C8 
		</td>
		
		<td align="center" valign="middle">
			B座 
		</td>
		
		<td align="center" valign="middle">
			A4-1
		</td>
		
		<td align="center" valign="middle">邓生</td>
		
		<td align="center" valign="middle">
			15200
		</td>
		
		<td align="center" valign="middle">
			195
		</td>
		
		<td align="center" valign="middle">
			1300000
		</td>
		
		<td align="center" valign="middle">
			<font color="#FF0000">否</font>
		</td>
		
		<td align="center" valign="middle">
			
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			力迅时光里
		</td>
		
		<td align="center" valign="middle">
			东区A8 
		</td>
		
		<td align="center" valign="middle">
			A座 
		</td>
		
		<td align="center" valign="middle">
			D3-1
		</td>
		
		<td align="center" valign="middle">林小姐</td>
		
		<td align="center" valign="middle">
			11500
		</td>
		
		<td align="center" valign="middle">
			180
		</td>
		
		<td align="center" valign="middle">
			2500000
		</td>
		
		<td align="center" valign="middle">
			是
		</td>
		
		<td align="center" valign="middle">
			2012-07-01
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			力迅时光里
		</td>
		
		<td align="center" valign="middle">
			东区D4
		</td>
		
		<td align="center" valign="middle">
			A座 
		</td>
		
		<td align="center" valign="middle">
			A10-4
		</td>
		
		<td align="center" valign="middle">马生</td>
		
		<td align="center" valign="middle">
			13500
		</td>
		
		<td align="center" valign="middle">
			200
		</td>
		
		<td align="center" valign="middle">
			3500000
		</td>
		
		<td align="center" valign="middle">
			是
		</td>
		
		<td align="center" valign="middle">
			2012-07-01
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			汇悦台
		</td>
		
		<td align="center" valign="middle">
			北区C8 
		</td>
		
		<td align="center" valign="middle">
			C座
		</td>
		
		<td align="center" valign="middle">
			C11-1
		</td>
		
		<td align="center" valign="middle">邓生</td>
		
		<td align="center" valign="middle">
			12500
		</td>
		
		<td align="center" valign="middle">
			240
		</td>
		
		<td align="center" valign="middle">
			4500000
		</td>
		
		<td align="center" valign="middle">
			<font color="#FF0000">否</font>
		</td>
		
		<td align="center" valign="middle">
			
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
	  
	  	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="height:25px"> 
	
		<td align="center" valign="middle">	
			汇悦台
		</td>
		
		<td align="center" valign="middle">
			东区A8 
		</td>
		
		<td align="center" valign="middle">
			D座
		</td>
		
		<td align="center" valign="middle">
			C11-8
		</td>
		
		<td align="center" valign="middle">叶小姐</td>
		
		<td align="center" valign="middle">
			13000
		</td>
		
		<td align="center" valign="middle">
			210
		</td>
		
		<td align="center" valign="middle">
			2500000
		</td>
		
		<td align="center" valign="middle">
			是
		</td>
		
		<td align="center" valign="middle">
			2012-07-01
		</td>
				
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/confirm/guangzhou/changeBuildToSecond.action?buildId=${c.id}" onclick="return false;">选择</a>
		</td>
		
		
	  </tr>
  
</table>
</div>

<!-- 列表 end -->


</td>
            </tr>
			
            <tr>
              <td colspan="6">
                <div class="manu">
					<a style="color:red;" href="saleunit/confirm/guangzhou/searchList.action?p=1" onclick="return false;">1</a> 
					<a href="saleunit/confirm/guangzhou/searchList.action?p=2" onclick="return false;">2</a> 
					<a href="saleunit/confirm/guangzhou/searchList.action?p=2" onclick="return false;">下页</a> 
					<a href="saleunit/confirm/guangzhou/searchList.action?p=2" onclick="return false;">末页</a>总数目: 16,总页数: 2
				</div>                
			</td>
            </tr>
 </table>

<%--主体table end --%>


</table>  

</body>
</html>

