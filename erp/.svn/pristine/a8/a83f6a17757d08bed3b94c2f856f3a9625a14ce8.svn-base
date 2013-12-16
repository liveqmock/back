<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>查询预约排号</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_alldel.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_common.js"></script>	 
		
	<script type="text/javascript" language="javascript">
		$(document).ready(function(){				
			
			projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
			
			obIcon();
			
		});
			
		function resetValue(){
			
			$("#projectName").val("");
			$("#unitId").val("");
			$("#realNum").val("");
			$("#unitNum").val("");
			$("#date1").val("");
			$("#date2").val("");
			$("#salesId").val("");
			$("#customerName").val("");			
			
			$("#hiddenId").val("0");
			
			return true;
		}
		
	</script>
	
	<style>
		*{margin:0;padding:0;}
		
	</style>
	
  </head>
  
 <body onload="clearSome('suggestion', 2000)">
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title02" ><a href="./saleunit/appoint/guangzhou/index.action" target="_self">查询预约排号</a></div>
<div class="title01"><a href="./saleunit/appoint/guangzhou/forInput.action" target="_self">新建预约排号</a></div>	
<div class="right99"></div>
<div class="blueline"></div>		
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c">		  	
			  &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
		  </div>	
		  
		  <table style="width: -moz-available;" align="left" border="0" cellspacing="0">		  
		  
		  <!-- 搜索表单 top -->
       
     <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/saleunit/appoint/guangzhou/index.action" method="post" >
		  <tr>
		  	<td colspan="6">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">
		 
  			<tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle" width="180">项目</td>
	
	<td width="187" align="left" valign="middle">
		<input type="text" id="projectName" name="cond.propertyName" value="${cond.propertyName}"/>	
		<input type="hidden" id="hiddenId" name="cond.propertyId" value="${cond.propertyId}"/>
		</td>
	
   <td align="center" valign="middle" width="180">
	客户名称	</td>
	
     <td width="187" align="left" valign="middle">
	 	<input type="text" id="customerName" name="cond.customerName" value="${cond.customerName}"/>
	 </td>
	
   <td align="center" valign="middle">
	业务员	</td>
	
     <td width="187" align="left" valign="middle">
	 	<input type="text" id="salesId" name="cond.salesId" value="${cond.salesId}"/>
	 </td>
	 
  </tr>
  
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle">房间</td>
	
	<td width="187" align="left" valign="middle">
		<input type="text" id="unitId" name="cond.unitId" value="${cond.unitId}"/>	
	</td>
	
   <td align="center" valign="middle">
	项目排号	</td>
	
     <td width="187" align="left" valign="middle" style="white-space:nowrap">
	 	<input type="text" id="realNum" name="cond.realNum" value="${cond.realNum}"/>
	 </td>
	
   <td align="center" valign="middle">
	 房间排号	 </td>
	 
     <td width="120" align="left" valign="middle">
	 	<input type="text" id="unitNum" name="cond.unitNum" value="${cond.unitNum}"/>
	 </td>
	 
  </tr>
  
  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

    <td align="center" valign="middle">
		预约日期	</td>
	
	<td width="200" align="left" valign="middle" style="white-space:nowrap">
	<input class="Wdate" type="text" id="date1" style="width:90px" name="cond.date1" value="${cond.date1}"/>		
	-
	<input class="Wdate" type="text" id="date2" style="width:90px" name="cond.date2" value="${cond.date2}"/></td>
	
   <td align="center" valign="middle">
   	<input type="submit" value="  搜索  " id="searchSubmit"/>
		&nbsp;&nbsp;
		<!-- 
		<input type="button" value="  清空  " onclick="resetValue()"/>	
		-->
   </td>
	
     <td width="187" align="left" valign="middle"></td>
	 <td width="187" align="left" valign="middle"></td>
	 <td width="187" align="left" valign="middle"></td>
	
   
  </tr>
  
  </table>

			
			
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
              <td height="20" colspan="6">
				<div id="load"></div>
				
				</td>
            </tr>
			
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    
	 <td width="20" align="center">
	<label for="checkbox">
	  <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>      
      </label>
	 </td>

    <td width="197">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">客户名称</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=14"><img id="img14" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=13"><img id="img13" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>
	  </td>
      </tr>
      </table></td>
   
	
    <td width="120">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">预约日期</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=18"><img id="img18" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=17"><img id="img17" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	</td>
      </tr>
    </table>
	</td>
	
	<td width="120">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">失效日期</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=20"><img id="img20" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=19"><img id="img19" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	</td>
      </tr>
    </table>
	</td>
	
     <td width="187" align="center" valign="middle">
		房间
	</td>
	
	 <td width="100" align="center" valign="middle">
		房间排号
	</td>
	
	<td width="100" align="center" valign="middle">
		项目排号
	</td>
	
	
	 <td width="100">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80%" align="center" valign="middle">应收预约金</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=12"><img id="img12" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="./saleunit/appoint/guangzhou/searchOrderBy.action?ob=11"><img id="img11" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>
	</td>
      </tr>
    </table></td>
	
	
	 <td width="100" align="center" valign="middle">
		币种
	</td>
	
	 <td width="100" align="center" valign="middle">
		业务员
	</td>
   
   <td width="50" align="center" valign="middle">
		操作
	</td>
  </tr>
 
 
  
   <s:iterator value="#request.appintList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
	   title='客户名称:<s:property value="#c.customerName"/>, 预约日期:<s:date name="#c.appointDate" format="yyyy-MM-dd "/>'> 
		<td width="20" align="center"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
		<td align="center" valign="middle" class="fontblue">
			<a href="./saleunit/appoint/guangzhou/getById.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.customerName"/></a>
		</td>
		
		<td align="center" valign="middle">
			<s:date name="#c.appointDate" format="yyyy-MM-dd "/>
		</td>
		<td align="center" valign="middle">
			<s:date name="#c.endDate" format="yyyy-MM-dd "/>
		</td>
		<td align="center" valign="middle">	
			<s:property value="#c.unitId"/>
		</td>
		<td align="center" valign="middle">
			<s:property value="#c.realNum"/>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.propertyId"/>
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.apponitMoney"/>
		</td>
		
		<td align="center" valign="middle">
			人民币
		</td>
		
		<td align="center" valign="middle">
			<s:property value="#c.salesId"/>
		</td>
		
		<td align="center" valign="middle" class="fontblue">
			
		</td>
		
	  </tr>
    </s:iterator>
  
</table>
</div>

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


<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

