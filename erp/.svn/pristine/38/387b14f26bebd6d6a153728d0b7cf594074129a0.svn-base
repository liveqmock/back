<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
<%@ page import="com.ihk.constanttype.ContUserId" %>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style type="text/css">
#pre2{
			color:#003C9D;
			width:150px;
			height:16px;
			background:#fafafa;
			border:1px solid #ccc;
			position:absolute;
			left:440px;
			top:0px;
			display:none;
		}
#cre2{
			color:#003C9D;
			width:200px;
			height:16px;
			background:#fafafa;
			border:1px solid #ccc;
			position:absolute;
			left:340px;
			top:0px;
			display:none;
	  }
#unitM{
			color:#003C9D;
			width:130px;
			height:16px;
			background:#fafafa;
			border:1px solid #ccc;
			position:absolute;
			left:70px;
			top:0px;
			display:none;
}
#unitZ{
			color:#003C9D;
			width:150px;
			height:16px;
			background:#fafafa;
			border:1px solid #ccc;
			position:absolute;
			left:170px;
			top:0px;
			display:none;
}
#unitP{
			color:#003C9D;
			width:130px;
			height:16px;
			background:#fafafa;
			border:1px solid #ccc;
			position:absolute;
			left:240px;
			top:0px;
			display:none;
}	  
</style>

<div class="easyui-tabs" fit="true" border="false" id="sale_tabs">
	<div title="单元信息" style="overflow: hidden;" id="_unit_map" uid=""> 
			<s:include  value="unit_info.jsp"/>
	</div>

    <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_UNITINFOMANAGER, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN ){%>

	<div title="单元资料管理" style="padding:0px;" id="_make_price" uid="" data-options="closable:true">
	</div>
    <%}%>
	
	<div title="单元图片" id="_unit_image" uid="">
	<!--
		<iframe scrolling="yes" frameborder="0"  src="./saleunit_new/guangzhou/unit_image.jsp" style="width:100%;height:100%;" id="uploadIfameId"></iframe>
	-->
		<s:include  value="../../saleunit_new/guangzhou/unit_image_div.jsp"/>
	</div>

    <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_QUESTION, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN ){%>

	<div title="售后客户问卷" style="padding:0px;" id="_customer_question" uid="">
		<p style="color:red">请先选择楼盘再进行操作</p>
	</div>
    <%}%>
	<!--  <div title="售前客户问卷" style="padding:0px;" id="_customer_question_befor" uid="" >
	</div>  -->
    <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_CONTRACTMANAGER, EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN ){%>

	<div title="合同管理" style="padding:0px;" id="_contract_manager" uid="" >
	</div>
    <%}%>
    	<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
	<div title="操作日志" id="_sale_unit_log_info" uid="">
			<s:include value="sale_unit_log.jsp"/>
	</div>
	<%}//end %>
</div>

