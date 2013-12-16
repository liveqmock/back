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
    
	<!-- <link href="../css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" /> -->
	

  </head>
  
  <body onLoad="clearSuggestion()">
   
   
<!--main-->
<table width="100%" border="0" cellspacing="0" class="boxnav">
  

    <td width="290" align="left" valign="top" background="images/blue/leftbg.gif">
	
	<!--left.top-->
	
	<s:include value="../customer/left.jsp"></s:include>

    <!--left.end-->	
    </td>
	
	
	<!-- right form top -->
	<form action="<%=request.getContextPath() %>/addUserAccount.action" method="post" >
	
    <td valign="top">
    <!--right-->	
    <div class="rightnav">
    	<div class="righttitle">
    	录入 &nbsp;&nbsp;<span id="suggestion"><s:property value="#request.suggestion"/></span>
        </div>
    	<div class="r">
    	  <div class="leftcreatesave iconbg"><a href="<%=request.getContextPath() %>/addUserAccountJsp.action" target="_self"">+ 新 建</a></div>
    	  <div class="l">    	   
  	    </div>
  	  </div>
<div class="rightlineg"></div>       
       <div class="leftcreatenav">
       <div class="leftv">
  <div class="righttitleword01 fontblue">姓名</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="userAccount.realName" id="realName" class="leftcreateinputbox01" maxlength="30"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
       
       </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">账户</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="userAccount.userName" id="userName" class="leftcreateinputbox01" maxlength="30"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
          <div class="righttitleword01 fontblue">密码</div>
          <div class="rightboxnone">
            <div class="rightboxl"></div>
            <div class="rightboxm01">
              <label for="textfield"></label>
             <!--   <input type="text" name="userAccount.userPwd" id="intentEstate" class="leftcreateinputbox01"/>-->
              <input maxlength="30" name="userAccount.userPwd" onKeyUp="value=value.replace(/[\W]/g,'') " onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))" onKeyDown="if(event.keyCode==13)event.keyCode=9"> 
            </div>
            <div class="rightboxr"></div>
            <div class="c"></div>
          </div>
        </div>
        </div>
        <div class="leftcreatenav"></div>
        <input type="hidden" name="userAccount.companyId" value="1"/>
        <input type="hidden" name="userAccount.teamId" value="1"/>
      <!--  <div class="leftcreatenav">
          <div class="leftv">
          <div class="righttitleword01 fontblue">选择公司</div>
          <div class="rightboxnone">
            <select name="userAccount.companyId" id="select1" class="rightinputbox">
            <s:iterator value="companyList">
            	 <option value="${id}">
            	 	<s:property value="companyName"/>
            	 </option>
            </s:iterator>
            </select>
          </div>
        </div>
          <div class="leftv">
            <div class="righttitleword01 fontblue">所属组别</div>
            <div class="rightboxnone">
              <select name="userAccount.teamId" id="select2" class="rightinputbox">
                <s:iterator value="teamList">
            	 <option value="${id}">
            	 	<s:property value="teamName"/>
            	 </option>
            </s:iterator>
              </select>
            </div>
          </div>
        </div>-->
        <div class="leftcreatenav">
          <div class="leftv">
            <div class="righttitleword01 fontblue">所属项目</div>
            <div class="rightboxnone">
              <select name="userAccount.projectId" id="select3" class="rightinputbox">
          	   		 <option value="1">
            		 	天銮
            		 </option>
               	<!--   <s:iterator value="projectList">
            		 <option value="${id}">
            		 	<s:property value="projectName"/>
            		 </option>
          		  </s:iterator>
          		  -->
              </select>
            </div>
          </div>
        </div>
        <div class="leftcreatenav"></div>
        <div class="leftcreatenav"></div>
        <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  <!--<a href="#">保 存</a>-->
		<input name="提交" type="submit" value="保存"/>
		  </div>
    	  <div class="l">

  	      
  	    </div>
  	  </div>
      <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		
			<!--<input name="重置" type="reset" onClick="javascript:window.location.href = './customer!login.action'" value="取 消" />-->
			<input type="reset" value = "重置"/>
		  </div>
    	  <div class="l">

  	      
  	    </div>
  	  </div>
    </div>
    <!--right.end-->	
	
	</td>
	
	
	<form>
	<!-- right form end-->
	
	
  </tr>
   
</table>

<!--main.end-->
   
   
  </body>
</html>
