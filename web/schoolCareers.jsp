<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/6/7
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 学校专业 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${schoolName}"/>学校开设专业</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/echarts.min.js"></script>
    <style type="text/css">
        body {
            padding-top: 50px;
        }
    </style>
</head>
<body>
<!-- 导航条 -->
<%@include file="/jspfragments/navigation.jsp" %>
<div class="container">
    <h1 style="text-align: center;"><c:out value="${schoolName}"/></h1>
    <nav class="navbar navbar-default" style="margin-top: 20px; background: #00000000;">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">高校信息选择</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav">
                    <li><a href="schoolItem.html?schoolId=${schoolId}">详细信息</a></li>
                    <li class="active"><a href="schoolCareers.html?schoolId=${schoolId}">开设专业</a></li>
                    <li><a href="schoolAcademy.html?schoolId=${schoolId}">开设院系</a></li>
                    <li>
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/collect.html" method="post">
                            <input type="hidden" name="addCollect" value="schoolId=${schoolId}"/>
                            <button class="btn btn-link" type="submit" style="margin-top: 8%" >收藏学校&nbsp;<samp class="glyphicon glyphicon-star-empty" aria-hidden="true" /></button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
            <p>这里面的数据误差可能会很大，你可以去学校官网了解，谢谢体谅</p>
            <div class="panel panel-warning">
                <div class="panel-heading">
                    <h3 class="panel-title">本科开设专业</h3>
                </div>
                <div class="panel-body">
                    <c:forEach var="career" items="${schoolCareerWL_1}" begin="1" varStatus="status">
                        <span style="margin:20px;">
                            <c:out value="（${status.count}）${career.special_name}"/>
                        </span>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12">
            <div class="panel panel-danger">
                <div class="panel-heading">
                    <h3 class="panel-title">专科开设专业</h3>
                </div>
                <div class="panel-body">
                    <c:forEach var="career" items="${schoolCareerWL_2}" begin="1" varStatus="status">
                        <span style="margin:20px;">
                            <c:out value="（${status.count}）${career.special_name}"/>
                        </span>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

