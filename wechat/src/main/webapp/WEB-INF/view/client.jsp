<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工管理</title>
    <%@ include file="common.jsp"%>
    <script>
        $(function () {
            var clientDatagrid = $('#client_datagrid');
            clientDatagrid.datagrid({
                url:'/clientList',
                fit:true,
                fitColumns:true,
                singleSelect:true,
                toolbar:'#client_toolbar',
                pagination:true,
                columns:[[
                    {field:'nickname',title:'昵称',width:1,align:'center'},
                    {field:'openId',title:'账号',width:1,align:'center'},
                    {field:'concernTime',title:'关注时间',width:1,align:'center'},
                    {field:'cancelConcernTime',title:'取关时间',width:1,align:'center'},
                    {field:'status',title:'状态',width:1,align:'center',formatter:function (value,row,index) {
                        return value == 0 ? '<span style="color: #00ee00">已取关</span>' : '<span style="color: #CC2222">已关注</span>';
                    }},
                ]]
            });

        });
    </script>
</head>

<body>
    <div id="client_toolbar">
        <div>
            <input type="text" name="keyword"><a data-cmd="search" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
        </div>
    </div>
    <table id="client_datagrid"></table>
</body>
</html>
