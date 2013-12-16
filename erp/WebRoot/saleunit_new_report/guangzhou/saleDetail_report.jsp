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
		<title>销售明细</title>

		<s:include value="header_report.jsp"></s:include>	
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/ui_fix.js"></script>
		<script type="text/javascript" src="<%=basePath%>/js/userAccount-hengda.js" ></script>
			
		<script type="text/javascript">
			var chart;
			$(document).ready(function() {
				//projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
				bindProjectDialogForSQKH("projectName", "hiddenId"); //多个项目的选择
			});

			function submitSearch(){
				var proIds = $("#hiddenId").val();
				var date1 =  $('#date1').datebox('getValue');
				var date2 =  $("#date2").datebox('getValue');
				var url1 = './saleunit_new_report/report/saleReport_json/saleDetailJson.action?proIds='+proIds+'&propertyUnitCond.date1='+date1+"&propertyUnitCond.date2="+date2;
				$("#test").treegrid("options").url=url1;
				$("#test").treegrid('reload');
			}


			
			$(function(){
				$('#test').treegrid({
					title:'',
					iconCls:'icon-save',
					height:600,
					nowrap: false,
					rownumbers: true,
					animate:true,
					collapsible:true,
					url:'./saleunit_new_report/report/saleReport_json/saleDetailJson.action',
					idField:'id',
					treeField:'project',
					toolbar:"toolbar",
					frozenColumns:[[
		                {title:'项目',field:'project',width:200}
					]],
					columns:[[
						{field:'buildId',title:'楼栋',width:220,rowspan:2},
						{field:'unitNo',title:'房间',width:220,rowspan:2},
						{field:'buildArea',title:'建筑面积',width:150,rowspan:2},
						{field:'insidedArea',title:'套内面积',width:150,rowspan:2},
						{field:'sumPrice',title:'标准总价',width:150,rowspan:2},
						{field:'saleState',title:'销售状态',width:150,rowspan:2}
						
					]]
				});
			});
			</script>
	</head>
	<body style="padding:0px;background:white;">
	
		
	
	
	  <!-- 
	   <table id="dg" title="" class="easyui-datagrid" style="width:auto;height:612px;"  
            url="./saleunit_new_report/report/saleReport_json/saleDetailJson.action?proId=79"  
            toolbar="#toolbar" pagination="false"  
            rownumbers="true" fitColumns="true" singleSelect="true"
            treeField='code'
            collapsible='true'
            >  
	        <thead>  
	            <tr>  
	            	 <th field="code" width="50px">楼栋</th>
	            	  <th field="name" width="50px">楼栋</th>
	            	   <th field="addr" width="50px">楼栋</th>
	            	    <th field="col4" width="50px">楼栋</th>
	         	
	                <th field="d11" width="50px">楼栋</th> 
	                <th field="d12" width="50px">房号</th> 
	                <th field="d13" width="50px">认购日期</th>  
	                <th field="d14" width="50px">客户名称</th>  
	                <th field="d15" width="50px">建筑面积</th> 
	                
	                <th field="d16" width="50px">套内面积</th> 
	                <th field="d17" width="50px">标准总价</th> 
	                <th field="d18" width="50px">成交总价</th> 
	                <th field="d19" width="50px">付款方式</th> 
	                <th field="d20" width="50px">优惠折扣</th> 
	                <th field="d21" width="50px">联系电话</th> 
	                <th field="d22" width="50px">通讯地址</th> 
	                
	                <th field="d23" width="50px">证件号码</th>
	                <th field="d24" width="50px">签合同日期</th>
	                <th field="d25" width="50px">认购状态（认购/临定/退房）</th>
	                
	            </tr>  
	        </thead>  
	    </table>   
	   -->
	    <div id="toolbar" style="height: auto;padding: 5px 0 5px 0">  
	        &nbsp;项目<input type="text" id="projectName" size="40" name="projectName" value="${cond.strSearchProjectNames}"/>
		<input type="hidden" id="hiddenId" name="projectIds" value="${cond.strSearchProjectIds}"/>
			<input type="hidden" id="d_date1" name="date1" value="${cond.date1 }"/>
			<input type="hidden" id="d_date2" name="date2" value="${cond.date2 }"/>
			<input type="hidden" id="datetype" name="datetype"/>
			&nbsp;日期<input class="easyui-datebox" type="text" id="date1" style="width:90px" name="cond.date1" value="${cond.date1}"/>
			-
			<input class="easyui-datebox" type="text" id="date2" style="width:90px" name="cond.date2" value="${cond.date2}"/>
		<%-- 	&nbsp;<a id="formweek" href="#" style="color: #1199FF;" class="ablue">本周</a>
			&nbsp;<a id="formmonth" href="#" style="color: #1199FF;" class="ablue">本月</a>
			&nbsp;<a id="form4month" href="#" style="color: #1199FF;" class="ablue">本季</a>
			&nbsp;<a id="form12month" href="#" style="color: #1199FF;" class="ablue">本年</a>
			&nbsp;<input type="checkbox"/><label>包含临订</label>
			  <input type="button" onclick="return submitSearch('export')" value="导出" ></input> --%>
			&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>	
				
	    </div>  
 <table id="test" title="" class="easyui-datagrid" style="width:auto;height:612px;" ></table>
	</body>
</html>



   
   



