<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
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
<title></title>
<s:include value="../../header/header_easyui.jsp"></s:include>
<s:include value="coder_header.jsp"></s:include>
</head>

<body  style="padding:10px;">
<b>下载数据说明：</b>
<br/>
ReportUtils.java里面有两个方法：<br/>
1,用excel模板的方式下载推荐使用;<br/>
2,拼凑html字符串，进行下载;(适合简单的报表格式)
<br/>

<p></p>
<b>参考：</b><br/>

<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b><br/>
<textarea rows="40" cols="150">
1,配置文件：

		<action name="download" class="com.ihk.saleunit.action.contract_customer.SearchAction" method="download"/>
		
2，action代码：		
	/**
	 * 下载数据cond.startLine = -1;表示查找所有
	 * @return
	 * @throws Exception
	 */
	public String download() throws Exception{
		
		if(contractCustomerCond == null){
			
			contractCustomerCond = new ContractCustomerCond();
		}
		
		if("2".equals(contractCustomerCond.getConfirmType())){
			
			contractCustomerCond.setConfirmTypeName("contract");
			contractCustomerCond.setAgreeNoName("contract_no");
			
		}else{
			
			contractCustomerCond.setConfirmTypeName("confirm");
			contractCustomerCond.setAgreeNoName("agree_no");
		}
		
		List<Integer> buildIds = ContractCustomerUtils.getBuildIdsByRequest(request);
		contractCustomerCond.setBuildIds(buildIds);
		
		contractCustomerCond.startLine = -1; //查找所有
		
		List<ContractCustConfirm> cusList = contractCustomerServices.findcontractCustAndConfirm(contractCustomerCond);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("cusList", cusList);
		
		//ReportUtils.downLoadReport(sb.toString(), "成交客户", response);
		ReportUtils.downLoadReport(map, "contract-customer.xls", "成交客户.xls", response);
		
		return null;
	}
	
3,jsp写法：
layout.jsp
		window.location.href = "./saleunit_new/contract/customer/download.action?" + queryParams;	
</textarea>
<br/>

</body>

</html>

