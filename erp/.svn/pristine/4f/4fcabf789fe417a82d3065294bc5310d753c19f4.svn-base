<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!--  <base href="<%=basePath%>">-->
    
    <title>indexMain.jsp</title>
	<link href="../css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" />
	
  </head>
	<script type="text/javascript">
		
		
	</script>
  
  
  <body>
    
    

<!--main-->
<table width="100%" border="0" cellspacing="0" class="boxnav">
 <tr>  
      <td width="290" align="left" valign="top" background="images/blue/leftbg.gif">
	  
	<!--left.top-->
	
	<s:include value="../customer/left.jsp"></s:include>

    <!--left.end-->	
    </td>
    <!--right-->
    <td>
    <div class="rightnav">
    	<div class="righttitle">
    	用户主页        </div>
       <!-- <div class="rightword01">
        <div class="l"><strong>视图：</strong></div>
        <div class="rightbox">
            <form id="form2" name="form2" method="post" action=""  >
              <select name="select" id="select" class="rightinputbox">
                <option>我的用户</option>
              </select>
            </form>
        </div>
        <div class="l"><a href="#" target="_blank">编辑</a> | <a href="#" target="_blank">新建视图</a></div>
        <div class="c"></div>
        </div>-->
        <div class="rightlineg"></div>
        <div class="rightboxn">
        <div class="righttitleword fontblue">查询用户</div>
<div class="r">
  <div class="leftcreatesave iconbg"><a href="<%=request.getContextPath() %>/addUserAccountJsp.action" target="_self"">+ 新 建</a></div>
          <!--<div class="l">
            <form id="form3" name="form2" method="post" action=""  >
              <select name="select2" id="select2" class="rightinputbox">
                <option>最近查看</option>
              </select>
            </form>
          </div>-->
