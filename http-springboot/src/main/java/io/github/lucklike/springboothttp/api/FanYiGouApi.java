package io.github.lucklike.springboothttp.api;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.ConfigurationMap;
import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import com.luckyframework.conversion.ConversionUtils;
import com.luckyframework.exception.LuckyRuntimeException;
import com.luckyframework.httpclient.core.Request;
import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.InterceptorRegister;
import com.luckyframework.httpclient.proxy.annotations.ObjectGenerate;
import com.luckyframework.httpclient.proxy.annotations.ResultConvert;
import com.luckyframework.httpclient.proxy.annotations.SpELVar;
import com.luckyframework.httpclient.proxy.convert.ConvertContext;
import com.luckyframework.httpclient.proxy.convert.ResponseConvert;
import com.luckyframework.httpclient.proxy.interceptor.Interceptor;
import com.luckyframework.httpclient.proxy.interceptor.InterceptorContext;
import com.luckyframework.httpclient.proxy.spel.StaticMethodAlias;
import com.luckyframework.serializable.SerializationSchemeFactory;
import io.github.lucklike.util.SM4Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 翻译狗API
 */
//@SpELVar({
//        "appid=${fanYiGou.config.appId}",
//        "privatekey=${fanYiGou.config.privateKey}",
//        "nonce_str=#{#NanoIdSize(5)}"
//})
@DomainName("https://www.fanyigou.com")
@ResultConvert(convert = @ObjectGenerate(FanYiGouApi.Convert.class))
@InterceptorRegister(intercept = @ObjectGenerate(FanYiGouApi.TokenInterceptor.class), priority = 99)
public interface FanYiGouApi {


    /**
     * 生成NanoId随机字符串
     * @return NanoId随机字符串
     */
    static String nanoId(){
        return NanoIdUtils.randomNanoId();
    }

    @StaticMethodAlias("NanoIdSize")
    static String nanoId(int s){
        return NanoIdUtils.randomNanoId(s);
    }

    static void set(String...s) {

    }

    /**
     * SM4解密算法
     * @param s SM4加密后的字符串
     * @return 加密前的明文
     */
    static String SM4(String s) throws Exception {
        return SM4Util.decryptEcb(s);
    }

    /**
     * 用于将Json字符串转为Java对象
     * @param jsonStr json字符串
     * @return 转化后的Java对象
     */
    @StaticMethodAlias("JSON")
    static Object fromJson(String jsonStr) throws Exception {
        return SerializationSchemeFactory.getJsonScheme().deserialization(jsonStr, Object.class);
    }
    /**
     * Token参数拦截器，用于生成Token
     */
    class TokenInterceptor implements Interceptor {
        @Override
        public void doBeforeExecute(Request request, InterceptorContext context) {
            request.addQueryParameter("nonce_str", context.parseExpression("#{nonceStr}"));
            request.addQueryParameter("appid", context.parseExpression("#{appId}"));
            Map<String, Object> queryMap = request.getSimpleQueries();

            queryMap.put("privatekey", context.parseExpression("#{privateKey}"));
            String token = getToken(queryMap);
            request.addQueryParameter("token", token);
        }

        /**
         * 获取接口访问所必须的token
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

    class Convert implements ResponseConvert {

        @Override
        public <T> T convert(Response response, ConvertContext context) throws Throwable {
            ConfigurationMap resultMap = response.jsonStrToConfigMap();
            if (resultMap.containsConfigKey("code") && resultMap.getInt("code") == 0) {
                return ConversionUtils.conversion(resultMap.getProperty("data.transResult"), context.getRealMethodReturnType());
            }
            throw new LuckyRuntimeException("翻译失败！【({}) {}】",resultMap.getInt("code"), resultMap.getString("msg"));
        }
    }
}
