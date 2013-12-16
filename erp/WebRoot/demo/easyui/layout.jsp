<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>


<%@ page import="com.ihk.utils.CacheUtils"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

<title>开发帮助示例文档</title>

<base href="<%=basePath%>">

<s:include value="../../customer/guangzhou/header.jsp" />
<link href="./css/easyui.css" rel="stylesheet" type="text/css"
	charset="utf-8" />
<link href="./css/icon.css" rel="stylesheet" type="text/css"
	charset="utf-8" />
<script type="text/javascript" language="javascript" src="./js/easyui.tab.utils.js"></script>
<script type="text/javascript" language="javascript" src="./js/easyui.utils.js"></script>

<style type="text/css">
* {
	margin: 0;
	padding: 0;
}
</style>

</head>

<body class="easyui-layout">

	<div region="north" border="false"
		style="height:50px;background:#B3DFDA;padding:0px; overflow:hidden">
		<s:include value="../../customer/guangzhou/top.jsp" />
	</div>

	<div region="west" split="true"
		title="<a href='./customer_guangzhou/index/login.action' style='color:#5482DE'>返回主页</a>"
		style="width:280px;padding:1px;">

		<div class="easyui-accordion" fit="true" border="false">
			<div title="开发帮助示例文档" selected="true" style="padding:0px;">
				<ul id="tt1" class="easyui-tree" animate="true" dnd="false">
					<li><span>增删改查</span>
						<ul>
							<li><span><a href="#"
									onclick="return showRightTable('easyui版查询与分页(json)');">easyui版查询与分页(json)</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('easyui版弹出框新建与修改');">easyui版弹出框新建与修改</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('数据校验');">数据校验</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('删除做法');">删除做法</a>
							</span></li>
							<li state="closed"><span>过时做法</span><ul>
							<li><span><a href="#"
									onclick="return showRightTable('增删改查');">iframe版</a>
							</span></li>	
							<li><span><a href="#"
									onclick="return showRightTable('增删改查div');">div版</a>
							</span></li>
							</ul></li>		
						</ul>
					</li>
					<li><span>组件</span>
						<ul>
							<li><span><a href="#" onclick="return showRightTable('公司下拉框(单选，多选)');">公司下拉框(单选，多选)</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('项目下拉框(单选，多选)');">项目下拉框(单选，多选)</a>
							</span></li>	
							<li><span><a href="#" onclick="return showRightTable('楼盘项目，分区，楼栋级联下拉框');">楼盘项目，分区，楼栋级联下拉框</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('公司，公司项目级联下拉框');">公司，公司项目级联下拉框</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('公司项目拼音搜索下拉框');">公司项目拼音搜索下拉框</a>
							</span></li>
							<li><span><a href="#"
									onclick="return showRightTable('自定义标签');">自定义标签</a>
							</span></li>	
						</ul>
					</li>
					<li><span>界面外观</span>
						<ul>
							<li><span><a href="#"
									onclick="return showRightTable('页面控件界面标准');">页面控件界面标准</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('弹窗(内容框)');">弹窗(内容框)</a>
							</span></li>	
							<li><span><a href="#" onclick="return showRightTable('弹窗(提示框)');">弹窗(提示框)</a>
							</span></li>
							<li><span><a href="#"
									onclick="return showRightTable('界面间的通信');">界面间的通信</a>
							</span></li>
						</ul>
					</li>
					<li><span>报表</span>
						<ul>
							<li><span><a href="#" onclick="return showRightTable('报表常规做法');">报表常规做法</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('报表表格(列表)');">报表表格(列表)</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('折线图');">折线图</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('柱状图');">柱状图</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('比例图');">比例图</a>
							</span></li>
							<li><span><a href="#"
									onclick="return showRightTable('下载数据');">下载数据</a>
							</span></li>		
						</ul>
					</li>
					<li><span>布局layout</span>
						<ul>
							<li>
							  <span>
							    <a href="#" onclick="return showRightTable('左右结构');">左右结构</a>
							  </span>
							</li>
							<li>
							  <span>
							    <a href="#" onclick="return showRightTable('主体上下结构');">主体上下结构</a>
							  </span>
							</li>
						</ul>
					</li>
					<li><span>自编常用类</span>
						<ul>
							<li><span><a href="#" onclick="return showRightTable('常用java工具类');">常用java工具类</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('常用权限类');">常用权限类</a>
							</span></li>
							<li><span><a href="#" onclick="return showRightTable('常用js类');">常用js类</a>
							</span></li>							
							<li><span><a href="#" onclick="return showRightTable('日志的做法');">日志的做法</a>
							</span></li>
						</ul>
					</li>	
					<li><span>其他</span>
						<ul>
							<li><span><a href="#" onclick="return showRightTable('struts使用参考');">struts使用参考</a>
							</span></li>								
							<li><span><a href="#" onclick="return showRightTable('杂项');">杂项</a>
							</span></li>
						</ul>
					</li>					

				</ul>
			</div>
		</div>



	</div>

	<!-- 中间再分上下结构 -->
	<div region="center" title="<div id='showTitle'> </div>"
		style="padding:0px;background:white;" id="_center">
		
	<div class="easyui-layout" fit="true" style="background:#cccccc;" id="_center_layout">			
			<!-- 中间的主要部分 -->
			<div region="center" id="center_main" style="top:26px;">
			<iframe id="_centerFrame" frameborder="0" scrolling="auto" style="width:100%;height:100%"></iframe>
			</div>
			
			<!-- 中间的底下部分 -->
			<div region="south" id="center_bottom" split="true" style="height:300px; width:500px" title="使用说明">			
			<iframe id="_docFrame" frameborder="0" scrolling="auto" style="width:100%;height:100%"></iframe>			
			</div>	
					
		</div> 

		</div>

	<!-- 底部,不用放其他代码-->
	<div region="south" border="false"
		style="background:#A9FACD;padding:0px;">
		<div style="width: 100%;height: 15px;background: #eeeeee"></div>
	</div>

	<!-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) -->
	<div id="myDialog" class="easyui-dialog" closed="true" modal="true"
		title="标题"
		style="display:block;width:800px;height:500px; overflow-x:hidden">
	</div>
	<!-- 一般使用  myIframeDialog 来做弹出框-->
	<div id="myIframeDialog" class="easyui-dialog" closed="true"
		modal="true" title="标题"
		style="display:block;width:800px;height:500px; overflow-x:hidden">
		<iframe scrolling="auto" id='openIframe' frameborder="0"
			src="./saleunit_new/guangzhou/loading.jsp"
			style="width:100%;height:100%;"></iframe>
	</div>
