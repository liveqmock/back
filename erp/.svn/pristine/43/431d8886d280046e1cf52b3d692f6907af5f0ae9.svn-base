<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	response.setHeader("Pragma","No-cache");   
	
	response.setHeader("Cache-Control","no-cache");   
	
	response.setDateHeader("Expires", 0);  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	
	<title>数据分组</title>
	
	<base href="<%=basePath%>">
		
	<meta http-equiv="pragma" content="no-cache" /> 
	<meta http-equiv="Cache-Control" content="no-cache, must-revalidate" /> 
	<meta http-equiv="expires" content="0">

	<link rel="stylesheet" href="./jqwidgets/styles/jqx.base.css" type="text/css" />
    <script type="text/javascript" src="./jqwidgets/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="./jqwidgets/jqxcore.js"></script>
    <script type="text/javascript" src="./jqwidgets/jqxdata.js"></script> 
    <script type="text/javascript" src="./jqwidgets/jqxbuttons.js"></script>
    <script type="text/javascript" src="./jqwidgets/jqxscrollbar.js"></script>
    <script type="text/javascript" src="./jqwidgets/jqxmenu.js"></script>
    <script type="text/javascript" src="./jqwidgets/jqxgrid.js"></script>
    <script type="text/javascript" src="./jqwidgets/jqxgrid.grouping.js"></script>
    <script type="text/javascript" src="./jqwidgets/jqxgrid.selection.js"></script> 
    <script type="text/javascript" src="./jqwidgets/gettheme.js"></script>
	
	 <script type="text/javascript" language="javascript">
        $(document).ready(function () {
            
            // 解析数据
            var source =
            {
                datatype: "json",
                datafields: ${dataGrid.datafields},
                url: "${dataGrid.url}",
            };

            // 创建 jqxGrid
            $("#jqxgrid").jqxGrid(
            {
                width: '100%',
                source: source,
                groupable: true,
                columns: ${dataGrid.columns},
                
            });
          
        });
    </script>
	
  </head>
  
<body class="default">
	
	<div id="jqxgrid"></div>

</body>

</html>

