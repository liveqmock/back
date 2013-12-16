/**
 * 广州的js
 */



$().ready(function(){
	
	/**
	 * update 使用 top
	 */
	 
	
	$("#follow").click(function(){
		
		$.ajax({
			type:"post",
			url: "./customer_guangzhou/follow/toAdd.action",  //查询一些相关的数据
			dataType: "html",
			success: function(data){
				var dataJson = eval("("+data+")");
				
				var followDialog = 
				 "<form id='followform' name='followform' method='post'><table border='0'><tr><td>跟进类型:</td><td>"
				+ dataJson.type
				+ "</td>"
				+ "<td><span id='followTypeSpan'></span></td></tr>"
				+ "<tr><td>跟进内容:</td><td>"
				+ "<textarea name='customerFollow.followDesc' id='followDesc' rows='3' cols='30'></textarea></td>"
				+ "<td><span id='followDescSpan'></span></td></tr>"
				+ "<tr><td>跟进日期:</td><td>"
				+ "<input class='easyui-datebox' type='text' name='customerFollow.createdTime' id='createdTime' value='"
				+ dataJson.createdTime
				+ "'/></td>"
				+ "<td><span id='customerPwdSpan'></span></td></tr>"
				+ "<tr align='center'><td colspan='2'><span id='suggId'></span>"
				+ "<input id='followSubmit' type='submit' value='  提交  ' onClick='save();return false;'/></td></tr>"
				+ "</table></form>"
				+ "<script>function save(){if(document.getElementById('followDesc').value.length < 1){$.messager.defaults = { ok: '确定'};$.messager.alert('提示', '跟进内容不能为空', 'info');}" 
				+ "else{$('#followSubmit').css('display', 'none'),$('#suggId').html('提交中...');"
				+ "document.followform.action='./customer_guangzhou/follow/add.action';document.followform.submit()} } </script>"
				;			
				
				var dialog = new Dialog(followDialog,{title:'客户跟进'});	
				//datepicker("createdTime");
				$('#createdTime').datebox({});
				dialog.show();
			
			}
		});
	});
	
	
	
	/**
	 * update 使用 end
	 */
	
});



