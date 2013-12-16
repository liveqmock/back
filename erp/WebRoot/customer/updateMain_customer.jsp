<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>inputMain</title>
	
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
    
	<link href="../css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" />
	<link href="css/dialogForm.css" rel="stylesheet" type="text/css" />
		
	<script language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" language="javascript" src="js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="js/dialogFollow.js"></script>
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
			$("#follow").click(function(){
				
				$.ajax({
					type:"get",
					url: "./customer!getSomeForAddFollow.action",  //查询一些相关的数据
					dataType: "html",
					success: function(data){
						var followDialog = 
						 "<form action='./customer!addFollow.action'><table border='0'><tr><td>跟进类型:</td><td>"
						+ "<input name='customerFollow.followType' id='followType'/></td>"
						+ "<td><span id='followTypeSpan'></span></td></tr>"
						+ "<tr><td>跟进内容:</td><td>"
						+ "<textarea name='customerFollow.followDesc' id='followDesc'></textarea></td>"
						+ "<td><span id='followDescSpan'></span></td></tr>"
						+ "<tr><td>跟进日期:</td><td>"
						+ "<input class='Wdate' type='text' name='customerFollow.createdTime' id='createdTime' onClick='WdatePicker()' value='"
						+ data
						+ "'/></td>"
						+ "<td><span id='customerPwdSpan'></span></td></tr>"
						+ "<tr align='center'><td colspan='2'><input type='submit' value='提交'/></td></tr>"
						+ "</table></form>"
						;				
	
						var dialog = new Dialog(followDialog);	
						dialog.show();
					
					}
				});
				
				
			});
		
			
		});
					
		
	</script>
	


  </head>
  
  <body>
   
   
<!--main-->
<table width="100%" border="0" cellspacing="0" class="boxnav">
  <tr>

    <td width="290" align="left" valign="top" background="images/blue/leftbg.gif">
	
	<!--left.top-->
	
	<s:include value="left.jsp"></s:include>

    <!--left.end-->    </td>	
	
	<!-- right form top -->
	
	
    <td valign="top">
	
	<form action="./customer!updateCustomer.action" method="post" >
    <!--right-->	
    <div class="rightnav">
    	<div class="righttitle">
    	更新        </div>
    	<div class="r">
    	  <div class="leftcreatesave01 iconbg"><a href="./customer!doSomeForAddCustomer.action" target="_self">+ 新 建</a></div>
    	  <div class="l">  	    </div>
  	  </div>
