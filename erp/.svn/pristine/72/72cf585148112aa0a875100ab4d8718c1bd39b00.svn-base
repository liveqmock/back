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


    <style type="text/css">
        *{margin:0;padding:0;}
    </style>

    <script type="text/javascript">

        function getQuestionId(){
            $("#ques_table").load('./customer_guangzhou/input/findQuestionTable.action',{questId:$("#questionList").val()});
            if( $("#questionList").val()== 0 ){

                $("#changeTable").toggle(true);
            }else{
                $("#changeTable").toggle(false);
            }
        }

        $().ready(function(){
            $("#changeTable").load('./customer_guangzhou/input/getBaseQuestion.action',{proId:$("#hiddenId").val()});
            if($("#hiddenId").val() != 0){
                $.ajax({
                    url:'./customer_guangzhou/input/pickQuestionList.action?proId='+$("#hiddenId").val(),
                    success:function(data){
                        $("#questionList").empty();
                        $("#questionList").append(data);
                        if(data != ""){
                            $("#ques_table").load('./customer_guangzhou/input/findQuestionTable.action',{questId:$("#questionList").val()});
                            if( $("#questionList").val()== 0 ){
                                $("#changeTable").toggle(true);
                            }else{
                                $("#changeTable").toggle(false);
                            }
                        }
                    }
                });


            }


            var old_pro_id = "0";
            $("input[name!=projectName]").click(function(){
            	if($("#selCustomerSource").val()=="" || $("#selCustomerSource").val() == null){
            		myAlert("请先选择客户来源");
            	}
            });
            
            $("select[name!='customer.customerSource']").click(function(){
            	if($("#selCustomerSource").val()=="" || $("#selCustomerSource").val() == null){
            		myAlert("请先选择客户来源");
            	}
            });
            
            
            
            $("#projectName").blur(function(){
                var pro_aja_id = $("#hiddenId").val();
                var projectName = $("#projectName").val();
                $.ajax({
        			url:"./customer_guangzhou/search/searchProjectByExactName.action?projectName="+projectName,
        			dataType:"json",
        			success:function(data){
        				//data为null时，是选择了下拉框的值或者输入的值没有精确匹配的项目
        				if(data!=null){
        					$("#hiddenId").val(data.hiddenId);
            				$("#hiddenCompanyId").val(data.hiddenCompanyId);
							$("#suggestion").attr("hidden","hidden");
							$("#tip").attr("hidden","hidden");
        				}else{
        					$("#hiddenId").val("0");
                            $(".red").remove();
                            $("#questionList").empty();
                            $("#suggestion").removeAttr("hidden");
                            $("#tip").removeAttr("hidden");
        				}
                        $("#showProject").html("<font color=\"red\">" + projectName + "</red>");
                        //val_jsp_and_proid(pro_aja_id); // 2012-11-05已经废弃自定义
                        if(pro_aja_id !=  old_pro_id){
                        	//data为null时，是选择了下拉框的值或者输入的值没有精确匹配的项目,若精确匹配，则取匹配的projectId，若没有精确匹配，则取隐藏域hiddenId中的值
                        	if(data!=null){
                        		$("#changeTable").load('./customer_guangzhou/input/getBaseQuestion.action',{proId:data.hiddenId});
                        	}else{
                        		$("#changeTable").load('./customer_guangzhou/input/getBaseQuestion.action',{proId:$("#hiddenId").val()});
                        	}
                            $.ajax({
                                url:'./customer_guangzhou/input/pickQuestionList.action?proId='+$("#hiddenId").val(),
                                success:function(data){
                                    $("#questionList").empty();
                                    $("#questionList").append(data);
                                    if(data != ""){
                                        $("#ques_table").load('./customer_guangzhou/input/findQuestionTable.action',{questId:$("#questionList").val()});
                                        //$("#questionList").val()==0 为基本问卷
                                        if( $("#questionList").val()== 0 ){
                                            $("#changeTable").toggle(true);
                                        }else{
                                            $("#changeTable").toggle(false);
                                        }
                                    }
                                }
                            });


                            old_pro_id = pro_aja_id;
                        }
        			}
        		})
                



            });

            function val_jsp_and_proid(proid){//本身就是 input2 jsp
                $.post('./customer_guangzhou/input/changeProject.action',{'changeProjectId':proid},function(date){
                    if(date == 'input2'){
                        location=location;
                    }
                })
            }
        })

        function noSpace(){
            var str  = $(this).val();
            alert(str)
            $(this).val(str.replace(/\s+/g,""));
        }
    </script>
    <style type="text/css">
        .topinfo{
            background-color: #eeeeee;height: 18px;padding: 2px;
            border-right: 1px #A9D9FF solid;
            border-top: 1px #A9D9FF solid;
            border-left: 1px #A9D9FF solid;
        }
        td{height: 25px;}
    </style>
