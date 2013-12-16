<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>售前客户问卷 </title>
<s:include value="header_report.jsp"></s:include>
<script type="text/javascript">

/**
 * 增加题目function
 */
function _customer_before_addtoc_dialog(){//hidid = qid
	if($("#selectQuestionId").val()==0||$("#selectQuestionId").val()==''){
		myAlert('请先选择问卷');
		return;
	}
	var selectQuestionId=$("#selectQuestionId").val();
	$.ajax({
		url:'./saleunit_new_init/appoint/guangzhou/questionHasBeUsed.action?selectQuestionId='+selectQuestionId,
		success:function(data){
			if(data!='0'){
				myAlert('问卷已经被使用，不能增加、修改或删除题目');
				return;
			}else{
				new MyAjaxIframeDialog({title:'新建问题',height:400, width:500,formId:'question_toc_form',
		closeFn:reloadTopicTable,ids:["topic_name","answer_id"],
		src:'./saleunit_new_init/appoint/guangzhou/customerBeforeDialogForMain.action?selectQuestionId='+selectQuestionId
		});
			}
		}
	});
	
	};

$().ready(function(){
	
			
	//页面加载时执行
	//projectListForHiddenId("projectName", "hiddenId"); //项目的联想框,及用隐藏域保存其id
	bindProjectDialogForSQKHOnly("projectName", "projectId"); //多个项目的选择

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
})

/**
 * 修改题目function
 */
function _customer_before_moditoc_dialog(){//hidid = qid
	if($("#selectTopicId").val()==0||$("#selectTopicId").val()==''){
		myAlert('请先选择题目');
		return;
	}
	var selectQuestionId=$("#selectQuestionId").val();
	var selectTopicId=$("#selectTopicId").val();
	$.ajax({
		url:'./saleunit_new_init/appoint/guangzhou/questionHasBeUsed.action?selectQuestionId='+selectQuestionId,
		success:function(data){
			if(data!='0'){
				myAlert('问卷已经被使用，不能增加、修改或删除题目');
				return;
			}else{
				new MyAjaxIframeDialog({title:'修改问题',height:400, width:500,formId:'question_toc_form',
		closeFn:reloadTopicTable,ids:["topic_name","answer_id"],
		src:'./saleunit_new_init/appoint/guangzhou/customerBeforeDialogForMainModify.action?selectQuestionId='+selectQuestionId+'&selectTopicId='+selectTopicId
		});
			}
		}
	});
	
	
	
}

/**
 * 删除题目function
 */
function _customer_before_deletetoc_dialog(){//hidid = qid
	if($("#selectTopicId").val()==0||$("#selectTopicId").val()==''){
		myAlert('请先选择题目');
		return;
	}
	var selectQuestionId=$("#selectQuestionId").val();
	var selectTopicId=$("#selectTopicId").val();
	$.ajax({
		url:'./saleunit_new_init/appoint/guangzhou/questionHasBeUsed.action?selectQuestionId='+selectQuestionId,
		success:function(data){
			if(data!='0'){
				myAlert('问卷已经被使用，不能增加、修改或删除题目');
				return;
			}else{
				var url='./saleunit_new_init/appoint/guangzhou/deleteTopicTable.action?selectTopicId='+selectTopicId;
				deletePojo(url, reloadTopicTable , selectTopicId);
		
			}
		}
	});
}

function _customer_before_ordertoc_dialog(){
	if($("#selectQuestionId").val()==0||$("#selectQuestionId").val()==''){
		myAlert('请先选择问卷');
		return;
	}
	var selectQuestionId=$("#selectQuestionId").val();
	new MyAjaxIframeDialog({title:'问题排序',height:400, width:500,formId:'question_toc_form',
		closeFn:reloadTopicTable,ids:["topic_name","answer_id"],
		src:'./saleunit_new_init/appoint/guangzhou/customerBeforeDialogForMainOrder.action?selectQuestionId='+selectQuestionId});
}


