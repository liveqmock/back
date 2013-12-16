<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@ page language="java" import="com.ihk.utils.CacheUtils" isELIgnored="false"%>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@page import="com.ihk.constanttype.*"%>
<%@page import="com.ihk.utils.SessionUser"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

    <title>查询客户</title>

    <base href="<%=basePath%>" />

    <s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_alldel.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_copy.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_follow.js"></script>

    <script type="text/javascript" language="javascript">
        $(document).ready(function(){

            //projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
            baseProjectListForHiddenId("projectName", "hiddenId", "./customer_guangzhou/search/projects.action", "");

            //baseProjectListForHiddenId("saleName", "hiddenSaleName", "./customer_guangzhou/search/sales.action", "");
            baseProjectListForHiddenId("saleName", "hiddenUserId", "./customer_guangzhou/search/sales.action", "");

            $("#weekData").click(function(){
                showLoad();
                $("#workOrMonth").val("week");
                $("#searchForm").submit();
            });

            $("#monthData").click(function(){
                showLoad();
                $("#workOrMonth").val("month");
                $("#searchForm").submit();
            });

            $("#defaultSearch").click(function(){
                showLoad();
                window.location.href = './customer_guangzhou/search/index.action';
                //$('#searchForm').attr('action', './customer_guangzhou/search/index.action');
                //$("#searchForm").submit();
                $.ajax({
                    url:'./customer_guangzhou/search/getSelPayWayByCompanyProjectId.action?projectId='+$("#hiddenId").val(),
                    success:function(data){
                        $("#payTypeList").empty();
                        $("#payTypeList").append(data);
                    }
                });
            });

            $("#downLoadId").click(function(){
                window.location.href = "./customer_guangzhou/search/downLoadContractCustomer.action";
            });

            var ob = "<%=request.getParameter("ob")%>";
            //alert(ob);
            if(ob != "null"){
                if(ob % 2 == 1){

                    $("#img" + ob).attr("src", "images/blue/downopen.gif");
                }else{
                    $("#img" + ob).attr("src", "images/blue/upopen.gif");
                }
            }

            $("#projectName").blur(function(){
                $.ajax({
                    url:'./customer_guangzhou/search/getSelPayWayByCompanyProjectId.action?projectId='+$("#hiddenId").val(),
                    success:function(data){
                        $("#payTypeList").empty();
                        $("#payTypeList").append(data);
                    }
                });
            });
        });

        function showCustomer(customerId){
            new MyAjaxIframeDialog({
                title:'查看售后客户',
                formId:'searchForm',
                buttons:false,
                height:550, width:700,
                src:'./saleunit_new/appoint/guangzhou/toModifyContractCustomerReadOnly.action?customerId=' + customerId
            });




        }

        function showLoad(){
            //$("#loading").show();

            /**
             var dialog = new Dialog("<h1><image src='images/loading.gif'/><font color='#15428B'>加载中...</font></h1>",
             {showTitle:false,width:'200px'});
             dialog.show();
             */

            try{

                //var module = parent.$('#tabs').tabs('getSelected').panel('options').content;
                var module = $('body');
                var width = module.width();
                var height = module.height();

                var mask = '<div id="maskDiv" style="display: block;" class="datagrid-mask"></div>'; // width: 578px; height: 31px;
                var msg = '<div id="msgDiv" style="display: block;" class="datagrid-mask-msg">加载中...</div>'; //left: 242.5px; top: -5.5px;

                $(module).append(mask);
                $(module).append(msg);

                //$("#maskDiv").width(width+10).height(height*10);
                //$("#msgDiv").css("left", width/4).css("top", height/2);

                $("#msgDiv").css("left", width/2);

            }catch(e){}

        }

    </script>

    <style>
        *{margin:0;padding:0;}

    </style>

</head>

<body onload="clearSome('suggestion', 2000)">

<div class="right99"></div>
<div class="c"></div>
<div class="c" style="padding-left: 5px">
    <font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
</div>

