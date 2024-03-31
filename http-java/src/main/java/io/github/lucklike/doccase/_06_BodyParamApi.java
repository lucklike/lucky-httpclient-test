package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.JavaBody;
import com.luckyframework.httpclient.proxy.annotations.JsonBody;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.XmlBody;
import io.github.lucklike.User;
import io.github.lucklike.resp.Result;

/**
 * Body参数测试
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 01:35
 */
@DomainName("http://localhost:8081/body/")
public interface _06_BodyParamApi {

    /*
        POST http://localhost:8081/body/json
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: application/json;charset=UTF-8

        {
         "id": 214,
         "username": "Jack",
         "password": "d0gtIRrh-9WGXewMUoLYk",
         "email": "GY3Bkk8K@qq.com",
         "age": 12
        }
     */
    @Post("json")
    Result<User> json(@JsonBody User user);

    /*
        POST http://localhost:8081/body/java
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: application/x-java-serialized-object

        Java serializable object. Size: 284
     */
    @Post("java")
    Result<User> java(@JavaBody User user);

    /*
        POST http://localhost:8081/body/xml
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: application/xml;charset=UTF-8

        <?xml version="1.0" encoding="UTF-8"?>
        <user>
            <age>12</age>
            <email>kmOgEe9J@qq.com</email>
            <id>27</id>
            <password>XLwJL4vXmg2bxb8RBkOeA</password>
            <username>Spring</username>
        </user>
    */
    @Post("xml")
    User xml(@XmlBody User user);
}
