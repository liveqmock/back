<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>

<head>

	<base href="<%=basePath%>">
	<title>共用loading界面</title>
	
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/jquery.easyui.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="./css/easyui.css"/>
	
	<script type="text/javascript" language="javascript">
	
		$(document).ready(function(){
			
			tabLoading();
		});
		
		function tabLoading(){
		
			//alert(this);
			var panel = parent.$("#tabs").tabs("getSelected");
			 
			$("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: "100%", height: "100%",marginTop:0}).appendTo($(document.body));
            $("<div class=\"datagrid-mask-msg\" style=\"font-size:12px\">正在加载数据,请稍候...</div>").appendTo($(document.body))
			  	.css({ display: "block", left: "45%", top: "50%"});
				
			var url = location.search;			
			var src = "";
			 
			if(url.indexOf("?") != -1){
				src = url.substr(1);
			}
			 
			$(panel).find("iframe")[0].src = src;
		}
		
	</script>
</head>

<body>
</body>
</html>

