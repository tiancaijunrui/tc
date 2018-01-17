<#import "../utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index" bodySign='false'>
<body>
<div class="layui-container">
    <form class="layui-form" action="update.html" method="post">
        <input type="hidden" name="userId" value="${(user.userId)!}">
        <input type="hidden" name="sessionId" value="${sessionId!}">
        <input type="hidden" name="accountId" value="${(accountId.accountId)!}">
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">*</span>账号</label>
            <div class="layui-input-inline">
                <input type="text" name="loginName" value="${(account.loginName)!}" required lay-verify="required" placeholder="登陆账号"
                       autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">*</span>密码</label>
            <div class="layui-input-inline">
                <input type="text" name="password" value="${(account.password)!}" required lay-verify="pass" placeholder="登录密码"
                       autocomplete="off" class="layui-input layui-input-width-300">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">*</span>公司</label>
            <div class="layui-input-block">
                <select name="corpId" lay-verify="required" lay-search>
                    <option value=""></option>
                    <#if corpCodeList ?? && corpCodeList?size gt 0>
                        <#list corpCodeList as corpCode>
                            <option value="${(corpCode.corpId)!}" <#if (corpCode.corpId) == account.corpId >selected</#if>>${(corpCode.corpCode)!}</option>
                        </#list>
                    </#if>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">绑定手机</label>
            <div class="layui-input-inline">
                <input type="text" name="phone" value="${(account.phone)!}" placeholder="手机号码"
                       autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">绑定邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email" value="${(account.email)!}" placeholder="邮箱" autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题一</label>
            <div class="layui-input-block">
                <textarea name="answerOne"  placeholder="请输入内容" class="layui-textarea">${(account.answerOne)!}</textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题二</label>
            <div class="layui-input-block">
                <textarea name="answerTwo" placeholder="请输入内容" class="layui-textarea">${(account.answerTwo)!}</textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题三</label>
            <div class="layui-input-block">
                <textarea name="answerThree" placeholder="请输入内容" class="layui-textarea">${(account.answerThree)!}</textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题四</label>
            <div class="layui-input-block">
                <textarea name="answerFour" placeholder="请输入内容" class="layui-textarea">${(account.answerFour)!}</textarea>
            </div>
        </div>
    </form>
</div>
</body>
<script>
    layui.use('form', function () {
    });
</script>
<style type="text/css">
    .layui-input-width-300 {
        width: 200%;
    }
</style>
</@p.pageFrame>