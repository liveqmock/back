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
    <title>查询对数表</title>
    <s:include value="header.jsp"></s:include>
    <script type="text/javascript">

        $(document).ready(function(){
            //bindCompanyPropertyPorjectForXKZXOnly("projectId", "projectIds"); //单个项目的选择
            bindProjectTreeAreaBuildOnly("projectId", "areaId", "buildId");
            $('#tbList').datagrid({
                width:'auto',
                height:  $(this).height()-45,
                //fitColumns: true,

                loadMsg:'数据加载中...',
                url:'',
                columns:[[

                    {field:'unit_id',title:'单元ID',hidden:true},
                    {field:'checkcommissionType',title:'对佣状态id',hidden:true},
                    {field:'checkcommissionTypeName',title:'对佣状态',width:70,align:"center"},
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

                    {field:'repayMoney',title:'回款金额',width:50,align:"center"},
                    {field:'repayAmount',title:'合计回款金额',width:50,align:"center"},
                    {field:'receiptId',title:'实收款ID',width:50,hidden:true},

                    {field:'sales',title:'销售人员',width:80}

                ]],
                toolbar: '#tb',
                showFooter: true,
                singleSelect:true
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

            $("#checkFeeType").combobox({
                onSelect:function(rec){
                    reloadCheckFeeDate();
                }
            });
        });


        function modCheckFee() {
			var checkFeeDate = $("#checkFeeDate").combobox("getValue");
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();
            var checkFeeType = $("#checkFeeType").combobox("getValue");
            //var saleState = $("#saleState").combobox("getValue");

            if(projectIds==null || projectIds.length==0 || projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }

            /*if((checkFeeDate==null || checkFeeDate.length==0) && !(checkFeeType==0||checkFeeType==4)){
                myAlert("对数日期不能为空。");
                return;
            }*/

            $('#tbList').datagrid({
                loadMsg:'数据加载中...',
                url:'./saleunit_new/checkfee/checkfeemod_unit.action',
                queryParams:{
                    projectIds:projectIds,
                    checkFeeDate:checkFeeDate,
                    checkFeeType:checkFeeType

                }

            });
        }

        function add(){
            var date2 = $("#date2").datebox("getValue");
            if(date2==null || date2.length==0){
                myAlert("对数日期不能为空。");
                return;
            }

			ajaxModifyMethod("add_checkfee", date2);
        }

        function del(){

			ajaxModifyMethod("del_checkfee", "");
        }
		
		//确认与开发商已对数
		function doFinal(){
			ajaxModifyMethod("final_checkfee", "");
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

            location.href = './saleunit_new/checkfee/exportExcel_Mod.action?projectIds='+projectIds +"&checkFeeDate="+checkFeeDate+"&checkFeeType="+$("#checkFeeType").combobox("getValue");
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
        function getCheckFeeDates(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].checkfee_date);
            }

            return ids;
        }
		//共用的ajax action方法
		function ajaxModifyMethod(action, checkFeeDate){
            var receiptId = getReceiptId();
			var ids = getSelections();
			if(ids.length <= 0 || ids.join(",") == ""){
                myAlert("请先选择要操作的单元");
                return ;
            }

            $.ajax({
                type: 'get',
                url: './saleunit_new/checkfee/' + action + '.action',
                data: "ids=" + ids.join(",") + "&checkFeeDate=" + checkFeeDate + "&receiptId=" + receiptId,
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
			
			new MyAjaxIframeDialog({title:'选择新单元列表',height:550, width:800,
				src:'./saleunit/operation/chooseNewUnit.action?type=checkfee&propertyProjectId=' + projectIds,
				submitFn:function(){				
					var unitId = parent.$("#__changeUnitId__").val();
										
					parent.$('#myIframeDialog').dialog('close'); //关闭弹出框
					
					if(unitId == undefined || unitId == '' || unitId == '0'){
						return ;
					}
					
					$.ajax({
						type:"get",
						url: './saleunit_new/checkfee/add_checkfee.action',
		                data: "ids=" + unitId + "&checkFeeDate=" + checkFeeDate,
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
            $("#checkFeeDate").combobox("clear");

			$("#checkFeeDate").combobox(
                    "reload",
                    "./saleunit_new/checkfee/getCheckFeeDateListForCombotree.action?propertyId=" + projectId +"&checkFeeType="+$("#checkFeeType").combobox("getValue")
            );
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
            var checkFeeDate = getCheckFeeDates();

            if(selected){
                if(selected.checkcommissionType=="0"){
                   ajaxModifyMethod("resume_checkfee", checkFeeDate);
                } else{
                    myAlert("此单元已操作过对佣，不能被恢复。");
                }
            } else {
                myAlert("请选择要操作的数据");
            }
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
                        对数状态:
                        <s:select list="checkFeeTypeMap" id="checkFeeType" name="checkFeeType" cssClass="easyui-combobox" cssStyle="width: 60px"></s:select>
                        对数日期:
                        <input id="checkFeeDate"/>
                        <img src="./ui/js/themes/icons/reload.png" alt="刷新对数日期" title="刷新对数日期" onclick="return reloadCheckFeeDate()" align="middle" style="padding-bottom:10px;cursor: pointer;">

                        <input type="button" onclick="return modCheckFee()" value="查看" />
                        <input type="button" onclick="return exportExcel()" value="导出" />

                    </span>

                </td>
            </tr>
        </table>
    </form>
</div>

<div id="tb">
    <input type="button" onclick="return doResume()" value="恢复可对数" />
</div>

<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;">
    <table id="tbList"></table>
</div>

<div id="mm" class="easyui-menu" style="width:100px;">
    <div iconCls="icon-edit" onclick="doResume()">恢复可对数</div>
</div>
</body>
</html>
