package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.FormParam;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.JsonBody;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.Put;
import com.luckyframework.httpclient.proxy.annotations.SpElSelect;
import com.luckyframework.httpclient.proxy.annotations.StaticFormBody;
import com.luckyframework.httpclient.proxy.annotations.StaticJsonBody;
import io.github.lucklike.User;
import io.github.lucklike.httpclient.annotation.HttpClient;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/12 00:51
 */
@HttpClient("${API.user}")
public interface UserAPI {

    @SpElSelect("#{$body$.data}")
    @Get("get")
    User get();

    @Put("put")
    void put(User user);

    @Put("put")
    void putForm(@FormParam User user);

    @StaticFormBody("id=2&username=付大康&password=😋3额3&age=23&email=234@qq.com")
    @Put("put")
    void putStaticForm();

    @Post("post")
    void post(@JsonBody User user);

    @StaticJsonBody(
            "{" +
                "id:43," +
                "username:参数," +
                "password:'${API.user}', " +
                "email:#{id}@cc.com, " +
                "age:22" +
            "}")
    @Post("post")
    void postStaticJson(String id);
}
