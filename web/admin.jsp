<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shaoyayu
  Date: 2019/6/8
  Time: 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!-- 注册 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>公告</title>
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
<nav class="navbar navbar-default navbar-fixed-top navbar-inverse">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html">高考小数据</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class=""><a href="${pageContext.request.contextPath}/index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>&nbsp;首页</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container" style="margin-top: 10%;">
    <h2 class="featurette-heading">公告栏：</h2>
    <p class="lead">
        这个网站是本人结合自己的学习知识技能开发的网站，数据来源于网络，<span style="color: red;">大部分数据主要是针对贵州考生和铜仁地区的用户</span>。请不要再短时间内不停的刷新页面，会被系统被IP地址封掉的。供有需要的学生通告简单的页面，了解到更多的高考信息，
        从不同的省市看到不一样的高考数据，了解自己喜欢的专业，省(市)的高考分数分布情况。功能不是全面，但是页面很简洁。如果你想预算一些数据，可以联系我，邮箱:yayushan@gmail
        <br />
        数据来网络数据统计，可能会有数据误差，请大家填报志愿的时候认真考虑，（友情提示:增强自己的高考防诈骗手段）
        <br />
        <br />
        由于涉及当初没有涉及，网站不接受任何广告投入。本人只是一个学生，技术方面的知识可以讨论。源代码可以可研究学习一起进步。
        <br/>
        <h3>累计访问量：<c:out value="${likeItem}"/></h3>
    </p>
    <!-- Button trigger modal -->
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        为我们点赞
    </button>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                    <h3 class="modal-title" id="myModalLabel">高考小数据</h3>
                </div>
                <div class="modal-body">
                    <h4>大家好：</h4>
                    <h5>首先感谢你们对本程序的支持</h5>
                    <hr>
                    <h4>至给所有用户：</h4>
                    <p>本程序从4月份开始，在网络上收集数据统计信息，建立数据库。数据输入历经一个多月的的数据整理，数据库里面有全国各地进2700多所
                        高校信息，进500多万条高校记录信息，33个省份高考信息，控档分数线，到一分一档的信息达到上千万条数据信息，不完全的专业统计进500多条数据。
                        和其它辅助材料进百万数据。</p>
                    <p>对于一个理工科的人来说，网站的见面设计是我最头痛的一部分，整一个前端页面，我已经从开始的第一版单纯的html+css+JavaScript布局，
                        到后来框架学习，自己一个人设计搭建开始，一直以来我都在简约风来设计的，主要的就是展现数据，没有广告和其他的数据展示。不停的翻新设计，
                        考虑大家可能都是手机用户，我换了4版的网页设计。只为了让大家更好的体验。</p>
                    <p>数据和网页设计只是程序的二分之一的，更得的是程序后台的编写，从简单的数据查找模块到后来的用户模块，近一个月的不停测试和翻新。最后把数据
                        整理好打包给用户查看，一直都是磕磕碰碰的。最后进自己最大努力用一个多月的时间的完成后台程序的编写。</p>
                    <h3>由于本网站部署在新浪云服务器上，涉及一些费用。希望得到大家的点赞的同时希望能够得到大家最小的支持</h3>
                    <div class="row" style="text-align: center;">
                        <img src="images/a.jpg" alt="支付宝收付款" class="img-thumbnail" style="width: 300px; height: 300px;">
                    </div>
                    <h4>同时也祝愿大家金榜题名，谢谢</h4>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <form action="admin.html" method="post">
                        <input type="hidden" name="like" value="likeTime"/>
                        <button type="submit" class="btn btn-primary">点赞</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

