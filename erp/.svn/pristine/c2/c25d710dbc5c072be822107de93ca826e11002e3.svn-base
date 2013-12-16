<%@ page import="com.ihk.constanttype.ContUserId" %>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ page import="com.ihk.constanttype.EnumDevFlag" %>
<%@ page import="com.ihk.constanttype.EnumPrivCode" %>
<%@ page import="com.ihk.permission.PermissionUtils" %>
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
    <title>修改对数表</title>
    <s:include value="header.jsp"></s:include>
    <script type="text/javascript">

        $(document).ready(function(){
            //bindCompanyPropertyPorjectForXKZXOnly("projectId", "projectIds"); //单个项目的选择
            bindProjectTreeAreaBuildOnly("projectId", "areaId", "buildId");
            $('#tbList').datagrid({
                width:'auto',
                height: $(this).height()-43,
                /*fitColumns: true,*/
                /*fix:true,*/
                loadMsg:'数据加载中...',
                url:'',
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'unit_id',title:'单元ID',hidden:true},
                    {field:'checkfeeTypeName',title:'状态',width:70,align:"center"},
                    {field:'checkfee_date',title:'对数日期',width:70,align:"center"},
                    {field:'work_date',title:'成交日期',width:70,align:"center"},
                    {field:'sign_date',title:'签约日期',width:70,align:"center"},
                    {field:'area_name',title:'分区',width:50},
                    {field:'build_name',title:'楼栋',width:50},
                    {field:'unit_no',title:'单元号',width:50},
                    {field:'customer_name',title:'业主姓名',width:100,sortable:true},
                    {field:'build_area',title:'建筑面积(㎡)',width:50,sortable:true,align:"right"},
                    {field:'sum_price',title:'成交总价(元)',width:80,sortable:true,align:"right"},
                    {field:'contract_no',title:'合同号',width:50},
                    {field:'pay_name',title:'付款方式',width:50},
                    {field:'repayMoney',title:'回款金额',width:50,align:"right"},
                    {field:'repayAmount',title:'合计回款金额',width:50,align:"right"},
                    {field:'receiptId',title:'实收款ID',width:50,hidden:true},
                    {field:'sales',title:'销售人员',width:50}

                ]],
                toolbar: '#tb',
                showFooter: true,
                singleSelect:false
            });

            $("#projectId").combotree({
                onChange:function(newValue, oldValue){

                        getCheckFeeDate(newValue);
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
        });


        function modCheckFee() {
			var checkFeeDate = $("#checkFeeDate").combobox("getValue");
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            //var saleState = $("#saleState").combobox("getValue");

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }

            if(checkFeeDate==null || checkFeeDate.length==0){
                myAlert("对数日期不能为空。");
                return;
            }

            $('#tbList').datagrid({

                loadMsg:'数据加载中...',
                url:'./saleunit_new/checkfee/checkfeemod_unit.action',
                queryParams:{
                    projectIds:projectIds,
                    checkFeeDate:checkFeeDate,
                    checkFeeType:1
                }

            });
        }


        function del(){
            var checkFeeDate = $("#checkFeeDate").combobox("getValue");
            myConfirm("是否确定删除？",function(){ajaxModifyMethod("del_checkfee", checkFeeDate);});
        }
		
		//确认与开发商已对数
		function doFinal(){
            var checkFeeDate = $("#checkFeeDate").combobox("getValue");
            myConfirm("开发商是否已确认该对数表？",function(){ajaxModifyMethod("final_checkfee", checkFeeDate);});
		}
        //不对数
        function notCheck(){
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var checkFeeDate = $("#checkFeeDate").combobox("getValue");

            if(projectIds==null || projectIds.length==0 || projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }

            if(checkFeeDate==null || checkFeeDate.length==0){
                myAlert("对数日期不能为空。");
                return;
            }

            myConfirm("所选择单元是否确定不结佣？",function(){ajaxModifyMethod("donot_checkfee", checkFeeDate);});

        }
        /**
         * 导出预对数表
         */
        function exportExcel(){
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var checkFeeDate = $("#checkFeeDate").combobox("getValue");

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }

            if(checkFeeDate==null || checkFeeDate.length==0){
                myAlert("对数日期不能为空。");
                return;
            }

            location.href = './saleunit_new/checkfee/exportExcel_Mod.action?projectIds='+projectIds +"&checkFeeDate="+checkFeeDate+"&checkFeeType="+$("#checkFeeType").val();
        }

        function getReceiptId(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].receiptId);
            }

            return ids;
        }

        function getSelections(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].unit_id);
            }

			return ids;
        }

		//共用的ajax action方法
		function ajaxModifyMethod(action, checkFeeDate){
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var receiptId = getReceiptId();
			var ids = getSelections();
			if(ids.length <= 0 || ids.join(",") == ""){
                myAlert("请先选择要操作的单元");
                return ;
            }

            $.ajax({
                type: 'get',
                url: './saleunit_new/checkfee/' + action + '.action',
                data: "ids=" + ids.join(",") + "&checkFeeDate=" + checkFeeDate + "&receiptId=" + receiptId
                        + "&projectIds=" + projectIds,
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
			var checkFeeDate = $("#checkFeeDate").combobox("getValue");

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }
			
            if(checkFeeDate==null || checkFeeDate.length==0){
                myAlert("对数日期不能为空。");
                return;
            }
			
			$.ajax({
				type:"get",
				url: './saleunit_new/checkfee/getCheckFeeRefundType.action',
				data: "checkFeeDate=" + checkFeeDate + "&projectIds="+projectIds,
				dataType: "json",
				success: function(data){
					
					var type = data.type;
					if(type == "1"){
						//全额
						allRefund(checkFeeDate, projectIds);
					}else if(type == "2"){
						//部分
						partRefund(checkFeeDate, projectIds);
					}else{
						myAlert("返回类型有异常");
					}
				},
				error: function(XMLHttpRequest, textStatus, errorThrown){
					myAlert("出现异常,请重试");
				}
			});
			
		}
		
		//全额回款单元弹出框
		function allRefund(checkFeeDate, projectIds){
			
			new MyAjaxIframeDialog({title:'全额回款新单元选择列表',height:550, width:800,
				src:'./saleunit/operation/chooseNewUnit.action?type=checkfeeForAllRefund&propertyProjectId=' + projectIds,
				submitFn:function(){				
					var unitId = parent.$("#__changeUnitId__").val();
										
					parent.$('#myIframeDialog').dialog('close'); //关闭弹出框
					
					if(unitId == undefined || unitId == '' || unitId == '0'){
						return ;
					}
					
					$.ajax({
						type:"get",
						url: './saleunit_new/checkfee/add_checkfee.action',
		                data: "ids=" + unitId + "&checkFeeDate=" + checkFeeDate + "&projectIds="+projectIds,
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
                        选择项目:
						<input type="text" id="projectId" name="propertyUnitCond.strSearchProjectIds" />
                        <input type="hidden" id="checkFeeType" value="1">
                    </span>

                    <span style="margin: 0 0 0 12px">
                        对数日期:						
						<input id="checkFeeDate"/>
                        <img src="./ui/js/themes/icons/reload.png" alt="刷新对数日期" title="刷新对数日期" onclick="return reloadCheckFeeDate()" align="middle" style="padding-bottom:10px;cursor: pointer;">

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

<div id="tb">
    <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKFEE_UPDATE, EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
    <input type="button" onclick="return del()" value="删除单元" />
    <input type="button" onclick="return addUnit()" value="新增单元" />
    <input type="button" onclick="return notCheck()" value="不结佣" />
    <input type="button" onclick="return doFinal()" value="开发商已确认" />
    <%} %>

</div>

<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;">
    <table id="tbList"></table>
</div>


</body>
</html>
