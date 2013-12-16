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
<b>js使用参考说明：</b>

<br/>

<p></p>
<b>参考：</b><br/>
<br/>
<p></p>
<b>主要代码说明：</b>
<br/>
Namespace在easyui.util.js 里面进行统一定义
<br/>
<b>代码示例：</b>
<textarea rows="10" cols="150">


//js命名空间DEMO
// 注册js脚本的命名空间
Namespace.register("erp.saleunit");
// 在Grandsoft.GEA命名空间里面声明类Person
erp.saleunit.Person = function(name, age)
{
    this.name = name;
    this.age = age;
} 
// 给类Person添加一个公共方法show()
erp.saleunit.Person.prototype.show = function()
{
    alert('hope733命名空间直接调用prototype的方法:'+this.name + " is " + this.age + " years old!");
} 

// 在Grandsoft.GEA命名空间里面声明类Person
erp.saleunit.TEST = function()
{
	alert('hope733命名空间直接调用function-成功');
}


erp.saleunit.Test2 = function(para1,para2)
{
	alert('hope733命名空间直接调用function-test2成功'+para1+para2);
}

//erp.saleunit.TEST();//无参数 
//erp.saleunit.Test2(); //不重复
//erp.saleunit.Test2(1,'a'); //带参数

// 演示如何使用类Person,这是以类型的方式
//var p = new erp.saleunit.Person("yanglf", 25);
//p.show();

</textarea>
<br/>

</body>

</html>

