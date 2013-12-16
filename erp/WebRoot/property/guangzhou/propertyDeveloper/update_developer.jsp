<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="../../../customer/guangzhou/header.jsp"></s:include>	
		<s:include value="../../../customer/guangzhou/header_left_js.jsp"></s:include>	
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/guangzhou_input_valdate.js"></script>
		<title>修改开发商</title>
		<style >
			.tb1 input{width:100%}
			.redbor {border: 2px solid red}
			em{margin-right: 5px;color: red}
			.poppng{background:url(<%=basePath%>/images/pop.png) no-repeat}
			.err_input_class{border-color: red;border-width: 2px}
		</style>
		<script type="text/javascript">
			$().ready(function(){
				 $("#inname").inputVal({			
						errClass:'err_input_class',
						errDiv:'org_box',
						minlength:1,
						maxlength:30
				 });
				
				$('#subbt').click(function(){
					if($.trim($('#inname').val()) == '' ){
						alert("开发商名称不能为空");
						$('#inname').text('');
						$('#inname').focus();
						$('#inname').addClass('redbor')
						return false;
						}
					if(confirm('确定要修改记录吗?')){return true;}return false;
				});
				$('input').blur(function(){
					$(this).removeClass('redbor')		
				})
			});
		</script>
	</head>
	<body>
	
<%--固定的上部 --%>

<s:include value="../../../customer/guangzhou/body_up.jsp">
</s:include>	

<%--主体导航页头 --%>
<div class="title02" ><a href="./property/developer/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">开发商</a></div>
<div class="title01" ><a href="./property/project/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>">楼盘项目</a></div>
<div class="title01" ><a href="./property/area/searchIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">分区</a></div>
<div class="title01" ><a href="./property/build/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼栋</a></div>


<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		<a href="./property/developer/index.action">查询开发商</a>
	</div>		
	<div class="d_out">
		<a href="./property/developer/input_index.action">新建开发商</a>
	</div>		
	

	<div class="d_out">
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>					
	</div>
		
	 </td>
	</tr>
</table>
<div class="right99"></div>
<div class="blueline"></div>
<%--主体table --%>
	<div style="width: 60%;height: inherit;float: left;vertical-align: top;">
	<form action="./property/developer/update.action" method="post">
			<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="margin-top: 10px;">
				<tr bgcolor="#FFFFFF";">
					<td width="90px">&nbsp;&nbsp;<em>*</em>开发商名称</td>
					<td>&nbsp;<input id="inname" type="text" value="${updateDeveloper.developerName}" name="updateDeveloper.developerName" style="width: 80%"/></td>
				</tr>
				<tr bgcolor="#FFFFFF";">
					<td>&nbsp;&nbsp;备注</td>
					<td>&nbsp;<input  type="text" value="${updateDeveloper.remark }" name="updateDeveloper.remark" style="width: 80%" /></td>
				</tr>
				<tr bgcolor="#FFFFFF";">
					<td></td>
					<td> 
					<input type="hidden" value="${updateDeveloper.id }" name="updateDeveloper.id"/>
					&nbsp;&nbsp;<input type="submit" value="  修改  "/>&nbsp;<a href="./property/project/input_index.action?inputProPro.developerId=${updateDeveloper.id}" style="color:#1199ff">
						新建楼盘</a>
						<s:actionmessage cssStyle="color:red"/>
					</td>
				</tr>
		</table></form>
	</div>
<%--POP --%>
<div id="org_box" class="poppng" style="height:20px; width:250px;
	  position:absolute; display: none;font-size: 12px;padding: 3px; overflow: hidden;"></div>
<%--固定的底部 --%>
<s:include value="../../../customer/guangzhou/body_bottom.jsp">
</s:include>
	</body>
</html>
