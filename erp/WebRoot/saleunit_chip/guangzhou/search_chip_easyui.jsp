<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>筹单管理</title>

<base href="<%=basePath%>">		

<s:include value="header_chip.jsp"></s:include>

<style type="text/css">
	.isVoid1{text-decoration:line-through}
	.isVoid0{}
</style>

<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 

<script type="text/javascript" language="javascript" src="./js/saleunit_new_common.js"></script>
<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
<script type="text/javascript" language="javascript" src="./js/saleunit_chip_manager.js?v=1.2"></script>

<script type="text/javascript" language="javascript" src="./js/saleunit_new_unit_info.js"></script>	
<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->

<script type="text/javascript">

	$(document).ready(function(){
		
		baseAutoComplete("customerName", "customerHiddenId", "./saleunit_chip_manager/guangzhou/searchCustomersForChip.action", "");
		baseAutoComplete("customerPhone", "customerHiddenId", "./saleunit_chip_manager/guangzhou/searchCustomersFromPhoneForChip.action", "");		
				
		//baseAutoComplete("userName", "userHiddenId", "./saleunit_chip_manager/guangzhou/searchUsersForChip.action", ""); //新建录入人员		
		//baseAutoComplete("editChipUserName", "editChipUserHiddenId", "./saleunit_chip_manager/guangzhou/searchUsersForChip.action", ""); //更新录入人员
		
	});
	
	function searchReset(){
		
		$('#thisForm')[0].reset();
	}

	function submitSearch() {	
		moduleMask("searchChipTableId");
		$("#thisForm").submit();
	}
	
</script>
</head>

<body style="padding:0px;background:white;">

	<div class="right99"></div>
	
		<table width="100%" border="0" align="left" cellspacing="0" id="searchChipTableId">

			<tr>
				<td colspan="6">
		<form class="queryform" id="thisForm" method="post" >
				<!-- <label>&nbsp;<span>项目</span> </label> <input
					type="text" id="projectName" name="projectName"
					value="${projectName}" />  -->
					<span>筹单号</span><input type="text" style="width:90px" id="chipCond_chipNo"  name="chipCond.chipNo" value="${chipCond.chipNo}" />
					<span>客户姓名</span><input type="text" style="width:90px" name="chipCond.customerName" value="${chipCond.customerName}" />
					<span>客户电话</span><input type="text" style="width:90px" name="chipCond.customerPhone" value="${chipCond.customerPhone}" />
					
					<input type="hidden" id="hiddenId" name="chipCond.projectId" value="" />
					
					日期<input class="easyui-datebox" type="text" style="width:90px" name="chipCond.date1" value="${chipCond.date1}" />-
					<input class="easyui-datebox" type="text" style="width:90px" name="chipCond.date2" value="${chipCond.date2}" />
					&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询 " />
					<input type="button" onclick="return createChipDiv()" value=" 新建认筹 " />
					
					<div class="right99"></div>
					<div class="blueline"></div>
					
					
			</form>
				</td>
			</tr>
			

			<!-- 搜索表单 end -->


			<tr>
				<td colspan="6">

					<div class="gbox1">
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" 
							style="text-align: center;font-size:12px; line-height:26px; white-space:normal">
						
							<tr class="gboxbg">
								<th>筹单号</th>
								<th>认筹日期</th>
								<th>认筹金额</th>
								<th>客户姓名</th>
								<th>电话号码</th>
								<th>销售人员</th>
								<th >第一意向</th>
								<th >第二意向</th>
								<th >第三意向</th>
								<th >第四意向</th>
								<th >第五意向</th>

								<th>操作</th>

							</tr>			
											
   						<s:iterator value="chipList" id="c">   						
						  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" class="isVoid${c.isVoid}"> 
						   <td>
						   		
						   		<a href="javascript:void(0)" style="color:#5482de;" onclick="return editChipDiv('${id}', '${isVoid}');"><s:property value="chipNo"/></a>
								
								<!-- 
								<a href="javascript:void(0)" style="color:#5482de;" onclick="myAlert('优化中...')"><s:property value="chipNo"/></a>
								-->
								
							</td>
						   <td><s:property value="createdTime"/></td>
						   <td><my:format value="${chipMoney}"/></td>
						   <td><s:property value="customerName"/></td>
						   <td><s:property value="customerPhone"/></td>
						   <td><s:property value="salesName"/></td>
						   <td><s:property value="unit1.unitNo"/></td>
						   <td><s:property value="unit2.unitNo"/></td>
						   <td><s:property value="unit3.unitNo"/></td>
						   <td><s:property value="unit4.unitNo"/></td>
						   <td><s:property value="unit5.unitNo"/></td>

						   <td><a href="javascript:void(0)" style="color:#5482de;" onclick="voidChip('${id}', '${isVoid}')">作废</a></td>

						   </tr>
   						</s:iterator>  
						
						</table>
					</div>
					
				</td>
			</tr>
			
			 <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
				</td>
            </tr>
			
		</table>
		
	
	
	
<!--
<div id="dd" class="easyui-dialog" closed="true" modal="true" style="padding:5px;width:400px;height:200px;"    
        title="My Dialog" iconCls="icon-ok"    
        toolbar="#dlg-toolbar" buttons="#dlg-buttons">    
    Dialog Content.    
</div> 
-->

</body>

</html>

