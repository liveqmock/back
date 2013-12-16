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
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="./js/contract_guangzhou_input.js"></script>	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
				
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
  </head>
  
 <body>
 
 
<%--固定的上部 --%>
<s:include value="../../customer/guangzhou/body_up.jsp">
</s:include>

<%--主体导航页头 --%>
<div class="title01" ><a href="<%=basePath%>saleunit/contract/guangzhou/searchList.action" target="_self">查询合同</a></div>
<div class="title02"><a href="<%=basePath%>saleunit/contract/guangzhou/getById.action?id=${contract.id}" target="_self">修改合同</a></div>	


<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_over">
		<b>主要信息</b>
	</div>				
	
	<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
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
	
	<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
		<a href="./saleunit/contract/guangzhou/searchContractService.action?contractId=${contract.id}">销售服务</a>						
	</div>
	<div class="d_out" onmouseover="this.className='d_over'" onmouseout="this.className='d_out'">
		<a href="./saleunit/contract/guangzhou/searchContractRenovate.action?contractId=${contract.id}">个性装修</a>
	</div> 		
	<div class="d_out">
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>					
	</div>
	
	<div class="blueline"></div>	
	<div class="right99"></div>	
	
	 </td>
	</tr>
</table>
	
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c"></div>	
		  
	  <form class="registerform" action="./saleunit/contract/guangzhou/updateContract.action" method="post" >	
		  
		  <table style="width: 800px;" align="left" border="0" cellspacing="0">		  
		  
		  <tr>
		  	<td colspan="4">
			

		 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >		
		 
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>客户名称&nbsp;</td>
                <td id="t16" style="width:30%" class="fontblue">
				 
				 <a href="#" onclick="return false;" id="showContractCustomer">${contract.customerName}</a>
				<input type='hidden' id='contractCustomerId'  name="contract.customerId" value="${contract.customerId}"/>

				</td>
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>联系电话&nbsp;</td>
                <td id="t16" style="width:30%">
			 	
				 <input type="text" id="phone" name="contract.phone" class="leftcreateinputbox01" value="${contract.phone}"/>
				 </td>
              </tr>		
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间&nbsp;</td>
				<td id="t16" style="width:30%">
					
					<a href="#" onclick="return false;" id="showConfirmUnitName">${unit.unitNo}</a>
      			 	<input type="hidden" id="hiddenUnitId" name="contract.unitId" value="${contract.unitId}"/>
				</td>
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房产类型&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selPropertyType"  name="contract.propertyType" cssStyle="width:auto" id="propertyType"/>
				</td>
			  </tr>
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">房间结构&nbsp;</td>
                <td id="t14">
					${unit.roomTypeStr}
				</td>		
                <td id="t15" style="width:15%" align="right">面积状态&nbsp;</td>
                <td id="t16" style="width:30%">
					${unit.areaStateStr}					
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑面积&nbsp;</td>
                <td id="t14">
				${unit.buildArea}	
				</td>		
                <td id="t15" style="width:15%" align="right">套内面积&nbsp;</td>
                <td id="t16" style="width:30%">
				${unit.insideArea}	
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑单价&nbsp;</td>
                <td id="t14">
				${unit.buildPrice} 元
				</td>		
                <td id="t15" style="width:15%" align="right">套内单价&nbsp;</td>
                <td id="t16" style="width:30%">
				${unit.insidePrice}	元
				</td>			
              </tr>	 
			 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">计价方式&nbsp;</td>
                <td id="t14">				
				<s:select list="selPriceWay"  name="contract.priceWay" cssStyle="width:auto" id="priceWay"
				value="#request.unit.priceWay" />
				</td>		
                <td id="t15" style="width:15%" align="right">标准总价&nbsp;</td>
                <td id="t16" style="width:30%">
				${unit.sumPrice} 元
				 </td>			
              </tr>	 
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>付款方式&nbsp;</td>
                <td id="t14">
				 	<s:select list="selPayType"  name="contract.payType" cssStyle="width:auto" id="payType"/>
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>折扣(%)&nbsp;</td>
                <td id="t16" style="width:30%">
					<input type="text" id="discountPercent" name="contract.discountPercent" class="leftcreateinputbox01" value="${contract.discountPercent}" style="width:25%"/>
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="buildPrice" name="contract.buildPrice" class="leftcreateinputbox01" style="width:25%" value="${contract.buildPrice}"/>
				 元
				</td>		
               <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>套内成交单价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="insideUnitPrice" name="contract.insideUnitPrice" class="leftcreateinputbox01" value="${contract.insideUnitPrice}" style="width:25%"/>
				 元
				</td>		
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="discountDesc" name="contract.discountDesc" class="leftcreateinputbox01" value="${contract.discountDesc}"/>
				 </td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间总价&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="sumMoney" name="contract.sumMoney" class="leftcreateinputbox01" value="${contract.sumMoney}" style="width:25%"/>
				 元
				</td>			
              </tr>	 
			  
			  
  			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>装修选择</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">装修标准&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="renovateDesc" name="contract.renovateDesc" class="leftcreateinputbox01" value="${contract.renovateDesc}"/>
				 </td>
                 <td id="t13" style="width:15%" align="right">装修单价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="renovatePrice" name="contract.renovatePrice" class="leftcreateinputbox01" value="${contract.renovatePrice}" style="width:25%"/>
				元
				</td>				
              </tr>	
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">是否并入合同&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selIsMerge" name="contract.isMerge" cssStyle="width:auto" id="isMerge"/>				 </td>
                 <td id="t13" style="width:15%" align="right">装修总价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="renovateMoney" name="contract.renovateMoney" class="leftcreateinputbox01" value="${contract.renovateMoney}" style="width:25%"/>
				元
				</td>					
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">个性装修约定交楼日期&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input class="Wdate" type="text" id="finishDate" style="width:90px" name="contract.finishDate" 
						 value='<s:date name="#request.contract.finishDate" format="yyyy-MM-dd "/>'/>
					 
				</td>
                 <td id="t13" style="width:15%" align="right"></td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>摘要</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">合同编号&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="contractNo" name="contract.contractNo" class="leftcreateinputbox01" value="${contract.contractNo}"/>				 </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				   <input type="text" id="shouldDeposit" name="contract.shouldDeposit" class="leftcreateinputbox01" value="${contract.shouldDeposit}" style="width:25%"/>
				 元					    </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>合同总价&nbsp;</td>
                <td id="t14">
				  <input type="text" id="contractMoney" name="contract.contractMoney" class="leftcreateinputbox01" value="${contract.contractMoney}" style="width:25%"/>
				 元				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>签署日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="signDate" style="width:90px" name="contract.signDate" 
						 value='<s:date name="#request.contract.signDate" format="yyyy-MM-dd "/>'/>
					</td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>业务归属日期&nbsp;</td>
                <td id="t14">
				 <input class="Wdate" type="text" id="workDate" style="width:90px" name="contract.workDate" 
						 value='<s:date name="#request.contract.workDate" format="yyyy-MM-dd "/>'/>
				 </td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">约定交房日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="deliveryDate" style="width:90px" name="contract.deliveryDate" 
						 value='<s:date name="#request.contract.deliveryDate" format="yyyy-MM-dd "/>'/>
					</td>
                 <td id="t13" style="width:15%" align="right">实际交房日期&nbsp;</td>
                <td id="t14">
				  <input class="Wdate" type="text" id="realHouseDate" style="width:90px" name="contract.realHouseDate" 
						 value='<s:date name="#request.contract.realHouseDate" format="yyyy-MM-dd "/>'/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">延期收楼日期&nbsp;</td>
                <td id="t16" style="width:30%">
				 	 <input class="Wdate" type="text" id="delayDate" style="width:90px" name="contract.delayDate" 
						 value='<s:date name="#request.contract.delayDate" format="yyyy-MM-dd "/>'/>
					 </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">合同备案号&nbsp;</td>
                <td id="t16" style="width:30%">
				     <input type="text" id="recordNo" name="contract.recordNo" class="leftcreateinputbox01" value="${contract.recordNo}"/>			    </td>
                 <td id="t13" style="width:15%" align="right">备案日期&nbsp;</td>
                <td id="t14">
				    <input class="Wdate" type="text" id="recordDate" style="width:90px" name="contract.recordDate" 
						 value='<s:date name="#request.contract.recordDate" format="yyyy-MM-dd "/>'/>
				</td>				
              </tr>	
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">推荐人&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="recommendMan" name="contract.recommendMan" class="leftcreateinputbox01" value="${contract.recommendMan}"/>
				</td>
                 <td id="t13" style="width:15%" align="right">业务员&nbsp;</td>
                <td id="t14">					
					
					 <input type="text" id="saleName" name="saleName" class="leftcreateinputbox01" value="${contract.saleName}"/>
					 <input type="hidden" id="hiddenSalesId" name="contract.salesId" value="${contract.salesId}"/>
				</td>				
              </tr>	
			  
			   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>贷款信息</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">按揭银行&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="contract.mortgageBank" name="contract.mortgageBank" class="leftcreateinputbox01" value="${contract.mortgageBank}"/>	
					
				 </td>
                 <td id="t13" style="width:15%" align="right">按揭贷款&nbsp;</td>
                <td id="t14">
					<input type="text" id="contract.mortgageMoney" name="contract.mortgageMoney" class="leftcreateinputbox01" value="${contract.mortgageMoney}"/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%"></td>
                 <td id="t13" style="width:15%" align="right">按揭年限&nbsp;</td>
                <td id="t14">
				<input type="text" id="mortgageYear" name="contract.mortgageYear" class="leftcreateinputbox01" value="${contract.mortgageYear}"/>
				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">公积金银行&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input type="text" id="fundBank" name="contract.fundBank" class="leftcreateinputbox01" value="${contract.fundBank}"/>
					
				</td>
                 <td id="t13" style="width:15%" align="right">公积金贷款&nbsp;</td>
                <td id="t14">
				 <input type="text" id="fundMoney" name="contract.fundMoney" class="leftcreateinputbox01" value="${contract.fundMoney}"/>
				 </td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"></td>
                <td id="t16" style="width:30%"></td>
                 <td id="t13" style="width:15%" align="right">公积金年限&nbsp;</td>
                <td id="t14">
				<input type="text" id="fundYear" name="contract.fundYear" class="leftcreateinputbox01" value="${contract.fundYear}"/>
				</td>				
              </tr>	
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="sub"/>
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
				  <input type="hidden" name="contract.id"  value="${contract.id}"/>
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>saleunit/contract/guangzhou/searchList.action'" />				</td>
			  </tr>			 
			</table>

			
		  </td>
		  </tr>
			
		  
           
            </table>
</form>

<%--主体table end --%>



<%--固定的底部 --%>
<s:include value="../../customer/guangzhou/body_bottom.jsp">
</s:include>
</table>  
   
  </body>
</html>
