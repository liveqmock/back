<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
    .rmb_format{text-align: right}
    .isVoid1{text-decoration:line-through}
    .isVoid0{}
    .exChangetd{background-color:#EEAD0E}
</style>

<script type="text/javascript" language="javascript">

    $("#contractManagerTableId tr").bind('click', function(){
        var contractManagerId = $(this).attr("contractManagerId");

        if(contractManagerId == '0' || contractManagerId == undefined || contractManagerId == ""){

            return false;
        }else{

            $(".exChangetd").removeClass("exChangetd");
            $(this).addClass("exChangetd");
        }

    });

</script>

<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox unit_table" width="100%" id="contractManagerTableId">

    <tr style="line-height: 20px;background:#E9F5FF; text-align:left" >
        <td colspan="11" style="margin-left:15px">

            <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0 40px" onclick="addAjaxContractManager()">新增</a>
            <!--
            <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0 0px" onclick="addContractManager()">新增</a>
            <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="showContractManager()">查看</a>
            <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="updateContractManager()">修改</a>
            -->
            <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="modifyContractManager()">查看/编辑</a>
            <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="copyContractManager()">复制</a>
            <a href="javascript:void(0)" style="color:#1199FF; text-decoration:underline;padding: 0 20px 0px" onclick="cancelManager()">作废</a>
        </td>
    </tr>

    <tr  style="line-height: 20px;background:#E9F5FF" >
        <th width="100" align="center">合同编号</th>
        <th width="100" align="center">所属项目</th>

        <th width="100" align="center">合同名称</th>
        <th width="150" align="center">合同有效期</th>
        <th width="80" align="center">开售日期</th>



        <th width="100" align="center">发展商名称</th>
        <th width="60" align="center">状态</th>
    </tr>


    <s:iterator value="managerList" var="c">
        <tr bgcolor="#FFFFFF" style="line-height: 20px;" contractManagerId="${c.id}" status="${c.status}" class="isVoid${c.status}">

            <td width="100" align="center" >${c.contractNo} </td>
            <td width="100" align="center">
                    ${c.showName}
            </td>

            <td width="100" align="center">
                    ${c.managerName}
            </td>

            <td width="150" align="center">
                <s:date name="#request.c.startDate" format="yyyy-MM-dd"/>
                -
                <s:date name="#request.c.endDate" format="yyyy-MM-dd"/>
            </td>

            <td width="80" align="center" ><s:date name="#request.c.saleDate" format="yyyy-MM-dd"/></td>


            <td width="100" align="center">
                    ${c.developerName}
            </td>
            <td width="60" align="center">
                    ${c.statusStr}
            </td>

        </tr>
    </s:iterator>

</table>
   