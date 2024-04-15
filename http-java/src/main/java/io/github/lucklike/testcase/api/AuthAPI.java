package io.github.lucklike.testcase.api;

import com.luckyframework.common.ConfigurationMap;
import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.httpclient.core.Request;
import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.IgnoreVerifySSL;
import com.luckyframework.httpclient.proxy.annotations.InterceptorRegister;
import com.luckyframework.httpclient.proxy.annotations.ObjectGenerate;
import com.luckyframework.httpclient.proxy.annotations.PrintLogProhibition;
import com.luckyframework.httpclient.proxy.annotations.ResponseSelect;
import com.luckyframework.httpclient.proxy.creator.Scope;
import com.luckyframework.httpclient.proxy.interceptor.Interceptor;
import com.luckyframework.httpclient.proxy.interceptor.InterceptorContext;
import com.luckyframework.reflect.Combination;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/2 22:05
 */



@IgnoreVerifySSL
@PrintLogProhibition
@AuthAPI.AutomaticRenewalToken
@DomainName("#{$val$.bootHttps}/auth")
public interface AuthAPI {

    @Get("/getToken")
    @ResponseSelect("#{$body$.data}")
    @AutomaticRenewalProhibition
    String getToken(String userName);

    @Get("/getToken")
    @AutomaticRenewalProhibition
    Response getToken2(String userName);

    @Get("helloUser")
    @ResponseSelect("#{{body: $body$.data, cookie: $respCookie$}}")
    Map<String, Object> hello();

    @Slf4j
    class AutomaticRenewalInterceptor implements Interceptor {

        private String tokenCache;

        private final String tokenKey = "X-Auth-Token";

        public synchronized String getTokenCache() {
            return tokenCache;
        }

        public synchronized void setTokenCache(String tokenCache) {
            this.tokenCache = tokenCache;
        }

        @Override
        public void doBeforeExecute(Request request, InterceptorContext context) {
            // 没有登录的情况需要调用登录接口获取token
            if (request.getFirstHeader(tokenKey) == null) {
                if (getTokenCache() == null) {
                    AuthAPI authAPI = (AuthAPI) context.getContext().getProxyObject();
                    log.info("No token cache");
                    setTokenCache(authAPI.getToken(NanoIdUtils.randomNanoId(8)));
                }
                request.addHeader(tokenKey, getTokenCache());
            }
        }

        @Override
        public Response doAfterExecute(Response response, InterceptorContext context) {
            ConfigurationMap mapResult = response.getConfigMapResult();
            String code = mapResult.getString("code");
            if ("403".equals(code)) {
                log.info("token expired");
                Request request = response.getRequest();
                AuthAPI authAPI = (AuthAPI) context.getContext().getProxyObject();
                setTokenCache(authAPI.getToken(NanoIdUtils.randomNanoId(8)));
                request.setHeader(tokenKey, getTokenCache());
                return context.getHttpProxyFactory().getHttpExecutor().execute(request);
            }
            return response;
        }
    }

    @Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Inherited
    @interface AutomaticRenewalProhibition {

    }

    @Target({ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @Inherited
    @Combination({InterceptorRegister.class})
    @InterceptorRegister(
            intercept = @ObjectGenerate(clazz=AuthAPI.AutomaticRenewalInterceptor.class, scope = Scope.CLASS),
            prohibition = AuthAPI.AutomaticRenewalProhibition.class,
            priority = 200
    )
    @interface AutomaticRenewalToken {

    }
}
