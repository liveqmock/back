<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="easyui-tabs" fit="true" border="false" id="sale_tabs">
	<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
	<div title="单元信息" style="" id="_unit_info" uid="" iconCls="icon-reload"> 
			<s:include  value="unit_info.jsp"/>
	</div>
	<%}//end %>
	
	<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
	<div title="客户资料"  style="padding:0px;" id="_customer_info" uid="">		
	</div>
	
	<div title="售后客户问卷"  style="" id="_question" uid="">			
	</div>
	<%}//end %>
	
	<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
	<div title="收款情况" id="_unit_pay_plan"   uid="">
			<!--<s:include  value="pay_info.jsp"/>-->
	</div>
	
	<!--
	<div title="收款明细" id="_unit_pay_bill"   uid="">		
	</div>
	-->
	
	<div title="单元操作"  style="padding:0px;" id="_unit_operation" uid="">		
	</div>
	
	<!--
	<div title="付款情况" id="_unit_pay_info"   uid="">		
	</div>
	-->
	
	<%}//end %>
	<%-- 
	<div title="认购情况"  style="" id="_unit_state_info" uid="">
			<s:include  value="sale_state_info.jsp"/>-->
	</div>
	--%>
	
	<%--
	<div title="自定义数据"  style="" id="_property_unit_define_info" uid="">
	</div>
	--%>
	
	<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
	<div title="单元图片" id="_unit_image" uid="">
	<!--
		<iframe scrolling="yes" frameborder="0"  src="./saleunit_new/guangzhou/unit_image.jsp" style="width:100%;height:100%;" id="uploadIfameId"></iframe>
	-->
		<s:include  value="unit_image_div.jsp"/>
	</div>
	<%}//end %>
	
	<%--
	<div title="赠品管理"  style="" id="_unit_gift" uid="">			
	</div>
	--%>
	
	<div title="客户服务事件"  style="" id="_customer_event_tabls" uid="">			
	</div>
	
	<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
	<div title="延期签约"  style="" id="_extension_contract" uid="">			
	</div>
	<%}//end %>
	
	<%--
	<div title="业主更名"  style="" id="_updatet_customer" uid="">			
	</div>
	--%>
	
	<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
	<div title="操作日志" id="_sale_unit_log_info" uid="">
			<s:include value="sale_unit_log.jsp"/>
	</div>
	<%}//end %>
</div>
