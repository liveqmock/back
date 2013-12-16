<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<style type="text/css">
.unit_table td{
	padding-left: 5px;
	padding-right: 5px;
	line-height: 20px;
}
</style>


<div style="float: left">

<table style="width: 650px;line-height: 24px" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		
		<tr style="background-color: #ffffff">
			<td width="150px">楼盘名称</td><td>${propojo.propertyName }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>预售证号</td><td>${propojo.saleCard }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>楼盘地址</td><td>${propojo.propertyAddress }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>行政区域</td><td>${propojo.areaName }</td>
		</tr>
		<tr style="background-color: #ffffff">
			<td>项目功能描述</td><td>${propojo.projectDesc }</td>
		</tr>	
		<tr style="background-color: #ffffff">
			<td>开发商</td><td>${devpojo.developerName }</td>
		</tr>
		<tr style="background-color: #ffffff">
		<td>项目销售计划</td><td>&nbsp;&nbsp;<a href="javascript:addPlan(${propojo.id });" style="color:blue">添加计划</a> &nbsp;&nbsp;说明：只有添加计划后，才能在报表中看到计划落实情况<br>
		
		<div class="gbox1">
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" 
		style="text-align: center;font-size:12px; line-height:26px; white-space:normal">
	
		<tr class="gboxbg">
			<th >计划年月</th>
			<th>任务面积</th>
			<th>任务金额</th>
			<th>任务均价</th>
			<th >备注</th>
		</tr>							
	<s:iterator value="propertyProjectPlanList" id="c">   						
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
	   <td><a  href="javascript:;" style="color:#5482de;" onclick="return erp.saleunit.propertyprojectplan.openEditFrame('<s:property value="id"/>');"><s:property value="planMonth"/></a></td>
	   <td><s:property value="planArea"/></td>
	   <td><s:property value="planMoney"/></td>
	   <td><s:property value="planPrice"/></td>
	   <td><s:property value="remark"/></td>
	   </tr>
	</s:iterator>  
	</table>
</div>
		
		</td></tr>
		 
</table>

</div>

		

	


<script type="text/javascript" language="javascript">
//添加计划
function addPlan(propertyId) {
	var actionUrl = './saleunit_new_init/appoint/guangzhou/forInputPropertyProjectPlan.action?propertyId='+propertyId;
	openNormalDialog(actionUrl,
		"addDataForm"
		,"新建计划",500,350);
}

//js命名空间DEMO
// 注册js脚本的命名空间
Namespace.register("erp.saleunit.propertyprojectplan");

erp.saleunit.propertyprojectplan.openEditFrame = function(planId)
{
	var actionUrl = './saleunit_new_init/appoint/guangzhou/getPlanById.action?id='+planId;
	openNormalDialog(actionUrl,
		"updateDataForm"
		,"修改计划",500,350);
} 

    
</script>




