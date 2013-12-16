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
		<title>销售单元</title>
		<style >
			.tab1 td{line-height:19px;}
			.tdnull {background-color: #000000;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*未知*/
			.td {background-color: #000000;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*未知*/
				 	.td1 {background-color: #DCDCDC;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*待售 */
			.td2 {background-color: #FFFFFF;width: 17px;float: left;height: 15px;border:
				 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*待售 */
			.td3 {background-color: #7FFF00;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*预约*/
			.td4 {background-color: #FFFF00;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*预留*/
			.td5 {background-color: #F4A460;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*小订*/
			.td6 {background-color: #CC0000;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*认购*/
			.td7 {background-color: #BA55D3;width: 17px;float: left;height:
				 15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*签约*/
			.td8 {background-color: #808080;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*非售*/
			.td9 {background-color: #228B22;width: 17px;float: left;height: 
				15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*交楼*/
			.td10 {background-color: #808000;width: 17px;float: left;height:
				 15px;border: 1px;margin: 2px;border: solid 2px;border-color: gray;cursor: pointer}/*出证*/
			
			.clicktd {background-color: pink}
		</style>
		
<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.form.js"></script>	
	
		<script language="javascript" type="text/javascript">
			$().ready(function(){
			
				selectUnit("${unitNoInput}","${unitIdInput}");
				 $("#closeUnitList").click(function(){
					 $("#forunitframe").html("");
					 $("#forunitframe").css("display","none");
					 $("#forunitframe").css("display","none");
					 });
			
				$("#searchForBuild").click(function(){
					$.ajax({ 
			             url: "./property/test/list.action",
			             dataType: "html",
			             data: "showdiv_buildId="+$("#showdiv_getbuildid").val().toString()+"&showdiv_propertyId="+$("#showdiv_projectName").val().toString()
			             +"&unitNoInput=${unitNoInput}&unitIdInput=${unitIdInput}",
			             success: function(sss) { 
						 $("#forunitframe").html("");
						 $("#forunitframe").html(sss); 
						
			             }
			         });
					
				});

			
				$("#showdiv_projectName").change(function(){
					//根据楼盘项目ID 拿到楼栋
					var hid = $("#showdiv_projectName").val();
					if(hid == "" || hid == 0){
						return false;
					}else{
					
						$.ajax({
							type:"get",
							url: "./property/build/sel_build_by_pr.action",  
							data: "prid=" + hid,
							dataType: "html",
							success: function(data){
								$("#showdiv_getbuildid").empty();
								$("#showdiv_getbuildid").append(data);
							}
						});
				}
				});
			});
		</script>
	</head>
	<body>
	


<%--主体table --%>
<div style="width: 100%;height: inherit;float: left;vertical-align: top;" id="bodyid">

	<div >
	&nbsp;楼盘项目<s:select list="propertyList" listKey="id" listValue="propertyName" name="showdiv_propertyId" id="showdiv_projectName" headerKey="0" headerValue="请选择"></s:select>
	&nbsp;楼栋<s:select list="builList" listKey="id" listValue="buildName" name="showdiv_buildId" id="showdiv_getbuildid" ></s:select>
	<input type="button" value="  查询  " id="searchForBuild"/>
	<input type="button" value="  关闭  " id="closeUnitList"/>
	<input type="button" value="  清空  " id="flush"/>

	</div>
	
	<div style="">
		
		<div style="overflow: scroll;height: 500px;border: solid 2px;border-color: gray;" id="table">
			
			<table id = "table1"  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tab1"  >
				<s:iterator value="tableList" id="tr">
					<tr  bgcolor="#FFFFFF";>
						${tr}
					</tr>
				</s:iterator>
				
			</table>
			<br/>
			
		</div>
		
	</div>
	<div style="width: 100%;height: auto;"> 
	<table>
				<tr>
					<td title="01" width="40px" ><div class="td1"></div> <div style="float: left">销控</div>  </td>
					<td title="01" width="40px" ><div class="td2"></div> <div style="float: left">待售</div>  </td>
					<td title="01" width="40px" ><div class="td3"></div> <div style="float: left">预约</div>  </td>
					<td title="03" width="40px" ><div class="td4"></div> <div style="float: left">预留</div>  </td>
					<td title="04" width="40px" ><div class="td5"></div> <div style="float: left">小订</div>  </td>
					<td title="01" width="40px" ><div class="td6"></div> <div style="float: left">认购</div>  </td>
					<td title="01" width="40px" ><div class="td7"></div> <div style="float: left">签约</div>  </td>
					<td title="03" width="40px" ><div class="td8"></div> <div style="float: left">非售</div>  </td>
					<td title="04" width="40px" ><div class="td9"></div> <div style="float: left">交楼</div>  </td>
					<td title="04" width="40px" ><div class="td10"></div> <div style="float: left">出证</div>  </td>
				</tr>
			</table>
</div>
</div>

	</body>
</html>
