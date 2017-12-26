<#import "utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index">
<section>
    <h4>hello world!~~</h4>
    <h4>${user.userId}</h4>
    <h4>${user.aliUserId}</h4>
    <h4>${user.avatar}</h4>
    <h4>${user.nickName}</h4>
    <input type="button" name="test" value="ceshi" onclick="window.open('test.html?sessionId=${sessionId!}','_self')"/>
</section>
</@p.pageFrame>