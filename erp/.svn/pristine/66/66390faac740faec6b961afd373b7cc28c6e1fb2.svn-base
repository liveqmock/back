<%@ page language="java" import="com.ihk.constanttype.ContCompanyId" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="com.ihk.constanttype.ContUserId"%>
<%@ page language="java" import="com.ihk.constanttype.EnumDevFlag" isELIgnored="false"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@page import="com.ihk.permission.PermissionUtils"%>
<%@page import="com.ihk.utils.CacheUtils"%>
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
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_copy.js?v=1.3"></script>
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
            });

            $("#downLoadId").click(function(){
                var questionId = $("#questionId").val();
                if(questionId== undefined){
                    questionId=0;
                }
                var delIds = document.getElementsByName("delId");
                var arr = new Array();
                for(var i=0; i<delIds.length; i++){
            		if(delIds[i].checked == true){
            			arr[i]=delIds[i].value;
            			//alert(delIds[i].value);
            		}
                }
                window.location.href = "./customer_guangzhou/search/downLoad.action?question.id="+questionId+"&customerIds="+arr;
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

        function showCustomer(id){
            parent.addTab('编辑客户_ID:'+id,'<%=request.getContextPath()%>/customer_guangzhou/update/getById.action?id='+id+'&ts=<%= CacheUtils.getUrlTimeStamp()%>','');
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

    <form class="registerform" id="searchForm" action="<%=request.getContextPath() %>/customer_guangzhou/search/search.action" method="post" >

        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="white-space:nowrap">

            <tr bgcolor="#FFFFFF">

                <td align="center" valign="middle" width="190px" height="20">客户姓名</td>

                <td width="200" align="left" valign="middle">
                    <input id="searchName" name="searchCond.searchName" value="${searchCond.searchName}"/>	</td>

                <td align="center" valign="middle" width="190px">
                    移动电话	</td>

                <td width="187" align="left" valign="middle">
                    <input id="searchPhone" name="searchCond.searchPhone" value="${searchCond.searchPhone}"/>	</td>

                <s:if test="#session.loginAccount.projectId != 53 && #session.loginAccount.projectId != 66">
                    <td align="center" valign="middle" width="180">
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

            <tr bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">
                    意向面积	</td>

                <td width="187" align="left" valign="middle">
                    <input type="text" id="area1" style="width:40px" name="searchCond.area1" value="${searchCond.area1}"/>
                    -
                    <input type="text" id="area2" style="width:40px" name="searchCond.area2" value="${searchCond.area2}"/>
                    ㎡	</td>

                <td align="center" valign="middle" width="180">
                    意向总价	 </td>

                <td width="120" align="left" valign="middle" style="white-space:nowrap">
                    <input type="text" id="price1" style="width:40px" name="searchCond.price1" value="${searchCond.price1}"/>
                    -
                    <input type="text" id="price2" style="width:40px" name="searchCond.price2" value="${searchCond.price2}"/>
                    万	</td>

                <td align="center" valign="middle">
                    未跟进天数	 </td>

                <td width="187" align="left" valign="middle">
                    <input type="text" id="notFollowDay" style="width:40px" name="searchCond.notFollowDay" value="${searchCond.notFollowDay}"/>
                    天	</td>


            </tr>

            <tr bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">
                    客户来源	</td>

                <td width="120" align="left" valign="middle">
                    <s:select list="selCustomerSource" name="searchCond.customerSource"></s:select>	</td>

                <td align="center" valign="middle">
                    产品类型	</td>

                <td width="187" align="left" valign="middle">
                    <s:select list="selHouseType" name="searchCond.houseType"></s:select>
                </td>

                <td align="center" valign="middle">
                    客户评级
                </td>
                <td>
                    <s:select list="selRating"  name="searchCond.rating"></s:select>
                </td>

            </tr>


            <tr bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">
                    创建日期
                </td>
                <td width="200" align="left" valign="middle">
                    <input class="easyui-datebox" type="text" id="date1" style="width:90px" name="searchCond.date1" value="${searchCond.date1}"/>
                    -
                    <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="searchCond.date2" value="${searchCond.date2}"/>
                </td>

                <td align="center" valign="middle">
                    最后跟进日期	</td>

                <td width="200" align="left" valign="middle" style="white-space:nowrap">
                    <input class="easyui-datebox" type="text" id="followdate1" style="width:90px"  name="searchCond.followTime1" value="${searchCond.followTime1}"/>
                    -
                    <input class="easyui-datebox" type="text" id="followdate2" style="width:90px"  name="searchCond.followTime2" value="${searchCond.followTime2}"/>
                </td>

                <td align="center" valign="middle" style="white-space:nowrap">
                    来访日期
                </td>

                <td align="left" valign="middle">
                    <input class="easyui-datebox" type="text" id="visitDate1" style="width:90px"  name="searchCond.visitDate1" value="${searchCond.visitDate1}"/>
                    -
                    <input class="easyui-datebox" type="text" id="visitDate2" style="width:90px"  name="searchCond.visitDate2" value="${searchCond.visitDate2}"/>
                </td>

            </tr>
            
            <tr bgcolor="#FFFFFF">

                <td align="center" valign="middle" height="20">
                   居住区域
                </td>
                <td width="187" align="left" valign="middle">
                    <input style="width:50px" id="homeProvince" name="searchCond.homeProvince" value="${searchCond.homeProvinceStr}"/>(省)	
                    <input style="width:50px" id="homeCity" name="searchCond.homeCity" value="${searchCond.homeCityStr}"/>(市)	
                    <input style="width:50px" id="homeRegion" name="searchCond.homeRegion" value="${searchCond.homeRegionStr}"/>(区)
                    <input style="width:50px" id="homeContent" name="searchCond.homeContent" value="${searchCond.homeContent}"/>
                 </td>
                <td align="center" valign="middle">
                   工作区域	</td>

               <td width="187" align="left" valign="middle">
                   <input style="width:50px" id="workProvince" name="searchCond.workProvince" value="${searchCond.workProvinceStr}"/>(省)	
                   <input style="width:50px" id="workCity" name="searchCond.workCity" value="${searchCond.workCityStr}"/>(市)
                   <input style="width:50px" id="workRegion" name="searchCond.workRegion" value="${searchCond.workRegionStr}"/>(区)	
                   <input style="width:50px" id="workContent" name="searchCond.workContent" value="${searchCond.workContent}"/>	
               	</td>

                <td align="center" valign="middle" style="white-space:nowrap">
                   手机归属地
                </td>

               <td width="187" align="left" valign="middle">
                    <input id="phoneFrom" name="searchCond.phoneFrom" value="${searchCond.phoneFrom}"/>
               </td>

            </tr>

            <tr bgcolor="#FFFFFF">

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
                    <input type="text" id="saleName" value="${searchCond.saleName}" name="searchCond.saleName" title="按空格键可以查找前十条数据"/>
                    <input type="hidden" id="hiddenUserId" value="${searchCond.userId}" name="searchCond.userId" />

                </td>

                <td align="center" valign="middle">
                  	 是否作废客户
                </td>

                <td width="200" align="left" valign="middle" style="white-space:nowrap">
					<select name="searchCond.isDeleted">
						<s:if test="searchCond.isDeleted==0">
							<option value="0" selected="selected">否</option>
						</s:if>
						<s:else>
							<option value="0">否</option>
						</s:else>
						<s:if test="searchCond.isDeleted==1">
							<%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_RESUME, EnumDevFlag.GUANGZHOU)){%>
							<option value="1" selected="selected">是</option>
							<%} %>
						</s:if>
						<s:else>
							<%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_RESUME, EnumDevFlag.GUANGZHOU)){%>
							<option value="1">是</option>
							<%} %>
						</s:else>
							
					</select>
                </td>
				
                <td align="center" valign="middle" style="white-space:nowrap">
					 <a id="weekData" href="javascript:void(0)" style="color:#1199FF" target="_self" onclick="return false;">本周客户</a>
                    <a id="monthData" href="javascript:void(0)" style="color:#1199FF" target="_self" onclick="return false;">本月客户</a>
                    <input type="hidden" id="workOrMonth" name="workOrMonth" value="" />
                </td>
				
                <td align="left" valign="middle">
                	<input type="submit" value="  搜索  " id="searchSubmit" onclick="showLoad();return true;"/>
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
        <s:if test="searchCond.isDeleted==0||searchCond.isDeleted==null">
        <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__DELETE, EnumDevFlag.GUANGZHOU)){%>
        <input type="button" id="delete" value=" 作废 "
               onClick="return delCustomers('<%=basePath%>customer_guangzhou/delete/customers.action')"/>
        <%} %>

        <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__PROJECT, EnumDevFlag.GUANGZHOU)){%>
        <input type="button" id="copyCustomer" value=" 转移客户 " onclick="return copyCustomers()"/>
        <%} %>

            <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__CREATE, EnumDevFlag.GUANGZHOU)){%>
            <input title="(使用此功能可将选中的客户开放给其他销售人员进行查看及填写跟进)" type="button" id="onlyFollow" value=" 客源共享设置 " onclick="return onlyFollowCustomers()"/>
            <%} %>

        <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__DOWNLOAD, EnumDevFlag.GUANGZHOU)){%>
        <%if(SessionUser.getCompanyId()!=ContCompanyId.DONGGUAN
                || SessionUser.getUserId()== ContUserId.DG_SHENJINFENG
                || SessionUser.getUserId()== ContUserId.DG_LUOLILI
                ){%>
        <input type="button" id="downLoadId" value="  下载数据  " />
        <s:if test="searchCond.projectId!=null&&searchCond.projectId!=''">
            <s:select id="questionId" name="questionId" list="questionList" ></s:select>
        </s:if>
        (搜索单一所属项目可选择项目下对应的问卷下载，否则下载基本售前问卷)
        <%} %>
        <%} %>
		</s:if>
		<s:else>
			<input type="button" id="recover" value=" 恢复作废客户 "
               onClick="return recoverCustomers('<%=basePath%>customer_guangzhou/recover/customers.action')"/>
		</s:else>


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
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=14" onclick="showLoad();return true;">
                                        <img id="img14" src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>

                                <div style="height: 7px;padding-bottom: 2px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=13" onclick="showLoad();return true;">
                                        <img id="img13" src="images/blue/downn.gif" width="9" height="10" border="0" /></a></div>
                            </div>
                        </div>
                    </td>
                    <td>
                        <div style="float: left;width: 70px;">
                            <div style="float: left;width: 50px;padding-left: 5px">意向总价</div>
                            <div style="float: right;padding-right: 4px">
                                <div style="height: 7px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=18" onclick="showLoad();return true;">
                                        <img id="img18" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                                </div>
                                <div style="height: 7px;padding-bottom: 2px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=17" onclick="showLoad();return true;">
                                        <img id="img17" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td>
                        <div style="float: left;width: 70px;">
                            <div style="float: left;width: 50px;padding-left: 5px">意向面积</div>
                            <div style="float: right;padding-right: 4px">
                                <div style="height: 7px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=20" onclick="showLoad();return true;">
                                        <img id="img20" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                                </div>
                                <div style="height: 7px;padding-bottom: 2px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=19" onclick="showLoad();return true;">
                                        <img id="img19" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td width="80" align="center" valign="middle">
                        电话
                    </td>
                    <td align="center">
                        <div style="width: 70px;">
                            手机归属地
                        </div>
                    </td>

                    <td>
                        <div style="float: left;width: 70px;">
                            <div style="float: left;width: 50px;padding-left: 5px">创建日期</div>
                            <div style="float: right;padding-right: 4px">
                                <div style="height: 7px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=12" onclick="showLoad();return true;">
                                        <img id="img12" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                                </div>
                                <div style="height: 7px;padding-bottom: 2px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=11" onclick="showLoad();return true;">
                                        <img id="img11" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td>
                        <div style="float: left;width: 98px;">
                            <div style="float: left;width: 75px;padding-left: 5px">最后跟进日期</div>
                            <div style="float: right;padding-right: 4px">
                                <div style="height: 7px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=22" onclick="showLoad();return true;">
                                        <img id="img22" src="images/blue/upn.gif" width="9" height="10" border="0" /></a>
                                </div>
                                <div style="height: 7px;padding-bottom: 2px">
                                    <a href="./customer_guangzhou/search/searchOrderBy.action?ob=21" onclick="showLoad();return true;">
                                        <img id="img21" src="images/blue/downn.gif" width="9" height="10" border="0" /></a>
                                </div>
                            </div>
                        </div>
                    </td>

                    <td align="center" >
                        <div style="width: 65px;">
                            来访日期
                        </div>

                    </td>

                    <td  align="center" valign="middle">
                        <div style="width: 65px;">
                            所属销售
                        </div>
                    </td>

                    <td align="center" valign="middle">
                        <div style="width: 75px;">
                            未跟进天数
                        </div>
                    </td>


                    <td align="center" valign="middle">
                        <div style="width: 50px">
                            操作
                        </div>

                    </td>
                </tr>



                <s:iterator value="#request.cusList" id="c">
                    <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                        <td width="20" align="center" height="25"><input name="delId" type="checkbox" value="<s:property value='#c.id'/>" onClick="delId()" /></td>
                        <td align="center" valign="middle" class="fontblue">
                            <a href="#" onclick="showCustomer(<s:property value='#c.id'/>);return false;">
                                <s:property value="#c.customerName"/>
                            </a>
                            <a href="./customer_guangzhou/update/getById.action?id=<s:property value='#c.id'/>" target="_self" ></a>
                        </td>

                        <td align="center" valign="middle">
                            <s:property value="#c.priceNum"/>
                            万
                        </td>
                        <td align="center" valign="middle">
                            <s:property value="#c.areaNum"/>
                            ㎡
                        </td>

						<s:if test="#c.isCanShowCustomerPhone">
                        
                         <td align="center" valign="middle">
                                ${c.dbPhone}
                        </td>
                        <td align="center" valign="middle">
                                ${c.phoneFrom}
                        </td>
                        
                        </s:if>
                        
                        <s:else>

                            <td align="center" valign="middle">
                                ***
                            </td>
                            <td align="center" valign="middle">
                                ***
                            </td>
                        </s:else>
 
 						<!--
                        <s:if test="#request.isTel == true">
                        <td align="center" valign="middle">
                                ${c.dbPhone}
                        </td>
                        <td align="center" valign="middle">
                                ${c.phoneFrom}
                        </td>
                        </s:if>
                        
                        <s:else>

                        <s:if test="#c.createdId== #session.loginAccount.id">
                            <td align="center" valign="middle">
                                    ${c.dbPhone}
                            </td>
                            <td align="center" valign="middle">
                                    ${c.phoneFrom}
                            </td>
                        </s:if>
                        <s:else>

                            <td align="center" valign="middle">
                                ***
                            </td>
                            <td align="center" valign="middle">
                                ***
                            </td>
                        </s:else>
						
                        </s:else>
                        -->

                        <td align="center" valign="middle">
                            <s:date name="#c.createdTime" format="yyyy-MM-dd "/>
                        </td>
                        <!--
		<td align="center" valign="middle" class="fontblue">
			<a href="#" onclick="customerIndexFollow(<s:property value='#c.id'/>); return false;"><s:date name="#c.modTime" format="yyyy-MM-dd "/></a>
		</td>
		-->
                        <td align="center" valign="middle">
                            <s:date name="#c.followTime" format="yyyy-MM-dd "/>
                        </td>

                        <td align="center" valign="middle">
                                ${c.visitDate}
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

<!--
<div id='loading' style="position:absolute;z-index:100000;top:0px;left:0px;width:100%;height:100%; background-color:#eeeeee;text-align:center;padding-top: 20%; display:none">
	<h1><image src='images/loading.gif'/><font color="#15428B">加载中...</font></h1>
</div>
-->

</body>
</html>

