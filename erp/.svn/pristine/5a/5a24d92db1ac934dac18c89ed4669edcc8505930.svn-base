<%@ page contentType="text/html; charset=utf-8" %>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@page import="com.ihk.permission.PermissionUtils"%>
<%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_STAT,EnumDevFlag.GUANGZHOU) ){%>
 <li data-options="state:'closed',iconCls:'icon-reportsearch'">
	<span>售前客户报表</span>
	<ul>
		<li>
			<span>数量分析</span>
			<ul>
				<li><span><a href="#" onclick="return showRightTable('customerNumCompareCompany','客户数量对比(公司)');">客户数量对比(公司)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerNumCompareProject','客户数量对比(项目)');">客户数量对比(项目)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerNumCompareSales','客户数量对比(销售)');">客户数量对比(销售)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerNumCompany','客户数量环比图(公司)');">客户数量环比图(公司)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerNum','客户数量环比图(项目)');">客户数量环比图(项目)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerNumSales','客户数量环比图(销售)');">客户数量环比图(销售)</a></span></li>
				<!-- <li><span><a href="#" onclick="return showRightTableFirst('projectAndCustNum','项目客户数量对比');">项目客户数量对比</a></span></li> -->
			</ul>
		</li>
		<li>
			<span>问卷分析</span>
			<ul>
				<li><span><a href="#" onclick="return showRightTable('customerQuestionCompany','客户问卷分类(公司)');">客户问卷分类(公司)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerQuestionProject','客户问卷分类(项目)');">客户问卷分类(项目)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerQuestionSales','客户问卷分类(销售)');">客户问卷分类(销售)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerTable','客户分类明细表(项目)');">客户分类明细表(项目)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerPie','客户分类比例(项目)');">客户分类比例(项目)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('categoryNum','分类环比走势图(项目)');">分类环比走势图(项目)</a></span></li>
				<li><span><a href="#" onclick="return showRightTableFirst('customerDoublePie','交叉分析组合图');">交叉分析组合图</a></span></li>
				<%--<li><span><a href="#" onclick="return showRightTable('sqkhtjReport','售前客户来源统计');"> 售前客户来源统计</a></span></li>--%>
				<li><span><a href="#" onclick="return showRightTable('sqkhflReport','售前客户分类统计');">售前客户分类统计</a></span></li>
				<!--  <li><span><a href="#" onclick="return showRightTable('khzhlfxReport','客户转化率分析报表');">客户转化率分析报表</a></span></li>-->
			</ul>
		</li>
		<li>
			<span>跟进情况</span>
			<ul>
				<li><span><a href="#" onclick="return showRightTable('customerQuery','活跃客户筛选报表');">活跃客户筛选报表</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('customerFollowCompany','客户跟进情况(公司)');">客户跟进情况(公司)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('xmgjqkReport','客户跟进情况(项目)');">客户跟进情况(项目)</a></span></li>
				<li><span><a href="#" onclick="return showRightTable('xsgjqkReport','客户跟进情况(销售)');">客户跟进情况(销售)</a></span></li>
			</ul>
		</li>
		<li>
			<span>录入质量分析</span>
			<ul>
				<li><span><a href="#" onclick="return showRightTable('redAnalysis','客户质量分析');">客户质量分析</a></span></li>
			</ul>
		</li>
		
		

	</ul>
</li>	
<%} %>		
             