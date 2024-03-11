package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.core.BodyObject;
import com.luckyframework.httpclient.proxy.annotations.BinaryBody;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticBinaryBody;
import io.github.lucklike.httpclient.annotation.HttpClient;

@HttpClient("${API.location}")
public interface BinaryDataAPI {

    @Post("upload")
    String upload(BodyObject bodyObject);

    @Post("upload")
    String upload2(@BinaryBody String url);

    @Post("upload")
    String upload3(@BinaryBody byte[] bytes);

    @StaticBinaryBody("#{url}")
    @Post("upload")
    String upload4(@NotHttpParam String url);
}