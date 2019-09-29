<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/5/31
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 一分一档 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>一份一档</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/echarts.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <style type="text/css">
        body {
            padding-top: 50px;
        }

        .carousel {
            height: 500px;
            background-color: #000000;
            margin-bottom: 50px;
        }

        .containerT {
            margin-top: 20px;
        }
        h3{
            text-align: center;
        }
        .data {
            margin-top: 50px;
        }
        .data1{
            margin-top: 50px;
        }
    </style>
</head>
<body>
<!-- 导航条 -->
<%@include file="/jspfragments/navigation.jsp" %>

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
                        <a href="stairScore.html?localAreaID=1">华东地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==2}">active</c:if>">
                        <a href="stairScore.html?localAreaID=2">华北地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==3}">active</c:if>">
                        <a href="stairScore.html?localAreaID=3">西南地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==4}">active</c:if>">
                        <a href="stairScore.html?localAreaID=4">东北地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==5}">active</c:if>">
                        <a href="stairScore.html?localAreaID=5">华南地区</a>
                    </li>
                    <li class="<c:if test="${localAreaID==6}">active</c:if>">
                        <a href="stairScore.html?localAreaID=6">西北地区</a></li>
                    <li class="<c:if test="${localAreaID==7}">active</c:if>">
                        <a href="stairScore.html?localAreaID=7">华中地区</a>
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

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                <ul class="nav navbar-nav">
                    <c:forEach var="local" items="${locals}">
                        <li class="<c:if test="${local.provinces==provinces}">active</c:if>">
                            <a href="<c:out value="stairScore.html?localAreaID=${localAreaID}&provinces=${local.provinces}"/>"><c:out value="${local.local}"/></a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
</div>
<!-- 友情提示 -->
<div class="container data1">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">2018年${staticLocal.local}高考</h3>
        </div>
        <div class="panel-body">
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
    </div>
    <hr />
</div>
<!-- 数据展示区 -->
<div class="container">
    <h3>2018年${staticLocal.local}省一分一档</h3>
    <div id="main" style="width: 100%;height:400px;"></div>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    myChart.showLoading();
    $.getJSON('${pageContext.request.contextPath}/json/stairScoreJson.json?provinces=${provinces}&year=2018', function(obama_budget_2012) {
        myChart.hideLoading();

        option = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow',
                    label: {
                        show: true
                    }
                }
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {
                        show: true
                    },
                    dataView: {
                        show: true,
                        readOnly: false
                    },
                    magicType: {
                        show: true,
                        type: ['line', 'bar']
                    },
                    restore: {
                        show: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            calculable: true,
            legend: {
                data: ['Growth', '文科', '理科'],
                itemGap: 5
            },
            grid: {
                top: '12%',
                left: '1%',
                right: '10%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data: obama_budget_2012.names
            }],
            yAxis: [{
                type: 'value',
                name: '数据信息',
                axisLabel: {
                    formatter: function(a) {
                        a = +a;
                        return isFinite(a) ?
                            echarts.format.addCommas(+a / 1000) :
                            '';
                    }
                }
            }],
            dataZoom: [{
                show: true,
                start: 94,
                end: 100
            },
                {
                    type: 'inside',
                    start: 94,
                    end: 100
                },
                {
                    show: true,
                    yAxisIndex: 0,
                    filterMode: 'empty',
                    width: 30,
                    height: '80%',
                    showDataShadow: false,
                    left: '93%'
                }
            ],
            series: [{
                name: '文科',
                type: 'bar',
                data: obama_budget_2012.budget2011List
            },
                {
                    name: '理科',
                    type: 'bar',
                    data: obama_budget_2012.budget2012List
                }
            ]
        };
        myChart.setOption(option);
    });
</script>
<!-- 数据展示区 -->
<div class="container data1">
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">2018年${staticLocal.local}高考</h3>
        </div>
        <div class="panel-body">
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
    </div>
    <hr />
</div>
<div class="container">
    <h3>2017年${staticLocal.local}省一分一档</h3>
    <div id="main1" style="width: 100%;height:400px;"></div>
</div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart1 = echarts.init(document.getElementById('main1'));
    myChart1.showLoading();
    $.getJSON('${pageContext.request.contextPath}/json/stairScoreJson.json?provinces=${provinces}&year=2017', function(obama_budget_2012) {
        myChart1.hideLoading();

        option1 = {
            tooltip: {
                trigger: 'axis',
                axisPointer: {
                    type: 'shadow',
                    label: {
                        show: true
                    }
                }
            },
            toolbox: {
                show: true,
                feature: {
                    mark: {
                        show: true
                    },
                    dataView: {
                        show: true,
                        readOnly: false
                    },
                    magicType: {
                        show: true,
                        type: ['line', 'bar']
                    },
                    restore: {
                        show: true
                    },
                    saveAsImage: {
                        show: true
                    }
                }
            },
            calculable: true,
            legend: {
                data: ['Growth', '文科', '理科'],
                itemGap: 5
            },
            grid: {
                top: '12%',
                left: '1%',
                right: '10%',
                containLabel: true
            },
            xAxis: [{
                type: 'category',
                data: obama_budget_2012.names
            }],
            yAxis: [{
                type: 'value',
                name: '数据信息',
                axisLabel: {
                    formatter: function(a) {
                        a = +a;
                        return isFinite(a) ?
                            echarts.format.addCommas(+a / 1000) :
                            '';
                    }
                }
            }],
            dataZoom: [{
                show: true,
                start: 94,
                end: 100
            },
                {
                    type: 'inside',
                    start: 94,
                    end: 100
                },
                {
                    show: true,
                    yAxisIndex: 0,
                    filterMode: 'empty',
                    width: 30,
                    height: '80%',
                    showDataShadow: false,
                    left: '93%'
                }
            ],
            series: [{
                name: '文科',
                type: 'bar',
                data: obama_budget_2012.budget2011List
            },
                {
                    name: '理科',
                    type: 'bar',
                    data: obama_budget_2012.budget2012List
                }
            ]
        };
        myChart1.setOption(option1);
    });
</script>

<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>

