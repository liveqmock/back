<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>新建问卷详细信息</title>
	<s:include value="../../header/header_easyui.jsp"></s:include>	  
	<script type="text/javascript">
	
		function click_property_tr(pid){
			var pp = $(".p"+pid);
			if(pp.size() > 0){
				if(pp.is(":hidden")){
					pp.show();
				}else{
					pp.hide()
				}
				return ;
			}
			
			$.post('./saleunit_new_questions/appoint/guangzhou/getArea.action',{'pid':pid},function(date){
				var ttp = $(date);
				$("#p"+pid).after(ttp);
			})
			
		}
		
		function click_area_tr(aid){
			//alert(aid)
			
			var aa = $(".a"+aid);
			//alert(aa)
			if(aa.size() > 0){
				if(aa.is(":hidden")){
					aa.show();
				}else{
					aa.hide()
				}
				return ;
			}
			$.post('./saleunit_new_questions/appoint/guangzhou/getBuild.action',{'aid':aid},function(date){
				var ttp = $(date);
				$("#a"+aid).after(ttp);
			})
		}


		function formsubmit (){
			document.getElementById("this_form").submit();
	    };
	</script>
	
	</head>
<body>
<form id="this_form" action="./saleunit_new_questions/appoint/guangzhou/copyForm.action" method="post">
	<table border="0"  align="center" cellpadding="0" cellspacing="1" style="width: 100%;background-color: #6CA6CD;line-height: 20px;margin: 0px;padding: 0px">
		<tr style="background-color: #E9F5FF"><th>名称</th><th>复制到</th></tr>
		<s:iterator value="proList" var="c">
			<tr id="p${c.id}" style="background-color: #ffffff;color: #111111;cursor: pointer;" onclick="javascript:click_property_tr(${c.id})">
				<td width="300px"><span style="color:blue">[+]</span>${c.propertyName}</td>
				<td>  </td>
			</tr>
		</s:iterator>
	</table>
	<input type="hidden" value="${qid}" name="qid"/>
</form>
</body>


</html>