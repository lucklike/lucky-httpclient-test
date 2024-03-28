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

    @Get("current")
    String test1();

    @Post("current")
    String test2();

    @Put("current")
    String test3();

    @Delete("current")
    String test4();

    @Head("current")
    String test5();

    @Options("current")
    String test6();

    @Connect("current")
    String test7();

    @Trace("current")
    String test8();

    @Patch("current")
    String test9();

    @HttpRequest("current")
    String test10(@MethodParam RequestMethod method);

    @HttpRequest("current")
    String test11(@MethodParam String method);
}
