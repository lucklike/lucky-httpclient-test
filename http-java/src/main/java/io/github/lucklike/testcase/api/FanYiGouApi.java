package io.github.lucklike.testcase.api;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.core.Request;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.InterceptorRegister;
import com.luckyframework.httpclient.proxy.annotations.ObjectGenerate;
import com.luckyframework.httpclient.proxy.annotations.SpELVar;
import com.luckyframework.httpclient.proxy.interceptor.Interceptor;
import com.luckyframework.httpclient.proxy.interceptor.InterceptorContext;
import com.luckyframework.serializable.SerializationSchemeFactory;
import io.github.lucklike.util.SM4Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 翻译狗API
 */
@SpELVar({
        "appid=#{$this$.SM4('a94edf938ecd3a2a8ca013bd800b52ad')}",
        "privatekey=#{$this$.SM4('b2482869665723323117ea6d00de9818833788eecce62cbfe88f6baeb23eb08ef59031af1aece287fe54e8b6c383eb3f')}",
        "nonce_str=#{$this$.nanoId()}"
})
@DomainName("https://www.fanyigou.com")
@InterceptorRegister(intercept = @ObjectGenerate(FanYiGouApi.TokenInterceptor.class), priority = 99)
public interface FanYiGouApi {


    /**
     * 生成NanoId随机字符串
     * @return NanoId随机字符串
     */
    default String nanoId(){
        return NanoIdUtils.randomNanoId();
    }

    /**
     * SM4解密算法
     * @param s SM4加密后的字符串
     * @return 加密前的明文
     */
    default String SM4(String s) throws Exception {
        return SM4Util.decryptEcb(s);
    }

    /**
     * 用于将Json字符串转为Java对象
     * @param jsonStr json字符串
     * @return 转化后的Java对象
     */
    default Object fromJson(String jsonStr) throws Exception {
        return SerializationSchemeFactory.getJsonScheme().deserialization(jsonStr, Object.class);
    }
    /**
     * Token参数拦截器，用于生成Token
     */
    class TokenInterceptor implements Interceptor {
        @Override
        public void doBeforeExecute(Request request, InterceptorContext context) {
            request.addQueryParameter("nonce_str", context.parseExpression("#{nonce_str}"));
            request.addQueryParameter("appid", context.parseExpression("#{appid}"));
            Map<String, Object> queryMap = request.getSimpleQueries();

            queryMap.put("privatekey", context.parseExpression("#{privatekey}"));
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
}
