<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/6/5
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 专业介绍 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><c:out value="${pc_career_detail.name}"/>---专业详情</title>
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
<!-- 专业介绍-- -->
<div class="container" style="margin-top: 20px;">
    <!-- 专业名称 -->
    <div class="row">
        <ol class="breadcrumb">
            <li><a href="index.html">首页</a></li>
            <li><a href="careers.html">专业</a></li>
            <li class="active"><c:out value="${pc_career_detail.name}"/>---专业介绍</li>
        </ol>
    </div>
    <!-- 专业介绍 -->
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><c:out value="${pc_career_detail.name}"/>---专业介绍</h3>
            </div>
            <div class="panel-body">
                <!-- 专业数据输出 -->
                <h5 class="text-primary">专业名称</h5>
                <p><c:out value="${pc_career_detail.name}"/></p>
                <h5 class="text-primary">专业代码</h5>
                <p><c:out value="${pc_career_detail.code}"/></p>
                <h5 class="text-primary">专业男:女生比例</h5>
                <p><c:out value="${pc_career_detail.rate}"/></p>
                <h5 class="text-primary">专业授予学位</h5>
                <p><c:out value="${pc_career_detail.degree}"/></p>
                <h5 class="text-primary">专业介绍</h5>
                <p><c:out value="${pc_career_detail.is_what}"/></p>
                <h5 class="text-primary">学习课程</h5>
                <p><c:out value="${pc_career_detail.learn_what}"/></p>
                <h5 class="text-primary">专业方向</h5>
                <p><c:out value="${pc_career_detail.do_what}"/></p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title"><c:out value="${pc_career_detail.name}"/>---专业就业</h3>
            </div>
            <div class="panel-body">
                <!-- 专业数据输出 -->
                <div class="container" class="data">
                    <p><c:out value="${pc_career_detail.name}"/>---专业岗位分布</p>
                    <div id="main" style="width: 100%;height:400px;"></div>
                    <hr />
                </div>
                <div class="panel-body">
                    <!-- 专业数据输出 -->
                    <p><c:out value="${pc_career_detail.name}"/>---专业岗位分布</p>
                    <c:forEach items="${pc_jobdetail_3s}" var="pc_jobdetail_3">
                        <p class="text-primary">
                            <c:out value="${pc_jobdetail_3.detail_pos}"/>
                        </p>
                        <p>
                            <c:out value="${pc_jobdetail_3.detail_job}"/>
                        </p>
                    </c:forEach>
                    <hr />
                    <div class="container" class="data">

                        <div id="main1" style="width: 100%;height:400px;"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));
    var myChart1 = echarts.init(document.getElementById('main1'));
    option = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c}% "
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: ${jobdetai1_name}
        },
        series: [{
            name: '--专业就业数据统计',
            type: 'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: ${jobdetai1_data}
        }]
    };
    option1 = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c}% "
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:
                ${pc_jobdetail_3Name}
        },
        series: [{
            name: '--专业就业数据统计',
            type: 'pie',
            radius: ['50%', '70%'],
            avoidLabelOverlap: false,
            label: {
                normal: {
                    show: false,
                    position: 'center'
                },
                emphasis: {
                    show: true,
                    textStyle: {
                        fontSize: '30',
                        fontWeight: 'bold'
                    }
                }
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data: ${pc_jobdetail_3Data}
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    myChart1.setOption(option1);
</script>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

