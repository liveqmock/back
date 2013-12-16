<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.ihk.permission.PermissionUtils"%>
<%@ page import="com.ihk.user.data.pojo.FuncTree"%>
 
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

		
		




<%-- body main --%>	
<!--body main1-->

		
				
				<!--<s:if test="#session.leftDisplay == 0"> 
					style="display:none"
			  	</s:if>		
				<s:if test="#session.leftDisplay == 1"> 
					style="display:block"
			  	</s:if>		-->	
				<div class="leftnav" >
					<div class="lefttop"></div>
        			<div class="leftbg"> <div>
			<%-- 
						<%if(PermissionUtils.getUserFuncTreeList() != null){
							for(FuncTree t : PermissionUtils.getUserFuncTreeList()){%>
						<div>
						  <div class="leftl"></div>
							<div class="leftm"><a href="<%=t.getActionUrl() %>" target="_self"><%//=t.getTreeName()%> </a></div>
							<div class="leftr"></div>
							<div class="c"></div>	
							</div>
							
						<%}}%>
					--%>	
						
						
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./userrole!queryRoles.action" target="_self">查询角色</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
						
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./userrole!doSomeForAddRole.action" target="_self">新建角色</a>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>	
						</div>
											
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./userrole!queryUserRoles.action" target="_self">查询用户角色</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>	
						
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./userrole!doSomeForAddUserRole.action" target="_self">新建用户角色</a>
							</div>
							<div class="leftr">
							</div>
							<div class="c"></div>	
						</div>
						
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./userrole!queryUserPrivs.action" target="_self">查询用户权限</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
						
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./user_role_priv!rolePrivRef_index.action" target="_self">查询角色参照</a>
	                         </div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
						
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./user_role_priv!rolePriv_index.action" target="_self">查询角色</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
					
						<div>
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./function_tree!tree_list.action" target="_self">查询功能列表</a>
							</div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
					
						<div>
							<div class="leftl"></div>
							<div class="leftm"><a href="./priv_func!privfunc_list.action" target="_self">查询功能权限表</a></div>
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
						
						<div class="leftl"></div>
							<div class="leftm">
								<a href="./cache!toCachePage.action" target="_self">系统设置</a>
							</div>
							
							<div class="leftr"></div>
							<div class="c"></div>	
						</div>
						
					
						<div class="leftbottom"></div>
				</div>
				
				
													
							
						
					<!-- 
						<div class="leftlist">
							<div class="leftl"></div>
							<div class="leftm">
								<a href="./sale_hengda!doSomeForAddSale.action?from=hengda" target="_self">新建在售数据</a>
							</div>
							<div class="leftr">
							</div>
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
								<a href="./presale_hengda!indexPresale.action" target="_self">查询认筹数据</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>							
							
						</div>
						
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./presale_hengda!addPresale_jsp.action" target="_self">新建认筹数据</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>							
							
						</div>
						
						<div class="leftlist">
							<div class="leftls"></div>
							<div class="leftm">
								<a href="./presale_hengda!indexPresaleAll_jsp.action" target="_self">认筹汇总</a>
							</div>
							<div class="leftrs"></div>
							<div class="c"></div>							
							
						</div>
						
						
							<div class="leftlist">
								<div class="leftl"></div>
								<div class="leftm">
									<a href="./user_hengda!indexUserAccount.action?tips=reset" target="_self">用户管理</a>
								</div>
								<div class="leftr"></div>
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
						 -->
					


					
		

			<!-- <td width="9" valign="middle">
					<img src="images/tianluan/arrow01.gif" width="9" height="90" border="0" id="img" class="img" title="点击收缩"/>
			</td> -->
	
