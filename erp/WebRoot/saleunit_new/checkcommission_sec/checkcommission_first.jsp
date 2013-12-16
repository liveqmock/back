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
    <title>新建预对佣表(一二手联动)</title>
    <s:include value="header.jsp"></s:include>
    <script type="text/javascript">

    $(document).ready(function(){

        //bindCompanyPropertyPorjectForXKZXOnly("projectId", "projectIds"); //单个项目的选择
        bindProjectTreeAreaBuildOnly("projectId", "areaId", "buildId");
        $('#tbList').datagrid({
            width:'auto',
            height: $(this).height()-130 ,
            /*fitColumns: true,*/
            /*fix:true,*/
            loadMsg:'数据加载中...',
            url:'',
            columns:[[
                {field:'ck',checkbox:true},
                {field:'unit_id',title:'单元ID',hidden:true},
                {field:'checkfeeid',title:'对数表ID',hidden:true},
                {field:'checkfeeTypeName',title:'状态',width:50,align:"center"},
                {field:'checkfee_date',title:'对数日期',width:70,align:"center"},
                {field:'work_date',title:'成交日期',width:70,align:"center",sortable:true},
                {field:'sign_date',title:'签约日期',width:70,align:"center",sortable:true},
                {field:'area_name',title:'分区',width:50},
                {field:'build_name',title:'楼栋',width:50},
                {field:'unit_no',title:'单元号',width:50,sortable:true},
                {field:'customer_name',title:'业主姓名',width:100,sortable:true},
                {field:'build_area',title:'建筑面积(㎡)',width:50,sortable:true,align:"right"},
                {field:'sum_price',title:'成交总价(元)',width:80,sortable:true,align:"right",formatter:formatPrice},
                {field:'contract_no',title:'合同号',width:50},
                {field:'pay_name',title:'付款方式',width:50},

                /*{field:'commission',title:'佣金点(%)',width:60,align:"center",formatter:formatNum},
                {field:'commissionAmount',title:'应收佣金(元)',width:60,align:"center",hidden:false,formatter:formatPrice},*/
                {field:'sec_commission',title:'一二手佣金点(%)',width:60,align:"center",formatter:formatNum},
                {field:'sec_commissionAmount',title:'一二手应收佣金(元)',width:60,align:"center",hidden:false,formatter:formatPrice},
                /*{field:'rel_commission',title:'关系户佣金点(%)',width:60,align:"center",formatter:formatNum},
                {field:'rel_commissionAmount',title:'关系户应收佣金(元)',width:60,align:"center",hidden:false,formatter:formatPrice},*/

                /*{field:'repayMoney',title:'回款金额(元)',width:60,align:"right",formatter:formatPrice},
                {field:'repayAmount',title:'合计回款金额(元)',width:60,align:"right",formatter:formatPrice},
                {field:'receiptId',title:'实收款ID',width:50,hidden:true},*/

                {field:'sales',title:'销售人员'}

            ]],
            toolbar: '#tb',
            showFooter: true,
            singleSelect:false
        });

        //选择回款
        $("#btn_add").attr("disabled","true");
        $("#btn_view").attr("disabled","true");
        $("#btn_search").attr("disabled","true");

        $('#checkCommissionDate').datebox({
            onSelect: function (date) {
                chgBtn();
            }
        });


        $("#checkFeeDate").combobox({
            valueField:'id',
            textField:'text',
            editable:false,
            url:'./saleunit_new/checkfee/getCheckFeeDateListForCombotree.action',
            onLoadSuccess:function(node, data){

                var module = $("#checkFeeDate").combotree('textbox');
                $(module).bind('focus', function(){
                    $("#checkFeeDate").combotree('showPanel');
                });
            }
        });

        $("#projectId").combotree({
            onChange:function(newValue, oldValue){

                    getCheckFeeDate(newValue);
            }

        });

    });

    function formatNum(val,row){
        if(val==null || val=="0" || val.length==0) return "-";
        return val;
    }

    function formatPrice(val,row){
        if(val==null || val=="0" || val.length==0) return "-";
        return commafy(val);
    }
    //disabled按钮
    function chgBtn(){
        //全额
        $("#span_saleStateDate").show();
        $("#span_receiptDate").hide();
        $("#tip").hide();
        $("#btn_add").removeAttr("disabled");
        $("#btn_view").removeAttr("disabled");
        $("#btn_search").removeAttr("disabled");
    }

    function submitSearch() {
        var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();

        if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
            myAlert("请选择项目。");
            return;
        }
        var url = './saleunit_new/checkcommission_sec/checkfeelist_confirm.action';


        $('#tbList').datagrid({

            loadMsg:'数据加载中...',
            url:url,
            queryParams:{
                projectIds:projectIds,
                areaId:$("input[name='propertyUnitCond.areaId']").val() ,
                buildId:$("input[name='propertyUnitCond.buildId']").val(),
                repayType:$('#repayType').val(),
                checkFeeDate:$('#checkFeeDate').datebox('getValue'),
                signDate:$('#date1').datebox('getValue'),
                signDateEnd:$('#date2').datebox('getValue'),
                receiptDate:$('#receiptDateStart').datebox('getValue'),
                receiptDateEnd:$('#receiptDateEnd').datebox('getValue'),
                checkFeeType:$('#checkFeeType').val()
            }

        });
    }

    //加入对佣表
    function add(){

        //只有选择的是已对数的才能加入对佣表
        var type = $("#checkFeeType").val();
        if(type != "2"){
            myAlert("只有已对数的单元才能加入对佣表");
            return;
        }

        var checkCommissionDate = $("#checkCommissionDate").datebox("getValue");
        if(checkCommissionDate==null || checkCommissionDate.length==0){
            myAlert("对佣日期不能为空。");
            return;
        }

        ajaxModifyMethod("add_checkcommission", checkCommissionDate);
    }

    function del(){

        ajaxModifyMethod("del_checkcommission", "");
    }


    function getSelections(colname){
        var ids = [];
        var rows = $('#tbList').datagrid('getSelections');

        $.each(rows, function (i, obj) {
            $.each(obj, function (name, val) {
                if(name==colname){
                    ids.push(val);
                }
            });
        });
        return ids;
    }


    //共用的ajax action方法
    function ajaxModifyMethod(action, checkCommissionDate){
        var repayMoney = getSelections("repayMoney");
        var repayAmount = getSelections("repayAmount");
        var receiptId = getSelections("receiptId");
        var checkfeeId = getSelections("checkfeeid");

        var commission = getSelections("commission");
        var commissionAmount = getSelections("commissionAmount");
        var sec_commission = getSelections("sec_commission");
        var sec_commissionAmount = getSelections("sec_commissionAmount");
        var rel_commission = getSelections("rel_commission");
        var rel_commissionAmount = getSelections("rel_commissionAmount");

        var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();

        var ids = getSelections("unit_id");
        if(ids.length <= 0 || ids.join(",") == ""){
            myAlert("请先选择要操作的单元");
            return ;
        }


        $.ajax({
            type: 'get',
            url: './saleunit_new/checkcommission_sec/' + action + '.action',
            data: "ids=" + ids.join(",") + "&checkCommissionDate=" + checkCommissionDate
                    + "&receiptId=" + receiptId+"&repayMoney="+ repayMoney
                    + "&repayAmount=" + repayAmount + "&repayType=" + $("#repayType").val()
                    + "&projectIds=" + projectIds + "&checkfeeid=" + checkfeeId
                    + "&commission=" + commission + "&commissionAmount="+commissionAmount
                    + "&sec_commission=" + sec_commission + "&sec_commissionAmount="+sec_commissionAmount
                    + "&rel_commission=" + rel_commission + "&rel_commissionAmount="+rel_commissionAmount,
            dataType: "json",
            beforeSend:function(){
                moduleMaskByModule($("body"));
            },
            success: function(data){

                if(data.type == "true"){

                    //myAlert("操作成功");
                    moduleMaskRemove();
                    submitSearch();
                }else{

                    myAlert("操作失败,请重试");
                    moduleMaskRemove();
                }

            },
            error: function(XMLHttpRequest, textStatus, errorThrown){

                myAlert("请求异常,请重试");
                moduleMaskRemove();
            }
        });

    }

    function clearSelections(){
        $('#tbList').datagrid('clearSelections');
    }

    function doView(){
        var checkCommissionDate = $("#checkCommissionDate").datebox("getValue");
        var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();

        if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
            myAlert("请选择项目。");
            return;
        }

        if(checkCommissionDate==null || checkCommissionDate.length==0){
            myAlert("对佣日期不能为空。");
            return;
        }

        new MyIframeDialog({title:'查看对佣表', width:800,height:550,buttons:false,
            src:'./saleunit_new/checkcommission_sec/checkcommission_view_init.action?projectIds='+projectIds
                    //+'&areaId=' + $("input[name='propertyUnitCond.areaId']").val()
                    //+'&buildId=' + $("input[name='propertyUnitCond.buildId']").val()
                    +'&checkCommissionDate=' + $('#checkCommissionDate').datebox('getValue')
                    +'&checkCommissionType=1'
                    +'&repayType=' + $("#repayType").val()

        });
    }



    /**
     * 获取对数日期下拉列表
     * @param projectId
     */
     function getCheckFeeDate(projectId){
     	if(!isNaN(projectId)) {
         $("#checkFeeDate").combobox("clear");

			$("#checkFeeDate").combobox(
                 "reload",
                 "./saleunit_new/checkfee/getCheckFeeDateListForCombotree.action?propertyId=" + projectId+"&checkFeeType="+$("#checkFeeType").val()
         	);
     	}
     }

    /**
     *刷新对数日期
     */
    function reloadCheckFeeDate(){
        var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
        if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
            myAlert("请选择项目。");
            return;
        }
        getCheckFeeDate(projectIds);
    }
    </script>
