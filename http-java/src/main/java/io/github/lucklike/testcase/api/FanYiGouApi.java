package io.github.lucklike.testcase.api;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.SpELVar;
import com.luckyframework.httpclient.proxy.context.Context;
import com.luckyframework.serializable.SerializationSchemeFactory;
import io.github.lucklike.util.SM4Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpELVar({
        "appid=#{$this$.SM4('a94edf938ecd3a2a8ca013bd800b52ad')}",
        "privatekey=#{$this$.SM4('b2482869665723323117ea6d00de9818833788eecce62cbfe88f6baeb23eb08ef59031af1aece287fe54e8b6c383eb3f')}",
        "nonce_str=#{$this$.nanoId()}",
        "abc=#{nonce_str}-#{appid}-#{privatekey}"
})
@DomainName("https://www.fanyigou.com")
public interface FanYiGouApi {


    default String nanoId(){
        return NanoIdUtils.randomNanoId();
    }

    default String SM4(String s) throws Exception {
        return SM4Util.decryptEcb(s);
    }

    default Object fromJson(String jsonStr) throws Exception {
        return SerializationSchemeFactory.getJsonScheme().deserialization(jsonStr, Object.class);
    }

    default String getToken(Map<String, Object> paramMap) {
        List<String> sortParamName = new ArrayList<>(paramMap.keySet());
        sortParamName.sort(String::compareTo);
        List<String> elementList = new ArrayList<>(sortParamName.size());
        for (String name : sortParamName) {
            elementList.add(name + "=" + paramMap.get(name));
        }
        String stringA = StringUtils.join(elementList, "&");
        return DigestUtil.md5Hex(stringA).toUpperCase();
    }
}
