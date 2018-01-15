<#import "../utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index">
<table class="layui-table" lay-data="{height: 'full-200', cellMinWidth: 80, page: true, limit:30, url:'/ac/loadAccount.html',method:'post'}">
    <thead>
    <tr>
        <th lay-data="{field:'corpCode', width:'20%',sort:true}">公司</th>
        <th lay-data="{field:'loginName', width:'20%', sort: true}">登陆名</th>
        <th lay-data="{field:'password', width:'20%', sort: true}">密码</th>
        <th lay-data="{field:'updateTime', width:'20%', sort: true}">修改时间</th>
        <th lay-data="{fixed: 'right', width:'20%', align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>
<script>
    layui.use('table', function(){
        var table = layui.table;
    });
    <#--$.post('/ac/loadAccount.html?sessionId=${sessionId!}',function () {-->
        <#--debugger;-->
    <#--});-->

    <#--$.ajax({-->
        <#--type: "POST",-->
        <#--contentType: "application/json",-->
        <#--url: "/ac/loadAccount.html",-->
        <#--data: {sessionId:'${sessionId!}'},-->
        <#--dataType: 'json',-->
        <#--cache: false,-->
        <#--timeout: 600000,-->
        <#--success: function (data) {-->
            <#--debugger-->
        <#--},-->
        <#--error: function (e) {-->
            <#--debugger;-->
        <#--}-->
    <#--});-->
</script>
</@p.pageFrame>