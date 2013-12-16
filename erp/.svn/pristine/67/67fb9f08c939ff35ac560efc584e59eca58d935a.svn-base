<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>录入</title>
	
	<link href="css/tianluan.css"  rel="stylesheet" type="text/css" charset="utf-8"/>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 
	<script type="text/javascript" language="javascript"
			src="<%=path %>/js/jquery-1.3.1.js"></script>
     <script type="text/javascript" language="javascript"
				src="<%=path %>/js/jquery.validate.js"></script>
     <script src="<%=path %>/js/jquery.validate.messages_cn.js" type="text/javascript"></script>  
      <script src="<%=path %>/js/jquery.metadata.js" type="text/javascript"></script>
      <style type="text/css">

em.error { color: red;   }


</style>
	 <script type="text/javascript">
  $(document).ready(function(){

	$("#commentForm").validate({
		rules: {
			'presaleMonitor.phoneNum': {
				required: true,
				digits:true
				
			},
			'presaleMonitor.visitorNum': {
				required: true,
				digits:true
			},
			'presaleMonitor.intentionNum': {
				required: true,
				digits:true
			},
			'presaleMonitor.monitorDate': {
				required: true,
				dateISO: true
			}
		},
		
		messages: {
			'presaleMonitor.phoneNum': {
				required: '不能为空',
				digits: '请输入自然数'
			},
			'presaleMonitor.visitorNum': {
				required: '不能为空',
				digits: '请输入自然数'
			},
			'presaleMonitor.intentionNum': {
				required: '不能为空',
				digits: '请输入自然数'
			},
			'presaleMonitor.monitorDate': {
				required: '不能为空',
				dateISO: '请输入正确格式的日期'
			}
		},	
		
		errorElement: "em", //可以用其他标签，记住把样式也对应修改
		success: function(label) {
			//label指向上面那个错误提示信息标签em
			label.text(" ")				//清空错误提示消息
					//加上自定义的success类
		}

	  });

  });
  </script>
  </head>
  
  <body onLoad="clearSuggestion()">
   
   
<!--main-->
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
  <tr>
  
 	<!--left.top-->
	
	<s:include value="../left.jsp"></s:include>

    <!--left.end-->	
  
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
		
        	
	        <div class="title01" ><a href="./presale_hengda!indexPresale.action" target="_self">查询认筹</a></div>
            <div class="title02"><a href="./presale_hengda!addPresale.action" target="_self">新建认筹</a></div>			
			 
			
			<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
		
		
		<!-- right form top -->
	<form id="commentForm" class="registerform" action="<%=request.getContextPath() %>/presale_hengda!addPresale.action" method="post" >	
			
          <div class="c"></div>
          <div class="c">
		  	 &nbsp;&nbsp;	
			<font color="#FF0000"><span id="suggestion"><s:property value="#session.suggestion"/></span></font>
		  </div>
		  
		  	  
		  
           <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
		   
		   	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td width="100" align="right" id="t15">来访电话:(次)</td>
                <td  colspan="5">
                	
                		<input type="text" name="presaleMonitor.phoneNum" maxlength="8"/>
					
       				</td>
                		
              </tr>
			  
			  
             <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t13">来访人数:(次)</td>
                <td  colspan="5">
					<input type="text" name="presaleMonitor.visitorNum"  maxlength="8"/></td>
               
              </tr>
			  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t13">认筹数:(次)</td>
                <td  colspan="5">
					<input type="text" name="presaleMonitor.intentionNum"  maxlength="8"/></td>
               
              </tr>
             
              
              <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
                <td align="right" id="t7">来访日期:</td>
                <td id="t8" colspan="5">
                <input type="text" class="Wdate" onClick="WdatePicker()" id="createdTime" name="presaleMonitor.monitorDate" value=""/>
                </td>
              </tr>
			  
			  
      
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
			<td id="t7">&nbsp;</td>
			<td id="t8" colspan="5">				
				</td>
		  </tr>
		  
		
	  
	  
	  
	  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; align="center">
	  <td></td>
		<td colspan="5" align="left">
		  <input type="submit" value="保 存" id="sub"/>
			&nbsp;&nbsp;
		  <input type="button" value="取 消" onClick="javascript:window.location.href = './presale_hengda!indexPresale.action?ob=11'" />
&nbsp;&nbsp;	<FONT color="red"><s:actionmessage/></FONT>	 </td>
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
