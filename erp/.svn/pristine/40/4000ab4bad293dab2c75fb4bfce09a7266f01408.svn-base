<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>update</title>
	
	<link href="<%=path %>/css/tianluan.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
   	 <script type="text/javascript" language="javascript"
			src="<%=path %>/js/jquery-1.3.1.js"></script>
     <script type="text/javascript" language="javascript"
				src="<%=path %>/js/jquery.validate.js"></script>
     <script src="<%=path %>/js/jquery.validate.messages_cn.js" type="text/javascript"></script>  
      <script src="<%=path %>/js/jquery.metadata.js" type="text/javascript"></script>            
<style type="text/css">

label { width: 10em; float: left; }
em.error { float: none; color: red; padding-left: .5em; vertical-align: top; }
p { clear: both; }
.submit { margin-left: 12em; }

em { font-weight: bold; padding-right: 1em; vertical-align: top; }
em.error {

  padding-left: 16px;
}
em.success {

  padding-left: 16px;
}

</style>
  <script type="text/javascript">
  $(document).ready(function(){

	$("#commentForm").validate({
		rules: {
			'userAccount.userPwd': {
				required: true,
				minlength: 6
			},
			'pwdValidation': {
				equalTo:"#pwd"
			}
		},
		
		messages: {
			'userAccount.userPwd': {
				required: '请输入密码',
				minlength: '请至少输入六个字符'
			},
			'pwdValidation': {
				equalTo:"两次密码输入不相等"
				
			},
			
		},	
		
		errorElement: "em", //可以用其他标签，记住把样式也对应修改
		success: function(label) {
			//label指向上面那个错误提示信息标签em
			label.text(" ")				//清空错误提示消息
				.addClass("success");	//加上自定义的success类
		}

	  });

  });
  </script>
  
  </head>
  
  <body>
   
   
<!--main-->
<table width="100%" border="0" cellspacing="0">
  <tr>
   <s:include value="../../customer/huijing/left.jsp"></s:include>
    
    <td width="100%" valign="top" height="100%" style="overflow:hidden;">
    <div class="right01"></div>
    <div class="right02"></div>
    <div class="right03"></div>
    <div class="c"></div>
    <div >
    <div class="right04"></div>
    <div class="right05">
      <div class="titlel"></div>
        <div class="titlebg" style=" height:auto;overflow:hidden;">
    
         <div class="title02" ><a href="./user_huijing!updateUserAccountJsp_user.action" target="_self">修改密码</a></div>
            
        
         <div class="right99"></div>
			<div class="blueline"></div>
          <div class="c"></div>
           <form action="./user_tianluan!updatePwd.action" method="post" id="commentForm">
            <table width="98%" border="0" cellspacing="0" class="main">
           
    
         
              <tr>
              	 <td width="70" align="right">新密码&nbsp;</td>
                 <td ><input name="userAccount.userPwd" class="box" type="password"  id="pwd"/></td>
              </tr>
             
              <tr >
              	 <td align="right">重复密码&nbsp;</td>
                <td ><input name="pwdValidation" class="box" type="password"  /></td>
              </tr>
           
           
             
 		 <tr>
    			<td></td><td><input type="submit" name="button" id="button" value="  保存  " align="right" />
         </td>
  </tr>
  
  		
  </table>
  </form>
          <div class="c"></div>
        </div>
        <div class="titler"></div>
        <div class="c"></div>
    </div>
    <div class="right06"></div>
    <div class="c"></div>
    </div>
    <div class="right07"></div>
    <div class="right08"></div>
    <div class="right09"></div>
    <div class="c" ></div>
    </td>
  </tr>
  <!--main.end-->
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
</table>
  </body>
</html>
