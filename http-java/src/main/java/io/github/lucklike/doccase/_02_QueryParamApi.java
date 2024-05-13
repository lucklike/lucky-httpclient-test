package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.QueryParam;

/**
 * Query参数的使用
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 13:27
 */
@DomainName
public interface _02_QueryParamApi {

    /*
    	GET http://localhost:8081/query/sayHello?name=xxx
	    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
     */
    @Get("http://localhost:8081/query/sayHello")
    String sayHello(@QueryParam String name);


    /*
        GET http://localhost:8081/query/sayHello?name=xxx
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
     */
    @Get("http://localhost:8081/query/sayHello")
    String sayHello1(@QueryParam("name") String user);

}
