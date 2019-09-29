<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/5/27
  Time: 8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 高考小数据首页 -->
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>首页</title>
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <style type="text/css">
    body {
      padding-top: 50px;
    }

    .carousel .item {
      background-color: #000000;
    }
    .summary-container {
      margin-bottom: 20px;
      text-align: center;
    }

    .imageName {
      width: 140px;
      height: 140px;
    }

    .textAlert {
      text-align: center;
    }

    .a_div {
      margin-top: 50px;
    }
  </style>
</head>
<body>
<%--导入导航栏的jsp--%>
<%@include file="/jspfragments/navigation.jsp" %>
<div class="">
  <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
      <li data-target="#carousel-example-generic" data-slide-to="1"></li>
      <li data-target="#carousel-example-generic" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <!-- 请使用宽800*500照片 -->
        <img src="img/index-1.png" alt="...">
        <div class="carousel-caption" style="margin-top: 1px;">
          <h3>欢迎你来到高考小数据</h3>
          <p >数据来源于网络爬虫，数据可能会有误差，请大家经供参考，网站仅供学习使用，不做任何商业用途</p>
        </div>
      </div>
      <div class="item">
        <img src="img/guizhouzhaoshengkaoshi.png" alt="贵州招生考试网">
        <div class="carousel-caption" style="background:#999999">
          <h3 style="color: red;">贵州招生考试网</h3>
          <p><a target="_blank" href="http://www.eaagz.org.cn/">进入官网</a></p>
        </div>
      </div>
      <div class="item">
        <img src="img/shouye_3.jpg" alt="...">
        <div class="carousel-caption" style="color: red; background: #09BA07;">
          <h1>友情提示：</h1>
          <h3>请大家按照招生简章填报志愿，本站数据会做成一些数据误差。数据仅供参考</h3>
          <h3>请大家记得防诈骗，增强自己的安全意识</h3>
        </div>
      </div>
    </div>
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">上一页</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">下一页</span>
    </a>
  </div>
</div>

<div class="container a_div">
  <h3 class="textAlert" style="margin-bottom: 50px;">大学数据展览</h3>
  <div class="row">
    <c:set var="locationT" value="https://map.baidu.com/search/@11878738.37739184,3048426.167919651,18.42z?querytype=s&wd="/>
    <c:forEach var="schoolInfo" items="${schoolInfoList}">
    <div class="col-sm-6 col-md-4">
      <div class="thumbnail">
        <div class="caption">
          <h3 class="text-primary"><c:out value="${schoolInfo.name}"/></h3>
          <p>数据展示</p>
          <hr />
          <p>详细地址:<span class="text-primary"><c:out value="${schoolInfo.address}"/></span></p>
          <p>隶属:<span class="text-primary"><c:out value="${schoolInfo.belong}"/></span></p>
          <p>城市名字:<span class="text-primary"><c:out value="${schoolInfo.city_name}"/></span></p>
          <p>学校水平:<span class="text-primary"><c:out value="${schoolInfo.level_name}"/></span></p>
          <p>省/直辖市名称:<span class="text-primary"><c:out value="${schoolInfo.province_name}"/></span></p>
          <p>学校性质:<span class="text-primary"><c:out value="${schoolInfo.school_nature_name}"/></span></p>
          <p>学校类型:<span class="text-primary"><c:out value="${schoolInfo.school_type_name}"/></span></p>
          <p>官方网站:<span class="text-primary"><c:out value="${schoolInfo.site}"/></span></p>
          <p>城镇:<span class="text-primary"><c:out value="${schoolInfo.town_name}"/></span></p>
          <p>学校学科类型:<span class="text-primary"><c:out value="${schoolInfo.type_name}"/></span></p>
          <p>联系电话:<span class="text-primary"><c:out value="${schoolInfo.phone}"/></span></p>
          <p></p>
          <a target="_blank" href="<c:out value="${schoolInfo.site}"/>" class="btn btn-primary" role="button">进入官网&nbsp;<span class="glyphicon glyphicon-qrcode"
                                                                            aria-hidden="true"/></a>
          <a target="_blank" href="${locationT}${schoolInfo.address}" class="btn btn-default" role="button">查看位置&nbsp;<span class="glyphicon glyphicon-map-marker"
                                                                            aria-hidden="true"/></a>
        </div>
      </div>
    </div>
    </c:forEach>

  </div>
  <a class="btn btn-default" href="schools.html?localAreaID=3&provinces=guizhou" role="button">更多<span class="glyphicon glyphicon-menu-right"
                                                                      aria-hidden="true"></span></a>
  <hr />
</div>
<!-- 下拉列表选择 -->
<div class="container featurette a_div">
  <div class="col-md-7">
    <h2 class="featurette-heading">高考小数据中心：<span class="text-muted"><a href="stairScore.html?localAreaID=3&provinces=guizhou">进入一分一档</a></span></h2>
    <p class="lead">数据展示近几年的高考数据，每个省/直辖市的控档分数线，包含每个省/直辖市的分数排布,各种专业的大类小类划分，
      进几年的高考所有大学的资料，官网，地址，录取信息，用最直观的方式把数据展现到你的面前，开放数据让你自己来预算自己的想法。<br/>
      更多的高考细节请认真阅读高考相关的书籍，关于每一所高校的录取分数线建议大家可以进入学校的官网，找到招生相关的栏目，都可找到高校在每一个地区的
      历年招生的人数，分数等招生简章。这里我就不做数据展示了。
    </p>
  </div>
  <div class="col-md-5">
    <img class="featurette-image img-responsive" alt="照片加载中" src="images/gaokao.jpg">
  </div>
