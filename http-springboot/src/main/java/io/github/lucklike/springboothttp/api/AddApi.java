package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.spel.SpELVar;
import io.github.lucklike.httpclient.annotation.HttpClient;

import java.lang.reflect.Method;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;


@HttpClient("http://#{$this$.getIp($method$)}")
public interface AddApi {

    AtomicInteger count = new AtomicInteger(0);

    @SpELVar("test=#{$this$.test()}")
    @Get("${API.java}/data?num=#{$this$.num()}")
    String getData();

    @Get("/data")
    Future<String> getData1();

    @Get("/user")
    Future<String> getUser();

    default int num() {
        return count.getAndIncrement();
    }

    default String getIp(Method method) {
        return "getData1".equals(method.getName()) ? "192.168.0.2" : "192.168.0.1";
    }

    default String test() {
        System.out.println("------------test--------------------");
        return "test";
    }

}
