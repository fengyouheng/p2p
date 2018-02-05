<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <title></title>
</head>
<body>
<div style="position:absolute;z-index:-1;width:98%;height:98%;">
    <img src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2953033256,169502064&fm=27&gp=0.jpg"
         width="100%" height="100%"/>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<select id="select" style="width: 300px;font-size: 30px">
    <option value="bzhw">
        不知火舞
    </option>
    <option value="aql">
        安琪拉
    </option>
    <option value="dj">
        妲己
    </option>
    <option value="wzj">
        王昭君
    </option>
</select>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="start"><h1>开始录音</h1>
</button>
&nbsp;&nbsp;&nbsp;<button class="stop"><h1>停止录音</h1></button>
&nbsp;&nbsp;&nbsp;
<button class="play"><h1>播放</h1></button>
&nbsp;&nbsp;&nbsp;
<button class="upload"><h1>上传评分</h1></button>
<script>
    wx.config({
        debug: false,//开启调试模式
        appId: '${appId}',
        timestamp: '${timestamp}',
        nonceStr: '${nonceStr}',
        signature: '${signature}',
        jsApiList: [
            // 所有要调用的 API 都要加到这个列表中
            'onMenuShareAppMessage',
            'startRecord',
            'stopRecord',
            'playVoice',
            'translateVoice',
            'uploadVoice'
        ]
    });
    wx.ready(function () {
        var start = document.querySelector(".start");
        var stop = document.querySelector(".stop");
        var play = document.querySelector(".play");
        var upload = document.querySelector(".upload");
        var localId = null;//用于记录录音ID
        var serverId = null;
        start.onclick = function () {
            alert("开始录音");
            wx.startRecord();
        };
        stop.onclick = function () {
            wx.stopRecord({
                success: function (res) {
                    localId = res.localId;
                }
            });
        };
        play.onclick = function () {
            wx.playVoice({
                localId: localId // 需要播放的音频的本地ID，由stopRecord接口获得
            });
        };

        upload.onclick = function () {
            if (!localId) {
                alert("骚年,不录音我怎么给你评分啊");
                return;
            }
            var select = $('#select option:selected').text();
            wx.uploadVoice({
                localId: localId, // 需要上传的音频的本地ID，由stopRecord接口获得
                isShowProgressTips: 1, // 默认为1，显示进度提示
                success: function (res) {
                    serverId = res.serverId; // 返回音频的服务器端ID
                    window.location.href = "${indexUrl}/result?localId=" + localId + "&personName=" + select;
                }
            });

        };

        // 在这里调用 API
        wx.onMenuShareAppMessage({
            title: '来聆听我的美妙的呻吟吧', // 分享标题
            desc: '与王者英雄一起吟唱', // 分享描述
            link: 'http://baidu.com', // 分享链接
            imgUrl: 'https://gss1.bdstatic.com/-vo3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=8fa6745028738bd4c421b53799b0e0eb/3b292df5e0fe9925e92362dd32a85edf8db1710b.jpg', // 分享图标
            type: '', // 分享类型,music、video或link，不填默认为link
            dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
            success: function () {
                // 用户确认分享后执行的回调函数
                alert("分享成功")
            },
            cancel: function () {
                // 用户取消分享后执行的回调函数
                alert("取消分享")
            }
        });
    });
</script>
</body>
</html>