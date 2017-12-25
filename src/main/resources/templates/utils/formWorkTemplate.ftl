<#macro pageFrame isAjax='true' bodySign='true' title="tc">
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>${title!"tc"}</title>
    <meta charset="utf-8">
    <script src="/other/jquery-3.2.1.min.js"></script>
    <script src="/layui/layui.js"></script>
    <style rel="stylesheet" href="/layui/css/layui.css"></style>
</head>
<body>
    <#nested>
</body>
</html>
</#macro>