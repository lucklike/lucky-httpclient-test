package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.AutoRedirect;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.PrintLog;
import com.luckyframework.httpclient.proxy.annotations.QueryParam;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;

/**
 * Query参数的使用
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 13:27
 */
@AutoRedirect
@PrintLog(allowBodyMaxLength = 1024)
@StaticHeader("[SET] User-Agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36 Edg/122.0.0.0")
public interface _02_QueryParamApi {

    @Get("https://www.baidu.com/s")
    String baiduQuery(String wd);

    @Get("https://www.baidu.com/s")
    String baiduQuery2(@QueryParam("wd") String keyWord);

}
