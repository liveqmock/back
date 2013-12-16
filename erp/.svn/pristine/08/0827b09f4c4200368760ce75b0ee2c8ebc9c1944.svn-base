<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页</title>
	
	<link href="css/tianluan.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	<script type="text/javascript" language="javascript"
			src="<%=path%>/js/jquery-1.6.2.min.js"></script>
  </head>
  
  <body onLoad="clearSuggestion()">
   
   

<!--main-->
<table width="100%" border="0" cellspacing="0">
  <tr>
  
  	<!--left.top-->
	
	<s:include value="left.jsp"></s:include>

    <!--left.end-->	
  
  
	
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
    <div >
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
        <div class="titlebg" style=" height:auto;overflow:hidden;">

	        <div class="title02" ><a href="./user_role_priv!rolePrivRef_index.action" target="_self">查询参照</a></div>
            <div class="title01"><a href="./user_role_priv!addRefRolePriv_jsp.action" target="_self" >新建参照</a></div>
			
			&nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
			<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
			
			
          <div class="c"></div>
          <div class="c"></div>
		  
		  
          <table width="98%" border="0" align="left" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
       
		  
           
             <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>              </td>
              </tr>	
          			
			
            <tr>
				<td height="10" colspan="6"></td>
            </tr height="5">
	
            <tr>
              <td colspan="3">			  
			  
			  <!--  列表 top -->
			  		  
<table width="50%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
<div class="gbox1">
  <tr class="gboxbg">
        <td  align="center" valign="middle">权限code</td>      
        <td  align="center" valign="middle">权限名称</td>
		<td  align="center" valign="middle">排序ID</td>
  </tr>
    <s:iterator value="listpriv" id="p">
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
		<td width="30%" align="center">
			<s:property value="#p.privCode" />
		</td>
		<td width="30%" align="center" valign="middle">
			<s:property value="#p.privName" />
		</td>
		<td width="30%" align="center" valign="middle">
			<s:property value="#p.orderIndex" />
		</td>
		</tr>
    </s:iterator>
	<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"><td colspan="3">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>			</td></tr>
	</div>			
</table>


<!-- 列表 end --></td>
 
            </tr>
            <tr>
              <td colspan="6">
                		</td>
            </tr>
            </table>
        </div>
        <div class="titler"></div>
        <div class="c"></div>
    </div>
    <div class="right06"></div>
    <div class="c"></div>
    </div>
    <div class="right07"></div>
    <div class="right08"></div>
    <div class="right09"></div>
    <div class="c" ></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
  
</table>

   
   
   
  </body>
</html>
