<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
		<title>新增项目</title>
		<style >
			.nalable{cursor: n-resize;color: navy;text-decoration: underline}
			.ealable{cursor: e-resize;color: navy;text-decoration: underline}
			
			.tb1 td{padding-left: 5px}
			.tb1 tr{background-color:#FFFFFF}
			
			.seltd{background-color:pink}
		</style>
		<script language="javascript" type="text/javascript">
			$().ready(function(){
				$(document.body).append($('<div id="follower" style="width:50px;height:50px;border:1px solid red;position:absolute"></div>'))  ;
				$(".ealable").click(
							function(e){
				                    $("#follower").text(e.pageX+"|"+e.pageY).css({top:e.pageY,left:e.pageX})  ;
				                
									$("td[flo*='"+$(this).attr("flo").toString()+"']").toggleClass("seltd")
								}
						);
				$(".nalable").click(
					function(){
							$("td[unit*='"+$(this).attr("unit").toString()+"']").toggleClass("seltd")
						}
					)
			});
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title01" ><a href="./property/newUnit/input_unit.jsp" target="_self">新建单元</a></div>
<div class="title02" ><a href="./property/newUnit/search_unit.jsp" target="_self">查询单元</a></div>
<div class="right99"></div>
<div class="blueline"></div>
<div class="c"></div>
<div class="c"></div>

<%--主体table --%>
<div title="查询" style="width: 100%">
	<h4>所属项目  广州分公司</h4>
	<input />  <span><button type="submit">  搜索  </button></span>
</div>
<div style="overflow: auto;width: 1100px">
<div style="float: left;width: 700px;overflow: scroll;height: 500px;border: solid 1px;border-color: gray;">
	 <h4>楼层</h4>
	 	<table width="300px" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 20px">
	 		
	 		<tr>
	 			<td style=""><p>楼层</p></td><td ><p></p></td><td ><p></p></td><td ><p></p></td>
	 		</tr>
	 		<tr  bgcolor="#FFFFFF"; style="background-color: #FFFFFF">
	 			<td><p></p> </td><td><p>号码</p></td><td><p>A</p> </td><td><p>B</p></td>
	 		</tr>
	 		<tr>
	 			<td><p></p></td><td><p></p></td><td><p><a class="nalable" unit="A">整列调整</a> </p></td><td><p><a unit="B" class="nalable">整列调整</a> </p></td>
	 		</tr>
	 		<tr>
	 			<td><p>2</p></td><td><p><a class="ealable" flo="4">行调整</a></p></td><td unit="A" flo="4"><p>MY-A-1-A</p></td><td unit="B" flo="4"><p>MY-A-1-B</p></td>
	 		</tr>
	 		<tr>
	 			<td><p>2</p></td><td><p><a class="ealable" flo="3">行调整</a></p></td><td unit="A" flo="3"><p>MY-A-1-A</p></td><td unit="B" flo="3"><p>MY-A-1-B</p></td>
	 		</tr>
	 		<tr>
	 			<td><p>2</p></td><td><p><a class="ealable" flo="2">行调整</a></p></td><td unit="A" flo="2"><p>MY-A-1-A</p></td><td unit="B" flo="2"><p>MY-A-1-B</p></td>
	 		</tr>
	 		<tr>
	 			<td><p>2</p></td><td><p><a class="ealable" flo="1">行调整</a></p></td><td unit="A" flo="1"><p>MY-A-1-A</p></td><td unit="B" flo="1"><p>MY-A-1-B</p></td>
	 		</tr>
	 		
	 	</table>
	 	
	 </div>
	<div style="float: left;margin-left: 20px;border: solid 1px;border-color: gray;width: 300px;">
	 <h4>修改单个单元</h4>
	 	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="margin-top: 10px;">
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>MY-5-5-A</p></td><td><p>已成交</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>建筑面积</p> </td><td><p>室内面积:180M3</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>建筑面积单价:18000</p></td><td><p>室内面积单价:20000</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>总价:18000</p></td><td><p>格局:三房二厅</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p><a>图片</a></p></td><td><p>销售详细资料</p></td>
	 		</tr>
	 	</table>
	 	<button>submit</button>
	 </div>
	 <div style="float: left;margin-left: 20px;border: solid 1px;border-color: gray;width: 300px;margin-top: 20px">
	 <div style="float: right;">VVV</div>
	 <h4>批量修改</h4>
	 	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="margin-top: 50px">
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>MY-5-5-A</p></td><td><p>已成交</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>建筑面积</p> </td><td><p>室内面积:180M3</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>建筑面积单价:18000</p></td><td><p>室内面积单价:20000</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p>总价:18000</p></td><td><p>格局:三房二厅</p></td>
	 		</tr>
	 		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	 			<td><p><a>图片</a></p></td><td><p>销售详细资料</p></td>
	 		</tr>
	 	</table>
	 		<button>submit</button>
	 		
	 </div>
	 </div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