<div class="rightlineg"></div>       
       
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">客户姓名</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" value="<s:property value='#session.c.customerName'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">客户来源</div>
  <div class="rightboxnone">
    <select name="customer.customerSource" id="customerSource" class="rightinputbox">
      <option value="0">客户来源</option>
    </select>
  </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">意向楼盘</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.intentEstate" id="intentEstate" class="leftcreateinputbox01" value="<s:property value='#session.c.intentEstate'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">客户状态</div>
  <div class="rightboxnone">

              <select name="customer.customerState" id="customerState" class="rightinputbox">
                <option value="0">客户状态</option>
              </select>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">联系电话</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.phone" id="phone" class="leftcreateinputbox01" value="<s:property value='#session.c.phone'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">家庭电话</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.homePhone" id="homePhone" class="leftcreateinputbox01" value="<s:property value='#session.c.homePhone'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">办公电话</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.officePhone" id="officePhone" class="leftcreateinputbox01" value="<s:property value='#session.c.officePhone'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">.性别</div>
  <div class="rightboxnone">

              <select name="customer.gender" id="gender" class="rightinputbox">
                <option selected="selected" value="男">男</option>
                <option value="女">女</option>
                <option value="0">未知</option>
              </select>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">电子邮件</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.email" id="email" class="leftcreateinputbox01" value="<s:property value='#session.c.email'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">同行人数</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.peerNumber" id="peerNumber" class="leftcreateinputbox01" value="<s:property value='#session.c.peerNumber'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">是否首次到场</div>
  <div class="rightboxnone">
          <div class="inputicon"><input name="customer.isFirst" type="radio" value="1" />是</div>
          <div class="inputicon"><input name="customer.isFirst" type="radio" value="0" />否</div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">是否提及关系</div>
  <div class="rightboxnone">
          <div class="inputicon"><input name="customer.isRelation" type="radio" value="1" />是</div>
          <div class="inputicon"><input name="customer.isRelation" type="radio" value="0" />否</div>
          <div class="c"></div>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">是否业主</div>
  <div class="rightboxnone">
          <div class="inputicon"><input name="customer.isOwner" type="radio" value="1" />是</div>
          <div class="inputicon"><input name="customer.isOwner" type="radio" value="0" />否</div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">客户背景</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.background" id="background" class="leftcreateinputbox01" value="<s:property value='#session.c.background'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">需求面积</div>
  <div class="rightboxnone">

              <select name="customer.requestArea" id="requestArea" class="rightinputbox">
                <option value="0">40平方以下</option>
				<option value="1">40-80平方</option>
				<option value="2">80平方以上</option>
              </select>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">投资额度</div>
  <div class="rightboxnone">

              <select name="customer.priceAmount" id="priceAmount" class="rightinputbox">
                <option value="1">100万</option>
				<option value="2">200万</option>
				<option value="3">300万</option>
              </select>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">影响客户购买原因</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox01" value="<s:property value='#session.c.buyReson'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">意向区域</div>
  <div class="rightboxnone">

              <select name="customer.intentionPart" id="intentionPart" class="rightinputbox">
                <option value="th">天河区</option>
				<option value="yx">越秀区</option>
				<option value="by">白云区</option>				
              </select>
        </div>
        </div>
        </div>
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">初步评级</div>
  <div class="rightboxnone">

              <select name="customer.rating" id="rating" class="rightinputbox">
                <option value="a">a级</option>
				<option value="b">b级</option>
				<option value="c">c级</option>				
              </select>
        </div>
        </div>
		
		<!-- more top -->
			<div class="leftv">
		  <div class="righttitleword01 fontblue">生日</div>
		  	<div class="rightboxnone">

              <input class="Wdate" type="text" id="birthday" name="customer.birthday" onClick="WdatePicker()" 
			  	value="<fmt:formatDate  value='${session.c.birthday }'  pattern='yyyy-MM-dd'/>"/>
			</div>
			</div>
			<!--  more end-->
        </div>
        <div class="leftcreatenav">
  <div class="righttitleword01 fontblue">备注1</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" value="<s:property value='#session.c.remark1'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftcreatenav">
  <div class="righttitleword01 fontblue">备注2  </div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.remark2" id="remark2" class="leftcreateinputbox02" value="<s:property value='#session.c.remark2'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        <div class="leftcreatenav">
  <div class="righttitleword01 fontblue">备注3</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.remark3" id="remark3" class="leftcreateinputbox02" value="<s:property value='#session.c.remark3'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
        
        
        <div class="leftcreatenav">
  <div class="righttitleword01 fontblue">备注4  </div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.remark4" id="remark4" class="leftcreateinputbox02" value="<s:property value='#session.c.remark4'/>"/>
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>		
		
        <div class="blank"></div>
        <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  <!--<a href="#">保 存</a>-->
		  <input type="hidden" name="customer.id" value="<s:property value='#session.c.id'/>"/>
		  <input type="submit" value=" 保 存 "/>
		  </div>
    	  <div class="l">  	    </div>
  	  </div>
	  
	  
      <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  	<!--<a href="#">取 消</a>-->
			<input type="button" value=" 取 消 " onClick="javascript:window.history.go(-1)" />
		  </div>
    	  <div class="l">  	    </div>
  	  </div>
	  
	   <div class="l">
    	  <div class="leftcreatesave01 iconbg">
			<input type="button" value=" 跟 进 " id="follow"/>
		  </div>
    	  <div class="l"></div>
  	  </div>
    </div>
    <!--right.end-->	
	</form>	
	
	<!-- follow top -->
	<!--
	<s:iterator value="#request.session.follows" id="f">		
		
		 <div class="leftcreatenav">
			<div class="leftv">
			  <div class="righttitleword01 fontblue">跟进类型</div>
				  <div class="rightboxnone">
					 
							<s:property value="#f.followType"/>
					  </div>
					
				</div>
			</div>
			
			<div class="leftv">
		  		<div class="righttitleword01 fontblue">跟进人</div>
		  			<div class="rightboxnone">

					 <s:property value="#f.followUser"/>
        		</div>
        	</div>
			
			<div class="leftv">
		  		<div class="righttitleword01 fontblue">跟进内容</div>
		  			<div class="rightboxnone">
						<s:property value="#f.followDesc"/>
					  
        		</div>
        	</div>
			
        </div>
	</s:iterator>
	-->
	
	 
	
	
	<!-- follow end -->
	
	</td>
	
	<!-- right form end-->
  </tr>
  
  
</table>

<!--main.end-->
   
   
  </body>
</html>