function getTopicById(id){
	var query = $("#thisForm").serialize();
		$("#topictable").datagrid({
			url:'./saleunit_new_init/appoint/guangzhou/getTopicById.action?selectQuestionId='+id
		});	
}

/**
 * 增加问卷function
 */
function _customer_before_add_question(){
	if($("#projectId").val()==0||$("#projectId").val()==''){
		myAlert('请先选择项目');
		return;
	}
	var projectId=$("#projectId").val();
	new MyAjaxIframeDialog({title:'新建问卷',height:400, width:500,formId:'question_form',
		closeFn:reloadAllTable,ids:["question_name"],
		src:'./saleunit_new_init/appoint/guangzhou/customerBeforeAddQuestion.action?projectId='+projectId
		})
}

/**
 * 复制问卷function
 */
function _customer_before_copy_question(){
	if($("#projectId").val()==0||$("#projectId").val()==''){
		myAlert('请先选择项目');
		return;
	}
	if($("#selectQuestionId").val()==''){
		myAlert('请先选择问卷');
		return;
	}
	var projectId=$("#projectId").val();
	var selectQuestionId=$("#selectQuestionId").val();
	new MyAjaxIframeDialog({title:'复制问卷',height:400, width:500,formId:'question_form',
		closeFn:reloadAllTable,ids:["question_name"],
		src:'./saleunit_new_init/appoint/guangzhou/customerBeforeAddQuestion.action?projectId='+projectId+'&selectQuestionId='+ selectQuestionId+'&flag='+true
		})
}


/**
 * 修改问卷function
 */
function _customer_before_modify_question(){
	if($("#projectId").val()==0||$("#projectId").val()==''){
		myAlert('请先选择项目');
		return;
	}
	var projectId=$("#projectId").val();
	var selectQuestionId=$("#selectQuestionId").val();
	if(selectQuestionId==0||selectQuestionId==''){
		myAlert('请先选择问卷,基本售前问卷不能修');
		return;
	}
	new MyAjaxIframeDialog({title:'修改问卷',height:400, width:500,formId:'question_form',
		closeFn:reloadAllTable,ids:["question_name"],
		src:'./saleunit_new_init/appoint/guangzhou/customerBeforeModifyQuestion.action?projectId='+projectId+'&selectQuestionId='+selectQuestionId
		})
}


/**
 * 删除问卷function
 */
function _customer_before_delete_question(){
	if($("#projectId").val()==0||$("#projectId").val()==''){
		myAlert('请先选择项目');
		return;
	}
	if($("#selectQuestionId").val()==''){
		myAlert('请先选择问卷');
		return;
	}
	var projectId=$("#projectId").val();
	var selectQuestionId=$("#selectQuestionId").val();
	$.ajax({
		url:'./saleunit_new_init/appoint/guangzhou/questionHasBeUsed.action?selectQuestionId='+selectQuestionId,
		success:function(data){
			if(data != '0'){
				myAlert('问卷已经被使用，不能删除');
				return;
			}else{
				var url='./saleunit_new_init/appoint/guangzhou/deleteQuestionTable.action?selectQuestionId='+selectQuestionId;
				deletePojo(url, reloadQuestionTable , selectQuestionId);
				
			}
		}
	});
}

