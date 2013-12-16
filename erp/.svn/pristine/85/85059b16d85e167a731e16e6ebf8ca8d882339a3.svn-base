<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<style>

.over{background-color: #FBEC88}
.make_price_tr{cursor: pointer;}
</style>

<script type="text/javascript">
	//删除定价单 根据 ID
	function del_price(hhid){
		$.messager.confirm('确认','是否确认删除此条数据',function(r){  
		    if (r){  
		        $.post('./saleunit_new_init/appoint/guangzhou/delMakePrice.action',{'makeId':hhid},function(date){
		        	$.messager.alert('提示',date);
		        	doMakePrice();
			    }) 
		    }  
		}); 
	}

	function dialog_show_make_price(hhid){//make build price 的ID
		$("#new_dialog").dialog({
			resizable: true,
			modal:true, 
			maximizable: true, 
			
			width:800,
			height:500,
			onClose:function(){
			$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
			},
			buttons:[ {
				text:'启用',
				iconCls:'icon-ok',
				handler:function(){
				window.document.getElementById("new_dialog_ifram").contentWindow.dosubmit();
				}},
				{text:'关闭',
					iconCls:'icon-cancel',
				handler:function(){
					$('#new_dialog').dialog('close');
					doMakePrice();
				}}
			]
		});
		$('#new_dialog').dialog('open');
		$('#new_dialog').dialog('setTitle', '调整单元资料'); 
		$('#new_dialog_ifram')[0].src='./saleunit_new_init/appoint/guangzhou/showMakePriceDaDialog.action?makeId='+hhid; 
	}	

	$(document).ready(function(){
		$(".make_price_tr").dblclick(function(){
			dialog_show_make_price($(this).attr("makeid"));
		});
		$(".make_price_a").click(function(){
			dialog_show_make_price($(this).attr("makeid"));
		});

		$("#_do_log_xls").click(function(){
			doUoXls();
		})	


		bindbutclass("btn1");
	});
</script>
<input type="button" value="下载资料" id="" class="btn1" onclick="doloadbuild()"/> <input type="button" value="上传资料" id="_do_log_xls" class="btn1"  />
<font color="red">请先使用创建单元(批量/单个),然后再使用下载资料和上传资料功能,用来批量修改单元详细信息</font> 
<br/>
<table   border="0" align="left" cellpadding="0" cellspacing="1" style="background-color: #A9D9FF" >
			<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="100" align="center" >创建人</th>
				<th width="100" align="center">创建时间</th>
				<th width="100" align="center">创建说明</th>
				<th width="100" align="center">启用状态</th>
				<th width="100" align="center">启用人</th>
				<th width="100" align="center">启用时间</th>
				<th width="100" align="center">启用说明</th>
				<th width="100" align="center"></th>
			</tr>
			<s:iterator value="makeList" var="mpc">
				<tr class="make_price_tr" makeid="${mpc.id }" onMouseOver="javascript:$(this).addClass('over');" onMouseOut="javascript:$(this).removeClass('over')" bgcolor="#FFFFFF" style="line-height: 20px;">
				 	<td width="100" align="center">${mpc.createdIdStr }</td>
				 	<td width="100" align="center">
				 		<s:date name="#request.mpc.createdTime" format="yyyy-MM-dd HH:mm"/>
				 	</td>
				 	<td width="100" align="center">${mpc.remark }</td>
				 	<td width="100" align="center">${mpc.isEffectStr }</td>
				 	<td width="100" align="center">${mpc.doUserStr }</td>
				 	<td width="100" align="center">
				 		<s:date name="#request.mpc.doTime" format="yyyy-MM-dd HH:mm"/>
				 	</td>
				 	<td width="100" align="center">${mpc.doRemark }</td>
				 	<td width="100" align="center"><a makeid="${mpc.id }" class="make_price_a" style="color: #5482DE">查看/启用</a> 
				 	<a onclick="del_price(${mpc.id })" style="color: red">删除</a></td>
				</tr>
			</s:iterator>
</table>
   
				
