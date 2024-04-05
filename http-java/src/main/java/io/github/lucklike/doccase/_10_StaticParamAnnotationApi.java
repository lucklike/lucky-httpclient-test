package io.github.lucklike.doccase;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.Put;
import com.luckyframework.httpclient.proxy.annotations.StaticCookie;
import com.luckyframework.httpclient.proxy.annotations.StaticForm;
import com.luckyframework.httpclient.proxy.annotations.StaticFormBody;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.StaticJsonBody;
import com.luckyframework.httpclient.proxy.annotations.StaticPath;
import com.luckyframework.httpclient.proxy.annotations.StaticQuery;
import com.luckyframework.httpclient.proxy.annotations.StaticXmlBody;
import io.github.lucklike.User;
import io.github.lucklike.resp.Result;

/**
 * 静态参数注解
 */
@DomainName("http://localhost:8081/")
public interface _10_StaticParamAnnotationApi {

    /*
    	GET http://localhost:8081/query/sayHello?name=马晓晨
	    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
     */
    @StaticQuery({"name=马晓晨"})
    @Get("/query/sayHello")
    String sayHello();

    /*
        GET http://localhost:8081/other/path/Fukang
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
     */
    @StaticPath({"name=Fukang"})
    @Get("other/path/{name}")
    String path();

    /*
    	POST http://localhost:8081/other/header
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
        X-Token: SEEDIJIHUHJNJKOK78656568898
     */
    @StaticHeader({"X-Token=SEEDIJIHUHJNJKOK78656568898"})
    @Post("other/header")
    String header();

    /*
    	PUT http://localhost:8081/other/cookie
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
        Cookie: username=JackCheng
     */
    @StaticCookie({"username=JackCheng"})
    @Put("other/cookie")
    String cookie();

    /*
        PUT http://localhost:8081/other/form
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
        Content-Type: application/x-www-form-urlencoded

        id=10&
        username=雪王八&
        password=_LSM5FF85Jc5Gb7QfKpM2&
        email=tibdn1Uv@qq.com&
        age=12
     */
    @StaticForm({"id=10", "username=雪王八", "password=_LSM5FF85Jc5Gb7QfKpM2", "email=tibdn1Uv@qq.com", "age=12"})
    @Put("other/form")
    Result<User> form();

    /*
        PUT http://localhost:8081/other/form
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
        Content-Type: application/x-www-form-urlencoded;charset=UTF-8

        id=10&
        username=雪王八&
        password=_LSM5FF85Jc5Gb7QfKpM2&
        email=tibdn1Uv@qq.com&
        age=12
     */
    @StaticFormBody(
            "id=10&" +
            "username=雪王八&" +
            "password=_LSM5FF85Jc5Gb7QfKpM2&" +
            "email=tibdn1Uv@qq.com&" +
            "age=12")
    @Put("other/form")
    Result<User> form2();

    /*
        注：JSON字符串中的双引号可以不写，当然，写也是没问题的

    	POST http://localhost:8081/body/json
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
        Content-Type: application/json;charset=UTF-8

        {
         "id": 292,
         "username": "Jack",
         "password": "0GPi0kDMudXv7RNVS6Npl",
         "email": "IIWjCtKY@qq.com",
         "age": 12
        }
     */
    @StaticJsonBody("{" +
            "id: 292," +
            "username: Jack," +
            "password: 0GPi0kDMudXv7RNVS6Npl," +
            "email: IIWjCtKY@qq.com," +
            "age: 12" +
            "}")
    @Post("body/json")
    Result<User> json();


    /*
    	POST http://localhost:8081/body/xml
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
        Content-Type: application/xml;charset=UTF-8

        <?xml version="1.0" encoding="UTF-8" standalone="no"?>
        <user>
            <age>12</age>
            <email>kmOgEe9J@qq.com</email>
            <id>27</id>
            <password>XLwJL4vXmg2bxb8RBkOeA</password>
            <username>Spring</username>
        </user>
     */
    @StaticXmlBody(
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
            "<user>\n" +
            "    <age>12</age>\n" +
            "    <email>kmOgEe9J@qq.com</email>\n" +
            "    <id>27</id>\n" +
            "    <password>XLwJL4vXmg2bxb8RBkOeA</password>\n" +
            "    <username>Spring</username>\n" +
            "</user>")
    @Post("body/xml")
    User xml();


    /*
        注：所有静态参数注解均支持SpEL表达式，以下是一个json参数的案例代码

        name=爱因斯坦
        pwd=1905
            ->

    	POST http://localhost:8081/body/json
        User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_391)
        Content-Type: application/json;charset=UTF-8

        {
         "id": 292,
         "username": "爱因斯坦",
         "password": 1905,
         "email": "O65jW2bF4rbRUhV0@qq.com",
         "age": 12,
         "sayHello": "Hello 马晓晨",
         "class": "io.github.lucklike.doccase._10_StaticParamAnnotationApi",
         "method": "jsonSpEL",
         "args": [
           "爱因斯坦",
           1905
         ]
        }
     */
    @StaticJsonBody("{" +
            "id: 292," +
            "username: #{name}," +
            "password: #{pwd}," +
            "email: #{$this$.nanoId(16)}@qq.com," +
            "age: 12," +
            "sayHello: '#{$this$.sayHello()}'," +
            "class: #{$class$.getName()}," +
            "method: #{$method$.getName()}," +
            "args: #{T(java.util.Arrays).toString($mc$.getArguments())}" +
            "}")
    @Post("body/json")
    @NotHttpParam
    Result<User> jsonSpEL(String name, String pwd);

    default String nanoId(int size){
        return NanoIdUtils.randomNanoId(size);
    }
}
