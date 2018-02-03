<#import "utils/formWorkTemplate.ftl" as p>
<@p.pageFrame title="index">
<h1>Error Handler</h1>
<div >${url!}</div>
<div>${(exception.message)!}</div>
</@p.pageFrame>