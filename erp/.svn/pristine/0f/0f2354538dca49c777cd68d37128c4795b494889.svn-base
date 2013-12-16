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
	
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	
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
	<form class="registerform" action="<%=request.getContextPath() %>/customer!addCustomer.action" method="post" >
	
    <td valign="top">
    <!--right-->	
    <div class="rightnav">
    	<div class="righttitle">
    	录入 &nbsp;&nbsp;
		 <s:radio list="selCustomerState" name="customer.customerState" value="1"/>
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
                <input type="text" name="customer.customerName" id="customerName" class="leftcreateinputbox01" maxlength="20"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
       <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>性别</div>
  <div class="rightboxnone">

		  
			  <s:select list="selGender"  name="customer.gender" value="%{customer.gender}" />

        </div>
        </div>
		
		 <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>年龄</div>
 <div class="rightboxnone">
			  
  
			  <s:select list="selAgeRange"  name="customer.age" value="%{customer.age}" />

            
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
                <input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox01"/>
              
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
                 <input type="text" id="phone" name="customer.phone" class="leftcreateinputbox01" maxlength="12"/>
              
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
                 <input type="text" id="homePhone" name="customer.homePhone" class="leftcreateinputbox01"/>
              
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
         
			  
			  
			  <s:select list="selJobType"  name="customer.jobIndustry" value="%{customer.jobIndustry}" />

        </div>
        </div>
		
       		

  <div class="righttitleword01 fontblue"><font color="red">*</font>行业背景描述</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.jobDesc" id="jobDesc" class="leftcreateinputbox02" style="width:auto"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>

		
		
        </div>
		
		
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>居住区域</div>
  <div class="rightboxnone">
          			  
	  
			  <s:select list="selCustomerRegion"  name="customer.customerRegion" value="%{customer.customerRegion}" />

        </div>
        </div>
		
		
		 <div class="righttitleword01 fontblue">客户外貌特征描述</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.faceLook" id="faceLook" class="leftcreateinputbox02" style="width:auto"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
		
		
        </div>
		
		
        <div class="leftcreatenav">		
		
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>是否提及关系</div>
  <div class="rightboxnone">
          <div class="inputicon"><input name="customer.isRelation" type="radio" value="1" id="yes"/>是</div>
          <div class="inputicon"><input name="customer.isRelation" type="radio" value="0" id="no"/>否</div>
          <div class="c"></div>
        </div>
        </div>
		
	
		
		<div class="righttitleword01 fontblue"><span id="red"></span>关系描述</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.relationDesc" id="relationDesc" class="leftcreateinputbox02" style="width:auto"/>
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
				
        </div>
		
		<div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue"><font color="red">*</font>获知途径</div>
  <div class="rightboxnone">
  
		 <s:checkboxlist list="selKnownFrom" name="knownFrom" value="%{customer.knownFrom}"/>
		
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
                <input type="text" name="customer.interest" id="interest" class="leftcreateinputbox02" />
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
	   

        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>需求面积</div>
  <div class="rightboxnone">
			  
	  
			  <s:select list="selRequestArea"  name="customer.requestArea" value="%{customer.requestArea}" />

            
        </div>
        </div>
        <div class="leftv">
  <div class="righttitleword01 fontblue">户型需求</div>
  <div class="rightboxnone">


			  <s:select list="selRoomType"  name="customer.roomType" value="%{customer.roomType}" />

			
        </div>
        </div>
        </div>
		
		
        <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>预算总价</div>
  <div class="rightboxnone">
           
			  

			  <s:select list="selPriceAmount"  name="customer.priceAmount" value="%{customer.priceAmount}" />

            
        </div>
        </div>
        <div class="leftv">
		  <div class="righttitleword01 fontblue"><font color="red">*</font>.购房目的</div>
		  <div class="rightboxnone">

	  
			  <s:select list="selBuyAim"  name="customer.buyAim" value="%{customer.buyAim}" />
      
            
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
                <input type="text" name="customer.buyReson" id="buyReson" class="leftcreateinputbox02" />
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
		
       
		 <div class="leftcreatenav">
        <div class="leftv">
  <div class="righttitleword01 fontblue"><font color="red">*</font>购房付款方式</div>
  <div class="rightboxnone">
  
           <s:select list="selPayType"  name="customer.payType" value="%{customer.payType}" />
			  
			  
        </div>
        </div>		
		
        </div>
		
		
       <div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue"><font color="red">*</font>所选单位1</div>
  <div class="rightboxnone">

          <div class="inputicon"><input type="text" id="building1" name="recRoom1.building"/>栋</div>
          <div class="inputicon"><input type="text" id="room1" name="recRoom1.room"/>单元,</div>
		  <div class="inputicon">原价<input type="text" id="originalPrice1" name="recRoom1.originalPrice"/>万元,</div>
		  <div class="inputicon">折扣<input type="text" id="discountDesc1" name="recRoom1.discountDesc"/></div>

          <div class="c"></div>
        </div>
        </div>
      </div>
	  
	   <div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue">所选单位2</div>
  <div class="rightboxnone">

		  <div class="inputicon"><input type="text" id="building2" name="recRoom2.building"/>栋</div>
          <div class="inputicon"><input type="text" id="room2" name="recRoom2.room"/>单元,</div>
		  <div class="inputicon">原价<input type="text" id="originalPrice2" name="recRoom2.originalPrice"/>万元,</div>
		  <div class="inputicon">折扣<input type="text" id="discountDesc2" name="recRoom2.discountDesc"/></div>	  
		  
    

          <div class="c"></div>
        </div>
        </div>
      </div>
	  
	   <div class="leftcreatenav">
        <div class="leftv2">
  <div class="righttitleword01 fontblue">所选单位3</div>
  <div class="rightboxnone">
		  
          <div class="inputicon"><input type="text" id="building3" name="recRoom3.building"/>栋</div>
          <div class="inputicon"><input type="text" id="room3" name="recRoom3.room"/>单元,</div>
		  <div class="inputicon">原价<input type="text" id="originalPrice3" name="recRoom3.originalPrice"/>万元,</div>
		  <div class="inputicon">折扣<input type="text" id="discountDesc3" name="recRoom3.discountDesc"/></div>	 

          <div class="c"></div>
        </div>
        </div>
      </div>
		
		
		 <div class="leftcreatenav">
  <div class="righttitleword01 fontblue"><font color="red">*</font>客户购买抗性</div>
  <div class="rightboxnone">

          <div class="rightboxm02">
		  
				<textarea id="notBuyReson" name="customer.notBuyReson" rows="3" cols="30"></textarea>
              
          </div>
        </div>
        </div>
		
        <div class="leftcreatenav">
  <div class="righttitleword01 fontblue"><font color="red">*</font>备注</div>
  <div class="rightboxnone">
          <div class="rightboxl"></div>
          <div class="rightboxm01">
            
                <label for="textfield"></label>
                <input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" />
              
          </div>
          <div class="rightboxr"></div>
          <div class="c"></div>
        </div>
        </div>
		
		
        <div class="blank"></div>
        <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  <!--<a href="#">保 存</a>-->
		  <input type="submit" value="保 存" id="sub"/>
		  </div>
    	  <div class="l">

  	      
  	    </div>
  	  </div>
	  
      <div class="l">
    	  <div class="leftcreatesave01 iconbg">
		  	<!--<a href="#">取 消</a>-->
			<input type="button" value="取 消" onClick="javascript:window.location.href = './customer!searchCustomer.action'" />
		  </div>
    	  <div class="l">

  	      
  	    </div>
  	  </div>
	  
	   <div>
    	  <div class="leftcreatesave01 iconbg2">
			<font color="#FF0000"><span id="tip"></span></font>
		  </div>
  	      
  	    </div>
  	  </div>
	  
	  
    </div>
    <!--right.end-->	
	
	</td>
	
	
	</form>
	<!-- right form end-->
	
	
  </tr>
   
</table>

<!--main.end-->
   
   
  </body>
</html>
