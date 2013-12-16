<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="gbox1">			  
			  
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
	 
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			客户姓名
		</td>
		
		 <td width="100" align="center" valign="middle">
			${customerMap.customerName}
		</td>
			
		
		 <td width="120" align="center" valign="middle">
			性别
		</td>
		
		 <td width="100" align="center" valign="middle">
			${customerMap.gender}
		</td>		
		  
	  </tr>
 
 
	  <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			证件类型
		</td>
		
		 <td width="100" align="center" valign="middle">
			${customerMap.idcardType}
		</td>
			
		
		 <td width="120" align="center" valign="middle">
			证件号码
		</td>
		
		 <td width="100" align="center" valign="middle">
			${customerMap.idcardNo}
		</td>		
		  
	  </tr>
	  
	   <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			联系电话
		</td>
		
		 <td width="100" align="center" valign="middle">
			${customerMap.phone}
		</td>
			
		
		 <td width="120" align="center" valign="middle">			
		</td>
		
		 <td width="100" align="center" valign="middle">			
		</td>		
		  
	  </tr>
	  
	    <tr onMouseOver="this.style.backgroundColor='#f1f9fe';" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF" style="line-height: 20px;"> 
			 
		 <td width="100" align="center" valign="middle">
			通信地址
		</td>
		
		 <td width="100" align="center" valign="middle" colspan="3">
			${customerMap.address}
		</td>
					  
	  </tr>
	  
	</table>
	</div>
 