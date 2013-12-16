<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改客户信息</title>

    <base href="<%=basePath%>"/>

    <s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>
    <s:include value="../../customer/log/customer_log_include.jsp"></s:include>
    <script type="text/javascript" language="javascript" src="./js/provi_city_region_select.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_guangzhou.js?v=1"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_guangzhou_update.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_copy.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_value_change.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_sel.js"></script>

    <style type="text/css">
        *{margin:0;padding:0;}
    </style>

    <script type="text/javascript">
        $().ready(function(){
            $("#showLog").click(function(){
                dialog_customerlog_list(${c.id})
            });
            $("#questionList").val()
            $.ajax({
                url:'./customer_guangzhou/input/pickQuestionList.action?proId='+$("#hiddenId").val(),
                success:function(data){
                    $("#questionList").empty();
                    $("#questionList").append(data);
                    if(data != ""){
                        $("#ques_table").load('./customer_guangzhou/input/findAnswerTable.action?customerId='+$("#customerId").val()+'&questId='+ $("#questionList").val());
                        if( $("#questionList").val()== 0 ){
                            $("#changeTable").toggle(true);
                        }else{
                            $("#changeTable").toggle(false);
                        }
                    }
                }
            });
            //判断是否销售人员
            var isTwentyFourLater = $("#isTwentyFourLater").val();
            if(isTwentyFourLater=="true"){
            	if($("#userRole").val()=="sales"){
            		$("#msg").css("display","inline");
    				$("input[type!='hidden']").attr("disabled","disabled");
    				$("input[id='sub']").removeAttr("disabled");
    				$("input[id='follow']").removeAttr("disabled");
    				$("input[id='copyCustomer']").removeAttr("disabled");
    				$("input[id='bnt-close']").removeAttr("disabled");
    				$("select[name!=selectQuestionId]").attr("disabled","disabled");
    				$("#selVisitCount").attr("disabled",false);
    				$("#selGender").attr("disabled",false);
    				$("#nationality").attr("disabled",false);
    				$("#idcardNo").attr("disabled",false);
    				$("#trafficDesc").attr("disabled",false);
    				$("#selAgeRange").attr("disabled",false);
    				$("#address").attr("disabled",false);
    				$("#postcode").attr("disabled",false);
    				$("#selFamilyIncome").attr("disabled",false);
    				$("#selFamilyType").attr("disabled",false);
    				$("#selFamilyIncome").attr("disabled",false);
    				$("#selJobType").attr("disabled",false);
    				$("#selJobIndustry").attr("disabled",false);
    				$("#intentUnit1").attr("disabled",false);
    				$("#intentUnit2").attr("disabled",false);
    				$("#selBuyAim").attr("disabled",false);
    				$("#selPayType").attr("disabled",false);
    				$("#selIntentBuynum").attr("disabled",false);
    				$("#selRoomType").attr("disabled",false);
    				$("input[type=checkbox]").attr("disabled",false);
    				$("input[id='copyHome']").attr("disabled","disabled");
    				$("#notBuyReson").attr("disabled",false);
    			}
            }
			
			
            $("input[id!=projectName]").click(function(){
            	if($("#selCustomerSource").val()=="" || $("#selCustomerSource").val() == null){
            		myAlert("请先选择客户来源");
            	}
            });
            
            $("select[name!='customer.customerSource']").click(function(){
            	if($("#selCustomerSource").val()=="" || $("#selCustomerSource").val() == null){
            		myAlert("请先选择客户来源");
            	}
            });
            
            
            msgAlert('${suggestion}');
        })
        
        
        
        

        function frashAnwser(){
            var customerId = $("#customerId").val();
            location.href = '<%=basePath%>customer_guangzhou/update/addAnwser.action?customerId='+customerId;
        }

        function getQuestionId(){
            $("#selectQuestionId").val($('#questionList').val());
            $("#ques_table").load('./customer_guangzhou/input/findAnswerTable.action?customerId='+$("#customerId").val()+'&questId='+ $("#questionList").val());
            if( $("#questionList").val()== 0 ){
                $("#changeTable").toggle(true);
            }else{
                $("#changeTable").toggle(false);
            }
        }
    </script>
</head>

<body onload="clearSuggestion()">

<%--主体 --%>
<div class="ui_tools"></div>
<div class="ui_listview">
<div class="right99"></div>

<%--主体table top --%>

<div class="c">

    <font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
</div>

<form id="thisform" class="registerform" action="./customer_guangzhou/update/toUpdateQuestion.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" method="post">

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="gbox" style="line-height:25px">

<tr>
<td colspan="6">


<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
<td colspan="6" style="background-color: #eeeeee; font-weight: bold;">必填&nbsp;&nbsp;&nbsp;<font style="display:none" color="red" id="msg">如需修改客户资料，请联系主管</span></td>
</tr>

