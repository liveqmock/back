<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
 
    <title>inputMain</title>
    
	<link href="../css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" />
	


  </head>
  
  <body>
   
   
<!--main-->
<table width="100%" border="0" cellspacing="0" class="boxnav">
  <tr>

    <td width="290" align="left" valign="top" background="images/blue/leftbg.gif">
	
	<!--left.top-->
	
	<s:include value="../customer/left.jsp"></s:include>

    <!--left.end-->    </td>	
	
	<!-- right form top -->
	<form action="user/updateUserAccount.action" method="post" >
	
	
    <td valign="top">
    <!--right-->	
    <div class="rightnav">
    	<div class="righttitle">
    	修改密码        </div>
    	<div class="r">
    	  <div class="leftcreatesave01 iconbg"><a href="./customer!doSomeForAddCustomer.action" target="_self">+ 新 建</a></div>
    	  <div class="l">  	    </div>
  	  </div>
<div class="rightlineg"></div>       
       
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">输入密码</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="password" name="userAccount.userPwd" id="pwd" class="leftcreateinputbox01"
									/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
          <div class="righttitleword01 fontblue">重复密码</div>
          <div class="rightboxnone">
            <div class="rightboxl"></div>
            <div class="rightboxm01">
              <label for="textfield"></label>
              <input type="password" id="repwd" class="leftcreateinputbox01" name="pwdValidation"/>
            </div>
            <div class="rightboxr"></div>
            <div class="c"></div>
          </div>
        </div>
        </div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav"></div>
        <div class="blank"></div>
        <div class="l">
          <div class="l">  	    </div>
  	  </div>
      <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  	<!--<a href="#">取 消</a>-->
	<!--  <input type="hidden" name="loginAccount" value="<s:property value='#session.loginAccount'/>"/>-->
		  	<input name="submit" id="submit" type="submit" value="保 存"/>
    	  </div>
    	  <div class="l">  	    </div>
  	  </div>
      <span class="leftcreatesave01 iconbg">
      <input name="button" type="button" onClick="javascript:window.history.go(-1)" value="返回" />
      </span></div>
    <!--right.end-->	</td>
	</form>
	<!-- right form end-->
  </tr>
</table>

<!--main.end-->
   
   
  </body>
</html>
