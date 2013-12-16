<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/sale_unit.js"></script>	 
		<script language="javascript" type="text/javascript">
			$().ready(function(){
			//	$("#select_unit_div").draggable({handle:"p"});
				saleUnitBind("showdiv_propertyName", "showdiv_propertyId", "showdiv_areaId", "showdiv_buildId");
				
				selectUnit("${unitNoInput}","${unitIdInput}");
				
				$("#select_unit_div_close").click(function()
					{
						$("#select_unit_div").css("display","none");
					});
			
				$("#searchForBuild").click(function(){
					$.ajax({ 
			             url: "./property/test/list.action",
			             dataType: "html",
			             data: "showdiv_buildId="+$("#showdiv_buildId").val().toString()
			             +"&showdiv_propertyId="+$("#showdiv_propertyId").val().toString()
			              +"&showdiv_propertyName="+$("#showdiv_propertyName").val().toString()
			             +"&showdiv_areaId="+$("#showdiv_areaId").val().toString()
			             +"&unitNoInput=${unitNoInput}&unitIdInput=${unitIdInput}",
			             success: function(sss) 
						 { 	 
							 $("#select_unit_div_body").html("");
							 $("#select_unit_div_body").html(sss); 
			             }
			         });
					
				});

				
			
			});
		</script>
	</head>
	<body>
	


<%--主体table --%>
<div style="width: 100%;height: 90%" id="bodyid">

	<div >
	&nbsp;楼盘<p:project  name="showdiv_propertyId"        value="${showdiv_propertyName}"   id="showdiv_propertyName"
		 hiddenId="showdiv_propertyId" hiddenName="" hiddenValue="${showdiv_propertyId}"   />
	&nbsp;分区<p:area name=""  relyValue="${showdiv_propertyId}" value="${showdiv_areaId}"  id="showdiv_areaId" />
	&nbsp;楼栋<p:build  name="" value="${showdiv_buildId}" relyValue="${showdiv_areaId}"      id="showdiv_buildId"/>
	<input type="button" value="  查询  " id="searchForBuild"/>
	</div>
	
	
		
		<div style="border: solid 0px;height: 95%;overflow: visible" id="table" >
			
			<table id = "table1" style="height: 250px;"   border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tab1"  >
				<s:iterator value="tableList" id="tr">
					<tr  bgcolor="#FFFFFF";>
						${tr}
					</tr>
				</s:iterator>
				
			</table>
			<br/>	
		</div>
</div>
	</body>
</html>
