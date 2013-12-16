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
	<title>新建认购</title>	
	<base href="<%=basePath%>">			
	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>	 
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_common.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	<script type="text/javascript" language="javascript" src="./js/confirm_guangzhou_input.js"></script>	
	
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
<div class="title01" ><a href="<%=basePath%>saleunit/confirm/guangzhou/searchList.action" target="_self">查询认购</a></div>
<div class="title02"><a href="<%=basePath%>saleunit/confirm/guangzhou/forInput.action" target="_self">新建认购</a></div>	
<table width="100%" border="0" cellspacing="0" class="d_top">
	<tr>
	  <td bgcolor="#edf8fe">
	  
	<div class="d_out">
		第一步:选择楼栋
	</div>		
	<div class="d_out">
		第二步:选择房间
	</div>		
	<div class="d_out">
		第三步:选择客户
	</div>
	<div class="d_over">
		<b>第四步:主要信息</b>
	</div> 

	<div class="d_out">
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>					
	</div>
		
	 </td>
	</tr>
</table>	
		
<%--主体table top --%>
		
  		<div class="c"></div>
          <div class="c"></div>	
		  
	  <form class="registerform" action="./saleunit/confirm/guangzhou/inputConfirm.action" method="post" >	
		  
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
				 <a href="#" onclick="return false;" id="showConfirmCustomer">${customer.customerName}</a>
				 <input type='hidden' id='confirmCustomerId' name="confirm.customerId" value="${customer.id}"/>
				 
				 </td>
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>联系电话&nbsp;</td>
                <td id="t16" style="width:30%">
			 	
				 <input type="text" id="phone" name="confirm.phone" class="leftcreateinputbox01" value="${customer.phone}"/>
				</td>
              </tr>		
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间&nbsp;</td>
				<td colspan="3">
				  ${unit.unitNo}
				  <input type="hidden" id="hiddenUnitId" name="confirm.unitId" value="${unit.id}"/>
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
				<s:select list="selPriceWay"  name="confirm.priceWay" cssStyle="width:auto" id="priceWay"
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
				 	<s:select list="selPayType"  name="confirm.payType" cssStyle="width:auto" id="payType" />
				</td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>折扣(%)&nbsp;</td>
                <td id="t16" style="width:30%">
					<input type="text" id="discountPercent" name="confirm.discountPercent" class="leftcreateinputbox01"  style="width:25%"/>
				 </td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="buildPrice" name="confirm.buildPrice" class="leftcreateinputbox01" style="width:25%"/>
				 元	
				</td>		
               <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>套内成交单价&nbsp;</td>
                <td id="t14">
					 <input type="text" id="insideUnitPrice" name="confirm.insideUnitPrice" class="leftcreateinputbox01"  style="width:25%"/>
				 元
				</td>		
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="discountDesc" name="confirm.discountDesc" class="leftcreateinputbox01"/>				 </td>		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>房间总价&nbsp;</td>
                <td id="t16" style="width:30%">
					 <input type="text" id="sumMoney" name="confirm.sumMoney" class="leftcreateinputbox01"  style="width:25%"/>
				 元</td>			
              </tr>	 
			  
			  
  			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>装修选择</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">装修标准&nbsp;</td>
                <td id="t16" style="width:30%">				
				 <input type="text" id="renovateDesc" name="confirm.renovateDesc" class="leftcreateinputbox01" value="${unit.renovateDesc}"/>
				</td>
                 <td id="t13" style="width:15%" align="right">装修单价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="renovatePrice" name="confirm.renovatePrice" class="leftcreateinputbox01" value="${unit.renovatePrice}" style="width:25%"/>
				元
				</td>				
              </tr>	
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">是否并入合同&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:select list="selIsMerge" name="confirm.isMerge" cssStyle="width:auto" id="isMerge"/>				 </td>
                 <td id="t13" style="width:15%" align="right">装修总价&nbsp;</td>
                <td id="t14">
				 <input type="text" id="renovateMoney" name="confirm.renovateMoney" class="leftcreateinputbox01" value="${unit.renovateMoney}" style="width:25%"/>
				元
				</td>				
              </tr>	
			  
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>摘要</b>&nbsp;</td>
				<td colspan="3"></td>
			  </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>协议编号&nbsp;</td>
                <td id="t16" style="width:30%">
				 <input type="text" id="agreeNo" name="confirm.agreeNo" class="leftcreateinputbox01"/>				 </td>
                 <td id="t13" style="width:15%" align="right">&nbsp;</td>
                <td id="t14"></td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				   <input type="text" id="shouldDeposit" name="confirm.shouldDeposit" class="leftcreateinputbox01"  style="width:25%"/>
				 元</td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>协议总价&nbsp;</td>
                <td id="t14">
				  <input type="text" id="agreeMoney" name="confirm.agreeMoney" class="leftcreateinputbox01" style="width:25%"/>
				 元
				 </td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000">*</font>签署日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="signDate" style="width:90px" name="confirm.signDate" />				 </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>业务归属日期&nbsp;</td>
                <td id="t14">
				 <input class="Wdate" type="text" id="workDate" style="width:90px" name="confirm.workDate" />				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">失效日期&nbsp;</td>
                <td id="t16" style="width:30%">
				    <input class="Wdate" type="text" id="endDate" style="width:90px" name="confirm.endDate" />			    </td>
                 <td id="t13" style="width:15%" align="right">推荐人&nbsp;</td>
                <td id="t14">
				 <input type="text" id="recommendMan" name="confirm.recommendMan" class="leftcreateinputbox01"/>				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">业务员&nbsp;</td>
                <td id="t16" style="width:30%">
				 	<input type="text" id="saleName" class="leftcreateinputbox01" />
					<input type="hidden" id="hiddenSalesId" name="confirm.salesId"/>			    </td>
                 <td id="t13" style="width:15%" align="right"><font color="#FF0000">*</font>认购约定交楼日期&nbsp;</td>
                <td id="t14">
				 <input class="Wdate" type="text" id="deliveryDate" style="width:90px" name="confirm.deliveryDate" />				</td>				
              </tr>	
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				 <td id="t13" style="width:15%" align="right">关联房间&nbsp;</td>
                <td id="t14">
					 
					  <input type="text" id="refUnitId" class="leftcreateinputbox01" />
					 <input type="hidden" id="hiddenRefUnitId" name="confirm.refUnitId" />				</td>	
                 <td id="t13" style="width:15%" align="right"></td>
                <td id="t14"></td>				
              </tr>	 
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4">
				
				  <s:token />
				  <input type="submit" value="  保存  " id="sub"/>
				  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
					&nbsp;&nbsp;
				  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>saleunit/confirm/guangzhou/searchList.action'" />				</td>
			  </tr>			 
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
				<td colspan="4" align="center">					
					<font color="#FF0000"><span id="suggestion2"><s:property value="#request.session.suggestion"/></span></font>	
				</td>
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
