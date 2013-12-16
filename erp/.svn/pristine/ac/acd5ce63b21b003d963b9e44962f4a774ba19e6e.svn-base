<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<style>
.rmb_format{text-align: right}

.btn1 {
BORDER-RIGHT: #7b9ebd 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7b9ebd 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#cecfde); BORDER-LEFT: #7b9ebd 1px solid; CURSOR: hand; COLOR: black; PADDING-TOP: 2px; BORDER-BOTTOM: #7b9ebd 1px solid
}
.btn1_d {
background:#444444;
BORDER-RIGHT: #7EBF4F 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7EBF4F 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#B3D997); BORDER-LEFT: #7EBF4F 1px solid; CURSOR: hand; COLOR: #ffffff; PADDING-TOP: 2px; BORDER-BOTTOM: #7EBF4F 1px solid
}
.btn1_mouseover {
background:#8DB6CD;color:#ffffff;
BORDER-RIGHT: #7EBF4F 1px solid; PADDING-RIGHT: 2px; BORDER-TOP: #7EBF4F 1px solid; PADDING-LEFT: 2px; FONT-SIZE: 12px; FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#CAE4B6); BORDER-LEFT: #7EBF4F 1px solid; CURSOR: hand;  PADDING-TOP: 2px; BORDER-BOTTOM: #7EBF4F 1px solid
}
.clickclass{background: #DADADA;}
</style>
<script type="text/javascript">
function new_anwser_dialog(hhid){
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:800,
		height:400,
		onClose:function(){
		$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		doQuestion();
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("openIframe").contentWindow.formsubmit();
			}},
			{text:'关闭',
			handler:function(){
				$('#myIframeDialog').dialog('close');
			}}
		]
	});
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '新建问卷调查'); 
	$('#openIframe')[0].src="./saleunit_new_questions/appoint/guangzhou/doQuestionAnswerDialog.action?id="+hhid; 
};

function update_anwser_dialog(hhid){//答卷ID
	$("#myIframeDialog").dialog({
		resizable: true,
		modal:true, 
		maximizable: false, 
		width:800,
		height:400,
		onClose:function(){
		$('#openIframe').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
		},
		buttons:[ {
			text:'提交',
			iconCls:'icon-ok',
			handler:function(){
			window.document.getElementById("openIframe").contentWindow.formsubmit();
			}},
			{text:'关闭',
			handler:function(){
				$('#myIframeDialog').dialog('close');
			}}
		]
	});
	$('#myIframeDialog').dialog('open');
	$('#myIframeDialog').dialog('setTitle', '查看/修改答卷'); 
	$('#openIframe')[0].src="./saleunit_new_questions/appoint/guangzhou/updateAnswerDialog.action?id="+hhid; 
};
var select_as_id = '0';
$().ready(function(){
	
	$(".btn1").hover(
			  function () {
				    $(this).addClass("btn1_mouseover");
				  },
				  function () {
				    $(this).removeClass("btn1_mouseover btn1_d");
				  }
				); 
	$(".btn1").mousedown(function(){
		 $(this).removeClass("btn1_mouseover").addClass("btn1_d");
	});

	$("#bar_anwser_add").click(function(){
		if(click_unit_id== '0'){
			myAlert('请选择单元');
			return false;
		}
		$.ajax({
			url:"./saleunit_new_questions/appoint/guangzhou/doQuestionAnswerDialog.action?id="+click_unit_id,
			success:function(data){
				if(data=='false'){
					myAlert('此单元不存在售后客户');
					return false;
				}else{
					new_anwser_dialog(click_unit_id);
				}
			}
		})
		
	});

	$(".answertr").click(function(){
		$(".answertr").removeClass("clickclass").attr("style","line-height: 20px;background-color: #ffffff");
		$(this).addClass("clickclass").attr("style","line-height: 20px;background-color: #FBEC88");
		select_as_id = $(this).attr("asId");
	});

	$("#bar_anwser_upp").click(function(){
		if(select_as_id == '0'){
			alert("请先选择调查卷");
			return false;
		}
		update_anwser_dialog(select_as_id);
	})

	$("#bar_anser_del").click(function(){
		
		if(select_as_id == '0'){
			alert("请先选择调查卷");
			return false;
		}
		if(confirm("是否确认删除?")){
			$.post('./saleunit_new_questions/appoint/guangzhou/delAnser.action',{id:select_as_id},function(date){doQuestion();});
		}
	});
});


</script>

<div style="width: 100%; float: left;margin-top: 2px;background-color: #ffffff"> 
<input id="bar_anwser_add" type="button" class="btn1" value="  选择问卷  "/>
<input id="bar_anwser_upp" type="button" class="btn1" value="  修改  "/>
<input id="bar_anser_del" type="button" class="btn1"  value="  删除  "/>
<font style="color: red">可添加多份售后问卷 </font>
</div>
<br/>
		<table style="margin: 5px 0px 0px 0px;background-color: #A9D9FF"  border="0" align="center" cellpadding="0" cellspacing="1" class="" width="100%"  >
			<tr  style="line-height: 20px;background: #E9F5FF" > 
				<th width="150px" align="center">调查时间</th>
				<th width="150px" align="center">回答人</th>
				<th width="150px" align="center">操作人员</th>
				<th width="150px" align="center">对应房间</th>
				<th  align="center">备注</th>
			</tr>
			<s:iterator value="anwserList" var="c">
				<tr class ="answertr"  style="line-height: 20px;background-color: #ffffff"  asId='${c.id}' >
					<td>
						<s:date name="#request.c.createdTime" format="yyyy-MM-dd"/>
					</td>
					<td>${c.customerName}</td>
					<td>${c.createdIdStr}</td>
					<td>${c.unitNo}</td>
					<td>${c.remark}</td>
				</tr>
			</s:iterator>
		</table>
   
				