$(function(){		
			
			$("#questiontable").datagrid({
				loadMsg:'加载中...',
				rownumbers:true,
				singleSelect:true,
				striped:true,
				nowrap:false,
				fitColumns:true,
				onSelect:function(rowIndex, rowData){
					$("#selectQuestionId").attr('value',rowData.id);
					reloadTopicTable();
					getTopicById(rowData.id);
					if($("input:radio:checked").attr('name')!= 'undefined'){
					var radioCheckedId = $("input:radio:checked").attr('value');
					$.post('./saleunit_new_init/appoint/guangzhou/setDefaultQuestion.action?id='+radioCheckedId+'&projectId='+$("#projectId").val());
					}
					if(rowData.id=='0'){
						//$("#changeTable").load('./customer_guangzhou/input/getBaseQuestion.action',{proId:$("#hiddenId").val()});
						$("#changeTable").toggle(true);
						$("#_but_cus_before_add").toggle(false);
						$("#_but_cus_before_modify").toggle(false);
						$("#_but_cus_before_delete").toggle(false);
						$("#_but_cus_before_order").toggle(false);
					}
					else{
						$("#changeTable").toggle(false);
						$("#_but_cus_before_add").toggle(true);
						$("#_but_cus_before_modify").toggle(true);
						$("#_but_cus_before_delete").toggle(true);
						$("#_but_cus_before_order").toggle(true);
					}
				}	
			});
			
			$("#topictable").datagrid({
				loadMsg:'加载中...',
				rownumbers:true,
				singleSelect:true,
				striped:true,
				nowrap:false,
				fitColumns:true,
				onSelect:function(rowIndex, rowData){
					$("#selectTopicId").attr('value',rowData.id);
				}	
			});
		})

function submitSearch(dir){
		var query = $("#thisForm").serialize();
		$("#questiontable").datagrid({
			url:'./saleunit_new_init/appoint/guangzhou/customerBeforeTabAjax.action?'+query
		});		
		reloadAllTable();
}

function reloadQuestionTable(){
	$("#selectQuestionId").attr('value','');
	$("#questiontable").datagrid('reload');
	$("#topictable").datagrid('reload');
}

function reloadTopicTable(){
	$("#selectTopicId").attr('value','');
	$("#topictable").datagrid('reload');
	$("#changeTable").toggle(false);
}

function reloadAllTable(){
	getTopicById('');
	reloadTopicTable();
	reloadQuestionTable();
}

function do_del_question_by_deid(delid){
	$.post('./saleunit_new_init/appoint/guangzhou/customerBeforeDelByDeId.action',{'deId':delid},						submitSearch());
}


$.messager.defaults = { ok: "确定", cancel: "取消" };
function del_select_question(delid){

	$.messager.confirm('询问框','是否确定删除问题?',function(r){  
	    if (r){  
	    	do_del_question_by_deid(delid);
	    }
	});  
		return false;
	}
	
/* */
 
 
</script>
</head>
<body class="easyui-layout">

<div region="center" style="padding:0px;background:#efefef;" title='<form class="registerform" id="thisForm"  method="post">
&nbsp;项目<input type="text" id="projectName" name="projectName" size="40" value="${customerCond.strSearchProjectNames}"/>
<input type="hidden" id="projectId" name="customerCond.projectId" value="${customerCond.projectId}"/>
<input type="hidden" id="selectQuestionId" name="selectQuestionId" />
<input type="hidden" id="selectTopicId" name="selectTopicId" />
&nbsp;<input type="button" onclick="return submitSearch()" value=" 查询  "/>
<input type="button" value="  添加问卷  " class="btn1" id="_but_cus_before_add_question" onclick="_customer_before_add_question()"/>
<input type="button" value="  修改问卷  " class="btn1" id="_but_cus_before_modify_question" onclick="_customer_before_modify_question()"/>
<input type="button" value="  复制问卷  " class="btn1" id="_but_cus_before_copy_question" onclick="_customer_before_copy_question()"/>
<input type="button" value="  删除问卷  " class="btn1" id="_but_cus_before_delete_question" onclick="_customer_before_delete_question()"/>
<font color="red">说明:同一个项目下，售前客户问卷初始化的问题相同。</font>
<br/>
</form>'>

<div class="easyui-layout" fit="true" style="background:#cccccc;">

<div region="center" style="padding:0px;background:#efefef; height:300px;" id="_center">

