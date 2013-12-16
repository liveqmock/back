<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.utils.CacheUtils"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	
	<title>新建客户</title>
	
	<base href="<%=basePath%>"/>
	<s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>
    <script type="text/javascript" language="javascript" src="./js/provi_city_region_select.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_sel.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_value_change.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_guangzhou_question.js?v=1"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_guangzhou_input.js"></script>
			
	<link href="<%=basePath%>css/easyui.css" rel="stylesheet" type="text/css"	charset="utf-8" />
	<link href="<%=basePath%>css/icon.css" rel="stylesheet" type="text/css"	charset="utf-8" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>

	<script type="text/javascript">
	
	
	$().ready(function(){
		$("#showOrHide1").click(function(){
			$("#ques_table").toggle() ;
		});
		
		if($("#hiddenId").val() != 0){
		  $("#ques_table").load('./customer_guangzhou/input/findQuestionTable.action',{proId:$("#hiddenId").val()});
	  	}          	
		
	});	
	
	</script>
	<style type="text/css">
	  .topinfo{
	  background-color: #eeeeee;height: 18px;padding: 2px;
	  border-right: 1px #A9D9FF solid;
	  border-top: 1px #A9D9FF solid;
	  border-left: 1px #A9D9FF solid;
	  }
	</style>
  </head>
  
 <body onload="clearSuggestion()" style="background-color: #ffffff">

