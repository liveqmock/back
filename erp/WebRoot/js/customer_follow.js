/**
 *
 * 客户跟进
 */

function customerIndexFollow(customerId){
	$.ajax({
		type:"post",
		url: "./customer_guangzhou/follow/toAddIndex.action",  //查询一些相关的数据
		data: "customerId=" + customerId,
		dataType: "html",
		success: function(data){
			var dataJson = eval("("+data+")");
			
			var followDialog = 
			 "<form id='cusfollow' name='followform' method='post'>"
			+ "<div class='gbox1'><table border='0' cellpadding='0' cellspacing='1' class='gbox' style='white-space:normal' width='675px'>" //500px
			+ "<tr bgcolor='#FFFFFF' height='28' style='white-space:nowrap'><td align='center' style='width:100px'>跟进类型</td><td colspan='3'>&nbsp;&nbsp;"
			+ dataJson.type
			+ "</td>"
			+ "</tr>"
			+ "<tr bgcolor='#FFFFFF'><td align='center'>跟进内容</td><td colspan='3'>&nbsp;&nbsp;"
			+ "<textarea name='customerFollow.followDesc' class='easyui-validatebox' id='followDesc' rows='3' cols='30'></textarea></td>"
			+ "</tr>"
			+ "<tr bgcolor='#FFFFFF' height='28'><td align='center'>跟进日期</td><td colspan='3'>&nbsp;&nbsp;"
			+ "<input class='easyui-datebox' type='text' name='customerFollow.createdTime' id='createdTime' value='"
			+ dataJson.createdTime
			+ "'/></td><input type='hidden' name='customerId' value='" + customerId + "'/>"
			+ "<td></tr>"
			+ "<tr bgcolor='#FFFFFF' align='center'><td colspan='4' height='28'><span id='suggId'></span>"
			+ "<input id='followSubmit' type='submit' value='  提交  ' onclick='save();return false;'/></td></tr>"
			+ dataJson.followNote
			+ "</table></div></form>"
			+ "<script>function save(){if(document.getElementById('followDesc').value.length < 1){$.messager.defaults = { ok: '确定'};$.messager.alert('提示', '跟进内容不能为空', 'info');}" 
			+ "else{$('#followSubmit').css('display', 'none'),$('#suggId').html('提交中...');"
			+ "document.followform.action='./customer_guangzhou/follow/addFollowForIndex.action';document.followform.submit()} } </script>"
			;				
					
			var dialog = new Dialog(followDialog, {title:'<p style="color:black;font-weight: bold;">客户跟进</p>',ie6width:'562px',ie6height:'350px'});
			//datepicker("createdTime");
			$('#createdTime').datebox({});
			dialog.show();
			
			}
		});
}


