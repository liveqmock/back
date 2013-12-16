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

	        <div class="title02" ><a href="./user_role_priv!rolePriv_index.action" target="_self">角色管理</a></div>
            
			
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
       
      
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>              </td>
              </tr>		
			  	 
		
			
	
		
            <tr>
              <td colspan="3">			  
			  
			  <!--  列表 top -->
<div class="gbox1">			  		  
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
          
        <td  align="center" valign="middle" >角色ID</td>
		<s:iterator value="listpriv" id="hlist">
		<td nowrap="nowrap" title="${hlist.privCode }">
			<s:property value="#hlist.privName"/>
		</td>	
		</s:iterator>
		<td></td>
  </tr>
   <s:iterator value="listtable" id="tablepp">
    <form action="./user_role_priv!rolePriv_update.action" method="post">
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
	  	<td  align="center"><s:property value="#tablepp.id"/></td>
	  	<s:iterator value="#tablepp.p" id="tablep">
		<s:if test="#tablep.ishave == true">
			<td  align="center"><input name="add.${privCode}" type="checkbox" checked="checked" value="1"/> </td>
		</s:if><s:else>
			<td  align="center"><input name="add.${privCode}" type="checkbox" value="1"/> </td>
		</s:else>
		
	   </s:iterator>
		<td>
		<input type="hidden" name="add.role_id" value="${tablepp.id}"/>
		<input type="submit" value=" 保 存 "/>  </td>
	  </tr>
	  </form>
    </s:iterator>
    	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    		 <td  align="center" valign="middle" >roleId </td>
				<s:iterator value="listpriv" id="hlist">
				<td nowrap="nowrap">
				<s:property value="#hlist.privName"/>
				</td>	
				</s:iterator>
				<td></td>
    	</tr>
    	
    	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    		 <form action="./user_role_priv!rolePriv_add.action" method="post">
    		 <td width="25"  align="center" valign="middle" ><input name="add.role_id" type="text" size="3" istyle="width=10%"/> </td>
				<s:iterator value="listpriv" id="hlist">
				
				<s:if test="#hlist.ishave == true">
		    	<td  align="center"><input name="add.${privCode}" type="checkbox" checked="checked" value="1"/> </td>
		        </s:if><s:else>
			    <td  align="center"><input name="add.${privCode}" type="checkbox" value="1"/> </td>
	        	</s:else>
				
				</s:iterator>
				<td><input type="submit" value=" 新 建  "/> </td>
				</form>
    	</tr>
</table>
</div>

<!-- 列表 end --></td>

            </tr>
            <tr>
              <td colspan="6" align="center">
                <font color="red" size="5"><s:actionmessage/>  </font>
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
