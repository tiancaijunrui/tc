<#macro pageFrame isAjax='true' bodySign='true' title="tc">
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <title>${title!"tc"}</title>
    <meta charset="utf-8">
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.js"></script>
    <style rel="stylesheet" href="/css/bootstrap.css"></style>
</head>
<body>
    <#nested>
</body>
</html>
</#macro>