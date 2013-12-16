<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

    <title>设置跳bar规则</title>

    <s:include value="../../customer/guangzhou/header_min.jsp"></s:include>

    <script type="text/javascript" language="javascript" src="./js/jquery.easyui.min.js"></script>
    <script type="text/javascript" language="javascript" src="./css/local/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>
    <link href="./css/easyui.css" rel="stylesheet" type="text/css" charset="utf-8"/>
    <link href="./css/icon.css" rel="stylesheet" type="text/css" charset="utf-8"/>

    <style type="text/css">
        *{margin:0;padding:0;}
		table tr{background-color:#f1f9fe;}
		
    </style>

</head>

<body>

<div class="gbox1">

<form action="./saleunit_new_init/appoint/guangzhou/addBarRule.action" method="post" id="barRuleFormId">

<table id="bar_table" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="width:100%;height:auto; font-size:12px; line-height:30px">
    <tr>
        <th width="100px">描述</th>
        <td><input type="text" id="memo" style="width:80%" name="contractBarrules.memo"/></td>
    </tr>
    <tr>
        <th width="100px">开始时间</th>
        <td><input type="text" id="start_date" name="contractBarrules.startDate" class="easyui-datebox"  style="width:90px"/></td>
    </tr>
    <tr>
        <th width="100px">结束时间</th>
        <td><input type="text" id="end_date" name="contractBarrules.endDate" class="easyui-datebox"  style="width:90px"/></td>
    </tr>
	
   	<tr title="面积销售率:委托期内所有已签订认购书的单元建筑面积总和÷委托期内可售单元建筑面积总和×100%">
        <th width="100px">面积销售率(%)</th>
        <td>
			<s:select list="selBarOpr" id="opr_f1" name="contractBarrules.oprF1"></s:select>		
            <input type="text" id="data_f1" name="contractBarrules.dataF1" style="width:50px"/>
            且           
			<s:select list="selBarOpr2" id="opr_b1" name="contractBarrules.oprB1"></s:select>
            <input type="text" id="data_b1" name="contractBarrules.dataB1" style="width:50px"/>
        </td>
    </tr>
	
	<tr title="面积签约率:委托期内所有已签订合同的单元建筑面积总和÷委托期内所有已签订认购书的单元建筑面积总和×100%">
        <th width="100px">面积签约率(%)</th>
        <td>
			<s:select list="selBarOpr" id="opr_f2" name="contractBarrules.oprF2"></s:select>		
            <input type="text" id="data_f2" name="contractBarrules.dataF2" style="width:50px"/>
            且           
			<s:select list="selBarOpr2" id="opr_b2" name="contractBarrules.oprB2"></s:select>
            <input type="text" id="data_b2" name="contractBarrules.dataB2" style="width:50px"/>
        </td>
    </tr>

    <tr title="套数销售率:委托期内所有已签订认购书的单元套数总和÷委托期内可售单元套数总和×100%">
        <th width="100px">套数销售率(%)</th>
        <td>
            <s:select list="selBarOpr" id="opr_f7" name="contractBarrules.oprF7"></s:select>
            <input type="text" id="data_f7" name="contractBarrules.dataF7" style="width:50px"/>
            且
            <s:select list="selBarOpr2" id="opr_b7" name="contractBarrules.oprB7"></s:select>
            <input type="text" id="data_b7" name="contractBarrules.dataB7" style="width:50px"/>
        </td>
    </tr>

    <tr title="套数签约率:委托期内所有已签订合同的单元套数总和÷委托期内所有已签订认购书的单元套数总和×100%">
        <th width="100px">套数签约率(%)</th>
        <td>
            <s:select list="selBarOpr" id="opr_f8" name="contractBarrules.oprF8"></s:select>
            <input type="text" id="data_f8" name="contractBarrules.dataF8" style="width:50px"/>
            且
            <s:select list="selBarOpr2" id="opr_b8" name="contractBarrules.oprB8"></s:select>
            <input type="text" id="data_b8" name="contractBarrules.dataB8" style="width:50px"/>
        </td>
    </tr>

    <tr title="销售套数:委托期内所有已签订认购书或合同的单元套数总和（以最新签订的为准）">
        <th width="100px">销售套数(套)</th>
        <td>
           <s:select list="selBarOpr" id="opr_f3" name="contractBarrules.oprF3"></s:select>		
            <input type="text" id="data_f3" name="contractBarrules.dataF3" style="width:50px"/>
            且           
			<s:select list="selBarOpr2" id="opr_b3" name="contractBarrules.oprB3"></s:select>
            <input type="text" id="data_b3" name="contractBarrules.dataB3" style="width:50px"/>
        </td>
    </tr>
	
   <tr title="销售金额:委托期内所有已签订认购书或合同的单元实收金额总和（以最新签订的为准）">
        <th width="100px">销售金额(万元)</th>
        <td>
            <s:select list="selBarOpr" id="opr_f4" name="contractBarrules.oprF4"></s:select>		
            <input type="text" id="data_f4" name="contractBarrules.dataF4" style="width:50px"/>
            且           
			<s:select list="selBarOpr2" id="opr_b4" name="contractBarrules.oprB4"></s:select>
            <input type="text" id="data_b4" name="contractBarrules.dataB4" style="width:50px"/>
        </td>
    </tr>
	
    <tr title="销售面积:委托期内所有已签订认购书或合同的单元建筑面积总和（以最新签订的为准）">
        <th width="100px">销售面积(㎡)</th>
        <td>
            <s:select list="selBarOpr" id="opr_f5" name="contractBarrules.oprF5"></s:select>		
            <input type="text" id="data_f5" name="contractBarrules.dataF5" style="width:50px"/>
            且           
			<s:select list="selBarOpr2" id="opr_b5" name="contractBarrules.oprB5"></s:select>
            <input type="text" id="data_b5" name="contractBarrules.dataB5" style="width:50px"/>
        </td>
    </tr>
	
	<tr title="销售均价:委托期内所有已签订合同的单元的成交金额总和÷委托期内所有已签订合同的单元建筑面积总和×100%">
        <th width="100px">销售均价(元/㎡)</th>
        <td>
            <s:select list="selBarOpr" id="opr_f6" name="contractBarrules.oprF6"></s:select>		
            <input type="text" id="data_f6" name="contractBarrules.dataF6" style="width:50px"/>
            且           
			<s:select list="selBarOpr2" id="opr_b6" name="contractBarrules.oprB6"></s:select>
            <input type="text" id="data_b6" name="contractBarrules.dataB6" style="width:50px"/>
        </td>
    </tr>
	
    <tr>
        <th width="100px">佣金点数(%)</th>
        <td>
        <input type="text" id="commission" style="width:50px" name="contractBarrules.commission"/>
        <input type="hidden" name="contractBarrules.contractManagerId" value="${managerId}" />
		</td>
    </tr>
</table>


</form>

</div>

</body>
</html>