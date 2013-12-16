<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>

<head>
	
	<base href="<%=basePath%>">
	
	<style type="text/css">
		*{margin:0;padding:0;}
		body{font-size:75%}
		.gbox {
			background: none repeat scroll 0 0 #A9D9FF;
		}
	</style>
	
	<script type="text/javascript" language="javascript" src="./js/jquery-1.6.2.min.js"></script>
	
	<script type="text/javascript" language="javascript">
		//置业计划中的首付
		function calcPrice(l) {
			var b = document.getElementById("calcdrop").value;
			var m = $("#lbl_PriceForSale");
			var h = parseInt(m.val() * (1 - l)) * 10000;
			var g = document.getElementById("lbl_FirstPrice");
			var j = document.getElementById("lbl_Year");
			var f = document.getElementById("lbl_MonthPrice");
			var a = document.getElementById("lbl_MonthPrice2");
			g.innerHTML = ((m.val() * 10000 - h) / 10000).toFixed(6);;
			var e = document.getElementById("type").value;
			var d;
			if (e == "1") {
				if (l <= 60) {
					d = 0.005750000000000001;
				} else {
					d = 0.005874999999999999;
				}
			} else {
				if (l <= 60) {
					d = 0.003708333333333334;
				} else {
					d = 0.004083333333333334;
				}
			}
			var c = Math.round(h * d * Math.pow(1 + d, b) / (Math.pow(1 + d, b) - 1), 2);
			f.innerHTML = c;
			a.innerHTML = f.innerHTML;
		}
		
		//置业计划中的月供
		function calcLoan(j) {
			var l = $("#lbl_PriceForSale");
			var m = document.getElementById("firstloan").value;
			var g = parseInt(l.val() * (1 - m), 10) * 10000;
			var f = document.getElementById("lbl_FirstPrice");
			var h = document.getElementById("lbl_Year");
			var e = document.getElementById("lbl_MonthPrice");
			var a = document.getElementById("lbl_MonthPrice2");
			var d = document.getElementById("type").value;
			h.innerHTML = j / 12;
			var c;
			if (d == "1") {
				if (j <= 60) {
					c = 0.005750000000000001;
				} else {
					c = 0.005874999999999999;
				}
			} else {
				if (j <= 60) {
					c = 0.003708333333333334;
				} else {
					c = 0.004083333333333334;
				}
			}
			var b = Math.round(g * c * Math.pow(1 + c, j) / (Math.pow(1 + c, j) - 1), 2);
			e.innerHTML = b;
			a.innerHTML = e.innerHTML;
		} 
		
		function _load(){
			calcPrice(0.3);
			calcLoan(240);
		}

	</script>
	
</head>

<body onload="_load()">
	
	<table width="100%" border="0" align="left" cellpadding="0" cellspacing="1" class="gbox" >
	 
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="20%" align="center" valign="middle">
			月供
		</td>		
		 <td width="100" align="left" valign="middle" colspan="2">
			<span id="lbl_MonthPrice"></span>元&nbsp;*&nbsp;<span id="lbl_Year">20</span>年
		</td>
		  
	  </tr> 
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			总价
		</td>	
		 <td width="20%" align="left" valign="center">
			
			<span id="lbl_TotalPrice">${calcMap.sum}</span>万
			<input id="lbl_PriceForSale" type="hidden" value="${calcMap.sum}" name="lbl_PriceForSale">
		</td>	
		 <td width="100" align="left" valign="middle">
			<select id="type">
				<option value="1" selected="selected">商业贷款</option>
				<option value="2">公积金贷款</option>
			</select>
		</td>
		  
	  </tr> 
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			首付
		</td>		
		 <td width="20%" align="left" valign="middle">
			<span id="lbl_FirstPrice"></span>万
		</td>
		 <td width="100" align="left" valign="middle">
		 	<select onchange="javascript:calcPrice(this.options[this.options.selectedIndex].value)" id="firstloan" name="">
			  <option value="0.1">10%</option>
			  <option value="0.2">20%</option>
			  <option selected="selected" value="0.3">30%</option>
			  <option value="0.4">40%</option>
			  <option value="0.5">50%</option>
			  <option value="0.6">60%</option>
			  <option value="0.7">70%</option>
			  <option value="0.8">80%</option>
			  <option value="0.9">90%</option>
			</select>
		</td>
		  
	  </tr> 
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			月供
		</td>		
		 <td width="20%" align="left" valign="middle">
			<span id="lbl_MonthPrice2"></span>元
		</td>
		 <td width="100" align="left" valign="middle">
			<select onchange="javascript:calcLoan(this.options[this.options.selectedIndex].value)" id="calcdrop" name="">
			   <option value="24">2年24期</option>
			  <option value="36">3年36期</option>
			  <option value="48">4年48期</option>
			  <option value="60">5年60期</option>
			  <option value="72">6年72期</option>
			  <option value="84">7年84期</option>
			  <option value="120">10年120期</option>
			  <option selected="selected" value="240">20年240期</option>
			  <option value="360">30年360期</option>
			</select>
		</td>
		  
	  </tr> 
 
	</table>
	
</body>

</html>