</body>
<script type="text/javascript" language="javascript"
	src="<%=basePath%>js/jquery.easyui.min.js"></script>
<script type="text/javascript" language="javascript">
		
		$().ready(function(){			
			
			$("#back").click(function(){
				
				location.href = "./customer_guangzhou/index/login.action";
				return false;
			});
					
			showRightTable('easyui版查询与分页(json)');
		});
		
	
	//显示右边的内容
	function showRightTable(actionName,titleName){
		var utabs = $("#_center");//指定显示单元信息的控件ID
		
		$('#_centerFrame').attr('src',"./demo/easyui/"+actionName+".action?ts=<%=CacheUtils.getUrlTimeStamp()%>");
		$('#_docFrame').attr('src',"./demo/easyui/"+actionName+"Doc.action?ts=<%=CacheUtils.getUrlTimeStamp()%>");
		$("#showTitle").text(titleName);
		return false;
	}
	
	
	function showRightTable(actionUrl,actionDocUrl,titleName){
	}
	function showRightTable(titleName){
		var actionUrl;
		var actionDocUrl;
		if(titleName=="增删改查"){
			actionUrl = "./demo/easyui/searchList.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "./demo/easyui/searchListDoc.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
		}	
		else if(titleName=="增删改查div"){
			actionUrl = "./demo/easyui/crudDivDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="左右结构"){
			actionUrl = "./saleunit_new_report/report/guangzhou/layout.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "./demo/easyui/layoutLeftRightDoc.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
		}	
		else if(titleName=="主体上下结构"){
			actionUrl = "./demo/easyui/layout.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "./demo/easyui/layoutCenterBottomDoc.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
		}	
		else if(titleName=="按钮"){
			actionUrl = "./demo/easyui/buttonDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="页面控件界面标准"){
			actionUrl = "./demo/easyui/uiStandDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="自定义标签"){
			actionUrl = "./demo/easyui/myTagDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="下载数据"){
			actionUrl = "./demo/easyui/downDataDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="struts使用参考"){
			actionUrl = "./demo/easyui/strutsDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";			
			actionDocUrl = "";
		}
		else if(titleName=="js使用参考"){
			actionUrl = "./demo/easyui/jsDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="easyui版查询与分页(json)"){
			actionUrl = "./demo/easyui/easyuiSearchlistDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="杂项"){
			actionUrl = "./demo/easyui/otherDocDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="easyui版弹出框新建与修改"){
			actionUrl = "./demo/easyui/addandupdateDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="数据校验"){
			actionUrl = "./demo/easyui/checkDataDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="删除做法"){
			actionUrl = "./demo/easyui/deleteDataDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="弹窗(内容框)"){
			actionUrl = "./demo/easyui/popwindowDataDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="弹窗(提示框)"){
			actionUrl = "./demo/easyui/popwindowMessageDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="界面间的通信"){
			actionUrl = "./demo/easyui/communicationDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="报表常规做法"){
			actionUrl = "./demo/easyui/reportNormalDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="折线图"){
			actionUrl = "./demo/easyui/reportLineDemo.action?ts=< %=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="柱状图"){
			actionUrl = "./demo/easyui/reportColumnDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="比例图"){
			actionUrl = "./demo/easyui/reportPieDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="报表表格(列表)"){
			actionUrl = "./demo/easyui/reportListDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="公司下拉框(单选，多选)"){
			actionUrl = "./demo/easyui/myCompanyComboboxDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="项目下拉框(单选，多选)"){
			actionUrl = "./demo/easyui/myProjectComboboxDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="楼盘项目，分区，楼栋级联下拉框"){
			actionUrl = "./demo/easyui/myPropertyprojectMulDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="公司，公司项目级联下拉框"){
			actionUrl = "./demo/easyui/myCompanyprojectMulDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="公司项目拼音搜索下拉框"){
			actionUrl = "./demo/easyui/myCompanyprojectPinyinDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="常用java工具类"){
			actionUrl = "./demo/easyui/commonJavaDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="常用权限类"){
			actionUrl = "./demo/easyui/commonPermissionDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="常用js类"){
			actionUrl = "./demo/easyui/commonJsDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else if(titleName=="日志的做法"){
			actionUrl = "./demo/easyui/commonLogDemo.action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
			actionDocUrl = "";
		}
		else{
			alert("待实施");
			return false;
		}
		
		var utabs = $("#_center");//指定显示单元信息的控件ID		
		
		var optionsx = $('#_center_layout').layout("panel", "south").panel("options");			
		var optionsxb = $('#center_bottom').panel("options");
		//alert(optionsxb.collapsed);

			
		//如果不需要显示额外的说明，那就隐藏右边下部的div
		if(actionDocUrl==""){
			$('#_center_layout').layout('collapse','south');
			actionDocUrl = "";
		}
		else{
			if(optionsx.collapsed){
				$('#_center_layout').layout('expand','south');
			}	
		}			
		$('#_centerFrame').attr('src',actionUrl);
		$('#_docFrame').attr('src',actionDocUrl);
		$("#showTitle").text(titleName);
		return false;
	}
	
</script>

<!-- ie6 水印问题 -->
<script type="text/javascript"
	src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
<script type="text/javascript">
	DD_belatedPNG.fix('.logo');
</script>

</html>

