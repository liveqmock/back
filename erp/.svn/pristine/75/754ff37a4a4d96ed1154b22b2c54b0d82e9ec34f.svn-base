<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>折扣管理</title>
	
	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript" src="./js/jquery.easyui.min.js"></script>
	<link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
	<link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

	<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>		
	<script type="text/javascript" language="javascript" src="./js/saleunit_new_common_min.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			closeIframeDialog("myIframeDialog", "${closeMark}", closeFn, "${suggestion}");
		});
		
		function closeFn(){
		
			var unitDiscountId = '${unitDiscount.id}';
			if(unitDiscountId != '0' && unitDiscountId != ''){
				window.parent.closeUnitDiscountManagerFn(unitDiscountId);
			}
			
		}
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
	</style>
	
</head>

<body>

<form action="./unit_discount/manager/createUnitDiscount.action" method="post" id="createUnitDiscountManagerFormId">

<div class="gbox1">			
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px; white-space:nowrap">
		  
		 
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				
				<td colspan="3">
					<font color="#FF0000">*</font><s:radio list="selComputeWay" name="unitDiscount.computeWay" id="computeWayId"/>
				</td>
			  </tr>

              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">附加价&nbsp;</td>
                <td id="t16" style="" colspan="2">	
				
					<table style="width:100%; white-space:nowrap">
						<tr>
						<!--
							<td style="text-align:right">单价(+)</td>
							<td><input style="width:80px" type="text" name="unitDiscount.addUnitPrice" value="${unitDiscount.addUnitPrice}" /></td>
						-->
							<td style="text-align:right">总价(+)</td>
							<td><input style="width:80px" type="text" name="unitDiscount.addSumPrice" value="${unitDiscount.addSumPrice}" /></td>
							<td style="text-align:right">优惠减价</td>
							<td><input style="width:80px" type="text" name="unitDiscount.reduceSumPrice" value="${unitDiscount.reduceSumPrice}" /></td>
						</tr>
					</table>
					
				</td>
				
				<!--
                <td id="t16" style="width:25%">
					<input type="button" value="  计算折后价  " />
				</td>
				-->
              </tr>			
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">附加价原因&nbsp;</td>
                <td id="t16" colspan="2"><input type="text" name="unitDiscount.discountDesc" style="width:80%" value="${unitDiscount.discountDesc}"/></td>
              </tr>					  
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right">折扣批准人&nbsp;</td>
                <td id="t16" style="width:100px" >
					<input name="unitDiscount.discountMan" type="text" value="${unitDiscount.discountMan}"/>
				</td>
            	<td></td>    			
              </tr>		
			  
			   <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show" align="center">
				
				<td colspan="3" width="100%" height="100%" style="text-align:left">
					<s:checkboxlist list="selPayWayDiscount" name="payWayDiscount" />
				</td>
				
              </tr>		
			  			 
			  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
			  	style="empty-cells:show" align="center">
				
				<td colspan="3" width="100%" height="100%">
					<input type="hidden" id="confirmType" name="unitDiscount.confirmType" value="${confirmType}" />
					<input type="hidden" id="mainId" name="unitDiscount.mainId" value="${mainId}" />
					
					<input type="hidden" name="confirmType" value="${confirmType}" /><!-- 用于init()方法 -->
					<input type="hidden" name="mainId" value="${mainId}" /><!-- 用于init()方法 -->
					
					<input type="hidden" id="hiddenUnitId" name="unitDiscount.unitId" value="${unit.id}" />
					<input type="hidden" name="unitDiscount.buildId" value="${unit.buildId}" />
					<input type="hidden" name="payWayId" value="${payWayId}" />
					
				</td>
				
              </tr>		
			  
    </table>

	
</div>

</form>	

</body>
</html>
