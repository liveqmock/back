<%@ page contentType="text/html; charset=utf-8"%>
<%@page import="com.ihk.constanttype.EnumDevFlag"%>
<%@page import="com.ihk.constanttype.EnumPrivCode"%>
<%@page import="com.ihk.permission.PermissionUtils"%>
<%@ page language="java" import="com.ihk.utils.CacheUtils" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.ihk.utils.SessionUser" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="easyui-accordion" data-options="fit:true,border:false">
    <div title="功能列表" style="padding:10px;overflow:auto;" data-options="selected:true,iconCls:'icon-edit'" >
        <ul  class="easyui-tree" data-options="animate:true,dnd:true">
            <li><span>基础</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('增删改查','./demo/easyui/searchList.action?ts=<%=CacheUtils.getUrlTimeStamp()%>');">增删改查(iframe版)</a></span></li>
                    <li><span><a href="#" onclick="return addTab('增删改查div','./demo/easyui/crudDivDemo.action?ts=< %=CacheUtils.getUrlTimeStamp()%>');">增删改查(div版)</a></span></li>
                </ul>
            </li>
            <li><span>布局layout</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('左右结构','./saleunit_new_report/report/guangzhou/layout.action?ts=<%=CacheUtils.getUrlTimeStamp()%>');">左右结构</a></span></li>

                    <li><span><a href="#" onclick="return addTab('主体上下结构','./demo/easyui/layout.action?ts=<%=CacheUtils.getUrlTimeStamp()%>');">主体上下结构</a></span></li>

                </ul>
            </li>
            <li><span>界面外观</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('页面控件界面标准','./demo/easyui/uiStandDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>');">页面控件界面标准</a></span></li>

                </ul>
            </li>
            <li><span>自定义插件</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('自定义标签','./demo/easyui/myTagDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>');">自定义标签</a></span></li>

                </ul>
            </li>
            <li><span>报表</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('下载数据','./demo/easyui/downDataDemo.action?ts=< %=CacheUtils.getUrlTimeStamp()%>');">下载数据</a></span></li>

                </ul>
            </li>
            <li><span>其他</span>
                <ul>
                    <li><span><a href="#" onclick="return addTab('struts使用参考','./demo/easyui/strutsDemo.action?ts=< %=CacheUtils.getUrlTimeStamp()%>');">struts使用参考</a></span></li>

                    <li><span><a href="#" onclick="return addTab('js使用参考','./demo/easyui/jsDemo.action?ts=< %=CacheUtils.getUrlTimeStamp()%>');">js使用参考</a></span></li>

                </ul>
            </li>

        </ul>
    </div>
    <div title="交易管理" style="padding:10px;" data-options="iconCls:'icon-edit'">
        <ul  class="easyui-tree" data-options="animate:true,dnd:true">

        </ul>
    </div>
    <div title="财务管理" style="padding:10px" data-options="iconCls:'icon-edit'">
        <p>财务管理</p>
    </div>


</div>



