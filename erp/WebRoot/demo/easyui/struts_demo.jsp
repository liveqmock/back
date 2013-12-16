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
<b>struts使用参考说明：</b>

<br/>
<br/>
<b>action的写法：</b><br/>
1,action中的java类要足够的简单，而不要把很多方法写在里面，做得太混乱，尽量不要超过5个方法，要与业务基本一致；<br/>
2,超过8个public方法左右的话，基本上可以考虑，重新再写一个action<br/>
3,关于代码的重复拷贝，可以用继承的方式去实现<br/>


<p></p>
<br/>
<p></p>
<b>checkboxlist：</b>
<br/>
参考：cjsjjc_report.jsp
<br/>
如果是竖向排列，参考input_userRole.jsp<br/>

<br/>
<p></p>
<b>select：</b>
<br/>
参考：bat_inputUser.jsp<br/>
<br/>
<br/>

<b>checkbox：</b>
<br/>
参考：search_userAccount.jsp里面的"是否恒大项目"
<br/>
<br/>
<b>代码示例：</b>
<textarea rows="10" cols="150">
jsp页面
s: checkboxlist name="selCountType"  list="listCountType" label="">< /s:checkboxlist>

action代码


	public String[] getListCountType() {
		return new String[]{"套数","建筑面积","套内面积","成交总价"};
	}
	
	//选中的统计内容
	private String[] selCountType;
	
public String[] getSelCountType()
    {
		if(selCountType==null){
			selCountType = new String[]{"套数"};
		}
        return selCountType;
    }
    
	public void setSelCountType(String[] selCountType)
    {
        this.selCountType = selCountType;
    }


1.第一个例子：
<s:select list="{'aa','bb','cc'}" theme="simple" headerKey="00" headerValue="00"></s:select>

2.第二个例子：
<s:select list="#{1:'aa',2:'bb',3:'cc'}"  label="abc" listKey="key" listValue="value"  headerKey="0" headerValue="aabb">

3.第三个例子：<%
HashMap map = new LinkedHashMap();
map.put(1,"aaa");map.put(2,"bbb");
map.put(3,"ccc");
request.setAttribute("map",map);
request.setAttribute("aa","2");
%>

<s :select list="#request.map"  label="abc" listKey="key" listValue="value" value="#request.aa"  headerKey="0" headerValue="aabb"></s:select>
</textarea>
<br/>

</body>
</html>

