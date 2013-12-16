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

<script type="text/javascript">
		
			var chart;
			$(document).ready(function() {
				
				chart = new Highcharts.Chart({
					chart: {
						renderTo: 'container',
						defaultSeriesType: 'line',
						marginRight: 130,
						marginBottom: 25
					},
					title: {
						text: '销售数据月统计',
						x: -20 //center
					},
					//subtitle: {
					//	text: 'Source: WorldClimate.com',
					//	x: -20
					//},
					xAxis: {
						//需要补充的x坐标
						categories: <s:property value="chartXAxis" escape="false"/>//['12-01', '11-02', '11-03', '11-04', '11-05', '11-06', 
							//'11-07', '11-07', '11-09', '11-10','11-11','11-12','11-13','11-14','11-15','11-16','11-17','11-18','11-19','11-20','11-21','11-22','11-23','11-24','11-25','11-26','11-27','11-28','11-29','11-30','11-31']
					},
					yAxis: {
						title: {
							text: '销售金额 (千元)'
						},
						plotLines: [{
							value: 0,
							width: 1,
							color: '#808080'
						}]
					},
					tooltip: {
						formatter: function() {
				                return '<b>'+ this.series.name +'</b><br/>'+
								this.x +': '+ this.y +'千元';
						}
					},
					legend: {
						layout: 'vertical',
						align: 'right',
						verticalAlign: 'top',
						x: -10,
						y: 100,
						borderWidth: 0
					},
					series: <s:property value="chartSeries"  escape="false"/> 
					
					
				});
				
				
			});
				
</script>
<title>恒大客户管理系统</title>

<link href="../css/tianluan.css"  rel="stylesheet" type="text/css" charset="utf-8"/>

</head>

<body>


<!--main-->
<table width="100%" border="0" cellspacing="0">
  <tr>
     
	 <s:include value="left.jsp"></s:include>
	 
  
    <td><table width="100%" border="0" align="right" cellspacing="0">
      <tr>
        <td width="3" height="3" class="leftbg01"></td>
        <td class="midbg01"></td>
        <td width="2" height="3" background="images/righttop.gif"></td>
      </tr>
      <tr>
        <td width="3" class="leftbg02"></td>
        <td bgcolor="#FFFFFF"><table width="98%" border="0" align="center" cellspacing="0">
  <tr>
    <td width="30%" valign="top"><table width="100%" border="0" align="center" cellspacing="0">
      <tr>
        <td height="32" colspan="3"><span class="titleblue">最新公告</span> <a href="#" onclick="return false"><span class="more">More..</span></a></td>
        </tr>
      <tr>
        <td colspan="3" background="images/blueline.jpg" class="blueline20111105"></td>
      </tr>
      <tr>
        <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
        <td height="22" valign="middle">最新通知12-2-12：新账户开通 <img src="images/new.gif" width="16" height="16" alt="new" /></td>
        <td width="18%" align="right">10-02</td>
      </tr>
      <tr>
        <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
        <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
        <td width="18%" align="right">10-02</td>
      </tr>
      <tr>
        <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
        <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
        <td width="18%" align="right">10-02</td>
      </tr>
      <tr>
        <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
        <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
        <td width="18%" align="right">10-02</td>
      </tr>
      <tr>
        <td width="15" height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
        <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
        <td width="18%" align="right">10-02</td>
      </tr>
    </table>
      <table width="100%" border="0" align="center" cellspacing="0">
        <tr>
          <td height="32" colspan="3"><span class="titleblue">最新录入</span> <a href="#" onclick="return false"><span class="more">More..</span></a></td>
        </tr>
        <tr>
          <td colspan="3" background="images/blueline.jpg" class="blueline20111105"></td>
        </tr>
        <tr>
          <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
          <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
          <td width="10%">10-02</td>
        </tr>
        <tr>
          <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
          <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
          <td width="10%">10-02</td>
        </tr>
        <tr>
          <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
          <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
          <td width="10%">10-02</td>
        </tr>
        <tr>
          <td height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
          <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
          <td width="10%">10-02</td>
        </tr>
        <tr>
          <td width="15" height="18"><img src="images/arrow_collapse.gif" width="10" height="10" alt="arrow" /></td>
          <td height="22"><a href="#" target="_blank" onclick="return false">最新通知12-2-12：新账户开通</a></td>
          <td width="10%">10-02</td>
        </tr>
      </table></td>
    <td width="70%" rowspan="2" valign="top"><table width="98%" border="0" align="right" cellspacing="0" class="picbox" >
      <tr>
        <td height="28" colspan="4" align="center" bgcolor="#FFFFFF" class="titleblue"><%-- 全国在售项目销售对比（X月-X月）--%></td>
      </tr>
      <tr>
        <td colspan="2" rowspan="11" bgcolor="#FFFFFF"><div id="container" style="width: 100%; height:210px; margin: 0 auto"></div></td>
        <td width="3%" bgcolor="#FFFFFF"><%-- <input type="checkbox" name="checkbox2" id="checkbox2" />--%></td>
        <td width="5%" bgcolor="#FFFFFF" class="bluefont"><%-- 广东--%></td>
      </tr>
      <%--
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">中山</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">安徽</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">贵州</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">云南</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">江苏</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">河南</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">湖南</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">四川</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">广西</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><input type="checkbox" name="checkbox2" id="checkbox2" /></td>
        <td bgcolor="#FFFFFF" class="bluefont">湖北</td>
      </tr> --%>
    </table>
      <p>&nbsp;</p>
      <table width="98%" border="0" align="right" cellspacing="0" class="picbox" >
      <tr>
        <td height="28" align="center" bgcolor="#FFFFFF" class="titleblue">广东合盈在售项目</td>
      </tr>
      <tr>
        <td bgcolor="#FFFFFF"><img src="images/pic1.jpg" width="100%" height="168" alt="销售对比图" /></td>
        </tr>
      </table></td>
    </tr>
  <tr>
    <td valign="top"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
      <tr class="gboxbg">
        <td valign="top"><strong>　其它更新公告</strong></td>
        </tr>
      <tr>
        <td bgcolor="#FFFFFF"><table width="98%" border="0">
          <tr>
            <td height="22">  &nbsp;&nbsp;2011-11-05更新：新增线形报表功能；</td>
            </tr>
          <tr>
            <td height="22">　2011-10-30更新：权限细化；</td>
            </tr>
          <tr>
            <td height="22">　2011-10-25更新：录入规则；</td>
            </tr>
          <tr>
            <td height="22">　2011-10-05更新：新增权限控制；</td>
            </tr>
          <tr>
            <td height="22">　2011-10-01更新：新增汇总功能；</td>
            </tr>
  </table>
  </td>
        
        </tr>
</table></td>
    </tr>
</table></td>
        <td width="3" background="../images/rightbg.gif"></td>
      </tr>
      <tr>
        <td class="leftbg03"></td>
        <td class="midbg02"></td>
        <td class="rightbg03"></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" align="right" cellspacing="0">
      <tr>
        <td width="3" height="3" class="leftbg01"></td>
        <td class="midbg01"></td>
        <td width="2" height="3" background="../images/righttop.gif"></td>
      </tr>
      
      <tr>
        <td class="leftbg03"></td>
        <td class="midbg02"></td>
        <td class="rightbg03"></td>
      </tr>
    </table></td>
  </tr>
  <!--main.end-->
  
  <tr>
    <td height="5" colspan="3">
    </td>
  </tr>
 
</table>

</body>
</html>
