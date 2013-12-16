<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">		
	
	
<input type="button" value=" 删除所选 "/>
<input type="button" value=" 添加单元 "/>
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
			 <div style="height: auto;border: 0px solid #A9D9FF;background-color: ">
				 ${aa[0]}
				<table id="unitTable" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox tb1" style="margin: 0px;width:auto;" >
					 <s:iterator value="#request.aa" id="cc" begin="1">  
						${cc}
					 </s:iterator>
				</table>
			</div>
	</s:iterator>
						
	
   

