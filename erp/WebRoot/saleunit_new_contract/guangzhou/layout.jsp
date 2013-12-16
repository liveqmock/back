<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
	
	<title>新框架</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"/>
		
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>saleunit_new_init/guangzhou/js/dialog_for_tree.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->	
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<style>
	
	.btn1 {
	BORDER-RIGHT: #7b9ebd 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7b9ebd 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#cecfde); BORDER-LEFT: #7b9ebd 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #7b9ebd 1px solid
	}
	.btn1_d {
	background:#444444;
	BORDER-RIGHT: #7EBF4F 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7EBF4F 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#B3D997); BORDER-LEFT: #7EBF4F 1px solid; CURSOR: hand; COLOR: #ffffff; PADDING-TOP: 2px; BORDER-BOTTOM: #7EBF4F 1px solid
	}
	.btn1_mouseover {
	background:#8DB6CD;color:#ffffff;
	BORDER-RIGHT: #7EBF4F 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7EBF4F 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#CAE4B6); BORDER-LEFT: #7EBF4F 1px solid; CURSOR: hand;  PADDING-TOP: 2px; BORDER-BOTTOM: #7EBF4F 1px solid
	}
	</style>	
	<!-- ie6 水印问题 -->
	<script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>   
	<script type="text/javascript"> 
		DD_belatedPNG.fix('.logo'); 

		
	</script>
	
	<style type="text/css">
	</style>	
	
  </head>
  
<body class="easyui-layout">

	<div region="north" border="false" style="height:50px;background:#B3DFDA;padding:0px; overflow:hidden">
		<s:include value="../../customer/guangzhou/top.jsp"/>
	</div>
	
	<div region="west" split="true" title="<a href='./customer_guangzhou/index/login.action' style='color:#5482DE'>返回主页</a>" style="width:213px;padding:1px;">	
		
		
	<div class="easyui-accordion" fit="true" border="false">
			<div title="交易管理" style="padding:5px;overflow:auto;">
				<s:include value="../../saleunit_new/guangzhou/left_unit.jsp"/>
			</div>
		</div>
		
	</div>
		
	<div region="center" title="合同管理" style="padding:0px;background:#efefef;" id="center_main">
	<div class="easyui-layout" fit="true" style="background:#ccc;" id="_center_layout">
		
	
			
			<!-- 中间的主要部分 -->
			<div region="center" id="contract_record_table" style="top:26px">
				<s:include value="contract_record.jsp"/>
			</div>
			
			<!-- 中间的底下部分
			<div region="south" id="contract_record_detail_table" split="true" style="height:300px; width:500px" title="详细信息">
				<s:include value="contract_record_detail.jsp"/>
			</div> -->
			
		</div>
			
	</div>
	
	<div region="south" border="false"  style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 15px;background: #eeeeee" ></div>
	</div>	
	

<%--dialog --%>
	<div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
</body>
</html>

