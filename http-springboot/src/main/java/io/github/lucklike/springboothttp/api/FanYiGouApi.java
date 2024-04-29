package io.github.lucklike.springboothttp.api;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.ConfigurationMap;
import com.luckyframework.common.StringUtils;
import com.luckyframework.conversion.ConversionUtils;
import com.luckyframework.exception.LuckyRuntimeException;
import com.luckyframework.httpclient.core.Request;
import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.Branch;
import com.luckyframework.httpclient.proxy.annotations.ConditionalSelection;
import com.luckyframework.httpclient.proxy.annotations.ContentCompressProhibition;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.InterceptorRegister;
import com.luckyframework.httpclient.proxy.annotations.ObjectGenerate;
import com.luckyframework.httpclient.proxy.annotations.ResultConvert;
import com.luckyframework.httpclient.proxy.annotations.StaticQuery;
import com.luckyframework.httpclient.proxy.convert.ConvertContext;
import com.luckyframework.httpclient.proxy.convert.ResponseConvert;
import com.luckyframework.httpclient.proxy.interceptor.Interceptor;
import com.luckyframework.httpclient.proxy.interceptor.InterceptorContext;
import com.luckyframework.httpclient.proxy.spel.SpELVar;
import io.github.lucklike.springboothttp.api.spel.function.SpELFunctionUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 翻译狗API
 */
@SpELVar({
        "appId=#{#SM4('${fanYiGou.sm4.appId}')}",
        "privateKey=#{#SM4('${fanYiGou.sm4.privateKey}')}"})
@ConditionalSelection({
        @Branch(assertion = "#{$body$.code != 0}", exception = "翻译失败！【(#{$body$.code}) #{$body$.msg}】"),
        @Branch(assertion = "#{$body$.code == 0}", result = "#{$body$.data.transResult}")
})
@StaticQuery("appid=#{appId}")
@DomainName("https://www.fanyigou.com")
@InterceptorRegister(intercept = @ObjectGenerate(msg = "tokenInterceptor"), priority = 99)
//@ResultConvert(convert = @ObjectGenerate(msg = "FYGResultConvert"))
@ContentCompressProhibition
public interface FanYiGouApi {

    /**
     * Token参数拦截器，用于生成Token
     */
    @Component("tokenInterceptor")
    class TokenInterceptor implements Interceptor {

        @Override
        public void doBeforeExecute(Request request, InterceptorContext context) {

            // 补充参数appid、nonce_str
            request.addQueryParameter("nonce_str", SpELFunctionUtils.nanoId());

            // 获取当前请求的Query参数Map，并加入privateKey，用于生成Token
            Map<String, Object> queryMap = request.getSimpleQueries();
            queryMap.put("privatekey", context.getNestRootVar("privateKey"));
            String token = getToken(queryMap);

            //  补充参数token
            request.addQueryParameter("token", token);
        }

        /**
         * 获取接口访问所必须的token
         *
         * @param paramMap 参与token加密的参数Map
         * @return token
         */
        private String getToken(Map<String, Object> paramMap) {
            List<String> sortParamName = new ArrayList<>(paramMap.keySet());
            sortParamName.sort(String::compareTo);
            List<String> elementList = new ArrayList<>(sortParamName.size());
            for (String name : sortParamName) {
                Object paramValue = paramMap.get(name);
                if (paramValue != null) {
                    elementList.add(name + "=" + paramMap.get(name));
                }
            }
            String stringA = StringUtils.join(elementList, "&");
            return DigestUtil.md5Hex(stringA).toUpperCase();
        }
    }

//    @Component("FYGResultConvert")
    class FYGResultConvert implements ResponseConvert {

        @Override
        public <T> T convert(Response response, ConvertContext context) throws Throwable {
            int status = response.getStatus();
            if (200 != status) {
                throw new LuckyRuntimeException("翻译接口调用异常，响应码【{}】", status);
            }
            if (response.getResult().length == 0) {
                throw new LuckyRuntimeException("翻译接口未返回结果，请检查请求参数是否正确！");
            }
            ConfigurationMap configMap = response.jsonStrToConfigMap();
            if (!configMap.containsConfigKey("code") || configMap.getInt("code") != 0) {
                throw new LuckyRuntimeException("翻译失败！code={}，msg={}", configMap.getInt("code"), configMap.getInt("msg"));
            }
            return response.jsonStrToEntity(context.getRealMethodReturnType());
        }
    }

    @Component
    class FYGAutoConvert implements Response.AutoConvert {

        @Override
        public boolean can(Response resp) {
            return "www.fanyigou.com".equals(resp.getRequest().getURI().getHost());
        }

        @Override
        public <T> T convert(Response resp, Type type) {
            if (200 != resp.getStatus()) {
                throw new LuckyRuntimeException("翻译接口调用异常，响应码【{}】", resp.getStatus());
            }
            try {
                return resp.jsonStrToEntity(type);
            }catch (Exception e) {
                throw new LuckyRuntimeException("响应体【'{}'】无法转换为【{}】", resp.getStringResult(), type);
            }

        }
    }
}