</div>
       <div class="rightlineg"></div>

        <form action="indexUserAccount.action" method="post">
       	<div class="1">
       	
      	 <input name="userCond.userName" type="text" id="findName" value="${userCond.userName}" maxlength="10"/>
    	<!--<input id="condid" name="userCond.orderByFiled" value="11"/> -->
    		<input name="submit"  type="submit" value="搜索"/>
    		</div>
    		
    		
    	 <!-- <select name="findCompany" id="findCompany" class="rightinputbox">
    	   	  <option value="">选择公司</option>
             	<s:iterator value="companyList">
             		<option value="companyId"><s:property value="companyName"/></option>
             	</s:iterator>
            </select>
            <select name="findProject" id="findProject" class="rightinputbox">
            <option value="">选择项目</option>
              <s:iterator value="teamList">
             		<option value=""><s:property value="teamName"/></option>
           	  </s:iterator>
            </select>
              <input name="reset" type="reset" value="重置"/>-->
            
            <div  align="center"></div>
          </form>
        <!-- 搜索表单 end -->
		  
		  
          <div class="c"></div>
          
        <div>
        <table width="100%" border="0" cellspacing="0">
  <tr>
    <td height="37" colspan="10" bgcolor="#fbfbfb"><div class="tableword">操作： 
	<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
	<a href="#" target="_blank" onClick="return false">增加</a> ｜  
	<a href="#" target="_blank" onClick="return false">追加</a> ｜  
	<a href="#" target="_blank" onClick="return false">批量删除</a></div>
    <div class="r">
	
	<s:property value="showPage" escape="false"/>
  <!-- 
    <div class="r">
    <div class="l"><a href="#"><img src="<%=path%>/images/blue/arrow01.gif" width="24" height="20" border="0" /></a></div>
    <div class="l"><a href="#"><img src="<%=path%>/images/blue/arrow02.gif" width="20" height="20" border="0" /></a></div>
    <div class="l" style="font-size:12px; margin-left:5px; margin-right:5px;">(1-20 的 82)</div>
    <div class="l"><a href="#"><img src="<%=path%>/images/blue/arrow03.gif" width="20" height="20" border="0" /></a></div>
    <div class="l"><a href="#"><img src="<%=path%>/images/blue/arrow04.gif" width="24" height="20" border="0" /></a></div>
    </div>
    <div class="c"></div>    </td>
    </tr> -->
  <tr>
    <td width="50" height="30" background="images/blue/tablebg.gif">
      <div class="tablebg01"><input name="" type="checkbox" value="" /></div>      </td>
   <!--  <td width="114" align="center" valign="middle" background="images/blue/tablebg.gif">是否可用</td> -->
     <td width="114" align="right" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">是否可用</div>
      </td>
  
     <td width="140" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">姓    名</div>
      <div class="l">
        <div></div>
        <div></div>
      </div></td>
    <td width="114" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">所属公司</div>
      <div class="l">
        <div><a href="indexUserAccount.action?ob=21"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>
        <div><a href="indexUserAccount.action?ob=22"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></div>
      </div></td>
    <td width="140" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">所属项目</div>
      <div class="l">
        <div><a href="indexUserAccount.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>
        <div><a href="indexUserAccount.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></div>
      </div></td>
       </div></td>
    <td width="114" align="center" valign="middle" background="images/blue/tablebg.gif"><div class="l" style="margin-left:5px;">用户账号</div>
      <div class="l">
        <div><a href="indexUserAccount.action?ob=11" onClick=""><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></div>
        <div><a href="indexUserAccount.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></div>
      </div></td>
    <td width="26" align="center" valign="middle" background="images/blue/tablebg.gif">&nbsp;</td>
    <td width="49" height="30" align="center" valign="middle" background="images/blue/tablebg.gif">&nbsp;</td>
    <td width="29" height="30" align="center" valign="middle" background="images/blue/tablebg.gif">&nbsp;</td>
    <td width="32" align="center" valign="middle" background="images/blue/tablebg.gif">&nbsp;</td>
  </tr>
  
  
  <!-- 列表 top -->
  
 
 <s:iterator value="userAccountList" id="userlist" >
				<tr>
					<td height="30" align="center" valign="middle"><input name="input" type="checkbox" value="" /></td>
					
					
					<td width="48" height="30" align="left" valign="middle">
						<s:param name="temp" id="temp" value="123456"></s:param>
						<s:if test="#userlist.isDeleted == 0" >
					 	 	正常
					  	</s:if>
					  	<s:else>
					  		禁用
					  	</s:else>
					</td>
					
					
					<td width="140" height="30" align="left" valign="middle">
					 	 	<s:property id="realname" value="realName"/>
					   </td>

		
					   <td width="140" height="30" align="left" valign="middle">
					   <s:iterator value="companyList" id="company" >
					   
					  	<s:if test="#company.id == #userlist.companyId" >
					 	 	<s:property id="company" value="companyName"/>
					  	</s:if>
						
						 </s:iterator>
					   </td>
		
					
	
					   <td width="140" height="30" align="left" valign="middle">
					  
					   <s:iterator value="projectList" id="project" >
					   
					  	<s:if test="#project.id == #userlist.projectId" >
					 	 	<s:property id="project" value="projectName"/>
					  	</s:if>
						
						 </s:iterator>
					   
					   </td>
						
						
					   <td width="114" height="30" align="left" valign="middle"class="fontblue">
					<a href="<%=request.getContextPath() %>/updateUserAccountJsp.action?id=${id}"  target="_self">
					<s:property value="userName"/></a></td>
    					<td height="30" align="center" valign="middle">&nbsp;</td>
    					<td height="30" align="center" valign="middle">&nbsp;</td>
   						 <td height="30" align="center" valign="middle">&nbsp;</td>
				</tr>
   <!-- 列表 end -->
  </s:iterator> 
  			
			<tr></tr>
			
        </table>
        </div>
      </div>
    </div>
    <!--<div class="rightnav1">
      <div class="rightboxn">
        <div class="righttitleword fontblue">报表</div>
<div class="r">
  <a href="#" target="_blank">X</a></div>
        <div class="rightlineg"></div>
        <ul>
        <li><a href="#" target="_blank">已户用用户</a></li>
<li><a href="#" target="_blank">有last活动 > 30天的用户</a></li>
<li><a href="#" target="_blank">用户所有人</a></li>
<li><a href="#" target="_blank">联系人角色报表</a></li>
<li class="fontblue"><a href="#" target="_blank">转至报表  >></a></li>
        </ul>
      </div>
    </div>
    <div class="rightnav2">
      <div class="rightboxn">
        <div class="righttitleword fontblue">工具</div>
<div class="r" >
  <a href="#" target="_blank">X</a></div>
        <div class="rightlineg"></div>
        <ul>
        <li><a href="#" target="_blank">导入我的用户 &amp; 联系人</a></li>
         <li><a href="#" target="_blank">导入我的组织的用户 &amp; 联系人</a></li>  
          <li><a href="#" target="_blank">批量删除用户</a></li>
          <li><a href="#" target="_blank">转移用户</a></li>
          <li><a href="#" target="_blank">合并用户</a></li>
        </ul>
      </div>
    </div>
    <!--right.end--></td>
  </tr>
</table>

<!--main.end-->

  </body>
</html>
