<%@ page language="java" pageEncoding="UTF-8"	isELIgnored="false"%>

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
    <title>结佣明细表</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript">
        $(document).ready(function(){
            //bindProjectDialogForXKZXOnly("projectName", "hiddenId"); //单个项目的选择
			
			bindProjectAreaBuildForXKZX("projectId", "areaId", "buildId"); //销控中心角色的项目,分区,楼栋级联
        });

        function submitSearch() {
            $("#thisForm").submit();
        }
    </script>
</head>
<body  style="padding:0;background:white;">

<div class="right99"></div>
<form class="registerform" id="thisForm"  method="post">
    <table width="100%" border="0" align="left" cellspacing="0">

        <tr>
            <td colspan="6">

                <span style="margin: 0 0 0 12px">
                    
					<input type="text" id="projectId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
					<input type="text" id="areaId" name="propertyUnitCond.buildPrice1" value="${propertyUnitCond.buildPrice1}" />
					<input type="text" id="buildId" name="propertyUnitCond.buildPrice2" value="${propertyUnitCond.buildPrice2}" />

					<!--
					
					<input type="text" id="projectName" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" />
                    <input type="hidden" id="hiddenId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />					
					
                    <select>
                       <option value="">选择区域</option>
                    </select>
                    <select>
                        <option value="">选择楼栋</option>
                    </select>
					-->

                    <input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1" value="${propertyUnitCond.date1}"/>-
                    <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2" value="${propertyUnitCond.date2}"/>

                </span>
                <input type="button" onclick="return submitSearch()" value=" 查询  " />


                <div class="right99"></div>
                <div class="blueline"></div>
            </td>
        </tr>


        <tr>
            <td colspan="6">

                <div class="gbox1">
                    <table width="100%" border="0" align="center" cellpadding="0"
                           cellspacing="1" class="gbox" style="text-align: center;">

                        <tr class="gboxbg">
                            <td rowspan="2">成交日期</td>
                            <td rowspan="2">单元号</td>
                            <td rowspan="2">客户姓名</td>
                            <td rowspan="2">面积</td>
                            <td rowspan="2">成交单价</td>
                            <td rowspan="2">成交金额</td>
                            <td colspan="3">溢价</td>
                            <td colspan="2">默认佣金</td>
                            <td colspan="2">跳点佣金</td>
                            <td colspan="2">挞定</td>
                        </tr>
                        <tr class="gboxbg">

                            <td>总价/平均单价</td>
                            <td>溢价</td>
                            <td>溢价佣金</td>
                            <td>点数</td>
                            <td>金额</td>
                            <td>点数</td>
                            <td>金额</td>
                            <td>点数</td>
                            <td>金额</td>
                        </tr>

                        <s:property value="showTrs"  escape="false"/>

                    </table>

                </div>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
