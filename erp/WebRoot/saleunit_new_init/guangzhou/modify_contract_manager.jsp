<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<head>

    <base href="<%=basePath%>">

    <style type="text/css">
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

    <script type="text/javascript" language="javascript">

		$(function(){
		
			$.ed('#tartsetPartya').numberspinner({				
				onChange:function(newValue,oldValue){
					$.ed('#tartsetPartyb').numberspinner('setValue', 100-newValue);	
				}
			});
			
			$.ed('#tartsetPartyb').numberspinner({				
				onChange:function(newValue,oldValue){
					$.ed('#tartsetPartya').numberspinner('setValue', 100-newValue);	
				}
			});
			
			$.ed('#feeMonthly').numberbox({
				onChange:function(newValue,oldValue){
					
					var total = $.ed('#feeTotal').numberbox('getValue');
					if(total != ''){
						$.ed('#feeMoneyTotal').text(newValue * total);
					}
				}
			});
			
			$.ed('#feeTotal').numberbox({
				onChange:function(newValue,oldValue){
					
					var monthly = $.ed('#feeMonthly').numberbox('getValue');
					if(monthly != ''){
						$.ed('#feeMoneyTotal').text(newValue * monthly);
					}
				}
			});
			
		});
		
    </script>

</head>

<body>
<div class="gbox1">

    <form action="./saleunit_new_init/appoint/guangzhou/updateContractManager.action" method="post" id="contractManagerFormId">

        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px;">

            <tr style="empty-cells:show; background-color:#f1f9fe;height:35px;">

                <td style="width:15%" align="right">代理合同信息&nbsp;</td>
                <td colspan="3">
				${showName}
				<input type="hidden" name="contractManager.propertyId" value="${contractManager.propertyId}"/>
				<input type="hidden" name="contractManager.areaId" value="${contractManager.areaId}"/>
				<input type="hidden" name="contractManager.buildId" value="${contractManager.buildId}"/>
				<input type="hidden" name="contractManager.id" value="${contractManager.id}" />
				<input type="hidden" name="contractManager.status" value="${contractManager.status}" />
				</td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show">


                <td style="width:15%" align="right"><font color="#FF0000">*</font>合同编号&nbsp;</td>
                <td >
                    <input type="text" id="contractNo" name="contractManager.contractNo" value="${contractManager.contractNo}" style="width:100px" class="searchbox"/>
                </td>

                <td style="width:15%" align="right">合同类型&nbsp;</td>
                <td style="width:30%">
					<s:select id="managerType" name="contractManager.managerType" list="selManagerType" theme="simple" cssClass="easyui-combobox"></s:select>
				</td>
            </tr>
			
			<tr bgcolor="#FFFFFF" style="empty-cells:show">

                <td style="width:15%" align="right">合同名称&nbsp;</td>
                <td >
					<input type="text" id="managerName" name="contractManager.managerName" value="${contractManager.managerName}" style="width:200px" class="searchbox"/>
                </td>

                <td style="width:15%" align="right">发展商名称&nbsp;</td>
                <td style="width:30%">
                    <input type="text" id="developerName" name="contractManager.developerName" value="${contractManager.developerName}" style="width:200px" class="searchbox"/>
                </td>
            </tr>

            <tr bgcolor="#FFFFFF" style="empty-cells:show">


                <td style="width:15%" align="right"><font color="#FF0000">*</font>签约日期&nbsp;</td>
                <td>
                    <input class="easyui-datebox" type="text" style="width:90px" id="startDate" name="contractManager.startDate" 
					value='<s:date name="#request.contractManager.startDate" format="yyyy-MM-dd"/>'/>
                    终止日期&nbsp;
                    <input class="easyui-datebox" type="text" style="width:90px" id="endDate" name="contractManager.endDate"
                           value='<s:date name="#request.contractManager.endDate" format="yyyy-MM-dd"/>'/>
                </td>

                <td style="width:15%" align="right">正式开售日期&nbsp;</td>
                <td style="width:30%">
                    <input class="easyui-datebox" type="text" style="width:90px" id="saleDate" name="contractManager.saleDate"
                           value='<s:date name="#request.contractManager.saleDate" format="yyyy-MM-dd"/>'/>
                </td>
            </tr>
			
			 <tr bgcolor="#FFFFFF" style="empty-cells:show;">
                <td style="width:15%" align="right">结算条件&nbsp;</td>
                <td colspan="3 ">
                    <s:radio name="contractManager.contractType" list="selContractType" theme="simple"></s:radio>
                    备注 <input type="text" id="contract_memo" name="contractManager.contractMemo" style="width:350px" value="${contractManager.contractMemo}" class="searchbox"/>
                </td>
            </tr>
			
			 <tr bgcolor="#FFFFFF">

                <td style="width:15%" align="right" rowspan="2">前期月费&nbsp;</td>
                <td colspan="3">
                    收取日期&nbsp;<input type="text" id="feeDate" name="contractManager.feeDate" class="easyui-datebox"  style="width:90px" 
					value='<s:date name="#request.contractManager.feeDate" format="yyyy-MM-dd"/>'/>&nbsp;&nbsp;
                    每月收取<input type="text" id="feeMonthly" name="contractManager.feeMonthly" value="${contractManager.feeMonthly}" style="width:50px"/>万
                    总计<input type="text" id="feeTotal" name="contractManager.feeTotal" value="${contractManager.feeTotal}" style="width:50px"/>月  
					(共<span id="feeMoneyTotal">${contractManager.feeMonthly * contractManager.feeTotal}</span>万)                  
                </td>
            </tr>
			
			
			 <tr bgcolor="#FFFFFF">
                <td colspan="3">                   
                    备注<input type="text" id="feeMemo" name="contractManager.feeMemo" value="${contractManager.feeMemo}" style="width:350px" class="searchbox"/>
                </td>
            </tr>
			
			 <tr bgcolor="#FFFFFF" style="empty-cells:show;">


                <td style="width:15%" align="right">回款类型&nbsp;</td>
                <td colspan="3">
                    <s:radio name="contractManager.refundType" list="selRefundType" theme="simple"></s:radio>
                    <input type="text" style="width:50px;" id="partTextId" name="contractManager.refundPercent" value="${contractManager.refundPercent}" />
                    <label id="partTextLabelId" for="partTextId">%</label>

                    备注 <input type="text" style="width:250px;" id="refundMemo" name="contractManager.refundMemo"  value="${contractManager.refundMemo}"  class="searchbox"/>

                </td>

            </tr>
            <tr bgcolor="#FFFFFF" style="empty-cells:show;">

                <td style="width:15%" align="right">合同备注&nbsp;</td>
                <td colspan="3">
                    <input type="text" style="width:350px;" id="remark" name="contractManager.remark"  value="${contractManager.remark}" class="searchbox"/>
                </td>

            </tr>

            <tr style="empty-cells:show; background-color:#f1f9fe;height:35px;">

                <td style="width:15%" align="right">计佣条件&nbsp;</td>
                <td colspan="3">以下条件将影响计佣报表,请准确填写</td>
            </tr>

           

            <tr bgcolor="#FFFFFF" style="empty-cells:show;">


                <td style="width:15%" align="right">溢价设置&nbsp;</td>
                <td>					
					<s:radio name="contractManager.premiumType" list="selPriceType" theme="simple"></s:radio>
                    &nbsp;分成比例&nbsp;<input type="text" id="premiumPercent" name="contractManager.premiumPercent" value="${contractManager.premiumPercent}" style="width:50px" />%
                </td>
                <td style="width:15%" align="right">挞定分成&nbsp;</td>
                <td style="width:30%">
					<!--				
               		甲方<input type="text" id="tartsetPartya" name="contractManager.tartsetPartya" value="${contractManager.tartsetPartya}" style="width:30px"/>% &nbsp;
                    乙方<input type="text" id="tartsetPartyb" name="contractManager.tartsetPartyb" value="${contractManager.tartsetPartyb}"  style="width:30px"/>%
					-->
					甲方<input type="text" id="tartsetPartya" class="easyui-numberspinner" min="0" max="100" name="contractManager.tartsetPartya"
						 value="${contractManager.tartsetPartya}" style="width:40px"/>% &nbsp;
                    乙方<input type="text" id="tartsetPartyb" class="easyui-numberspinner" min="0" max="100" name="contractManager.tartsetPartyb"
						 value="${contractManager.tartsetPartyb}" style="width:40px"/>%
                </td>
            </tr>
			
			<tr bgcolor="#FFFFFF" style="empty-cells:show;">


                <td style="width:15%" align="right">可售建筑面积&nbsp;</td>
                <td>
                   <input type="text" id="saleBuildArea" name="contractManager.saleBuildArea" style="width:70px" value="${contractManager.saleBuildArea}" class="searchbox"/>㎡

                </td>
                <td style="width:15%" align="right">可售货量&nbsp;</td>
                <td style="width:30%">
					<input type="text" id="saleCargoCount" name="contractManager.saleCargoCount" style="width:50px" value="${contractManager.saleCargoCount}" class="searchbox"/>套
                </td>
            </tr>


            <tr style="empty-cells:show; background-color:#f1f9fe;height:35px;">

                <td style="width:15%" align="right">佣金规则&nbsp;</td>
                <td colspan="3"></td>
            </tr>

            <tr bgcolor="#FFFFFF">

                <td style="width:15%" align="right"><font color="#FF0000">*</font>默认佣金点数&nbsp;</td>
                <td>
                    <input type="text" id="defaultCommission" name="contractManager.defaultCommission" value="${contractManager.defaultCommission}" style="width:50px" class="easyui-searchbox"/>%
                </td>
				 <td style="width:15%" align="right">关系户佣金&nbsp;</td>
                <td style="width:30%">
					<input type="text" id="relationCommission" name="contractManager.relationCommission" value="${contractManager.relationCommission}" style="width:50px" class="easyui-searchbox"/>%
                    或金额 <input type="text" id="relationMoney" name="contractManager.relationMoney"  value="${contractManager.relationMoney}" style="width:50px" class="searchbox"/>元
				</td>
				
            </tr>

            <tr bgcolor="#FFFFFF">
                <td style="width:15%" align="right">&nbsp;</td>
                <td colspan="3" height="30">
                    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',disabled:${isShow}" onClick="barRule(${contractManager.id})">添加跳BAR规则</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',disabled:${isShow}" onClick="modifyBarRule()">查看/编辑</a>
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',disabled:${isShow}" onClick="deleteBarRule()">删除</a>				
                </td>
            </tr>
            <tr bgcolor="#FFFFFF">
                <td style="width:15%" align="right">跳BAR规则&nbsp;</td>
                <td colspan="3">
				
				<table id="viewbar_table" class="easyui-datagrid" data-options="fitColumns:true,singleSelect:true,loadMsg:'加载中...',
					url:'./saleunit_new_init/appoint/guangzhou/getBarRuleListByManagerId.action?id=${contractManager.id}'">
				
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