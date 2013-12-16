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
		<title>客户跟进情况(销售)</title>

		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>
		<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
		<script type="text/javascript">							
		function download(){
			location.href = './saleunit_new_report/report/guangzhou/xsgjqkDownload.action';	   
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
				//width:'auto',
				rownumbers:true,
				singleSelect:true,
				pagination:false,
				striped:true,
				nowrap:true,
				fitColumns: true,
				url:"./saleunit_new_report/report/guangzhou/xsgjqkReportAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order"]),
				columns: [[
					{field:'projectName',title:'项目',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortGBK},
					{field:'realName',title:'销售人员',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortGBK},
					{field:'phoneCount',title:'电话跟进',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterPhone},
					{field:'visitCount',title:'再次到访',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterVisit},
					{field:'purchasedCount',title:'已购买',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterPurchased},
					{field:'phone2visitCount',title:'电转访',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterPhone2visit},
					{field:'identificationChipsCount',title:'认筹',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterIdentificationChips},
					{field:'initiationCount',title:'入会',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterInitiation},
					{field:'homeExhibitionsWillCount',title:'房展会',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterHomeExhibitionsWill},
					{field:'externalExhibitionCount',title:'外展场',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterExternalExhibition},
					{field:'leafletCount',title:'派单',sortable:true,align:'center',width:$(this).width() * 0.2,
					sorter:sortNUM,
					formatter:formatterLeaflet}
					]]  
				
			});
		}				
		
		$().ready(function(){	
			var paraObj = requestParaToObject();
			//根据传入的参数来进行查询
			if(typeof(paraObj["cond.strSearchCompanyProjectIds"])!="undefined"){
				$("#projectIds").val(paraObj["cond.strSearchCompanyProjectIds"]);
				$("#projectNames").val($("#projectIds").val());
				$("#date1").datebox("setValue",paraObj["cond.date1"]);
				$("#date2").datebox("setValue",paraObj["cond.date2"]);
				queryForm();
			}
			else{
				queryFormByMonth();
			}
			
			bindProjectDialogForSQKHOnly("projectNames", "projectIds"); //单个项目的选择
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
		//dategrid给电话跟进显示下划线，超链接
		function formatterPhone(value,row,rowIndex){
			var textShow;
			
			if(row.phoneCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'1'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
       	//dategrid给回访显示下划线，超链接
		function formatterVisit(value,row,rowIndex){
			var textShow;
			
			if(row.visitCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'2'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
		//dategrid给已购买下划线，超链接
		function formatterPurchased(value,row,rowIndex){
			var textShow;
			
			if(row.purchasedCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'3'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
       	
		//dategrid给电转访下划线，超链接
		function formatterPhone2visit(value,row,rowIndex){
			var textShow;
			
			if(row.phone2visitCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'4'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
		//dategrid给认筹下划线，超链接
		function formatterIdentificationChips(value,row,rowIndex){
			var textShow;
			
			if(row.identificationChipsCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'5'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
  
		//dategrid给入会下划线，超链接
		function formatterInitiation(value,row,rowIndex){
			var textShow;
			
			if(row.initiationCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'6'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
		//dategrid给房展会下划线，超链接
		function formatterHomeExhibitionsWill(value,row,rowIndex){
			var textShow;
			
			if(row.homeExhibitionsWillCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'7'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
		//dategrid给外展场下划线，超链接
		function formatterExternalExhibition(value,row,rowIndex){
			var textShow;
			
			if(row.externalExhibitionCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'8'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
		//dategrid给派单下划线，超链接
		function formatterLeaflet(value,row,rowIndex){
			var textShow;
			
			if(row.leafletCount!=0){
            	textShow = '<a onclick="openWinCustomer(\''+'9'+'\',\''+row.userId+'\',\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
      	
		//根据跟进的类型，显示跟进的用户信息
		function openWinCustomer(type,userId,value){
		if(userId=="undefined")
			return;
			new MyAjaxIframeDialogX2({title:'查看客户明细', 
				width:750,
				height:385,
				src:'./saleunit_new_report/report/guangzhou/customerListByFollowForm.action?cond.followType='+type+'&cond.followUserId='+userId+'&cond.date1='+$('#date1').datebox('getValue')+'&cond.date2='+$('#date2').datebox('getValue')+'&value='+value+'&cond.projectId='+$("#projectIds").val(),
				buttons:false
				});	
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
	    	
     	&nbsp;项目<input type="text" id="projectNames" size="40" />
			<input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>			
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
			&nbsp;比例图(<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('电话跟进','XSGJQK_PHONE');">电话跟进</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('再次到访','XSGJQK_VISIT');">再次到访</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('已购买','XSGJQK_Purchased');">已购买</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('电转访','XSGJQK_PHONE2VISIT');">电转访</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('认筹','XSGJQK_IDENTIFICATIONCHIPS');">认筹</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('入会','XSGJQK_INITIATION');">入会</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('房展会','XSGJQK_HOMEEXHIBITIONSWILL');">房展会</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('外展场','XSGJQK_EXTERNALEXHIBITION');">外展场</a>
			&nbsp;<a style="color: #1199FF;cursor: pointer;" class="ablue" onclick="showPie('派单','XSGJQK_LEAFLET');">派单</a>)
	    </div> 
	    
	</body>
</html>



   
   



