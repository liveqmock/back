<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pt" uri="/WEB-INF/projectText.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>修改项目销售计划</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/project.text.utils.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){		
			//加载后处理关闭窗口，以及提示
			closeIframeDialog("myIframeDialog", "${closeMark}", "", "${suggestion}");							
		});		
		
//显示为yyyy-MM年月格式	
$.fn.datebox.defaults.formatter = function(date){
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	var d = date.getDate();
	return y+'-'+ (m < 10 ? '0' + m : m);
}

$.fn.datebox.defaults.parser = function(s){
	var t = Date.parse(s+"-01");
	if (!isNaN(t)){
		return new Date(t);
	} else {
		return new Date();
	}
}
				
	</script>
		
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		
	</style>
	
</head>
<body>
<div class="gbox1">			

<form  action="<%=basePath%>saleunit_new_init/appoint/guangzhou/updatePlanData.action" method="post" id="updateDataForm">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">		
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">楼盘项目&nbsp;</td>
                <td id="t14" >												
					<s:property value="propertyProject.propertyName"/>
					<input type="hidden" id="updateData_propertyId" name="updateData.propertyId"/>
					<input type="hidden" name="propertyProject.id" value="${propertyProject.id }"/>
					<input type="hidden" id="updateData_id" name="updateData.id"  value="${updateData.id }"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>计划年月&nbsp;</td>
                <td id="t14">
					<input name="updateData.planMonth" class="easyui-datebox" required="required" value="${updateData.planMonth }"></input>  
				</td>	
				</tr>
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15" align="right"><font color="red">*</font>任务面积&nbsp;</td>
                <td id="t16" style="width:30%">
					<input type="text" name="updateData.planArea" required="required"  class="easyui-numberbox" data-options="min:0,precision:2" style="width:90px"  value="${updateData.planArea }"/>㎡
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="red">*</font>任务金额&nbsp;</td>
                <td id="t14">
					<input  required="required"  name="updateData.planMoney"  class="easyui-numberbox" data-options="min:0,precision:2" style="width:90px"  value="${updateData.planMoney }"/>元
				</td>	
				</tr>
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td id="t15" style="width:15%" align="right"><font color="red">*</font>任务均价&nbsp;</td>
                <td id="t16" style="width:30%">
					<input type="text"  required="required"  name="updateData.planPrice" class="easyui-numberbox" data-options="min:0,precision:2" style="width:90px"  value="${updateData.planPrice}"/>元/㎡			
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">备注&nbsp;</td>
                <td id="t14" >
					<input type="text"  name="updateData.remark" style="width:76%"  value="${updateData.remark }"/>								
				</td>		              	
              </tr> 
			  
			  
			</table>
</form>	
	
	</div>



</body>
</html>
