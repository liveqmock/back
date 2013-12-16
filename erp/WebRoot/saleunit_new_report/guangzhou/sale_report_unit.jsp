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
		<title>销售分析(单元明细)（看起来已经作废,peter20130628)struts-saleunit-new-report.xml,saleReportUnit</title>

		<s:include value="header_report.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
			
		<script type="text/javascript">
			var chart;
			$(document).ready(function() {
				bindProjectDialogForXKZXOnly("projectName", "hiddenId"); //单个项目选择
			});		

			function submitSearch(){
				submitSearch1(stype)
			}
			
			function submitSearch1(type){
				var ty
				if(type != undefined){
				ty = type
				}
				var proIds = $("#hiddenId").val();
				var date1 =  $('#date1').datebox('getValue');
				var date2 =  $("#date2").datebox('getValue');
				var date3 =  $('#date3').datebox('getValue');
				var date4 =  $("#date4").datebox('getValue');
				var saleName = $("#saleName").val();
				$("#dg").datagrid({
					url:'./saleunit_new_report/report/saleReport_json/saleJsonUnit.action',
					queryParams:{'urcond.companyProjectId':proIds,'urcond.date1':date1,'urcond.date2':date2,'urcond.date3':date3,'urcond.date4':date4,"type":ty}
				});
			}
			var stype = 0;
			function rengou(){
				submitSearch1(0);
				var rr= $("#dg");
				rr.datagrid('hideColumn','saleDate2');
				rr.datagrid('showColumn','saleDate');	
				stype = 0;
			}
			function qianyue(){
				submitSearch1(1);
				var rr= $("#dg");
				rr.datagrid('showColumn','saleDate2');
				rr.datagrid('hideColumn','saleDate');
				stype = 1;
			}
			
			//查询
			function queryForm(){
				//使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染		
				$("#dg").datagrid({
					url:"./saleunit_new_report/report/guangzhou/xsgjqkReportAjax.action",
					queryParams:getInputsAsOjbect(["cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order"])
				});
			}	
			</script>
	</head>
<body style="padding:0px;background:white;">
		 <table id="dg" title="" style="width:auto;height:auto;"  
            toolbar="#toolbar" pagination="false"  
            rownumbers="true" singleSelect="true"
            striped='true'
            >  
	        <thead>  
	            <tr>  
	                <th field="build" width="100px">楼栋</th> 
	                <th field="roomNo" width="100px">房号</th> 
	                <th field="saleDate" width="100px">认购日期</th>  
	                <th field="saleDate2" hidden width="100px">签约日期</th>  
	                <th field="customerName" width="100px">客户名称</th>  
	                <th field="buildArea" width="100px" align="right">建筑面积</th> 
	                <th field="insideArea" width="100px" align="right">套内面积</th> 
	                <th field="sumPrice" width="100px" align="right" >标准总价</th> 
	                <th field="salePrice" width="100px" align="right">成交总价</th>
	                <th field="payWay" width="100px">付款方式</th>
	                <th field="discountPercent" width="100px" align="right">优惠折扣</th> 
	        </thead>  
	    </table>  
	    <div id="toolbar" style="height: auto;padding: 5px">   
	        &nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${propertyUnitCond.strSearchProjectNames}"/>
		<input type="hidden" id="hiddenId" name="projectIds" value="${urcond.companyProjectId}"/>
			<input type="hidden" id="d_date1" name="date1" value="${urcond.date1 }"/>
			<input type="hidden" id="d_date2" name="date2" value="${urcond.date2 }"/>
			<input type="hidden" id="datetype" name="datetype"/>
			&nbsp;认购日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="cond.date1" value="${urcond.date1}"/>
			-
			<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="cond.date2" value="${urcond.date2}"/>
			&nbsp;签约日期<input class="easyui-datebox" type="text" id="date3" style="width:90px" name="cond.date1" value="${urcond.date3}"/>
			-
			<input class="easyui-datebox" type="text" id="date4" style="width:90px" name="cond.date2" value="${urcond.date4}"/>
			<label><input name="selecttype" type="radio" value="认购" onclick="rengou()" checked="checked"/>认购</label>
			<label><input name="selecttype" type="radio" value="签约" onclick="qianyue()"/>签约</label>
			&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>	
				  <input type="button" onclick="return submitSearch('export')" value="导出"/>
				  <div style="margin-top: 5px">
				  <font style="font-weight: bold; ">状态以销控中心为准</font></div> 
	    </div> 
	    
	</body>
</html>



   
   