<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
     style="empty-cells:show">
    <td style="width:15%"  align="right"><font color="red">*</font>项目&nbsp;</td>
    <td colspan="1">
        <input   type="text" id="projectName" disabled="disabled" value="<s:property value='#session.selectedProjectName'/>"/>
        <input type="hidden" id="hiddenId" value="<s:property value='#session.c.projectId'/>"/>
		<input type="hidden" id="hiddenCompanyId" value="<s:property value='#session.c.companyId'/>"/>
        <input type="hidden" id="customerId" value="<s:property value='#session.c.id'/>"/>
        <input type="hidden" id="userRole"  value="<s:property value='#session.userRole'/>"/>
     </td>
	<td align="right"><font color="red">*</font>客户来源&nbsp;</td>
	<td>
	    <s:select id="selCustomerSource" list="selCustomerSource"  name="customer.customerSource" value="#session.c.customerSource"/>
	</td>
    <td colspan="2">
        <a style="color:#1199FF;cursor: pointer" id="showLog" >客户修改信息</a>
    </td>

</tr>

<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
     style="empty-cells:show">
    <td style="width:15%"  align="right"><font color="red">*</font>客户姓名&nbsp;</td>
    <td>
        <input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20" value="<s:property value='#session.c.customerName'/>"/>
    </td>
    <td style="width:15%"  align="right"><font color="red">*</font>客户评级&nbsp;</td>
    <td style="width:18%">
        <s:select list="selRating"  name="customer.rating" value="#session.c.rating"/>
    </td>
    <td style="width:15%"  align="right">来访日期</td>
    <td>
        <input class="easyui-datebox" type="text" id="visitDate" style="width:90px" name="customer.visitDate" value="${session.c.visitDate}"/>
    </td>

</tr>

<tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

<td style="width:15%" align="right"><font color="red">*</font>移动电话&nbsp;</td>
<td style="width:18%">

	<s:if test="#session.c.isCanShowCustomerPhone">
                        
    <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" value="<s:property value='#session.c.phone'/>"
                   title="移动电话,固定电话可以二选一" onkeyup="valueChangeGetCount('phone', 'phoneCount', 11)" onkeydown="valueChangeGetCount('phone', 'phoneCount', 11)"/>
    
    </s:if>
    
    <s:else>

        ***
         <input type="hidden" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12" value="${session.c.phone}" />
    </s:else>
    
    <span id="phoneCount"></span>
</td>

<td style="width:15%" align="right"><font color="red">*</font>固定电话&nbsp;</td>
<td>
    <s:if test="#session.c.isCanShowCustomerPhone">
                        
    <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" value="<s:property value='#session.c.homePhone'/>"
               title="移动电话,固定电话可以二选一" maxlength="15"/>
    
    </s:if>
    
    <s:else>

        ***
        <input type="hidden" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" value="${session.c.homePhone}" />
    </s:else>
    
</td>
<td colspan="2">
    (移动电话,固定电话可以二选一)
</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
<td  align="right"><font color="red">*</font>居住区域&nbsp;</td>
<td colspan="5">
    <s:select list="selProvince"  name="customer.homeProvince" value="#session.c.homeProvince"/>省
    <s:select list="selHomeCity"  name="customer.homeCity" value="#session.c.homeCity"/>市
    <s:select list="selHomeRegion"  name="customer.homeRegion" value="#session.c.homeRegion"/>
    <input type="text" id="homeContent" name="customer.homeContent" value="<s:property value='#session.c.homeContent'/>" maxlength="30"/>

</td>
</tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
<td align="right"><font color="red">*</font>工作区域&nbsp;</td>
<td colspan="5">
    <s:select list="selProvince"  name="customer.workProvince" value="#session.c.workProvince"/>省
    <s:select list="selWorkCity"  name="customer.workCity" value="#session.c.workCity"/>市
    <s:select list="selWorkRegion"  name="customer.workRegion" value="#session.c.workRegion"/>
    <input type="text" id="workContent" name="customer.workContent" value="<s:property value='#session.c.workContent'/>"  maxlength="30"/>
    &nbsp;
    <input type="checkbox" id="copyHome" />与居住区域相同
</td>
</tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
<td align="right"><font color="red">*</font>购房用途&nbsp;</td>
<td>
    <s:select list="selBuyUse"  name="customer.buyUse" value="#session.c.buyUse"/>
</td>
<td align="right"><font color="red">*</font>置业次数&nbsp;</td>
<td>
    <s:select list="selBuyCount"  name="customer.buyCount" value="#session.c.buyCount"/>
</td>
<td style="width:15%" align="right"><font color="red">*</font>意向总价&nbsp;</td>
<td>
    <input type="text" name="customer.priceNum" id="priceNum" style="width:40px" value="<s:property value='#session.c.priceNum'/>" maxlength="11"/>
    万
