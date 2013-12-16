<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>

    <title>查询客户</title>

    <base href="<%=basePath%>">

    <s:include value="header.jsp"></s:include>
    <s:include value="header_left_js.jsp"></s:include>

    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_alldel.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_copy.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_user.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_follow.js"></script>

    <script type="text/javascript" language="javascript">
        $(document).ready(function(){

            projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id

            $("#weekData").click(function(){
                $("#workOrMonth").val("week");
                $("#searchForm").submit();
            });

            $("#monthData").click(function(){
                $("#workOrMonth").val("month");
                $("#searchForm").submit();
            });

            $("#downLoadId").click(function(){
                window.location.href = "./customer_guangzhou/search/downLoad.action";
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

        });

    </script>

    <style>
        *{margin:0;padding:0;}

    </style>

</head>

<body onload="clearSome('suggestion', 2000)">
<div class="ui_tools">
    <!-- 搜索表单 top -->

    <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/customer_guangzhou/search/search.action" method="post" >

        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle" width="180">客户姓名</td>


                <td width="187" align="left" valign="middle">
                    <input id="searchName" name="searchCond.searchName" value="${searchCond.searchName}"/>	</td>

                <td align="center" valign="middle" width="180">
                    移动电话	</td>

                <td width="187" align="left" valign="middle">
                    <input id="searchPhone" name="searchCond.searchPhone" value="${searchCond.searchPhone}"/>	</td>

                <td align="center" valign="middle" width="180">
                    意向总价	 </td>

                <td width="120" align="left" valign="middle" style="white-space:nowrap">
                    <input type="text" id="price1" style="width:40px" name="searchCond.price1" value="${searchCond.price1}"/>
                    -
                    <input type="text" id="price2" style="width:40px" name="searchCond.price2" value="${searchCond.price2}"/>
                    万	</td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle">
                    意向面积	</td>

                <td width="187" align="left" valign="middle">
                    <input type="text" id="area1" style="width:40px" name="searchCond.area1" value="${searchCond.area1}"/>
                    -
                    <input type="text" id="area2" style="width:40px" name="searchCond.area2" value="${searchCond.area2}"/>
                    ㎡	</td>

                <td align="center" valign="middle">
                    创建日期	</td>

                <td width="200" align="left" valign="middle" style="white-space:nowrap">
                    <input class="Wdate" type="text" id="date1" style="width:90px" name="searchCond.date1" value="${searchCond.date1}"/>
                    -
                    <input class="Wdate" type="text" id="date2" style="width:90px" name="searchCond.date2" value="${searchCond.date2}"/>	</td>

                <td align="center" valign="middle">
                    客户来源	 </td>

                <td width="120" align="left" valign="middle">
                    <s:select list="selCustomerSource" name="searchCond.customerSource"></s:select>	</td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle">
                    未跟进天数	</td>

                <td width="187" align="left" valign="middle">
                    <input type="text" id="notFollowDay" style="width:40px" name="searchCond.notFollowDay" value="${searchCond.notFollowDay}"/>
                    天	</td>

                <td align="center" valign="middle">
                    产品类型	</td>

                <td width="187" align="left" valign="middle">
                    <s:select list="selHouseType" name="searchCond.houseType"></s:select>
                </td>

                <s:if test="#session.loginAccount.projectId != 53 && #session.loginAccount.projectId != 66">
                    <td align="center" valign="middle">
                        所属项目
                    </td>
                    <td width="120" align="left" valign="middle">
                        <input type="hidden" id="hiddenId" name="searchCond.projectId" value="${searchCond.projectId}"/>
                        <input type="text" id="projectName" name="projectName" value="${projectName}" title="按空格键可以查找前十条数据"/>
                    </td>
                </s:if>

                <s:else>
                    <td></td>
                    <td></td>
                </s:else>
            </tr>


            <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td align="center" valign="middle">
                    所属销售
                </td>
                <td width="187" align="left" valign="middle">
                    <input type="text" id="saleName" name="searchCond.saleName" value="${searchCond.saleName}" title="可进行模糊查询"/>
                </td>

                <td align="center" valign="middle">
                    客户评级
                </td>
                <td>
                    <s:select list="selRating"  name="searchCond.rating"></s:select>
                </td>

                <td align="center" valign="middle" style="white-space:nowrap">
                    <a id="weekData" href="#" style="color:#1199FF" target="_self" onclick="return false;">本周数据</a>
                    <a id="monthData" href="#" style="color:#1199FF" target="_self" onclick="return false;">本月数据</a>
                    <input type="hidden" id="workOrMonth" name="workOrMonth" value="" />
                </td>

                <td align="left" valign="middle">
                    <input type="submit" value="  搜索  " id="searchSubmit"/>
                </td>

            </tr>
        </table>

    </form>

    <!-- 搜索表单 end -->

</div>

<div class="ui_listview">

<%--主体table top --%>

<div class="c">
    &nbsp;&nbsp;
    <font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
</div>

<table style="width: -moz-available;" align="left" border="0" cellspacing="0">



<tr>
    <td height="10" colspan="6">
        <div class="blueline"></div>
    </td>
</tr>

<tr>
    <td height="20" colspan="6">

        操作：
        <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__DELETE, EnumDevFlag.GUANGZHOU)){%>
        <input type="button" id="delete" value="  删除  "
               onClick="return delCustomers('<%=basePath%>customer_guangzhou/delete/customers.action')"/>
        <%} %>

        <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__PROJECT, EnumDevFlag.GUANGZHOU)){%>
        <input type="button" id="copyCustomer" value="  转移客户  " onclick="return copyCustomers()"/>
        <%} %>
        <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__DOWNLOAD, EnumDevFlag.GUANGZHOU)){%>
        <input type="button" id="downLoadId" value="  下载数据  " />
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
                <tr class="gboxbg">

                    <td width="20" align="center">
                        <label for="checkbox">
                            <input name="allDel" type="checkbox" value="" onClick="allDel()" id="allDel"/>
                        </label>
                    </td>

                    <td width="100">
                        <table width="99" height="28"  border="0" align="center" cellspacing="0">
                            <tr>
                                <td width="80%" align="center" valign="middle">客户名称</td>
                                <td align="center" valign="middle">
                                    <table width="5" border="0" cellspacing="0">
                                        <tr>
                                            <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=14"><img id="img14" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
                                        </tr>
                                        <tr>
                                            <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=13"><img id="img13" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </td>


                    <td width="100">
                        <table width="100" height="28"  border="0" align="center" cellspacing="0">
                            <tr>
                                <td width="80%" align="center" valign="middle">意向总价</td>
                                <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=18"><img id="img18" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=17"><img id="img17" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                </table>
                                </td>
                            </tr>
                        </table>
                    </td>

                    <td width="120">
                        <table width="100" height="28"  border="0" align="center" cellspacing="0">
                            <tr>
                                <td width="80%" align="center" valign="middle">意向面积</td>
                                <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=20"><img id="img20" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=19"><img id="img19" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                </table>
                                </td>
                            </tr>
                        </table>
                    </td>

                    <td width="120" align="center" valign="middle">
                        电话
                    </td>
                    <td width="120" align="center" valign="middle">
                        手机归属地
                    </td>
                    <td width="110">
                        <table width="100" height="28"  border="0" align="center" cellspacing="0">
                            <tr>
                                <td width="80%" align="center" valign="middle">创建日期</td>
                                <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=12"><img id="img12" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=11"><img id="img11" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                </table>
                                </td>
                            </tr>
                        </table>
                    </td>

                    <td width="120">
                        <table width="100" height="28"  border="0" align="center" cellspacing="0">
                            <tr>
                                <td width="80%" align="center" valign="middle">最后跟进日期</td>
                                <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=22"><img id="img22" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                    <tr>
                                        <td><a href="./customer_guangzhou/search/searchOrderBy.action?ob=21"><img id="img21" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></td>
                                    </tr>
                                </table>
                                </td>
                            </tr>
                        </table>
                    </td>

                    <td width="110" align="center" valign="middle">
                        所属销售
                    </td>

                    <td width="80" align="center" valign="middle">
                        未跟进天数
                    </td>

                    <td width="50" align="center" valign="middle">
                        操作
                    </td>
                </tr>



                <s:iterator value="#request.cusList" id="c">
                    <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                        title='客户名称:<s:property value="#c.customerName"/>, 电话:${c.dbPhone}'>
                        <td width="20" align="center"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
                        <td align="center" valign="middle" class="fontblue">
                            <a href="./customer_guangzhou/update/getById.action?id=<s:property value='#c.id'/>" target="_self" ><s:property value="#c.customerName"/></a>
                        </td>

                        <td align="center" valign="middle">
                            <s:property value="#c.priceNum"/>
                            万
                        </td>
                        <td align="center" valign="middle">
                            <s:property value="#c.areaNum"/>
                            ㎡
                        </td>
                        <td align="center" valign="middle">
                                ${c.dbPhone}
                        </td>
                        <td align="center" valign="middle">
                                ${c.phoneFrom}
                        </td>
                        <td align="center" valign="middle">
                            <s:date name="#c.createdTime" format="yyyy-MM-dd "/>
                        </td>
                        <!--
		<td align="center" valign="middle" class="fontblue">
			<a href="#" onclick="customerIndexFollow(<s:property value='#c.id'/>); return false;"><s:date name="#c.modTime" format="yyyy-MM-dd "/></a>
		</td>
		-->
                        <td align="center" valign="middle">
                            <s:date name="#c.modTime" format="yyyy-MM-dd "/>
                        </td>

                        <td align="center" valign="middle">
                            <s:property value="#c.descUserId"/>
                        </td>

                        <td align="center" valign="middle">
                                ${c.notFollowDay}
                        </td>

                        <td align="center" valign="middle" class="fontblue">
                            <a href="#" onclick="customerIndexFollow(<s:property value='#c.id'/>); return false;">跟进</a>
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
</body>
</html>

