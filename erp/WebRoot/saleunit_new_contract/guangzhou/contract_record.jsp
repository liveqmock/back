<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<script type="text/javascript">
	function submit_serach(){
		$re1 = $("#sub_1").val();
		if($re1 == '合同编号'){
			$re1 = '';
		}
		$re2 = $("#sub_2").val();
		if($re2 == '签署日期起始'){
			$re2 = '';
		}
		$re3 = $("#sub_3").val();
		if($re3 == '签署日期结束'){
			$re3 = '';
		}
		
		$re4 = $("#sub_4").val();
		$re5 = $("#sub_5").val();

		$re6 = $("#sub_6").val();
		$re7 = $("#sub_7").val();
		$re8 = $("#sub_8").val();
		$re9 = $("#sub_9").val();

		$res = "cond.contractNoLike="+$re1;
		$("#cr_table_div").load('./saleunit_new_contract_record/appoint/guangzhou/showTable.action',{'cond.contractNoLike':$re1},function(date){
			$("#cr_table_div").html(date);
		});
	};
	function new_shou_and_up_dialog(hhid){
		$("#new_dialog").dialog({
			resizable: true,
			modal:true, 
			maximizable: false, 
			width:1000,
			onClose:function(){
				//$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
			},
			buttons:[ 
				{text:'提交',
				iconCls:'icon-ok',
				handler:function(){
				window.document.getElementById("new_dialog_ifram").contentWindow.dosubmit();
				}},
				{text:'关闭',
				handler:function(){
					$('#new_dialog').dialog('close');
				}}
			]
		});
		$('#new_dialog').dialog('open');
		$('#new_dialog').dialog('setTitle', '查看/修改合同'); 
		$('#new_dialog_ifram')[0].src='./saleunit_new_contract_record/appoint/guangzhou/addContractRecords.action'; 
	}
	function new_contra_dialog(){
		$("#new_dialog").dialog({
			resizable: true,
			modal:true, 
			maximizable: false, 
			width:1100,
			onClose:function(){
			$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
			},
			buttons:[ {
				text:'增加一行',
				iconCls:'icon-add',
				handler:function(){
				window.document.getElementById("new_dialog_ifram").contentWindow.doaddtr();
				}},
				{text:'提交',
				iconCls:'icon-ok',
				handler:function(){
				window.document.getElementById("new_dialog_ifram").contentWindow.dosubmit();
				}},
				{text:'关闭',
				handler:function(){
					$('#new_dialog').dialog('close');
				}}
			]
		});
		$('#new_dialog').dialog('open');
		$('#new_dialog').dialog('setTitle', '新建合同'); 
		$('#new_dialog_ifram')[0].src='./saleunit_new_contract_record/appoint/guangzhou/addContractRecords.action'; 
	};

	function get_ids(){
		var $strres = "";
		$("input[name='check_name']:checked").each(  
				function(){
					if($(this).val() != null){
					 $strres =  $strres +$(this).val().toString() +",";
					}  
				}  
			); 
		return $strres;
	}
	
	function update_handover_user_dialog(){
		$("#new_dialog").dialog({
			resizable: true,
			modal:true, 
			maximizable: false, 
			width:400,
			onClose:function(){
			$('#new_dialog_ifram').attr("src", "./saleunit_new/guangzhou/loading.jsp"); //清空内容
			},
			buttons:[ 
				{text:'提交',
				iconCls:'icon-ok',
				handler:function(){
				window.document.getElementById("new_dialog_ifram").contentWindow.dosubmit();
				}},
				{text:'关闭',
				handler:function(){
					$('#new_dialog').dialog('close');
				}}
			]
		});
		$('#new_dialog').dialog('open');
		$('#new_dialog').dialog('setTitle', '修改持有人'); 
		$('#new_dialog_ifram')[0].src="./saleunit_new_contract_record/appoint/guangzhou/handChangeDialog.action?ids="+get_ids();
	};
	
	$(document).ready(function(){
		$("#check_ids").click(function(){
			var che = $("#check_ids:checked").val();
			if(che == 'ids'){
				$(".check_id").attr('checked',true);
			}else{
				$(".check_id").attr('checked',false);
			}
			
		});
		
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
		
		$("#but_new_contr").click(function(){new_contra_dialog();});

		$("#but_update_handover_user").click(function(){update_handover_user_dialog();});

		$("#but_ct_re_submit").click(function(){submit_serach();});

		$("#sub_1").focus(function(){
			if($(this).val() == '合同编号'){
				$(this).val('');
			}
		});
		$("#sub_1").blur(function(){
			if($(this).val() == ''){
				$(this).val('合同编号');
			}
		});

		$("#sub_2").focus(function(){
			if($(this).val() == '签署日期起始'){
				$(this).val('');
			}
		});
		$("#sub_2").blur(function(){
			if($(this).val() == ''){
				$(this).val('签署日期起始');
			}
		});
		$("#sub_3").focus(function(){
			if($(this).val() == '签署日期结束'){
				$(this).val('');
			}
		});
		$("#sub_3").blur(function(){
			if($(this).val() == ''){
				$(this).val('签署日期结束');
			}
		});
		$("#sub_4").focus(function(){
			if($(this).val() == '客户姓名'){
				$(this).val('');
			}
		});
		$("#sub_4").blur(function(){
			if($(this).val() == ''){
				$(this).val('客户姓名');
			}
		});
		$("#sub_5").focus(function(){
			if($(this).val() == '成交金额'){
				$(this).val('');
			}
		});
		$("#sub_5").blur(function(){
			if($(this).val() == ''){
				$(this).val('成交金额');
			}
		});
		$("#sub_6").focus(function(){
			if($(this).val() == '销售人员'){
				$(this).val('');
			}
		});
		$("#sub_6").blur(function(){
			if($(this).val() == ''){
				$(this).val('销售人员');
			}
		});
		$("#sub_7").focus(function(){
			if($(this).val() == '当前状态'){
				$(this).val('');
			}
		});
		$("#sub_7").blur(function(){
			if($(this).val() == ''){
				$(this).val('当前状态');
			}
		});
		$("#sub_8").focus(function(){
			if($(this).val() == '当前持有人'){
				$(this).val('');
			}
		});
		$("#sub_8").blur(function(){
			if($(this).val() == ''){
				$(this).val('当前持有人');
			}
		});
		$("#sub_9").focus(function(){
			if($(this).val() == '备注'){
				$(this).val('');
			}
		});
		$("#sub_9").blur(function(){
			if($(this).val() == ''){
				$(this).val('备注');
			}
		});
		$(".cr_tr").dblclick(function(){
				new_shou_and_up_dialog($(this).attr("cid"));
		});
	});
	
