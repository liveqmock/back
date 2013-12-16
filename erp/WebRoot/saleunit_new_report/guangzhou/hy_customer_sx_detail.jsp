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

    <title>活跃客户筛选报表(明细)</title>
    <base href="<%=basePath%>" />
<s:include value="header_report_easyui.jsp"></s:include>
	<script type="text/javascript">
		$().ready(function(){	
			var paraObj = requestParaToObject();
			
			//使用.datagrid的方法设置easyui组件,那么该table的class不要设置为easyui-datagrid，否则会两次加载渲染		
			$("#dg").datagrid({
				url:"./saleunit_new_report/report/guangzhou/phoneDetailListAjax.action",
				queryParams:{'cond.phone':paraObj['phone']}
			});
		});			
	</script>
    <style>
        *{margin:0;padding:0;}
    </style>

</head>

<body style="padding:0px;background:white;">
		 <table id="dg" style="width:auto;height:350px;"  
            toolbar="#toolbar" pagination="false" striped="true" nowrap="true"
            rownumbers="true" fitColumns="true" singleSelect="true"  
            >  
	        <thead>  
	            <tr>  
	                <th field="phone" width="100" align="center">电话</th>  
	                <th field="customerName" width="100" align="center"  >客户名称</th>
	                <th field="projectName" width="100" align="center"  >项目名称</th>
	                <th field="salesName" width="100" align="center"  >销售人员</th>  
	            </tr>  
	        </thead>  
	    </table>  	    
	</form>
</body>
</html>

