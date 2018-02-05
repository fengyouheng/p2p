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
<div align="center">
    <button id="reg" class="btn btn-default">注册信息接单</button>
</div>
<br>
<table class="table table-striped table-bordered table-hover ">

    <thead>
    <tr>
        <td>订单号</td>
        <td>发单时间</td>
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
                <td>${order.departure}</td>
                <td>${order.destination}</td>
                <c:if test="${order.state==0}">
                    <td>
                        <button data-id="${order.id}" class="btn btn-default getOrder">接单</button>
                    </td>
                </c:if>
                <c:if test="${order.state==1}">
                    <td>
                        已被接单
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </c:if>

</table>


<div class="modal fade" id="RegModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">绑定手机</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="regForm" method="post" action="/reg">
                    <div class="form-group">
                        <label for="phoneNumber" class="col-sm-2 control-label">手机号:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"/>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="save">保存</button>
            </div>
        </div>
    </div>
</div>


<script>
    $('.getOrder').click(function () {
        var id = $(this).data('id');
        $.post('/getOrder', {id: id}, function (data) {
            if (data.success) {
                $.messager.popup("接单成功");
                window.location.href = "/success";
            }
        })
    });

    $('#reg').click(function () {
        $('#RegModal').modal('show');
    })


    $('#save').click(function () {
        if (!(/^1[3|4|5|8][0-9]\d{8}$/.test($('#phoneNumber').val()))) {
            $.messager.popup("请输入正确的手机号码");
            return;
        }
        $('#regForm').ajaxSubmit({
            dataType: 'json',
            success: function (data) {
                $.messager.popup(data.msg);
                if (data.success) {
                    $('#RegModal').modal('hide');
                }
            }
        })

    });
</script>

</body>
</html>
