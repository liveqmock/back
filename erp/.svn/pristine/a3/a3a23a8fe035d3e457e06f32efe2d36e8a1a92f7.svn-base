<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="include/header.jsp"></s:include>
		<title>查询通告</title>

</head>
	<body>
		<table width="100%" border="0" align="left" cellspacing="0" >
			<thead>
				<tr>
					<td colspan="2" style="border-collapse: collapse; border: 0px; margin: 0px; padding: 0px;">
						<s:include value="include/top.jsp"></s:include>
					</td>
				</tr>
			</thead>
			<tfoot>
				<tr>
					<td colspan="2">
						<s:include value="include/bottom.jsp"></s:include>
					</td>
				</tr>
			</tfoot>
			<tbody>
				<tr>
					<td valign="top">
						<s:include value="../hengda/sale/include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top">
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						
				
<!--main-->
<table width="100%" class="mainbg20111112" style="height:100%">
  <tr>  
	
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
   <%-- 
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
    <div >
    <div class="right04"></div>
    <div class="right05">
   --%>
      <div class="titlel"></div>
        <div class="titlebg" style=" height:auto;overflow:hidden;">

	        <div class="title02"><a href="./article/search/all.action" target="_self">查询文章</a></div>	
	        <div class="title01" ><a href="./article/input/for_article.action" target="_self">录入文章</a></div>
	        
		<div class="right99"></div>
		<div class="blueline"></div>
          <div class="c"></div>
          <div class="c"></div>
          

 		<table width="100%" border="0" align="left" cellspacing="0">	
		  <form action="./article/search/all.action" method="post"> 	
		  <!-- 搜索表单 top -->
       
      
	   		 <tr style="white-space:nowrap">
	   		 <td colspan="6" height="0" align="left"> <label><span>标题&nbsp;</span></label>
     			<input  type="text" id="title" style="width:90px" name="cond.title" value="${cond.title }"/>
				<label> <span>类型&nbsp;</span></label>
              	&nbsp;
              	<select name="cond.articleType">
              		<option value="1" 
              		<s:if test="cond.articleType ==1">selected="selected"</s:if>
              		>系统公告</option>
              		<option value="2"
              		<s:if test="cond.articleType ==2">selected="selected"</s:if>
              		>更新公告</option>
              	</select>
              	
	
				<input type="submit" value=" 搜 索 " id="searchSubmit" />
			</td>
            </tr>
            
		</form>
		
		<!-- 搜索表单 end -->
		  <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
              </td>
              </tr>	
	<tr>
		<td colspan="6"><input  type="button" value="删除"  onclick="delArticle('delete')"/></td>
	</tr>
   <tr >
         <td colspan="6">			  
			  
	  <!--  列表 top -->	
		

			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
	
	
 
	
  	<tr class="gboxbg" align="center" nowrap="nowrap">
  	<td width="67"><input  type="checkbox" id="allDel" name="allDel" onclick="allDel()" /></td>
  	<td width="191">标题</td>
    <td width="177">文章类型</td>
    
    <td width="299">摘要</td>
	 <td width="126">顺序</td> 
	 
	<%--<td width="94" align="center" valign="middle" title="">
		crm项目	</td>
	<td width="107" align="center" valign="middle" title="">销售监控项目</td>
	
	  
  --%></tr>
  
   <s:iterator value="#request.articlelist" id="c">
	   <tr onMouseOver="this.style.backgroundColor='#FFFF99';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" nowrap="nowrap"> 
			<td align="center" valign="middle"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onclick="delId()" /></td>
			<td align="center" valign="middle">
				
				<a class="ablue" href="./article/update/for_article.action?articleId=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.title"/></a>
				
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.articleType"/>
			</td>
			
			<td align="center" valign="middle">
				<s:property value="#c.summary"/>
			</td>
			<td align="center" valign="middle">
				<s:property value="#c.orderIndex"/>
			</td>
			
			<%--<td align="center" valign="middle">
			<s:if test="#c.isCrm==1">是</s:if>
			<s:if test="#c.isCrm==0">否</s:if>
			</td>
			<td align="center" valign="middle">	
			<s:if test="#c.isSale==1">是</s:if>
			<s:if test="#c.isSale==0">否</s:if>	
			</td>
				
	  --%></tr>
   </s:iterator>
   
</table>


<!-- 列表 end -->
</td>
</tr>
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>
				</td>
            </tr>
            </table>
         </div>
       
     <%-- 
    <div class="right06"></div>
   
    </div>
     
		<div class="right01"></div>
		<div class="right02"></div>
		<div class="right03"></div>
		--%>
		<div class="c"></div>
     <div class="c"></div>
    </td>
  </tr>
</table>
<!--main.end-->
	
						</DIV>
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
				</tr>
			</tbody>

		</table>

	</body>
</html>
