<#import "../utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index">
<div class="layui-container">
    <form class="layui-form" action="add.html?sessionId=${sessionId!}" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label"><span style="color: red">*</span>账号</label>
            <div class="layui-input-inline">
                <input type="text" name="corpCode" required lay-verify="required" placeholder="公司名称"
                       autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">公司网址</label>
            <div class="layui-input-inline">
                <input type="text" name="link" required lay-verify="required" placeholder="公司网址"
                       autocomplete="off"
                       class="layui-input layui-input-width-300">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">公司介绍</label>
            <div class="layui-input-block">
                <textarea name="introduce" placeholder="请输入内容" class="layui-textarea"></textarea>
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
    layui.use(['form'], function () {
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            layer.msg(JSON.stringify(data.field));
            return false;
        });
    });
</script>
</@p.pageFrame>