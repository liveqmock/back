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
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新建客户</title>

    <base href="<%=basePath%>" />

    <s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>
    <script type="text/javascript" language="javascript" src="./js/provi_city_region_select.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_sel.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_value_change.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_guangzhou_question.js"></script>
    <script type="text/javascript" language="javascript" src="./js/customer_guangzhou_input.js"></script>
    
    <link href="<%=basePath%>css/easyui.css" rel="stylesheet" type="text/css"	charset="utf-8" />
	<link href="<%=basePath%>css/icon.css" rel="stylesheet" type="text/css"	charset="utf-8" />
	<script type="text/javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>	
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
    <style type="text/css">
        *{margin:0;padding:0;}
        tr{height: 26px;}
    </style>
    <script>
        $().ready(function(){
        	var myDate = new Date();
            if($("#hiddenId").val() != 0){
                $("#ques_table").load('./customer_guangzhou/input/findQuestionTable.action',{proId:$("#hiddenId").val()});
            }

			$(".nokg").keyup(function(){
				this.value = this.value.replace(/\s/g, "");
			});
            
        })
        
    </script>

</head>

<body onload="clearSuggestion()">

<%--主体 --%>
<div class="ui_tools"></div>
<div class="ui_listview">

    <div class="c">
        &nbsp;&nbsp;
        <font color="#FF0000"><span id="suggestion"><s:if test="#request.session.suggestion != null"><script type="text/javascript">msgAlert('<s:property value="#request.session.suggestion"/>');</script></s:if></span></font>
    </div>

    <form class="registerform" action="./customer_guangzhou/input/addCustomerAndQuestion.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" method="post" >
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
            <tr  bgcolor="#eeeeee">
                <td colspan="6" style="font-weight: bold;">必填</td>
            </tr>

            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                 style="empty-cells:show">
                <td style="width:15%"  align="right"><font color="red">*</font>项目&nbsp;</td>
                <td>
                    <input  type="text" id="projectName" name="projectName" value="<s:property value='#request.project.projectName'/>"/>
                    <input type="hidden" id="hiddenId" name="customer.projectId" value="<s:property value='#request.project.id'/>"/>
                   
                    
                </td>
                <td> <div><font color="red">请首先确定项目</font></div></td>
            	   <td></td>
                <td style="width:15%"  align="right"></td>
                <td></td>
            </tr>

            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                 style="empty-cells:show">
                <td style="width:15%"  align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td>
                    <input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01 nokg" maxlength="10" />
                </td>
                <td style="width:15%"  align="right"><font color="red">*</font>客户评级&nbsp;</td>
                <td style="width:18%">
                    <s:select list="selRating"  name="customer.rating"/>
                </td>
                <td style="width:15%"  align="right">来访日期</td>
                <td>
                    <input onfocus="javascript:blur()" class="Wdate" type="text" id="visitDate" style="width:90px" name="customer.visitDate" value="${nowDate}"/>
                </td>
            </tr>

            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                 style="empty-cells:show">
                <td style="width:15%" align="right"><font color="red">*</font>移动电话&nbsp;</td>
                <td style="width:18%">
                    <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01 nokg" maxlength="12" title="移动电话,固定电话可以二选一"
                           onkeyup="valueChangeGetCount('phone', 'phoneCount', 11)" onkeydown="valueChangeGetCount('phone', 'phoneCount', 11)"/>
                    <span id="phoneCount"></span>
                </td>
                <td style="width:15%" align="right"><font color="red">*</font>固定电话&nbsp;</td>
                <td id="t14">
                    <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01 nokg" title="移动电话,固定电话可以二选一" maxlength="15"/>				</td>
                <td colspan="2">
                    (移动电话,固定电话可以二选一)
                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                <td align="right"><font color="red">*</font>居住区域&nbsp;</td>
                <td colspan="5">
                    <s:select list="selProvince"  name="customer.homeProvince" value="#session.cacheCustomer.homeProvince" cssStyle="width:auto"/>省
                    <s:select list="selHomeCity"  name="customer.homeCity" value="#session.cacheCustomer.homeCity" cssStyle="width:auto"/>市
                    <s:select list="selHomeRegion"  name="customer.homeRegion" value="#session.cacheCustomer.homeRegion" cssStyle="width:auto"/>
                    <input class="nokg" type="text" id="homeContent" name="customer.homeContent" value="<s:property value='#session.cacheCustomer.homeContent'/>"  maxlength="30"/>

                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                <td align="right"><font color="red">*</font>工作区域&nbsp;</td>
                <td colspan="5">
                    <s:select list="selProvince"  name="customer.workProvince" value="#session.cacheCustomer.workProvince" cssStyle="width:auto"/>省
                    <s:select list="selWorkCity"  name="customer.workCity" value="#session.cacheCustomer.workCity" cssStyle="width:auto"/>市
                    <s:select list="selWorkRegion"  name="customer.workRegion" value="#session.cacheCustomer.workRegion" cssStyle="width:auto"/>
                    <input class="nokg" type="text" id="workContent" name="customer.workContent" value="<s:property value='#session.cacheCustomer.workContent'/>"  maxlength="30" />
                    &nbsp;
                    <input type="checkbox" id="copyHome" />与居住区域相同
                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
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

                    <input type="text" name="customer.priceNum" id="priceNum" style="width:80px" maxlength="9" class="easyui-numberbox"/>
                    万
                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
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
                    <input type="text" name="customer.areaNum" id="areaNum" style="width:80px" maxlength="9" class="easyui-numberbox"/>
                    <span id="areaNumUnit">㎡</span>
                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                <td align="right"><font color="red">*</font>销售人员&nbsp;</td>
                <td colspan="3">
                    <input type="hidden" name="customer.managerId" value="<s:property value='#session.loginAccount.id'/>" />
                    <span><s:property value='#session.loginAccount.realName'/></span>
                    &nbsp;&nbsp;
                    当前时间:
                    <span id="nowTime"></span>
                    &nbsp;&nbsp;
                    选定的项目:
                    <span id="showProject"></span>
                </td>
                <td id="t9" style="width:15%" align="right"></td>
                <td id="t6"></td>
            </tr>

            <tr  bgcolor="#eeeeee">
                <td colspan="6" style="font-weight: bold;">选填(带<font color="red">*</font>为必填项)</td>
            </tr>
            <tr>
                <td colspan="6" style="margin: 0;padding: 0;width:100%;">
                    <div id="ques_table" style="width: 100%">
                    </div>
                </td>
            </tr>
            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" align="center">
                <td colspan="6">

                    <s:token />
                    <input type="submit" value="  保存  " id="sub"/>
                    <input type="hidden" id="baseUrl" value="<%=basePath%>"/>
                    &nbsp;&nbsp;
                    <input type="button" value="  关闭  " id="bnt-close" />
                </td>
            </tr>
        </table>
    </form>

    <%--主体table end --%>


</div>
</body>
</html>