</script>
<style>
.fontnowrite{color: #777777}
</style>
<div>

<input value="合同编号" style="width: 80px" class="fontnowrite" id="sub_1"/>
<!-- <input value="签署日期起始" style="width: 80px" class="fontnowrite" id="sub_2"/>
<input value="签署日期结束" style="width: 80px" class="fontnowrite" id="sub_3"/>
<input value="客户姓名" style="width: 80px" class="fontnowrite" id="sub_4"/>
<input value="成交金额" style="width: 80px" class="fontnowrite" id="sub_5"/>
<input value="销售人员" style="width: 80px" class="fontnowrite" id="sub_6"/>
<input value="当前状态" style="width: 80px" class="fontnowrite" id="sub_7"/>
<input value="当前持有人" style="width: 80px" class="fontnowrite" id="sub_8"/>
<input value="备注" style="width: 80px" class="fontnowrite" id="sub_9"/>
 -->
<input value=" 搜索 " type="button" id="but_ct_re_submit" class="btn1"/>
<input value=" 新建 " type="button" id="but_new_contr" class="btn1"/>
<input value=" 持有人 " type="button" id="but_update_handover_user" class="btn1">
</div>
<div id="cr_table_div">
<s:include value="contract_record_table.jsp"></s:include>
	</div>	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
