package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.MultiFile;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import io.github.lucklike.httpclient.annotation.HttpClient;
import io.github.lucklike.resp.Result;

import java.util.List;

@HttpClient("${API.file}")
public interface FileAPI {

    @Post("upload")
    Result<List<String>> upload(@MultiFile("files") String path);

    @Get("preview/{fileName}")
    byte[] preview(@PathParam String fileName);
}
