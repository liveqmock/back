<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>年度销售计划及落实情况</title>
    <s:include value="header_report.jsp"></s:include>
    <script type="text/javascript">
        $().ready(function() {
            bindProjectDialogForXKZX("projectName", "hiddenId"); //多个项目的选择
            parent.hideLoading("年度销售计划及落实情况");
        });

        function submitSearch() {
            $("#thisForm").submit();
        }
    </script>
</head>
<body  style="padding:0px;background:white;">

<div class="right99"></div>
<form class="registerform" id="thisForm"  method="post">
<table width="100%" border="0" align="left" cellspacing="0">

<tr>
    <td colspan="6"><label>&nbsp;<span>项目</span> </label> <input
            type="text" id="projectName" name="propertyUnitCond.strSearchProjectNames" value="${propertyUnitCond.strSearchProjectNames}" /> <input type="hidden" id="hiddenId"
                                                                                                                                                   name="propertyUnitCond.strSearchProjectIds" value="${propertyUnitCond.strSearchProjectIds}" />
        年度<input  type="text" style="width:90px"
                  name="propertyProjectPlanCond.planMonth" value="2012" /> &nbsp;<input
                type="button"  onclick="return submitSearch()"  value=" 查询  " />
        <div class="right99"></div>
        <div class="blueline"></div></td>
</tr>

<!-- 搜索表单 end -->


<tr>
<td colspan="6">

<div class="gbox1">





<table width="100%" border="0" align="center" cellpadding="0"
       cellspacing="1" class="gbox" style="text-align: center;">
<tr class="gboxbg">
    <th colspan="2">2012年1-12月</th>
    <th>一月</th>
    <th>二月</th>
    <th>三月</th>
    <th>四月</th>
    <th>五月</th>
    <th>六月</th>
    <th>七月</th>
    <th>八月</th>
    <th>九月</th>
    <th>十月</th>
    <th>十一月</th>
    <th>十二月</th>
    <th>合计</th>
    <th>平均值</th>
    <th>剩余</th>
</tr>


<s:property value="showTrs"  escape="false"/>
<!--
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <td rowspan="18" width="25px"><strong>销售任务</strong></td>
    <th>任务套数(套)</th>
    <td>20</td>
    <td>60</td>
    <td>200</td>
    <td>80</td>
    <td>150</td>
    <td>60</td>
    <td>60</td>
    <td>50</td>
    <td>100</td>
    <td>10</td>
    <td>5</td>
    <td>0</td>
    <td>795</td>
    <td>66</td>
    <td></td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>任务面积(㎡)</th>
    <td height="19">1760</td>
    <td>4580</td>
    <td>15600</td>
    <td>7040</td>
    <td>13200</td>
    <td>5280</td>
    <td>5280</td>
    <td>4200</td>
    <td>8500</td>
    <td>760</td>
    <td>440</td>
    <td>0</td>
    <td>66640</td>
    <td>5553</td>
    <td></td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>任务金额(万元)</th>
    <td height="19">1,109</td>
    <td>2,885</td>
    <td>9,984</td>
    <td>4,506</td>
    <td>8,448</td>
    <td>3,379</td>
    <td>3,379</td>
    <td>2,688</td>
    <td>5,440</td>
    <td>486</td>
    <td>282</td>
    <td>0</td>
    <td>42,586</td>
    <td>3,549</td>
    <td></td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>任务均价(元/㎡)</th>
    <td height="19">6300</td>
    <td>6300</td>
    <td>6400</td>
    <td>6400</td>
    <td>6400</td>
    <td>6400</td>
    <td>6400</td>
    <td>6400</td>
    <td>6400</td>
    <td>6400</td>
    <td>6400</td>
    <td>#DIV/0!</td>
    <td>6390</td>
    <td>6390</td>
    <td></td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>齐定套数(套)</th>
    <td height="19">33</td>
    <td>70</td>
    <td>234</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>337</td>
    <td>112</td>
    <td>458</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>齐定面积(㎡)</th>
    <td height="19">2850.71</td>
    <td>6872.46</td>
    <td>21226.71</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>30949.88</td>
    <td>10317</td>
    <td>35690.12</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>齐定金额(元)</th>
    <td height="19">17,740,622</td>
    <td>43,690,577</td>
    <td>141,601,963</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>203,033,162</td>
    <td>67,677,721</td>
    <td>222,828,838</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>齐定均价(元/㎡)</th>
    <td height="19">6223</td>
    <td>6357</td>
    <td>6671</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>6560</td>
    <td>6560</td>
    <td>6243</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>达标率</th>
    <td height="19">160%</td>
    <td>151%</td>
    <td>142%</td>
    <td>0%</td>
    <td>0%</td>
    <td>0%</td>
    <td>0%</td>
    <td>0%</td>
    <td>0%</td>
    <td>0%</td>
    <td>0%</td>
    <td>#DIV/0!</td>
    <td>48%</td>
    <td>191%</td>
    <td>52%</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>累计达标率</th>
    <td height="19">160%</td>
    <td>154%</td>
    <td>145%</td>
    <td>110%</td>
    <td>75%</td>
    <td>67%</td>
    <td>60%</td>
    <td>56%</td>
    <td>49%</td>
    <td>48%</td>
    <td>48%</td>
    <td>48%</td>
    <td></td>
    <td></td>
    <td></td>
