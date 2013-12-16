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
    <title>修改对佣表</title>
    <s:include value="header.jsp"></s:include>
    <script type="text/javascript">
        var editIndex = undefined;
        var cmenu;
        $(document).ready(function(){
            //bindCompanyPropertyPorjectForXKZXOnly("projectId", "projectIds"); //单个项目的选择
            bindProjectTreeAreaBuildOnly("projectId", "areaId", "buildId");
            $('#tbList').datagrid({
                width:'auto',
                height: $(this).height()-50,
                /*fitColumns: true,*/
                /*fix:true,*/
                loadMsg:'数据加载中...',
                url:'',
                columns:[[
                    {field:'ck',title:"选项",checkbox:true,hidden:false},
                    {field:'unit_id',title:'单元ID',hidden:true},
                    {field:'checkfeeid',title:'checkfeeid',hidden:true},
                    {field:'checkcommissionId',title:'checkcommissionId',hidden:true},
                    {field:'checkcommissionTypeName',title:'状态',width:50,align:"center",hidden:false},
                    {field:'checkcommission_date',title:'对佣日期',width:70,align:"center",hidden:false},
                    {field:'work_date',title:'成交日期',width:70,align:"center",hidden:false},
                    {field:'sign_date',title:'签约日期',width:70,align:"center",hidden:false},
                    {field:'area_name',title:'分区',width:50,hidden:false},
                    {field:'build_name',title:'楼栋',width:50,hidden:false},
                    {field:'unit_no',title:'单元号',width:50,hidden:false},
                    {field:'customer_name',title:'业主姓名',width:100,sortable:true,hidden:false},
                    {field:'build_area',title:'建筑面积(㎡)',width:50,sortable:true,align:"right",hidden:false},
                    {field:'sum_price',title:'成交总价(元)',width:80,sortable:true,align:"right",hidden:false,formatter:formatPrice},
                    {field:'contract_no',title:'合同号',width:50,hidden:false},
                    {field:'pay_name',title:'付款方式',width:50,hidden:false},

                    {field:'commission',title:'佣金点(%)',width:60,align:"center",editor:'text',formatter:formatPrice},
                    {field:'commissionAmount',title:'应收佣金(元)',width:60,align:"center",hidden:false,editor:'text',formatter:formatPrice},
                    /*{field:'sec_commission',title:'一二手佣金点(%)',width:60,align:"center",editor:'text',formatter:formatPrice},
                    {field:'sec_commissionAmount',title:'一二手应收佣金(元)',width:60,align:"center",hidden:false,formatter:formatPrice,editor:'text'},*/
                    {field:'rel_commission',title:'关系户佣金点(%)',width:60,align:"center",editor:'text',formatter:formatPrice},
                    {field:'rel_commissionAmount',title:'关系户应收佣金(元)',width:60,align:"center",hidden:false,editor:'text',formatter:formatPrice},

                    {field:'repayMoney',title:'回款金额(元)',width:50,align:"right",hidden:false,formatter:formatPrice},
                    {field:'repayAmount',title:'合计回款金额(元)',width:50,align:"right",hidden:false,formatter:formatPrice},
                    {field:'receiptId',title:'实收款ID',width:50,hidden:true},
                    {field:'sales',title:'销售人员',width:50,hidden:false}

                ]],

                toolbar: '#tb',
                onClickCell: onClickCell,
                showFooter: true,
                singleSelect:false
            });
            function formatPrice(val,row){
                if(val==null || val=="0") return "-";
                return commafy(val);
            }
            

            $("#projectId").combotree({
                onChange:function(newValue, oldValue){
                	getCheckCommissionDate(newValue);
                }
            });	
			
			$("#checkCommissionDate").combobox({
				valueField:'id',
				textField:'text',
				editable:false,
				url:'./saleunit_new/checkcommission/getDateListForCombotree.action',
				onLoadSuccess:function(node, data){
					
					var module = $("#checkCommissionDate").combotree('textbox');
					$(module).bind('focus', function(){
						$("#checkCommissionDate").combotree('showPanel');
					});			
				}
            });
        });


        $.extend($.fn.datagrid.methods, {
            editCell: function(jq,param){
                return jq.each(function(){
                    var opts = $(this).datagrid('options');
                    var fields = $(this).datagrid('getColumnFields',true).concat($(this).datagrid('getColumnFields'));
                    for(var i=0; i<fields.length; i++){
                        var col = $(this).datagrid('getColumnOption', fields[i]);
                        col.editor1 = col.editor;
                        if (fields[i] != param.field){
                            col.editor = null;
                        }
                    }
                    $(this).datagrid('beginEdit', param.index);
                    for(var i=0; i<fields.length; i++){
                        var col = $(this).datagrid('getColumnOption', fields[i]);
                        col.editor = col.editor1;
                    }
                });
            }
        });

        function endEditing(){
            if (editIndex == undefined){return true}
            if ($('#tbList').datagrid('validateRow', editIndex)){
                $('#tbList').datagrid('endEdit', editIndex);
                editIndex = undefined;
                return true;
            } else {
                return false;
            }
        }
        function onClickCell(index, field,value){
            if (endEditing()){
                $('#tbList').datagrid('selectRow', index).datagrid('editCell', {index:index,field:field});
                editIndex = index;
                /*if(field=="commission"){
                    var row = $('#tbList').datagrid('getSelected');
                    row.commissionAmount =  Math.round(row.commission * row.sum_price)/100;
                    alert(row.commission+"="+ row.sum_price+"="+Math.round(row.commission * row.sum_price)/100+"=="+value)
                }*/
            }
        }
        function accept(){
            if (endEditing()){
                getChanges();
                //$('#tbList').datagrid('acceptChanges');
            }
        }
        //保存修改佣金
        function getChanges(){
            var rows = $('#tbList').datagrid('getChanges');
            var checkcommissionId = [];
            var commissions = [];
            var commissionAmounts = [];

            var rel_commissions = [];
            var rel_commissionAmounts = [];

            var isChange = false;
            for(var i=0;i<rows.length;i++) {
                //修改过佣金行
                //alert(i+"=i "+rows[i].commission)
                //savecommission
                var commission,commissionAmount,rel_commission,rel_commissionAmount ;
                if(rows[i].commission==null || rows[i].commission=="-" || rows[i].commission.length==0){
                    commission = "0";
                } else {
                    commission = rows[i].commission;
                }
                if(rows[i].commissionAmount==null || rows[i].commissionAmount=="-" || rows[i].commissionAmount.length==0){
                    commissionAmount = "0";
                } else {
                    commissionAmount = rows[i].commissionAmount;
                }

                if(rows[i].rel_commission==null || rows[i].rel_commission=="-" || rows[i].rel_commission.length==0){
                    rel_commission = "0";
                } else {
                    rel_commission = rows[i].rel_commission;
                }
                if(rows[i].rel_commissionAmount==null || rows[i].rel_commissionAmount=="-" || rows[i].rel_commissionAmount.length==0){
                    rel_commissionAmount = "0";
                } else {
                    rel_commissionAmount = rows[i].rel_commissionAmount;
                }

                if(rel_commission==0 && rel_commissionAmount==0){
                    if(!parseFloat(commissionAmount)){
                    	alert(commissionAmount);
                        myAlert("佣金不能为 0");
                        return ;
                    }
                } else {
                    if(!parseFloat(rel_commissionAmount)){
                        myAlert("佣金不能为 0");
                        return ;
                    }
                }

                checkcommissionId.push(rows[i].checkcommissionId);
                commissions.push(commission);
                commissionAmounts.push(commissionAmount);

                rel_commissions.push(rel_commission);
                rel_commissionAmounts.push(rel_commissionAmount);

                isChange = true;
            }

            if(isChange){
                $.ajax({
                    type: 'get',
                    url: './saleunit_new/checkcommission/savecommission.action',
                    data: "checkcommissionId=" + checkcommissionId
                            + "&commissions=" + commissions + "&commissionAmounts=" + commissionAmounts
                            //+ "&sec_commissions=" + sec_commissions + "&sec_commissionAmounts=" + sec_commissionAmounts
                            + "&rel_commissions=" + rel_commissions + "&rel_commissionAmounts=" + rel_commissionAmounts  ,
                    dataType: "json",
                    beforeSend:function(){
                        moduleMaskByModule($("body"));
                    },
                    success: function(data){
                        if(data.type == "true"){
                            myAlert("操作成功");
                            $('#tbList').datagrid('acceptChanges');
                            moduleMaskRemove();
                            //modCheckFee();
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
        }

        function modCheckFee() {
			var checkDate = $("#checkCommissionDate").combobox("getValue");
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var checkCommissionType = $("#checkCommissionType").val();
            var checkIds = getSelections("checkfeeid");
            var receiptIds = getSelections("receiptId");

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }

            if(checkDate==null || checkDate.length==0){
                myAlert("对佣日期不能为空。");
                return;
            }

            $('#tbList').datagrid({

                loadMsg:'数据加载中...',
                url:'./saleunit_new/checkcommission/checkmod_view.action',
                queryParams:{
                    projectIds:projectIds,
                    checkCommissionDate:checkDate,
                    checkCommissionType:checkCommissionType,
                    receiptIds:receiptIds,
                    checkIds:checkIds
                }

            });
        }


        function del(){
            var commissionDate = $("#checkCommissionDate").combobox("getValue");
            myConfirm("是否确定删除？",function(){ajaxModifyMethod("del_checkcommission", commissionDate);});
        }

		//确认与开发商已对数
		function doFinal(){
            if (endEditing()){
                var rows = $('#tbList').datagrid('getChanges');
                if(rows.length>0) {
                    alert("请先保存佣金点");
                    return;
                }

                var commissionDate = $("#checkCommissionDate").combobox("getValue");
                myConfirm("开发商是否已确认该对佣表？",function(){ajaxModifyMethod("final_checkcommission", commissionDate);});
            }
		}

        /**
         * 导出预对数表
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

            location.href = './saleunit_new/checkcommission/exportExcel_Mod.action?projectIds='+projectIds +"&checkCommissionDate="+checkCommissionDate;
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
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var receiptId = getSelections("receiptId");
            var checkCommissionIds = getSelections("checkcommissionId");
            var checkIds = getSelections("checkfeeid");
			var ids = getSelections("unit_id");
			if(ids.length <= 0 || ids.join(",") == ""){
                myAlert("请先选择要操作的单元");
                return ;
            }

            $.ajax({
                type: 'get',
                url: './saleunit_new/checkcommission/' + action + '.action',
                data: "ids=" + ids.join(",") + "&checkCommissionDate=" + checkCommissionDate + "&receiptId=" + receiptId
                        + "&projectIds=" + projectIds + "&checkCommissionIds=" + checkCommissionIds
                        + "&checkIds=" + checkIds,
                dataType: "json",
                beforeSend:function(){
                    moduleMaskByModule($("body"));
                },
                success: function(data){

                    if(data.type == "true"){

                        //myAlert("操作成功");
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

        function clearSelections(){
            $('#tbList').datagrid('clearSelections');
        }

		//增加单元
		function addUnit(){
		
			var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
			var checkCommissionDate = $("#checkCommissionDate").combobox("getValue");

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }
			
            if(checkCommissionDate==null || checkCommissionDate.length==0){
                myAlert("对佣日期不能为空。");
                return;
            }
			
			$.ajax({
				type:"get",
				url: './saleunit_new/checkcommission/getCheckCommissionRefundType.action',
				data: "checkCommissionDate=" + checkCommissionDate + "&projectIds="+projectIds,
				dataType: "json",
				success: function(data){
					
					var type = data.type;
                    allRefund(checkCommissionDate, projectIds,type);

				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					myAlert("出现异常,请重试");
				}
			});
			
		}
		
		//全额回款单元弹出框
		function allRefund(checkCommissionDate, projectIds,repayType){


			new MyAjaxIframeDialog({title:'全额回款新单元选择列表',height:550, width:800,
				//src:'./saleunit/operation/chooseNewUnit.action?type=checkfeeForAllRefund&propertyProjectId=' + projectIds,
				src:'./saleunit_new/checkcommission/checkcommission_addUnit.action?propertyProjectId=' + projectIds +"&repayType="+repayType,
				submitFn:function(){
                    var repayMoney = $.easyIframeContentWindow("openIframe").getSelections("repayMoney");
                    var repayAmount = $.easyIframeContentWindow("openIframe").getSelections("repayAmount");
                    var receiptId = $.easyIframeContentWindow("openIframe").getSelections("receiptId");
                    var checkfeeId = $.easyIframeContentWindow("openIframe").getSelections("checkfeeid");
                    var commission = $.easyIframeContentWindow("openIframe").getSelections("commission");
                    var projectIds =$.easyIframeContentWindow("openIframe").$("input[name='propertyUnitCond.strSearchProjectIds']").val();
                    var repayType = $.easyIframeContentWindow("openIframe").$("#repayType").val();
                    var ids = parent.$.easyIframeContentWindow("openIframe").getSelections("unit_id");

                    if(ids.length <= 0 || ids.join(",") == ""){
                        myAlert("请先选择要操作的单元");
                        return ;
                    }
										
					parent.$('#myIframeDialog').dialog('close'); //关闭弹出框
					
					$.ajax({
						type:"get",
						url: './saleunit_new/checkcommission/add_checkcommission.action',
                        data: "ids=" + ids.join(",") + "&checkCommissionDate=" + checkCommissionDate
                                + "&receiptId=" + receiptId+"&repayMoney="+ repayMoney
                                + "&repayAmount=" + repayAmount + "&repayType=" + repayType
                                + "&projectIds=" + projectIds + "&checkfeeid=" + checkfeeId
                                + "&commission=" + commission,
						dataType: "json",
						success: function(data){
							
							 modCheckFee(); //重新加载datagrid
						},
						error: function(XMLHttpRequest, textStatus, errorThrown){
							myAlert("出现异常,请重试");
						}
					});
					
				}
			});
		}
		
		//部分回款单元弹出框
		function partRefund(checkFeeDate, projectIds){
		
			new MyAjaxIframeDialog({title:'部分回款新单元选择列表',height:650, width:800,
				src:'./saleunit/operation/chooseNewUnit.action?type=checkfeeForPartRefund&propertyProjectId=' + projectIds,
				submitFn:function(){
				
					var checkReceipt = parent.$("#openIframe")[0].contentWindow.$("input[name='receiptIdCk']:checked"); //获取选中的
					var unitId = parent.$("#__changeUnitId__").val(); //单元id
					
					parent.$('#myIframeDialog').dialog('close'); //关闭弹出框
					
					if(checkReceipt == undefined || checkReceipt.length <= 0){
						return ;
					}
					
					if(unitId == undefined || unitId == '' || unitId == '0'){
						return ;
					}					
					
					var receiptId = "";
					var repayMoney = "";
					var repayAmount = "";
					
					$(checkReceipt).each(function(){
					
						receiptId += $.trim($(this).attr("value")) + ":";
						repayMoney += $.trim($(this).attr("repayMoney")) + ",";
						repayAmount = $.trim($(this).attr("repayAmount"));
						
					});					

					$.ajax({
						type:"get",
						url: './saleunit_new/checkfee/add_checkfee.action',
		                data: "ids=" + unitId + "&checkFeeDate=" + checkFeeDate + "&projectIds=" + projectIds 
							+ "&receiptId=" + receiptId + "&repayMoney=" + repayMoney + "&repayAmount=" + repayAmount,
						dataType: "json",
						success: function(data){
							
							 modCheckFee(); //重新加载datagrid
						},
						error: function(XMLHttpRequest, textStatus, errorThrown){
							myAlert("出现异常,请重试");
						}
					});					
				}
			});
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
                          "./saleunit_new/checkcommission/getDateListForCombotree.action?propertyId=" + projectId +"&checkCommissionType="+$("#checkCommissionType").val()
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


    </script>
</head>
<body id="body" style="padding:0;background:white;">


<div id="toolbar" style="height: auto;padding: 5px">
    <form class="registerform" id="thisForm" name="thisForm"  method="post">
        <table width="100%" border="0" align="left" cellspacing="0">

            <tr>
                <td>

                    <span style="margin: 0 0 0 12px">
                        选择项目:
                        <input type="text" id="projectId" name="propertyUnitCond.strSearchProjectIds" />

                        <input type="hidden" id="checkCommissionType" value="1">
                    </span>

                    <span style="margin: 0 0 0 12px">
                        对佣日期:
						<input id="checkCommissionDate"/>
                        <img src="./ui/js/themes/icons/reload.png" alt="刷新对佣日期" title="刷新对佣日期" onclick="return reloadCheckCommissionDate()" align="middle" style="padding-bottom:10px;cursor: pointer;">

                        <%--销售状态:
                        <s:select list="saleMap" id="saleState" name="saleState" cssClass="easyui-combobox" cssStyle="width: 50px" panelHeight="auto"></s:select>--%>
                        <input type="button" onclick="return modCheckFee()" value="查看" />
                        <input type="button" onclick="return exportExcel()" value="导出" />
                    </span>



                </td>
            </tr>
        </table>
    </form>
</div>


<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;">
    <table id="tbList"></table>
</div>

<div id="tb" style="height:30px;line-height: 32px;">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addUnit()">新增单元</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="del()">删除单元</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存佣金点</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true" onclick="doFinal()">开发商已确认</a>
</div>
</body>
</html>
