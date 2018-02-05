<%--
  Created by IntelliJ IDEA.
  User: cgs
  Date: 2018/2/2
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/jquery-easyui/themes/icon.css">
    <script type="text/javascript" src="/static/jquery-easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/jquery-easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.js"></script>

    <script type="text/javascript">
        $(function () {
            $("#btn").click(function () {
                $("#form").ajaxSubmit({
                    dataType:"json",
                    url:"/menuSave",
                    success: function (data) {
                        $.messager.alert("温馨提示",data.msg,"info");
                        if(data.success){
                            //如果是成功就刷新一下微信的菜单界面
                            window.location.href="http://2xqgaa.natappfree.cc/menu";
                            window.location.href="http://localhost:8888/systemManager";
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<div style="align-items: center;">

    <form id="form" method="post">
        <p>
            父级菜单:
            <select id="firstMenu" name="parentId">
                <option value="-1">请选择根菜单</option>
                <option value="1">游玩广州</option>
                <option value="2">美食推荐</option>
                <option value="3">丁丁叫车</option>
            </select>
        </p>
        <P>
            菜单名称:
            <input type="text" id="secondMenu" name="name">
        </P>

        <P>
            &nbsp;&nbsp;显&nbsp;&nbsp;示:&nbsp;&nbsp;
            <select id="isView" name="view">
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
        </P>

        <P>
            &nbsp;&nbsp;排&nbsp;&nbsp;序:&nbsp;&nbsp;
            <input id="order" value="-1" name="order">
        </P>

        <P>
            要连接到的URL地址:
            <input id="url" name="url">
        </P>
        <input type="button" id="btn" value="提交">
    </form>
</div>
</body>
</html>