</td>
</tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
<td align="right"><font color="red">*</font>产品类型&nbsp;</td>
<td>
    <s:select list="selHouseType"  name="customer.houseType" value="#session.c.houseType"/>				</td>
<td align="right"><font color="red">*</font>意向面积&nbsp;</td>
<td>
    <input type="text" name="customer.areaNum" id="areaNum" style="width:40px" value="<s:property value='#session.c.areaNum'/>" maxlength="11"/>
    <span id="areaNumUnit">㎡</span>
</td>
<td align="right"></td>
<td>
    
</td>
</tr>

<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
<td align="right"><font color="red">*</font>销售人员&nbsp;</td>
<td colspan="3">
    <input type="hidden" name="customer.managerId" value="<s:property value='#session.c.managerId'/>" />
    <span><s:property value='#session.c.descUserId'/></span>
    &nbsp;&nbsp;
    创建日期:
    <s:date name="#session.c.createdTime" format="yyyy-MM-dd "/>
    &nbsp;&nbsp;
    选定的项目:
    <font color="red"><span id="showProject"><s:property value='#session.selectedProjectName'/></span></font>

</td>

<td style="width:15%" align="right"></td>
<td>

</td>
</tr>


<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

<td colspan="6">
    &nbsp;<font color="red">请选择售前问卷：</font>
    <input type="hidden" id="selectQuestionId" value=""/>
    <select id="questionList" name="selectQuestionId" onchange="getQuestionId();">
    </select>
    <div style="margin: 5px;">
        <div id="" class="topinfo">&nbsp;自定义内容</div>
        <div id="ques_table">
        </div>
    </div>
</td>
</tr>

<tr>
    <td colspan="6">



        <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap;display:none" id="changeTable" >

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" id="change1">
                <td align="right">来访次数&nbsp;</td>
                <td>
                    <s:select id="selVisitCount" list="selVisitCount"  name="customer.visitCount" value="#session.c.visitCount"/>
                </td>
                <td style="width:15%" align="right">性别&nbsp;</td>
                <td style="width:18%">
                    <s:select id="selGender" list="selGender"  name="customer.gender" value="#session.c.gender"/>
                </td>
                <td style="width:15%" align="right">国籍&nbsp;</td>
                <td>
                    <input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" value="<s:property value='#session.c.nationality'/>" maxlength="10"/>
                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">身份证号码&nbsp;</td>
            <td style="width:18%">
                <input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto" value="<s:property value='#session.c.idcardNo'/>"
                       onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" onkeydown="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" maxlength="18"/>
                <span id="idcardNoCount"></span>
            </td>
            <td align="right">驾车车型&nbsp;</td>
            <td>
                <input type="text" name="customer.trafficDesc" id="trafficDesc" class="leftcreateinputbox02" style="width:auto" value="<s:property value='#session.c.trafficDesc'/>" maxlength="10"/>				</td>
            <td align="right">年龄&nbsp;</td>
            <td>
                <s:select id="selAgeRange" list="selAgeRange"  name="customer.age" value="#session.c.age"/>				</td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">地址&nbsp;</td>
            <td colspan="3">
                <input type="text" name="customer.address" id="address" class="leftcreateinputbox02" style="width:80%" value="<s:property value='#session.c.address'/>" maxlength="100"/>				</td>
            <td align="right">邮编&nbsp;</td>
            <td>
                <input type="text" name="customer.postcode" id="postcode" class="leftcreateinputbox01" value="<s:property value='#session.c.postcode'/>"/>				</td>
            </tr>


            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">家庭结构&nbsp;</td>
            <td>
                <s:select id="selFamilyType" list="selFamilyType"  name="customer.familyType" value="#session.c.familyType"/>				</td>
            <td align="right">家庭收入&nbsp;</td>
            <td>
                <s:select id="selFamilyIncome" list="selFamilyIncome"  name="customer.familyIncome" value="#session.c.familyIncome"/>				</td>
            <td align="right"></td>
            <td></td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">行业分类&nbsp;</td>
            <td>
                <s:select id="selJobType" list="selJobType"  name="customer.jobType" value="#session.c.jobType"/>				</td>
            <td align="right">职业&nbsp;</td>
            <td>
                <s:select id="selJobIndustry" list="selJobIndustry"  name="customer.jobIndustry" value="#session.c.jobIndustry"/>				</td>
            <td align="right">&nbsp;</td>
            <td>				</td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">意向购买单元1&nbsp;</td>
            <td>
                <input type="text" id="intentUnit1" name="customer.intentUnit1" value="<s:property value='#session.c.intentUnit1'/>" maxlength="10"/>				</td>
            <td align="right">意向购买单元2&nbsp;</td>
            <td>
                <input type="text" id="intentUnit2" name="customer.intentUnit2" value="<s:property value='#session.c.intentUnit2'/>" maxlength="10"/>				</td>
            <td align="right">&nbsp;</td>
            <td>				</td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">购房目的&nbsp;</td>
            <td>
                <s:select id="selBuyAim" list="selBuyAim"  name="customer.buyAim" value="#session.c.buyAim"/>				</td>
            <td align="right">付款方式&nbsp;</td>
            <td>
                <s:select id="selPayType" list="selPayType"  name="customer.payType" value="#session.c.payType"/>			</td>
            <td align="right">&nbsp;</td>
            <td>				</td>
            </tr>



            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

            <td align="right">意向套数&nbsp;</td>
            <td>
                <s:select id="selIntentBuynum" list="selIntentBuynum"  name="customer.intentBuynum" value="#session.c.intentBuynum"/>				</td>
            <td align="right">意向户型&nbsp;</td>
            <td>
                <s:select id="selRoomType" list="selRoomType"  name="customer.roomType" value="#session.c.roomType"/>		    </td>
            <td align="right"></td>
            <td></td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td id="t1" style="width:15%"  align="right">认知途径&nbsp;</td>
            <td colspan="5" style="white-space:normal;line-height: 30px">
                <s:checkboxlist id="selKnownFrom1" list="selKnownFrom1" name="knownFrom" value="#session.knowns"/>
            </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">关注点&nbsp;</td>
            <td colspan="5" style="white-space:normal">
                <s:checkboxlist id="selCustomerFocus" list="selCustomerFocus" name="customerFocus" value="#session.focus"/>
                <input type="hidden" id="focusPoint" />
            </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">未能成交原因&nbsp;</td>
            <td colspan="5" style="white-space:normal">
                <input type="text" name="customer.notBuyReson" id="notBuyReson" value="<s:property value='#session.c.notBuyReson'/>"
                       class="leftcreateinputbox02" style="width:80%" maxlength="50"/>
            </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="right">备注&nbsp;</td>
            <td colspan="5" style="white-space:normal">
                <textarea rows="" cols="" id="remark1" name="customer.remark1" style="height: 150px;width: 80%"><s:property value='#session.c.remark1'/></textarea>
            </td>
            </tr>

        </table>


    </td>
