package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.MultiFile;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import io.github.lucklike.httpclient.annotation.HttpClient;
import io.github.lucklike.resp.Result;

import java.io.InputStream;
import java.util.List;

@HttpClient("${API.file}")
public interface FileAPI {

    @Post("upload")
    Result<List<String>> upload(@MultiFile("files") String[] path);

    @Post("upload")
    Result<List<String>> upload2(@MultiFile("files") String path);

    @Post("upload")
    Result<List<String>> upload3(@MultiFile(name = "files", fileName = "myfile-_index_.jpg")InputStream[] bytes);

    @Get("preview/{fileName}")
    InputStream preview(@PathParam String fileName);
}
