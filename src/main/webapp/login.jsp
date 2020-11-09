<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020/7/3
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title class="iconfont icon-renwey-logo">登陆页面</title>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <%--icons--%>
    <link rel="stylesheet" href="//at.alicdn.com/t/font_1929903_y5g16q2q7k9.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script src="js/md5.js"></script>
</head>
<style>
    body{
        background-color: mediumpurple;
        background-size: 100%;
    }
     .icon {
         width: 1em;
         height: 1em;
         vertical-align: -0.15em;
         fill: currentColor;
         overflow: hidden;
     }
</style>
<body>
<br><br>
<h1 class="projectDiv">小富婆和小保安的甜美爱情</h1>
<div class="loginForm">
    <div class="loginLeftDiv">
        <img src="images/business/loginPage/sun.png" style="width: 300px;height: 300px;margin-top: 40px">
    </div>
    <div class="loginDiv">
        <h3 style="margin-left: 26%;margin-top: 23%;color: lightsalmon">登陆系统，发现狗粮</h3>
        <span id="errorInfor" style="display: none" class="errorInfor">
            用户名密码错误
        </span>
        <div class="loginDivOnlyCenter">
            <span class="add-on"><i class="iconfont icon-yonghuming1"style="color: mediumpurple"></i></span>
            <input id="userName" type="text" placeholder="用户名" style="border: 0px;outline: none"/>
            <hr style="width: 235px" color="lightpink"/>
        </div>
        <div class="loginDivOnlyCenter">
            <span class="add-on"><i class="iconfont icon-mima2"style="color: mediumpurple"></i></span>
            <input id="passWord" type="password" placeholder="密码" style="border: 0px;outline: none"/>
            <hr style="width: 235px" color="lightpink"/>
        </div>
        <div style="margin-left: 48px">
            <br/>
            <label class="checkbox"><input type="checkbox" checked/>一周内免登陆</label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button class="registerButton" id="register">注册</button>
            <button id="loginButton" class="loginButton">登录</button>
        </div>
        </form>
        <br><br>
    </div><!--/row-fluid-->
</div>
<div class="copyrightDiv">
    <span style="margin-left: 50%">版权所有© 小姜</span>
</div>
</body>
<script type="text/javascript">
    var userName = document.getElementById("userName").valueOf();
    var passWord = document.getElementById("passWord").valueOf();
    $('#loginButton').click(function () {
        document.getElementById("errorInfor").style.display='none';
        if (userName == "" || passWord == "") {
            alert("用户名或密码未填!");
            return false;
        }
        var values={
            "userName":userName.value,
            "passWord":$.md5(passWord.value)
        }
        var errorInfor = document.getElementById("errorInfor");
        $.ajax({
            type :'post',
            url :'userController/login',
            contentType :'application/x-www-form-urlencoded',
            data :values,
            success :function (result) {
                var code = result.code;
                if("110" != code){
                    console.error("登陆失败"+"============="+result.desc);
                    document.getElementById("errorInfor").style.display='block'
                }else{
                    console.info("登陆成功!");
                    document.getElementById("errorInfor").style.display='none';
                    open();
                    function open() {
                        window.open("jsp/business/blogHome/blogHome.jsp",'_self');
                    }
                }
            },
            error : function (e) {
                document.getElementById("errorInfor").style.display='block'
                console.error(e.status);
            }
        })
    });
    $("#register").click(function () {
        register();
        function register() {
            window.open("jsp/setting/register.jsp",'_self');
        }
    });
</script>
</html>