</tr>

<!--
			 <s:iterator value="questionDetailList" var="c">
			 <tr style="line-height: 20px" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			  	 <td colspan="6" id="t11"  align="left"> ${c.topicName }</td>
               
			  </tr>
			   <tr style="line-height: 20px" onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td  id="t12" colspan="6">
                	${c.inputAndOtherHtml }
				</td>
			  </tr>
			 </s:iterator>
			 -->
</table>
</td>
</tr>



<tr>
    <td colspan="6" align="center" bgcolor="#ffffff">
    	<input type="hidden" id="isTwentyFourLater" value="<s:property value='#request.isTwentyFourLater'/>"/>
		<input type="hidden" name="customer.createdTime" value="<s:property value='#session.c.createdTime'/>"/>
        <input type="hidden" name="customer.id" value="<s:property value='#session.c.id'/>"/>
        <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
        <input type="button" onclick="return validateCustForm();" value="  保存  " id="sub"/>
        <!--  &nbsp;&nbsp;
		  <input type="button" value="  返回  " onClick="javascript:window.location.href = '<%=basePath%>customer_guangzhou/search/searchOrderBy.action'" /> -->
        &nbsp;&nbsp;
        <input type="button" value="  跟进  " id="follow" ac="customer_guangzhou"/>
        &nbsp;&nbsp;
        <input type="button" id="copyCustomer" value="  转移客户  " onclick="return copyOneCustomer('<s:property value='#session.c.id'/>')"/>
        &nbsp;&nbsp;
        <input type="button" value="  关闭  " id="bnt-close" />
        <font color="#FF0000"><span id="tip"><s:property value="#request.session.suggestion"/></span></font>

    </td>
</tr>

<tr>
    <td colspan="6">

        <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: normal">
            <!-- follow top -->
            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td align="center" style="width:15%">跟进类型&nbsp;</td>
            <td align="center"  style="width:15%">跟进人&nbsp;</td>
            <td align="center"  style="width:15%">跟进日期&nbsp;</td>
            <td align="left"  colspan="3">跟进内容&nbsp;</td>
            </tr>

            <s:iterator value="#request.session.follows" id="f">
                <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                <td align="center"><s:property value="#f.descFollowType"/></td>
                <td align="center"><s:property value="#f.descUserId"/></td>
                <td align="center"><s:date name="#f.createdTime" format="yyyy-MM-dd "/></td>
                <td align="left" colspan="3"><s:property value="#f.followDesc"/></td>
                </tr>
            </s:iterator>

            <!-- follow end -->

        </table>

    </td>
</tr>


</table>
</form>

<%--主体table end --%>
</div>
</body>
</html>

