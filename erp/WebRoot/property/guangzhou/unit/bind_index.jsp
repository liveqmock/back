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
			
		<title>绑定单元</title>
		
		<style >
			.nalable{cursor: pointer;color: navy;}
			.ealable{cursor: e-resize;color: navy;text-decoration: underline}
			
			.tb1 td{padding-left: 5px;width:75px}
			.tb1 tr{background-color:#FFFFFF}
			.unit {cursor: pointer}
			.seltd{background-color:#EEAD0E}
			.isa{background-color:red}
			.isb{background-color:#333333}
			.no{color:red}
			
			.noselect{ background:#333}
			.noselect1{ background:#888}
		</style>
		 
		<script type="text/javascript" language="javascript" src="./js/sale_unit.js"></script>	
		
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				saleUnitBind("projectName", "projectHiddenId", "areaId", "buildId");

				var selecta = 0;
				var divstate = 0;
				//如果选择的是没有绑定过的房间
				$(".no").click(function(){
					//已经选择的和已经绑定过的 不做出反映
					if($(this).hasClass("noselect")|| $(this).hasClass("noselect1")){
						return false;
					}

					//如果选择的主单元
					if(selecta == 0){
						$("#bind_list").append("主房间<label color='red' class='noselect'> "+$(this).text()+"</label>");
			
						selecta = 1;
						$(this).addClass("noselect");
						$(".isa").addClass("noselect");
						$(".isb").addClass("noselect");
					}else if(selecta == 1 ){
						$(this).addClass("noselect1");
						$("#bind_list").append("<br/>副房间<label color='red' class='noselect1'> "+$(this).text()+"</label>");
					}
				});
				
				$("#reset").click(function(){
					
					$("#unit_table td").removeClass("noselect")
						.removeClass("noselect1");
					selecta = 0;
					$("#bind_list").html("");
					
				});
				
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
	<div class="d_out">
		<a href="./property/unit/reset_index.action?
		ts=<%=CacheUtils.getUrlTimeStamp()%>" target="_self">调整单元</a>
	</div>
	<div class="d_over">
		<b>绑定单元</b>
	</div>
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>



<div class="unitmapdiv">

	<form action="./property/unit/bind_index.action" method="post" >
	<div>
	&nbsp;楼盘项目<p:project id="projectName" name="unitCond.propertyName" value="${unitCond.descPropertyId}"
		 hiddenId="projectHiddenId" hiddenName="unitCond.propertyId" hiddenValue="${unitCond.propertyId}"/>
	&nbsp;分区<p:area id="areaId" name="unitCond.areaId" value="${unitCond.areaId}" relyValue="${unitCond.propertyId}"/>		 
	&nbsp;楼栋<p:build id="buildId" name="unitCond.buildId" value="${unitCond.buildId}" relyValue="${unitCond.areaId}"/>
	<input type="submit" value="  搜索  " />
	</div></form>
	<div style="width: 100%">
		<div style="float: left;width: 50%;overflow: scroll;height: 500px;border: solid 1px;border-color: gray;" id = "tablediv">
	 
	
	 	<table border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 2px" id="unit_table">
				<s:iterator value="tableTrList" id="tr">
					<tr  bgcolor="#FFFFFF";>
						${tr}
					</tr>
				</s:iterator>
			</table>
			<br/>
		</div>
		<div style="float: left;width: 30%;border: solid 1px;border-color: gray;margin-left: 4px ;padding: 4px;color:red">
		<h3>绑定单元列表</h3>
			<button id="reset">取消</button>
			<form action="" method="post">
			<div id="bind_list">
			</div>
			<button id="sub_bind" type="submit">确定</button>
			</form>
	</div>

</div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
