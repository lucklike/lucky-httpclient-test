package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.core.BodyObject;
import com.luckyframework.httpclient.proxy.annotations.Post;
import io.github.lucklike.httpclient.annotation.HttpClient;

@HttpClient("${API.location}")
public interface BinaryDataAPI {

    @Post("upload")
    void upload(BodyObject bodyObject);
}