<%--主体 --%>
    <div class="right99"></div>

    <%--主体table top --%>

    <div class="c"></div>
    <div class="c">
        &nbsp;&nbsp;
        <font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
    </div>

    <form class="registerform" action="./customer_guangzhou/input/addCustomerAndQuestion.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" method="post" onsubmit="return validateCustForm();">
	   <div style="margin: 5px">
			  <div class="topinfo">&nbsp;&nbsp;必填</div>
			 <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="white-space: nowrap;background-color: #A9D9FF">
			  <tr   bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td style="width:15%"  align="right"><font color="red">*</font>项目&nbsp;</td>
                <td>
					<input type="text" id="projectName1" name="projectName" disabled="disabled" value="<s:property value='#request.project.projectName'/>"/>
					<input type="hidden" id="hiddenId" name="customer.projectId" value="<s:property value='#request.project.id'/>"/>
                </td>
                <td colspan="2"> <div><font color="red">请首先确定项目</font></div></td>
                <td style="width:15%"  align="right"></td>
                <td></td>
              </tr>
			  <tr   bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
                <td style="width:15%"  align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td>
					<input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="10" />		
				</td>
				<td style="width:15%"  align="right"><font color="red">*</font>客户评级&nbsp;</td>
                <td style="width:18%">
					<s:select list="selRating"  name="customer.rating"/>	
				</td>
				<td style="width:15%"  align="right">来访日期</td>
                <td>
					<input class="Wdate" type="text" id="visitDate" style="width:90px" name="customer.visitDate" onfocus="javascript:blur()" value="${nowDate}"/>
				</td>
              </tr>
              <tr   bgcolor="#FFFFFF" 
			  	style="empty-cells:show">
				<td id="t15" style="width:15%" align="right"><font color="red">*</font>移动电话&nbsp;</td>
                <td id="t16" style="width:18%" nowrap="nowrap">
                <div>
                <div style="float: left;"  >
				 <input style="width: 70%" type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" title="移动电话,固定电话可以二选一"  
				 	onkeyup="valueChangeGetCount('phone', 'phoneCount', 11)" onkeydown="valueChangeGetCount('phone', 'phoneCount', 11)"/>
				 </div>
				 <div style="float: left;" id="phoneCount" ></div>
				 </div>
				 </td>
                 <td style="width:15%" align="right"><font color="red">*</font>固定电话&nbsp;</td>
                <td id="t14" nowrap="nowrap">
					 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" title="移动电话,固定电话可以二选一" maxlength="15"/>				</td>
				<td colspan="2" nowrap="nowrap">
					(移动电话,固定电话可以二选一)
				</td>
              </tr>
             <tr  bgcolor="#FFFFFF">
                <td align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.homeProvince" value="#session.cacheCustomer.homeProvince" cssStyle="width:auto"/>省
					<s:select list="selHomeCity"  name="customer.homeCity" value="#session.cacheCustomer.homeCity" cssStyle="width:auto"/>市
					<s:select list="selHomeRegion"  name="customer.homeRegion" value="#session.cacheCustomer.homeRegion" cssStyle="width:auto"/>
					<input type="text" id="homeContent" name="customer.homeContent" value="<s:property value='#session.cacheCustomer.homeContent'/>" maxlength="30"/>
					<!--
					<s:select list="selHomeBlock"  name="customer.homeBlock" value="#session.cacheCustomer.homeBlock" cssStyle="width:auto"/>
					-->
					
				</td>
             </tr>
			  
			  <tr  bgcolor="#FFFFFF">
                <td id="t13"  align="right"><font color="red">*</font>工作区域&nbsp;</td>
                <td colspan="5">
					<s:select list="selProvince"  name="customer.workProvince" value="#session.cacheCustomer.workProvince" cssStyle="width:auto"/>省
					<s:select list="selWorkCity"  name="customer.workCity" value="#session.cacheCustomer.workCity" cssStyle="width:auto"/>市
					<s:select list="selWorkRegion"  name="customer.workRegion" value="#session.cacheCustomer.workRegion" cssStyle="width:auto"/>
					<input type="text" id="workContent" name="customer.workContent" value="<s:property value='#session.cacheCustomer.workContent'/>" maxlength="30"/> 
					<!--
					<s:select list="selWorkBlock"  name="customer.workBlock" value="#session.cacheCustomer.workBlock" cssStyle="width:auto"/>
					-->
					&nbsp;
					<input type="checkbox" id="copyHome" />与居住区域相同
				</td>
              </tr>
			  
             <tr  bgcolor="#FFFFFF">
                <td align="right"><font color="red">*</font>购房用途&nbsp;</td>
                <td>
					<s:select list="selBuyUse"  name="customer.buyUse" />
				</td>
                <td align="right"><font color="red">*</font>置业次数&nbsp;</td>
                <td>
					<s:select list="selBuyCount"  name="customer.buyCount" />
				</td>
                <td align="right"><font color="red">*</font>意向总价&nbsp;</td>
                <td>
					
					<input type="text" name="customer.priceNum" id="priceNum" style="width:40px" maxlength="11" class="easyui-numberbox"/>
					万
				</td>
             </tr>
			  
			  <tr  bgcolor="#FFFFFF">
                <td align="right"><font color="red">*</font>产品类型&nbsp;</td>
                <td>
					<s:select list="selHouseType"  name="customer.houseType" value="#request.houseType"/>
				</td>
                <td align="right"><font color="red">*</font>客户来源&nbsp;</td>
                <td>
					<s:select list="selCustomerSource"  name="customer.customerSource" />				
				</td>
                <td align="right"><font color="red">*</font>意向面积&nbsp;</td>
                <td>
					<input type="text" name="customer.areaNum" id="areaNum" style="width:40px" maxlength="11" class="easyui-numberbox"/>
					<span id="areaNumUnit">㎡</span>
				</td>
              </tr>
			  
			  <tr  bgcolor="#FFFFFF">
			  					
			  	 <td align="right"><font color="red">*</font>销售人员&nbsp;</td>
                <td colspan="3">
					<input type="hidden" name="customer.managerId" value="<s:property value='#session.loginAccount.id'/>" />
					<span><s:property value='#session.loginAccount.realName'/></span>
					&nbsp;&nbsp;
					当前时间:
					<span id="nowTime"></span>
					&nbsp;&nbsp;
					选定的项目:
					<s:property value='#request.project.projectName'/>					
				</td>
				
				 <td style="width:15%" align="right"></td>
                <td></td>
				
			  </tr>
			 
			  
			</table>
	   </div>
			
	   <div style="margin: 5px;background-color: red;">
			  <div id="" class="topinfo">&nbsp;&nbsp;自定义内容</div>
		       <div id="ques_table"></div> 
	   </div>	
			
	   <div style="margin: 5px">
			  <div id="showOrHide" class="topinfo">&nbsp;&nbsp;选填(<font color="#1199FF">点击可以隐藏/显示</font>)</div>
			 <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap;display: block;"id="changeTable">
              <tr  bgcolor="#FFFFFF" id="change1">
                <td align="right">来访次数&nbsp;</td>
                <td>
					<s:select list="selVisitCount"  name="customer.visitCount" />	
				</td>
                <td style="width:15%" align="right">性别&nbsp;</td>
                <td style="width:18%">
					<s:select list="selGender"  name="customer.gender" />	
				</td>
                <td style="width:15%" align="right">户籍&nbsp;</td>
                <td>
					<input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" maxlength="10"/>
				</td>
              </tr>
              
			  <tr  bgcolor="#FFFFFF">
                <td align="right">身份证号码&nbsp;</td>
                <td style="width:18%">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto"
					onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" onkeydown="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" maxlength="18"/>
					<span id="idcardNoCount"></span>
				</td>
                <td  align="right">驾车车型&nbsp;</td>
                <td>
					<input type="text" name="customer.trafficDesc" id="trafficDesc" class="leftcreateinputbox02" style="width:auto" maxlength="10"/>
					
				</td>
                <td align="right">年龄&nbsp;</td>
                <td>
					<s:select list="selAgeRange"  name="customer.age" />	
				</td>
              </tr>
			  
			   <tr  bgcolor="#FFFFFF">
                <td align="right">地址&nbsp;</td>
                <td colspan="3">
					<input type="text" name="customer.address" id="address" class="leftcreateinputbox02" style="width:80%" maxlength="100"/>				
				</td>
                <td align="right">邮编&nbsp;</td>
                <td id="t8">
					<input type="text" name="customer.postcode" id="postcode" class="leftcreateinputbox01" maxlength="10"/>				
					
				</td>
              </tr>
			  
			  
             <tr  bgcolor="#FFFFFF">
                <td align="right">家庭结构&nbsp;</td>
                <td>
					<s:select list="selFamilyType"  name="customer.familyType" />	
				</td>
                <td align="right">家庭收入&nbsp;</td>
                <td>
					<s:select list="selFamilyIncome"  name="customer.familyIncome" />	
				</td>
				 <td style="width:15%" align="right">发动力</td>
                <td>
					<s:select list="selProductClaim"  name="customer.productClaim" />	
				</td>
               
             </tr>
			  
			  <tr  bgcolor="#FFFFFF">
                <td align="right">行业分类&nbsp;</td>
                <td>
					<s:select list="selJobType"  name="customer.jobType" />	
				</td>
                <td align="right">职业&nbsp;</td>
                <td>
					<s:select list="selJobIndustry"  name="customer.jobIndustry" />	
				</td>
                <td align="right">&nbsp;</td>
                <td>				</td>
              </tr>
			  
			   <tr  bgcolor="#FFFFFF">
                <td align="right">意向购买单元1&nbsp;</td>
                <td>
					<input type="text" id="intentUnit1" name="customer.intentUnit1" maxlength="10"/>
				</td>
                <td align="right">意向购买单元2&nbsp;</td>
                <td>
					<input type="text" id="intentUnit2" name="customer.intentUnit2" maxlength="10"/>
				</td>
                <td align="right">&nbsp;</td>
                <td>				</td>
              </tr>
			  
			   <tr  bgcolor="#FFFFFF">
                <td align="right">购房目的&nbsp;</td>
                <td>
					<s:select list="selBuyAim"  name="customer.buyAim" />
				</td>
                <td align="right">付款方式&nbsp;</td>
                <td>
					<s:select list="selPayType"  name="customer.payType" />	
				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td>				</td>
              </tr>
	  
	
	  
	    <tr  bgcolor="#FFFFFF">
              
                <td align="right">意向套数&nbsp;</td>
                <td>
					<s:select list="selIntentBuynum"  name="customer.intentBuynum" />	
				</td>
                <td align="right">意向户型&nbsp;</td>
                <td>
				  <s:select list="selRoomType"  name="customer.roomType" />	
			    </td>
				
				<td align="right"></td>
                <td></td>
             </tr>
	  
	   <tr  bgcolor="#FFFFFF">
		<td id="t1" style="width:15%"  align="right">认知途径&nbsp;</td>
		<td colspan="5" style="white-space:normal">
						<s:iterator value="#request.selKnownFrom1" id="cc">
			 <div style="float: left;padding-right: 10px;padding-top: 5px">
			 	<label style="margin: 0">
			 	<input name="knownFrom" type="checkbox" value="${cc.key }" style="vertical-align: text-bottom;"/>
			 	<s:property value="#cc.value"/>
			 	</label>
			 	</div>
			 </s:iterator>
		</td>
	  </tr>
	  
	  <tr  bgcolor="#FFFFFF">
		<td align="right">关注点&nbsp;</td>
		<td colspan="5" style="white-space:normal">
			 <s:iterator value="#request.selCustomerFocus" id="c">
			 <div style="float: left;padding-right: 10px;padding-top: 5px">
			 	<label style="margin: 0">
			 	<input name="customerFocus" type="checkbox" value="${c.key }" style="vertical-align: text-bottom;"/>
			 	<s:property value="#c.value"/>
			 	</label>
			 	</div>
			 </s:iterator>
			<input type="hidden" id="focusPoint" style=" "/>
		</td>
	  </tr>
	  
	   <tr  bgcolor="#FFFFFF">
		<td align="right">未能成交原因&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.notBuyReson" id="notBuyReson" class="leftcreateinputbox02" style="width:80%" maxlength="50"/>			
		</td>
	  </tr>
	  
	   <tr  bgcolor="#FFFFFF">
		<td align="right">备注&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%" maxlength="100"/>			
		</td>
	  </tr>
	  
	   </table>
	   </div>
	   
	  <div style="margin: 5px">
	  <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
	  <tr  bgcolor="#FFFFFF" align="center">
		<td >
		
		  <s:token />
		  <input type="submit" value="  保存  " id="sub"/>
		  <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
			&nbsp;&nbsp;
			<!--
		  <input type="button" value="  取消  " onClick="javascript:window.location.href = '<%=basePath%>customer_guangzhou/search/index.action'" />
		  -->
		   <input type="button" value="  关闭  " id="bnt-close" />
			
		</td>
	  </tr>

	  <tr  bgcolor="#FFFFFF" align="center">
		<td >	
			<font color="#FF0000"><span id="tip"><s:property value="#request.session.suggestion"/></span></font>
		</td>
	</tr>
      </table>
      </div>
</form>
</body>
</html>
