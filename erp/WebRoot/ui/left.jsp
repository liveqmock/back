<%@page import="com.ihk.constanttype.ContUserId"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@page import="com.ihk.permission.PermissionUtils"%>
<%@ page language="java" import="com.ihk.utils.CacheUtils" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%--width不能设为auto,否则会出现滚动条 --%>
<div class="easyui-accordion" data-options="fit:false,border:false" style="width:220px;overflow-y: hidden;">

    <%if(PermissionUtils.hasPermission(EnumPrivCode.MENU_PRECUSTOMER,EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN){%>
    <div title="售前客户管理" style="padding:10px;overflow:auto;" data-options="selected:true,iconCls:'icon-cust'" >
		
		<!--
        <ul  class="easyui-tree" data-options="animate:true,dnd:true">
		-->
		 <ul class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){
				$(this).tree('toggle', node.target);
			}">

             <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER__CREATE,EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN){%>
            <li><a href="javascript:void(0)" 
			onclick="return addTab('新建客户','<%=request.getContextPath()%>/customer_guangzhou/input/forAdd.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">新建客户</a></li>
             <%} %>
            <li><a href="#" onclick="return addTab('查询客户','<%=request.getContextPath()%>/customer_guangzhou/search/index.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">查询客户</a></li>
             <%if(PermissionUtils.hasPermission(EnumPrivCode.PRECUSTOMER_QUESTION,EnumDevFlag.GUANGZHOU) ){%>
			<li><a href="#" onclick="return addTab('售前客户问卷','./saleunit_new_init/appoint/guangzhou/customerBeforeTabForMainAjax.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">售前客户问卷</a></li>
			<%} %>
			
	<s:include value="left_precustomer_report.jsp"></s:include>
             
        </ul>
    </div>
    <%} %>
    
    <%if(PermissionUtils.hasPermission(EnumPrivCode.MENU_VIPCUSTOMER,EnumDevFlag.GUANGZHOU) ||SessionUser.getUserId() == ContUserId.ADMIN || SessionUser.getUserId() == 167 || SessionUser.getUserId() == 1330){//只开放给黄晓军和ADMIN,何静怡%>
    <div title="VIP客户管理" style="padding:10px;" data-options="iconCls:'icon-vipcust'">
    	<ul class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){$(this).tree('toggle', node.target);}">
    			 <li><a href="#" onclick="return addTab('vip客户导入','<%=request.getContextPath()%>/customer/collection/vip_information_data.action','')">vip客户导入</a></li>
            	 <li><a href="#" onclick="return addTab('vip客户数据分析','<%=request.getContextPath()%>/customer/collection/analysis_vip_customer.action','')">vip客户数据分析</a></li>
		 		 <li><a href="#" onclick="return addTab('vip客户管理','<%=request.getContextPath()%>/customer/collection/query_vip_customer.action','')">vip客户管理</a></li>
    	</ul>
    </div>
    <%} %>

    <%if(PermissionUtils.hasPermission(EnumPrivCode.MENU_TRANCUSTOMER,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
    <div title="成交客户管理" style="padding:10px;overflow:auto;" data-options="selected:true,iconCls:'icon-contract_cust'" >
		
		<!--
        <ul  class="easyui-tree" data-options="animate:true,dnd:true">
		-->
		 <ul class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){
				$(this).tree('toggle', node.target);
			}">

            <li><a href="#" onclick="return addTab('查询成交客户','<%=request.getContextPath()%>/customer_guangzhou/search/indexContractCustomer.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">查询成交客户</a></li>
             
        </ul>
    </div>
    <%} %>
    
    <%if(PermissionUtils.hasPermission(EnumPrivCode.MENU_TRANS,EnumDevFlag.GUANGZHOU )|| SessionUser.getUserId() == ContUserId.ADMIN){%>
    <div title="交易管理" style="padding:10px;" data-options="iconCls:'icon-home'">
		 <ul class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){$(this).tree('toggle', node.target);}">
            <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_INIT_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
            <li><span><a href="#" onclick="return addTab('楼盘初始','./saleunit_new_init/appoint/guangzhou/layout.action?selectType=__init__&ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
			楼盘初始</a></span></li>			
           <li>
			 <span><a href="#" onclick="return addTab('付款方式','./saleunit_setup/manager/layout.action?selectType=__setup__&ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
			 付款方式</a></span>
			</li>			
            <%} %>
            <!-- 20130725暂时隐藏 -->
            <!-- 
            <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_GROUP_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>            
            <li><span><a href="#" onclick="return addTab('组团管理','./saleunit_new/unit/group/layout_new.action?selectType=__group__&ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
			组团管理</a></span></li>			 
            <%} %>  
             -->          
            <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CHIP_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
            <li><span><a href="#" onclick="return addTab('认筹管理','./saleunit_chip_manager/guangzhou/layout.action?selectType=__chip__&ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
			认筹管理</a></span></li>
            <%} %>
            
            <%if(PermissionUtils.hasPermission(EnumPrivCode.SALEUNIT_CENTER_RETRIEVE,EnumDevFlag.GUANGZHOU) ){%>
            <li><span><a href="#" onclick="return addTab('现场销控情况','./saleunit/scene/guangzhou/layoutScene.action?selectType=__scene__&ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
				现场销控情况</a></span></li>
			<li><span><a href="#" onclick="return addTab('销售中心','./saleunit_new/appoint/guangzhou/layoutFrom.action?selectType=__appoint__&ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
				销售中心</a></span></li>					
            <%} %>
            
        </ul>
    </div>
    <%} %>
    
     <%if(PermissionUtils.hasPermission(EnumPrivCode.MENU_FINANCIAL,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
    <div title="财务管理" style="padding:10px" data-options="iconCls:'icon-caiwu'">
         <ul  class="easyui-tree" data-options="animate:true,dnd:false">

             <%if(SessionUser.getUserId() == ContUserId.ADMIN ){//只开放给admin_gz%>
             <li>
                 <a href="javascropt:void(0)"
                    onclick="return addTab('财务管理','./saleunit_financial_manager/guangzhou/layout.action?selectType=__financial__','')">
                     财务管理</a>
             </li>
             <%} %>
             <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_MANAGER,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
             <li>
                 <a href="javascropt:void(0)"
                    onclick="return addTab('成交单元管理','./saleunit_contract/manager/layout.action?selectType=__contractManager__','')">
                     成交单元管理</a>
             </li>
             <%} %>
             <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKFEE_READ,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
             <li >
                 <span>对数管理</span>
                 <ul>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKFEE_CREATE,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('新建预对数表','./saleunit_new/checkfee/checkfee_list.action','')">新建预对数表</a></span></li>
                     <%} %>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKFEE_UPDATE,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('修改预对数表','./saleunit_new/checkfee/checkfee_mod.action','')">修改预对数表</a></span></li>
                     <%} %>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKFEE_READ,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('查询对数表','./saleunit_new/checkfee/checkfee_confirm.action','')">查询对数表</a></span></li>
                     <%} %>
                 </ul>
             </li>
             <%} %>
             <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKCOMMISSION_READ,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
             <li >
                 <span>对佣管理</span>
                 <ul>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKCOMMISSION_CREATE,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('新建预对佣表','./saleunit_new/checkcommission/checkcommission_list.action','')">新建预对佣表</a></span></li>
                     <%} %>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKCOMMISSION_UPDATE,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('修改预对佣表','./saleunit_new/checkcommission/checkcommission_mod.action','')">修改预对佣表</a></span></li>
                     <%} %>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKCOMMISSION_READ,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('查询对佣表','./saleunit_new/checkcommission/checkcommission_confirm.action','')">查询对佣表</a></span></li>
                     <%} %>

                 </ul>
             </li>
             <li >
                 <span>对佣管理(一二手联动)</span>
                 <ul>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKCOMMISSION_CREATE,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('新建预对佣表(一二手联动)','./saleunit_new/checkcommission_sec/checkcommission_list.action','')">新建预对佣表</a></span></li>
                     <%} %>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKCOMMISSION_UPDATE,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('修改预对佣表(一二手联动)','./saleunit_new/checkcommission_sec/checkcommission_mod.action','')">修改预对佣表</a></span></li>
                     <%} %>
                     <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_CHECKCOMMISSION_READ,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
                     <li><span><a href="javascropt:void(0)" onclick="return addTab('查询对佣表(一二手联动)','./saleunit_new/checkcommission_sec/checkcommission_confirm.action','')">查询对佣表</a></span></li>
                     <%} %>

                 </ul>
             </li>
             <%} %>
             <%if(PermissionUtils.hasPermission(EnumPrivCode.FINANCIAL_RESULTCOMMISSION,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
             <li >
                 <span>结佣管理</span>
                 <ul>

                     <li><span><a href="javascropt:void(0)" onclick="return addTab('结佣','./saleunit_new/resultcommission/resultcommission_list.action','')">结佣</a></span></li>

                 </ul>
             </li>
             <li >
                 <span>结佣管理(一二手联动)</span>
                 <ul>

                     <li><span><a href="javascropt:void(0)" onclick="return addTab('结佣(一二手联动)','./saleunit_new/resultcommission_sec/resultcommission_list.action','')">结佣</a></span></li>

                 </ul>
             </li>
             <%} %>
         </ul>
		
    </div>		
    <%} %>
    
    
     <%if(PermissionUtils.hasPermission(EnumPrivCode.MENU_REPORT,EnumDevFlag.GUANGZHOU)|| SessionUser.getUserId() == ContUserId.ADMIN ){%>
    <div title="综合报表" style="padding:10px" data-options="iconCls:'icon-report'">
        <div class="easyui-panel" data-options="fit:false,border:false">
            <ul id="leftTree" class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){
				$(this).tree('toggle', node.target);
			}">
			
				<s:include value="left_precustomer_report.jsp"></s:include>
                
     			<%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_SALEUNIT_STAT,EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN ){%>
                <li data-options="state:'closed'">
                    <span>销售报表</span>
                    <ul>
                        <li>
                            <span>销售货量分析</span>
                            <ul>
                                <li><span><a href="#" id="zthlfxReport" onclick="return showRightTableFirst('zthlfxReport','总体货量分析');">总体货量分析</a></span></li>
                                <!-- <li><span><a href="#" id="xshlfxLcReport" onclick="return showRightTableFirst('xshlfxLcReport','销售货量分析(按楼层)');">销售货量分析(按楼层)</a></span></li>
                                <li><span><a href="#" id="xshlfxJgReport" onclick="return showRightTableFirst('xshlfxJgReport','销售货量分析(按价格)');">销售货量分析(按价格)</a></span></li>
                                <li><span><a href="#" id="xshlfxFlReport" onclick="return showRightTableFirst('xshlfxFlReport','销售货量分析(按分类)')">销售货量分析(按分类)</a> </span></li> -->
                            </ul>
                        </li>
						
						 <li>
                            <span>客户管理</span>
                            <ul>
                            	<!--  <li><span><a href="#" onclick="return showRightTable('contractCustomerQuestionCompany','成交客户问卷分类(公司)');">成交客户问卷分类(公司)</a></span></li>
								<li><span><a href="#" onclick="return showRightTable('contractCustomerQuestionProject','成交客户问卷分类(项目)');">成交客户问卷分类(项目)</a></span></li>
								<li><span><a href="#" onclick="return showRightTable('contractCustomerQuestionSales','成交客户问卷分类(销售)');">成交客户问卷分类(销售)</a></span></li> -->
                            	<li><span><a href="#" onclick="return showRightTableFirst('cjkhbj','成交客户背景分析');">成交客户背景分析</a></span></li>
								
								<li><span><a href="#" onclick="return showRightTableFirst('cjsjjcReport','成交数据交叉分析');">成交数据交叉分析</a></span></li>
                                <li><span><a href="#" onclick="return showRightTableFirst('cjkhflReport','成交客户分类统计');">成交客户分类统计</a></span></li>
								
                            	<li><span><a href="#" onclick="return showRightTable('khcj','客户交易明细(项目)');">客户交易明细(项目)</a></span></li>    
								
								<%--  
								<li><span><a href="javascript:void(0)" 
					onclick="return addTab('客户交易明细(楼栋)','./saleunit_new/contract/customer/layout.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">客户交易明细(楼栋)</a></span></li>                          		--%>
					
								<li>
									<span>
									<a href="javascript:void(0)" 
					onclick="return addTab('客户交易明细(楼栋)','./saleunit_new/contract/customer/layoutDataGrid.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
								客户交易明细(楼栋)</a>
									</span>
								</li>
								
                            </ul>
                        </li>
                      	<li>
                            <span>销售情况分析</span>
                      		<ul>
		                      	<li><span><a href="#" onclick="return showRightTable('saleReportCompany','销售分析(公司)');">销售分析(公司)</a></span></li>
		          			  	<li><span><a href="#" onclick="return showRightTable('saleReportProject','销售分析(项目)');">销售分析(项目)</a></span></li>
		          				<li><span><a href="#" onclick="return showRightTable('saleReportSale','销售分析(销售人员)');">销售分析(销售人员)</a></span></li>
		          				<li><span><a href="#" onclick="return showRightTable('saleReportSaleUnit','销售分析(单元明细)');">销售分析(单元明细)</a></span></li> 
						</ul>
						</li>
						<li><span><a href="#" onclick="return showRightTableFirst('rcfxReport','认筹分析');">认筹分析</a></span></li>
						<li><span><a href="#" onclick="return showRightTableFirst('shwjReport','售后问卷分析');">售后问卷分析</a></span></li>
						
                    </ul>
                </li>
                <%} %>


     			<%if(PermissionUtils.hasPermission(EnumPrivCode.REPORT_FINANCIAL_STAT,EnumDevFlag.GUANGZHOU) || SessionUser.getUserId() == ContUserId.ADMIN ){%>
                <li data-options="state:'closed'">
                    <span>财务报表</span>
                    <ul>
                        <!-- <li>对数情况</li> -->
                        <li>
                        	<span>系统应收</span>
                            <ul>
		                        <li><span><a href="#" 
		                                     onclick="return showRightTableFirst('commission_company','公司结佣表(系统计算)');">公司结佣表(系统计算)</a></span></li>
		                        <li><span><a href="#" 
                                             onclick="return showRightTableFirst('commission_prj','项目结佣表(系统计算)');">项目结佣表(系统计算)</a></span></li>
		                        <li><span><a href="#" id="commission_detail"
                                             onclick="return showRightTableFirst('commission_detail','单元结佣表(系统计算)');">单元结佣表(系统计算)</a></span></li>
                            </ul>
                         </li>
						<li>
							<span>财务应收</span>
                            <ul>
		                        <li><span><a href="#" 
		                                     onclick="return showRightTableFirst('commission_affirm_company','公司结佣表(开发商确认)');">公司结佣表(开发商确认)</a></span></li>
		                        <li><span><a href="#" 
                                             onclick="return showRightTableFirst('commission_affirm_prj','项目结佣表(开发商确认)');">项目结佣表(开发商确认)</a></span></li>
		                        <li><span><a href="#" id="commission_detail"
                                             onclick="return showRightTableFirst('commission_affirm_detail','单元结佣表(开发商确认)');">单元结佣表(开发商确认)</a></span></li>
                            </ul>
						
						</li>
    					<%if(SessionUser.getUserId() == ContUserId.ADMIN ){//只开放给admin_gz%>
                        <li><span><a href="#" id="xmjyqkReport"
                                     onclick="return showRightTableFirst('xmjyqkReport','项目结佣情况一览表');">项目结佣情况一览表</a></span></li>
                        <li><span><a href="#" id="ndxsjhReport"
                                     onclick="return showRightTableFirst('ndxsjhReport','年度销售计划及落实情况');">年度销售计划及落实情况</a></span></li>

                        <li>
                            <span>销售数据统计</span>
                            <ul>
                                <li><span><a href="#" id="qdqyhkjReport"
                                             onclick="return showRightTableFirst('qdqyhkjReport','齐定签约回款情况');">齐定签约回款情况</a></span></li>
                                <li><span><a href="#" id="cjqyhkReport"
                                             onclick="return showRightTableFirst('cjqyhkReport','成交签约回款情况');">成交签约回款情况</a></span></li>
                                <li><span><a href="#" id="ljcjtjbReport"
                                             onclick="return showRightTableFirst('ljcjtjbReport','累计成交统计表');">累计成交统计表</a></span></li>
                                <li><span><a href="#" id="ljqyhktjReport"
                                             onclick="return showRightTableFirst('ljqyhktjReport','累计签约回款统计');">累计签约回款统计</a></span></li>
                            </ul>
                        </li>
                        <li>
                            <span><a href="#" onclick="return showRightTable('xsryjxReport','销售人员绩效');">销售人员绩效</a></span>
                        </li>
                        <%} %>

                    </ul>
                </li>
               	<%} %>

                <%if(SessionUser.getUserId() == ContUserId.ADMIN || SessionUser.getCompanyId()==32){//只开放给admin%>
                <li data-options="state:'closed'">
                    <span>中山公司报表</span>
                    <ul>
                        <li>
                            <span><a href="#" onclick="return addTab('来访来电成交简况','./saleunit_new_report/report/zhongshan/zhongshanConfirmDetail.action?ts=2_13247095449451','');">来访来电成交简况</a></span>
                        </li>
                        <li>
                            <span><a href="#" onclick="return addTab('项目推货情况','./saleunit_new_report/report/zhongshan/projectPushDetail.action?ts=2_13247095449451','');">项目推货情况</a></span>
                        </li>

                        <%if(SessionUser.getUserId() == ContUserId.ADMIN ){//只开放给admin%>
                        <li>
                                <span>
				<a href="javascript:void(0)"
                   onclick="return addTab('中山客户情况分析','./saleunit_new_report/report/zhongshan/toCustomerManager.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
                    客户情况分析</a>
                                </span>
                        </li>

                        <li>
                            <span><a href="#" onclick="return showRightTableFirst('projectAndCustNum','成交客户分析');">成交客户分析</a></span>
                        </li>
                        <%} %>
                    </ul>
                </li>
                <%} %>
            </ul>

        </div>
    </div>
     <%} %>


    <div title="操作指引" style="padding:10px" data-options="iconCls:'icon-caozuo'">
        <ul  class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){
				$(this).tree('toggle', node.target);
			}">
            <li><span><a href="#" onclick="return addTab('系统功能构架概览','./help_html/20131210/系统功能构架概览.htm','')">系统功能构架概览</a></span></li>
            <li><span><a href="#" onclick="return addTab('系统登陆方式','./help_html/20131210/系统登陆方式.htm','')">系统登陆方式</a></span></li>
            <li><span><a href="#" onclick="return addTab('售前客户管理','./help_html/20131210/售前客户管理.htm','')">售前客户管理</a></span></li>
            <li><span><a href="#" onclick="return addTab('交易管理','./help_html/20131210/交易管理.htm','')">交易管理</a></span></li>
        </ul>
    </div>


    <%
        	if(SessionUser.getUserId() == ContUserId.ADMIN || PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_NOTICE_RETRIEVE, EnumDevFlag.GUANGZHOU) ){
    %>

    <div title="后台管理" style="padding:10px" data-options="iconCls:'icon-houtai'">
        <ul  class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){
				$(this).tree('toggle', node.target);
			}">
            <%if(SessionUser.getUserId() == ContUserId.ADMIN || PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_NOTICE_RETRIEVE, EnumDevFlag.GUANGZHOU) ){%>
            <li>
                <span>公告管理</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('公告查询','./customer_guangzhou/article/searchArticle.action','')">公告查询</a></span></li>
                </ul>
            </li>
			<%}%>
           
            <%if(SessionUser.getUserId() == ContUserId.ADMIN ||PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_USER_RETRIEVE, EnumDevFlag.GUANGZHOU) ){%>
            <li>
                <span>用户管理</span>
                <ul>
					

                    <li><span><a href="javascript:void(0)" onclick="return addTab('用户管理','./user/manager/easyuiLayout.action','')">
                    	用户管理</a></span></li>
                        
                    <li><span><a href="javascript:void(0)" onclick="return addTab('批量修改客户项目','./user/manager/toBatchModifyProject.action','')">
                    	批量修改客户项目</a></span></li>
              
              		<!--
                    <li><span><a href="#" onclick="return addTab('用户管理','./user/manager/layout.action','')">用户管理</a></span></li>
              		-->

                    <%if(SessionUser.getUserId() == ContUserId.ADMIN){%>
                    <li><span><a href="#" onclick="return addTab('角色权限','./user/manager/searchRolepriv.action','')">角色权限</a></span></li>
                    <li><span><a href="#" onclick="return addTab('权限管理','./user/manager/searchPriv.action','')">权限管理</a></span></li>
                    <li><span><a href="#" onclick="return addTab('角色替换','./user/manager/ajaxSearchRoleFrist.action','')">角色替换</a></span></li>
                    <%} %>
                </ul>
            </li>
            <%} %>
           
			<%if(SessionUser.getUserId() == ContUserId.ADMIN || PermissionUtils.isHaveThisRole(14)){%>
            <li>
                <span>登录情况查询</span>
                <ul>
                     <li><a href="#" onclick="return addTab('项目登录情况','./property/oper/project_unit_index.action','')">项目登录情况</a></li>
                     <li><a href="#" onclick="return addTab('用户登录情况','./property/oper/user_index.action','')">用户登录情况</a></li>
                     <li><a href="#" onclick="return addTab('详细登录情况','./property/oper/index.action','')">详细登录情况</a></li>
                     <li><a href="#" onclick="return addTab('系统浏览功能记录','./property/oper/actionRecordLogForm.action','')">浏览功能</a></li>
                     <li><a href="#" onclick="return addTab('数据导出情况','./property/oper/actionRecordLogForm.action','')">数据导出情况</a></li>
                </ul>
            </li>
			
			<li>
                <span>在线用户及缓存管理/异常</span>
                <ul>
                     <li>
                         <a href="javascript:void(0)" 
                         onclick="return addTab('在线用户及缓存管理','./customer_guangzhou/cache/cacheIndex.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
                            在线用户及缓存管理</a>
                      </li>
                      
                      <li>
                         <a href="javascript:void(0)" 
                         onclick="return addTab('action modify异常','./saleunit/common/action_modify_exception.action?ts=<%= CacheUtils.getUrlTimeStamp()%>','')">
                            action modify异常</a>
                      </li>					                        
                        
            		<%--<li><span><a href="#" onclick="return addTab('设置号码归属地','./customer/phone_from/to.action','')">设置号码归属地</a></span></li>--%>
                </ul>
            </li>            
            <%}%>
			
			<%if(SessionUser.getUserId() == ContUserId.ADMIN ||PermissionUtils.hasPermission(EnumPrivCode.SYSTEM_POWER_RETRIEVE, EnumDevFlag.GUANGZHOU) ){%>
			<li>
                <span>项目管理</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('项目管理','./projecr/manager/indexSearch.action','')">项目管理</a></span></li>
                </ul>
            </li>
			<%}%>
        </ul>

    </div>
    <%}%>
    <div title="帐号管理" style="padding:10px" data-options="iconCls:'icon-account'">
      <ul  class="easyui-tree" data-options="animate:true,dnd:false,onClick: function(node){
				$(this).tree('toggle', node.target);
			}">
               <li><span><a href="#" onclick="return addTab('帐号管理','./guangzhou/userAccount/setpwd.action','')">帐号管理</a></span></li>
	  </ul>
    </div>
</div>



