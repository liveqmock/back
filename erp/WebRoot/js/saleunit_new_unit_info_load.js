/**
 * 单元信息显示时,要加载的js
 *
 **/

var click_unit_id = "0";
var select_tabs = '单元信息';

$().ready(function(){
    $('#sale_tabs').tabs({
        onSelect : function(title) {
            if (title == '单元信息') {
                doUnitInfo();
            } else if (title == '客户资料') {
                doCustomerInfo();
            }else if (title == '操作日志') {
                doSaleUnitLogInfo();
            } else if (title == '付款情况') {
                doUnitPayInfo();
            } else if (title == '认购情况') {
                doUnitStateInfo();
            } else if (title == '自定义数据') {
                doPropertyUnitDefineTab();
            } else if (title == '单元图片') {
                doUnitImage();
            } else if (title == '业主更名') {
                doUpdateCustomer();
            } else if (title == '客户服务事件') {
                doCustomerEvent();
            } else if (title == '赠品管理') {
                doUnitGift();
            } else if (title == '延期签约') {
                doExtensionContract();
            } else if (title == '售后客户问卷') {
                doQuestion();
            } else if(title == '收款明细'){
				doUnitPayBill();
			} else if(title == '收款情况'){
				doUnitPayPlan();
			} else if (title == '单元操作') {
				doUnitOperation();
            }
            select_tabs = title;
        }
    });


});




