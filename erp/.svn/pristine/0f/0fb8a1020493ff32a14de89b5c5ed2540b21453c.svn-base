<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@ page import="com.ihk.user.data.pojo.FuncTree"%>
<%
	String isshow = "";
	if (PermissionUtils.isMultiCompany()) {
		isshow = "isMultiCompany";
	} else if (PermissionUtils.isMultiProject()) {
		isshow = "isMultiProject";
	}
	request.getSession().setAttribute("isshow", isshow);
%>
<script type="text/javascript" language="javascript">
	$().ready(function() {
		
		$(".img").click(function() {
			$("#lefttable").toggle(150);
			$.ajax( {
				type : "get",
				url : "./sale_hengda!leftDisplay.action", //查询一些相关的数据
				dataType : "html"
			});
		});
	
		
		$("#uldiv1").click(function() {
			$("#lidiv1").toggle();
		});
		$("#uldiv2").click(function() {
			$("#lidiv2").toggle();
		});

		$("#uldiv3").click(function() {
			$("#lidiv3").toggle();
		});

		$("#uldiv4").click(function() {
			$("#lidiv4").toggle();
		});

		$("#uldiv5").click(function() {
			$("#lidiv5").toggle();
		});

		$("#uldiv6").click(function() {
			$("#lidiv6").toggle();
		});

	});
	<%--
	$(document).ready(function() {
		// 树型结构
			$("#browser").treeview();
		});
		--%>
</script>


