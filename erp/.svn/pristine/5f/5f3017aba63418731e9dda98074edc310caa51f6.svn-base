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
		<title>客户质量分析</title>
		<s:include value="../../header/header_easyui.jsp"></s:include>
		<script language="javascript" type="text/javascript" src="<%=basePath%>js/project.list.utils.js?v=1.2"></script>		
    	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
		<script type="text/javascript" src="<%=basePath%>js/datetime.utils.js?v=1"></script>
		<script src="<%=basePath%>js/TableOrder.js" type="text/javascript"></script>
		
		<script type="text/javascript">
		
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
			//用客户端sorter进行排序
			$("#dg").datagrid({
				url:"./saleunit_new_report/report/guangzhou/redAnalysisAjax.action",
				queryParams:getInputsAsOjbect(["cond.strSearchCompanyIds","cond.strSearchCompanyProjectIds","cond.userId","cond.date1","cond.date2","cond.sort","cond.order"]),
				columns: [[
					{field:'fieldName',title:'记录项',width:80,sortable:true,align:'center',  
						sorter:function(a,b){ 
							return a.localeCompare(b);
						}  
					},
					{field:'inputCount',title:'录入数量',width:80,sortable:true,align:'center',  
						sorter:function(a,b){ 
							a = a.replace("-","-1");
							a = a.replace("%",""); 
							b = b.replace("-","-1");
							b = b.replace("%",""); 
							return parseInt(a)>parseInt(b)?1:-1;
						}  
					},
					{field:'notInputCount',title:'未录入数量',width:80,sortable:true,align:'center',  
						sorter:function(a,b){ 
							a = a.replace("-","-1");
							a = a.replace("%",""); 
							b = b.replace("-","-1");
							b = b.replace("%",""); 
							return parseInt(a)>parseInt(b)?1:-1;
						}  
					},
					{field:'inputRate',title:'录入率',width:80,sortable:true,align:'center',  
						sorter:function(a,b){ 
							a = a.replace("-","-1");
							a = a.replace("%",""); 
							b = b.replace("-","-1");
							b = b.replace("%",""); 
							return parseInt(a)>parseInt(b)?1:-1;
						}  
					}
				]]
			});
		}	
		
		$().ready(function(){
			queryFormByMonth();
		
			bindProjectDialogForSQKHOnly("projectNames", "projectIds"); //单个项目的选择	
			baseProjectListForHiddenId("saleName", "hiddenUserId", "./customer_guangzhou/search/sales.action", "");//销售人员的下拉选择	
		});
								
		function download(){
			location.href = './saleunit_new_report/report/guangzhou/redAnalysisDownload.action';	   
		}		
		
	</script>	
	
   
	</head>
<body style="padding:0px;background:white;">
		 <table id="dg" style="width:auto;height:612px;"  
            toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
            rownumbers="true" fitColumns="true" singleSelect="true" remoteSort="false"  
            >   
	    </table>  
	    <div id="toolbar" style="padding:5px;height:auto">
	    	
     	&nbsp;项目<input type="text" id="projectNames" size="40"/>
			<input type="hidden" id="projectIds" name="cond.strSearchCompanyProjectIds"/>	
			
			<input type="hidden" id="companyIds" name="cond.strSearchCompanyIds"/>	
			&nbsp;销售
                    <input type="text" id="saleName" name="cond.saleName" title="按空格键可以查找前十条数据"/>
                    <input type="hidden" id="hiddenUserId" name="cond.userId" />         
					
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
				<input style="float:left;margin-left:740px;margin-top:-24px;" type="button" onclick="return exportMessage()" value="导出" />
	    </div> 
	    

	</body>
</html>



   
   