</tr>
 -->

<!-- 年度任务佣金，未确认如何计算 -->
<!--
<tr class="gboxbg">
    <th>年度任务佣金</th>
    <th>&nbsp;</th>
    <th>一月</th>
    <th>二月</th>
    <th>三月</th>
    <th>四月</th>
    <th>五月</th>
    <th>六月</th>
    <th>七月</th>
    <th>八月</th>
    <th>九月</th>
    <th>十月</th>
    <th>十一月</th>
    <th>十二月</th>
    <th>合计</th>
    <th>平均值</th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <td align="center">3,193,965</td>
    <th>签约套数</th>
    <td height="19">26</td>
    <td>73</td>
    <td>20</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>119</td>
    <td>40</td>
    <td></td>
    <td>套</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>项目任务佣金比例上限</th>
    <th>签约面积</th>
    <td height="19">2923.23</td>
    <td>7634.65</td>
    <td>2496.31</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>13054.19</td>
    <td>4351</td>
    <td></td>
    <td>㎡</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <td align="center">0.80%</td>
    <th>签约金额</th>
    <td height="19">19,713,140</td>
    <td>52,212,587</td>
    <td>18,924,121</td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>90,849,848</td>
    <td>30,283,283</td>
    <td></td>
    <td>元</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>项目任务佣金比例下限</th>
    <th>签约均价</th>
    <td>6744</td>
    <td>6839</td>
    <td>7581</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>#DIV/0!</td>
    <td>6959</td>
    <td>6959</td>
    <td></td>
    <td>元/㎡</td>
</tr>
<tr class="gboxbg">
    <td align="center">0.70%</td>
    <th>月份</th>
    <th>一月</th>
    <th>二月</th>
    <th>三月</th>
    <th>四月</th>
    <th>五月</th>
    <th>六月</th>
    <th>七月</th>
    <th>八月</th>
    <th>九月</th>
    <th>十月</th>
    <th>十一月</th>
    <th>十二月</th>
    <th>合计</th>
    <th>平均值</th>
    <th>&nbsp;</th>
    <th>&nbsp;</th>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <th>项目任务佣金比例均值</th>
    <th>任务佣金</th>
    <td>83,160</td>
    <td>216,405</td>
    <td>748,800</td>
    <td>337,920</td>
    <td>633,600</td>
    <td>253,440</td>
    <td>253,440</td>
    <td>201,600</td>
    <td>408,000</td>
    <td>36,480</td>
    <td>21,120</td>
    <td>0</td>
    <td>3,193,965</td>
    <td>266,164</td>
    <td></td>
    <td>元</td>
</tr>
<tr onMouseOver="this.style.backgroundColor='#f1f9fe'"
    onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF";>
    <td align="center">0.75%</td>
    <th>应收佣金</th>
    <td height="20">133,055</td>
    <td>327,679</td>
    <td>1,062,015</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>0</td>
    <td>1,522,749</td>
    <td>507,583</td>
    <td></td>
    <td>元</td>
</tr>


-->
</table>
</div>

</td>
</tr>
</table>
</form>
</body>
</html>



