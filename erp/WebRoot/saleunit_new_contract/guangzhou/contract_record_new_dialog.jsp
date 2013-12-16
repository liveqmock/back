<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>新建合同</title>

	<s:include value="../../customer/guangzhou/header.jsp"></s:include>	  
	<style type="text/css">
		*{margin:0;padding:0;}
	</style>
	<script type="text/javascript" language="javascript" src="<%=basePath%>js/jquery.easyui.min.js"></script>
	<script type="text/javascript" language="javascript" src="<%=basePath%>css/local/easyui-lang-zh_CN.js"></script>
<script>

			function showTips(date){
				$("#show_tips").html(date);
			};
	
			function dosubmit (){
				$input1str ="";
				$input2str ="";
				$input3str ="";
				$input4str ="";
				$input5str ="";
				$input6str ="";
				$input7str ="";
				$input8str ="";
				
				$("input[name='input1']").each(  
					function(){  
						$input1str =  $input1str+","+$(this).val();  
					}  
				);  
				$("input[name='input2']").each(  
						function(){  
							$input2str = $input2str +","+$(this).val().toString();  
						}  
					); 
				$("input[name='input3']").each(  
						function(){  
							$input3str = $input3str +","+$(this).val().toString();  
						}  
					); 
				$("input[name='input4']").each(  
						function(){  
							$input4str = $input4str +","+$(this).val().toString();  
						}  
					); 
				$("input[name='input5']").each(  
						function(){  
							$input5str = $input5str +","+$(this).val().toString();  
						}  
					); 
				$("input[name='input6']").each(  
						function(){  
							$input6str = $input6str +","+$(this).val().toString();  
						}  
					); 
				$("input[name='input7']").each(  
						function(){  
							$input7str = $input7str +","+$(this).val().toString();  
						}  
					); 
				$("input[name='input8']").each(  
						function(){  
							$input8str = $input8str +","+$(this).val().toString();  
						}  
					); 
				$.post('./saleunit_new_contract_record/appoint/guangzhou/addContractRecordsForm.action',
					{input1:$input1str,
					input2:$input2str,
					input3:$input3str,
					input4:$input4str,
					input5:$input5str,
					input6:$input6str,
					input7:$input7str,
					input8:$input8str},function(date){
						$("#show_tips").html(date);
						});
			}

			
			
			function doaddtr(){
					    $str='';
					    $str+="<tr style='background: #ffffff'>";
					    $str+="<td align='center'><input name='input1'/></td>";
					    $str+="<td  align='center'><input name='input2'/></td>";
					    $str+="<td  align='center'><input name='input3'/></td>";
					    $str+="<td  align='center'><input name='input4'/></td>";
					    $str+="<td  align='center'><input name='input5'/></td>";
					    $str+="<td  align='center'><input name='input6'/></td>";
					    $str+="<td  align='center'><input name='input7'/></td>";
					    $str+="<td  align='center'><input name='input8'/></td>";
					    $str+="</tr>";
						$("#this_table").append($str);   
			}
		
	</script>
	</head>
<body>
		
<table  border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" id="this_table">
			<tr  style="line-height: 20px;background:#E9F5FF" > 
				<th width="80px" align="center" >合同编号</th>
				<th width="80px" align="center">签署日期</th>
				<th width="80px" align="center">客户姓名</th>
				<th width="80px" align="center">成交金额</th>
				<th width="80px" align="center">销售人员</th>
				<th width="80px" align="center">当前状态</th>
				<th width="80px" align="center">当前持有人</th>
				<th width="80px" align="center">备注</th>
			</tr>
			<tr style="background: #ffffff">
				
				<td  align="center"><input name="input1"/></td>
				<td  align="center"><input name="input2"/></td>
				<td  align="center"><input name="input3"/></td>
				<td  align="center"><input name="input4"/></td>
				<td  align="center"><input name="input5"/></td>
				<td  align="center"><input name="input6"/></td>
				<td  align="center"><input name="input7"/></td>
				<td  align="center"><input name="input8"/></td>
			</tr>
			
</table>

<p id="show_tips" style="color: red"></p>
</body>
</html>
