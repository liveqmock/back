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
    <title>查询对佣表</title>
    <s:include value="header.jsp"></s:include>
    <script type="text/javascript">

        $(document).ready(function(){
            //bindCompanyPropertyPorjectForXKZXOnly("projectId", "projectIds"); //单个项目的选择
            bindProjectTreeAreaBuildOnly("projectId", "areaId", "buildId");
            $('#tbList').datagrid({
                width:'auto',
                height: $(this).height()-42,
                fitColumns: true,

                loadMsg:'数据加载中...',
                url:'',
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'unit_id',title:'单元ID',hidden:true},
                    {field:'checkfeeid',title:'对数表ID',hidden:true},
                    {field:'checkcommissionTypeName',title:'状态',align:"center",width:$(this).width() * 0.2},
                    {field:'checkcommission_date',title:'对佣日期',align:"center",width:$(this).width() * 0.2},
                    /*{field:'checkfee_date',title:'对数日期',width:70,align:"center"},*/
                    {field:'work_date',title:'成交日期',align:"center",width:$(this).width() * 0.2},
                    {field:'sign_date',title:'签约日期',align:"center",width:$(this).width() * 0.2},
                    {field:'area_name',title:'分区',width:$(this).width() * 0.2},
                    {field:'build_name',title:'楼栋',width:$(this).width() * 0.2},
                    {field:'unit_no',title:'单元号',width:$(this).width() * 0.2},
                    {field:'customer_name',title:'业主姓名',sortable:true,width:$(this).width() * 0.2},
                    {field:'build_area',title:'建筑面积(㎡)',sortable:true,align:"right",width:$(this).width() * 0.2},
                    {field:'sum_price',title:'成交总价(元)',sortable:true,align:"right",formatter:formatPrice,width:$(this).width() * 0.2},
                    {field:'contract_no',title:'合同号',width:$(this).width() * 0.2},
                    {field:'pay_name',title:'付款方式',width:$(this).width() * 0.2},

                    /*{field:'commission',title:'佣金点(%)',width:60,align:"center",formatter:formatPrice},
                    {field:'commissionAmount',title:'应收佣金(元)',width:60,align:"center",hidden:false,formatter:formatPrice},*/
                    {field:'sec_commission',title:'一二手佣金点(%)',align:"center",formatter:formatPrice,width:$(this).width() * 0.2},
                    {field:'sec_commissionAmount',title:'一二手应收佣金(元)',align:"center",hidden:false,formatter:formatPrice,width:$(this).width() * 0.2},
                    /*{field:'rel_commission',title:'关系户佣金点(%)',width:60,align:"center",formatter:formatPrice},
                    {field:'rel_commissionAmount',title:'关系户应收佣金(元)',width:60,align:"center",hidden:false,formatter:formatPrice},*/

                    /*{field:'repayMoney',title:'回款金额(元)',width:50,align:"right",formatter:formatPrice},
                    {field:'repayAmount',title:'合计回款金额(元)',width:50,align:"right",formatter:formatPrice},
                    {field:'receiptId',title:'实收款ID',width:50,hidden:true},*/

                    {field:'sales',title:'销售人员',width:$(this).width() * 0.2}

                ]],
                toolbar: '#tb',
                showFooter: true,
                singleSelect:false
            });
            function formatPrice(val,row){
                if(val==null || val=="0") return "";
                return commafy(val);
            }
                        
            $("#projectId").combotree({
                onChange:function(newValue, oldValue){
                	
                	getCheckCommissionDate(newValue);
                	/**
                    if(newValue==null || newValue.length==0|| newValue.indexOf(",")>=0) {

                    } else {
                        getCheckCommissionDate(newValue);
                    }
                    $("#projectIds").val(newValue);
                    */
                }

            });			
			
			$("#checkCommissionDate").combobox({
				valueField:'id',
				textField:'text',
				editable:false,
				url:'./saleunit_new/checkcommission_sec/getDateListForCombotree.action',
				onLoadSuccess:function(node, data){
					
					var module = $("#checkCommissionDate").combotree('textbox');
					$(module).bind('focus', function(){
						$("#checkCommissionDate").combotree('showPanel');
					});			
				}
            });

            $("#checkCommissionType").combobox({
                onSelect:function(rec){
                    reloadCheckCommissionDate();
                }
            });
        });


        function modCheckFee() {
			var checkCommissionDate = $("#checkCommissionDate").combobox("getValue");
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var checkCommissionType = $("#checkCommissionType").combobox("getValue");
            var checkIds = getCheckfeeId();
            if(projectIds==null || projectIds.length==0 || projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }



            $('#tbList').datagrid({
                loadMsg:'数据加载中...',
                url:'./saleunit_new/checkcommission_sec/checkmod_view.action',
                queryParams:{
                    projectIds:projectIds,
                    checkCommissionDate:checkCommissionDate,
                    checkCommissionType:checkCommissionType,
                    checkIds:checkIds
                }

            });
        }

		
        /**
         * 导出对佣表
         */
        function exportExcel(){
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var checkCommissionDate = $("#checkCommissionDate").combobox("getValue");

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }

            if(checkCommissionDate==null || checkCommissionDate.length==0){
                myAlert("对数日期不能为空。");
                return;
            }

            location.href = './saleunit_new/checkcommission_sec/exportExcel_Mod.action?projectIds='+projectIds +"&checkCommissionDate="+checkCommissionDate+"&checkCommissionType="+$("#checkCommissionType").combobox("getValue");
        }

        function getSelections(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].unit_id);
            }

			return ids;
        }
        function getReceiptId(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].receiptId);
            }

            return ids;
        }
        function getCheckCommissionId(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].checkcommissionId);
            }

            return ids;
        }
        function getCheckCommissionDates(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].checkcommission_date);
            }

            return ids;
        }
        function getCheckfeeId(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].checkfeeid);
            }

            return ids;
        }
        function clearSelections(){
            $('#tbList').datagrid('clearSelections');
        }


        /**
         * 获取对佣日期下拉列表
         * @param projectId
         */
        function getCheckCommissionDate(projectId){
        	
        	if(!isNaN(projectId)) {
        		
        		$("#checkCommissionDate").combobox("clear");

    			$("#checkCommissionDate").combobox(
                        "reload",
                        "./saleunit_new/checkcommission_sec/getDateListForCombotree.action?propertyId=" + projectId +"&checkCommissionType="+$("#checkCommissionType").combobox("getValue")
                );
        	}
            
        }
        /**
         *刷新对数日期
         */
        function reloadCheckCommissionDate(){
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }
            getCheckCommissionDate(projectIds);
        }

        $(".datagrid-cell").live('contextmenu',function(e){
            //显示快捷菜单
            $('#mm').menu('show', {
                left: e.pageX,
                top: e.pageY
            });

            return false;
        });


        //添加右击菜单内容
        function onRowContextMenu(e, rowIndex, rowData){
            e.preventDefault();

            var selected=$("#test").datagrid('getRows'); //获取所有行集合对象
            var idValue = selected[rowIndex].id;
            $(this).datagrid('selectRecord', idValue);  //通过获取到的id的值做参数选中一行

            $('#mm').menu('show', {
                left:e.pageX,
                top:e.pageY
            });
        }

        function doResume(){
            var selected = $('#tbList').datagrid('getSelected');
            var checkCommissionDate = getCheckCommissionDates();
            if(selected){
                ajaxModifyMethod("resume_checkcommission", checkCommissionDate);
            } else {
            	myAlert("请选择要操作的数据");
            }
        }

        //共用的ajax action方法
        function ajaxModifyMethod(action, checkCommissionDate){
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var receiptId = getReceiptId();
            var checkCommissionIds = getCheckCommissionId();
            var checkIds = getCheckfeeId();
            var ids = getSelections();
            if(ids.length <= 0 || ids.join(",") == ""){
                myAlert("请先选择要操作的单元");
                return ;
            }

            $.ajax({
                type: 'get',
                url: './saleunit_new/checkcommission_sec/' + action + '.action',
                data: "ids=" + ids.join(",") + "&checkCommissionDate=" + checkCommissionDate + "&receiptId=" + receiptId
                        + "&projectIds=" + projectIds + "&checkCommissionIds=" + checkCommissionIds
                        + "&checkIds=" + checkIds,
                dataType: "json",
                beforeSend:function(){
                    moduleMaskByModule($("body"));
                },
                success: function(data){

                    if(data.type == "true"){

                        moduleMaskRemove();
                        modCheckFee();
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
    </script>
</head>
<body  style="padding:0;background:white;">


<div id="toolbar" style="height: auto;padding: 5px">
    <form class="registerform" id="thisForm" name="thisForm"  method="post">
        <table width="100%" border="0" align="left" cellspacing="0">

            <tr>
                <td>

                    <span style="margin: 0 0 0 12px">

                        选择项目:
                        <input type="text" id="projectId" name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
                        对佣状态:
                        <s:select list="checkFeeCommissionMap" id="checkCommissionType" name="checkCommissionType"  cssStyle="width: 100px"></s:select>
                        对佣日期:
                        <input id="checkCommissionDate"/>
                        <img src="./ui/js/themes/icons/reload.png" alt="刷新对佣日期" title="刷新对佣日期" onclick="return reloadCheckCommissionDate()" align="middle" style="padding-bottom:10px;cursor: pointer;">

                        <input type="button" onclick="return modCheckFee()" value="查看" />
                        <input type="button" onclick="return exportExcel()" value="导出" />

                    </span>

                </td>
            </tr>
        </table>
    </form>
</div>

<div id="tb">
    <input type="button" onclick="return doResume()" value="恢复可对佣" />
</div>

<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;">
    <table id="tbList"></table>
</div>

<div id="mm" class="easyui-menu" style="width:100px;">
    <div iconCls="icon-edit" onclick="doResume()">恢复可对佣</div>
</div>
</body>
</html>