function dialog_unit_state_info(bbbid) {
    $("#myIframeDialog").dialog({
        resizable : true,
        modal : true,
        maximizable : false,
        width : 500,
        height : 435,
        onClose : function() {
            $('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
        },
        buttons:[]

    });

    $('#myIframeDialog').dialog('open');
    $('#myIframeDialog').dialog('setTitle', '销售情况');
    $('#openIframe')[0].src = "./saleunit_new/appoint/guangzhou/unitStateInfo.action?buildId=" + bbbid;
}

function dialogCloseRefresh(){
	var utabs = $("#_unit_pay_plan");
	 utabs.load("./saleunit_financial_manager/guangzhou/unitPayInfo.action?unitId="
     + click_unit_id + "");
	    utabs.attr("uid", click_unit_id);
}

function doUnitInfo() {
    var utabs = $("#_unit_info");
    utabs.load("./saleunit_new/appoint/guangzhou/unitInfo.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doCustomerInfo() {
    var utabs = $("#_customer_info");
    utabs.load("./saleunit_new/appoint/guangzhou/customerInfo.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doUnitOperation() {
    var utabs = $("#_unit_operation");
    utabs.load("./saleunit/operation/unitOperation.action?unitId="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doPropertyUnitDefineTab() {//自定义数据
    var utabs = $("#_property_unit_define_info");
    utabs.load("./saleunit_new/appoint/guangzhou/propertyUnitDefineTab.action?unitId="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doUnitStateInfo() {

    var buildId = $("#hiddenBuildId").val();
    if (buildId != "" && buildId != undefined && buildId != "0") {

        var utabs = $("#_unit_state_info");
        utabs.load("./saleunit_new/appoint/guangzhou/unitStateInfo.action?buildId="
            + buildId);
    }

}

function doSaleUnitLogInfo() {
    var utabs = $("#_sale_unit_log_info");
    utabs.load("./saleunit_new/appoint/guangzhou/unitTransactionLogInfo.action?unitId="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doUnitPayInfo() {
    var utabs = $("#_unit_pay_info");
    utabs.load("./saleunit_new/appoint/guangzhou/unitPayInfo.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doUnitPayInfo_flush() {
    var utabs = $("#_unit_pay_info");
    utabs.load("./saleunit_new/appoint/guangzhou/unitPayInfo.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doUnitImage() {

    if (click_unit_id != "0") {
        //表示选择了单元
        toGetUnitImageInfo(click_unit_id);
    }
}

function doUpdateCustomer() {
    var utabs = $("#_updatet_customer");
    //if(utabs.attr("uid") != 0){
    utabs.load("./saleunit_new/appoint/guangzhou/showContract.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
    //	}
}

function doCustomerEvent() {
    var utabs = $("#_customer_event_tabls");

    utabs.load("./saleunit_new/appoint/guangzhou/customerEvent.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doUnitGift() {
    var utabs = $("#_unit_gift");
    utabs.load("./saleunit_new/appoint/guangzhou/unitGiftIndex.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

function doExtensionContract() {

    var utabs = $("#_extension_contract");
    if (utabs.attr("uid") != click_unit_id && click_unit_id != "0") {
        utabs.load("./saleunit_new/appoint/guangzhou/extensionContractList.action?id="
            + click_unit_id + "");
        utabs.attr("uid", click_unit_id);
    }
}

function doQuestion() {
    var utabs = $("#_question");
    utabs.load("./saleunit_new_questions/appoint/guangzhou/doQuestionTable.action?id="
        + click_unit_id + "");
    utabs.attr("uid", click_unit_id);
}

//收款情况
function doUnitPayPlan() {
	 var utabs = $("#_unit_pay_plan");
	   // utabs.load("./saleunit_new/appoint/guangzhou/unitPayPlan.action?id="
	     //   + click_unit_id + "");
	
	 utabs.load("./saleunit_financial_manager/guangzhou/unitPayInfo.action?unitId="
        + click_unit_id + "");
	 
	    utabs.attr("uid", click_unit_id);
}

//收款明细
function doUnitPayBill(){
	
	if(click_unit_id == undefined || click_unit_id == "" || click_unit_id == "0")
		return ;
	
	var utabs = $("#_unit_pay_bill");
	var url = "./saleunit_financial_manager/guangzhou/receiptList.action?unitId=" + click_unit_id; //旧的财务模块的
	url = "./saleunit_financial_tabs/guangzhou/receiptList.action?unitId=" + click_unit_id;
    utabs.load(url);
    utabs.attr("uid", click_unit_id);
}

//单元格的单击事件
function tdClick(td) {
    var clickUnitId = $(td).attr("unitid");
 
    $("unitId").attr("value",clickUnitId);
    //如果是重复选择的单元信息,不刷新
    if (clickUnitId == click_unit_id || clickUnitId == '0'
        || clickUnitId == undefined || clickUnitId == "") {

        return false;
    } else {

        //为选中的单元加上样式

        $(".changetd").removeClass("changetd");
        $(td).addClass("changetd");

        var unitValue = $(td).text();

        var oldHiddenUnitId = $("#hiddenUnitId").attr("value");
        //表示第一次点击单元(还要区分是不是组合)
        if(oldHiddenUnitId == undefined){

            var getHiddenBuildId = $("#hiddenBuildId").val();
            if(getHiddenBuildId != undefined && getHiddenBuildId != "" && getHiddenBuildId != "0"){
                //表示非组合

                var oldShowContent = $("#showContent").html();
                var hiddenValue = "<input type='hidden' id='hiddenUnitId' value='" + clickUnitId + "'/>";
                var unitValueSpan = "<span id='unitValueId'>" + unitValue + "</span>";
                $("#showContent").html(oldShowContent + "," + unitValueSpan + hiddenValue);

            }else{
                //组合要一并把该单元的项目,楼栋等名称及对应的值设置好
                $.ajax({
                    type:"get",
                    url: "./saleunit_new/appoint/guangzhou/getUnitShowContent.action",
                    data: "unitId=" + clickUnitId,
                    dataType: "html",
                    success: function(data){
                        $("#_center_layout .panel-title").html(data);
                    }
                });

            }

        }else{

            var getHiddenBuildId = $("#hiddenBuildId").val();
            if(getHiddenBuildId != undefined && getHiddenBuildId != "" && getHiddenBuildId != "0"){
                //表示非组合

                $("#unitValueId").html(unitValue);
                $("#hiddenUnitId").attr("value", clickUnitId);

            }else{
                //组合要一并把该单元的项目,楼栋等名称及对应的值设置好
                $.ajax({
                    type:"get",
                    url: "./saleunit_new/appoint/guangzhou/getUnitShowContent.action",
                    data: "unitId=" + clickUnitId,
                    dataType: "html",
                    success: function(data){
                        $("#_center_layout .panel-title").html(data);
                    }
                });

            }

        }

        click_unit_id = clickUnitId;
        if (select_tabs == '单元信息') {
            var utabs = $("#_unit_info");
            doUnitInfo();
        } else if (select_tabs == '客户资料') {
            var utabs = $("#_customer_info");
            doCustomerInfo();
        } else if (select_tabs == '操作日志') {
            var utabs = $("#_sale_unit_log_info");
            doSaleUnitLogInfo();
        } else if (select_tabs == '付款情况') {
            var utabs = $("#_unit_pay_info");
            doUnitPayInfo();
        } else if (select_tabs == '认购情况') {
            var utabs = $("#_unit_state_info");
            doUnitStateInfo();
        } else if (select_tabs == '自定义数据') {
            var utabs = $("#_property_unit_define_info");
            doPropertyUnitDefineTab();
        } else if (select_tabs == '单元图片') {
            doUnitImage();
        } else if (select_tabs == '业主更名') {
            var utabs = $("#_updatet_customer");
            doUpdateCustomer();
        } else if (select_tabs == '客户服务事件') {
            var utabs = $("#_customer_event_tabls");
            doCustomerEvent();
        } else if (select_tabs == '赠品管理') {
            var utabs = $("#_unit_gift");
            doUnitGift();
        } else if (select_tabs == '延期签约') {
            doExtensionContract();
        } else if (select_tabs == '售后客户问卷') {
            doQuestion();
        } else if(select_tabs == '收款明细'){
			doUnitPayBill();
		}else if(select_tabs == '收款情况'){
			doUnitPayPlan();
		}else if (select_tabs == '单元操作') {
            var utabs = $("#_unit_operation");
            doUnitOperation();
        }
    }
}

function tdOver(td) {
    var unitId = $(td).attr("unitid");
    if (unitId != "" && unitId != "0" && unitId != undefined) {
        $(td).addClass("seltd");

    }
}

function tdOut(td) {
    var unitId = $(td).attr("unitid");
    if (unitId != "" && unitId != "0" && unitId != undefined) {
        $(td).removeClass("seltd");
    }
}

function unitSaleState(){
    var buildId = $("#hiddenBuildId").val();
    if(buildId != undefined && buildId != "" && buildId != "0"){
        dialog_unit_state_info(buildId);
    }else{
        myAlert("请先确定楼栋");
    }
}
