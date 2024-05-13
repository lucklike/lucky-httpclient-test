package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.core.BodyObject;
import com.luckyframework.httpclient.proxy.annotations.BinaryBody;
import com.luckyframework.httpclient.proxy.annotations.MultiData;
import com.luckyframework.httpclient.proxy.annotations.MultiFile;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticBinaryBody;
import io.github.lucklike.httpclient.annotation.HttpClient;

import java.io.File;
import java.io.InputStream;

@HttpClient("${API.location}")
public interface BinaryDataAPI {

    @Post("upload")
    String upload(BodyObject bodyObject);

    @Post("upload")
    String upload2(@BinaryBody String url);

    @Post("upload")
    String upload3(@MultiFile byte[] file,
                   @MultiData("fefwfw") String kk);

    @StaticBinaryBody("#{url}")
    @Post("upload")
    String upload4(String url);

    @Post("upload")
    String upload5(@MultiFile(name = "file", fileName = "#{p1}") InputStream in,
                   String fileName);

    @Post("upload")
    String upload6(File file);
}
