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
<title>客户信息历史记录</title>

<s:include value="../../header/header_easyui.jsp"></s:include>
<style type="text/css">
</style>

 <script type="text/javascript">
        $().ready(function(){
        	$(".loga").click(function(){
        		dialog_customerlog_info($(this).attr('logid'))
            })
        })

        function dialog_customerlog_info(logid){
			$("#new_dialog").dialog({
				resizable: true,
				modal:true, 
				maximizable: false, 
				width:500,
				height:300,
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
			$('#new_dialog').dialog('setTitle', '修改前客户信息'); 
			$('#new_dialog_ifram')[0].src='./customer/log/logInfo.action?customerLogId='+logid; 
        }
    </script>
</head>
<body>
<table border="0" align="" cellpadding="0" cellspacing="1" class="gbox unit_table" >
<thead>
	<tr class="gboxbg">
		<th width="150px">修改时间</th>
		<th width="150px">修改人员</th>
		<th width="150px">客户姓名(原)</th>
		<th width="150px">电话(原)</th>
		<th width="150px">固定电话(原)</th>
		<th width="150px">详细信息</th>
	</tr>
</thead>
<tbody style="background-color: #ffffff">
	<s:iterator value="customerLogList" var="c">
	<tr style="line-height: 24px;">
		<td style="padding-left: 5px">
			<s:date name="#request.c.logCreatedTime" format="yyyy-MM-dd HH:mm"/>
		</td>
		<td style="padding-left: 5px">${c.descLogCreatedId}</td>
		<td style="padding-left: 5px">${c.customerName}</td>
		<td style="padding-left: 5px">${c.phone}</td>
		<td style="padding-left: 5px">${c.homePhone}</td>
		<td style="padding-left: 5px"><a class="loga" logid='${c.id}' style="color: blue;cursor: pointer;">查看</a> </td>
	</tr>
	</s:iterator>
</tbody>
</table>
<div id="new_dialog" class="easyui-dialog" closed="true" modal="true" title="标题" style="display:block;width:500px;height:250px; overflow-x:hidden"> 			
    	<iframe name="new_dialog_ifram" scrolling="auto" id='new_dialog_ifram' frameborder="0"  src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	</div> 
</body>
</html>

