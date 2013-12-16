<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@ page import="com.ihk.user.data.pojo.FuncTree"%>

<script type="text/javascript" language="javascript">
	$().ready(function() {
		$(".img").click(function() {
			$(".leftnav").toggle();

			$.ajax( {
				type : "get",
				url : "./sale_hengda!leftDisplay.action", //查询一些相关的数据
				dataType : "html"
			});

		});
	});
	
	
$(document).ready(function(){	
	// 树型结构
	$("#browser").treeview();
});
</script>


<%-- body main --%>
<!--body main1-->
<div>
	<table  border="0" align="left" cellspacing="0" >
		<tr>

			<td valign="top" align="center">
				<div class="leftnav" <s:if test="#session.leftDisplay == 0"> 
					style="display:none"
			  	</s:if> <s:if test="#session.leftDisplay == 1"> 
					style="display:block"
			  	</s:if>>

					<div class="lefttop"></div>
					<div class="leftbg">
					<%//if(PermissionUtils.getUserFuncTreeList() != null){
							//for(FuncTree t : PermissionUtils.getUserFuncTreeList()){%>
						<%--<div>
						  <div class="leftl"></div>
							<div class="leftm"><a href="<%=t.getActionUrl() %>" target="_self"><%//=t.getTreeName()%> </a></div>
							<div class="leftr"></div>
							<div class="c"></div>	
							</div>
							
						--%><%//}}%>
						<%-- 
						<div class="leftlist">
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./sale_hengda/input/for_sale.action" target="_self">新建在售数据</a>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>
						</div>

						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/search/sale.action?from=left" target="_self">查询在售数据</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>

						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/search/week.action?from=left" target="_self">在售数据周查询</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>

						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/search/month.action?from=left" target="_self">在售数据月查询</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>

						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/search/all.action?from=left" target="_self">在售数据汇总</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>

						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/search/time.action?from=left" target="_self">在售数据分段汇总</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>



						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/chart/project.action" target="_self">项目曲线</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/chart/company.action" target="_self">公司曲线</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda/chart/country.action" target="_self">全国曲线</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>

						</div>
					--%>

						

					</div>
					<div class="leftbottom" style="width: 100%">
					</div>
				</div>
				
				<!--
			<ul id="browser" class="filetree">

		<li><span class="folder">录入</span>

			<ul>

				<li><span class="file"><a href="">录入销售数据</a></span></li>

			</ul>

		</li>

		<li><span class="folder">查询</span>

			<ul>
<%--
				<li><span class="folder"></span>

					<ul id="folder21">

						<li><span class="file">File 2.1.1</span></li>

						<li><span class="file">File 2.1.2</span></li>

					</ul>

				</li>
				--%>

				<li><span class="file">查询销售数据</span></li>
				<li><span class="file">按周查询</span></li>
				<li><span class="file">按月查询</span></li>
			</ul>

		</li>
		
		<li><span class="folder">汇总</span>
			<ul>
				<li><span class="file">销售汇总</span></li>
				<li><span class="file">按日汇总（分段）</span></li>
			</ul>
		</li>
		
		<li><span class="folder">曲线</span>
			<ul>
				<li><span class="file">项目曲线</span></li>
				<li><span class="file">公司曲线</span></li>
				<li><span class="file">全国曲线</span></li>
			</ul>
		</li>


	</ul>
				-->
			</td>

			<td valign="middle" width="0px" style="height: 200px;" align="left" >
				<div style="height: 150px">
					<img src="images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩" />
				</div>
			</td>
		</tr>
	</table>


</div>