</head>

<body onload="clearSuggestion()">

<%--主体 --%>
<div class="right99"></div>

<%--主体table top --%>


<div>
    &nbsp;&nbsp;
    <font color="#FF0000"><span id="suggestion"><s:property value="#request.session.suggestion"/></span></font>
</div>

<form id="thisform" class="registerform" action="./customer_guangzhou/input/addCustomerAndQuestion.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" method="post" >
    <div style="margin: 5px">
        <div class="topinfo">&nbsp;&nbsp;必填</div>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="white-space: nowrap;background-color: #A9D9FF">
            <tr   bgcolor="#FFFFFF"
                  style="empty-cells:show">
                <td style="width:15%"  align="right"><font color="red">*</font>项目&nbsp;</td>
                <td>
                    <input type="text" id="projectName" name="projectName" value="<s:property value='#request.project.projectName'/>"/>
                    <input type="hidden" id="hiddenId" name="customer.projectId" value="<s:property value='#request.project.id'/>"/>
                    <input type="hidden" id="hiddenCompanyId" value="<s:property value='#request.project.companyId'/>"/>
                </td>
                <td align="right"><font color="red">*</font>客户来源&nbsp;</td>
                <td>
                    <s:select id="selCustomerSource" list="selCustomerSource"  name="customer.customerSource" />
                </td>
                <td colspan="1"> <div><font color="red">请首先确定项目和客户来源</font></div></td>
                <td></td>
            </tr>
            <tr   bgcolor="#FFFFFF"
                  style="empty-cells:show">
                <td style="width:15%"  align="right"><font color="red">*</font>客户姓名&nbsp;</td>
                <td>
                    <input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="10" value="${customerName}" />
                </td>
                <td style="width:15%"  align="right"><font color="red">*</font>客户评级&nbsp;</td>
                <td style="width:18%">
                    <s:select list="selRating"  name="customer.rating"/>
                </td>
                <td style="width:15%"  align="right">来访日期</td>
                <td>
                    <input class="easyui-datebox" type="text" id="visitDate" style="width:90px" name="customer.visitDate" onfocus="javascript:blur()" value="${nowDate}"/>
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
                
                <td align="right"><font color="red">*</font>意向面积&nbsp;</td>
                <td>
                    <input type="text" name="customer.areaNum" id="areaNum" style="width:40px" maxlength="11" class="easyui-numberbox"/>
                    <span id="areaNumUnit">㎡</span>
                </td>
                <td align="right"></td>
                <td>
                   
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
                    <span id="showProject"></span>
                </td>

                <td style="width:15%" align="right"></td>
                <td></td>

            </tr>


        </table>
    </div>

    &nbsp;<font color="red">请选择售前问卷：</font>
    <select id="questionList" onchange="getQuestionId();"></select>


    <div style="margin:5px 5px 0 5px">
        <div id="" class="topinfo">&nbsp;&nbsp;自定义内容</div>

        <div id="ques_table"></div>

    </div>

    <div style="margin: 0 5px 0 5px">
        <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap;;"id="changeTable">
        </table>
    </div>

    <div style="margin: 5px">
        <table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" style="white-space: nowrap">
            <tr  bgcolor="#FFFFFF" align="center">
                <td >

                    <s:token />
                    <input type="button" onclick="return validateCustForm();" value="  保存  " id="sub"/>
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
