<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <script>
        $(function () {
            $('#form').validate({
                rules: {
                    departure: {
                        required: true
                    },
                    destination: {
                        required: true
                    }
                },
                messages: {
                    departure: {
                        required: '请输入出发地'
                    },
                    destination: {
                        required: '请输入目的地'
                    }
                },
                errorClass: 'text-danger',
                highlight: function (element, errorClass) {
                    $(element).closest('.form-group').addClass('has-error')
                },
                unhighlight: function (element, errorClass) {
                    $(element).closest('.form-group').removeClass('has-error').addClass('has-success')
                },
                submitHandler: function (form) {
                    $(form).ajaxSubmit({
                        dataType: 'json',
                        success: function (data) {
                            if (data.success) {
                                $.messager.confirm('温馨提示', data.msg + '点击进入訂單页面', function () {
                                    window.location.href = '/order';
                                });
                            } else {
                                $.post('/checkState', function (re) {
                                    $.messager.popup(re.msg);
                                    if (!re.success) {
                                        $('#bindPhoneModal').modal('show');
                                    }
                                }, 'json');
                            }
                        }
                    })
                }
            })


            $('#sendVerifyCode').click(function () {

                if (!(/^1[3|4|5|8][0-9]\d{8}$/.test($('#phoneNumber').val()))) {
                    $.messager.popup("请输入正确的手机号码");
                    return;
                }

                $('#phoneNumber').val()
                var thisObj = $(this);
                thisObj.prop('disabled', true)
                $.ajax({
                    url: '/sendVerifyCode',
                    data: {phoneNumber: $('#phoneNumber').val()},
                    dataType: 'json',
                    success: function (data) {
                        $.messager.popup(data.msg);
                        if (data.success) {
                            var count = 5;
                            var timer = setInterval(function () {
                                count--;
                                if (count >= 0) {
                                    thisObj.text(count + "s后重新发送")
                                } else {
                                    thisObj.prop('disabled', false).text('发送验证码');
                                    clearInterval(timer)
                                }
                            }, 1000);
                        } else {
                            thisObj.prop('disabled', false);
                        }
                    }

                })
            })

            $('#bindPhone').click(function () {
                $('#bindPhoneForm').ajaxSubmit({
                    dataType: 'json',
                    success: function (data) {
                        $.messager.popup(data.msg);
                        if (data.success) {
                            $('#bindPhoneModal').modal('hide');
                        }
                    }
                })
            });

            $('#look').click(function () {
                window.location.href = '/order';
            })
            $('#info').click(function () {
                window.location.href = '/info';
            })
        })
    </script>
</head>
<body>
<button id="info" class="btn btn-default">我的信息</button>
<h1 align="center">最快2分钟接单,最慢不接单</h1>
<form id="form" class="form-inline" style="text-align: center" action="/callCar" method="post">
    <div class="form-group">
        <label class="sr-only" for="exampleInputEmail3"></label>
        <input name="departure" type="departure" class="form-control" id="exampleInputEmail3" placeholder="出发地">
    </div>
    <br>
    <br>
    <div class="form-group">
        <label class="sr-only" for="exampleInputPassword3"></label>
        <input name="destination" type="destination" class="form-control" id="exampleInputPassword3"
               placeholder="你要去哪儿">
    </div>
    <br>
    <br>
    <button type="submit" class="btn btn-default">一键叫车</button>
    <button id="look" class="btn btn-default">查看订单</button>
</form>


<div class="modal fade" id="bindPhoneModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">绑定手机</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="bindPhoneForm" method="post" action="/bindPhone">
                    <div class="form-group">
                        <label for="phoneNumber" class="col-sm-2 control-label">手机号:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"/>
                            <button id="sendVerifyCode" class="btn btn-primary" type="button" autocomplate="off">发送验证码
                            </button>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="verifyCode" class="col-sm-2 control-label">验证码:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="verifyCode" name="verifyCode"/>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="bindPhone">保存</button>
            </div>
        </div>
    </div>
</div>
<br>
<div>
    <img src="/image/1.jpg" style="width: 100%;height: 300px;margin-top: -10px">
</div>
</body>
</html>
