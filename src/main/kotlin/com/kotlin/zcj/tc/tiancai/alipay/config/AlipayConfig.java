package com.kotlin.zcj.tc.tiancai.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088802540108624";
	// 商户的私钥
	public static String key = "eawfver0y8lb0iwu214vlzxj1w23jfvc";
	public static String aesKey = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCDiBjbkA1iX86cRxjIg4BCZ0tdaBRjfDnqMwmpEaFZ/XOVGuXlYY1Ckxe8i31BKLjLv7dlKmmUrw0kolxl9tQNgI4rAz65HIkp+69HUN40rTRIi5z04dJITm2FJyCFDsK9Fm4HOxUHTS8CUF3ecBtHN7yYxGCieWJdglhwHxzb7crxYV8kcai3UpvxCOxYqwPT2OlO8W3XAu1G6Td09LvB0BigywDieK7aUWZsM8bMdzpx3q2nhYkr3k/0DLoIFzoQSKS57IbhDyE0ym+KgH/PHiDycl9Tx/kMPV3RZrbnc49ZhJ9jee7bVTWz3wAGTBZ5XNvujrtxaa8iYjbdqClLAgMBAAECggEBAIDUBnTXLSTTbgyHXnDWzAM+JQUB8iZXAGqxPp8IE5+OrWy3gcEfwToZ1D/p5+6wMf/ucXR3DB6DLj5ZgGKmVaA78AOVFBQ/LOGgEFerj1jM5M7BYCRCIrKLjp3CawmoIXkOxQn0Bm62XHrJuIcsCqvAncqLXZMFjSDFkFWRQ7TsVWk8T5t70+jr7ZkGK3+Fdr/79O7/nwQ1ch9TkxsKihDtmmPw25+WECMVpMV5scQSSkh+ln9NTg9Sj4vOd5gfstxEgPhOYclkf6rLG5yH67wI4IH3qgf9BQmp1OOrfQmx5NgJrCOGfRMcaGAjOWDpK9tbrWU3XduvjTNpDtDcDoECgYEAxMajjDkSVt/mRPXbTFtZQoiNtrg3ntU4r37Iv+mHJGWFaE5BMG/lVSmGmu5ip8QhZth7bcareOS31v+Nz/6qnOHpmCfiz2SyRG8kChGrC6w8Gpumn1OCVKQl2HOIWiM2bWvC+Ywnh6ZWDsVvq9e+zRrqoDNkBJDjX5Ux3bxHbuECgYEAqx51he7L40dbBWdOX6dc2VpXnPL+YYhdWOf4MVvJdUWXq8MD8wwMmXj/qZqFlJzIRwFjMJJ8OYdpu7s5ySwJTgxWv7EDOUDh1uFhbGu7Buy2mXmQYduh8rUZi3RgU2G2Kb7s5xcxmiU4uioC+PK6MLIxBBOnMk5w0apXXg9hOasCgYAfUPWqVVLj3JJLG02hY1BbVFwpXjwL3Sc+VtEgKcxGMJoAtaOOT+CRoyA2/AVbac1fDsjl+Z5EiTHw1478MS159kI04vQnyYDNf1qe95zfKLQQEAF+jc3KJq2XOxvSLJR26ZWIHZQU9JXxl95j3NwSzFvWzxb12xE0nwvmnBZKQQKBgQCp9FefTVx9gMp7ZG5n/K7wRZVNEd7reefUvJg6VcKSUitg8hEDHY2KBK5QgmN4Bfu44jzk6iitbrvqM/shvjYDqaejPilIfRORO0pqx9j6+LInXqCzQNPpXktfwZdGWX72mWVr5BJk2eEsrTtEjLe2U9TxCp/+DABrjXa2uinDfwKBgQCcjMNY3LqBJxMyfaq0TRX9a3qOAsYI+o5K/aq2hxtJUNBj69dH9MyMw6LjSiFYuHvodaKpXFvjPJLjC5SvHSHWu8wWwAtjW4x4xo16LcM2PTCOsffHyPhyXgTPtg0AF+Tl3Bwxp56sCqgkE9CMeeuYutRnhM2H5J8h94+1NbeJEA==";

	public static String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg9Puo9ToNeaAF7PPcSr3U94Csq3CN7yFkgRWqQBlqmHk4etSWn3Z1q4tlmtYtV69ctMBr0NVsZTyu/wRFv/FKHaJ2UjNSuMsSWfyaa0NIcUlxUdQsvkGFKRPoAHFLe5etAbNbtVN6oJk11JhirgUiN+5Ja2bryOCqePbiXvuz96auS7bnT/+p0p/Gez4eZ+SWaFAkVyo0irGVUQ3xIvvch2IWFS99vHNh9JNuFprNBaSdqBRjSHkIw3ghGy9P2p19QTJBmq6c37jhUy23iiaUBQO0O8JyMW4eYJRlijLxP6cs8OweWY4wQ+rr7z8HePi3fD8g2cMjHexyY+CbOEZ5wIDAQAB";

	public static String appId = "2017051507241359";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "D:\\aliLog";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "MD5";

}
