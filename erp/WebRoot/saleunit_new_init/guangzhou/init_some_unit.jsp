<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	<meta http-equiv="Pragma" content="no-cache"/>
	<meta http-equiv="no-cache"/>
	<meta http-equiv="Expires" content="-1"/>
	<meta http-equiv="Cache-Control" content="no-cache"/>
	<title>认购</title>
	<base href="<%=basePath%>"/>
	<s:include value="../../header/header_easyui.jsp"></s:include>	  
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
	</style>
	<script>
		/*var products = [
		    {productid:'4',name:'两室一厅'},
		    {productid:'3',name:'一室一厅'},
		    {productid:'1',name:'三室一厅'},
		    {productid:'2',name:'三室两厅'}
		];*/

		
		$().ready(function(){
			$("#unit_no_input").blur(function(){
				var vn = $(this).val();
				if (vn.match(/^-?\d*$/) == null) {
					$(this).val("");
			    }
			})
			$("#unit_no_input_1").blur(function(){
				var vn = $(this).val();
				if (vn.match(/^-?\d*$/) == null) {
					$(this).val("");
			    }
			})
		});
		
		var payWay = [${selPayWay}];
		
		var orientations =[${selOrientations}];
		
		//var products = [${selRoomType}]; 

		var producttype = [${productType}]; 

		function _this_check_num(){
			alert($(this).val());
		}

		function gval1(name){
			for(var i=0; i<payWay.length; i++){
				if (payWay[i].name == name) return payWay[i].productid;
			}
			return name;
		};	
		function gval2(name){
			for(var i=0; i<orientations.length; i++){
				if (orientations[i].name == name) return orientations[i].productid;
			}
			return name;
		};
		
		function gval3(name){
			for(var i=0; i<products.length; i++){
				if (products[i].name == name) return products[i].productid;
			}
			return name;
		};	
		function gval4(name){
			for(var i=0; i<producttype.length; i++){
				if (producttype[i].name == name) return producttype[i].productid;
			}
			return name;
		};	
		
		function productFormatter(value){
			for(var i=0; i<products.length; i++){
				if (products[i].productid == value) return products[i].name;
			}
			return value;
		};
		function productFormatter1(value){
			for(var i=0; i<payWay.length; i++){
				if (payWay[i].productid == value) return payWay[i].name;
			}
			return value;
		};
		function productFormatter2(value){
			for(var i=0; i<orientations.length; i++){
				if (orientations[i].productid == value) return orientations[i].name;
			}
			return value;
		};
		function productFormatter3(value){
			for(var i=0; i<producttype.length; i++){
				if (producttype[i].productid == value) return producttype[i].name;
			}
			return value;
		};
		
		function submitForm(){//在submit前做好属性的处理
			var unitform1 = $("td[field='unitform1']"); 
			var unitform21 = $("td[field='unitform21']"); 
			var unitform22 = $("td[field='unitform22']"); 
			var unitform23 = $("td[field='unitform23']"); 
			var unitform3 = $("td[field='unitform3']"); 
			var unitform4 = $("td[field='unitform4']"); 
			var unitform5 = $("td[field='unitform5']"); 
			var unitform6 = $("td[field='unitform6']");
			var unitform7 = $("td[field='unitform7']");
			var unitform8 = $("td[field='unitform8']");

			var unitform9 = $("td[field='unitform9']");
			var unitform10 = $("td[field='unitform10']");
			var unitform11 = $("td[field='unitform11']");
			var unitform12 = $("td[field='unitform12']");
			 
			var usub1 = "";
			var usub21 = "";
			var usub22 = "";
			var usub23 = "";
			var usub3 = "";
			var usub4 = "";
			var usub5 = "";
			var usub6 = "";
			var usub7 = "";
			var usub8 = "";

			var usub9 = "";
			var usub10 = "";
			var usub11 = "";
			var usub12 = "";
			
			for(var i = 1 ;i<unitform1.length;i++){
				usub1 += $(unitform1[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform21.length;i++){//
				usub21 += $(unitform21[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform22.length;i++){//
				usub22 += $(unitform22[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform23.length;i++){//
				usub23 += $(unitform23[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform3.length;i++){
				usub3 += $(unitform3[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform4.length;i++){
				usub4 += $(unitform4[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform5.length;i++){
				usub5 += $(unitform5[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform6.length;i++){//
				usub6 += gval2($(unitform6[i]).text())+"&";
			}
			for(var i = 1 ;i<unitform7.length;i++){//
				usub7 += gval1($(unitform7[i]).text())+"&";
			}
			for(var i = 1 ;i<unitform8.length;i++){
				usub8 += $(unitform8[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform9.length;i++){
				usub9 += $(unitform9[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform10.length;i++){
				usub10 += $(unitform10[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform11.length;i++){
				usub11 += $(unitform11[i]).text()+"&";
			}
			for(var i = 1 ;i<unitform12.length;i++){
				usub12 += $(unitform12[i]).text()+"&";
			}
			
			$("#usub1").val(usub1);
			$("#usub21").val(usub21);
			$("#usub22").val(usub22);
			$("#usub23").val(usub23);
			$("#usub3").val(usub3);
			$("#usub4").val(usub4);
			$("#usub5").val(usub5);
			$("#usub6").val(usub6);
			$("#usub7").val(usub7);
			$("#usub8").val(usub8);

			$("#usub9").val(usub9);
			$("#usub10").val(usub10);
			$("#usub11").val(usub11);
			$("#usub12").val(usub12);
		};
		function tosubmit(){//提交表单
			if(editIndex != ""){
				$('#tt').datagrid('endEdit', editIndex);
			}
			
		//	alert("进入submit	")
			submitForm();//把table的数据写进hidden属性
			$("#init_some_unit_form").submit();
		};		

		//${doJava}
		
		var editIndex = "";
		
		$(function(){
			var lastIndex;
			$('#tt').datagrid({
				onBeforeLoad:function(){
					$(this).datagrid('rejectChanges');
				},
				onClickCell:function(rowIndex){
						$('#tt').datagrid('endEdit', editIndex);
						$('#tt').datagrid('beginEdit', rowIndex);
					//lastIndex = rowIndex;
				//	editIndex = lastIndex;
					editIndex = rowIndex;
				}
			});

			var oldmin;
			var oldmax;
			$("._unit_flo_num").blur(function(){///单元数过多的话 只生成一个
				var min = $('#_unit_flo_num_min').val();
				var mins=parseInt(min);
				var max = $('#_unit_flo_num_max').val();
				var maxs=parseInt(max);
				var num = max-min+1;
				var nums = maxs-mins+1;
				var beginZero='';
				var secondZero='';
				/*for(var i=0;i<min.length;i++){
					if(min.indexOf('0')==0){
						beginZero=beginZero+'0';
					}
					if(min)
				}*/
				if(min<10){
					if(min.indexOf('0')==0){
						beginZero='0';
						if(min.substr(1,min.length).indexOf('0')==0){
							secondZero='0';
						}
					}
				}else if(min<100){
					if(min.indexOf('0')==0){
						secondZero='0';
					}
				}
				
				if(num <= 0){
					//alert('请您设置有效的单元号 例如 1 - 10')
					return false ;}
				if(editIndex != ""){
					$('#tt').datagrid('endEdit', editIndex);
				}

				//1删除所有
				for(var i=lastIndex; i >= 0; i--){
					$('#tt').datagrid('deleteRow', i);
				}
				lastIndex = -1;
				
				if(nums > 20){//单元数比较大 
					for(var i=lastIndex; i>=0; i--){
						$('#tt').datagrid('deleteRow', i);
					}
					$('#tt').datagrid('appendRow',{
						unitform1:min+'-'+max
					});
					lastIndex = 0;
					return ;
				}else{
					for(var i=mins; i<= maxs; i++){
						if(i<10){
							$('#tt').datagrid('appendRow',{
								unitform1:beginZero+secondZero+i
							});
						}else if(i>=10){
							if(i<=20){
								$('#tt').datagrid('appendRow',{
									unitform1:secondZero+i
								});
							}
							if(i>20){
								$('#tt').datagrid('appendRow',{
									unitform1:secondZero+i
								});
							}
						}
						
					}
					lastIndex = $('#tt').datagrid('getRows').length -1;
				}
				
				/*if(lastIndex == undefined ){//完全重新建
					for(var i=min; i<=un; i++){
						$('#tt').datagrid('appendRow',{
							unitform1:i
						});
					}
					lastIndex = $('#tt').datagrid('getRows').length -1;
				}else if(lastIndex+1  < un-min+1){//row大约现有的
					alert('lastIndex+1  < un-min+1 :' + lastIndex)
					$('#tt').datagrid('endEdit', editIndex);
					if(lastIndex == '0'){
						$('#tt').datagrid('deleteRow', lastIndex);
						lastIndex = -1;
					}
					for(var i=lastIndex + min + 2; i<=un-min+1; i++){
						alert('++')
						$('#tt').datagrid('appendRow',{
							unitform1:i
						});
								
					}
					lastIndex = $('#tt').datagrid('getRows').length-1;
					//alert("lastIndex+1  < un"+" lastIndex = " +lastIndex)
				}else if(lastIndex+1  > un-min+1){
						for(var i=lastIndex; i>=un-min+1; i--){
							$('#tt').datagrid('deleteRow', i);
						}
					lastIndex = $('#tt').datagrid('getRows').length-1;

					//alert("lastIndex+1  > un"+" lastIndex = " +lastIndex)
				}else if(lastIndex+1  == un){
					//alert(lastIndex+"+1=="+un)
					if(un == '1'){
						$('#tt').datagrid('deleteRow', lastIndex);
						$('#tt').datagrid('appendRow',{
							unitform1:'1'
						});
						lastIndex = 0;
					}
				}*/
				
			//	lastIndex = $('#tt').datagrid('getRows').length-1;	
			});
			var selecttype = '1';
			
			$("#bu_f_name").keyup(function(){
				if(selecttype == '1'){
					$("#show_text").text($("#bu_f_name").val() + '1'+$("#un_f_name").val()+'1');
					}else{
						$("#show_text").text($("#bu_f_name").val() +$("#un_f_name").val()+'1');
					}
				
			});

			$("#un_f_name").keyup(function(){
				if(selecttype == '1'){
					$("#show_text").text($("#bu_f_name").val() + '1'+$("#un_f_name").val()+'1');
					}else{
						$("#show_text").text($("#bu_f_name").val() +$("#un_f_name").val()+'1');
					}
				
			});

			$("#name_type_1").click(function(){selecttype = '1';$("#show_text").text($("#bu_f_name").val() +$("#un_f_name").val());})
			$("#name_type_2").click(function(){selecttype = '2';$("#show_text").text($("#bu_f_name").val() +$("#un_f_name").val());})
		});
	</script>
</head>
<body>
<div class="gbox1">			
<form id="init_some_unit_form" action="./saleunit_new_init/appoint/guangzhou/initSomeUnitForm.action" method="post">
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:20px">		
		 
		 	   <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td colspan="4"><b>${topInfo} </b></td>
			  </tr>

            	<tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td>编号前缀</td><td><input name="buildFname"  id="bu_f_name" maxlength="15"/></td>
				<td>房号前缀</td><td><input name="unitFname" id="un_f_name" maxlength="15" value="-"/></td>
			  </tr>
			  <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td></td><td></td>
				<td>推货日期</td><td>
						<input class="easyui-datebox" name="saleTime"  />
				</td>
			  </tr>
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td colspan="4"> <input type="radio" name="nameType" value="1" id="name_type_1" checked="checked"/> 单元编号规则一(适合多,高层物业)  :编号前缀 + 楼层 + 房号前缀 + 房号</td>
			  </tr>
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td colspan="4"><input type="radio" name="nameType" value="2" id="name_type_2"/>  单元编号规则二(适合别墅,车位,商铺)  :编号前缀 + 房号前缀 + 房号</td>
			  </tr>
			  <tr bgcolor="#E9F5FF" style="empty-cells:show">
				<td colspan="4" style="color: red"><b>例如1层1单元:<span id="show_text"></span> </b></td>
			  </tr>
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<%-- <td>每层单元数</td><td><input id="_unit_flo_num" name="unitNum" style="width: 50px"  class="easyui-numberbox" required="required" min="1" max="500" missingMessage="必填"
				/></td>--%>
				<td>单元号</td><td>
				<input id="_unit_flo_num_min" name="unitNumMin" style="width: 50px"  class=" _unit_flo_num" required="required" min="1" max="5000" missingMessage="必填"
				/> - 
				<input id="_unit_flo_num_max" name="unitNumMax" style="width: 50px"  class=" _unit_flo_num" required="required" min="1" max="5000" missingMessage="必填"
				/>
				</td>
				<td>层数</td><td><input  class="easyui-numberbox" required="required" min="-5" max="999" missingMessage="必填"
				 id="unit_no_input" style="width: 50px;" maxlength="3" name="bfl"/> - 
				 <input class="easyui-numberbox" required="required" min="-5" max="999" missingMessage="必填"
				  id="unit_no_input_1" style="width: 50px;" maxlength="3" name="efl"/>
				
				 <input id="usub1" type="hidden" name="unitinfo.roomNo"/>
				 <%--<input id="usub2" type="hidden" name="unitinfo.roomType"/> --%>
				 <input id="usub21" type="hidden" name="unitinfo.roomNum"/> 
				 <input id="usub22" type="hidden" name="unitinfo.hallNum"/> 
				 <input id="usub23" type="hidden" name="unitinfo.toiletNum"/> 
				 <input id="usub3" type="hidden" name="unitinfo.insideArea"/>
				 <input id="usub4" type="hidden" name="unitinfo.buildArea"/>
				 <input id="usub5" type="hidden" name="unitinfo.insidePrice"/>
				 <input id="usub6" type="hidden" name="unitinfo.orientation"/>
				 <input id="usub7" type="hidden" name="unitinfo.priceWay"/>
				 <input id="usub8" type="hidden" name="unitinfo.buildPrice"/>
				 
				 <input id="usub9" type="hidden" name="unitinfo.productType"/>
				 <input id="usub10" type="hidden" name="unitinfo.renovateDesc"/>
				 <input id="usub11" type="hidden" name="unitinfo.renovatePrice"/>
				 <input id="usub12" type="hidden" name="unitinfo.renovateMoney"/>
				 <input type="hidden" value="${buildId}" name="buildId"/>
				</td>
				
			  </tr>
			   <tr bgcolor="#FFFFFF" style="empty-cells:show">
				<td colspan="4">
					<div>
						<table id="tt" style="width:780;height:auto"
							title="" iconCls="icon-edit" singleSelect="true"
							idField="unitform1">
						<thead>
							<tr>
								<th field="unitform1" width="80" editor="{type:'text'}">房号</th>
								<th field="unitform21" width="20" align="right"   editor="{type:'numberbox',options:{precision:0,max:9,min:0}}" >房</th>
								<th field="unitform22" width="20" align="right"  editor="{type:'numberbox',options:{precision:0,max:9,min:0}}" >厅</th>
								<th field="unitform23" width="20" align="right"   editor="{type:'numberbox',options:{precision:0,max:9,min:0}}" >卫</th>
								<th field="unitform3" width="80" align="right" editor="{type:'numberbox',options:{precision:4,max:9999,min:0}}">套内面积</th>
								<th field="unitform4" width="80"  align="right" editor="{type:'numberbox',options:{precision:4,max:9999,min:0}}">建筑面积</th>
								<th field="unitform5" width="80" align="right" editor="{type:'numberbox',options:{precision:2,max:999999,min:0}}">套内单价</th>
								<th field="unitform8" width="80" align="right" editor="{type:'numberbox',options:{precision:2,max:999999,min:0}}">建筑单价</th>
								<th field="unitform6" width="80" align="right" formatter="productFormatter2" editor="{type:'combobox',options:{valueField:'productid',textField:'name',data:orientations,required:false}}">朝向</th>
								<th field="unitform7" width="80" align="right" formatter="productFormatter1" editor="{type:'combobox',options:{valueField:'productid',textField:'name',data:payWay,required:false}}">计价方式</th>
								<th field="unitform9" width="110" align="right" formatter="productFormatter3" editor="{type:'combobox',options:{valueField:'productid',textField:'name',data:producttype,required:false}}">产品类型</th>
								<th field="unitform10" width="80" align="right" editor="{type:'validatebox'}">装修标准</th>
								<th field="unitform11" width="80" align="right" editor="{type:'numberbox',options:{precision:2,max:999999,min:0}}">装修单价</th>
								<th field="unitform12" width="80" align="right" editor="{type:'numberbox',options:{precision:2,max:999999999,min:0}}">装修款</th>
								</tr>
								</thead>
							</table>
					</div>
				</td>
			  </tr>
			</table>
			<font color="red">${inUnittips }</font>
</form>	
	
	</div>


</body>
</html>
