<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body background="/image/303405-106.jpg">
<br>
<br>
<table>
    <tr>
        <p>
        <td><font size="8" style="margin-left: 150px;color: white">你这次模仿的是</font></td>
        </p>
        <p>
        <td><font size="8" style="margin-left: 150px;color: orange">${person}</font></td>
        </p>
    </tr>
    <br>
    <br>
    <br>
    <tr>
        <td><font size="8" style="margin-left: 150px;color: white">相似度得分</font></td>
        <td><font size="8" id="font" style="margin-left: 150px;color: orange"></font><br></td>
    </tr>
</table>
<form style="text-align: center">
    <font size="8" style="margin-left: 50px;color: white">恭喜,你的得分</font><br>
    <font size="8" style="margin-left: 50px;color: white">超过了全国 </font>
    <font size="8" id="num" style="margin-left: 50px;color: white"></font>
    <font size="8" style="margin-left: 50px;color: white">的玩家 </font>
    <br><a href="${indexUrl}/good" style="color: orange;margin-left: 50px;font-size: 50px">点击查看全区排行榜</a>
    <br>
    <p><font size="8" style="margin-left: 50px;color: white">以下是你的模仿,分享给好友一起玩玩吧</font></p>
    <c:forEach items="${list}" var="item">
        <tr>
            <td><span style="font-size: 80px">${item.personName}</span></td>
        </tr>
    </c:forEach>
</form>
<script>
    random();
    function random() {
        var font = Math.floor(Math.random() * 40 + 60);
        $('#font').text(font);
        if (font == 100) {
            $('#num').text('100%');
        }
        if (font > 90 && font < 100) {
            $('#num').text('91%');
        }
        if (font > 70 && font <= 90) {
            $('#num').text('68%');
        }
        if (font > 60 && font <= 70) {
            $('#num').text('54%');
        }
    }
</script>
</body>
</html>