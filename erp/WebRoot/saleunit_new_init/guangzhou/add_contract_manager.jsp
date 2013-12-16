<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>新增合同管理</title>

	 <s:include value="../../header/header_easyui.jsp"/>
	
     <style type="text/css">
	 	*{margin:0;padding:0;}
         td {empty-cells:show; height:26px;padding-left: 5px;}
        .contract_tr_des {empty-cells:show; background-color:#f1f9fe;height:35px;}
        .searchbox-button {display:none;width: 1px;}
         .searchbox {
             background: none repeat scroll 0 0 #FFFFFF;
             border: 1px solid #A4BED4;
             display: inline-block;
             font-size: 12px;
             margin: 0;
             padding: 0;
             white-space: nowrap;
             height: 22px;
         }
    </style>
    
    <script type="text/javascript" language="javascript" src="./js/contract_manager.js"></script>
    
    <script type="text/javascript" language="javascript">
		
		$().ready(function(e) {
            
			$("#add").linkbutton({
				iconCls:'icon-add'
			});
			
			$("#show").linkbutton({
				iconCls:'icon-edit'
			});
			
			$("#delete").linkbutton({
				iconCls:'icon-cancel'
			});			
				
			$("#viewbar_table").datagrid({
				loadMsg:'加载中...',
				singleSelect:true,
				striped:true,
				nowrap:true,
				fit:true,
				fitColumns:true
				//width: $(this).width(),
				//height: $(this).height()
			});
			
			// class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,loadMsg:'加载中...'"
			
        });
		
	</script>
    
  <script type="text/javascript" language="javascript">

    $(function(){
        
        $('#tartsetPartya').numberspinner({				
            onChange:function(newValue,oldValue){
                $('#tartsetPartyb').numberspinner('setValue', 100-newValue);	
            }
        });
        
        $('#tartsetPartyb').numberspinner({				
            onChange:function(newValue,oldValue){
                $('#tartsetPartya').numberspinner('setValue', 100-newValue);	
            }
        });
        
        $('#feeMonthly').numberbox({
            onChange:function(newValue,oldValue){
                
                var total = $('#feeTotal').numberbox('getValue');
                if(total != ''){
                    $('#feeMoneyTotal').text(newValue * total);
                }
            }
        });
        
        $('#feeTotal').numberbox({
            onChange:function(newValue,oldValue){
                
                var monthly = $('#feeMonthly').numberbox('getValue');
                if(monthly != ''){
                    $('#feeMoneyTotal').text(newValue * monthly);
                }
            }
        });
        
    });
                
    </script>
	
</head>
	
<body>
<div class="gbox1">			

 <form action="./saleunit_new_init/appoint/guangzhou/addContractManager.action" method="post" id="contractManagerFormId">

        <table id="tableForm" width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px;">

            <tr class="contract_tr_des">

                <td style="width:15%" align="right">代理合同信息&nbsp;</td>
                <td colspan="3">
				${showName} <a href="javascript:void(0)" id="add2" onClick="barRule(0)">添加跳BAR规则</a>
				<input type="hidden" name="contractManager.propertyId" value="${build.propertyId}"/>
				<input type="hidden" name="contractManager.areaId" value="${build.areaId}"/>
				<input type="hidden" name="contractManager.buildId" value="${build.id}"/>
				</td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show">


                <td style="width:15%" align="right"><font color="#FF0000">*</font>合同编号&nbsp;</td>
                <td >
                    <input type="text" id="contractNo" name="contractManager.contractNo" style="width:100px" class="searchbox"/>
                </td>

                <td style="width:15%" align="right">合同类型&nbsp;</td>
                <td style="width:30%">
					<s:select id="managerType" name="contractManager.managerType" list="selManagerType" theme="simple" cssClass="easyui-combobox" ></s:select>
				</td>
            </tr>
			
			<tr bgcolor="#FFFFFF" style="empty-cells:show">

                <td style="width:15%" align="right">合同名称&nbsp;</td>
                <td >
                    <input type="text" id="managerName" name="contractManager.managerName" style="width:200px" class="searchbox"/>
                </td>

                <td style="width:15%" align="right">发展商名称&nbsp;</td>
                <td style="width:30%">
                    <input type="text" id="developerName" name="contractManager.developerName" style="width:200px"  class="searchbox" value=""/>
                </td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show">

                <td style="width:15%" align="right"><font color="#FF0000">*</font>签约日期&nbsp;</td>
                <td>
                    <input class="easyui-datebox" type="text" style="width:90px" id="startDate" name="contractManager.startDate" />
                    终止日期&nbsp; <input class="easyui-datebox" type="text" style="width:90px" id="endDate" name="contractManager.endDate" />
                </td>

                <td style="width:15%" align="right">正式开售日期&nbsp;</td>
                <td style="width:30%">
                    <input class="easyui-datebox" type="text" style="width:90px" id="saleDate" name="contractManager.saleDate" />
                </td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show">
                <td style="width:15%" align="right">结算条件&nbsp;</td>
                <td colspan="3">
                    <s:radio name="contractManager.contractType" list="selContractType" theme="simple"></s:radio>
                    备注<input type="text" id="contractMemo" name="contractManager.contractMemo" style="width:350px" class="searchbox"/>
                </td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show">

                <td style="width:15%" align="right" rowspan="2">前期月费&nbsp;</td>
                <td colspan="3">
                    收取日期&nbsp;<input type="text" id="feeDate" name="contractManager.feeDate" class="easyui-datebox"  style="width:90px"/>&nbsp;&nbsp;
                    每月收取<input type="text" id="feeMonthly" name="contractManager.feeMonthly" style="width:50px" class="easyui-numberbox"/>万
                    总计<input type="text" id="feeTotal" name="contractManager.feeTotal" style="width:50px" class="easyui-numberbox"/>月
                    (共<span id="feeMoneyTotal">0</span>万)
                </td>
            </tr>


            <tr bgcolor="#FFFFFF">
                <td colspan="3">                   
                    备注  <input type="text" id="feeMemo" name="contractManager.feeMemo" style="width:350px" class="searchbox"/>
                </td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show;">

                <td style="width:15%" align="right">回款类型&nbsp;</td>
                <td colspan="3">
                    <s:radio name="contractManager.refundType" list="selRefundType" theme="simple"></s:radio>
                    <input type="text" style="width:50px;" id="partTextId" name="contractManager.refundPercent" class="searchbox"/>
                    备注 <input type="text" style="width:250px;" id="refundMemo" name="contractManager.refundMemo" class="searchbox"/>
				</td>

            </tr>
            <tr bgcolor="#FFFFFF" style="empty-cells:show;">

                <td style="width:15%" align="right">合同备注&nbsp;</td>
                <td colspan="3">
                     <input type="text" style="width:350px;" id="remark" name="contractManager.remark" class="searchbox"/>
                </td>

            </tr>


            <tr class="contract_tr_des">

                <td style="width:15%" align="right">计佣条件&nbsp;</td>
                <td colspan="3">以下条件将影响计佣报表,请准确填写</td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show;">

                <td style="width:15%" align="right">溢价设置&nbsp;</td>
                <td>
                    <s:radio name="contractManager.premiumType" list="selPriceType" theme="simple"></s:radio>
                    &nbsp;分成比例&nbsp;<input type="text" id="premiumPercent" name="contractManager.premiumPercent" style="width:50px"  class="searchbox"/>%
                </td>
                <td style="width:15%" align="right">挞定分成&nbsp;</td>
                <td style="width:30%">
					<!--				
                    甲方<input type="text" id="tartsetPartya" name="contractManager.tartsetPartya" style="width:30px"/>% &nbsp;
                    乙方<input type="text" id="tartsetPartyb" name="contractManager.tartsetPartyb" style="width:30px"/>%
					-->
					甲方<input type="text" id="tartsetPartya" class="easyui-numberspinner" min="0" max="100" name="contractManager.tartsetPartya" style="width:40px"/>% &nbsp;
                    乙方<input type="text" id="tartsetPartyb" class="easyui-numberspinner" min="0" max="100" name="contractManager.tartsetPartyb" style="width:40px"/>%
                </td>
            </tr>

			<tr bgcolor="#FFFFFF" style="empty-cells:show;">


                <td style="width:15%" align="right">可售建筑面积&nbsp;</td>
                <td>
                   <input type="text" id="saleBuildArea" name="contractManager.saleBuildArea" style="width:70px" class="searchbox"/>㎡

                </td>
                <td style="width:15%" align="right">可售货量&nbsp;</td>
                <td style="width:30%">
					<input type="text" id="saleCargoCount" name="contractManager.saleCargoCount" style="width:50px" class="searchbox"/>套
                </td>
            </tr>

            <tr class="contract_tr_des">

                <td style="width:15%" align="right">佣金规则&nbsp;</td>
                <td colspan="3"></td>
            </tr>

            <tr bgcolor="#FFFFFF">

                <td style="width:16%" align="right"><font color="#FF0000">*</font>默认佣金点数&nbsp;</td>
                <td >
                    <input type="text" id="defaultCommission" name="contractManager.defaultCommission" style="width:50px" class="searchbox"/>%
                </td>
				
                <td style="width:15%" align="right">关系户佣金&nbsp;</td>
                <td style="width:30%">
					<input type="text" id="relationCommission" name="contractManager.relationCommission" style="width:50px" class="searchbox"/>%
                    或金额 <input type="text" id="relationMoney" name="contractManager.relationMoney" style="width:50px" class="searchbox"/>元
				</td>
            </tr>

            <tr bgcolor="#FFFFFF">
                <td style="width:15%" align="right">&nbsp;</td>
                <td colspan="3" height="30">
                    <!--
                    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" id="add" onClick="barRule(0)">添加跳BAR规则</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" id="show" onClick="modifyBarRule()">查看/编辑</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" id="delete" onClick="deleteBarRule()">删除</a>				
                    -->
                    
                     <a href="javascript:void(0)" id="add" onClick="barRule(0)">添加跳BAR规则</a>
					<a href="javascript:void(0)" id="show" onclick="modifyBarRule()">查看/编辑</a>
					<a href="javascript:void(0)" id="delete" onClick="deleteBarRule()">删除</a>
                    
                </td>
            </tr>
            <tr bgcolor="#FFFFFF" style="height:auto">
                <td style="width:15%" align="right">跳BAR规则&nbsp;</td>
                <td colspan="3">
				
				<table id="viewbar_table" style="width:100%; height:100%">
				
					<thead>
						<tr>
							<!--
							<th field="modify" width="40">操作</th>
							-->
							<th field="id" hidden="true"></th>
							<th field="name" hidden="true"></th>
                            <th field="startDate">开始时间</th>
                            <th field="endDate">结束时间</th>
                            <th field="rate">面积销售率(%)</th>
							<th field="contractRate">面积签约率(%)</th>
                            <th field="suitRate">套数销售率(%)</th>
							<th field="suitContractRate">套数签约率(%)</th>
                            <th field="suit">销售套数(套)</th>
                            <th field="money">销售金额(万元)</th>
                            <th field="area">销售面积(㎡)</th>
							<th field="price">销售均价(元/㎡)</th>							
                            <th field="commission">佣金点数(%)</th>
                            <th field="memo">描述</th>
							
						</tr>
												
					</thead>
				</table>
					
                </td>
            </tr>



        </table>

    </form>

</div>

</body>
</html>