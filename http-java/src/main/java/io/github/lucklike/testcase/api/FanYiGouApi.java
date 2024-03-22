package io.github.lucklike.testcase.api;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.SpELVar;
import io.github.lucklike.util.SM4Util;

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
}
