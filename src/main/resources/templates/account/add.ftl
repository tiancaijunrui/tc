<#import "../utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index">
<div class="layui-container">
    <div class="layui-carousel" id="test1">
        <div carousel-item>
            <div>条目1</div>
            <div>条目2</div>
            <div>条目3</div>
            <div>条目4</div>
            <div>条目5</div>
        </div>
    </div>
    <br>
    <form class="layui-form" action="add.html?sessionId=${sessionId!}" method="post">
        <input type="hidden" name="userId" value="${(user.userId)!}">
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">*</span>账号</label>
            <div class="layui-input-inline">
                <input type="text" name="loginName" required lay-verify="required" placeholder="登陆账号"
                       autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">*</span>密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="pass" placeholder="登录密码"
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
                            <option value="${(corpCode.corpId)!}">${(corpCode.corpCode)!}</option>
                        </#list>
                    </#if>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">绑定手机</label>
            <div class="layui-input-inline">
                <input type="text" name="phone"  placeholder="手机号码"
                       autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">绑定邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="email"  placeholder="邮箱" autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题一</label>
            <div class="layui-input-block">
                <textarea name="answerOne" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题二</label>
            <div class="layui-input-block">
                <textarea name="answerTwo" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题三</label>
            <div class="layui-input-block">
                <textarea name="answerThree" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">密保问题四</label>
            <div class="layui-input-block">
                <textarea name="answerFour" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit >立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<style type="text/css">
    .layui-input-width-300 {
        width: 300%;
    }
</style>
<script>
    layui.use(['carousel', 'form'], function () {
        var form = layui.form;
        var carousel = layui.carousel;
        //常规轮播
        carousel.render({
            elem: '#test1'
            , width: '100%' //设置容器宽度
            , arrow: 'always'
        });
        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</@p.pageFrame>