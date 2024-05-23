package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.AutoRedirect;
import com.luckyframework.httpclient.proxy.annotations.BrowserFeign;
import com.luckyframework.httpclient.proxy.annotations.DownloadToLocal;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.QueryParam;
import com.luckyframework.httpclient.proxy.annotations.RespSelect;
import com.luckyframework.httpclient.proxy.annotations.Retryable;
import com.luckyframework.httpclient.proxy.annotations.Url;
import io.github.lucklike.httpclient.annotation.HttpClient;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;

/**
 * https://api.aa1.cn/
 */
@BrowserFeign
@HttpClient("https://v.api.aa1.cn/")
public interface XiaRouApi {

    @RespSelect("#{$body$.data.values()}")
    @Get("api/api-web-img/index.php?type=list")
    Set<String> getWebImage(@QueryParam String url);

    @Get
    @DownloadToLocal("D:/web/images/")
    boolean saveWebImage(@Url String url);


    @Retryable(retryCount = 10, waitMillis = 5000, normalStatus = 200)
    @RespSelect("#{$body$.data.![{'utag':utag, 'img_1600_900':img_1600_900}]}")
    @Get("https://v.api.aa1.cn/api/api-meiribizhi/api.php")
    List<Map<String, Object>> meiribizhi();

    @DownloadToLocal(saveDir = "D:/web/bizhi/", filename = "#{p0.utag}")
    @Get("#{p0.img_1600_900}")
    Future<File> saveBiZhi(Map<String, Object> biZhiInfo);

    @DownloadToLocal(saveDir = "D:/web/bizhi/", filename = "#{p0.utag}")
    @Get("#{p0.img_1600_900}")
    File saveBiZhi2(Map<String, Object> biZhiInfo);


    @DownloadToLocal("D:/web/qingtou/#{(p0-1) / 2}")
    @Get("https://www.hhlqilongzhu.cn/api/tu_qingtou_result.php")
    File qingTou(@QueryParam Integer imageid);
}