<div class="ui_tools">
    <!-- 搜索表单 top -->

    <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/customer_guangzhou/search/searchContractCustomer.action" method="post" >

        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle" width="190px" height="20">客户姓名</td>

                <td width="200" align="left" valign="middle">
                    <input id="searchName" name="ccSearchCond.searchName" value="${ccSearchCond.searchName}"/>	</td>

                <td align="center" valign="middle" width="190px">
                    移动电话	</td>

                <td width="187" align="left" valign="middle">
                    <input id="searchPhone" name="ccSearchCond.searchPhone" value="${ccSearchCond.searchPhone}"/>	</td>

                <s:if test="#session.loginAccount.projectId != 53 && #session.loginAccount.projectId != 66">
                    <td align="center" valign="middle" width="180">
                        所属项目
                    </td>
                    <td width="120" align="left" valign="middle">
                        <input type="hidden" id="hiddenId" name="ccSearchCond.projectId" value="${ccSearchCond.projectId}"/>
                        <input type="text" id="projectName" name="projectName" value="${projectName}" title="按空格键可以查找前十条数据"/>
                    </td>
                </s:if>

                <s:else>
                    <td></td>
                    <td></td>
                </s:else>

            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">
                    认购面积	</td>

                <td width="187" align="left" valign="middle">
                    <input type="text" id="area1" style="width:40px" name="ccSearchCond.area1" value="${ccSearchCond.area1}"/>
                    -
                    <input type="text" id="area2" style="width:40px" name="ccSearchCond.area2" value="${ccSearchCond.area2}"/>
                    ㎡	</td>

                <td align="center" valign="middle" width="180">
                    认购总价	 </td>

                <td width="120" align="left" valign="middle" style="white-space:nowrap">
                    <input type="text" id="price1" style="width:40px" name="ccSearchCond.price1" value="${ccSearchCond.price1}"/>
                    -
                    <input type="text" id="price2" style="width:40px" name="ccSearchCond.price2" value="${ccSearchCond.price2}"/>
                    万	</td>

                <td align="center" valign="middle">
                    成交类型	 </td>

                <td width="187" align="left" valign="middle">
                    <s:select list="confirmTypeList" name="ccSearchCond.confirmType"></s:select>
                </td>


            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">
                    付款方式	</td>

                <td width="120" align="left" valign="middle">
                    <s:select id="payTypeList" list="payTypeList" name="ccSearchCond.payType"></s:select>(选择项目后获取付款方式)	</td>

                 <td align="center" valign="middle" height="20">
                   居住区域
                </td>
                <td width="187" align="left" valign="middle">
                    <input style="width:50px" id="homeProvince" name="ccSearchCond.homeProvince" value="${ccSearchCond.homeProvinceStr}"/>(省)	
                    <input style="width:50px" id="homeCity" name="ccSearchCond.homeCity" value="${ccSearchCond.homeCityStr}"/>(市)	
                    <input style="width:50px" id="homeRegion" name="ccSearchCond.homeRegion" value="${ccSearchCond.homeRegionStr}"/>(区)
                    <input style="width:50px" id="homeContent" name="ccSearchCond.homeContent" value="${ccSearchCond.homeContent}"/>
                 </td>
                <td align="center" valign="middle">
                   户籍区域	</td>

               <td width="187" align="left" valign="middle">
                   <input style="width:50px" id="householdProvince" name="ccSearchCond.householdProvince" value="${ccSearchCond.householdProvinceStr}"/>(省)	
                   <input style="width:50px" id="householdCity" name="ccSearchCond.householdCity" value="${ccSearchCond.householdCityStr}"/>(市)
                   <input style="width:50px" id="householdRegion" name="ccSearchCond.householdRegion" value="${ccSearchCond.householdRegionStr}"/>(区)	
                   <input style="width:50px" id="householdContent" name="ccSearchCond.householdContent" value="${ccSearchCond.householdContent}"/>	
               	</td>

            </tr>


            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">
                    成交日期
                </td>
                <td width="200" align="left" valign="middle">
                    <input class="easyui-datebox" type="text" id="date1" style="width:90px" name="ccSearchCond.date1" value="${ccSearchCond.date1}"/>
                    -
                    <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="ccSearchCond.date2" value="${ccSearchCond.date2}"/>
                </td>





                <td align="center" valign="middle" height="20">
                    所属销售
                </td>
                <td width="187" align="left" valign="middle">

                    <!--没有提示框的模糊查询
                    <input type="text" id="saleName" name="searchCond.saleName" value="${searchCond.saleName}" title="可进行模糊查询"/>
					-->

                    <!--有提示框的模糊查询
					 <input type="text" id="saleName" value="${searchCond.saleName}" name="searchCond.saleName" title="按空格键可以查找前十条数据"/>
					 <input type="hidden" id="hiddenSaleName" value="${searchCond.saleName}" />
					 -->

                    <!--有提示框的精确查询-->
                    <input type="text" id="saleName" value="${ccSearchCond.saleName}" name="ccSearchCond.saleName" title="按空格键可以查找前十条数据"/>
                    <input type="hidden" id="hiddenUserId" value="${ccSearchCond.userId}" name="ccSearchCond.userId" />

                </td>



                <td align="center" valign="middle">
                    生日
                </td>

                <td width="200" align="left" valign="middle" style="white-space:nowrap">
                    <input class="easyui-datebox" type="text" id="birthday1" style="width:90px" name="ccSearchCond.birthday1" value="${ccSearchCond.birthday1}"/>
                    -
                    <input class="easyui-datebox" type="text" id="birthday2" style="width:90px" name="ccSearchCond.birthday2" value="${ccSearchCond.birthday2}"/>

                </td>



            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">

                    <input type="submit" value="  搜索  " id="searchSubmit" onclick="showLoad();return true;"/>
                </td>
                <td width="200" align="left" valign="middle">

                </td>





                <td align="center" valign="middle" height="20">

                </td>
                <td width="187" align="left" valign="middle">

                    <!--没有提示框的模糊查询
                    <input type="text" id="saleName" name="searchCond.saleName" value="${searchCond.saleName}" title="可进行模糊查询"/>
					-->

                    <!--有提示框的模糊查询
					 <input type="text" id="saleName" value="${searchCond.saleName}" name="searchCond.saleName" title="按空格键可以查找前十条数据"/>
					 <input type="hidden" id="hiddenSaleName" value="${searchCond.saleName}" />
					 -->

                    <!--有提示框的精确查询-->


                </td>



                <td align="center" valign="middle">

                </td>

                <td width="200" align="left" valign="middle" style="white-space:nowrap">

                </td>



            </tr>


        </table>

    </form>

    <!-- 搜索表单 end -->

