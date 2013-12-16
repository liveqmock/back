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
        alert("没有选择楼盘");
        return false;
    }
    $("#myIframeDialog").dialog({
        resizable: true,
        modal:true,
        maximizable: false,
        width:400,
        height:180,
        onClose:function(){
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
    		flush_tab();			
        },
        buttons:[ {
            text:'提交',
            iconCls:'icon-ok',
            handler:function(){
                window.document.getElementById("openIframe").contentWindow.formsubmit();
            }},
            {text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#myIframeDialog').dialog('close');
                    
                }}
        ]
    });
    $('#myIframeDialog').dialog('open');
    $('#myIframeDialog').dialog('setTitle', '添加付款方式');
    $('#openIframe')[0].src='./saleunit_setup/payway/dialogPayWay.action?propertyProjectId='+propertyProjectId;
}
 <%--
function dialog_copy_payway(buildId){
    if(buildId == '0'){
        alert("没有选择楼栋");
        return false;
    }
    $("#myIframeDialog").dialog({
        resizable: true,
        modal:true,
        maximizable: false,
        width:400,
        height:180,
        onClose:function(){
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
        },
        buttons:[ {
            text:'提交',
            iconCls:'icon-ok',
            handler:function(){
                window.document.getElementById("openIframe").contentWindow.formsubmit();
            }},
            {text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#myIframeDialog').dialog('close');
                    flush_tab();
                }}
        ]
    });
    $('#myIframeDialog').dialog('open');
    $('#myIframeDialog').dialog('setTitle', '复制付款方式');
    $('#openIframe')[0].src='./saleunit_setup/payway/dialogCopyPayWay.action?buildId='+build_id;
}
--%>
function dialog_update_payway(wayId){
    //alert(wayId)
    $("#myIframeDialog").dialog({
        resizable: true,
        modal:true,
        maximizable: false,
        width:400,
        height:180,
        onClose:function(){
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
        },
        buttons:[ {
            text:'提交',
            iconCls:'icon-ok',
            handler:function(){
                window.document.getElementById("openIframe").contentWindow.formsubmit();
            }},
            {text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#myIframeDialog').dialog('close');
                    flush_tab();
                }}
        ]
    });
    $('#myIframeDialog').dialog('open');
    $('#myIframeDialog').dialog('setTitle', '修改付款方式');
    $('#openIframe')[0].src='./saleunit_setup/payway/dialogUpdatePayWay.action?wayId='+wayId;
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

function dialog_payway_de(wayId){    

    $("#myIframeDialog").dialog({
        resizable: true,
        modal:true,
        maximizable: false,
        width:500,
        height:500,
        onClose:function(){
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
        },
        buttons:[ {
            text:'提交',
            iconCls:'icon-ok',
            handler:function(){
                window.document.getElementById("openIframe").contentWindow.formsubmit();
            }},
            {text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#myIframeDialog').dialog('close');
                    flush_tab();
                }}
        ]
    });
    $('#myIframeDialog').dialog('open');
    $('#myIframeDialog').dialog('setTitle', '添加付款明细');
    $('#openIframe')[0].src='./saleunit_setup/payway/dialogPayWayDetail.action?wayId='+wayId;

	/**	
	new MyAjaxIframeDialog({title:'添加付款明细', formId:'question_toc_form', 
		width:500, height:500, closeFn:flush_tab,
		src:'./saleunit_setup/payway/dialogPayWayDetail.action?wayId='+wayId		
		});	
	*/
}

function dialog_update_payway_de(pwdId){
    $("#myIframeDialog").dialog({
        resizable: true,
        modal:true,
        maximizable: false,
        width:400,
        height:300,
        onClose:function(){
			$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
        },
        buttons:[ {
            text:'提交',
            iconCls:'icon-ok',
            handler:function(){
                window.document.getElementById("openIframe").contentWindow.formsubmit();
            }},
            {text:'关闭',
                iconCls:'icon-cancel',
                handler:function(){
                    $('#myIframeDialog').dialog('close');
                    flush_tab();
                }}
        ]
    });
    $('#myIframeDialog').dialog('open');
    $('#myIframeDialog').dialog('setTitle', '修改付款明细');
    $('#openIframe')[0].src='./saleunit_setup/payway/dialogUpdatePayWayDetail.action?pwdId='+pwdId;
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

<input style="" type="button" value="  添加付款方式  " id="_but_add_payway"/> <font color="red">设定的付款方式将适用于该楼盘</font>
<table style="width: 100%;line-height: 24px;" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
    <tr style="background-color: #ffffff; text-align:center">
        <th width="80px">付款方式</th>
        <th>付款明细</th>
        <th width="100">付款方式操作</th>
    </tr>
    <s:iterator value="listPayWay" var="c">
        <tr style="background-color: #ffffff" class="pay_way_tr">
            <td align="center" style="margin-top: 5px;margin-left: 5px" valign="top">${c.payName }</td>
            <td width="75%" valign="top">
                <table style="background-color: #eeeeee;width: 100%">
                    <tr style="background-color: #ddeeee" >
                        <th width="150">款项</th>
                        <th width="150">类别</th>
                        <th width="150">金额</th>
                        <th width="150">房款比例</th>
                        <th width="50">天数</th>
                        <th width="200">固定交款时间</th>
                        <td align="center" width="200" ><a style="color: #5482DE" href="#"  class="_add_pay_way_detail_class" onclick="dialog_payway_de(${c.id});return false;" >添加明细</a>
                        </td>	
                    </tr>
					
                    <s:iterator value="#request.c.payWayDetailList" var="cc">

                        <tr style="background-color: #ffffff" class="pay_way_de_tr">
                            <td align="center" valign="top">${cc.detailName }</td>
                            <td align="center" valign="top">${cc.payType }</td>
                            <td align="center" valign="top">${cc.payMoney }</td>
                            <td align="center" valign="top"><my:format value="${cc.payPercent*100}" type="intPercent"/>%
							<!--${cc.payPercent*100 }%--></td>
                            <td align="center">
                                <s:if test="#request.cc.dayNum != '-1'">
                                    ${cc.dayNum }
                                </s:if>
                            </td>
                            <td align="center">
                                <s:date name="#request.cc.payDate" format="yyyy-MM-dd"/>
                            </td>
                            <td align="center" width="100"><a style="color:  #5482DE" href="#" onclick="del_payway_de(${cc.id});return false;">删除明细</a>
                                    <%-- 	<a style="color:  #5482DE" href="#" onclick="dialog_update_payway_de(${cc.id});return false;">修改</a>--%></td>
                        </tr>
                    </s:iterator>
                </table>
            </td>
            <td align="center" valign="top" nowrap="nowrap">
			
				<a style="color: #5482DE" href="javascript:void(0)" onclick="dialog_update_payway(${c.id})">修改</a>
				<a style="color: #5482DE" href="javascript:void(0)" onclick="del_payway(${c.id})">删除</a>	
				
				<a style="color: #5482DE" href="javascript:void(0)" onclick="createPayWayProjectDiscount('${c.id}', '${c.payName}')">折扣管理</a>
				
				
				<!--
                <input type="button" value="  修改  "  onclick="dialog_update_payway(${c.id})"/>
                <input type="button" value="  删除  "  onclick="del_payway(${c.id})"/>
				<input type="button" value="  折扣  " onclick="javascript:alert('折扣管理')" />
				-->
            </td>
        </tr>
    </s:iterator>
</table>


