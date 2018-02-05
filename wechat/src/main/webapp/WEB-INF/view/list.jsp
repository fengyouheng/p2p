<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>周边美食</title>

    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
    <style type="text/css">
        /*a:link：未访问链接 */
        a:link {
            color: #000008;
            text-decoration:none;
        }

        /*a:visited：已访问链接*/
        a:visited {
            color: #000005;
            text-decoration:none;
        }

        /*a:active：激活时（链接获得焦点时）链接的颜色*/
        a:active {
            color: #000005;
            text-decoration:none;
        }

        /*a:hover：鼠标移到链接上时*/
        a:hover {
            color: #000005;
            text-decoration:none;
        }
    </style>
    <script type="text/javascript">
        var jing;
        var wei;
        wx.config({
            debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: '${appId}', // 必填，公众号的唯一标识
            timestamp: '${timestamp}', // 必填，生成签名的时间戳
            nonceStr: '${nonceStr}', // 必填，生成签名的随机串
            signature: '${signature}',// 必填，签名，见附录1
            jsApiList: [//网络状态接口
                'openLocation',//使用微信内置地图查看地理位置接口
                'getLocation' //获取地理位置接口
            ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });
        wx.ready(function () {

            wx.getLocation({
                type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
                success: function (res) {
                    wei = res.latitude; // 纬度，浮点数，范围为90 ~ -90
                    jing = res.longitude; // 经度，浮点数，范围为180 ~ -180。
                    var speed = res.speed; // 速度，以米/每秒计
                    var accuracy = res.accuracy; // 位置精度

                    console.log(wei)
                    console.log(jing)


                }
            });

            wx.openLocation({
                latitude: 113.2312774658,
                longitude: 23.1313622164,
                scale: 14,
                name: '你所在的位置',
                infoUrl: 'http://weixin.qq.com'
            });


        });
        $(".info").click(function () {
            alert()
        });

    </script>

    <style type="text/css">
        body {
            font-family: sans-serif;
            font-size: 26px;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-default navbar-static-top  navbar-inverse">
    <div class="container">
        <h1><span style="color: white">你周边的美食推荐</span></h1> &nbsp;&nbsp;
        <h1><span style="color: white">联系我们</span></h1>&nbsp;&nbsp;
        <h1><span style="color: white">关于丁丁</span></h1>&nbsp;&nbsp;
    </div>
</nav>

<table class="table table-striped table-bordered table-hover table-condensed " style="width: 100%;text-align: center">
    <thread>
        <tr>
            <td><p>店名</p></td>
            <td><p>详细地址</p></td>
            <td><p>区名</p></td>
        </tr>
    </thread>
    <tbody>

    <c:forEach items="${list.data}" var="sv">
        <tr>
            <td><p><a href="${sv.url}">${sv.shopName}</a></p></td>
            <td><p><a href="${sv.url}">${sv.placeName}</a></p></td>
            <td><p><a href="${sv.url}">${sv.areaName}</a></p></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