</head>
<body  style="padding:0;background:white;">


<div id="toolbar" style="height: auto;padding: 5px">
    <form class="registerform" id="thisForm" name="thisForm"  method="post">
        <table width="100%" border="0" align="left" cellspacing="0">

            <tr>
                <td>

                    <span style="margin: 0 0 0 12px">
                        <span style="color: red">*</span>选择对佣日期:
                        <input class="easyui-datebox" type="text" id="checkCommissionDate" style="width:90px"/>
                        <input id="repayType" type="hidden" value="1">

                        <span id="tip" style="color: red">（请先选择对数日期）</span>
                    </span>

                    <br><br>

                    <fieldset  style="border:1px solid #989898;" id="fieldset_search">
                        <legend>筛选条件</legend>

                        选择项目:
                        <input type="text" id="projectId" name="propertyUnitCond.strSearchProjectIds" />
                        对数日期:
                        <input id="checkFeeDate"/>
                        <img src="./ui/js/themes/icons/reload.png" alt="刷新对数日期" title="刷新对数日期" onclick="return reloadCheckFeeDate()" align="middle" style="padding-bottom:10px;cursor: pointer;">

                        <br>

                        <span id="span_saleStateDate">
                            签约日期:
                            <input class="easyui-datebox" type="text" id="date1" style="width:90px" name="propertyUnitCond.date1"/>
                            -
                            <input class="easyui-datebox" type="text" id="date2" style="width:90px" name="propertyUnitCond.date2"/>
                        </span>

                        <span id="span_receiptDate" style="display: none;">
                            回款日期:
                            <input class="easyui-datebox" type="text" id="receiptDateStart" style="width:90px" name="receiptDateStart" />
                            -
                            <input class="easyui-datebox" type="text" id="receiptDateEnd" style="width:90px" name="receiptDateEnd" />
                        </span>

                        <input type="hidden" id="checkFeeType" value="2" alt="已对数">

                        <input id="btn_search" type="button" onclick="return submitSearch()" value=" 筛选 " />

                    </fieldset>

                </td>
            </tr>
        </table>
    </form>
</div>


<div id="tb">
    <input id="btn_add" type="button" onclick="return add()" value="加入对佣表" />

    <input id="btn_view" type="button" onclick="return doView()" value="查看对佣表" />
</div>

<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;" id="div_tbList">
    <table id="tbList"></table>
</div>

</body>
</html>
