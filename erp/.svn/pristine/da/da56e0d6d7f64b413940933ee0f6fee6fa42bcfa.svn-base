<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>认筹汇总</title>
	
	<!--<link href="css/blue_new.css"  rel="stylesheet" type="text/css" charset="utf-8"/>-->
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	<script type="text/javascript">
		 $(document).ready(function(){
              $("#reusername").click(
                       function(){
                    	   alert('111');
                       var url = "./ajax_hengda!CheckName.action";                                        //这里设置Ajax将值传到哪个Action中，还需要在Struts.xml中配置
                       var params = {tips : $("#select1").val()}     //Ajax将会传给Action的参数
                       function callbackFn(data)                                               //定义一个回调函数
                          {
                    	   var state1 = eval("("+data+")");
                           var state2 = state1.state;
                    	   alert(state2);
                    	 
                          }
						  
                          $.post(url,params,callbackFn,'json');                           //就是通过这个POST方法，将值传到后台Action中
                            }
                          )
              })
	
	</script>
  </head>
  
  <body onLoad="clearSuggestion()">
   
   

<!--main-->
<table width="100%" border="0" cellspacing="0">
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

	        <div class="title02" >未售项目汇总</div>
            <div class="title01">&nbsp;</div>
			
			&nbsp;&nbsp;
			<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
			<!--
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入2</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入3</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
            <div class="title01"><a href="#">录入4</a></div>
            <div class="title02" style="display:none;"><a href="#">录入</a></div>
			-->
			
			
          <div class="c"></div>
          <div class="c"></div>
		  
		  
          <table >		  
		  
		  <!-- 搜索表单 top -->
       
       <form action="presale_hengda!searchPresaleAll.action" method="get">
		  
            <tr>
              <td width="0" nowrap bordercolor="#C4DAAB" >选择日期
                <input type="text" class="Wdate" onClick="WdatePicker()" id="createdTime" name="cond.monitorDate" value="${cond.monitorDate}"/>
                <input name="submit" type="submit" id="searchSubmit" onClick="return check();" value="  搜索  "/></td>
				<td>选择省份 
				<select name="cond.projectId" id="select1">
              	<s:iterator value="listCompanyProject" id="op1">
          	   		 <option value="4">
    		 			安徽合肥
            		 </option>
            		  <option value="5">
    		 			广东合营
            		 </option>
            		  <option value="10">
    		 			湖南合服
            		 </option>
            		 </s:iterator>
              </select>		 <input id="reusername" type="button" value="点击" />
                    	 <input type="text" id="recheck"/>	</td>
              <td height="0">选择项目:
              <select name="cond.projectId" id="select2">
              	<s:iterator value="listCompanyProject" id="op">
          	   		 <option value="<s:property value="#request.op.id"/>">
            		 	<s:property value="#request.op.projectName" />
            		 	
            		 </option>
            		 </s:iterator>
              </select>              </td>
            </tr>			
			
            <tr>
              
				  <td >&nbsp;</td> 
				  <td >&nbsp;</td>
				  <td height="0"><FONT color="red"><s:actionmessage/></FONT></td>
            </tr>
			  </form>
		  
		<!-- 搜索表单 end -->
			
            <tr>
              <td height="10" colspan="6">
              <div class="blueline"></div>              </td>
              </tr>		
			  	 
		<s:if test="#session.type == 2">
	 
            <tr>
              <td height="20" colspan="6">
			<!--   
			  操作： 	
				<input type="button" id="delete" value="删除" onClick="return delPre('presale_hengda')"/>
				
				
				<a href="#" target="_blank" onClick="return false">删除</a> ｜ 
				<a href="#" target="_blank" onClick="return false">增加</a> ｜  
				<a href="#" target="_blank" onClick="return false">追加</a> ｜  
				<a href="#" target="_blank" onClick="return false">批量删除</a>
				-->				</td>
            </tr>
		</s:if>
			
	
		
            <tr>
              <td colspan="6">			  
			  
			  <!--  列表 top -->
			  <div class="gbox1">			  
			  
			  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
   
      <td width="150">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80" align="center" valign="middle">销售公司</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=41"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=42"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>	  </td>
      </tr>
      </table></td>
      <td width="150">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80" align="center" valign="middle">项目</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=51"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=52"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>	  </td>
      </tr>
      </table></td>
    <td width="197">
	<table width="99" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80" align="center" valign="middle">日期</td>
        <td align="center" valign="middle">
		<table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=11"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=12"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></a></td>
          </tr>
        </table>	  </td>
      </tr>
      </table></td>
     <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80" align="center" valign="middle">来访电话</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=21"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=22"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
	
    <td width="188">
	<table width="100" height="28"  border="0" align="center" cellspacing="0">
      <tr>
        <td width="80" align="center" valign="middle">来访人数</td>
        <td align="center" valign="middle"><table width="5" border="0" cellspacing="0">
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=31"><img src="images/blue/upn.gif" width="9" height="10" border="0" /></a></td>
          </tr>
          <tr>
            <td><a href="presale_hengda!searchPresaleAll.action?ob=32"><img src="images/blue/downopen.gif" width="9" height="10" border="0" /></a></td>
          </tr>
        </table>	</td>
      </tr>
    </table></td>
     <td width="100" align="center" valign="middle">当天认筹</td>
     <td width="100" align="center" valign="middle">累计认筹</td>
  </tr>
  
  
   <s:iterator value="#request.listpre" id="c">  
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"> 
		
		<td align="center" valign="middle">
			<s:property value="#c.companyId_desc"/>		</td>
			<td align="center" valign="middle">
			<s:property value="#c.projectId_desc"/>		</td>
		
		<td align="center" valign="middle" class="fontblue">
			<a href="presale_hengda!updatePre_jsp.action?id=${id}"> <s:property value="#c.monitorDate"/>	</a>	</td>
		<td align="center" valign="middle">
			<s:property value="#c.phoneNum"/>		</td>
		<td align="center" valign="middle">
			<s:property value="#c.visitorNum"/>		</td>
		<td align="center" valign="middle">	
			<s:property value="#c.intentionNum"/>		</td>
		<td align="center" valign="middle">
			<s:property value="#c.intentionAll"/>					</td>
		<td align="center" valign="middle">					</td>
	  </tr>
    </s:iterator>
</table>
</div>

<!-- 列表 end --></td>
            </tr>
            <tr>
              <td colspan="6">
                <div class="manu">				</div>			</td>
            </tr>
            </table>
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
