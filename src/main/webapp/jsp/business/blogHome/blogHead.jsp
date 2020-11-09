<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020/7/14
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>spring boot</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/business/blogHome/blogHead.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_1929903_wn15dg1ktc.css">
    <script type="text/javascript" src="../../../js/jquery.min.js"></script>
    <script src="../../../js/ajaxComplete.js"></script>
</head>
<body class="headBody">
    <div class="maxDiv">
        <a href="${pageContext.request.contextPath}/jsp/business/blogHome/blogHome.jsp" class="blogHomeDiv">Spring Boot</a>
        <a href="${pageContext.request.contextPath}/jsp/business/blogHome/blogHome.jsp" class="titleStyle">博客</a>
        <a href="${pageContext.request.contextPath}/jsp/business/articleShow/articleHome.jsp" class="titleStyle">文章</a>
        <a href="${pageContext.request.contextPath}/jsp/business/articleShow/articleHome.jsp" class="titleStyle">留言</a>
        <div style="float: left;margin-left: 6%">
            <input type="text" id="searchStr" name="searchStr" class="textBox" placeholder="SpringBoot">
            <button id = "search" class="search">搜索</button>
        </div>
        <span id="setting" class="iconfont icon-shezhi" style="font-size: 30px;margin-left: 36%;color: mediumpurple"></span>
        <img src="${headPortrait}" style="width: 30px;height: 30px;border-radius: 50px;float: right">
        <hr style="width: 100%;margin-top: 6px" color="lightpink"/>
    </div>
    <div id="settingMenu"class="setting">
        <div>
        <a href="${pageContext.request.contextPath}/jsp/business/blogHome/blogHome.jsp" class="menu" style="text-decoration: none">业务菜单</a><br/>
        </div>
        <a href="${pageContext.request.contextPath}/jsp/setting/settingHome.jsp" class="menu" style="text-decoration: none">配置菜单</a>
        <a href="javascript:;" onclick="loginOut()" class="menu" style="text-decoration: none">退出系统</a>
    </div>
</body>
<script type="text/javascript">
    var search = document.getElementById("search");
    var settingMenu = document.getElementById("settingMenu");
    var setting = document.getElementById("setting");
    var menu = document.getElementsByClassName("menu");
    settingMenu.style.display="none";
    setting.onmouseover = function () {
        settingMenu.style.display="block";
    }
    setting.onmouseout = function () {
        settingMenu.style.display="none";
    }
    menu[0].onmouseover = function () {
        menu[0].style.backgroundColor = 'lightsalmon';
    }
    menu[0].onmouseout = function () {
        menu[0].style.backgroundColor = 'white';
    }
    menu[1].onmouseover = function () {
        menu[1].style.backgroundColor = 'lightsalmon';
    }
    menu[1].onmouseout = function () {
        menu[1].style.backgroundColor = 'white';
    }
    menu[2].onmouseover = function () {
        menu[2].style.backgroundColor = 'lightsalmon';
    }
    menu[2].onmouseout = function () {
        menu[2].style.backgroundColor = 'white';
    }
    settingMenu.onmouseover = function () {
        settingMenu.style.display="block";
    }
    settingMenu.onmouseout = function () {
        settingMenu.style.display="none";
    }
    search.onmouseover = function () {
        search.style.cursor="pointer";
        search.style.cursor="hand";
    }
    search.onmouseout = function () {
        search.style.cursor="default";
    }
    function loginOut() {
        var values = {
            "userName":"${userName}"
        };
        $.ajax({
            type :'post',
            url :'../../../userController/loginOut',
            contentType :'application/x-www-form-urlencoded',
            data :values,
            success :function (result) {
                var code = result.code;
                if("110" != code){
                    console.error("退出失败"+"============="+result.desc);
                    alert("当前系统繁忙，退出失败!");
                }else{
                    console.info("退出成功!");
                    open();
                    function open() {
                        window.open("${pageContext.request.contextPath}/login.jsp",'_self');
                    }
                }
            },
            error : function (e) {
                //alert("当前系统繁忙，退出失败!");
                console.error(e.status);
            }
        });
        /*session 为空 跳转登陆页面*/
        ajaxComplete();
    }
</script>
</html>
