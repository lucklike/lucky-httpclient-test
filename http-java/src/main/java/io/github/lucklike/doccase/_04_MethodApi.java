package io.github.lucklike.doccase;

import com.luckyframework.httpclient.core.RequestMethod;
import com.luckyframework.httpclient.proxy.annotations.Connect;
import com.luckyframework.httpclient.proxy.annotations.Delete;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.Head;
import com.luckyframework.httpclient.proxy.annotations.HttpRequest;
import com.luckyframework.httpclient.proxy.annotations.MethodParam;
import com.luckyframework.httpclient.proxy.annotations.Options;
import com.luckyframework.httpclient.proxy.annotations.Patch;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.Put;
import com.luckyframework.httpclient.proxy.annotations.Trace;

/**
 * HTTP方法测试
 */
@DomainName("http://localhost:8081/method/")
public interface _04_MethodApi {

    /*
        GET http://localhost:8081/method/current
	    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
     */
    @Get("current")
    String test1();

    /*
        POST http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Post("current")
    String test2();

    /*
        PUT http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Put("current")
    String test3();

    /*
        DELETE http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Delete("current")
    String test4();

    /*
        HEAD http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Head("current")
    String test5();

    /*
        OPTIONS http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Options("current")
    String test6();

    /*
        CONNECT http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Connect("current")
    String test7();

    /*
        TRACE http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Trace("current")
    String test8();

    /*
        PATCH http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @Patch("current")
    String test9();

    /*
        XXX http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @HttpRequest("current")
    String test10(@MethodParam RequestMethod method);

    /*
        XXX http://localhost:8081/method/current
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    */
    @HttpRequest("current")
    String test11(@MethodParam String method);
}
