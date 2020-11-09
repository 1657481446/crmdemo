<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 2020/7/12
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>SpringBoot注册</title>
    <link rel="stylesheet" type="text/css" href="../../css/login.css">
    <link rel="stylesheet" type="text/css" href="../../css/setting/register.css">
    <link rel="stylesheet" href="//at.alicdn.com/t/font_1929903_e24aoh49z0e.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="../../js/md5.js"></script>
</head>
<body>
    <div class="registerHead">
        <span style="font-family: 楷体;font-size: 22px;margin-left: 10%">让爱情变得简单</span>
        <span class="iconfont icon-aixin" style="color: red"></span>
        <span class="iconfont icon-aixin" style="color: red"></span>
    </div>
    <div class="maxDiv">
        <div class="textLineDiv">
            <span class="textLineSpan">注册用户</span>
            <span id = "spanUser",class="textLineNumber"></span>
            <span class="textLineSpanSun">个</span>
            <span class="spanBoundary">|</span>
            <span>安全运行</span>
            <span id = "spanSafety" class="textLineNumber"></span>
            <span class="textLineSpanSun">天</span>
            <span class="spanBoundary">|</span>
            <span>浏览网站</span>
            <span id="spanBrowse" class="textLineNumber"></span>
            <span class="textLineSpanSun">次</span>
        </div>
        <div class="registerDiv">
            <div class="topRegisterDiv"></div>
            <div class="content">
                <div class="error_tip">
                    <span id="error_username" style="display: none ;color: red;size: 10px">请输入用户名</span>
                </div>
                <div class="nameDiv">
                    <input type="text" name="userName" id="userName" class="nameInput" placeholder="请输入用户名"/>
                </div>
                <div class="error_tip">
                    <span id="error_password" style="display: none ;color: red;size: 10px">请输入密码</span>
                </div>
                <div class="nameDiv">
                    <input type="password" name="passWord" id="passWord" class="nameInput" placeholder="请输入密码"/>
                </div>
                <div class="nameDiv">
                    <input type="text" name="email" id="email" class="nameInput" placeholder="请输入邮箱"/>
                </div>
                <div class="nameDiv">
                    <button id="registerButton" class="regBtn" style="">注册</button>
                </div>
            </div>
        </div>
    </div>
</body>

<script type="text/javascript">
    function checkEmail() {
        var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$"); //正则表达式
        var obj = document.getElementById("email"); //要验证的对象
        var errorInfor = document.getElementById("errorInfor"); //错误信息
        if(obj.value === ""){ //输入不能为空
            alert("输入不能为空!");
            return false;
        }else if(!reg.test(obj.value)){ //正则验证不通过，格式不对
            document.getElementById("errorInfor").style.display='block'
        }
    }
    /*
    * 网站流量统计
    * */
    $(document).ready(function () {
        $.ajax({
            type :'post',
            url :'../../sysController/loginLog',
            contentType :'application/x-www-form-urlencoded',
            data : "",
            success :function (result) {
                var code = result.code;
                if("110" != code){
                    document.getElementById("spanUser").innerText = '2';
                    document.getElementById("spanSafety").innerText = '520';
                    document.getElementById("spanBrowse").innerText = '1314';
                }else{
                    document.getElementById("spanUser").innerText = result.data[0].userNum;
                    document.getElementById("spanSafety").innerText = result.data[0].safetyDayNum;
                    document.getElementById("spanBrowse").innerText = result.data[0].viewCount;
                }
            },
            error : function (e) {
                console.error(e);
                document.getElementById("spanUser").innerText = '2'
                document.getElementById("spanSafety").innerText = '520'
                document.getElementById("spanBrowse").innerText = '1314'
            }
        })
    });
    /*
    * 用户名密码错误提示
    * */
    var userName = document.getElementById("userName");
    var passWord = document.getElementById("passWord");
    var email = document.getElementById("email");
    var error_username = document.getElementById("error_username");
    var error_password = document.getElementById("error_password");
    userName.onmouseout = function () {
        if(userName.valueOf().value == ""){
            error_username.style.display = "block";
        }
    }
    passWord.onmouseout = function () {
        if(passWord.valueOf().value == ""){
            error_password.style.display = "block";
        }
    }
    userName.onmouseover = function () {
        error_username.style.display = "none";
    }
    passWord.onmouseover = function () {
        error_password.style.display = "none";
    }
    /*
    * 注册
    * */

    $('#registerButton').click(function () {
        alert($.md5("111"));
        if(userName.valueOf().value == ""){
            alert("请输入用户名");
            return false;
        }else if(passWord.valueOf().value == ""){
            alert("请输入密码");
            return false;
        }
        var values = {
            "userName" : userName.valueOf().value,
            "passWord" : $.md5(passWord.valueOf().value),
            "email" : email.valueOf().value
        }
        $.ajax({
            type: 'post',
            url: '../../userController/register',
            contentType: 'application/x-www-form-urlencoded',
            data: values,
            success: function (result) {
                var code = result.code;
                if("110" != code){
                   /* console.error("注册失败"+"============="+result.desc);*/
                    alert(result.desc);
                }else{
                    /*console.info("注册成功!");*/
                    alert("注册成功，为您跳转登陆页面");
                    open();
                    function open() {
                        window.open("../../login.jsp",'_self');
                    }
                }
            },
            error: function (e) {
                alert("注册失败，请联系管理员解决");
                console.error(e.status);
            }
        })
    })
</script>
</html>
