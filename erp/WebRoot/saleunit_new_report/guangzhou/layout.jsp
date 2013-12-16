<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>


<%@ page import="com.ihk.utils.CacheUtils"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>

    <title>报表管理</title>

    <base href="<%=basePath%>">

    <s:include value="../../customer/guangzhou/header.jsp" />
    <link href="./css/easyui.css" rel="stylesheet" type="text/css"
          charset="utf-8" />
    <link href="./css/icon.css" rel="stylesheet" type="text/css"
          charset="utf-8" />
    <script type="text/javascript" language="javascript"
            src="./js/easyui.tab.utils.js"></script>

    <script type="text/javascript" language="javascript"
            src="<%=basePath%>js/jquery.easyui.min.js"></script>
    <script type="text/javascript" language="javascript">

        $().ready(function(){

            $("#back").click(function(){

                location.href = "./customer_guangzhou/index/login.action";
                return false;
            });

            $("#left_tree").tree({

                onClick:function(node){

                    treeNodeClickForFinancialManager("left_financial_tree", node, "false", "left_main");

                }
            });

            showRightTable('customerNum','客户数量环比图');
        });


        //显示右边的报表
        function showRightTable(actionName,titleName){
            var utabs = $("#_center");//指定显示单元信息的控件ID

            $('#_centerFrame').attr('src',"./saleunit_new_report/report/guangzhou/"+actionName+".action?ts=<%=CacheUtils.getUrlTimeStamp()%>");
            //utabs.load("./saleunit_new_report/report/guangzhou/"+actionName+".action?ts=<%=CacheUtils.getUrlTimeStamp()%>");
            $("#showTitle").text(titleName);
            return false;
        }

    </script>


    <!-- ie6 水印问题 -->
    <script type="text/javascript" src="<%=basePath%>js/DD_belatedPNG_0.0.8a-min.js"></script>
    <script type="text/javascript">
        $().ready(function(){
            DD_belatedPNG.fix('.logo');
        });
    </script>

    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
    </style>

</head>

<body class="easyui-layout">

<!-- 上部的内容 -->
<div region="north" border="false"
     style="height:50px;background:#B3DFDA;padding:0px; overflow:hidden">
    <s:include value="../../customer/guangzhou/top.jsp" />
</div>

