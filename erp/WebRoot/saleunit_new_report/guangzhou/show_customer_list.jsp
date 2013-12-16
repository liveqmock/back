<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<s:include value="../../header/header_easyui.jsp"></s:include>
<title>客户分列表</title>
<script type="text/javascript">
		function getDownload(){
			//预设好拿那个session里面的cond
			var sessionKey = 'customerCond';
	        window.location.href = "./saleunit_new_report/report/guangzhou/flmxCustomerListExport.action?sessionKey="+sessionKey;
		}
</script>
</head>
<body style="padding:0px;background:white;">
 <table id="dg" title="" class="easyui-datagrid" style="width:auto;height:430px;"  
            url="./customer/report_json/searchCustomerList.action"  
            toolbar="#toolbar" pagination="true"  
            rownumbers="true" fitColumns="true" singleSelect="true"
            pageSize='20'
            >  
	        <thead>  
	            <tr>  
	                <th field="name" width="50">客户名称</th>  
	                <th field="phone1" width="50">移动电话</th>  
	                <th field="phone2" width="50">固定电话</th> 
	                <th field="area" width="50">意向面积</th>
	                <th field="price" width="50">意向总价</th>
	                <th field="pro" width="50">项目</th> 
	                <th field="cuser" width="50">录入人员</th>
	                <th field="ctime" width="50">录入时间</th> 
	            </tr>  
	        </thead>  
	    </table>  
	     <div id="toolbar">  
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="getDownload();">导出</a>  
	    </div> 
</body>
</html>