<%-- body main --%>
<!--body main1-->
<div>
	<table border="0" align="left" cellspacing="0">
		<tr>

			<td valign="top" align="center">
				<div id="lefttable" class="leftnav" <s:if test="#session.leftDisplay == 0"> 
					style="display:none"
			  	</s:if> <s:if test="#session.leftDisplay == 1"> 
					style="display:block"
			  	</s:if>>

					<div class="lefttop"></div>
					<div class="leftbg">
						<%--
					<%if(PermissionUtils.getUserFuncTreeList() != null){
							for(FuncTree t : PermissionUtils.getUserFuncTreeList()){%>
						<div>
						  <div class="leftl"></div>
							<div class="leftm"><a href="<%=t.getActionUrl() %>" target="_self"><%=t.getTreeName()%> </a></div>
							<div class="leftr"></div>
							<div class="c"></div>	
							</div>
							
						<%}}%>
					 --%>

						<div id="uldiv1" class="leftlist">
							<div class="leftl"></div>
							<div id="uldiv1" class="leftm" align="left">
								<b>主页</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>

						<div id="lidiv1" class="leftms" style="margin-bottom: 0px; margin-top: 0px">
							<ul style="margin-bottom: 0px; margin-top: 0px">
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/index/for_sale.action" target="_self">主页</a>
								</li>
							</ul>
						</div>

						<div id="uldiv2" class="leftlist">
							<div class="leftl"></div>
							<div class="leftm" align="left">
								<b>录入数据</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>

						<div id="lidiv2" class="leftms" style="margin-bottom: 0px; margin-top: 0px">
							<ul style="margin-bottom: 0px; margin-top: 0px">
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/input/for_sale.action" target="_self">录入数据</a>
								</li>
							</ul>
						</div>

						<div id="uldiv3" class="leftlist">
							<div class="leftl"></div>
							<div class="leftm" align="left">
								<b>汇总数据</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>

						<div id="lidiv3" class="leftms" style="margin-bottom: 0px; margin-top: 0px">
							<ul style="margin-bottom: 0px; margin-top: 0px">
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/search/all.action?from=left" target="_self">汇总查询</a>
								</li>
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/search/sale.action?from=left" target="_self">明细查询</a>
								</li>
								
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/search/week.action?from=left" target="_self">本周累计</a>
								</li>
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/search/month.action?from=left" target="_self">本月累计</a>
								</li>
								<!--
								<li>
									<img alt=">" src="images/liimg.gif"><a class="ablue" href="./sale_hengda/search/year.action?from=left" target="_self" 
										onclick="javascript:alert('开发中...');return false">年累计</a>
								</li>
								-->
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/search/time.action?from=left" target="_self">时段累计</a>
								</li>

							</ul>
						</div>

						<div id="uldiv4" class="leftlist">
							<div class="leftl"></div>
							<div class="leftm" align="left">
								<b>曲线图</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>

						<div id="lidiv4" class="leftms" style="margin-bottom: 0px; margin-top: 0px">
							<ul style="margin-bottom: 0px; margin-top: 0px">
								<s:if test="#session.isshow ==  'isMultiCompany' ">
									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/chart/country.action?from=left" target="_self">全国曲线</a>
									</li>
									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/chart/company.action?from=left" target="_self">区域曲线</a>
									</li>
								</s:if>
								<s:if test="#session.isshow == 'isMultiProject' ">

									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/chart/company.action?from=left" target="_self">区域曲线</a>
									</li>
								</s:if>

								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/chart/project.action?from=left" target="_self">项目曲线</a>
								</li>

							</ul>
						</div>


						

						<s:if test="#session.isshow ==  'isMultiCompany' ">
						<div id="uldiv5" class="leftlist">
							<div class="leftl"></div>
							<div class="leftm" align="left">
								<b>客户管理</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>

						<div id="lidiv5" class="leftms" style="margin-bottom: 0px; margin-top: 0px">
							<ul style="margin-bottom: 0px; margin-top: 0px">

								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/customer/forCustomerInput.action" target="_self">新建客户</a>
								</li>
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/customer/index.action?from=left" target="_self">查询客户</a>
								</li>

								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/customer/all.action?from=left" target="_self">客户汇总</a>
								</li>
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/chart/customerNum.action?from=left" target="_self">客户数量环比图</a>
								</li>
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/chart/customerTable.action?from=left" target="_self">单项数据分析表</a>
								</li>
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/chart/customerPie.action?from=left" target="_self">单项比例分析图</a>
								</li>
								<li>
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" href="./sale_hengda/chart/categoryNum.action?from=left" target="_self">单项环比走势图</a>
								</li>


							</ul>
						</div>
						</s:if>
						
						<!-- 
						<div id="uldiv4" class="leftlist">
							<div class="leftl"></div>
							<div class="leftm" align="left">
								<b>项目分析</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>

						<div id="lidiv4" class="leftms" style="margin-bottom: 0px; margin-top: 0px">
							<ul style="margin-bottom: 0px; margin-top: 0px">
									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/chart/country.action?from=left" target="_self">项目客户比例</a>
									</li>
									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/chart/company.action?from=left" target="_self">客户录入分析</a>
									</li>
							</ul>
						</div>
						

						
						
							<div id="uldiv6" class="leftlist">
								<div class="leftl"></div>
								<div class="leftm" align="left">
									<b>其他</b>
								</div>
								<div class="leftr">
								</div>
								<div class="c"></div>
							</div>
							<div id="lidiv6" class="leftms" style="margin-bottom: 0px; margin-top: 0px">
								<ul style="margin-bottom: 0px; margin-top: 0px">
									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./article/input/for_article.action" target="_self">新增公告</a>
									</li>
									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/role_project/index.action" target="_self">权限管理</a>
									</li>

									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/userAccount/search.action" target="_self">用户管理</a>
									</li>
									
									<li>
										<img alt=">" src="images/liimg.gif">
										<a class="ablue" href="./sale_hengda/project/search.action" target="_self">项目管理</a>
									</li>
									
								</ul>
							</div>
						-->
					</div>
					<div class="leftbottom" style="width: 100%">
					</div>
				</div>
			</td>
			<td valign="top" width="0px">
				<div>
					<img src="images/tianluan/arrow01.gif" width="10" height="100" border="0" id="img" class="img" title="点击收缩" />
				</div>
			</td>
		</tr>
	</table>


</div>

