<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<base href="<%=basePath%>">

<script type="text/javascript">
$().ready(function(){
    $(".pay_way_tr").hover(function(){
                $(this).attr("style","background-color: #eeeeee");
            },
            function(){
                $(this).attr("style","background-color: #ffffff");
            }
    )

    $(".pay_way_de_tr").hover(function(){
                $(this).attr("style","background-color: #FBEC88");
            },function(){
                $(this).attr("style","background-color: #ffffff");
            }
    )

    $("#_but_add_payway").click(function(){
        dialog_payway(pp_id);
    })

})


function dialog_payway(propertyProjectId){
    if(propertyProjectId == '0'){
        myAlert("请先选择楼盘");
        return false;
    }
	
	new MyAjaxIframeDialog({title:'添加付款方式', formId:'inputPayWayFormId', 
		ids:['payName'],
		width:400, height:180, closeFn:flush_tab,
		src:'./saleunit_setup/payway/dialogPayWay.action?propertyProjectId='+propertyProjectId
	});	
}


function dialog_update_payway(wayId){
	
	new MyAjaxIframeDialog({title:'修改付款方式', formId:'updatePayWayFormId', 
		ids:['payName'],
		width:400, height:180, closeFn:flush_tab,
		src:'./saleunit_setup/payway/dialogUpdatePayWay.action?wayId='+wayId		
		});	
}

$.messager.defaults = { ok: "确定", cancel: "取消" };
function del_payway(wayId){
    //alert('1');
    $.messager.confirm('确定框','是否确定删除',function(r){
        if (r){
            $.post('./saleunit_setup/payway/delPayWay.action',{'wayId':wayId},function(date){

                $.messager.alert('提示',date);
                flush_tab();
            });
        }
    });
}

//添加明细
function dialog_payway_de(wayId){

	MyAjaxIframeDialog({title:'添加付款明细', formId:'addFormId', 
		ids:['typeName:combobox', 
			function(_easy){return checkFeeTypeForAdd(_easy);}
		],
		width:600, height:480, closeFn:flush_tab,
		src:'./saleunit_setup/payway/toAddPayWayDetail.action?wayId='+wayId		
		});	
}

//添加明细的收款内容验证function
function checkFeeTypeForAdd(_easy){
	
	var radioCheck = false; //收款内容的固定部分
	var feeType = ""; //收款内容的自定义部分

	_easy.$("#feeTypeFixedId input[type=radio]").each(function(){
		if(this.checked == true){
			radioCheck = true;
		}
	});
	
	feeType = _easy.$("#feeType").combobox("getValue");
	
	if(radioCheck == false && feeType == ""){
		return "收款内容 不合规则";
	}			
}

//修改明细
function dialog_update_payway_de(pwdId){
	
	new MyAjaxIframeDialog({title:'修改付款明细', formId:'updateFormId', 
		ids:[],
		width:600, height:480, closeFn:flush_tab,
		src:'./saleunit_setup/payway/toUpdatePayWayDetail.action?detailId=' + pwdId
	});	
	
}

function del_payway_de(pwdId){
    $.messager.confirm('确定框','是否确定删除',function(r){
        if (r){
            $.post('./saleunit_setup/payway/delPayWayDetail.action',{'pwdId':pwdId},function(date){
                $.messager.alert('提示',date);
                flush_tab();
            });
        }
    });
}
</script>

<input style="" type="button" value="  添加付款方式  " id="_but_add_payway"/>
<font color="red">设定的付款方式将适用于该楼盘</font>

<table style="width: 100%;line-height: 24px;" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
    <tr style="background-color: #ffffff; text-align:center">
        <th width="80px">付款方式</th>
        <th>付款明细</th>
        <th width="100">付款方式操作</th>
    </tr>
	
    <s:iterator value="payWayList" var="c">
        <tr style="background-color: #ffffff" class="pay_way_tr">
		
            <td align="center" style="margin-top: 5px;margin-left: 5px" valign="top">
			${c.payName}
			</td>
			
            <td width="75%" valign="top">
                <table style="background-color: #eeeeee;width: 100%">
                    <tr style="background-color: #ddeeee" >
                        <th width="150">收费类别</th>
                        <th width="150">收款内容</th>
						
						<th width="80" title="认购日期后的天数">付款天数</th>
						<th width="200">固定付款时间</th>
						
                        <th width="150">固定金额</th>
                        <th width="150">房款比例</th>                       
                       
                        <td align="center" width="200">
							<a style="color: #5482DE" href="#"  class="_add_pay_way_detail_class" onclick="dialog_payway_de(${c.id});return false;">添加明细</a>
                        </td>	
                    </tr>
					
                    <s:iterator value="#request.c.payWayDetailList" var="cc">

                        <tr style="background-color: #ffffff" class="pay_way_de_tr">
                            <td align="center" valign="top">${cc.typeName }</td>
                            <td align="center" valign="top">${cc.feeType }</td>
							
							<td align="center">
								<!--
                                <s:if test="#cc.dayNum > 0">${cc.dayNum}</s:if>
								-->
								${cc.dayNum}
                            </td>
							<td align="center">
                                <s:date name="#request.cc.payDate" format="yyyy-MM-dd"/>
                            </td>
							
                            <td align="center" valign="top">${cc.payMoney }</td>
                            <td align="center" valign="top">							
								${cc.payPercentStr}
							</td>
                                                        
                            <td align="center" width="100">
                               	<a style="color:  #5482DE" href="#" onclick="dialog_update_payway_de(${cc.id});return false;">修改</a>
								<a style="color:  #5482DE" href="#" onclick="del_payway_de(${cc.id});return false;">删除</a>
							</td>
                        </tr>
                    </s:iterator>
                </table>
            </td>
			
            <td align="center" valign="top" nowrap="nowrap">
			
				<a style="color: #5482DE" href="javascript:void(0)" onclick="dialog_update_payway(${c.id})">修改</a>
				<a style="color: #5482DE" href="javascript:void(0)" onclick="del_payway(${c.id})">删除</a>	
				
				<a style="color: #5482DE" href="javascript:void(0)" onclick="createPayWayProjectDiscount('${c.id}', '${c.payName}')">折扣管理</a>
				
            </td>
        </tr>
    </s:iterator>
</table>


