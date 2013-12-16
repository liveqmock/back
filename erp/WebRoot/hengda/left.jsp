<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@ page import="com.ihk.user.data.pojo.FuncTree"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>left</title>
		<meta http-equiv=Content-Type content="text/html; charset=utf-8" /> 
		<link href="../css/hengda.css" rel="stylesheet" type="text/css"
				charset="utf-8" />
		<script type="text/javascript" language="javascript">
			$().ready(function(){
				$(".img").click(function(){
					$(".leftnav").toggle();
					
					$.ajax({
						type:"get",
						url: "./sale_hengda!leftDisplay.action",  //查询一些相关的数据
						dataType: "html"
					});
					
				});
			});
		

		</script>

	</head>

	<body>

		
			<td width="10" valign="top">
				<div class="leftnav" 
				<s:if test="#session.leftDisplay == 0"> 
					style="display:none"
			  	</s:if>		
				<s:if test="#session.leftDisplay == 1"> 
					style="display:block"
			  	</s:if>			
				>
					<div class="lefttop"></div>
					
					<div class="leftbg">
					
						<div class="leftlist">
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./sale_hengda!doSomeForAddSale.action?from=hengda" target="_self">新建在售数据</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>

						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda!searchSale.action?from=left" target="_self">查询在售数据</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>
						</div>
						
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda!searchSaleFromType.action?type=week" target="_self">在售数据周查询</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>	
						</div>
						
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda!searchSaleFromType.action?type=month" target="_self">在售数据月查询</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>	
						</div>
						
						
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./sale_hengda!searchSaleAll.action?from=left" target="_self">在售数据汇总</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>	
						</div>
						
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./user_hengda!updateUserAccountJsp_user.action" target="_self">修改密码</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>	
						</div>
						
						<div class="leftlist">	
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./sale_hengda/chart/all_project.action" target="_self">各个项目报表</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>
						</div>
						
						<div class="leftlist">	
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./sale_hengda/chart/one_project.action" target="_self">单个项目报表</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
						
						
				</div>


				<div class="leftbottom"></div>
			</div>
		</td>

			<td width="9" valign="middle">
					<img src="images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩"/>
			</td>

	</body>
</html>
