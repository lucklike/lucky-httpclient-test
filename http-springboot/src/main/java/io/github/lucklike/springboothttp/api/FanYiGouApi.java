package io.github.lucklike.springboothttp.api;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.ConfigurationMap;
import com.luckyframework.common.StringUtils;
import com.luckyframework.conversion.ConversionUtils;
import com.luckyframework.exception.LuckyRuntimeException;
import com.luckyframework.httpclient.core.Request;
import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.InterceptorRegister;
import com.luckyframework.httpclient.proxy.annotations.ObjectGenerate;
import com.luckyframework.httpclient.proxy.annotations.ResultConvert;
import com.luckyframework.httpclient.proxy.annotations.StaticQuery;
import com.luckyframework.httpclient.proxy.convert.ConvertContext;
import com.luckyframework.httpclient.proxy.convert.ResponseConvert;
import com.luckyframework.httpclient.proxy.interceptor.Interceptor;
import com.luckyframework.httpclient.proxy.interceptor.InterceptorContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 翻译狗API
 */
@DomainName("https://www.fanyigou.com")
@StaticQuery({"nonce_str=#{nonceStr}", "appid=#{appId}"})
@ResultConvert(convert = @ObjectGenerate(FanYiGouApi.Convert.class))
@InterceptorRegister(intercept = @ObjectGenerate(FanYiGouApi.TokenInterceptor.class), priority = 99)
public interface FanYiGouApi {

    /**
     * Token参数拦截器，用于生成Token
     */
    class TokenInterceptor implements Interceptor {
        @Override
        public void doBeforeExecute(Request request, InterceptorContext context) {
            Map<String, Object> queryMap = request.getSimpleQueries();
            queryMap.put("privatekey", context.getSpElRootVariable("privateKey"));
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
