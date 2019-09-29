<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/5/30
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--导航栏-->
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
                <li class=""><a href="${pageContext.request.contextPath}/index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;首页</a></li>
            </ul>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="false"></span>&nbsp;省高考数据
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/province.html?localAreaID=3&provinces=guizhou">省控分数线</a></li>
                        <li><a href="${pageContext.request.contextPath}/stairScore.html?localAreaID=3&provinces=guizhou">一分一档</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/careers.html?major_1=1">专业中心</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="false"></span>&nbsp;高校数据
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/schools.html?localAreaID=3&provinces=guizhou&city_id=208">高校大全</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">高校录取分数线</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <span class="glyphicon glyphicon-th-list" aria-hidden="false"></span>&nbsp;个人中心
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/collect.html">收藏</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="${pageContext.request.contextPath}/login.html">登录</a></li>
                        <li><a href="${pageContext.request.contextPath}/register.html">注册</a></li>
                    </ul>
                </li>
                <li><a href="admin.html">
                    <span class="glyphicon glyphicon-globe" aria-hidden="false"></span>&nbsp;管理员(公告)</a></li>
            </ul>
        </div>
    </div>
</nav>