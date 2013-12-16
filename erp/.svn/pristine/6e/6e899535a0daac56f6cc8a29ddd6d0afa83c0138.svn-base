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
    <title>新建预对数表</title>
    <s:include value="header.jsp"></s:include>
    <script type="text/javascript">

        $(document).ready(function(){

            //bindProjectAreaBuildForXKZX("projectId", "areaId", "buildId"); //销控中心角色的项目,分区,楼栋级联
            bindProjectTreeAreaBuildOnly("projectId", "areaId", "buildId");
            $('#tbList').datagrid({
                width:'auto',
                height: $(this).height()-128,
                /*fitColumns: true,*/
                /*fix:true,*/
                loadMsg:'数据加载中...',
                url:'',
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'unit_id',title:'单元ID',hidden:true},
                    {field:'checkfeeTypeName',title:'状态',width:70,align:"center"},
                    {field:'checkfee_date',title:'对数日期',width:70,align:"center"},
                    {field:'work_date',title:'成交日期',width:70,align:"center",sortable:true},
                    {field:'sign_date',title:'签约日期',width:70,align:"center",sortable:true},
                    {field:'area_name',title:'分区',width:50},
                    {field:'build_name',title:'楼栋',width:50},
                    {field:'unit_no',title:'单元号',width:50,sortable:true},
                    {field:'customer_name',title:'业主姓名',width:100,sortable:true},
                    {field:'build_area',title:'建筑面积(㎡)',width:50,sortable:true,align:"right"},
                    {field:'sum_price',title:'成交总价(元)',width:80,sortable:true,align:"right"},
                    {field:'contract_no',title:'合同号',width:50},
                    {field:'pay_name',title:'付款方式',width:50},

                    {field:'repayMoney',title:'回款金额',width:60,align:"right"},
                    {field:'repayAmount',title:'合计回款金额',width:60,align:"right"},
                    {field:'receiptId',title:'实收款ID',width:50,hidden:true},

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

            $('#checkFeeDate').datebox({
                onSelect: function (date) {
                    chgBtn();
                }
            });
            /*
            //全额回款，部分回款选择
            $("#seleType").combobox({
                onChange: function (n,o) {
                    if(n==1){
                        //全额
                        $("#span_saleStateDate").show();
                        $("#span_receiptDate").hide();
                        $("#tip").hide();
                        $("#btn_add").removeAttr("disabled");
                        $("#btn_view").removeAttr("disabled");
                        $("#btn_search").removeAttr("disabled");

                    } else if(n==2) {
                        //部分回款
                        $("#span_saleStateDate").hide();
                        $("#span_receiptDate").show();
                        $("#tip").hide();
                        $("#btn_add").removeAttr("disabled");
                        $("#btn_view").removeAttr("disabled");
                        $("#btn_search").removeAttr("disabled");
                    } else {

                        $("#tip").show();
                        $("#btn_add").attr("disabled","true");
                        $("#btn_view").attr("disabled","true");
                        $("#btn_search").attr("disabled","true");
                    }
                }
            });*/
        });

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
            var url = './saleunit_new/checkfee/checkfee_unit.action';
            if($("#seleType").combobox('getValue')==2){
                //部分回款
                url = './saleunit_new/checkfee/checkfee_unit_receipt.action';
            }

            $('#tbList').datagrid({

                loadMsg:'数据加载中...',
                url:url,
                queryParams:{
                    projectIds:projectIds,
                    areaId:$("input[name='propertyUnitCond.areaId']").val() ,
                    buildId:$("input[name='propertyUnitCond.buildId']").val(),
                    saleState:$('#saleState').combobox('getValue'),
                    /*checkFeeDate:$('#checkFeeDate').datebox('getValue'),*/
                    signDate:$('#date1').datebox('getValue'),
                    signDateEnd:$('#date2').datebox('getValue'),
                    receiptDate:$('#receiptDateStart').datebox('getValue'),
                    receiptDateEnd:$('#receiptDateEnd').datebox('getValue'),
                    checkFeeType:$('#checkFeeType').val()
                }

            });
        }

		//加入对数表
        function add(){
		
			//只有选择的是未对数的才能加入对数表
			var type = $("#checkFeeType").val();
			if(type != "0"){
				myAlert("只有未对数的单元才能加入对数表");
				return;
			}
			
            var checkFeeDate = $("#checkFeeDate").datebox("getValue");
            if(checkFeeDate==null || checkFeeDate.length==0){
                myAlert("对数日期不能为空。");
                return;
            }
			
			ajaxModifyMethod("add_checkfee", checkFeeDate);
        }
		
        function del(){
		
			ajaxModifyMethod("del_checkfee", "");           
        }
        /**
         * 对数表确认
         */
        function save(){
            var date3 = $("#date3").datebox("getValue");
            if(date3==null || date3.length==0){
                myAlert("对数日期不能为空。");
                return;
            }
            getSelections();
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
        function getRepayMoney(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].repayMoney);
            }

			return ids;
        }
        function getRepayAmount(){
            var ids = [];
            var rows = $('#tbList').datagrid('getSelections');
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].repayAmount);
            }

			return ids;
        }

		//共用的ajax action方法
		function ajaxModifyMethod(action, checkFeeDate){
            var repayMoney = getRepayMoney();
            var repayAmount = getRepayAmount();
            //var receiptId = getReceiptId();
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();

			var ids = getSelections();
			if(ids.length <= 0 || ids.join(",") == ""){
                myAlert("请先选择要操作的单元");
                return ;
            }


            $.ajax({
                type: 'get',
                url: './saleunit_new/checkfee/' + action + '.action',
                data: "ids=" + ids.join(",") + "&checkFeeDate=" + checkFeeDate
                        //+ "&receiptId=" + receiptId+"&repayMoney="+ repayMoney
                        + "&repayAmount=" + repayAmount + "&seleType=1"
                        + "&projectIds=" + projectIds,
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
            var checkFeeDate = $("#checkFeeDate").datebox("getValue");
            var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
                return;
            }
			
            if(checkFeeDate==null || checkFeeDate.length==0){
                myAlert("对数日期不能为空。");
                return;
            }

            new MyIframeDialog({title:'查看对数表', width:800,height:550,buttons:false,
                src:'./saleunit_new/checkfee/checkfee_view_init.action?projectIds='+projectIds
                        +'&areaId=' + $("input[name='propertyUnitCond.areaId']").val()
                        +'&buildId=' + $("input[name='propertyUnitCond.buildId']").val()
                        //+'&saleState=' + $('#saleState').combobox('getValue')
                        +'&checkFeeDate=' + $('#checkFeeDate').datebox('getValue')
                        +'&checkFeeType=1'

            });
        }
		
		//增加单元
		function addUnit(){
		
			var projectIds = $("input[name='propertyUnitCond.strSearchProjectIds']").val();

            if(projectIds==null || projectIds.length==0|| projectIds.indexOf(",")>=0) {
                myAlert("请选择项目。");
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
						url: './saleunit_new/checkfee/getCheckFeeRowDataForAddByUnitId.action?unitId=' + unitId,
						dataType: "json",
						success: function(data){
						
							if(data == ""){
								return ;
							}
						
							$('#tbList').datagrid('appendRow',{
							
								//{field:'ck',checkbox:true},
								unit_id:data.unit_id,
								
								checkfeeTypeName:data.checkfeeTypeName,
								checkfee_date:data.checkfee_date,
								
								work_date:data.work_date,
								sign_date:data.sign_date,
								
								area_name:data.area_name,								
								build_name:data.build_name,
								unit_no:data.unit_no,
								
								customer_name:data.customer_name,
								
								build_area:data.build_area,
								sum_price:data.sum_price,
								contract_no:data.contract_no,
								
								pay_name:data.pay_name,
								sales:data.sales
					
					 		});
						},
						error: function(XMLHttpRequest, textStatus, errorThrown){
							myAlert("出现异常,请重试");
						}
					});
					
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
                        <span style="color: red">*</span>选择对数日期:
                        <input class="easyui-datebox" type="text" id="checkFeeDate" style="width:90px" name="checkFeeDate"/>

                        <span style="display: none;">
                        <select id="seleType" class="easyui-combobox" style="width:80px;" panelHeight="auto">
                            <%--<option value="">请选择回款</option>--%>
                            <option value="1" selected="true">全额回款</option>
                            <option value="2">部分回款</option>
                        </select>
                        </span>

                        <span id="tip" style="color: red">（请先选择对数日期）</span>
                    </span>

                    <br><br>

                    <fieldset  style="border:1px solid #989898;" id="fieldset_search">
                        <legend>筛选条件</legend>

                        选择项目:
                        <input type="text" id="projectId" name="propertyUnitCond.strSearchProjectIds" />
                        <input type="text" id="areaId" name="propertyUnitCond.areaId" value="${propertyUnitCond.areaId}" />
                        <input type="text" id="buildId" name="propertyUnitCond.buildId" value="${propertyUnitCond.buildId}" />
                        销售状态:<s:select list="saleMap" id="saleState" name="saleState" cssClass="easyui-combobox" cssStyle="width: 50px"  panelHeight="auto"></s:select>

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

                        <input type="hidden" id="checkFeeType" value="0">

                        <input id="btn_search" type="button" onclick="return submitSearch()" value=" 筛选 " />

                    </fieldset>

                </td>
            </tr>
        </table>
    </form>
</div>

<div id="tb">
    <input id="btn_add" type="button" onclick="return add()" value="加入对数表" />
    <input id="btn_view" type="button" onclick="return doView()" value="查看对数表" />
</div>

<div region="center" style="background:#ffffff;overflow:hidden;padding:5px;" id="div_tbList">
    <table id="tbList"></table>
</div>

</body>
</html>
