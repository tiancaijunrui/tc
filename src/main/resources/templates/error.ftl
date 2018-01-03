<#import "utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index">
<script>window.open("myConsole/${(user.userId)!}.html?sessionId=${sessionId!}","_self")</script>
</@p.pageFrame>