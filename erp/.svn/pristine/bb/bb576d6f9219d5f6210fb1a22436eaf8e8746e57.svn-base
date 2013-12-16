<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>"/>
<link href="<%=basePath%>css/easyui.css" rel="stylesheet" type="text/css"	charset="utf-8" />
<link href="<%=basePath%>css/icon.css" rel="stylesheet" type="text/css"	charset="utf-8" />
<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
<script type="text/javascript" src="<%=basePath%>js/easyui.utils.js"></script>	
<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

        function dialog_customerlog_list(customer_id){
			$("#new_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				width:800,
				height:500,
				onClose:function(){
					$('#new_dialog_ifram').html("");
				},
				buttons:[ 
					{text:'关闭',
						iconCls:'icon-cancel',
						handler:function(){
						$('#new_dialog').dialog('close');
						$('#new_dialog_ifram').html("");
					}}
				]
			});
			$('#new_dialog').dialog('open');
			$('#new_dialog').dialog('setTitle', '客户修改信息'); 
			$('#new_dialog_ifram')[0].src='./customer/log/index.action?customerId='+customer_id; 
        }
    </script>
<div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe name="new_dialog_ifram" scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 

