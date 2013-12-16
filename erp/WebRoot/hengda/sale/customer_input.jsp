<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  

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

		<title>客户录入</title>
		
		<script language="javascript" type="text/javascript">
			$().ready(function(){
						
				$("#customer_companyId").change(function(){
					companyToProject(this.value, "customer_projectId");
				});
				
				
			});
		</script>
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
				<tr style="height: 100%">
					<td valign="top">
						<s:include value="include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top" >
					<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">
						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>
						<table width="100%" class="mainbg20111112" style="height: 100%">
							<tr>


								<td width="100%" valign="top" height="100%" style="overflow: hidden;">
									
									<div class="titlel"></div>
									<div class="titlebg" style="height: auto; overflow: hidden;">

										 <div class="title01" ><a href="./sale_hengda/customer/index.action" target="_self">查询客户</a></div>
								         <div class="title02"><a href="./sale_hengda/customer/forCustomerInput.action" target="_self">新建客户</a></div>		
										<div class="right99"></div>
										<div class="blueline"></div>

										<div class="c"></div>
										<div class="c"></div>
										
										
										
							<form class="registerform" action="./sale_hengda/customer/input.action" method="post" >	 

										<table width="100%" border="0" align="left" cellspacing="0">


											<tr>
												<td height="10" colspan="6">
													<div class="blueline"></div>
												</td>
											</tr>
											
											 <div class="c"></div>
											  <div class="c">
												 &nbsp;&nbsp;
												 <label>
														<span>所属公司</span>
												</label>
												<s:select list="selCompany" name="customer.companyId" value="#session.companyId" />
												<label>
													<span>所属项目</span>
												</label>
												<s:select list="selProject" name="customer.projectId" value="#session.projectId" />
												 &nbsp;&nbsp;
												 <s:radio list="selCustomerState" name="customer.customerState" value="1"/>
												  &nbsp;&nbsp;	
												<font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
											  </div>


											<tr>
												<td colspan="6">

													<!--  main top -->

													<div class="gbox1">
													
		 <table width="75%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
              <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t15" align="right" nowrap="nowrap"><font color="red">*</font>客户姓名&nbsp;</td>
                <td id="t16">
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20"/>
				</td>
                <td id="t15" nowrap="nowrap"  align="right"><font color="red">*</font>性别&nbsp;</td>
                <td id="t16">
					<s:select list="selGender"  name="customer.gender" value="%{customer.gender}" />
				</td>
                <td id="t15"  nowrap="nowrap"  align="right"><font color="red">*</font>年龄&nbsp;</td>
                <td id="t16">
				 <s:select list="selAgeRange"  name="customer.age" value="%{customer.age}" />
                </td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t13" nowrap="nowrap"   align="right">身份证&nbsp;</td>
                <td id="t14">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox01"/>
				</td>
                <td id="t13"  nowrap="nowrap"  align="right"><font color="red">*</font>联系电话A&nbsp;</td>
                <td id="t14">
					 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" ac="customer_tianluan"/>
				</td>
                <td id="t13"  nowrap="nowrap"  align="right">联系电话B&nbsp;</td>
                <td id="t14">
					<input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01"/>
				</td>
              </tr>
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t11" nowrap="nowrap"   align="right"><font color="red">*</font>从事行业&nbsp;</td>
                <td id="t12">
					<s:select list="selJobType"  name="customer.jobIndustry" value="%{customer.jobIndustry}" />
				</td>
                <td id="t11"  nowrap="nowrap"  align="right"><font color="red">*</font>行业背景描述&nbsp;</td>
                <td id="t12">
					<input type="text" name="customer.jobDesc" id="jobDesc" class="leftcreateinputbox02" style="width:auto"/>
				</td>
                <td id="t11"  nowrap="nowrap"  align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td id="t12">	
					 <s:select list="selCustomerRegion"  name="customer.customerRegion" value="%{customer.customerRegion}" />
				</td>
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t9" nowrap="nowrap"   align="right">客户外貌特征描述&nbsp;</td>
                <td id="t10">
					 <input type="text" name="customer.faceLook" id="faceLook" class="leftcreateinputbox02" style="width:auto"/>
				</td>
                <td id="t9" nowrap="nowrap"    align="right"><font color="red">*</font>是否提及关系&nbsp;</td>
                <td id="t10">
					<input name="customer.isRelation" type="radio" value="1" id="yes"/>是
					<input name="customer.isRelation" type="radio" value="0" id="no"/>否
				</td>
                <td id="t9" nowrap="nowrap"   align="right"><span id="red"></span>关系描述&nbsp;</td>
                <td id="t10">
					<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" style="width:auto"/>
				</td>
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t7" nowrap="nowrap"   align="right"><font color="red">*</font>获知途径&nbsp;</td>
                <td id="t8" colspan="5">
					 <s:checkboxlist list="selKnownFrom" name="knownFrom" value="%{customer.knownFrom}"/>
				</td>
               
              </tr>
			  
			   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5" nowrap="nowrap"   align="right"><font color="red">*</font>客户兴趣爱好&nbsp;</td>
                <td id="t6">
					<input type="text" name="customer.interest" id="interest" class="leftcreateinputbox02" />
				</td>
				<td id="t7"  align="right" nowrap="nowrap" ><font color="red">*</font>购房目的&nbsp;</td>
                <td id="t8">
					<s:select list="selBuyAim"  name="customer.buyAim" value="%{customer.buyAim}" />
				</td>
                <td id="t7"  align="right" nowrap="nowrap" ><font color="red">*</font>需求面积&nbsp;</td>
                <td id="t8">
					 <s:select list="selRequestArea"  name="customer.requestArea" value="%{customer.requestArea}" />
				</td>
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td id="t5"  align="right" nowrap="nowrap" >户型需求&nbsp;</td>
                <td id="t6">
					 <s:select list="selRoomType"  name="customer.roomType" value="%{customer.roomType}" />
				</td>
                <td id="t5"  align="right" nowrap="nowrap" ><font color="red">*</font>预算总价&nbsp;</td>
                <td id="t6">
					 <s:select list="selPriceAmount"  name="customer.priceAmount" value="%{customer.priceAmount}" />
				</td>
                <td id="t5"  align="right" nowrap="nowrap" ><font color="red">*</font>购房付款方式&nbsp;</td>
                <td id="t6">
					<s:select list="selPayType"  name="customer.payType" value="%{customer.payType}" />
				</td>
              </tr>
			  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right" nowrap="nowrap" >客户对产品及项目认可方面&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>
	  
	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t3"  align="right" nowrap="nowrap" >所选单位1&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building1" name="recRoom1.building"/>栋
			<input type="text" id="room1" name="recRoom1.room" nowrap="nowrap" />单元&nbsp;&nbsp;
			原价<input type="text" id="originalPrice1" name="recRoom1.originalPrice"/>万元&nbsp;&nbsp;
			折扣<input type="text" id="discountDesc1" name="recRoom1.discountDesc"/>
		</td>
		
	  </tr>
	  
	 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t3"  align="right" nowrap="nowrap" >所选单位2&nbsp;</td>
		<td id="t4" colspan="5" nowrap="nowrap" >
			<input type="text" id="building2" name="recRoom2.building"/>栋
			<input type="text" id="room2" name="recRoom2.room"/>单元&nbsp;&nbsp;
			原价<input type="text" id="originalPrice2" name="recRoom2.originalPrice"/>万元&nbsp;&nbsp;
			折扣<input type="text" id="discountDesc2" name="recRoom2.discountDesc"/>
		</td>
	  </tr>
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t3"  align="right">所选单位3&nbsp;</td>
		<td id="t4" colspan="5">
			<input type="text" id="building3" name="recRoom3.building"/>栋
			<input type="text" id="room3" name="recRoom3.room"/>单元&nbsp;&nbsp;
			原价<input type="text" id="originalPrice3" name="recRoom3.originalPrice"/>万元&nbsp;&nbsp;
			折扣<input type="text" id="discountDesc3" name="recRoom3.discountDesc"/>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right"><font color="red">*</font>客户购买抗性&nbsp;</td>
		<td colspan="5">
			 <textarea id="notBuyReson" name="customer.notBuyReson" rows="3" cols="30"></textarea>
		</td>
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right"><font color="red">*</font>备注&nbsp;</td>
		<td colspan="5">
			 <input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%"/>
		</td>
	  </tr>

	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
		<td id="t1" style="width:15%"  align="right"><font color="red">*</font>首次到场日期&nbsp;</td>
		<td>
		 	<input class="Wdate" type="text" id="firstDate" name="customer.firstDate" value="${customer.firstDate}" onClick="WdatePicker()"/>
		</td>
		<td  align="right">
			<font color="red">*</font>首次到场时间&nbsp;
		</td>
		<td colspan="3">
			 <s:select list="selFirstHour"  name="customer.firstHour" value="%{customer.firstHour}" />
		</td>
	  </tr>
	  
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
		<td colspan="6">
		  <input type="submit" value="  保存  " id="hengda_sub"/>
			&nbsp;&nbsp;
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = './customer_tianluan!searchCustomer.action'" />
		  &nbsp;&nbsp;

		 </td>
	  </tr>
	  </table>

														
													</div>

													<!-- main end -->
												</td>
											</tr>
											

										</table>
										
										
								</form>
										
									</div>
									<div class="titler"></div>
									<div class="c"></div>
								
								</td>
							</tr>
							<!--main.end-->
							<tr>
								<td height="100%" colspan="6">
								</td>
							</tr>
						</table>
					</DIV>
					</td>
					<%-- 基本table分割 ^^^^^^^^^^^^^^^^^end^^^</td>^^^^^^^^^^^^^^^^^^^^^--%>
					
				</tr>
				
			</tbody>

		</table>

	</body>
</html>
