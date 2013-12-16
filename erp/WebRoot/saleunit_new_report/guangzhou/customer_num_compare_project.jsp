<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
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
		<title>客户数量对比(项目)</title>

		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
			
		<script type="text/javascript">
		$(document).ready(function() {
			bindProjectDialogForSQKH("projectNames", "projectIds"); //多个项目的选择				
		});			
								
		function download(){
			location.href = './saleunit_new_report/report/guangzhou/customerNumCompareProjectDownload.action';	   
		}		

		//客户数量对比(销售)
		function openTabXS(projectId,projectName){
			var date1 = $("#date1").datebox("getValue");
			var date2 = $("#date2").datebox("getValue");
			var url = './saleunit_new_report/report/guangzhou/customerNumCompareSales.action?cond.strSearchCompanyProjectIds='+projectId+'&cond.date1='+date1+'&cond.date2='+date2;
			try
			{
				parent.OpenTab('客户数量对比(销售):'+projectName,url);
			}
			catch(err)
			{
				//用于demo的显示，因为没有使用左右框架，没有OpenTab的方法
				location.href = url;	 
			}
		}
		
		//查询本周
		function queryFormByWeek(){
			setTwoDatebox("thisweek",$("#date1"),$("#date2"));
			queryForm();
		}		
		
		//查询本月
		function queryFormByMonth(){
			setTwoDatebox("thismonth",$("#date1"),$("#date2"));
			queryForm();
		}		
		
		//查询
		function queryForm(){
			//使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染		
			$("#dg").datagrid({
				url:"./saleunit_new_report/report/guangzhou/customerNumCompareProjectAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyIds","cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order","cbxIncludeEmpty"])
			});
		}				
		
		$().ready(function(){	
			var paraObj = requestParaToObject();
			//根据传入的参数来进行查询
			if(typeof(paraObj["cond.strSearchCompanyIds"])!="undefined"){
				$("#companyIds").val(paraObj["cond.strSearchCompanyIds"]);
				
				$("#date1").datebox("setValue",paraObj["cond.date1"]);
				$("#date2").datebox("setValue",paraObj["cond.date2"]);
				queryForm();
			}
			else{			
				queryFormByMonth();
			}
		});	
		
		//比例图
		function showPie(){
			//取得datagrid的行数			
			var rows_length = $('#dg').datagrid('getRows').length;  

			if(rows_length>0){
				new MyAjaxIframeDialog({title:'比例图:客户数量对比(项目)', 
					width:650,
					height:550,
					src:'./saleunit_new_report/report/guangzhou/commonPie.action?flag=CUSTOMER_NUM_COMPARE_PROJECT',
					buttons:false
					});
			}
			else{
				parent.myAlert("列表没有数据,不能显示饼图,请先查询出数据");
			}	
		}
				
		//dategrid显示下划线，超链接
		function formatterProjectName(value,row,index){
			var textShow;
			if(row.projectId!=null){
            	textShow = '<a onclick="openTabXS(\''+row.projectId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
		
		</script>

		
	</head>
<body style="padding:0px;background:white;">

		 <table id="dg" style="width:auto;height:612px;"  
            toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
            rownumbers="true" fitColumns="true" singleSelect="true"   
            >  
	        <thead>  
	            <tr>  
	                <th field="projectName" width="50" sortable="true" align="center" formatter="formatterProjectName">项目</th>  
	                <th field="sumCount" width="50" sortable="true" align="right">客户数量</th>  
	            </tr>  
	        </thead>  
	    </table>  
	    <div id="toolbar" style="padding:5px;height:auto">
	    	
     	&nbsp;项目<input type="text" id="projectNames" size="40"/>
			<input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>	
			
			<input type="hidden" id="companyIds" name="cond.strSearchCompanyIds"/>	
					
			<input type="hidden" name="cond.sort" value="sumCount"/>
			<input type="hidden" name="cond.order" value="desc"/>	
			日期<input class="easyui-datebox" type="text" id="date1" name="cond.date1" style="width:90px" />
			-
			<input class="easyui-datebox" type="text" id="date2" name="cond.date2" style="width:90px" />
				<s:checkbox label="是否显示没有数据的项目" name="cbxIncludeEmpty" theme="xhtml"></s:checkbox>
			&nbsp;	
			<input type="button" onclick="queryForm();" value=" 查询 "/>	
			<input type="button" onclick="queryFormByWeek();" value=" 查询本周 "/>	
			<input type="button" onclick="queryFormByMonth();" value=" 查询本月 "/>	

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
				  	  <input type="button" onclick="download()" value=" 导出 " >
            <%} %>
			<input type="button" onclick="showPie();" value=" 比例图 "/>
	    </div> 


	</body>
</html>



   
   



