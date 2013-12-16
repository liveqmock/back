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
<b>常用java工具类说明：</b>

<br/>

<p></p>
<p><b>参考：</b></p>
<p>帮助工具类都放在com.ihk.utils下，<br>
</br>目前最常用的是ActionTemplate(基于easyui)，</p>
<p>
 弹出框表单action及ajax分页，两者对应的后台方法都是在com.ihk.utils.ActionTemplate.java中，前端js方法在easyui.utils.js中。<br/>
后台，弹出框表单action对应方法executeAjaxMethod()，ajax分页对应方法executeAjaxPage()；<br/>
前端，弹出框表单action对应MyAjaxIframeDialog(iframe)，MyAjaxDivDialog(div)，ajax分页使用easyui的datagrid；
<br/>
弹出框表单action可以设置自定义成功或异常信息，并在前端页面获取，ajax分页分为有无底部两种模式。

<br/>

<br/>

<b>数据缓存的做法：</b><br/>
参考：applicationContext-cache-interceptor.xml<br/>
里面配置companyProjectMethodInterceptor，实现的是公司项目的缓存；<br/>
具体缓存的实现类(key,value),参考：CompanyProjectMethodInterceptor<br/>
可以拦截，可以指定不拦截方法名<br/>
并且有模糊方法名(前后缀)的方式<br/>
  
  <br/>
</p>
<p></p>
<b>主要代码说明：</b>
<br/>
<br/>
<b>代码示例：</b>
<textarea rows="10" cols="150">
		
	ActionTemplate.executeAjaxMethod(true, this, new ActionAjaxMethodModifyCallback() {			
		@Override
		public void modifyMethodException(Exception e) {				
			setUpEasyuiAjaxForFail(e.getMessage());				
		}
		
		@Override
		public void modifyMethod() throws Exception {				
			init();
			
			if(userAccount.getUserName()==null||userAccount.getUserName().trim().equals("")){					
				throw new Exception("注册失败.用户名不能为空.");
			}
			
			if(userAccount.getUserPwd() == null || userAccount.getUserPwd().trim().equals("")){				
				throw new Exception("注册失败.密码不能为空.");
			}
			
			if(userAccount.getRealName() == null || userAccount.getRealName().trim().equals("")){			
				throw new Exception("注册失败.姓名不能为空.");
			}
			
			if(valUserName(userAccount.getUserName())) {		
				throw new Exception("注册失败.用户名重复.");
			}
			userAccount = initUpdateUser(userAccount);
			userAccountServices.saveUserAccount(userAccount);
			addRole(userAccount);
			
		}
	});		
	
	return null;
</textarea>
<br/>

</body>
</html>

