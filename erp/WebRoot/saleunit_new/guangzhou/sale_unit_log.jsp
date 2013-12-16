
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript">
	function more(time){
		if(time=="undefined")
			return;
			new MyAjaxIframeDialogX2({title:'查看批量详细信息', 
				width:750,
				height:385,
				src:'./saleunit_new/appoint/guangzhou/moreLogInfo.action?createdTime='+time,
				buttons:false
				});	
		}
</script>
<div class="gbox1">
		<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" bgcolor="blue" style="font-size:10px">
			<tr  bgcolor="#E9F5FF" style="line-height: 20px;"> 
				<th width="150" align="center">用户</th>
				<th width="150" align="center">时间</th>
				<th width="150" align="center">模块</th>
				<th width="150" align="center">类型</th>
				<th width="350" align="center">操作类容</th>
				<th width="150" align="center">电脑信息</th>
			</tr>
			<s:iterator value="logs" var="c">
			<tr  bgcolor="#ffffff" style="line-height: 20px;"> 
				<td width="150" align="center">${c.realName }</td>
				<td width="150" align="center">
					<s:date name="#request.c.createdTime" format="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td width="150" align="center">${c.modul}</td>
				<td width="150" align="center">${c.type }</td>
				<td width="350" align="center">${c.operationProcedure }</td>
				<td width="350" align="center">${c.computerInformationl }</td>
			</tr>
			</s:iterator>
		</table>
   
				
		</div>