</div>

<div class="ui_listview">

<div class="right99"></div>

<%--主体table top --%>



<table style="width: 100%;" align="left" border="0" cellspacing="0">



<tr>
    <td height="10" colspan="6">
        <div class="blueline"></div>
    </td>
</tr>

<tr>
    <td height="20" colspan="6">

        操作：


        <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__DOWNLOAD, EnumDevFlag.GUANGZHOU)){%>
        <%if(SessionUser.getCompanyId()!=ContCompanyId.DONGGUAN
                || SessionUser.getUserId()== ContUserId.DG_SHENJINFENG
                || SessionUser.getUserId()== ContUserId.DG_LUOLILI
                ){%>
        <input type="button" id="downLoadId" value="  下载数据  " />
        <%} %>
        <%} %>


        <div id="load"></div>
        <%--
		  <a style="color:#1199FF" href="./customer_guangzhou/search/downLoad.action">下载数据</a>
		  <a href="./customer_guangzhou/search/tmpFetchPhoneFrom.action">手机归属地</a>
		  --%>
    </td>
</tr>

<tr>
<td colspan="6">

<!--  列表 top -->
<div class="gbox1">

<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
<tr style="background-color: #ffffff;height: 24px">

    <td width="20" align="center">
        <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>
    </td>

    <td >
        <div style="float: left;width: 70px">
            <div style="float: left;width: 40px;padding-left: 14px">客户名</div>
            <div style="float: right;padding-right: 4px">
                <div style="height: 7px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=14" onclick="showLoad();return true;">
                        <img id="img14" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>

                <div style="height: 7px;padding-bottom: 2px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=13" onclick="showLoad();return true;">
                        <img id="img13" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></div>
            </div>
        </div>
    </td>


    <td width="80" align="center" valign="middle">
        电话
    </td>
    <td>
        <div style="float: left;width: 70px;">
            <div style="float: left;width: 50px;padding-left: 5px">所属项目</div>
            <div style="float: right;padding-right: 4px">
                <div style="height: 7px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=16" onclick="showLoad();return true;">
                        <img id="img16" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                </div>
                <div style="height: 7px;padding-bottom: 2px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=15" onclick="showLoad();return true;">
                        <img id="img15" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                </div>
            </div>
        </div>
    </td>
    <td align="center" valign="middle">
        <div style="width: 50px">
            分区
        </div>
    </td>
    <td align="center" valign="middle">

        <div style="width: 50px">
            楼栋
        </div>

    </td>

    <td align="center" valign="middle">
        <div style="width: 50px">
            单元号
        </div>

    </td>


    <td align="center">
        <div style="float: left;width: 70px;">
            <div style="float: left;width: 50px;padding-left: 5px">成交类型</div>
            <div style="float: right;padding-right: 4px">
                <div style="height: 7px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=18" onclick="showLoad();return true;">
                        <img id="img18" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                </div>
                <div style="height: 7px;padding-bottom: 2px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=17" onclick="showLoad();return true;">
                        <img id="img17" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                </div>
            </div>
        </div>
    </td>

    <td align="center">
        <div style="float: left;width: 70px;">
            <div style="float: left;width: 50px;padding-left: 5px">成交日期</div>
            <div style="float: right;padding-right: 4px">
                <div style="height: 7px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=20" onclick="showLoad();return true;">
                        <img id="img20" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                </div>
                <div style="height: 7px;padding-bottom: 2px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=19" onclick="showLoad();return true;">
                        <img id="img19" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                </div>
            </div>
        </div>
    </td>

    <td align="center" >
        <div style="float: left;width: 70px;">
            <div style="float: left;width: 50px;padding-left: 5px">所属销售</div>
            <div style="float: right;padding-right: 4px">
                <div style="height: 7px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=22" onclick="showLoad();return true;">
                        <img id="img22" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                </div>
                <div style="height: 7px;padding-bottom: 2px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=21" onclick="showLoad();return true;">
                        <img id="img21" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                </div>
            </div>
        </div>

    </td>

    <td align="center" valign="middle">
        <div style="width: 75px;">
            付款方式
        </div>
    </td>

    <td align="center" valign="middle">
        <div style="float: left;width: 70px;">
            <div style="float: left;width: 50px;padding-left: 5px">认购面积</div>
            <div style="float: right;padding-right: 4px">
                <div style="height: 7px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=26" onclick="showLoad();return true;">
                        <img id="img26" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                </div>
                <div style="height: 7px;padding-bottom: 2px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=25" onclick="showLoad();return true;">
                        <img id="img25" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                </div>
            </div>
        </div>
    </td>


    <td align="center" valign="middle">
        <div style="float: left;width: 70px;">
            <div style="float: left;width: 50px;padding-left: 5px">认购总价</div>
            <div style="float: right;padding-right: 4px">
                <div style="height: 7px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=24" onclick="showLoad();return true;">
                        <img id="img24" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                </div>
                <div style="height: 7px;padding-bottom: 2px">
                    <a href="./customer_guangzhou/search/searchContractCustomerOrderBy.action?ob=23" onclick="showLoad();return true;">
                        <img id="img23" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                </div>
            </div>
        </div>

    </td>

    <td align="center" valign="middle">
        <div style="width: 50px">
            居住省
        </div>

    </td>
    <td align="center" valign="middle">
        <div style="width: 50px">
            居住市
        </div>

    </td>
    <td align="center" valign="middle">
        <div style="width: 50px">
            居住区
        </div>

    </td>

    <td align="center" valign="middle">
        <div style="width: 50px">
            户籍省
        </div>

    </td>
    <td align="center" valign="middle">
        <div style="width: 50px">
            户籍市
        </div>

    </td>
    <td align="center" valign="middle">
        <div style="width: 50px">
            户籍区
        </div>

    </td>


