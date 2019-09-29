<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/5/28
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 注册 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户注册</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/security_1.js"></script>
    <style type="text/css">
        body {
            padding-top: 50px;
        }
    </style>
</head>
<body>
<!-- 导航条 -->

<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.html">高考小数据</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class=""><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;首页</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container" style="margin-top: 10%;">
    <div class="row" style="margin: 10px;">
        <div class="col-sm-2">
        </div>
        <div class="col-sm-10">
            <h1>用户注册<span style="color: red;">${ages}</span></h1>
        </div>
    </div>
    <form class="form-horizontal" action="${pageContext.request.contextPath}/registerSave.do" method="post">
        <div class="form-group">
            <label  class="col-sm-2 control-label">邮箱</label>
            <div class="col-lg-8">
                <div class="input-group">
                    <input type="text" class="form-control" id="userName" name="user_name" placeholder="输入注册的邮箱">
                    <span class="input-group-btn">
								<button class="btn btn-default" name="btnSendCode" type="button" value="获取验证码" onclick="sendMessage();" id="btnSendCode">获取验证码</button>
							</span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">验证码</label>
            <div class="col-lg-8">
                <div class="input-group">
                    <input type="text" class="form-control" name="user_token" placeholder="输入验证码">
                    <span class="input-group-btn">
								<button class="btn btn-default" type="submit">登&nbsp;&nbsp;录</button>
                        </span>
                </div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
