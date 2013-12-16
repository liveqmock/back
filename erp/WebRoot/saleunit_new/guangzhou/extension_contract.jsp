<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<script type="text/javascript" language="javascript">	

	$(document).ready(function(){
		
		var isShowModify = ${showModify};
		if(!isShowModify){
		
			$("#add").hide();
			$("#update").hide();
			$("#delete").hide();
			
		}
		
	});

	$("#exTable tr").click(function(){
		var exId = $(this).attr("exId");
		
		if(exId == '0' || exId == undefined || exId == ""){
		
			return false;
		}else{
		
			$(".exChangetd").removeClass("exChangetd");				
			$(this).addClass("exChangetd");
		}
		
	});
	
</script>

<div class="gbox1">			  
		  
<table width="90%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" id="exTable">

  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px; text-align:center"> 
  	<td>
		<a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline" onclick="return canShowOrUpdate(false)">查看</a>
	</td>
	
	<td>
		<a href="javascript:void(0)" id="add" style="color:#1199FF; text-decoration:underline" onclick="return extensionContractAddDiv()">新建</a>
	</td>
	
	<td>
		<a href="javascript:void(0)" id="update" style="color:#1199FF; text-decoration:underline" onclick="return canShowOrUpdate(true)">修改</a>
	</td>
	
	<td>
		<a href="javascript:void(0)" id="delete" style="color:#1199FF; text-decoration:underline" onclick="return canDelete()">删除</a>
	</td>
	
	<td colspan="2"></td>
	
	<td>当前客户</td>
	
	<td colspan="2">
		<s:select list="customerMap" cssStyle="width:auto" id="conCustomerId" name="conCustomerId"/>
	</td>
  </tr>
 
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
	
	 <td width="100" align="center" valign="middle">
	 	申请日期
	</td>  
	
	 <td width="100" align="center" valign="middle">
	 	客户已付金额
	</td> 
	
	 <td width="100" align="center" valign="middle">		
	 	原约定签约日期
	</td> 
	
	 <td width="100" align="center" valign="middle">
	 	延期签约天数
	</td>  
	
	 <td width="100" align="center" valign="middle">
	 	改为签约日期
	</td> 
	
	 <td width="100" align="center" valign="middle">		
	 	是否首次延期
	</td> 
	
	 <td width="100" align="center" valign="middle">
	 	延期签约原因
	</td>  
	
	 <td width="100" align="center" valign="middle">
	 	延期批准人
	</td> 
	
	 <td width="100" align="center" valign="middle">		
	 	延期批准日期
	</td> 
	  
  </tr> 
  
   <s:iterator value="#request.exList" id="c">  
   	
	 <tr bgcolor="#FFFFFF" style="line-height: 20px;" exId="${c.id}"> 
	
	 <td width="100" align="center" valign="middle">
	 	<s:date name="#c.applyTime" format="yyyy-MM-dd "/> 
	</td>  
	
	 <td width="100" align="center" valign="middle">
	 	${payBill.hadPay}
	</td> 
	
	 <td width="100" align="center" valign="middle">	
		<s:date name="#c.oldSignDate" format="yyyy-MM-dd "/>
	</td> 
	
	 <td width="100" align="center" valign="middle">
	 	${c.extensionDay}	</td>  
	
	 <td width="100" align="center" valign="middle">
	 	${c.newApplyTime}
	</td> 
	
	 <td width="100" align="center" valign="middle">		
	 	${c.extensionFirstStr}
	</td> 
	
	 <td width="100" align="center" valign="middle">
	 	${c.extensionReason}
	</td>  
	
	 <td width="100" align="center" valign="middle">
	 	${c.approvedMan}
	</td> 
	
	 <td width="100" align="center" valign="middle">		
	 	<s:date name="#c.approvedDay" format="yyyy-MM-dd "/> 
	</td> 
	  
  </tr> 
	
   </s:iterator>
  
  
  
</table>

</div>	