</tr>




<s:iterator value="#request.concusList" id="c">
    <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
        title='客户名称:<s:property value="#c.customerName"/>, 电话:${c.mobilePhone}'>
        <td width="20" align="center" height="25"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
        <td align="center" valign="middle" class="fontblue">
            <a href="#" onclick="showCustomer(<s:property value='#c.id'/>);return false;">
                <s:property value="#c.customerName"/>
            </a>
            <a href="./saleunit_new/appoint/guangzhou/toModifyContractCustomerReadOnly.action?customerId='<s:property value='#c.id'/>" target="_self" ></a>
        </td>


        <td align="center" valign="middle">
            <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_RETRIEVE_TEL,EnumDevFlag.GUANGZHOU)){%>
                ${c.mobilePhone}
            <%}else{%>
            <s:if test="#c.createdId== #session.loginAccount.id">
                   ${c.mobilePhone}
            </s:if>
            <s:else>
                ***
            </s:else>
            <%}%>
        </td>
        <td align="center" valign="middle">
                ${c.projectStr}
        </td>
        <td align="center" valign="middle">
                ${c.areaName}
        </td>
        <td align="center" valign="middle">
                ${c.buildName }
        </td>

        <td align="center" valign="middle">
                ${c.unitNo }
        </td>
        <td align="center" valign="middle">
            <!--<s:date name="#c.createdTime" format="yyyy-MM-dd "/>-->
                ${c.confirmTypeStr}
        </td>
        <!--
		<td align="center" valign="middle" class="fontblue">
			<a href="#" onclick="customerIndexFollow(<s:property value='#c.id'/>); return false;"><s:date name="#c.modTime" format="yyyy-MM-dd "/></a>
		</td>
		-->
        <td align="center" valign="middle">
            <s:date name="#c.confirmTypeDate" format="yyyy-MM-dd"/>
        </td>

        <td align="center" valign="middle">
                ${c.confirmTypeSalesStr}
        </td>

        <td align="center" valign="middle">
                ${c.confirmTypePayWay}
        </td>

        <td align="center" valign="middle">
                ${c.buildArea }
        </td>

        <td align="center" valign="middle">
                ${c.sumMoney }
        </td>

        <td align="center" valign="middle">
                ${c.homeProvinceStr }
        </td>
        <td align="center" valign="middle">
                ${c.homeCityStr }
        </td>
        <td align="center" valign="middle">
                ${c.homeRegionStr }
        </td>

        <td align="center" valign="middle">
                ${c.householdProvinceStr }
        </td>
        <td align="center" valign="middle">
                ${c.householdCityStr }
        </td>
        <td align="center" valign="middle">
                ${c.householdRegionStr }
        </td>






    </tr>
</s:iterator>

</table>
</div>

<!-- 列表 end -->


</td>
</tr>

<tr>
    <td colspan="6">
        <div class="manu">
            <s:property value="showPage" escape="false"/>
        </div>
    </td>
</tr>


</table>


<%--主体table end --%>
</div>

<!--
<div id='loading' style="position:absolute;z-index:100000;top:0px;left:0px;width:100%;height:100%; background-color:#eeeeee;text-align:center;padding-top: 20%; display:none">
	<h1><image src='images/loading.gif'/><font color="#15428B">加载中...</font></h1>
</div>
-->

</body>
</html>

