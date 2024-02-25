package io.github.lucklike.api;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.PathParam;

/**
 * 发送简单请求
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 23:00
 */
@DomainName("http://localhost:8081/simple/")
public interface SimpleApi {

    /*
        name=Jack
        GET http://localhost:8081/simple/sayHello?name=Jack
     */
    @Get("/sayHello")
    String sayHello(String name);

    /*
        name=Tom
        GET http://localhost:8081/simple/hi/Tom
 */
    @Get("/hi/{name}")
    String hi(@PathParam String name);
}