<!-- 左边的功能树 -->
<div region="west" split="true"
     title="<a href='./customer_guangzhou/index/login.action' style='color:#5482DE'>返回主页</a>"
     style="width:213px;padding:1px;">

    <div class="easyui-accordion" fit="true" border="false">
        <div title="交易管理" style="padding:5px;overflow:auto;">
            <s:include value="../../saleunit_new/guangzhou/left_unit.jsp" />
        </div>
        <div title="报表" selected="true" style="padding:0px;">
            <ul id="tt1" class="easyui-tree" animate="true" dnd="true">
                <li><span>售前客户报表</span>
                    <ul>
                        <li><span><a href="#"
                                     onclick="return showRightTable('customerNum','客户数量环比图');">客户数量环比图</a>
							</span></li>
                        <li><span><a href="#"
                                     onclick="return showRightTable('customerTable','客户分类明细表');">客户分类明细表</a>
							</span></li>
                        <li><span><a href="#"
                                     onclick="return showRightTable('customerPie','客户分类比例图');">客户分类比例图</a>
							</span></li>
                        <li><span><a href="#"
                                     onclick="return showRightTable('categoryNum','分类环比走势图');">分类环比走势图</a>
							</span></li>
                        <li><span><a href="#"
                                     onclick="return showRightTable('customerDoublePie','分类交叉分析');">分类交叉分析</a>
							</span></li>
                        <!-- 可以作废，用分类交叉分析来统计
                                                <li>
                                                      <span>
                                                        <a href="#" onclick="return showRightTable('sqkhtjReport','售前客户来源统计');">售前客户来源统计</a>
                                                      </span>
                                                </li> -->
                        <li>
							  <span>
							    <a href="#" onclick="return showRightTable('sqkhflReport','售前客户分类统计');">售前客户分类统计</a>
							  </span>
                        </li>
                        <li><span>跟进情况统计</span>
                            <ul>
                                <li><span><a href="#"
                                             onclick="return showRightTable('xmgjqkReport','项目跟进情况');">项目跟进情况</a>
									</span></li>
                                <li><span><a href="#"
                                             onclick="return showRightTable('xsgjqkReport','销售跟进情况');">销售跟进情况</a> </span></li>
                            </ul>
                        </li>
                        <li><span>管理报表</span>
                            <ul>
                                <li><span><a href="#"
                                             onclick="return showRightTable('projectAndCustNum','项目客户数量对比');">项目客户数量对比</a>
									</span></li>
                                <li><span><a href="#"
                                             onclick="return showRightTable('redAnalysis','客户质量分析');">客户质量分析</a> </span></li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><span>销控报表</span>
                    <ul>
                        <li><span>销售货量分析</span>
                            <ul>
                                <li><span>
									<a href="#" id="zthlfxReport"
                                       onclick="return showRightTable('zthlfxReport','总体货量分析');">总体货量分析</a>
									</span>
                                </li>
                                <li><span><a href="#" id="xshlfxLcReport"
                                             onclick="return showRightTable('xshlfxLcReport','销售货量分析(按楼层)');">销售货量分析(按楼层)</a> </span></li>

                                <li><span><a href="#" id="xshlfxJgReport"
                                             onclick="return showRightTable('xshlfxJgReport','销售货量分析(按价格)');">销售货量分析(按价格)</a> </span></li>

                                <li><span><a href="#" id="xshlfxFlReport"
                                             onclick="return showRightTable('xshlfxFlReport','销售货量分析(按分类)')">销售货量分析(按分类)</a> </span></li>
                            </ul>
                        </li>
                        <li>
							  <span>
							    <a href="#" onclick="return showRightTable('rcfxReport','认筹分析');">认筹分析</a>
							  </span>
                        </li>
                        <li><span>售后问卷</span>
                            <ul>
                                <li>
								  <span>
								    <a href="#" onclick="return showRightTable('shwjReport','售后问卷分析');">售后问卷分析</a>
								  </span>
                                </li>
                                <li>
								  <span>
								    <a href="#" onclick="return showRightTable('cjsjjcReport','成交数据交叉分析');">成交数据交叉分析</a>
								  </span>
                                </li>
                                <li>
								  <span>
								    <a href="#" onclick="return showRightTable('cjkhflReport','成交客户分类统计');">成交客户分类统计</a>
								  </span>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
                <li><span>财务报表</span>
                    <ul>
                        <!-- <li>对数情况</li> -->
                        <li><span><a href="#" id="xmjyqkReport"
                                     onclick="return showRightTable('xmjyqkReport','项目结佣情况一览表');">项目结佣情况一览表</a> </span></li>
                        <li><span><a href="#" id="ndxsjhReport"
                                     onclick="return showRightTable('ndxsjhReport','年度销售计划及落实情况');">年度销售计划及落实情况</a> </span></li>

                        <li><span>销售数据统计</span>
                            <ul>
                                <li><span><a href="#" id="qdqyhkjReport"
                                             onclick="return showRightTable('qdqyhkjReport','齐定签约回款情况');">齐定签约回款情况</a> </span></li>
                                <li><span><a href="#" id="cjqyhkReport"
                                             onclick="return showRightTable('cjqyhkReport','成交签约回款情况');">成交签约回款情况</a> </span></li>
                                <li><span><a href="#" id="ljcjtjbReport"
                                             onclick="return showRightTable('ljcjtjbReport','累计成交统计表');">累计成交统计表</a> </span></li>
                                <li><span><a href="#" id="ljqyhktjReport"
                                             onclick="return showRightTable('ljqyhktjReport','累计签约回款统计');">累计签约回款统计</a> </span></li>
                            </ul>
                        </li>
                        <li>
							  <span>
							    <a href="#" onclick="return showRightTable('xsryjxReport','销售人员绩效');">销售人员绩效</a>
							  </span>
                        </li>








                    </ul>
                </li>
            </ul>
        </div>
    </div>



</div>

<!-- 中间主体内容结构 -->
<div region="center" title="<div id='showTitle'>报表</div>"
     style="padding:0px;background:white;" id="_center">
    <iframe id="_centerFrame" frameborder="0" scrolling="auto" style="width:100%;height:100%"></iframe>

</div>

<!-- 底部,不用放其他代码，预留占位-->
<div region="south" border="false"
     style="background:#A9FACD;padding:0px;">
    <div style="width: 100%;height: 15px;background: #eeeeee"></div>
</div>

<!-- 统一dialog,myDialog表示没有iframe,myIframeDialog表示使用iframe,且iframe的名称统一为openIframe,(如果弹出的iframe中又包含弹出框,就不用变) -->
<div id="myDialog" class="easyui-dialog" closed="true" modal="true"
     title="标题"
     style="display:block;width:800px;height:500px; overflow-x:hidden">
</div>

<div id="myIframeDialog" class="easyui-dialog" closed="true"
     modal="true" title="标题"
     style="display:block;width:800px;height:500px; overflow-x:hidden">
    <iframe scrolling="auto" id='openIframe' frameborder="0"
            src="./saleunit_new/guangzhou/loading.jsp"
            style="width:100%;height:100%;"></iframe>
</div>
</body>



</html>

