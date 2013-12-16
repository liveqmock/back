<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>查看成交</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<link href="./css/unit_table.css"  rel="stylesheet" type="text/css" charset="utf-8"/><!-- unit的样式 -->
	
	<script type="text/javascript" language="javascript" src="./js/customer_guangzhou_project.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>	 
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_table.js"></script>	<!-- unit table -->
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/unit_infomation.js"></script>	
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_unit_info.js"></script>
	<script type="text/javascript" language="javascript" src="./js/saleunit_sale.js"></script><!-- 管理销售弹出框 -->
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_discount.js"></script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
	</style>
	
</head>
<body>
<div class="gbox1">			

<form action="./saleunit_new/appoint/guangzhou/updateConfirmDialog.action" method="post">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">
		  
		 
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td id="t15" style="width:15%" align="right"><b>基本资料</b>&nbsp;</td>
				<td colspan="3"></td>
				
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="#FF0000"></font>客户名称&nbsp;</td>
                <td id="t16" style="width:30%">
					<s:iterator value="contractCustomerList" var="c">
						${c.customerName}
						&nbsp;
					</s:iterator>
			    </td>
				<td id="t15" style="width:15%" align="right"><font color="#FF0000"></font>联系电话&nbsp;</td>
                <td id="t16" style="width:30%">
			 		<s:iterator value="contractCustomerList" var="c">
						${c.mobilePhone}
						&nbsp;
					</s:iterator>

				 </td>
                			
              </tr>		
			  
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show" >
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000"></font>房间&nbsp;</td>
				<td colspan="3">
					${selectUnit.unitNo}
      			 	
				</td>
				
			  </tr>
			  
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">房间结构&nbsp;</td>
                <td id="t14">
					${selectUnit.roomTypeStr}
				</td>		
                <td id="t15" style="width:15%" align="right">销售状态&nbsp;</td>
                <td id="t16" style="width:30%">
					${selectUnit.areaStateStr}					
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑面积&nbsp;</td>
                <td id="t14">
				${selectUnit.buildArea}	
				</td>		
                <td id="t15" style="width:15%" align="right">套内面积&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.insideArea}	
				</td>			
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">建筑单价&nbsp;</td>
                <td id="t14">
				${selectUnit.buildPrice} 元
				</td>		
                <td id="t15" style="width:15%" align="right">套内单价&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.insidePrice}	元
				</td>			
              </tr>	 
			 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font></td>
                <td id="t14">

				</td>
                <td id="t15" style="width:15%" align="right">标准总价&nbsp;</td>
                <td id="t16" style="width:30%">
				${selectUnit.sumPrice} 元
				 </td>			
              </tr>	 
			  
			    <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>付款方式&nbsp;</td>
                <td id="t14">
				 	${confirm.payWay}
				</td>
				<td id="t13" style="width:15%" align="right">计价方式&nbsp;</td>
                <td id="t14">				
					<s:if test="confirm.priceWay == 1">建筑面积</s:if>
					<s:elseif test="$confirm.priceWay == 2">套内面积</s:elseif>
				</td>					
              </tr>	 
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
			  <td id="t15" style="width:15%" align="right"><font color="#FF0000"></font>折扣(%)&nbsp;</td>
                <td id="t16" style="width:30%">
					<!--
					<input type="text" id="discountPercent" name="confirm.discountPercent" class="leftcreateinputbox01"  style="width:30%" value="${confirm.discountPercent}" />
					-->
					${confirm.discountPercent}
				 </td>	
				 <td id="t15" style="width:15%" align="right">折扣说明&nbsp;</td>
                <td id="t16" style="width:30%">
				 ${confirm.discountDesc}				 </td>	
				 </tr>
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>建筑成交单价&nbsp;</td>
                <td id="t14">
				 ${confirm.buildPrice}
				 元	
				</td>		
				
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>套内成交单价&nbsp;</td>
                <td id="t14">
					${confirm.insideUnitPrice}
				 元
				</td>
				 
            	
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				 <td id="t13" style="width:15%" align="right"><font color="#FF0000"></font></td>
                <td id="t14">

				</td>  		
                <td id="t15" style="width:15%" align="right"><font color="#FF0000"></font>房间总价&nbsp;</td>
                <td id="t16" style="width:30%">
					 ${confirm.sumMoney}
				 元</td>			
              </tr>	 
              
              
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>认购书编号&nbsp;</td>
                <td id="t14">
               		 ${confirm.agreeNo}
				 </td>	
				
				<td id="t15" style="width:15%" align="right"><font color="#FF0000"></font>认购日期&nbsp;</td>
                <td id="t16" style="width:30%">
				  <s:date name="#request.confirm.workDate" format="yyyy-MM-dd" />
				 </td>						
              </tr>	 			   
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right">附属产品&nbsp;</td>
                <td id="t14">
                ${confirm.auxiliaryProduct}
				</td>	
				
				<td id="t15" style="width:15%" align="right">应收定金&nbsp;</td>
                <td id="t16" style="width:30%">
				  ${confirm.shouldDeposit}
				 元
				  
				 </td>						
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t13" style="width:15%" align="right"><font color="#FF0000"></font>销售人员&nbsp;</td>
                <td id="t14" colspan="2">				 	
					${confirm.salesName}
				  <input type="hidden" id="salesId" name="confirm.salesId" value="${confirm.salesId}" readonly="readonly"/>	
				</td>
				
                <td id="t16" style="width:30%">
				
				
				
				<!--
				 <a href="javascript:void(0)" style="float:left; padding:0 10px 0 0" onclick="return searchSale()"><font color="#5482DE">新增</font></a>
				  <a href="javascript:void(0)" style="float:left;" onclick="return deleteSale()"><font color="#5482DE">删除</font></a>
				  -->
				  
				 </td>						
              </tr>	 
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">是否二手成交&nbsp;</td>
                <td id="t16" style="width:30%">
					
				</td>
                 <td id="t13" style="width:15%" align="right">是否一二手联动</td>
                <td id="t14">
					
				</td>				
              </tr>	
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">是否关系户&nbsp;</td>
                <td id="t16" style="width:30%">
								 </td>
                 <td id="t13" style="width:15%" align="right"></td>
                <td id="t14">
				 <s:token />
				<input type="hidden" id="baseUrl" value="<%=basePath%>"/>
			   <input type="hidden" id="confirmType" value="${confirmType}" />
			    <input type="hidden" id="mainId" name="confirm.id"  value="${confirm.id}"/>
				
				<input type="hidden" name="confirm.companyProjectId" value="${confirm.companyProjectId}" />
				</td>				
              </tr>	
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">备注&nbsp;</td>
                <td id="t16" colspan="3">
					${confirm.remark}
				</td>
						
              </tr>	
			  
			  
  			  
				
				
			
           
            </table>
</form>	
	
	</div>




</body>
</html>
