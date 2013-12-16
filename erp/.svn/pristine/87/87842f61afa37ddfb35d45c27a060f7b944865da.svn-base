<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
    
    <title>inputMain</title>
    
	<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
	
	<link href="../css/blue.css" rel="stylesheet" type="text/css" charset="utf-8" />
	<link href="css/dialogForm.css" rel="stylesheet" type="text/css" />
	
	<script language="javascript" type="text/javascript" src="./My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	<script type="text/javascript" language="javascript" src="./js/dialogFollow.js"></script>
	<script type="text/javascript" language="javascript" src="./js/customer.js"></script>

  </head>
  
  <body onLoad="clearSuggestion()">
   
   
<!--main-->
<table width="100%" border="0" cellspacing="0" class="boxnav">
  <tr>

    <td width="290" align="left" valign="top" background="images/blue/leftbg.gif">
	
	<!--left.top-->
	
	<s:include value="left.jsp"></s:include>

    <!--left.end-->	
    </td>
	
	
	<!-- right form top -->
	<form class="registerform" action="<%=request.getContextPath() %>/customer!updateCustomer.action" method="post" >
	
    <td valign="top">
    <!--right-->	
    <div class="rightnav">
    	<div class="righttitle">
    	更新 &nbsp;&nbsp;
		 <s:radio list="selCustomerState" name="customer.customerState"  value="#session.c.customerState"/> 
		  &nbsp;&nbsp;
		<font color="#FF0000"><span id="suggestion"><s:property value="#request.suggestion"/></span></font>
        </div>
		
		<!--
    	<div class="r">
    	  <div class="leftcreatesave01 iconbg">

			  <a href="./customer!doSomeForAddCustomer.action" target="_self">+ 新 建</a>
			
		  </div>
    	  <div class="l">    	   
  	    </div>
  	  </div>
	  -->
	  
