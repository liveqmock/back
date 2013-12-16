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
	
	<s:include value="../../customer/huijing/left.jsp"></s:include>

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

	        <div class="title02" ><a href="./user_huijing!indexUserAccount.action" target="_self">列表</a></div>
            <div class="title01"><a href="./user_huijing!addUserAccountJsp.action" target="_self" >新建</a></div>
			
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
       
       <form action="./user_huijing!indexUserAccount.action" method="get">
		  
            <tr>
              <td width="5%" height="0"></td>
              <td width="8%" height="0">&nbsp;</td>
              <td width="5%" height="0"></td>
              <td width="8%" height="0">&nbsp;</td>
              <td width="5%" height="0"></td>
              <td width="10%" height="0">&nbsp;</td>
            </tr>			
			
            <tr>
              <td width="100" height="0" nowrap>姓名：<input value="${userCond.userName}" name="userCond.userName" maxlength="10"/>
                <input type="submit" name="button3" id="button3" value="搜索"  align="left"/></td>
              <td height="0" colspan="3"></td>              
              <td width="182" height="0">				  </td>
              <td height="0">&nbsp;</td>
            </tr>
			  </form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>              </td>
              </tr>		
			  	 
		<s:if test="#session.type == 2">
	 
            <tr>
              <td height="20" colspan="6">

				
				<!-- 
				<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
				<a href="#" target="_blank" onClick="return false">增加</a> ｜  
				<a href="#" target="_blank" onClick="return false">追加</a> ｜  
				<a href="#" target="_blank" onClick="return false">批量删除</a>
				-->				</td>
            </tr>
		</s:if>
			
	
		
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    <td width="109">	 </td>

    <td width="197">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">姓名</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td></td>
          </tr>
          <tr>
            <td></td>
          </tr>
        </table>	  </td>
      </tr>
      </table></td>
     <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">公司</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./user_huijing!indexUserAccount.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./user_huijing!indexUserAccount.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
	
    <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">项目</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./user_huijing!indexUserAccount.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./user_huijing!indexUserAccount.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
      <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">账号</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./user_huijing!indexUserAccount.action?ob=11"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./user_huijing!indexUserAccount.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
     <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">状态</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td></td>
          </tr>
          <tr>
            <td></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
     <td width="187" align="center" valign="middle">&nbsp;</td>
  </tr>
  
  
  <s:iterator value="userAccountList" id="userlist">
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td width="109" align="center"><img src="<%=path%>/images/star-y.gif" width="17" height="16" /></td>
		<td align="center" valign="middle">
			<s:property id="realname" value="realName" />	</td>
		<td align="center" valign="middle">
			<s:property id="company" value="descCompanyId" />	</td>
		<td align="center" valign="middle">
			<s:property id="pro" value="descProjectId" />	</td>
		<td align="center" valign="middle"  class="fontblue">	
			<a
																		href="./user_huijing!updateUserAccountJsp.action?id=${id}"
																		target="_self"> <s:property value="userName" />
																	</a>	</td>
		<td align="center" valign="middle">
			<s:if test="#userlist.isDeleted == 0">
					 								 	正常													  	</s:if>
																	<s:else>
					  									禁用													  	</s:else>		</td>
		<td align="center" valign="middle">				</td>
	  </tr>
    </s:iterator>
</table>
</div>

<!-- 列表 end --></td>
            </tr>
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>			</td>
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
