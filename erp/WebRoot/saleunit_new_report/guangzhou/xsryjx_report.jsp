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
<title>销售人员绩效 </title>
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
<body  style="padding:0px;background:white;">

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
		<!-- <a style="color:#1199FF;" href="#">下载</a>&nbsp; -->	
        <div class="right99"></div>	
	     <div class="blueline"></div>	 
		</td>
	    </tr> 
		  
		<!-- 搜索表单 end -->
					
			
            <tr>
              <td colspan="6">			  
			  
			  	<div class="gbox1">	
				<table  width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="text-align: center;">

 <tr class="gboxbg">
  <td colspan="3">楼盘</td>
  <td colspan="33"></td>
 </tr>

 <tr class="gboxbg">
  <td colspan="3">起始时间</td>
  <td colspan="6">客户事件时间</td>
  <td colspan="27"></td>
 </tr>

 <tr class="gboxbg">
  <td colspan="3">终止时间</td>
  <td colspan="6">客户事件时间</td>
  <td colspan="27"></td>
 </tr>

 <tr class="gboxbg">
  <td colspan="3">事件类别</td>
  <td colspan="6">来电</td>
  <td colspan="27"></td>
 </tr>








 <tr class="gboxbg">
  <td></td>
  <td></td>
  <td></td>
  <td colspan=4>意向度</td>
  <td></td>
  <td colspan=9>到访次数</td>
  <td colspan=5>认购情况</td>
  <td colspan=4>签约情况</td>
  <td colspan=3>排名</td>
  <td colspan=3>未签约情况</td>
  <td colspan=2>回款情况</td>
  <td colspan=2>未回款情况</td>
 </tr>

<tr style="background-image: url(/erp/images/tianluan/gboxbg.gif);">
  <td> </td>
  <td>销售人员</td>
  <td>统计量</td>
  <td>D<br/>级<br/>︵<br/>无<br/>意<br/>向<br/>︶</td>
  <td>C<br/>级<br/>︵<br/>可<br/>跟<br/>进<br/>︶</td>
  <td>B<br/>级<br/>︵<br/>意<br/>向<br/>较<br/>高<br/>︶</td>
  <td>A<br/>级<br/>︵<br/>成<br/>交<br/>︶</td>
  <td>人<br/>均<br/>比<br/>例</td>
  <td>统<br/>计<br/>量</td>
  <td>无</td>
  <td>第<br/>一<br/>次</td>
  <td>第<br/>二<br/>次</td>
  <td>第<br/>三<br/>次</td>
  <td>第<br/>四<br/>次</td>
  <td>第<br/>五<br/>次</td>
  <td>第<br/>六<br/>次</td>
  <td>多<br/>次</td>
  <td>成<br/>交<br/>套<br/>数</td>
  <td>成<br/>交<br/>面<br/>积</td>
  <td>成<br/>交<br/>金<br/>额</td>
  <td>人<br/>均<br/>比<br/>例</td>
  <td>成<br/>功<br/>率</td>
  <td>签<br/>约<br/>套<br/>数</td>
  <td>签<br/>约<br/>面<br/>积</td>
  <td>签<br/>约<br/>金<br/>额</td>
  <td>人<br/>均<br/>比<br/>例</td>
  <td>按<br/>套<br/>数<br/>排<br/>名</td>
  <td>按<br/>面<br/>积<br/>排<br/>名</td>
  <td>按<br/>金<br/>额<br/>排<br/>名</td>
  <td>未<br/>签<br/>约<br/>套<br/>数</td>
  <td>未<br/>签<br/>约<br/>面<br/>积</td>
  <td>未<br/>签<br/>约<br/>金<br/>额</td>
  <td>首<br/>付<br/>回<br/>款</td>
  <td>贷<br/>款<br/>回<br/>款</td>
  <td>首<br/>付<br/>未<br/>回<br/>款</td>
  <td>贷<br/>款<br/>未<br/>回<br/>款</td>
 </tr>
 
 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td></td>
  <td>张三</td>
  <td>4</td>
  <td></td>
  <td></td>
  <td>4</td>
  <td></td>
  <td>44%</td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
 </tr>

 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td></td>
  <td>李四</td>
  <td>3</td>
  <td></td>
  <td>3</td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
 </tr>

 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td></td>
  <td>王五</td>
  <td>2</td>
  <td>2</td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
 </tr>

 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td></td>
  <td>合计</td>
  <td>9</td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
  <td></td>
 </tr>

 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
  <td colspan="2"></td>
  <td colspan="7"></td>
  <td colspan="27"></td>
 </tr>

</table>
			</div>


			</td>
            </tr>
			
 </table>


</form>

   

</body>
</html>




