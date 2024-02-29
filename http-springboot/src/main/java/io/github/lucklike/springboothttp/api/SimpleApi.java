package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.IgnoreVerifySSL;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import io.github.lucklike.httpclient.annotation.HttpClient;

import java.util.concurrent.Future;

@IgnoreVerifySSL
@HttpClient("${API.simple}")
public interface SimpleApi {

    @Get("/sayHello")
    Future<String> sayHello(String name);

    @Get("/hi/{name}")
    String hi(@PathParam String name);
}