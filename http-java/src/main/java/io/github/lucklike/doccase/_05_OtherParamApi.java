package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.CookieParam;
import com.luckyframework.httpclient.proxy.annotations.Delete;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.FormParam;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.HeaderParam;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.Put;
import io.github.lucklike.User;
import io.github.lucklike.resp.Result;

import java.util.Map;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 01:05
 */
@DomainName("http://localhost:8081/other/")
public interface _05_OtherParamApi {

    /*
    	GET http://localhost:8081/other/path/Jack
	    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
     */
    @Get("path/{name}")
    String path(@PathParam String name);

    /*
        POST http://localhost:8081/other/header
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        X-Token: DFhIrYjWtjpMgBt
    */
    @Post("header")
    String header(@HeaderParam("X-Token") String token);

    /*
        PUT http://localhost:8081/other/cookie
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Cookie: username=妞妞
     */
    @Put("cookie")
    String cookie(@CookieParam String username);

    /*
        PUT http://localhost:8081/other/form
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: application/x-www-form-urlencoded

        username=lucky&
        password=PA$$W0RD
     */
    @Put("form")
    Result<Map<String, Object>> form1(@FormParam String username, @FormParam String password);

    /*
        PUT http://localhost:8081/other/form
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: application/x-www-form-urlencoded

        username=tom&
        password=__tom_mot__
     */
    @Put("form")
    @FormParam
    Result<Map<String, Object>> form2(String username, String password);

    /*
        PUT http://localhost:8081/other/form
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: application/x-www-form-urlencoded

        sex=男&
        name=小黄鸭&
        age=3
     */
    @Put("form")
    @FormParam
    Result<Map<String, Object>> form3(Map<String, Object> form);

    /*
        PUT http://localhost:8081/other/form
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
        Content-Type: application/x-www-form-urlencoded

        id=103&
        username=雪王八&
        password=_LSM5FF85Jc5Gb7QfKpM2&
        email=tibdn1Uv@qq.com&
        age=12
     */
    @Put("form")
    @FormParam
    Result<User> form4(User user);
}
