<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
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
	<form action="user/addUserAccount.action" method="post" >
	
	
    <td valign="top">
    <!--right-->	
    <div class="rightnav">
    	<div class="righttitle">
    	用户更新        </div>
    	<div class="r">
    	  <div class="leftcreatesave01 iconbg"><a href="./customer!doSomeForAddCustomer.action" target="_self">+ 新 建</a></div>
    	  <div class="l">  	    </div>
  	  </div>
<div class="rightlineg"></div>       
       
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">用户姓名</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="userAccount.userName" id="customerName" class="leftcreateinputbox01"
									 value="<s:property value='#session.tempUser.userName'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
          <div class="righttitleword01 fontblue">用户密码</div>
          <div class="rightboxnone">
            <div class="rightboxl"></div>
            <div class="rightboxm01">
              <label for="textfield"></label>
              <input type="text" name="userAccount.userPwd" id="userAccount.userPwd" class="leftcreateinputbox01" 
			  						value="<s:property value='#session.tempUser.userPwd'/>"/>
            </div>
            <div class="rightboxr"></div>
            <div class="c"></div>
          </div>
        </div>
        </div>
        <div class="leftcreatenav">
          <div class="leftv">
  <div class="righttitleword01 fontblue">所属公司</div>
  <div class="rightboxnone">
    <select name="customer.customerState" id="customerState" class="rightinputbox">
      <option value="0" selected>选择公司</option>
      <s:iterator value="companyList">
     	 <option value="companyId" >
     	 	<s:property value="companyName"/>
     	 </option>
      </s:iterator>
     </select>
  </div>
        </div>
          <div class="leftv">
            <div class="righttitleword01 fontblue">所属组别</div>
            <div class="rightboxnone">
              <select name="customer.customerSource" id="customerSource" class="rightinputbox">
                <option value="0">选择组别</option>
                <s:iterator value="teamList">
     			 <option value="teamId" >
     	 			<s:property value="teamName"/>
     	 			</option>
     			 </s:iterator>
              </select>
            </div>
          </div>
        </div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav">
          <div class="leftv">
  <div class="righttitleword01 fontblue">是否删除</div>
  <div class="rightboxnone">
          <div class="inputicon"><input name="userAccount.isDeleted" type="radio" value="y" />是</div>
          <div class="inputicon"><input name="userAccount.isDeleted" type="radio" value="n" checked />
          否</div>
          <div class="c"></div>
        </div>
        </div>
        </div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav"></div>
        <div class="blank"></div>
        <div class="l">
          <div class="l">  	    </div>
  	  </div>
      <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  	<!--<a href="#">取 消</a>-->
		  	<input type="hidden" name="userAccount.id" value="<s:property value='#session.tempUser.id'/>"/>
		  	<input name="submit" type="submit" value="保 存"/>
    	  </div>
    	  <div class="l">  	    </div>
  	  </div>
      <span class="leftcreatesave01 iconbg">
      <input name="button" type="button" onClick="javascript:window.history.go(-1)" value="取 消" />
      </span></div>
    <!--right.end-->	</td>
	</form>
	<!-- right form end-->
  </tr>
</table>

<!--main.end-->
   
   
  </body>
</html>
