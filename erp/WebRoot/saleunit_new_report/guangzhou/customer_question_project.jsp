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
		<title>客户问卷分类(项目)</title>
		<base href="<%=basePath%>"/>
		<s:include value="../../header/header_easyui1.3.4.jsp"></s:include>
		
		<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>	
			
		<script type="text/javascript">
		$(document).ready(function() {
            bindProjectDialogForSQKHOnlyQuestion("projectNames", "projectIds"); //单个项目的选择，并且设置该项目的问卷
		});			
								
		function download(){
			location.href = './saleunit_new_report/report/guangzhou/customerQuestionProjectDownload.action';	   
		}		

		//客户问卷分类(销售)
		function openTabXS(projectId,projectName){
			var date1 = $("#date1").datebox("getValue");
			var date2 = $("#date2").datebox("getValue");
			var url = './saleunit_new_report/report/guangzhou/customerQuestionSales.action?cond.strSearchCompanyProjectIds='+projectId+'&cond.date1='+date1+'&cond.date2='+date2;
			try
			{
				parent.OpenTab('客户问卷分类(销售):'+projectName,url);
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
				url:"./saleunit_new_report/report/guangzhou/customerQuestionProjectAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyIds","cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order","questionId"])
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
		</script>
		
	</head>
<body style="padding:0px;background:white;">
	    <table id="dg" style="width:auto;height:612px;"  
	    toolbar="#toolbar" 
            data-options="
                singleSelect:true,
                collapsible:true,
                rownumbers:false,
                fitColumns:false,
                view:groupview,
                groupField:'topicName',
                groupFormatter:function(value,rows){
                    return value + ' - ' + rows.length + ' 项';
                }
            ">
        <thead>
            <tr>
                <th align="right" data-options="field:'topicContent',width:300">类别(选项)</th>
                <th align="right" data-options="field:'sumCount',width:300">小计</th>
            </tr>
        </thead>
    </table>
	    <div id="toolbar" style="padding:5px;height:auto">
	    	
     	&nbsp;项目<input type="text" id="projectNames" size="40"/>
			<input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>			
			<input type="hidden" id="companyIds" name="cond.strSearchCompanyIds"/>
            <label>&nbsp;<span>项目问卷</span></label><s:select list="questionList" name="questionId" id="questionList" />	
					
			<input type="hidden" name="cond.sort" value="sumCount"/>
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
	    </div> 
	</body>
</html>



   
   