<div class="rightlineg"></div>       
       
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>客户姓名</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20" value="<s:property value='#session.c.customerName'/>"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
       <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>性别</div>
  <div class="rightboxnone">

		  
			  <s:select list="selGender"  name="customer.gender" value="#session.c.gender"/>

        </div>
        </div>
		
		 <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>年龄</div>
 <div class="rightboxnone">
			  
  
			  <s:select list="selAgeRange"  name="customer.age" value="#session.c.age"/>

            
        </div>
        </div>
		
        </div>
		
		
		
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue">&nbsp;身份证&nbsp;</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox01" value="<s:property value='#session.c.idcardNo'/>"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
       		
		 <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>联系电话1</div>
  <div class="rightboxnone">
            
			   <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" value="<s:property value='#session.c.phone'/>"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
            </div>
        </div>
		
		  <div class="leftv">
  <div class="righttitleword01 fontblue">联系电话2</div>
  <div class="rightboxnone">
            
			   <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01" value="<s:property value='#session.c.homePhone'/>"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
            </div>
        </div>
		
        </div>
		
		
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>从事行业</div>
  <div class="rightboxnone">
			  
			  
			  <s:select list="selJobType"  name="customer.jobIndustry" value="#session.c.jobIndustry"/>

        </div>
        </div>
		
       		

  <div class="righttitleword01 fontblue"><font color="red">*</font>行业背景描述</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.jobDesc" id="jobDesc" class="leftcreateinputbox02" value="<s:property value='#session.c.jobDesc'/>" style="width:auto"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>

		
		
        </div>
		
		
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>居住区域</div>
  <div class="rightboxnone">
          			  
	  
			  <s:select list="selCustomerRegion"  name="customer.customerRegion" value="#session.c.customerRegion"/>

        </div>
        </div>
		
		
		 <div class="righttitleword01 fontblue">客户外貌特征描述</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.faceLook" id="faceLook" class="leftcreateinputbox02" value="<s:property value='#session.c.faceLook'/>" style="width:auto"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
		
		
        </div>
		
		
        <div class="leftcreatenav">		
		
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>是否提及关系</div>
  <div class="rightboxnone">
          <div class="inputicon">		
		  
		  <s:radio list="#{'1':'是','0':'否'}" name="customer.isRelation" value="#session.c.isRelation"/>
		  
		  </div>
          
          <div class="c"></div>
        </div>
        </div>
		
	
		
		<div class="righttitleword01 fontblue"><span id="red"></span>关系描述</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                
                <s:if test="#session.c.isRelation==1">
                	<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02"  
                		value="<s:property value='#session.c.relationDesc'/>" style="width:auto"/>
                </s:if>
                <s:else>
                	<input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" disabled="disabled"
                		value="<s:property value='#session.c.relationDesc'/>"  style="width:auto"/>
                </s:else>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
				
        </div>
		
		<div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue"><font color="red">*</font>获知途径</div>
  <div class="rightboxnone">
  
		 <s:checkboxlist list="selKnownFrom" name="knownFrom" value="#session.knowns"/>
		
  	<!--

	 
          <div class="inputicon"><input name="knownFrom" type="checkbox" value="1" />户外</div>
          <div class="inputicon"><input name="knownFrom" type="checkbox" value="2" />电话</div>
          <div class="inputicon"><input name="knownFrom" type="checkbox" value="3" />短信</div>
          <div class="inputicon"><input name="knownFrom" type="checkbox" value="4" />报刊</div>
          <div class="inputicon"><input name="knownFrom" type="checkbox" value="5" />杂志</div>
          <div class="inputicon"><input name="knownFrom" type="checkbox" value="6" />朋友介绍</div>
          <div class="inputicon"><input name="knownFrom" type="checkbox" value="7" />业主介绍</div>	
    -->
  		
			
			
		  
          <div class="c"></div>
        </div>
        </div>
      </div>
		
		
		<div class="leftcreatenav">
  <div class="righttitleword01 fontblue"><font color="red">*</font>客户兴趣爱好</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.interest" id="interest" class="leftcreateinputbox02" value="<s:property value='#session.c.interest'/>"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
	   

        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>需求面积</div>
  <div class="rightboxnone">
			  
	  
			  <s:select list="selRequestArea"  name="customer.requestArea" value="#session.c.requestArea"/>

            
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">户型需求</div>
  <div class="rightboxnone">


			  <s:select list="selRoomType"  name="customer.roomType" value="#session.c.roomType"/>

			
        </div>
        </div>
        </div>
		
		
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>预算总价</div>
  <div class="rightboxnone">
           
			  
			  <s:select list="selPriceAmount"  name="customer.priceAmount" value="#session.c.priceAmount"/>

            
        </div>
        </div>
        <div class="leftv">
		  <div class="righttitleword01 fontblue"><font color="red">*</font>购房目的</div>
		  <div class="rightboxnone">

	  
			  <s:select list="selBuyAim"  name="customer.buyAim" value="#session.c.buyAim"/>
      
            
        </div>
        </div>
        </div>
		
		<!-- more top 
			<div class="leftcreatenav">
			
				
				
				<div class="leftv">
			  <div class="righttitleword01 fontblue">生日</div>
				<div class="rightboxnone">
	
				  <input class="Wdate" type="text" id="birthday" name="customer.birthday" onClick="WdatePicker()"/>
				
				</div>
				</div>
				 
				
			</div>
		 more end-->
		 
		 
		 
		
		
        <div class="leftcreatenav">
  <div class="righttitleword01 fontblue">客户对产品及项目认可方面</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox02" value="<s:property value='#session.c.buyReson'/>"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
		
       
		 <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>购房付款方式</div>
  <div class="rightboxnone">
  
           <s:select list="selPayType"  name="customer.payType" value="#session.c.payType"/>
			  
			  
        </div>
        </div>		
		
        </div>
		
		
       <div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue"><font color="red">*</font>所选单位1</div>
  <div class="rightboxnone">

          <div class="inputicon"><input type="text" id="building1" name="recRoom1.building" value="<s:property value='#session.recRoom1.building'/>"/>栋</div>
          <div class="inputicon"><input type="text" id="room1" name="recRoom1.room" value="<s:property value='#session.recRoom1.room'/>"/>单元,</div>
		  <div class="inputicon">原价<input type="text" id="originalPrice1" name="recRoom1.originalPrice" value="<s:property value='#session.recRoom1.originalPrice'/>"/>万元,</div>
		  <div class="inputicon">折扣<input type="text" id="discountDesc1" name="recRoom1.discountDesc" value="<s:property value='#session.recRoom1.discountDesc'/>"/></div>

          <div class="c"></div>
        </div>
        </div>
      </div>
	  
	   <div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue">所选单位2</div>
  <div class="rightboxnone">

		  <div class="inputicon"><input type="text" id="building2" name="recRoom2.building" value="<s:property value='#session.recRoom2.building'/>"/>栋</div>
          <div class="inputicon"><input type="text" id="room2" name="recRoom2.room" value="<s:property value='#session.recRoom2.room'/>"/>单元,</div>
		  <div class="inputicon">原价<input type="text" id="originalPrice2" name="recRoom2.originalPrice" value="<s:property value='#session.recRoom2.originalPrice'/>"/>万元,</div>
		  <div class="inputicon">折扣<input type="text" id="discountDesc2" name="recRoom2.discountDesc" value="<s:property value='#session.recRoom2.discountDesc'/>"/></div>	  
		  
    

          <div class="c"></div>
        </div>
        </div>
      </div>
	  
	   <div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue">所选单位3</div>
  <div class="rightboxnone">
		  
          <div class="inputicon"><input type="text" id="building3" name="recRoom3.building" value="<s:property value='#session.recRoom3.building'/>"/>栋</div>
          <div class="inputicon"><input type="text" id="room3" name="recRoom3.room" value="<s:property value='#session.recRoom3.room'/>"/>单元,</div>
		  <div class="inputicon">原价<input type="text" id="originalPrice3" name="recRoom3.originalPrice" value="<s:property value='#session.recRoom3.originalPrice'/>"/>万元,</div>
		  <div class="inputicon">折扣<input type="text" id="discountDesc3" name="recRoom3.discountDesc" value="<s:property value='#session.recRoom3.discountDesc'/>"/></div>	 

          <div class="c"></div>
        </div>
        </div>
      </div>
		
		
		 <div class="leftcreatenav">
  <div class="righttitleword01 fontblue"><font color="red">*</font>客户购买抗性</div>
  <div class="rightboxnone">

          <div class="rightboxm02" style="width:auto">
		  
				<textarea id="notBuyReson" name="customer.notBuyReson" rows="3" cols="50"><s:property value='#session.c.notBuyReson'/></textarea>
              
          </div>
        </div>
        </div>
		
        <div class="leftcreatenav">
  <div class="righttitleword01 fontblue"><font color="red">*</font>备注</div>
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
		
		
        <div class="blank"></div>
        <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  <!--<a href="#">保 存</a>-->
		  <input type="hidden" name="customer.id" value="<s:property value='#session.c.id'/>"/>
		  
		  <input type="submit" value="保 存" id="sub"
		  	<s:if test="#session.c.customerState == 2"> 
		  	disabled="disabled"
		  	</s:if>
		  />
		  
		  </div>
    	  <div class="l">

  	      
  	    </div>
  	  </div>
	  
      <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  	<!--<a href="#">取 消</a>-->
			<input type="button" value="取 消" onClick="javascript:window.location.href = './customer!searchCustomer.action?from=return'" />
		  </div>
    	  <div class="l"></div>
  	  </div>
	  
	  <div class="l">
    	  <div class="leftcreatesave01 iconbg">
			<input type="button" value=" 跟 进 " id="follow" ac="customer"
				<s:if test="#session.c.customerState == 2"> 
			  	disabled="disabled"
			  </s:if>
			/>
		  </div>
    	  <div class="l"></div>
  	  </div>
	  
	   <div>
    	  <div class="leftcreatesave01 iconbg2">
			<font color="#FF0000"><span id="tip"></span></font>
		  </div>  	      
  	    </div>
  	  </div>
	  
	
	  
    </div>
    <!--right.end-->	
	
	
	</form>
	<!-- right form end-->
	
	
	
	<!-- follow top -->

	
		
	 <div class="leftcreatenav" >
		<div class="leftv3" style="background-color:#CCCCCC">
		  <div class="righttitleword01 fontblue">跟进类型</div>
			  <div class="rightboxnone"></div>
				
		</div>
		
		<div class="leftv3" style="background-color:#CCCCCC">
			<div class="righttitleword01 fontblue">跟进人</div>
				<div class="rightboxnone"></div>
		</div>
		
		<div class="leftv3" style="background-color:#CCCCCC">
			<div class="righttitleword01 fontblue">跟进内容</div>
				<div class="rightboxnone"></div>
		</div>
		
		<div class="leftv3" style="background-color:#CCCCCC">
			<div class="righttitleword01 fontblue">跟进日期</div>
				<div class="rightboxnone"></div>
		</div>
		
	</div>
	<!-- 标题 end-->
	
	<s:iterator value="#request.session.follows" id="f">	
	 <div class="leftcreatenav">
		<div class="leftv3">
			  <div class="rightboxnone">
				 
						<s:property value="#f.followType"/>
				  </div>
				
			</div>
		</div>
		
		<div class="leftv3">

				<div class="rightboxnone">

				 <s:property value="#f.isDeleted"/>
			</div>
		</div>
		
		
		<div class="leftv3">

				<div class="rightboxnone">
					<s:property value="#f.followDesc"/>
				  
			</div>
		</div>
		
			<div class="leftv3">

				<div class="rightboxnone">
					<s:date name="#f.modTime" format="yyyy-MM-dd "/> 
				  
			</div>
		</div>
		
	</div>

	</s:iterator>
	
	 
	
	
	<!-- follow end -->
	
	</td>
	
  </tr>
  
 
   
</table>

<!--main.end-->
   
   
  </body>
</html>
