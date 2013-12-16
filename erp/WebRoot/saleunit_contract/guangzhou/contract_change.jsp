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
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 

	<script type="text/javascript">
			$().ready(function(){
				$(".cilcka").click(function(){
						var obj = new Object();
						obj.type = "iframe";
						obj.value = "./saleunit/contract/guangzhou/searchChangeInfomation.action?" 
							+ "changeType=" + $(this).attr("changetype")+"&changeId="+$(this).attr("changeid")
							+"&contract.id="+$("#this_confirm_id").val();
						obj.width = "640px";
						obj.height = "400px";
						var dialog = new Dialog(obj,{title:'<font color="black">'+$(this).attr("titt")+'</font>', fixed:true, isReload:false});	
						dialog.show();
						return false;
					
				});
				
				$("#add_price_butt").click(function(){
					var obj = new Object();
					obj.type = "iframe";
					obj.value = "./saleunit/contract/guangzhou/addChangePrice.action?" 
						+"&contract.id="+$("#this_confirm_id").val();
					obj.width = "640px";
					obj.height = "400px";
					var dialog = new Dialog(obj,{title:'<font color="black">'+$(this).attr("titt")+'</font>', fixed:true, isReload:true});	
					dialog.show();
					return false;
					});	
				$("#add_out_butt").click(function(){
					var obj = new Object();
					obj.type = "iframe";
					obj.value = "./saleunit/contract/guangzhou/addChangeOut.action?" 
						+"&contract.id="+$("#this_confirm_id").val();
					obj.width = "640px";
					obj.height = "400px";
					var dialog = new Dialog(obj,{title:'<font color="black">'+$(this).attr("titt")+'</font>', fixed:true, isReload:true});	
					dialog.show();
					return false;
					});	
				$("#add_unit_butt").click(function(){
					var obj = new Object();
					obj.type = "iframe";
					obj.value = "./saleunit/contract/guangzhou/addChangeUnit.action?" 
						+"&contract.id="+$("#this_confirm_id").val();
					obj.width = "640px";
					obj.height = "400px";
					var dialog = new Dialog(obj,{title:'<font color="black">'+$(this).attr("titt")+'</font>', fixed:true, isReload:true});	
					dialog.show();
					return false;
					});	
				$("#add_owner_butt").click(function(){
					var obj = new Object();
					obj.type = "iframe";
					obj.value = "./saleunit/contract/guangzhou/addChangeOwner.action?" 
						+"&contract.id="+$("#this_confirm_id").val();
					obj.width = "640px";
					obj.height = "400px";
					var dialog = new Dialog(obj,{title:'<font color="black">'+$(this).attr("titt")+'</font>', fixed:true, isReload:true});	
					dialog.show();
					return false;
					});	
			});
		</script>	
  </head>
  
 <body>
 
 
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
					<div class="d_over">
						<b>申请变更</b>
					</div> 
					<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
						<a href="./saleunit/contract/guangzhou/searchPropertyOwner.action?contractId=${contract.id}">权益人</a>
					</div>
							
					<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
						<a href="./saleunit/contract/guangzhou/searchContractService.action?contractId=${contract.id}">销售服务</a>
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
			  <input type="button" value="  价格变更  "   titt="价格变更申请"  id="add_price_butt"/>
              <input type="button" value="  换房  "  titt="换房 申请" id="add_unit_butt"/>
              <input type="button" value="  权益人变更  "   titt="权益人变更申请"  id="add_owner_butt"/>
              <input type="button" value="  退房  "    titt="退房申请 "  id="add_out_butt"/>
              <input type="hidden" value="${contract.id}" id="this_confirm_id"/>
              </td>
            </tr>
		
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" width="100%">
				  <tr class="gboxbg">
				    
					 <td align="center" width="100px">
					
					 </td>
				
					
				    <td align="center" valign="middle">变更类型</td>   
					
				    <td align="center">申请人</td>
					
					<td align="center">申请时间</td>
					
				  
					
					 <td align="center" valign="middle">
						申请状态
					</td>
	
	
	
  
  </tr>
 
 
  
   <s:iterator value="#request.changePriceList" id="alist">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		<td align="center">
			 
			<b  changetype="price" changeid="${id}" class="cilcka" titt="价格变更"   style="color: #1199FF;cursor: pointer;text-decoration: underline">查看</b>
		</td>
		<td align="center" valign="middle" >
			价格
		</td>
		<td align="center" valign="middle">
				${descApplyUser }
		</td>
		<td align="center" valign="middle" >
			
			<s:date name="#request.applyDate" format="yyyy-MM-dd"/>
		</td>
		<td align="center" valign="middle">
			${descApplyState}
		</td>
    </s:iterator>
	 <s:iterator value="#request.changeOutList" id="blist">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		<td align="center">
			<b  changetype="out" changeid="${id}" class="cilcka" titt="退房"  style="color: #1199FF;cursor: pointer;text-decoration: underline">查看</b>
		</td>
		<td align="center" valign="middle" >
			退房
		</td>
		<td align="center" valign="middle">
			${descApplyUser }
		</td>
		<td align="center" valign="middle" >
			<s:date name="#request.applyDate" format="yyyy-MM-dd"/>
		</td>
		<td align="center" valign="middle">
			${descApplyState}
		</td>
    </s:iterator>  
     <s:iterator value="#request.changeUnitList" id="clist">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		<td align="center">
			<b  changetype="unit" changeid="${id}" class="cilcka" titt="换房"  style="color: #1199FF;cursor: pointer;text-decoration: underline">查看</b>
		</td>
		<td align="center" valign="middle" >
			换房
		</td>
		<td align="center" valign="middle">
			${descApplyUser }
		</td>
		<td align="center" valign="middle" >
			<s:date name="#request.applyDate" format="yyyy-MM-dd"/>
		</td>
		<td align="center" valign="middle">
			${descApplyState}
		</td>
    </s:iterator>  
     <s:iterator value="#request.changeOwnerList" id="dlist">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		<td align="center">
			 <b  changetype="owner" changeid="${id}" class="cilcka" titt="权益人"   style="color: #1199FF;cursor: pointer;text-decoration: underline">查看</b>
		</td>
		<td align="center" valign="middle" >
			权益人
		</td>
		<td align="center" valign="middle">
				${descApplyUser }
		</td>
		<td align="center" valign="middle" >
			<s:date name="#request.applyDate" format="yyyy-MM-dd"/>
		</td>
		<td align="center" valign="middle">
			${descApplyState}
		</td>
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

