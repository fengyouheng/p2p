<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前的位置</title>
    <script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="/jquery/jquery-2.1.3.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<%--<input type="button" value="checkJSAPI" id="checkJsApi"><br>

<span class="desc" style="color: red">地理位置接口-使用微信内置地图查看位置接口</span><br>
<button class="btn btn_primary" id="openLocation">openLocation</button>
<br>
<span class="desc" style="color: red">地理位置接口-获取地理位置接口</span><br>
<button class="btn btn_primary" id="getLocation">getLocation</button>
<br>--%>
<script type="text/javascript">
    var  jing;
    var  wei;
    wx.config({
        debug: false , // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
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


               wx.openLocation({
                    latitude: wei,
                    longitude: jing,
                    scale: 14,
                    name: '你所在的位置',
                    infoUrl: 'http://weixin.qq.com'
                });

            }
        });

    });


    $(function(){
        $("#food").click(function(){
            window.location.href='http://g6gtsa.natappfree.cc/list?jing='+jing+'&wei='+wei
        })
    })


</script>
<center>
<img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1517721373055&di=ce8bbb43104645c0471b5162006da49d&imgtype=0&src=http%3A%2F%2Fm.tuniucdn.com%2Ffb2%2Ft1%2FG2%2FM00%2F27%2F3D%2FCii-TleisCKIbiySACbUAYHlJhIAAAv-ACgHOMAJtQZ946_w0_h600_c0_t0.jpg" width="100%"/>
</center>
<br><br><br><br>
<center>
<button id="food" class="btn btn-success" style="width:60%;" >查看周边美食</button></center>
<br><br><br><br>
<iframe src="http://desk.zol.com.cn/showpic/1366x768_75807_350.html" width="100%" height="700"></iframe>





</body>
</html>
