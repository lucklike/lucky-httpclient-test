package io.github.lucklike.springboothttp.api;

import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.annotations.ArgHandle;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.spel.FunctionAlias;
import com.luckyframework.httpclient.proxy.spel.SpELVar;
import io.github.lucklike.httpclient.annotation.HttpClient;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

@SpELVar(root= "test=#{$this$.test()}", fun = AddApi.class)
@HttpClient("http://#{$this$.getIp($method$)}")
public interface AddApi {

    AtomicInteger count = new AtomicInteger(0);

    @SpELVar("array=#{#LIST_TO_STRING('q', q)}")
    @Get("${API.java}/data?num=#{$this$.num()}&#{array}")
    String getData(@NotHttpParam List<String> q);

    @Get("/data")
    Future<String> getData1();

    @Get("/user")
    Future<String> getUser();

    default int num() {
        return count.getAndIncrement();
    }

    default String getIp(Method method) {
        System.out.println(method.toGenericString());
        return "getData1".equals(method.getName()) ? "192.168.0.2" : "192.168.0.1";
    }

    default String test() {
        System.out.println("------------test--------------------");
        return "test";
    }

    @FunctionAlias("LIST_TO_STRING")
    static String listToString(String prefix, List<String> list) {
        List<String> elementList = new ArrayList<>();
        int i = 0;
        for (String srt : list) {
            elementList.add(StringUtils.format("{}[{}]={}", prefix, i++, srt));
        }
        return StringUtils.join(elementList, "&");
    }

}
