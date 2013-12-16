<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
	<base href="<%=basePath%>">		
	
	<script type="text/javascript" language="javascript">
	
		$(document).ready(function() {
		
			$("#unitTable td").bind({
				
				//设置显示及单元隐藏id
				click : function() {
					tdClick(this);
				},
				//给单元格加鼠标经过的背景颜色
				mouseover : function() {
					tdOver(this);
				},
				mouseout : function() {
					tdOut(this);
				}
		
			});
			
		});
	</script>
	

<s:if test="#request.trList.size > 0">
	<div style="height: auto;border: 0px solid #A9D9FF;float: left;">
		<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;">
			 <s:iterator value="#request.trList" id="c">  
				${c}
			 </s:iterator>
		</table>

	</div>
</s:if>	
	
	 <s:iterator value="#request.groList" id="aa">  
			 <div style="height: auto;border: 0px solid #A9D9FF;">
				 ${aa[0]}
				<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;" >
					 <s:iterator value="#request.aa" id="cc" begin="1">  
						${cc}
					 </s:iterator>
				</table>
			</div>
	</s:iterator>

<!-- 不使用这种方式
<input type="hidden" id="_default_load_build_id" value="${_default_load_build.id}" />
-->
