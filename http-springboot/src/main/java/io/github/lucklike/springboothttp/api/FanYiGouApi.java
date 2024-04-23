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
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.InterceptorRegister;
import com.luckyframework.httpclient.proxy.annotations.ObjectGenerate;
import com.luckyframework.httpclient.proxy.convert.ConvertContext;
import com.luckyframework.httpclient.proxy.convert.ResponseConvert;
import com.luckyframework.httpclient.proxy.interceptor.Interceptor;
import com.luckyframework.httpclient.proxy.interceptor.InterceptorContext;
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
@ConditionalSelection({
        @Branch(assertion = "#{$body$.code != 0}", exception = "翻译失败！【(#{$body$.code}) #{$body$.msg}】"),
        @Branch(assertion = "#{$body$.code == 0}", result = "#{$body$.data.transResult}")
})
@DomainName("https://www.fanyigou.com")
//@ResultConvert(convert = @ObjectGenerate(FanYiGouApi.Convert.class))
@InterceptorRegister(
        intercept = @ObjectGenerate(
                clazz = FanYiGouApi.TokenInterceptor.class,
                msg = "tokenInterceptor"),
        priority = 99
)
public interface FanYiGouApi {

    /**
     * Token参数拦截器，用于生成Token
     */
    @Component("tokenInterceptor")
    class TokenInterceptor implements Interceptor {

        @Value("${fanYiGou.sm4.appId}")
        private String sm4_appId;
        @Value("${fanYiGou.sm4.privateKey}")
        private String sm4_private_key;

        private String privateKey;
        private String appId;

        @Override
        public void doBeforeExecute(Request request, InterceptorContext context) {

            // 补充参数appid、nonce_str
            request.addQueryParameter("appid", getAppId());
            request.addQueryParameter("nonce_str", SpELFunctionUtils.nanoId());

            // 获取当前请求的Query参数Map，并加入privateKey，用于生成Token
            Map<String, Object> queryMap = request.getSimpleQueries();
            queryMap.put("privatekey", getPrivateKey());
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

        @SneakyThrows
        public String getPrivateKey() {
            if (privateKey == null) {
                privateKey = SpELFunctionUtils.SM4(sm4_private_key);
            }
            return privateKey;
        }

        @SneakyThrows
        public String getAppId() {
            if (appId == null) {
                appId = SpELFunctionUtils.SM4(sm4_appId);
            }
            return appId;
        }
    }

    class Convert implements ResponseConvert {

        @Override
        public <T> T convert(Response response, ConvertContext context) throws Throwable {
            if (200 != response.getStatus()) {
                throw new LuckyRuntimeException("翻译接口调用异常，响应码【{}】", response.getStatus());
            }
            ConfigurationMap resultMap = response.jsonStrToConfigMap();
            if (resultMap.containsConfigKey("code") && resultMap.getInt("code") == 0) {
                return ConversionUtils.conversion(resultMap.getProperty("data.transResult"), context.getRealMethodReturnType());
            }
            throw new LuckyRuntimeException("翻译失败！【({}) {}】", resultMap.getInt("code"), resultMap.getString("msg"));
        }
    }

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
            return resp.jsonStrToEntity(type);
        }
    }
}
