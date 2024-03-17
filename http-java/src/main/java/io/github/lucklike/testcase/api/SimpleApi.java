package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.ExceptionReturn;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.IgnoreVerifySSL;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.StaticCookie;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.URLEncoder;

import java.util.concurrent.Future;

/**
 * 发送简单请求
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 23:00
 */
@URLEncoder
@IgnoreVerifySSL
@StaticHeader("X-Auth-Token=efueirguheigh84545y989")
@StaticCookie("SessionID=21432543546567687658")
@ExceptionReturn("出异常了老铁")
@DomainName("https://localhost/simple/")
public interface SimpleApi {

    /*
        name=Jack
        GET http://localhost:8081/simple/sayHello?name=Jack
     */
    @Get("/sayHello")
    Future<String> sayHello(String name);

    /*
        name=Tom
        GET http://localhost:8081/simple/hi/Tom
 */
    @Get("/hi/{name}{kk}")
    @PathParam
    String hi(Object name, Object kk);
}
