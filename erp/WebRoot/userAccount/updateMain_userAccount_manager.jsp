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
	<form action="<%=request.getContextPath() %>/updateUserAccountByManager.action" method="post" >
	
	
    <td valign="top">
    <!--right-->	
    <div class="rightnav">
    	<div class="righttitle">
    	      修改密码</div>
    	      <br/>
    	      <div class="rightlineg"></div>
    	      <br/>
    	     &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 姓名：  ${tempUser.realName } &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 账号：  ${tempUser.userName } 
    	<div class="r">
    	 <div class="leftcreatesave iconbg"><a href="<%=request.getContextPath() %>/addUserAccountJsp.action" target="_self"">+ 新 建</a></div>
    	  <div class="l">  	    </div>
  	  </div>
        <div class="leftcreatenav">
          <div class="leftv">
  <div class="righttitleword01 fontblue">输入新密码</div>
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
          <div class="righttitleword01 fontblue">重复新密码</div>
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
        <div class="blank">
          <div class="leftv">
            <div class="righttitleword01 fontblue">是否禁用</div>
            <div class="rightboxnone">
               <s:if test="#session.tempUser.isDeleted== 0">
              <div class="inputicon">
           
                <input name="userAccount.isDeleted" type="radio" value="1" />
                是</div>
              <div class="inputicon">
                <input name="userAccount.isDeleted" type="radio" value="0" checked />
                否</div>
                </s:if>
                <s:else>
                 <div class="inputicon">
           
                <input name="userAccount.isDeleted" type="radio" value="1" checked/>
                是</div>
              <div class="inputicon">
                <input name="userAccount.isDeleted" type="radio" value="0"  />
                否</div>
                </s:else>
              <div class="c"></div>
            </div>
          </div>
        </div>
        <div class="l">
          <div class="l">  	    </div>
  	  </div>
      <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  	<!--<a href="#">取 消</a>-->
		  	<input type="hidden" name="userAccount.id" value="<s:property value='#session.tempUser.id'/>"/>
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
