package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.HttpRequest;
import com.luckyframework.httpclient.proxy.annotations.PrintRequestLog;

import static com.luckyframework.httpclient.core.RequestMethod.GET;

/**
 * hello world
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 13:12
 */
@PrintRequestLog
public interface _01_HelloWorldApi {

    /*
    	GET http://www.baidu.com
	    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301);
     */
    @HttpRequest(url = "http://www.baidu.com", method = GET)
    String baidu();

    /*
        GET http://www.baidu.com
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301);
    */
    @Get("http://www.baidu.com")
    String baidu2();

}
