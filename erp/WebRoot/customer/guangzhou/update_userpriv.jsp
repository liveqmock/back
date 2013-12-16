

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<s:include value="header.jsp"></s:include>	
		<script type="text/javascript" language="javascript" src="./js/userAccount-hengda.js"></script>	
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_sel.js"></script>
		<title>修改用户信息</title>

		<style>
		html,body {height:100%;width:100%;}
		#content {background:#f8f8f8;padding:30px;height:100%;}
		#content a {font-size:30px;color:#369;font-weight:700;}
		.alert {margin:0;padding:0;font-size:12px;overflow: hidden;}
		/*.alert {border:1px solid #369;width:auto;height:auto;background:#e2ecf5;z-index:1000;position:absolute;display:none;}*/
		.alert {border:2px solid #369;width:auto;height:auto;background:#fff;z-index:2000;position:absolute;display:none;margin:0;padding:0;font-size:12px;}
		.alert h4 {height:20px;background:#369;color:#fff;padding:0 10px 10px 0;}
		.alert h4 span {float:left;padding:10px 0 0 10px;}
		.alert em  {color:red;padding:5px 0 0 5px;}
		.alert h4 span#close1 {margin-left:280px;cursor:pointer;}
		.alert h4 span#close2 {cursor:pointer;}
		.alert h4 span#close3 {margin-left:280px;cursor:pointer;}
		.alert p {padding:12px 0 0 30px;}
		.alert p input {width:120px;margin-left:20px;}
		.alert p input.myinp {border:2px solid #ccc;height:16px;}
		.alert p input.sub {width:60px;margin-left:30px;}
	</style>	
	
		<script type="text/javascript" src="<%=basePath%>js/customer_guangzhou.js"></script>
		
		
		<script type="text/javascript" language="javascript" src="<%=basePath%>js/customer_guangzhou_project.js"></script>
		<script type="text/javascript">
		$().ready(function(){				
					
		
		projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
		projectListForHiddenId("projectName2", "hiddenId2"); //项目的联想框,及用隐藏域保存其id
		projectListForHiddenId("projectName3", "hiddenId3"); //项目的联想框,及用隐藏域保存其id

		 var bool = false;
		    var offsetX = 0;
		    var offsetY = 0;
		    var divid ;
			//拖动DIV
			$("#alert1title").mousedown(function(event) {//绑定事件的控件
	            bool = true;
	            divid = 'alert1';//移动的控件
	            offsetX = event.offsetX ? event.offsetX : event.layerX;
	            offsetX = offsetX -150;
	            offsetY = event.offsetY ? event.offsetY : event.layerY;
	            offsetY = offsetY -75;
	        
	        })
	        .mouseup(function() {
	            bool = false;
	        })
	        $("#alert2title").mousedown(function(event) {
	            bool = true;
	            divid = 'alert2';
	            offsetX = event.offsetX ? event.offsetX : event.layerX;
	            offsetX = offsetX -150;
	            offsetY = event.offsetY ? event.offsetY : event.layerY;
	            offsetY = offsetY -75;
	         
	        })
	        .mouseup(function() {
	            bool = false;
	        })
	        $("#alert3title").mousedown(function(event) {
	            bool = true;
	            divid = 'alert3';
	            offsetX = event.offsetX ? event.offsetX : event.layerX;
	            offsetX = offsetX -150;
	            offsetY = event.offsetY ? event.offsetY : event.layerY;
	            offsetY = offsetY -75;
	          
	        })
	        .mouseup(function() {
	            bool = false;
	        })
	        $(document).mousemove(function(event) {
	            if (!bool) {
	                return;
	            }
	            else {
	           
	                var x = event.clientX - offsetX;
	                var y = event.clientY - offsetY;
	                $("#"+divid).css("position", "absolute");
	                $("#"+divid).css("left", x);
	                $("#"+divid).css("top", y);
	            }
	        })   
	});
	</script>

	</head>
	<body>
		<style>
		* {margin:0;padding:0;}
	</style>
		<table width="100%" border="0" align="left" cellspacing="0">	
		<tr>
			<td>
			
			
							
								
											<table width="470" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox">
											
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													<td width="110" align="center" id="t15" nowrap="nowrap">账号</td>
													<td width="257" nowrap="nowrap" id="t16"  >
													
														&nbsp;${selectUser.userName }
														<label><em>&nbsp;</em></label>
													</td>
												</tr>
											
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t13" align="center">姓名</td>
													<td id="t14" >
													
														&nbsp;${selectUser.realName }
													</td>
												
												</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t13" align="center">移动电话</td>
													<td id="t14" >
													
														&nbsp;${selectUser .mobilePhone }
													</td>
												
												</tr>
												</tr>
													<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t13" align="center">工号</td>
													<td id="t14" >
													
														&nbsp;${selectUser .jobNumber }
													</td>
												
												</tr>
												<tr onMouseOver="this.style.backgroundColor='#ffffbf'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF"; height="40px">
													
													<td id="t13" align="center">所属项目</td>
													<td id="t14" >
													
														&nbsp;${selectUser .descProjectId }
													</td>
												
												</tr>
												
												<tr bgcolor="#FFFFFF">
												<td colspan="2"><input type="button" name="x" value="  修改帐号信息  " onclick="showalert($('#alert3'));"/>
												<input type="button" name="x" value="  修改密码  " onclick="showalert($('#alert1'));"/>
												<input type="button" name="x" value="  添加权限  " onclick="showalert($('#alert2'));"/>
												<input type="button"  value="  返回查询  " onclick=" history.go(-1);"/>
												${pwdTip }
												<s:actionmessage cssStyle="color:red;"/>
												</td>
												</tr>
												
											

								</table>
								
								
							
						</td>
					</tr>


						
						
						<tr><td>
						
		&nbsp;<input type="button" value="  批量删除权限  " onclick="delUserRoleById('./guangzhou/userAccount/delUserRoles.action?id=${selectUser.id}')"></input>
		<form method="get" action="./guangzhou/userAccount/searchuserrole.action">
			<input type="hidden" name="id" value="${id}"/>
			
							  项目<input type="text" id="projectName" name ="projectName"  value="${projectName }"/>
									<input type="hidden" id="hiddenId" name="userRoleCond.projectId" value=""/>
			
								角色<s:select list="roleList" listValue="roleName" listKey="id" name="userRoleCond.roleId" headerKey="" headerValue="全部"></s:select>
			<input type="submit" value="  搜索  "/>							
		</form>
			  <table width="50%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
  <tr class="gboxbg">
    <td width="25" align="center"><input  type="checkbox" id="allDel" name="allDel" onclick="allDel()" /> </td>

     <td width="188">
	&nbsp;&nbsp;项目</td>
	
    <td width="188">			
	&nbsp;&nbsp;权限
       </td>
    
    <td width="188">&nbsp;&nbsp;功能</td>
  </tr>
  
     
    
	  
	  
	  <div class="right99"></div>
<div class="blueline"></div>
	  <s:iterator value="selectUserRoleList" id="li">
			  	<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
				<td align="center" valign="middle"><input name="delId" type="checkbox" value="<s:property value='id'/>" onclick="delId()" /></td>
				<td align="left" valign="middle"  class="fontblue">&nbsp;
					<s:property value="DescProjectId"/>	</td>
				<td align="left" valign="middle">&nbsp;
					<s:property value="DescRoleName"/>	</td>
					
					<td>
					&nbsp;&nbsp;<input type="button" value="  删除  " onclick="location.href = './guangzhou/userAccount/delUserRoles.action?ids=${id}&id=${selectUser.id }'"></input>
					</td>
			  </tr>
			 
	  </s:iterator>
</table>


						
						</td></tr>
					
					
						

					

		</table>
						  <%--固定的底部 --%>
			  <div id="alert3" class="alert">
              		<iframe     style= "position:absolute;z-index:-1;width:99%;height:99%;top:0;left:0; "   frameborder= "0"   src= "about:blank "> 
			</iframe> 
	
					<div>
					
					<form action="./guangzhou/userAccount/updateuser.action" method="post">
					<input type="hidden" name="id" value="${selectUser.id}"/>
					<table width="400px"  border="0" align="center" cellpadding="0" cellspacing="0" class="gbox" >
						<tr id="alert3title" style="padding: 10px;cursor: move;"><td  align="left" bgcolor="#336699" style="color:#ffffff" height="30px">&nbsp;&nbsp;修改用户信息</td>
						 <td align="right" bgcolor="#336699"><span id="close2" onclick="closealert($('#alert3'));"><font color="#ffffff" style="font-size: 12px;"><a href="javascript:void(0)" style="color: #ffffff;text-decoration: none">关闭&nbsp;&nbsp;</a></font></span></td> </tr>
						<tr  bgcolor="#FFFFFF"; style="height: 30px">
							<td width="30%" align="right">姓名&nbsp;</td><td>&nbsp;<input maxlength="12"  size="12" name="updateUser.realName" type="text"    />
					</td>
						</tr>
						<tr  bgcolor="#FFFFFF"; style="height: 30px">
							<td align="right">电话&nbsp; </td><td>&nbsp;<input size="12" maxlength="12"  name="updateUser.mobilePhone" type="text"    />
					</td>
						</tr>
						<tr  bgcolor="#FFFFFF"; style="height: 30px">
							<td align="right">工号&nbsp; </td><td>&nbsp;<input size="12" maxlength="12" name="updateUser.jobNumber" type="text"   />
					</td>
						</tr>
						<tr  bgcolor="#FFFFFF"; style="height: 30px">
							<td align="right">所属项目&nbsp; </td><td>&nbsp;<input type="text" id="projectName3" "/>
									<input type="hidden" id="hiddenId3" name="updateUser.projectId"/>
					</td>
						</tr>
						<tr bgcolor="#FFFFFF"; style="height: 30px">
							<td></td><td align="center" style="padding-left: 100px"><input type="submit" value="  提交  " ></input></td>
						</tr>
					
				
					</table>
					</form>
					</div>
		      </div>	
              <div id="alert2" class="alert" style=" overflow-y: scroll;height: 500px">
						<iframe     style= "position:absolute;z-index:-1;width:99%;height:99%;top:0;left:0; "   frameborder= "0"   src= "about:blank "> </iframe> 
					
					<form action="./guangzhou/userAccount/addUserRole.action" method="get">
					<table  border="0" align="center" cellpadding="0" cellspacing="0" class="gbox" >
						<tr id="alert2title" style="padding: 10px;cursor: move;"><td  align="left" bgcolor="#336699" style="color:#ffffff" height="30px">&nbsp;&nbsp;赋予权限</td> <td align="right" bgcolor="#336699"><span id="close2" onclick="closealert($('#alert2'));"><font color="#ffffff" style="font-size: 12px;"><b><a href="javascript:void(0)" style="color: #ffffff;text-decoration: none">关闭&nbsp;&nbsp;</a></b></font></span></td> </tr>
						<tr  bgcolor="#FFFFFF" >
							<td width="100px" align="right" valign="middle"><em>*</em> 项目 &nbsp;</td><td>
							&nbsp;&nbsp;
							
							
								<table frame="box">
									<tr>
									
										<td width="400px" char="4" >
											<s:iterator value="proList">
													<div style="width: 180px;float: left;padding-bottom: 5px" >
														<input type="checkbox" name="proId" value="${id }" />${projectName }</div>
											</s:iterator>
										</td>
									</tr>
									
								</table>
							
							</td>
						
						</tr>
						
						<tr bgcolor="#FFFFFF"; style="height: 100px;">
							<td  align="right"><em>*</em> 角色 &nbsp;</td><td>
							<table frame="box">
									<tr>
										
								<td colspan="4" width="400px">
								<s:iterator value="roleList" id="tdrole" >
								<div style="width: 180px;float: left;padding-bottom: 5px" >
									<input type="checkbox" name="rolId" value="${id }" />${roleName }</div>
								</s:iterator>
								</td>
								</tr>
									
								</table>
							</td>
							
						</tr>
						<tr  bgcolor="#FFFFFF">
							<td></td><td style="padding-left: 180px"><input type="hidden" name="id" value="${selectUser.id}"/>
								&nbsp;&nbsp;<input type="submit" value="  提交  " ></input>
								<br/>&nbsp;
								</td>
						</tr>
					
					</table>
				
					</form>
	
					
			</div>
			 <div id="alert1" class="alert">
              		
	<iframe     style= "position:absolute;z-index:-1;width:99%;height:99%;top:0;left:0; "   frameborder= "0"   src= "about:blank "> </iframe> 
				
					<form action="./guangzhou/userAccount/updatepwd.action" method="post">
					<input type="hidden" name="id" value="${selectUser.id}"/>
					
					<table width="400px"   border="0" align="center" cellpadding="0" cellspacing="0" class="gbox" >
					<tr  id="alert1title" style="padding: 10px;cursor: move;"><td  align="left" bgcolor="#336699" style="color:#ffffff" height="30px">&nbsp;&nbsp;修改密码</td>
						 <td align="right" bgcolor="#336699"><span id="close2" onclick="closealert($('#alert1'));"><font color="#ffffff" style="font-size: 12px;"><b> <a href="javascript:void(0)" style="color: #ffffff;text-decoration: none">关闭&nbsp;&nbsp;</a></b></font></span></td> </tr>
					
						<tr  bgcolor="#FFFFFF"; style="height: 30px">
							<td width="30%" align="right" style="line-height: 150px">
							
							新密码&nbsp;</td><td>&nbsp;<input  size="12" maxlength="12" name="pwd" type="text"   />
							<input type="submit" value="  提交  " />
					</td>
						</tr>
						
					</table>
					&nbsp;
					
					</form>
			</div>
	</body>
	<script language="javascript" type="text/javascript">
			
			
				
				function showalert(alert){
					//myAlert.style.display = "block";
					//myAlert.style.position = "absolute";
					//myAlert.style.top = "30%";
					//myAlert.style.left = "30%";
					//myAlert.style.marginTop = "-75px";
					//myAlert.style.marginLeft = "-150px";
				
					alert.css("display","block");
					alert.css("top","30%");
					alert.css("left","50%");
					alert.css("marginTop","-75px");
					alert.css("marginLeft","-150px");
					
					mybg = document.createElement("div");
					mybg.setAttribute("id","mybg");
					mybg.style.background = "#000";
					mybg.style.width = "100%";
					mybg.style.height = "100%";
					mybg.style.position = "absolute";
					mybg.style.top = "0";
					mybg.style.left = "0";
					mybg.style.zIndex = "500";
					mybg.style.opacity = "0.3";
					mybg.style.filter = "Alpha(opacity=30)";
					document.body.appendChild(mybg);
					document.body.style.overflow = "hidden";
				
				}
				function closealert(alert){
					//alert.style.display = "none";
					alert.css("display","none");
					mybg.style.display = "none";
					document.body.style.overflow = "auto";
				}
			

		
			function showrole(showrole,showid){
				
				var show = showrole
					+"<br/>"
					+"<a class='ablue' href='./sale_hengda/role/index.action?selectId="
					+showid
					+"'"	
					+"target='_self'>修改</a>"
					;
				var showdialog = new Dialog(show,{title:'查看角色'});	
				showdialog.show();
			}
		
		</script>
</html>
