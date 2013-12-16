<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

    <title>活跃客户筛选报表</title>
    <base href="<%=basePath%>" />
<s:include value="header_report_easyui.jsp"></s:include>
	<script type="text/javascript">
		$(document).ready(function() {
	        bindProjectDialogForXKZX("projectNames", "projectIds"); //多个项目的选择
		});
		
		$().ready(function(){				
			queryFormByMonth();
		});	
				
		//导出		
		function download(){
			location.href = './saleunit_new_report/report/guangzhou/customerQueryDownload.action';	   
		}		
				
		//导出明细			
		function downloadDetail(){
			location.href = './saleunit_new_report/report/guangzhou/customerQueryDownloadDetail.action';	   
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
				url:"./saleunit_new_report/report/guangzhou/customerQueryAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyProjectIds","cond.date1","cond.date2","cond.sort","cond.order","cond.mulProjectCount"])
			});
		}	
		
		//具体相同电话的客户明细
		function openWinCustomer(phone){
			new MyAjaxIframeDialogX2({title:'查看客户明细', 
				width:650,
				height:400,
				src:'./saleunit_new_report/report/guangzhou/phoneDetailList.action?phone='+phone,
				buttons:false
				});	
		}
		
		//dategrid显示下划线，超链接
		function formatterPhone(value,row,index){
			var textShow;
			if(value!=null){
            	textShow = '<a onclick="openWinCustomer(\''+value+'\')" style="color: #1199FF;cursor: pointer;" class="ablue">'+value+'</a> ';
			}
			else{
				textShow = value;
			}
        	return textShow;
       	}
	</script>
    <style>
        *{margin:0;padding:0;}
    </style>

</head>

<body style="padding:0px;background:white;">
		 <table id="dg" style="width:auto;height:612px;"  
            toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
            rownumbers="true" fitColumns="true" singleSelect="true"  
            >  
	        <thead>  
	            <tr>  
	                <th field="phone" width="100" align="center" formatter="formatterPhone">电话</th>  
	                <th field="projectCount" width="100" align="center"  >跨项目数量</th>  
	            </tr>  
	        </thead>  
	    </table>  
	    <div id="toolbar" style="padding:5px;height:auto">
	    
     	&nbsp;项目<input type="text" id="projectNames" size="40"/>
			<input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>			
			<input type="hidden" name="cond.sort" value="phoneCount"/>
			<input type="hidden" name="cond.order" value="desc"/>	
			日期<input class="easyui-datebox" type="text" id="date1" name="cond.date1" style="width:90px" />
			-
			<input class="easyui-datebox" type="text" id="date2" name="cond.date2" style="width:90px" />
			&nbsp;跨项目数大于等于
			<input class="easyui-numberspinner" style="width:40px;" name="cond.mulProjectCount" required="required" value="2" data-options="min:2,max:10,editable:false">
			&nbsp;
			<input type="button" onclick="queryForm();" value=" 查询 "/>	
			<input type="button" onclick="queryFormByWeek();" value=" 查询本周 "/>	
			<input type="button" onclick="queryFormByMonth();" value=" 查询本月 "/>

            <%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_EXCEL, EnumDevFlag.GUANGZHOU) ){%>
				  <input type="button" onclick="download()" value=" 导出 " >
				  <input type="button" onclick="downloadDetail()" value=" 导出明细 " >(明细包括客户详细信息)
            <%} %>
	    </div> 
	    
	</form>
</body>
</html>

