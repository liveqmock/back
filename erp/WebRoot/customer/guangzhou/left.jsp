<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@page import="com.ihk.utils.SessionUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@ page import="com.ihk.utils.CacheUtils"%>
<%@ page import="com.ihk.user.data.pojo.Role;"%>
<table>
<tr>
			<td width="213" valign="top">
				
				<s:if test="#session.leftDisplay == 0">
					<div class="leftnav" style="display:none">
				</s:if>
				<s:else>
					<div class="leftnav" style="display:block">
				</s:else>
				
					<div class="lefttop"></div>
					
					
					
					<div class="leftbg">
					
					
						<div id="uldiv1" class="leftlist1">
							<div class="leftl"></div>
							<div id="uldiv1" class="leftm" align="left">
								<b>客户管理</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="<%=request.getContextPath()%>/customer_guangzhou/input/forAdd.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">新建客户</a>
								
						</div>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="<%=request.getContextPath()%>/customer_guangzhou/search/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">查询客户</a>
								
						</div>		
						
					
					
						
						
						<%if(PermissionUtils.isHaveThisRole(19) ){//是否具有销控中心角色%>
						<div id="uldiv1" class="leftlist1">
							<div class="leftl"></div>
							<div id="uldiv1" class="leftm" align="left">
								<b>交易管理</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>
									<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_RETRIEVE,EnumDevFlag.GUANGZHOU) ){//节点权限验证 楼盘初始%>
									<div id="lidiv1" class="leftms" >
										&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<img alt=">" src="images/liimg.gif">
										<a class="ablue" style="color:#1199FF" id="_layout_1"
												href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=1&ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">楼盘初始</a>
											
									</div>	
								  <%} //节点权限验证 楼盘初始 end%>
								  
								  <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_GROUP_RETRIEVE,EnumDevFlag.GUANGZHOU) ){//节点权限验证-组团管理%>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
							<a class="ablue" style="color:#1199FF" id="_layout_2"
									href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=4&ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">组团管理</a>
								 <%} //节点权限验证-组团管理 end%>
						</div>	
						
								<%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CHIP_RETRIEVE,EnumDevFlag.GUANGZHOU) ){//节点权限验证-认筹中心%>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
							<a class="ablue" style="color:#1199FF" id="_layout_2"
									href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=5&ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">认筹中心</a>
								
						</div>	
							 <%} //节点权限验证-认筹中心 end%>
							 
							 <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){//节点权限验证-销控中心%>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
							<a class="ablue" style="color:#1199FF" id="_layout_2"
									href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=2&ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">销控中心</a>
								
						</div>	
							 <%} //节点权限验证-销控中心 end%>
						
						
						<%--<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
							<a class="ablue" style="color:#1199FF" id="_layout_2"
									href="./saleunit_setup/manager/layout.action?type=2&ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">设置管理</a>
								
						</div>	
		 --%>
						
		

					
							<%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_FINANCIAL_STAT,EnumDevFlag.GUANGZHOU) ){//节点权限验证-财务管理%>
						<div id="uldiv1" class="leftlist1">
							<div class="leftl"></div>
							<div id="uldiv1" class="leftm" align="left">
								<b>财务管理</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
							<a class="ablue" style="color:#1199FF" id="_layout_3"
								href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=3&ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">财务管理</a>
		
						</div>	
							 <%} //节点权限验证-财务管理 end%>
							
							<%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_STAT,EnumDevFlag.GUANGZHOU) ){//节点权限验证-报表管理%>
						<div id="uldiv1" class="leftlist1">
							<div class="leftl"></div>
							<div id="uldiv1" class="leftm" align="left">
								<b>报表分析</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
							<a class="ablue" style="color:#1199FF" id="_layout_3"
								href="./saleunit_new/appoint/guangzhou/saleUnitInitSelect.action?type=6&ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">综合报表</a>
		
						</div>	
							 <%} //节点权限验证-报表管理 end%>
						
						
						
						 <%}//是否具有销控中心角色end %>
						 
						 
						 
						
						<%
					if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_PRECUSTOMER_DOWNLOAD, EnumDevFlag.GUANGZHOU)){
					%>
						<div id="uldiv1" class="leftlist1">
							<div class="leftl"></div>
							<div id="uldiv1" class="leftm" align="left">
								<b>项目分析</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./customer_guangzhou/chart/projectAndCustNum.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">项目客户比例</a>
								
						</div>
						
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./customer_guangzhou/analysis/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">客户录入分析</a>
								
						</div>
						<%
							}
						%>
						
						
							<%
						if(PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_CREATE, EnumDevFlag.GUANGZHOU) 
								|| PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_NOTICE_CREATE, EnumDevFlag.GUANGZHOU) 
								||SessionUser.getUserId() == 2 ){
						%>
						<div id="uldiv1" class="leftlist1">
							<div class="leftl"></div>
							<div id="uldiv1" class="leftm" align="left">
								<b>后台管理</b>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>
						
						<%if(SessionUser.getUserId() == 2 ){%>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./customer_guangzhou/customer_red/list.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">调查表标红</a>
								
						</div>						
						<%}%>
						
						<%if(PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_NOTICE_CREATE, EnumDevFlag.GUANGZHOU) 
								||SessionUser.getUserId() == 2 
								){%>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./customer_guangzhou/article/search.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">公告管理</a>
							
						</div>	
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./guangzhou/project/search.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">项目管理</a>
							
						</div>			
						<%}%>
						
						<%if(SessionUser.getUserId() == 2 ){%>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./guangzhou/userAccount/search.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">用户管理</a>
							
						</div>
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./property/oper/project_unit_index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">项目登录情况</a>
							
						</div>
						
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<img alt=">" src="images/liimg.gif">
									<a class="ablue" style="color: #1199FF;" href="./customer_guangzhou/cache/cacheIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>" target="_self">缓存管理</a>
							
						</div>	
						
						<!--
						<div id="lidiv1" class="leftms" >
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<img alt=">" src="images/liimg.gif">
							<a class="ablue" style="color: #1199FF;" href="./customer/phone_from/to.action" target="_self">设置号码归属地</a>
							
						</div>	
						-->
							<%}%>
							
						
						<%}%>
						
					<div class="leftbottom"></div>
				</div>
			</td>

			<td width="9" valign="middle">
					<img src="./images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩"/>
			</td>

</tr></table>