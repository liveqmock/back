<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%@ taglib prefix="p" uri="/WEB-INF/property.tld"%>
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
		<title>调整单元</title>
		<style >
			.nalable{cursor: pointer;color: navy;}
			.ealable{cursor: e-resize;color: navy;text-decoration: underline}
			
			.tb1 td{padding-left: 5px;width:75px}
			.tb1 tr{background-color:#FFFFFF}
			.unit {cursor: pointer}
			.seltd{background-color:#EEAD0E}
		</style>
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.form.js"></script>		
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="./js/sale_unit.js"></script>	
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				saleUnitBind("projectName", "projectHiddenId", "areaId", "buildId");	
				
				<%if(request.getAttribute("tip") != null && request.getAttribute("tip")!=""){%>
					alert('<%=request.getAttribute("tip")%>');
				<%}%>
				
				$(".flo").click(
							function(){
									$("td[flo='"+$(this).attr("flo").toString()+"']").toggleClass("seltd")
								}
						);
				$(".flo").dblclick(
						function(){
								$("td[flo='"+$(this).attr("flo").toString()+"']").addClass('seltd')
							}
					);
				$(".rom").click(
						function(){
								$("td[rom='"+$(this).attr("rom").toString()+"']").toggleClass("seltd")
							}
					);
				$(".rom").dblclick(
						function(){
								$("td[rom='"+$(this).attr("rom").toString()+"']").addClass('seltd')
							}
					);
				$(".unit").click(
					function(){
							$(this).toggleClass("seltd")
						}
					);

				$("#sub").click(function(){
					if($(".seltd").size()<=0){
						alert("没有选单元");
						return false;
					}
						var ids = "";
						for(i=0;i < $(".seltd").size();i++){
							ids = "" + ids + $($(".seltd").get(i)).attr("uid").toString() +","
							
						};
						
						location.href='./property/unit/reset_unit.action?ids='+ids;
				});	
<%--
				$("#bind").click(function(){
					if($(".seltd").size()<=0){
						alert("没有选单元");
						return false;
					}
					if($(".seltd").size()==1){
						alert("只选择一个单元,不能进行绑定操作");
						return false;
					}
					var ids = "";
					for(i=0;i < $(".seltd").size();i++){
						ids = "" + ids + $($(".seltd").get(i)).attr("uid").toString() +","
					};
					location.href='./property/unit/unit_bind.action?ids='+ids+"&buildId="+${buildId};
				});	

				$("#delbind").click(function(){
					location.href='./property/unit/del_bind.action?buildId='+${buildId};
				});	
				
			--%>
				
			});
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="./property/unit/search_list_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元列表</a></div>
<div class="title02" ><a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">单元视图</a></div>

<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		<a href="./property/unit/show_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">查看单元</a>
	</div>		
	<div class="d_over">
		<b><a href="./property/unit/reset_index.action?ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">调整单元</a></b>
	</div>	
			
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
<div style="width:100%;height: inherit;float: left;vertical-align: top;">
<div title="查询" style="width: 100%;height: 25px">
<form action="./property/unit/reset_index.action" method="post">
	&nbsp;楼盘项目<p:project id="projectName" name="" value="${unitCond.descPropertyId}"
		 hiddenId="projectHiddenId" hiddenName="unitCond.propertyId" hiddenValue="${unitCond.propertyId}"/>
	&nbsp;分区<p:area id="areaId" name="unitCond.areaId" value="${unitCond.areaId}" relyValue="${unitCond.propertyId}"/>		 
	&nbsp;楼栋<p:build id="buildId" name="unitCond.buildId" value="${unitCond.buildId}" relyValue="${unitCond.areaId}"/>
<!-- <s:select list="buildList" listKey="id" listValue="buildName" name="buildId" id="build_id"></s:select>-->

&nbsp;<input  type="submit" value="  查询  "/>
	</form>
</div>

	 <input value="  修改所选单元  " id="sub" type="button"/>
	 <!--  <input value="  绑定所选单元  " id="bind" type="button"/>
	 <input value="  解除楼盘单元绑定  " id="delbind" type="button"/> -->

<div style="overflow: auto;">
<div style="float: left;width: 75%;overflow: scroll;height: 500px;border: solid 1px;border-color: gray;" id = "tablediv">
	 
	
	 	<table border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 20px">
	 		
	 		<s:iterator value="tableList" id="tr">
	 		<tr>
	 			${tr}
	 		</tr>
	 		</s:iterator>
	 		
	 	</table>
	 	
	 </div>
	
	 </div>
</div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
