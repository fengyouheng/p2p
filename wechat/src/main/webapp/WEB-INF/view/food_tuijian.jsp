
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>丁丁美食推荐</title>
    <script type="text/javascript" src="/js1/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="/js1/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <link rel="stylesheet" href="/js1/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css" />
    <script type="text/javascript">
        wx.config({
            debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: '${appId}', // 必填，公众号的唯一标识
            timestamp: '${timestamp}', // 必填，生成签名的时间戳
            nonceStr: '${nonceStr}', // 必填，生成签名的随机串
            signature: '${signature}',// 必填，签名，见附录1
            jsApiList: [//网络状态接口
                'onMenuShareTimeline',//使用微信内置地图查看地理位置接口
                'onMenuShareAppMessage' ,
                'onMenuShareQQ'//获取地理位置接口
            ] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
        });
        wx.ready(function ()
        {
            wx.onMenuShareTimeline({
                title: '亲们,宝宝发现了一个好地方,点进来开一下吧', // 分享标题
                link: 'http://iinz6k.natappfree.cc/food_tuijian', // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
                imgUrl: '' // 分享图标
            });

            wx.onMenuShareAppMessage({
                title: '亲们,宝宝发现了一个好地方,点进来开一下吧', // 分享标题
                desc: '这是聚集了全广州最多好吃的地方！！！！', // 分享描述
                link: 'http://iinz6k.natappfree.cc/food_tuijian'               // 分享链接,该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
            });


            wx.onMenuShareQQ({
                title: '亲们,宝宝发现了一个好地方,点进来开一下吧', // 分享标题
                desc: '这是聚集了全广州最多好吃的地方！！！！', // 分享描述
                link: 'http://iinz6k.natappfree.cc/food_tuijian' // 分享链接,该链接域名或路径必须与当前页面
            });

        });


    </script>
</head>
<body>

<nav class="navbar navbar-default navbar-static-top navbar-inverse">
    <div class="container" style="color: white ;padding-top: 20px">
        <h1><span>广州美食文化</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <span><a href="http://g6gtsa.natappfree.cc/what"><span style="color: white ">想不到吃什麽??</span></a></span>
        </h1>
        我的名字 &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-up "> &nbsp; ${nickname}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        我的老家 &nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-road">  &nbsp;&nbsp; ${city}</span>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

        我的頭像 &nbsp;<img src="${headimgurl}" alt="頭像" width="35px">
    </div>
</nav>
<iframe src="https://mp.weixin.qq.com/mp/homepage?__biz=MzI2MDEwNTY3MA==&hid=1&sn=79b771ec0ad3a572c05b446434e9daa1&uin=&key=&devicetype=Windows+8&version=62040549&lang=zh_CN&winzoom=1&scene=18" width="100%" height="80%"></iframe>
<nav class="navbar navbar-default navbar-static-top navbar-inverse">

    <br/>
    <br/> <br/>

    <div class="container" style="color: white ;padding-top: 20px">
        <span >在线咨询</span>
        &nbsp;&nbsp;&nbsp;
        <span>关于我们</span>
        &nbsp;&nbsp;&nbsp;
        <span>招商热线</span>
        &nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
        <span>在丁丁,带你玩转广州</span>
    </div>
    <br/>
    <br/><br/>
   <br/><br/><br/>
</nav>

</body>
</html>
