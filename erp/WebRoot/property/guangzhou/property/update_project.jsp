<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../../customer/guangzhou/header.jsp"></s:include>	
		<s:include value="../../../customer/guangzhou/header_left_js.jsp"></s:include>	
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	
		<title>修改项目</title>
		<style >
		
			
			.tb1 tr{background:#FFFFFF}
			.redbor {border: 2px solid red}
			em{margin-right: 5px;color: red}
			textarea{font-size:12px}
		</style>
		<script type="text/javascript">
			$().ready(function(){
				propertyProjectListForHiddenId("projectName", "hiddenId");
				userListForHiddenId("userName","userId");
				
					$("#submit").click(function(){
					
					var	$str = $.trim($("#proName").val());
					if($str == ""){
						alert("楼盘名称需要填写");
						$("#proName").val("");
						$("#proName").focus();
						return false;
						}
					var	$str = $.trim($("#deleloperId").val());
					if($str == ""){
						alert("请选择开发商");
						$("#deleloperId").val("");
						$("#deleloperId").focus();
						return false;
						}
					
				});
			});
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="./property/developer/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">开发商</a></div>
<div class="title02" ><a href="./property/project/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">楼盘项目</a></div>
<div class="title01" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title01" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>

<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		<a href="./property/project/index.action" target="_self">查询楼盘</a>
	</div>		
	<div class="d_out">
		<a href="./property/project/input_index.action" target="_self">新建楼盘</a>
	</div>		
	<div class="d_over">
		<b>楼盘信息</b>
	</div>			
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
	<div style="width:100%;height: inherit;float: left;vertical-align: top;margin-top: 5px">
		<form action="./property/project/update.action" method="post">
		<div style="width: 100%;float: left;">
			<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 70%" class="tb1 gbox">
				<tr>
					<td width="20%" align="right"><em>*</em>楼盘名称(推广名)</td>
					<td width="30%"><input  type="text" name="updateProPro.propertyName" id="proName" value="${updateProPro.propertyName}"/></td>
					<td align="right" width="20%">项目状态</td>
					<td width="30%"> 
							<s:select list="selProState" name="updateProPro.projectState"></s:select>
						  </td>
				</tr>
				<tr>
					
					<td align="right">标准地名</td>
					<td><input  type="text" name="updateProPro.adName" value="${updateProPro.adName}"/></td>
					<td align="right"><em>*</em>开发商</td>
						<td> 
							<s:select id="deleloperId" list="developerList" name="updateProPro.developerId" listValue="developerName" listKey="id" headerKey="" headerValue="请选择"></s:select>
						  </td>
					
				</tr>
				<tr>
					<td align="right">地块名称(编号)</td>
					<td><input  type="text" name="updateProPro.blockName"  value="${updateProPro.blockName}"/></td>
					<td align="right">签合同日期(天数)</td>
					<td><input  type="text" name="updateProPro.contractLimitDate" value="${updateProPro.contractLimitDate}"/></td>
				</tr>
				
				<tr>
					<td align="right">楼盘地址</td>
					<td><input  type="text" name="updateProPro.propertyAddress" value="${updateProPro.propertyAddress}"/></td>
					<td align="right"></td>
					<td></td>
				</tr>
				<tr>
					<td align="right" style="">商品房许可证</td>
					<td><input  type="text" name="updateProPro.preSalePermit" maxlength="20" value="${updateProPro.preSalePermit}"/></td>
					<td align="right"></td>
					<td></td>
				</tr>
				<tr>
					<td align="right">项目功能</td>
					<td>
						<select>
							<option value="">请选择</option>
							<option value="1">住宅</option>
							<option value="2">商业</option>
							<option value="3">办公</option>
							<option value="4">综合/其他</option>
						</select>
					</td>
					<td align="right">规划用途</td>
					<td>
						<select>
							<option value="">请选择</option>
							<option value="1">住宅</option>
							<option value="2">商业</option>
							<option value="3">办公</option>
							<option value="4">综合/其他</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right">土地使用年限</td>
					<td colspan="3"><input type="text" maxlength="4" name="updateProPro.startLandLife" style="width: 100px" value="${updateProPro.startLandLife}"/> 到 
					<input type="text" maxlength="4" name="updateProPro.endLandLife" style="width: 100px" value="${updateProPro.endLandLife}"/></td>
					
				</tr>
				<tr>
					<td align="right"></td>
					<td>&nbsp;</td>
					<td align="right"></td>
					<td></td>
				</tr>
				<tr>
					
					
					<td width="20%" align="right">占地面积（㎡）</td>
					<td width="30%"><input  type="text" name="updateProPro.coverArea" value="${updateProPro.coverArea}"/></td>
					<td align="right">开盘日期</td>
					<td><input  type="text" name="updateProPro.startSaleDate" class="Wdate" value="<s:date name="#request.updateProPro.startSaleDate" format="yyyy-mm-dd"/>"/></td>
					
				
				</tr>
				<tr>
					
					<td align="right">建筑面积（㎡）</td>
					<td><input  type="text" name="updateProPro.buildArea" value="${updateProPro.buildArea}"/></td>
					<td align="right">封盘日期</td>
				
					<td><input type="text" name="updateProPro.endSaleDate" class="Wdate" value="<s:date name="#request.updateProPro.endSaleDate" format="yyyy-mm-dd"/>"/></td>
				</tr>
				<tr>
					<td align="right">可售面积（㎡）</td>
					<td><input  type="text" name="updateProPro.saleArea" value="${updateProPro.saleArea}"/></td>
					<td align="right">开工日期</td>
					<td><input  type="text" name="updateProPro.startBuildDate" class="Wdate" value="<s:date name="#request.updateProPro.startBuildDate" format="yyyy-mm-dd"/>"/></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td>
						
					</td>
					<td align="right">竣工日期</td>
					<td><input type="text" name="updateProPro.endBuildDate" class="Wdate" value="<s:date name="#request.updateProPro.endBuildDate" format="yyyy-mm-dd"/>"/>  
						
					  </td>
				</tr>
				
				<tr>
					<td rowspan="1"  align="right">项目描述</td>
					<td rowspan="1" colspan="3">
						<textarea rows="2" cols="50" style="margin:0px;width: 90%;font-size: 12px" name="updateProPro.projectDesc" >${updateProPro.projectDesc}</textarea>
					</td>
					
				</tr>
				<tr >
					<td align="right">目标客户描述</td>
					<td colspan="3">
						<textarea rows="2" cols="50" style="margin:0px;width: 90%;font-size: 12px" name="updateProPro.customerDesc">${updateProPro.customerDesc}</textarea>
					</td>
				
				</tr>
				<tr>
					<td rowspan="1" align="right">备注</td>
					<td rowspan="1" colspan="3">
						<textarea  rows="2" cols="50" style="margin:0px;width: 90%;font-size: 12px" name="updateProPro.remark">${updateProPro.remark}</textarea>
					</td>
				</tr>
				
			
				<tr valign="top">
					<td colspan="4" align="center" style="text-align: center">
					<input value="${updateProPro.id}" type="hidden" name="updateProPro.id" />
						<input type="submit" value="  修改  " style="width: 50px" id="submit"/>
						<a  class="ablue" style="color:#1199ff" href="./property/area/index.action?inputArea.propertyId=${updateProPro.id}">新建分区</a>
						<s:actionmessage cssStyle="color:red"/></td>
				</tr>
				
		</table>
		</div>
		</form>
	</div>
	
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