</div>
<div class="container featurette a_div">
  <div class="col-md-5">
    <img class="featurette-image img-responsive" alt="照片加载中" src="images/guanliyuan.jpg">
  </div>
  <div class="col-md-7">
    <h2 class="featurette-heading">公告栏：<span class="text-muted"><a href="admin.html">进入公告栏</a></span></h2>
    <p class="lead">
      这个网站是本人结合自己的学习知识技能开发的网站，数据来源于网络，请不要再短时间内不停的刷新页面，会被系统被IP地址封掉的。供有需要的学生通告简单的页面，了解到更多的高考信息，
      从不同的省市看到不一样的高考数据，了解自己喜欢的专业，省(市)的高考分数分布情况。功能不是全面，但是页面很简洁。如果你想预算一些数据，可以联系我，邮箱:yayushan@gmail
      <br />
      数据来源于网络统计，可能会有数据误差，请大家填报志愿的时候认真考虑，（友情提示:增强自己的高考防诈骗手段）
    </p>
  </div>
</div>
<div class="container a_div">
  <h3 class="textAlert">省控线</h3>
  <ul class="nav nav-tabs" role="tablist">
    <li class="active"><a href="#home" role="tab" data-toggle="tab">贵州</a></li>
    <li><a href="#profile" role="tab" data-toggle="tab">湖北</a></li>
    <li><a href="#messages" role="tab" data-toggle="tab">北京</a></li>
  </ul>
  <div class="tab-content">
    <div class="tab-pane active" id="home">
      <h5>2018贵州理科控档线</h5>
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
        <c:forEach var="Batch" items="${GZBatchs}">
        <tbody>
        <tr>
          <th><c:out value="${Batch.local}"/></th>
          <th><c:out value="${Batch.syear}"/>年</th>
          <th><c:out value="${Batch.wl}"/></th>
          <th><c:out value="${Batch.batch}"/></th>
          <th><c:out value="${Batch.MINscore}"/></th>
        </tr>
        </tbody>
        </c:forEach>
      </table>
    </div>
    <div class="tab-pane" id="profile">
      <h5>2018湖北理科控档线</h5>
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
        <c:forEach var="Batch" items="${HBBatchs}">
          <tbody>
          <tr>
            <th><c:out value="${Batch.local}"/></th>
            <th><c:out value="${Batch.syear}"/>年</th>
            <th><c:out value="${Batch.wl}"/></th>
            <th><c:out value="${Batch.batch}"/></th>
            <th><c:out value="${Batch.MINscore}"/></th>
          </tr>
          </tbody>
        </c:forEach>
      </table>
    </div>
    <div class="tab-pane" id="messages">
      <h5>2018北京理科控档线</h5>
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
        <c:forEach var="Batch" items="${BJBatchs}">
          <tbody>
          <tr>
            <th><c:out value="${Batch.local}"/></th>
            <th><c:out value="${Batch.syear}"/>年</th>
            <th><c:out value="${Batch.wl}"/></th>
            <th><c:out value="${Batch.batch}"/></th>
            <th><c:out value="${Batch.MINscore}"/></th>
          </tr>
          </tbody>
        </c:forEach>
      </table>
    </div>
  </div>
  <a class="btn btn-default" href="province.html?localAreaID=3&provinces=guizhou" role="button">更多<span class="glyphicon glyphicon-menu-right"
                                                                        aria-hidden="true"></span></a>
  <hr />
</div>
<!-- 专业栏 -->
<div class="container a_div">
  <h3 class="textAlert">计算机小类专业库</h3>
  <table class="table table-hover">
    <thead>
    <tr>
      <th>专业大类</th>
      <th>专业小类</th>
      <th>专业名称</th>
      <th>专业介绍</th>
    </tr>
    </thead>
    <c:forEach var="career" items="${computersCareers}">
      <tbody>
      <tr>
        <th><c:out value="${career.level2_name}"/></th>
        <th><c:out value="${career.level3_name}"/></th>
        <th><c:out value="${career.name}"/></th>
        <th><a href="career.html?careerId=${career.special_id}">专业详情&nbsp;<samp class="glyphicon glyphicon-search" aria-hidden="true" /></a></th>
      </tr>
      </tbody>
    </c:forEach>

  </table>
  <a class="btn btn-default" href="careers.html?major_1=1" role="button">更多<span class="glyphicon glyphicon-menu-right"
                                                                      aria-hidden="true"></span></a>
  <hr />
</div>
<div class="container summary-container " style="border-style: dashed;">
  <h3>开发人员</h3>
  <br />

  <div class="row">
    <div class="col-md-12" >
      <img class="img-circle imageName" src="images/a.jpg" />
      <h1>邵涯语</h1>
      <p>感谢每一位身边的朋友和老师们的支持和帮助，也感谢铜仁大数据平台的数据</p>
      <p>提示:关于每一所学校的录取分数线，在每一个学校的官网会有。哪里数据比较精确</p>
      <p style="margin-bottom: 20px;">高考数据库开发,数据来源于网络统计，可能会有误差，仅供参考</p>
      <p style="margin-bottom: 20px;">做自己想做的事，初次为人，不留遗憾，加油∧_∧</p>
      <div class="row">
        <div class="col-md-3" >
          <p>邮箱:<span class="text-primary">yayushan@gmail</span></p>
        </div>
        <div class="col-md-3" >
          <p>地址:<span class="text-primary">贵州省铜仁市松桃苗族自治县***</span></p>
        </div>
        <div class="col-md-3" >
          <p>联系方式:<span class="text-primary">***********</span></p>
        </div>
        <div class="col-md-3" >
          <p>CSDN:<span class="text-primary"><a target="_blank" href="https://blog.csdn.net/qq_41590014">项目技术开源部分</a></span></p>
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

