<#macro pageFrame isAjax='true' bodySign='true' title="tc">
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>${title!"tc"}</title>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <script src="/other/jquery-3.2.1.min.js"></script>
    <script src="/layui/layui.js"></script>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
</head>
<#if bodySign == 'true'>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <a href="/index/myConsole/${(user.userId)!}.html?sessionId=${sessionId!}" target="_self"><div class="layui-logo">控制台</div></a>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${(user.avatar)!}" class="layui-nav-img">
                ${(user.nickName)!}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="/login/loginOut/${sessionId!}.html">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">账号管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/index/myConsole/${(user.userId)!}.html?sessionId=${sessionId!}" target="_self">查询</a></dd>
                        <dd><a href="/ac/toAdd.html?sessionId=${sessionId!}" target="_self">添加账号</a></dd>
                        <dd><a href="/corp/toAdd.html?sessionId=${sessionId!}">添加公司</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;"><#nested></div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © junrui.online
    </div>
</div>

<script>
    layui.use('element', function () {
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function (elem) {
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>

</body>
<#else>
    <#nested>
</#if>
</html>
</#macro>