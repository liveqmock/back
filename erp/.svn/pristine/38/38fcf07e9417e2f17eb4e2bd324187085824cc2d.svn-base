<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="my" uri="/WEB-INF/my.tld" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
	
	<title>选择销售</title>

	<s:include value="../../customer/guangzhou/header_min.jsp"></s:include>	  
	
	<script type="text/javascript" language="javascript">
		$().ready(function(){
		
			baseAutoComplete("companySaleName", "commpanySaleId", "./saleunit_new/appoint/guangzhou/searchSaleForCompany.action", "");		

		});
		
		function allChange(){
		
			var projectIds = $("input[name=sale]");
			$(projectIds).each(function(){
			
				$(this).attr("checked", "checked");
			});
		}
		
		function noChange(){
		
			var projectIds = $("input[name=sale]");
			$(projectIds).each(function(){
			
				$(this).removeAttr("checked");
			});
		}
		
		function submitCompany(){
			
			var saleName = $("#companySaleName").val();
			var saleId = $("#commpanySaleId").val();
			
			if(saleId != ""){
			
				var appendTr = $(".appendTr:last");
				if(appendTr.html() != null){
					//表示之前已经增加过
					
					var secondTd = $(appendTr.find("td")[1]).text();
					if(secondTd == ""){
					 	//第二个td为空
						
						var td = "<input type='checkbox' value='" + saleId + "' label='" + saleName + "' name='sale' checked='checked'/>" + saleName;
						$(appendTr.find("td")[1]).html(td);
						
					}else{
					
						var tr = "<tr class='appendTr'><td style='width:15%; padding-left:10px' align='left'><input type='checkbox' value='"
							+ saleId + "' label='" + saleName + "' name='sale' checked='checked'/>"
							+ saleName + "</td><td style='width:30%; padding-left:10px' align='left'></td></tr>"
							;
					
						$("#companySaleTr").before(tr);
						
					}
					
				}else{
				
					var tr = "<tr class='appendTr'><td style='width:15%; padding-left:10px' align='left'><input type='checkbox' value='"
						+ saleId + "' label='" + saleName + "' name='sale' checked='checked'>"
						+ saleName + "</td><td style='width:30%; padding-left:10px' align='left'></td></tr>"
						;
				
					$("#companySaleTr").before(tr);
					
				}
			
			}
			
			//还原
			$("#companySaleName").val("");
			$("#commpanySaleId").val("");

		}
		
	</script>
	
	<style type="text/css">
		*{margin:0;padding:0;}
		.appendTr{background-color:#D9E5FD;}
	</style>
	
</head>
	
<body>
<div class="gbox1">			
		 
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" style="font-size:12px; line-height:26px">	
	 
	  <tr bgcolor="#E9F5FF" style="empty-cells:show">
		
		<td id="t15" style="width:30%" align="center"><b>销售</b>&nbsp;</td>
		<td>
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return allChange()"><font color="#5482DE">全选</font></a>
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return noChange()"><font color="#5482DE">取消</font></a>
		</td>
	  </tr>
	  
	   <s:iterator value="#request.proBeanTrList" id="c">  
	  
	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="empty-cells:show">
	  
		<td id="t15" style="width:15%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[0].id}" label="${c[0].name}" name="sale" check="${c[0].check}"/></td>
		<td id="t16" style="width:30%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[1].id}" label="${c[1].name}" name="sale" check="${c[1].check}"/></td>
					
	  </tr>	
	  
	  </s:iterator>
	  
	  <s:iterator value="#request.comBeanTrList" id="c">  
	  
	  <tr class="appendTr">
	  
		<td id="t15" style="width:15%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[0].id}" label="${c[0].name}" name="sale" check="${c[0].check}"/></td>
		<td id="t16" style="width:30%; padding-left:10px" align="left"><my:checkbox fieldValue="${c[1].id}" label="${c[1].name}" name="sale" check="${c[1].check}"/></td>
					
	  </tr>	
	  
	  </s:iterator>
	  
	   <tr bgcolor="#E9F5FF" style="empty-cells:show" id="companySaleTr">
		
		<td id="t15" style="width:30%" align="center"><b>其他项目的销售</b>&nbsp;</td>
		<td></td>
	  </tr>

	  <tr  onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" 
		style="empty-cells:show; height:26px">
		<td id="t15" style="width:15%" align="center">
		 <input type="text" id="companySaleName"/>
		  <input type="hidden" id="commpanySaleId" /> 
		</td>
		<td id="t16" style="width:30%">				 				 
		 <a href="javascript:void(0)" style="padding:0 0 0 10px" onclick="return submitCompany()"><font color="#5482DE">确定</font></a>
		</td>
		
	  </tr>		
</table>
	
</div>


</body>
</html>