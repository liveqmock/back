<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>认筹</title>
	
	<!--<link href="css/blue_new.css"  rel="stylesheet" type="text/css" charset="utf-8"/>-->
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 

  </head>
  
  <body onLoad="clearSuggestion()">
   
   

<!--main-->
<table width="100%" border="0" cellspacing="0">
  <tr>
  
  	<!--left.top-->
	
	<s:include value="../left.jsp"></s:include>

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

	        <div class="title02" ><a href="./presale_hengda!indexPresale.action" target="_self">查询认筹</a></div>
            <div class="title01"><a href="./presale_hengda!addPresale_jsp.action" target="_self">新建认筹</a></div>
			
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
		  
		  
          <table >		  
		  
		  <!-- 搜索表单 top -->
       
       <form action="presale_hengda!searchPresale.action" method="get">
		  
            <tr>
              <td width="0" nowrap bordercolor="#C4DAAB" >选择日期：
                <input type="text" class="Wdate" onClick="WdatePicker()" id="createdTime" name="cond.monitorDate" value="${cond.monitorDate}"/></td>
              <td height="0">&nbsp;</td>
            </tr>			
			
            <tr>
              
				  <td ><input name="submit" type="submit" id="searchSubmit" onClick="return check();" value=" 搜 索 "/></td>
				
					
			
			  
              <td height="0"><FONT color="red"><s:actionmessage/></FONT></td>
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
			  
			  操作： 	
				<input type="button" id="delete" value="删除" onClick="return delPre('presale_hengda')"/>
				
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
    <td width="20">
	<label for="checkbox">
	  <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>      
      </label>	 </td>

    <td width="197">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">日期</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresale.action?ob=11"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresale.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>	  </td>
      </tr>
      </table></td>
     <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">来访电话</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresale.action?ob=21"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresale.action?ob=22"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
	
    <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">来访人数</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresale.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresale.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
     <td width="187" align="center" valign="middle">当天认筹</td>
     <td width="187" align="center" valign="middle">累计认筹</td>
     <td width="187" align="center" valign="middle"></td>
  </tr>
  
  
   <s:iterator value="#request.listpre" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		<td width="22"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
		<td align="center" valign="middle" class="fontblue">
			<a href="presale_hengda!updatePre_jsp.action?id=${id}"> <s:property value="#c.monitorDate"/>	</a>	</td>
		<td align="center" valign="middle">
			<s:property value="#c.phoneNum"/>		</td>
		<td align="center" valign="middle">
			<s:property value="#c.visitorNum"/>		</td>
		<td align="center" valign="middle">	
			<s:property value="#c.intentionNum"/>		</td>
		<td align="center" valign="middle">
			<s:property value="#c.intentionAll"/>					</td>
		<td align="center" valign="middle">					</td>
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
