package io.github.lucklike.springboothttp.api.spel.function;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.spel.FunctionAlias;
import io.github.lucklike.httpclient.annotation.SpELFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpELFunction
public class FanYiGouFunction {


    /**
     * 获取接口访问所必须的token
     *
     * @param paramMap 参与token加密的参数Map
     * @return token
     */
    @FunctionAlias("FYG_TOKEN")
    public static String getToken(Map<String, Object> paramMap) {
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
