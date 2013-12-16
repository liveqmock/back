<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询付款单</title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
<script type="text/javascript">
	$(document).ready(function(){	
		//做一些初始化，或者是提交之后显示提示的事情
	})

    //页面提交
	function submitSearch() {	
		$("#queryForm").submit();	
	}	
</script>
</head>
<body style="padding:0px;">
	<div class="right99"></div>	
		<table width="100%" border="0" align="left" cellspacing="0" id="queryTable">
			<tr>
				<td colspan="6">
		        <form class="queryForm" id="queryForm" method="post">
				<!--查询框-->
				<%--
					<span>主单id</span><input type="text" style="width:90px" id="searchPayBillCond_mainId"  name="searchPayBillCond.mainId" value="${searchPayBillCond.mainId}" /> 
					<span>开盘日期</span><input type="text" style="width:90px" id="searchPayBillCond_startSaleDate"  name="searchPayBillCond.startSaleDate" value="${searchPayBillCond.startSaleDate}" /> 
					<span>单据类型</span><input type="text" style="width:90px" id="searchPayBillCond_billType"  name="searchPayBillCond.billType" value="${searchPayBillCond.billType}" /> 
					<span>票据类型</span><input type="text" style="width:90px" id="searchPayBillCond_paperType"  name="searchPayBillCond.paperType" value="${searchPayBillCond.paperType}" /> 
					<span>票据编号</span><input type="text" style="width:90px" id="searchPayBillCond_billNo"  name="searchPayBillCond.billNo" value="${searchPayBillCond.billNo}" /> 
					<span>金额</span><input type="text" style="width:90px" id="searchPayBillCond_payMoney"  name="searchPayBillCond.payMoney" value="${searchPayBillCond.payMoney}" /> 
					<span>交款人</span><input type="text" style="width:90px" id="searchPayBillCond_payMan"  name="searchPayBillCond.payMan" value="${searchPayBillCond.payMan}" /> 
					<span>开票人id</span><input type="text" style="width:90px" id="searchPayBillCond_writerId"  name="searchPayBillCond.writerId" value="${searchPayBillCond.writerId}" /> 
					<span>审核日期</span><input type="text" style="width:90px" id="searchPayBillCond_approvalDate"  name="searchPayBillCond.approvalDate" value="${searchPayBillCond.approvalDate}" /> 
					<span>状态</span><input type="text" style="width:90px" id="searchPayBillCond_state"  name="searchPayBillCond.state" value="${searchPayBillCond.state}" /> 
					<span>备注</span><input type="text" style="width:90px" id="searchPayBillCond_remark"  name="searchPayBillCond.remark" value="${searchPayBillCond.remark}" /> 
                 --%>
					&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询 " />
					<input type="button" onclick="return openDivCreatePayBill()" value=" 新建付款单 " />	
					<div class="right99"></div>
					<div class="blueline"></div>					
			    </form>
				</td>
			</tr>
			<tr>
				<td colspan="6">
					<div class="gbox1">
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" 
							style="text-align: center;font-size:12px; line-height:26px; white-space:normal">						
							<tr class="gboxbg">
                                    <th>认购或合同</th>
                                    <th>主单id</th>
                                    <th>开盘日期</th>
                                    <th>单据类型</th>
                                    <th>票据类型</th>
                                    <th>票据编号</th>
                                    <th>金额</th>
                                    <th>交款人</th>
                                    <th>开票人id</th>
                                    <th>审核日期</th>
                                    <th>状态</th>
                                    <th>备注</th>
                                    <th>是否删除</th>
                                    <th>创建人</th>
                                    <th>创建时间</th>
                                    <th>修改人</th>
                                    <th>修改时间</th>
							</tr>							
   						<s:iterator value="searchListPayBill" id="c">   						
						  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
						   <td><a href="javascript:;" style="color:#5482de;" onclick="return openDivEditPayBill('<s:property value="id"/>');"><s:property value="id"/></a></td>
                        
                            <td><s:property value="mainId"/></td>
                            <td><s:property value="startSaleDate"/></td>
                            <td><s:property value="billType"/></td>
                            <td><s:property value="paperType"/></td>
                            <td><s:property value="billNo"/></td>
                            <td><s:property value="payMoney"/></td>
                            <td><s:property value="payMan"/></td>
                            <td><s:property value="writerId"/></td>
                            <td><s:property value="approvalDate"/></td>
                            <td><s:property value="state"/></td>
                            <td><s:property value="remark"/></td>
                            <td><s:property value="isDeleted"/></td>
                            <td><s:property value="createdId"/></td>
                            <td><s:property value="createdTime"/></td>
                            <td><s:property value="modId"/></td>
                            <td><s:property value="modTime"/></td>
						   </tr>
   						</s:iterator>  
						</table>
					</div></td>
			</tr>			
			 <tr>
              <td colspan="6">
                <div class="manu">
					<s:property value="showPage" escape="false"/>
				</div>                
				</td>
            </tr>			
		</table>	
    <!--弹出新建的div-->
	<s:include value="div_create_paybill.jsp"/>
    
    <!--弹出修改的div-->
	<s:include value="div_edit_paybill.jsp"/>
    
</body>
</html>


