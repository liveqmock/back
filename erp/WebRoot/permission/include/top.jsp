<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!--top-->
	<div class="boxnavtop">
    <div class="logo"></div>
    <div class="logoword">恒大项目</div>
    <!--welcome begin-->
<div class="welcome">
    	<div class="welcome01"></div>
        <div class="welcome02">欢迎
        <span class="fontblue"><s:property value="#session.loginAccount.realName"/></span> |
        <a href="./customer!customerLoginOut.action" title="注销" target="_self">注销</a>
        <!-- <a href="#" title="培训" target="_blank">培训</a> ｜ <a href="#" title="帮助" target="_blank">帮助</a> ｜<a href="#" title="关于" target="_blank">关于</a></div> -->
  </div>
  </div>
  </div>
    <!--welcome.end-->
    
<div class="topline"></div>

<!--top.end-->