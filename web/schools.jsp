<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/6/5
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 高校大全 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>高校大全</title>
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
<div class="container" style="margin-top:20px">
    <form class="form-horizontal" action="${pageContext.request.contextPath}/schools.html" method="post">
        <div class="form-group">
            <label  class="col-sm-2 control-label">请输入学校</label>
            <div class="col-lg-8">
                <div class="input-group">
                    <input type="text" class="form-control" name="school_name" id="exampleInputEmail1" placeholder="请输入你你想查询的学校">
                    <span class="input-group-btn">
								<input class="btn btn-default"  type="submit" value="查找"/>
					</span>
                </div>
            </div>
        </div>
    </form>
</div>
<c:if test="${select==1}">
    <div class="container">
        <nav class="navbar navbar-default" style="margin-top: 0px; background: #00000000;">
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
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                    <ul class="nav navbar-nav">
                        <li class="<c:if test="${localAreaID==1}">active</c:if>">
                            <a href="schools.html?localAreaID=1">华东地区</a>
                        </li>
                        <li class="<c:if test="${localAreaID==2}">active</c:if>">
                            <a href="schools.html?localAreaID=2">华北地区</a>
                        </li>
                        <li class="<c:if test="${localAreaID==3}">active</c:if>">
                            <a href="schools.html?localAreaID=3">西南地区</a>
                        </li>
                        <li class="<c:if test="${localAreaID==4}">active</c:if>">
                            <a href="schools.html?localAreaID=4">东北地区</a>
                        </li>
                        <li class="<c:if test="${localAreaID==5}">active</c:if>">
                            <a href="schools.html?localAreaID=5">华南地区</a>
                        </li>
                        <li class="<c:if test="${localAreaID==6}">active</c:if>">
                            <a href="schools.html?localAreaID=6">西北地区</a></li>
                        <li class="<c:if test="${localAreaID==7}">active</c:if>">
                            <a href="schools.html?localAreaID=7">华中地区</a>
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
                                <a href="<c:out value="schools.html?localAreaID=${localAreaID}&provinces=${local.provinces}"/>"><c:out value="${local.local}"/></a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="container" style="margin-top: 0px;">
        <nav class="navbar navbar-default" style="margin-top: 0px; background: #00000000;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-4"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">选择城市</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                    <ul class="nav navbar-nav">
                        <c:forEach var="city" items="${cityMapS}">
                            <li class="<c:if test="${city.city_id == staticCity}">active</c:if>">
                                <a href="<c:out value="schools.html?localAreaID=${localAreaID}&provinces=${provinces}&city_id=${city.city_id}"/>">
                                    <c:out value="${city.city_name}"/>
                                </a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
    <div class="container" style="margin-top:0px;">
        <nav class="navbar navbar-default" style="margin-top: 0px; background: #00000000;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-6"
                            aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">学校类型</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-6">
                    <ul class="nav navbar-nav">
                        <li class="<c:if test="${school_type==1}">active</c:if>">
                            <a href="<c:out value="schools.html?localAreaID=${localAreaID}&provinces=${provinces}&city_id=${staticCity}&school_type=1"/>">
                                本科
                            </a>
                        </li>
                        <li class="<c:if test="${school_type==2}">active</c:if>">
                            <a href="<c:out value="schools.html?localAreaID=${localAreaID}&provinces=${provinces}&city_id=${staticCity}&school_type=2"/>">
                                独立院校
                            </a>
                        </li>
                        <li class="<c:if test="${school_type==3}">active</c:if>">
                            <a href="<c:out value="schools.html?localAreaID=${localAreaID}&provinces=${provinces}&city_id=${staticCity}&school_type=3"/>">
                                中外合作
                            </a>
                        </li>
                        <li class="<c:if test="${school_type==4}">active</c:if>">
                            <a href="<c:out value="schools.html?localAreaID=${localAreaID}&provinces=${provinces}&city_id=${staticCity}&school_type=4"/>">
                                高职
                            </a>
                        </li>
                        <li class="<c:if test="${school_type==5}">active</c:if>">
                            <a href="<c:out value="schools.html?localAreaID=${localAreaID}&provinces=${provinces}&city_id=${staticCity}&school_type=5"/>">
                                其他
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </div>
</c:if>
<div class="container">
    <c:set var="locationT" value="https://map.baidu.com/search/@11878738.37739184,3048426.167919651,18.42z?querytype=s&wd="/>
    <c:forEach items="${schoolInfoList}" var="school">
        <div class="panel panel-info">
            <div class="panel-heading">
                <h3 class="panel-title"><c:out value="${school.name}"/>---学校详细</h3>
            </div>
            <div class="panel-body">
                <div class="row row_margin_bottom" style="margin-bottom: 10px;">
                    <div class="col-md-4">
                        <p>隶属：
                            <c:out value="${school.belong}"/>
                        </p>
                    </div>
                    <div class="col-md-4">
                        城市：
                        <c:out value="${school.city_name}"/>
                    </div>
                    <div class="col-md-4">
                        办学水平：
                        <c:out value="${school.level_name}"/>
                    </div>
                </div>
                <div class="row row_margin_bottom">
                    <div class="col-md-4">
                        <p>院校名字：
                            <c:out value="${school.name}"/>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <p>学校地区：
                            <c:out value="${school.province_name}"/>
                        </p>
                    </div>
                    <div class="col-md-4">
                        学校类型：
                         <c:out value="${school.school_type_name}"/>
                        </a>
                    </div>
                </div>
                <div class="row row_margin_bottom">
                    <div class="col-md-4">
                        <p>联系电话：<br />
                            <c:out value="${school.phone}"/></p>
                    </div>
                    <div class="col-md-8">
                        学校官网：<br />
                        <a target="_blank" href="<c:out value="${school.site}"/>">
                            <c:out value="${school.site}"/>
                        </a>
                    </div>
                </div>
                <div class="row row_margin_bottom">
                    <div class="col-md-12">
                        详细地址：<br /><a target="_blank" href="${locationT}<c:out value="${school.address}"/>">
                        <c:out value="${school.address}"/>
                    </a>
                    </div>
                </div>
                <hr/>
                <div class="row row_margin_bottom">
                    <div class="col-md-3">
                        <a  href="schoolItem.html?schoolId=${school.school_id}">详细信息</a>
                    </div>
                    <div class="col-md-3">
                        <a  href="schoolCareers.html?schoolId=${school.school_id}">开设专业</a>
                    </div>
                    <div class="col-md-3">
                        <a  href="schoolAcademy.html?schoolId=${school.school_id}">开设院校</a>
                    </div>
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/collect.html" method="post">
                        <div class="col-md-3">
                            <input type="hidden" name="addCollect" value="schoolId=${school.school_id}"/>
                            <button class="btn btn-link" type="submit" >收藏学校&nbsp;<samp class="glyphicon glyphicon-star-empty" aria-hidden="true" /></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>

