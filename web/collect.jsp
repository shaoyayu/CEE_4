<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/6/8
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 用户收藏 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户收藏</title>
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
<div class="container" style="margin-top: 20px;">
<%--    <h3>欢迎你：<br/><c:out value="${user.mail}"/>用户</h3>--%>
    <h3>欢迎你：<br/><c:out value="邵涯语"/></h3>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">你收藏的专业，有</div>
            <div class="panel-body">
                <p>下面是你所收藏的专业</p>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>专业名称</th>
                    <th>移除收藏</th>
                    <th>专业介绍</th>
                </tr>
                </thead>
                <c:forEach var="career" items="${careerList}">
                <tbody>
                <tr>

                    <th>
                        <c:out value="${career.name}"/>
                    </th>
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/collect.html" method="post">
                        <th>
                            <input type="hidden" name="addCollect" value="rCareerId=${career.special_id}"/>
                            <button class="btn-link" type="submit" >移除收藏&nbsp;<samp class="glyphicon glyphicon-trash" aria-hidden="true"/></button>
                        </th>
                    </form>
                    <th><a href="career.html?careerId=${career.special_id}">专业介绍&nbsp;<samp class="glyphicon glyphicon-search" aria-hidden="true"/></a></th>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">你收藏的高校</div>
            <div class="panel-body">
                <p>下面是你所收藏的高校</p>
            </div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>学校名称</th>
                    <th>移除收藏</th>
                    <th>专业介绍</th>
                </tr>
                </thead>
                <c:forEach items="${schoolInfoList}" var="school">
                    <tbody>
                    <tr>
                        <th>
                            <c:out value="${school.name}"/>
                        </th>
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/collect.html" method="post">
                            <th>
                                <input type="hidden" name="addCollect" value="rSchoolId=${school.school_id}"/>
                                <button class="btn-link" type="submit" >移除收藏&nbsp;<samp class="glyphicon glyphicon-trash" aria-hidden="true"/></button>
                            </th>
                        </form>
                        <th><a href="schoolItem.html?schoolId=${school.school_id}">专业介绍&nbsp;<samp class="glyphicon glyphicon-search" aria-hidden="true"/></a></th>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

<div class="container" style="margin-top: 20px;">
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

