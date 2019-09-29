<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/5/30
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 高考小数据	省控分数线 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>省/直辖市控档分数线</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/echarts.min.js"></script>
    <style type="text/css">
        body {
            padding-top: 50px;
        }

        h3 {
            text-align: center;
        }

        .data {
            margin-top: 50px;
        }
    </style>
</head>
<body>
<!-- 导航条 -->
<%@include file="jspfragments/navigation.jsp"%>
<!-- 省/直辖市地区的下拉选择地方 -->
<div class="container">
    <nav class="navbar navbar-default" style="margin-top: 50px; background: #00000000;">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">选择地区</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul class="nav navbar-nav">
                    <li class="<c:if test="${localAreaID==1}">active</c:if>">
                        <a href="province.html?localAreaID=1">华东地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==2}">active</c:if>">
                        <a href="province.html?localAreaID=2">华北地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==3}">active</c:if>">
                        <a href="province.html?localAreaID=3">西南地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==4}">active</c:if>">
                        <a href="province.html?localAreaID=4">东北地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==5}">active</c:if>">
                        <a href="province.html?localAreaID=5">华南地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==6}">active</c:if>">
                        <a href="province.html?localAreaID=6">西北地区</a></li>
                    <li class="<c:if test="${localAreaID==7}">active</c:if>">
                        <a href="province.html?localAreaID=7">华中地区</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container">
    <nav class="navbar navbar-default" style="margin-top: 0px; background: #00000000;">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-3"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">选择省</a>
            </div>
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                <ul class="nav navbar-nav">
                    <c:forEach var="local" items="${locals}">
                        <li class="<c:if test="${local.provinces==provinces}">active</c:if>">
                            <a href="<c:out value="province.html?localAreaID=${localAreaID}&provinces=${local.provinces}"/>"><c:out value="${local.local}"/></a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="container" id="container-tt">
    <h3><c:out value="${staticLocal.local}"/>控档线</h3>
    <ul class="nav nav-tabs" role="tablist">
        <li class="active"><a href="#home" role="tab" data-toggle="tab">2018年</a></li>
        <li><a href="#profile" role="tab" data-toggle="tab">2017年</a></li>
        <li><a href="#messages" role="tab" data-toggle="tab">2016年</a></li>
        <li><a href="#messages1" role="tab" data-toggle="tab">2015年</a></li>
        <li><a href="#messages2" role="tab" data-toggle="tab">2014年</a></li>
    </ul>

    <div class="tab-content">
        <div class="tab-pane active" id="home">
            <h5>2018年<c:out value="${staticLocal.local}"/>控档线</h5>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>地区</th>
                    <th>年份</th>
                    <th>考生类别</th>
                    <th>批次</th>
                    <th>分数</th>
                </tr>
                </thead>
                <c:forEach var="batch" items="${batches2018}">
                <tbody>
                <tr>
                    <th><c:out value="${batch.local}"/></th>
                    <th><c:out value="${batch.syear}"/></th>
                    <th><c:out value="${batch.wl}"/></th>
                    <th><c:out value="${batch.batch}"/></th>
                    <th><c:out value="${batch.MINscore}"/></th>
                </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
        <div class="tab-pane" id="profile">
            <h5>2017年<c:out value="${staticLocal.local}"/>控档线</h5>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>地区</th>
                    <th>年份</th>
                    <th>考生类别</th>
                    <th>批次</th>
                    <th>分数</th>
                </tr>
                </thead>
                <c:forEach var="batch" items="${batches2017}">
                    <tbody>
                    <tr>
                        <th><c:out value="${batch.local}"/></th>
                        <th><c:out value="${batch.syear}"/></th>
                        <th><c:out value="${batch.wl}"/></th>
                        <th><c:out value="${batch.batch}"/></th>
                        <th><c:out value="${batch.MINscore}"/></th>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        <div class="tab-pane" id="messages">
            <h5>2016年<c:out value="${staticLocal.local}"/>控档线</h5>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>地区</th>
                    <th>年份</th>
                    <th>考生类别</th>
                    <th>批次</th>
                    <th>分数</th>
                </tr>
                </thead>
                <c:forEach var="batch" items="${batches2016}">
                    <tbody>
                    <tr>
                        <th><c:out value="${batch.local}"/></th>
                        <th><c:out value="${batch.syear}"/></th>
                        <th><c:out value="${batch.wl}"/></th>
                        <th><c:out value="${batch.batch}"/></th>
                        <th><c:out value="${batch.MINscore}"/></th>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        <div class="tab-pane" id="messages1">
            <h5>2015年<c:out value="${staticLocal.local}"/>控档线</h5>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>地区</th>
                    <th>年份</th>
                    <th>考生类别</th>
                    <th>批次</th>
                    <th>分数</th>
                </tr>
                </thead>
                <c:forEach var="batch" items="${batches2015}">
                    <tbody>
                    <tr>
                        <th><c:out value="${batch.local}"/></th>
                        <th><c:out value="${batch.syear}"/></th>
                        <th><c:out value="${batch.wl}"/></th>
                        <th><c:out value="${batch.batch}"/></th>
                        <th><c:out value="${batch.MINscore}"/></th>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
        <div class="tab-pane" id="messages2">
            <h5>2014年<c:out value="${staticLocal.local}"/>控档线</h5>
            <table class="table table-hover table-bordered">
                <thead>
                <tr>
                    <th>地区</th>
                    <th>年份</th>
                    <th>考生类别</th>
                    <th>批次</th>
                    <th>分数</th>
                </tr>
                </thead>
                <c:forEach var="batch" items="${batches2014}">
                    <tbody>
                    <tr>
                        <th><c:out value="${batch.local}"/></th>
                        <th><c:out value="${batch.syear}"/></th>
                        <th><c:out value="${batch.wl}"/></th>
                        <th><c:out value="${batch.batch}"/></th>
                        <th><c:out value="${batch.MINscore}"/></th>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </div>
    <hr />
</div>
<div class="container" class="data">
    <p><c:out value="${staticLocal.local}"/>历年高考数据</p>
    <div id="main" style="width: 100%;height:400px;"></div>
    <hr />
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    option = {
        legend: {},
        tooltip: {},
        dataset: {
            source: [
                ${tubiaoData}
            ]
        },
        xAxis: {
            type: 'category'
        },
        yAxis: {},
        series: [{
            type: 'bar'
        },
            {
                type: 'bar'
            },
            {
                type: 'bar'
            },
            {
                type: 'bar'
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>

