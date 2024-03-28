package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.QueryParam;

/**
 * 域名注解的使用
 */
@DomainName("http://localhost:8081/query/")
public interface _03_DomainNameApi {


    /*
    	GET http://localhost:8081/query/sayHello?name=xxx
	    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
     */
    @Get("sayHello")
    String sayHello(String name);


    /*
        GET http://localhost:8081/query/sayHello?name=xxx
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
     */
    @Get("sayHello")
    String sayHello1(@QueryParam("name") String user);
}
