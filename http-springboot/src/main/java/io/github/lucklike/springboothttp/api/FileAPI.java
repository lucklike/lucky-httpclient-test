package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.DownloadToLocal;
import com.luckyframework.httpclient.proxy.annotations.Ex;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.HttpExec;
import com.luckyframework.httpclient.proxy.annotations.MultiData;
import com.luckyframework.httpclient.proxy.annotations.MultiFile;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.RespImportIntoSpEL;
import com.luckyframework.httpclient.proxy.annotations.Throws;
import com.luckyframework.io.MultipartFile;
import com.luckyframework.reflect.Param;
import io.github.lucklike.entity.JarInfo;
import io.github.lucklike.httpclient.annotation.HttpClient;
import io.github.lucklike.resp.Result;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


@HttpClient("${API.file}")
@RespImportIntoSpEL(importBody = false)
public interface FileAPI {

    @HttpExec.http_client
    @Post("upload")
    Result<Map<String, Object>> upload(@MultiFile("files") String[] path, @MultiData String desc);

    @Post("upload")
    Result<List<String>> upload2(@MultiFile("files") String path);

    @Post("upload")
    Result<Map<String, Object>> upload3(@MultiFile(name = "files", fileName = "myfile-{_index_}.jpg") InputStream[] bytes);

    @Get("preview/{fileName}")
    InputStream preview(@PathParam String fileName);

    @Get("http://maven.cairenhui.com/nexus/content/repositories/crh_dev/com/cairh/cpe-common-backend/0.1.17/cpe-common-backend-0.1.17-sources.jar")
    MultipartFile jarDownload();

    @Throws(@Ex(assertion = "#{$status$ != 200}", message = "【http-status=#{$status$}】Jar包下载失败：#{jar.toString()}"))
    @Get("http://maven.cairenhui.com/nexus/content/repositories/crh_dev/#{#TO_PATH(jar)}")
    MultipartFile jarDownload(JarInfo jar);

    @DownloadToLocal("${download.folder}")
    @Get("http://maven.cairenhui.com/nexus/content/repositories/crh_dev/#{#TO_PATH(jar)}")
    String jarToLocal(JarInfo jar);

    @DownloadToLocal(saveDir = "#{savePath}", filename = "#{file.artifactId}-#{file.version}")
    @Get("http://maven.cairenhui.com/nexus/content/repositories/crh_dev/#{#TO_PATH(file)}")
    File jarToLocal(@Param("file") JarInfo jar, String savePath);

}
