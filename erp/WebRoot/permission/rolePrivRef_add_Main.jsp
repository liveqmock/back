<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>add</title>

		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
        <script>

$(function(){
  $("#s1 option:first,#s2 option:first").attr("selected",true);
 
  $("#s1").dblclick(function(){
    var alloptions = $("#s1 option");
    var so = $("#s1 option:selected");
 if(so === null || so == "undefined"){
  return;
 }
 try{
     var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
    }catch(e){
     return;
    }
    $("#s2").append(so);
  });
 
  $("#s2").dblclick(function(){
    var alloptions = $("#s2 option");
    var so = $("#s2 option:selected");
 if(so === null || so == "undefined"){
  return;
 }
    try{
     var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
    }catch(e){
     return;
    }
    $("#s1").append(so);
  });
 
  $("#add").click(function(){
    var alloptions = $("#s1 option");
    var so = $("#s1 option:selected");

    var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
   
    $("#s2").append(so);
  });
 
  $("#remove").click(function(){
    var alloptions = $("#s2 option");
    var so = $("#s2 option:selected");
   
    var a = (so.get(so.length-1).index == alloptions.length-1)? so.prev().attr("selected",true):so.next().attr("selected",true);
   
    $("#s1").append(so);
  });
 
  $("#addall").click(function(){
    $("#s2").append($("#s1 option").attr("selected",true));
  });
 
  $("#removeall").click(function(){
    $("#s1").append($("#s2 option").attr("selected",true));
  });
 
  $("#s1up").click(function(){
    var so = $("#s1 option:selected");
    if(so.get(0).index!==0){
      so.each(function(){
          $(this).prev().before($(this));
      });
    }
  });
 
  $("#s1down").click(function(){
    var alloptions = $("#s1 option");
    var so = $("#s1 option:selected");
   
    if(so.get(so.length-1).index!=alloptions.length-1){
      for(i=so.length-1;i>=0;i=1-1)
      {
        var item = $(so.get(i));
        item.insertAfter(item.next());
      }
    }
  });
 
  $("#s2up").click(function(){
    var so = $("#s2 option:selected");
    if(so.get(0).index!==0){
      so.each(function(){
          $(this).prev().before($(this));
      });
    }
  });
 
  $("#s2down").click(function(){
    var alloptions = $("#s2 option");
    var so = $("#s2 option:selected");
   
    if(so.get(so.length-1).index!=alloptions.length-1){
      for(i=so.length-1;i>=0;i--)
      {
        var item = $(so.get(i));
        item.insertAfter(item.next());
      }
    }
  });

  
});

</script>

	</head>

	<body onLoad="clearSuggestion()">


		<!--main-->
	<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="1">
			<tr>

				<!--left.top-->

				<s:include value="left.jsp"></s:include>

				<!--left.end-->

				<td width="100%" valign="top" height="100%"
					style="overflow: hidden;">
					<div class="right01"></div>
					<div class="right02"></div>
					<div class="right03"></div>
					<div class="c"></div>

					<div>
						<div class="right04"></div>
						<div class="right05">
							<div class="titlel"></div>

							<div class="titlebg" style="height: auto; overflow: hidden;">


								<div class="title01">
									<a href="./user_role_priv!rolePrivRef_index.action"
										target="_self">查询参照</a>
								</div>
								<div class="title02">
									<a href="./user_role_priv!addRefRolePriv.action" target="_self">新建参照</a>
								</div>

&nbsp;&nbsp;

								<!-- right form top -->


								<div class="c"> </div>
								<div class="c"></div>
	
		  <div class="blueline"></div>
            

		
								<table width="50%" border="0" align="left" cellpadding="0"
									cellspacing="1" class="gbox">
									
									<form class="registerform"
										action="./user_role_priv!addRefRolePriv.action" method="get">
										<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
											onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
											<td width="19%" align="right" id="t13">
												角色&nbsp;
											</td>
											<td width="26%" id="t14">
												<input type="text" name="ref.roleId" id="2312" class="leftcreateinputbox01" />
											</td>


										</tr>



										<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
											onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
											<td width="19%" align="right" id="t13">
												仿照&nbsp;
											</td>
											<td width="26%" id="t14">
												<input type="text" name="ref.refRoleId" id="initRolePriv" class="leftcreateinputbox01" />
											</td>

										</tr>




										<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
											onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"
											; align="center">
											<td colspan="2">
												<input type="submit" value="  保存   " id="sub" />
												<input type="button" value="  取消   "
													onClick="javascript:window.location.href = './user_role_priv!rolePrivRef_index.action'" />
												<FONT color="red"><s:actionmessage /> </FONT>
											</td>

										</tr>
									</form>
								</table>




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
					<div class="c"></div>
				</td>
			</tr>
			<!--main.end-->
			<tr>
				<td height="5" colspan="3">
				</td>
			</tr>
		</table>
		<form name="form1" method="post" action="">
		  <label for="22312"></label>
		  <select name="22312" size="4" multiple id="22312">
          <optgroup label="left list"></optgroup>
		    <option value="1" >1111111111</option>
		    <option value="2">2</option>
		    <option value="3">3</option>
		    <option value="4">4</option>
             <option value="1">1</option>
		    <option value="2">2</option>
		    <option value="3">3</option>
		    <option value="4">4</option>
	      </select>
          <a href="#">-></a>
          <label for="22312"></label>
		  <select name="22312" size="4" id="22312">
           <optgroup label="right list"></optgroup>
		    <option value="1">1</option>
		    <option value="2">2</option>
		    <option value="3">3</option>
		    <option value="4">4</option>
             <option value="1">1</option>
		    <option value="2">2</option>
		    <option value="3">3</option>
		    <option value="4">4</option>
	      </select>
    </form>
    <table width="288" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="29">
      <input type="button" name="s1up" id="s1up" value="up" /><br />
     <input type="button" name="s1down" id="s1down" value="down"/>
    </td>
    <td width="100">
    
     <select name="s1" size="10" multiple="multiple" id="s1" style=" width:100px;">
       <option value="opt01">option01</option>
       <option value="opt02">option02</option>
       <option value="opt03">option03</option>
       <option value="opt04">option04</option>
       <option value="opt05">option05</option>
       <option value="opt06">option06</option>
       <option value="opt07">option07</option>
       <option value="opt08">option08</option>
       <option value="opt09">option09</option>
       <option value="opt10">option10</option>
     </select>
     
    </td>
    <td width="37" align="center"><input type="button" name="addall" id="addall" value="&gt;|" /><br /><input type="button" name="add" id="add" value="&gt;&gt;" /><br /><input type="button" name="remove" id="remove" value="&lt;&lt;" /><br /><input type="button" name="removeall" id="removeall" value="|&lt;" /></td>
    <td width="100"><select name="s2" size="10" multiple="multiple" id="s2" style=" width:100px;">
    </select></td>
    <td width="119">
      <input type="button" name="s2up" id="s2up" value="up" /><br />
    <input type="button" name="s2down" id="s2down" value="down" /></td>
    <td>
    
       <s:select list="listRolePriv"  listKey="roleId" listValue="privCode" id="privlist" size="10"></s:select>
   		
    </td>
  </tr>
</table>
    </body>
</html>