<table width="95%" height="612px;" border="0" align="left" cellpadding="0" cellspacing="1" class="registerform"  id="questiontable">
	<thead>
	<tr style="line-height: 20px;background: #E9F5FF">
		<th field="id" hidden="true"></th>
		<th field="questionName" width="220px" align="center">问卷名称</th>
		<th field="createId" width="220px" align="center">操作人</th>
		<th field="createTime" width="220px" align="center">操作时间</th>
		<th field="remark" width="220px" align="center">说明</th>
		<th field="isDefault" width="140px" align="center">默认问卷</th>
	</tr>
	</thead>
</table>

</div>

<!--
<div region="south" id="center_bottom" spilt="true" style="padding:0px;background:#efefef;height:250px; width:auto" title="&nbsp;">
-->
<div region="south" id="center_bottom" split="true" style="height:280px; width:300px;background:#efefef;" title="&nbsp;">
<form class="registerform" id="topicForm"  method="post">
<input type="button" value="  增加题目  " class="btn1" id="_but_cus_before_add" onclick="_customer_before_addtoc_dialog()"/>
<input type="button" value="  修改题目  " class="btn1" id="_but_cus_before_modify" onclick="_customer_before_moditoc_dialog()"/>
<input type="button" value="  删除题目  " class="btn1" id="_but_cus_before_delete" onclick="_customer_before_deletetoc_dialog()"/>
<input type="button" value="  题目排序  " class="btn1" id="_but_cus_before_order" onclick="_customer_before_ordertoc_dialog()"/>
<table width="100%"  border="0" align="left" cellpadding="0" cellspacing="1" class="registerform"  id="topictable">
	<thead>
	<tr style="line-height: 20px;background: #E9F5FF">
		<th field="id" hidden="true"></th>
		<th  field="topicName" width="auto" align="center">问题</th>
		<th  field="topicContent" width="auto" align="center">选项</th>
	</tr>
	</thead>
	
