package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Branch;
import com.luckyframework.httpclient.proxy.annotations.ConditionalSelection;
import com.luckyframework.httpclient.proxy.annotations.Ex;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.HttpExec;
import com.luckyframework.httpclient.proxy.annotations.MultiFile;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.RespImportIntoSpEL;
import com.luckyframework.httpclient.proxy.annotations.Throws;
import com.luckyframework.io.MultipartFile;
import io.github.lucklike.entity.JarInfo;
import io.github.lucklike.httpclient.annotation.HttpClient;
import io.github.lucklike.resp.Result;

import java.io.InputStream;
import java.util.List;
import java.util.Map;


@HttpClient("${API.file}")
@RespImportIntoSpEL(importBody = false)
public interface FileAPI {

    @HttpExec.http_client
    @Post("upload")
    Result<Map<String, Object>> upload(@MultiFile("files") String[] path);

    @Post("upload")
    Result<List<String>> upload2(@MultiFile("files") String path);

    @Post("upload")
    Result<List<String>> upload3(@MultiFile(name = "files", fileName = "myfile-_index_.jpg") InputStream[] bytes);

    @Get("preview/{fileName}")
    InputStream preview(@PathParam String fileName);

    @Get("http://maven.cairenhui.com/nexus/content/repositories/crh_dev/com/cairh/cpe-common-backend/0.1.17/cpe-common-backend-0.1.17-sources.jar")
    MultipartFile jarDownload();


    @Throws({
        @Ex(assertion = "#{$status$ != 200}", message = "【http-status=#{$status$}】Jar包下载失败：#{jar.toString()}")
    })
    @Get("http://maven.cairenhui.com/nexus/content/repositories/crh_dev/#{#TO_PATH(jar)}")
    MultipartFile jarDownload(@NotHttpParam JarInfo jar);
}
