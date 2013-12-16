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
<b>页面控件界面标准的说明：</b>
<br/>
按钮 <input type="button" value=" 按钮 " /><br/>
1,直接使用按钮<br/>
<textarea rows="3" cols="150">
<input type="button" value=" 查询 " />
注意value值的前后都留一个空格,如果页面实在位置不够,才考虑把空格去掉；
</textarea><br/><br/>
2,按钮提交的两种方式：<br/>
<textarea rows="7" cols="150">
1,type=submit
<input type="submit" value=" 查询 " />

2,type=button
<input type="button" onclick="javascript:submitForm();" value=" 查询 " />
自行写代码进行提交
</textarea>
<br/>
<hr/>
控件间距<br/>
1,留一个nbsp的距离，源代码换行<br/>


2,不留间距，源代码换行<br/>
按钮与按钮之间,需要在源代码中换行即可，具体留的位置，由浏览器去适应，换行在firefox与chrome中是最好的效果;<br/>

3,留两个间距的距离<br/>
这样的情况暂不属于通用情况，不作举例

<br/>
<hr/>
<br/>
页面的a链接，其实如果用onclick的写法，而不写href的时候，直接采用class="blueLink",在blue_easyui.css样式表中，已经包括下划线，鼠标手型的定义<br/>



</body>
</html>

