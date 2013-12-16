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
	
	<title>修改合同</title>
	
	<base href="<%=basePath%>">
		
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_alldel.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_common.js"></script>	 
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/contract_service_guangzhou.js"></script>
	
	<style>
		*{margin:0;padding:0;}
		
	</style>
	
  </head>
  
 <body onload="clearSome('suggestion', 2000)">
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="<%=basePath%>saleunit/contract/guangzhou/searchList.action" target="_self">查询合同</a></div>
<div class="title02"><a href="<%=basePath%>saleunit/contract/guangzhou/getById.action?id=${contract.id}" target="_self">修改合同</a></div>	

<%--主体table top --%>
		
  		<div class="c"></div>
         		  
		  <table style="width: 100%;" align="left" border="0" cellspacing="0">		  
		  
		  
           <tr>
              <td height="10" colspan="6">
			  
			  	<table width="100%" border="0" cellspacing="0" class="d_top">
                <tr>
                  <td bgcolor="#edf8fe">
					
					<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
						<a href="./saleunit/contract/guangzhou/getById.action?id=${contract.id}">主要信息</a>
					</div>				
					
					<div class="d_out">
						<a href="./saleunit/contract/guangzhou/searchAddonProperty.action?contractId=${contract.id}">附属房产</a>
					</div>
					<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
						<a href="./saleunit/contract/guangzhou/searchPayDetail.action?contractId=${contract.id}">付款情况</a>
					</div> 
					<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
						<a href="./saleunit/contract/guangzhou/addChangeIndex.action?contract.id=${contract.id}">申请变更</a>
					</div>
					<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
						<a href="./saleunit/contract/guangzhou/searchPropertyOwner.action?contractId=${contract.id}">权益人</a>
					</div>
						
					<div class="d_over">
						<b>销售服务</b>
					</div> 
					<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
						<a href="./saleunit/contract/guangzhou/searchContractRenovate.action?contractId=${contract.id}">个性装修</a>
					</div>					
					<div class="d_out">
						<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>					
					</div>						
                  </td>
                </tr>
              </table>
			  
              </td>
            </tr>		
			
			
			<tr>
              <td height="10" colspan="6">
		 		<div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  					  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" > 				 
					
						<td align="center" valign="middle" width="18%">楼盘项目</td>
						
						<td width="18%" align="left" valign="middle">${contract.propertyProjectName}</td>
						
						<td align="center" valign="middle" width="18%">分区楼栋</td>
						
						<td width="18%" align="left" valign="middle">${contract.propertyBuildName}</td>
						
						<td align="center" valign="middle" width="18%">房间</td>
						
						<td width="18%" align="left" valign="middle">${contract.propertyUnitNo}</td>
						 
					  </tr>
					  
					 <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" >	 
					
						<td align="center" valign="middle" width="18%">客户名称</td>
						
						<td width="18%" align="left" valign="middle">${contract.customerName}</td>
						
						<td align="center" valign="middle" width="18%">合同总价</td>
						
						<td width="18%" align="left" valign="middle">${contract.contractMoney}元</td>
						
						<td align="center" valign="middle" width="18%">签署日期</td>
						
						<td width="18%" align="left" valign="middle"><s:date name="#request.contract.signDate" format="yyyy-MM-dd "/></td>
						 
			    </tr>					  
					
		  			</table>
					
					</div>
			  </td>
			 </tr>
			 
			 <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>
			  <input type="button" value="  新建销售服务  " onclick="inputContractServiceDialog(${contract.id})"/>
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

	
    <td width="120" align="center" valign="middle">服务项目</td>   
	
    <td width="120" align="center" valign="middle">承诺办理时间</td>
	
	<td width="120" align="center">承诺完成时间
	</td>
	
     <td width="100" align="center" valign="middle">服务进程
	</td>
	
	 
  </tr>
 
 
  
   <s:iterator value="#request.contractServiceList" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		<td width="20" align="center"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
				
		<td align="center" valign="middle" class="fontblue" title="点击修改">
			<a href="#" onclick="return updateContractServiceDialog(${c.id})">${c.serviceTypeStr}</a>
			
		</td>
		<td align="center" valign="middle">
			<s:date name="#c.promiseDoDate" format="yyyy-MM-dd "/>
		</td>
		
		<td align="center" valign="middle">
			<s:date name="#c.promiseFinishDate" format="yyyy-MM-dd "/>
		</td>
		<td align="center" valign="middle">
			${c.stepStateStr}
		</td>
		
		
	  </tr>
    </s:iterator>
  
</table>
</div>

<!-- 列表 end -->


</td>
            </tr>
			
	<%-- 不用分页
            <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
			</td>
            </tr>
	--%>
 </table>


<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
</body>
</html>

