<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>合同</title>

	<s:include value="../../header/header_easyui.jsp"></s:include>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui.utils.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_common_min.js"></script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		input{width: 75%}
	</style>
	<script>
			$().ready(function(){
				closeIframeDialog("new_dialog", "${closeMark}", "", "${suggestion}");
			})
			function formsubmit (){
				document.getElementById("pay_unit_form").submit();
			}  

			function adddev (){
				var tmp = $("#new_pro_name").val();
				$("#pro_name").val(tmp);

				var tmp1 = $("#new_card").val();
				$("#pro_card").val(tmp1);
				var tmp2 = $("#new_address").val();
				$("#pro_address").val(tmp2);
				var tmp3 = $("#new_areaname").val();
				$("#pro_areaname").val(tmp3);
				var tmp4 = $("#new_prodesc").val();
				$("#pro_prodesc").val(tmp4);



				
				document.getElementById("add_dev_form").submit();
			}  
			
			function getNewName(){
				return "${newName}";
			}

			$(function(){
				$('#dd').dialog({
					
					buttons:[{
						text:'确定',
						handler:function(){
						adddev ();
						}
					},{
						text:'取消',
						handler:function(){
							$('#dd').dialog('close');
						}
					}]
				});
			});
			function open1(){
				$('#dd').dialog('open');
				return false;
			}
	</script>
	</head>
<body>
<form action="${actionPath}" method="post" id="pay_unit_form">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1"  style="font-size:12px; line-height:26px;background-color: #A9D9FF">	
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td  align="left" colspan="2" style="line-height: 30px" > <b>&nbsp;您现在的操作:新建楼盘&nbsp;</b></td>
			  </tr>
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="80px"  align="right"><span style="color:red">*</span>楼盘名称&nbsp;</td>
                <td >				 				 
				 <input name="newName" id="new_pro_name" value="${proName }"/>
				 <input type="hidden" value="${id }" name="id"/>
				</td>
              </tr>	
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">预售证号&nbsp;</td>
                <td >				 				 
				 <input name="saleCard"  value="${saleCard }" id="new_card"/>
				</td>
              </tr>	
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">楼盘地址&nbsp;</td>
                <td >				 				 
				 <input name=propertyAddress  value="${propertyAddress }" id="new_address"/>
				</td>
              </tr>	
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">行政区域&nbsp;</td>
                <td >				 				 
				 <input name="areaName"  value="${areaName }" id="new_areaname"/>
				</td>
              </tr>	
              <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">项目功能描述&nbsp;</td>
                <td >				 				 
				 <input name="projectDesc"  value="${projectDesc }" id="new_prodesc"/>
				</td>
              </tr>	
               <tr bgcolor="#FFFFFF" style="empty-cells:show" >
               <td width="50px"  align="right">	</td>
				<td ><font color="red">如果没有找到开发商,请新建开发商之后再选择.</font> </td>
              </tr>	
               <tr bgcolor="#FFFFFF" style="empty-cells:show" >
				<td width="50px"  align="right">开发商&nbsp;</td>
                <td >				 				 
				 <s:select list="devList"  listKey="id" listValue="developerName" name="proDevName"></s:select>
				 <a id="but_new_dev" onclick="return open1()" style="cursor: pointer;" class="fontblue">新建开发商</a>
				</td>
              </tr>	
			</table>
</form>	
	<div id="dd" title="新建开发商" style="padding:5px;width:250px;height:120px;" resizable="true" closed="true">
	<form action="./saleunit_new_init/appoint/guangzhou/addDev.action" method="post" id="add_dev_form">
		名称<input name="devName"/>
		<input type="hidden" name="actionPath" value="${actionPath}"/>
		
		<input type="hidden" name="proName" id="pro_name"/>
		<input type="hidden" name="saleCard" id="pro_card"/>
		<input type="hidden" name="propertyAddress" id="pro_address"/>
		<input type="hidden" name="areaName" id="pro_areaname"/>
		<input type="hidden" name="projectDesc" id="pro_prodesc"/>
		</form>
	</div>
</body>
</html>