</table>
<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" 
style="white-space: nowrap;display:none;" id="changeTable">
              <tr  bgcolor="#FFFFFF" id="change1">
                <td align="right">来访次数&nbsp;</td>
                <td>
					<s:select list="selVisitCount"  name="customer.visitCount" />	
				</td>
                <td style="width:15%" align="right">性别&nbsp;</td>
                <td style="width:18%">
					<s:select list="selGender"  name="customer.gender" />	
				</td>
                <td style="width:15%" align="right">国籍&nbsp;</td>
                <td>
					<input type="text" name="customer.nationality" id="nationality" class="leftcreateinputbox01" maxlength="10"/>
				</td>
              </tr>
              
			  <tr  bgcolor="#FFFFFF">
                <td align="right">身份证号码&nbsp;</td>
                <td style="width:18%">
					<input type="text" name="customer.idcardNo" id="idcardNo" class="leftcreateinputbox02" style="width:auto"
					onkeyup="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" onkeydown="valueChangeGetCount('idcardNo', 'idcardNoCount', 18)" maxlength="18"/>
					<span id="idcardNoCount"></span>
				</td>
                <td  align="right">驾车车型&nbsp;</td>
                <td>
					<input type="text" name="customer.trafficDesc" id="trafficDesc" class="leftcreateinputbox02" style="width:auto" maxlength="10"/>
					
				</td>
                <td align="right">年龄&nbsp;</td>
                <td>
					<s:select list="selAgeRange"  name="customer.age" />	
				</td>
              </tr>
			  
			   <tr  bgcolor="#FFFFFF">
                <td align="right">地址&nbsp;</td>
                <td colspan="3">
					<input type="text" name="customer.address" id="address" class="leftcreateinputbox02" style="width:80%" maxlength="100"/>				
				</td>
                <td align="right">邮编&nbsp;</td>
                <td id="t8">
					<input type="text" name="customer.postcode" id="postcode" class="leftcreateinputbox01" maxlength="10"/>				
					
				</td>
              </tr>
			  
			  
             <tr  bgcolor="#FFFFFF">
                <td align="right">家庭结构&nbsp;</td>
                <td>
					<s:select list="selFamilyType"  name="customer.familyType" />	
				</td>
                <td align="right">家庭收入&nbsp;</td>
                <td>
					<s:select list="selFamilyIncome"  name="customer.familyIncome" />	
				</td>
				 <td style="width:15%" align="right"></td>
                <td>
				</td>
               
             </tr>
			  
			  <tr  bgcolor="#FFFFFF">
                <td align="right">行业分类&nbsp;</td>
                <td>
					<s:select list="selJobType"  name="customer.jobType" />	
				</td>
                <td align="right">职业&nbsp;</td>
                <td>
					<s:select list="selJobIndustry"  name="customer.jobIndustry" />	
				</td>
                <td align="right">&nbsp;</td>
                <td>				</td>
              </tr>
			  
			   <tr  bgcolor="#FFFFFF">
                <td align="right">意向购买单元1&nbsp;</td>
                <td>
					<input type="text" id="intentUnit1" name="customer.intentUnit1" maxlength="10"/>
				</td>
                <td align="right">意向购买单元2&nbsp;</td>
                <td>
					<input type="text" id="intentUnit2" name="customer.intentUnit2" maxlength="10"/>
				</td>
                <td align="right">&nbsp;</td>
                <td>				</td>
              </tr>
			  
			   <tr  bgcolor="#FFFFFF">
                <td align="right">购房目的&nbsp;</td>
                <td>
					<s:select list="selBuyAim"  name="customer.buyAim" />
				</td>
                <td align="right">付款方式&nbsp;</td>
                <td>
					<s:select list="selPayType"  name="customer.payType" />	
				</td>
                <td id="t5"  align="right">&nbsp;</td>
                <td>				</td>
              </tr>
	  
	
	  
	    <tr  bgcolor="#FFFFFF">
              
                <td align="right">意向套数&nbsp;</td>
                <td>
					<s:select list="selIntentBuynum"  name="customer.intentBuynum" />	
				</td>
                <td align="right">意向户型&nbsp;</td>
                <td>
				  <s:select list="selRoomType"  name="customer.roomType" />	
			    </td>
				
				<td align="right"></td>
                <td></td>
             </tr>
	  
	   <tr  bgcolor="#FFFFFF">
		<td id="t1" style="width:15%"  align="right">认知途径&nbsp;</td>
		<td colspan="5" style="white-space:normal">
						<s:iterator value="#request.selCustomerKnownFrom" id="cc">
			 <div style="float: left;padding-right: 10px;padding-top: 5px">
			 	<label style="margin: 0">
			 	<input name="knownFrom" type="checkbox" value="${cc.key }"  style="vertical-align: text-bottom;"/>
			 	<s:property value="#cc.value"/>
			 	</label>
			 	</div>
			 </s:iterator>
		</td>
	  </tr>
	  
	  <tr  bgcolor="#FFFFFF">
		<td align="right">关注点&nbsp;</td>
		<td colspan="5" style="white-space:normal">
			 <s:iterator value="#request.selCustomerFocus" id="c">
			 <div style="float: left;padding-right: 10px;padding-top: 5px">
			 	<label style="margin: 0">
			 	<input name="customerFocus" type="checkbox" value="${c.key }"  style="vertical-align: text-bottom;"/>
			 	<s:property value="#c.value"/>
			 	</label>
			 	</div>
			 </s:iterator>
			<input type="hidden" id="focusPoint" style=" "/>
		</td>
	  </tr>
	  
	   <tr  bgcolor="#FFFFFF">
		<td align="right">未能成交原因&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.notBuyReson" id="notBuyReson" class="leftcreateinputbox02" style="width:80%" maxlength="50"/>			
		</td>
	  </tr>
	  
	   <tr  bgcolor="#FFFFFF">
		<td align="right">备注&nbsp;</td>
		<td colspan="5" style="white-space:normal">	
			<input type="text" name="customer.remark1" id="remark1" class="leftcreateinputbox02" style="width:80%" maxlength="100"/>			
		</td>
	  </tr>
	  
	   </table>
		
</form>
</div>

</div>

</div>

</body>
</html>