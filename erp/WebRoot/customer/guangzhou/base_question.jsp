<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

 <tr  bgcolor="#FFFFFF" id="change1">
                <td align="right">来访次数&nbsp;</td>
                <td>
					<s:select list="selVisitCount"  name="customer.visitCount" />	
				</td>
                <td style="width:15%" align="right">性别&nbsp;</td>
                <td style="width:18%">
					<s:select list="selGender"  name="customer.gender" />	
				</td>
                <td style="width:15%" align="right">国籍&nbsp;</td>
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
				 <td style="width:15%" align="right"></td>
                <td>
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