## 声明式接口

### 📦 构建接口

#### 简单请求

```java
public interface MyApi {

    // GET http://www.baidu.com
    @HttpRequest(url = "http://www.baidu.com", method = RequestMethod.GET)
    String index();

}
```

通过`@HttpRequest`注解可以将接口中的某个方法声明为一个HTTP请求方法，上面的案例中
声明了一个URL为`http://www.baidu.com`请求方法为`GET`的HTTP请求，且将请求响应的数据以String的方式返回给调用者。

#### 稍复杂点的请求

```java
public interface MyApi {

    /*
       GET http://localhost:8081/simple/sayHello?name=Lucky
       User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
       Accept: text/plain
    */
    @StaticHeader({"Accept=text/plain"})
    @HttpRequest(
            url = "http://localhost:8081/simple/sayHello",
            method = GET
    )
    String sendRequest(String name);
}
```

上面的`sendRequest`方法绑定的 HTTP 请求，定义了 URL 信息，以及`Accept:text/plain`加到了请求头中， 方法的参数`String name`
的值将会自动值加入到HTTP的请求参数`name`中。

调用方代码如下所示：  
原生Java：

```java
    HttpClientProxyObjectFactory factory = new HttpClientProxyObjectFactory();
    MyApi api = factory.getJdkProxyObject(MyApi.class);

    api.sendRequest("Lucky");
```

Spring/SpringBoot:

```java

    @Resource
    MyApi api;

    api.sendRequest("Lucky");

```

这段调用所实际产生的 HTTP 请求如下：

```text
    GET http://localhost:8081/simple/sayHello?name=Lucky
    User-Agent: Lucky-HttpClient/2.1.0 (Java/1.8.0_301)
    Accept: text/plain
```

### 👜 请求方法

`Lucky`使用不同的请求注解来标识某个接口方法来进行发送不同类型的请求，其支持的HTTP方法如下表所示:

| 注解             | 请求方法                         |
|----------------|------------------------------|
| `@Get `        | GET请求                        |
| `@Post`        | POST请求                       |
| `@Delete`      | DELETE请求                     |
| `@Put`         | PUT请求                        |
| `@Head`        | HEAD请求                       |
| `@Patch`       | PATCH请求                      |
| `@Connect`     | CONNECT请求                    |
| `@Options`     | OPTIONS请求                    |
| `@Trace`       | TRACE请求                      |
| `@HttpRequest` | 定义请求的`元注解`，以上所有注解都是由此注解扩展而来

#### GET请求
使用`@Get`注解 
````java
    @Get("http://localhost:8080/hello")
    String simple();
````
#### POST请求
使用`@Post`注解
````java
    @Post("http://localhost:8080/hello")
    String simple();
````
#### PUT请求
使用`@Put`注解
````java
    @Put("http://localhost:8080/hello")
    String simple();
````
#### HEAD请求
使用`@Head`注解
````java
    @Head("http://localhost:8080/hello")
    String simple();
````
#### DELETE请求
使用`@Delete`注解
````java
    @Delete("http://localhost:8080/hello")
    String simple();
````
#### OPTIONS请求
使用`@Options`注解
````java
    @Options("http://localhost:8080/hello")
    String simple();
````
#### TRACE请求
使用`@Trace`注解
````java
    @Trace("http://localhost:8080/hello")
    String simple();
````
#### PATCH请求
使用`@Patch`注解
````java
    @Patch("http://localhost:8080/hello")
    String simple();
````
#### CONNECT请求
使用`@Connect`注解
````java
    @Connect("http://localhost:8080/hello")
    String simple();
````
#### 动态HTTP请求方法
1. 使用`@HttpRequest`注解配合`@MethodParam`注解 + `String类型参数`来实现 
2. 使用`@HttpRequest`注解配合`@MethodParam`注解 + `RequestMethod类型参数`来实现

````java
    @HttpRequest("http://localhost:8080/hello")
    String simple1(@MethodParam String method);

    @HttpRequest("http://localhost:8080/hello")
    String simple2(@MethodParam RequestMethod method);
````
在调用改方法时通过参数传入 HTTP 请求方法类型（字符串类型/RequestMethod枚举类型，字符类型式大小写不敏感） 
```java
    // POST 请求
    String result1 = simple1("post");
    // DELETE 请求
    String result2 = simple1("DELETE");

    // GET 请求
    String result3 = simple2(RequestMethod.GET);
    // PUT 请求
    String result4 = simple2(RequestMethod.PUT);
```

### 🚚 请求地址
