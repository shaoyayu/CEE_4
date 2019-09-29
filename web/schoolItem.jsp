<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/6/7
  Time: 8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 学校详细信息 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${schoolInfo.name}"></c:out>---详细信息</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/echarts.min.js"></script>
    <style type="text/css">
        body {
            padding-top: 50px;
        }
        .row_margin_bottom{
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<!-- 导航条 -->
<%@include file="/jspfragments/navigation.jsp" %>
<div class="container">
    <h1 style="text-align: center;"><c:out value="${schoolInfo.name}"></c:out></h1>
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
                    <li class="active"><a href="#">详细信息</a></li>
                    <li><a href="schoolCareers.html?schoolId=${schoolInfo.school_id}">开设专业</a></li>
                    <li><a href="schoolAcademy.html?schoolId=${schoolInfo.school_id}">开设院系</a></li>
                    <li>
                        <form class="form-horizontal" action="${pageContext.request.contextPath}/collect.html" method="post">
                            <input type="hidden" name="addCollect" value="schoolId=${schoolInfo.school_id}"/>
                            <button class="btn btn-link" type="submit" style="margin-top: 8%" >收藏学校&nbsp;<samp class="glyphicon glyphicon-star-empty" aria-hidden="true" /></button>
                        </form>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">学校介绍</h3>
        </div>
        <div class="panel-body">
            <div class="row row_margin_bottom">
                <div class="col-xs-12">
                    <h4>
                        <c:out value="${school.schoolName}"/>
                    </h4>
                    <div class="row">
                        <div class="col-md-3">
                            <p>地区:
                                <c:out value="${school.location}"/>
                            </p>
                        </div>
                        <div class="col-md-3">
                            <p>重点学科：
                                <c:out value="${school.keyDiscipline}"/>
                            </p>
                        </div>
                        <div class="col-md-3">
                            <p>硕士点数：
                                <c:out value="${school.master}"/>
                            </p>
                        </div>
                        <div class="col-md-3">
                            <p>博士点数：
                                <c:out value="${school.doctor}"/>
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <p>学校类型：
                                <c:out value="${school.category}"/>
                            </p>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <p>学校标签:&nbsp;
                                <c:out value="${school.rests}"/>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <c:set var="locationT" value="https://map.baidu.com/search/@11878738.37739184,3048426.167919651,18.42z?querytype=s&wd="/>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><c:out value="${schoolInfo.name}"/>---学校详细</h3>
        </div>
        <div class="panel-body">
            <div class="row row_margin_bottom" style="margin-bottom: 10px;">
                <div class="col-md-4">
                    <p>隶属：
                        <c:out value="${schoolInfo.belong}"/>
                    </p>
                </div>
                <div class="col-md-4">
                    城市：
                    <c:out value="${schoolInfo.city_name}"/>
                </div>
                <div class="col-md-4">
                    办学水平：
                    <c:out value="${schoolInfo.level_name}"/>
                </div>
            </div>
            <div class="row row_margin_bottom">
                <div class="col-md-4">
                    <p>院校名字：
                        <c:out value="${schoolInfo.name}"/>
                    </p>
                </div>
                <div class="col-md-4">
                    <p>学校地区：
                        <c:out value="${schoolInfo.province_name}"/>
                    </p>
                </div>
                <div class="col-md-4">
                    学校类型：
                    <c:out value="${schoolInfo.school_type_name}"/>
                    </a>
                </div>
            </div>
            <div class="row row_margin_bottom">
                <div class="col-md-4">
                    <p>联系电话：<br />
                        <c:out value="${schoolInfo.phone}"/></p>
                </div>
                <div class="col-md-8">
                    学校官网：<br />
                    <a target="_blank" href="<c:out value="${schoolInfo.site}"/>">
                        <c:out value="${schoolInfo.site}"/>
                    </a>
                </div>
            </div>
            <div class="row row_margin_bottom">
                <div class="col-md-12">
                    详细地址：(百度地图在电脑上面可以实现全景3D观看学校)<br /><a target="_blank" href="${locationT}<c:out value="${schoolInfo.address}"/>">
                    <c:out value="${schoolInfo.address}"/>
                </a>
                </div>
            </div>
            <hr/>
        </div>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">联系方式</h3>
        </div>
        <div class="panel-body">
            <div class="row row_margin_bottom">
                <div class="col-md-2">
                    <p>院校类型：<br />
                        <c:out value="${schoolSc.type}"/>
                    </p>
                </div>
                <div class="col-md-2">
                    <p>学校地址：<br />
                        <c:out value="${schoolSc.site}"/>
                    </p>
                </div>
                <div class="col-md-5">
                    详细地址：(百度地图在电脑上面可以实现全景3D观看学校)<br /><a target="_blank" href="${locationT}<c:out value="${schoolInfo.address}"/>">
                    <c:out value="${schoolSc.location}"/></a>
                </div>
                <div class="col-md-3">
                    学校官网：<br /><a target="_blank" href="<c:out value="${schoolSc.officialWebsite}"/>"> <c:out value="${schoolSc.officialWebsite}"/></a>
                </div>
            </div>
        </div>
    </div>
    <hr />
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

