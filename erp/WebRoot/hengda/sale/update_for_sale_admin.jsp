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
		
		<script type="text/javascript" language="javascript">
			$().ready(function(){
				getSomeSum("houseNum", "shopNum", "parkNum", "sunNum");
				getSomeSum("houseArea", "shopArea", "parkArea", "sumArea");
				getSomeSum("houseMoney", "shopMoney", "parkMoney", "sumMoney");
				
				getSomeSum("contractHouseNum", "contractShopNum", "contractParkNum", "getContractHouseNum");
				getSomeSum("contractHouseArea", "contractShopArea", "contractParkArea", "getContractSumArea");
				getSomeSum("contractHouseMoney", "contractShopMoney", "contractParkMoney", "getContractMoneySum");
				
				getSomeSum("undoHouseNum", "undoShopNum", "undoParkNum", "unDoHouseSunNum");
				getSomeSum("undoHouseArea", "undoShopArea", "undoParkArea", "undoHouseAreaSum");
				getSomeSum("undoHouseMoney", "undoShopMoney", "undoParkMoney", "undoSumMoney");
				
				getRealReduction("contractHouseMoney", "undoHouseMoney", "realHouseMoney");
				getRealReduction("contractShopMoney", "undoShopMoney", "realShopMoney");
				getRealReduction("contractParkMoney", "undoParkMoney", "realParkMoney");
				
				$("#realSumMoney").html(Number($("#contractHouseMoney").val()) + Number($("#contractShopMoney").val()) + Number($("#contractParkMoney").val()) -
					Number($("#undoHouseMoney").val()) - Number($("#undoShopMoney").val()) - Number($("#undoParkMoney").val()));
				
			});
			
			function getSomeSum(id1, id2, id3, sumId){
				var value1 = $("#" + id1).val();
				var value2 = $("#" + id2).val();
				var value3 = $("#" + id3).val();
				
				$("#" + sumId).html(Number(value1) + Number(value2) + Number(value3));				
			}
			
			function getRealReduction(id1, id2, reduId){
				var value1 = $("#" + id1).val();
				var value2 = $("#" + id2).val();
				
				$("#" + reduId).html((Number(value1) - Number(value2)).toFixed(2));
			}
		</script>

		<title> 修改数据</title>
	</head>
	<body onload="clearSuggestion()">
		<table width="100%" border="0" align="left" cellspacing="0">
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
						<s:include value="include/left.jsp">
						</s:include>
					</td>
					<td width="100%" valign="top" >
							<DIV style="WIDTH: 98%; HEIGHT: 100%; BACKGROUND-COLOR: #A4C3D7;padding: 1px">

				


						<%-- 基本table分割 ^^^^^^<td width="100%">^^^^^^^^^^^^^^^^^^^^^^--%>
						<%--main table开始 --%>



						<!--main-->
						<table width="100%" class="mainbg20111112" style="height: 100%; white-space: nowrap;">
							<tr>

								<td width="100%" valign="top" height="100%" style="overflow: hidden;" nowrap="nowrap">

									<div class="titlel"></div>

									<div class="titlebg" style="height: auto; overflow: hidden;">


										<div class="title02">
											修改信息
										</div>


										<div class="right99"></div>
										<div class="blueline"></div>

										<!-- right form top -->
										<form class="registerform" id="registerform" action="./sale_hengda/update/for_submit.action" method="post">

											<div class="c"></div>
											<div class="c">
												&nbsp;&nbsp;
												<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion" />
												</span>
												</font>

											</div>



											<table width="750" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													<td width="69" align="center" id="t15" nowrap="nowrap">
														日期
													</td>
													<td width="257" nowrap="nowrap" id="t16">
														&nbsp;
														<input type="text" class="input" disabled="disabled" value="<s:date name='#session.saleMonitor.monitorDate' format='yyyy-MM-dd'/>" style="width: 90px" />
														<input type="hidden" name="saleMonitor.monitorDate" value="<s:date name='#session.saleMonitor.monitorDate' format='yyyy-MM-dd'/>" />
														<font color="#000000"></font>
													</td>
													<td id="t7" align="center">
														截止时间
													</td>
													<td id="t15" nowrap="nowrap">
														&nbsp;
														<font size="3" color="red">${time}</font>
													</td>
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													
													<td width="110" align="center" id="t15" nowrap="nowrap">
														来电
													</td>
													<td width="148" nowrap="nowrap" id="t16">
														&nbsp;
														<input type="text" name="saleMonitor.phoneNum" value="${session.saleMonitor.phoneNum }" id="phoneNum" class="leftcreateinputbox02" style="width: 70px" />
														组
													</td>
													<td width="172" align="center" id="t15" nowrap="nowrap">
														来访
													</td>
													<td width="226" nowrap="nowrap" id="t16">
														&nbsp;
														<input type="text" name="saleMonitor.visitorNum" value="${session.saleMonitor.visitorNum }" id="visitorNum" class="leftcreateinputbox02" style="width: 70px" />
														个
													</td>
												</tr>

												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													<td colspan="4" align="left" nowrap="nowrap" id="t7">
														&nbsp;预售项目填写,今天认筹了
														<input type="text" name="saleMonitor.intentionNum" value="${session.saleMonitor.intentionNum }" id="intentionNum" class="leftcreateinputbox02" style="width: 70px" />
														次
													</td>
												</tr>
												<!-- <td id="t7" align="center">车位</td>
                 <td id="t12">
				 	&nbsp;<input type="text" name="saleMonitor.parkNum" id="parkNum" class="leftcreateinputbox02" style="width:70px"/>
					个
				</td>-->




												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													<td id="t14" ></td>
													<td id="t14">
														成交套数
													</td>
													<td id="t14">
														成交面积 (㎡)
													</td>
													<td id="t14">
														成交金额(元)
													</td>

													<!-- <td id="t13" align="center">退挞定套数</td>
                <td id="t14">
					退挞定面积</td> -->
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													<td id="t13" align="center">
														住宅
													</td>
													<td id="t14">
														&nbsp;
														<input type="text" name="saleMonitor.houseNum" value="${session.saleMonitor.houseNum }" id="houseNum" class="leftcreateinputbox01" style="width: 70px" />
													</td>
													<td id="t14">
														&nbsp;
														<input type="text" name="saleMonitor.houseArea" value="${session.saleMonitor.houseArea}" id="houseArea" class="leftcreateinputbox01" style="width: 70px" />
													</td>
													<td id="t14">
														&nbsp;
														<input type="text" name="saleMonitor.houseMoney" value="${session.saleMonitor.houseMoney }"  id="houseMoney" class="leftcreateinputbox01" style="width: 70px" />
													</td>

													<!-- <td id="t13" align="center"><input type="text" name="saleMonitor.undoHouseNum" id="undoHouseNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t14">
					<input type="text" name="saleMonitor.undoHouseArea" id="undoHouseArea" class="leftcreateinputbox02" style="width:70px"/>			</td>
					-->
												</tr>



												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													<td id="t11" align="center">
														商铺
													</td>
													<td id="t12">
														&nbsp;
														<input type="text" name="saleMonitor.shopNum" value="${session.saleMonitor.shopNum }" id="shopNum" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<td id="t12">

														&nbsp;
														<input type="text" name="saleMonitor.shopArea" value="${session.saleMonitor.shopArea }" id="shopArea" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<td id="t12">
														&nbsp;
														<input type="text" name="saleMonitor.shopMoney" value="${session.saleMonitor.shopMoney }" id="shopMoney" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<!--   <td id="t11" align="center"><input type="text" name="saleMonitor.undoShopNum" id="undoShopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">
				<input type="text" name="saleMonitor.undoShopArea" id="undoShopArea" class="leftcreateinputbox02" style="width:70px"/></td>-->
												</tr>


												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													<td id="t15" align="center">
														车位
													</td>
													<td id="t12">
														&nbsp;
														<input type="text" name="saleMonitor.parkNum" value="${session.saleMonitor.parkNum }" id="parkNum" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<td id="t16">
														&nbsp;
														<input type="text" name="saleMonitor.parkArea" value="${session.saleMonitor.parkArea }" id="parkArea" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<td>
														&nbsp;
														<input type="text" name="saleMonitor.parkMoney" value="${session.saleMonitor.parkMoney }" id="parkMoney" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<!--  <td id="t9" align="center"><input type="text" name="saleMonitor.undoParkNum" id="undoParkNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t10"><input type="text" name="saleMonitor.undoParkArea" id="undoParkArea" class="leftcreateinputbox02" style="width:70px"/></td>-->
												</tr>

												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													<td id="t7" align="center">
														合计
													</td>

													 <td id="t12">&nbsp;<span id="sunNum" ></span></td>
                 <td id="t8">&nbsp;<span id="sumArea" ></span></td>
					<td>&nbsp;<span  id="sumMoney" ></span></td>
													<!--  <td id="t7" align="center"><input type="text" name="unDoHouseSunNum" id="unDoHouseSunNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t8">
					<input type="text" name="undoHouseAreaSum" id="undoHouseAreaSum" class="leftcreateinputbox02" style="width:70px"/>		</td>    -->
												</tr>
												
												
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   		 <td id="t14" ></td>
                <td id="t14">签约套数</td>
                <td id="t14">
					签约面积(㎡)</td>  
				<td id="t14">
					签约金额(元)</td> 
			   </tr>
			  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; >
			
                <td id="t13" align="center">住宅</td>
          
				<td id="t13" >&nbsp;<input type="text" name="saleMonitor.contractHouseNum" id="contractHouseNum" value="${session.saleMonitor.contractHouseNum }" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t14">&nbsp;<input type="text" name="saleMonitor.contractHouseArea" id="contractHouseArea"  value="${session.saleMonitor.contractHouseArea }" class="leftcreateinputbox02" style="width:70px"/>			</td>
				<td id="t14">&nbsp;<input type="text" name="saleMonitor.contractHouseMoney" id="contractHouseMoney" value="${session.saleMonitor.contractHouseMoney }" class="leftcreateinputbox02" style="width:70px"/>
				<font color="#0000FF"><span id="contractHouseMoneySum"></span></font></td>
				
				  <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			
                <td id="t11" align="center">商铺</td>
                <td id="t12">&nbsp;<input type="text" name="saleMonitor.contractShopNum" id="contractShopNum" value="${session.saleMonitor.contractShopNum }" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">&nbsp;<input type="text" name="saleMonitor.contractShopArea" id="contractShopArea" value="${session.saleMonitor.contractShopArea }" class="leftcreateinputbox02" style="width:70px"/></td>
					<td id="t12">&nbsp;<input type="text" name="saleMonitor.contractShopMoney" id="contractShopMoney" value="${session.saleMonitor.contractShopMoney }" class="leftcreateinputbox02" style="width:70px"/>
					<font color="#0000FF"><span id="contractShopMoneySum"></span></font></td>
              <!--   <td id="t11" align="center"><input type="text" name="saleMonitor.undoShopNum" id="undoShopNum" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t12">
				<input type="text" name="saleMonitor.undoShopArea" id="undoShopArea" class="leftcreateinputbox02" style="width:70px"/></td>-->
              </tr>	
               <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  
                <td id="t15" align="center">车位</td>
                 <td id="t9" >&nbsp;<input type="text" name="saleMonitor.contractParkNum" id="contractParkNum" value="${session.saleMonitor.contractParkNum }" class="leftcreateinputbox02" style="width:70px"/></td>
                <td id="t10">&nbsp;<input type="text" name="saleMonitor.contractParkArea" id="contractParkArea" value="${session.saleMonitor.contractParkArea }" class="leftcreateinputbox02" style="width:70px"/></td>           		
				<td>&nbsp;<input type="text" name="saleMonitor.contractParkMoney" id="contractParkMoney" value="${session.saleMonitor.contractParkMoney }" class="leftcreateinputbox02" style="width:70px"/>
				<font color="#0000FF"><span id="contractParkMoneySum"></span></font></td>
                <!--  -->
              </tr>
              <tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			   
                 <td id="t7" align="center">合计</td>
                
                  	<td id="t7" >&nbsp;<span  id="getContractHouseNum" ></span></td>
                	<td id="t8">&nbsp;<span  id="getContractSumArea" ></span></td>
					<td>&nbsp;<span  id="getContractMoneySum" ></span></td>
				<!--     -->
              </tr>
										
												
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													<td id="t14" ></td>
													<td id="t14">
														退挞定套数
													</td>
													<td id="t14">
														退挞定面积(㎡)
													</td>
													<td id="t14">
														退挞定金额(元)
													</td>
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													<td id="t13" align="center">
														住宅
													</td>

													<td id="t13">
														&nbsp;
														<input type="text" name="saleMonitor.undoHouseNum" value="${session.saleMonitor.undoHouseNum }" id="undoHouseNum" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<td id="t14">
														&nbsp;
														<input type="text" name="saleMonitor.undoHouseArea" value="${session.saleMonitor.undoHouseArea }" id="undoHouseArea" class="leftcreateinputbox02" style="width: 70px" />
													</td>
													<td id="t14">
														&nbsp;
														<input type="text" name="saleMonitor.undoHouseMoney" value="${session.saleMonitor.undoHouseMoney }" id="undoHouseMoney" class="leftcreateinputbox02" style="width: 70px" />
													</td>

													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
														
														<td id="t11" align="center">
															商铺
														</td>
														<td id="t12">
															&nbsp;
															<input type="text" name="saleMonitor.undoShopNum" value="${session.saleMonitor.undoShopNum }" id="undoShopNum" class="leftcreateinputbox02" style="width: 70px" />
														</td>
														<td id="t12">
															&nbsp;
															<input type="text" name="saleMonitor.undoShopArea" value="${session.saleMonitor.undoShopArea }" id="undoShopArea" class="leftcreateinputbox02" style="width: 70px" />
														</td>
														<td id="t12">
															&nbsp;
															<input type="text" name="saleMonitor.undoShopMoney" value="${session.saleMonitor.undoShopMoney }" id="undoShopMoney" class="leftcreateinputbox02" style="width: 70px" />
														</td>
												
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
														
														<td id="t15" align="center">
															车位
														</td>
														<td id="t9">
															&nbsp;
															<input type="text" name="saleMonitor.undoParkNum" value="${session.saleMonitor.undoParkNum }" id="undoParkNum" class="leftcreateinputbox02" style="width: 70px" />
														</td>
														<td id="t10">
															&nbsp;
															<input type="text" name="saleMonitor.undoParkArea" value="${session.saleMonitor.undoParkArea }" id="undoParkArea" class="leftcreateinputbox02" style="width: 70px" />
														</td>
														<td>
															&nbsp;
															<input type="text" name="saleMonitor.undoParkMoney" value="${session.saleMonitor.undoParkMoney }" id="undoParkMoney" class="leftcreateinputbox02" style="width: 70px" />
														</td>
														<!--  -->
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
														
														<td id="t7" align="center">
															合计
														</td>

														<td id="t7" >&nbsp;<span  id="unDoHouseSunNum" ></span></td>
                	<td id="t8">&nbsp;<span  id="undoHouseAreaSum" ></span></td>
					<td>&nbsp;<span  id="undoSumMoney" ></span></td>
														<!--     -->
													</tr>
													
													
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													<td id="t14" ></td>
													<td id="t14">
													</td>
													<td id="t14">
													</td>
													<td id="t14">实收金额(元)
													</td>
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
													
													<td id="t13" align="center">
														住宅
													</td>

													<td id="t13">
													</td>
													<td id="t14"></td>
													<td id="t14">&nbsp;<span  id="realHouseMoney" ></span></td>

													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
														
														<td id="t11" align="center">
															商铺
														</td>
														<td id="t12"></td>
														<td id="t12"></td>
														<td id="t12">&nbsp;<span  id="realShopMoney" ></span></td>
												
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
														
														<td id="t15" align="center">
															车位
														</td>
														<td id="t9"></td>
														<td id="t10"></td>
														<td>&nbsp;<span  id="realParkMoney" ></span></td>
														<!--  -->
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
														
														<td id="t7" align="center">
															合计
														</td>

														<td id="t7" ></td>
                	<td id="t8"></td>
					<td>&nbsp;<span  id="realSumMoney" ></span></td>
														<!--     -->
													</tr>
																
													
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="4">
														<font color="blue">		项目:${saleMonitor.descProjectName }</font>
														</td>
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="4">
															<input type="hidden" name="saleMonitor.id" value="<s:property value='#session.saleMonitor.id'/>" />
															<input type="hidden" name="saleMonitor.projectId" value="<s:property value='#session.saleMonitor.projectId'/>" />
															<input type="hidden" name="saleMonitor.monitorDate" value="<s:date name='#session.saleMonitor.monitorDate' format='yyyy-MM-dd'/> " />
													
															<input type="submit" value="  保存  " id="sub" />
															<input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=path %>/sale_hengda/search/sale.action?from=left'" />
														</td>
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="4">
														<font color="red">	最后修改人:${saleMonitor.descModId}    &nbsp;&nbsp;&nbsp;     最后修改时间:<s:date name='#session.saleMonitor.modTime' format='yyyy-MM-dd HH:mm:ss'/></font>
														</td>
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td>创建人：</td>
														<td>${saleMonitor.descCreatedId}</td>
														<td>创建时间：</td>
														<td><s:date name='#session.saleMonitor.createdTime' format='yyyy-MM-dd HH:mm:ss'/></td>
													</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														<td colspan="2">修改人</td>
														
														<td colspan="2">修改时间</td>
														
													</tr>
													<s:iterator value="logMonitorList" id="c">
														<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" ; align="center">
														
														<td colspan="2">${c.descModId }</td>
														
														<td colspan="2">
															<s:date name='#c.modTime' format='yyyy-MM-dd HH:mm:ss'/>
														</td>
													</tr>
													
													</s:iterator>
													
											</table>

										</form>


										<div class="c"></div>
									</div>



									<div class="titler"></div>
									<div class="c"></div>

									<div class="c"></div>
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

