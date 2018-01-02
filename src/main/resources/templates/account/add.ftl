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
    <form class="layui-form" action="">
        <input type="hidden" name="account.userId = ${(user.userId)!}">
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" name="title" required lay-verify="required" placeholder="登陆账号" autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="password" required lay-verify="required" placeholder="登录密码"
                       autocomplete="off" class="layui-input layui-input-width-300">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司</label>
            <div class="layui-input-block">
                <select name="city" lay-verify="required" lay-search>
                    <option value=""></option>
                    <option value="0">北京</option>
                    <option value="1">上海</option>
                    <option value="2">广州</option>
                    <option value="3">深圳</option>
                    <option value="4">杭州</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">复选框</label>
            <div class="layui-input-block">
                <input type="checkbox" name="like[write]" title="写作">
                <input type="checkbox" name="like[read]" title="阅读" checked>
                <input type="checkbox" name="like[dai]" title="发呆">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">开关</label>
            <div class="layui-input-block">
                <input type="checkbox" name="switch" lay-skin="switch">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男">
                <input type="radio" name="sex" value="女" title="女" checked>
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">文本域</label>
            <div class="layui-input-block">
                <textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<style type="text/css">
    .layui-input-width-300{
        width: 300%;
    }
</style>
<script>
    //Demo
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