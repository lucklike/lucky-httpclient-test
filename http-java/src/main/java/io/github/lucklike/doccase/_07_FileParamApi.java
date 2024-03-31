package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.BinaryBody;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.MultiData;
import com.luckyframework.httpclient.proxy.annotations.MultiFile;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.io.MultipartFile;
import io.github.lucklike.resp.Result;

import java.io.File;
import java.util.Map;

/**
 * 文件上传下载Api
 *
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 19:47
 */
@DomainName("http://localhost:8081/file/")
public interface _07_FileParamApi {

    /*
    	POST http://localhost:8081/file/upload
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: multipart/form-data; boundary=LuckyBoundary

        Content-Disposition: form-data; name="desc"
        Content-Type: text/plain

        本地文件
        --LuckyBoundary
        Content-Disposition: form-data; name="files"
        Content-Type: image/jpeg

        < /Users/fukang/Pictures/OIP-C.jpeg
        --LuckyBoundary
        Content-Disposition: form-data; name="files"
        Content-Type: image/jpeg

        < /Users/fukang/Pictures/R-C.jpeg
        --LuckyBoundary--
     */
    @Post("upload")
    Result<Map<String, Object>> upload(@MultiData String desc, @MultiFile File[] files);

    /*
        POST http://localhost:8081/file/upload
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: multipart/form-data; boundary=LuckyBoundary

        Content-Disposition: form-data; name="desc"
        Content-Type: text/plain

        HTTP文件
        --LuckyBoundary
        Content-Disposition: form-data; name="files"
        Content-Type: text/plain

        < URL [https://ts1.cn.mm.bing.net/th/id/R-C.b56aa4bb51cabc689de0e62b44e9ded1?rik=68%2bi6nBs8vAjaA&riu=http%3a%2f%2fseopic.699pic.com%2fphoto%2f50062%2f5802.jpg_wh1200.jpg&ehk=fapBxRe0u39jJ8t3P3G2Qobt2aqqpWZaTACd54Ycyzc%3d&risl=&pid=ImgRaw&r=0]
        --LuckyBoundary
        Content-Disposition: form-data; name="files"
        Content-Type: image/jpeg

        < URL [file:/Users/fukang/Desktop/🥕/405731702729632_.pic_hd.jpg]
        --LuckyBoundary--
     */
    @Post("upload")
    Result<Map<String, Object>> upload2(@MultiData String desc, @MultiFile String[] files);


    /*
    	POST http://localhost:8081/file/binaryUpload
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        FileName: avatar.jpg
        Content-Type: application/octet-stream

        Binary data request body. [JPEG (164706)]
     */
    @Post("binaryUpload")
    @StaticHeader("fileName=#{file.getName()}")
    Result<String> binaryUpload(@BinaryBody File file);


    @Get("preview/{fileName}")
    byte[] preview(@PathParam String fileName);

    @Get("preview/{fileName}")
    MultipartFile preview2(@PathParam String fileName);


}
