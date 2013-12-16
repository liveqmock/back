<%@ page contentType="text/html; charset=utf-8" %>

<div class="gbox1">

    <form action="./saleunit_contract/manager/addOtherExpenses.action" method="post" id="addOtherFormId">

        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">

            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                 style="empty-cells:show">
                <td style="width:15%" align="right">项目名称&nbsp;</td>
                <td style="width:25%" colspan="3">
                    ${project.propertyName}
                    <input type="hidden" name="other.projectId" value="${project.id}" />
                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                 style="empty-cells:show">
                <td style="width:15%" align="right"><font color="red">*</font>费用名称&nbsp;</td>
                <td style="width:25%">
                    <input type="text" id="expensesName" name="other.expensesName"/>
                </td>
                <td style="width:15%" align="right"><font color="red">*</font>录入日期&nbsp;</td>
                <td style="width:25%">
                    <input class="easyui-datebox" id="enterTime" name="other.enterTime" style="width:90px" value="${nowDate}"/>
                </td>
            </tr>

            <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                 style="empty-cells:show">
                <td style="width:15%" align="right"><font color="red">*</font>金额&nbsp;</td>
                <td style="width:25%">
                    <input type="text" id="expensesMoney" name="other.expensesMoney"/>
                </td>
                <td style="width:15%" align="right">录入人员&nbsp;</td>
                <td style="width:25%">
                    ${LOGIN_SESSION.realName}
                    <input type="hidden" id="enterId" name="other.enterId" value="${LOGIN_SESSION.id}"/>
                </td>
            </tr>

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
                 style="empty-cells:show">
                <td style="width:15%" align="right">备注&nbsp;</td>
                <td style="width:25%" colspan="3">
                    <!--
                    <input type="text" style="width:80%" id="remark" name="other.remark"/>
                    -->
                    <textarea id="remark" name="other.remark" style="font-size:12px; height:100px; width:85%"></textarea>
                </td>
            </tr>

        </table>
    </form>

</div>

