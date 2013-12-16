<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
         isELIgnored="false"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
    <s:include value="../../header/header_easyui.jsp"></s:include>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/easyui.utils.js"></script>
    <script type="text/javascript" language="javascript" src="<%=basePath%>js/saleunit_new_common_min.js"></script>
    <title>新建项目</title>

    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
        #fm{
            margin:0;
            padding:10px 30px;
        }
        .ftitle{
            font-size:14px;
            font-weight:bold;
            color:#666;
            padding:5px 0;
            margin-bottom:10px;
            border-bottom:1px solid #ccc;
        }
        .fitem{
            margin-bottom:15px;
        }
        .fitem label{
            display:inline-block;
            width:100px;
        }
    </style>
    <script type="text/javascript">
        $().ready(function(){

            closeIframeDialog("new_dialog", "${closeMark}", "", "${suggestion}");

            $("#provinceId").change(function(){
                thisProviToCity("provinceId", "cityId");
            });
        });
        function formsubmit (){
            document.getElementById("input_project_form").submit();
        }

        function thisProviToCity(proviId, cityId){
            var emp = "<option value=\"\">请选择</option>";
            var provi = $("#" + proviId).val();

            if(provi == ""){
                $("#" + cityId).empty();
                $("#" + cityId).append(emp);

            }else{
                $.ajax({
                    type:"get",
                    url: "./customer_guangzhou/search/proviToCity.action",
                    data: "provinceId=" + provi,
                    dataType: "html",
                    success: function(data){
                        $("#" + cityId).empty();
                        $("#" + cityId).append(data);
                    }
                });
            }
        }

    </script>
</head>
<body>
<div style="width:90%;height:auto;padding:10px 20px">
    <form method="post" id="input_project_form" action="./projecr/manager/inputProjectForm.action">
        <div class="ftitle">项目信息</div>

        <div class="fitem">
            <label>项目名称: </label>
            <input size="10" type="text" name="inputProject.projectName"
                   value="${inputProject.projectName}"  style="width: 200px;" maxlength="20"/>
        </div>

        <div class="fitem">
            <label>公司:</label>
            <s:select list="comList" name="inputProject.companyId" listKey="id" listValue="companyName">
            </s:select>
        </div>

        <div class="fitem">
            <label>默认省市:</label>
            <s:select list="selProvince"  name="inputProject.provinceId" id="provinceId" cssStyle="width:auto"/>省
            <s:select list="selCity"  name="inputProject.cityId" id="cityId" cssStyle="width:auto"/>市
        </div>

    </form>
</div>
</body>
</html>

