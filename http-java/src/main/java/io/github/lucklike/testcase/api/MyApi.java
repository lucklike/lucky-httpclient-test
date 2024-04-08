package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.AutoRedirect;
import com.luckyframework.httpclient.proxy.annotations.BrotliCompress;
import com.luckyframework.httpclient.proxy.annotations.BrowserFeign;
import com.luckyframework.httpclient.proxy.annotations.ContentCompress;
import com.luckyframework.httpclient.proxy.annotations.DeflateCompress;
import com.luckyframework.httpclient.proxy.annotations.GzipCompress;
import com.luckyframework.httpclient.proxy.annotations.HttpRequest;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.ZstdCompress;

import java.util.concurrent.Future;

import static com.luckyframework.httpclient.core.RequestMethod.GET;


/**
 * 请求百度首页
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 15:45
 */
@AutoRedirect
@BrowserFeign
public interface MyApi {

    /*
    	GET http://www.baidu.com
	    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
     */

    @HttpRequest(url = "http://www.bilibili.com/", method = GET)
    Future<String> index();

    /*
        GET http://localhost:8081/simple/sayHello?name=Lucky
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Accept: text/plain
     */

    @StaticHeader({"Accept=text/plain"})
    @HttpRequest(
            url = "http://localhost:8081/simple/sayHello",
            method = GET
    )
    String sendRequest(String name);

}
