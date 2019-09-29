<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/6/1
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 专业介绍 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>专业中心</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        body {
            padding-top: 50px;
        }
    </style>
</head>

<body>
<!-- 导航条 -->
<%@include file="/jspfragments/navigation.jsp" %>
<!-- 添加查找输入 -->
<div class="container" style="margin-top:20px">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/careers.html" method="post">
        <div class="form-group">
            <label  class="col-sm-2 control-label">请输入专业</label>
            <div class="col-lg-8">
                <div class="input-group">
                    <input type="text" class="form-control" name="career_name" id="exampleInputEmail1" placeholder="请输入你你想查询的专业">
                    <span class="input-group-btn">
								<input class="btn btn-default"  type="submit" value="查找"></input>
							</span>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- 添加专业专业层次导航栏 -->
<%--判断当前是不是查找专业--%>
<c:if test="${select==1}">
    <div class="container">
        <nav class="navbar navbar-default" style="margin-top: 30px; background: #00000000;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-5"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">专业层次选择</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
                    <ul class="nav navbar-nav">
                        <li class="<c:if test="${major_1==1}">active</c:if>"><a href="careers.html?major_1=1">本科</a></li>
                        <li class="<c:if test="${major_1==2}">active</c:if>"><a href="careers.html?major_1=2">专科</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <!-- 专业大类导航栏 -->
    <div class="container">
        <nav class="navbar navbar-default" style="margin-top: 10px; background: #00000000;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">专业大类选择</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                    <ul class="nav navbar-nav">
                        <c:forEach items="${careers_1}" var="careers">
                            <li class="<c:if test="${careers.level2==major_2}">active</c:if>">
                                <a href="careers.html?major_1=${major_1}&major_2=${careers.level2}">
                                    <c:out value="${careers.level2_name}"/>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="container">
        <nav class="navbar navbar-default" style="margin-top: 10px; background: #00000000;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-3"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">专业小类选择</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                    <ul class="nav navbar-nav">
                        <c:forEach items="${careers_2}" var="careers">
                            <li class="<c:if test="${careers.level3==major_3}">active</c:if>">
                                <a href="careers.html?major_1=${major_1}&major_2=${major_2}&major_3=${careers.level3}">
                                    <c:out value="${careers.level3_name}"/>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</c:if>
<div class="container">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>专业大类</th>
            <th>专业小类</th>
            <th>专业名称</th>
            <th>专业介绍</th>
            <th>收藏专业</th>
        </tr>
        </thead>
        <c:forEach var="career" items="${careers_3}">
        <tbody>
        <tr>
            <form class="form-horizontal" action="${pageContext.request.contextPath}/collect.html" method="post">
            <th><c:out value="${career.level2_name}"/></th>
            <th><c:out value="${career.level3_name}"/></th>
            <th><c:out value="${career.name}"/></th>
            <th><a href="career.html?careerId=${career.special_id}">专业详情&nbsp;<samp class="glyphicon glyphicon-search" aria-hidden="true" /></a></th>
                <input type="hidden" name="addCollect" value="careerId=${career.special_id}"/>
            <th><button class="btn btn-link" type="submit" >收藏专业&nbsp;<samp class="glyphicon glyphicon-star-empty" aria-hidden="true" /></button></th>
            </form>
        </tr>
        </tbody>
        </c:forEach>
    </table>
</div>

<div class="container">
    <nav class="navbar navbar-default" style="margin-top: 50px; background: #00000000;">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-4"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="">专业热点</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                <ul class="nav navbar-nav">
                    <li><a target="_blank" href="https://gkcx.eol.cn/special?zycengci=%E6%9C%AC%E7%A7%91&zytype=">高考数据库</a></li>
                    <li><a target="_blank" href="https://www.dxsbb.com/news/list_76.html">大学生必备网</a></li>
                    <li><a target="_blank" href="https://www.dxsbb.com/news/list_454.html">热门专业</a></li>
                    <li><a target="_blank" href="https://www.dxsbb.com/news/list_90.html">就业前景</a></li>
                    <li><a target="_blank" href="https://www.dxsbb.com/news/list_160.html">专业介绍</a></li>
                    <li><a target="_blank" href="https://www.dxsbb.com/news/list_96.html">专业目录</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<style type="text/javascript">

</style>
</body>
</html>
