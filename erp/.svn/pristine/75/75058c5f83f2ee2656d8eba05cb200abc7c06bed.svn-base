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
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/guangzhou_input_valdate.js"></script>
		<title>新建楼盘</title>
		<style >
			.poppng{background:url(<%=basePath%>/images/pop.png) no-repeat}
			.err_input_class{border-color: red;border-width: 2px}
			.tb1 tr{background:#FFFFFF}
			.tb1 td{padding-left: 5px;padding-right: 5px}
			.redbor {border: 2px solid red}
		     em{margin-right: 5px;color: red}
		    .body_div{width:100%;height: inherit;float: left;vertical-align: top;margin-top: 5px} 
		</style>
		<script type="text/javascript">
			$().ready(function(){
				propertyProjectListForHiddenId("projectName", "hiddenId");//自动提示 项目名称
				
				userListForHiddenId("userName","userId");//自动提示 用户
				
				$("#submit").click(function(){//提交验证
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

				$("#proName").inputVal({//填写时提醒			
					errClass:'err_input_class',
					errDiv:'org_box',
					minlength:1
				});
				
			});
		</script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
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
	<div class="d_over">
		<b><a href="./property/project/input_index.action" target="_self">新建楼盘</a></b>
	</div>				
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
	<div id="body_div">
		<form action="./property/project/input.action" method="post">
		<div style="width: 100%;float: left;">
			<table cellpadding="0" cellspacing="1"  style="vertical-align: top;width: 70%" class="tb1 gbox">
				<tr>
					<td width="20%" align="right"><em>*</em>楼盘名称(推广名)</td>
					<td width="30%"><input  type="text" name="inputProPro.propertyName" value="" id="proName"/></td>
					<td align="right" width="20%">项目状态</td>
					<td width="30%"> 
							<s:select list="selProState" name="inputProPro.projectState"></s:select>
						  </td>
				</tr>
				<tr>
					
					<td align="right">标准地名</td>
					<td><input  type="text" name="inputProPro.adName"/></td>
					<td align="right"><em>*</em>开发商</td>
						<td> 
							<s:select id="deleloperId" list="developerList" name="inputProPro.developerId" listValue="developerName" listKey="id" headerKey="" headerValue="请选择"></s:select>
						  </td>
					
				</tr>
				<tr>
					<td align="right">地块名称(编号)</td>
					<td><input  type="text" name="inputProPro.blockName"/></td>
					<td align="right">签合同日期(天数)</td>
					<td><input  type="text" name="inputProPro.contractLimitDate"/></td>
				</tr>
				
				<tr>
					<td align="right">楼盘地址</td>
					<td><input  type="text" name="inputProPro.propertyAddress"/></td>
					<td align="right"></td>
					<td></td>
				</tr>
				<tr>
					<td align="right" style="">商品房许可证</td>
					<td><input  type="text" name="inputProPro.preSalePermit" maxlength="20"/></td>
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
					<td colspan="3"><input type="text" maxlength="4" name="inputProPro.startLandLife" style="width: 100px"/> 到 
					<input type="text" maxlength="4" name="inputProPro.startLandLife" style="width: 100px"/></td>
					
				</tr>
				<tr>
					<td align="right"></td>
					<td>&nbsp;</td>
					<td align="right"></td>
					<td></td>
				</tr>
				<tr>
					
					
					<td width="20%" align="right">占地面积（㎡）</td>
					<td width="30%"><input  type="text" name="inputProPro.coverArea" /></td>
					<td align="right">开盘日期</td>
					<td><input  type="text" name="inputProPro.startSaleDate" class="Wdate"/></td>
					
				
				</tr>
				<tr>
					
					<td align="right">建筑面积（㎡）</td>
					<td><input  type="text" name="inputProPro.buildArea" /></td>
					<td align="right">封盘日期</td>
				
					<td><input type="text" name="inputProPro.endSaleDate" class="Wdate"/></td>
				</tr>
				<tr>
					<td align="right">可售面积（㎡）</td>
					<td><input  type="text" name="inputProPro.saleArea" /></td>
					<td align="right">开工日期</td>
					<td><input  type="text" name="inputProPro.startBuildDate" class="Wdate"/></td>
				</tr>
				<tr>
					<td align="right"></td>
					<td>
						
					</td>
					<td align="right">竣工日期</td>
					<td><input type="text" name="inputProPro.endBuildDate" class="Wdate" /></td>
				</tr>
				
				<tr>
					<td rowspan="1"  align="right">项目描述</td>
					<td rowspan="1" colspan="3">
						<textarea rows="2" cols="50" style="margin:0px;width: 90%;" name="inputProPro.projectDesc" ></textarea>
					</td>
					
				</tr>
				<tr >
					<td align="right">目标客户描述</td>
					<td colspan="3">
						<textarea rows="2" cols="50" style="margin:0px;width: 90%;" name="inputProPro.customerDesc"></textarea>
					</td>
				
				</tr>
				<tr>
					<td rowspan="1" align="right">备注</td>
					<td rowspan="1" colspan="3">
						<textarea  rows="2" cols="50" style="margin:0px;width: 90%;" name="inputProPro.remark"></textarea>
					</td>
				</tr>
				
				<tr valign="top">
					<td colspan="4" align="center" style="text-align: center">
						<input type="submit" value="  新建  " style="width: 50px" id="submit"/>
						<s:actionmessage cssStyle="color:red"/></td><s:actionmessage cssStyle="color:red"/>
				</tr>
		</table>
		</div>
		</form>
	</div>
	
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>

<%--POP --%>
<div id="org_box" class="poppng" style="height:20px; width:250px;
	  position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;"></div>
	</body>
	</body>
</html>
