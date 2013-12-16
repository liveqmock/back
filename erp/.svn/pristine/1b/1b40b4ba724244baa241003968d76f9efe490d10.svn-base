<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<div class="gbox1">			  
		  
<table width="50%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" id="imageTable">
 
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;" class="imageTr"> 
	
	 <td width="100" align="center" valign="middle">
	 	<a id="unitImageUnload" href="javascript:void(0)" style="color:#1199FF; text-decoration:underline" onclick="return toUnloadImage();">上传</a>
	</td>  
	
	 <td width="100" align="center" valign="middle">
	</td> 
	
	 <td width="100" align="center" valign="middle">		
	</td> 
	  
  </tr> 
  
</table>

</div>	


<div id="unitImageDialog" class="easyui-dialog" closed="true" modal="true" title="查看图片" style="display:hidden;text-align:center; "> 	

	<img id="unitImageDialogImgId" style="width:auto; height:auto"/>
	<!--	
	<iframe scrolling="auto" id='show_image_dialog_ifram' frameborder="0" src="./saleunit_new/guangzhou/loading.jsp" style="width:100%;height:100%;"></iframe> 
	-->
</div>

<div id="uploadUnitImageDialog" class="easyui-dialog" closed="true" modal="true" title="上传图片" style="display:hidden;width:400px;height:160px; "> 	
	<iframe scrolling="auto" id='upload_image_dialog_iframe' frameborder="0" style="width:100%;height:100%;"></iframe> 
</div>