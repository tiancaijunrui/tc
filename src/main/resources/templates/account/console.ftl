<#import "../utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index">
<table class="layui-table"
       lay-filter='accountFilter'
       lay-data="{height: 'full-200', cellMinWidth: 80, page: true, limit:30, url:'/ac/loadAccount.html?sessionId=${sessionId!}',method:'post'}">
    <thead>
    <tr>
        <th lay-data="{field:'corpCode', width:'20%',sort:true}">公司</th>
        <th lay-data="{field:'loginName', width:'20%', sort: true}">登陆名</th>
        <th lay-data="{field:'password', width:'20%', sort: true}">密码</th>
        <th lay-data="{field:'updateTime', width:'20%', sort: true}">修改时间</th>
        <th lay-data="{fixed: 'right', width:'20%', align:'center', toolbar: '#toolBar'}"></th>
    </tr>
    </thead>
</table>
<script type="text/html" id="toolBar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table', 'layer'], function () {
        var $ = layui.jquery, layer = layui.layer, table = layui.table;
        //监听工具条
        table.on('tool(accountFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.open({
                    type: 1
                    , title: "222"
                    , area: ['390px', '260px']
                    , shade: 0
                    , maxmin: true
                    , offset: [
                        Math.random() * ($(window).height() - 300)
                        , Math.random() * ($(window).width() - 390)
                    ]
                    , content: 'http://layer.layui.com/test/settop.html'
                    , btn: ['继续弹出', '全部关闭'] //只是为了演示
                    , yes: function () {
                        $(that).click();
                    }
                    , btn2: function () {
                        layer.closeAll();
                    }

                    , zIndex: layer.zIndex //重点1
                    , success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });
//                layer.msg('ID：'+ data.loginName + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                var domId ="edit_" + data.accountId;
                layer.open({
                    type: 2
                    , id: domId
                    , title: "编辑"
                    , area: ['600px', '850px']
                    , shade: 0.3
                    , anim: 5
                    , maxmin: true
                    , offset: 'auto'
                    , btn: ['提交', '取消']
                    , yes: function (index, layero) {
                        $("#"+domId).find("form").length
                    }
                    ,btn1 : function (index,layero) {
                        
                    }
                    , content: '/ac/toUpdate.html?sessionId=${sessionId!}&accountId=' + data.accountId
                    , zIndex: layer.zIndex //重点1
                    , success: function (layero) {
                        layer.setTop(layero); //重点2
                    }
                });
//                layer.alert('编辑行：<br>' + JSON.stringify(data))
            }
        });

    });

</script>
</@p.pageFrame>