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
<b>公司项目拼音搜索下拉框说明：</b>
<br/>
<br/>

<p></p>
<p><b>参考：</b></p><br/>
交易管理，销控中心<br/>
<b>例子图片</b><br/>
<img src="<%= basePath%>/demo/easyui/images/my_companyproject_pinyin_demo.jpg" width="800px"/>

<p>struts-saleunit-new.xml</p>
<p>&lt;action name=&quot;layout&quot; class=&quot;com.ihk.saleunit.action.new_.GuangZhouAppointNewLeftAction&quot; method=&quot;layout&quot;&gt;<br />
&lt;result name=&quot;layout&quot;&gt;/saleunit_new/guangzhou/layout.jsp&lt;/result&gt;<br />
&lt;/action&gt;<br />
<br />
&lt;!-- ajax加载公司项目的下拉框 --&gt;<br />
&lt;action name=&quot;layoutAjax&quot; class=&quot;com.ihk.saleunit.action.new_.GuangZhouAppointNewLeftAction&quot; method=&quot;layoutAjax&quot;/&gt;<br/>
  
  <br/> 
easyui.left.tree.js</p>
<p>function bindLeftCombobox(moduleId, selectType, bindLeftTreeFn, bindLeftTreeArg) </p>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b>
<textarea rows="30" cols="150">
1,jsp页面写法：
saleunit_new\guangzhou\layout.jsp

		$(document).ready(function(){		
			//延期签约的弹出框
			messageShow("延期签约提醒");

			bindLeftCombobox("__myProjectId__", "__appoint__", bindLeftTree, ["__appoint__"]);
			
		});
		
说明：
__myProjectId__：jsp页面input的id；
__appoint__：EnumSelectTypeSessionKey.java里面的枚举值（相当于session的key）；
bindLeftTree:选中下拉框后，调用的函数，用于显示下方的树形；
__appoint__：和第二个参数目前一致（做参数类型的扩展）		
		
2，关于选中的值的id情况：
action中写：
		int companyProjectId = PropertyTreeUtils.getLeftTreeProjectIdSession(request);

    utabs.load("./saleunit_new_init/appoint/guangzhou/customerBeforeTab.action?selectType=__init__");	
    selectType=__init__:表示取楼盘初始选中的公司项目
    具体参考：EnumSelectTypeSessionKey的枚举值	
				
</textarea>
<br/>

</body>
</html>

