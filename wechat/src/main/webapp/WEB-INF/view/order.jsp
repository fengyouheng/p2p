<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/js/bootstrap-3.3.2-dist/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="/css/core.css" type="text/css"/>
    <script type="text/javascript" src="/js/jquery/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="/js/bootstrap-3.3.2-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery-validation/jquery.validate.js"></script>
    <script type="text/javascript" src="/js/plugins/jquery.form.js"></script>
    <script type="text/javascript" src="/js/jquery.bootstrap.min.js"></script>
</head>
<body>

<table class="table table-striped table-bordered table-hover ">

    <thead>
    <tr>
        <td>订单号</td>
        <td>发单时间</td>
        <td>接单时间</td>
        <td>接单人</td>
        <td>出发地</td>
        <td>目的地</td>
        <td>状态</td>
    </tr>
    </thead>
    <c:if test="${orders==null}">
        <tr>
            <td colspan="7" align="center"> 暂无订单信息</td>
        </tr>
    </c:if>
    <c:if test="${orders!=null}">
        <tbody>
        <c:forEach items="${orders}" var="order">
            <tr class="active">
                <td>${order.id}</td>
                <td>${order.beginDate}</td>
                <td>${order.endDate}</td>
                <td>${order.orderUserId}</td>
                <td>${order.departure}</td>
                <td>${order.destination}</td>
                <td>${order.stateDisplay}</td>
            </tr>
        </c:forEach>
        </tbody>
    </c:if>

</body>
</html>
