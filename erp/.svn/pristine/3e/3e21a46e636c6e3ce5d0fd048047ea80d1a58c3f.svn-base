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
	
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<link href="./css/blue_guangzhou.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
		
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/jquery.easyui.min.js"></script>
	
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("uploadUnitImageDialog", "${closeMark}", "", "${uploadStr}");
		});
	</script>
	
	<script type="text/javascript" language="javascript">
	
		function saveImage(){
			var hiddenUnitId = $(window.parent.document).find("#hiddenUnitId").val();
			
			if(hiddenUnitId == undefined || hiddenUnitId == "" || hiddenUnitId == "0"){
				alert("请先选择单元");
				return false;
			}
			
			var unitImage = $("#unitImage").val();
			if(unitImage == ""){
				alert("请先选择文件");
				return false;
			}
			
			$("#unitIdValue").val(hiddenUnitId);
						
			return true;
		}
		
	</script>
	
</head>

<body>
<form id="upload" action="./saleunit_new/appoint/guangzhou/uploadUnitImage.action" method="post" enctype="multipart/form-data"> 
	<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
	 
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			类型
		</td>		
		 <td width="100" align="left" valign="middle">
			<s:select list="selImageType" name="type" id="type"></s:select>
			<input type="hidden" name="unitIdValue" id="unitIdValue" value="${unitId}"/>
		</td>
		  
	  </tr> 
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			描述
		</td>		
		 <td width="100" align="left" valign="middle">
			<input type="text" id="context" name="context"/>
		</td>
		  
	  </tr> 
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			<font color="#FF0000">*</font>图片
		</td>		
		 <td width="100" align="left" valign="middle">
		 	<input type="file" name="unitImage" id="unitImage"/>
		</td>
		  
	  </tr> 
	  
	  <%--
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">			
			<input type="hidden" name="unitIdValue" id="unitIdValue"/>
			<input type="submit" value="  上传  " onclick="return saveImage();"/>
		</td>		
		 <td width="100" align="center" valign="middle">
		 	<font color="#FF0000"><span id="uploadSuggestion">${uploadStr}</span></font>
		</td>
		  
	  </tr> 
	  --%>
 
	</table>
</form>
 </body>
 </html>