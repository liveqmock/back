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
		<title>客户跟进情况(项目)</title>

		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>		
		<script type="text/javascript">
		$(document).ready(function() {
			bindProjectDialogForSQKH("projectNames", "projectIds"); //多个项目的选择				
		});			
		$(window).resize(function(){
			$('#dg').datagrid('resize');
		});									
		function download(){
			location.href = './saleunit_new_report/report/guangzhou/xmgjqkDownload.action';	   
		}		

		//客户跟进情况(销售)
		function openTabXS(projectId,projectName){
			var date1 = $("#date1").datebox("getValue");
			var date2 = $("#date2").datebox("getValue");
			var url = './saleunit_new_report/report/guangzhou/xsgjqkReport.action?cond.strSearchCompanyProjectIds='+projectId+'&cond.date1='+date1+'&cond.date2='+date2;
			try
			{
				parent.OpenTab('客户跟进情况(销售):'+projectName,url);
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
				remoteSort:false,
				showFooter:true,
				toolbar:'#toolbar',
				height:$(this).height(),
				
				rownumbers:true,
				singleSelect:true,
				pagination:false,
				striped:true,
				nowrap:true,
				fitColumns: true,
				url:"./saleunit_new_report/report/guangzhou/xmgjqkReportAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyIds","cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order"]),
				columns: [[
					{field:'projectName',title:'项目',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortGBK,
					formatter:formatterProjectName},
					{field:'phoneCount',title:'电话跟进',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'visitCount',title:'再次到访',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'purchasedCount',title:'已购买',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'phone2visitCount',title:'电转访',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'identificationChipsCount',title:'认筹',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'initiationCount',title:'入会',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'homeExhibitionsWillCount',title:'房展会',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'externalExhibitionCount',title:'外展场',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM},
					{field:'leafletCount',title:'派单',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM}
					]]  
				
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
		
		//通用扇形图显示函数
		function showPie(title,flag){
			var rows_length = $('#dg').datagrid('getRows').length;  

			if(rows_length>0){
				new MyAjaxIframeDialog({title:"比例图:客户跟进情况(销售)-"+title, 
					width:650,
					height:550,
					src:'./saleunit_new_report/report/guangzhou/commonPie.action?flag='+flag,
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
		function sortNUM(a,b){
			return parseInt(a)>parseInt(b)?1:-1;;
		}
		function sortGBK(a,b){
			return a.localeCompare(b);
		}
		</script>

		
	</head>
<body style="padding:0px;background:white;">

		 <table id="dg"></table>   
	    <div id="toolbar" style="padding:5px;height:auto">
	    	
     	&nbsp;项目<input type="text" id="projectNames" size="40"/>
			<input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>	
			
			<input type="hidden" id="companyIds" name="cond.strSearchCompanyIds"/>	
					
			<input type="hidden" name="cond.sort" value="phoneCount"/>
			<input type="hidden" name="cond.order" value="desc"/>	
			日期<input class="easyui-datebox" type="text" id="date1" name="cond.date1" style="width:90px" />
			-
			<input class="easyui-datebox" type="text" id="date2" name="cond.date2" style="width:90px" />
			&nbsp;	
			<input type="button" onclick="queryForm();" value=" 查询 "/>	
			<input type="button" onclick="queryFormByWeek();" value=" 查询本周 "/>	
			<input type="button" onclick="queryFormByMonth();" value=" 查询本月 "/>	

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
				  	  <input type="button" onclick="download()" value=" 导出 " >
            <%} %>
			 <br/>
			&nbsp;比例图(<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('电话跟进','CUSTOMER_FOLLOW_PROJECT_PHONE');">电话跟进</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('再次到访','CUSTOMER_FOLLOW_PROJECT_VISIT');">再次到访</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('已购买','CUSTOMER_FOLLOW_PROJECT_PURCHASED');">已购买</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('电转访','CUSTOMER_FOLLOW_PROJECT_PHONE2VISIT');">电转访</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('认筹','CUSTOMER_FOLLOW_PROJECT_IDENTIFICATIONCHIPS');">认筹</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('入会','CUSTOMER_FOLLOW_PROJECT_INITIATION');">入会</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('房展会','CUSTOMER_FOLLOW_PROJECT_HOMEEXHIBITIONSWILL');">房展会</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('外展场','CUSTOMER_FOLLOW_PROJECT_EXTERNALEXHIBITION');">外展场</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('派单','CUSTOMER_FOLLOW_PROJECT_LEAFLET');">派单</a>)
	    </div> 


	</body>
</html>



   
   



