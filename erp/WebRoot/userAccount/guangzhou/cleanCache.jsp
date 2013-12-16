<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
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
    <s:include value="../../customer/guangzhou/header.jsp"></s:include>
    <s:include value="../../customer/guangzhou/header_left_js.jsp"></s:include>

    <title>缓存管理</title>
    <script language="javascript" type="text/javascript">

        function clear(){
            setTimeout("document.getElementById('suggestion').innerHTML = ''", 2000);
        }
    </script>
    <style type="text/css">
        tr{height: 26px;}
    </style>
</head>

<body onload="clear()">


<%--主体 --%>
<div class="ui_tools"></div>
<div class="ui_listview">

    <div class="right99"></div>
    <div class="c"></div>
    <div class="c"></div>

    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
        <form action="./customer_guangzhou/cache/cacheFlush.action" method="post">
            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                <td height="0">&nbsp;&nbsp;
                    缓存名称
                    <s:select list="caches" name="cacheName"/>
                    <input type="submit" value=" 清理缓存(缓存剩余个数:<s:property value='#request.cacheSize'/>)" id="searchSubmit" />
                </td>


            </tr>
        </form>

        <form action="./customer_guangzhou/cache/cleanRoleCache.action" method="get">

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                <td>
                    &nbsp;&nbsp;
                    权限缓存
                    <s:select list="roleCaches" name="cacheName"/>
                    <input type="submit" value=" 清除缓存 " />(<font color="#FF0000">手工操作表:priv,role_priv,role,user_role,请清空对应缓存</font>)
                </td>
            </tr>

        </form>

        <form action="./customer_guangzhou/cache/initDownloadCache.action" method="get">

            <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                <td>
                    &nbsp;&nbsp;
                    初始化缓存
                    <s:select list="downloadCaches" name="downloadCacheName"/>
                    <input type="submit" value=" 初始化 " />
                </td>
            </tr>

        </form>


        <!--
		<form action="quartzAction.action" method="get"> 
            <tr>
			
              <td height="0" colspan="6">
			  	<input class="Wdate" type="text" id="firstMonitorDay" name="firstMonitorDay" style="width: 90px" onClick="WdatePicker()" />
				-
				<input class="Wdate" type="text" id="endMonitorDay" name="endMonitorDay" style="width: 90px" onClick="WdatePicker()" />
				<input type="submit" id="quartzSub" value=" 手工执行定时器 "/>
				(开始的日期不能小于<font color="#FF0000">2011-08-01</font>,结束日期不能大于<font color="#FF0000"><s:property value="#session.quartzDate"/></font>)
			  </td> 
		  
             
		 </tr>
	 	</form>
		-->

        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td height="30px"><font color="#FF0000"><span id="suggestion"><s:property value="#request.message"/></span></font></td>
        </tr>

		<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td>
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >
				
					 <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#eaeef4">
                        <td colspan="7">
							在线用户,<font color="#FF0000">总数:(${applicationUserCount})</font>
							<input type="button" value="刷新" onclick="location.href='./customer_guangzhou/cache/cacheIndex.action'" />
						</td>
                    </tr>

                    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#eaeef4">
                        <td style="width:20%">
                            sessionId
                        </td>
                        <td style="width:5%">
                            用户id
                        </td>
						<td style="width:13%">
                            用户登陆名称
                        </td>
                        <td style="width:12%">
                            用户名称
                        </td>
						
						 <td style="width:13%">
                            创建时间
                        </td>
						 <td style="width:40%; padding:0 0 0 20px">
                            用户所属公司项目
                        </td>
						 
					</tr>
					
					 <s:iterator value="#application.userAccount_binding_listener" id="c">

						<tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
							<td>
								${c.key.sessionId}
							</td>
							<td>
								${c.value.id}
							</td>
							<td>
								${c.value.userName}
							</td>
							<td>
								${c.value.realName}
							</td>
							
							<td>
								${c.key.creationTimeStr}
							</td>
							<td style="padding:0 0 0 20px">
								${c.value.descCompanyId},${c.value.descProjectId}
							</td>
							
						</tr>

					</s:iterator>

                </table>
            </td>
        </tr>
		
		
        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
            <td>
                <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" >

                    <form action="./customer_guangzhou/cache/showCaches.action" method="get">
                        <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                            <td style="width:10%">
                                cacheName:
                            </td>
                            <td style="width:20%">
                                <s:select list="caches" name="showCacheName" value="showCacheName"/>
                            </td>
                            <td>
                                <input type="submit" value="查找" />
                            </td>
                        </tr>
                    </form>

                    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#eaeef4">
                        <td>
                            cacheName:
                        </td>
                        <td>
                            key
                        </td>
                        <td>
                            value
                        </td>
                    </tr>

                    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#eaeef4">
                        <td colspan="3">
                            <table width="100%" border="0" align="center" cellpadding="0" cellspacing="1" class="gbox" id="listPage">

                                <s:iterator value="#request.showCaches" id="c">

                                    <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">
                                        <td>
                                                ${showCacheName}
                                        </td>
                                        <td>
                                                ${c[1]}
                                        </td>
                                        <td>
                                                ${c[2]}
                                        </td>
                                    </tr>

                                </s:iterator>

                                <tr onMouseOver="this.style.backgroundColor='#f1f9fe'" onMouseOut="this.style.backgroundColor=''" bgcolor="#FFFFFF">

                                    <td colspan="3" style="text-align:center">                                        
                                        <a href="#" onclick="return listPage(1,'./customer_guangzhou/cache/ajaxShowCaches.action', 'listPage')"><<</a>&nbsp;1/${pageCount}&nbsp;<a href="#" onclick="return listPage(2,'./customer_guangzhou/cache/ajaxShowCaches.action', 'listPage')">>></a>

                                    </td>
                                </tr>

                            </table>
                        </td>
                    </tr>


                </table>
            </td>
        </tr>
		
		

    </table>
</div>
</body>
</html>


