package io.github.lucklike.testcase.api;

import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.annotations.ArgHandle;
import com.luckyframework.httpclient.proxy.annotations.AutoRedirect;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.RefParam;
import com.luckyframework.httpclient.proxy.annotations.StaticFormBody;
import com.luckyframework.httpclient.proxy.annotations.StaticRef;
import com.luckyframework.httpclient.proxy.annotations.StaticUserInfo;
import com.luckyframework.httpclient.proxy.annotations.UseProxy;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public interface TestAPI {


    @Get("http://www.baidu.com")
    @UseProxy(type = Proxy.Type.SOCKS, ip = "118.25.42.139", port = "8882", username = "marry", password = "pass123")
    Future<String> test();

    @StaticFormBody("#{name1}&#{name2}")
    @ArgHandle("#{_name_}:#{_value_}:#{_type_.toString()}")
    @Get("http://www.baidu.com")
    void test1(String name1, Integer name2);

    @Get("http://www.baidu.com?#{$this$.getArrayStr('array', array)}")
    void test2(String[] array);

    @Get("http://www.baidu.com")
    @StaticRef("uc=UC浏览器&query=#{p0}")
    @RefParam(prefix = "&")
    void test3(String query, String ref2);

    @AutoRedirect(maxCount = 10)
    @StaticUserInfo("#{#URL_ENCODE('fukang1163@cairh.com:fk@0911!')}")
    @Get("https://glakh.cpetest.cairenhui.com/cpe-view-main-backend/")
    String test4(@RefParam String ref);

    default String getArrayStr(String prefix, String[] array) {
        List<String> elementList = new ArrayList<>();
        int i = 0;
        for (String srt : array) {
            elementList.add(StringUtils.format("{}[{}]={}", prefix, i++, srt));
        }
        return StringUtils.join(elementList, "&");
    }

}
